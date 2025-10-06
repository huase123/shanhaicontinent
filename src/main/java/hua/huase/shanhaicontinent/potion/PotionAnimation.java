package hua.huase.shanhaicontinent.potion;

import hua.huase.shanhaicontinent.event.api.LeveRenderPlaerEventPostEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.client.event.RenderPlayerEvent;

import java.util.Map;

public interface PotionAnimation {

     void renderPlayer(LeveRenderPlaerEventPostEvent event);
}
