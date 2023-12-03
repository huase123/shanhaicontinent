package hua.huase.shanhaicontinent.advancements;

import hua.huase.shanhaicontinent.advancements.tupo.ICriterionTupo;
import hua.huase.shanhaicontinent.advancements.tupo.ICriterionXishouHunHuan;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.critereon.PositionTrigger;
import net.minecraft.util.ResourceLocation;

public class TFAdvancements {
    /*
    public static final HasAdvancementTrigger ADVANCEMENT_UNLOCKED = CriteriaTriggers.register(new HasAdvancementTrigger());
    public static final MakePortalTrigger MADE_TF_PORTAL = CriteriaTriggers.register(new MakePortalTrigger());
    public static final HydraChopTrigger CONSUME_HYDRA_CHOP = CriteriaTriggers.register(new HydraChopTrigger());
    public static final QuestRamCompletionTrigger QUEST_RAM_COMPLETED = CriteriaTriggers.register(new QuestRamCompletionTrigger());
    public static final TrophyPedestalTrigger PLACED_TROPHY_ON_PEDESTAL = CriteriaTriggers.register(new TrophyPedestalTrigger());
    public static final ActivateGhastTrapTrigger ACTIVATED_GHAST_TRAP = CriteriaTriggers.register(new ActivateGhastTrapTrigger());
    public static final StructureClearedTrigger STRUCTURE_CLEARED = CriteriaTriggers.register(new StructureClearedTrigger());
    public static final ItemUseTrigger ITEM_USE_TRIGGER = CriteriaTriggers.register(new ItemUseTrigger());
    public static final ArmorInventoryChangedTrigger ARMOR_CHANGED = CriteriaTriggers.register(new ArmorInventoryChangedTrigger());
    */
    public static final ICriterionTupo PLAYER_TUPO = CriteriaTriggers.register(new ICriterionTupo());
    public static final ICriterionXishouHunHuan PLAYER_XISHOUHUNHUAN = CriteriaTriggers.register(new ICriterionXishouHunHuan());
    public static final PositionTrigger PLAYER_ZHUANSHENG = CriteriaTriggers.register(new PositionTrigger(new ResourceLocation("zhuansheng")));

    public static void init() {}
}
