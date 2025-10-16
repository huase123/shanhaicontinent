package hua.huase.shanhaicontinent.network;

import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capabilitys.CapabilityUtil;
import hua.huase.shanhaicontinent.capabilitys.capability.AttributeBase;
import hua.huase.shanhaicontinent.capabilitys.capability.MosterCapability;
import hua.huase.shanhaicontinent.capabilitys.capability.PlayerCapability;
import hua.huase.shanhaicontinent.network.server.SPacketEntityAttribute;
import hua.huase.shanhaicontinent.network.server.SPacketCapability;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

public interface SynsAPI {
    static void synsCapability(Entity entity, @NotNull AttributeBase attributeBase){
//        CapabilityUtil.synsMaxhealth(serverPlayer,playerCapability);
        NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), new SPacketCapability(entity.getId(),attributeBase.serializeNBT()));
    }
    @Deprecated
    static void synsPlayerCapability(Entity serverPlayer, @NotNull PlayerCapability playerCapability){
        CapabilityUtil.synsMaxhealth(serverPlayer,playerCapability);
        playerCapability.setIsupdate(false);
        NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> serverPlayer), new SPacketCapability(serverPlayer.getId(),playerCapability.serializeNBT()));
    }
    @Deprecated
    static void synsEntityCapability(Entity entity, @NotNull MosterCapability capability){
        CapabilityUtil.synsMaxhealth(entity,capability);
//        CapabilityUtil.synsCustomName(entity,capability);
        capability.setIsupdate(false);
        NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), new SPacketCapability(entity.getId(),capability.serializeNBT()));


//        ServerLevel level = (ServerLevel) entity.level();
//        for (ServerPlayer player : level.players()) {
//            NetworkHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new SPacketEntityAttribute(entity.getId(),capability.serializeNBT()));
//        }

    }
    @Deprecated
    static void synsPlayerAttribute(Entity entity){
//        if(entity instanceof ServerPlayer livingEntity){
//            float maxshengming = AttrubuteAPI.getMaxshengming(livingEntity);
//            if(livingEntity.getMaxHealth() != maxshengming){
//                livingEntity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(maxshengming);
//            }
//
//            entity.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
//
//                NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> livingEntity), new SPacketPlayerAttribute(entity.getId(),capability.serializeNBT()));
//            });
//        }
    }
    @Deprecated
    static void synsEntityAttribute(Entity entity){
//            entity.getCapability(MonsterAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
//                NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), new SPacketEntityAttribute(entity.getId(),capability.serializeNBT()));
//            });
    }
}
