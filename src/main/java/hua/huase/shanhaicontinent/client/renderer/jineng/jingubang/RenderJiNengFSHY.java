package hua.huase.shanhaicontinent.client.renderer.jineng.jingubang;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
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
public class RenderJiNengFSHY extends RenderEntity {


    private static final ResourceLocation POLAR_BEAR_TEXTURE = new ResourceLocation("shanhaicontinent:textures/jineng/jingubang/bang.png");
    public static Map<Integer, Integer> timemap=new HashMap();
public RenderJiNengFSHY(RenderManager renderManager) {
        super(renderManager);
    }


    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        if(timemap.get(entity.getEntityId()) == null) timemap.put(entity.getEntityId(),0);

        int time = timemap.get(entity.getEntityId()).intValue();

        int limitFramerate = Minecraft.getMinecraft().gameSettings.limitFramerate;
        float ticks = (float) ((float)time/(float)limitFramerate);

        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)15728880%65536, (float)15728880/ 65536);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        for (int j = -1; j <2 ; j++) {

            GlStateManager.pushMatrix();
            GlStateManager.translate((float)x+j*2, (float)y+1f, (float)z);
            GlStateManager.rotate(entityYaw, 0, 1, 0);
            for (int i = 0; i < 4; i++) {

                GlStateManager.pushMatrix();
                GlStateManager.rotate(i*90, 0, 0, 1);
                GlStateManager.rotate(-90, 1, 0, 0);
                GlStateManager.rotate(ticks*200f, 0, 1, 0);
//                GlStateManager.rotate(j*15, 0, 1, 0);
//                GlStateManager.rotate(ticks*20f, 0, 0, 1);
        //        GlStateManager.scale(1.5f, 1.5f, 0);
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                Minecraft.getMinecraft().getTextureManager().bindTexture(POLAR_BEAR_TEXTURE);
                Tessellator tessellator = Tessellator.getInstance();
                BufferBuilder buffer = tessellator.getBuffer();
                buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
                buffer.pos(  -0.5,   -5.5, 0).tex(0, 0).endVertex();
                buffer.pos(  -0.5, 5.5, 0).tex(0, 1).endVertex();
                buffer.pos(0.5, 5.5, 0).tex(1, 1).endVertex();
                buffer.pos(0.5,   -5.5, 0).tex(1, 0).endVertex();
                tessellator.draw();
                GlStateManager.popMatrix();

            }

            GlStateManager.popMatrix();
        }




        timemap.put(entity.getEntityId(),time>= 18*limitFramerate ? 0:++time);

    }




    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return POLAR_BEAR_TEXTURE;
    }



}
