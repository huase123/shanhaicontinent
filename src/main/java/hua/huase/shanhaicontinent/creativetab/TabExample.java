package hua.huase.shanhaicontinent.creativetab;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class TabExample extends CreativeTabs {
    public static final CreativeTabs TAB1 =new TabExample("shanhaicontinent.wuping");
    public static final CreativeTabs TAB2=new TabExample("shanhaicontinent.wuhun");

    public TabExample(String TABNANE) {
        super(CreativeTabs.getNextID(), TABNANE);
    }

    @Override
    public ItemStack getTabIconItem() {        return new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":textsword")));
    }

    @Override
    public boolean hasSearchBar()
    {
        return true;
    }

    @Override
    public int getSearchbarWidth()
    {
        return 45;
    }

    @Override
    public String getBackgroundImageName()
    {
        return "shanhaicontinent.png";
    }
}
