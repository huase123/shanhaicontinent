package hua.huase.shanhaicontinent.client.keybinding;

import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.capability.baubles.seedpacket.PacketHandler;
import hua.huase.shanhaicontinent.capability.baubles.seedpacket.PacketOpenHunhuan;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class KeyBindingHunHuan {
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onKeyPressed(InputUpdateEvent event) {
        if (MyKeyBinding.MYKEY_K.isPressed()) {

            EntityLivingBase entity = event.getEntityLiving();
            if (entity instanceof EntityPlayer) {

                PlayerCapability capability = entity.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
                boolean hunhuankaiguan = capability.isHunhuankaiguan();
                entity.sendMessage(new TextComponentTranslation("message.hunhuan:"+(!hunhuankaiguan)));
                capability.setHunhuankaiguan(!hunhuankaiguan);
                PacketHandler.INSTANCE.sendToServer(new PacketOpenHunhuan());


            }



        }


    }
}