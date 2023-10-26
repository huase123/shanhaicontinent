package hua.huase.shanhaicontinent.entity.jineng;

import hua.huase.shanhaicontinent.ExampleMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class EntityJiNengThread extends Entity {
    public static final String ID = "Thread";
    public static final String NAME = ExampleMod.MODID + ".Thread";


    public EntityJiNengThread(World worldIn) {
        super(worldIn);
        this.setSize(1.2F, 2.2F);
    }


    @Override
    protected void entityInit() {

    }


    public void onCollideWithPlayer(EntityPlayer entityIn)
    {

    }

    public void applyEntityCollision(Entity entityIn)
    {

        entityIn.attackEntityFrom(DamageSource.FIREWORKS,20);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {

    }

    public void onUpdate()
    {
        if(motionX>0.2||motionZ>0.2){

            this.posX += this.motionX;
            this.posZ += this.motionZ;
            this.motionX*=0.9;
            this.motionZ*=0.9;

        }else {
            this.setDead();
        }
        if (!this.world.isRemote)
        {
            AxisAlignedBB entityBoundingBox = this.getEntityBoundingBox();
            List<Entity> list = this.world.<Entity>getEntitiesWithinAABBExcludingEntity(this, entityBoundingBox.grow(4.0D, 2.0D, 4.0D));
            for (Entity entityLiving : list) {
                if(entityLiving!=null&&entityLiving instanceof EntityLiving)
                entityLiving.attackEntityFrom(DamageSource.DROWN,20);
            }


        }


    }

}
