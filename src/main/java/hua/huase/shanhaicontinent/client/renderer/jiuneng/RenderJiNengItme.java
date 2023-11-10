package hua.huase.shanhaicontinent.client.renderer.jiuneng;

import hua.huase.shanhaicontinent.entity.jinengitem.EntityJinengItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;

import static hua.huase.shanhaicontinent.client.event.RenderWorldHunhuan.EXPLOSION_TEXTURE;

@SideOnly(Side.CLIENT)
public class RenderJiNengItme extends RenderEntity {

    private  ItemStack item ;
    private static final ResourceLocation POLAR_BEAR_TEXTURE = new ResourceLocation("shanhaicontinent:textures/picture/particletext.png");
    public static Map<Integer, Integer> timemap=new HashMap();
    public RenderJiNengItme(RenderManager renderManagerIn,Item item)
    {
        super(renderManagerIn);
        this.shadowSize = 0.15F;
        this.shadowOpaque = 0.75F;
        this.item=new ItemStack(item,1);
    }
    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {

        if(timemap.get(entity.getEntityId()) == null) timemap.put(entity.getEntityId(),0);
        int time = timemap.get(entity.getEntityId()).intValue();
        int limitFramerate = Minecraft.getMinecraft().gameSettings.limitFramerate;
        float ticks = (float) ((float)time/(float)limitFramerate);

        if(((EntityJinengItem)entity).getItemStack()!=null)this.item=((EntityJinengItem)entity).getItemStack();

        // 渲染
        // 清空颜色缓冲
//        GL11.glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
//        GL11.glClear(GL_COLOR_BUFFER_BIT);
//        GlStateManager.matrixMode(5889);
//        GlStateManager.loadIdentity();

        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y+0.35+0.1f* MathHelper.sin(ticks/4.5f*3.14159265359f), (float)z);
        GlStateManager.rotate(ticks*40, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);
        Minecraft.getMinecraft().getRenderItem().renderItem(item, ItemCameraTransforms.TransformType.GROUND);
        GlStateManager.popMatrix();

        int nianxian = item.getTagCompound().getInteger("nianxian");

        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y+0.2f, (float)z);
        GlStateManager.rotate(90, 1, 0, 0);
        GlStateManager.rotate(ticks*20f, 0, 0, 1);
        GlStateManager.scale(1.5f, 1.5f, 0);

        if (nianxian >= 1000000) {
            GlStateManager.color(ticks <= 1 ? 1 : ticks <= 2 ? 2 - ticks : ticks <= 4 ? 0 : ticks <= 5 ? ticks - 4 : 1, ticks <= 1 ? ticks : ticks <= 3 ? 1 : ticks <= 4 ? 4 - ticks : 0, ticks <= 2 ? 0 : ticks <= 3 ? ticks - 2 : ticks <= 5 ? 1 : ticks <= 5 ? 1 : 6 - ticks, 1.0f);
        } else if (nianxian >= 100000) {
            GlStateManager.color(1.5f, 0, 0, 0.8f);
        } else if (nianxian >= 10000) {
            GlStateManager.color(0, 0f, 0, 0.8f);
        } else if (nianxian >= 1000) {
            GlStateManager.color(1.5f, 0f, 1f, 0.8f);
        } else if (nianxian >= 100) {
            GlStateManager.color(1.5f, 1f, 0, 0.8f);
        } else if (nianxian >= 1) {
            GlStateManager.color(1.5f, 1.5f, 1.5f, 0.8f);
        }
        GlStateManager.disableLighting();
        GlStateManager.disableColorMaterial();
        GlStateManager.enablePolygonOffset();
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend(); //开启混合器(使GL支持Alpha透明通道)
        GlStateManager.doPolygonOffset(-3, -3);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        Minecraft.getMinecraft().getTextureManager().bindTexture(EXPLOSION_TEXTURE);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        buffer.pos(  -0.5,   -0.5, 0).tex(0, 0).endVertex();
        buffer.pos(  -0.5, 0.5, 0).tex(0, 1).endVertex();
        buffer.pos(0.5, 0.5, 0).tex(1, 1).endVertex();
        buffer.pos(0.5,   -0.5, 0).tex(1, 0).endVertex();
        tessellator.draw();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.disablePolygonOffset();
        GlStateManager.enableLighting();
        GlStateManager.enableColorMaterial();
        GlStateManager.popMatrix();


        GlStateManager.disableLighting();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y+0.2f, (float)z);
        GlStateManager.rotate(-90, 1, 0, 0);
        GlStateManager.rotate(ticks*20f, 0, 0, 1);
        GlStateManager.scale(1.5f, 1.5f, 0);

        if (nianxian >= 1000000) {
            GlStateManager.color(ticks <= 1 ? 1 : ticks <= 2 ? 2 - ticks : ticks <= 4 ? 0 : ticks <= 5 ? ticks - 4 : 1, ticks <= 1 ? ticks : ticks <= 3 ? 1 : ticks <= 4 ? 4 - ticks : 0, ticks <= 2 ? 0 : ticks <= 3 ? ticks - 2 : ticks <= 5 ? 1 : ticks <= 5 ? 1 : 6 - ticks, 1.0f);
        } else if (nianxian >= 100000) {
            GlStateManager.color(1.5f, 0, 0, 0.8f);
        } else if (nianxian >= 10000) {
            GlStateManager.color(0, 0f, 0, 0.8f);
        } else if (nianxian >= 1000) {
            GlStateManager.color(1.5f, 0f, 1f, 0.8f);
        } else if (nianxian >= 100) {
            GlStateManager.color(1.5f, 1f, 0, 0.8f);
        } else if (nianxian >= 1) {
            GlStateManager.color(1.5f, 1.5f, 1.5f, 0.8f);
        }
        GlStateManager.disableLighting();
        GlStateManager.enablePolygonOffset();
        GlStateManager.depthMask(false);
        GlStateManager.enableBlend(); //开启混合器(使GL支持Alpha透明通道)
        GlStateManager.doPolygonOffset(-3, -3);
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        Minecraft.getMinecraft().getTextureManager().bindTexture(EXPLOSION_TEXTURE);
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        buffer.pos(  -0.5,   -0.5, 0).tex(0, 0).endVertex();
        buffer.pos(  -0.5, 0.5, 0).tex(0, 1).endVertex();
        buffer.pos(0.5, 0.5, 0).tex(1, 1).endVertex();
        buffer.pos(0.5,   -0.5, 0).tex(1, 0).endVertex();
        tessellator.draw();
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.disablePolygonOffset();
        GlStateManager.enableLighting();
        GlStateManager.enableColorMaterial();
        GlStateManager.popMatrix();






        timemap.put(entity.getEntityId(),time>= 9*limitFramerate ? 0:++time);
    }



    protected ResourceLocation getEntityTexture(EntityItem entity)
    {
//        return POLAR_ITEM_TEXTURE;
        return null;
    }
}
