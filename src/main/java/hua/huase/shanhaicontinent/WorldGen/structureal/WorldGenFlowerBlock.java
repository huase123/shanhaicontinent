package hua.huase.shanhaicontinent.WorldGen.structureal;

import hua.huase.shanhaicontinent.block.FlowerBlock;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class WorldGenFlowerBlock {
    private IBlockState state;

    public WorldGenFlowerBlock()
    {
    }

    public void setGeneratedBlock(IBlockState state)
    {
        this.state = state;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (!worldIn.isAirBlock(blockpos) &&worldIn.isAirBlock(blockpos.up()) && (!worldIn.provider.isNether() || blockpos.getY() < 255))
            {
                IBlockState state = worldIn.getBlockState(blockpos);
                if(state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.FARMLAND){

                    worldIn.setBlockState(blockpos, HanderAny.soulsoil.getStateFromMeta(0), 2);
                    worldIn.setBlockState(blockpos.up(), FlowerBlock.flowerBlocksList.get(rand.nextInt(FlowerBlock.flowerBlocksList.size())).getStateFromMeta(rand.nextInt(6)), 2);
                }
            }
        }

        return true;
    }
}
