package hua.huase.shanhaicontinent.client.keybinding;

import hua.huase.shanhaicontinent.seedpacket.PacketHandler;
import hua.huase.shanhaicontinent.seedpacket.PacketJiNengKaiguan;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class KeyBindingJiNeng {
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onKeyPressed(InputUpdateEvent event) {
        if (MyKeyBinding.MYKEY_R.isPressed()) {

            EntityLivingBase entity = event.getEntityLiving();
            if (entity instanceof EntityPlayer) {

                PacketHandler.INSTANCE.sendToServer(new PacketJiNengKaiguan());


            }



        }


    }
}