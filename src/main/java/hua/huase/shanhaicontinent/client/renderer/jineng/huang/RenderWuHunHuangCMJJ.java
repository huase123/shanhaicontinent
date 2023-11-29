package hua.huase.shanhaicontinent.client.renderer.jineng.huang;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
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
public class RenderWuHunHuangCMJJ extends Render {

    private static final ResourceLocation LIGHTNING_TEXTURE = new ResourceLocation("textures/entity/creeper/creeper_armor.png");

    private static final ResourceLocation POLAR_BEAR_TEXTURE = new ResourceLocation("shanhaicontinent:textures/jineng/jingubang/bang.png");
    public static Map<Integer, Integer> timemap=new HashMap();

    private static final ItemStack item = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":wuhunhuangkpbs")));
public RenderWuHunHuangCMJJ(RenderManager renderManager) {
        super(renderManager);
    }


    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {


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
        bufferbuilder.pos(-1.5, 10, 0).color(0, 0.45F, 0.5F, 0.8f).endVertex();
         bufferbuilder.pos(1.5, 10, 0).color(0, 0.45F, 0.5F, 0.8f).endVertex();
          bufferbuilder.pos(1.5, 2, 0).color(0, 0.45F, 0.5F, 0.8f).endVertex();
         bufferbuilder.pos(-1.5, 2, 0).color(0, 0.45F, 0.5F, 0.8f).endVertex();

         bufferbuilder.pos(-1.5, 2, 0).color(0, 1.45F, 1.5F, 0.8f).endVertex();
          bufferbuilder.pos(1.5, 2, 0).color(0, 0.45F, 0.5F, 0.8f).endVertex();
            bufferbuilder.pos(0, 0, 0).color(0, 0.45F, 0.5F, 0.8f).endVertex();
            bufferbuilder.pos(0, 0, 0).color(0, 0.45F, 0.5F, 0.8f).endVertex();
        tessellator.draw();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
        GlStateManager.popMatrix();







//
//
//        if(timemap.get(entity.getEntityId()) == null) timemap.put(entity.getEntityId(),0);
//
//        int time = timemap.get(entity.getEntityId()).intValue();
//
//        int limitFramerate = Minecraft.getMinecraft().gameSettings.limitFramerate;
//        float ticks = (float) ((float)time/(float)limitFramerate);
//
//        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)15728880%65536, (float)15728880/ 65536);
//        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//        if(item==null)return;
//
//        GlStateManager.pushMatrix();
//        GlStateManager.translate((float)x, (float)y, (float)z);
//        GlStateManager.enableRescaleNormal();
//        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
//        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
//        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
//        GlStateManager.scale(1.8F, 1.8F, 1.8F);
//        Minecraft.getMinecraft().getRenderItem().renderItem(item, ItemCameraTransforms.TransformType.NONE);
//        GlStateManager.disableRescaleNormal();
//        GlStateManager.popMatrix();
//
//
//        timemap.put(entity.getEntityId(),time>= 18*limitFramerate ? 0:++time);
//
//

    }




    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return POLAR_BEAR_TEXTURE;
    }



}
