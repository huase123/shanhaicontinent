package hua.huase.shanhaicontinent.entity;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.loot.LootTableList;

import java.util.UUID;

public class EntityDirtBallKing extends EntityMob
{
    public static final String ID = "dirt_ball_king";
    public static final String NAME = ExampleMod.MODID + ".DirtBallKing";

//    生成的群系，PLAINS平原  SAVANNA 热带草原    SAVANNA_PLATEAU 热带高原  MUTATED_PLAINS向日葵平原
    public static final Biome[] BIOMES = new Biome[] {Biomes.PLAINS, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.MUTATED_PLAINS};



//    掉落物战利品表
    private static final ResourceLocation LOOT_TABLE = LootTableList.register(
            new ResourceLocation(ExampleMod.MODID + ":entities/dirt_ball_king"));

    public EntityDirtBallKing(World worldIn)
    {
        super(worldIn);
        this.setSize(1.2F, 1.95F);
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LOOT_TABLE;
    }

    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));//游泳
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0, false));//攻击
        this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 0.8));//闲逛
        this.tasks.addTask(3, new AIChangeGrassToDirt(this));//脚下方块替换为草方块
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));//看向玩家
        this.tasks.addTask(5, new EntityAILookIdle(this));//发呆

        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));//被攻击时锁定目标
    }

//用于servce与client相互同步参数
    private static final DataParameter<Byte> COLOR =
            EntityDataManager.createKey(EntityDirtBallKing.class, DataSerializers.BYTE);
    private static final DataParameter<NBTTagCompound> LIVINGENTITYCAPABILITY =
            EntityDataManager.createKey(EntityDirtBallKing.class, DataSerializers.COMPOUND_TAG);

    //该对象初始化时被调用
    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(COLOR, (byte) 0);
        this.getDataManager().register(LIVINGENTITYCAPABILITY,new PlayerCapability().serializeNBT());
    }

    public byte getColor()
    {
        return this.getDataManager().get(COLOR);
    }
    public NBTTagCompound getLivingEntityCapability()
    {
        return this.getDataManager().get(LIVINGENTITYCAPABILITY);
    }

//    序列化
    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setByte("Color", this.getDataManager().get(COLOR));
        compound.setTag("LivingEntityCapability", this.getDataManager().get(LIVINGENTITYCAPABILITY));
    }

    //    反序列化
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.getDataManager().set(COLOR, compound.getByte("Color"));
        this.getDataManager().set(LIVINGENTITYCAPABILITY, compound.getCompoundTag("LivingEntityCapability"));
    }


    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200);//血量
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0);//攻击力
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);//速度
//        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(1.6);
    }


    private static final UUID MAX_HEALTHID = UUID.fromString("1707f7535-349a-4613-b33f-4a5eaf4d0ed7");
    private static final UUID ATTACK_DAMAGEID = UUID.fromString("2707f7535-349a-4613-b33f-4a5eaf4d0ed7");
    private static final UUID MOVEMENT_SPEEDID = UUID.fromString("3707f7535-349a-4613-b33f-4a5eaf4d0ed7");
//    private static final UUID ATTACK_SPEEDID = UUID.fromString("4707f7535-349a-4613-b33f-4a5eaf4d0ed7");
//    生成时被调用
    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData data)
    {


//        IAttributeInstance attributehealth = this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
//        attributehealth.applyModifier(new AttributeModifier(MAX_HEALTHID,"shanhaicontinent.health",this.rand.nextInt(200), 0));

        IAttributeInstance attributehealth = this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH);
        attributehealth.applyModifier(new AttributeModifier(MAX_HEALTHID,"shanhaicontinent.health",3200, 0));
        this.setHealth(3000);

        IAttributeInstance attributeattack = this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        attributeattack.applyModifier(new AttributeModifier(ATTACK_DAMAGEID,"shanhaicontinent.attack",this.rand.nextInt(20), 0));
//
//        IAttributeInstance attributeattackspeed = this.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED);
//        attributeattackspeed.applyModifier(new AttributeModifier(ATTACK_SPEEDID,"shanhaicontinent.attackspeed",-10, 0));

        this.getDataManager().set(COLOR, (byte) this.rand.nextInt(3));
        return super.onInitialSpawn(difficulty, data);

    }

//    获取到攻击目标时被调用
    @Override
    public void setAttackTarget(EntityLivingBase entity)
    {
        super.setAttackTarget(entity);
        IAttributeInstance attributemovespeed = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);//生物的移动速度
        if (entity == null)
        {
            attributemovespeed.removeModifier(MOVEMENT_SPEEDID);
        }
        else if (attributemovespeed.getModifier(MOVEMENT_SPEEDID) == null)
        {
            attributemovespeed.applyModifier(new AttributeModifier(MOVEMENT_SPEEDID, "shanhaicontinent.movespeed", 1, 2).setSaved(false));
        }
    }

//    private static final UUID SPEED_BOOST = UUID.fromString("707f7535-349a-4613-b33f-4a5eaf4d0ed7");

//    替换方块ai
    private static class AIChangeGrassToDirt extends EntityAIBase
    {
        private final EntityDirtBallKing entity;

        private AIChangeGrassToDirt(EntityDirtBallKing entity)
        {
            this.entity = entity;
        }

        @Override
        public void updateTask()
        {
            BlockPos blockPos = new BlockPos(this.entity.posX, this.entity.posY - 0.2, this.entity.posZ);
            this.entity.world.setBlockState(blockPos, Blocks.DIRT.getDefaultState());
        }

        @Override
        public boolean shouldExecute()
        {
            BlockPos blockPos = new BlockPos(this.entity.posX, this.entity.posY - 0.2, this.entity.posZ);
            return this.entity.world.getBlockState(blockPos).getBlock() == Blocks.GRASS;
        }
    }
}
