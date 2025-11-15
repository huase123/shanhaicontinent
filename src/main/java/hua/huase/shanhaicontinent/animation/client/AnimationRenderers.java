package hua.huase.shanhaicontinent.animation.client;

import com.google.common.collect.Maps;
import hua.huase.shanhaicontinent.animation.AnimationControllerInit;
import hua.huase.shanhaicontinent.animation.SHAnimationController;
import hua.huase.shanhaicontinent.animation.animationcontrollers.DamoAnimationRender;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

/**
 * - @description:AnimationRenderers类
 */
@OnlyIn(Dist.CLIENT)
public class AnimationRenderers {
    private static final Map<SHAnimationController, IClientMobAnimationExtensions> PROVIDERS = Maps.newHashMap();
    public static void register(SHAnimationController shAnimationController, IClientMobAnimationExtensions iClientMobAnimationExtensions) {
        PROVIDERS.put(shAnimationController, iClientMobAnimationExtensions);
    }

    public static IClientMobAnimationExtensions getRenderer(SHAnimationController shAnimationController) {
        IClientMobAnimationExtensions iClientMobAnimationExtensions = PROVIDERS.get(shAnimationController);
        if(iClientMobAnimationExtensions == null)iClientMobAnimationExtensions = IClientMobAnimationExtensions.DEFAULT;
        return iClientMobAnimationExtensions;
    }
    /**
     * @see hua.huase.shanhaicontinent.init.ClientModEvents*/
    public static void init(){
        register(AnimationControllerInit.demo.get(),new DamoAnimationRender());
    }
}
