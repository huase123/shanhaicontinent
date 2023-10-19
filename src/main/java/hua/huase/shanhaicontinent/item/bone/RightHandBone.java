package hua.huase.shanhaicontinent.item.bone;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.api.BaublesApi;
import hua.huase.shanhaicontinent.api.IBaublesItemHandler;
import hua.huase.shanhaicontinent.capability.BaubleType;
import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.ItemCapability;
import hua.huase.shanhaicontinent.capability.ItemCapabilityProvider;
import hua.huase.shanhaicontinent.capability.api.ChangeCapability;
import hua.huase.shanhaicontinent.capability.baubles.IBauble;
import hua.huase.shanhaicontinent.handers.HanderAny;
import hua.huase.shanhaicontinent.item.api.ItemListDisplay;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class RightHandBone extends Item implements IBauble
{

	public RightHandBone(String name, CreativeTabs Tabs) {
		super();
		this.setMaxStackSize(1);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setUnlocalizedName(ExampleMod.MODID + name);
		this.setRegistryName(name);
		this.setCreativeTab(Tabs);
		HanderAny.itemList.add(this);
	}

/*

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		if (this.isInCreativeTab(tab)) {
			list.add(new ItemStack(this, 1, 0));
		}
	}
*/

	@Nullable
	public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
		if (nbt != null) {
			stack.setTagCompound(nbt.getCompoundTag("Parent"));
			return new ItemCapabilityProvider(nbt);
		}
		ItemCapabilityProvider itemCapabilityProvider = new ItemCapabilityProvider(500-new Random().nextInt(500));
		stack.setTagCompound(itemCapabilityProvider.serializeNBT());
		return itemCapabilityProvider;
	}


	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RIGHTHAND;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
		for(int i = 0; i < baubles.getSlots(); i++)
			if((baubles.getStackInSlot(i) == null || baubles.getStackInSlot(i).isEmpty()) && baubles.isItemValidForSlot(i, player.getHeldItem(hand), player)) {
				baubles.setStackInSlot(i, player.getHeldItem(hand).copy());
				onEquipped(player.getHeldItem(hand), player);
				if(!player.capabilities.isCreativeMode){
					player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
				}
				break;
			}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (itemstack.getItemDamage()==0 && player.ticksExisted%99==0) {
			ItemStack stackInSlot = BaublesApi.getBaublesHandler((EntityPlayer) player).getStackInSlot(2);
			if(stackInSlot.getItem()instanceof LeftHandBone){
				player.addPotionEffect(new PotionEffect(MobEffects.HASTE,100,2,true,true));
			}else {
				player.addPotionEffect(new PotionEffect(MobEffects.HASTE,100,1,true,true));
			}

		}
	}
	@Override
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}
	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.75F, 1.9f);
		if (!player.world.isRemote) {
			ChangeCapability.addItem(player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY,null),itemstack.getCapability(CapabilityRegistryHandler.ITEM_CAPABILITY,null), (EntityPlayer) player);
		}
	}
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		player.playSound(SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.75F, 2f);
		if (!player.world.isRemote) {
			ChangeCapability.removeItem(player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY,null),itemstack.getCapability(CapabilityRegistryHandler.ITEM_CAPABILITY,null), (EntityPlayer) player);
		}


	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
		super.addInformation(itemstack, world, list, flag);
		NBTTagCompound tagCompound = itemstack.getTagCompound();
		if (tagCompound!=null) {

			ItemCapability capability = itemstack.getCapability(CapabilityRegistryHandler.ITEM_CAPABILITY, null);
			capability.deserializeNBT(tagCompound);
			ItemListDisplay.addBoneLsit(list, capability);

		}

	}

}
