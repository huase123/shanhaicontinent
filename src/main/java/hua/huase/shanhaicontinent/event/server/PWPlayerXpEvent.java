package hua.huase.shanhaicontinent.event.server;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capabilitys.CapabilityUtil;
import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerXpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * - @description:PWPlayerXpEvent类
 * - @author: huase。
 * - @date: 2025/10/13 8:12
 */
@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PWPlayerXpEvent {
    @SubscribeEvent
    public static void onPlayerXpEvent(PlayerXpEvent.PickupXp event){
        Player player = event.getEntity();
        int experienceLevel = player.experienceLevel;
        if(experienceLevel > 1){
            player.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).ifPresent(capability ->{
                if(!capability.isIsjuexing()){
                    CapabilityUtil.juexingWuhun(player,capability);
                }
            });
        }

    }
}
