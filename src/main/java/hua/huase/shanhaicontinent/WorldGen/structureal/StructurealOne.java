package hua.huase.shanhaicontinent.WorldGen.structureal;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import static hua.huase.shanhaicontinent.LootTablesHander.GUFENGXIAOWU_CHESTS;
import static hua.huase.shanhaicontinent.villager.VillagerRegistryHandler.DIRT_WORKER;

public class StructurealOne implements IWorldGenerator {
    int distance;
    World world;
    public StructurealOne(){
        distance=16;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        this.world=world;
        if(world==null||!canSpawnStructureAtCoords(chunkX,chunkZ)||world.provider.getDimension()!=0) {
            return;
        }

        ((WorldServer)world).addScheduledTask(() ->
        {

            MinecraftServer server = world.getMinecraftServer();
        TemplateManager manager = world.getSaveHandler().getStructureTemplateManager();
        Template template2 = manager.getTemplate(server,new ResourceLocation("shanhaicontinent","huasstr/gufengxiaowu01"));
        Rotation[] arotation = Rotation.values();
        Rotation rotation = arotation[random.nextInt(arotation.length)];
        PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation).setRandom(random);

        BlockPos pos = new BlockPos(chunkX * 16, 180, chunkZ * 16);
        for (IBlockState iblockstate = world.getBlockState(pos); (iblockstate.getBlock().isAir(iblockstate, world, pos) || iblockstate.getBlock().isLeaves(iblockstate, world, pos)) && pos.getY() > 5; iblockstate = world.getBlockState(pos))
        {
            pos = pos.down();
        }
        BlockPos blockpos1 = template2.getZeroPositionWithTransform(pos.up(), Mirror.NONE, rotation);



        int x = 9;
        int z =7;
        BlockPos  chestPos = blockpos1;
        switch (rotation){
            case NONE:chestPos =blockpos1.add(x,0,z);
            break;
            case CLOCKWISE_90:chestPos =blockpos1.add(-x,0,z);
            break;
            case CLOCKWISE_180:chestPos =blockpos1.add(-x,0,-z);
            break;
            case COUNTERCLOCKWISE_90:chestPos =blockpos1.add(x,0,-z);
            break;

        }

        BlockPos  chestPos1 = rotationPos(blockpos1,rotation,13,1,13);


        placementsettings.setIntegrity(1F);

        template2.addBlocksToWorld(world, blockpos1, placementsettings, 2 | 4 | 16);




        world.setBlockState(chestPos, Blocks.CHEST.getStateFromMeta(0), 3);
        TileEntity tileentity = world.getTileEntity(chestPos);

        if (tileentity instanceof TileEntityChest)
        {
            ((TileEntityChest)tileentity).setLootTable(GUFENGXIAOWU_CHESTS, random.nextLong());
        }

        world.setBlockState(chestPos1, Blocks.CHEST.getStateFromMeta(0), 3);
        TileEntity tileentity1= world.getTileEntity(chestPos1);

        if (tileentity1 instanceof TileEntityChest)
        {
            ((TileEntityChest)tileentity1).setLootTable(GUFENGXIAOWU_CHESTS, random.nextLong());
        }




        EntityVillager entityvillager = new EntityVillager(world);
        entityvillager.setLocationAndAngles((double)chestPos.getX(), (double)chestPos.getY()+2, (double)chestPos.getZ(), 0.0F, 0.0F);
//        net.minecraftforge.fml.common.registry.VillagerRegistry.setRandomProfession(entityvillager, worldIn.rand);

        entityvillager.setProfession(DIRT_WORKER);
        entityvillager.finalizeMobSpawn(world.getDifficultyForLocation(new BlockPos(entityvillager)), (IEntityLivingData)null, false);
        world.spawnEntity(entityvillager);


        });
    }


    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ)
    {

        int i = chunkX;
        int j = chunkZ;

        if (chunkX < 0)
        {
            chunkX -= this.distance - 1;
        }

        if (chunkZ < 0)
        {
            chunkZ -= this.distance - 1;
        }

        int k = chunkX ;
        int l = chunkZ ;
        Random random = this.world.setRandomSeed(k, l, 2023109);
        k = k + random.nextInt(this.distance+8);
        l = l + random.nextInt(this.distance+8);

        if (i == k && j == l)
        {
//            boolean flag = this.world.getBiomeProvider().areBiomesViable(i * 16 + 8, j * 16 + 8, 0, VILLAGE_SPAWN_BIOMES);

                return true;
        }

        return false;
    }



    public static BlockPos rotationPos(BlockPos blockPos,Rotation rotation,int x ,int y, int z){

        switch (rotation){
            case NONE:return blockPos.add(x,y,z);
            case CLOCKWISE_90:return blockPos.add(-z,y,x);
            case CLOCKWISE_180:return blockPos.add(-x,y,-z);
            case COUNTERCLOCKWISE_90:return blockPos.add(z,y,-x);

        }
        return null;

    }

}
