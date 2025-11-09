package hua.huase.shanhaicontinent.item;

import hua.huase.shanhaicontinent.capabilitys.PlayerHunHuanAPI;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class TextItem extends Item {
    public TextItem(Properties p) {
        super(p);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        if (!level.isClientSide) {
            if(attackAnimationState.isStarted()){
                attackAnimationState.stop();
            }else {
                attackAnimationState.start(livingEntity.tickCount);
            }
//            attackAnimationState.stop();
        }
//        int i;
//        if(livingEntity instanceof ServerPlayer serverPlayer){
//
//            PlayerHunHuanAPI.addManHunhuanT(serverPlayer);
//
//        }
//
//        if (livingEntity instanceof Player && !((Player)livingEntity).getAbilities().instabuild) {
//            itemStack.shrink(1);
//        }

        return itemStack;
    }

    public final static AnimationState attackAnimationState = new AnimationState();
    public static int attackAnimationTimeout = 0;
//    public void onUseTick(Level pLevel, LivingEntity pLivingEntity, ItemStack pStack, int pCount) {
//        if (!pLevel.isClientSide) {
//            if(attackAnimationTimeout <= 0) {
//                attackAnimationTimeout = 80; // Length in ticks of your animation
//                attackAnimationState.start(pCount);
//            } else {
//                --this.attackAnimationTimeout;
//            }
//            if(attackAnimationState.isStarted()){
//                attackAnimationState.stop();
//            }else {
//                attackAnimationState.start(pCount);
//            }
////            attackAnimationState.stop();
//        }
//    }

}
