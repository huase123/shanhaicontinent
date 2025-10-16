package hua.huase.shanhaicontinent.entity.hunhe;

import hua.huase.shanhaicontinent.capabilitys.PlayerHunHuanAPI;
import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.init.AdvenceInit;
import hua.huase.shanhaicontinent.init.EntityInit;
import hua.huase.shanhaicontinent.item.Nengliang;
import hua.huase.shanhaicontinent.network.SynsAPI;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import static net.minecraft.sounds.SoundEvents.EXPERIENCE_ORB_PICKUP;

public class HunheEntity extends Entity {
    private Player player;
    private int livetime;
    private int contacttime = 20;
    private static final EntityDataAccessor<Float> VALUE =
            SynchedEntityData.defineId(HunheEntity.class, EntityDataSerializers.FLOAT);
    public HunheEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    public static void createHunhe(float value, Level level, BlockPos onPos) {
        HunheEntity hunheEntity = new HunheEntity(EntityInit.HUNHE.get(), level);
        hunheEntity.setPos(onPos.getCenter());
        hunheEntity.setValue(value);
        level.addFreshEntity(hunheEntity);
    }

    public static float conversionValue(int nianxian) {
        double log = Math.log(nianxian);
        return (float) (log *log);
    }

    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.NONE;
    }
    @Override
    public void tick() {
        super.tick();

        this.xo = this.getX();
        this.yo = this.getY();
        this.zo = this.getZ();
        this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.03D, 0.0D));
        this.move(MoverType.SELF, this.getDeltaMovement());

        if(livetime>=1200){
            this.discard();
        }
        livetime++;
    }


    public void playerTouch(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            if (player != this.player){
                this.player = player;
                this.contacttime = 20;
            }else {
                contacttime--;
            }
            if(contacttime<=0){
                serverPlayer.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).ifPresent(c ->{
                        c.addJingyan(serverPlayer,this.getValue());
                        c.setIsupdate(true);
                    }
                );


                AdvenceInit.xishouhunhetrigger.trigger(serverPlayer);

                this.playSound(EXPERIENCE_ORB_PICKUP, 1.1F, (this.random.nextFloat() - this.random.nextFloat()) * 0.35F + 0.9F);

                this.discard();
            }
        }
    }


    @Override
    public boolean isPickable() {
        return true;
    }

    public InteractionResult interact(Player player, InteractionHand hand) {
        if (player.isSecondaryUseActive()) {
            return InteractionResult.PASS;
        } else{
            if (!this.level().isClientSide) {
                ItemStack itemInHand = player.getItemInHand(hand);
                if(itemInHand.getItem() instanceof Nengliang nengliang){
                    nengliang.setNengliang(player,itemInHand, (int) (nengliang.getNengliang(player,itemInHand)+this.getValue()));
                    this.playSound(EXPERIENCE_ORB_PICKUP, 5.1F, (this.random.nextFloat() - this.random.nextFloat()) * 0.35F + 0.9F);

                    this.discard();
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
        this.entityData.define(VALUE, 1f);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        this.entityData.set(VALUE, compoundTag.getFloat("value"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putFloat("value",this.entityData.get(VALUE));
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

    public float getValue() {
        return this.entityData.get(VALUE);
    }

    public void setValue(float value) {
        this.entityData.set(VALUE,value);
    }


    public static boolean checkMonsterSpawnRules(EntityType<? extends Entity> p_219014_, ServerLevelAccessor p_219015_, MobSpawnType p_219016_, BlockPos p_219017_, RandomSource p_219018_) {
        return true;
    }
}
