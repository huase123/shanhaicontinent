package hua.huase.shanhaicontinent.capabilitys.capability;

import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * - @description:ItemICapabilityProvider类itemstack的capability同步需要capabilityProvider实现INBTSerializable接口，所以封装了这个类
 * - @author: huase。
 * - @date: 2025/10/15 9:09
 */
public class SHCapabilityProvider implements ICapabilityProvider, INBTSerializable {


    private AttributeBase attributeBase = null;

    private final LazyOptional<AttributeBase> CapabilityLazyOptional;

    public SHCapabilityProvider(AttributeBase attributeBase) {
        this.attributeBase =attributeBase;
        CapabilityLazyOptional = LazyOptional.of(() -> attributeBase);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == RegisterCapabilitys.HUNHUANCAPABILITY
                || cap == RegisterCapabilitys.HUNJICAPABILITY
                || cap == RegisterCapabilitys.WUHUNCAPABILITY
                || cap == RegisterCapabilitys.MOSTERCAPABILITY
                || cap == RegisterCapabilitys.PLAYERCAPABILITY
        )
            return CapabilityLazyOptional.cast();
        return LazyOptional.empty();
    }

    @Override
    public Tag serializeNBT() {
        return attributeBase.serializeNBT();
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        attributeBase.deserializeNBT((CompoundTag) nbt);
    }
}
