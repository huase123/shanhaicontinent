package hua.huase.shanhaicontinent.entity;

import hua.huase.shanhaicontinent.entity.jineng.EntityJiNengThread;
import hua.huase.shanhaicontinent.entity.jinengitem.EntityJinengItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class EntityRegistryHandler
{/*
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
    public static final EntityEntry HUNHUANENTITY =
            EntityEntryBuilder.create().entity(HunhuanEntity.class)
                    .id(HunhuanEntity.ID, 3).name(HunhuanEntity.NAME).tracker(64, 10, true).build();

    public static final EntityEntry JiNengItem =
            EntityEntryBuilder.create().entity(EntityJinengItem.class)
                    .id(EntityJinengItem.ID, 4).name(EntityJinengItem.NAME).tracker(64, 10, true).build();

    public static final EntityEntry JiNengThread =
            EntityEntryBuilder.create().entity(EntityJiNengThread.class)
                    .id(EntityJiNengThread.ID, 5).name(EntityJiNengThread.NAME).tracker(64, 10, true).build();







    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<EntityEntry> event)
    {
        IForgeRegistry<EntityEntry> registry = event.getRegistry();
//        registry.register(DIRT_BALL_KING);
//        registry.register(DIRT_BALL);
//        registry.register(ENTITY_THROWABLE_TEXT);
        registry.register(HUNHUANENTITY);
        registry.register(JiNengItem);
        registry.register(JiNengThread);
    }
}
