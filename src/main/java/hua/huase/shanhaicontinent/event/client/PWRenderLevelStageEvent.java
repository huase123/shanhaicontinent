package hua.huase.shanhaicontinent.event.client;

import com.mojang.blaze3d.vertex.PoseStack;
import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.event.api.LeveRenderPlaerEventPostEvent;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PWRenderLevelStageEvent {



    @SubscribeEvent
    public static void renderPlayerEventPost(RenderLevelStageEvent event){
        postEvent(event);
    }

    /**
     * 注入自定义事件
     * @see LeveRenderPlaerEventPostEvent
     */
    private static void postEvent(RenderLevelStageEvent event) {
        if (event.getStage() !=RenderLevelStageEvent.Stage.AFTER_ENTITIES )return;
        MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
        LevelRenderer levelRenderer = event.getLevelRenderer();
        float renderTick =Minecraft.getInstance().getPartialTick();
        Camera camera = event.getCamera();

        for (AbstractClientPlayer abstractClientPlayer : Minecraft.getInstance().level.players()) {
            Player player = abstractClientPlayer;
            PoseStack poseStack = event.getPoseStack();
            double d0 = Mth.lerp(renderTick, player.xOld, player.getX()) - camera.getPosition().x;
            double d1 = Mth.lerp(renderTick, player.yOld, player.getY()) - camera.getPosition().y;
            double d2 = Mth.lerp(renderTick, player.zOld, player.getZ()) - camera.getPosition().z;
            if(d0 * d0 + d1 * d1 + d2 * d2 <=32*32){
                poseStack.pushPose();
                poseStack.translate(d0, d1, d2);
                net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new LeveRenderPlaerEventPostEvent(player,levelRenderer,bufferSource,event.getPartialTick(),poseStack,camera));
                poseStack.popPose();
            }
        }
        bufferSource.endBatch();
    }


}
