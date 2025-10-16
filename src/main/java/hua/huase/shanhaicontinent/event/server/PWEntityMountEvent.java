package hua.huase.shanhaicontinent.event.server;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapabilityProvider;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PWEntityMountEvent {
    @SubscribeEvent
    public static void entityMountEvent(EntityMountEvent event){
        Entity entityMounting = event.getEntityMounting();
        Entity entityBeingMounted = event.getEntityBeingMounted();
//禁止怪物上船
        entityMounting.getCapability(MonsterAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
            event.setCanceled(true);
        });

    }
}
