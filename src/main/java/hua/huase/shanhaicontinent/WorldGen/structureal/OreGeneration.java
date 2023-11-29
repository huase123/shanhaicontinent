package hua.huase.shanhaicontinent.WorldGen.structureal;


import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;


public class OreGeneration implements IWorldGenerator {
    private WorldGenerator quartz_ore;

    public OreGeneration() {

    }

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case -1:
//                地狱
                this.generateHell(world, random, chunkX, chunkZ);
                break;
            case 0:
                this.generateWorld(world, random, chunkX, chunkZ);
                break;
//                主世界
            case 1:
                this.generateEnd(world, random, chunkX, chunkZ);
//                末地
        }

    }

    public void generateHell(World world, Random random, int chunkX, int chunkZ) {
        for (int i = 0; i < 5; i++) {
            this.quartz_ore = new WorldGenMinable(HanderAny.soulsoil.getStateFromMeta(i+1), 10-i*2, BlockMatcher.forBlock(Blocks.NETHERRACK));

            this.runGenerator(this.quartz_ore, world, random, chunkX, chunkZ, 4, 30, 80);
        }

        this.generateBianhua(world, random, chunkX, chunkZ,1);
    }
    public void generateEnd(World world, Random random, int chunkX, int chunkZ) {
        for (int i = 0; i < 2; i++) {
            this.quartz_ore = new WorldGenMinable(HanderAny.soulsoil.getStateFromMeta(i+5), 10-i*2, BlockMatcher.forBlock(Blocks.END_STONE));

            this.runGenerator(this.quartz_ore, world, random, chunkX, chunkZ, 4, 30, 70);
        }
    }

    public void generateWorld(World world, Random rand, int x, int z) {
//        this.generateOre(HanderAny.soulsoil.getStateFromMeta(rand.nextInt(5)), world, rand, x, z, 2, 20, 3, 5, 60);

        for (int i = 0; i < 5; i++) {

            this.generateOre(HanderAny.soulsoil.getStateFromMeta(i), world, rand, x, z, 2, 12-i*2, 4, 5, 60);

        }
            this.generateFlower(world, rand, x, z,1);


    }

    public void generateFlower(World world, Random randomx, int chunkX, int chunkZ,int chance) {


        int i = chunkX;
        int j = chunkZ;

        int k = chunkX ;
        int l = chunkZ ;
        Random random = world.setRandomSeed(k, l, 2023109);
        k = k + random.nextInt(8);
        l = l + random.nextInt(8);

        if (i == k && j == l)
        {
            int xRand = chunkX * 16+8;
            int yRand = 0;
            int zRand = chunkZ * 16+8;
            BlockPos pos = new BlockPos(xRand, yRand, zRand);
            int j14 = world.getHeight(pos).getY();
//            WorldGenFlowerBlock gen = new WorldGenFlowerBlock();
            WorldGenFlowerBlock.generate(world, random, pos.add(0,j14,0));


        }





    }


    public void generateBianhua(World world, Random randomx, int chunkX, int chunkZ,int chance) {


        int i = chunkX;
        int j = chunkZ;

        int k = chunkX ;
        int l = chunkZ ;
        Random random = world.setRandomSeed(k, l, 2023109);
        k = k + random.nextInt(4);
        l = l + random.nextInt(4);

        if (i == k && j == l)
        {
            int xRand = chunkX * 16+8;
            int yRand = 0;
            int zRand = chunkZ * 16+8;
            BlockPos pos = new BlockPos(xRand, yRand, zRand);
//            WorldGenFlowerBlock gen = new WorldGenFlowerBlock();
            WorldGenFlowerBlock.generateBianhua(world, random, pos.add(0,31,0));


        }





    }

    public void generateOre(IBlockState ore, World world, Random random, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY) {
        int vienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
        int heightRange = maxY - minY;
        WorldGenMinable gen = new WorldGenMinable(ore, vienSize);

        for(int i = 0; i < chance; ++i) {
            int xRand = chunkX * 16 + random.nextInt(16);
            int yRand = random.nextInt(heightRange) + minY;
            int zRand = chunkZ * 16 + random.nextInt(16);
            BlockPos pos = new BlockPos(xRand, yRand, zRand);
            gen.generate(world, random, pos);
        }

    }

    private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
        if (minHeight <= maxHeight && minHeight >= 0 && maxHeight <= 256) {
            int heightDiff = maxHeight - minHeight + 1;

            for(int i = 0; i < chance; ++i) {
                int x = chunkX * 16 + rand.nextInt(16);
                int y = minHeight + rand.nextInt(heightDiff);
                int z = chunkZ * 16 + rand.nextInt(16);
                gen.generate(world, rand, new BlockPos(x, y, z));
            }

        } else {
            throw new IllegalArgumentException("Ore generated out of bounds");
        }
    }
}
