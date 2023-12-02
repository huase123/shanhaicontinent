package hua.huase.shanhaicontinent.event;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.advancements.TFAdvancements;
import hua.huase.shanhaicontinent.api.BaublesApi;
import hua.huase.shanhaicontinent.api.IBaublesItemHandler;
import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.capability.api.ChangeCapability;
import hua.huase.shanhaicontinent.capability.baubles.IBauble;
import hua.huase.shanhaicontinent.handers.HanderAny;
import hua.huase.shanhaicontinent.item.jineng.JinengMethond;
import hua.huase.shanhaicontinent.network.NetworkRegistryHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.entity.player.SleepingTimeCheckEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

import static hua.huase.shanhaicontinent.potion.PotionRegistryHandler.Potion_Debuff_BiAnHua;

@Mod.EventBusSubscriber
public class PlayerEventSleepInBed {

    private static Map<Integer,Integer> stageHashMap=new HashMap<>();


    @SubscribeEvent
    public static void playerSleepInBedEvent(SleepingTimeCheckEvent event) {
        EntityPlayer entityPlayer = event.getEntityPlayer();
        stageHashMap.putIfAbsent(entityPlayer.getEntityId(), 0);
        Integer integer = stageHashMap.get(entityPlayer.getEntityId());
        PlayerCapability capability = entityPlayer.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
        if(integer==10){

            if(!entityPlayer.getHeldItem(EnumHand.MAIN_HAND).isEmpty() && entityPlayer.getHeldItem(EnumHand.MAIN_HAND).getItem() instanceof JinengMethond){
                ItemStack to = entityPlayer.getHeldItem(EnumHand.MAIN_HAND);
                to.setCount(0);


            }
            if(!entityPlayer.getHeldItem(EnumHand.OFF_HAND).isEmpty() && entityPlayer.getHeldItem(EnumHand.OFF_HAND).getItem() instanceof JinengMethond){
                ItemStack to = entityPlayer.getHeldItem(EnumHand.OFF_HAND);
                to.setCount(0);
            }

        }
        if(integer==100 && capability.getDengji()>=99 && entityPlayer.isPotionActive(Potion_Debuff_BiAnHua)){

            entityPlayer.clearActivePotions();

            PlayerCapability playerCapability = new PlayerCapability();
            ChangeCapability.addCapabilityZhuanShi(playerCapability,capability,entityPlayer);


            for (String s : capability.getWuhunListsname()) {
                ItemStack itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":"+s)));
                boolean b = entityPlayer.inventory.addItemStackToInventory(itemStack);
                entityPlayer.world.playSound((EntityPlayer)null, entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.PLAYERS, 0.2F, ((entityPlayer.getRNG().nextFloat() - entityPlayer.getRNG().nextFloat()) * 0.7F + 1.0F) * 2.0F);
                entityPlayer.inventoryContainer.detectAndSendChanges();
                if(!b){
                    entityPlayer.dropItem(itemStack,false);
                }
            }



            capability.deserializeNBT(playerCapability.serializeNBT());


            IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(entityPlayer);
            for(int i = 0; i < baubles.getSlots(); i++) {
                if (baubles.getStackInSlot(i) != null && !baubles.getStackInSlot(i).isEmpty() && baubles.getStackInSlot(i).getItem() instanceof IBauble) {
                    ItemStack stackInSlot = baubles.getStackInSlot(i);
                    stackInSlot.setCount(0);
//                    ChangeCapability.addItem(capability,stackInSlot.getCapability(CapabilityRegistryHandler.ITEM_CAPABILITY,null), (EntityPlayer) entityPlayer);

                }
            }

            TFAdvancements.PLAYER_ZHUANSHENG.trigger((EntityPlayerMP) entityPlayer);

            NetworkRegistryHandler.PlayerListen.sendClientCustomPacket(entityPlayer);
        }
        stageHashMap.put(entityPlayer.getEntityId(),++integer);

    }
    @SubscribeEvent
    public static void playerWakeUpEvent(PlayerWakeUpEvent event) {
        stageHashMap.remove(event.getEntityPlayer().getEntityId());

    }


}
