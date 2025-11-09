package hua.huase.shanhaicontinent.datagen;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.item.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static hua.huase.shanhaicontinent.item.ItemInit.ARMORLIST;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, SHMainBus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        for (Map.Entry<String, ArrayList<RegistryObject<Item>>> stringArrayListEntry : ItemInit.JINENGMAP.entrySet()) {
            for (RegistryObject<Item> itemRegistryObject : stringArrayListEntry.getValue()) {
                simpleItem(itemRegistryObject);
            }

        }

        for (RegistryObject<Item> itemRegistryObject : ARMORLIST) {
            handheldItem(itemRegistryObject);
        }


        wuqiItem(ItemInit.jineng_jgb_0);
        wuqiItem(ItemInit.jineng_htsc_0);
        wuqiItem(ItemInit.jineng_htsc_3);

        wuqiItem(ItemInit.guoshi_huang);
        wuqiItem(ItemInit.guoshi_haotianchui);
        wuqiItem(ItemInit.guoshi_jingubang);
        for (RegistryObject<Item> itemRegistryObject : ItemInit.hunyepinglist) {
            wuqiItem(itemRegistryObject);
        }


        simpleItem(ItemInit.wanfajieshao);


        withExistingParent(ItemInit.hunmin_spanw_egg.getId().getPath(), mcLoc("item/template_spawn_egg"));

        for (RegistryObject<Item> itemRegistryObject : ItemInit.DANYAOLIST) {
            simpleItem(itemRegistryObject);
        }
        for (RegistryObject<Item> itemRegistryObject : ItemInit.DANFANGLIST) {
            simpleItem(itemRegistryObject);
        }
        for (RegistryObject<Item> itemRegistryObject : ItemInit.HUNGULIST) {
            simpleItem(itemRegistryObject);
        }
//        simpleSeedItem(ItemInit.fengxinzi_seed);
        for (RegistryObject<Item> itemRegistryObject : ItemInit.SEEDLIST) {
            simpleSeedItem(itemRegistryObject);
        }
//        simpleFruitItem(ItemInit.fengxinzi_fruit);
        for (RegistryObject<Item> itemRegistryObject : ItemInit.FRUITLIST) {
            simpleFruitItem(itemRegistryObject);
        }

//        simpleItem(ItemInit.itemkongjianshi);
//        simpleItem(ItemInit.itemmingtie);
//        simpleItem(ItemInit.itemheijin);
//        simpleItem(ItemInit.itemlanlingjin);
//        simpleItem(ItemInit.itemlanhaizuan);
//        simpleItem(ItemInit.itemcixuexianjin);
//
//        simpleBaoGuItem(ItemInit.baogu00);
//        simpleBaoGuItem(ItemInit.baogu01);
//        simpleBaoGuItem(ItemInit.baogu02);
//
//        simpleBaoGuItem(ItemInit.baogu10);
//        simpleBaoGuItem(ItemInit.baogu11);
//        simpleBaoGuItem(ItemInit.baogu12);
//
//        simpleBaoGuItem(ItemInit.baogu20);
//        simpleBaoGuItem(ItemInit.baogu21);
//        simpleBaoGuItem(ItemInit.baogu22);
//
//        simpleBaoGuItem(ItemInit.baogu30);
//        simpleBaoGuItem(ItemInit.baogu31);
//        simpleBaoGuItem(ItemInit.baogu32);
//
//        simpleBaoGuItem(ItemInit.baogu40);
//        simpleBaoGuItem(ItemInit.baogu41);
//        simpleBaoGuItem(ItemInit.baogu42);
//
//        simpleBaoGuItem(ItemInit.baogu50);
//        simpleBaoGuItem(ItemInit.baogu51);
//        simpleBaoGuItem(ItemInit.baogu52);

//        simpleItem(ItemInit.TEXTITEM);

//        withExistingParent(ItemInit.SHUZHU_SPANW_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
//        withExistingParent(ItemInit.RHINO_SPANW_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

//        simpleItem(ModItems.SAPPHIRE);
//        simpleItem(ModItems.RAW_SAPPHIRE);
//
//        simpleItem(ModItems.METAL_DETECTOR);
//        simpleItem(ModItems.PINE_CONE);
//        simpleItem(ModItems.STRAWBERRY);
//        simpleItem(ModItems.STRAWBERRY_SEEDS);
//
//        simpleItem(ModItems.CORN);
//        simpleItem(ModItems.CORN_SEEDS);
//
//        simpleItem(ModItems.BAR_BRAWL_MUSIC_DISC);
//
//        simpleBlockItem(ModBlocks.SAPPHIRE_DOOR);
//
//        fenceItem(ModBlocks.SAPPHIRE_FENCE, ModBlocks.SAPPHIRE_BLOCK);
//        buttonItem(ModBlocks.SAPPHIRE_BUTTON, ModBlocks.SAPPHIRE_BLOCK);
//        wallItem(ModBlocks.SAPPHIRE_WALL, ModBlocks.SAPPHIRE_BLOCK);
//
//        evenSimplerBlockItem(ModBlocks.SAPPHIRE_STAIRS);
//        evenSimplerBlockItem(ModBlocks.SAPPHIRE_SLAB);
//        evenSimplerBlockItem(ModBlocks.SAPPHIRE_PRESSURE_PLATE);
//        evenSimplerBlockItem(ModBlocks.SAPPHIRE_FENCE_GATE);
//
//        trapdoorItem(ModBlocks.SAPPHIRE_TRAPDOOR);
//
//        handheldItem(ModItems.SAPPHIRE_SWORD);
//        handheldItem(ModItems.SAPPHIRE_PICKAXE);
//        handheldItem(ModItems.SAPPHIRE_AXE);
//        handheldItem(ModItems.SAPPHIRE_SHOVEL);
//        handheldItem(ModItems.SAPPHIRE_HOE);
//
//        trimmedArmorItem(ModItems.SAPPHIRE_HELMET);
//        trimmedArmorItem(ModItems.SAPPHIRE_CHESTPLATE);
//        trimmedArmorItem(ModItems.SAPPHIRE_LEGGINGS);
//        trimmedArmorItem(ModItems.SAPPHIRE_BOOTS);
//
//        simpleBlockItemBlockTexture(ModBlocks.CATMINT);
//
//        withExistingParent(ModItems.RHINO_SPANW_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
//
//        simpleItem(ModItems.PINE_SIGN);
//        simpleItem(ModItems.PINE_HANGING_SIGN);
//
//        simpleItem(ModItems.PINE_BOAT);
//        simpleItem(ModItems.PINE_CHEST_BOAT);
//
//        simpleItem(ModItems.DICE);
//        saplingItem(ModBlocks.PINE_SAPLING);
    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = SHMainBus.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + armorItem;
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = new ResourceLocation(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = new ResourceLocation(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = new ResourceLocation(MOD_ID, currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                new ResourceLocation(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    private void wuqiItem(RegistryObject<Item> itemRegistryObject) {

        String currentTrimName =itemRegistryObject.getKey().location().getPath()+"_base";
        ResourceLocation trimNameResLoc = new ResourceLocation(SHMainBus.MOD_ID, currentTrimName);

        this.withExistingParent(itemRegistryObject.getId().getPath(),
                        mcLoc("item/generated"))
                .override()
                .model(new ModelFile.UncheckedModelFile(trimNameResLoc));
    }


    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SHMainBus.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SHMainBus.MOD_ID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleSeedItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation(SHMainBus.MOD_ID,"block/" + item.getId().getPath().split("_")[0]+"_stage0"));


    }
    private ItemModelBuilder simpleFruitItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation(SHMainBus.MOD_ID,"block/" + item.getId().getPath().split("_")[0]+"_stage3"));

    }
    private ItemModelBuilder simpleBaoGuItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SHMainBus.MOD_ID,"item/" + "baogu"));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(SHMainBus.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(SHMainBus.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(SHMainBus.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(SHMainBus.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SHMainBus.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SHMainBus.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SHMainBus.MOD_ID,"block/" + item.getId().getPath()));
    }
}