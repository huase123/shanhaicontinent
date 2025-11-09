package hua.huase.shanhaicontinent.datagen.loot;

import hua.huase.shanhaicontinent.block.entityblock.flowerblock.SHFlowerBlock;
import hua.huase.shanhaicontinent.init.BlockInit;
import hua.huase.shanhaicontinent.item.ItemInit;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

import static hua.huase.shanhaicontinent.init.BlockInit.ORELIST;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(BlockInit.SAPPHIRE_BLOCK.get());
        this.dropSelf(BlockInit.POT_BLOCK.get());
        this.dropSelf(BlockInit.SOUL_BLOCK.get());
        for (RegistryObject<Block> blockRegistryObject : ORELIST) {
            this.dropSelf(blockRegistryObject.get());
        }


        this.dropFlower(BlockInit.baisuilan.get(),ItemInit.baisuilan_fruit.get(),ItemInit.baisuilan_seed.get());
        this.dropFlower(BlockInit.fengxinzi.get(),ItemInit.fengxinzi_fruit.get(),ItemInit.fengxinzi_seed.get());
        this.dropFlower(BlockInit.hanxiaohua.get(),ItemInit.hanxiaohua_fruit.get(),ItemInit.hanxiaohua_seed.get());
        this.dropFlower(BlockInit.hehuan.get(),ItemInit.hehuan_fruit.get(),ItemInit.hehuan_seed.get());
        this.dropFlower(BlockInit.heshouwu.get(),ItemInit.heshouwu_fruit.get(),ItemInit.heshouwu_seed.get());
        this.dropFlower(BlockInit.qiuhaitang.get(),ItemInit.qiuhaitang_fruit.get(),ItemInit.qiuhaitang_seed.get());
        this.dropFlower(BlockInit.shancha.get(),ItemInit.shancha_fruit.get(),ItemInit.shancha_seed.get());
        this.dropFlower(BlockInit.wangyoucao.get(),ItemInit.wangyoucao_fruit.get(),ItemInit.wangyoucao_seed.get());
        this.dropFlower(BlockInit.xiwu.get(),ItemInit.xiwu_fruit.get(),ItemInit.xiwu_seed.get());
        this.dropFlower(BlockInit.xunyicao.get(),ItemInit.xunyicao_fruit.get(),ItemInit.xunyicao_seed.get());
        this.dropFlower(BlockInit.yueguanghua.get(),ItemInit.yueguanghua_fruit.get(),ItemInit.yueguanghua_seed.get());
        this.dropFlower(BlockInit.zhushamei.get(),ItemInit.zhushamei_fruit.get(),ItemInit.zhushamei_seed.get());
        this.dropFlower(BlockInit.bianhua.get(),ItemInit.bianhua_fruit.get(),ItemInit.bianhua_seed.get());




//
//        this.dropSelf(ModBlocks.SAPPHIRE_BLOCK.get());
//        this.dropSelf(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
//        this.dropSelf(ModBlocks.SOUND_BLOCK.get());
//
//        this.add(ModBlocks.SAPPHIRE_ORE.get(),
//                block -> createCopperLikeOreDrops(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
//        this.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
//                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
//        this.add(ModBlocks.NETHER_SAPPHIRE_ORE.get(),
//                block -> createCopperLikeOreDrops(ModBlocks.NETHER_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
//        this.add(ModBlocks.END_STONE_SAPPHIRE_ORE.get(),
//                block -> createCopperLikeOreDrops(ModBlocks.END_STONE_SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get()));
//
//        this.dropSelf(ModBlocks.SAPPHIRE_STAIRS.get());
//        this.dropSelf(ModBlocks.SAPPHIRE_BUTTON.get());
//        this.dropSelf(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
//        this.dropSelf(ModBlocks.SAPPHIRE_TRAPDOOR.get());
//        this.dropSelf(ModBlocks.SAPPHIRE_FENCE.get());
//        this.dropSelf(ModBlocks.SAPPHIRE_FENCE_GATE.get());
//        this.dropSelf(ModBlocks.SAPPHIRE_WALL.get());
//
//        this.add(ModBlocks.SAPPHIRE_SLAB.get(),
//                block -> createSlabItemTable(ModBlocks.SAPPHIRE_SLAB.get()));
//        this.add(ModBlocks.SAPPHIRE_DOOR.get(),
//                block -> createDoorTable(ModBlocks.SAPPHIRE_DOOR.get()));
//
//        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
//                .hasBlockStateProperties(ModBlocks.STRAWBERRY_CROP.get())
//                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 5));
//
//        this.add(ModBlocks.STRAWBERRY_CROP.get(), createCropDrops(ModBlocks.STRAWBERRY_CROP.get(), ModItems.STRAWBERRY.get(),
//                ModItems.STRAWBERRY_SEEDS.get(), lootitemcondition$builder));
//
//
//        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
//                .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
//                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 7))
//                .or(LootItemBlockStatePropertyCondition
//                        .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 8)));
//
//        // LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
//        //         .hasBlockStateProperties(ModBlocks.CORN_CROP.get())
//        //         .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CornCropBlock.AGE, 8));
//
//        this.add(ModBlocks.CORN_CROP.get(), createCropDrops(ModBlocks.CORN_CROP.get(), ModItems.CORN.get(),
//                ModItems.CORN_SEEDS.get(), lootitemcondition$builder2));
//
//        this.dropSelf(ModBlocks.CATMINT.get());
//        this.add(ModBlocks.POTTED_CATMINT.get(), createPotFlowerItemTable(ModBlocks.CATMINT.get()));
//
//        this.dropSelf(ModBlocks.GEM_POLISHING_STATION.get());
//
//        this.dropSelf(ModBlocks.PINE_LOG.get());
//        this.dropSelf(ModBlocks.PINE_WOOD.get());
//        this.dropSelf(ModBlocks.STRIPPED_PINE_LOG.get());
//        this.dropSelf(ModBlocks.STRIPPED_PINE_WOOD.get());
//        this.dropSelf(ModBlocks.PINE_PLANKS.get());
//
//        this.add(ModBlocks.PINE_LEAVES.get(), block ->
//                createLeavesDrops(block, ModBlocks.PINE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
//
//        this.add(ModBlocks.PINE_SIGN.get(), block ->
//                createSingleItemTable(ModItems.PINE_SIGN.get()));
//        this.add(ModBlocks.PINE_WALL_SIGN.get(), block ->
//                createSingleItemTable(ModItems.PINE_SIGN.get()));
//        this.add(ModBlocks.PINE_HANGING_SIGN.get(), block ->
//                createSingleItemTable(ModItems.PINE_HANGING_SIGN.get()));
//        this.add(ModBlocks.PINE_WALL_HANGING_SIGN.get(), block ->
//                createSingleItemTable(ModItems.PINE_HANGING_SIGN.get()));
//
//        this.dropSelf(ModBlocks.PINE_SAPLING.get());

    }


    private void dropFlower(Block block, Item item, Item item1) {
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(block)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SHFlowerBlock.AGE, 3));
        this.add(block, createCropDrops(block, item,
                item1, lootitemcondition$builder));
    }

    protected LootTable.Builder createCropDrops(Block p_249457_, Item p_248599_, Item p_251915_, LootItemCondition.Builder p_252202_) {
        return this.applyExplosionDecay(p_249457_, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(p_248599_).when(p_252202_).otherwise(LootItem.lootTableItem(p_251915_)))).withPool(LootPool.lootPool().when(p_252202_).add(LootItem.lootTableItem(p_251915_).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.07F, 3)))));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }



    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
