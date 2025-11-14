
package hua.huase.shanhaicontinent.potion;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import hua.huase.shanhaicontinent.event.api.LeveRenderLivingEntityPostEvent;
import hua.huase.shanhaicontinent.item.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;


public class Jineng_htsc_6 extends SHBaseMobEffect  implements PotionAnimation{
	public Jineng_htsc_6() {
		super(MobEffectCategory.BENEFICIAL);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {

	}

	@Override
	public float getWufang(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		return 20000;
	}

	@Override
	public float getShanbi(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		return 20;
	}
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

	private static ItemStack itemStack;
	@Override
	@OnlyIn(Dist.CLIENT)
	public void renderPlayer(LeveRenderLivingEntityPostEvent event) {

		if(itemStack == null){
			itemStack = new ItemStack(ItemInit.jineng_htsc_0.get());
		}

		PoseStack pPoseStack = event.getPoseStack();

		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		pPoseStack.pushPose();
		pPoseStack.translate(0,2,-1);
		pPoseStack.scale(5.0f, 5.0f, 5.0f);
		pPoseStack.mulPose(Axis.XP.rotationDegrees(180));
//		pPoseStack.mulPose(Axis.YP.rotationDegrees(3*(event.getEntity().level().getGameTime()+event.getPartialTick())));

//		pPoseStack.translate(0,0,2);

		itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, 15728880,
				OverlayTexture.NO_OVERLAY, pPoseStack, event.getMultiBufferSource(), event.getEntity().level(), 1);
		pPoseStack.popPose();

	}

}
