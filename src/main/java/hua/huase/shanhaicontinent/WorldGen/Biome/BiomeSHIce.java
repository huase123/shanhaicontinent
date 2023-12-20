package hua.huase.shanhaicontinent.WorldGen.Biome;

import com.google.common.collect.Lists;
import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.WorldGen.HanderBiome;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.List;
import java.util.Random;

public class BiomeSHIce extends BiomeBase
{

    protected static final IBlockState PACKED_ICE = Blocks.PACKED_ICE.getDefaultState();
    public BiomeSHIce(BiomeSHIce.Type type , String name)
    {
        super(new BiomeProperties(name+"_"+type.name())
                .setBaseHeight(-3.1f)
                .setHeightVariation(0.5f)
                ,type);
        this.setRegistryName(ExampleMod.MODID,name+"_"+type.name());
        this.topBlock = Blocks.SNOW.getDefaultState();
        this.fillerBlock = Blocks.ICE.getDefaultState();
        HanderBiome.biomeslist.add(this);
//        this.spawnableCreatureList.clear();
    }
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {
        int i = worldIn.getSeaLevel();
        IBlockState iblockstate = this.topBlock;
        IBlockState iblockstate1 = this.fillerBlock;
        int j = -1;
        int k = (int)(noiseVal / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
        int l = x & 15;
        int i1 = z & 15;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (int j1 = 255; j1 >= 0; --j1)
        {
            if (j1 <= 1)
            {
                chunkPrimerIn.setBlockState(i1, j1, l, BEDROCK);
            }
            else
            {
                IBlockState iblockstate2 = chunkPrimerIn.getBlockState(i1, j1, l);

                if (iblockstate2.getMaterial() == Material.AIR)
                {
                    j = -1;
                }
                else if (iblockstate2.getBlock() == Blocks.STONE)
                {
                    if (j == -1)
                    {
                        if (k <= 0)
                        {
                            iblockstate = AIR;
                            iblockstate1 = fillerBlock;
                        }
                        else if (j1 >= i - 4 && j1 <= i + 1)
                        {
                            iblockstate = this.topBlock;
                            iblockstate1 = this.fillerBlock;
                        }

                        if (j1 < i && (iblockstate == null || iblockstate.getMaterial() == Material.AIR))
                        {
                            if (this.getTemperature(blockpos$mutableblockpos.setPos(x, j1, z)) < 0.15F)
                            {
                                iblockstate = ICE;
                            }
                            else
                            {
                                iblockstate = WATER;
                            }
                        }

                        j = k;

                        if (j1 >= i - 1)
                        {
                            chunkPrimerIn.setBlockState(i1, j1, l, iblockstate);
                        }
                        else if (j1 < i - 7 - k)
                        {
                            iblockstate = AIR;
                            iblockstate1 = PACKED_ICE;
                            chunkPrimerIn.setBlockState(i1, j1, l, PACKED_ICE);
                        }
                        else
                        {
                            chunkPrimerIn.setBlockState(i1, j1, l, iblockstate1);
                        }
                    }
                    else if (j > 0)
                    {
                        --j;
                        chunkPrimerIn.setBlockState(i1, j1, l, PACKED_ICE);

                        if (j == 0 && iblockstate1.getBlock() == Blocks.SAND && k > 1)
                        {
                            j = rand.nextInt(4) + Math.max(0, j1 - 63);
                            iblockstate1 = iblockstate1.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ? RED_SANDSTONE : SANDSTONE;
                        }
                    }
                }
                else if (j1>=8 && iblockstate2.getBlock() == Blocks.WATER)
                {

                    chunkPrimerIn.setBlockState(i1, j1, l, PACKED_ICE);
                }
            }
        }
    }
    public TempCategory getTempCategory()
    {
        return TempCategory.OCEAN;
    }


    public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        this.decorator.decorate(worldIn, rand, this, pos);
    }


    public BiomeDecorator createBiomeDecorator()
    {
        return getModdedBiomeDecorator(new BiomeDecorator());
    }



    public List<SpawnListEntry> getSpawnableList(EnumCreatureType creatureType)
    {
        switch (creatureType)
        {
            case MONSTER:
                return this.spawnableMonsterList;
            case CREATURE:
                return this.spawnableCreatureList;
            case WATER_CREATURE:
                return this.spawnableWaterCreatureList;
            case AMBIENT:
                return this.spawnableCaveCreatureList;
            default:
                // Forge: Return a non-empty list for non-vanilla EnumCreatureTypes
                if (!this.modSpawnableLists.containsKey(creatureType)) this.modSpawnableLists.put(creatureType, Lists.<SpawnListEntry>newArrayList());
                return this.modSpawnableLists.get(creatureType);
        }
    }


}
