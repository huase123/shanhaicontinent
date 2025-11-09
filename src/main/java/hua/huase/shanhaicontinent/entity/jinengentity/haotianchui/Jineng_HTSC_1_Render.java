package hua.huase.shanhaicontinent.entity.jinengentity.haotianchui;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import hua.huase.shanhaicontinent.item.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.joml.Quaternionf;

public class Jineng_HTSC_1_Render extends EntityRenderer<Jineng_HTSC_1_Entity> {

    private static ItemStack itemStack = new ItemStack(ItemInit.jineng_htsc_0.get());
    public Jineng_HTSC_1_Render(EntityRendererProvider.Context context) {
        super(context);
    }

    public void render(Jineng_HTSC_1_Entity entity, float v, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        renderEntity(entity,v,partialTick,poseStack,multiBufferSource,i);
        super.render(entity,v,partialTick,poseStack,multiBufferSource,i);
    }

    private void renderEntity(Jineng_HTSC_1_Entity entity, float v, float partialTick, PoseStack pPoseStack, MultiBufferSource multiBufferSource, int i) {



        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        pPoseStack.pushPose();
        pPoseStack.translate(0,3,0);
        Quaternionf quaternionf = Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation();
        pPoseStack.mulPose(quaternionf.rotateXYZ((float) Math.PI, (float) Math.PI, (float) Math.PI));
        pPoseStack.scale(5.0f, 5.0f, 5.0f);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(180));

        itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, i,
                OverlayTexture.NO_OVERLAY, pPoseStack, multiBufferSource, entity.level(), 1);
        pPoseStack.popPose();


    }


    @Override
    public ResourceLocation getTextureLocation(Jineng_HTSC_1_Entity p_114482_) {
        return null;
    }
}
