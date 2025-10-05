package hua.huase.shanhaicontinent.event.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapability;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.event.api.LeveRenderPlaerEventPostEvent;
import hua.huase.shanhaicontinent.potion.PotionAnimation;
import hua.huase.shanhaicontinent.render.SHRenderApi;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;
import java.util.Map;

import static hua.huase.shanhaicontinent.SHMainBus.HUNHUAN;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PWRenderPlayerEvent {

    /**
     * 注入自定义事件
     * @see LeveRenderPlaerEventPostEvent
     */
    @SubscribeEvent
    public static void renderPlayerEventPost(RenderLevelStageEvent event) {
        if (event.getStage() !=RenderLevelStageEvent.Stage.AFTER_ENTITIES )return;
        LocalPlayer player = Minecraft.getInstance().player;
        LevelRenderer levelRenderer = event.getLevelRenderer();
        float renderTick =Minecraft.getInstance().getPartialTick();
        Camera camera = event.getCamera();
        PoseStack poseStack = event.getPoseStack();
        double d0 = Mth.lerp((double)renderTick, player.xOld, player.getX()) - camera.getPosition().x;
        double d1 = Mth.lerp((double)renderTick, player.yOld, player.getY()) - camera.getPosition().y;
        double d2 = Mth.lerp((double)renderTick, player.zOld, player.getZ()) - camera.getPosition().z;
        float f = Mth.lerp(renderTick, player.yRotO, player.getYRot());
        poseStack.pushPose();
        poseStack.translate(d0, d1, d2);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new LeveRenderPlaerEventPostEvent(player,levelRenderer,event.getPartialTick(),poseStack));
        poseStack.popPose();
    }

    @SubscribeEvent
    public static void renderPlayerEventPost(LeveRenderPlaerEventPostEvent event) {

        renderHunhuan(event.getPlayer(), event.getPartialTick(), event.getPoseStack(),
                100, 1);
    }



    //    @SubscribeEvent
    public static void renderPlayerEventPre(RenderPlayerEvent.Pre event){

    }

//    @SubscribeEvent
    public static void onRenderLevelStageEvent(RenderLevelStageEvent event){
        if(event.getStage() == RenderLevelStageEvent.Stage.AFTER_LEVEL){
            LocalPlayer player = Minecraft.getInstance().player;
            player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
                int count = 0;
                if(capability.getWuhunList() != null){
                    PoseStack poseStack = event.getPoseStack();
                    float partialTick = event.getPartialTick();

                    for (MonsterAttributeCapability monsterAttributeCapability : capability.getWuhunList()) {
//                    renderHandHunhuan(player, event.getPartialTick(),event.getPoseStack(),monsterAttributeCapability.getNianxian(),count);
                        renderHandHunhuan(player, partialTick,poseStack,monsterAttributeCapability.getNianxian(),count);
                        count++;
                    }


                }
            });
        }

    }


//    @SubscribeEvent
    public static void onRenderHandEvent(RenderHandEvent event){
        LocalPlayer player = Minecraft.getInstance().player;
        if(event.getHand() != InteractionHand.MAIN_HAND){
            return;
        }

        player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
                int count = 0;
            if(capability.getWuhunList() != null){
                PoseStack poseStack = event.getPoseStack();
                float partialTick = event.getPartialTick();



                for (MonsterAttributeCapability monsterAttributeCapability : capability.getWuhunList()) {
//                    renderHandHunhuan(player, event.getPartialTick(),event.getPoseStack(),monsterAttributeCapability.getNianxian(),count);
                    renderHandHunhuan(player, partialTick,poseStack,monsterAttributeCapability.getNianxian(),count);
                    count++;
                }


                }
            });
    }

    private static void renderHandHunhuan(LocalPlayer player, float partialTick, PoseStack poseStack, int nianxian, int count) {

        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        RenderSystem.depthMask(true);
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        poseStack.pushPose();


        RenderSystem.setShaderTexture(0, HUNHUAN);

        Matrix4f matrix4f = poseStack.last().pose();


//        Quaternionf quaternionf = Minecraft.getInstance().getEntityRenderDispatcher().cameraOrientation();
//        poseStack.mulPose(quaternionf.rotateXYZ((float) Math.PI, (float) Math.PI, (float) Math.PI));
//        poseStack.mulPose(new Quaternionf(-quaternionf.x(),-quaternionf.y(),-quaternionf.z(),-quaternionf.w()));




//        渲染动画
        renderAnimation(matrix4f,nianxian,(player.level().getGameTime()+partialTick),count);
//            渲染属性
        renderHunhuanscale(matrix4f,nianxian,(player.level().getGameTime()+partialTick),count);
        renderHunhuanColor(matrix4f,nianxian,(player.level().getGameTime()+partialTick),count);

        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix4f, (float)0-6, 0.1f, (float)0-6).uv(0, 0).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0-6, 0.1f, (float)0+6).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+6, 0.1f, (float)0+6).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+6, 0.1f, (float)0-6).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+6, 0.1f, (float)0-6).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+6, 0.1f, (float)0+6).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0-6, 0.1f, (float)0+6).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0-6, 0.1f, (float)0-6).uv(0, 0).endVertex();
        BufferUploader.drawWithShader(bufferbuilder.end());
        poseStack.popPose();
        RenderSystem.depthMask(false);
        RenderSystem.disableDepthTest();
        RenderSystem.disableBlend();

        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f,1.0f);
    }


    @SubscribeEvent
    public static void renderPlayerEventPost(RenderPlayerEvent.Post event){
        PoseStack poseStack = event.getPoseStack();
        Player entity = event.getEntity();
        if(entity !=null){
            entity.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
                int count = 0;
                if(capability.getWuhunList() != null){
                    for (MonsterAttributeCapability monsterAttributeCapability : capability.getWuhunList()) {
                        renderHunhuan(entity, event.getPartialTick(),poseStack,monsterAttributeCapability.getNianxian(),count);
                        count++;
                    }
                }
            });
        }


        if(entity !=null) {
            for (MobEffectInstance activeEffect : entity.getActiveEffects()) {

                if (activeEffect.getEffect() instanceof PotionAnimation potionAnimation) {
                    potionAnimation.renderPlayer(event);
                }
            }


            Map<MobEffect, MobEffectInstance> activeEffectsMap = entity.getActiveEffectsMap();
            for (Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry : activeEffectsMap.entrySet()) {
                if (mobEffectMobEffectInstanceEntry.getKey() instanceof PotionAnimation potionAnimation) {
                    potionAnimation.renderPlayer(event);
                }
            }
        }
    }


    public static void renderHunhuan(Entity entity, float partialTick, PoseStack poseStack, int nianxian, int count){

        SHRenderApi.renderStart(HUNHUAN,poseStack);

        Matrix4f matrix4f = poseStack.last().pose();
//        渲染动画
        renderAnimation(matrix4f,nianxian,(entity.level().getGameTime()+partialTick),count);
//            渲染属性
        renderHunhuanscale(matrix4f,nianxian,(entity.level().getGameTime()+partialTick),count);
        renderHunhuanColor(matrix4f,nianxian,(entity.level().getGameTime()+partialTick),count);

        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix4f, (float)0-6, 0.1f, (float)0-6).uv(0, 0).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0-6, 0.1f, (float)0+6).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+6, 0.1f, (float)0+6).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+6, 0.1f, (float)0-6).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+6, 0.1f, (float)0-6).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0+6, 0.1f, (float)0+6).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0-6, 0.1f, (float)0+6).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, (float)0-6, 0.1f, (float)0-6).uv(0, 0).endVertex();
        BufferUploader.drawWithShader(bufferbuilder.end());
        SHRenderApi.renderEnd(poseStack);

    }

    private static void renderAnimation(Matrix4f matrix4f, int nianxian, float partialTick, int count) {
        matrix4f.rotate((float)Math.PI*0.005f*(partialTick)*(count%2==0? -1:1), 0.0F, 1.0F, 0.0F);
        matrix4f.translate(0,0.01f*count,0);
    }

    private static void renderHunhuanColor(Matrix4f matrix4f, int nianxian, float partialTick, int count) {
        if(nianxian>=1000000){
            RenderSystem.setShaderColor(1.0f, 0.6f, 0.1f,0.8f);
        }else if(nianxian>=100000){
            RenderSystem.setShaderColor(1.0f, 0, 0,0.6f);

        }else if(nianxian>=10000){
            RenderSystem.setShaderColor(0, 0f, 0,0.6f);
        }else if(nianxian>=1000){
            RenderSystem.setShaderColor(1.0f, 0f, 1.0f,0.4f);
        }else if(nianxian>=100){
            RenderSystem.setShaderColor(1.0f, 1.0f, 0,0.4f);
        }else if(nianxian>=1){
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f,0.8f);
        }
    }

    private static void renderHunhuanscale(Matrix4f matrix4f, int nianxian, float partialTick, int count) {
        matrix4f.scale(0.4f+count*0.12f,1, 0.4f+count*0.12f);
        matrix4f.scale(1.0f+(float) Math.sin(partialTick*0.01f)*0.15f,1, 1.0f+(float) Math.sin(partialTick*0.01f)*0.15f);
    }


}
