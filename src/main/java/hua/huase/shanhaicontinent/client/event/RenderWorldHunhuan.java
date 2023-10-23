package hua.huase.shanhaicontinent.client.event;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.MonsterCapability;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;

import static hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler.NIANLING;

@Mod.EventBusSubscriber
public class RenderWorldHunhuan {

    public static final ResourceLocation EXPLOSION_TEXTURE = new ResourceLocation(ExampleMod.MODID,"textures/picture/particletext.png");
    public static Map<Integer, Integer> timemap=new HashMap();
//    public static float time=0f;

    //    世界实体渲染事件
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void renderLivingText(RenderLivingEvent.Post event) {
        EntityPlayerSP player = Minecraft.getMinecraft().player;
        PlayerCapability capability = player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
        if (true) {


            EntityLivingBase entityIn = event.getEntity();
            int limitFramerate = Minecraft.getMinecraft().gameSettings.limitFramerate;

            if(timemap.get(entityIn.getEntityId()) == null) timemap.put(entityIn.getEntityId(),0);


            int time = timemap.get(entityIn.getEntityId()).intValue();
            float ticks = (float) ((float)time/(float)limitFramerate);


            if(entityIn  instanceof IMob && entityIn instanceof EntityLivingBase &&entityIn.getEntityAttribute(NIANLING)!=null ){
                    int nianxian = (int) entityIn.getEntityAttribute(NIANLING).getBaseValue();

                    double x = entityIn.posX-player.posX;
                    double y = entityIn.posY- player.posY;
                    double z = entityIn.posZ-player.posZ;

                    GlStateManager.pushMatrix();
                    GlStateManager.translate((float) x, (float) y+0.4f, (float) z);
                    GlStateManager.rotate(90, 1, 0, 0);
                    GlStateManager.rotate(ticks*20f, 0, 0, 1);
                    GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                    float v =ticks;



                    if(nianxian>=1000000){
                        GlStateManager.color(v<=1?1:v<=2?2-v:v<=4?0:v<=5?v-4:1,v<=1?v:v<=3?1:v<=4?4-v:0,v<=2?0:v<=3?v-2:v<=5?1:v<=5?1:6-v,1.0f);

                        GlStateManager.scale(1.5f, 1.5f, 0);

                    }else if(nianxian>=100000){
                        GlStateManager.color(1.5f, 0, 0,0.8f);
                        GlStateManager.scale(1.18f, 1.18f, 0);

                    }else if(nianxian>=10000){
                        GlStateManager.color(0, 0f, 0,0.8f);
                        GlStateManager.scale(0.9f, 0.9f, 0);
                    }else if(nianxian>=1000){

                        GlStateManager.color(1.5f, 0f, 1f,0.8f);
                        GlStateManager.scale(0.76f, 0.76f, 0);
                    }else if(nianxian>=100){

                        GlStateManager.color(1.5f, 1f, 0,0.8f);
                        GlStateManager.scale(0.60f, 0.60f, 0);
                    }else if(nianxian>=1){
                        GL11.glColor3f(1f,1f,1f);
                        GlStateManager.color(1.5f, 1.5f, 1.5f,0.8f);
                        GlStateManager.scale(0.4f, 0.4f, 0);
                    }

                GlStateManager.disableLighting();
                GlStateManager.enablePolygonOffset();
                GlStateManager.depthMask(false);
                GlStateManager.enableBlend(); //开启混合器(使GL支持Alpha透明通道)
                GlStateManager.doPolygonOffset(-3, -30);

                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);


                Minecraft.getMinecraft().getTextureManager().bindTexture(EXPLOSION_TEXTURE);
                    Tessellator tessellator = Tessellator.getInstance(); //获取Tessellator的一般方式
                    BufferBuilder buffer = tessellator.getBuffer();//获取记录顶点信息的"数组"

                    buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX); //指定数组的组织方式(位置 + UV方式), 以及要画的图像的顶点数(矩形四个顶点)

                    buffer.pos(-6, -6, 0).tex(0, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
                    buffer.pos(-6, 6, 0).tex(0, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
                    buffer.pos(6, 6, 0).tex(1, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
                    buffer.pos(6, -6, 0).tex(1, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV


                    tessellator.draw(); //将数组和渲染方式提交到GPU

                GlStateManager.disableBlend();
                GlStateManager.depthMask(true);
                GlStateManager.disablePolygonOffset();
                GlStateManager.enableLighting();
                GlStateManager.popMatrix();

//=====================

                    GlStateManager.pushMatrix();
                    GlStateManager.translate((float) x, (float) y+0.4f, (float) z);
                    GlStateManager.rotate(-90, 1, 0, 0);
                    GlStateManager.rotate(ticks*20f, 0, 0, -1);

                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);


                if(nianxian>=1000000){
                    GlStateManager.color(v<=1?1:v<=2?2-v:v<=4?0:v<=5?v-4:1,v<=1?v:v<=3?1:v<=4?4-v:0,v<=2?0:v<=3?v-2:v<=5?1:v<=5?1:6-v,1.0f);

                    GlStateManager.scale(1.5f, 1.5f, 0);

                }else if(nianxian>=100000){
                    GlStateManager.color(1.5f, 0, 0,0.8f);
                    GlStateManager.scale(1.18f, 1.18f, 0);

                }else if(nianxian>=10000){
                    GlStateManager.color(0, 0f, 0,0.8f);
                    GlStateManager.scale(0.9f, 0.9f, 0);
                }else if(nianxian>=1000){

                    GlStateManager.color(1.5f, 0f, 1f,0.8f);
                    GlStateManager.scale(0.76f, 0.76f, 0);
                }else if(nianxian>=100){

                    GlStateManager.color(1.5f, 1f, 0,0.8f);
                    GlStateManager.scale(0.60f, 0.60f, 0);
                }else if(nianxian>=1){

                    GlStateManager.color(1.5f, 1.5f, 1.5f,0.8f);
                    GlStateManager.scale(0.4f, 0.4f, 0);
                }
                GlStateManager.disableLighting();
                GlStateManager.enablePolygonOffset();
                GlStateManager.depthMask(false);
                GlStateManager.enableBlend(); //开启混合器(使GL支持Alpha透明通道)
                GlStateManager.doPolygonOffset(-3, -30);

                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);


                Minecraft.getMinecraft().getTextureManager().bindTexture(EXPLOSION_TEXTURE);
                    buffer = tessellator.getBuffer();//获取记录顶点信息的"数组"
                    buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX); //指定数组的组织方式(位置 + UV方式), 以及要画的图像的顶点数(矩形四个顶点)

                    buffer.pos(-6, -6, 0).tex(0, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
                    buffer.pos(-6, 6, 0).tex(0, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
                    buffer.pos(6, 6, 0).tex(1, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
                    buffer.pos(6, -6, 0).tex(1, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV


                    tessellator.draw(); //将数组和渲染方式提交到GPU

                GlStateManager.disableBlend();
                GlStateManager.depthMask(true);
                GlStateManager.disablePolygonOffset();
                GlStateManager.enableLighting();
                GlStateManager.popMatrix();



                    timemap.put(entityIn.getEntityId(),time>= 18*limitFramerate ? 0:++time);

                }



            if(entityIn  instanceof EntityOtherPlayerMP) {
                if(entityIn.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY,null).isHunhuankaiguan()){



                    PlayerCapability capability1 = entityIn.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
                    if(capability1==null) return;

                    double x = entityIn.posX-player.posX;
                    double y = entityIn.posY- player.posY;
                    double z = entityIn.posZ-player.posZ;


                    int i1 = 1;
                    for (MonsterCapability monsterCapability1 : capability1.getMonsterCapabilityList()) {

                        int nianxian = monsterCapability1.getNianxian();
                        GlStateManager.pushMatrix();
                        GlStateManager.translate((float) x, (float) y+0.05f, (float) z);
                        GlStateManager.rotate(90, 1, 0, 0);
                        GlStateManager.rotate(i1%2==0? ticks*18f:-ticks*18f, 0, 0, 1);
                        float v = ticks;
                        GlStateManager.scale(0.3f+ i1 /10f, 0.3f+ i1 /10f, 0);

                        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

                        if(nianxian>=1000000){
                            GlStateManager.color(v<=1?1:v<=2?2-v:v<=4?0:v<=5?v-4:1,v<=1?v:v<=3?1:v<=4?4-v:0,v<=2?0:v<=3?v-2:v<=5?1:v<=5?1:6-v,1.0f);
                        }else if(nianxian>=100000){
                            GlStateManager.color(1.5f, 0, 0,0.8f);

                        }else if(nianxian>=10000){
                            GlStateManager.color(0, 0f, 0,0.8f);
                        }else if(nianxian>=1000){
                            GlStateManager.color(1.5f, 0f, 1f,0.8f);
                        }else if(nianxian>=100){
                            GlStateManager.color(1.5f, 1f, 0,0.8f);
                        }else if(nianxian>=1){
                            GlStateManager.color(1.5f, 1.5f, 1.5f,0.8f);
                        }


                        GlStateManager.disableLighting();
                        GlStateManager.enablePolygonOffset();
                        GlStateManager.depthMask(false);
                        GlStateManager.enableBlend(); //开启混合器(使GL支持Alpha透明通道)
                        GlStateManager.doPolygonOffset(-3, -30);

                        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);


                        Minecraft.getMinecraft().getTextureManager().bindTexture(EXPLOSION_TEXTURE);
                        Tessellator tessellator = Tessellator.getInstance(); //获取Tessellator的一般方式
                        BufferBuilder buffer = tessellator.getBuffer();//获取记录顶点信息的"数组"

                        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX); //指定数组的组织方式(位置 + UV方式), 以及要画的图像的顶点数(矩形四个顶点)

                        buffer.pos(-6, -6, 0).tex(0, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
                        buffer.pos(-6, 6, 0).tex(0, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
                        buffer.pos(6, 6, 0).tex(1, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
                        buffer.pos(6, -6, 0).tex(1, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV


                        tessellator.draw(); //将数组和渲染方式提交到GPU

                        GlStateManager.disableBlend();
                        GlStateManager.depthMask(true);
                        GlStateManager.disablePolygonOffset();
                        GlStateManager.enableLighting();
                        GlStateManager.popMatrix();
//=====================

                        GlStateManager.pushMatrix();
                        GlStateManager.translate((float) x, (float) y+0.05f, (float) z);
                        GlStateManager.rotate(-90, 1, 0, 0);
                        GlStateManager.rotate(i1%2==0? ticks*18f:-ticks*18f, 0, 0, 1);

                        GlStateManager.scale(0.3f+ i1 /10f, 0.3f+ i1 /10f, 0);

                        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);



                        if(nianxian>=1000000){
                            GlStateManager.color(v<=1?1:v<=2?2-v:v<=4?0:v<=5?v-4:1,v<=1?v:v<=3?1:v<=4?4-v:0,v<=2?0:v<=3?v-2:v<=5?1:v<=5?1:6-v,1.0f);
                        }else if(nianxian>=100000){
                            GlStateManager.color(1.5f, 0, 0,0.8f);

                        }else if(nianxian>=10000){
                            GlStateManager.color(0, 0f, 0,0.8f);
                        }else if(nianxian>=1000){
                            GlStateManager.color(1.5f, 0f, 1f,0.8f);
                        }else if(nianxian>=100){
                            GlStateManager.color(1.5f, 1f, 0,0.8f);
                        }else if(nianxian>=1){
                            GlStateManager.color(1.5f, 1.5f, 1.5f,0.8f);
                        }


                        GlStateManager.disableLighting();
                        GlStateManager.enablePolygonOffset();
                        GlStateManager.depthMask(false);
                        GlStateManager.enableBlend(); //开启混合器(使GL支持Alpha透明通道)
                        GlStateManager.doPolygonOffset(-3, -30);

                        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);


                        Minecraft.getMinecraft().getTextureManager().bindTexture(EXPLOSION_TEXTURE);
                        buffer = tessellator.getBuffer();//获取记录顶点信息的"数组"
                        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX); //指定数组的组织方式(位置 + UV方式), 以及要画的图像的顶点数(矩形四个顶点)

                        buffer.pos(-6, -6, 0).tex(0, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
                        buffer.pos(-6, 6, 0).tex(0, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
                        buffer.pos(6, 6, 0).tex(1, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
                        buffer.pos(6, -6, 0).tex(1, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV


                        tessellator.draw(); //将数组和渲染方式提交到GPU

                        GlStateManager.disableBlend();
                        GlStateManager.depthMask(true);
                        GlStateManager.disablePolygonOffset();
                        GlStateManager.enableLighting();

                        GlStateManager.popMatrix();
                        i1++;
                    }
                }
            }
            timemap.put(entityIn.getEntityId(),time>= 20*limitFramerate ? 0:++time);
        }
    }





}