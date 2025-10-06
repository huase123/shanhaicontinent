
package hua.huase.shanhaicontinent.potion;

import hua.huase.shanhaicontinent.capability.AttrubuteAPI;
import hua.huase.shanhaicontinent.event.api.LeveRenderPlaerEventPostEvent;
import hua.huase.shanhaicontinent.init.SHModMobEffectsinit;
import hua.huase.shanhaicontinent.render.SHRenderApi;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.entity.EntityTypeTest;

import java.util.List;
import java.util.Map;


public class Jineng_jgb_7 extends SHBaseMobEffect implements PotionAnimation{

	private static final ResourceLocation POLAR_BEAR_TEXTURE = new ResourceLocation("shanhaicontinent:textures/jineng/jingubangdzsy.png");

	public Jineng_jgb_7() {
		super(MobEffectCategory.BENEFICIAL);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {


		if(!entity.level().isClientSide && entity.level().getGameTime()%100==0){
			++amplifier;
			if(1000-amplifier*100>0){
				entity.removeEffect(SHModMobEffectsinit.jineng_jgb_7.get());
				entity.addEffect(new MobEffectInstance(SHModMobEffectsinit.jineng_jgb_7.get(), 1000-amplifier*100, amplifier));
			}
		}

		if(entity.level().getGameTime()%10==0){
			List<LivingEntity> nearbyEntities = entity.level().getEntities(EntityTypeTest.forClass(LivingEntity.class), entity.getBoundingBox().inflate(10,6,10), Entity::isAlive);
			for (LivingEntity nearbyEntity : nearbyEntities) {
				if(nearbyEntity.getId() != entity.getId()){
					nearbyEntity.hurt(entity.damageSources().playerAttack((Player) entity), AttrubuteAPI.getWugong((entity))*0.05f);
					entity.level().playSound((Player)null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 0.5F, 1.0f);

					for(int i = 0; i < 8; ++i) {
						entity.level().addParticle(ParticleTypes.LAVA, nearbyEntity.getX(), nearbyEntity.getY(), nearbyEntity.getZ(), 0.0D, 0.0D, 0.0D);
					}
				}
			}

		}
	}


	@Override
	public float getWugong(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		int amplifier = mobEffectMobEffectInstanceEntry.getValue().getAmplifier();
		return amplifier*1000;
	}

	@Override
	public float getBaojishanghai(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		int amplifier = mobEffectMobEffectInstanceEntry.getValue().getAmplifier();
		return 10*amplifier;
	}

	@Override
	public float getBaojilv(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		int amplifier = mobEffectMobEffectInstanceEntry.getValue().getAmplifier();
		return 5*amplifier;
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void renderPlayer(LeveRenderPlaerEventPostEvent event) {
		SHRenderApi.renderdibu(event.getEntity().level().getGameTime()+event.getPartialTick(),event.getPoseStack(),1,POLAR_BEAR_TEXTURE);
		SHRenderApi.rendertian(event.getEntity().level().getGameTime()+event.getPartialTick(),event.getPoseStack(),1,POLAR_BEAR_TEXTURE,12);
	}


}
