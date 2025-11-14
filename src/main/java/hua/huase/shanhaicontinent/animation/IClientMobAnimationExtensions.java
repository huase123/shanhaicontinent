package hua.huase.shanhaicontinent.animation;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.Entity;

/**
 * - @description:IClientMobAnimationExtensions接口
 * - @author: huase。
 * - @date: 2025/11/14 12:56
 */
public interface IClientMobAnimationExtensions {

    IClientMobAnimationExtensions DEFAULT = new IClientMobAnimationExtensions() { };

    static IClientMobAnimationExtensions of(AnimationControllerInstance instance)
    {
        return of(instance.getAnimationcontroller());
    }

    static IClientMobAnimationExtensions of(SHAnimationController instance)
    {
        return instance.getEffectRendererInternal() instanceof IClientMobAnimationExtensions r ? r : DEFAULT;
    }

    default void render(AnimationControllerInstance animationControllerInstance, Entity entity, PoseStack poseStack, MultiBufferSource.BufferSource multiBufferSource, Camera camera, float partialTick) {

    }

    default void steupAnimtick(Entity entity, Model model, ModelPart modelPart, float v){

    };
}
