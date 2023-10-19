package hua.huase.shanhaicontinent.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TabExample extends CreativeTabs {
//    public static final CreativeTabs TAB1=new TabExample("shanhaicontinent");
    public static final CreativeTabs TAB2=new TabExample("textTab");

    public TabExample(String TABNANE) {
        super(CreativeTabs.getNextID(), TABNANE);
    }

    @Override
    public ItemStack getTabIconItem() {        return new ItemStack(Items.BED);
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
