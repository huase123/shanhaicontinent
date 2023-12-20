package hua.huase.shanhaicontinent.WorldGen.gen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class GenSHBoat extends WorldGenerator
{
    private int length;
    private IBlockState state;

    public GenSHBoat(int length, IBlockState typeIn)
    {
        this.setGeneratedBlock(length, typeIn);
    }

    public void setGeneratedBlock(int length, IBlockState typeIn)
    {
        this.length = length;
        this.state = typeIn;
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        for (int i = -length/2; i < length/2; i++) {
            int y = (int)Math.sqrt((length / 2) * (length / 2) - i * i);
            for (int j = -y; j <= y ; j++) {
                int z = (int)Math.sqrt(y*y - j * j);
                for (int k = -z-length; k <z+length ; k++) {
                    if(i<=0 || k>=-(z+length)/4  ){

                        worldIn.setBlockState(position.add(k,i+12,j),state);
//                        this.setBlockAndNotifyAdequately(worldIn,position.add(k,i+12,j),state);
                    }
                }
            }
        }

        for (int i = -length/2+3; i < length/2-2; i++) {
            int y = (int)Math.sqrt((length / 2-2) * (length / 2-2) - i * i);
            for (int j = -y; j <= y ; j++) {
                int z = (int)Math.sqrt(y*y - j * j);
                for (int k = -z-length; k <z+length ; k++) {
                    if(k!=-(z+length)/4 && i!=-1 ){
                        worldIn.setBlockState(position.add(k,i+12,j), Blocks.AIR.getDefaultState());
                        if(k==0&&i==0&&j==0){

                            worldIn.setBlockState(position.add(k,i+12,j), Blocks.STONE.getDefaultState());
//                            this.setBlockAndNotifyAdequately(worldIn,position.add(k,i+12,j), Blocks.STONE.getDefaultState());
                        }
                    }
                }
            }
        }


        return true;
    }
}