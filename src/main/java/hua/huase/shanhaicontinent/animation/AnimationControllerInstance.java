package hua.huase.shanhaicontinent.animation;

import hua.huase.shanhaicontinent.init.SHRegistries;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * - @description:AnimationControllerInstance类动画控制实列
 * - @author: huase。
 * - @date: 2025/11/11 1:13
 */
public class AnimationControllerInstance implements INBTSerializable<CompoundTag> {
    private final Entity entity;
    SHAnimationController animationcontroller;
    long startime;

    public AnimationControllerInstance(Entity entity) {
        this.entity = entity;
    }
    public void play(SHAnimationController shAnimationController,LivingEntity livingEntity){
        this.animationcontroller = shAnimationController;
        this.startime = livingEntity.level().getGameTime();
    }

    //动画是否结束
    public boolean isover() {
        if(animationcontroller == null ||(
                startime+ animationcontroller.getDuration(entity)<entity.level().getGameTime())
        ){
            return true;
        }
        return false;
    }

    //返回动画播放时间
    public long getCumulativeTime() {
        if(isover())return 0;
        return entity.level().getGameTime()-startime;
    }

    public SHAnimationController getAnimationcontroller() {
        return animationcontroller;
    }

    public Entity getEntity() {
        return entity;
    }

    public void tick() {
        animationcontroller.tick(entity);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag compoundTag = new CompoundTag();

        if(animationcontroller == null)return compoundTag;
        ResourceLocation key = SHRegistries.shAnimationControllers__IForgeRegistry.getKey(animationcontroller);
        if (key != null) {
            compoundTag.putString("animationcontroller",key.toString());
            compoundTag.putLong("startime",startime);
        }

        return compoundTag;
    }

    @Override
    public void deserializeNBT(CompoundTag compoundTag) {
        this.animationcontroller = SHRegistries.shAnimationControllers__IForgeRegistry.getValue(new ResourceLocation(compoundTag.getString("animationcontroller")));
        this.startime = compoundTag.getLong("startime");
    }

    public float getDuration() {
        return animationcontroller.getDuration(entity);
    }
}
