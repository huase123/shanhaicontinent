package hua.huase.shanhaicontinent.enchantment;

import hua.huase.shanhaicontinent.ExampleMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;

public class LuoDiShuiExplosion extends Enchantment
{

/*
        Rarity:稀有度
        EnumEnchantmentType:工具类型
        EntiyEquipmentSlot[]:工具生效位置
*/

    public LuoDiShuiExplosion()
    {
        super(Rarity.RARE, EnumEnchantmentType.ARMOR_LEGS,
                new EntityEquipmentSlot[] {EntityEquipmentSlot.LEGS});
        this.setName(ExampleMod.MODID + ".luodishui");
        this.setRegistryName("luodishui");
    }

    @Override
    public int getMaxLevel()
    {
        return 3;
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 16 + enchantmentLevel * 5;
    }

    @Override
    public int getMaxEnchantability(int enchantmentLevel)
    {
        return 21 + enchantmentLevel * 5;
    }



//    附魔冲突
    @Override
    protected boolean canApplyTogether(Enchantment ench)
    {
        return super.canApplyTogether(ench) && Enchantments.SWEEPING != ench;
    }
}
