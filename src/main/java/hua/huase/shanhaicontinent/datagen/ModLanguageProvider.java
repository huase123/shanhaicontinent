package hua.huase.shanhaicontinent.datagen;

import hua.huase.shanhaicontinent.init.BlockInit;
import hua.huase.shanhaicontinent.init.EntityInit;
import hua.huase.shanhaicontinent.item.ItemInit;
import hua.huase.shanhaicontinent.init.SHModMobEffectsinit;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
// In LanguageProvider#addTranslations
//        this.addBlock(BlockInit.text_block, "Example Block");
        this.add("套装效果", "套装效果:");
        this.add("套装描述", "十分耐用，非降维伤害，不可破坏");
        this.add("已破损", "已破损");
        this.add("未装配", "未装配");
        this.add("可通过造化炉修理", "可通过造化炉修理");
        this.add("所需能量", "§c所需能量：%s");
        this.add("生命", "生命：%s/%s");
        this.add("最大生命", "最大生命：+%s");
        this.add("获得生命", "生命：+%s");
        this.add("物攻", "物攻：+%s");
        this.add("物防", "物防：+%s");
        this.add("爆伤", "爆伤：+%s");
        this.add("爆率", "爆率：+%s");
        this.add("真伤", "真伤：+%s");
        this.add("物穿", "物穿：+%s");
        this.add("抗暴", "抗暴：+%s");
        this.add("吸血", "吸血：+%s");
        this.add("回复", "回复：+%s");
        this.add("命中", "命中：+%s");
        this.add("闪避", "闪避：+%s");
        this.add("经验", "经验：%s/%s");
        this.add("获得经验", "经验：+%s");
        this.add("等级", "等级：%s");
        this.add("转生", "转生：%s世");
        this.add("精神力", "精神力：%s/%s");
        this.add("获得精神力", "精神力：+%s");
        this.add("获得最大精神力", "最大精神力：+%s");
        this.add("体力", "体力：%s/%s");
        this.add("最大使用次数", "最大使用次数：%s");

        this.add("突破成功率", "突破成功率：+%s");
        this.add("能量", "能量：%s/%s");

        this.add("能量耗尽", "能量耗尽");
        this.add("能量已满", "能量已满");


        this.add("技能开关", "技能开关");
        this.add("武魂开关", "武魂开关");
        this.add("属性面板", "属性面板");
        this.add("右键<魂核>收集能量；右键<耕地>消耗能量，转化<魂土>", "右键<魂核>收集能量；右键<耕地>消耗能量，转化<魂土>");



        this.add("player join world", "§2-%s-§f来到了山海大陆———-§e山海大陆：§b宇宙之初，混沌演化，造化之气，造化万物，山川海势，万物而生");
        this.add("精神力不足", "精神力不足");
        this.add("吸收经验成功", "§2吸收成功,经验：§e+%s");
        this.add("突破成功", "§6成功进阶到§e%s级");
        this.add("不能突破", "§c无法突破：请先吸收魂环");
        this.add("已经满级", "§c无法突破：天地压制");
        this.add("突破失败", "§5突破失败，下次突破概率+5");

        this.add("未开启或觉醒武魂", "§c未开启或觉醒武魂");
        this.add("成功觉醒武魂", "§c成功觉醒武魂§c%s");
        this.add("成功吸收魂环", "§c成功吸收%s年魂环");
        this.add("等级不够", "§c等级不够或魂环已满，无法吸收魂环");
        this.add("正在吸收魂环", "§c正在吸收魂环，精神力-%s");


        this.add("服用后觉醒武魂", "§2服用后觉醒%s武魂");
//        this.add("jingubang",   "§4破天神棍");
//        this.add("huang",       "§e武魂-荒");
//        this.add("haotianchui", "§e浩天圣锤");


        this.add("已达到服用上限", "§4已达到服用上限");


        this.add("武魂已开启", "<<§c%s>> §a武魂已开启");
        this.add("武魂已关闭", "§a武魂已关闭");
        this.add("拥有者", "拥有者:%s");
        this.add("年限", "年限:%s");
        this.add("武魂技能", "技能：%s+%s年");


        this.add("block.tutorialmod.gem_polishing_station", "§6造化炉配方");
        this.add("creativetab.shanhaicontient_tab", "§7山海大陆");


//        物品说明
        this.add("用于栽培药材，可由《魂液瓶》消耗能量，右键耕地获得", "用于栽培药材，可由《魂液瓶》消耗能量，右键耕地获得");
        this.add("以造化之气，炼制物品", "以造化之气，炼制物品");


        this.add("玩法介绍", "玩法介绍");
        this.add("默认o键打开属性面板，可在属性面板装配", "默认o键打开属性面板，可在属性面板装配");
        this.add("击杀《古风小屋》中的魂民概率掉落", "击杀《古风小屋》中的魂民概率掉落");


//        技能说明
        this.add("蹲下释放可破环地形", "蹲下释放可破环地形");
        this.add("每10级提升5%的物攻、暴击率、爆伤", "每10级提升5%的物攻、暴击率、爆伤");
        this.add("能在地面上产生威力无比的震动，对前方造成伤害", "能在地面上产生威力无比的震动，对前方造成伤害");
        this.add("在短时间内产生坚实的防护罩", "在短时间内产生坚实的防护罩");
        this.add("每10级提升5%的物伤、暴击率、爆伤", "每10级提升5%的物伤、暴击率、爆伤");
        this.add("--副手生效", "--副手生效");
        this.add("发出强大的力量风暴，前方的敌人造成伤害", "发出强大的力量风暴，前方的敌人造成伤害");
        this.add("调用全身之力，形成力量风暴，对范围内的敌人照成伤害", "调用全身之力，形成力量风暴，对范围内的敌人照成伤害");
        this.add("锤影在周身形成一圈能量光罩进行防御", "锤影在周身形成一圈能量光罩进行防御");
        this.add("将全身魂力集中于一点迅速发出", "将全身魂力集中于一点迅速发出");
        this.add("引动天地之力，降下天雷", "引动天地之力，降下天雷");

        this.add("每10级提升4%的物攻、物防、真伤、爆伤、抗暴、回复", "每10级提升4%的物攻、物防、真伤、爆伤、抗暴、回复");
        this.add("向前位移，对路过的敌人造成伤害", "向前位移，对路过的敌人造成伤害");
        this.add("召唤雷电轰击地面", "召唤雷电轰击地面");
        this.add("造成伤害，并根据造成伤害的回复生命值", "造成伤害，并根据造成伤害的回复生命值");
        this.add("一株草可斩日月星辰!挑出一剑，对前方大范围敌人伤害", "一株草可斩日月星辰!挑出一剑，对前方大范围敌人伤害");
        this.add("刷新所有技能冷却", "刷新所有技能冷却");
        this.add("受到致命伤满血复活", "受到致命伤满血复活");
        this.add("对前方单体造成伤害", "对前方单体造成伤害");
        this.add("物攻+6666、物防+6666、爆伤+66、爆率+66、回复+666，吸血+66", "物攻+6666、物防+6666、爆伤+66、爆率+66、回复+666，吸血+66");

        this.add("《万破》：每10级增加10%的物攻", "《万破》：每10级增加10%的物攻");
        this.add("分出三根破天神棍，对前方造成伤害", "分出三根破天神棍，对前方造成伤害");
        this.add("对附近生物施加负面效果", "对附近生物施加负面效果");
        this.add("以自身为中心，形成一个魂力漩涡，对5格范围内的敌人造成伤害", "以自身为中心，形成一个魂力漩涡，对5格范围内的敌人造成伤害");
        this.add("武魂分出一些魂力可以使自己超速行驶", "武魂分出一些魂力可以使自己超速行驶");
        this.add("身旁召唤九龙并发出令人长时间眩晕的禅音，对15格范围内的敌人施加减速和伤害", "身旁召唤九龙并发出令人长时间眩晕的禅音，对15格范围内的敌人施加减速和伤害");
        this.add("自己与破天神棍融为一体，提升自身3000物攻，50%爆伤，20%爆率", "自己与破天神棍融为一体，提升自身3000物攻，50%爆伤，20%爆率");
        this.add("周身形成超强的领域，所有跨入领域的人会受到红莲业火的焚烧，而自己不断增强", "周身形成超强的领域，所有跨入领域的人会受到红莲业火的焚烧，而自己不断增强");
        this.add("上古神王附体", "上古神王附体");

//玩法介绍
        this.add("玩法介绍主题", "山海大陆1.20.1_4.0基础玩法介绍");
        this.add("玩法介绍1页",
                "§6基础操作：§0\n" +
                "§6O键：§0打开属性界面。\n" +
                "§6K键：§0武魂切换，开启武魂会消耗精神力，能够飞行也会消耗精神力\n" +
                "§6R键：§0召唤技能（需打开魂环显示）\n" +
                "§6武魂觉醒：§0魂师等级突破1级时自动觉醒武魂或通过服用武魂果实获得（武魂果实可由转生获得）\n" +
                "§6魂环吸收：§0击杀带有魂环的魂兽会掉落魂环\n" +
                "§6魂环分解：§0蹲下右键或攻击魂环可以加速魂环转化成魂核\n" +
                "§6魂技：§0每吸收一个魂环增加一个魂技，通过R键召唤魂魂技再空手右键获得魂技，第一魂技可以通过铁贴绑定其它魂技能但第一魂技本事无主动效果\n" +
                "§6升级：§0吸收魂核和炼制丹药");
        this.add("玩法介绍2页",
                "§6机制介绍：§0\n" +
                "§6古风小屋：§0会固定刷新魂民，参考守卫者的刷新机制\n" +
                "§6魂民：§0会掉落丹药和单方，玩家等级越高，掉落的单方等级越高\n" +
                "§6魂液瓶：§0右键可收集魂核的能量，右键耕地可转化为魂土，魂土能够种植草药\n" +
                "§6转生：§0满级后获得梦回万古debuff后再通过床睡觉完成转生，转生后等级属性回归0级，返还武魂果实,重置丹药使用次数，保留本体百分之二十属性\n" +
                "§6魂兽分布：§0主世界千年内，下界万年内，末地百万年内\n" +
                "§6矿物分布：§0虽然所有矿物在主世界都有刷新，但一些稀有矿物在下届或末地的会有刷新\n" +
                "§6联动：§0所有配方都在jei物品管理器（mod）中可以查询，对暮色的怪的年限做了适配\n" +
                "§6测试物品：§0/give @p shanhaicontinent:textitem1，服用后获得满魂环，仅测试使用\n" +
                "§d更新内容：§0新增加3种丹药及单方，新增修改玩家数据作弊指令：/shanhaicontinent attribute @p [属性名] [值] "
                );


//方块


        this.add(BlockInit.SAPPHIRE_BLOCK   .get(),"测试方块");
        this.add(BlockInit.SOUL_BLOCK       .get(),"§a魂土");
        this.add(BlockInit.POT_BLOCK        .get(),"§e造化炉");

        this.add(BlockInit.baisuilan        .get(),"§1百岁栏");
        this.add(BlockInit.fengxinzi        .get(),"§a风信子");
        this.add(BlockInit.hanxiaohua       .get(),"§b含笑花");
        this.add(BlockInit.hehuan           .get(),"§3合欢");
        this.add(BlockInit.heshouwu         .get(),"§c何首乌");
        this.add(BlockInit.qiuhaitang       .get(),"§4秋海棠");
        this.add(BlockInit.shancha          .get(),"§d山茶");
        this.add(BlockInit.wangyoucao       .get(),"§f忘忧草");
        this.add(BlockInit.xiwu             .get(),"§f夕雾");
        this.add(BlockInit.xunyicao         .get(),"§f薰衣草");
        this.add(BlockInit.yueguanghua      .get(),"§f月光花");
        this.add(BlockInit.bianhua          .get(),"§2彼岸花");
        this.add(BlockInit.zhushamei        .get(),"§f朱莎玫");


        this.add(BlockInit.blockmingtieore             .get(),"§a冥铁矿");
        this.add(BlockInit.blockheijinore              .get(),"§a黑金矿");
        this.add(BlockInit.blocklanlingjinore          .get(),"§a蓝灵金矿");
        this.add(BlockInit.blocklanhaizuanore          .get(),"§a蓝海钻矿");
        this.add(BlockInit.blockcixuexianjinore        .get(),"§a赤血仙金矿");
        this.add(BlockInit.blockkongjianshiore         .get(),"§a空间石矿");


        this.add(BlockInit.blockkongjianshi_block         .get(),"§b空间石块");
        this.add(BlockInit.blockmingtie_block             .get(),"§b冥铁块");
        this.add(BlockInit.blockheijin_block              .get(),"§b黑金块");
        this.add(BlockInit.blocklanlingjin_block          .get(),"§b蓝灵金块");
        this.add(BlockInit.blocklanhaizuan_block          .get(),"§b蓝海钻块");
        this.add(BlockInit.blockcixuexianjin_block        .get(),"§b赤血仙金块");




//物品


        this.add(ItemInit.wanfajieshao       .get(),"§1山海大陆玩法介绍");

        this.add(ItemInit.itemmingtie            .get(),"§a冥铁");
        this.add(ItemInit.itemheijin             .get(),"§a黑金");
        this.add(ItemInit.itemlanlingjin         .get(),"§a蓝灵金");
        this.add(ItemInit.itemlanhaizuan         .get(),"§a蓝海钻");
        this.add(ItemInit.itemcixuexianjin       .get(),"§a赤血仙金");
        this.add(ItemInit.itemkongjianshi        .get(),"§a空间石");

        this.add(ItemInit.mingtie_head     .get(),"§a冥铁头盔");
        this.add(ItemInit.mingtie_chest    .get(),"§a冥铁胸甲");
        this.add(ItemInit.mingtie_feet     .get(),"§a冥铁鞋子");
        this.add(ItemInit.mingtie_legs     .get(),"§a冥铁护腿");
        this.add(ItemInit.mingtie_axe            .get(),"§a冥铁斧");
        this.add(ItemInit.mingtie_hoe            .get(),"§a冥铁锄");
        this.add(ItemInit.mingtie_pickaxe        .get(),"§a冥铁镐");
        this.add(ItemInit.mingtie_shovel         .get(),"§a冥铁锹");
        this.add(ItemInit.mingtie_sword          .get(),"§a冥铁剑");

        this.add(ItemInit.heijin_head          .get(),"§a黑金头盔");
        this.add(ItemInit.heijin_chest         .get(),"§a黑金胸甲");
        this.add(ItemInit.heijin_feet          .get(),"§a黑金鞋子");
        this.add(ItemInit.heijin_legs          .get(),"§a黑金护腿");
        this.add(ItemInit.heijin_axe            .get(),"§a黑金斧");
        this.add(ItemInit.heijin_hoe            .get(),"§a黑金锄");
        this.add(ItemInit.heijin_pickaxe        .get(),"§a黑金镐");
        this.add(ItemInit.heijin_shovel         .get(),"§a黑金锹");
        this.add(ItemInit.heijin_sword          .get(),"§a黑金剑");

        this.add(ItemInit.lanlingjin_head            .get(),"§a蓝灵金头盔");
        this.add(ItemInit.lanlingjin_chest           .get(),"§a蓝灵金胸甲");
        this.add(ItemInit.lanlingjin_feet            .get(),"§a蓝灵金鞋子");
        this.add(ItemInit.lanlingjin_legs            .get(),"§a蓝灵金护腿");
        this.add(ItemInit.lanlingjin_axe            .get(),"§a蓝灵金斧");
        this.add(ItemInit.lanlingjin_hoe            .get(),"§a蓝灵金锄");
        this.add(ItemInit.lanlingjin_pickaxe        .get(),"§a蓝灵金镐");
        this.add(ItemInit.lanlingjin_shovel         .get(),"§a蓝灵金锹");
        this.add(ItemInit.lanlingjin_sword          .get(),"§a蓝灵金剑");

        this.add(ItemInit.lanhaizuan_head            .get(),"§a蓝海钻头盔");
        this.add(ItemInit.lanhaizuan_chest           .get(),"§a蓝海钻胸甲");
        this.add(ItemInit.lanhaizuan_feet            .get(),"§a蓝海钻鞋子");
        this.add(ItemInit.lanhaizuan_legs            .get(),"§a蓝海钻护腿");
        this.add(ItemInit.lanhaizuan_axe            .get(),"§a蓝海钻斧");
        this.add(ItemInit.lanhaizuan_hoe            .get(),"§a蓝海钻锄");
        this.add(ItemInit.lanhaizuan_pickaxe        .get(),"§a蓝海钻镐");
        this.add(ItemInit.lanhaizuan_shovel         .get(),"§a蓝海钻锹");
        this.add(ItemInit.lanhaizuan_sword          .get(),"§a蓝海钻剑");

        this.add(ItemInit.cixuexianjin_head              .get(),"§a赤血仙金头盔");
        this.add(ItemInit.cixuexianjin_chest             .get(),"§a赤血仙金胸甲");
        this.add(ItemInit.cixuexianjin_feet              .get(),"§a赤血仙金鞋子");
        this.add(ItemInit.cixuexianjin_legs              .get(),"§a赤血仙金护腿");
        this.add(ItemInit.cixuexianjin_axe            .get(),"§a赤血仙金斧");
        this.add(ItemInit.cixuexianjin_hoe            .get(),"§a赤血仙金锄");
        this.add(ItemInit.cixuexianjin_pickaxe        .get(),"§a赤血仙金镐");
        this.add(ItemInit.cixuexianjin_shovel         .get(),"§a赤血仙金锹");
        this.add(ItemInit.cixuexianjin_sword          .get(),"§a赤血仙金剑");





        this.add(ItemInit.baisuilan_fruit       .get(),"§1百岁栏");
        this.add(ItemInit.fengxinzi_fruit       .get(),"§a风信子");
        this.add(ItemInit.hanxiaohua_fruit      .get(),"§b含笑花");
        this.add(ItemInit.hehuan_fruit          .get(),"§3合欢");
        this.add(ItemInit.heshouwu_fruit        .get(),"§c何首乌");
        this.add(ItemInit.qiuhaitang_fruit      .get(),"§4秋海棠");
        this.add(ItemInit.shancha_fruit         .get(),"§d山茶");
        this.add(ItemInit.wangyoucao_fruit      .get(),"§f忘忧草");
        this.add(ItemInit.xiwu_fruit            .get(),"§f夕雾");
        this.add(ItemInit.xunyicao_fruit        .get(),"§f薰衣草");
        this.add(ItemInit.yueguanghua_fruit     .get(),"§f月光花");
        this.add(ItemInit.zhushamei_fruit       .get(),"§f朱莎玫");
        this.add(ItemInit.bianhua_fruit         .get(),"§2彼岸花");

        this.add(ItemInit.baisuilan_seed        .get(),"§1百岁栏 *** 种子");
        this.add(ItemInit.fengxinzi_seed        .get(),"§a风信子 *** 种子");
        this.add(ItemInit.hanxiaohua_seed       .get(),"§b含笑花 *** 种子");
        this.add(ItemInit.hehuan_seed           .get(),"§3合欢 *** 种子");
        this.add(ItemInit.heshouwu_seed         .get(),"§c何首乌 *** 种子");
        this.add(ItemInit.qiuhaitang_seed       .get(),"§4秋海棠 *** 种子");
        this.add(ItemInit.shancha_seed          .get(),"§d山茶 *** 种子");
        this.add(ItemInit.wangyoucao_seed       .get(),"§f忘忧草 *** 种子");
        this.add(ItemInit.xiwu_seed             .get(),"§f夕雾 *** 种子");
        this.add(ItemInit.xunyicao_seed         .get(),"§f薰衣草 *** 种子");
        this.add(ItemInit.yueguanghua_seed      .get(),"§f月光花 *** 种子");
        this.add(ItemInit.zhushamei_seed        .get(),"§f朱莎玫 *** 种子");
        this.add(ItemInit.bianhua_seed          .get(),"§2彼岸花 *** 种子");



        this.add(SHModMobEffectsinit.jineng_jgb_6 	     .get(),"§b《金箍真身》");
        this.add(SHModMobEffectsinit.jineng_jgb_7 	     .get(),"§b《斗战圣域》");
        this.add(SHModMobEffectsinit.jineng_jgb_8 	     .get(),"§b《斗战胜佛体》");
        this.add(SHModMobEffectsinit.jineng_huang_6      .get(),"§b《轮回宝术》");
        this.add(SHModMobEffectsinit.jineng_huang_8      .get(),"§b《不知名至尊术》");
        this.add(SHModMobEffectsinit.jineng_htsc_2       .get(),"§b《浩天护盾》");
        this.add(SHModMobEffectsinit.jineng_htsc_5       .get(),"§b《浩天九绝》");
        this.add(SHModMobEffectsinit.jineng_htsc_6       .get(),"§b《落天雷锤》");
        this.add(SHModMobEffectsinit.zhiwu_bianhua       .get(),"§d梦回万古");


        this.add(ItemInit.TEXTITEM.get(),"测试物品");
        this.add(ItemInit.hunyeping0.get(),"§a<魂液瓶> *** Ⅰ阶");
        this.add(ItemInit.hunyeping1.get(),"§b<魂液瓶> ***  Ⅱ阶");
        this.add(ItemInit.hunyeping2.get(),"§c<魂液瓶> *** Ⅲ阶");
        this.add(ItemInit.hunyeping3.get(),"§d<魂液瓶> *** Ⅳ阶");
        this.add(ItemInit.hunyeping4.get(),"§e<魂液瓶> *** Ⅴ阶");
        this.add(ItemInit.hunyeping5.get(),"§5<魂液瓶> *** Ⅵ阶");
        this.add(ItemInit.hunyeping6.get(),"§4<魂液瓶> *** Ⅶ阶");

        this.add(ItemInit.jineng_jgb_0.get(),"§e器武魂：§4破天神棍 §f------ §e《极品器武魂》");
        this.add(ItemInit.jineng_jgb_1.get(),"§e魂技：§b《分身化影》 §f------ 武魂：§e《破天神棍》");
        this.add(ItemInit.jineng_jgb_2.get(),"§e魂技：§b《禁锢咒》 §f------ 武魂：§e《破天神棍》");
        this.add(ItemInit.jineng_jgb_3.get(),"§e魂技：§b《定海》 §f------ 武魂：§e《破天神棍》");
        this.add(ItemInit.jineng_jgb_4.get(),"§e魂技：§b《金斗云》 §f------ 武魂：§e《破天神棍》");
        this.add(ItemInit.jineng_jgb_5.get(),"§e魂技：§b《九龙禅音》 §f------ 武魂：§e《破天神棍》");
        this.add(ItemInit.jineng_jgb_6.get(),"§e魂技：§b《金箍真身》 §f------ 武魂：§e《破天神棍》");
        this.add(ItemInit.jineng_jgb_7.get(),"§e魂技：§b《斗战圣域》 §f------ 武魂：§e《破天神棍》");
        this.add(ItemInit.jineng_jgb_8.get(),"§e魂技：§b《斗战胜佛体》 §f------ 武魂：§e《破天神棍》");
        this.add(ItemInit.jineng_huang_0.get(),"§e武魂-荒： §f------ §e《极品武魂》");
        this.add(ItemInit.jineng_huang_1.get(),"§e魂技：§b《鲲鹏宝术》 §f------ 武魂：§e《荒》");
        this.add(ItemInit.jineng_huang_2.get(),"§e魂技：§b《狻猊神雷》 §f------ 武魂：§e《荒》");
        this.add(ItemInit.jineng_huang_3.get(),"§e魂技：§b《柳神法》 §f------ 武魂：§e《荒》");
        this.add(ItemInit.jineng_huang_4.get(),"§e魂技：§b《草灭剑诀》 §f------ 武魂：§e《荒》");
        this.add(ItemInit.jineng_huang_5.get(),"§e魂技：§b《六道轮回天功》 §f------ 武魂：§e《荒》");
        this.add(ItemInit.jineng_huang_6.get(),"§e魂技：§b《轮回宝术》 §f------ 武魂：§e《荒》");
        this.add(ItemInit.jineng_huang_7.get(),"§e魂技：§b《抱剑杀》 §f------ 武魂：§e《荒》");
        this.add(ItemInit.jineng_huang_8.get(),"§e魂技：§b《不知名至尊术》 §f------ 武魂：§e《荒》");
        this.add(ItemInit.jineng_htsc_0.get(),"§e器武魂-§e浩天圣锤： §f------ §e《极品武魂》");
        this.add(ItemInit.jineng_htsc_1.get(),"§e魂技：§b《浩天震》 §f------ 武魂：§e《浩天圣锤》");
        this.add(ItemInit.jineng_htsc_2.get(),"§e魂技：§b《浩天护盾》 §f------ 武魂：§e《浩天圣锤》");
        this.add(ItemInit.jineng_htsc_3.get(),"§e魂技：§b《神秘之锤》 §f------ 武魂：§e《浩天圣锤》");
        this.add(ItemInit.jineng_htsc_4.get(),"§e魂技：§b《天地无极》 §f------ 武魂：§e《浩天圣锤》");
        this.add(ItemInit.jineng_htsc_5.get(),"§e魂技：§b《浩天九绝》 §f------ 武魂：§e《浩天圣锤》");
        this.add(ItemInit.jineng_htsc_6.get(),"§e魂技：§b《浩天护体》 §f------ 武魂：§e《浩天圣锤》");
        this.add(ItemInit.jineng_htsc_7.get(),"§e魂技：§b《凌天一击》 §f------ 武魂：§e《浩天圣锤》");
        this.add(ItemInit.jineng_htsc_8.get(),"§e魂技：§b《落天雷锤》 §f------ 武魂：§e《浩天圣锤》");
        this.add(ItemInit.guoshi_haotianchui    .get(),"§4<浩天圣锤> §f------ §c《武魂果实》");
        this.add(ItemInit.guoshi_huang          .get(),"§4<荒> §f------ §c《武魂果实》");
        this.add(ItemInit.guoshi_jingubang      .get(),"§4<破天神棍> §f------ §c《武魂果实》");
        this.add(ItemInit.danyao_qihundan       .get(),"§a气魂丹*Ⅰ阶");
        this.add(ItemInit.danyao_jvlingdan      .get(),"§b聚灵丹*Ⅱ阶");
        this.add(ItemInit.danyao_xvanyuandan    .get(),"§c玄元丹*Ⅲ阶");
        this.add(ItemInit.danyao_yanghundan     .get(),"§d养魂丹*Ⅳ阶");
        this.add(ItemInit.danyao_lingbidan      .get(),"§e凝碧丹*Ⅴ阶");
        this.add(ItemInit.danyao_haoyuan        .get(),"§7昊元丹*Ⅵ阶");
        this.add(ItemInit.danyao_xihundan       .get(),"§6涤魂丹*Ⅶ阶");
        this.add(ItemInit.danyao_huangjidan     .get(),"§5皇极丹*Ⅷ阶");
        this.add(ItemInit.danyao_lushendan      .get(),"§4怒神丹*Ⅸ阶");
        this.add(ItemInit.danyao_jiuhua         .get(),"§1《§b九花玉露丸§1》");
        this.add(ItemInit.danyao_huanyuandan         .get(),"§1《§b还元丹§1》");
        this.add(ItemInit.danyao_fanmindan           .get(),"§1《§b返命丹§1》");
        this.add(ItemInit.danyao_heqidan             .get(),"§1《§b合气丹§1》");
        this.add(ItemInit.danyao_zengqidan           .get(),"§1《§b增气丹§1》");
        this.add(ItemInit.danyao_yishendan              .get(),"§7《§b益神丹§7");
        this.add(ItemInit.danyao_xisuidan               .get(),"§7《§b洗髓丹§7");
        this.add(ItemInit.danyao_longlidan              .get(),"§7《§b龙力丹§7");
        this.add(ItemInit.danfang_qihundan      .get(),"§a丹方：§f《§a气魂丹§f》*Ⅰ阶");
        this.add(ItemInit.danfang_jvlingdan     .get(),"§b丹方：§f《§b聚灵丹§f》*Ⅱ阶");
        this.add(ItemInit.danfang_xvanyuandan   .get(),"§c丹方：§f《§c玄元丹§f》*Ⅲ阶");
        this.add(ItemInit.danfang_yanghundan    .get(),"§d丹方：§f《§d养魂丹§f》*Ⅳ阶");
        this.add(ItemInit.danfang_lingbidan     .get(),"§e丹方：§f《§e凝碧丹§f》*Ⅴ阶");
        this.add(ItemInit.danfang_haoyuan       .get(),"§7丹方：§f《§7昊元丹§f》*Ⅵ阶");
        this.add(ItemInit.danfang_xihundan      .get(),"§6丹方：§f《§6涤魂丹§f》*Ⅶ阶");
        this.add(ItemInit.danfang_huangjidan    .get(),"§5丹方：§f《§5皇极丹§f》*Ⅷ阶");
        this.add(ItemInit.danfang_lushendan     .get(),"§4丹方：§f《§4怒神丹§f》*Ⅸ阶");
        this.add(ItemInit.danfang_jiuhua        .get(),"§4丹方：§1《§b九花玉露丸§1》***");
        this.add(ItemInit.danfang_huanyuandan       .get(),"§4丹方：§1《§b还元丹§1》***");
        this.add(ItemInit.danfang_fanmindan         .get(),"§4丹方：§1《§b返命丹§1》***");
        this.add(ItemInit.danfang_heqidan           .get(),"§4丹方：§1《§b合气丹§1》***");
        this.add(ItemInit.danfang_zengqidan         .get(),"§4丹方：§1《§b增气丹§1》***");
        this.add(ItemInit.danfang_yishendan         .get(),"§4丹方：§7《§b益神丹§7》***");
        this.add(ItemInit.danfang_xisuidan          .get(),"§4丹方：§7《§b洗髓丹§7》***");
        this.add(ItemInit.danfang_longlidan         .get(),"§4丹方：§7《§b龙力丹§7》***");
        this.add(ItemInit.headbone              .get(),"§c头骨 §f§k****** §e《上古神秘骨》");
        this.add(ItemInit.exoskeletonsoulbone.get(),"§c外附骨 §f§k****** §e《上古神秘骨》");
        this.add(ItemInit.lefthandbone          .get(),"§c左臂骨 §f§k****** §e《上古神秘骨》");
        this.add(ItemInit.righthandbone         .get(),"§c右臂骨 §f§k****** §e《上古神秘骨》");
        this.add(ItemInit.trunkbone             .get(),"§c躯干骨 §f§k****** §e《上古神秘骨》");
        this.add(ItemInit.leftlegbone           .get(),"§c左腿骨 §f§k****** §e《上古神秘骨》");
        this.add(ItemInit.rightlegbone          .get(),"§c右腿骨 §f§k****** §e《上古神秘骨》");
        this.add(ItemInit.hunmin_spanw_egg      .get(),"生成魂民");




//实体
        this.add(EntityInit.hunmin.get(),"§a魂民");
        this.add(EntityInit.HUNHE.get(),"§9魂核");
        this.add(EntityInit.HUNHUAN.get(),"§9魂环");



    }
}
