package hua.huase.shanhaicontinent.client.renderer.jineng;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class RenderJiNengThread extends RenderEntity {


    private static final ResourceLocation POLAR_BEAR_TEXTURE = new ResourceLocation("shanhaicontinent:textures/jineng/jianqi3/1.png");
    public  static List<ResourceLocation> pacture = new ArrayList<ResourceLocation>();
public RenderJiNengThread(RenderManager renderManager) {
        super(renderManager);
        for (int i = 0; i < 8; i++) {
            pacture.add(new ResourceLocation("shanhaicontinent:textures/jineng/jianqi3/"+(i+1)+".png"));
        }
    }

//    float time = 0f;
    public int time=0;

    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {

        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.rotate(90, 1, 0, 0);
        GlStateManager.rotate(-entityYaw+45, 0, 0, 1);
        GlStateManager.rotate(30, 0, 1, 0);
        GlStateManager.disableLighting();
        GlStateManager.enablePolygonOffset();
        GlStateManager.enableBlend(); //开启混合器(使GL支持Alpha透明通道)
        GlStateManager.depthMask(false);
        GlStateManager.doPolygonOffset(-1, 20);
        Minecraft.getMinecraft().getTextureManager().bindTexture(pacture.get(time/10));
        Tessellator tessellator = Tessellator.getInstance(); //获取Tessellator的一般方式
        BufferBuilder buffer = tessellator.getBuffer();//获取记录顶点信息的"数组"
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX); //指定数组的组织方式(位置 + UV方式), 以及要画的图像的顶点数(矩形四个顶点)
        buffer.pos(  -6,   -6, 0).tex(0, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(  -6, 6, 0).tex(0, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(6, 6, 0).tex(1, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(6,   -6, 0).tex(1, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
        tessellator.draw(); //将数组和渲染方式提交到GPU
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.disablePolygonOffset();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.rotate(90, 1, 0, 0);
        GlStateManager.rotate(-entityYaw+45, 0, 0, 1);
        GlStateManager.rotate(-30, 0, 1, 0);
        GlStateManager.disableLighting();
        GlStateManager.enablePolygonOffset();
        GlStateManager.enableBlend(); //开启混合器(使GL支持Alpha透明通道)
        GlStateManager.depthMask(false);
        GlStateManager.doPolygonOffset(-1, 20);
        Minecraft.getMinecraft().getTextureManager().bindTexture(pacture.get(time/10));
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX); //指定数组的组织方式(位置 + UV方式), 以及要画的图像的顶点数(矩形四个顶点)
        buffer.pos(  -6,   -6, 0).tex(0, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(  -6, 6, 0).tex(0, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(6, 6, 0).tex(1, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(6,   -6, 0).tex(1, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
        tessellator.draw(); //将数组和渲染方式提交到GPU
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.disablePolygonOffset();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();



        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.rotate(-90, 1, 0, 0);
        GlStateManager.rotate(entityYaw-45, 0, 0, 1);
        GlStateManager.rotate(30, 0, 1, 0);
        GlStateManager.disableLighting();
        GlStateManager.enablePolygonOffset();
        GlStateManager.enableBlend(); //开启混合器(使GL支持Alpha透明通道)
        GlStateManager.depthMask(false);
        GlStateManager.doPolygonOffset(-1, 20);
        Minecraft.getMinecraft().getTextureManager().bindTexture(pacture.get(time/10));
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX); //指定数组的组织方式(位置 + UV方式), 以及要画的图像的顶点数(矩形四个顶点)
        buffer.pos(  -6,   -6, 0).tex(0, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(  -6, 6, 0).tex(0, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(6, 6, 0).tex(1, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(6,   -6, 0).tex(1, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
        tessellator.draw(); //将数组和渲染方式提交到GPU
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.disablePolygonOffset();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();


        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.rotate(-90, 1, 0, 0);
        GlStateManager.rotate(entityYaw-45, 0, 0, 1);
        GlStateManager.rotate(-30, 0, 1, 0);
        GlStateManager.disableLighting();
        GlStateManager.enablePolygonOffset();
        GlStateManager.enableBlend(); //开启混合器(使GL支持Alpha透明通道)
        GlStateManager.depthMask(false);
        GlStateManager.doPolygonOffset(-1, 20);
        Minecraft.getMinecraft().getTextureManager().bindTexture(pacture.get(time/10));
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX); //指定数组的组织方式(位置 + UV方式), 以及要画的图像的顶点数(矩形四个顶点)
        buffer.pos(  -6,   -6, 0).tex(0, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(  -6, 6, 0).tex(0, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(6, 6, 0).tex(1, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(6,   -6, 0).tex(1, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
        tessellator.draw(); //将数组和渲染方式提交到GPU
        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.disablePolygonOffset();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();





        time = time>=7*10? 0:++time;


    }




    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return POLAR_BEAR_TEXTURE;
    }



}
