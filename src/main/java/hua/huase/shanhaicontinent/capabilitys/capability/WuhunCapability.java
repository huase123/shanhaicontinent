package hua.huase.shanhaicontinent.capabilitys.capability;

import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import hua.huase.shanhaicontinent.init.SHRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.items.ItemStackHandler;

/**
 * - @description:HunhuanCapability类
 * - @author: huase。
 * - @date: 2025/10/12 3:18
 */
public class WuhunCapability extends AttributeBase{
//    类型
    FunctionType functionType;

//    魂技
    ItemStackHandler hunjilist = new ItemStackHandler();

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.put("hunjilist", hunjilist.serializeNBT());
        ResourceLocation key = SHRegistries.FUNCTION_TYPE_Registry.getKey(functionType);
        nbt.putString("functiontype",key == null ? "air" : key.toString());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        if(nbt.get("hunjilist")!=null){
            this.hunjilist.deserializeNBT((CompoundTag) nbt.get("hunjilist"));
        }
        functionType = SHRegistries.FUNCTION_TYPE_Registry.getValue(new ResourceLocation(nbt.getString("functiontype")));
    }

}
