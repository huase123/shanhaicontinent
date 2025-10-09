package hua.huase.shanhaicontinent.potion;

import hua.huase.shanhaicontinent.event.api.LeveRenderLivingEntityPostEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

import java.util.Map;

public class Jineng_huang_6 extends SHBaseMobEffect  implements PotionAnimation{
    public Jineng_huang_6() {
        super(MobEffectCategory.BENEFICIAL);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {

    }

    @Override
    public float getWugong(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
        return 99;
    }
    @Override
    public float getWufang(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
        return 99;
    }
    @Override
    public float getBaojishanghai(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
        return 10;
    }
    @Override
    public float getBaojilv(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
        return 10;
    }
    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return false;
    }

    @Override
    public void renderPlayer(LeveRenderLivingEntityPostEvent event) {

    }

    public void chufaEvent(LivingEntity livingEntity, LivingDamageEvent event) {
        livingEntity.setHealth(livingEntity.getMaxHealth());
        event.setAmount(0);
        livingEntity.level().broadcastEntityEvent(livingEntity, (byte)35);
    }
}