package hua.huase.shanhaicontinent.client.keybinding;

import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.seedpacket.PacketHandler;
import hua.huase.shanhaicontinent.seedpacket.PacketTuPo;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static hua.huase.shanhaicontinent.client.event.ClientEventHandler.jingtoukaiguan;

@Mod.EventBusSubscriber
public class KeyBindingHander {
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onKeyPressed(InputUpdateEvent event) {

        if(Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown()){
            jingtoukaiguan = false;
        }



        if (MyKeyBinding.MYKEY_P.isPressed()) {

            EntityLivingBase entity = event.getEntityLiving();
            if (entity instanceof EntityPlayer) {

                PlayerCapability capability = entity.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
                int maxjingyan = capability.getMaxjingyan();
                int jingyan = capability.getJingyan();
                int dengji = capability.getDengji();
                if(jingyan>=maxjingyan&&(dengji+1)%10!=0) {


                    PacketHandler.INSTANCE.sendToServer(new PacketTuPo());
                }else {
                    if(jingyan<maxjingyan){

                        entity.sendMessage(new TextComponentTranslation("message.tupo.fail.client.jingyan"));
                    }else {
                        entity.sendMessage(new TextComponentTranslation("message.tupo.fail.client.hunhuan"));
                    }
                }


            }



        }


    }
}