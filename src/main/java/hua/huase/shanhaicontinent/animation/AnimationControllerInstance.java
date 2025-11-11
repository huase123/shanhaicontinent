package hua.huase.shanhaicontinent.animation;

import hua.huase.shanhaicontinent.functiontypes.FunctionTypeInit;
import hua.huase.shanhaicontinent.init.SHRegistries;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * - @description:AnimationControllerInstance类
 * - @author: huase。
 * - @date: 2025/11/11 1:13
 */
public class AnimationControllerInstance implements INBTSerializable<CompoundTag> {
    SHAnimationController animationcontroller;
    long startime;

    public AnimationControllerInstance(Player player) {

    }
    public void play(SHAnimationController shAnimationController,LivingEntity livingEntity){
        this.animationcontroller = shAnimationController;
        this.startime = livingEntity.level().getGameTime();
    }

    //动画是否结束
    public boolean isover(LivingEntity livingEntity) {
        if(animationcontroller == null ||(
                startime+ animationcontroller.getDuration(livingEntity)<livingEntity.level().getGameTime())
        ){
            return true;
        }
        return false;
    }

    //返回动画播放时间
    public long getCumulativeTime(LivingEntity livingEntity) {
        if(isover(livingEntity))return 0;
        return livingEntity.level().getGameTime()-startime;
    }

    //获取播放的动画
    public AnimationDefinition getAnimationDefinition(LivingEntity livingEntity) {
        return animationcontroller.getAnimationDefinition(livingEntity);
    }

    public void steupAnimtick(LivingEntity livingEntity, HumanoidModel<?> humanoidModel, ModelPart modelPart, float nowtime) {

    }

    public void tick(Player player) {

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
}
