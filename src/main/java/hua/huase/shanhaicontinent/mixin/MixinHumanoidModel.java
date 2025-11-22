package hua.huase.shanhaicontinent.mixin;

import hua.huase.shanhaicontinent.entity.animations.ModAnimationDefinitions;
import hua.huase.shanhaicontinent.event.api.HumanoidModelsteupAnimEvent;
import hua.huase.shanhaicontinent.event.api.LeveRenderLivingEntityPostEvent;
import hua.huase.shanhaicontinent.item.TextItem;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Mixin(HumanoidModel.class)
public abstract class MixinHumanoidModel {




    @Unique
    private   ModelPart pRoot;

    @Inject(at = @At(value = "RETURN"), method = "Lnet/minecraft/client/model/HumanoidModel;<init>(Lnet/minecraft/client/model/geom/ModelPart;Ljava/util/function/Function;)V")
    public void HumanoidModel(ModelPart pRoot, Function pRenderType, CallbackInfo ci) {
         this.pRoot = pRoot;
    }
    @Inject(method = "setupAnim",at = @At(
            value ="TAIL",
            target = "Lnet/minecraft/client/model/HumanoidModel;setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V"
    ))
    public void setupAnim(LivingEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch, CallbackInfo ci) {
        HumanoidModelsteupAnimEvent humanoidModelsteupAnimEvent = new HumanoidModelsteupAnimEvent(((HumanoidModel<?>) ((Object) this)), pRoot, pEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(humanoidModelsteupAnimEvent);
    }

}
