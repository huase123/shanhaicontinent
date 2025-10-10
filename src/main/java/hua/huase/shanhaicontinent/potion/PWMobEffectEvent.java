package hua.huase.shanhaicontinent.potion;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.network.NetworkHandler;
import hua.huase.shanhaicontinent.network.server.SPacketEntityAttribute;
import net.minecraft.network.protocol.game.ClientboundRemoveMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;

/**
 * - @description:PWMobEffectEvent类同步客户端其它玩家以用于渲染
 * - @author: huase。
 * - @date: 2025/10/11 6:05
 */
@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PWMobEffectEvent {
    @SubscribeEvent
    public static void updateEffect(MobEffectEvent.Added event){
        updateEffectInstance(event);
    }
    @SubscribeEvent
    public static void updateEffect(MobEffectEvent.Remove event){
        removeEffectInstance(event);
    }
    @SubscribeEvent
    public static void updateEffect(MobEffectEvent.Expired event){
        removeEffectInstance(event);
    }
/**
 * TODO 功能描述：原版包不能使用NetworkHandler.INSTANCE发送,使用一下方式向追踪玩家发包
 * @see PacketDistributor 由这个类查到的发送方法
 * @author :huase
 * @date 2025/10/11 7:22
 */
    private static void updateEffectInstance(MobEffectEvent event) {
        MobEffect effect = event.getEffectInstance().getEffect();
        LivingEntity livingEntity = event.getEntity();
        if(effect instanceof PotionAnimation potionAnimation && livingEntity.isAlive()){

            ((ServerChunkCache)livingEntity.getCommandSenderWorld().getChunkSource()).broadcastAndSend(livingEntity, new ClientboundUpdateMobEffectPacket(livingEntity.getId(), event.getEffectInstance()));


//            NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> livingEntity), new ClientboundUpdateMobEffectPacket(livingEntity.getId(), event.getEffectInstance()));
        }
    }


    private static void removeEffectInstance(MobEffectEvent event) {
        MobEffect effect = event.getEffectInstance().getEffect();
        LivingEntity livingEntity = event.getEntity();
        if(effect instanceof PotionAnimation potionAnimation){
            ((ServerChunkCache)livingEntity.getCommandSenderWorld().getChunkSource()).broadcastAndSend(livingEntity, new ClientboundRemoveMobEffectPacket(livingEntity.getId(), effect));

//            NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(event::getEntity), new ClientboundRemoveMobEffectPacket(event.getEntity().getId(), effect));
        }
    }
}
