package hua.huase.shanhaicontinent.item;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemDirtArmor extends ItemArmor
{
    public ItemDirtArmor(ArmorMaterial dirt, String name, EntityEquipmentSlot equipmentSlot, CreativeTabs Tabs)
    {
        super(dirt, 0, equipmentSlot);
        this.setUnlocalizedName(ExampleMod.MODID + name);
        this.setRegistryName(name);
        this.setCreativeTab(Tabs);

        HanderAny.itemList.add(this);

    }
}
