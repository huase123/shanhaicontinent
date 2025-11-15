package hua.huase.shanhaicontinent.animation;

import hua.huase.shanhaicontinent.animation.client.AnimationRenderers;
import hua.huase.shanhaicontinent.animation.client.IClientMobAnimationExtensions;
import net.minecraft.world.entity.Entity;

/**
 * - @description:AnimationControllerDemo类
 * - @author: huase。
 * - @date: 2025/11/11 6:48
 */
public class AnimationController implements SHAnimationController {
    long duration =20;
    public AnimationController() {


    }

    @Override
    public long getDuration(Entity livingEntity) {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }


    @Override
    public void tick(Entity entity) {

    }



/**
 * TODO 功能描述：十分诡异的封装方法，通过这样封装后，能够绕过服务端运行时对客户类的加载检测，原生java没有了解到有相关机制，个人怀疑是Forge系统内部的反射机制在发力，
 * @author :huase
 * @date 2025/11/14 14:33
 */
    private Object effectRenderer;

    public Object getRendererInternal() {
        if(effectRenderer != null)return effectRenderer;
        initClient();
        return effectRenderer;
    }

    private void initClient() {
        if (net.minecraftforge.fml.loading.FMLEnvironment.dist == net.minecraftforge.api.distmarker.Dist.CLIENT && !net.minecraftforge.fml.loading.FMLLoader.getLaunchHandler().isData()) {
            initializeClient(properties -> {
                this.effectRenderer = properties;
            });
        }
    }

    public void initializeClient(java.util.function.Consumer<IClientMobAnimationExtensions> consumer) {
        consumer.accept(AnimationRenderers.getRenderer(this));
    }

}
