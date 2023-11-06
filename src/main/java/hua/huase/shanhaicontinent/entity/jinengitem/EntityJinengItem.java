package hua.huase.shanhaicontinent.entity.jinengitem;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityJinengItem extends Entity {
    public static final String ID = "JinengItem";
    public static final String NAME = ExampleMod.MODID + ".JinengItem";
    private  long exiistTime;
    private  EntityPlayer entityPlayer;

    private float f;
    private float f2;
    private int posint;
    public EntityJinengItem(World worldIn) {
        super(worldIn);
        this.exiistTime = worldIn.getWorldTime();
        this.setSize(0.5F, 0.5F);
    }

    @Override
    protected void entityInit() {

    }

    public EntityJinengItem(World worldIn, EntityPlayer entityPlayer,int posint) {
        super(worldIn);
        this.entityPlayer = entityPlayer;
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
                if (itemstack.isEmpty())
                {
                       player.setHeldItem(hand,new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":wuqijingubang"))));

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
        return true;
    }
    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {

    }

    public void onUpdate()
    {

        if (!this.world.isRemote) {
            if (exiistTime + 200 <= this.world.getWorldTime() || entityPlayer == null) {
                this.setDead();
            }

            if (entityPlayer != null) {
                this.setPosition(entityPlayer.posX+f,entityPlayer.posY+posint/3,entityPlayer.posZ+f2);

            }
        }
        super.onUpdate();

    }

}
