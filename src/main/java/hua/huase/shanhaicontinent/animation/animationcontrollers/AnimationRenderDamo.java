package hua.huase.shanhaicontinent.animation.animationcontrollers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import hua.huase.shanhaicontinent.animation.AnimationControllerInstance;
import hua.huase.shanhaicontinent.animation.IClientMobAnimationExtensions;
import hua.huase.shanhaicontinent.render.SHRenderType;
import net.minecraft.client.Camera;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

import static hua.huase.shanhaicontinent.SHMainBus.TEXT;

/**
 * - @description:AnimationRenderDamo类
 * - @author: huase。
 * - @date: 2025/11/14 13:31
 */
public class AnimationRenderDamo implements IClientMobAnimationExtensions {
    ModelPart modelPart =  resizeBoxElement(16, 100, 16);
    private ModelPart resizeBoxElement(int pixelsX, int pixelsY, int pixelsZ) {

        MeshDefinition mesh = new MeshDefinition();
        PartDefinition partRoot = mesh.getRoot();

        partRoot.addOrReplaceChild("box", CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1.0F, -1.0F, -1.0F, pixelsX, pixelsY, pixelsZ),
                PartPose.ZERO);
        return partRoot.bake(16, 16);

    }
    public void render(AnimationControllerInstance animationControllerInstance, Entity entity, PoseStack poseStack, MultiBufferSource.BufferSource multiBufferSource, Camera camera, float partialTick) {
//        VertexConsumer bufferbuilder = multiBufferSource.getBuffer(RenderType.solid());

        VertexConsumer bufferbuilder = multiBufferSource.getBuffer(SHRenderType.render_Material(TEXT));
        poseStack.pushPose();
        Matrix4f matrix4f = poseStack.last().pose();
//        matrix4f.translate(0,2,0);
//        matrix4f.scale(1,10, 1);
        float cumulativeTime = (float) animationControllerInstance.getCumulativeTime(entity) /animationControllerInstance.getDuration(entity);
        matrix4f.rotate((float)Math.PI/2.0f*cumulativeTime, 1.0F, 0.0F, 0.0F);

//        ModelPart modelPart =  resizeBoxElement(16, 100, 16);
//        ModelPart modelPart = mesh.getRoot().getChild("box").bake(16,16);
        modelPart.render(poseStack,bufferbuilder,15728880, OverlayTexture.NO_OVERLAY);

//        int color = 0xffffffff;
//        float[][] cubeVertices = ShapeUtil.getCubeVertices(1, 1, 1);
//        for (float[] cubeVertex : cubeVertices) {
//            bufferbuilder.vertex(matrix4f, cubeVertex[0], cubeVertex[1], cubeVertex[2]).color(color).uv(cubeVertex[3], cubeVertex[4]).endVertex();
//        }
        poseStack.popPose();
    }

    public void steupAnimtick(Entity entity, Model model, ModelPart modelPart, float v){

    };
}
