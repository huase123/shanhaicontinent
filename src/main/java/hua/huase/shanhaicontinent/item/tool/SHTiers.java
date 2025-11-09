package hua.huase.shanhaicontinent.item.tool;

import hua.huase.shanhaicontinent.item.ItemInit;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Supplier;

public enum SHTiers implements Tier {
    mingtie(4, 1800, 12.0F, 2.0F, 80, () -> {
        return Ingredient.of(ItemInit.itemmingtie.get());
    }),
    heijin(5, 2400, 14.0F, 2.0F, 32, () -> {
        return Ingredient.of(ItemInit.itemheijin.get());
    }),
    lanlingjin(6, 4800, 18.0F, 2.0F, 32, () -> {
        return Ingredient.of(ItemInit.itemlanlingjin.get());
    }),
    lanhaizuan(7, 9600, 24.0F, 3.0F, 32, () -> {
        return Ingredient.of(ItemInit.itemlanhaizuan.get());
    }),
    cixuexianjin(99, 19800, 32.0F, 3.0F, 32, () -> {
        return Ingredient.of(ItemInit.itemcixuexianjin.get());
    });

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private SHTiers(int pLevel, int pUses, float pSpeed, float pDamage, int pEnchantmentValue, Supplier<Ingredient> pRepairIngredient) {
        this.level = pLevel;
        this.uses = pUses;
        this.speed = pSpeed;
        this.damage = pDamage;
        this.enchantmentValue = pEnchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @org.jetbrains.annotations.Nullable public net.minecraft.tags.TagKey<net.minecraft.world.level.block.Block> getTag() {
//        return net.minecraftforge.common.ForgeHooks.getTagFromVanillaTier(this);
        return Tags.Blocks.NEEDS_NETHERITE_TOOL;
    }
}
