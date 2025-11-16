package hua.huase.shanhaicontinent.event.client;

import com.mojang.blaze3d.vertex.*;
import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.event.api.LeveRenderLivingEntityPostEvent;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PWRenderLivingEvent {


    @SubscribeEvent
    public static void renderLivingEventPost(RenderLivingEvent.Post event){
        LivingEntity entity = event.getEntity();
        if(entity == null)return;
        LevelRenderer levelRenderer = Minecraft.getInstance().levelRenderer;
        MultiBufferSource bufferSource =event.getMultiBufferSource();
        Camera camera = Minecraft.getInstance().gameRenderer.getMainCamera();
        PoseStack poseStack = event.getPoseStack();
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new LeveRenderLivingEntityPostEvent(entity,levelRenderer,bufferSource,event.getPartialTick(),poseStack,camera));
    }
}
