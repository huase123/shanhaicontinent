package hua.huase.shanhaicontinent.capabilitys.capability;

import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.entity.hunhuan.HunhuanEntity;
import hua.huase.shanhaicontinent.functiontypes.FunctionTypeInit;
import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import hua.huase.shanhaicontinent.init.SHRegistries;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
    ItemStackHandler hunjilist = new ItemStackHandler();

    public FunctionType getFunctionType() {
        return functionType;
    }

    public void setFunctionType(FunctionType functionType) {
        this.functionType = functionType;
    }

    public ItemStackHandler getHunjilist() {
        return hunjilist;
    }

    public void setHunjilist(ItemStackHandler hunjilist) {
        this.hunjilist = hunjilist;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.put("hunjilist", hunjilist.serializeNBT());
        ResourceLocation key = FunctionTypeInit.FUNCTION_TYPE_Registry.getKey(functionType);
        nbt.putString("functiontype",key == null ? "air" : key.toString());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        if(nbt.get("hunjilist")!=null){
            this.hunjilist.deserializeNBT((CompoundTag) nbt.get("hunjilist"));
        }
        functionType = FunctionTypeInit.FUNCTION_TYPE_Registry.getValue(new ResourceLocation(nbt.getString("functiontype")));
    }

    public void init(ItemStack itemStack) {

    }

    public void xishouHunhuan(Player player, HunhuanEntity hunhuanEntity, int existenceTime, PlayerCapability playerCapability) {
        hunhuanEntity.getCapability(RegisterCapabilitys.MOSTERCAPABILITY).ifPresent(c->{
            ItemStackHandler hunhuan = c.getHunhuan();
            ItemStack stackInSlot = hunhuan.getStackInSlot(0);
            stackInSlot.getCapability(RegisterCapabilitys.HUNHUANCAPABILITY).ifPresent(hc->{
                ItemStack stackInSlot1 = hc.hunji.getStackInSlot(0);
                hunjilist.setStackInSlot(0,stackInSlot1);
                player.sendSystemMessage(Component.translatable("成功吸收魂环").withStyle(ChatFormatting.YELLOW));
            });
        });

    }
}
