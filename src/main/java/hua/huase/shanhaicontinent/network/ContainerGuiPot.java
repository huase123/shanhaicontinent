package hua.huase.shanhaicontinent.network;

import hua.huase.shanhaicontinent.item.danfangdir.DanFangBase;
import hua.huase.shanhaicontinent.tileentity.TileEntityPot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerGuiPot extends Container
{
    private final World world;
    private final BlockPos pos;

    private final IItemHandler SOLT0;
    private final IItemHandler SOLT1;
    private final IItemHandler SOLT7;

    private int compressorProgress = 0;

    public int getCompressorProgress()
    {
        return this.compressorProgress;
    }
    public int getItemStace()
    {
        if(SOLT0.extractItem(0, 1, true).getItem() instanceof DanFangBase){
        return SOLT0.extractItem(0, 1, true).getItemDamage();
        }
        return -1;
    }
    public ContainerGuiPot(EntityPlayer player, World world, int x, int y, int z)
    {
        this.world = world;
        this.pos = new BlockPos(x, y, z);

        TileEntity tileEntity = world.getTileEntity(this.pos);
        Capability<IItemHandler> itemHandlerCapability = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;

        this.SOLT0 = tileEntity.getCapability(itemHandlerCapability, EnumFacing.UP);
        this.SOLT1 = tileEntity.getCapability(itemHandlerCapability, EnumFacing.NORTH);
        this.SOLT7 = tileEntity.getCapability(itemHandlerCapability, EnumFacing.DOWN);


        this.addSlotToContainer(new SlotItemHandler(this.SOLT0, 0, 41, 27));
        this.addSlotToContainer(new SlotItemHandler(this.SOLT1, 0, 41, 91));
        this.addSlotToContainer(new SlotItemHandler(this.SOLT1, 1, 97, 60));
        this.addSlotToContainer(new SlotItemHandler(this.SOLT1, 2, 116, 100));
        this.addSlotToContainer(new SlotItemHandler(this.SOLT1, 3, 146, 17));
        this.addSlotToContainer(new SlotItemHandler(this.SOLT1, 4, 170, 100));
        this.addSlotToContainer(new SlotItemHandler(this.SOLT1, 5, 194, 60));
        this.addSlotToContainer(new SlotItemHandler(this.SOLT7, 0, 323, 60));

        InventoryPlayer inventoryPlayer = player.inventory;
        for (int i = 0; i <=8; i++) {

            this.addSlotToContainer(new Slot(inventoryPlayer, i + 0,  112 + 18 * i,  152+37));
            this.addSlotToContainer(new Slot(inventoryPlayer, i + 9,  112 + 18 * i,   94+37));
            this.addSlotToContainer(new Slot(inventoryPlayer, i + 18, 112 + 18 * i, 112+37));
            this.addSlotToContainer(new Slot(inventoryPlayer, i + 27, 112 + 18 * i, 130+37));
        }
    }



//打开检测
    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return playerIn.world.equals(this.world) && playerIn.getDistanceSq(this.pos) <= 64.0;
    }

//    分配物品快捷键
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        return ItemStack.EMPTY;
    }


    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
        TileEntity tileEntity = this.world.getTileEntity(this.pos);
        if (tileEntity instanceof TileEntityPot)
        {
            int compressorProgress = ((TileEntityPot) tileEntity).getCompressorProgress();
            if (compressorProgress != this.compressorProgress)
            {
                this.compressorProgress = compressorProgress;
                for (IContainerListener listener : this.listeners)
                {
                    listener.sendWindowProperty(this, 0, compressorProgress);
                }
            }
        }
    }


//    客户端接收数据
    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        if (id == 0)
        {
            this.compressorProgress = data;
        }
    }
}
