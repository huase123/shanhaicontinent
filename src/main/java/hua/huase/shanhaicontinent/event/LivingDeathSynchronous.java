package hua.huase.shanhaicontinent.event;

import hua.huase.shanhaicontinent.item.jineng.JinengMethond;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

@Mod.EventBusSubscriber
public class LivingDeathSynchronous {

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event)
    {
        EntityLivingBase entityLiving = event.getEntityLiving();
        if (!entityLiving.world.isRemote&&entityLiving instanceof EntityPlayer)
        {
            for (EntityEquipmentSlot entityequipmentslot : EntityEquipmentSlot.values()) {
                EntityPlayer entityLiving1 = (EntityPlayer) entityLiving;
                ItemStack itemstack1 = entityLiving1.getItemStackFromSlot(entityequipmentslot);
                if(itemstack1.getItem() instanceof JinengMethond){
                    itemstack1.setCount(0);
                }
            }
        }
    }


    @SubscribeEvent
    public static void onPlayerLoggedOutEvent(PlayerEvent.PlayerLoggedOutEvent event){
        if(event !=null &&event.player != null && event.player instanceof EntityPlayer && !event.player.world.isRemote){

            EntityPlayer entity =  event.player;

            for (EntityEquipmentSlot entityequipmentslot : EntityEquipmentSlot.values()) {
                ItemStack from = entity.getItemStackFromSlot(entityequipmentslot);
                if (!from.isEmpty() && from.getItem()instanceof JinengMethond && from.getTagCompound()!=null && from.getTagCompound().getString("playername").equals(entity.getName()))
                {
                    ((JinengMethond) from.getItem()).removeAttributeModifiers(from,entity,entityequipmentslot);
                    from.setCount(0);
                }

            }
        }
    }



    @SubscribeEvent
    public static void onPlayerClone(net.minecraftforge.event.entity.player.PlayerEvent.Clone event)
    {

        EntityPlayer player = event.getEntityPlayer();
        if(player!=null && !player.world.isRemote){


            for (EntityEquipmentSlot entityequipmentslot : EntityEquipmentSlot.values()) {
                ItemStack from = player.getItemStackFromSlot(entityequipmentslot);
                if (!from.isEmpty() && from.getItem()instanceof JinengMethond && from.getTagCompound()!=null && from.getTagCompound().getString("playername").equals(player.getName()))
                {
                    ((JinengMethond) from.getItem()).removeAttributeModifiers(from,player,entityequipmentslot);
                    from.setCount(0);
                }

            }
        }

    }



}
