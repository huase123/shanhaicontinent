package hua.huase.shanhaicontinent.datagen.util;

import com.google.gson.JsonObject;
import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.init.ModRecipesInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

public class SHFinishedRecipe implements FinishedRecipe {

    private ItemLike PEIFANG;
    private ItemLike RANLIAO;
    private ItemLike JIN;
    private ItemLike MU;
    private ItemLike SHUI;
    private ItemLike HUO;
    private ItemLike TU;
    private ItemLike JEIGUO;
    private int num;
    private int nengliang;


    @Override
    public void serializeRecipeData(JsonObject pJson) {

        JsonObject jsonobject = new JsonObject();

        jsonobject.add("PEIFANG",   Ingredient.of(PEIFANG).toJson());
        jsonobject.add("RANLIAO",   Ingredient.of(RANLIAO).toJson());
        jsonobject.add("JIN",       Ingredient.of(JIN).toJson());
        jsonobject.add("MU",        Ingredient.of(MU).toJson());
        jsonobject.add("SHUI",      Ingredient.of(SHUI).toJson());
        jsonobject.add("HUO",       Ingredient.of(HUO).toJson());
        jsonobject.add("TU",        Ingredient.of(TU).toJson());
        jsonobject.add("JEIGUO",    Ingredient.of(JEIGUO).toJson());
        pJson.addProperty("nengliang",nengliang);
        pJson.add("key", jsonobject);
        JsonObject jsonobject1 = new JsonObject();
        jsonobject1.addProperty("item", BuiltInRegistries.ITEM.getKey(JEIGUO.asItem()).toString());
        if (num > 1) {
            jsonobject1.addProperty("count", num);
        }

        pJson.add("result", jsonobject1);
    }

    @Override
    public ResourceLocation getId() {
        return new ResourceLocation(SHMainBus.MOD_ID,"pot/"+BuiltInRegistries.ITEM.getKey(JIN.asItem()).getPath()+BuiltInRegistries.ITEM.getKey(PEIFANG.asItem()).getPath() +"_to_"+BuiltInRegistries.ITEM.getKey(JEIGUO.asItem()).getPath()+num );
    }

    @Override
    public RecipeSerializer<?> getType() {
        return ModRecipesInit.POT_TEXT.get();
    }

    @Nullable
    @Override
    public JsonObject serializeAdvancement() {
        return null;
    }

    @Nullable
    @Override
    public ResourceLocation getAdvancementId() {
        return null;
    }

    public SHFinishedRecipe setPEIFANG(ItemLike PEIFANG) {
        this.PEIFANG = PEIFANG;
        return this;
    }

    public SHFinishedRecipe setRANLIAO(ItemLike RANLIAO) {
        this.RANLIAO = RANLIAO;
        return this;
    }

    public SHFinishedRecipe setJIN(ItemLike JIN) {
        this.JIN = JIN;
        return this;
    }

    public SHFinishedRecipe setMU(ItemLike MU) {
        this.MU = MU;
        return this;
    }

    public SHFinishedRecipe setSHUI(ItemLike SHUI) {
        this.SHUI = SHUI;
        return this;
    }

    public SHFinishedRecipe setHUO(ItemLike HUO) {
        this.HUO = HUO;
        return this;
    }

    public SHFinishedRecipe setTU(ItemLike TU) {
        this.TU = TU;
        return this;
    }

    public SHFinishedRecipe setJEIGUO(ItemLike JEIGUO) {
        this.JEIGUO = JEIGUO;
        return this;
    }

    public SHFinishedRecipe setNum(int num) {
        this.num = num;
        return this;
    }

    public SHFinishedRecipe setNengliang(int nengliang) {
        this.nengliang = nengliang;
        return this;
    }
}
