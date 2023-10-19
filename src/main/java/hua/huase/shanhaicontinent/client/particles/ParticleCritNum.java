package hua.huase.shanhaicontinent.client.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
@SideOnly(Side.CLIENT)
public class ParticleCritNum extends Particle
{
    int time ;
    int lifeTime = 140;
    double initialX;
    double initialY;
    double initialZ;
    int Damage;
    int type;


    public ParticleCritNum(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double p_i46285_8_, double p_i46285_10_, double p_i46285_12_, float p_i46285_14_, int y, int z, int amount, int damage)
    {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, 0.0D, 0.0D, 0.0D);
        time = 0;
    }

    public ParticleCritNum(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double pI4628510, double zSpeedIn, float pI4628514,int damage, int type) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn);
        time = 0;
        this.initialX =xCoordIn;
        this.initialY =yCoordIn;
        this.initialZ =zCoordIn;
        this.Damage =damage;
        this.type =type;
    }

    public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
    {

        EntityPlayerSP player = Minecraft.getMinecraft().player;
        float renderArmYaw = player.renderArmYaw;
        float renderArmPitch = player.renderArmPitch;

        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
        int strLenHalved = fontRenderer.getStringWidth(String.valueOf(Damage)) / 2;

        GlStateManager.pushMatrix();
        GlStateManager.translate(initialX-player.posX,initialY-player.posY+1,initialZ-player.posZ);
        GlStateManager.translate(0,1.8f*time/lifeTime,0);
        GlStateManager.rotate(180, 1, 0, 0);
        GlStateManager.rotate(180, 0, 1, 0);

        GlStateManager.rotate(renderArmYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(renderArmPitch/2, 1.0F, 0.0F, 0.0F);
        GlStateManager.scale(0.05F, 0.04F, 0.05F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F); //将画笔置为黑色, 便于进行绘画(这里没有进行绘画)


        fontRenderer.drawString(String.valueOf(Damage), -strLenHalved, 0, 0xf0f01010,true);

        GlStateManager.popMatrix();

        this.time++;


    }

    public void onUpdate()
    {



        if (this.time >= this.lifeTime)
        {
            this.setExpired();
        }
    }
    public int getFXLayer()
    {
        return 3;
    }

    @SideOnly(Side.CLIENT)
    public static class Factory implements IParticleFactory
    {
        public Particle createParticle(int particleID, World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int... args)
        {


            return  new ParticleCritNum(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn + 0.5D, zSpeedIn, 1.0F
                    ,args[0],args[1]);
        }
    }

}
