package hua.huase.shanhaicontinent.datagen;

import hua.huase.shanhaicontinent.init.BlockInit;
import hua.huase.shanhaicontinent.init.EntityInit;
import hua.huase.shanhaicontinent.item.ItemInit;
import hua.huase.shanhaicontinent.init.SHModMobEffectsinit;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnLanguageProvider extends LanguageProvider {
    public ModEnLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
// In LanguageProvider#addTranslations
//        this.addBlock(BlockInit.text_block, "Example Block");
        this.add("套装效果", "setEffect:");
        this.add("套装描述", "Extremely durable, non dimensional damage, non destructible");
        this.add("已破损", "damaged");
        this.add("未装配", "notAssembled");
        this.add("可通过造化炉修理", "canBeRepairedThroughAChemicalFurnace");
        this.add("所需能量", "§crequiredEnergy：%s");
        this.add("生命", "life：%s/%s");
        this.add("最大生命", "theGreatestLife：+%s");
        this.add("获得生命", "life：+%s");
        this.add("物攻", "physicalAttack：+%s");
        this.add("物防", "physicalDefense：+%s");
        this.add("爆伤", "explosiveInjury：+%s");
        this.add("爆率", "explosionRate：+%s");
        this.add("真伤", "reallyHurt：+%s");
        this.add("物穿", "clothing：+%s");
        this.add("抗暴", "antiViolence：+%s");
        this.add("吸血", "bloodsucking：+%s");
        this.add("回复", "reply：+%s");
        this.add("命中", "hitIt：+%s");
        this.add("闪避", "evade：+%s");
        this.add("经验", "experience：%s/%s");
        this.add("获得经验", "experience：+%s");
        this.add("等级", "grade：%s");
        this.add("转生", "reincarnation：%sle");
        this.add("精神力", "spiritualPower：%s/%s");
        this.add("获得精神力", "spiritualPower：+%s");
        this.add("获得最大精神力", "maximumMentalPower：+%s");
        this.add("体力", "physicalStrength：%s/%s");
        this.add("最大使用次数", "used：%s");

        this.add("突破成功率", "breakthroughSuccessRate：+%s");
        this.add("能量", "energy：%s/%s");

        this.add("能量耗尽", "energyDepletion");
        this.add("能量已满", "energyIsFull");


        this.add("技能开关", "skillSwitch");
        this.add("武魂开关", "martialSoulSwitch");
        this.add("属性面板", "attributePanel");
        this.add("右键<魂核>收集能量；右键<耕地>消耗能量，转化<魂土>", "Right click on<Soul Core>to collect energy; Right click on<Farmland>to consume energy and convert<Soul Soil>");



        this.add("player join world", "§2-%s-§fArriving at the Shanhai Continent - The Shanhai Continent: At the beginning of the universe, chaotic evolution, the energy of creation, the creation of all things, the power of mountains, rivers, and seas, and the birth of all things");
        this.add("精神力不足", "lackOfMentalStrength");
        this.add("吸收经验成功", "§2absorbingSuccessExperience：§e+%s");
        this.add("突破成功", "§6successfullyAdvancedTo§e%s级");
        this.add("不能突破", "§cUnable to break through: Please absorb the soul ring first");
        this.add("已经满级", "§cUnable to break through: suppressed by heaven and earth");
        this.add("突破失败", "§5Breakthrough failure, probability of next breakthrough+5");

        this.add("未开启或觉醒武魂", "§cunactivatedOrAwakenedMartialSoul");
        this.add("成功觉醒武魂", "§csuccessfullyAwakenedMartialSoul§c%s");
        this.add("成功吸收魂环", "§csuccessfullyAbsorbedSYearSoulRing");
        this.add("等级不够", "§cInsufficient level or full soul ring, unable to absorb soul ring");
        this.add("正在吸收魂环", "§cabsorbingSoulRingsAndSpiritualPower-%s");


        this.add("服用后觉醒武魂", "§2awakeningAfterTakingIt%smartialSoul");
//        this.add("jingubang",   "§4破天神棍");
//        this.add("huang",       "§e武魂-荒");
//        this.add("haotianchui", "§e浩天圣锤");


        this.add("已达到服用上限", "§4theUpperLimitOfMedicationHasBeenReached");


        this.add("武魂已开启", "<<§c%s>> §atheMartialSoulHasBeenActivated");
        this.add("武魂已关闭", "§amartialSoulHasBeenClosed");
        this.add("拥有者", "owner:%s");
        this.add("年限", "yearLimit:%s");
        this.add("武魂技能", "skill：%s+%s年");


        this.add("block.tutorialmod.gem_polishing_station", "§6chemicalFurnaceFormula");
        this.add("creativetab.shanhaicontient_tab", "§7shanhaiContinent");


//        物品说明
        this.add("用于栽培药材，可由《魂液瓶》消耗能量，右键耕地获得", "Used for cultivating medicinal herbs, energy can be consumed by the <Soul Liquid Bottle> and obtained by right clicking on the cultivated land");
        this.add("以造化之气，炼制物品", "refiningObjectsWithTheEnergyOfNature");


        this.add("玩法介绍", "gameplayIntroduction");
        this.add("默认o键打开属性面板，可在属性面板装配", "The default 'o' key opens the property panel, which can be assembled in the property panel");
        this.add("击杀《古风小屋》中的魂民概率掉落", "Probability of Killing Soul People in 'Ancient Wind House' Dropping");


//        技能说明
        this.add("蹲下释放可破环地形", "squatDownAndReleaseToBreakThroughTerrain");
        this.add("每10级提升5%的物攻、暴击率、爆伤", "Increases object attack, critical hit rate, and damage by 5% every 10 levels");
        this.add("能在地面上产生威力无比的震动，对前方造成伤害", "Capable of producing incredibly powerful vibrations on the ground, causing damage to the front");
        this.add("在短时间内产生坚实的防护罩", "Produce a solid protective cover in a short period of time");
        this.add("每10级提升5%的物伤、暴击率、爆伤", "Increases object damage, critical hit rate, and blast damage by 5% every 10 levels");
        this.add("--副手生效", "--deputyTakesEffect");
        this.add("发出强大的力量风暴，前方的敌人造成伤害", "Send out a powerful storm of force, causing damage to enemies ahead");
        this.add("调用全身之力，形成力量风暴，对范围内的敌人照成伤害", "Summon full body power to form a power storm and inflict damage on enemies within range");
        this.add("锤影在周身形成一圈能量光罩进行防御", "The hammer shadow forms a circle of energy shield around its body for defense");
        this.add("将全身魂力集中于一点迅速发出", "Concentrate all your soul power on one point and quickly release it");
        this.add("引动天地之力，降下天雷", "Activate the power of heaven and earth, and bring down thunder from the sky");

        this.add("每10级提升4%的物攻、物防、真伤、爆伤、抗暴、回复", "Increases physical attack, physical defense, real damage, explosive damage, resistance, and recovery by 4% every 10 levels");
        this.add("向前位移，对路过的敌人造成伤害", "moveForwardAndDealDamageToPassingEnemies");
        this.add("召唤雷电轰击地面", "summonLightningToStrikeTheGround");
        this.add("造成伤害，并根据造成伤害的回复生命值", "Cause damage and restore health based on the damage caused");
        this.add("一株草可斩日月星辰!挑出一剑，对前方大范围敌人伤害", "A single blade of grass can slay the sun, moon, and stars! Pick out a sword and deal damage to a wide range of enemies ahead");
        this.add("刷新所有技能冷却", "refreshAllSkillCooldowns");
        this.add("受到致命伤满血复活", "resurrectedFromFatalInjuriesAndFullOfBlood");
        this.add("对前方单体造成伤害", "causingDamageToTheFrontUnit");
        this.add("物攻+6666、物防+6666、爆伤+66、爆率+66、回复+666，吸血+66", "Physical Attack+6666, Physical Defense+6666, Explosive Damage+66, Explosive Rate+66, Recovery+666, Bloodsucking+66");

        this.add("《万破》：每10级增加10%的物攻", "Ten Thousand Breaks: Increases physical attacks by 10% every 10 levels");
        this.add("分出三根破天神棍，对前方造成伤害", "Separate three Heavenly God Breaking Staff and deal damage to the front");
        this.add("对附近生物施加负面效果", "applyNegativeEffectsOnNearbyOrganisms");
        this.add("以自身为中心，形成一个魂力漩涡，对5格范围内的敌人造成伤害", "Form a soul vortex centered around oneself, dealing damage to enemies within a 5-grid range");
        this.add("武魂分出一些魂力可以使自己超速行驶", "The martial soul can allocate some soul power to accelerate its own speed");
        this.add("身旁召唤九龙并发出令人长时间眩晕的禅音，对15格范围内的敌人施加减速和伤害", "Summon Kowloon beside you and emit a dizzying Zen sound for a long time, slowing down and dealing damage to enemies within a 15 grid range");
        this.add("自己与破天神棍融为一体，提升自身3000物攻，50%爆伤，20%爆率", "Integrate yourself with the Broken Heavenly God Stick, increase your own attack by 3000 items, 50% damage, and 20% rate");
        this.add("周身形成超强的领域，所有跨入领域的人会受到红莲业火的焚烧，而自己不断增强", "The body forms a super strong realm, and all those who enter the realm will be burned by the fire of the Red Lotus industry, while themselves continue to strengthen");
        this.add("上古神王附体", "thePossessionOfTheAncientDivineKing");

//玩法介绍
        this.add("玩法介绍主题", "Shanhai Continent 1.20.1_4.0 Basic Gameplay Introduction");
        this.add("玩法介绍1页",
                "§6basicOperations：§0\n" +
                "§6Okey：§0openTheAttributeInterface。\n" +
                "§6Kkey：§0Soul switching, activating soul will consume mental power, and being able to fly will also consume mental power\n" +
                "§6Rkey：§0Summoning skill (requires opening soul ring display)\n" +
                "§6awakeningOfMartialSoul：§0When the soul master level exceeds level 1, the soul will automatically awaken or be obtained by taking the soul fruit (which can be obtained through reincarnation)\n" +
                "§6soulRingAbsorption：§0Killing soul beasts with soul rings will result in the dropping of soul rings\n" +
                "§6soulRingDecomposition：§0Squatting down the right button or attacking the soul ring can accelerate the conversion of the soul ring into a soul nucleus\n" +
                "§6soulSkills：§0For every soul ring absorbed, an additional soul skill is added. Summon the soul skill with the R key and then obtain the soul skill with bare hands by right clicking. The first soul skill can be bound to other soul skills through iron stickers, but it has no active effect\n" +
                "§6upgrade：§0absorbSoulNucleiAndRefineElixirs");
        this.add("玩法介绍2页",
                "§6mechanismIntroduction：§0\n" +
                "§6ancientStyleCottage：§0It will refresh the Soul People regularly, referring to the refresh mechanism of the Guardian\n" +
                "§6soulPeople：§0Will drop elixirs and one side, the higher the player's level, the higher the level of the dropped side\n" +
                "§6soulLiquidBottle：§0Right click to collect energy from soul nuclei, right-click to convert cultivated land into soul soil, which can be used to plant herbs\n" +
                "§6reincarnation：§0After reaching full level, obtain the Dream Return Eternal debuff and then complete reincarnation by sleeping on the bed. After reincarnation, the level attribute returns to level 0, returns the martial soul fruit, and retains 20% of the original attribute\n" +
                "§6distributionOfSoulBeasts：§0Within a thousand years in the main world, within ten thousand years in the lower world, and within a million years in the end world\n" +
                "§6mineralDistribution：§0Although all minerals are refreshed in the main world, some rare minerals will be refreshed in the next or final world\n" +
                "§6linkage：§0All formulas can be queried in the JEI Item Manager (mod)\n" +
                "§6testItems：§0/give @p shanhaicontinent:textitem1，Obtain a full soul ring after taking it, for testing purposes only");


//方块


        this.add(BlockInit.SAPPHIRE_BLOCK   .get(),"testBlock");
        this.add(BlockInit.SOUL_BLOCK       .get(),"§aSoulSoil");
        this.add(BlockInit.POT_BLOCK        .get(),"§eChemicalFurnace");

        this.add(BlockInit.baisuilan        .get(),"§1centennialBar");
        this.add(BlockInit.fengxinzi        .get(),"§aHyacinth");
        this.add(BlockInit.hanxiaohua       .get(),"§bSmilingFlower");
        this.add(BlockInit.hehuan           .get(),"§3 Acacia trees");
        this.add(BlockInit.heshouwu         .get(),"§cpolygonumMultiflorum");
        this.add(BlockInit.qiuhaitang       .get(),"§4 Autumn Begonia");
        this.add(BlockInit.shancha          .get(),"§dCamellia");
        this.add(BlockInit.wangyoucao       .get(),"§fForgetWorryGrass");
        this.add(BlockInit.xiwu             .get(),"§fEveningMist");
        this.add(BlockInit.xunyicao         .get(),"§fLavender");
        this.add(BlockInit.yueguanghua      .get(),"§fmoonlightFlower");
        this.add(BlockInit.bianhua          .get(),"§2 Other shore flowers");
        this.add(BlockInit.zhushamei        .get(),"§fZhuShaMei");


        this.add(BlockInit.blockmingtieore             .get(),"§amingIronMine");
        this.add(BlockInit.blockheijinore              .get(),"§aBlackGoldMine");
        this.add(BlockInit.blocklanlingjinore          .get(),"§aLanling Gold Mine");
        this.add(BlockInit.blocklanhaizuanore          .get(),"§ablueOceanDiamondMine");
        this.add(BlockInit.blockcixuexianjinore        .get(),"§aRedBloodImmortalGoldMine");
        this.add(BlockInit.blockkongjianshiore         .get(),"§aSpaceStoneMine");


        this.add(BlockInit.blockkongjianshi_block         .get(),"§bSpaceStones");
        this.add(BlockInit.blockmingtie_block             .get(),"§bDarkIronBlock");
        this.add(BlockInit.blockheijin_block              .get(),"§blackGoldNugget");
        this.add(BlockInit.blocklanlingjin_block          .get(),"§blueSpiritGoldNuggets");
        this.add(BlockInit.blocklanhaizuan_block          .get(),"§bBlueOceanDiamondBlock");
        this.add(BlockInit.blockcixuexianjin_block        .get(),"§bRedBloodImmortalGoldNuggets");




//物品


        this.add(ItemInit.wanfajieshao       .get(),"§1Introduction to the gameplay of Shanhai Continent");

        this.add(ItemInit.itemmingtie            .get(),"§aDarkIron");
        this.add(ItemInit.itemheijin             .get(),"§ablackGold");
        this.add(ItemInit.itemlanlingjin         .get(),"§ablueSpiritGold");
        this.add(ItemInit.itemlanhaizuan         .get(),"§ablueOceanDiamond");
        this.add(ItemInit.itemcixuexianjin       .get(),"§aredBloodImmortalGold");
        this.add(ItemInit.itemkongjianshi        .get(),"§aspaceStone");

        this.add(ItemInit.mingtie_head     .get(),"§adarkIronHelmet");
        this.add(ItemInit.mingtie_chest    .get(),"§adarkIronChestArmor");
        this.add(ItemInit.mingtie_feet     .get(),"§adarkIronShoes");
        this.add(ItemInit.mingtie_legs     .get(),"§adarkIronLegProtector");
        this.add(ItemInit.mingtie_axe            .get(),"§adarkIronAxe");
        this.add(ItemInit.mingtie_hoe            .get(),"§adarkIronHoe");
        this.add(ItemInit.mingtie_pickaxe        .get(),"§adarkIronPickaxe");
        this.add(ItemInit.mingtie_shovel         .get(),"§ahellShovel");
        this.add(ItemInit.mingtie_sword          .get(),"§adarkIronSword");

        this.add(ItemInit.heijin_head          .get(),"§ablackGoldHelmet");
        this.add(ItemInit.heijin_chest         .get(),"§ablackGoldBreastplate");
        this.add(ItemInit.heijin_feet          .get(),"§ablackGoldShoes");
        this.add(ItemInit.heijin_legs          .get(),"§ablackGoldLegGuards");
        this.add(ItemInit.heijin_axe            .get(),"§ablackGoldenAxe");
        this.add(ItemInit.heijin_hoe            .get(),"§ablackGoldHoe");
        this.add(ItemInit.heijin_pickaxe        .get(),"§ablackGoldPickaxe");
        this.add(ItemInit.heijin_shovel         .get(),"§ablackGoldSpade");
        this.add(ItemInit.heijin_sword          .get(),"§ablackGoldSword");

        this.add(ItemInit.lanlingjin_head            .get(),"§ablueSpiritGoldHelmet");
        this.add(ItemInit.lanlingjin_chest           .get(),"§ablueSpiritGoldChestArmor");
        this.add(ItemInit.lanlingjin_feet            .get(),"§ablueSpiritGoldShoes");
        this.add(ItemInit.lanlingjin_legs            .get(),"§ablueSpiritGoldLegProtector");
        this.add(ItemInit.lanlingjin_axe            .get(),"§ablueSpiritGoldenAxe");
        this.add(ItemInit.lanlingjin_hoe            .get(),"§ablueSpiritGoldenHoe");
        this.add(ItemInit.lanlingjin_pickaxe        .get(),"§ablueSpiritGoldAxe");
        this.add(ItemInit.lanlingjin_shovel         .get(),"§ablueSpiritGoldenSpade");
        this.add(ItemInit.lanlingjin_sword          .get(),"§ablueSpiritGoldenSword");

        this.add(ItemInit.lanhaizuan_head            .get(),"§ablueOceanDiamondHelmet");
        this.add(ItemInit.lanhaizuan_chest           .get(),"§ablueOceanDiamondChestArmor");
        this.add(ItemInit.lanhaizuan_feet            .get(),"§ablueOceanDiamondShoes");
        this.add(ItemInit.lanhaizuan_legs            .get(),"§ablueOceanDiamondLegProtector");
        this.add(ItemInit.lanhaizuan_axe            .get(),"§ablueOceanDiamondAxe");
        this.add(ItemInit.lanhaizuan_hoe            .get(),"§ablueOceanDrillingHoe");
        this.add(ItemInit.lanhaizuan_pickaxe        .get(),"§ablueOceanDrillAxe");
        this.add(ItemInit.lanhaizuan_shovel         .get(),"§ablueOceanDiamondSpade");
        this.add(ItemInit.lanhaizuan_sword          .get(),"§ablueOceanDiamondSword");

        this.add(ItemInit.cixuexianjin_head              .get(),"§aredBloodImmortalGoldHelmet");
        this.add(ItemInit.cixuexianjin_chest             .get(),"§aredBloodImmortalGoldChestArmor");
        this.add(ItemInit.cixuexianjin_feet              .get(),"§aredBloodImmortalGoldShoes");
        this.add(ItemInit.cixuexianjin_legs              .get(),"§aredBloodImmortalGoldLegProtector");
        this.add(ItemInit.cixuexianjin_axe            .get(),"§aredBloodImmortalGoldenAxe");
        this.add(ItemInit.cixuexianjin_hoe            .get(),"§aredBloodImmortalGoldenHoe");
        this.add(ItemInit.cixuexianjin_pickaxe        .get(),"§acrimsonBloodImmortalGoldenAxe");
        this.add(ItemInit.cixuexianjin_shovel         .get(),"§aredBloodImmortalGoldenSpade");
        this.add(ItemInit.cixuexianjin_sword          .get(),"§aredBloodImmortalGoldenSword");





        this.add(ItemInit.baisuilan_fruit       .get(),"§1centennialBar");
        this.add(ItemInit.fengxinzi_fruit       .get(),"§ahyacinth");
        this.add(ItemInit.hanxiaohua_fruit      .get(),"§bbananaShrub");
        this.add(ItemInit.hehuan_fruit          .get(),"§3hehuan");
        this.add(ItemInit.heshouwu_fruit        .get(),"§cpolygonumMultiflorum");
        this.add(ItemInit.qiuhaitang_fruit      .get(),"§4autumnCrabapple");
        this.add(ItemInit.shancha_fruit         .get(),"§dcamellia");
        this.add(ItemInit.wangyoucao_fruit      .get(),"§fnepenthes");
        this.add(ItemInit.xiwu_fruit            .get(),"§fxiWu");
        this.add(ItemInit.xunyicao_fruit        .get(),"§flavender");
        this.add(ItemInit.yueguanghua_fruit     .get(),"§fmoonlightFlower");
        this.add(ItemInit.zhushamei_fruit       .get(),"§fzhushaMei");
        this.add(ItemInit.bianhua_fruit         .get(),"§2higanbana");

        this.add(ItemInit.baisuilan_seed        .get(),"§1centennialBar *** seed");
        this.add(ItemInit.fengxinzi_seed        .get(),"§ahyacinth *** seed");
        this.add(ItemInit.hanxiaohua_seed       .get(),"§bbananaShrub *** seed");
        this.add(ItemInit.hehuan_seed           .get(),"§3hehuan *** 种子");
        this.add(ItemInit.heshouwu_seed         .get(),"§cpolygonumMultiflorum *** seed");
        this.add(ItemInit.qiuhaitang_seed       .get(),"§4autumnCrabapple *** seed");
        this.add(ItemInit.shancha_seed          .get(),"§dcamellia *** seed");
        this.add(ItemInit.wangyoucao_seed       .get(),"§fnepenthes *** seed");
        this.add(ItemInit.xiwu_seed             .get(),"§fxiWu *** seed");
        this.add(ItemInit.xunyicao_seed         .get(),"§flavender *** seed");
        this.add(ItemInit.yueguanghua_seed      .get(),"§fmoonlightFlower *** seed");
        this.add(ItemInit.zhushamei_seed        .get(),"§fzhushaMei *** seed");
        this.add(ItemInit.bianhua_seed          .get(),"§2higanbana *** seed");



        this.add(SHModMobEffectsinit.jineng_jgb_6 	     .get(),"§b《goldenHoopBody》");
        this.add(SHModMobEffectsinit.jineng_jgb_7 	     .get(),"§b《battleHolyLand》");
        this.add(SHModMobEffectsinit.jineng_jgb_8 	     .get(),"§b《defeatTheBuddhaBodyThroughStruggle》");
        this.add(SHModMobEffectsinit.jineng_huang_6      .get(),"§b《reincarnationTreasureTechnique》");
        this.add(SHModMobEffectsinit.jineng_huang_8      .get(),"§b《unknownSupremeTechnique》");
        this.add(SHModMobEffectsinit.jineng_htsc_2       .get(),"§b《haotianShield》");
        this.add(SHModMobEffectsinit.jineng_htsc_5       .get(),"§b《haotianNineWonders》");
        this.add(SHModMobEffectsinit.jineng_htsc_6       .get(),"§b《fallingThunderHammer》");
        this.add(SHModMobEffectsinit.zhiwu_bianhua       .get(),"§ddreamingBackToEternity");


        this.add(ItemInit.TEXTITEM.get(),"testItems");
        this.add(ItemInit.hunyeping0.get(),"§a<soulLiquidBottle> *** Ⅰ阶");
        this.add(ItemInit.hunyeping1.get(),"§b<soulLiquidBottle> ***  Ⅱ阶");
        this.add(ItemInit.hunyeping2.get(),"§c<soulLiquidBottle> *** Ⅲ阶");
        this.add(ItemInit.hunyeping3.get(),"§d<soulLiquidBottle> *** Ⅳ阶");
        this.add(ItemInit.hunyeping4.get(),"§e<soulLiquidBottle> *** Ⅴ阶");
        this.add(ItemInit.hunyeping5.get(),"§5<soulLiquidBottle> *** Ⅵ阶");
        this.add(ItemInit.hunyeping6.get(),"§4<soulLiquidBottle> *** Ⅶ阶");

        this.add(ItemInit.jineng_jgb_0.get(),"§eqiWuSoul：§4breakingTheHeavenlyGodStick §f------ §e《ultimateWeaponSoul》");
        this.add(ItemInit.jineng_jgb_1.get(),"§esoulSkills：§b《cloneShadow》 §f------ martialSoul：§e《breakingTheHeavenlyGodStick》");
        this.add(ItemInit.jineng_jgb_2.get(),"§esoulSkills：§b《imprisonmentCurse》 §f------ martialSoul：§e《breakingTheHeavenlyGodStick》");
        this.add(ItemInit.jineng_jgb_3.get(),"§esoulSkills：§b《dinghai》 §f------ martialSoul：§e《breakingTheHeavenlyGodStick》");
        this.add(ItemInit.jineng_jgb_4.get(),"§esoulSkills：§b《jinDouyun》 §f------ martialSoul：§e《breakingTheHeavenlyGodStick》");
        this.add(ItemInit.jineng_jgb_5.get(),"§esoulSkills：§b《jiulongZenMusic》 §f------ martialSoul：§e《breakingTheHeavenlyGodStick》");
        this.add(ItemInit.jineng_jgb_6.get(),"§esoulSkills：§b《goldenHoopBody》 §f------ martialSoul：§e《breakingTheHeavenlyGodStick》");
        this.add(ItemInit.jineng_jgb_7.get(),"§esoulSkills：§b《battleHolyLand》 §f------ martialSoul：§e《breakingTheHeavenlyGodStick》");
        this.add(ItemInit.jineng_jgb_8.get(),"§esoulSkills：§b《defeatTheBuddhaBodyThroughStruggle》 §f------ martialSoul：§e《breakingTheHeavenlyGodStick》");
        this.add(ItemInit.jineng_huang_0.get(),"§emartialSoul-Huang： §f------ §e《ultimateMartialSoul》");
        this.add(ItemInit.jineng_huang_1.get(),"§esoulSkills：§b《kunpengTreasureTechnique》 §f------ martialSoul：§e《huang》");
        this.add(ItemInit.jineng_huang_2.get(),"§esoulSkills：§b《niSuanDivineThunder》 §f------ martialSoul：§e《huang》");
        this.add(ItemInit.jineng_huang_3.get(),"§esoulSkills：§b《willowGodTechnique》 §f------ martialSoul：§e《huang》");
        this.add(ItemInit.jineng_huang_4.get(),"§esoulSkills：§b《grassKillingSwordTechnique》 §f------ martialSoul：§e《huang》");
        this.add(ItemInit.jineng_huang_5.get(),"§esoulSkills：§b《theSixPathsOfReincarnationHeavenlySkill》 §f------ martialSoul：§e《huang》");
        this.add(ItemInit.jineng_huang_6.get(),"§esoulSkills：§b《reincarnationTreasureTechnique》 §f------ martialSoul：§e《huang》");
        this.add(ItemInit.jineng_huang_7.get(),"§esoulSkills：§b《swordWieldingKilling》 §f------ martialSoul：§e《huang》");
        this.add(ItemInit.jineng_huang_8.get(),"§esoulSkills：§b《unknownSupremeTechnique》 §f------ martialSoul：§e《huang》");
        this.add(ItemInit.jineng_htsc_0.get(),"§eqiWuSoul-§ehaotianHolyHammer： §f------ §e《ultimateMartialSoul》");
        this.add(ItemInit.jineng_htsc_1.get(),"§esoulSkills：§b《haotianZhen》 §f------ martialSoul：§e《haotianHolyHammer》");
        this.add(ItemInit.jineng_htsc_2.get(),"§esoulSkills：§b《haotianShield》 §f------ martialSoul：§e《haotianHolyHammer》");
        this.add(ItemInit.jineng_htsc_3.get(),"§esoulSkills：§b《theMysteriousHammer》 §f------ martialSoul：§e《haotianHolyHammer》");
        this.add(ItemInit.jineng_htsc_4.get(),"§esoulSkills：§b《heavenAndEarthAreInfinite》 §f------ martialSoul：§e《haotianHolyHammer》");
        this.add(ItemInit.jineng_htsc_5.get(),"§esoulSkills：§b《haotianNineWonders》 §f------ martialSoul：§e《haotianHolyHammer》");
        this.add(ItemInit.jineng_htsc_6.get(),"§esoulSkills：§b《haotianProtector》 §f------ martialSoul：§e《haotianHolyHammer》");
        this.add(ItemInit.jineng_htsc_7.get(),"§esoulSkills：§b《lingTianSStrike》 §f------ martialSoul：§e《haotianHolyHammer》");
        this.add(ItemInit.jineng_htsc_8.get(),"§esoulSkills：§b《fallingThunderHammer》 §f------ martialSoul：§e《haotianHolyHammer》");
        this.add(ItemInit.guoshi_haotianchui    .get(),"§4<haotianHolyHammer> §f------ §c《wuhunFruit》");
        this.add(ItemInit.guoshi_huang          .get(),"§4<huang> §f------ §c《wuhunFruit》");
        this.add(ItemInit.guoshi_jingubang      .get(),"§4<breakingTheHeavenlyGodStick> §f------ §c《wuhunFruit》");
        this.add(ItemInit.danyao_qihundan       .get(),"§aqiSoulPill*Ⅰ阶");
        this.add(ItemInit.danyao_jvlingdan      .get(),"§bjulingPill*Ⅱ阶");
        this.add(ItemInit.danyao_xvanyuandan    .get(),"§cxuanyuanDan*Ⅲ阶");
        this.add(ItemInit.danyao_yanghundan     .get(),"§dsoulNourishingPill*Ⅳ阶");
        this.add(ItemInit.danyao_lingbidan      .get(),"§eningbiDan*Ⅴ阶");
        this.add(ItemInit.danyao_haoyuan        .get(),"§7haoyuanDan*Ⅵ阶");
        this.add(ItemInit.danyao_xihundan       .get(),"§6dishengPill*Ⅶ阶");
        this.add(ItemInit.danyao_huangjidan     .get(),"§5huangjiDan*Ⅷ阶");
        this.add(ItemInit.danyao_lushendan      .get(),"§4angryGodPill*Ⅸ阶");
        this.add(ItemInit.danyao_jiuhua         .get(),"§1《§bjiuhuaYuluPill§1》");
        this.add(ItemInit.danyao_huanyuandan         .get(),"§1《§bhuanYuanDan§1》");
        this.add(ItemInit.danyao_fanmindan           .get(),"§1《§breturningLifePill§1》");
        this.add(ItemInit.danyao_heqidan             .get(),"§1《§bheqiDan§1》");
        this.add(ItemInit.danyao_zengqidan           .get(),"§1《§bqiBoostingPill§1》");
        this.add(ItemInit.danyao_yishendan              .get(),"§7《§bYiShenDan§7");
        this.add(ItemInit.danyao_xisuidan               .get(),"§7《§bXiShuiDan§7");
        this.add(ItemInit.danyao_longlidan              .get(),"§7《§bLongLiDan§7");
        this.add(ItemInit.danfang_qihundan      .get(),"§adanFang：§f《§aqiSoulPill§f》*Ⅰ阶");
        this.add(ItemInit.danfang_jvlingdan     .get(),"§bdanFang：§f《§bjulingPill§f》*Ⅱ阶");
        this.add(ItemInit.danfang_xvanyuandan   .get(),"§cdanFang：§f《§cxuanyuanDan§f》*Ⅲ阶");
        this.add(ItemInit.danfang_yanghundan    .get(),"§ddanFang：§f《§dsoulNourishingPill§f》*Ⅳ阶");
        this.add(ItemInit.danfang_lingbidan     .get(),"§edanFang：§f《§eningbiDan§f》*Ⅴ阶");
        this.add(ItemInit.danfang_haoyuan       .get(),"§7danFang：§f《§7haoyuanDan§f》*Ⅵ阶");
        this.add(ItemInit.danfang_xihundan      .get(),"§6danFang：§f《§6dishengPill§f》*Ⅶ阶");
        this.add(ItemInit.danfang_huangjidan    .get(),"§5danFang：§f《§5huangjiDan§f》*Ⅷ阶");
        this.add(ItemInit.danfang_lushendan     .get(),"§4danFang：§f《§4angryGodPill§f》*Ⅸ阶");
        this.add(ItemInit.danfang_jiuhua        .get(),"§4danFang：§1《§bjiuhuaYuluPill§1》***");
        this.add(ItemInit.danfang_huanyuandan       .get(),"§4danFang：§1《§bhuanYuanDan§1》***");
        this.add(ItemInit.danfang_fanmindan         .get(),"§4danFang：§1《§breturningLifePill§1》***");
        this.add(ItemInit.danfang_heqidan           .get(),"§4danFang：§1《§bheqiDan§1》***");
        this.add(ItemInit.danfang_zengqidan         .get(),"§4danFang：§1《§bqiBoostingPill§1》***");
        this.add(ItemInit.danfang_yishendan         .get(),"§4danFang：§7《§bYiShenDan§7》***");
        this.add(ItemInit.danfang_xisuidan          .get(),"§4danFang：§7《§bXiSuiDan§7》***");
        this.add(ItemInit.danfang_longlidan         .get(),"§4danFang：§7《§bLongLiDan§7》***");
        this.add(ItemInit.headbone              .get(),"§cskull §f§k****** §e《ancientMysteriousBones》");
        this.add(ItemInit.exoskeletonsoulbone.get(),"§cextrinsicBone §f§k****** §e《ancientMysteriousBones》");
        this.add(ItemInit.lefthandbone          .get(),"§cleftArmBone §f§k****** §e《ancientMysteriousBones》");
        this.add(ItemInit.righthandbone         .get(),"§crightArmBone §f§k****** §e《ancientMysteriousBones》");
        this.add(ItemInit.trunkbone             .get(),"§ctrunkBone §f§k****** §e《ancientMysteriousBones》");
        this.add(ItemInit.leftlegbone           .get(),"§cleftLegBone §f§k****** §e《ancientMysteriousBones》");
        this.add(ItemInit.rightlegbone          .get(),"§crightLegBone §f§k****** §e《ancientMysteriousBones》");
        this.add(ItemInit.hunmin_spanw_egg      .get(),"generateSoulPeople");




//实体
        this.add(EntityInit.hunmin.get(),"§asoulPeople");
        this.add(EntityInit.HUNHE.get(),"§9soulCore");
        this.add(EntityInit.HUNHUAN.get(),"§9soulRing");



    }
}
