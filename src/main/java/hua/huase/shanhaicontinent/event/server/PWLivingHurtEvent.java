package hua.huase.shanhaicontinent.event.server;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capability.AttrubuteAPI;
import hua.huase.shanhaicontinent.capabilitys.CapabilityUtil;
import hua.huase.shanhaicontinent.capabilitys.capability.AttributeBase;
import hua.huase.shanhaicontinent.init.SHModMobEffectsinit;
import hua.huase.shanhaicontinent.potion.Jineng_huang_6;
import hua.huase.shanhaicontinent.potion.PotionAttribute;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

import static hua.huase.shanhaicontinent.SHMainBus.random;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PWLivingHurtEvent {
    @SubscribeEvent
    public static void livingHurtEvent(LivingHurtEvent event){
        LivingEntity directEntity = event.getEntity();
        if(directEntity == null)return;
        float amount = event.getAmount();
        DamageSource source = event.getSource();
        AttributeBase directcapability = CapabilityUtil.getCapability(directEntity);
        if(directcapability != null){
            amount = directcapability.Hurt(directEntity,source,amount);
        }
        event.setAmount(amount);
    }
    @SubscribeEvent
    public static void onLivingDamageEvent(LivingDamageEvent event){
        displayerDamage(event.getEntity(),event);
    }

    private static void displayerDamage(LivingEntity livingEntity, LivingDamageEvent event) {

        if(livingEntity.getHealth()-event.getAmount()<=0){
            Map<MobEffect, MobEffectInstance> activeEffectsMap = livingEntity.getActiveEffectsMap();
//            防止java.util.ConcurrentModificationException
            Boolean b = false;
            for (Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry : activeEffectsMap.entrySet()) {
                if(mobEffectMobEffectInstanceEntry.getKey() instanceof Jineng_huang_6 potionAttribute){
                    potionAttribute.chufaEvent(livingEntity,event);
                    b=true;
                }
            }
            if(b){
                livingEntity.removeEffect(SHModMobEffectsinit.jineng_huang_6.get());
            }
        }
    }

}
