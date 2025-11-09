package hua.huase.shanhaicontinent.init;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.block.entityblock.flowerblock.SHFlowerBlock;
import hua.huase.shanhaicontinent.block.entityblock.pot.PotBlock;
import hua.huase.shanhaicontinent.block.entityblock.soulblock.SoulBlock;
import hua.huase.shanhaicontinent.item.ItemInit;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SHMainBus.MOD_ID);

    public static final RegistryObject<Block> SAPPHIRE_BLOCK = registerBlock("text_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));


    public static final RegistryObject<Block> blockkongjianshiore  = registerBlock("blockkongjianshiore",       () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(80.0F, 3200.0F).sound(SoundType.AMETHYST).lightLevel((p_152663_) -> {
      return 2;
   })));
    public static final RegistryObject<Block> blockmingtieore      = registerBlock("blockmingtieore",           () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(30.0F, 1200.0F).sound(SoundType.AMETHYST).lightLevel((p_152663_) -> {
      return 3;
   })));
    public static final RegistryObject<Block> blockheijinore       = registerFireBlock("blockheijinore",        () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(40.0F, 1600.0F).sound(SoundType.AMETHYST).lightLevel((p_152663_) -> {
      return 4;
   })));
    public static final RegistryObject<Block> blocklanlingjinore   = registerFireBlock("blocklanlingjinore",    () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(50.0F, 2000.0F).sound(SoundType.AMETHYST).lightLevel((p_152663_) -> {
      return 6;
   })));
    public static final RegistryObject<Block> blocklanhaizuanore   = registerFireBlock("blocklanhaizuanore",    () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(60.0F, 2400.0F).sound(SoundType.AMETHYST).lightLevel((p_152663_) -> {
      return 9;
   })));
    public static final RegistryObject<Block> blockcixuexianjinore = registerFireBlock("blockcixuexianjinore",  () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(70.0F, 2800.0F).sound(SoundType.AMETHYST).lightLevel((p_152663_) -> {
      return 12;
   })));

    public static final RegistryObject<Block> blockkongjianshi_block   = registerBlock("blockkongjianshi_block",            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(30.0F, 1200.0F).sound(SoundType.AMETHYST).lightLevel((p_152663_) -> {
      return 2;
   })));
    public static final RegistryObject<Block> blockmingtie_block       = registerBlock("blockmingtie_block",                () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(40.0F, 1600.0F).sound(SoundType.AMETHYST).lightLevel((p_152663_) -> {
      return 3;
   })));
    public static final RegistryObject<Block> blockheijin_block        = registerFireBlock("blockheijin_block",             () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(50.0F, 2000.0F).sound(SoundType.AMETHYST).lightLevel((p_152663_) -> {
      return 4;
   })));
    public static final RegistryObject<Block> blocklanlingjin_block    = registerFireBlock("blocklanlingjin_block",         () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(60.0F, 2400.0F).sound(SoundType.AMETHYST).lightLevel((p_152663_) -> {
      return 6;
   })));
    public static final RegistryObject<Block> blocklanhaizuan_block    = registerFireBlock("blocklanhaizuan_block",         () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(70.0F, 2800.0F).sound(SoundType.AMETHYST).lightLevel((p_152663_) -> {
      return 9;
   })));
    public static final RegistryObject<Block> blockcixuexianjin_block  = registerFireBlock("blockcixuexianjin_block",       () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(80.0F, 3200.0F).sound(SoundType.AMETHYST).lightLevel((p_152663_) -> {
      return 12;
   })));

    public static ArrayList<RegistryObject<Block>> ORELIST = new ArrayList<>();
    static {
        ORELIST.add(blockmingtieore);
        ORELIST.add(blockheijinore);
        ORELIST.add(blocklanlingjinore);
        ORELIST.add(blocklanhaizuanore);
        ORELIST.add(blockcixuexianjinore);
        ORELIST.add(blockkongjianshiore);

        ORELIST.add(blockmingtie_block      );
        ORELIST.add(blockheijin_block       );
        ORELIST.add(blocklanlingjin_block   );
        ORELIST.add(blocklanhaizuan_block   );
        ORELIST.add(blockcixuexianjin_block );
        ORELIST.add(blockkongjianshi_block  );
    }


    public static final RegistryObject<Block> SOUL_BLOCK = registerBlock("soul_block", () -> new SoulBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).randomTicks().strength(0.6F).sound(SoundType.GRAVEL)));
    public static final RegistryObject<Block> POT_BLOCK = registerBlock("pot_block", () -> new PotBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion()));

    public static final RegistryObject<Block> baisuilan = registerFlowerBlock("baisuilan", () -> new SHFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> fengxinzi = registerFlowerBlock("fengxinzi", () -> new SHFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> hanxiaohua = registerFlowerBlock("hanxiaohua", () -> new SHFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> hehuan = registerFlowerBlock("hehuan", () -> new SHFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> heshouwu = registerFlowerBlock("heshouwu", () -> new SHFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> qiuhaitang = registerFlowerBlock("qiuhaitang", () -> new SHFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> shancha = registerFlowerBlock("shancha", () -> new SHFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> wangyoucao = registerFlowerBlock("wangyoucao", () -> new SHFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> xiwu = registerFlowerBlock("xiwu", () -> new SHFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> xunyicao = registerFlowerBlock("xunyicao", () -> new SHFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> yueguanghua = registerFlowerBlock("yueguanghua", () -> new SHFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> zhushamei = registerFlowerBlock("zhushamei", () -> new SHFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> bianhua = registerFlowerBlock("bianhua", () -> new SHFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));


    public static ArrayList<RegistryObject<Block>> FLOWERLIST = new ArrayList<>();
    static {
        FLOWERLIST.add(baisuilan);
        FLOWERLIST.add(fengxinzi);
        FLOWERLIST.add(hanxiaohua);
        FLOWERLIST.add(hehuan);
        FLOWERLIST.add(heshouwu);
        FLOWERLIST.add(qiuhaitang);
        FLOWERLIST.add(shancha);
        FLOWERLIST.add(wangyoucao);
        FLOWERLIST.add(xiwu);
        FLOWERLIST.add(xunyicao);
        FLOWERLIST.add(yueguanghua);
        FLOWERLIST.add(zhushamei);
        FLOWERLIST.add(bianhua);
    }



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> RegistryObject<T> registerFireBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerFireBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerFireBlockItem(String name, RegistryObject<T> block) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()));
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerFlowerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
//        registerFlowerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerFlowerBlockItem(String name, RegistryObject<T> block) {
        ItemInit.ITEMS.register(name+"_fruit", () -> new Item(new Item.Properties()));
        return ItemInit.ITEMS.register(name+"_seed", () -> new ItemNameBlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
