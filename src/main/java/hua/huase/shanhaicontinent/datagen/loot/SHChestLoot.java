package hua.huase.shanhaicontinent.datagen.loot;

import hua.huase.shanhaicontinent.item.ItemInit;
import hua.huase.shanhaicontinent.world.lootables.SHLootTables;
import net.minecraft.data.loot.packs.VanillaChestLoot;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.StructureTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ExplorationMapFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetNameFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class SHChestLoot extends VanillaChestLoot {

    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> p_250931_) {
        p_250931_.accept(SHLootTables.gufengxiaowu0, isnullchest());
    }

    public static LootTable.Builder shipwreckMapLootTable() {
        return LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.MAP)
                                        .apply(ExplorationMapFunction.makeExplorationMap()
                                                .setDestination(StructureTags.ON_TREASURE_MAPS)
                                                .setMapDecoration(MapDecoration.Type.RED_X)
                                                .setZoom((byte)1)
                                                .setSkipKnownStructures(false))
                                        .apply(SetNameFunction
                                                .setName(Component.translatable("filled_map.buried_treasure")))))
                .withPool(
                        LootPool.lootPool().setRolls(ConstantValue.exactly(3.0F))
                                .add(LootItem.lootTableItem(Items.COMPASS))
                                .add(LootItem.lootTableItem(Items.MAP))
                                .add(LootItem.lootTableItem(Items.CLOCK))
                                .add(LootItem.lootTableItem(Items.PAPER)
                                        .setWeight(20)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 10.0F))))
                                .add(LootItem.lootTableItem(Items.FEATHER).setWeight(10)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
                                .add(LootItem.lootTableItem(Items.BOOK)
                                        .setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F)))))
                .withPool(
                        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(EmptyLootItem.emptyItem().setWeight(5))
                                .add(LootItem.lootTableItem(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE)
                                        .setWeight(1)
                                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))));
    }

    private static LootPool.Builder danyao = LootPool.lootPool().setRolls(UniformGenerator.between(1.0F, 3.0F))
            .add(LootItem.lootTableItem(ItemInit.danyao_jiuhua.get())       .setWeight(100).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_huanyuandan.get())  .setWeight(30).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_fanmindan.get())    .setWeight(20).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_heqidan.get())      .setWeight(30).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_zengqidan.get())    .setWeight( 16).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_qihundan.get())     .setWeight( 8).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0F, 5.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_jvlingdan.get())    .setWeight( 8).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_xvanyuandan.get())  .setWeight( 4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_yanghundan.get())   .setWeight( 4).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_lingbidan.get())    .setWeight( 3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_haoyuan.get())      .setWeight( 3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_xihundan.get())     .setWeight( 3).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_huangjidan.get())   .setWeight( 2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_lushendan.get())    .setWeight( 1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_yishendan.get())    .setWeight( 1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_xisuidan.get())     .setWeight( 1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
            .add(LootItem.lootTableItem(ItemInit.danyao_longlidan.get())    .setWeight( 1).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))
            ;


    private static LootPool.Builder danfang = LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
            .add(LootItem.lootTableItem(ItemInit.danfang_qihundan.get())            .setWeight(90).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_jvlingdan.get())           .setWeight(70).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_xvanyuandan.get())         .setWeight(50).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_yanghundan.get())          .setWeight(40).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_lingbidan.get())           .setWeight(30).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_haoyuan.get())             .setWeight(20).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_xihundan.get())            .setWeight(15).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_huangjidan.get())          .setWeight(10).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_lushendan.get())           .setWeight(5 ).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_jiuhua.get())              .setWeight(80).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_huanyuandan.get())         .setWeight(90).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_fanmindan.get())           .setWeight(50).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_heqidan.get())             .setWeight(90).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_zengqidan.get())           .setWeight(50).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_yishendan.get())           .setWeight(5).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_xisuidan.get())           .setWeight(5).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.danfang_longlidan.get())           .setWeight(5).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            ;

    private static LootPool.Builder seed = LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
            .add(LootItem.lootTableItem(ItemInit.baisuilan_seed.get())           .setWeight(90).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 4.0F))))
            .add(LootItem.lootTableItem(ItemInit.fengxinzi_seed.get())           .setWeight(70).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 4.0F))))
            .add(LootItem.lootTableItem(ItemInit.hanxiaohua_seed.get())          .setWeight(50).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 4.0F))))
            .add(LootItem.lootTableItem(ItemInit.hehuan_seed.get())              .setWeight(40).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 4.0F))))
            .add(LootItem.lootTableItem(ItemInit.heshouwu_seed.get())            .setWeight(30).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 4.0F))))
            .add(LootItem.lootTableItem(ItemInit.qiuhaitang_seed.get())          .setWeight(20).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 4.0F))))
            .add(LootItem.lootTableItem(ItemInit.shancha_seed.get())             .setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 4.0F))))
            .add(LootItem.lootTableItem(ItemInit.wangyoucao_seed.get())          .setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 4.0F))))
            .add(LootItem.lootTableItem(ItemInit.xiwu_seed.get())                .setWeight(5 ).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 4.0F))))
            .add(LootItem.lootTableItem(ItemInit.xunyicao_seed.get())            .setWeight(90).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
            .add(LootItem.lootTableItem(ItemInit.yueguanghua_seed.get())         .setWeight(50).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
            .add(LootItem.lootTableItem(ItemInit.zhushamei_seed.get())           .setWeight(90).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))))
            .add(LootItem.lootTableItem(ItemInit.bianhua_seed.get())             .setWeight(50).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F))));

    private static LootPool.Builder fruit = LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
            .add(LootItem.lootTableItem(ItemInit.baisuilan_fruit.get())          .setWeight(90).apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))))
            .add(LootItem.lootTableItem(ItemInit.fengxinzi_fruit.get())          .setWeight(70).apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))))
            .add(LootItem.lootTableItem(ItemInit.hanxiaohua_fruit.get())         .setWeight(50).apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))))
            .add(LootItem.lootTableItem(ItemInit.hehuan_fruit.get())             .setWeight(40).apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))))
            .add(LootItem.lootTableItem(ItemInit.heshouwu_fruit.get())           .setWeight(30).apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))))
            .add(LootItem.lootTableItem(ItemInit.qiuhaitang_fruit.get())         .setWeight(20).apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))))
            .add(LootItem.lootTableItem(ItemInit.shancha_fruit.get())            .setWeight(15).apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))))
            .add(LootItem.lootTableItem(ItemInit.wangyoucao_fruit.get())         .setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))))
            .add(LootItem.lootTableItem(ItemInit.xiwu_fruit.get())               .setWeight(5 ).apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))))
            .add(LootItem.lootTableItem(ItemInit.xunyicao_fruit.get())           .setWeight(90).apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))))
            .add(LootItem.lootTableItem(ItemInit.yueguanghua_fruit.get())        .setWeight(50).apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))))
            .add(LootItem.lootTableItem(ItemInit.zhushamei_fruit.get())          .setWeight(90).apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))))
            .add(LootItem.lootTableItem(ItemInit.bianhua_fruit.get())            .setWeight(50).apply(SetItemCountFunction.setCount(UniformGenerator.between(5.0F, 10.0F))));

    private static LootPool.Builder oreitem = LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
            .add(LootItem.lootTableItem(ItemInit.itemmingtie     .get())          .setWeight(90).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 6.0F))))
            .add(LootItem.lootTableItem(ItemInit.itemheijin      .get())          .setWeight(40).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 6.0F))))
            .add(LootItem.lootTableItem(ItemInit.itemlanlingjin  .get())          .setWeight(20).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 6.0F))))
            .add(LootItem.lootTableItem(ItemInit.itemlanhaizuan  .get())          .setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 6.0F))))
            .add(LootItem.lootTableItem(ItemInit.itemcixuexianjin.get())          .setWeight(5 ).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 6.0F))))
            .add(LootItem.lootTableItem(ItemInit.itemkongjianshi .get())          .setWeight(90).apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 6.0F))));


    private static LootPool.Builder armorandtool = LootPool.lootPool().setRolls(UniformGenerator.between(0.0F, 1.0F))
            .add(LootItem.lootTableItem(ItemInit.hunyeping0     .get()).setWeight(1).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.hunyeping1     .get()).setWeight(1).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.hunyeping2     .get()).setWeight(1).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.hunyeping3     .get()).setWeight(1).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.hunyeping4     .get()).setWeight(1).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.hunyeping5     .get()).setWeight(1).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.hunyeping6     .get()).setWeight(1).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.mingtie_head     .get()).setWeight(20).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.mingtie_chest    .get()).setWeight(20).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.mingtie_feet     .get()).setWeight(20).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.mingtie_legs     .get()).setWeight(20).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.mingtie_axe      .get()).setWeight(20).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.mingtie_hoe      .get()).setWeight(20).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.mingtie_pickaxe  .get()).setWeight(20).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.mingtie_shovel   .get()).setWeight(20).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
            .add(LootItem.lootTableItem(ItemInit.mingtie_sword    .get()).setWeight(20).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))));


    public static LootTable.Builder isnullchest() {


        return LootTable.lootTable()
                .withPool(danyao)
                .withPool(danfang)
                .withPool(seed)
                .withPool(fruit)
                .withPool(oreitem)
                .withPool(armorandtool)
                ;
    }

}
