package hua.huase.shanhaicontinent.animation.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import hua.huase.shanhaicontinent.animation.AnimationControllerInstance;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import org.joml.Vector3f;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * - @description:AnimationRenderDamo类
 * - @author: huase。
 * - @date: 2025/11/14 13:31
 */
public class AnimationRender implements IClientMobAnimationExtensions {
    public void render(AnimationControllerInstance animationControllerInstance, Entity entity, PoseStack poseStack, MultiBufferSource.BufferSource multiBufferSource, Camera camera, float partialTick) {
        RenderType renderType = getRenderType();
        if(renderType == null)return;
        VertexConsumer bufferbuilder = multiBufferSource.getBuffer(renderType);
        poseStack.pushPose();
        getExtramodelPart().render(poseStack,bufferbuilder,15728880, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
    }

    public void steupAnimtick(AnimationControllerInstance animationControllerInstance, Entity entity, Model model, ModelPart modelPart, float v){
        if(this.getAnimationDefinition() == null)return;
        animate(modelPart,this.getExtramodelPart(),this.getAnimationDefinition(),animationControllerInstance.getCumulativeTime()*50, 1.0f,ANIMATION_VECTOR_CACHE);
    };



/**
 * TODO 功能描述：解析播放mc原版动画，添加了额外模型
 * @author :huase
 * @date 2025/11/15 5:58
 * @see KeyframeAnimations#animate(HierarchicalModel, AnimationDefinition, long, float, Vector3f)
 *
 */
    private  final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();
    private  void animate(ModelPart pModel,ModelPart extraModel, AnimationDefinition pAnimationDefinition, long pAccumulatedTime, float pScale, Vector3f pAnimationVecCache) {

        float f = getElapsedSeconds(pAnimationDefinition, pAccumulatedTime);

        for(Map.Entry<String, List<AnimationChannel>> entry : pAnimationDefinition.boneAnimations().entrySet()) {
//            Optional<ModelPart> optional = pModel.getAnyDescendantWithName(entry.getKey());
            Optional<ModelPart> optional = getAnyDescendantWithName(pModel,entry.getKey());
            if(optional.isEmpty() && extraModel != null)optional = getAnyDescendantWithName(extraModel,entry.getKey());


            List<AnimationChannel> list = entry.getValue();
            optional.ifPresent((modelPart) -> {
                if(Objects.equals(entry.getKey(), "root")){
                    modelPart.resetPose();
                    for (ModelPart part : modelPart.getAllParts().toList()) {
                        list.forEach((p_288241_) -> {
                            Keyframe[] akeyframe = p_288241_.keyframes();
                            int i = Math.max(0, Mth.binarySearch(0, akeyframe.length, (p_232315_) -> {
                                return f <= akeyframe[p_232315_].timestamp();
                            }) - 1);
                            int j = Math.min(akeyframe.length - 1, i + 1);
                            Keyframe keyframe = akeyframe[i];
                            Keyframe keyframe1 = akeyframe[j];
                            float f1 = f - keyframe.timestamp();
                            float f2;
                            if (j != i) {
                                f2 = Mth.clamp(f1 / (keyframe1.timestamp() - keyframe.timestamp()), 0.0F, 1.0F);
                            } else {
                                f2 = 0.0F;
                            }

                            keyframe1.interpolation().apply(pAnimationVecCache, f2, akeyframe, i, j, pScale);
                            p_288241_.target().apply(part, pAnimationVecCache);
                        });
                    }

                }else {
                    list.forEach((p_288241_) -> {
                        Keyframe[] akeyframe = p_288241_.keyframes();
                        int i = Math.max(0, Mth.binarySearch(0, akeyframe.length, (p_232315_) -> {
                            return f <= akeyframe[p_232315_].timestamp();
                        }) - 1);
                        int j = Math.min(akeyframe.length - 1, i + 1);
                        Keyframe keyframe = akeyframe[i];
                        Keyframe keyframe1 = akeyframe[j];
                        float f1 = f - keyframe.timestamp();
                        float f2;
                        if (j != i) {
                            f2 = Mth.clamp(f1 / (keyframe1.timestamp() - keyframe.timestamp()), 0.0F, 1.0F);
                        } else {
                            f2 = 0.0F;
                        }

                        keyframe1.interpolation().apply(pAnimationVecCache, f2, akeyframe, i, j, pScale);
                        p_288241_.target().apply(modelPart, pAnimationVecCache);
                    });
                }
            });
        }

    }

    private   Optional<ModelPart> getAnyDescendantWithName(ModelPart pModel, String pName) {
        if(pName.equals("root")) return Optional.of(pModel);
        if(pModel.hasChild(pName)){
            return Optional.of(pModel.getChild(pName));
        }

        return Optional.empty();
    }
    private   float getElapsedSeconds(AnimationDefinition pAnimationDefinition, long pAccumulatedTime) {
        float f = (float)pAccumulatedTime / 1000.0F + Minecraft.getInstance().getFrameTime()/1000.0F;
        return pAnimationDefinition.looping() ? f % pAnimationDefinition.lengthInSeconds() : f;
    }
}
