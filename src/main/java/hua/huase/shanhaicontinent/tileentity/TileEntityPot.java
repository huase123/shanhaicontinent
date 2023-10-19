package hua.huase.shanhaicontinent.tileentity;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.block.FlowerBlock;
import hua.huase.shanhaicontinent.capability.DanyaoItemCapabilityProvider;
import hua.huase.shanhaicontinent.handers.HanderAny;
import hua.huase.shanhaicontinent.item.danfangdir.DanFangBase;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityPot extends TileEntity implements ITickable
{
    public static final String ID = ExampleMod.MODID + ":Pot";

    private final ItemStackHandler SLOT0 = new ItemStackHandler(1)
    {
        @Override
        protected void onContentsChanged(int slot)
        {
            TileEntityPot.this.markDirty();
        }
    };

    private final ItemStackHandler SLOT1 = new ItemStackHandler(6)
    {
        @Override
        protected void onContentsChanged(int slot)
        {
            TileEntityPot.this.markDirty();
        }
    };


    private final ItemStackHandler SLOT7 = new ItemStackHandler(1)
    {
        @Override
        protected void onContentsChanged(int slot)
        {
            TileEntityPot.this.markDirty();
        }
    };





    private int compressorProgress = 0;

    public int getCompressorProgress()
    {
        return this.compressorProgress;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.compressorProgress = compound.getInteger("Progress");
        this.SLOT0.deserializeNBT(compound.getCompoundTag("Slot0"));
        this.SLOT1.deserializeNBT(compound.getCompoundTag("Slot1"));
        this.SLOT7.deserializeNBT(compound.getCompoundTag("Slot7"));
    }


    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("Progress", this.compressorProgress);
        compound.setTag("Slot0", this.SLOT0.serializeNBT());
        compound.setTag("Slot1", this.SLOT1.serializeNBT());
        compound.setTag("Slot7", this.SLOT7.serializeNBT());

        return compound;
    }




    private ItemStack oldItemstack = new ItemStack(Blocks.AIR);
    public int fuel = 0;

    public boolean changeFuel(){
        if (fuel<=0){
            if (Items.COAL.equals(this.SLOT1.extractItem(0, 1, true).getItem())){

                this.SLOT1.extractItem(0, 1, false);
                fuel +=8 ;
            }else {
                return false;
            }

        }
            fuel--;
            return true;
    }

//方块执行逻辑
    @Override
    public void update() {

        if(oldItemstack!=this.SLOT0.extractItem(0, 1, true)){
            oldItemstack=this.SLOT0.extractItem(0, 1, true);
            this.compressorProgress=0;
        }

        Item air = Item.getItemFromBlock(Blocks.AIR);
        boolean canExtractInput = air.equals(this.SLOT0.extractItem(0, 1, true).getItem());
        if (canExtractInput) {
            if (this.compressorProgress % 80 == 0) {

                ItemStack itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":hunye")));


                if (Items.COAL.equals(this.SLOT1.extractItem(0, 1, true).getItem())) {
                    boolean b = false;
                    if(Block.getBlockFromItem(this.SLOT1.extractItem(1, 1, true).getItem()) instanceof FlowerBlock&&this.SLOT1.extractItem(1, 1, true).getMetadata()>0){
                        itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":hunye")), 1, this.SLOT1.extractItem(1, 1, true).getMetadata()-1, new DanyaoItemCapabilityProvider(1,this.SLOT1.extractItem(1, 1, true).getMetadata()-1).serializeItemNBT());

                        if (this.SLOT7.insertItem(0, itemStack, true).isEmpty()) {
                        if (this.compressorProgress >= 240) {
                            this.SLOT7.insertItem(0, itemStack, false);
                                this.SLOT1.extractItem(1, 1, false);
                                b=true;
                            }
                            this.compressorProgress += 1;
                        }
                    }
                    if (Block.getBlockFromItem(this.SLOT1.extractItem(2, 1, true).getItem()) instanceof FlowerBlock&&this.SLOT1.extractItem(2, 1, true).getMetadata()>0){
                        itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":hunye")), 1, this.SLOT1.extractItem(2, 1, true).getMetadata()-1, new DanyaoItemCapabilityProvider(1,this.SLOT1.extractItem(2, 1, true).getMetadata()-1).serializeItemNBT());

                        if (this.SLOT7.insertItem(0, itemStack, true).isEmpty()) {
                        if (this.compressorProgress >= 240) {    this.SLOT7.insertItem(0, itemStack, false);
                                this.SLOT1.extractItem(2, 1, false);
                                b=true;
                            }
                            this.compressorProgress += 1;
                        }
                    }
                    if (Block.getBlockFromItem(this.SLOT1.extractItem(3, 1, true).getItem()) instanceof FlowerBlock&&this.SLOT1.extractItem(3, 1, true).getMetadata()>0){
                        itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":hunye")), 1, this.SLOT1.extractItem(3, 1, true).getMetadata()-1, new DanyaoItemCapabilityProvider(1,this.SLOT1.extractItem(3, 1, true).getMetadata()-1).serializeItemNBT());

                        if (this.SLOT7.insertItem(0, itemStack, true).isEmpty()) {
                        if (this.compressorProgress >= 240) {   this.SLOT7.insertItem(0, itemStack, false);
                                this.SLOT1.extractItem(3, 1, false);
                                b=true;
                            }
                            this.compressorProgress += 1;
                        }
                    }
                    if (Block.getBlockFromItem(this.SLOT1.extractItem(4, 1, true).getItem()) instanceof FlowerBlock&&this.SLOT1.extractItem(4, 1, true).getMetadata()>0){
                        itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":hunye")), 1, this.SLOT1.extractItem(4, 1, true).getMetadata()-1, new DanyaoItemCapabilityProvider(1,this.SLOT1.extractItem(4, 1, true).getMetadata()-1).serializeItemNBT());

                        if (this.SLOT7.insertItem(0, itemStack, true).isEmpty()) {
                        if (this.compressorProgress >= 240) {   this.SLOT7.insertItem(0, itemStack, false);
                                this.SLOT1.extractItem(4, 1, false);
                                b=true;
                            }
                            this.compressorProgress += 1;
                        }
                    }
                    if (Block.getBlockFromItem(this.SLOT1.extractItem(5, 1, true).getItem()) instanceof FlowerBlock&&this.SLOT1.extractItem(5, 1, true).getMetadata()>0){
                        itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":hunye")), 1, this.SLOT1.extractItem(5, 1, true).getMetadata()-1, new DanyaoItemCapabilityProvider(1,this.SLOT1.extractItem(5, 1, true).getMetadata()-1).serializeItemNBT());

                        if (this.SLOT7.insertItem(0,itemStack, true).isEmpty()) {
                        if (this.compressorProgress >= 240) {  this.SLOT7.insertItem(0,itemStack, false);
                                this.SLOT1.extractItem(5, 1, false);
                                b=true;
                            }
                            this.compressorProgress += 1;
                        }
                    }
                    if(b){

                        this.compressorProgress =0;
                    }
                }
            } else {
                this.compressorProgress += 1;
                    this.markDirty();
            }
        } else if (this.SLOT0.extractItem(0, 1, true).getItem() instanceof DanFangBase) {
            DanFangBase item = (DanFangBase) this.SLOT0.extractItem(0, 1, true).getItem();
            this.compressorProgress = item.update(this,this.SLOT0.extractItem(0, 1, true),SLOT0,SLOT1,SLOT7,this.compressorProgress);
//            this.markDirty();

        } else if (this.compressorProgress > 0) {
            this.compressorProgress = 0;
            this.markDirty();
        }
    }



//比较Capablity
    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
    {
        Capability<IItemHandler> itemHandlerCapability = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
        return itemHandlerCapability.equals(capability) || super.hasCapability(capability, facing);
    }

    //查找Capablity
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
        Capability<IItemHandler> itemHandlerCapability = CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
        if (itemHandlerCapability.equals(capability))
        {
            if (EnumFacing.UP.equals(facing))
            {
                return itemHandlerCapability.cast(this.SLOT0);
            }
            if (EnumFacing.DOWN.equals(facing))
            {
                return itemHandlerCapability.cast(this.SLOT7);
            }
            return itemHandlerCapability.cast(this.SLOT1);
        }
        return super.getCapability(capability, facing);
    }

}
