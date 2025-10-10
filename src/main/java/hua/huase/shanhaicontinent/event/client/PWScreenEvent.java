package hua.huase.shanhaicontinent.event.client;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.event.api.LeveRenderLivingEntityPostEvent;
import net.minecraft.Util;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.PauseScreen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.client.gui.widget.ExtendedButton;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * - @description:PWScreenEvent类
 * - @author: huase。
 * - @date: 2025/10/10 3:41
 */
@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PWScreenEvent {

    protected static final Button.CreateNarration DEFAULT_NARRATION = (p_253298_) -> {
        return p_253298_.get();
    };
    @SubscribeEvent
    public static void screenEventInitPost(ScreenEvent.Init.Post event){
        if(event.getScreen() !=null && event.getScreen() instanceof PauseScreen pauseScreen){
            event.addListener(new ExtendedButton(100, 100, 30, 200, Component.translatable("narrator.button.difficulty_lock"), new Button.OnPress() {
                @Override
                public void onPress(Button pButton) {
                    System.out.println("哈哈哈");
                }
            }, DEFAULT_NARRATION));
        }
    }
}
