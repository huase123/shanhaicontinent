package hua.huase.shanhaicontinent.mixin;

import hua.huase.shanhaicontinent.entity.animations.ModAnimationDefinitions;
import hua.huase.shanhaicontinent.item.TextItem;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mixin(PlayerModel.class)
public abstract class MixinPlayerModel {


    @Shadow @Final private List<ModelPart> parts;


    @Shadow protected abstract Iterable<ModelPart> bodyParts();

    private  final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();
    private   ModelPart pRoot;

    @Inject(at = @At(value = "RETURN"), method = "<init>(Lnet/minecraft/client/model/geom/ModelPart;Z)V")
    public void PlayerModel(ModelPart pRoot, boolean pSlim, CallbackInfo ci) {
         this.pRoot = pRoot;
    }
    @Inject(method = "setupAnim",at = @At(
            value ="INVOKE",
            target = "Lnet/minecraft/client/model/HumanoidModel;setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V", shift = At.Shift.AFTER
    ))
    public void setupAnim(LivingEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch, CallbackInfo ci) {
        Iterable<ModelPart> modelParts = this.bodyParts();
        ModelPart head = ((PlayerModel<?>) ((Object) this)).head;
        System.out.println(head.xRot);
        float v = pAgeInTicks * 10.0f;
//        animate(pRoot, ModAnimationDefinitions.playerfly, (long) v,1.0f,ANIMATION_VECTOR_CACHE);
        animate(pRoot, TextItem.attackAnimationState, ModAnimationDefinitions.playerfly, (long) v,1.0f,ANIMATION_VECTOR_CACHE);
    }



    protected void animate(ModelPart pRoot, AnimationState pAnimationState, AnimationDefinition pAnimationDefinition, float pAgeInTicks, float pSpeed, Vector3f ANIMATION_VECTOR_CACHE) {
        pAnimationState.updateTime(pAgeInTicks, pSpeed);
        pAnimationState.ifStarted((p_233392_) -> {
            animate(pRoot, pAnimationDefinition, p_233392_.getAccumulatedTime(), 1.0F, this.ANIMATION_VECTOR_CACHE);
        });
    }
    public  void animate(ModelPart pModel, AnimationDefinition pAnimationDefinition, long pAccumulatedTime, float pScale, Vector3f pAnimationVecCache) {

        float f = getElapsedSeconds(pAnimationDefinition, pAccumulatedTime);

        for(Map.Entry<String, List<AnimationChannel>> entry : pAnimationDefinition.boneAnimations().entrySet()) {
//            Optional<ModelPart> optional = pModel.getAnyDescendantWithName(entry.getKey());
            Optional<ModelPart> optional = getAnyDescendantWithName(pModel,entry.getKey());
            List<AnimationChannel> list = entry.getValue();
            optional.ifPresent((p_232330_) -> {

                p_232330_.resetPose();

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
                    p_288241_.target().apply(p_232330_, pAnimationVecCache);
                });
            });
        }

    }

    public  Optional<ModelPart> getAnyDescendantWithName(ModelPart pModel, String pName) {
        if(pModel.hasChild(pName)){
            return Optional.of(pModel.getChild(pName));
        }

        return Optional.empty();
    }
    private  float getElapsedSeconds(AnimationDefinition pAnimationDefinition, long pAccumulatedTime) {
        float f = (float)pAccumulatedTime / 1000.0F;
        return pAnimationDefinition.looping() ? f % pAnimationDefinition.lengthInSeconds() : f;
    }
}
