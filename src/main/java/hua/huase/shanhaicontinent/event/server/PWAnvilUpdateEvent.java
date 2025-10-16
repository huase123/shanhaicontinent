package hua.huase.shanhaicontinent.event.server;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.item.jineng.Jineng;
import hua.huase.shanhaicontinent.item.jineng.JinengBase;
import hua.huase.shanhaicontinent.item.jineng.WuqiAttribute;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PWAnvilUpdateEvent {
    @SubscribeEvent
    public static void livingDeathEvent(AnvilUpdateEvent event){


        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        Player player = event.getPlayer();


        if(left.getItem() instanceof WuqiAttribute wuqiAttribute&& right.getItem() instanceof JinengBase jinengBase){
            if(jinengBase.isBelongToPlayer(player,left) && ((Jineng)wuqiAttribute).isBelongToPlayer(player,right)){
                ItemStack copy = left.copy();
                CompoundTag tagCompound = copy.getOrCreateTag();
                if(tagCompound!=null){
                    CompoundTag compound = right.serializeNBT();
                    byte b= 0;
                    CompoundTag wuhunjineng = (CompoundTag) tagCompound.get("wuhunjineng"+b);
                    while (wuhunjineng !=null && !wuhunjineng.equals(compound)){
                        ++b;
                        wuhunjineng = (CompoundTag) tagCompound.get("wuhunjineng"+b);
                    }
                    tagCompound.put("wuhunjineng"+b,compound);
                }
                event.setOutput(copy);
                event.setCost(10);
                event.setMaterialCost(1);
            }

        }



    }


}
