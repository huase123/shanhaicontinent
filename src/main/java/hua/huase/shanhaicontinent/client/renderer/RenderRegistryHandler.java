package hua.huase.shanhaicontinent.client.renderer;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.client.model.ModelTFYeti;
import hua.huase.shanhaicontinent.client.renderer.jineng.RenderJiNengItme;
import hua.huase.shanhaicontinent.client.renderer.jineng.RenderJiNengThread;
import hua.huase.shanhaicontinent.client.renderer.jineng.huang.RenderWuHunHuangBSJ;
import hua.huase.shanhaicontinent.client.renderer.jineng.huang.RenderWuHunHuangCMJJ;
import hua.huase.shanhaicontinent.client.renderer.jineng.huang.RenderWuHunHuangKPBS;
import hua.huase.shanhaicontinent.client.renderer.jineng.huang.RenderWuHunHuangSNSL;
import hua.huase.shanhaicontinent.client.renderer.jineng.jingubang.RenderJiNengDZSY;
import hua.huase.shanhaicontinent.client.renderer.jineng.jingubang.RenderJiNengFSHY;
import hua.huase.shanhaicontinent.entity.EntityTFYeti;
import hua.huase.shanhaicontinent.entity.HunhuanEntity;
import hua.huase.shanhaicontinent.entity.jineng.EntityJiNengThread;
import hua.huase.shanhaicontinent.entity.jineng.huang.EntityWuHunHuangBSJ;
import hua.huase.shanhaicontinent.entity.jineng.huang.EntityWuHunHuangCMJJ;
import hua.huase.shanhaicontinent.entity.jineng.huang.EntityWuHunHuangKPBS;
import hua.huase.shanhaicontinent.entity.jineng.huang.EntityWuHunHuangSNSL;
import hua.huase.shanhaicontinent.entity.jineng.jingubang.EntityJiNengDZSY;
import hua.huase.shanhaicontinent.entity.jineng.jingubang.EntityJiNengFSHY;
import hua.huase.shanhaicontinent.entity.jinengitem.EntityJinengItem;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderRegistryHandler
{
    public static void register()
    {
        /*
        RenderingRegistry.registerEntityRenderingHandler(EntityDirtBallKing.class, RenderDirtBallKing::new);

*/
        RenderingRegistry.registerEntityRenderingHandler(HunhuanEntity.class, RenderHunHuan::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityJinengItem.class, RenderJiNengItme::new);

        RenderingRegistry.registerEntityRenderingHandler(EntityJinengItem.class, manager ->
        {
//            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            return new RenderJiNengItme(manager, HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":wuqijingubang")));
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityJiNengThread.class, RenderJiNengThread::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityJiNengFSHY.class, RenderJiNengFSHY::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityJiNengDZSY.class, manager ->
                new RenderJiNengDZSY(manager, HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":wuqijndzsy"))));


        RenderingRegistry.registerEntityRenderingHandler(EntityWuHunHuangKPBS.class, RenderWuHunHuangKPBS::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityWuHunHuangSNSL.class, RenderWuHunHuangSNSL::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityWuHunHuangCMJJ.class, RenderWuHunHuangCMJJ::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityWuHunHuangBSJ.class, RenderWuHunHuangBSJ::new);



        RenderingRegistry.registerEntityRenderingHandler(EntityTFYeti.class, (RenderManager manager) -> new RenderTFYeti(manager,new ModelTFYeti(),"yeti"));
//        RenderingRegistry.registerEntityRenderingHandler(EntityJiNengThread.class, m -> new RenderSnowball<>(m, Items.ENDER_PEARL, Minecraft.getMinecraft().getRenderItem()));

/*
        RenderingRegistry.registerEntityRenderingHandler(EntityDirtBall.class, manager ->
        {
            RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
            return new RenderSnowball<EntityDirtBall>(manager, HanderAny.itemList.get(8), renderItem);
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
