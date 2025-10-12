package hua.huase.shanhaicontinent.item.hunji;

import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import hua.huase.shanhaicontinent.item.Hunhuan;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;

import static hua.huase.shanhaicontinent.init.ItemInit.hunjilist;

/**
 * - @description:HunjiItem类
 * - @author: huase。
 * - @date: 2025/10/12 6:52
 */
public class HunjiItem extends Item implements Hunhuan {
    FunctionType functionType;

    public HunjiItem(FunctionType functionType) {
        super(new Item.Properties().stacksTo(1));
        this.functionType = functionType;
        hunjilist.add(this);
    }



    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
//        if(!this.isBelongToPlayer(player,itemstack))return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
//        int nianxian = this.getNianxian(player, itemstack);
//        level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENDER_PEARL_THROW, SoundSource.NEUTRAL, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
//        player.getCooldowns().addCooldown(this, (int) (120-Math.log10(nianxian)*10));
//        if (!level.isClientSide) {
//
//            Jineng_HTSC_1_Entity entity = new Jineng_HTSC_1_Entity(EntityInit.jinenghtsc1.get(), level);
//            entity.setOwner(player);
//            double v = -Math.sin((player.getYRot()) * 0.017453292F) * 6f;
//            double v1 = Math.cos((player.getYRot()) * 0.017453292F) * 6f;
//
//            entity.setPos(player.getX()+v,player.getY()+4,player.getZ()+v1);
//            entity.setItem(itemstack);
//            entity.shootFromRotation(player, 90, 0, 0.0F, 0.4F, 0.0F);
//            entity.isExploade = player.isShiftKeyDown();
//            level.addFreshEntity(entity);
//        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }


    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);
        list.add(Component.translatable("能在地面上产生威力无比的震动，对前方造成伤害").withStyle(ChatFormatting.GREEN));

        list.add(Component.translatable("蹲下释放可破环地形").withStyle(ChatFormatting.GRAY));
    }
}
