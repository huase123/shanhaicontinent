package hua.huase.shanhaicontinent.client.renderer;

import hua.huase.shanhaicontinent.client.renderer.jiuneng.RenderJiNengThread;
import hua.huase.shanhaicontinent.entity.HunhuanEntity;
import hua.huase.shanhaicontinent.entity.jineng.EntityJiNengThread;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderRegistryHandler
{
    public static void register()
    {
        /*
        RenderingRegistry.registerEntityRenderingHandler(EntityDirtBallKing.class, RenderDirtBallKing::new);

*/
        RenderingRegistry.registerEntityRenderingHandler(HunhuanEntity.class, RenderHunHuan::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityJiNengThread.class, RenderJiNengThread::new);



/*

        RenderingRegistry.registerEntityRenderingHandler(EntityDirtBall.class, manager ->
        {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            return new RenderSnowball<EntityDirtBall>(manager,HanderAny.itemList.get(8), renderItem);
        });

*/

/*

        RenderingRegistry.registerEntityRenderingHandler(EntityThrowableText.class, manager ->
        {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            return new RenderSnowball<EntityThrowableText>(manager,HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":textitme")), renderItem);
        });
*/

    }
}
