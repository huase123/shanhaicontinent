package hua.huase.shanhaicontinent.capabilitys.capability;

import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.entity.hunhuan.HunhuanEntityEntity;
import hua.huase.shanhaicontinent.functiontypes.FunctionTypeInit;
import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
    ItemStackHandler hunhuanlist = new ItemStackHandler();

    public FunctionType getFunctionType() {
        return functionType;
    }

    public void setFunctionType(FunctionType functionType) {
        this.functionType = functionType;
    }

    public ItemStackHandler getHunhuanlist() {
        return hunhuanlist;
    }

    public void setHunhuanlist(ItemStackHandler hunhuanlist) {
        this.hunhuanlist = hunhuanlist;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.put("hunhuanlist", hunhuanlist.serializeNBT());
        ResourceLocation key = FunctionTypeInit.FUNCTION_TYPE_Registry.getKey(functionType);
        nbt.putString("functiontype",key == null ? "air" : key.toString());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        if(nbt == null)return;
        super.deserializeNBT(nbt);
        if(nbt.get("hunhuanlist")!=null){
            this.hunhuanlist.deserializeNBT((CompoundTag) nbt.get("hunhuanlist"));
        }
        functionType = FunctionTypeInit.FUNCTION_TYPE_Registry.getValue(new ResourceLocation(nbt.getString("functiontype")));
    }

    public void init(ItemStack itemStack) {

    }

    public void xishouHunhuan(Player player, HunhuanEntityEntity hunhuanEntity, int existenceTime, PlayerCapability playerCapability) {
        hunhuanEntity.getCapability(RegisterCapabilitys.MOSTERCAPABILITY).ifPresent(c->{
            ItemStackHandler hunhuan = c.getHunhuan();
            ItemStack stackInSlot = hunhuan.getStackInSlot(0);
            hunhuanlist.setStackInSlot(0,stackInSlot);
        });

    }
}
