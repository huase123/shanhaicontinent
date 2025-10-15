
package hua.huase.shanhaicontinent.potion;

import hua.huase.shanhaicontinent.capability.AttrubuteAPI;
import hua.huase.shanhaicontinent.event.api.LeveRenderLivingEntityPostEvent;
import hua.huase.shanhaicontinent.render.SHRenderApi;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.entity.EntityTypeTest;

import java.util.List;


public class Jineng_htsc_5 extends SHBaseMobEffect  implements PotionAnimation{
	private static final ResourceLocation POLAR_BEAR_TEXTURE = new ResourceLocation("shanhaicontinent:textures/jineng/haotianchui_5.png");

	public Jineng_htsc_5() {
		super(MobEffectCategory.BENEFICIAL);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {


		if(entity.level().getGameTime()%10==0){
			List<LivingEntity> nearbyEntities = entity.level().getEntities(EntityTypeTest.forClass(LivingEntity.class), entity.getBoundingBox().inflate(8,5,8), Entity::isAlive);
			for (LivingEntity nearbyEntity : nearbyEntities) {
				if(nearbyEntity.getId() != entity.getId()){
					nearbyEntity.hurt(entity.damageSources().mobAttack( entity), 3);
					entity.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 0.5F, 1.0f);

					for(int i = 0; i < 8; ++i) {
						entity.level().addParticle(ParticleTypes.LAVA, nearbyEntity.getX(), nearbyEntity.getY(), nearbyEntity.getZ(), 0.0D, 0.0D, 0.0D);
					}
				}
			}

		}
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public void renderPlayer(LeveRenderLivingEntityPostEvent event) {
		SHRenderApi.renderdibu(event.getEntity().level().getGameTime()+event.getPartialTick(),event.getPoseStack(),1,POLAR_BEAR_TEXTURE);
		SHRenderApi.rendertian(event.getEntity().level().getGameTime()+event.getPartialTick(),event.getPoseStack(),1,POLAR_BEAR_TEXTURE,12);
	}


}
