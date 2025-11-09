package hua.huase.shanhaicontinent.entity.jinengentity.huang;

import com.mojang.blaze3d.vertex.PoseStack;
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

public class JiNengKPBSRender extends EntityRenderer<JiNengKPBSEntity> {

    private static ItemStack itemStack = new ItemStack(ItemInit.jineng_huang_1.get());
    public JiNengKPBSRender(EntityRendererProvider.Context context) {
        super(context);
    }

    public void render(JiNengKPBSEntity entity, float v, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        renderEntity(entity,v,partialTick,poseStack,multiBufferSource,i);
        super.render(entity,v,partialTick,poseStack,multiBufferSource,i);
    }

    private void renderEntity(JiNengKPBSEntity entity, float v, float partialTick, PoseStack pPoseStack, MultiBufferSource multiBufferSource, int i) {


        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        pPoseStack.pushPose();
//        pPoseStack.translate(0.0f, 0.3f, 0.0f);
//        pPoseStack.last().pose().rotate((float)Math.PI*0.5f, 1.0F, 0.0F, 0.0F);
//        pPoseStack.last().pose().rotate((float)Math.PI*1.0f*(entity.level().getGameTime()+partialTick), 1.0F, 0.0F, 0.0F);
//        pPoseStack.last().pose().rotate((float)Math.PI*0.5f, 1.0F, 0.0F, 1.0F);
        pPoseStack.scale(5.0f, 5.0f, 5.0f);
//        pPoseStack.mulPose(Axis.XP.rotationDegrees(0));

        itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, i,
                OverlayTexture.NO_OVERLAY, pPoseStack, multiBufferSource, entity.level(), 1);
        pPoseStack.popPose();



    }


    @Override
    public ResourceLocation getTextureLocation(JiNengKPBSEntity p_114482_) {
        return null;
    }
}
