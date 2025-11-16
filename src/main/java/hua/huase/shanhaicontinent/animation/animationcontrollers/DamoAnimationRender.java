package hua.huase.shanhaicontinent.animation.animationcontrollers;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.animation.client.AnimationRender;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/**
 * - @description:DamoAnimationRender类
 */
public class DamoAnimationRender extends AnimationRender {
    @Nullable
    @Override
    public RenderType getRenderType() {


//        ResourceLocation resourcelocation = this.getTextureLocation(pLivingEntity);
//        if (pTranslucent) {
//            return RenderType.itemEntityTranslucentCull(resourcelocation);
//        } else if (pBodyVisible) {
//            return this.model.renderType(resourcelocation);
//        } else {
//            return RenderType.outline(this.getTextureLocation());
//        }

        return RenderType.itemEntityTranslucentCull(this.getTextureLocation());
    }

    public static final ResourceLocation dame = new ResourceLocation(SHMainBus.MOD_ID, "textures/animation/dame.png");
    @Override
    public ResourceLocation getTextureLocation() {
        return dame;
    }

    public static final AnimationDefinition demo = AnimationDefinition.Builder.withLength(2.2F)
            .addAnimation("right_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-155.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.96F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("left_arm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(-155.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.96F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.96F, KeyframeAnimations.degreeVec(16.7653F, -10.0618F, -6.0468F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("root", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.96F, KeyframeAnimations.posVec(0.0F, 0.0F, 8.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("goldencudgel", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.96F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .addAnimation("goldencudgel", new AnimationChannel(AnimationChannel.Targets.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                    new Keyframe(1.96F, KeyframeAnimations.posVec(0.0F, -24.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
            ))
            .build();
    @Override
    public AnimationDefinition getAnimationDefinition() {
        return demo;
    }
    ModelPart part = createModelPart();
    @Override
    public ModelPart getExtramodelPart() {

        return part;
    }

    private ModelPart createModelPart() {

        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition goldencudgel = partdefinition.addOrReplaceChild("goldencudgel", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -76.0F, -4.0F, 9.0F, 77.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -14.0F, -6.0F));

        PartDefinition cube_r1 = goldencudgel.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(68, 85).addBox(-5.0F, -76.0F, -4.0F, 9.0F, 77.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.2654F, 0.0F));

        PartDefinition cube_r2 = goldencudgel.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(34, 85).addBox(-5.0F, -76.0F, -4.0F, 9.0F, 77.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0472F, 0.0F));

        PartDefinition cube_r3 = goldencudgel.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 85).addBox(-5.0F, -76.0F, -4.0F, 9.0F, 77.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7418F, 0.0F));

        PartDefinition cube_r4 = goldencudgel.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(68, 0).addBox(-5.0F, -76.0F, -4.0F, 9.0F, 77.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.48F, 0.0F));

        PartDefinition cube_r5 = goldencudgel.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(34, 0).addBox(-5.0F, -76.0F, -4.0F, 9.0F, 77.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256).bakeRoot();

    }
}
