package hua.huase.shanhaicontinent.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapability;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapabilityProvider;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

import static hua.huase.shanhaicontinent.SHMainBus.HUNHUAN;

@OnlyIn(Dist.CLIENT)
public interface SHRenderApi {


    public static void renderHunhuan(int nianxian,float size, PoseStack poseStack, VertexConsumer bufferbuilder, float partialTick, boolean direction) {
        poseStack.pushPose();
        Matrix4f matrix4f = poseStack.last().pose();
        matrix4f.translate(0,0.001f*size,0);
        matrix4f.scale(size,1, size);
        matrix4f.rotate((float)Math.PI*0.005f*(Minecraft.getInstance().level.getGameTime()+partialTick)*(direction? -1:1), 0.0F, 1.0F, 0.0F);
        int color = SHRenderUtil.getColor(nianxian);
        bufferbuilder.vertex(matrix4f, -1, 0.01f, -1).color(color).uv(0, 0).endVertex();
        bufferbuilder.vertex(matrix4f, -1, 0.01f, +1).color(color).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, +1, 0.01f, +1).color(color).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, +1, 0.01f, -1).color(color).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, +1, 0.01f, -1).color(color).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, +1, 0.01f, +1).color(color).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, -1, 0.01f, +1).color(color).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, -1, 0.01f, -1).color(color).uv(0, 0).endVertex();
        poseStack.popPose();
    }



    static void renderStart(ResourceLocation resourceLocation, PoseStack poseStack){
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
//        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
//        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

        RenderSystem.setShaderTexture(0, resourceLocation);
        RenderSystem.depthMask(Minecraft.useShaderTransparency());
        poseStack.pushPose();

//        RenderSystem.setShaderColor(f, f1, f2, (float)d1);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.polygonOffset(-3.0F, -3.0F);
        RenderSystem.enablePolygonOffset();
        RenderSystem.disableCull();
    }
    static void renderStart(PoseStack poseStack){
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
//        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.DST_COLOR, GlStateManager.DestFactor.SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

//        RenderSystem.setShaderTexture(0, resourceLocation);
        RenderSystem.depthMask(Minecraft.useShaderTransparency());
        poseStack.pushPose();

//        RenderSystem.setShaderColor(f, f1, f2, (float)d1);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.polygonOffset(-3.0F, -3.0F);
        RenderSystem.enablePolygonOffset();
        RenderSystem.disableCull();
    }
    static void renderEnd(PoseStack poseStack){

        RenderSystem.enableCull();
        RenderSystem.polygonOffset(0.0F, 0.0F);
        RenderSystem.disablePolygonOffset();
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
        poseStack.popPose();
        RenderSystem.disableDepthTest();
        RenderSystem.applyModelViewMatrix();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.depthMask(true);
    }



    public static void renderdibu(float partialTick, PoseStack poseStack, float scale, ResourceLocation resourceLocation){

        SHRenderApi.renderStart(resourceLocation,poseStack);

        Matrix4f matrix4f = poseStack.last().pose();

        matrix4f.scale(scale,scale, scale);

        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f,1.0f);

        matrix4f.rotate((float)0.03f*(partialTick), 0.0F, 1.0F, 0.0F);
        matrix4f.translate(0,0.3f,0);

        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix4f, (float)0-10, 0.1f, (float)0-10).uv(0, 0).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0-10, 0.1f, (float)0+10).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+10, 0.1f, (float)0+10).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+10, 0.1f, (float)0-10).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+10, 0.1f, (float)0-10).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+10, 0.1f, (float)0+10).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0-10, 0.1f, (float)0+10).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0-10, 0.1f, (float)0-10).uv(0, 0).endVertex();
        BufferUploader.drawWithShader(bufferbuilder.end());
        SHRenderApi.renderEnd(poseStack);
    }

    public static void rendertian(float partialTick, PoseStack poseStack, float scale, ResourceLocation resourceLocation,int count){

        for (int i = 0; i < count; i++) {
            SHRenderApi.renderStart(resourceLocation,poseStack);
            Matrix4f matrix4f = poseStack.last().pose();
            matrix4f.scale(scale,scale, scale);
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f,0.1f);

            matrix4f.rotate((float) (i/(float)count*Math.PI)+0.03f*(partialTick), 0.0F, 1.0F, 0.0F);
            matrix4f.rotate((float) (0.5*Math.PI), 1.0F, 0.0F, 0.0F);
//			matrix4f.rotate(0.03f*(partialTick), 0.0F, 1.0F, 0.0F);
//			matrix4f.rotate(0.03f*(partialTick), 1.0F, 0.0F, 0.0F);
            matrix4f.translate(0,0.3f,0);

            BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
            bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
            bufferbuilder.vertex(matrix4f, (float)0-10, 0.1f, (float)0-10).uv(0, 0).endVertex();
            bufferbuilder.vertex(matrix4f, (float)0-10, 0.1f, (float)0+10).uv(0, 1).endVertex();
            bufferbuilder.vertex(matrix4f, (float)0+10, 0.1f, (float)0+10).uv(1, 1).endVertex();
            bufferbuilder.vertex(matrix4f, (float)0+10, 0.1f, (float)0-10).uv(1, 0).endVertex();
            bufferbuilder.vertex(matrix4f, (float)0+10, 0.1f, (float)0-10).uv(1, 0).endVertex();
            bufferbuilder.vertex(matrix4f, (float)0+10, 0.1f, (float)0+10).uv(1, 1).endVertex();
            bufferbuilder.vertex(matrix4f, (float)0-10, 0.1f, (float)0+10).uv(0, 1).endVertex();
            bufferbuilder.vertex(matrix4f, (float)0-10, 0.1f, (float)0-10).uv(0, 0).endVertex();
            BufferUploader.drawWithShader(bufferbuilder.end());
            SHRenderApi.renderEnd(poseStack);
        }

    }
}
