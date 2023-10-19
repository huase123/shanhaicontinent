package hua.huase.shanhaicontinent.network;


import hua.huase.shanhaicontinent.capability.baubles.BaublesCapabilities;
import hua.huase.shanhaicontinent.api.IBaublesItemHandler;
import hua.huase.shanhaicontinent.api.SlotBauble;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerPlayerExpanded extends Container
{

	/**
	 * The crafting matrix inventory.
	 */
	public IBaublesItemHandler baubles;
	/**
	 * Determines if inventory manipulation should be handled.
	 */
	public boolean isLocalWorld;
	private final EntityPlayer thePlayer;
	public ContainerPlayerExpanded(InventoryPlayer inventoryPlayer, boolean par2, EntityPlayer player)
	{
		this.isLocalWorld = par2;
		this.thePlayer = player;
		baubles = player.getCapability(BaublesCapabilities.CAPABILITY_BAUBLES, null);
//		baubles = new BaublesContainer();


		this.addSlotToContainer(new SlotBauble(player,baubles,0,232-48,-27+45 ));
		this.addSlotToContainer(new SlotBauble(player,baubles,1,266-48,-27+57 ));
		this.addSlotToContainer(new SlotBauble(player,baubles,2,177-48,-27+78 ));
		this.addSlotToContainer(new SlotBauble(player,baubles,3,286-48,-27+78 ));
		this.addSlotToContainer(new SlotBauble(player,baubles,4,190-48,-27+102 ));
		this.addSlotToContainer(new SlotBauble(player,baubles,5,177-48,-27+127 ));
		this.addSlotToContainer(new SlotBauble(player,baubles,6,286-48,-27+127 ));

//270 480
		for (int i = 0; i <=8; i++) {

			this.addSlotToContainer(new Slot(inventoryPlayer, i + 0, 112 + 18 * i,  152+37));
			this.addSlotToContainer(new Slot(inventoryPlayer, i + 9, 112 + 18 * i,   94+37));
			this.addSlotToContainer(new Slot(inventoryPlayer, i + 18, 112 + 18 * i, 112+37));
			this.addSlotToContainer(new Slot(inventoryPlayer, i + 27, 112 + 18 * i, 130+37));
		}



	}



	//打开检测
	@Override
	public boolean canInteractWith(EntityPlayer playerIn)
	{
		return true;
	}

/*

//	    分配物品快捷键
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		return ItemStack.EMPTY;
	}
*/
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{

		return ItemStack.EMPTY;
	}


	//private void unequipBauble(ItemStack stack) { }
//	@Override
//	public boolean canMergeSlot(ItemStack stack, Slot slot)
//	{
//		return slot.inventory != this.craftResult && super.canMergeSlot(stack, slot);
//	}
}
