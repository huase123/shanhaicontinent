package hua.huase.shanhaicontinent.WorldGen.Biome;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;

import java.util.Random;

public class BiomeZDY extends Biome
{
    public BiomeZDY(Biome.BiomeProperties properties)
    {
        super(properties);
//        this.spawnableCreatureList.clear();
    }
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal)
    {

    }
    public Biome.TempCategory getTempCategory()
    {
        return Biome.TempCategory.OCEAN;
    }
}
