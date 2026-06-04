package hua.huase.shanhaicontinent.event.client;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.animation.AnimationControllerInstance;
import hua.huase.shanhaicontinent.animation.AnimationUtil;
import hua.huase.shanhaicontinent.animation.client.IClientMobAnimationExtensions;
import hua.huase.shanhaicontinent.event.api.HumanoidModelsteupAnimEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Vector3f;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * - @description:PWModelsteupAnimEvent类
 * - @author: huase。
 * - @date: 2025/11/11 0:27
 */
@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class PWModelsteupAnimEvent {

    @SubscribeEvent
    public static void onModelsteupAnimEvent(HumanoidModelsteupAnimEvent event){
        LivingEntity livingEntity = event.getpEntity();
        AnimationControllerInstance animationControllerInstance =  AnimationUtil.getAnimationControllerInstance(livingEntity);
        if(animationControllerInstance != null && !animationControllerInstance.isover()){
            IClientMobAnimationExtensions.of(animationControllerInstance).steupAnimtick(animationControllerInstance,event.getpEntity(),event.getHumanoidModel(),event.getpRoot(),event.getpAgeInTicks());
        }
    }
}
