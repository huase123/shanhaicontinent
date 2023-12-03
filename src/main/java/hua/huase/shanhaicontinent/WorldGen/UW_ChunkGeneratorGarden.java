//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package hua.huase.shanhaicontinent.WorldGen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

import static hua.huase.shanhaicontinent.handers.HanderAny.soulsoil;

public class UW_ChunkGeneratorGarden implements IChunkGenerator {

    protected static final IBlockState STONE = Blocks.STONE.getDefaultState();
    private final World world;
    public Random rand;

    public UW_ChunkGeneratorGarden(World worldIn, long seed, boolean mapFeaturesEnabledIn, String generatorOptions)
    {

        this.world = worldIn;
        this.rand = worldIn.rand;
//        this.mapFeaturesEnabled = mapFeaturesEnabledIn;

    }



    public void setBlocksInChunk(int x, int z, ChunkPrimer primer)
    {
//        int i = 2;
//        int j = 3;
//        int k = 33;
//        int l = 3;
//        this.buffer = this.getHeights(this.buffer, x * 2, 0, z * 2, 3, 33, 3);
//
//        for (int i1 = 0; i1 < 2; ++i1)
//        {
//            for (int j1 = 0; j1 < 2; ++j1)
//            {
//                for (int k1 = 0; k1 < 32; ++k1)
//                {
//                    double d0 = 0.25D;
//                    double d1 = this.buffer[((i1 + 0) * 3 + j1 + 0) * 33 + k1 + 0];
//                    double d2 = this.buffer[((i1 + 0) * 3 + j1 + 1) * 33 + k1 + 0];
//                    double d3 = this.buffer[((i1 + 1) * 3 + j1 + 0) * 33 + k1 + 0];
//                    double d4 = this.buffer[((i1 + 1) * 3 + j1 + 1) * 33 + k1 + 0];
//                    double d5 = (this.buffer[((i1 + 0) * 3 + j1 + 0) * 33 + k1 + 1] - d1) * 0.25D;
//                    double d6 = (this.buffer[((i1 + 0) * 3 + j1 + 1) * 33 + k1 + 1] - d2) * 0.25D;
//                    double d7 = (this.buffer[((i1 + 1) * 3 + j1 + 0) * 33 + k1 + 1] - d3) * 0.25D;
//                    double d8 = (this.buffer[((i1 + 1) * 3 + j1 + 1) * 33 + k1 + 1] - d4) * 0.25D;
//
//                    for (int l1 = 0; l1 < 4; ++l1)
//                    {
//                        double d9 = 0.125D;
//                        double d10 = d1;
//                        double d11 = d2;
//                        double d12 = (d3 - d1) * 0.125D;
//                        double d13 = (d4 - d2) * 0.125D;
//
//                        for (int i2 = 0; i2 < 8; ++i2)
//                        {
//                            double d14 = 0.125D;
//                            double d15 = d10;
//                            double d16 = (d11 - d10) * 0.125D;
//
//                            for (int j2 = 0; j2 < 8; ++j2)
//                            {
//                                IBlockState iblockstate = AIR;
//
//                                if (d15 > 0.0D)
//                                {
//                                    iblockstate = END_STONE;
//                                }
//
//                                int k2 = i2 + i1 * 8;
//                                int l2 = l1 + k1 * 4;
//                                int i3 = j2 + j1 * 8;
//                                primer.setBlockState(k2, l2, i3, iblockstate);
//                                d15 += d16;
//                            }
//
//                            d10 += d12;
//                            d11 += d13;
//                        }
//
//                        d1 += d5;
//                        d2 += d6;
//                        d3 += d7;
//                        d4 += d8;
//                    }
//                }
//            }
//        }
    }

    protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
    public void replaceBiomeBlocks(int x, int z, ChunkPrimer primer, Biome[] biomesIn)
    {
        if (!net.minecraftforge.event.ForgeEventFactory.onReplaceBiomeBlocks(this, x, z, primer, this.world)) return;
        double d0 = 0.03125D;

        for (int i = 0; i < 16; ++i)
        {
            for (int j = 0; j < 16; ++j)
            {
//                Biome biome = biomesIn[j + i * 16];
//                biome.genTerrainBlocks(this.world, this.rand, primer, x * 16 + i, z * 16 + j, this.depthBuffer[j + i * 16]);

                primer.setBlockState(i, 1, j, BEDROCK);
                primer.setBlockState(i, 2, j, STONE);
                primer.setBlockState(i, 3, j, soulsoil.getStateFromMeta(0));
//                for (int j1 = 255; j1 >= 0; --j1) {
//                    if (j1 <= 1) {
//                        primer.setBlockState(i, j1, j, BEDROCK);
//                    }else {
//                        primer.setBlockState(i, j1, j, oceanBlock);
//                    }
//                }
            }
        }
    }

    public Chunk generateChunk(int x, int z)
    {
        this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
//        this.setBlocksInChunk(x, z, chunkprimer);
//        this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16, 16);
        this.replaceBiomeBlocks(x, z, chunkprimer, null);
/*

        if (this.settings.useCaves)
        {
            this.caveGenerator.generate(this.world, x, z, chunkprimer);
        }

        if (this.settings.useRavines)
        {
            this.ravineGenerator.generate(this.world, x, z, chunkprimer);
        }

        if (this.mapFeaturesEnabled)
        {
            if (this.settings.useMineShafts)
            {
                this.mineshaftGenerator.generate(this.world, x, z, chunkprimer);
            }

            if (this.settings.useVillages)
            {
                this.villageGenerator.generate(this.world, x, z, chunkprimer);
            }

            if (this.settings.useStrongholds)
            {
                this.strongholdGenerator.generate(this.world, x, z, chunkprimer);
            }

            if (this.settings.useTemples)
            {
                this.scatteredFeatureGenerator.generate(this.world, x, z, chunkprimer);
            }

            if (this.settings.useMonuments)
            {
                this.oceanMonumentGenerator.generate(this.world, x, z, chunkprimer);
            }

            if (this.settings.useMansions)
            {
                this.woodlandMansionGenerator.generate(this.world, x, z, chunkprimer);
            }

        }
*/

        Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
//        byte[] abyte = chunk.getBiomeArray();
//
//        for (int i = 0; i < abyte.length; ++i)
//        {
//            abyte[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
//        }

        chunk.generateSkylightMap();



        return chunk;
    }

    public void populate(int x, int z)
    {
//        BlockFalling.fallInstantly = true;
//        int i = x * 16;
//        int j = z * 16;
//        BlockPos blockpos = new BlockPos(i, 0, j);
//        Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));
//        this.rand.setSeed(this.world.getSeed());
//        long k = this.rand.nextLong() / 2L * 2L + 1L;
//        long l = this.rand.nextLong() / 2L * 2L + 1L;
//        this.rand.setSeed((long)x * k + (long)z * l ^ this.world.getSeed());
//        boolean flag = false;
//        ChunkPos chunkpos = new ChunkPos(x, z);
//
//        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand, x, z, flag);
//
//        if (this.mapFeaturesEnabled)
//        {
//            if (this.settings.useMineShafts)
//            {
//                this.mineshaftGenerator.generateStructure(this.world, this.rand, chunkpos);
//            }
//
//            if (this.settings.useVillages)
//            {
//                flag = this.villageGenerator.generateStructure(this.world, this.rand, chunkpos);
//            }
//
//            if (this.settings.useStrongholds)
//            {
//                this.strongholdGenerator.generateStructure(this.world, this.rand, chunkpos);
//            }
//
//            if (this.settings.useTemples)
//            {
//                this.scatteredFeatureGenerator.generateStructure(this.world, this.rand, chunkpos);
//            }
//
//            if (this.settings.useMonuments)
//            {
//                this.oceanMonumentGenerator.generateStructure(this.world, this.rand, chunkpos);
//            }
//
//            if (this.settings.useMansions)
//            {
//                this.woodlandMansionGenerator.generateStructure(this.world, this.rand, chunkpos);
//            }
//        }
//
//        if (biome != Biomes.DESERT && biome != Biomes.DESERT_HILLS && this.settings.useWaterLakes && !flag && this.rand.nextInt(this.settings.waterLakeChance) == 0)
//            if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag, net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE))
//            {
//                int i1 = this.rand.nextInt(16) + 8;
//                int j1 = this.rand.nextInt(256);
//                int k1 = this.rand.nextInt(16) + 8;
//                (new WorldGenLakes(Blocks.WATER)).generate(this.world, this.rand, blockpos.add(i1, j1, k1));
//            }
//
//        if (!flag && this.rand.nextInt(this.settings.lavaLakeChance / 10) == 0 && this.settings.useLavaLakes)
//            if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag, net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAVA))
//            {
//                int i2 = this.rand.nextInt(16) + 8;
//                int l2 = this.rand.nextInt(this.rand.nextInt(248) + 8);
//                int k3 = this.rand.nextInt(16) + 8;
//
//                if (l2 < this.world.getSeaLevel() || this.rand.nextInt(this.settings.lavaLakeChance / 8) == 0)
//                {
//                    (new WorldGenLakes(Blocks.LAVA)).generate(this.world, this.rand, blockpos.add(i2, l2, k3));
//                }
//            }
//
//        if (this.settings.useDungeons)
//            if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag, net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON))
//            {
//                for (int j2 = 0; j2 < this.settings.dungeonChance; ++j2)
//                {
//                    int i3 = this.rand.nextInt(16) + 8;
//                    int l3 = this.rand.nextInt(256);
//                    int l1 = this.rand.nextInt(16) + 8;
//                    (new WorldGenDungeons()).generate(this.world, this.rand, blockpos.add(i3, l3, l1));
//                }
//            }
//
//        biome.decorate(this.world, this.rand, new BlockPos(i, 0, j));
//        if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag, net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ANIMALS))
//            WorldEntitySpawner.performWorldGenSpawning(this.world, biome, i + 8, j + 8, 16, 16, this.rand);
//        blockpos = blockpos.add(8, 0, 8);
//
//        if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag, net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE))
//        {
//            for (int k2 = 0; k2 < 16; ++k2)
//            {
//                for (int j3 = 0; j3 < 16; ++j3)
//                {
//                    BlockPos blockpos1 = this.world.getPrecipitationHeight(blockpos.add(k2, 0, j3));
//                    BlockPos blockpos2 = blockpos1.down();
//
//                    if (this.world.canBlockFreezeWater(blockpos2))
//                    {
//                        this.world.setBlockState(blockpos2, Blocks.ICE.getDefaultState(), 2);
//                    }
//
//                    if (this.world.canSnowAt(blockpos1, true))
//                    {
//                        this.world.setBlockState(blockpos1, Blocks.SNOW_LAYER.getDefaultState(), 2);
//                    }
//                }
//            }
//        }//Forge: End ICE
//
//        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(false, this, this.world, this.rand, x, z, flag);
//
//        BlockFalling.fallInstantly = false;
    }

    public boolean generateStructures(Chunk chunkIn, int x, int z)
    {
//        boolean flag = false;
//
//        if (this.settings.useMonuments && this.mapFeaturesEnabled && chunkIn.getInhabitedTime() < 3600L)
//        {
//            flag |= this.oceanMonumentGenerator.generateStructure(this.world, this.rand, new ChunkPos(x, z));
//        }

        return false;
    }






    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos)
    {
        Biome biome = this.world.getBiome(pos);

//        if (this.mapFeaturesEnabled)
//        {
//            if (creatureType == EnumCreatureType.MONSTER && this.scatteredFeatureGenerator.isSwampHut(pos))
//            {
//                return this.scatteredFeatureGenerator.getMonsters();
//            }
//
//            if (creatureType == EnumCreatureType.MONSTER && this.settings.useMonuments && this.oceanMonumentGenerator.isPositionInStructure(this.world, pos))
//            {
//                return this.oceanMonumentGenerator.getMonsters();
//            }
//        }

        return biome.getSpawnableList(creatureType);
    }

    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos)
    {
        return false;
    }

    @Nullable
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored)
    {
        return  null;
    }

    public void recreateStructures(Chunk chunkIn, int x, int z)
    {
     /*
        if (this.mapFeaturesEnabled)
        {
            if (this.settings.useMineShafts)
            {
                this.mineshaftGenerator.generate(this.world, x, z, (ChunkPrimer)null);
            }

            if (this.settings.useVillages)
            {
                this.villageGenerator.generate(this.world, x, z, (ChunkPrimer)null);
            }

            if (this.settings.useStrongholds)
            {
                this.strongholdGenerator.generate(this.world, x, z, (ChunkPrimer)null);
            }

            if (this.settings.useTemples)
            {
                this.scatteredFeatureGenerator.generate(this.world, x, z, (ChunkPrimer)null);
            }

            if (this.settings.useMonuments)
            {
                this.oceanMonumentGenerator.generate(this.world, x, z, (ChunkPrimer)null);
            }

            if (this.settings.useMansions)
            {
                this.woodlandMansionGenerator.generate(this.world, x, z, (ChunkPrimer)null);
            }
        }
        */

    }
}
