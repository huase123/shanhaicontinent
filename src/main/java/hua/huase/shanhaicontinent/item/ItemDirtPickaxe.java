package hua.huase.shanhaicontinent.item;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemDirtPickaxe extends ItemPickaxe
{
    public ItemDirtPickaxe(Item.ToolMaterial TMATERIAL,String name, CreativeTabs Tabs)
    {
        super(TMATERIAL);
        this.setUnlocalizedName(ExampleMod.MODID + name);
        this.setRegistryName(name);
        this.setCreativeTab(Tabs);
        HanderAny.itemList.add(this);
    }


    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Block block = state.getBlock();
        float speed = super.getDestroySpeed(stack, state);
        return (block == Blocks.DIRT || block == Blocks.GRASS) ? speed * 10 : speed;
    }
}
