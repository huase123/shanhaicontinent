package hua.huase.shanhaicontinent.client.event;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.capability.baubles.seedpacket.PacketHandler;
import hua.huase.shanhaicontinent.capability.baubles.seedpacket.PacketOpenBaublesInventory;
import hua.huase.shanhaicontinent.client.keybinding.MyKeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.minecraft.entity.SharedMonsterAttributes.MAX_HEALTH;

@EventBusSubscriber
public class ClientEventHandler
{


    public static boolean b = false;
    //键盘检测事件
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onKeyPressed(InputUpdateEvent event) {




        if (MyKeyBinding.MYKEY_O.isPressed()) {

            if (FMLClientHandler.instance().getClient().inGameHasFocus) {
                PacketHandler.INSTANCE.sendToServer(new PacketOpenBaublesInventory());
            }
        }

    }



    @SideOnly(Side.CLIENT)
    public static boolean jingtoukaiguan = false;
    @SideOnly(Side.CLIENT)
    public static int jingtou = 0;
    @SideOnly(Side.CLIENT)
    public static int tick=0;
    //    镜头事件
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void renderentityEventText(EntityViewRenderEvent.CameraSetup event){



        if(jingtoukaiguan){

            Minecraft.getMinecraft().renderGlobal.notifyBlockUpdate(Minecraft.getMinecraft().world,new BlockPos(Minecraft.getMinecraft().player.posX,Minecraft.getMinecraft().player.posY,Minecraft.getMinecraft().player.posZ),null,null,1);

//            Minecraft.getMinecraft().gameSettings.thirdPersonView = 1;
            int limitFramerate = Minecraft.getMinecraft().gameSettings.limitFramerate;
            float i = (float)tick / limitFramerate * 24;
            double x = MathHelper.sin((float) (i * Math.PI / 180f)) * 10f;
            double y = MathHelper.cos((float) (i * Math.PI / 180f)) * 10f;

            event.setYaw(0);
            event.setPitch(0);
    //        event.setRoll(0);
            GlStateManager.rotate(30,1 ,0,0);
            GlStateManager.rotate(i+90,0 ,1,0);
            GlStateManager.translate(y,-3 ,x);
//
//            GL11.glPushMatrix();
//            GL11.glPopMatrix();
//            GlStateManager.rotate(30,0 ,0,1);

            tick = tick<=limitFramerate*15?tick+1:0;
        }


    }







    public static final ResourceLocation HEATDOWN = new ResourceLocation(ExampleMod.MODID,"textures/gui/shuchai/heatdown.png");
    public static final ResourceLocation MINECRAFT = new ResourceLocation("minecraft:textures/gui/icons.png");
    public static final ResourceLocation HEATUP = new ResourceLocation(ExampleMod.MODID,"textures/gui/shuchai/heatup.png");
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void renderHealthbar(RenderGameOverlayEvent.Pre event) {
        ScaledResolution resolution = event.getResolution();

        Entity renderViewEnity = Minecraft.getMinecraft().getRenderViewEntity();
        if(event.getType() == RenderGameOverlayEvent.ElementType.HEALTH && !event.isCanceled() && (renderViewEnity instanceof EntityPlayer)) {
            float health = ((EntityPlayer) renderViewEnity).getHealth();
            float maxhealth = (float) ((EntityPlayer) renderViewEnity).getEntityAttribute(MAX_HEALTH).getBaseValue();

            int x = resolution.getScaledWidth()/2-91;
            int y = resolution.getScaledHeight()-38;

//            double x = 147;
//            double y = 232;
            double z = 0;

            GlStateManager.pushMatrix();
//            GlStateManager.translate((float) x, (float) y, (float) z);

            Minecraft.getMinecraft().getTextureManager().bindTexture(HEATDOWN);
            Tessellator tessellator = Tessellator.getInstance(); //获取Tessellator的一般方式
            BufferBuilder buffer = tessellator.getBuffer();//获取记录顶点信息的"数组"

            buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
            buffer.pos(x, y, 0).tex(0, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
            buffer.pos(x, y+8, 0).tex(0, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
            buffer.pos(x+85, y+8, 0).tex(1, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
            buffer.pos(x+85, y, 0).tex(1, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV

            tessellator.draw();

            GlStateManager.popMatrix();


            GlStateManager.pushMatrix();
//            GlStateManager.translate((float) x, (float) y, (float) z);


            if(health/maxhealth<=0.10){
                GlStateManager.color(0.5f,0.0f,0.0f,1f);
            }
//
//            if(health/maxhealth<=0.10){
//                GlStateManager.color(1f,0.3f,0.3f,1);
//            }


            Minecraft.getMinecraft().getTextureManager().bindTexture(HEATUP);
            buffer = tessellator.getBuffer();//获取记录顶点信息的"数组"

            buffer.begin(7, DefaultVertexFormats.POSITION_TEX);
            buffer.pos(x+1, y+1, 0).tex(0, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
            buffer.pos(x+1, y+1+6, 0).tex(0, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
            buffer.pos(x+1+83*health/maxhealth, y+1+6, 0).tex(1, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
            buffer.pos(x+1+83*health/maxhealth, y+1, 0).tex(1, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV

            tessellator.draw();

            GlStateManager.color(1f,1f,1f,1);
            GlStateManager.popMatrix();


            String s = I18n.translateToLocalFormatted("player.shanhaicontinent.hp.name", Math.round(health) + "/" + maxhealth);

            GlStateManager.pushMatrix();
            GlStateManager.translate(x,y-0.5,0);
            GlStateManager.scale(0.7,0.7,0);
            Minecraft.getMinecraft().fontRenderer.drawString(s,5, 2, 0xffffffff,true);

            GlStateManager.popMatrix();











            Minecraft.getMinecraft().getTextureManager().bindTexture(MINECRAFT);



            event.setCanceled(true);//取消原版渲染



        }

        if(event.getType() == RenderGameOverlayEvent.ElementType.ARMOR && !event.isCanceled() && (renderViewEnity instanceof EntityPlayer)) {
            GlStateManager.translate((float) 0, (float) -9, (float) 0);
        }
        if(event.getType() == RenderGameOverlayEvent.ElementType.FOOD && !event.isCanceled() && (renderViewEnity instanceof EntityPlayer)) {
            GlStateManager.translate((float) 0, (float) 9, (float) 0);
        }
    }








}
