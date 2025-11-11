package hua.huase.shanhaicontinent.animation;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.world.entity.LivingEntity;

/**
 * - @description:AnimationController接口
 * - @author: huase。
 * - @date: 2025/11/10 6:55
 */
public interface SHAnimationController {
    long getDuration(LivingEntity livingEntity);

    AnimationDefinition getAnimationDefinition(LivingEntity livingEntity);
}
