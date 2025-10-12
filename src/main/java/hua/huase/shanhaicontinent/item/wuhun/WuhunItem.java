package hua.huase.shanhaicontinent.item.wuhun;

import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import hua.huase.shanhaicontinent.item.Hunhuan;
import hua.huase.shanhaicontinent.item.Wuhun;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static hua.huase.shanhaicontinent.init.ItemInit.wuhunlist;

/**
 * - @description:WuhunItem类
 * - @author: huase。
 * - @date: 2025/10/12 9:02
 */
public class WuhunItem extends Item implements Wuhun {
    FunctionType functionType;

    public WuhunItem(FunctionType functionType) {
        super(new Item.Properties().stacksTo(1));
        this.functionType = functionType;
        wuhunlist.add(this);
    }

    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);
        list.add(Component.translatable("能在地面上产生威力无比的震动，对前方造成伤害").withStyle(ChatFormatting.GREEN));

        list.add(Component.translatable("蹲下释放可破环地形").withStyle(ChatFormatting.GRAY));
    }
}
