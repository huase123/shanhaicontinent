package hua.huase.shanhaicontinent.item.bonemeal;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.block.soulsoil.SoulSoilBase;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class SoulBoneMeal extends Item {


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

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }

    public int getMetadata(int damage)
    {
        return damage;
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "_age" + stack.getMetadata();
    }


    public SoulBoneMeal(String name, CreativeTabs Tabs){
        super();
        setRegistryName(name);
        setUnlocalizedName(ExampleMod.MODID  +"."+  name);
        setCreativeTab(Tabs);
        setHasSubtypes(true);
        HanderAny.soulbonemeal= this;
        setMaxStackSize(64);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {

        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack))
        {
            return EnumActionResult.FAIL;
        }else{

            applyBonemeal(itemstack, worldIn, pos, player, hand);

            return EnumActionResult.SUCCESS;

        }



    }


    public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target, EntityPlayer player, @javax.annotation.Nullable EnumHand hand)
    {
        IBlockState iblockstate = worldIn.getBlockState(target);

        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, target, iblockstate, stack, hand);
        if (hook != 0) return hook > 0;

        if (iblockstate.getBlock() instanceof SoulSoilBase)
        {
            SoulSoilBase igrowable = (SoulSoilBase)iblockstate.getBlock();

            if (igrowable.canGrow(worldIn, target, iblockstate, worldIn.isRemote,stack))
            {
                if (!worldIn.isRemote)
                {
                    if (igrowable.canUseBonemeal(worldIn, worldIn.rand, target, iblockstate,stack))
                    {
                        igrowable.grow(worldIn, worldIn.rand, target, iblockstate,stack,player);
                    }

                    stack.shrink(1);
                }

                return true;
            }
        }

        return false;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
//        list.remove(list.size()-1);
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("soulbonemeal_list0"));
    }




}
