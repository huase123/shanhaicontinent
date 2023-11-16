package hua.huase.shanhaicontinent.item.jineng;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface JinengMethond {

    static Map<String,List<Item>> monsterCapabilityLists = new HashMap<>();

    static boolean isBinding(ItemStack stack, Entity entityPlayer) {
        if(stack.getTagCompound()!=null && entityPlayer instanceof EntityPlayer && stack.getTagCompound().getString("playername").equals(entityPlayer.getName())){
            return true;
        }

        stack.setCount(0);
        return false;
    }

    static void addJinengItem(Item item,String s){
        if(monsterCapabilityLists.get(s)==null)monsterCapabilityLists.put(s,new ArrayList<>());
        monsterCapabilityLists.get(s).add(item);
    }

    void removeAttributeModifiers(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityEquipmentSlot equipmentSlot);
    void addAttributeModifiers(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityEquipmentSlot equipmentSlot);
}
