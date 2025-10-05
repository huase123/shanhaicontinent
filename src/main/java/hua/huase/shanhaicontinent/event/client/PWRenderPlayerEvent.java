package hua.huase.shanhaicontinent.event.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapability;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.event.api.LeveRenderPlaerEventPostEvent;
import hua.huase.shanhaicontinent.network.NetworkHandler;
import hua.huase.shanhaicontinent.network.client.SyncWuhunDataPacket;
import hua.huase.shanhaicontinent.render.SHRenderApi;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PacketDistributor;
import org.joml.Matrix4f;


import java.util.*;
import java.util.List;

import static hua.huase.shanhaicontinent.SHMainBus.HUNHUAN;
//玩家的魂环渲染
@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PWRenderPlayerEvent {
    private static final int ANIMATION_DURATION = 80;
    private static final int ANIMATION_DELAY_PER_RING = 15;

    private static final Map<Player, Long> playerShenhuanAnimationStartTime = new HashMap<>();


    private static final ResourceLocation SHENHUAN = new ResourceLocation(SHMainBus.MOD_ID,"textures/picture/shenhuan.png");
    private static final ResourceLocation HUNHUAN = new ResourceLocation(SHMainBus.MOD_ID, "textures/picture/particletext.png");


    private static final Map<Player, Long> playerOpenAnimationStartTime = new HashMap<>();
    private static final Map<Player, Boolean> playerIsPlayingOpenAnimation = new HashMap<>();
    private static final Map<UUID, List<Integer>> otherPlayerWuhunData = new HashMap<>();
    private static final Map<UUID, Boolean> otherPlayerIsPlayingOpenAnimation = new HashMap<>();
    private static final Map<UUID, Long> otherPlayerAnimationStartTime = new HashMap<>();


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


    public static void updatePlayerWuhunData(Player player, List<Integer> wuhunNianxianList,
                                             boolean isPlayingAnimation, long animationStartTime) {
        if (wuhunNianxianList.isEmpty()) {
            otherPlayerWuhunData.remove(player.getUUID());
            otherPlayerIsPlayingOpenAnimation.remove(player.getUUID());
            otherPlayerAnimationStartTime.remove(player.getUUID());
        } else {
            otherPlayerWuhunData.put(player.getUUID(), wuhunNianxianList);
            otherPlayerIsPlayingOpenAnimation.put(player.getUUID(), isPlayingAnimation);
            otherPlayerAnimationStartTime.put(player.getUUID(), animationStartTime);
        }
    }

    public static void startOpenAnimation(Player player) {
        long currentTime = player.level().getGameTime();
        playerOpenAnimationStartTime.put(player, currentTime);
        playerIsPlayingOpenAnimation.put(player, true);

        playerShenhuanAnimationStartTime.put(player, currentTime + 9 * ANIMATION_DELAY_PER_RING + ANIMATION_DURATION);

        if (!player.level().isClientSide) {
            player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
                List<Integer> nianxianList = new ArrayList<>();
                if (capability.getWuhunList() != null) {
                    for (MonsterAttributeCapability wuhun : capability.getWuhunList()) {
                        if (wuhun != null) {
                            nianxianList.add(wuhun.getNianxian());
                        }
                    }
                }
                SyncWuhunDataPacket packet = new SyncWuhunDataPacket(player.getUUID(), nianxianList, true, currentTime);
                for (ServerPlayer serverPlayer : ((ServerLevel)player.level()).getPlayers(p -> true)) {
                    NetworkHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> serverPlayer), packet);
                }
            });
        }
    }

    public static boolean isPlayingOpenAnimation(Player player) {
        if (player.level().isClientSide) {
            return player.equals(Minecraft.getInstance().player) ?
                    playerIsPlayingOpenAnimation.getOrDefault(player, false) :
                    otherPlayerIsPlayingOpenAnimation.getOrDefault(player.getUUID(), false);
        }
        return false;
    }

    public static float getAnimationProgress(Player player, int ringIndex, int totalRingCount) {
        if (player.equals(Minecraft.getInstance().player)) {
            if (!isPlayingOpenAnimation(player)) return 1f;

            long startTime = playerOpenAnimationStartTime.getOrDefault(player, 0L);
            long currentTime = player.level().getGameTime();
            long ringStartTime = startTime + ringIndex * ANIMATION_DELAY_PER_RING;

            if (currentTime < ringStartTime) return 0f;

            float progress = Math.min(1f, Math.max(0f, (float)(currentTime - ringStartTime) / ANIMATION_DURATION));

            if (progress >= 1f && ringIndex == totalRingCount - 1) {
                playerIsPlayingOpenAnimation.put(player, false);
            }

            return progress;
        } else {
            if (!isPlayingOpenAnimation(player)) return 1f;

            long startTime = otherPlayerAnimationStartTime.getOrDefault(player.getUUID(), 0L);
            long currentTime = Minecraft.getInstance().level.getGameTime();
            long ringStartTime = startTime + ringIndex * ANIMATION_DELAY_PER_RING;

            if (currentTime < ringStartTime) return 0f;

            return Math.min(1f, Math.max(0f, (float)(currentTime - ringStartTime) / ANIMATION_DURATION));
        }
    }

private static void renderShenhuan(Entity entity, float partialTick, PoseStack poseStack, int nianxian, int count, int totalRingCount) {
    poseStack.pushPose();
    SHRenderApi.renderStart(SHENHUAN, poseStack);
    float progress = 1f;
    if (entity instanceof Player player && isPlayingOpenAnimation(player)) {
        progress = getAnimationProgress(player, count, totalRingCount);
    }
    float bodyYaw = entity.getYRot();
    float yawRad = (float) Math.toRadians(bodyYaw);
    float backX = Mth.sin(yawRad);
    float backZ = -Mth.cos(yawRad);
    float currentY = 1.0f;
    float zOffset = 0.6f + (count - 9) * 0.15f;
    poseStack.translate(backX * zOffset * progress, currentY, backZ * zOffset * progress);
    poseStack.mulPose(Axis.YP.rotationDegrees(-bodyYaw + 180f));
    poseStack.mulPose(Axis.XP.rotationDegrees(90));
    float rotationSpeed = 0.6f;
    float rotationAngle = (entity.level().getGameTime() + partialTick) * rotationSpeed;
    poseStack.mulPose(Axis.YP.rotationDegrees(rotationAngle));
    float scale = 0.22f * progress;
    poseStack.scale(scale, scale, scale);
    Matrix4f matrix4f = poseStack.last().pose();
    if (progress >= 1f) {
        renderHunhuanscale(matrix4f, nianxian, (entity.level().getGameTime() + partialTick), count);
    }
    renderShenhuanColor(matrix4f, nianxian, (entity.level().getGameTime() + partialTick), count);
    // 绘制
    BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
    bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
    bufferbuilder.vertex(matrix4f, -5f, 0.1f, -5f).uv(0, 0).endVertex();
    bufferbuilder.vertex(matrix4f, -5f, 0.1f, 5f).uv(0, 1).endVertex();
    bufferbuilder.vertex(matrix4f, 5f, 0.1f, 5f).uv(1, 1).endVertex();
    bufferbuilder.vertex(matrix4f, 5f, 0.1f, -5f).uv(1, 0).endVertex();
    BufferUploader.drawWithShader(bufferbuilder.end());
    SHRenderApi.renderEnd(poseStack);
    poseStack.popPose();
}

    private static void renderShenhuanColor(Matrix4f matrix4f, int nianxian, float partialTick, int count) {
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        float alpha = 0.8f;
        if (nianxian >= 10000000) {
            RenderSystem.setShaderColor(0.0f, 0.8f, 1.0f, alpha);
        } else if(nianxian >= 1000000) {
            RenderSystem.setShaderColor(1.0f, 0.8f, 0.0f, alpha);
        } else if(nianxian >= 100000) {
            RenderSystem.setShaderColor(1.0f, 0.0f, 0.0f, alpha);
        } else if(nianxian >= 10000) {
            RenderSystem.setShaderColor(0.1f, 0.1f, 0.1f, alpha);
        } else if(nianxian >= 1000) {
            RenderSystem.setShaderColor(0.8f, 0.0f, 0.8f, alpha);
        } else if(nianxian >= 100) {
            RenderSystem.setShaderColor(1.0f, 1.0f, 0.0f, alpha);
        } else {
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, alpha);
        }
    }

    @SubscribeEvent
    public static void renderPlayerEventPost(RenderPlayerEvent.Post event) {
        PoseStack poseStack = event.getPoseStack();
        Player entity = event.getEntity();
        if (entity == null) return;

        if (entity.equals(Minecraft.getInstance().player)) {
            entity.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
                if (capability.getHunhuankuaiguan() >= 0 &&
                        capability.getWuhunList() != null &&
                        !capability.getWuhunList().isEmpty()) {

                    boolean isAnimating = isPlayingOpenAnimation(entity);
                    int totalRingCount = capability.getWuhunList().size();
                    for (int count = 0; count < Math.min(9, totalRingCount); count++) {
                        MonsterAttributeCapability wuhun = capability.getWuhunList().get(count);
                        if (wuhun != null) {
                            if (isAnimating) {
                                renderHunhuanWithAnimation(entity, event.getPartialTick(), poseStack,
                                        wuhun.getNianxian(), count, totalRingCount);
                            } else {
                                renderHunhuan(entity, event.getPartialTick(), poseStack,
                                        wuhun.getNianxian(), count);
                            }
                        }
                    }
                    for (int count = 9; count < Math.min(20, totalRingCount); count++) {
                        MonsterAttributeCapability wuhun = capability.getWuhunList().get(count);
                        if (wuhun != null) {
                            if (isAnimating) {
                                renderShenhuan(entity, event.getPartialTick(), poseStack,
                                        wuhun.getNianxian(), count, totalRingCount);
                            } else {
                                renderShenhuan(entity, event.getPartialTick(), poseStack,
                                        wuhun.getNianxian(), count, totalRingCount);
                            }
                        }
                    }
                }
            });
        }
        else {
            if (!otherPlayerWuhunData.containsKey(entity.getUUID())) {
                return;
            }
            List<Integer> nianxianList = otherPlayerWuhunData.get(entity.getUUID());
            boolean isAnimating = otherPlayerIsPlayingOpenAnimation.getOrDefault(entity.getUUID(), false);
            if (nianxianList != null && !nianxianList.isEmpty()) {
                int totalRingCount = nianxianList.size();
                for (int count = 0; count < Math.min(9, totalRingCount); count++) {
                    int nianxian = nianxianList.get(count);
                    if (isAnimating) {
                        renderHunhuanWithAnimation(entity, event.getPartialTick(), poseStack,
                                nianxian, count, totalRingCount);
                    } else {
                        renderHunhuan(entity, event.getPartialTick(), poseStack,
                                nianxian, count);
                    }
                }
                for (int count = 9; count < Math.min(20, totalRingCount); count++) {
                    int nianxian = nianxianList.get(count);
                    if (isAnimating) {
                        renderShenhuan(entity, event.getPartialTick(), poseStack,
                                nianxian, count, totalRingCount);
                    } else {
                        renderShenhuan(entity, event.getPartialTick(), poseStack,
                                nianxian, count, totalRingCount);
                    }
                }
            }
        }
    }

    private static void renderHunhuan(Entity entity, float partialTick, PoseStack poseStack, int nianxian, int count){
        SHRenderApi.renderStart(HUNHUAN, poseStack);
        Matrix4f matrix4f = poseStack.last().pose();

        renderAnimation(matrix4f, nianxian, (entity.level().getGameTime()+partialTick), count);
        renderHunhuanscale(matrix4f, nianxian, (entity.level().getGameTime()+partialTick), count);
        renderHunhuanColor(matrix4f, nianxian, (entity.level().getGameTime()+partialTick), count);

        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix4f, -6f, 0.1f, -6f).uv(0, 0).endVertex();
        bufferbuilder.vertex(matrix4f, -6f, 0.1f, 6f).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, 6f, 0.1f, 6f).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, 6f, 0.1f, -6f).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, 6f, 0.1f, -6f).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, 6f, 0.1f, 6f).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, -6f, 0.1f, 6f).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, -6f, 0.1f, -6f).uv(0, 0).endVertex();
        BufferUploader.drawWithShader(bufferbuilder.end());
        SHRenderApi.renderEnd(poseStack);
    }

    private static void renderHunhuanWithAnimation(Entity entity, float partialTick, PoseStack poseStack, int nianxian, int count, int totalRingCount){
        SHRenderApi.renderStart(HUNHUAN, poseStack);
        Matrix4f matrix4f = poseStack.last().pose();

        float progress = 1f;
        if (entity instanceof Player player && isPlayingOpenAnimation(player)) {
            progress = getAnimationProgress(player, count, totalRingCount);
        }

        float currentY = 1.1f + (0.03f - 1.1f) * progress;
        float scale = (0.4f + count * 0.12f) * progress;

        matrix4f.translate(0, currentY, 0);
        matrix4f.scale(scale, 1f, scale);
        matrix4f.rotate((float)Math.PI*0.005f*(entity.level().getGameTime()+partialTick)*(count%2==0? -1:1), 0.0F, 1.0F, 0.0F);
        renderHunhuanColor(matrix4f, nianxian, (entity.level().getGameTime()+partialTick), count);

        BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex(matrix4f, -6f, 0.1f, -6f).uv(0, 0).endVertex();
        bufferbuilder.vertex(matrix4f, -6f, 0.1f, 6f).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, 6f, 0.1f, 6f).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, 6f, 0.1f, -6f).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, 6f, 0.1f, -6f).uv(1, 0).endVertex();
        bufferbuilder.vertex(matrix4f, 6f, 0.1f, 6f).uv(1, 1).endVertex();
        bufferbuilder.vertex(matrix4f, -6f, 0.1f, 6f).uv(0, 1).endVertex();
        bufferbuilder.vertex(matrix4f, -6f, 0.1f, -6f).uv(0, 0).endVertex();
        BufferUploader.drawWithShader(bufferbuilder.end());
        SHRenderApi.renderEnd(poseStack);
    }

    private static void renderAnimation(Matrix4f matrix4f, int nianxian, float partialTick, int count) {
        matrix4f.rotate((float)Math.PI*0.005f*partialTick*(count%2==0? -1:1), 0.0F, 1.0F, 0.0F);
        matrix4f.translate(0, 0.01f*count, 0);
    }

    private static void renderHunhuanColor(Matrix4f matrix4f, int nianxian, float partialTick, int count) {
        if (nianxian >= 10000000) {
            RenderSystem.setShaderColor(0.0f, 0.6f, 1.0f, 0.8f);
        } else if(nianxian >= 1000000) {
            RenderSystem.setShaderColor(1.0f, 0.6f, 0.1f, 0.8f);
        } else if(nianxian >= 100000) {
            RenderSystem.setShaderColor(1.0f, 0, 0, 0.6f);
        } else if(nianxian >= 10000) {
            RenderSystem.setShaderColor(0, 0f, 0, 0.6f);
        } else if(nianxian >= 1000) {
            RenderSystem.setShaderColor(1.0f, 0f, 1.0f, 0.4f);
        } else if(nianxian >= 100) {
            RenderSystem.setShaderColor(1.0f, 1.0f, 0, 0.4f);
        } else if(nianxian >= 1) {
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 0.8f);
        }
    }

    private static void renderHunhuanscale(Matrix4f matrix4f, int nianxian, float partialTick, int count) {
        matrix4f.scale(0.4f+count*0.12f, 1, 0.4f+count*0.12f);
        matrix4f.scale(1.0f+(float)Math.sin(partialTick*0.01f)*0.15f, 1, 1.0f+(float)Math.sin(partialTick*0.01f)*0.15f);
    }

    public static void sendCloseNotification(Player player) {
        if (!player.level().isClientSide) {
            SyncWuhunDataPacket packet = new SyncWuhunDataPacket(
                    player.getUUID(),
                    Collections.emptyList(),
                    false,
                    0L
            );

            for (ServerPlayer serverPlayer : ((ServerLevel)player.level()).getPlayers(p -> true)) {
                NetworkHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> serverPlayer), packet);
            }
        }
    }

    //加入游戏魂环同步
    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
                if (capability.getHunhuankuaiguan() >= 0) {
                    PWRenderPlayerEvent.startOpenAnimation(player);
                }
            });
        }
    }

    //进入维度魂环同步
    @SubscribeEvent
    public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
                if (capability.getHunhuankuaiguan() >= 0) {
                    PWRenderPlayerEvent.startOpenAnimation(player);
                }
            });
        }
    }

}