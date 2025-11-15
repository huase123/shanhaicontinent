package hua.huase.shanhaicontinent.item;

import hua.huase.shanhaicontinent.animation.AnimationControllerInit;
import hua.huase.shanhaicontinent.animation.AnimationUtil;
import hua.huase.shanhaicontinent.datagen.level.SHStructureTagGenerator;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.EyeOfEnder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class TextItem extends Item {
    public TextItem(Properties p) {
        super(new Item.Properties());
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        BlockHitResult blockhitresult = getPlayerPOVHitResult(pLevel, pPlayer, ClipContext.Fluid.NONE);
        if (blockhitresult.getType() == HitResult.Type.BLOCK && pLevel.getBlockState(blockhitresult.getBlockPos()).is(Blocks.END_PORTAL_FRAME)) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            pPlayer.startUsingItem(pUsedHand);
            if (pLevel instanceof ServerLevel) {
                ServerLevel serverlevel = (ServerLevel)pLevel;

            AnimationUtil.play(pPlayer, AnimationControllerInit.demo.get());
                return InteractionResultHolder.success(itemstack);
            }

            return InteractionResultHolder.consume(itemstack);
        }
    }

//    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
//
//        if (!level.isClientSide) {
////            AnimationUtil.play(livingEntity, AnimationControllerInit.demo.get());
////            attackAnimationState.stop();
//        }
////        int i;
////        if(livingEntity instanceof ServerPlayer serverPlayer){
////
////            PlayerHunHuanAPI.addManHunhuanT(serverPlayer);
////
////        }
////
////        if (livingEntity instanceof Player && !((Player)livingEntity).getAbilities().instabuild) {
////            itemStack.shrink(1);
////        }
//
//        return itemStack;
//    }

}
