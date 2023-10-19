package hua.huase.shanhaicontinent.block.soulsoil;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public interface SoulSoilBase {

    boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient, ItemStack stack);

    boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state,ItemStack stack);

    void grow(World worldIn, Random rand, BlockPos pos, IBlockState state, ItemStack stack, EntityPlayer player);

     int getAge(IBlockState state);
    IBlockState withAge(int age);

}
