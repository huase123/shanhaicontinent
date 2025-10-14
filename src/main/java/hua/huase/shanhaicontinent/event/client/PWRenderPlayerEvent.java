package hua.huase.shanhaicontinent.event.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapability;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.event.api.LeveRenderLivingEntityPostEvent;
import hua.huase.shanhaicontinent.potion.PotionAnimation;
import hua.huase.shanhaicontinent.render.SHRenderApi;
import hua.huase.shanhaicontinent.render.SHRenderType;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.*;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

import java.util.Map;

import static hua.huase.shanhaicontinent.SHMainBus.HUNHUAN;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PWRenderPlayerEvent {
    @SubscribeEvent
    public static void renderPlayerEventPost(LeveRenderLivingEntityPostEvent event){
        LivingEntity livingEntity = event.getEntity();
        PoseStack poseStack = event.getPoseStack();
        MultiBufferSource.BufferSource multiBufferSource = event.getMultiBufferSource();
        Camera camera = event.getCamera();
        float partialTick = event.getPartialTick();
        if(livingEntity instanceof Player player){
            renderPlayerHunhuan(player, poseStack,multiBufferSource,camera,partialTick);
        }else {
            renderLivingEntityHunhuan(livingEntity, poseStack,multiBufferSource,camera,partialTick);
        }



        if(livingEntity !=null) {
            for (MobEffectInstance activeEffect : livingEntity.getActiveEffects()) {
                if (activeEffect.getEffect() instanceof PotionAnimation potionAnimation) {
                    potionAnimation.renderPlayer(event);
                }
            }
        }
    }

    private static void renderLivingEntityHunhuan(LivingEntity livingEntity, PoseStack poseStack, MultiBufferSource.BufferSource multiBufferSource, Camera camera, float partialTick) {
        livingEntity.getCapability(MonsterAttributeCapabilityProvider.CAPABILITY).ifPresent(monsterAttributeCapability -> {
            VertexConsumer bufferbuilder = multiBufferSource.getBuffer(SHRenderType.render_Material(HUNHUAN));
            int nianxian = monsterAttributeCapability.getNianxian();
            float size1 = (float)livingEntity.getBoundingBox().getSize();
            float size =1+ size1*2f;
            SHRenderApi.renderHunhuan(nianxian,size,poseStack,bufferbuilder,partialTick,false);
        });
    }

    private static void renderPlayerHunhuan(Player player, PoseStack poseStack, MultiBufferSource.BufferSource multiBufferSource, Camera camera, float partialTick) {
        player.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).ifPresent(capability -> {
            ItemStack stackInSlot = capability.getWuhun().getStackInSlot(0);
            if(stackInSlot.isEmpty())return;
            stackInSlot.getCapability(RegisterCapabilitys.WUHUNCAPABILITY).ifPresent(c->{
                ItemStack stackInSlot1 = c.getHunjilist().getStackInSlot(0);
                if(stackInSlot1.isEmpty())return;
                stackInSlot1.getCapability(RegisterCapabilitys.HUNHUANCAPABILITY).ifPresent(c1->{

                    VertexConsumer bufferbuilder = multiBufferSource.getBuffer(SHRenderType.render_Material(HUNHUAN));
                    int nianxian = c1.getNianxian();
                    float size =2.0f;
                    SHRenderApi.renderHunhuan(nianxian,size,poseStack,bufferbuilder,partialTick,true);

                });
            });
        });
//        player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
//            if(capability.getWuhunList() == null)return;
//            VertexConsumer bufferbuilder = multiBufferSource.getBuffer(SHRenderType.render_Material(HUNHUAN));
//            int count = 1;
//            int size1 = capability.getWuhunList().size();
//            for (MonsterAttributeCapability monsterAttributeCapability : capability.getWuhunList()) {
//                int nianxian = monsterAttributeCapability.getNianxian();
//                float size =2.0f-size1/9.0f*1.5f+count*count*0.15f;
//                SHRenderApi.renderHunhuan(nianxian,size,poseStack,bufferbuilder,partialTick,count%2==0);
//                count++;
//            }
//        });
    }



//    @SubscribeEvent
    public static void onRenderHandEvent(RenderHandEvent event){

    }
}
