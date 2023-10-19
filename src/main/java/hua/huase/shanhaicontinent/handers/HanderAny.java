package hua.huase.shanhaicontinent.handers;


import hua.huase.shanhaicontinent.block.BlockPot;
import hua.huase.shanhaicontinent.block.FlowerBlock;
import hua.huase.shanhaicontinent.block.soulsoil.SoulSoil;
import hua.huase.shanhaicontinent.creativetab.TabExample;
import hua.huase.shanhaicontinent.item.Danyao;
import hua.huase.shanhaicontinent.item.Hunye;
import hua.huase.shanhaicontinent.item.ItemTextPickaxe;
import hua.huase.shanhaicontinent.item.ItemTextSword;
import hua.huase.shanhaicontinent.item.bone.*;
import hua.huase.shanhaicontinent.item.bonemeal.SoulBoneMeal;
import hua.huase.shanhaicontinent.item.danfangdir.DanFang;
import hua.huase.shanhaicontinent.tileentity.TileEntityPot;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class HanderAny {

    public static List<Item> itemList = new ArrayList();

    public static List<Block> blockList = new ArrayList();

//    方块创建
//public static final OreRuby ORE_RUBY = new OreRuby();


    public static IForgeRegistry<Item> registry = null;

    public static ItemBlock soulSoilItem;
    public static Item soulbonemeal ;
    public static Item danfang ;
    public static Item hunye ;
    public static Item danyao ;
    //注册方块
    public static FlowerBlock baisuilan= new FlowerBlock("baisuilan",TabExample.TAB2);
    public static FlowerBlock fengxinzi= new FlowerBlock("fengxinzi",TabExample.TAB2);
    public static FlowerBlock hanxiaohua= new FlowerBlock("hanxiaohua",TabExample.TAB2);
    public static FlowerBlock hehuan= new FlowerBlock("hehuan",TabExample.TAB2);
    public static FlowerBlock heshouwu= new FlowerBlock("heshouwu",TabExample.TAB2);
    public static FlowerBlock qiuhaitang= new FlowerBlock("qiuhaitang",TabExample.TAB2);
    public static FlowerBlock shancha= new FlowerBlock("shancha",TabExample.TAB2);
    public static FlowerBlock wangyoucao= new FlowerBlock("wangyoucao",TabExample.TAB2);
    public static FlowerBlock xiwu= new FlowerBlock("xiwu",TabExample.TAB2);
    public static FlowerBlock xunyicao= new FlowerBlock("xunyicao",TabExample.TAB2);
    public static FlowerBlock yueguanghua= new FlowerBlock("yueguanghua",TabExample.TAB2);
    public static FlowerBlock zhushamei= new FlowerBlock("zhushamei",TabExample.TAB2);



    public static Block soulsoil ;
    public static Block pot ;

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {

        // 和物品一样，每一个方块都有唯一一个注册名，不能使用大写字母。


        soulsoil = new SoulSoil("soulsoil",TabExample.TAB2);
        pot = new BlockPot("pot",TabExample.TAB2);


        event.getRegistry().registerAll(blockList.toArray(new Block[0]));
        TileEntity.register(TileEntityPot.ID, TileEntityPot.class);
    }


    //方块itme注册
    public static void registerBlockItme(Block block, String name, CreativeTabs creativeTabs){
        itemList.add((new ItemBlock(block).setRegistryName(name).setCreativeTab(creativeTabs).setUnlocalizedName(name)));
    }


    //注册物品
    @SubscribeEvent
    public static void handleItem(RegistryEvent.Register<Item> e){
        registry=e.getRegistry();
        new ItemTextPickaxe("textpickaxe", TabExample.TAB2);
        new ItemTextSword("textsword", TabExample.TAB2);

        new ExoskeletonBone("exoskeletonbone", TabExample.TAB2);
        new HeadBone("headbone", TabExample.TAB2);
        new LeftHandBone("lefthandbone", TabExample.TAB2);
        new LeftLegBone("leftlegbone", TabExample.TAB2);
        new RightHandBone("righthandbone", TabExample.TAB2);
        new RightLegBone("rightlegbone", TabExample.TAB2);
        new TrunkBone("trunkbone", TabExample.TAB2);
        new SoulBoneMeal("soulbonemeal", TabExample.TAB2);
        new DanFang("danfang", TabExample.TAB2);
        new Hunye("hunye", TabExample.TAB2);
        new Danyao("danyao", TabExample.TAB2);
        e.getRegistry().registerAll(itemList.toArray(new Item[0]));
        e.getRegistry().register(soulSoilItem);
        e.getRegistry().register(soulbonemeal);
        e.getRegistry().register(danfang);
        e.getRegistry().register(hunye);
        e.getRegistry().register(danyao);

        e.getRegistry().register(baisuilan.itemBlock);
        e.getRegistry().register(fengxinzi.itemBlock);
        e.getRegistry().register(hanxiaohua.itemBlock);
        e.getRegistry().register(hehuan.itemBlock);
        e.getRegistry().register(heshouwu.itemBlock);
        e.getRegistry().register(qiuhaitang.itemBlock);
        e.getRegistry().register(shancha.itemBlock);
        e.getRegistry().register(wangyoucao.itemBlock);
        e.getRegistry().register(xiwu.itemBlock);
        e.getRegistry().register(xunyicao.itemBlock);
        e.getRegistry().register(yueguanghua.itemBlock);
        e.getRegistry().register(zhushamei.itemBlock);

    }










/*



    //注册群系
    @SubscribeEvent
    public static void registryBioms(RegistryEvent.Register<Biome> event){
        Biome.BiomeProperties properties = new Biome.BiomeProperties("zdy_BIOME");
        properties.setBaseHeight(-0.5f).setWaterColor(0xffffff).setHeightVariation(1.0f);

        Biome biome = new Biome(properties){};
        biome.setRegistryName("new biome");

        biome.topBlock= Blocks.LAPIS_BLOCK.getDefaultState();
        BiomeManager.addSpawnBiome(biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM,new BiomeManager.BiomeEntry(biome,9999));


        event.getRegistry().register(biome);

        BiomeDictionary.addTypes(biome,BiomeDictionary.Type.COLD);
    }






    public static int dimID = 21;
    public static DimensionType myDim;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // 第一个参数代表此维度的内部名称。
        // 第二个参数是村庄等数据保存时会用到的“当前维度的专有后缀名”。
        // 第三个参数是维度 ID。维度 ID 是基于 Minecraft 1.12.2 的 Forge Mod 开发中
        // 仍然需要手动指定数字 ID 的游戏内容，也因此几乎所有的 Modder 都会允许通过配置文件
        // 修改维度 ID。
        // 第四个参数是该维度使用的 WorldProvider 的类。要求这个类有零参构造器。
        // 第五个参数代表“是否保持该维度的 spawn 区块一直加载”。
        myDim = DimensionType.register("my_dimension", "_my_dim", dimID, MyWorldProvider.class, false);
        // 在拿到自己的维度的 myDimType 后，需要再向 Forge 告知这一新的 DimensionType 的存在，
        // 否则某些 Forge 加入的功能会无法在你的新维度中工作。
        // 第一个参数仍然是维度 ID，和上面保持一致即可。
        DimensionManager.registerDimension(dimID, myDim);
    }


*/



    //注册模型
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onModelreg(ModelRegistryEvent event){
        for(Item item:itemList){
            ModelLoader.setCustomModelResourceLocation(
                    item,
                    0,
                    new ModelResourceLocation(item.getRegistryName(),"inventory")
                    );

        }

        for (int i = 0; i <=8; i++) {

            ModelLoader.setCustomModelResourceLocation(
                    soulSoilItem,
                    i,
                    new ModelResourceLocation(new ResourceLocation(soulSoilItem.getRegistryName().toString()+"_age"+i),"inventory")
            );

            ModelLoader.setCustomModelResourceLocation(
                    soulbonemeal,
                    i,
                    new ModelResourceLocation(new ResourceLocation(soulbonemeal.getRegistryName().toString()+"_age"+i),"inventory")
            );

            ModelLoader.setCustomModelResourceLocation(
                    danfang,
                    i,
                    new ModelResourceLocation(new ResourceLocation(danfang.getRegistryName().toString()+"_age"+i),"inventory")
            );

            ModelLoader.setCustomModelResourceLocation(
                    danyao,
                    i,
                    new ModelResourceLocation(new ResourceLocation(danyao.getRegistryName().toString()+"_age"+i),"inventory")
            );

        }

        for (int i = 0; i <=6; i++) {

            ModelLoader.setCustomModelResourceLocation(
                    baisuilan.itemBlock,
                    i,
                    new ModelResourceLocation(new ResourceLocation(baisuilan.itemBlock.getRegistryName().toString()+"_age"+i),"inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    fengxinzi.itemBlock,
                    i,
                    new ModelResourceLocation(new ResourceLocation(fengxinzi.itemBlock.getRegistryName().toString()+"_age"+i),"inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    hanxiaohua.itemBlock,
                    i,
                    new ModelResourceLocation(new ResourceLocation(hanxiaohua.itemBlock.getRegistryName().toString()+"_age"+i),"inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    hehuan.itemBlock,
                    i,
                    new ModelResourceLocation(new ResourceLocation(hehuan.itemBlock.getRegistryName().toString()+"_age"+i),"inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    heshouwu.itemBlock,
                    i,
                    new ModelResourceLocation(new ResourceLocation(heshouwu.itemBlock.getRegistryName().toString()+"_age"+i),"inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    qiuhaitang.itemBlock,
                    i,
                    new ModelResourceLocation(new ResourceLocation(qiuhaitang.itemBlock.getRegistryName().toString()+"_age"+i),"inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    shancha.itemBlock,
                    i,
                    new ModelResourceLocation(new ResourceLocation(shancha.itemBlock.getRegistryName().toString()+"_age"+i),"inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    wangyoucao.itemBlock,
                    i,
                    new ModelResourceLocation(new ResourceLocation(wangyoucao.itemBlock.getRegistryName().toString()+"_age"+i),"inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    xiwu.itemBlock,
                    i,
                    new ModelResourceLocation(new ResourceLocation(xiwu.itemBlock.getRegistryName().toString()+"_age"+i),"inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    xunyicao.itemBlock,
                    i,
                    new ModelResourceLocation(new ResourceLocation(xunyicao.itemBlock.getRegistryName().toString()+"_age"+i),"inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    yueguanghua.itemBlock,
                    i,
                    new ModelResourceLocation(new ResourceLocation(yueguanghua.itemBlock.getRegistryName().toString()+"_age"+i),"inventory")
            );
            ModelLoader.setCustomModelResourceLocation(
                    zhushamei.itemBlock,
                    i,
                    new ModelResourceLocation(new ResourceLocation(zhushamei.itemBlock.getRegistryName().toString()+"_age"+i),"inventory")
            );




        }

        for (int i = 0; i <=5; i++) {
            ModelLoader.setCustomModelResourceLocation(
                    hunye,
                    i,
                    new ModelResourceLocation(new ResourceLocation(hunye.getRegistryName().toString()+"_age"+i),"inventory")
            );
        }

    }

}
