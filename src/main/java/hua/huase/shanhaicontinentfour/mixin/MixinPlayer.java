package hua.huase.shanhaicontinentfour.mixin;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Player.class)
public abstract class MixinPlayer {


    @Redirect(
            method = "attack", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/level/ServerLevel;sendParticles(Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I"
    )
    )
    public int sendParticles(ServerLevel instance, ParticleOptions j, double v, double p_8768_, double p_8769_, int p_8770_, double p_8771_, double p_8772_, double p_8773_, double p_8774_) {

        return 0;
    }

}
