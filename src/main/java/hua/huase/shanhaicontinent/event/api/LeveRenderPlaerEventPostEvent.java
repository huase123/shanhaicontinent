package hua.huase.shanhaicontinent.event.api;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
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

    public LocalPlayer getPlayer() {
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

    private final LocalPlayer player;
    private final LevelRenderer levelRenderer;
    private final float partialTick;
    private final PoseStack poseStack;

    public LeveRenderPlaerEventPostEvent(LocalPlayer player, LevelRenderer levelRenderer, float partialTick, PoseStack poseStack) {

        this.player = player;
        this.levelRenderer = levelRenderer;
        this.partialTick = partialTick;
        this.poseStack = poseStack;
    }
}
