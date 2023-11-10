package hua.huase.shanhaicontinent.item.jineng;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface JinengMethond {
    public static boolean isBinding(ItemStack stack, Entity entityPlayer) {
        if(stack.getTagCompound()!=null && entityPlayer instanceof EntityPlayer && stack.getTagCompound().getString("playername").equals(entityPlayer.getName())){
            return true;
        }

        stack.setCount(0);
        return false;
    }
}
