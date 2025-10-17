package hua.huase.shanhaicontinent.capabilitys.capability;

import hua.huase.shanhaicontinent.functiontypes.FunctionTypeInit;
import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * - @description:HunhuanCapability类
 * - @author: huase。
 * - @date: 2025/10/12 3:18
 */
public class HunjiCapability extends AttributeBase{
    List<FunctionType> functionTypelist = new ArrayList();
    int nianxian;

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("nianxian",nianxian);

        nbt.putInt("functionSize",functionTypelist.size());
        for (int i = 0; i < functionTypelist.size(); i++) {
            ResourceLocation key = FunctionTypeInit.FUNCTION_TYPE_Registry.getKey(functionTypelist.get(i));
            nbt.putString("functiontype"+i,key == null ? FunctionTypeInit.FUNCTION_TYPE_Registry.getKey(FunctionTypeInit.empty.get()).toString() : key.toString());
        }
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        nianxian = nbt.getInt("nianxian");

        functionTypelist.clear();
        int functionSize = nbt.getInt("functionSize");
        for (int i = 0; i < functionSize; i++) {
            functionTypelist.add(FunctionTypeInit.FUNCTION_TYPE_Registry.getValue(new ResourceLocation(nbt.getString("functiontype"+i))));

        }
    }

    public void inti(Entity entity, int nianxian, FunctionType functionType, ItemStack hunhuan, ItemStack hunji, HunhuanCapability hunhuanCapability, MosterCapability mosterCapability) {
        this.addFunction(functionType);
        this.nianxian = nianxian;
    }

    private void addFunction(FunctionType functionType) {
        functionTypelist.add(functionType);
    }
}
