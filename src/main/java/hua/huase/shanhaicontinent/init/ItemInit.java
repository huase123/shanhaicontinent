package hua.huase.shanhaicontinent.init;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capability.playerattribute.WuHunName;
import hua.huase.shanhaicontinent.functiontypes.FunctionTypeInit;
import hua.huase.shanhaicontinent.item.*;
import hua.huase.shanhaicontinent.item.armor.SHArmorBaseItem;
import hua.huase.shanhaicontinent.item.armor.SHArmorMaterial;
import hua.huase.shanhaicontinent.item.guoshi.WuhunGuoshiItem;
import hua.huase.shanhaicontinent.item.hunji.HunjiItem;
import hua.huase.shanhaicontinent.item.jineng.haotianshengchui.*;
import hua.huase.shanhaicontinent.item.jineng.huang.*;
import hua.huase.shanhaicontinent.item.jineng.jinggubang.*;
import hua.huase.shanhaicontinent.item.tool.SHTiers;
import hua.huase.shanhaicontinent.item.wuhun.WuhunItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemInit {



    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SHMainBus.MOD_ID);

//    public static final RegistryObject<Item> TEXTITEM = ITEMS.register("textitem",
//            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> sheyeitem = ITEMS.register("sheyeitem",
            () -> new SHEyeitem(new Item.Properties()));

    public static final RegistryObject<Item> TEXTITEM = ITEMS.register("textitem",
            () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setJingyan(28));

    public static final RegistryObject<Item> TEXTITEM1 = ITEMS.register("textitem1",
            () -> new TextItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())));

    public static final RegistryObject<Item> wanfajieshao = ITEMS.register("wanfajieshao",
            () -> new WanfajieshaoItem(new Item.Properties()));

    public static final RegistryObject<Item> hunhuan0 = ITEMS.register("hunhuan0", () -> new HunHuanitem(FunctionTypeInit.defense));


    public static ArrayList<Item> hunjilist = new ArrayList<>();

    public static final RegistryObject<Item> hunji0 = ITEMS.register("hunji0", () -> new HunjiItem(FunctionTypeInit.defense));
    public static final RegistryObject<Item> hunji1 = ITEMS.register("hunji1", () -> new HunjiItem(FunctionTypeInit.defense));
    public static final RegistryObject<Item> hunji2 = ITEMS.register("hunji2", () -> new HunjiItem(FunctionTypeInit.defense));
    public static final RegistryObject<Item> hunji3 = ITEMS.register("hunji3", () -> new HunjiItem(FunctionTypeInit.defense));
    public static final RegistryObject<Item> hunji4 = ITEMS.register("hunji4", () -> new HunjiItem(FunctionTypeInit.defense));
    public static final RegistryObject<Item> hunji5 = ITEMS.register("hunji5", () -> new HunjiItem(FunctionTypeInit.defense));
    public static final RegistryObject<Item> hunji6 = ITEMS.register("hunji6", () -> new HunjiItem(FunctionTypeInit.defense));
    public static final RegistryObject<Item> hunji7 = ITEMS.register("hunji7", () -> new HunjiItem(FunctionTypeInit.defense));
    public static final RegistryObject<Item> hunji8 = ITEMS.register("hunji8", () -> new HunjiItem(FunctionTypeInit.defense));
    public static final RegistryObject<Item> hunji9 = ITEMS.register("hunji9", () -> new HunjiItem(FunctionTypeInit.defense));

    public static ArrayList<Item> wuhunlist = new ArrayList<>();
    public static final RegistryObject<Item> wuhun0 = ITEMS.register("wuhun0", () -> new WuhunItem(FunctionTypeInit.defense));
    public static final RegistryObject<Item> wuhun1 = ITEMS.register("wuhun1", () -> new WuhunItem(FunctionTypeInit.defense));
    public static final RegistryObject<Item> wuhun2 = ITEMS.register("wuhun2", () -> new WuhunItem(FunctionTypeInit.defense));
    public static final RegistryObject<Item> wuhun3 = ITEMS.register("wuhun3", () -> new WuhunItem(FunctionTypeInit.defense));



    public static final RegistryObject<Item> hunyeping0 = ITEMS.register("hunyeping0", () -> new HunyePing(new Item.Properties().stacksTo(1)).setMaxnengliang(300));
    public static final RegistryObject<Item> hunyeping1 = ITEMS.register("hunyeping1", () -> new HunyePing(new Item.Properties().stacksTo(1)).setMaxnengliang(600));
    public static final RegistryObject<Item> hunyeping2 = ITEMS.register("hunyeping2", () -> new HunyePing(new Item.Properties().fireResistant().stacksTo(1)).setMaxnengliang(1200));
    public static final RegistryObject<Item> hunyeping3 = ITEMS.register("hunyeping3", () -> new HunyePing(new Item.Properties().fireResistant().stacksTo(1)).setMaxnengliang(2400));
    public static final RegistryObject<Item> hunyeping4 = ITEMS.register("hunyeping4", () -> new HunyePing(new Item.Properties().fireResistant().stacksTo(1)).setMaxnengliang(4800));
    public static final RegistryObject<Item> hunyeping5 = ITEMS.register("hunyeping5", () -> new HunyePing(new Item.Properties().fireResistant().stacksTo(1)).setMaxnengliang(9600));
    public static final RegistryObject<Item> hunyeping6 = ITEMS.register("hunyeping6", () -> new HunyePing(new Item.Properties().fireResistant().stacksTo(1)).setMaxnengliang(99999));


    public static ArrayList<RegistryObject<Item>> hunyepinglist = new ArrayList<>();
    static {
        hunyepinglist.add(hunyeping0);
        hunyepinglist.add(hunyeping1);
        hunyepinglist.add(hunyeping2);
        hunyepinglist.add(hunyeping3);
        hunyepinglist.add(hunyeping4);
        hunyepinglist.add(hunyeping5);
        hunyepinglist.add(hunyeping6);
    }


    public static final RegistryObject<Item> jineng_jgb_0 = ITEMS.register("jineng_jgb_0", () -> new Jineng_JGB_0(Tiers.NETHERITE, 7, -0.4F, new Item.Properties()));
    public static final RegistryObject<Item> jineng_jgb_1 = ITEMS.register("jineng_jgb_1", () -> new Jineng_JGB_1(new Item.Properties()));
    public static final RegistryObject<Item> jineng_jgb_2 = ITEMS.register("jineng_jgb_2", () -> new Jineng_JGB_2(new Item.Properties()));
    public static final RegistryObject<Item> jineng_jgb_3 = ITEMS.register("jineng_jgb_3", () -> new Jineng_JGB_3(new Item.Properties()));
    public static final RegistryObject<Item> jineng_jgb_4 = ITEMS.register("jineng_jgb_4", () -> new Jineng_JGB_4(new Item.Properties()));
    public static final RegistryObject<Item> jineng_jgb_5 = ITEMS.register("jineng_jgb_5", () -> new Jineng_JGB_5(new Item.Properties()));
    public static final RegistryObject<Item> jineng_jgb_6 = ITEMS.register("jineng_jgb_6", () -> new Jineng_JGB_6(new Item.Properties()));
    public static final RegistryObject<Item> jineng_jgb_7 = ITEMS.register("jineng_jgb_7", () -> new Jineng_JGB_7(new Item.Properties()));
    public static final RegistryObject<Item> jineng_jgb_8 = ITEMS.register("jineng_jgb_8", () -> new Jineng_JGB_8(new Item.Properties()));


    public static final RegistryObject<Item> jineng_huang_0 = ITEMS.register("jineng_huang_0", () -> new Jineng_Huang_0(Tiers.NETHERITE, 1, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> jineng_huang_1 = ITEMS.register("jineng_huang_1", () -> new Jineng_Huang_1(new Item.Properties()));
    public static final RegistryObject<Item> jineng_huang_2 = ITEMS.register("jineng_huang_2", () -> new Jineng_Huang_2(new Item.Properties()));
    public static final RegistryObject<Item> jineng_huang_3 = ITEMS.register("jineng_huang_3", () -> new Jineng_Huang_3(new Item.Properties()));
    public static final RegistryObject<Item> jineng_huang_4 = ITEMS.register("jineng_huang_4", () -> new Jineng_Huang_4(new Item.Properties()));
    public static final RegistryObject<Item> jineng_huang_5 = ITEMS.register("jineng_huang_5", () -> new Jineng_Huang_5(new Item.Properties()));
    public static final RegistryObject<Item> jineng_huang_6 = ITEMS.register("jineng_huang_6", () -> new Jineng_Huang_6(new Item.Properties()));
    public static final RegistryObject<Item> jineng_huang_7 = ITEMS.register("jineng_huang_7", () -> new Jineng_Huang_7(new Item.Properties()));
    public static final RegistryObject<Item> jineng_huang_8 = ITEMS.register("jineng_huang_8", () -> new Jineng_Huang_8(new Item.Properties()));

    public static final RegistryObject<Item> jineng_htsc_0 = ITEMS.register("jineng_htsc_0", () -> new Jineng_HTSC_0(Tiers.NETHERITE, 1, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> jineng_htsc_1 = ITEMS.register("jineng_htsc_1", () -> new Jineng_HTSC_1(new Item.Properties()));
    public static final RegistryObject<Item> jineng_htsc_2 = ITEMS.register("jineng_htsc_2", () -> new Jineng_HTSC_2(new Item.Properties()));
    public static final RegistryObject<Item> jineng_htsc_3 = ITEMS.register("jineng_htsc_3", () -> new Jineng_HTSC_3(Tiers.NETHERITE, 1, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> jineng_htsc_4 = ITEMS.register("jineng_htsc_4", () -> new Jineng_HTSC_4(new Item.Properties()));
    public static final RegistryObject<Item> jineng_htsc_5 = ITEMS.register("jineng_htsc_5", () -> new Jineng_HTSC_5(new Item.Properties()));
    public static final RegistryObject<Item> jineng_htsc_6 = ITEMS.register("jineng_htsc_6", () -> new Jineng_HTSC_6(new Item.Properties()));
    public static final RegistryObject<Item> jineng_htsc_7 = ITEMS.register("jineng_htsc_7", () -> new Jineng_HTSC_7(new Item.Properties()));
    public static final RegistryObject<Item> jineng_htsc_8 = ITEMS.register("jineng_htsc_8", () -> new Jineng_HTSC_8(new Item.Properties()));


    public static HashMap<String,ArrayList<RegistryObject<Item>>> JINENGMAP = new HashMap();
    static {
        ArrayList<RegistryObject<Item>> Jienglist1 = new ArrayList<>();
        Jienglist1.add(jineng_jgb_0);
        Jienglist1.add(jineng_jgb_1);
        Jienglist1.add(jineng_jgb_2);
        Jienglist1.add(jineng_jgb_3);
        Jienglist1.add(jineng_jgb_4);
        Jienglist1.add(jineng_jgb_5);
        Jienglist1.add(jineng_jgb_6);
        Jienglist1.add(jineng_jgb_7);
        Jienglist1.add(jineng_jgb_8);
        JINENGMAP.put(WuHunName.jingubang,Jienglist1);

        ArrayList<RegistryObject<Item>> Jienglist2 = new ArrayList<>();
        Jienglist2.add(jineng_huang_0);
        Jienglist2.add(jineng_huang_1);
        Jienglist2.add(jineng_huang_2);
        Jienglist2.add(jineng_huang_3);
        Jienglist2.add(jineng_huang_4);
        Jienglist2.add(jineng_huang_5);
        Jienglist2.add(jineng_huang_6);
        Jienglist2.add(jineng_huang_7);
        Jienglist2.add(jineng_huang_8);
        JINENGMAP.put(WuHunName.huang,Jienglist2);

        ArrayList<RegistryObject<Item>> Jienglist3 = new ArrayList<>();
        Jienglist3.add(jineng_htsc_0);
        Jienglist3.add(jineng_htsc_1);
        Jienglist3.add(jineng_htsc_2);
        Jienglist3.add(jineng_htsc_3);
        Jienglist3.add(jineng_htsc_4);
        Jienglist3.add(jineng_htsc_5);
        Jienglist3.add(jineng_htsc_6);
        Jienglist3.add(jineng_htsc_7);
        Jienglist3.add(jineng_htsc_8);
        JINENGMAP.put(WuHunName.haotianchui,Jienglist3);

    }

    public static final RegistryObject<Item> guoshi_huang = ITEMS.register("guoshi_huang",() -> new WuhunGuoshiItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setWuhunname(WuHunName.huang));
    public static final RegistryObject<Item> guoshi_jingubang = ITEMS.register("guoshi_jingubang",() -> new WuhunGuoshiItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setWuhunname(WuHunName.jingubang));
    public static final RegistryObject<Item> guoshi_haotianchui = ITEMS.register("guoshi_haotianchui",() -> new WuhunGuoshiItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setWuhunname(WuHunName.haotianchui));



    public static final RegistryObject<Item> danyao_qihundan        = ITEMS.register("danyao_qihundan",       () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setJingyan(6));
    public static final RegistryObject<Item> danyao_jvlingdan       = ITEMS.register("danyao_jvlingdan",     () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setJingyan(18));
    public static final RegistryObject<Item> danyao_xvanyuandan     = ITEMS.register("danyao_xvanyuandan", () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setJingyan(54));
    public static final RegistryObject<Item> danyao_yanghundan      = ITEMS.register("danyao_yanghundan",   () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setJingyan(208));
    public static final RegistryObject<Item> danyao_lingbidan       = ITEMS.register("danyao_lingbidan",     () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setJingyan(416));
    public static final RegistryObject<Item> danyao_haoyuan         = ITEMS.register("danyao_haoyuan",         () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setJingyan(832));
    public static final RegistryObject<Item> danyao_xihundan        = ITEMS.register("danyao_xihundan",       () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setJingyan(1664));
    public static final RegistryObject<Item> danyao_huangjidan      = ITEMS.register("danyao_huangjidan",   () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setJingyan(3338));
    public static final RegistryObject<Item> danyao_lushendan       = ITEMS.register("danyao_lushendan",     () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setJingyan(6666));
    public static final RegistryObject<Item> danyao_jiuhua          = ITEMS.register("danyao_jiuhua",           () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setJingshenli(100).setMaxjingshenli(10));

    public static final RegistryObject<Item> danyao_huanyuandan          = ITEMS.register("danyao_huanyuandan",           () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setShengming(100));
    public static final RegistryObject<Item> danyao_fanmindan          = ITEMS.register("danyao_fanmindan",           () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setShengmingbaifenbi(10));
    public static final RegistryObject<Item> danyao_heqidan          = ITEMS.register("danyao_heqidan",           () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setJingshenli(80));
    public static final RegistryObject<Item> danyao_zengqidan          = ITEMS.register("danyao_zengqidan",           () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setJingshenlibaifenbi(5));




    public static final RegistryObject<Item> danyao_yishendan          = ITEMS.register("danyao_yishendan",           () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setMaxjingshenli(300).setMaxused(10));
    public static final RegistryObject<Item> danyao_xisuidan          = ITEMS.register("danyao_xisuidan",           () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setMaxshengming(200).setKangbao(3).setWufang(100).setMaxused(10));
    public static final RegistryObject<Item> danyao_longlidan          = ITEMS.register("danyao_longlidan",           () -> new DanYaoItem(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().build())).setWugong(66).setWuchuan(10).setBaojishanghai(2).setBaojilv(2).setMaxused(10));

    public static ArrayList<RegistryObject<Item>> DANYAOLIST = new ArrayList<>();
    static {
        DANYAOLIST.add(danyao_qihundan);
        DANYAOLIST.add(danyao_jvlingdan);
        DANYAOLIST.add(danyao_xvanyuandan);
        DANYAOLIST.add(danyao_yanghundan);
        DANYAOLIST.add(danyao_lingbidan);
        DANYAOLIST.add(danyao_haoyuan);
        DANYAOLIST.add(danyao_xihundan);
        DANYAOLIST.add(danyao_huangjidan);
        DANYAOLIST.add(danyao_lushendan);
        DANYAOLIST.add(danyao_jiuhua);
        DANYAOLIST.add(danyao_huanyuandan);
        DANYAOLIST.add(danyao_fanmindan);
        DANYAOLIST.add(danyao_heqidan);
        DANYAOLIST.add(danyao_zengqidan);

        DANYAOLIST.add(danyao_yishendan);
        DANYAOLIST.add(danyao_xisuidan);
        DANYAOLIST.add(danyao_longlidan);
    }

    public static final RegistryObject<Item> danfang_qihundan       = ITEMS.register("danfang_qihundan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });
    public static final RegistryObject<Item> danfang_jvlingdan      = ITEMS.register("danfang_jvlingdan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });
    public static final RegistryObject<Item> danfang_xvanyuandan    = ITEMS.register("danfang_xvanyuandan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });
    public static final RegistryObject<Item> danfang_yanghundan     = ITEMS.register("danfang_yanghundan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });
    public static final RegistryObject<Item> danfang_lingbidan      = ITEMS.register("danfang_lingbidan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });
    public static final RegistryObject<Item> danfang_haoyuan        = ITEMS.register("danfang_haoyuan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });
    public static final RegistryObject<Item> danfang_xihundan       = ITEMS.register("danfang_xihundan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });
    public static final RegistryObject<Item> danfang_huangjidan     = ITEMS.register("danfang_huangjidan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });
    public static final RegistryObject<Item> danfang_lushendan      = ITEMS.register("danfang_lushendan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });
    public static final RegistryObject<Item> danfang_jiuhua         = ITEMS.register("danfang_jiuhua", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });

    public static final RegistryObject<Item> danfang_huanyuandan         = ITEMS.register("danfang_huanyuandan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });


    public static final RegistryObject<Item> danfang_fanmindan         = ITEMS.register("danfang_fanmindan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });


    public static final RegistryObject<Item> danfang_heqidan         = ITEMS.register("danfang_heqidan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });


    public static final RegistryObject<Item> danfang_zengqidan         = ITEMS.register("danfang_zengqidan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });
    public static final RegistryObject<Item> danfang_yishendan         = ITEMS.register("danfang_yishendan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });
    public static final RegistryObject<Item> danfang_xisuidan         = ITEMS.register("danfang_xisuidan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });
    public static final RegistryObject<Item> danfang_longlidan         = ITEMS.register("danfang_longlidan", () -> new Item(new Item.Properties()){
        public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
            list.add(Component.translatable("击杀《古风小屋》中的魂民概率掉落").withStyle(ChatFormatting.GRAY));
        }
    });


    public static ArrayList<RegistryObject<Item>> DANFANGLIST = new ArrayList<>();
    static {
        DANFANGLIST.add(danfang_qihundan);
        DANFANGLIST.add(danfang_jvlingdan);
        DANFANGLIST.add(danfang_xvanyuandan);
        DANFANGLIST.add(danfang_yanghundan);
        DANFANGLIST.add(danfang_lingbidan);
        DANFANGLIST.add(danfang_haoyuan);
        DANFANGLIST.add(danfang_xihundan);
        DANFANGLIST.add(danfang_huangjidan);
        DANFANGLIST.add(danfang_lushendan);
        DANFANGLIST.add(danfang_jiuhua);
        DANFANGLIST.add(danfang_huanyuandan);
        DANFANGLIST.add(danfang_fanmindan);
        DANFANGLIST.add(danfang_heqidan);
        DANFANGLIST.add(danfang_zengqidan);
        DANFANGLIST.add(danfang_yishendan);
        DANFANGLIST.add(danfang_xisuidan);
        DANFANGLIST.add(danfang_longlidan);
    }



    public static final RegistryObject<Item> headbone       = ITEMS.register("headbone", () -> new BoneItem(new Item.Properties()).setArramIndex(0));
    public static final RegistryObject<Item> exoskeletonsoulbone = ITEMS.register("exoskeletonsoulbone", () -> new BoneItem(new Item.Properties()).setArramIndex(1));
    public static final RegistryObject<Item> lefthandbone   = ITEMS.register("lefthandbone", () -> new BoneItem(new Item.Properties()).setArramIndex(2));
    public static final RegistryObject<Item> righthandbone  = ITEMS.register("righthandbone", () -> new BoneItem(new Item.Properties()).setArramIndex(3));
    public static final RegistryObject<Item> trunkbone      = ITEMS.register("trunkbone", () -> new BoneItem(new Item.Properties()).setArramIndex(4));
    public static final RegistryObject<Item> leftlegbone    = ITEMS.register("leftlegbone", () -> new BoneItem(new Item.Properties()).setArramIndex(5));
    public static final RegistryObject<Item> rightlegbone   = ITEMS.register("rightlegbone", () -> new BoneItem(new Item.Properties()).setArramIndex(6));


    public static ArrayList<RegistryObject<Item>> HUNGULIST = new ArrayList<>();
    static {
        HUNGULIST.add(headbone);
        HUNGULIST.add(lefthandbone);
        HUNGULIST.add(leftlegbone);
        HUNGULIST.add(righthandbone);
        HUNGULIST.add(rightlegbone);
        HUNGULIST.add(trunkbone);
        HUNGULIST.add(exoskeletonsoulbone);
    }




    //植物
    public static final RegistryObject<Item> baisuilan_seed     = ITEMS.register("baisuilan_seed", () -> new ItemNameBlockItem(BlockInit.baisuilan.get(),new Item.Properties()));
    public static final RegistryObject<Item> baisuilan_fruit    = ITEMS.register("baisuilan_fruit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> fengxinzi_seed     = ITEMS.register("fengxinzi_seed", () -> new ItemNameBlockItem(BlockInit.fengxinzi.get(),new Item.Properties()));
    public static final RegistryObject<Item> fengxinzi_fruit    = ITEMS.register("fengxinzi_fruit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> hanxiaohua_seed    = ITEMS.register("hanxiaohua_seed", () -> new ItemNameBlockItem(BlockInit.hanxiaohua.get(),new Item.Properties()));
    public static final RegistryObject<Item> hanxiaohua_fruit   = ITEMS.register("hanxiaohua_fruit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> hehuan_seed        = ITEMS.register("hehuan_seed", () -> new ItemNameBlockItem(BlockInit.hehuan.get(),new Item.Properties()));
    public static final RegistryObject<Item> hehuan_fruit       = ITEMS.register("hehuan_fruit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> heshouwu_seed      = ITEMS.register("heshouwu_seed", () -> new ItemNameBlockItem(BlockInit.heshouwu.get(),new Item.Properties()));
    public static final RegistryObject<Item> heshouwu_fruit     = ITEMS.register("heshouwu_fruit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> qiuhaitang_seed    = ITEMS.register("qiuhaitang_seed", () -> new ItemNameBlockItem(BlockInit.qiuhaitang.get(),new Item.Properties()));
    public static final RegistryObject<Item> qiuhaitang_fruit   = ITEMS.register("qiuhaitang_fruit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> shancha_seed       = ITEMS.register("shancha_seed", () -> new ItemNameBlockItem(BlockInit.shancha.get(),new Item.Properties()));
    public static final RegistryObject<Item> shancha_fruit      = ITEMS.register("shancha_fruit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> wangyoucao_seed    = ITEMS.register("wangyoucao_seed", () -> new ItemNameBlockItem(BlockInit.wangyoucao.get(),new Item.Properties()));
    public static final RegistryObject<Item> wangyoucao_fruit   = ITEMS.register("wangyoucao_fruit", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> xiwu_seed          = ITEMS.register("xiwu_seed", () -> new ItemNameBlockItem(BlockInit.xiwu.get(),new Item.Properties()));
    public static final RegistryObject<Item> xiwu_fruit         = ITEMS.register("xiwu_fruit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> xunyicao_seed      = ITEMS.register("xunyicao_seed", () -> new ItemNameBlockItem(BlockInit.xunyicao.get(),new Item.Properties()));
    public static final RegistryObject<Item> xunyicao_fruit     = ITEMS.register("xunyicao_fruit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> yueguanghua_seed   = ITEMS.register("yueguanghua_seed", () -> new ItemNameBlockItem(BlockInit.yueguanghua.get(),new Item.Properties()));
    public static final RegistryObject<Item> yueguanghua_fruit  = ITEMS.register("yueguanghua_fruit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> zhushamei_seed     = ITEMS.register("zhushamei_seed", () -> new ItemNameBlockItem(BlockInit.zhushamei.get(),new Item.Properties()));
    public static final RegistryObject<Item> zhushamei_fruit    = ITEMS.register("zhushamei_fruit", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> bianhua_seed       = ITEMS.register("bianhua_seed", () -> new ItemNameBlockItem(BlockInit.bianhua.get(),new Item.Properties()));
    public static final RegistryObject<Item> bianhua_fruit      = ITEMS.register("bianhua_fruit", () -> new Item(new Item.Properties()));

    public static ArrayList<RegistryObject<Item>> SEEDLIST = new ArrayList<>();
    static {
        SEEDLIST.add(baisuilan_seed);
        SEEDLIST.add(fengxinzi_seed);
        SEEDLIST.add(hanxiaohua_seed);
        SEEDLIST.add(hehuan_seed);
        SEEDLIST.add(heshouwu_seed);
        SEEDLIST.add(qiuhaitang_seed);
        SEEDLIST.add(shancha_seed);
        SEEDLIST.add(wangyoucao_seed);
        SEEDLIST.add(xiwu_seed);
        SEEDLIST.add(xunyicao_seed);
        SEEDLIST.add(yueguanghua_seed);
        SEEDLIST.add(zhushamei_seed);
        SEEDLIST.add(bianhua_seed);
    }

    public static ArrayList<RegistryObject<Item>> FRUITLIST = new ArrayList<>();
    static {
        FRUITLIST.add(baisuilan_fruit);
        FRUITLIST.add(fengxinzi_fruit);
        FRUITLIST.add(hanxiaohua_fruit);
        FRUITLIST.add(hehuan_fruit);
        FRUITLIST.add(heshouwu_fruit);
        FRUITLIST.add(qiuhaitang_fruit);
        FRUITLIST.add(shancha_fruit);
        FRUITLIST.add(wangyoucao_fruit);
        FRUITLIST.add(xiwu_fruit);
        FRUITLIST.add(xunyicao_fruit);
        FRUITLIST.add(yueguanghua_fruit);
        FRUITLIST.add(zhushamei_fruit);
        FRUITLIST.add(bianhua_fruit);
    }


//    装备

    public static final RegistryObject<Item> itemmingtie      = ITEMS.register("itemmingtie",       () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> itemheijin       = ITEMS.register("itemheijin",        () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> itemlanlingjin   = ITEMS.register("itemlanlingjin",    () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> itemlanhaizuan   = ITEMS.register("itemlanhaizuan",    () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> itemcixuexianjin = ITEMS.register("itemcixuexianjin",  () -> new Item(new Item.Properties().fireResistant()));
    public static final RegistryObject<Item> itemkongjianshi = ITEMS.register("itemkongjianshi",    () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> mingtie_head   = ITEMS.register("mingtie_head", () -> new SHArmorBaseItem(SHArmorMaterial.mingtie, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> mingtie_chest  = ITEMS.register("mingtie_chest", () -> new SHArmorBaseItem(SHArmorMaterial.mingtie, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> mingtie_feet   = ITEMS.register("mingtie_feet", () -> new SHArmorBaseItem(SHArmorMaterial.mingtie, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final RegistryObject<Item> mingtie_legs   = ITEMS.register("mingtie_legs", () -> new SHArmorBaseItem(SHArmorMaterial.mingtie, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> mingtie_axe        = ITEMS.register("mingtie_axe",         () -> new AxeItem(      SHTiers.mingtie, 5, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> mingtie_hoe        = ITEMS.register("mingtie_hoe",         () -> new HoeItem(      SHTiers.mingtie, 5, -1.4F, new Item.Properties()));
    public static final RegistryObject<Item> mingtie_pickaxe    = ITEMS.register("mingtie_pickaxe",     () -> new PickaxeItem(  SHTiers.mingtie, 5, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> mingtie_shovel     = ITEMS.register("mingtie_shovel",      () -> new ShovelItem(   SHTiers.mingtie, 5, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> mingtie_sword      = ITEMS.register("mingtie_sword",       () -> new SwordItem(    SHTiers.mingtie, 13, -2.4F, new Item.Properties()));

    public static final RegistryObject<Item> heijin_head         = ITEMS.register("heijin_head",      () -> new SHArmorBaseItem(SHArmorMaterial.heijin, ArmorItem.Type.HELMET, new Item.Properties()    .fireResistant()));
    public static final RegistryObject<Item> heijin_chest        = ITEMS.register("heijin_chest",       () -> new SHArmorBaseItem(SHArmorMaterial.heijin, ArmorItem.Type.CHESTPLATE, new Item.Properties()  .fireResistant()));
    public static final RegistryObject<Item> heijin_feet         = ITEMS.register("heijin_feet",       () -> new SHArmorBaseItem(SHArmorMaterial.heijin, ArmorItem.Type.BOOTS, new Item.Properties()    .fireResistant()));
    public static final RegistryObject<Item> heijin_legs     = ITEMS.register("heijin_legs",       () -> new SHArmorBaseItem(SHArmorMaterial.heijin, ArmorItem.Type.LEGGINGS, new Item.Properties() .fireResistant()));
    public static final RegistryObject<Item> heijin_axe        = ITEMS.register("heijin_axe",         () -> new AxeItem(      SHTiers.heijin, 7, -2.4F, new Item.Properties()   .fireResistant()));
    public static final RegistryObject<Item> heijin_hoe        = ITEMS.register("heijin_hoe",         () -> new HoeItem(      SHTiers.heijin, 7, -0.4F, new Item.Properties()   .fireResistant()));
    public static final RegistryObject<Item> heijin_pickaxe    = ITEMS.register("heijin_pickaxe",     () -> new PickaxeItem(  SHTiers.heijin, 7, -2.4F, new Item.Properties()   .fireResistant()));
    public static final RegistryObject<Item> heijin_shovel     = ITEMS.register("heijin_shovel",      () -> new ShovelItem(   SHTiers.heijin, 7, -2.4F, new Item.Properties()   .fireResistant()));
    public static final RegistryObject<Item> heijin_sword      = ITEMS.register("heijin_sword",       () -> new SwordItem(    SHTiers.heijin, 26, -2.4F, new Item.Properties()  .fireResistant()));


    public static final RegistryObject<Item> lanlingjin_head      = ITEMS.register("lanlingjin_head",       () -> new SHArmorBaseItem(SHArmorMaterial.lanlingjin, ArmorItem.Type.HELMET, new Item.Properties()  .fireResistant()));
    public static final RegistryObject<Item> lanlingjin_chest     = ITEMS.register("lanlingjin_chest",      () -> new SHArmorBaseItem(SHArmorMaterial.lanlingjin, ArmorItem.Type.CHESTPLATE, new Item.Properties()  .fireResistant()));
    public static final RegistryObject<Item> lanlingjin_feet      = ITEMS.register("lanlingjin_feet",       () -> new SHArmorBaseItem(SHArmorMaterial.lanlingjin, ArmorItem.Type.BOOTS, new Item.Properties()   .fireResistant()));
    public static final RegistryObject<Item> lanlingjin_legs      = ITEMS.register("lanlingjin_legs",       () -> new SHArmorBaseItem(SHArmorMaterial.lanlingjin, ArmorItem.Type.LEGGINGS, new Item.Properties()    .fireResistant()));
    public static final RegistryObject<Item> lanlingjin_axe        = ITEMS.register("lanlingjin_axe",         () -> new AxeItem(      SHTiers.lanlingjin, 9, -2.4F, new Item.Properties()   .fireResistant()));
    public static final RegistryObject<Item> lanlingjin_hoe        = ITEMS.register("lanlingjin_hoe",         () -> new HoeItem(      SHTiers.lanlingjin, 9, 1.0F, new Item.Properties()    .fireResistant()));
    public static final RegistryObject<Item> lanlingjin_pickaxe    = ITEMS.register("lanlingjin_pickaxe",     () -> new PickaxeItem(  SHTiers.lanlingjin, 9, -2.4F, new Item.Properties()   .fireResistant()));
    public static final RegistryObject<Item> lanlingjin_shovel     = ITEMS.register("lanlingjin_shovel",      () -> new ShovelItem(   SHTiers.lanlingjin, 9, -2.4F, new Item.Properties()   .fireResistant()));
    public static final RegistryObject<Item> lanlingjin_sword      = ITEMS.register("lanlingjin_sword",       () -> new SwordItem(    SHTiers.lanlingjin, 52, -2.4F, new Item.Properties()  .fireResistant()));


    public static final RegistryObject<Item> lanhaizuan_head      = ITEMS.register("lanhaizuan_head",       () -> new SHArmorBaseItem(SHArmorMaterial.lanhaizuan, ArmorItem.Type.HELMET, new Item.Properties()  .fireResistant()));
    public static final RegistryObject<Item> lanhaizuan_chest     = ITEMS.register("lanhaizuan_chest",      () -> new SHArmorBaseItem(SHArmorMaterial.lanhaizuan, ArmorItem.Type.CHESTPLATE, new Item.Properties()  .fireResistant()));
    public static final RegistryObject<Item> lanhaizuan_feet      = ITEMS.register("lanhaizuan_feet",       () -> new SHArmorBaseItem(SHArmorMaterial.lanhaizuan, ArmorItem.Type.BOOTS, new Item.Properties()   .fireResistant()));
    public static final RegistryObject<Item> lanhaizuan_legs      = ITEMS.register("lanhaizuan_legs",       () -> new SHArmorBaseItem(SHArmorMaterial.lanhaizuan, ArmorItem.Type.LEGGINGS, new Item.Properties()    .fireResistant()));
    public static final RegistryObject<Item> lanhaizuan_axe        = ITEMS.register("lanhaizuan_axe",         () -> new AxeItem(      SHTiers.lanhaizuan, 11, -2.4F, new Item.Properties()  .fireResistant()));
    public static final RegistryObject<Item> lanhaizuan_hoe        = ITEMS.register("lanhaizuan_hoe",         () -> new HoeItem(      SHTiers.lanhaizuan, 11, 2.0F, new Item.Properties()   .fireResistant()));
    public static final RegistryObject<Item> lanhaizuan_pickaxe    = ITEMS.register("lanhaizuan_pickaxe",     () -> new PickaxeItem(  SHTiers.lanhaizuan, 11, -2.4F, new Item.Properties()  .fireResistant()));
    public static final RegistryObject<Item> lanhaizuan_shovel     = ITEMS.register("lanhaizuan_shovel",      () -> new ShovelItem(   SHTiers.lanhaizuan, 11, -2.4F, new Item.Properties()  .fireResistant()));
    public static final RegistryObject<Item> lanhaizuan_sword      = ITEMS.register("lanhaizuan_sword",       () -> new SwordItem(    SHTiers.lanhaizuan, 104, -1.4F, new Item.Properties()  .fireResistant()));


    public static final RegistryObject<Item> cixuexianjin_head      = ITEMS.register("cixuexianjin_head",       () -> new SHArmorBaseItem(SHArmorMaterial.cixuexianjin, ArmorItem.Type.HELMET, new Item.Properties()    .fireResistant()));
    public static final RegistryObject<Item> cixuexianjin_chest     = ITEMS.register("cixuexianjin_chest",      () -> new SHArmorBaseItem(SHArmorMaterial.cixuexianjin, ArmorItem.Type.CHESTPLATE, new Item.Properties()    .fireResistant()));
    public static final RegistryObject<Item> cixuexianjin_feet      = ITEMS.register("cixuexianjin_feet",       () -> new SHArmorBaseItem(SHArmorMaterial.cixuexianjin, ArmorItem.Type.BOOTS, new Item.Properties() .fireResistant()));
    public static final RegistryObject<Item> cixuexianjin_legs      = ITEMS.register("cixuexianjin_legs",       () -> new SHArmorBaseItem(SHArmorMaterial.cixuexianjin, ArmorItem.Type.LEGGINGS, new Item.Properties()  .fireResistant()));
    public static final RegistryObject<Item> cixuexianjin_axe        = ITEMS.register("cixuexianjin_axe",         () -> new AxeItem(      SHTiers.cixuexianjin, 14, -2.4F, new Item.Properties()    .fireResistant()));
    public static final RegistryObject<Item> cixuexianjin_hoe        = ITEMS.register("cixuexianjin_hoe",         () -> new HoeItem(      SHTiers.cixuexianjin, 14, 3.0F, new Item.Properties() .fireResistant()));
    public static final RegistryObject<Item> cixuexianjin_pickaxe    = ITEMS.register("cixuexianjin_pickaxe",     () -> new PickaxeItem(  SHTiers.cixuexianjin, 14, -2.4F, new Item.Properties()    .fireResistant()));
    public static final RegistryObject<Item> cixuexianjin_shovel     = ITEMS.register("cixuexianjin_shovel",      () -> new ShovelItem(   SHTiers.cixuexianjin, 14, -2.4F, new Item.Properties()    .fireResistant()));
    public static final RegistryObject<Item> cixuexianjin_sword      = ITEMS.register("cixuexianjin_sword",       () -> new SwordItem(    SHTiers.cixuexianjin, 208, -0.4F, new Item.Properties()    .fireResistant()));




    public static ArrayList<RegistryObject<Item>> ARMORLIST = new ArrayList<>();
    static {
        ARMORLIST.add(itemmingtie       );
        ARMORLIST.add(itemheijin        );
        ARMORLIST.add(itemlanlingjin    );
        ARMORLIST.add(itemlanhaizuan    );
        ARMORLIST.add(itemcixuexianjin  );
        ARMORLIST.add(itemkongjianshi   );

        ARMORLIST.add(mingtie_head  );
        ARMORLIST.add(mingtie_chest );
        ARMORLIST.add(mingtie_feet  );
        ARMORLIST.add(mingtie_legs  );
        ARMORLIST.add(mingtie_axe      );
        ARMORLIST.add(mingtie_hoe      );
        ARMORLIST.add(mingtie_pickaxe  );
        ARMORLIST.add(mingtie_shovel   );
        ARMORLIST.add(mingtie_sword    );

        ARMORLIST.add(heijin_head       );
        ARMORLIST.add(heijin_chest      );
        ARMORLIST.add(heijin_feet       );
        ARMORLIST.add(heijin_legs       );
        ARMORLIST.add(heijin_axe      );
        ARMORLIST.add(heijin_hoe      );
        ARMORLIST.add(heijin_pickaxe  );
        ARMORLIST.add(heijin_shovel   );
        ARMORLIST.add(heijin_sword    );

        ARMORLIST.add(lanlingjin_head    );
        ARMORLIST.add(lanlingjin_chest   );
        ARMORLIST.add(lanlingjin_feet    );
        ARMORLIST.add(lanlingjin_legs    );
        ARMORLIST.add(lanlingjin_axe      );
        ARMORLIST.add(lanlingjin_hoe      );
        ARMORLIST.add(lanlingjin_pickaxe  );
        ARMORLIST.add(lanlingjin_shovel   );
        ARMORLIST.add(lanlingjin_sword    );

        ARMORLIST.add(lanhaizuan_head    );
        ARMORLIST.add(lanhaizuan_chest   );
        ARMORLIST.add(lanhaizuan_feet    );
        ARMORLIST.add(lanhaizuan_legs    );
        ARMORLIST.add(lanhaizuan_axe      );
        ARMORLIST.add(lanhaizuan_hoe      );
        ARMORLIST.add(lanhaizuan_pickaxe  );
        ARMORLIST.add(lanhaizuan_shovel   );
        ARMORLIST.add(lanhaizuan_sword    );

        ARMORLIST.add(cixuexianjin_head    );
        ARMORLIST.add(cixuexianjin_chest   );
        ARMORLIST.add(cixuexianjin_feet    );
        ARMORLIST.add(cixuexianjin_legs    );
        ARMORLIST.add(cixuexianjin_axe      );
        ARMORLIST.add(cixuexianjin_hoe      );
        ARMORLIST.add(cixuexianjin_pickaxe  );
        ARMORLIST.add(cixuexianjin_shovel   );
        ARMORLIST.add(cixuexianjin_sword    );

    }


    public static final RegistryObject<Item> hunmin_spanw_egg = ITEMS.register("hunmin_spanw_egg",
            () -> new ForgeSpawnEggItem(EntityInit.hunmin, 0x888888, 0xff0000, new Item.Properties()));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
