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

import java.util.ArrayList;
import java.util.List;

/**
 * - @description:HunhuanCapability类
 * - @author: huase。
 * - @date: 2025/10/12 3:18
 */
public class HunhuanCapability extends AttributeBase{
    ItemStackHandler hunji = new ItemStackHandler();
    List<FunctionType> functionTypelist = new ArrayList();
    int nianxian;

    public ItemStackHandler getHunji() {
        return hunji;
    }

    public void setHunji(ItemStackHandler hunji) {
        this.hunji = hunji;
    }

    public List<FunctionType> getFunctionTypelist() {
        return functionTypelist;
    }

    public void setFunctionTypelist(List<FunctionType> functionTypelist) {
        this.functionTypelist = functionTypelist;
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
        if(nbt.get("hunji")!=null){
            this.hunji.deserializeNBT((CompoundTag) nbt.get("hunji"));
        }

        functionTypelist.clear();
        int functionSize = nbt.getInt("functionSize");
        for (int i = 0; i < functionSize; i++) {
            functionTypelist.add(FunctionTypeInit.FUNCTION_TYPE_Registry.getValue(new ResourceLocation(nbt.getString("functiontype"+i))));

        }
    }


    public void inti(Entity entity, int nianxian, FunctionType functionType, ItemStack hunhuan, MosterCapability mosterCapability) {

        this.addFunction(functionType);
        this.nianxian = nianxian;
        this.hunhuanAddhunji(entity,nianxian,functionType,hunhuan,mosterCapability);
    }

    private void addFunction(FunctionType functionType) {
        functionTypelist.add(functionType);
    }

    public void hunhuanAddhunji(Entity entity, int nianxian, FunctionType functionType, ItemStack hunhuan, MosterCapability mosterCapability) {
        ItemStack hunji = new ItemStack(ItemInit.hunji0.get());
        hunji.getCapability(RegisterCapabilitys.HUNJICAPABILITY).ifPresent(c ->{
            c.inti(entity,nianxian,functionType,hunhuan,hunji,this,mosterCapability);
        });
        this.hunji.setStackInSlot(0,hunji);
    }
}
