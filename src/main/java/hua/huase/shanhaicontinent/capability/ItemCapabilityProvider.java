package hua.huase.shanhaicontinent.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import java.util.Random;

public class ItemCapabilityProvider implements ICapabilitySerializable<NBTTagCompound>
{
    private final ItemCapability instance;
    private final Capability<ItemCapability> capability;

    public ItemCapabilityProvider()
    {
        int i = new Random().nextInt(6);
        float v = new Random().nextFloat();

        this.instance = new ItemCapability((int) (i==0? v*100:
                        i==1? v*1000:
                        i==2? v*10000:
                        i==3? v*100000:
                        i==4? v*1000000: 1000000)
                ,1);
        this.capability = CapabilityRegistryHandler.ITEM_CAPABILITY;

    }
    public ItemCapabilityProvider(int nianxian)
    {

        this.instance = new ItemCapability(nianxian,1);
        this.capability = CapabilityRegistryHandler.ITEM_CAPABILITY;

    }

    public ItemCapabilityProvider(NBTTagCompound nbt)
    {
        this.instance=new ItemCapability();
        this.instance.deserializeNBT(nbt);

        this.capability = CapabilityRegistryHandler.ITEM_CAPABILITY;
    }


    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        return this.capability.equals(capability);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        return this.capability.equals(capability) ? this.capability.cast(this.instance) : null;
//        return this.capability.equals(capability) ? this.capability.cast(new ItemCapability()) : null;
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        return this.instance.serializeNBT();
    }


    public NBTTagCompound serializeItemNBT()
    {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setTag("Parent",this.instance.serializeNBT());
        return compound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        this.instance.deserializeNBT(nbt);
    }
}
