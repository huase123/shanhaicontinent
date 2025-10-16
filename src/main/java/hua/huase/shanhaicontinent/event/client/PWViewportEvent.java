package hua.huase.shanhaicontinent.event.client;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.entity.hunhuan.HunhuanEntityEntity;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PWViewportEvent {

/*

    float i = (float)tick / limitFramerate * 24;
    double x = MathHelper.sin((float) (i * Math.PI / 180f)) * 10f;
    double y = MathHelper.cos((float) (i * Math.PI / 180f)) * 10f;

            event.setYaw(0);
            event.setPitch(0);
    //        event.setRoll(0);
            GlStateManager.rotate(30,1 ,0,0);
            GlStateManager.rotate(i+90,0 ,1,0);
            GlStateManager.translate(y,-3 ,x);*/

//    @SubscribeEvent
    public static void computeCameraAngles(ViewportEvent.ComputeCameraAngles event){
        Camera camera = event.getCamera();
        if(camera == null)return;

        GameRenderer renderer = event.getRenderer();
        Minecraft minecraft = renderer.getMinecraft();
        if(minecraft.player != null && minecraft.player.getVehicle()!=null && minecraft.player.getVehicle() instanceof HunhuanEntityEntity){
            double v = minecraft.level.getGameTime() + event.getPartialTick();
//            event.setYaw((float) (v));
//            event.setYaw((float) (0));
//            event.setPitch(90);
//            event.setRoll(0);


        }
    }


//    @SubscribeEvent
    public static void renderPlayerEventPost(RenderLevelStageEvent event){

        Minecraft minecraft = Minecraft.getInstance();
        if(minecraft.player != null && minecraft.player.getVehicle()!=null && minecraft.player.getVehicle() instanceof HunhuanEntityEntity){
            Matrix4f pose = event.getPoseStack().last().pose();
            double v = minecraft.level.getGameTime() + event.getPartialTick();
            double x = Math.sin((float) 0.01f*v* Math.PI / 180f) * 3f;
            double y = Math.cos((float) 0.01f*v* Math.PI / 180f) * 3f;
//            pose.translate((float) 0, (float) -(v*0.1)%10, (float) 0);
            Entity entity = event.getCamera().getEntity();
            entity.setPos(entity.xo,minecraft.player.getVehicle().yo+x,entity.zo);
//            entity.xo +=x;
//            entity.zo +=y;
//            entity.absMoveTo( x, (float) 0, (float) y);
//            entity.setPos(new Vec3((float) x, (float) 0, (float) y));
//            pose.translate((float) x, (float) 0, (float) y);
//            pose.rotate((float) (v* Math.PI / 180f),0,1,0);
        }
    }

}
