package hua.huase.shanhaicontinent.event.client;

import com.mojang.blaze3d.vertex.*;
import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.animation.AnimationControllerInstance;
import hua.huase.shanhaicontinent.animation.AnimationUtil;
import hua.huase.shanhaicontinent.animation.client.IClientMobAnimationExtensions;
import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.capabilitys.capability.HunhuanCapability;
import hua.huase.shanhaicontinent.event.api.LeveRenderLivingEntityPostEvent;
import hua.huase.shanhaicontinent.item.Hunhuan;
import hua.huase.shanhaicontinent.potion.PotionAnimation;
import hua.huase.shanhaicontinent.render.SHRenderApi;
import hua.huase.shanhaicontinent.render.SHRenderType;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemStackHandler;
import org.joml.Vector3f;

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
            AnimationControllerInstance animationControllerInstance =  AnimationUtil.getAnimationControllerInstance(livingEntity);
            if(animationControllerInstance != null && !animationControllerInstance.isover()){
                IClientMobAnimationExtensions of = IClientMobAnimationExtensions.of(animationControllerInstance);
                of.render(animationControllerInstance,livingEntity, poseStack,multiBufferSource,camera,partialTick);
            }

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
        livingEntity.getCapability(RegisterCapabilitys.MOSTERCAPABILITY).ifPresent(monstercapability -> {
            VertexConsumer bufferbuilder = multiBufferSource.getBuffer(SHRenderType.render_Material(HUNHUAN));
            ItemStackHandler hunhuanlist = monstercapability.getHunhuan();
            for (int i = 0; i < hunhuanlist.getSlots(); i++) {
                ItemStack hunhuan = hunhuanlist.getStackInSlot(i);
                if(!hunhuan.isEmpty() && hunhuan.getItem() instanceof Hunhuan){
                    HunhuanCapability hunhuanCapability = hunhuan.getCapability(RegisterCapabilitys.HUNHUANCAPABILITY).orElse(null);
                    if(hunhuanCapability ==null)return;
                    int nianxian = hunhuanCapability.getNianxian();
                    float size1 = (float)livingEntity.getBoundingBox().getSize();
                        float size2 =1+ size1*2f;
                    float size =size2+i*i*0.15f;
                    SHRenderApi.renderHunhuan(nianxian,size,poseStack,bufferbuilder,partialTick,false);
                }
            }
        });
    }

    private static void renderPlayerHunhuan(Player player, PoseStack poseStack, MultiBufferSource.BufferSource multiBufferSource, Camera camera, float partialTick) {
        player.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).ifPresent(capability -> {
            ItemStack stackInSlot = capability.getUseWuhun();
            if(stackInSlot.isEmpty())return;
            VertexConsumer bufferbuilder = multiBufferSource.getBuffer(SHRenderType.render_Material(HUNHUAN));
            stackInSlot.getCapability(RegisterCapabilitys.WUHUNCAPABILITY).ifPresent(c->{
                ItemStackHandler hunhuanlist = c.getHunhuanlist();
                for (int i = 0; i < hunhuanlist.getSlots(); i++) {
                    ItemStack hunhuan = hunhuanlist.getStackInSlot(i);
                    if(hunhuan.isEmpty())return;
                    HunhuanCapability hunhuanCapability = hunhuan.getCapability(RegisterCapabilitys.HUNHUANCAPABILITY).orElse(null);
                    if(hunhuanCapability == null)return;
                    int nianxian = hunhuanCapability.getNianxian();
                float size =2.0f-hunhuanlist.getSlots()/9.0f*1.5f+i*i*0.15f;
                SHRenderApi.renderHunhuan(nianxian,size,poseStack,bufferbuilder,partialTick,i%2==0);

                }
            });
        });
    }



//    @SubscribeEvent
    public static void onRenderHandEvent(RenderHandEvent event){

    }

    private static final Vector3f ANIMATION_VECTOR_CACHE = new Vector3f();
//    @SubscribeEvent
    public static void onRenderPlayerEvent(RenderPlayerEvent.Pre event){
//        event.getRenderer().getModel().body.z = -5;(float)pLivingBase.tickCount + pPartialTick;
        float v = (float) (event.getEntity().tickCount + event.getPartialTick());
//        long v = (long) event.getEntity().tickCount;
        v = v*100;
//        animate(event.getRenderer().getModel(), ModAnimationDefinitions.animation, (long) v,1.0f,ANIMATION_VECTOR_CACHE);
    }


}
