package hua.huase.shanhaicontinent.block.entityblock.pot;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.shaders.ShadersInt;
import hua.huase.shanhaicontinent.shaders.TimeShader;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

import static org.lwjgl.glfw.GLFW.glfwGetTime;

public class PotBlockEntityRenderer implements BlockEntityRenderer<PotBlockEntity> {
    public PotBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(PotBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = pBlockEntity.getRenderStack();

        pPoseStack.pushPose();
        pPoseStack.translate(0.5f, 1.10f, 0.5f);
        pPoseStack.scale(0.35f, 0.35f, 0.35f);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(270));

        itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY, pPoseStack, pBuffer, pBlockEntity.getLevel(), 1);
        pPoseStack.popPose();
        rendertext(pBlockEntity,pPartialTick,pPoseStack,pBuffer,pPackedLight,pPackedOverlay);
    }

    private static final ResourceLocation HUNHUAN = new ResourceLocation(SHMainBus.MOD_ID, "textures/picture/particletext.png");
    private void rendertext(PotBlockEntity pBlockEntity, float pPartialTick, PoseStack poseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {

        Camera mainCamera = Minecraft.getInstance().gameRenderer.getMainCamera();

        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
//        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
//        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

        RenderSystem.setShaderTexture(0, HUNHUAN);
        RenderSystem.depthMask(Minecraft.useShaderTransparency());
//        RenderSystem.setShaderColor(f, f1, f2, (float)d1);
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShader(ShadersInt::getShmapshaderUnlitShader);
        ShaderInstance shader = RenderSystem.getShader();

//        RenderSystem.polygonOffset(-3.0F, -3.0F);
        RenderSystem.enablePolygonOffset();
        RenderSystem.disableCull();


        for (int i = 0; i < 12; i++) {



            if(RenderSystem.getShader() instanceof TimeShader timeShader){
//            float v1 = (float) (mainCamera.getXRot() / (2*Math.PI));
//            float v1 = 0;
//            float v = (float) (mainCamera.getYRot() / (2*Math.PI));
//            float v = 0;
//            timeShader.setBrightnessRot(v1, v,mainCamera.getYRot());
                Vec3 position = mainCamera.getPosition();
                BlockPos blockPos = pBlockEntity.getBlockPos();
                double v2 = Math.atan2(position.z - blockPos.getZ(), position.x - blockPos.getX());

//            timeShader.setBrightnessRot((float) 0, (float) v2,0);

                timeShader.setBrightnessTime((float) glfwGetTime()+i);

            }


            poseStack.pushPose();
//        poseStack.translate(0.5f,3.5f,0.5f);
            poseStack.translate(0f,3.5f,0f);
            poseStack.scale(5,5,5);

            double v = 2*i * Math.PI / 12;
            double x = Math.sin(v) * 1;
            double y = Math.cos(v) * 1;
            poseStack.translate((float) x, (float) 0, (float) y);

            poseStack.mulPose(mainCamera.rotation());
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
            Matrix4f matrix4f = poseStack.last().pose();

//        matrix4f.scale(0.5f,0.5f,0.5f);
            BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
            bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);

            float size = 0.5f;
            bufferbuilder.vertex(matrix4f, -size, -size, 0f).uv(0, 0).endVertex();
            bufferbuilder.vertex(matrix4f, -size, size, 0f).uv(0, 1).endVertex();
            bufferbuilder.vertex(matrix4f, size, size, 0f).uv(1, 1).endVertex();
            bufferbuilder.vertex(matrix4f, size, -size, 0f).uv(1, 0).endVertex();

            BufferUploader.drawWithShader(bufferbuilder.end());

            poseStack.popPose();

        }





        RenderSystem.enableCull();
        RenderSystem.polygonOffset(0.0F, 0.0F);
        RenderSystem.disablePolygonOffset();
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableDepthTest();
        RenderSystem.applyModelViewMatrix();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.depthMask(true);
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
