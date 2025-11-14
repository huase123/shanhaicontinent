package hua.huase.shanhaicontinent.animation.animationcontrollers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import hua.huase.shanhaicontinent.animation.AnimationControllerInstance;
import hua.huase.shanhaicontinent.animation.IClientMobAnimationExtensions;
import hua.huase.shanhaicontinent.animation.SHAnimationController;
import hua.huase.shanhaicontinent.entity.animations.ModAnimationDefinitions;
import hua.huase.shanhaicontinent.render.SHRenderType;
import net.minecraft.client.Camera;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

import static hua.huase.shanhaicontinent.SHMainBus.TEXT;

/**
 * - @description:AnimationControllerDemo类
 * - @author: huase。
 * - @date: 2025/11/11 6:48
 */
public class AnimationController implements SHAnimationController {
    long duration =20;
    public AnimationController() {


        initClient();
    }

    @Override
    public long getDuration(Entity livingEntity) {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public AnimationDefinition getAnimationDefinition(Entity livingEntity) {
        return ModAnimationDefinitions.playerfly;
    }

    @Override
    public void tick(Entity entity) {

    }




    private Object effectRenderer;

    public Object getEffectRendererInternal() {
        return effectRenderer;
    }

    private void initClient() {
        // Minecraft instance isn't available in datagen, so don't call initializeClient if in datagen
        if (net.minecraftforge.fml.loading.FMLEnvironment.dist == net.minecraftforge.api.distmarker.Dist.CLIENT && !net.minecraftforge.fml.loading.FMLLoader.getLaunchHandler().isData()) {
            initializeClient(properties -> {
                this.effectRenderer = properties;
            });
        }
    }

    public void initializeClient(java.util.function.Consumer<IClientMobAnimationExtensions> consumer) {
        consumer.accept(new AnimationRenderDamo());
    }

}
