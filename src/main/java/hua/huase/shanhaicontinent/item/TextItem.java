package hua.huase.shanhaicontinent.item;

import hua.huase.shanhaicontinent.capabilitys.PlayerHunHuanAPI;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TextItem extends Item {
    public TextItem(Properties p) {
        super(p);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {

        int i;
        if(livingEntity instanceof ServerPlayer serverPlayer){

            PlayerHunHuanAPI.addManHunhuanT(serverPlayer);

        }

        if (livingEntity instanceof Player && !((Player)livingEntity).getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        return itemStack;
    }

}
