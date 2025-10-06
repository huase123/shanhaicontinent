package hua.huase.shanhaicontinent.event.api;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.Event;
/**
 *
 * 因为原版中第一人称不会渲染玩家自身，所以创建了这个事件来取代forge的
 * @see RenderPlayerEvent.Post 事件
 * 创建方式请查看
 * @see hua.huase.shanhaicontinent.event.client.PWRenderPlayerEvent
 */
public class LeveRenderPlaerEventPostEvent extends Event {

    public Player getEntity() {
        return player;
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

    public MultiBufferSource.BufferSource getMultiBufferSource() {
        return bufferSource;
    }

    private final Player player;
    private final LevelRenderer levelRenderer;
    private final MultiBufferSource.BufferSource bufferSource;
    private final float partialTick;
    private final PoseStack poseStack;
    private final Camera camera;

    public LeveRenderPlaerEventPostEvent(Player player, LevelRenderer levelRenderer, MultiBufferSource.BufferSource bufferSource, float partialTick, PoseStack poseStack, Camera camera) {

        this.player = player;
        this.levelRenderer = levelRenderer;
        this.bufferSource = bufferSource;
        this.partialTick = partialTick;
        this.poseStack = poseStack;
        this.camera = camera;
    }
}
