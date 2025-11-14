package hua.huase.shanhaicontinent.animation;

import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * - @description:AnimationController接口
 * - @author: huase。
 * - @date: 2025/11/10 6:55
 */
public interface SHAnimationController {
    //动画播放的时间
    long getDuration(Entity livingEntity);
    //播放的动画
    @OnlyIn(Dist.CLIENT)
    AnimationDefinition getAnimationDefinition(Entity livingEntity);

    //服务端与客户端实体tick
    void tick(Entity entity);
    Object getEffectRendererInternal();

}
