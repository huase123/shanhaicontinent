package hua.huase.shanhaicontinent.init;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.item.ItemInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Map;

import static hua.huase.shanhaicontinent.init.BlockInit.ORELIST;
import static hua.huase.shanhaicontinent.item.ItemInit.ARMORLIST;

public class CreativeModTabsInit {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SHMainBus.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("shanhaicontient_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemInit.TEXTITEM.get()))
                    .title(Component.translatable("creativetab.shanhaicontient_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(Items.DIAMOND);

                        pOutput.accept(ItemInit.TEXTITEM.get());

                        pOutput.accept(ItemInit.headbone.get());
                        pOutput.accept(ItemInit.lefthandbone.get());
                        pOutput.accept(ItemInit.leftlegbone.get());
                        pOutput.accept(ItemInit.righthandbone.get());
                        pOutput.accept(ItemInit.rightlegbone.get());
                        pOutput.accept(ItemInit.trunkbone.get());
                        pOutput.accept(ItemInit.exoskeletonsoulbone.get());



//                        pOutput.accept(ItemInit.BOLT.get());
//                        pOutput.accept(ItemInit.RHINO_SPANW_EGG.get());


                        pOutput.accept(BlockInit.SAPPHIRE_BLOCK.get());
                        pOutput.accept(BlockInit.POT_BLOCK.get());

                        pOutput.accept(BlockInit.SOUL_BLOCK.get());

                        pOutput.accept(ItemInit.wanfajieshao.get());
                        for (RegistryObject<Item> itemRegistryObject : ItemInit.hunyepinglist) {
                            pOutput.accept(itemRegistryObject.get());
                        }

                        pOutput.accept(ItemInit.guoshi_huang.get());
                        pOutput.accept(ItemInit.guoshi_jingubang.get());
                        pOutput.accept(ItemInit.guoshi_haotianchui.get());

                        for (RegistryObject<Item> itemRegistryObject : ItemInit.DANYAOLIST) {
                            pOutput.accept(itemRegistryObject.get());
                        }
                        for (RegistryObject<Item> itemRegistryObject : ItemInit.DANFANGLIST) {
                            pOutput.accept(itemRegistryObject.get());
                        }
                        for (RegistryObject<Item> itemRegistryObject : ItemInit.SEEDLIST) {
                            pOutput.accept(itemRegistryObject.get());
                        }
                        for (RegistryObject<Item> itemRegistryObject : ItemInit.FRUITLIST) {
                            pOutput.accept(itemRegistryObject.get());
                        }
                        for (RegistryObject<Item> itemRegistryObject : ItemInit.HUNGULIST) {
                            pOutput.accept(itemRegistryObject.get());
                        }

                        for (Map.Entry<String, ArrayList<RegistryObject<Item>>> stringArrayListEntry : ItemInit.JINENGMAP.entrySet()) {
                            for (RegistryObject<Item> itemRegistryObject : stringArrayListEntry.getValue()) {
                                pOutput.accept(itemRegistryObject.get());
                            }

                        }
                        for (RegistryObject<Item> itemRegistryObject : ARMORLIST) {
                            pOutput.accept(itemRegistryObject.get());
                        }
                        for (RegistryObject<Block> blockRegistryObject : ORELIST) {
                            pOutput.accept(blockRegistryObject.get());
                        }

                        pOutput.accept(ItemInit.hunmin_spanw_egg.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
