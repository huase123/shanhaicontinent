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

public class Danyao extends Item {


    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab)) {
            list.add(new ItemStack(this, 1, 0));
            list.add(new ItemStack(this, 1, 1));
            list.add(new ItemStack(this, 1, 2));
            list.add(new ItemStack(this, 1, 3));
            list.add(new ItemStack(this, 1, 4));
            list.add(new ItemStack(this, 1, 5));
            list.add(new ItemStack(this, 1, 6));
            list.add(new ItemStack(this, 1, 7));
            list.add(new ItemStack(this, 1, 8));
        }
    }


    public int getMetadata(int damage) {
        return damage;
    }

    public String getUnlocalizedName(ItemStack stack) {
        return super.getUnlocalizedName() + "_age" + stack.getMetadata();
    }

    @Nullable
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
        if (nbt != null) {
            stack.setTagCompound(nbt.getCompoundTag("Parent"));
            return new DanyaoItemCapabilityProvider(nbt);
        }
//        return null;
        DanyaoItemCapabilityProvider danyaoItemCapabilityProvider = new DanyaoItemCapabilityProvider(0, stack.getMetadata());

        stack.setTagCompound(danyaoItemCapabilityProvider.serializeNBT());
        return danyaoItemCapabilityProvider;
    }

    public Danyao(String name, CreativeTabs Tabs) {
        super();
        setRegistryName(name);
        setUnlocalizedName(ExampleMod.MODID + "." + name);
        setCreativeTab(Tabs);
        setHasSubtypes(true);
        HanderAny.danyao = this;
        setMaxStackSize(64);
    }


    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack item = playerIn.getHeldItem(handIn);

        if (!worldIn.isRemote) {

            DanyaoItemCapability danyaocapability1 = item.getCapability(CapabilityRegistryHandler.DANYAOITEMCAPABILITYCAPABILITY, null);
            danyaocapability1.deserializeNBT(item.getTagCompound());
            PlayerCapability capability = playerIn.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
            if(capability.getJingyan()>=capability.getMaxjingyan()){
                playerIn.sendMessage(new TextComponentTranslation("message.use.fail"));

                return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
            }
            ChangeCapability.addDanyao(capability, danyaocapability1, playerIn);

            if (!playerIn.capabilities.isCreativeMode) {
                item.shrink(1);
            }
            playerIn.sendMessage(new TextComponentTranslation("message.use.success" , danyaocapability1.getJingyan()));
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
        NBTTagCompound tagCompound = itemstack.getTagCompound();
        if (tagCompound!=null) {

            DanyaoItemCapability capability = itemstack.getCapability(CapabilityRegistryHandler.DANYAOITEMCAPABILITYCAPABILITY, null);
            capability.deserializeNBT(tagCompound);
            ItemListDisplay.addDanyaoLsit(list, capability);

        }


    }
}