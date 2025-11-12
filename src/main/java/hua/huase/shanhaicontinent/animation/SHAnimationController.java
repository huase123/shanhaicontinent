package hua.huase.shanhaicontinent.animation;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

/**
 * - @description:AnimationController接口
 * - @author: huase。
 * - @date: 2025/11/10 6:55
 */
public interface SHAnimationController {
    //动画播放的时间
    long getDuration(LivingEntity livingEntity);
    //播放的动画
    AnimationDefinition getAnimationDefinition(LivingEntity livingEntity);

    void steupAnimtick(LivingEntity livingEntity, HumanoidModel<?> humanoidModel, ModelPart modelPart, float nowtime);

    void tick(Player player);
}
