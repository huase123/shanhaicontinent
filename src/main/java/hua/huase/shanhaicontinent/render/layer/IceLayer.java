//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hua.huase.shanhaicontinent.render.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import hua.huase.shanhaicontinent.render.SHRenderApi;
import hua.huase.shanhaicontinent.render.SHRenderType;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;


import static hua.huase.shanhaicontinent.SHMainBus.HUNHUAN;

public class IceLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private final RandomSource random = RandomSource.create();

    public IceLayer(RenderLayerParent<T, M> renderer) {
        super(renderer);
    }

    public void render(PoseStack stack, MultiBufferSource buffer, int light, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {

        float size1 = (float) entity.getBoundingBox().getSize();
        float size =1+ size1*2f;
        VertexConsumer bufferbuilder = buffer.getBuffer(SHRenderType.render_Material(HUNHUAN));
        SHRenderApi.renderHunhuan(10000,size,stack,bufferbuilder,partialTicks,false);
    }
}
