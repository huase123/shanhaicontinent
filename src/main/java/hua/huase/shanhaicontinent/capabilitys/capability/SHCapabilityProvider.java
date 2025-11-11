package hua.huase.shanhaicontinent.capabilitys.capability;

import hua.huase.shanhaicontinent.animation.AnimationControllerInstance;
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
public class SHCapabilityProvider<M extends INBTSerializable> implements ICapabilityProvider, INBTSerializable {


    private M cap;

    private final LazyOptional<M> CapabilityLazyOptional;

    public SHCapabilityProvider(M cap) {
        this.cap = cap;
        CapabilityLazyOptional = LazyOptional.of(() -> cap);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if ((cap == RegisterCapabilitys.HUNHUANCAPABILITY && this.cap instanceof HunhuanCapability)
                || (cap == RegisterCapabilitys.HUNJICAPABILITY  && this.cap instanceof HunjiCapability)
                || (cap == RegisterCapabilitys.WUHUNCAPABILITY  && this.cap instanceof WuhunCapability)
                || (cap == RegisterCapabilitys.MOSTERCAPABILITY && this.cap instanceof MosterCapability)
                || (cap == RegisterCapabilitys.PLAYERCAPABILITY && this.cap instanceof PlayerCapability)
                || (cap == RegisterCapabilitys.ANIMATIONCONTROLLERINSTANCE  && this.cap instanceof AnimationControllerInstance)
        )
            return CapabilityLazyOptional.cast();
        return LazyOptional.empty();
    }

    @Override
    public Tag serializeNBT() {
        return cap.serializeNBT();
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        cap.deserializeNBT((CompoundTag) nbt);
    }
}
