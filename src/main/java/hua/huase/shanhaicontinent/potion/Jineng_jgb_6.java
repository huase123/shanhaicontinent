
package hua.huase.shanhaicontinent.potion;

import com.mojang.blaze3d.vertex.PoseStack;
import hua.huase.shanhaicontinent.event.api.LeveRenderPlaerEventPostEvent;
import hua.huase.shanhaicontinent.init.ItemInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import java.util.Map;


public class Jineng_jgb_6 extends SHBaseMobEffect implements PotionAnimation {
	public Jineng_jgb_6() {
		super(MobEffectCategory.BENEFICIAL);
	}

	@Override
	public float getWugong(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		return 3000;
	}
	@Override
	public float getBaojishanghai(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		return 50;
	}
	@Override
	public float getBaojilv(LivingEntity livingEntity, Map.Entry<MobEffect, MobEffectInstance> mobEffectMobEffectInstanceEntry, float value) {
		return 20;
	}


	private static ItemStack itemStack;
	@Override
	public void renderPlayer(LeveRenderPlaerEventPostEvent event) {

		Player entity = event.getEntity();
		PoseStack poseStack = event.getPoseStack();
//		if(itemStack)
		ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
		if(itemStack == null){
			itemStack = new ItemStack(ItemInit.jineng_jgb_0.get());
		}

		poseStack.pushPose();
		poseStack.last().pose().rotate((float)Math.PI*0.225f, 0.0F, 0.0F, 1.0F);
		poseStack.translate(-1.0f, 1.0f, -1.0f);
		poseStack.scale(5f, 5f, 5f);
//		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 0.02F);
		itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, 15728880,
				OverlayTexture.NO_OVERLAY, poseStack, event.getMultiBufferSource(), entity.level(), 1);
		poseStack.popPose();
	}
}
