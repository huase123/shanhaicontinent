package hua.huase.shanhaicontinent.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import java.util.Random;

public class MonsterCapabilityProvider implements ICapabilitySerializable<NBTTagCompound>
{
    private final MonsterCapability instance;
    private final Capability<MonsterCapability> capability;

    public MonsterCapabilityProvider(int provider,Random random)
    {

        int i =0 ;
        switch (provider) {
            case -1:
//                i=random.nextInt(110);
                i=random.nextInt(110);
                break;
            case 0:
                i=random.nextInt(100);
                break;
            case 1:
                i=random.nextInt(120);
//                i=random.nextInt(120);
                break;
            default:
                i=random.nextInt(130)+2;
                break;
        }
        int v;
        if(i>=118){
            v=1000000-1;
        } else if (i>=110) {
            v=random.nextInt(1000000);
        } else if (i>=100) {
            v=random.nextInt(100000);
        } else if (i>=80) {
            v=random.nextInt(10000);
        } else if (i>=50) {
            v=random.nextInt(1000);
        } else if (i>=20) {
            v=random.nextInt(100);
        } else {
            v=random.nextInt(10);
        }


//        int i = new Random().nextInt(6);
//        float v = new Random().nextFloat();

        this.instance = new MonsterCapability(v+1,0);
        this.capability = CapabilityRegistryHandler.MONSTER_CAPABILITY;

    }
    public MonsterCapabilityProvider(Boolean b)
    {

        this.instance = new MonsterCapability();
        this.capability = CapabilityRegistryHandler.MONSTER_CAPABILITY;

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
