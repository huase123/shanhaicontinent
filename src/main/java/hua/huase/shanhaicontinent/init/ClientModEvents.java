package hua.huase.shanhaicontinent.init;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.animation.client.AnimationRenderers;
import hua.huase.shanhaicontinent.block.entityblock.pot.PotBlockEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * - @description:ClientModEvents类
 */
@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public  class ClientModEvents {
    @SubscribeEvent
//    public static void onClientSetup(FMLClientSetupEvent event) {
    public static void register(EntityRenderersEvent.RegisterRenderers event) {
        AnimationRenderers.init();
    }
}
