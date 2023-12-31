package hua.huase.shanhaicontinent.client.renderer;

import hua.huase.shanhaicontinent.ExampleMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderTFBiped<T extends EntityLiving> extends RenderBiped<T> {

	private final ResourceLocation textureLoc;

	public RenderTFBiped(RenderManager manager, ModelBiped modelBiped, float shadowSize, String textureName) {
		super(manager, modelBiped, shadowSize);
		this.addLayer(new LayerBipedArmor(this));

		if (textureName.startsWith("textures")) {
			textureLoc = new ResourceLocation(textureName);
		} else {
			textureLoc = new ResourceLocation(ExampleMod.MODID, "textures/model/" + textureName);
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(T entity) {
		return textureLoc;
	}
}
