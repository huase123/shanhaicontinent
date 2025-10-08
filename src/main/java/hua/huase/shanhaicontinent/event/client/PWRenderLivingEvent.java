package hua.huase.shanhaicontinent.event.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapability;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.render.SHRenderApi;
import hua.huase.shanhaicontinent.render.SHRenderType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

import static hua.huase.shanhaicontinent.SHMainBus.HUNHUAN;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PWRenderLivingEvent {


    @SubscribeEvent
    public static void renderLivingEventPost(RenderLivingEvent.Post event){
        if(event.getEntity() == null)return;
        event.getEntity().getCapability(MonsterAttributeCapabilityProvider.CAPABILITY).ifPresent(monsterAttributeCapability -> {
            VertexConsumer bufferbuilder = event.getMultiBufferSource().getBuffer(SHRenderType.render_Material(HUNHUAN));
            int nianxian = monsterAttributeCapability.getNianxian();
            float size1 = (float) event.getEntity().getBoundingBox().getSize();
            float size =1+ size1*2f;
            SHRenderApi.renderHunhuan(nianxian,size,event.getPoseStack(),bufferbuilder,event.getPartialTick(),false);
        });

    }


    public static void renderHunhuan(Entity entity,float partialTick,PoseStack poseStack,int nianxian){

        SHRenderApi.renderStart(HUNHUAN,poseStack);

            Matrix4f matrix4f = poseStack.last().pose();
            matrix4f.rotate((float)Math.PI*0.01f*(entity.level().getGameTime()+partialTick), 0.0F, 1.0F, 0.0F);
//            matrix4f.rotate((float)Math.PI*0.5f, 1.0F, 0.0F, 0.0F);
//            渲染属性
            renderHunhuanAttribute(matrix4f,nianxian,(entity.level().getGameTime()+partialTick));
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


    public static void renderHunhuanAttribute(Matrix4f matrix4f, int nianxian, float partialTick){
        if(nianxian>=1000000){
            RenderSystem.setShaderColor(1.0f, 0.6f, 0.1f,0.8f);
            matrix4f.scale(1.5f+(float) Math.sin(partialTick*0.02f)*0.15f,1, 1.5f+(float) Math.sin(partialTick*0.01f)*0.15f);
        }else if(nianxian>=100000){
            RenderSystem.setShaderColor(1.0f, 0, 0,0.6f);
            matrix4f.scale(1.18f, 1,1.18f);
        }else if(nianxian>=10000){
            RenderSystem.setShaderColor(0f, 0f, 0f,0.8f);
            matrix4f.scale(0.9f, 1,0.9f);
        }else if(nianxian>=1000){
            RenderSystem.setShaderColor(1.0f, 0f, 1.0f,0.4f);
            matrix4f.scale(0.76f, 1,0.76f);
        }else if(nianxian>=100){
            RenderSystem.setShaderColor(1.0f, 1.0f, 0,0.4f);
            matrix4f.scale(0.60f, 1, 0.60f);
        }else if(nianxian>=1){
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f,0.8f);
            matrix4f.scale(0.4f,1, 0.4f);
        }

    }
}
