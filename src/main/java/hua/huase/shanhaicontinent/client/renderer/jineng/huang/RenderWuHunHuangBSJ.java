package hua.huase.shanhaicontinent.client.renderer.jineng.huang;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class RenderWuHunHuangBSJ extends RenderEntity {

    private static final ResourceLocation LIGHTNING_TEXTURE = new ResourceLocation("textures/entity/creeper/creeper_armor.png");

    private static final ResourceLocation POLAR_BEAR_TEXTURE = new ResourceLocation("shanhaicontinent:textures/jineng/jingubang/bang.png");
    public static Map<Integer, Integer> timemap=new HashMap();

    private static final ItemStack item = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":wuhunhuangkpbs")));
public RenderWuHunHuangBSJ(RenderManager renderManager) {
        super(renderManager);
    }


    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {


//        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)15728880%65536, (float)15728880/ 65536);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferbuilder.pos(-1, 10, 0).color(1, 0.2F, 0.2F, 1f).endVertex();
         bufferbuilder.pos(1, 10, 0).color(1, 0.2F, 0.2F, 1f).endVertex();
          bufferbuilder.pos(1, 2, 0).color(1, 0.2F, 0.2F, 1f).endVertex();
         bufferbuilder.pos(-1, 2, 0).color(1, 0.2F, 0.2F, 1f).endVertex();

         bufferbuilder.pos(-1, 2, 0).color(1, 0.2F, 0.2F, 1f).endVertex();
          bufferbuilder.pos(1, 2, 0).color(1, 0.2F, 0.2F, 1f).endVertex();
          bufferbuilder.pos(0, 1, 0).color(1, 0.2F, 0.2F, 1f).endVertex();
          bufferbuilder.pos(0, 1, 0).color(1, 0.2F, 0.2F, 1f).endVertex();
        tessellator.draw();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();






    }




    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return POLAR_BEAR_TEXTURE;
    }



}
