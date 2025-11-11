package hua.huase.shanhaicontinent.animation;

import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import net.minecraft.world.entity.LivingEntity;
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
        getAnimationControllerInstance(livingEntity).play(empty,livingEntity);
    }
}
