package hua.huase.shanhaicontinent.capability.baubles;

import hua.huase.shanhaicontinent.capability.BaubleType;
import net.minecraft.item.ItemStack;

public class BaubleItem implements IBauble
{
	private BaubleType baubleType;

	public BaubleItem(BaubleType type) {
		baubleType = type;
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return baubleType;
	}
}
