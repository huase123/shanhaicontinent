package hua.huase.shanhaicontinent.event.client;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.animation.AnimationControllerInstance;
import hua.huase.shanhaicontinent.animation.AnimationUtil;
import hua.huase.shanhaicontinent.animation.client.IClientMobAnimationExtensions;
import hua.huase.shanhaicontinent.event.api.HumanoidModelsteupAnimEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Vector3f;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * - @description:PWModelsteupAnimEvent类
 * - @author: huase。
 * - @date: 2025/11/11 0:27
 */
@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PWModelsteupAnimEvent {

    @SubscribeEvent
    public static void onModelsteupAnimEvent(HumanoidModelsteupAnimEvent event){
        LivingEntity livingEntity = event.getpEntity();
        AnimationControllerInstance animationControllerInstance =  AnimationUtil.getAnimationControllerInstance(livingEntity);
        if(animationControllerInstance != null && !animationControllerInstance.isover()){
            IClientMobAnimationExtensions.of(animationControllerInstance).steupAnimtick(animationControllerInstance,event.getpEntity(),event.getHumanoidModel(),event.getpRoot(),event.getpAgeInTicks());
        }
    }



    private static final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();

//    protected void animate(ModelPart pRoot, AnimationState pAnimationState, AnimationDefinition pAnimationDefinition, float pAgeInTicks, float pSpeed, Vector3f ANIMATION_VECTOR_CACHE) {
//        pAnimationState.updateTime(pAgeInTicks, pSpeed);
//        pAnimationState.ifStarted((p_233392_) -> {
//            animate(pRoot, pAnimationDefinition, p_233392_.getAccumulatedTime(), 1.0F, this.ANIMATION_VECTOR_CACHE);
//        });
//    }
    private static void animate(ModelPart pModel, AnimationDefinition pAnimationDefinition, long pAccumulatedTime, float pScale, Vector3f pAnimationVecCache) {

        float f = getElapsedSeconds(pAnimationDefinition, pAccumulatedTime);

        for(Map.Entry<String, List<AnimationChannel>> entry : pAnimationDefinition.boneAnimations().entrySet()) {
//            Optional<ModelPart> optional = pModel.getAnyDescendantWithName(entry.getKey());
            Optional<ModelPart> optional = getAnyDescendantWithName(pModel,entry.getKey());
            List<AnimationChannel> list = entry.getValue();
            optional.ifPresent((modelPart) -> {

                modelPart.resetPose();

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
            });
        }

    }

    private static  Optional<ModelPart> getAnyDescendantWithName(ModelPart pModel, String pName) {
        if(pModel.hasChild(pName)){
            return Optional.of(pModel.getChild(pName));
        }

        return Optional.empty();
    }
    private static  float getElapsedSeconds(AnimationDefinition pAnimationDefinition, long pAccumulatedTime) {
        float f = (float)pAccumulatedTime / 1000.0F + Minecraft.getInstance().getFrameTime()/1000.0F;
        return pAnimationDefinition.looping() ? f % pAnimationDefinition.lengthInSeconds() : f;
    }
}
