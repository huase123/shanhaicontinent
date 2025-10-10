package hua.huase.shanhaicontinent.event.client;

import com.mojang.blaze3d.vertex.PoseStack;
import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.config.Config;
import hua.huase.shanhaicontinent.event.api.LeveRenderLivingEntityPostEvent;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PWRenderLevelStageEvent {



    @SubscribeEvent
    public static void renderPlayerEventPost(RenderLevelStageEvent event){
        postEvent(event);
    }

    /**
     * 注入自定义事件
     * @see LeveRenderLivingEntityPostEvent
     */
    private static void postEvent(RenderLevelStageEvent event) {
        if(!Config.FIRSTPERSONDISPLAY.get())return;
        if (event.getStage() !=RenderLevelStageEvent.Stage.AFTER_ENTITIES )return;
        Player player = Minecraft.getInstance().player;
        if(Minecraft.getInstance().gameMode.getPlayerMode() == GameType.SPECTATOR || Minecraft.getInstance().options.hideGui || !Minecraft.getInstance().options.getCameraType().isFirstPerson())return;
        MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
        LevelRenderer levelRenderer = event.getLevelRenderer();
        float renderTick =Minecraft.getInstance().getPartialTick();
        Camera camera = event.getCamera();
        PoseStack poseStack = event.getPoseStack();
        double d0 = Mth.lerp(renderTick, player.xOld, player.getX()) - camera.getPosition().x;
        double d1 = Mth.lerp(renderTick, player.yOld, player.getY()) - camera.getPosition().y;
        double d2 = Mth.lerp(renderTick, player.zOld, player.getZ()) - camera.getPosition().z;
        poseStack.pushPose();
        poseStack.translate(d0, d1, d2);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new LeveRenderLivingEntityPostEvent(player,levelRenderer,bufferSource,event.getPartialTick(),poseStack,camera));
        poseStack.popPose();
        bufferSource.endBatch();
    }


}
