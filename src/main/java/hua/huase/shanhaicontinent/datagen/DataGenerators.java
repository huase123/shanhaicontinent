package hua.huase.shanhaicontinent.datagen;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.datagen.level.SHBiomeTagGenerator;
import hua.huase.shanhaicontinent.datagen.level.RegistryDataGenerator;
import hua.huase.shanhaicontinent.datagen.level.SHStructureTagGenerator;
import hua.huase.shanhaicontinent.datagen.loot.ModBlockLootTables;
import hua.huase.shanhaicontinent.datagen.loot.SHChestLoot;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


//        物品，方块模型
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
//        粒子材质配置
        generator.addProvider(event.includeClient(), new ModParticleDescriptionProvider(packOutput, existingFileHelper));
//方块标签
        generator.addProvider(event.includeServer(), new SHBlockTagsProvider(packOutput, lookupProvider));


        generator.addProvider(event.includeServer(), new ModLanguageProvider(packOutput, SHMainBus.MOD_ID,"zh_cn"));
//        generator.addProvider(event.includeServer(), new ModLanguageProvider(packOutput, SHMainBus.MOD_ID,"en_us"));
        generator.addProvider(event.includeServer(), new ModEnLanguageProvider(packOutput, SHMainBus.MOD_ID,"en_us"));


//配方
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
////        战力表
//        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Set.of(), List.of(
//                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)
//        )));
//
//

        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Set.of(),
                List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(SHChestLoot::new, LootContextParamSets.CHEST)
            ))
        );


        generator.addProvider(event.includeServer(), new AdvancementProvider(packOutput, lookupProvider,
                List.of(
                        new ModAdvanceProvider()
            ))
        );





        DatapackBuiltinEntriesProvider datapackProvider = new RegistryDataGenerator(packOutput, lookupProvider);
        CompletableFuture<HolderLookup.Provider> lookupProvider1 = datapackProvider.getRegistryProvider();
        generator.addProvider(event.includeServer(), datapackProvider);
        generator.addProvider(event.includeServer(), new SHBiomeTagGenerator(packOutput, lookupProvider, existingFileHelper));



        generator.addProvider(event.includeServer(), new SHStructureTagGenerator(packOutput, lookupProvider1, existingFileHelper));

//        generator.addProvider(event.includeServer(), new ModGlobalLootModifiersProvider(packOutput));

//        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));
//

//        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
//        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));
//
//        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
//        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
//
//        ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
//                new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
//        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
//
//        generator.addProvider(event.includeServer(), new ModGlobalLootModifiersProvider(packOutput));
//        generator.addProvider(event.includeServer(), new ModPoiTypeTagsProvider(packOutput, lookupProvider, existingFileHelper));
//
//        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));
    }
}
