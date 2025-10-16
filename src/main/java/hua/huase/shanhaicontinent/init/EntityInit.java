package hua.huase.shanhaicontinent.init;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.entity.client.RhinoModel;
import hua.huase.shanhaicontinent.entity.hunhe.HunheEntity;
import hua.huase.shanhaicontinent.entity.hunhe.HunheRender;
import hua.huase.shanhaicontinent.entity.hunhuan.HunhuanEntityEntity;
import hua.huase.shanhaicontinent.entity.hunhuan.HunhuanRender;
import hua.huase.shanhaicontinent.entity.jinengentity.haotianchui.*;
import hua.huase.shanhaicontinent.entity.jinengentity.huang.*;
import hua.huase.shanhaicontinent.entity.jinengentity.jinggubang.JiNengFSHYEntity;
import hua.huase.shanhaicontinent.entity.jinengentity.jinggubang.JiNengFSHYRender;
import hua.huase.shanhaicontinent.entity.jinengitem.JinengItemEntity;
import hua.huase.shanhaicontinent.entity.jinengitem.JinengItemRender;
import hua.huase.shanhaicontinent.entity.mob.hunmin.HunminEntity;
import hua.huase.shanhaicontinent.entity.protectionbox.ProtectionBox;
import hua.huase.shanhaicontinent.entity.protectionbox.ProtectionBoxModel;
import hua.huase.shanhaicontinent.entity.protectionbox.ProtectionBoxRenderer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ZombieVillagerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SHMainBus.MOD_ID);

//    public static final RegistryObject<EntityType<RhinoEntity>> RHINO =
//            ENTITY_TYPES.register("rhino", () -> EntityType.Builder.of(RhinoEntity::new, MobCategory.CREATURE)
//                    .sized(2.5f, 2.5f).build("rhino"));
    public static final RegistryObject<EntityType<ProtectionBox>> PROTECTION_BOX =
        registerEntity(
                EntityType.Builder.<ProtectionBox>of(ProtectionBox::new, MobCategory.MISC)
                        .sized(0.5F, 0.5F)
                        .updateInterval(Integer.MAX_VALUE)
                        .setCustomClientFactory(ProtectionBox::new), "protection_box");

    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(EntityType.Builder<T> builder, String entityName) {
        return ENTITY_TYPES.register(entityName, () -> builder.build(entityName));
    }




    public static final RegistryObject<EntityType<HunhuanEntityEntity>> HUNHUAN =
            ENTITY_TYPES.register("hunhuan", () -> EntityType.Builder.of(HunhuanEntityEntity::new, MobCategory.MISC)
                    .updateInterval(Integer.MAX_VALUE)
                    .sized(1.0f, 1.0f).build("hunhuan"));
    public static final RegistryObject<EntityType<HunheEntity>> HUNHE =
            ENTITY_TYPES.register("hunhe", () -> EntityType.Builder.of(HunheEntity::new, MobCategory.MISC)
                    .updateInterval(Integer.MAX_VALUE)
                    .sized(1.0f, 1.0f).build("hunhe"));
    public static final RegistryObject<EntityType<JinengItemEntity>> JINENGITEM =
            ENTITY_TYPES.register("jinengitem", () -> EntityType.Builder.of(JinengItemEntity::new, MobCategory.MISC)
                    .updateInterval(Integer.MAX_VALUE)
                    .sized(0.5f, 0.5f).build("jinengitem"));


    public static final RegistryObject<EntityType<JiNengFSHYEntity>> jinengfshy =
            ENTITY_TYPES.register("jinengfshy", () -> EntityType.Builder.of(JiNengFSHYEntity::new, MobCategory.MISC)
                    .sized(1.0f, 1.0f).build("jinengfshy"));
    public static final RegistryObject<EntityType<JiNengKPBSEntity>> jinengkpbs =
            ENTITY_TYPES.register("jinengkpbs", () -> EntityType.Builder.of(JiNengKPBSEntity::new, MobCategory.MISC)
                    .updateInterval(Integer.MAX_VALUE)
                    .sized(3.0f, 3.0f).build("jinengkpbs"));
    public static final RegistryObject<EntityType<JiNengSNSLEntity>> jinengsnsl =
            ENTITY_TYPES.register("jinengsnsl", () -> EntityType.Builder.of(JiNengSNSLEntity::new, MobCategory.MISC)
                    .updateInterval(Integer.MAX_VALUE)
                    .sized(3.0f, 3.0f).build("jinengsnsl"));
    public static final RegistryObject<EntityType<JiNengCMJJEntity>> jinengcmjj =
            ENTITY_TYPES.register("jinengcmjj", () -> EntityType.Builder.of(JiNengCMJJEntity::new, MobCategory.MISC)
                    .updateInterval(Integer.MAX_VALUE)
                    .sized(3.0f, 3.0f).build("jinengcmjj"));
    public static final RegistryObject<EntityType<JiNengBSQEntity>> jinengbsq =
            ENTITY_TYPES.register("jinengbsq", () -> EntityType.Builder.of(JiNengBSQEntity::new, MobCategory.MISC)
                    .updateInterval(Integer.MAX_VALUE)
                    .sized(8.0f, 8.0f).build("jinengbsq"));
    public static final RegistryObject<EntityType<Jineng_HTSC_1_Entity>> jinenghtsc1 =
            ENTITY_TYPES.register("jinenghtsc1", () -> EntityType.Builder.of(Jineng_HTSC_1_Entity::new, MobCategory.MISC)
                    .updateInterval(Integer.MAX_VALUE)
                    .sized(3.0f, 3.0f).build("jinenghtsc1"));
    public static final RegistryObject<EntityType<Jineng_HTSC_4_Entity>> jinenghtsc4 =
            ENTITY_TYPES.register("jinenghtsc4", () -> EntityType.Builder.of(Jineng_HTSC_4_Entity::new, MobCategory.MISC)
                    .updateInterval(Integer.MAX_VALUE)
                    .sized(4.0f, 4.0f).build("jinenghtsc4"));
    public static final RegistryObject<EntityType<Jineng_HTSC_7_Entity>> jinenghtsc7 =
            ENTITY_TYPES.register("jinenghtsc7", () -> EntityType.Builder.of(Jineng_HTSC_7_Entity::new, MobCategory.MISC)
                    .updateInterval(Integer.MAX_VALUE)
                    .sized(8.0f, 8.0f).build("jinenghtsc7"));



//    mob

    public static final RegistryObject<EntityType<HunminEntity>> hunmin =
            ENTITY_TYPES.register("hunmin", () -> EntityType.Builder.of(HunminEntity::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.95F).
                    clientTrackingRange(20)
                    .build("hunmin"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

//实体刷新
    @Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class SpawnPlacementsRegister {
        @SubscribeEvent
        public static void onSpawnPlacementsRegister(SpawnPlacementRegisterEvent event) {
            /*
            event.register(HUNHE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE_WG,
                    HunheEntity::checkMonsterSpawnRules,
                    SpawnPlacementRegisterEvent.Operation.AND);
*/
        }
    }


//实体属性注册
    @Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public class ModEventBusEvents {
        @SubscribeEvent
        public static void registerAttributes(EntityAttributeCreationEvent event) {
//            event.put(EntityInit.RHINO.get(), RhinoEntity.createAttributes().build());
            event.put(EntityInit.hunmin.get(), HunminEntity.createAttributes().build());
        }
    }


//渲染注册
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

//            EntityRenderers.register(EntityInit.RHINO.get(), RhinoRenderer::new);
            EntityRenderers.register(EntityInit.HUNHUAN.get(), HunhuanRender::new);
            EntityRenderers.register(EntityInit.HUNHE.get(), HunheRender::new);
            EntityRenderers.register(EntityInit.JINENGITEM.get(), JinengItemRender::new);

            EntityRenderers.register(EntityInit.jinengfshy.get(), JiNengFSHYRender::new);
            EntityRenderers.register(EntityInit.jinengkpbs.get(), JiNengKPBSRender::new);
            EntityRenderers.register(EntityInit.jinengsnsl.get(), JiNengSNSLRender::new);
            EntityRenderers.register(EntityInit.jinengcmjj.get(), JiNengCMJJRender::new);
            EntityRenderers.register(EntityInit.jinengbsq.get(), JiNengBSQRender::new);

            EntityRenderers.register(EntityInit.jinenghtsc1.get(), Jineng_HTSC_1_Render::new);
            EntityRenderers.register(EntityInit.jinenghtsc4.get(), Jineng_HTSC_4_Render::new);
            EntityRenderers.register(EntityInit.jinenghtsc7.get(), Jineng_HTSC_7_Render::new);



//            Mob
            EntityRenderers.register(EntityInit.hunmin.get(), ZombieVillagerRenderer::new);

//            要塞箱子

            EntityRenderers.register(EntityInit.PROTECTION_BOX.get(), ProtectionBoxRenderer::new);

        }



    public static final ModelLayerLocation RHINO_LAYER = new ModelLayerLocation(
            new ResourceLocation(SHMainBus.MOD_ID, "rhino_layer"), "main");
    public static final ModelLayerLocation PROTECTION_BOX = new ModelLayerLocation(
            new ResourceLocation(SHMainBus.MOD_ID, "protection_box"), "main");

//模型图层注册
        @SubscribeEvent
        public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(RHINO_LAYER, RhinoModel::createBodyLayer);
            event.registerLayerDefinition(PROTECTION_BOX, () -> LayerDefinition.create(ProtectionBoxModel.createMesh(), 16, 16));

//        event.registerLayerDefinition(ModModelLayers.PINE_BOAT_LAYER, BoatModel::createBodyModel);
//        event.registerLayerDefinition(ModModelLayers.PINE_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
        }

    }



}
