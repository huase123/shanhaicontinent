package hua.huase.shanhaicontinent.client.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.common.util.EnumHelper;

//@SideOnly(Side.CLIENT)
public class ParticlesHander {
   public static EnumParticleTypes enumParticleTypes ;
   public static EnumParticleTypes enumParticleTypesText ;
   public static EnumParticleTypes parTicleCritNum = EnumHelper.addEnum(EnumParticleTypes.class,
           "HEATHNUM", new Class[]{String.class, int.class, boolean.class, int.class}, "heathnum", EnumParticleTypes.values().length, false, 2);



    public static void register(){
//
//        Minecraft.getMinecraft().effectRenderer.registerParticle(enumParticleTypes.getParticleID(),new ParticleText.Factory());
//        Minecraft.getMinecraft().effectRenderer.registerParticle(enumParticleTypesText.getParticleID(),new ParticleTextTwo.Factory());
        Minecraft.getMinecraft().effectRenderer.registerParticle(parTicleCritNum.getParticleID(),new ParticleCritNum.Factory());
        EnumParticleTypes.PARTICLES.put(parTicleCritNum.getParticleID(),parTicleCritNum);
        EnumParticleTypes.BY_NAME.put(parTicleCritNum.getParticleName(),parTicleCritNum);
    }
}
