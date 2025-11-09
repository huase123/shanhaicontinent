package hua.huase.shanhaicontinent.item.wuhun;

import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import hua.huase.shanhaicontinent.item.Wuhun;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static hua.huase.shanhaicontinent.item.ItemInit.wuhunlist;

/**
 * - @description:WuhunItem类
 * - @author: huase。
 * - @date: 2025/10/12 9:02
 */
public class WuhunItem extends Item implements Wuhun {
    ArrayList<RegistryObject<FunctionType>> registryFunctionTypeList = new ArrayList<>();
    ArrayList<RegistryObject<Item>> jinengList = new ArrayList<>();

    public WuhunItem() {
        super(new Item.Properties().stacksTo(1));
        wuhunlist.add(this);
    }

    public List<Item> getJinengList() {
        return jinengList.stream().map(RegistryObject::get).toList();
    }

    public WuhunItem addJinengList(RegistryObject<Item> jinenng) {
        this.jinengList.add(jinenng);
        return this;
    }

    public List<FunctionType> getRegistryFunctionTypeList() {
        return registryFunctionTypeList.stream().map(RegistryObject::get).toList();
    }

    public WuhunItem setRegistryFunctionTypeList(RegistryObject<FunctionType> registryFunctionTypeList) {
        this.registryFunctionTypeList.add(registryFunctionTypeList);
        return this;
    }

    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);
        list.add(Component.translatable("能在地面上产生威力无比的震动，对前方造成伤害").withStyle(ChatFormatting.GREEN));

        list.add(Component.translatable("蹲下释放可破环地形").withStyle(ChatFormatting.GRAY));
    }
}
