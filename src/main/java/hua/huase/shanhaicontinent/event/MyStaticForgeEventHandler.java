package hua.huase.shanhaicontinent.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
public class MyStaticForgeEventHandler extends Event {

        int time ;
        int lifeTime = 100;
        double initialX;
        double initialY;
        double initialZ;
        int Damage;
        int type;




    public MyStaticForgeEventHandler( double initialX, double initialY, double initialZ, int damage, int type) {

        time = 0;
        this.initialX =initialX;
        this.initialY =initialY;
        this.initialZ =initialZ;
        this.Damage =damage;
        this.type =type;
    }

    @SideOnly(Side.CLIENT)
//    @SubscribeEvent
        public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
        {


            for(int i = time;time>=lifeTime;time++) {

                float renderArmYaw = Minecraft.getMinecraft().player.renderArmYaw;
                float renderArmPitch = Minecraft.getMinecraft().player.renderArmPitch;

                GlStateManager.pushMatrix();
                GlStateManager.translate(initialX - entityIn.posX, initialY - entityIn.posY + 1, initialZ - entityIn.posZ);
                GlStateManager.translate(0, 1.8 * time / lifeTime, 0);
                GlStateManager.rotate(180, 1, 0, 0);
                GlStateManager.rotate(180, 0, 1, 0);

                GL11.glRotatef(renderArmYaw, 0.0F, 1.0F, 0.0F);
                GL11.glRotatef(renderArmPitch / 2, 1.0F, 0.0F, 0.0F);
                //...省略了translate过程...
                GlStateManager.scale(0.05F, 0.04F, 0.05F);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F); //将画笔置为黑色, 便于进行绘画(这里没有进行绘画)

                GlStateManager.disableLighting();
                GlStateManager.enablePolygonOffset();
                GlStateManager.depthMask(false);
//        GlStateManager.enableBlend(); //开启混合器(使GL支持Alpha透明通道)
                GlStateManager.doPolygonOffset(-1, 1);

                FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
                int strLenHalved = fontRenderer.getStringWidth(String.valueOf(Damage)) / 2;
                fontRenderer.drawString(String.valueOf(Damage), -strLenHalved, 0, 0xFFFF0000);

//        GlStateManager.disableBlend();
                GlStateManager.depthMask(true);
                GlStateManager.disablePolygonOffset();
                GlStateManager.enableLighting();

                GlStateManager.popMatrix();

            }

        }



    }
