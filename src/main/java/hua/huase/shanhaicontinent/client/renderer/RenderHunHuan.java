package hua.huase.shanhaicontinent.client.renderer;

import hua.huase.shanhaicontinent.entity.HunhuanEntity;
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
import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class RenderHunHuan extends RenderEntity {


    private static final ResourceLocation POLAR_BEAR_TEXTURE = new ResourceLocation("shanhaicontinent:textures/picture/particletext.png");
//    protected ModelBase modelBoat = new HunhuanModel();
    protected RenderHunHuan(RenderManager renderManager) {

        super(renderManager);
    }

//    float time = 0f;
    public static Map<Integer, Integer> timemap=new HashMap();

    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {

        if(timemap.get(entity.getEntityId()) == null) timemap.put(entity.getEntityId(),0);


        int time = timemap.get(entity.getEntityId()).intValue();


        HunhuanEntity entity1 = (HunhuanEntity) entity;
        Integer nianxian = entity1.getStage();


        int limitFramerate = Minecraft.getMinecraft().gameSettings.limitFramerate;



        float ticks = (float) ((float)time/(float)limitFramerate);
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y+0.2, (float)z);
        GlStateManager.rotate(90, 1, 0, 0);
        GlStateManager.rotate(ticks*20f, 0, 0, 1);
//        GlStateManager.scale(1f, 1f, 1);
        float v = ticks/3;

        GlStateManager.disableLighting();
        GlStateManager.enablePolygonOffset();
//        GlStateManager.enableBlend(); //开启混合器(使GL支持Alpha透明通道)
        GlStateManager.depthMask(false);
        GlStateManager.doPolygonOffset(-1, 20);


        if(nianxian>=1000000){
            GlStateManager.color(v<=1?1:v<=2?2-v:v<=4?0:v<=5?v-4:1,v<=1?v:v<=3?1:v<=4?4-v:0,v<=2?0:v<=3?v-2:v<=5?1:v<=5?1:6-v,1.0f);

            GlStateManager.scale(1.5f, 1.5f, 0);

        }else if(nianxian>=100000){
            GlStateManager.color(1f, 0, 0,0.8f);
            GlStateManager.scale(1.18f, 1.18f, 0);

        }else if(nianxian>=10000){
            GlStateManager.color(0, 0f, 0,0.8f);
            GlStateManager.scale(0.9f, 0.9f, 0);
        }else if(nianxian>=1000){

            GlStateManager.color(1f, 0f, 1f,0.8f);
            GlStateManager.scale(0.76f, 0.76f, 0);
        }else if(nianxian>=100){

            GlStateManager.color(1f, 1f, 0,0.8f);
            GlStateManager.scale(0.60f, 0.60f, 0);
        }else if(nianxian>=1){

            GlStateManager.color(1f, 1f, 1f,0.8f);
            GlStateManager.scale(0.4f, 0.4f, 0);
        }







        Minecraft.getMinecraft().getTextureManager().bindTexture(POLAR_BEAR_TEXTURE);
        Tessellator tessellator = Tessellator.getInstance(); //获取Tessellator的一般方式
        BufferBuilder buffer = tessellator.getBuffer();//获取记录顶点信息的"数组"

        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX); //指定数组的组织方式(位置 + UV方式), 以及要画的图像的顶点数(矩形四个顶点)

        buffer.pos(  -6,   -6, 0).tex(0, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(  -6, 6, 0).tex(0, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(6, 6, 0).tex(1, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(6,   -6, 0).tex(1, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV


        tessellator.draw(); //将数组和渲染方式提交到GPU

//        GlStateManager.disableBlend();
        GlStateManager.depthMask(true);
        GlStateManager.disablePolygonOffset();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();



        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y+0.2, (float)z);
        GlStateManager.rotate(-90, 1, 0, 0);
        GlStateManager.rotate(ticks*20f, 0, 0, 1);
//                    GlStateManager.color(0.5f, 0.5f, 0,0.8f);


        GlStateManager.disableLighting();
        GlStateManager.enablePolygonOffset();
//        GlStateManager.enableBlend(); //开启混合器(使GL支持Alpha透明通道)
        GlStateManager.depthMask(false);
        GlStateManager.doPolygonOffset(-1, 20);


        if(nianxian>=1000000){
            GlStateManager.color(v<=1?1:v<=2?2-v:v<=4?0:v<=5?v-4:1,v<=1?v:v<=3?1:v<=4?4-v:0,v<=2?0:v<=3?v-2:v<=5?1:v<=5?1:6-v,1.0f);

            GlStateManager.scale(1.5f, 1.5f, 0);

        }else if(nianxian>=100000){
            GlStateManager.color(1f, 0, 0,0.8f);
            GlStateManager.scale(1.18f, 1.18f, 0);

        }else if(nianxian>=10000){
            GlStateManager.color(0, 0f, 0,0.8f);
            GlStateManager.scale(0.9f, 0.9f, 0);
        }else if(nianxian>=1000){

            GlStateManager.color(1f, 0f, 1f,0.8f);
            GlStateManager.scale(0.76f, 0.76f, 0);
        }else if(nianxian>=100){

            GlStateManager.color(1f, 1f, 0,0.8f);
            GlStateManager.scale(0.60f, 0.60f, 0);
        }else if(nianxian>=1){

            GlStateManager.color(1f, 1f, 1f,0.8f);
            GlStateManager.scale(0.4f, 0.4f, 0);
        }






        Minecraft.getMinecraft().getTextureManager().bindTexture(POLAR_BEAR_TEXTURE);
        buffer = tessellator.getBuffer();//获取记录顶点信息的"数组"
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX); //指定数组的组织方式(位置 + UV方式), 以及要画的图像的顶点数(矩形四个顶点)

        buffer.pos(  -6,   -6, 0).tex(0, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(  -6, 6, 0).tex(0, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(6, 6, 0).tex(1, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(6,   -6, 0).tex(1, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV


        tessellator.draw(); //将数组和渲染方式提交到GPU

        GlStateManager.depthMask(true);
//        GlStateManager.disableBlend();
        GlStateManager.disablePolygonOffset();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();





        timemap.put(entity.getEntityId(),time>= 18*limitFramerate ? 0:++time);



    }





    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return POLAR_BEAR_TEXTURE;
    }



}
