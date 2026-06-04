package hua.huase.shanhaicontinent.particles;

import hua.huase.shanhaicontinent.SHMainBus;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:ParticleTypesInti类
 */
public class ParticleTypesInti {
/**
 * TODO 功能描述：渲染注册请查阅
 * @author :huase
 * @date 2025/11/23 15:20
 * @see hua.huase.shanhaicontinent.init.ClientModEvents#register(RegisterParticleProvidersEvent)
 */
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SHMainBus.MOD_ID);

    public static final RegistryObject<SimpleParticleType> potianshengunhunji2 = PARTICLE_TYPES.register("hunji2", () -> new SimpleParticleType(true));


}
