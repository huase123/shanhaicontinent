package hua.huase.shanhaicontinent.WorldGen.BiomeProvider;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;

public class BiomeProviderBase extends BiomeProvider {


    public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int width, int height, boolean useCache) {

        return super.getBiomesForGeneration(biomes, x, z, width, height);
    }

}
