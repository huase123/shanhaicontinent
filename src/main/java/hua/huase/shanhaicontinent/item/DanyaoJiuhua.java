package hua.huase.shanhaicontinent.item;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.DanyaoItemCapability;
import hua.huase.shanhaicontinent.capability.DanyaoItemCapabilityProvider;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.capability.api.ChangeCapability;
import hua.huase.shanhaicontinent.handers.HanderAny;
import hua.huase.shanhaicontinent.item.api.ItemListDisplay;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class DanyaoJiuhua extends Item {




    @Nullable
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
        if (nbt != null) {
            stack.setTagCompound(nbt.getCompoundTag("Parent"));
            return new DanyaoItemCapabilityProvider(nbt);
        }
//        return null;
        DanyaoItemCapabilityProvider danyaoItemCapabilityProvider = new DanyaoItemCapabilityProvider(2, 0);

        stack.setTagCompound(danyaoItemCapabilityProvider.serializeNBT());
        return danyaoItemCapabilityProvider;
    }

    public DanyaoJiuhua(String name, CreativeTabs Tabs) {
        super();
        setRegistryName(name);
        setUnlocalizedName(ExampleMod.MODID + "." + name);
        setCreativeTab(Tabs);
        setHasSubtypes(true);
        HanderAny.danyaojiuhua = this;
        setMaxStackSize(64);

        HanderAny.itemList.add(this);
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);

        playerIn.getCooldownTracker().setCooldown(this, 5);
        if (!worldIn.isRemote) {

            DanyaoItemCapability danyaocapability1 = item.getCapability(CapabilityRegistryHandler.DANYAOITEMCAPABILITYCAPABILITY, null);
            danyaocapability1.deserializeNBT(item.getTagCompound());
            PlayerCapability capability = playerIn.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);

            ChangeCapability.addDanyao(capability, danyaocapability1, playerIn);

            if (!playerIn.capabilities.isCreativeMode) {
                item.shrink(1);
            }
            playerIn.sendMessage(new TextComponentTranslation("message.usejiuhua.success" , danyaocapability1.getJingshenli()));
        }
        worldIn.playSound((EntityPlayer) null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
        return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("danyao_list0"));
        NBTTagCompound tagCompound = itemstack.getTagCompound();
        if (tagCompound!=null) {

            DanyaoItemCapability capability = itemstack.getCapability(CapabilityRegistryHandler.DANYAOITEMCAPABILITYCAPABILITY, null);
            capability.deserializeNBT(tagCompound);
            ItemListDisplay.addDanyaoLsit(list, capability);

        }


    }
}