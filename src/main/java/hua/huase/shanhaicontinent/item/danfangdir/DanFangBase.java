package hua.huase.shanhaicontinent.item.danfangdir;

import hua.huase.shanhaicontinent.tileentity.TileEntityPot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public interface DanFangBase {
    int update(TileEntityPot tileEntityPot, ItemStack itemStack, ItemStackHandler solt0, ItemStackHandler solt1, ItemStackHandler slot7, int compressorProgress);

    boolean canUpdate();
}
