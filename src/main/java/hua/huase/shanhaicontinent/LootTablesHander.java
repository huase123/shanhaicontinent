package hua.huase.shanhaicontinent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTablesHander {

    public static final ResourceLocation GUFENGXIAOWU_CHESTS = LootTableList.register(new ResourceLocation(ExampleMod.MODID+":chests/gufengxiaowu"));
    public static final ResourceLocation GUFENGXIAOWU_CHESTS_DiYV = LootTableList.register(new ResourceLocation(ExampleMod.MODID+":chests/gufengxiaowu_diyv"));
    public static final ResourceLocation GUFENGXIAOWU_CHESTS_MODI = LootTableList.register(new ResourceLocation(ExampleMod.MODID+":chests/gufengxiaowu_modi"));
    public static final ResourceLocation GUFENGXIAOWU_CHESTS_MODI_ZUIHOU = LootTableList.register(new ResourceLocation(ExampleMod.MODID+":chests/gufengxiaowu_modi_zuihou"));
    public static void register()
    {
//        LootTableList.register(GUFENGXIAOWU_CHESTS);
    }

}
