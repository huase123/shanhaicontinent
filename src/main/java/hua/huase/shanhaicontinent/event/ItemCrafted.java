package hua.huase.shanhaicontinent.event;

import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.ItemCapability;
import hua.huase.shanhaicontinent.capability.baubles.IBauble;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber
public class ItemCrafted {

//    public static Map<Integer,Integer> stageHashMap=new HashMap<>();
//    @SideOnly(Side.CLIENT)
////    @SubscribeEvent
//    public static void playerTick(TickEvent.PlayerTickEvent event) {
//
//    }




    @SubscribeEvent
    public static void itemCrafted(PlayerEvent.ItemCraftedEvent event) {
        InventoryCrafting craftMatrix = (InventoryCrafting)event.craftMatrix;
        ItemStack stackInSlot = ItemStack.EMPTY;

        for (int i = 0; i < 9; i++) {
                if (!craftMatrix.getStackInSlot(i).isEmpty())
                {
                    stackInSlot = craftMatrix.getStackInSlot(i);
                    break;
                }
        }

        if(stackInSlot.isEmpty())return;
        if(stackInSlot.getItem() instanceof IBauble){
            ItemStack crafting = event.crafting;
            ItemCapability capability = stackInSlot.getCapability(CapabilityRegistryHandler.ITEM_CAPABILITY, null);
            if(capability==null)return;
            int nianxian = capability.getNianxian();

//            crafting.setCount(8);

            if(nianxian>=1000000){
                crafting.setCount(9);
                crafting.setItemDamage(8);
            }else if(nianxian>=100000){
                crafting.setCount(nianxian/100000+1);
                crafting.setItemDamage(7);
            }else if(nianxian>=10000){
                crafting.setCount(nianxian/10000+1);
                crafting.setItemDamage(6);
            }else if(nianxian>=8000){
                crafting.setCount(nianxian/1000+1);
                crafting.setItemDamage(5);
            }else if(nianxian>=5000){
                crafting.setCount(nianxian/800+1);
                crafting.setItemDamage(4);
            }else if(nianxian>=1000){
                crafting.setCount(nianxian/500+1);
                crafting.setItemDamage(3);
            }else if(nianxian>=500){
                crafting.setCount(nianxian/100+1);
                crafting.setItemDamage(2);
            }else if(nianxian>=100){
                crafting.setCount(nianxian/50+1);
                crafting.setItemDamage(1);
            }else if(nianxian>=1){
                crafting.setCount(nianxian/10+1);
                crafting.setItemDamage(0);
            }







        }


    }

}
