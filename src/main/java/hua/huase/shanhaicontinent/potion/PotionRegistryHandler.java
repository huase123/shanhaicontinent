package hua.huase.shanhaicontinent.potion;

import hua.huase.shanhaicontinent.potion.potionjineng.*;
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
    public static final Potion Potion_Wuqijn_JGZ = new PotionWuqijnJGZ();
    public static final Potion Potion_Wuqijn_JDY = new PotionWuqijnJDY();
    public static final Potion Potion_Wuqijn_JLCY = new PotionWuqijnJLCY();
    public static final Potion Potion_Wuqijn_JGZS = new PotionWuqijnJGZS();
    public static final Potion Potion_Wuqijn_DZSY = new PotionWuqijnDZSY();
    public static final Potion Potion_Wuqijn_DZSFT = new PotionWuqijnDZSFT();
    @SubscribeEvent
    public static void onPotionRegistry(RegistryEvent.Register<Potion> event)
    {
        IForgeRegistry<Potion> registry = event.getRegistry();
//        registry.register(Potion_Wuqijn_JGZ);
        registry.registerAll(POTION_LIST.toArray(new Potion[0]));
    }

}
