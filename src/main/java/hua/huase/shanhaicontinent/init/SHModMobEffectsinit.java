
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package hua.huase.shanhaicontinent.init;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.potion.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;


public class SHModMobEffectsinit {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, SHMainBus.MOD_ID);
	public static final RegistryObject<MobEffect> JISHENG = REGISTRY.register("shbasemobeffect", () -> new SHBaseMobEffect());
	public static final RegistryObject<MobEffect> jineng_jgb_6 		= REGISTRY.register("jineng_jgb_6", () -> new Jineng_jgb_6());
	public static final RegistryObject<MobEffect> jineng_jgb_7 		= REGISTRY.register("jineng_jgb_7", () -> new Jineng_jgb_7());
	public static final RegistryObject<MobEffect> jineng_jgb_8 		= REGISTRY.register("jineng_jgb_8", () -> new Jineng_jgb_8());
	public static final RegistryObject<MobEffect> jineng_huang_6 	= REGISTRY.register("jineng_huang_6", () -> new Jineng_huang_6());
	public static final RegistryObject<MobEffect> jineng_huang_8 	= REGISTRY.register("jineng_huang_8", () -> new Jineng_huang_8());
	public static final RegistryObject<MobEffect> jineng_htsc_2 	= REGISTRY.register("jineng_htsc_2", () -> new Jineng_htsc_2());
	public static final RegistryObject<MobEffect> jineng_htsc_5 	= REGISTRY.register("jineng_htsc_5", () -> new Jineng_htsc_5());
	public static final RegistryObject<MobEffect> jineng_htsc_6 	= REGISTRY.register("jineng_htsc_6", () -> new Jineng_htsc_6());
	public static final RegistryObject<MobEffect> zhiwu_bianhua 	= REGISTRY.register("zhiwu_bianhua", () -> new ZhiwuBianhua());

    public static void register(IEventBus eventBus) {
		REGISTRY.register(eventBus);
	}

}
