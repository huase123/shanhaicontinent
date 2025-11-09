package hua.huase.shanhaicontinent.event.server;

import hua.huase.shanhaicontinent.SHMainBus;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * - @description:PWPlayerInteractEvent类
 * - @author: huase。
 * - @date: 2025/10/31 17:11
 */

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PWPlayerInteractEvent {
/**
 * TODO 功能描述：用于测试
 * @author :huase
 * @date 2025/10/31 17:27
 */
    @SubscribeEvent
    public static void onLivingTickEvent(PlayerInteractEvent.EntityInteract event){
        Entity target = event.getTarget();
        if(target.level().isClientSide)return;
        if(target instanceof Mob mob){
//            mob.setNoAi(!mob.isNoAi());
//            眩晕实体
            mob.setNoAi(true);
        }
        event.getEntity().setNoActionTime(200);
//        event.getEntity().setNoActionTime(200);
    }

}
