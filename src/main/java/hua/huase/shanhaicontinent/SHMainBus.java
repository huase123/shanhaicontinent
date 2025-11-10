package hua.huase.shanhaicontinent;

import hua.huase.shanhaicontinent.command.SHCommand;
import hua.huase.shanhaicontinent.config.Config;
import hua.huase.shanhaicontinent.functiontypes.FunctionTypeInit;
import hua.huase.shanhaicontinent.init.*;
import hua.huase.shanhaicontinent.init.ModelBlockEntitiesinit;
import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.item.ItemInit;
import hua.huase.shanhaicontinent.network.NetworkHandler;
import hua.huase.shanhaicontinent.init.ModRecipesInit;
import hua.huase.shanhaicontinent.screen.ModMenuTypes;
import hua.huase.shanhaicontinent.world.structure.SHStructureTypes;
import hua.huase.shanhaicontinent.world.biome.OverworldModifications;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Random;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SHMainBus.MOD_ID)
@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID)
public class SHMainBus {
    public static final String MOD_ID = "shanhaicontinent";
    public static final Random random = new Random();

//    暮色深林
    public static boolean twilightforest_compat;
//    暮色深林
    public static boolean sophisticated_backpacks;

    public static final ResourceLocation HUNHUAN = new ResourceLocation(SHMainBus.MOD_ID, "textures/gui/hunhuan.png");
    public static final ResourceLocation TEXT = new ResourceLocation(SHMainBus.MOD_ID, "textures/entity/hunhe.png");


//    protected static final SimpleChannel channel = NetworkRegistry.newSimpleChannel(new ResourceLocation("ep","sync"),()->"340",(s) -> true, (s) -> true);


    public SHMainBus() throws IOException {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();



//指令
        MinecraftForge.EVENT_BUS.addListener(this::registerCommands);

//        SHRegistries.Init();
        modEventBus.addListener(SHRegistries::registerNewRegistry);

//        FunctionTypeInit.register(modEventBus);
        FunctionTypeInit.FUNCTION.register(modEventBus);

        BlockInit.register(modEventBus);
        ItemInit.register(modEventBus);
        EntityInit.register(modEventBus);
        ModelBlockEntitiesinit.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModRecipesInit.register(modEventBus);
        CreativeModTabsInit.register(modEventBus);
        SHModMobEffectsinit.register(modEventBus);

//        world
        SHStructureTypes.STRUCTURE_TYPES.register(modEventBus);

//        触发器
        new AdvenceInit();

        MinecraftForge.EVENT_BUS.register(this);
//        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(CapabilityRegistryHandler::registerCaps);

        NetworkHandler.register();

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC);
        changeAttributesIO();

//联动
        twilightforest_compat = ModList.get().isLoaded("twilightforest");

//联动
        sophisticated_backpacks = ModList.get().isLoaded("sophisticatedbackpacks");

    }


    public void registerCommands(RegisterCommandsEvent event) {
        SHCommand.register(event.getDispatcher());
    }


//    某创造栏里加某物品
//    private void addCreative(BuildCreativeModeTabContentsEvent event){
//        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
//            event.accept(ModItems.TEXTITEM);
//            event.accept(ModItems.RHINO_SPANW_EGG);
//        }
//    }


//给主世界添加自定义群系
    private void loadComplete(final @NotNull FMLLoadCompleteEvent event) {
        event.enqueueWork(OverworldModifications::addBiomesToOverworldUnsafe);
    }


//    修改血量上限
    public static void changeAttributesIO()  {

        try {
            Field privateField = RangedAttribute.class.getDeclaredFields()[1];
            privateField.setAccessible(true);
            privateField.set(Attributes.MAX_HEALTH, Float.MAX_VALUE);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }


}
