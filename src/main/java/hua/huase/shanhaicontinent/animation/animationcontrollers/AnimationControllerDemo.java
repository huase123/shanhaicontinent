package hua.huase.shanhaicontinent.animation.animationcontrollers;

import hua.huase.shanhaicontinent.animation.SHAnimationController;
import hua.huase.shanhaicontinent.entity.animations.ModAnimationDefinitions;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.world.entity.LivingEntity;

/**
 * - @description:AnimationControllerDemo类
 * - @author: huase。
 * - @date: 2025/11/11 6:48
 */
public class AnimationControllerDemo implements SHAnimationController {
    @Override
    public long getDuration(LivingEntity livingEntity) {
        return 20;
    }

    @Override
    public AnimationDefinition getAnimationDefinition(LivingEntity livingEntity) {
        return ModAnimationDefinitions.playerfly;
    }
}
