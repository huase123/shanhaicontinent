package hua.huase.shanhaicontinent.capabilitys.capability;

import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.functiontypes.FunctionTypeInit;
import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import hua.huase.shanhaicontinent.init.ItemInit;
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
public class HunhuanCapability extends AttributeBase{
    ItemStackHandler hunji = new ItemStackHandler();
    FunctionType functionType;
    int nianxian;

    public ItemStackHandler getHunji() {
        return hunji;
    }

    public void setHunji(ItemStackHandler hunji) {
        this.hunji = hunji;
    }

    public FunctionType getFunctionType() {
        return functionType;
    }

    public void setFunctionType(FunctionType functionType) {
        this.functionType = functionType;
    }

    public int getNianxian() {
        return nianxian;
    }

    public void setNianxian(int nianxian) {
        this.nianxian = nianxian;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.putInt("nianxian",nianxian);
        nbt.put("hunji", hunji.serializeNBT());
        ResourceLocation key = FunctionTypeInit.FUNCTION_TYPE_Registry.getKey(functionType);
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
        functionType = FunctionTypeInit.FUNCTION_TYPE_Registry.getValue(new ResourceLocation(nbt.getString("functiontype")));
    }


    public void inti(Entity entity, int nianxian, FunctionType functionType, ItemStack hunhuan, MosterCapability mosterCapability) {

        this.functionType = functionType;
        this.nianxian = nianxian;
        this.hunhuanAddhunji(entity,nianxian,functionType,hunhuan,mosterCapability);
    }
    public void hunhuanAddhunji(Entity entity, int nianxian, FunctionType functionType, ItemStack hunhuan, MosterCapability mosterCapability) {
        ItemStack hunji = new ItemStack(ItemInit.hunji0.get());
        hunji.getCapability(RegisterCapabilitys.HUNJICAPABILITY).ifPresent(c ->{
            c.inti(entity,nianxian,functionType,hunhuan,hunji,this,mosterCapability);
        });
        this.hunji.setStackInSlot(0,hunji);
    }
}
