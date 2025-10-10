package hua.huase.shanhaicontinent.init;

import com.mojang.blaze3d.platform.InputConstants;
import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.config.Config;
import hua.huase.shanhaicontinent.network.NetworkHandler;
import hua.huase.shanhaicontinent.network.client.CPacketHunji;
import hua.huase.shanhaicontinent.network.client.CPacketOpenAttrGUI;
import hua.huase.shanhaicontinent.network.client.CPacketQiehuanWuhun;
import hua.huase.shanhaicontinent.screen.PlayerAttrubuteContainerMenu;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jline.utils.Log;
import org.lwjgl.glfw.GLFW;

public class KeyMappingInit {
    // In some physical client only class

    // Key mapping is lazily initialized so it doesn't exist until it is registered
    public static final KeyMapping HUNJI = new KeyMapping(
            "技能开关", // Will be localized using this translation key
            InputConstants.Type.KEYSYM, // Default mapping is on the keyboard
            GLFW.GLFW_KEY_R, // Default key is P
            SHMainBus.MOD_ID // Mapping will be in the misc category
        );
    public static final KeyMapping ATTRIBUTE_MAPPING = new KeyMapping(
            "属性面板",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_O,
            SHMainBus.MOD_ID
    );
    public static final KeyMapping KAIGUAN_MAPPING = new KeyMapping(
            "武魂开关",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_K,
            SHMainBus.MOD_ID //
    );
    public static final KeyMapping FIRSTPERSONDISPLAY_MAPPING = new KeyMapping(
            "第一人称渲染",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_F6, //
            SHMainBus.MOD_ID //
    );

    @Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class RegisterBindings {
        // Event is on the mod event bus only on the physical client
        @SubscribeEvent
        public static void registerBindings(RegisterKeyMappingsEvent event) {
            event.register(ATTRIBUTE_MAPPING);
            event.register(KAIGUAN_MAPPING);
            event.register(HUNJI);
            event.register(FIRSTPERSONDISPLAY_MAPPING);
        }
    }

    @Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class OnClientTick{
        // Event is on the Forge event bus only on the physical client

        @SubscribeEvent
        public static void onKeyPressed(InputEvent.Key event) {
            if(event.getAction() == InputConstants.PRESS){
                if (FIRSTPERSONDISPLAY_MAPPING.getKey().getValue() == event.getKey()) {
                    Config.FIRSTPERSONDISPLAY.set(!Config.FIRSTPERSONDISPLAY.get());
                }
                if (ATTRIBUTE_MAPPING.getKey().getValue() == event.getKey()) {
                    NetworkHandler.INSTANCE.sendToServer(new CPacketOpenAttrGUI());
                }
                if (KAIGUAN_MAPPING.getKey().getValue() == event.getKey()) {
                    NetworkHandler.INSTANCE.sendToServer(new CPacketQiehuanWuhun());
                }
                if (HUNJI.getKey().getValue() == event.getKey()) {
                    NetworkHandler.INSTANCE.sendToServer(new CPacketHunji());
                }
            }
        }
//        @SubscribeEvent
        public static void onClientTick(TickEvent.ClientTickEvent event) {


        }
    }
}
