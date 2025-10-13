package hua.huase.shanhaicontinent.entity.hunhuan;

import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capabilitys.PlayerHunHuanAPI;
import hua.huase.shanhaicontinent.entity.NoHunhuan;
import hua.huase.shanhaicontinent.entity.hunhe.HunheEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class HunhuanEntity extends Entity implements NoHunhuan {
    private int existenceTime;
    private int livetime;
    private Player player;
    public HunhuanEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.level().isClientSide)return;
        if(this.level().getGameTime()%20 == 0){
            secondtick();
        }
        if(livetime>=1000){
            this.getCapability(MonsterAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
                HunheEntity.createHunhe(HunheEntity.conversionValue(capability.getNianxian()),level(),this.getOnPos());
            });

            this.discard();
        }
        if(player != null && player.getVehicle()!=null && player.getVehicle() == this){
            return;
        }
        livetime++;
    }


    public void secondtick() {
        if(player != null && player.getVehicle()!=null && player.getVehicle() == this){
            if(PlayerHunHuanAPI.isXishouHunhuan((ServerPlayer) player,this)){
                PlayerHunHuanAPI.xishouHunhuan(player,this);
                existenceTime++;
            }
        }else {
            existenceTime= 0;
        }
    }

    public boolean isAttackable() {
        return true;
    }


    public boolean skipAttackInteraction(Entity entity) {
        if(entity instanceof Player){
            return false;
        }
        return true;
    }


    public boolean hurt(DamageSource damageSource, float damage) {
        if(damageSource.getEntity() instanceof Player player){
            livetime +=40;

        }

        return false;
    }
    @Override
    public boolean isPickable() {
        return true;
    }

    public InteractionResult interact(Player player, InteractionHand hand) {
        if (player.isSecondaryUseActive()) {
//            return InteractionResult.PASS;
//                    分解魂环
            livetime+=1000;
            return InteractionResult.SUCCESS;
        } else{
            if (!this.level().isClientSide) {
                if(player.startRiding(this)){
                    this.player = player;
                    existenceTime = 0;
                    return InteractionResult.CONSUME;
                }else {
                    return InteractionResult.PASS;
                }
            } else {
                return InteractionResult.SUCCESS;
            }
        }
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }

    public int getExistenceTime() {
        return existenceTime;
    }

    public void setExistenceTime(int existenceTime) {
        this.existenceTime = existenceTime;
    }

    public int getLivetime() {
        return livetime;
    }

    public void setLivetime(int livetime) {
        this.livetime = livetime;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
