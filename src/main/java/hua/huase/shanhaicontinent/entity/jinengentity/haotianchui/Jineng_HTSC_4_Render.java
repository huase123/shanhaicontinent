package hua.huase.shanhaicontinent.entity.jinengentity.haotianchui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.item.ItemInit;
import hua.huase.shanhaicontinent.render.SHRenderApi;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

public class Jineng_HTSC_4_Render extends EntityRenderer<Jineng_HTSC_4_Entity> {

    public static final ResourceLocation resourceLocation = new ResourceLocation(SHMainBus.MOD_ID, "textures/jineng/jingubangdzsy.png");
    private static ItemStack itemStack = new ItemStack(ItemInit.jineng_htsc_0.get());
    public Jineng_HTSC_4_Render(EntityRendererProvider.Context context) {
        super(context);
    }

    public void render(Jineng_HTSC_4_Entity entity, float v, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        renderEntity(entity,v,partialTick,poseStack,multiBufferSource,i);
        super.render(entity,v,partialTick,poseStack,multiBufferSource,i);
    }

    private void renderEntity(Jineng_HTSC_4_Entity entity, float v, float partialTick, PoseStack pPoseStack, MultiBufferSource multiBufferSource, int i) {



        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        pPoseStack.pushPose();
        pPoseStack.translate(0,3,0);
        Quaternionf quaternionf = Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation();
        pPoseStack.mulPose(quaternionf.rotateXYZ((float) Math.PI, (float) Math.PI, (float) Math.PI));
        pPoseStack.scale(5.0f, 5.0f, 5.0f);
        pPoseStack.mulPose(Axis.YP.rotationDegrees(90));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(3*(entity.tickCount+partialTick)));

        itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, i,
                OverlayTexture.NO_OVERLAY, pPoseStack, multiBufferSource, entity.level(), 1);
        pPoseStack.popPose();





        SHRenderApi.renderStart(resourceLocation,pPoseStack);

        RenderSystem.setShaderColor(1.0F, 1.0F, 0.0F, 1.0F);
        Matrix4f matrix4f = pPoseStack.last().pose();

        pPoseStack.mulPose(Axis.YP.rotationDegrees(10*(entity.tickCount+partialTick)));
        matrix4f.rotate((float) Math.PI,1,0,0);
//        poseStack.mulPose(new Quaternionf(-quaternionf.x(),-quaternionf.y(),-quaternionf.z(),-quaternionf.w()));


        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix4f, (float)0-6, 0.1f, (float)0-6).uv(0, 0).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0-6, 0.1f, (float)0+6).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+6, 0.1f, (float)0+6).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+6, 0.1f, (float)0-6).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+6, 0.1f, (float)0-6).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+6, 0.1f, (float)0+6).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0-6, 0.1f, (float)0+6).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0-6, 0.1f, (float)0-6).uv(0, 0).endVertex();
        BufferUploader.drawWithShader(bufferbuilder.end());
        SHRenderApi.renderEnd(pPoseStack);



    }


    @Override
    public ResourceLocation getTextureLocation(Jineng_HTSC_4_Entity p_114482_) {
        return null;
    }
}
