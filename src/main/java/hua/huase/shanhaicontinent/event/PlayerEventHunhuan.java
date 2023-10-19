package hua.huase.shanhaicontinent.event;

import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.baubles.seedpacket.PacketHandler;
import hua.huase.shanhaicontinent.capability.baubles.seedpacket.PacketPlayerCapability;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber
public class PlayerEventHunhuan {

    public static Map<Integer,Integer> stageHashMap=new HashMap<>();
    @SideOnly(Side.CLIENT)
//    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {

    }




    @SubscribeEvent
    public static void onStartTracking(PlayerEvent.StartTracking event) {
        Entity target = event.getTarget();
        if (target instanceof EntityPlayerMP ) {

            PacketHandler.INSTANCE.sendToAllTracking(new PacketPlayerCapability(target.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY,null),target),new NetworkRegistry.TargetPoint(target.dimension,target.posX,target.posY,target.posZ,64));

        }
    }

}
