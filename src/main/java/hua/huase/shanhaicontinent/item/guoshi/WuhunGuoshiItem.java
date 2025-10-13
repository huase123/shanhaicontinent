package hua.huase.shanhaicontinent.item.guoshi;

import hua.huase.shanhaicontinent.capabilitys.PlayerHunHuanAPI;
import hua.huase.shanhaicontinent.capability.playerattribute.WuHunName;
import hua.huase.shanhaicontinent.init.ItemInit;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class WuhunGuoshiItem extends Item {

    private String wuhunname;
    public WuhunGuoshiItem(Properties properties) {
        super(properties);
    }

    public static ItemStack getWuhunguo(String s) {
        ItemStack itemStack = ItemStack.EMPTY;
        switch (s){
            case WuHunName.haotianchui:
                itemStack = new ItemStack(ItemInit.guoshi_haotianchui.get());
                break;
            case WuHunName.huang:
                itemStack = new ItemStack(ItemInit.guoshi_huang.get());
                break;
            case WuHunName.jingubang:
                itemStack = new ItemStack(ItemInit.guoshi_jingubang.get());
                break;
        }
        return itemStack;
    }


    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        int i;
        if(livingEntity instanceof ServerPlayer serverPlayer){
            PlayerHunHuanAPI.addWuHun(serverPlayer,this.getWuhunname());

        }

        if (livingEntity instanceof Player && !((Player)livingEntity).getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        return itemStack;
    }

    public String getWuhunname() {
        return wuhunname;
    }

    public WuhunGuoshiItem setWuhunname(String wuhunname) {
        this.wuhunname = wuhunname;
        return this;
    }


    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable("服用后觉醒武魂",wuhunname).withStyle(ChatFormatting.DARK_PURPLE));
    }
}
