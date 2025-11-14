package hua.huase.shanhaicontinent.capabilitys.capability;

import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.entity.hunhuan.HunhuanEntityEntity;
import hua.huase.shanhaicontinent.functiontypes.FunctionTypeInit;
import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import hua.huase.shanhaicontinent.init.SHRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * - @description:HunhuanCapability类
 * - @author: huase。
 * - @date: 2025/10/12 3:18
 */
public class WuhunCapability extends AttributeBase{
    List<FunctionType> functionTypelist = new ArrayList();
//    魂环
    ItemStackHandler hunhuanlist = new ItemStackHandler();

    public List<FunctionType> getFunctionTypelist() {
        return functionTypelist;
    }

    public void setFunctionTypelist(List<FunctionType> functionTypelist) {
        this.functionTypelist = functionTypelist;
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
        nbt.putInt("functionSize",functionTypelist.size());
        for (int i = 0; i < functionTypelist.size(); i++) {
            ResourceLocation key = SHRegistries.FUNCTION_TYPE_IForgeRegistry.getKey(functionTypelist.get(i));
            nbt.putString("functiontype"+i,key == null ? SHRegistries.FUNCTION_TYPE_IForgeRegistry.getKey(FunctionTypeInit.empty.get()).toString() : key.toString());
        }
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        if(nbt == null)return;
        super.deserializeNBT(nbt);
        if(nbt.get("hunhuanlist")!=null){
            this.hunhuanlist.deserializeNBT((CompoundTag) nbt.get("hunhuanlist"));
        }


        functionTypelist.clear();
        int functionSize = nbt.getInt("functionSize");
        for (int i = 0; i < functionSize; i++) {
            functionTypelist.add(SHRegistries.FUNCTION_TYPE_IForgeRegistry.getValue(new ResourceLocation(nbt.getString("functiontype"+i))));
        }
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
