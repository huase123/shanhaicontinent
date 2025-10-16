package hua.huase.shanhaicontinent.event.client;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.item.DanYaoItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PWItemTooltipEvent {


//    @SubscribeEvent
    public static void onItemTooltipEvent(ItemTooltipEvent event){
        ItemStack itemStack = event.getItemStack();
        if(!itemStack.isEmpty() && itemStack.getItem() instanceof DanYaoItem danYaoItem ){
//            danYaoItem.playerAppendHoverText(event.getItemStack(),event.getEntity(),event.getToolTip());
        }
    }
}
