package hua.huase.shanhaicontinent.event.api;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.Event;
/**
 *
 * 因为原版中第一人称不会渲染玩家自身，所以创建了这个事件来取代forge的
 * @see RenderHandEvent 事件
 * 创建方式请查看
 * @see hua.huase.shanhaicontinent.event.client.PWRenderPlayerEvent
 */
@OnlyIn(Dist.CLIENT)
public class LeveRenderLivingEntityPostEvent extends Event {

    public LivingEntity getEntity() {
        return entity;
    }

    public LevelRenderer getLevelRenderer() {
        return levelRenderer;
    }

    public float getPartialTick() {
        return partialTick;
    }

    public PoseStack getPoseStack() {
        return poseStack;
    }

    public Camera getCamera() {
        return camera;
    }

    public MultiBufferSource getMultiBufferSource() {
        return bufferSource;
    }

    private final LivingEntity entity;
    private final LevelRenderer levelRenderer;
    private final MultiBufferSource bufferSource;
    private final float partialTick;
    private final PoseStack poseStack;
    private final Camera camera;

    public LeveRenderLivingEntityPostEvent(LivingEntity entity, LevelRenderer levelRenderer, MultiBufferSource bufferSource, float partialTick, PoseStack poseStack, Camera camera) {

        this.entity = entity;
        this.levelRenderer = levelRenderer;
        this.bufferSource = bufferSource;
        this.partialTick = partialTick;
        this.poseStack = poseStack;
        this.camera = camera;
    }
}
