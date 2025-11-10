package hua.huase.shanhaicontinent.event.api;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

/**
*      - @description:HumanoidModelsteupAnimEvent类
*      - @author: huase。
*      - @date: 2025/11/10 3:57
*      
*/
public class HumanoidModelsteupAnimEvent {
    public HumanoidModel<?> getHumanoidModel() {
        return humanoidModel;
    }

    public ModelPart getpRoot() {
        return pRoot;
    }

    public LivingEntity getpEntity() {
        return pEntity;
    }

    public float getpLimbSwing() {
        return pLimbSwing;
    }

    public float getpLimbSwingAmount() {
        return pLimbSwingAmount;
    }

    public float getpAgeInTicks() {
        return pAgeInTicks;
    }

    public float getpNetHeadYaw() {
        return pNetHeadYaw;
    }

    public float getpHeadPitch() {
        return pHeadPitch;
    }

    private final HumanoidModel<?> humanoidModel;
    private final ModelPart pRoot;
    private final LivingEntity pEntity;
    private final float pLimbSwing;
    private final float pLimbSwingAmount;
    private final float pAgeInTicks;
    private final float pNetHeadYaw;
    private final float pHeadPitch;

    public HumanoidModelsteupAnimEvent(HumanoidModel<?> humanoidModel, ModelPart pRoot, LivingEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

        this.humanoidModel = humanoidModel;
        this.pRoot = pRoot;
        this.pEntity = pEntity;
        this.pLimbSwing = pLimbSwing;
        this.pLimbSwingAmount = pLimbSwingAmount;
        this.pAgeInTicks = pAgeInTicks;
        this.pNetHeadYaw = pNetHeadYaw;
        this.pHeadPitch = pHeadPitch;
    }
}
