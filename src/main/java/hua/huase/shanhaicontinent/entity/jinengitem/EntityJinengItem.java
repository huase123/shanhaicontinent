package hua.huase.shanhaicontinent.entity.jinengitem;

import hua.huase.shanhaicontinent.ExampleMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityJinengItem extends Entity {
    public static final String ID = "JinengItem";
    public static final String NAME = ExampleMod.MODID + ".JinengItem";
    private final long exiistTime;
    private  EntityPlayer entityPlayer;
    private  ItemStack itemStack;

    private float f;
    private float f2;
    private int posint;
    public EntityJinengItem(World worldIn) {
        super(worldIn);
        this.exiistTime = worldIn.getWorldTime();
        this.setSize(0.5F, 0.5F);
    }

    private static final DataParameter<ItemStack> ITEM_STACK =
            EntityDataManager.createKey(EntityJinengItem.class, DataSerializers.ITEM_STACK);
    private static final DataParameter<Integer> PLAYER_ID =
            EntityDataManager.createKey(EntityJinengItem.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> PLAYER_POSINT =
            EntityDataManager.createKey(EntityJinengItem.class, DataSerializers.VARINT);
    private static final DataParameter<Float> PLAYER_F =
            EntityDataManager.createKey(EntityJinengItem.class, DataSerializers.FLOAT);
    private static final DataParameter<Float> PLAYER_F2 =
            EntityDataManager.createKey(EntityJinengItem.class, DataSerializers.FLOAT);
    @Override
    protected void entityInit() {

        this.getDataManager().register(ITEM_STACK, ItemStack.EMPTY);
        this.getDataManager().register(PLAYER_ID, 0);
        this.getDataManager().register(PLAYER_POSINT, 0);
        this.getDataManager().register(PLAYER_F, 0f);
        this.getDataManager().register(PLAYER_F2, 0f);
    }

    public ItemStack getItemStack()
    {
        return (ItemStack)this.getDataManager().get(ITEM_STACK);
    }
    public EntityJinengItem setItemStack()
    {
        this.getDataManager().set(ITEM_STACK, itemStack);
        this.getDataManager().set(PLAYER_ID, entityPlayer.getEntityId());
        this.getDataManager().set(PLAYER_POSINT, posint);
        this.getDataManager().set(PLAYER_F, f);
        this.getDataManager().set(PLAYER_F2, f2);
        this.getDataManager().setDirty(ITEM_STACK);
        return this;
    }
    public EntityJinengItem(World worldIn, EntityPlayer entityPlayer,int posint,ItemStack stack) {
        super(worldIn);
        this.entityPlayer = entityPlayer;
        this.itemStack=stack;
        this.exiistTime = worldIn.getWorldTime();
        this.posint=posint;
        this.rotationYaw=entityPlayer.rotationYaw;
        this.rotationPitch=entityPlayer.rotationPitch;
        f = -MathHelper.sin(((posint%3-1)*45+entityPlayer.rotationYaw) * 0.017453292F)*2f;
        f2 = MathHelper.cos(((posint%3-1)*45+entityPlayer.rotationYaw) * 0.017453292F)*2f;
        this.setPosition(entityPlayer.posX+f,entityPlayer.posY+posint/3,entityPlayer.posZ+f2);
        this.setSize(0.5F, 0.5F);
    }

    public boolean processInitialInteract(EntityPlayer player, EnumHand hand)
    {


        ItemStack itemstack = player.getHeldItem(hand);

        if (!this.world.isRemote)
        {
                if (itemstack.isEmpty()&&entityPlayer.getEntityId()==player.getEntityId())
                {
                       player.setHeldItem(hand,this.itemStack);
                        this.setDead();

                }
        }

        return true;

    }


    public boolean canBeCollidedWith()
    {
        return true;
    }





    public boolean isInvisible()
    {
        return false;
    }{
        super.isInvisible();
    }

    public void writeEntityToNBT(NBTTagCompound compound)
    {
        if (!this.getItemStack().isEmpty())
        {
            compound.setTag("Item", this.getItemStack().writeToNBT(new NBTTagCompound()));
        }

        compound.setInteger("PlayerId", this.getDataManager().get(PLAYER_ID));
        compound.setInteger("PLAYERPOSINT", this.getDataManager().get(PLAYER_POSINT));
        compound.setFloat("PLAYERF", this.getDataManager().get(PLAYER_F));
        compound.setFloat("PLAYERF2", this.getDataManager().get(PLAYER_F2));

    }

    public void readEntityFromNBT(NBTTagCompound compound)
    {
        NBTTagCompound nbttagcompound = compound.getCompoundTag("Item");
        if (nbttagcompound != null && !nbttagcompound.hasNoTags())
        {
            ItemStack itemStack1 = new ItemStack(nbttagcompound);

            this.getDataManager().set(ITEM_STACK, itemStack1);
            this.getDataManager().setDirty(ITEM_STACK);
            this.world.updateComparatorOutputLevel(this.getPosition(), Blocks.AIR);
        }

        this.getDataManager().set(PLAYER_ID, compound.getInteger("PlayerId"));
        this.getDataManager().set(PLAYER_POSINT, compound.getInteger("PLAYERPOSINT"));
        this.getDataManager().set(PLAYER_F, compound.getFloat("PLAYERF"));
        this.getDataManager().set(PLAYER_F2, compound.getFloat("PLAYERF2"));


    }




    @SideOnly(Side.CLIENT)
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport)
    {
//        this.setPosition(x, y, z);
//        this.setRotation(yaw, pitch);
    }


    public void onUpdate()
    {

        if (!this.world.isRemote) {
            if (exiistTime + 200 <= this.world.getWorldTime() || entityPlayer == null) {
                this.setDead();
                return;
            }

            if((entityPlayer.posX + f-this.posX)*(entityPlayer.posX + f-this.posX)>1.4f||(entityPlayer.posY + f-this.posY)*(entityPlayer.posY + f-this.posY)>1.4f||(entityPlayer.posZ + f-this.posZ)*(entityPlayer.posZ + f-this.posZ)>1.4f){

                this.setPosition(entityPlayer.posX + f, entityPlayer.posY + posint / 3, entityPlayer.posZ + f2);

            }



        }else {
            Entity entityByID = this.world.getEntityByID(this.getDataManager().get(PLAYER_ID).intValue());
            if (entityByID != null) {
//                this.setPosition(entityByID.posX+this.getDataManager().get(PLAYER_F), entityByID.posY+this.getDataManager().get(PLAYER_POSINT)/3, entityByID.posZ+this.getDataManager().get(PLAYER_F2));
                this.setPosition(entityByID.posX+this.getDataManager().get(PLAYER_F), entityByID.posY+this.getDataManager().get(PLAYER_POSINT)/3, entityByID.posZ+this.getDataManager().get(PLAYER_F2));

            }
        }



        super.onUpdate();

    }

}
