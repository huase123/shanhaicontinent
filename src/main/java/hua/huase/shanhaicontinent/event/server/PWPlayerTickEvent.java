package hua.huase.shanhaicontinent.event.server;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.animation.AnimationControllerInstance;
import hua.huase.shanhaicontinent.animation.AnimationUtil;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapability;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttrubuteAPI;
import hua.huase.shanhaicontinent.entity.hunhuan.HunhuanEntityEntity;
import hua.huase.shanhaicontinent.network.SynsAPI;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PWPlayerTickEvent {

    @SubscribeEvent
    public static void onStartTracking(TickEvent.PlayerTickEvent event) {

        Player player = event.player;
        if(event.phase == TickEvent.Phase.END ) {
            updateAnimation(player);
        }
    }

    private static void updateAnimation(Player player) {
        AnimationControllerInstance animationControllerInstance =  AnimationUtil.getAnimationControllerInstance(player);
        if(animationControllerInstance != null && !animationControllerInstance.isover()){
            animationControllerInstance.tick();
        }
    }
//    @SubscribeEvent
//    public static void onStartTracking(TickEvent.PlayerTickEvent event) {
//        Player player = event.player;
//        if(event.phase == TickEvent.Phase.END){
//
//
//            if(!player.level().isClientSide){
//                if(player.level().getGameTime()%100==0){
//                    SynsAPI.synsPlayerAttribute(player);
//                }
//                float maxshengming = AttrubuteAPI.getMaxshengming(player);
//                if(maxshengming != player.getMaxHealth()){
//                    player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(maxshengming);
//                }
//
//
//                player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
//                    playerUpdateServere(player,capability);
//                });
//
//            }
//
//
//            player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
//                updatePlayerFly(player,capability);
//            });
//
//
//        }
//    }

    private static void updatePlayerFly(Player player, @NotNull PlayerAttributeCapability capability) {


        if(!player.isCreative() && !player.isSpectator()){


//            if(capability.getDengji()>=25  && PlayerAttrubuteAPI.getJingshenli(player)>200
            if(PlayerAttrubuteAPI.getMaxjingshenli(player)>3000){
                player.getAbilities().mayfly=true;
            }else {
                player.getAbilities().mayfly=false;
            }


            if(player.getAbilities().flying && player.level().getGameTime()%10 == 0){
                capability.setJingshenli(capability.getJingshenli()-30+ (float) capability.getDengji() /5);
            }
            if(capability.getWuhunName() !=null && player.level().getGameTime()%20 == 0){
                capability.setJingshenli(capability.getJingshenli()-25- (float) capability.getDengji() /5);
            }
        }

    }

    private static void playerUpdateServere(Player player, @NotNull PlayerAttributeCapability capability) {
        float jingshenli = PlayerAttrubuteAPI.getJingshenli(player);
        if(jingshenli<0){
            player.sendSystemMessage(Component.translatable("精神力不足").withStyle(ChatFormatting.GRAY));
            if(player.getVehicle() instanceof HunhuanEntityEntity){
                player.removeVehicle();
            }
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 2));
            player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, 2));
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 100, 2));
            player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 2));
            capability.setJingshenli(0);
            capability.setHunhuankuaiguan(-1);
            SynsAPI.synsPlayerAttribute(player);
        }

        if(player.level().getGameTime()%100 == 0){
            float shengminghuifu = PlayerAttrubuteAPI.getShengminghuifu(player);
            if(player.getHealth()<player.getMaxHealth() && shengminghuifu >0){
                player.heal(shengminghuifu);
            }
            float dengji = PlayerAttrubuteAPI.getDengji(player);

            float maxjingshenli = PlayerAttrubuteAPI.getMaxjingshenli(player);
            float jingshenli1 = capability.getJingshenli();
            if(jingshenli1<maxjingshenli && dengji>0 && capability.getHunhuankuaiguan()==-1){
                int dengji1 = capability.getDengji();
//                float v = jingshenli1 + (maxjingshenli * 0.01f * (1 + dengji1 / 80));
                float v = jingshenli1 + (10 * (0.5f + dengji1 / 80));
                capability.setJingshenli(Math.min(v,maxjingshenli));
            }

        }

    }
}
