package hua.huase.shanhaicontinent.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class DanyaoItemCapabilityProvider implements ICapabilitySerializable<NBTTagCompound>
{
    private final DanyaoItemCapability instance;
    private final Capability<DanyaoItemCapability> capability;

    public DanyaoItemCapabilityProvider()
    {

        this.instance = new DanyaoItemCapability(false);
        this.capability = CapabilityRegistryHandler.DANYAOITEMCAPABILITYCAPABILITY;

    }
    public DanyaoItemCapabilityProvider(int danfang,int age)
    {

        this.instance = new DanyaoItemCapability(danfang,age);
        this.capability = CapabilityRegistryHandler.DANYAOITEMCAPABILITYCAPABILITY;

    }

    public DanyaoItemCapabilityProvider(NBTTagCompound nbt)
    {
        this.instance=new DanyaoItemCapability();
        this.instance.deserializeNBT(nbt);

        this.capability = CapabilityRegistryHandler.DANYAOITEMCAPABILITYCAPABILITY;
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
