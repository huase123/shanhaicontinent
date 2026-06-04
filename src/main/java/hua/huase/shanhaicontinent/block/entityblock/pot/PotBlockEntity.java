package hua.huase.shanhaicontinent.block.entityblock.pot;

import hua.huase.shanhaicontinent.init.ModelBlockEntitiesinit;
import hua.huase.shanhaicontinent.item.HunyePing;
import hua.huase.shanhaicontinent.item.armor.SHArmorBaseItem;
import hua.huase.shanhaicontinent.recipe.PotRecipe;
import hua.huase.shanhaicontinent.screen.PotMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class PotBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(8) {
        @Override
        protected void onContentsChanged(int slot) {
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
            setChanged();
        }
    };

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 7;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 200;
    private int nengliang = 0;

    public PotBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModelBlockEntitiesinit.Pot_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> PotBlockEntity.this.progress;
                    case 1 -> PotBlockEntity.this.maxProgress;
                    case 2 -> PotBlockEntity.this.nengliang;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> PotBlockEntity.this.progress = pValue;
                    case 1 -> PotBlockEntity.this.maxProgress = pValue;
                    case 2 -> PotBlockEntity.this.nengliang = pValue;
                }
            }

            @Override
            public int getCount() {
                return 8;
            }
        };
    }

    public ItemStack getRenderStack() {
        if(itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty()) {
            return itemHandler.getStackInSlot(INPUT_SLOT);
        } else {
            return itemHandler.getStackInSlot(OUTPUT_SLOT);
        }
    }

        @Override
        public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
            if(cap == ForgeCapabilities.ITEM_HANDLER) {
                return lazyItemHandler.cast();
            }

            return super.getCapability(cap, side);
        }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.tutorialmod.gem_polishing_station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new PotMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("gem_polishing_station.progress", progress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("gem_polishing_station.progress");
    }

    public void tick(Level pLevel, BlockPos pPos, BlockState pState) {
        if(hasRecipe() && isNengliang()) {
            increaseCraftingProgress();
            setChanged(pLevel, pPos, pState);

            if(hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            if(hasRecipe() && !isNengliang()){
                nengliang = getCurrentRecipe().get().getnengliang();
            }else {
                nengliang = 0;
            }

            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
    }

    private void craftItem() {
        Optional<PotRecipe> recipe = getCurrentRecipe();
        ItemStack result = recipe.get().getResultItem(null);

//        this.itemHandler.extractItem(0, 1, false);

        ItemStack stackInSlot1 = this.itemHandler.getStackInSlot(0);
        ItemStack stackInSlot2 = ItemStack.EMPTY;


        if(!stackInSlot1.isEmpty() && stackInSlot1.isDamageableItem()){
            stackInSlot2 = result.copy();
            CompoundTag tag = stackInSlot1.getOrCreateTag();
            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(stackInSlot1);
            if(!enchantments.isEmpty()){
                EnchantmentHelper.setEnchantments(enchantments, stackInSlot2);
            }
            stackInSlot2.setTag(tag);
            if(stackInSlot1.getItem() == result.getItem()){

                stackInSlot2.setDamageValue(0);
            }
            this.itemHandler.extractItem(0, 1, false);
        } else if (stackInSlot1.getItem() instanceof HunyePing && result.getItem() instanceof HunyePing) {

            stackInSlot2 = result.copy();
            CompoundTag tag = stackInSlot1.getOrCreateTag();
            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(stackInSlot1);
            if(!enchantments.isEmpty()){
                EnchantmentHelper.setEnchantments(enchantments, stackInSlot2);
            }
            stackInSlot2.setTag(tag);

            this.itemHandler.extractItem(0, 1, false);
        }


        ItemStack stackInSlot = this.itemHandler.getStackInSlot(1);
        if(!stackInSlot.isEmpty() && stackInSlot.getItem() instanceof HunyePing hunyePing && recipe.get().getnengliang()>0){
            hunyePing.setNengliang(null,stackInSlot,hunyePing.getNengliang(null,stackInSlot)-recipe.get().getnengliang());
        }else {
            this.itemHandler.extractItem(1, 1, false);
        }

        this.itemHandler.extractItem(2, 1, false);
        this.itemHandler.extractItem(3, 1, false);
        this.itemHandler.extractItem(4, 1, false);
        this.itemHandler.extractItem(5, 1, false);
        this.itemHandler.extractItem(6, 1, false);
//        是否为修复
        if(stackInSlot2.isEmpty()){
            this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                    this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
        }else {
            this.itemHandler.setStackInSlot(OUTPUT_SLOT, stackInSlot2);
        }


        this.getLevel().playSound((Player)null, this.getBlockPos().getX(), this.getBlockPos().getY(), this.getBlockPos().getZ(),
                SoundEvents.PLAYER_LEVELUP, SoundSource.BLOCKS, 1 * 0.75F, 1.0F);



    }

    public boolean hasRecipe() {
        Optional<PotRecipe> recipe = getCurrentRecipe();

        if(recipe.isEmpty()) {
            return false;
        }
        ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());

        return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem()) ;
    }


    public boolean isNengliang() {
        Optional<PotRecipe> recipe = getCurrentRecipe();
        ItemStack stackInSlot = itemHandler.getStackInSlot(1);
        if(!stackInSlot.isEmpty() && stackInSlot.getItem() instanceof HunyePing hunyePing){
            if(hunyePing.getNengliang(null,stackInSlot)<recipe.get().getnengliang())return false;
        }
        return true;
    }

    public Optional<PotRecipe> getCurrentRecipe() {
        SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
        for(int i = 0; i < itemHandler.getSlots()-1; i++) {
            inventory.setItem(i, this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager().getRecipeFor(PotRecipe.Type.INSTANCE, inventory, level);
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
    }

    private boolean hasProgressFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return saveWithoutMetadata();
    }
}
