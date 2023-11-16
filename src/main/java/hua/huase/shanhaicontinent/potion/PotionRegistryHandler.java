package hua.huase.shanhaicontinent.potion;

import hua.huase.shanhaicontinent.potion.potionjineng.PotionChangewugong;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber
public class PotionRegistryHandler
{
    public static final List<Potion> POTION_LIST = new ArrayList<>();
    public static final Potion POTION_DIRT_PROTECTION = new PotionChangewugong();
    @SubscribeEvent
    public static void onPotionRegistry(RegistryEvent.Register<Potion> event)
    {
        IForgeRegistry<Potion> registry = event.getRegistry();
        registry.register(POTION_DIRT_PROTECTION);
    }

}
