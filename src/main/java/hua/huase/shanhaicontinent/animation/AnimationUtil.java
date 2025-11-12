package hua.huase.shanhaicontinent.animation;

import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.network.NetworkHandler;
import hua.huase.shanhaicontinent.network.server.SPacketAnimationData;
import hua.huase.shanhaicontinent.network.server.SPacketCapability;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

/**
 * - @description:AnimationUtil类
 * - @author: huase。
 * - @date: 2025/11/11 0:25
 */
public class AnimationUtil {
    public static AnimationControllerInstance getAnimationControllerInstance(LivingEntity livingEntity) {
        return livingEntity.getCapability(RegisterCapabilitys.ANIMATIONCONTROLLERINSTANCE).orElse(null);
    }

    public static void play(LivingEntity livingEntity, @NotNull SHAnimationController empty) {
        AnimationControllerInstance animationControllerInstance = getAnimationControllerInstance(livingEntity);
        animationControllerInstance.play(empty,livingEntity);
        if(!livingEntity.level().isClientSide){
            NetworkHandler.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> livingEntity), new SPacketAnimationData(livingEntity.getId(),animationControllerInstance.serializeNBT()));
        }
    }
}
