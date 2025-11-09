package hua.huase.shanhaicontinent.event.server;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.item.ItemInit;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PWPlayerLoggedInEvent {
    @SubscribeEvent
    public static void onPlayerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event){
        Player entity = event.getEntity();
        entity.sendSystemMessage(Component.translatable("player join world", entity.getName()));

        if(entity instanceof ServerPlayer serverPlayer){
            ItemStack itemStack = new ItemStack(ItemInit.wanfajieshao.get());
            if(!itemStack.isEmpty()){
                serverPlayer.addItem(itemStack);
            }
        }

    }


}
