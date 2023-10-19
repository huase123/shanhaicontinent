package hua.huase.shanhaicontinent.WorldGen.structureal;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import static hua.huase.shanhaicontinent.LootTablesHander.*;

public class StructurealTow implements IWorldGenerator {
    int distance;
    World world;
    public StructurealTow(){
        distance=32;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        this.world=world;
        if(world==null||!canSpawnStructureAtCoords(chunkX,chunkZ)||world.provider.getDimension()!=1) {
            return;
        }
        MinecraftServer server = world.getMinecraftServer();
        TemplateManager manager = world.getSaveHandler().getStructureTemplateManager();
        Template template0 = manager.getTemplate(server,new ResourceLocation("shanhaicontinent","huasstr/gelou0"));
        Template template1 = manager.getTemplate(server,new ResourceLocation("shanhaicontinent","huasstr/gelou1"));
        BlockPos pos = new BlockPos(chunkX * 16, 80, chunkZ * 16);

        for (IBlockState iblockstate = world.getBlockState(pos); (iblockstate.getBlock().isAir(iblockstate, world, pos) || iblockstate.getBlock().isLeaves(iblockstate, world, pos)) && pos.getY() > 40; iblockstate = world.getBlockState(pos))
        {
            pos = pos.down();
        }



        if(world.getBlockState(pos.down()).getBlock().isAir(world.getBlockState(pos.down()), world, pos)){
            return;
        }


        final BlockPos posfinal = pos;

        for (Rotation rotation : Rotation.values()) {

                    PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation).setRandom(random);
                    template0.addBlocksToWorld(world, posfinal, placementsettings, 2 | 4 | 16);
                    template1.addBlocksToWorld(world, posfinal.add(0,32,0), placementsettings, 2 | 4 | 16);

        }

        world.setBlockState(posfinal, Blocks.CHEST.getStateFromMeta(0), 3);
        TileEntity tileentity = world.getTileEntity(posfinal);

        if (tileentity instanceof TileEntityChest)
        {
            ((TileEntityChest)tileentity).setLootTable(GUFENGXIAOWU_CHESTS_MODI_ZUIHOU, random.nextLong());
        }

        final BlockPos posfinal1 = pos.add(0,4,0);
        final BlockPos posfinal2 = pos.add(0,20,0);
        final BlockPos posfinal3 = pos.add(0,36,0);
        final BlockPos posfinal4 = pos.add(0,48,0);

        world.setBlockState(posfinal1, Blocks.CHEST.getStateFromMeta(0), 3);
        TileEntity tileentity1 = world.getTileEntity(posfinal1);

        if (tileentity1 instanceof TileEntityChest)
        {
            ((TileEntityChest)tileentity1).setLootTable(GUFENGXIAOWU_CHESTS_MODI, random.nextLong());
        }

        world.setBlockState(posfinal2, Blocks.CHEST.getStateFromMeta(0), 3);
        TileEntity tileentity2 = world.getTileEntity(posfinal2);

        if (tileentity2 instanceof TileEntityChest)
        {
            ((TileEntityChest)tileentity2).setLootTable(GUFENGXIAOWU_CHESTS_MODI, random.nextLong());
        }

        world.setBlockState(posfinal3, Blocks.CHEST.getStateFromMeta(0), 3);
        TileEntity tileentity3 = world.getTileEntity(posfinal3);

        if (tileentity3 instanceof TileEntityChest)
        {
            ((TileEntityChest)tileentity3).setLootTable(GUFENGXIAOWU_CHESTS_MODI, random.nextLong());
        }

        world.setBlockState(posfinal4, Blocks.CHEST.getStateFromMeta(0), 3);
        TileEntity tileentity4 = world.getTileEntity(posfinal4);

        if (tileentity4 instanceof TileEntityChest)
        {
            ((TileEntityChest)tileentity4).setLootTable(GUFENGXIAOWU_CHESTS_MODI, random.nextLong());
        }




    }


    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ)
    {
        int i = chunkX;
        int j = chunkZ;

        if (Math.abs(chunkX )< 20||Math.abs(chunkZ)< 20)
        {
            return false;
        }

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



}
