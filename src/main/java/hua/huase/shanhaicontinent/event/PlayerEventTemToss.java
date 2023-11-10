package hua.huase.shanhaicontinent.event;

import hua.huase.shanhaicontinent.item.jineng.JinengMethond;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class PlayerEventTemToss {



    @SubscribeEvent
    public static void onStartTracking(ItemTossEvent event) {
        EntityPlayer player = event.getPlayer();
        EntityItem entityItem = event.getEntityItem();
        if(entityItem.getItem().getItem()instanceof JinengMethond && !JinengMethond.isBinding(entityItem.getItem(),player)){
            event.setCanceled(true);
        }

    }


}
