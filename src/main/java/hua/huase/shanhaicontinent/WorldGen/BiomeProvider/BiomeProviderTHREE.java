package hua.huase.shanhaicontinent.WorldGen.BiomeProvider;

import hua.huase.shanhaicontinent.WorldGen.layer.GenLayerTFBiomesTHREE;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerSmooth;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

import java.util.Arrays;


public class BiomeProviderTHREE extends BiomeProviderBase {

	private final BiomeCacheMy mapCache;

	public BiomeProviderTHREE(World world) {
//		super(world.getWorldInfo());
		getBiomesToSpawnIn().clear();
//		getBiomesToSpawnIn().add(biome);

		makeLayers(world.getSeed());
		mapCache = new BiomeCacheMy(this, 512, true);
	}

	private void makeLayers(long seed) {
		GenLayer biomes = new GenLayerTFBiomesTHREE(1L);

		biomes = new GenLayerZoom(1000L, biomes);
		biomes = new GenLayerZoom(1001, biomes);


		biomes = new GenLayerZoom(1002, biomes);
		biomes = new GenLayerZoom(1003, biomes);
		biomes = new GenLayerZoom(1004, biomes);
		biomes = new GenLayerZoom(1005, biomes);

		biomes = new GenLayerZoom(1006, biomes);

		biomes = new GenLayerSmooth(7000L, biomes);

		// do "voronoi" zoom
		GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);

		biomes.initWorldGenSeed(seed);
		genlayervoronoizoom.initWorldGenSeed(seed);

		genBiomes = biomes;
		biomeIndexLayer = genlayervoronoizoom;
	}



	@Override
	public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int width, int height) {
		return getBiomesForGeneration(biomes, x, z, width, height, true);
	}

	public Biome[] getBiomesForGeneration(Biome[] biomes, int x, int z, int width, int height, boolean useCache) {
		// for grid-centred magic maps, get from map cache
		if (useCache && mapCache.isGridAligned(x, z, width, height)) {
			Biome[] cached = mapCache.getBiomes(x, z);
			return Arrays.copyOf(cached, cached.length);
		}
		return super.getBiomesForGeneration(biomes, x, z, width, height);
	}

	@Override
	public void cleanupCache() {
		mapCache.cleanup();
		super.cleanupCache();
	}
}
