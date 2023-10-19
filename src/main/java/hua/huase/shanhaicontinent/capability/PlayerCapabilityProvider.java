package hua.huase.shanhaicontinent.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

class PlayerCapabilityProvider implements ICapabilitySerializable<NBTTagCompound>
{
    private final PlayerCapability instance;
    private final Capability<PlayerCapability> capability;

    public PlayerCapabilityProvider()
    {
        this.instance = new PlayerCapability();
        this.capability = CapabilityRegistryHandler.PLYAER_CAPABILITY;

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
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        return this.instance.serializeNBT();
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        this.instance.deserializeNBT(nbt);
    }
}
