package hua.huase.shanhaicontinent.event;

import hua.huase.shanhaicontinent.item.jineng.JinengMethond;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class PlayerEventChangeItemSiot {



    @SubscribeEvent
    public static void changeItemSiot(LivingEquipmentChangeEvent event) {
        EntityLivingBase entityLiving = event.getEntityLiving();
        ItemStack from = event.getFrom();
        ItemStack to = event.getTo();
        EntityEquipmentSlot slot = event.getSlot();

        if (!from.isEmpty() && from.getItem()instanceof JinengMethond && from.getTagCompound()!=null && from.getTagCompound().getString("playername").equals(entityLiving.getName()))
        {
            ((JinengMethond) from.getItem()).removeAttributeModifiers(from,entityLiving,slot);
        }

        if (!to.isEmpty()&&to.getItem()instanceof JinengMethond  && to.getTagCompound()!=null && to.getTagCompound().getString("playername").equals(entityLiving.getName()))
        {
            ((JinengMethond) to.getItem()).addAttributeModifiers(to,entityLiving,slot);
        }


    }


}
