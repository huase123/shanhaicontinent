package hua.huase.shanhaicontinent.entity.jinengitem;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.entity.EntityDirtBallKing;
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
            EntityDataManager.createKey(EntityDirtBallKing.class, DataSerializers.ITEM_STACK);
    @Override
    protected void entityInit() {

        this.getDataManager().register(ITEM_STACK, ItemStack.EMPTY);
    }

    public ItemStack getItemStack()
    {
        return (ItemStack)this.getDataManager().get(ITEM_STACK);
    }
    public EntityJinengItem setItemStack()
    {
        this.getDataManager().set(ITEM_STACK, itemStack);
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

    }




    public void onUpdate()
    {

        if (!this.world.isRemote) {
            if (exiistTime + 200 <= this.world.getWorldTime() || entityPlayer == null) {
                this.setDead();
            }

            if (entityPlayer != null) {
                this.setPosition(entityPlayer.posX+f,entityPlayer.posY+posint/3,entityPlayer.posZ+f2);

            }else {
                this.setDead();
            }
        }
        super.onUpdate();

    }

}
