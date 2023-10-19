package hua.huase.shanhaicontinent.villager;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.block.FlowerBlock;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber
public class VillagerRegistryHandler
{
//    村名VillagerProfession
    public static final VillagerProfession DIRT_WORKER =
            new VillagerProfession(ExampleMod.MODID + ".huncaoworker",
                    ExampleMod.MODID + ":textures/entity/villager/dirt_worker.png",
                    ExampleMod.MODID + ":textures/entity/zombie_villager/zombie_dirt_worker.png");
//    职业
    public static final VillagerCareer DIRT_WORKER_CAREER =
            new VillagerCareer(DIRT_WORKER, ExampleMod.MODID + ".huncaoworker");

    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<VillagerProfession> event)
    {

        IForgeRegistry<VillagerProfession> registry = event.getRegistry();


        for (FlowerBlock flowerBlock : FlowerBlock.flowerBlocksList) {


            DIRT_WORKER_CAREER.addTrade(1, (merchant, recipeList, random) ->
            {
                recipeList.add(new MerchantRecipe(
                        new ItemStack(HanderAny.soulSoilItem, 1, 0),
                        ItemStack.EMPTY,
                        new ItemStack(flowerBlock,2,1)));
            });


        }

        for (FlowerBlock flowerBlock : FlowerBlock.flowerBlocksList) {


            DIRT_WORKER_CAREER.addTrade(2, (merchant, recipeList, random) ->
            {
                recipeList.add(new MerchantRecipe(
                        new ItemStack(HanderAny.soulSoilItem, 1, 1),
                        ItemStack.EMPTY,
                        new ItemStack(flowerBlock,1,2)));
            });


        }

        for (FlowerBlock flowerBlock : FlowerBlock.flowerBlocksList) {


            DIRT_WORKER_CAREER.addTrade(3, (merchant, recipeList, random) ->
            {
                recipeList.add(new MerchantRecipe(
                        new ItemStack(HanderAny.soulSoilItem, 1, 2),
                        ItemStack.EMPTY,
                        new ItemStack(flowerBlock,5,2)));
            });


        }


        DIRT_WORKER_CAREER.addTrade(2, (merchant, recipeList, random) ->
        {
            recipeList.add(new MerchantRecipe(
                    new ItemStack(HanderAny.soulSoilItem, 10, 3),
                    new ItemStack(Items.PAPER, 1, 0),
                    new ItemStack(HanderAny.danfang,1,0)));
        });

        DIRT_WORKER_CAREER.addTrade(3, (merchant, recipeList, random) ->
        {
            recipeList.add(new MerchantRecipe(
                    new ItemStack(HanderAny.soulSoilItem, 10, 4),
                    new ItemStack(Items.PAPER, 1, 0),
                    new ItemStack(HanderAny.danfang,1,1)));
        });


        DIRT_WORKER_CAREER.addTrade(4, (merchant, recipeList, random) ->
        {
            recipeList.add(new MerchantRecipe(
                    new ItemStack(HanderAny.soulSoilItem, 10, 5),
                    new ItemStack(Items.PAPER, 1, 0),
                    new ItemStack(HanderAny.danfang,1,2)));
        });


        DIRT_WORKER_CAREER.addTrade(5, (merchant, recipeList, random) ->
        {
            recipeList.add(new MerchantRecipe(
                    new ItemStack(HanderAny.soulSoilItem, 10, 6),
                    new ItemStack(Items.PAPER, 1, 0),
                    new ItemStack(HanderAny.danfang,1,3)));
        });






        registry.register(DIRT_WORKER);
        /*
        DIRT_WORKER_CAREER.addTrade(1,
                new EntityVillager.EmeraldForItems((HanderAny.itemList.get(1)),//泥土球换绿宝石
                        new EntityVillager.PriceInfo(8, 10)
                ),

                new EntityVillager.ListItemForEmeralds(Item.getItemFromBlock(Blocks.DIRT),//绿宝石换泥土块
                        new EntityVillager.PriceInfo(1, 2)
                )
        );

*/
    }
}
