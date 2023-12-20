package hua.huase.shanhaicontinent.handers;


import hua.huase.shanhaicontinent.block.BlockPot;
import hua.huase.shanhaicontinent.block.BlockSHPortal;
import hua.huase.shanhaicontinent.block.FlowerBlock;
import hua.huase.shanhaicontinent.block.soulsoil.SoulSoil;
import hua.huase.shanhaicontinent.creativetab.TabExample;
import hua.huase.shanhaicontinent.item.*;
import hua.huase.shanhaicontinent.item.bone.*;
import hua.huase.shanhaicontinent.item.bonemeal.SoulBoneMeal;
import hua.huase.shanhaicontinent.item.danfangdir.DanFang;
import hua.huase.shanhaicontinent.item.danfangdir.DanFangJiuHua;
import hua.huase.shanhaicontinent.item.jineng.WuHunHuang;
import hua.huase.shanhaicontinent.item.jineng.WuHunJingubang;
import hua.huase.shanhaicontinent.item.jineng.huang.*;
import hua.huase.shanhaicontinent.item.jineng.jingubang.*;
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
    public static Item danfangjiuhua ;
    public static Item hunye ;
    public static Item danyao ;
    public static Item danyaojiuhua ;
    //注册方块
    public static FlowerBlock baisuilan= new FlowerBlock("baisuilan",TabExample.TAB1);
    public static FlowerBlock fengxinzi= new FlowerBlock("fengxinzi",TabExample.TAB1);
    public static FlowerBlock hanxiaohua= new FlowerBlock("hanxiaohua",TabExample.TAB1);
    public static FlowerBlock hehuan= new FlowerBlock("hehuan",TabExample.TAB1);
    public static FlowerBlock heshouwu= new FlowerBlock("heshouwu",TabExample.TAB1);
    public static FlowerBlock qiuhaitang= new FlowerBlock("qiuhaitang",TabExample.TAB1);
    public static FlowerBlock shancha= new FlowerBlock("shancha",TabExample.TAB1);
    public static FlowerBlock wangyoucao= new FlowerBlock("wangyoucao",TabExample.TAB1);
    public static FlowerBlock xiwu= new FlowerBlock("xiwu",TabExample.TAB1);
    public static FlowerBlock xunyicao= new FlowerBlock("xunyicao",TabExample.TAB1);
    public static FlowerBlock yueguanghua= new FlowerBlock("yueguanghua",TabExample.TAB1);
    public static FlowerBlock zhushamei= new FlowerBlock("zhushamei",TabExample.TAB1);
    public static FlowerBlock bianhua= new FlowerBlock("bianhua",TabExample.TAB1);



    public static Block soulsoil ;
    public static Block pot ;
    public static Block shportal ;

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {

        // 和物品一样，每一个方块都有唯一一个注册名，不能使用大写字母。


        soulsoil = new SoulSoil("soulsoil",TabExample.TAB1);
        pot = new BlockPot("pot",TabExample.TAB1);
        shportal = new BlockSHPortal();

        event.getRegistry().registerAll(blockList.toArray(new Block[0]));
        event.getRegistry().register(shportal);
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

        new Wuqijingubang("wuqijingubang", TabExample.TAB2);
        new WuqijnFSHY("wuqijnfshy", TabExample.TAB2);
        new WuqijnJGZ("wuqijnjgz", TabExample.TAB2);
        new WuqijnDH("wuqijndh", TabExample.TAB2);
        new WuqijnJDY("wuqijnjdy", TabExample.TAB2);
        new WuqijnJLCY("wuqijnjlcy", TabExample.TAB2);
        new WuqijnJGZS("wuqijnjgzs", TabExample.TAB2);
        new WuqijnDZSY("wuqijndzsy", TabExample.TAB2);
        new WuqijnDZSFT("wuqijndzsft", TabExample.TAB2);

        new WuHunHuangyishenweizhong("wuhunhuangyishenweizhong", TabExample.TAB2);
        new WuHunHuangKPBS("wuhunhuangkpbs", TabExample.TAB2);
        new WuHunHuangSNSL("wuhunhuangsnsl", TabExample.TAB2);
        new WuHunHuangLSF("wuhunhuanglsf", TabExample.TAB2);
        new WuHunHuangCMJJ("wuhunhuangcmjj", TabExample.TAB2);
        new WuHunHuangLDLHG("wuhunhuangldlhg", TabExample.TAB2);
        new WuHunHuangLHBS("wuhunhuanglhbs", TabExample.TAB2);
        new WuHunHuangBSQ("wuhunhuangbsq", TabExample.TAB2);
        new WuHunHuangBZMZZS("wuhunhuangbzmzzs", TabExample.TAB2);


        new WuHunHuang("huang",TabExample.TAB2);
        new WuHunJingubang("jingubang",TabExample.TAB2);


        new ItemTextPickaxe("textpickaxe", TabExample.TAB1);
        new ItemTextSword("textsword", TabExample.TAB1);
        new Lianyaohu("lianyaohu", TabExample.TAB1);

        new ExoskeletonBone("exoskeletonbone", TabExample.TAB1);
        new HeadBone("headbone", TabExample.TAB1);
        new LeftHandBone("lefthandbone", TabExample.TAB1);
        new LeftLegBone("leftlegbone", TabExample.TAB1);
        new RightHandBone("righthandbone", TabExample.TAB1);
        new RightLegBone("rightlegbone", TabExample.TAB1);
        new TrunkBone("trunkbone", TabExample.TAB1);
        new SoulBoneMeal("soulbonemeal", TabExample.TAB1);
        new DanFang("danfang", TabExample.TAB1);
        new DanFangJiuHua("danfangjiuhua", TabExample.TAB1);
        new Hunye("hunye", TabExample.TAB1);
        new Danyao("danyao", TabExample.TAB1);
        new DanyaoJiuhua("danyaojiuhua", TabExample.TAB1);
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
        e.getRegistry().register(bianhua.itemBlock);

    }










    /*


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
            ModelLoader.setCustomModelResourceLocation(
                    bianhua.itemBlock,
                    i,
                    new ModelResourceLocation(new ResourceLocation(bianhua.itemBlock.getRegistryName().toString()+"_age"+i),"inventory")
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
