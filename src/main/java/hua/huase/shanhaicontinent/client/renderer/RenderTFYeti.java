package hua.huase.shanhaicontinent.client.renderer;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;

public class RenderTFYeti extends RenderTFBiped<EntityLiving> {
	public RenderTFYeti(RenderManager manager, ModelBiped modelBiped, String textureName) {
		super(manager, modelBiped, 1, textureName);
	}

	@Override
	protected void preRenderCallback(EntityLiving living, float partialTicks) {
		float scale = 1.0F;
		GlStateManager.scale(scale, scale, scale);
	}
}
