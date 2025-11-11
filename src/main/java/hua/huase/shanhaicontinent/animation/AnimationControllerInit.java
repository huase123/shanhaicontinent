package hua.huase.shanhaicontinent.animation;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.animation.animationcontrollers.AnimationControllerDemo;
import hua.huase.shanhaicontinent.init.SHRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

/**
 * - @description:AnimationControllerInti类
 * - @author: huase。
 * - @date: 2025/11/10 9:36
 */
public class AnimationControllerInit {
    public static final DeferredRegister<SHAnimationController> AnimationController = DeferredRegister.create(SHRegistries.SHAnimationController, SHMainBus.MOD_ID);

    public static final RegistryObject<SHAnimationController> empty= AnimationController.register("demo", AnimationControllerDemo::new);
}
