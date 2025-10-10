package hua.huase.shanhaicontinent.network;

import hua.huase.shanhaicontinent.capability.AttrubuteAPI;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttrubuteAPI;
import hua.huase.shanhaicontinent.network.server.SPacketEntityAttribute;
import hua.huase.shanhaicontinent.network.server.SPacketPlayerAttribute;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.network.PacketDistributor;

public interface SynsAPI {
    static void synsPlayerAttribute(Entity entity){
        if(entity instanceof ServerPlayer livingEntity){
            float maxshengming = AttrubuteAPI.getMaxshengming(livingEntity);
            if(livingEntity.getMaxHealth() != maxshengming){
                livingEntity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(maxshengming);
            }

            entity.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {

                NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> livingEntity), new SPacketPlayerAttribute(entity.getId(),capability.serializeNBT()));
            });
        }
    }
    static void synsEntityAttribute(Entity entity){
            entity.getCapability(MonsterAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
                NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), new SPacketEntityAttribute(entity.getId(),capability.serializeNBT()));
            });
    }
}
