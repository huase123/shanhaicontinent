package hua.huase.shanhaicontinent.animation.client;

import com.mojang.blaze3d.vertex.PoseStack;
import hua.huase.shanhaicontinent.animation.AnimationController;
import hua.huase.shanhaicontinent.animation.AnimationControllerInstance;
import hua.huase.shanhaicontinent.animation.SHAnimationController;
import net.minecraft.client.Camera;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;
import java.util.function.Consumer;

/**
 客户端{@link AnimationController}类的渲染扩展
 * @see AnimationController#initializeClient(Consumer)
 */
public interface IClientMobAnimationExtensions {

    IClientMobAnimationExtensions DEFAULT = new IClientMobAnimationExtensions() { };

    static IClientMobAnimationExtensions of(AnimationControllerInstance instance)
    {
        return of(instance.getAnimationcontroller());
    }

    static IClientMobAnimationExtensions of(SHAnimationController instance)
    {
        return instance.getRendererInternal() instanceof IClientMobAnimationExtensions r ? r : DEFAULT;
    }

    /**
     *额外渲染
     */
    default void render(AnimationControllerInstance animationControllerInstance, Entity entity, PoseStack poseStack, MultiBufferSource multiBufferSource, Camera camera, float partialTick) {

    }
    /**
    *动画更新
    */
    default void steupAnimtick(AnimationControllerInstance animationControllerInstance, Entity entity, Model model, ModelPart modelPart, float v){

    };


    @Nullable
    default RenderType getRenderType() {
            return RenderType.outline(this.getTextureLocation());
//            return RenderType.itemEntityTranslucentCull(this.getTextureLocation());
//        ResourceLocation resourcelocation = this.getTextureLocation(pLivingEntity);
//        if (pTranslucent) {
//            return RenderType.itemEntityTranslucentCull(resourcelocation);
//        } else if (pBodyVisible) {
//            return this.model.renderType(resourcelocation);
//        } else {
//            return pGlowing ? RenderType.outline(resourcelocation) : null;
//        }
    }

    default ResourceLocation getTextureLocation() {
        return null;
    }


    default AnimationDefinition getAnimationDefinition() {
        return null;
    }

    default ModelPart getExtramodelPart() {
        return null;
    }
}
