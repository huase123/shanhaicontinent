package hua.huase.shanhaicontinent.capabilitys.capability;

import hua.huase.shanhaicontinent.functiontypes.FunctionTypeInit;
import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import hua.huase.shanhaicontinent.init.SHRegistries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * - @description:HunhuanCapability类
 * - @author: huase。
 * - @date: 2025/10/12 3:18
 */
public class HunhuanCapability extends AttributeBase{
    ItemStackHandler hunji = new ItemStackHandler();
    FunctionType functionType;
    int nianxian;

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("nianxian",nianxian);
        nbt.put("hunji", hunji.serializeNBT());
        ResourceLocation key = SHRegistries.FUNCTION_TYPE_Registry.getKey(functionType);
        nbt.putString("functiontype",key == null ? "air" : key.toString());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        nianxian = nbt.getInt("nianxian");
        if(nbt.get("hunji")!=null){
            this.hunji.deserializeNBT((CompoundTag) nbt.get("hunji"));
        }
        functionType = SHRegistries.FUNCTION_TYPE_Registry.getValue(new ResourceLocation(nbt.getString("functiontype")));
    }
}
