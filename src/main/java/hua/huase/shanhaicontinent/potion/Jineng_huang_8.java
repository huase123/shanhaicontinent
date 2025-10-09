
package hua.huase.shanhaicontinent.potion;

import hua.huase.shanhaicontinent.event.api.LeveRenderLivingEntityPostEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

import java.util.Map;


public class Jineng_huang_8 extends SHBaseMobEffect  implements PotionAnimation{
	public Jineng_huang_8() {
		super(MobEffectCategory.BENEFICIAL);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {

	}

	@Override
	public float getWugong(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		return 6666;
	}
	@Override
	public float getWufang(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		return 6666;
	}
	@Override
	public float getBaojishanghai(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		return 66;
	}
	@Override
	public float getBaojilv(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		return 66;
	}


	@Override
	public float getShengminghuifu(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		return value+66;
	}
	@Override
	public float getXixue(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		return value+66;
	}
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void renderPlayer(LeveRenderLivingEntityPostEvent event) {

	}
}
