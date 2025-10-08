package hua.huase.shanhaicontinent.entity.hunhuan;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.render.SHRenderApi;
import hua.huase.shanhaicontinent.render.SHRenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import static hua.huase.shanhaicontinent.SHMainBus.HUNHUAN;
public class HunhuanRender extends EntityRenderer<HunhuanEntity> {
    public HunhuanRender(EntityRendererProvider.Context context) {
        super(context);
    }

    public void render(HunhuanEntity entity, float v, float v1, PoseStack poseStack, MultiBufferSource multiBufferSource, int i) {
        entity.getCapability(MonsterAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {

            VertexConsumer bufferbuilder = multiBufferSource.getBuffer(SHRenderType.render_Material(HUNHUAN));
            int nianxian = capability.getNianxian();
            float size = (float) (2+ Math.log10(nianxian));
            SHRenderApi.renderHunhuan(nianxian,size,poseStack,bufferbuilder,v1,false);
        });
    }
    @Override
    public ResourceLocation getTextureLocation(HunhuanEntity p_114482_) {
        return null;
    }
}
