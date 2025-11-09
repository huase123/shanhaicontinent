package hua.huase.shanhaicontinent.datagen;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.advance.*;
import hua.huase.shanhaicontinent.init.BlockInit;
import hua.huase.shanhaicontinent.item.ItemInit;
import hua.huase.shanhaicontinent.init.SHModMobEffectsinit;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.EffectsChangedTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.MobEffectsPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public class ModAdvanceProvider implements AdvancementSubProvider {
    public void generate(HolderLookup.Provider p_256214_, Consumer<Advancement> p_250851_) {
        Advancement root = Advancement.Builder.advancement()
                .display(BlockInit.POT_BLOCK.get()
                        , Component.translatable("魂士").withStyle(ChatFormatting.GOLD)
                        , Component.translatable("第一次升级,踏上修行路").withStyle(ChatFormatting.DARK_GREEN),
//                        new ResourceLocation(SHMainBus.MOD_ID,"textures/block/soul_block.png"),
                        new ResourceLocation("textures/block/diamond_block.png"),
                        FrameType.GOAL, true, true, false)
                .addCriterion("xishouhunhe", XishouHunheTrigger.TriggerInstance.createInstance()).
                save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/root");


        Advancement juexingwuhun1 = Advancement.Builder.advancement().parent(root)
                .display(ItemInit.TEXTITEM.get()
                        ,Component.translatable("觉醒武魂").withStyle(ChatFormatting.GREEN)
                        ,Component.translatable("觉醒武魂后并开启才能吸收魂环哦？？？？").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("juexingwuhun1", JuexingwuhunTrigger.TriggerInstance.createInstance(1))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/juexingwuhun/juexingwuhun1");



        Advancement juexingwuhun2 = Advancement.Builder.advancement().parent(juexingwuhun1)
                .display(ItemInit.TEXTITEM.get()
                        ,Component.translatable("觉醒双生武魂").withStyle(ChatFormatting.DARK_PURPLE)
                        ,Component.translatable("觉醒武魂后并开启才能吸收魂环哦？？？？").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.CHALLENGE, true, true, false)
                .addCriterion("juexingwuhun2", JuexingwuhunTrigger.TriggerInstance.createInstance(2))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/juexingwuhun/juexingwuhun2");



        Advancement juexingwuhun3 = Advancement.Builder.advancement().parent(juexingwuhun2)
                .display(ItemInit.TEXTITEM.get()
                        ,Component.translatable("觉醒三生武魂").withStyle(ChatFormatting.DARK_RED)
                        ,Component.translatable("觉醒武魂后并开启才能吸收魂环哦？？？？").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.CHALLENGE, true, true, false)
                .addCriterion("juexingwuhun3", JuexingwuhunTrigger.TriggerInstance.createInstance(3))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/juexingwuhun/juexingwuhun3");



        Advancement xishouhunhuan1 = Advancement.Builder.advancement().parent(root)
                .display(ItemInit.TEXTITEM.get()
                        ,Component.translatable("吸收魂环").withStyle(ChatFormatting.WHITE)
                        ,Component.translatable("拥有魂环后才能召唤技能哦？？？？").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.CHALLENGE, true, true, false)
                .addCriterion("xishouhunhuan1", XishouhunhuanTrigger.TriggerInstance.createInstance(1))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/xishouhunhuan/xishouhunhuan1");

        Advancement xishouhunhuan100 = Advancement.Builder.advancement().parent(xishouhunhuan1)
                .display(ItemInit.TEXTITEM.get()
                        ,Component.translatable("吸收百年魂环").withStyle(ChatFormatting.YELLOW)
                        ,Component.translatable("拥有魂环后才能召唤技能哦？？？？").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.CHALLENGE, true, true, false)
                .addCriterion("xishouhunhuan100", XishouhunhuanTrigger.TriggerInstance.createInstance(100))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/xishouhunhuan/xishouhunhuan100");


        Advancement xishouhunhuan1000 = Advancement.Builder.advancement().parent(xishouhunhuan100)
                .display(ItemInit.TEXTITEM.get()
                        ,Component.translatable("吸收千年魂环").withStyle(ChatFormatting.DARK_PURPLE)
                        ,Component.translatable("拥有魂环后才能召唤技能哦？？？？").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.CHALLENGE, true, true, false)
                .addCriterion("xishouhunhuan1000", XishouhunhuanTrigger.TriggerInstance.createInstance(1000))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/xishouhunhuan/xishouhunhuan1000");


        Advancement xishouhunhuan10000 = Advancement.Builder.advancement().parent(xishouhunhuan1000)
                .display(ItemInit.TEXTITEM.get()
                        ,Component.translatable("吸收万年魂环").withStyle(ChatFormatting.BLACK)
                        ,Component.translatable("拥有魂环后才能召唤技能哦？？？？").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.CHALLENGE, true, true, false)
                .addCriterion("xishouhunhuan10000", XishouhunhuanTrigger.TriggerInstance.createInstance(10000))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/xishouhunhuan/xishouhunhuan10000");


        Advancement xishouhunhuan100000 = Advancement.Builder.advancement().parent(xishouhunhuan10000)
                .display(ItemInit.TEXTITEM.get()
                        ,Component.translatable("吸收十万年魂环").withStyle(ChatFormatting.RED)
                        ,Component.translatable("拥有魂环后才能召唤技能哦？？？？").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.CHALLENGE, true, true, false)
                .addCriterion("xishouhunhuan100000", XishouhunhuanTrigger.TriggerInstance.createInstance(100000))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/xishouhunhuan/xishouhunhuan100000");


        Advancement xishouhunhuan1000000 = Advancement.Builder.advancement().parent(xishouhunhuan100000)
                .display(ItemInit.TEXTITEM.get()
                        ,Component.translatable("吸收百万年魂环").withStyle(ChatFormatting.DARK_RED)
                        ,Component.translatable("拥有魂环后才能召唤技能哦？？？？").withStyle(ChatFormatting.GRAY)
                        ,(ResourceLocation)null
                        ,FrameType.CHALLENGE, true, true, false)
                .addCriterion("xishouhunhuan1000000", XishouhunhuanTrigger.TriggerInstance.createInstance(1000000))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/xishouhunhuan/xishouhunhuan1000000");



        Advancement hunyeping = Advancement.Builder.advancement().parent(root)
                .display(ItemInit.hunyeping0.get()
                        ,Component.translatable("获得魂液瓶").withStyle(ChatFormatting.DARK_GREEN)
                        ,Component.translatable("能够装精纯的能量").withStyle(ChatFormatting.DARK_GREEN)
                        ,(ResourceLocation)null
                        ,FrameType.TASK, true, true, false)
                .addCriterion("hunyeping", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemInit.hunyeping0.get(),
                        ItemInit.hunyeping1.get(),
                        ItemInit.hunyeping2.get(),
                        ItemInit.hunyeping3.get(),
                        ItemInit.hunyeping4.get(),
                        ItemInit.hunyeping5.get(),
                        ItemInit.hunyeping6.get()
                ))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/huodeitem/hunyeping");


        Advancement zhaohualu = Advancement.Builder.advancement().parent(root)
                .display(BlockInit.POT_BLOCK.get()
                        ,Component.translatable("造化炉").withStyle(ChatFormatting.YELLOW)
                        ,Component.translatable("可生万物，炼制丹药").withStyle(ChatFormatting.LIGHT_PURPLE)
                        ,(ResourceLocation)null
                        ,FrameType.TASK, true, true, false)
                .addCriterion("zhaohualu", InventoryChangeTrigger.TriggerInstance.hasItems(BlockInit.POT_BLOCK.get()))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/huodeitem/zhaohualu");



        Advancement bianhua = Advancement.Builder.advancement().parent(root)
                .display(ItemInit.bianhua_seed.get()
                        ,Component.translatable("彼岸花").withStyle(ChatFormatting.DARK_PURPLE)
                        ,Component.translatable("生长时可为附近玩家提供《梦回万古debuff》").withStyle(ChatFormatting.LIGHT_PURPLE)
                        ,(ResourceLocation)null
                        ,FrameType.CHALLENGE, true, true, false)
                .addCriterion("TASK", InventoryChangeTrigger.TriggerInstance.hasItems(ItemInit.bianhua_seed.get(),ItemInit.bianhua_fruit.get()))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/huodeitem/bianhua");


        Advancement menghuiwangu = Advancement.Builder.advancement().parent(bianhua)
                .display(ItemInit.bianhua_fruit.get()
                        ,Component.translatable("梦回万古").withStyle(ChatFormatting.DARK_PURPLE)
                        ,Component.translatable("获得《梦回万古debuff》").withStyle(ChatFormatting.DARK_AQUA)
                        ,(ResourceLocation)null
                        ,FrameType.CHALLENGE, true, true, false)
                .addCriterion("TASK", EffectsChangedTrigger.TriggerInstance.hasEffects(MobEffectsPredicate.effects().and(SHModMobEffectsinit.zhiwu_bianhua.get())))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/huodedebuff/menghuiwangu");



        Advancement zhuansheng = Advancement.Builder.advancement().parent(menghuiwangu)
                .display(ItemInit.TEXTITEM.get()
                        ,Component.translatable("转生").withStyle(ChatFormatting.DARK_RED)
                        ,Component.translatable("在有《梦回万古》时睡觉，并精神力超过3000时可以转生，属性重回0级，并移除魂环和武魂，返还武魂果实").withStyle(ChatFormatting.RED)
                        ,(ResourceLocation)null
                        ,FrameType.CHALLENGE, true, true, false)
                .addCriterion("zhuansheng", MenghuiwanguTrigger.TriggerInstance.createInstance())
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/teshu/zhuansheng");



        Advancement changedeng10 = Advancement.Builder.advancement().parent(root)
                .display(ItemInit.danyao_qihundan.get()
                        ,Component.translatable("魂师").withStyle(ChatFormatting.DARK_GRAY)
                        ,Component.translatable("成功突破到10级").withStyle(ChatFormatting.DARK_GREEN)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("changedengji_10", ChangeDengjiTrigger.TriggerInstance.createInstance(10))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/changedengji/tupo_10");

        Advancement changedeng20 = Advancement.Builder.advancement().parent(changedeng10)
                .display(ItemInit.danyao_jvlingdan.get()
                        ,Component.translatable("大魂师").withStyle(ChatFormatting.GRAY)
                        ,Component.translatable("成功突破到20级").withStyle(ChatFormatting.DARK_GREEN)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("changedengji_20", ChangeDengjiTrigger.TriggerInstance.createInstance(20))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/changedengji/tupo_20");


        Advancement changedeng30 = Advancement.Builder.advancement().parent(changedeng20)
                .display(ItemInit.danyao_xvanyuandan.get()
                        ,Component.translatable("魂尊").withStyle(ChatFormatting.DARK_PURPLE)
                        ,Component.translatable("成功突破到30级").withStyle(ChatFormatting.DARK_GREEN)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("changedengji_30", ChangeDengjiTrigger.TriggerInstance.createInstance(30))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/changedengji/tupo_30");


        Advancement changedeng40 = Advancement.Builder.advancement().parent(changedeng30)
                .display(ItemInit.danyao_yanghundan.get()
                        ,Component.translatable("魂宗").withStyle(ChatFormatting.LIGHT_PURPLE)
                        ,Component.translatable("成功突破到40级").withStyle(ChatFormatting.DARK_GREEN)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("changedengji_40", ChangeDengjiTrigger.TriggerInstance.createInstance(40))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/changedengji/tupo_40");


        Advancement changedeng50 = Advancement.Builder.advancement().parent(changedeng40)
                .display(ItemInit.danyao_lingbidan.get()
                        ,Component.translatable("魂王").withStyle(ChatFormatting.BLUE)
                        ,Component.translatable("成功突破到50级").withStyle(ChatFormatting.DARK_GREEN)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("changedengji_50", ChangeDengjiTrigger.TriggerInstance.createInstance(50))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/changedengji/tupo_50");


        Advancement changedeng60 = Advancement.Builder.advancement().parent(changedeng50)
                .display(ItemInit.danyao_haoyuan.get()
                        ,Component.translatable("魂帝").withStyle(ChatFormatting.DARK_BLUE)
                        ,Component.translatable("成功突破到60级").withStyle(ChatFormatting.DARK_GREEN)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("changedengji_60", ChangeDengjiTrigger.TriggerInstance.createInstance(60))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/changedengji/tupo_60");


        Advancement changedeng70 = Advancement.Builder.advancement().parent(changedeng60)
                .display(ItemInit.danyao_xihundan.get()
                        ,Component.translatable("魂圣").withStyle(ChatFormatting.YELLOW)
                        ,Component.translatable("成功突破到70级").withStyle(ChatFormatting.DARK_GREEN)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("changedengji_70", ChangeDengjiTrigger.TriggerInstance.createInstance(70))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/changedengji/tupo_70");


        Advancement changedeng80 = Advancement.Builder.advancement().parent(changedeng70)
                .display(ItemInit.danyao_huangjidan.get()
                        ,Component.translatable("斗罗").withStyle(ChatFormatting.RED)
                        ,Component.translatable("成功突破到80级").withStyle(ChatFormatting.DARK_GREEN)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("changedengji_80", ChangeDengjiTrigger.TriggerInstance.createInstance(80))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/changedengji/tupo_80");


        Advancement changedeng90 = Advancement.Builder.advancement().parent(changedeng80)
                .display(ItemInit.danyao_lushendan.get()
                        ,Component.translatable("封号斗罗").withStyle(ChatFormatting.DARK_RED)
                        ,Component.translatable("成功突破到90级").withStyle(ChatFormatting.DARK_GREEN)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("changedengji_90", ChangeDengjiTrigger.TriggerInstance.createInstance(90))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/changedengji/tupo_90");


        Advancement changedeng99 = Advancement.Builder.advancement().parent(changedeng90)
                .display(ItemInit.danyao_jiuhua.get()
                        ,Component.translatable("九九至尊").withStyle(ChatFormatting.DARK_RED)
                        ,Component.translatable("天地压制").withStyle(ChatFormatting.DARK_GREEN)
                        ,(ResourceLocation)null
                        ,FrameType.GOAL, true, true, false)
                .addCriterion("changedengji_99", ChangeDengjiTrigger.TriggerInstance.createInstance(99))
                .save(p_250851_, SHMainBus.MOD_ID+":joinshanhai/changedengji/tupo_99");





//        Advancement advancement1 = Advancement.Builder.advancement().parent(advancement).display(Blocks.END_STONE, Component.translatable("advancements.end.root.title"), Component.translatable("advancements.end.root.description"), new ResourceLocation("textures/gui/advancements/backgrounds/end.png"), FrameType.TASK, false, false, false).addCriterion("hahahah", ChangeDengjiTrigger.TriggerInstance.createInstance(1)).save(p_250851_, "joinshanhai/root");


        /*
        Advancement advancement = Advancement.Builder.advancement().display(Blocks.END_STONE, Component.translatable("advancements.end.root.title"), Component.translatable("advancements.end.root.description"), new ResourceLocation("textures/gui/advancements/backgrounds/end.png"), FrameType.TASK, false, false, false).addCriterion("entered_end", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(Level.END)).save(p_250851_, "end/root");
        Advancement advancement1 = Advancement.Builder.advancement().parent(advancement).display(Blocks.DRAGON_HEAD, Component.translatable("advancements.end.kill_dragon.title"), Component.translatable("advancements.end.kill_dragon.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("killed_dragon", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(EntityType.ENDER_DRAGON))).save(p_250851_, "end/kill_dragon");
        Advancement advancement2 = Advancement.Builder.advancement().parent(advancement1).display(Items.ENDER_PEARL, Component.translatable("advancements.end.enter_end_gateway.title"), Component.translatable("advancements.end.enter_end_gateway.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("entered_end_gateway", EnterBlockTrigger.TriggerInstance.entersBlock(Blocks.END_GATEWAY)).save(p_250851_, "end/enter_end_gateway");
        Advancement.Builder.advancement().parent(advancement1).display(Items.END_CRYSTAL, Component.translatable("advancements.end.respawn_dragon.title"), Component.translatable("advancements.end.respawn_dragon.description"), (ResourceLocation)null, FrameType.GOAL, true, true, false).addCriterion("summoned_dragon", SummonedEntityTrigger.TriggerInstance.summonedEntity(EntityPredicate.Builder.entity().of(EntityType.ENDER_DRAGON))).save(p_250851_, "end/respawn_dragon");
        Advancement advancement3 = Advancement.Builder.advancement().parent(advancement2).display(Blocks.PURPUR_BLOCK, Component.translatable("advancements.end.find_end_city.title"), Component.translatable("advancements.end.find_end_city.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("in_city", PlayerTrigger.TriggerInstance.located(LocationPredicate.inStructure(BuiltinStructures.END_CITY))).save(p_250851_, "end/find_end_city");
        Advancement.Builder.advancement().parent(advancement1).display(Items.DRAGON_BREATH, Component.translatable("advancements.end.dragon_breath.title"), Component.translatable("advancements.end.dragon_breath.description"), (ResourceLocation)null, FrameType.GOAL, true, true, false).addCriterion("dragon_breath", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DRAGON_BREATH)).save(p_250851_, "end/dragon_breath");
        Advancement.Builder.advancement().parent(advancement3).display(Items.SHULKER_SHELL, Component.translatable("advancements.end.levitate.title"), Component.translatable("advancements.end.levitate.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).rewards(AdvancementRewards.Builder.experience(50)).addCriterion("levitated", LevitationTrigger.TriggerInstance.levitated(DistancePredicate.vertical(MinMaxBounds.Doubles.atLeast(50.0D)))).save(p_250851_, "end/levitate");
        Advancement.Builder.advancement().parent(advancement3).display(Items.ELYTRA, Component.translatable("advancements.end.elytra.title"), Component.translatable("advancements.end.elytra.description"), (ResourceLocation)null, FrameType.GOAL, true, true, false).addCriterion("elytra", InventoryChangeTrigger.TriggerInstance.hasItems(Items.ELYTRA)).save(p_250851_, "end/elytra");
        Advancement.Builder.advancement().parent(advancement1).display(Blocks.DRAGON_EGG, Component.translatable("advancements.end.dragon_egg.title"), Component.translatable("advancements.end.dragon_egg.description"), (ResourceLocation)null, FrameType.GOAL, true, true, false).addCriterion("dragon_egg", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.DRAGON_EGG)).save(p_250851_, "end/dragon_egg");

        */
    }
}