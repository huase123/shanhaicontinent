package hua.huase.shanhaicontinent.capabilitys.capability;

import hua.huase.shanhaicontinent.functiontypes.FunctionTypeInit;
import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

/**
 * - @description:HunhuanCapability类
 * - @author: huase。
 * - @date: 2025/10/12 3:18
 */
public class HunjiCapability extends AttributeBase{
//    ItemStackHandler hunhuan = new ItemStackHandler();
    FunctionType functionType;
    int nianxian;

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("nianxian",nianxian);
//        nbt.put("hunhuan", hunhuan.serializeNBT());
        ResourceLocation key = FunctionTypeInit.FUNCTION_TYPE_Registry.getKey(functionType);
        nbt.putString("functiontype",key == null ? "air" : key.toString());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        nianxian = nbt.getInt("nianxian");
//        if(nbt.get("hunhuan")!=null){
//            this.hunhuan.deserializeNBT((CompoundTag) nbt.get("hunhuan"));
//        }
        functionType = FunctionTypeInit.FUNCTION_TYPE_Registry.getValue(new ResourceLocation(nbt.getString("functiontype")));
    }

    public void inti(Entity entity, int nianxian, FunctionType functionType, ItemStack hunhuan, ItemStack hunji, HunhuanCapability hunhuanCapability, MosterCapability mosterCapability) {
//        this.hunhuan.setStackInSlot(0,hunhuan);
        this.functionType = functionType;
        this.nianxian = nianxian;
    }
}
