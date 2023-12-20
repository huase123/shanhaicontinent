package hua.huase.shanhaicontinent.entity;

import hua.huase.shanhaicontinent.entity.jineng.EntityJiNengThread;
import hua.huase.shanhaicontinent.entity.jineng.huang.EntityWuHunHuangBSJ;
import hua.huase.shanhaicontinent.entity.jineng.huang.EntityWuHunHuangCMJJ;
import hua.huase.shanhaicontinent.entity.jineng.huang.EntityWuHunHuangKPBS;
import hua.huase.shanhaicontinent.entity.jineng.huang.EntityWuHunHuangSNSL;
import hua.huase.shanhaicontinent.entity.jineng.jingubang.EntityJiNengDZSY;
import hua.huase.shanhaicontinent.entity.jineng.jingubang.EntityJiNengFSHY;
import hua.huase.shanhaicontinent.entity.jinengitem.EntityJinengItem;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class EntityRegistryHandler
{
    /*
    public static final EntityEntry DIRT_BALL_KING =
            EntityEntryBuilder.create().entity(EntityDirtBallKing.class)
                    .id(EntityDirtBallKing.ID, 0).name(EntityDirtBallKing.NAME).tracker(80, 3, true)
                    .egg(0xe52222, 0xd7ef39).spawn(EnumCreatureType.MONSTER, 50, 4, 4,EntityDirtBallKing.BIOMES).build();
    public static final EntityEntry DIRT_BALL =
            EntityEntryBuilder.create().entity(EntityDirtBall.class)
                    .id(EntityDirtBall.ID, 1).name(EntityDirtBall.NAME).tracker(64, 10, true).build();

    public static final EntityEntry ENTITY_THROWABLE_TEXT =
            EntityEntryBuilder.create().entity(EntityThrowableText.class)
                    .id(EntityThrowableText.ID, 2).name(EntityThrowableText.NAME).tracker(64, 10, true).build();

*/


    public static int entityID=0;
    public static final EntityEntry YE_TI =
            EntityEntryBuilder.create().entity(EntityTFYeti.class)
                    .id(EntityTFYeti.ID, entityID++).name(EntityTFYeti.NAME).tracker(80, 3, true)
                    .egg(0xe52222, 0xd7ef39).spawn(EnumCreatureType.MONSTER, 50, 4, 4,EntityDirtBallKing.BIOMES).build();
    public static final EntityEntry HUNHUANENTITY =
            EntityEntryBuilder.create().entity(HunhuanEntity.class)
                    .id(HunhuanEntity.ID, entityID++).name(HunhuanEntity.NAME).tracker(64, 10, true).build();

    public static final EntityEntry JiNengItem =
            EntityEntryBuilder.create().entity(EntityJinengItem.class)
                    .id(EntityJinengItem.ID, entityID++).name(EntityJinengItem.NAME).tracker(64, 10, false).build();

    public static final EntityEntry JiNengThread =
            EntityEntryBuilder.create().entity(EntityJiNengThread.class)
                    .id(EntityJiNengThread.ID, entityID++).name(EntityJiNengThread.NAME).tracker(64, 10, true).build();


    public static final EntityEntry JiNengFSHY =
            EntityEntryBuilder.create().entity(EntityJiNengFSHY.class)
                    .id(EntityJiNengFSHY.ID, entityID++).name(EntityJiNengFSHY.NAME).tracker(64, 10, true).build();



    public static final EntityEntry JiNengDZSY =
            EntityEntryBuilder.create().entity(EntityJiNengDZSY.class)
                    .id(EntityJiNengDZSY.ID, entityID++).name(EntityJiNengDZSY.NAME).tracker(64, 10, true).build();



    public static final EntityEntry WuHunHuangKPBS =
            EntityEntryBuilder.create().entity(EntityWuHunHuangKPBS.class)
                    .id(EntityWuHunHuangKPBS.ID, entityID++).name(EntityWuHunHuangKPBS.NAME).tracker(64, 10, true).build();




    public static final EntityEntry WuHunHuangSNSL =
            EntityEntryBuilder.create().entity(EntityWuHunHuangSNSL.class)
                    .id(EntityWuHunHuangSNSL.ID, entityID++).name(EntityWuHunHuangSNSL.NAME).tracker(64, 10, true).build();


    public static final EntityEntry WuHunHuangCMJJ =
            EntityEntryBuilder.create().entity(EntityWuHunHuangCMJJ.class)
                    .id(EntityWuHunHuangCMJJ.ID, entityID++).name(EntityWuHunHuangCMJJ.NAME).tracker(64, 10, true).build();



    public static final EntityEntry WuHunHuangBSJ =
            EntityEntryBuilder.create().entity(EntityWuHunHuangBSJ.class)
                    .id(EntityWuHunHuangBSJ.ID, entityID++).name(EntityWuHunHuangBSJ.NAME).tracker(64, 10, true).build();







    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<EntityEntry> event)
    {
        IForgeRegistry<EntityEntry> registry = event.getRegistry();
        registry.register(HUNHUANENTITY);
        registry.register(JiNengItem);
        registry.register(JiNengThread);
        registry.register(JiNengFSHY);
        registry.register(JiNengDZSY);
        registry.register(WuHunHuangKPBS);
        registry.register(WuHunHuangSNSL);
        registry.register(WuHunHuangCMJJ);
        registry.register(WuHunHuangBSJ);

        registry.register(YE_TI);
    }
}
