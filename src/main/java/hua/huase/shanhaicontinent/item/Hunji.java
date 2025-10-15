package hua.huase.shanhaicontinent.item;

import hua.huase.shanhaicontinent.capabilitys.capability.HunhuanCapability;
import hua.huase.shanhaicontinent.capabilitys.capability.MosterCapability;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/**
 * - @description:Hunji类
 * - @author: huase。
 * - @date: 2025/10/12 4:09
 */
public interface Hunji {
    void monsterHoldTick(LivingEntity entity, MosterCapability mosterCapability, ItemStack hunhuanitemstack, HunhuanCapability hunhuanCapability, ItemStack hunji);

}
