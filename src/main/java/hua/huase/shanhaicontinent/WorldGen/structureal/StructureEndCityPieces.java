package hua.huase.shanhaicontinent.WorldGen.structureal;


import com.google.common.collect.Lists;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.world.storage.loot.LootTableList;

import java.util.List;
import java.util.Random;

import static hua.huase.shanhaicontinent.LootTablesHander.GUFENGXIAOWU_CHESTS_MODI;
import static hua.huase.shanhaicontinent.LootTablesHander.GUFENGXIAOWU_CHESTS_MODI_ZUIHOU;

public class StructureEndCityPieces
{
    private static final PlacementSettings OVERWRITE = (new PlacementSettings()).setIgnoreEntities(true);
    private static final PlacementSettings INSERT = (new PlacementSettings()).setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
    private static final IGenerator HOUSE_TOWER_GENERATOR = new IGenerator()
    {
        public void init()
        {
        }
        public boolean generate(TemplateManager p_191086_1_, int p_191086_2_, CityTemplateMy p_191086_3_, BlockPos p_191086_4_, List<StructureComponent> p_191086_5_, Random p_191086_6_)
        {
            if (p_191086_2_ > 8)
            {
                return false;
            }
            else
            {
                Rotation rotation = p_191086_3_.placeSettings.getRotation();
                CityTemplateMy structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, p_191086_3_, p_191086_4_, "base_floor", rotation, true));
                int i = p_191086_6_.nextInt(3);

                if (i == 0)
                {
                    addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(-1, 4, -1), "base_roof", rotation, true));
                }
                else if (i == 1)
                {
                    structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(-1, 0, -1), "second_floor_2", rotation, false));
                    structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(-1, 8, -1), "second_roof", rotation, false));
                    recursiveChildren(p_191086_1_, TOWER_GENERATOR, p_191086_2_ + 1, structureendcitypieces$citytemplate, (BlockPos)null, p_191086_5_, p_191086_6_);
                }
                else if (i == 2)
                {
                    structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(-1, 0, -1), "second_floor_2", rotation, false));
                    structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(-1, 4, -1), "third_floor_c", rotation, false));
                    structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(-1, 8, -1), "third_roof", rotation, true));
                    recursiveChildren(p_191086_1_, TOWER_GENERATOR, p_191086_2_ + 1, structureendcitypieces$citytemplate, (BlockPos)null, p_191086_5_, p_191086_6_);
                }

                return true;
            }
        }
    };
    private static final List<Tuple<Rotation, BlockPos>> TOWER_BRIDGES = Lists.newArrayList(new Tuple(Rotation.NONE, new BlockPos(1, -1, 0)), new Tuple(Rotation.CLOCKWISE_90, new BlockPos(6, -1, 1)), new Tuple(Rotation.COUNTERCLOCKWISE_90, new BlockPos(0, -1, 5)), new Tuple(Rotation.CLOCKWISE_180, new BlockPos(5, -1, 6)));
    private static final IGenerator TOWER_GENERATOR = new IGenerator()
    {
        public void init()
        {
        }
        public boolean generate(TemplateManager p_191086_1_, int p_191086_2_, StructureEndCityPieces.CityTemplateMy p_191086_3_, BlockPos p_191086_4_, List<StructureComponent> p_191086_5_, Random p_191086_6_)
        {
            Rotation rotation = p_191086_3_.placeSettings.getRotation();
            StructureEndCityPieces.CityTemplateMy lvt_8_1_ = addHelper(p_191086_5_, addPiece(p_191086_1_, p_191086_3_, new BlockPos(3 + p_191086_6_.nextInt(2), -3, 3 + p_191086_6_.nextInt(2)), "tower_base", rotation, true));
            lvt_8_1_ = addHelper(p_191086_5_, addPiece(p_191086_1_, lvt_8_1_, new BlockPos(0, 7, 0), "tower_piece", rotation, true));
            StructureEndCityPieces.CityTemplateMy structureendcitypieces$citytemplate1 = p_191086_6_.nextInt(3) == 0 ? lvt_8_1_ : null;
            int i = 1 + p_191086_6_.nextInt(3);

            for (int j = 0; j < i; ++j)
            {
                lvt_8_1_ = addHelper(p_191086_5_, addPiece(p_191086_1_, lvt_8_1_, new BlockPos(0, 4, 0), "tower_piece", rotation, true));

                if (j < i - 1 && p_191086_6_.nextBoolean())
                {
                    structureendcitypieces$citytemplate1 = lvt_8_1_;
                }
            }

            if (structureendcitypieces$citytemplate1 != null)
            {
                for (Tuple<Rotation, BlockPos> tuple : TOWER_BRIDGES)
                {
                    if (p_191086_6_.nextBoolean())
                    {
                        StructureEndCityPieces.CityTemplateMy structureendcitypieces$citytemplate2 = addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate1, tuple.getSecond(), "bridge_end", rotation.add(tuple.getFirst()), true));
                        recursiveChildren(p_191086_1_, TOWER_BRIDGE_GENERATOR, p_191086_2_ + 1, structureendcitypieces$citytemplate2, (BlockPos)null, p_191086_5_, p_191086_6_);
                    }
                }

                addHelper(p_191086_5_, addPiece(p_191086_1_, lvt_8_1_, new BlockPos(-1, 4, -1), "tower_top", rotation, true));
            }
            else
            {
                if (p_191086_2_ != 7)
                {
                    return recursiveChildren(p_191086_1_, FAT_TOWER_GENERATOR, p_191086_2_ + 1, lvt_8_1_, (BlockPos)null, p_191086_5_, p_191086_6_);
                }

                addHelper(p_191086_5_, addPiece(p_191086_1_, lvt_8_1_, new BlockPos(-1, 4, -1), "tower_top", rotation, true));
            }

            return true;
        }
    };
    private static final IGenerator TOWER_BRIDGE_GENERATOR = new IGenerator()
    {
        public boolean shipCreated;
        public void init()
        {
            this.shipCreated = false;
        }
        public boolean generate(TemplateManager p_191086_1_, int p_191086_2_, StructureEndCityPieces.CityTemplateMy p_191086_3_, BlockPos p_191086_4_, List<StructureComponent> p_191086_5_, Random p_191086_6_)
        {
            Rotation rotation = p_191086_3_.placeSettings.getRotation();
            int i = p_191086_6_.nextInt(4) + 1;
            StructureEndCityPieces.CityTemplateMy structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, p_191086_3_, new BlockPos(0, 0, -4), "bridge_piece", rotation, true));
            structureendcitypieces$citytemplate.componentType = -1;
            int j = 0;

            for (int k = 0; k < i; ++k)
            {
                if (p_191086_6_.nextBoolean())
                {
                    structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(0, j, -4), "bridge_piece", rotation, true));
                    j = 0;
                }
                else
                {
                    if (p_191086_6_.nextBoolean())
                    {
                        structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(0, j, -4), "bridge_steep_stairs", rotation, true));
                    }
                    else
                    {
                        structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(0, j, -8), "bridge_gentle_stairs", rotation, true));
                    }

                    j = 4;
                }
            }

            if (!this.shipCreated && p_191086_6_.nextInt(10 - p_191086_2_) == 0)
            {
                addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(-8 + p_191086_6_.nextInt(8), j, -70 + p_191086_6_.nextInt(10)), "ship", rotation, true));
                this.shipCreated = true;
            }
            else if (!recursiveChildren(p_191086_1_, HOUSE_TOWER_GENERATOR, p_191086_2_ + 1, structureendcitypieces$citytemplate, new BlockPos(-3, j + 1, -11), p_191086_5_, p_191086_6_))
            {
                return false;
            }

            structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(4, j, 0), "bridge_end", rotation.add(Rotation.CLOCKWISE_180), true));
            structureendcitypieces$citytemplate.componentType = -1;
            return true;
        }
    };
    private static final List<Tuple<Rotation, BlockPos>> FAT_TOWER_BRIDGES = Lists.newArrayList(new Tuple(Rotation.NONE, new BlockPos(4, -1, 0)), new Tuple(Rotation.CLOCKWISE_90, new BlockPos(12, -1, 4)), new Tuple(Rotation.COUNTERCLOCKWISE_90, new BlockPos(0, -1, 8)), new Tuple(Rotation.CLOCKWISE_180, new BlockPos(8, -1, 12)));
    private static final IGenerator FAT_TOWER_GENERATOR = new IGenerator()
    {
        public void init()
        {
        }
        public boolean generate(TemplateManager p_191086_1_, int p_191086_2_, StructureEndCityPieces.CityTemplateMy p_191086_3_, BlockPos p_191086_4_, List<StructureComponent> p_191086_5_, Random p_191086_6_)
        {
            Rotation rotation = p_191086_3_.placeSettings.getRotation();
            StructureEndCityPieces.CityTemplateMy structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, p_191086_3_, new BlockPos(-3, 4, -3), "fat_tower_base", rotation, true));
            structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(0, 4, 0), "fat_tower_middle", rotation, true));

            for (int i = 0; i < 2 && p_191086_6_.nextInt(3) != 0; ++i)
            {
                structureendcitypieces$citytemplate = addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(0, 8, 0), "fat_tower_middle", rotation, true));

                for (Tuple<Rotation, BlockPos> tuple : FAT_TOWER_BRIDGES)
                {
                    if (p_191086_6_.nextBoolean())
                    {
                        StructureEndCityPieces.CityTemplateMy structureendcitypieces$citytemplate1 = addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, tuple.getSecond(), "bridge_end", rotation.add(tuple.getFirst()), true));
                        recursiveChildren(p_191086_1_, TOWER_BRIDGE_GENERATOR, p_191086_2_ + 1, structureendcitypieces$citytemplate1, (BlockPos)null, p_191086_5_, p_191086_6_);
                    }
                }
            }

            addHelper(p_191086_5_, addPiece(p_191086_1_, structureendcitypieces$citytemplate, new BlockPos(-2, 8, -2), "fat_tower_top", rotation, true));
            return true;
        }
    };

    public static void registerPieces()
    {
        MapGenStructureIO.registerStructureComponent(StructureEndCityPieces.CityTemplateMy.class, "ECPxx");
    }

    private static CityTemplateMy addPiece(TemplateManager p_191090_0_, CityTemplateMy p_191090_1_, BlockPos p_191090_2_, String p_191090_3_, Rotation p_191090_4_, boolean owerwrite)
    {
        CityTemplateMy structureendcitypieces$citytemplate = new CityTemplateMy(p_191090_0_, p_191090_3_, p_191090_1_.templatePosition, p_191090_4_, owerwrite);
        BlockPos blockpos = p_191090_1_.template.calculateConnectedPos(p_191090_1_.placeSettings, p_191090_2_, structureendcitypieces$citytemplate.placeSettings, BlockPos.ORIGIN);
        structureendcitypieces$citytemplate.offset(blockpos.getX(), blockpos.getY(), blockpos.getZ());
        return structureendcitypieces$citytemplate;
    }

    public static void startHouseTower(TemplateManager p_191087_0_, BlockPos p_191087_1_, Rotation p_191087_2_, List<StructureComponent> p_191087_3_, Random p_191087_4_)
    {
//        FAT_TOWER_GENERATOR.init();
//        HOUSE_TOWER_GENERATOR.init();
//        TOWER_BRIDGE_GENERATOR.init();
//        TOWER_GENERATOR.init();
int i =0;
        for (Rotation rotation : Rotation.values()) {


           addHelper(p_191087_3_, new StructureEndCityPieces.CityTemplateMy(p_191087_0_, "gelou1", p_191087_1_.add(0,0,0), rotation, false));
           addHelper(p_191087_3_, new StructureEndCityPieces.CityTemplateMy(p_191087_0_, "gelou0", p_191087_1_.add(0,32,0), rotation, false));

            i++;
        }


//        recursiveChildren(p_191087_0_, TOWER_GENEwRATOR, 1, structureendcitypieces$citytemplate, (BlockPos)null, p_191087_3_, p_191087_4_);
    }

    private static CityTemplateMy addHelper(List<StructureComponent> p_189935_0_, CityTemplateMy p_189935_1_)
    {
        p_189935_0_.add(p_189935_1_);
        return p_189935_1_;
    }

    private static boolean recursiveChildren(TemplateManager p_191088_0_, IGenerator p_191088_1_, int p_191088_2_, CityTemplateMy p_191088_3_, BlockPos p_191088_4_, List<StructureComponent> p_191088_5_, Random p_191088_6_)
    {
        if (p_191088_2_ > 8)
        {
            return false;
        }
        else
        {
            List<StructureComponent> list = Lists.<StructureComponent>newArrayList();

            if (p_191088_1_.generate(p_191088_0_, p_191088_2_, p_191088_3_, p_191088_4_, list, p_191088_6_))
            {
                boolean flag = false;
                int i = p_191088_6_.nextInt();

                for (StructureComponent structurecomponent : list)
                {
                    ((CityTemplateMy)structurecomponent).componentType = i;
                    StructureComponent structurecomponent1 = StructureComponent.findIntersecting(p_191088_5_, structurecomponent.getBoundingBox());

                    if (structurecomponent1 != null && ((CityTemplateMy)structurecomponent).componentType != p_191088_3_.componentType)
                    {
                        flag = true;
                        break;
                    }
                }

                if (!flag)
                {
                    p_191088_5_.addAll(list);
                    return true;
                }
            }

            return false;
        }
    }

    public static class CityTemplateMy extends StructureComponent
    {
        private String pieceName;
        private Rotation rotation;
        private boolean overwrite;
        protected PlacementSettings placeSettings;

        protected int componentType;
        protected BlockPos templatePosition;
        protected Template template;



        private static final PlacementSettings DEFAULT_PLACE_SETTINGS = new PlacementSettings();

        public boolean addComponentParts(World world, Random p_74875_2_, StructureBoundingBox p_74875_3_) {
            this.placeSettings.setBoundingBox(p_74875_3_);
            this.template.addBlocksToWorld(world, this.templatePosition, this.placeSettings, 18);

            if(this.placeSettings.getRotation() ==Rotation.NONE && this.pieceName.equals("gelou1")){
//                return true;

                world.setBlockState(this.templatePosition, Blocks.CHEST.getStateFromMeta(0), 3);
                TileEntity tileentity = world.getTileEntity(this.templatePosition);

                if (tileentity instanceof TileEntityChest)
                {
                    ((TileEntityChest)tileentity).setLootTable(GUFENGXIAOWU_CHESTS_MODI_ZUIHOU, world.rand.nextLong());
                }

                final BlockPos posfinal1 = this.templatePosition.add(0,4,0);
                final BlockPos posfinal2 = this.templatePosition.add(0,20,0);
                final BlockPos posfinal3 = this.templatePosition.add(0,36,0);
                final BlockPos posfinal4 = this.templatePosition.add(0,48,0);

                world.setBlockState(posfinal1, Blocks.CHEST.getStateFromMeta(0), 3);
                TileEntity tileentity1 = world.getTileEntity(posfinal1);

                if (tileentity1 instanceof TileEntityChest)
                {
                    ((TileEntityChest)tileentity1).setLootTable(GUFENGXIAOWU_CHESTS_MODI, world.rand.nextLong());
                }

                world.setBlockState(posfinal2, Blocks.CHEST.getStateFromMeta(0), 3);
                TileEntity tileentity2 = world.getTileEntity(posfinal2);

                if (tileentity2 instanceof TileEntityChest)
                {
                    ((TileEntityChest)tileentity2).setLootTable(GUFENGXIAOWU_CHESTS_MODI, world.rand.nextLong());
                }

                world.setBlockState(posfinal3, Blocks.CHEST.getStateFromMeta(0), 3);
                TileEntity tileentity3 = world.getTileEntity(posfinal3);

                if (tileentity3 instanceof TileEntityChest)
                {
                    ((TileEntityChest)tileentity3).setLootTable(GUFENGXIAOWU_CHESTS_MODI, world.rand.nextLong());
                }

                world.setBlockState(posfinal4, Blocks.CHEST.getStateFromMeta(0), 3);
                TileEntity tileentity4 = world.getTileEntity(posfinal4);

                if (tileentity4 instanceof TileEntityChest)
                {
                    ((TileEntityChest)tileentity4).setLootTable(GUFENGXIAOWU_CHESTS_MODI, world.rand.nextLong());
                }

            }
/*




            Map<BlockPos, String> lvt_4_1_ = this.template.getDataBlocks(this.templatePosition, this.placeSettings);
            Iterator var5 = lvt_4_1_.entrySet().iterator();

            while(var5.hasNext()) {
                Map.Entry<BlockPos, String> lvt_6_1_ = (Map.Entry)var5.next();
                String lvt_7_1_ = (String)lvt_6_1_.getValue();
                this.handleDataMarker(lvt_7_1_, (BlockPos)lvt_6_1_.getKey(), world, p_74875_2_, p_74875_3_);
            }
*/

            return true;
        }





        public CityTemplateMy()
        {
            this.placeSettings = DEFAULT_PLACE_SETTINGS.setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
        }

        public CityTemplateMy(TemplateManager p_i47214_1_, String p_i47214_2_, BlockPos p_i47214_3_, Rotation p_i47214_4_, boolean overwriteIn)
        {
            super(0);
            this.pieceName = p_i47214_2_;
            this.templatePosition = p_i47214_3_;
            this.rotation = p_i47214_4_;
            this.overwrite = overwriteIn;
            this.loadTemplate(p_i47214_1_);
//            this.placeSettings = DEFAULT_PLACE_SETTINGS.setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
        }

        private void loadTemplate(TemplateManager p_191085_1_)
        {
            Template template = p_191085_1_.getTemplate((MinecraftServer)null, new ResourceLocation("shanhaicontinent","huasstr/" + this.pieceName));
            PlacementSettings placementsettings = (this.overwrite ? OVERWRITE : INSERT).copy().setRotation(this.rotation);
            this.placeSettings = placementsettings;
            this.setup(template, this.templatePosition, placementsettings);
        }




        protected void setup(Template p_186173_1_, BlockPos p_186173_2_, PlacementSettings p_186173_3_) {
            this.template = p_186173_1_;
            this.setCoordBaseMode(EnumFacing.NORTH);
            this.templatePosition = p_186173_2_;
            this.placeSettings = p_186173_3_;
            this.setBoundingBoxFromTemplate();
        }

        private void setBoundingBoxFromTemplate() {
            Rotation lvt_1_1_ = this.placeSettings.getRotation();
            BlockPos lvt_2_1_ = this.template.transformedSize(lvt_1_1_);
            Mirror lvt_3_1_ = this.placeSettings.getMirror();
            this.boundingBox = new StructureBoundingBox(0, 0, 0, lvt_2_1_.getX(), lvt_2_1_.getY() - 1, lvt_2_1_.getZ());
            switch (lvt_1_1_) {
                case NONE:
                default:
                    break;
                case CLOCKWISE_90:
                    this.boundingBox.offset(-lvt_2_1_.getX(), 0, 0);
                    break;
                case COUNTERCLOCKWISE_90:
                    this.boundingBox.offset(0, 0, -lvt_2_1_.getZ());
                    break;
                case CLOCKWISE_180:
                    this.boundingBox.offset(-lvt_2_1_.getX(), 0, -lvt_2_1_.getZ());
            }

            BlockPos lvt_4_2_;
            switch (lvt_3_1_) {
                case NONE:
                default:
                    break;
                case FRONT_BACK:
                    lvt_4_2_ = BlockPos.ORIGIN;
                    if (lvt_1_1_ != Rotation.CLOCKWISE_90 && lvt_1_1_ != Rotation.COUNTERCLOCKWISE_90) {
                        if (lvt_1_1_ == Rotation.CLOCKWISE_180) {
                            lvt_4_2_ = lvt_4_2_.offset(EnumFacing.EAST, lvt_2_1_.getX());
                        } else {
                            lvt_4_2_ = lvt_4_2_.offset(EnumFacing.WEST, lvt_2_1_.getX());
                        }
                    } else {
                        lvt_4_2_ = lvt_4_2_.offset(lvt_1_1_.rotate(EnumFacing.WEST), lvt_2_1_.getZ());
                    }

                    this.boundingBox.offset(lvt_4_2_.getX(), 0, lvt_4_2_.getZ());
                    break;
                case LEFT_RIGHT:
                    lvt_4_2_ = BlockPos.ORIGIN;
                    if (lvt_1_1_ != Rotation.CLOCKWISE_90 && lvt_1_1_ != Rotation.COUNTERCLOCKWISE_90) {
                        if (lvt_1_1_ == Rotation.CLOCKWISE_180) {
                            lvt_4_2_ = lvt_4_2_.offset(EnumFacing.SOUTH, lvt_2_1_.getZ());
                        } else {
                            lvt_4_2_ = lvt_4_2_.offset(EnumFacing.NORTH, lvt_2_1_.getZ());
                        }
                    } else {
                        lvt_4_2_ = lvt_4_2_.offset(lvt_1_1_.rotate(EnumFacing.NORTH), lvt_2_1_.getX());
                    }

                    this.boundingBox.offset(lvt_4_2_.getX(), 0, lvt_4_2_.getZ());
            }

            this.boundingBox.offset(this.templatePosition.getX(), this.templatePosition.getY(), this.templatePosition.getZ());
        }

        public void offset(int p_181138_1_, int p_181138_2_, int p_181138_3_) {
            super.offset(p_181138_1_, p_181138_2_, p_181138_3_);
            this.templatePosition = this.templatePosition.add(p_181138_1_, p_181138_2_, p_181138_3_);
        }






        protected void writeStructureToNBT(NBTTagCompound tagCompound)
        {
            tagCompound.setInteger("TPX", this.templatePosition.getX());
            tagCompound.setInteger("TPY", this.templatePosition.getY());
            tagCompound.setInteger("TPZ", this.templatePosition.getZ());

            tagCompound.setString("Template", this.pieceName);
            tagCompound.setString("Rot", this.rotation.name());
            tagCompound.setBoolean("OW", this.overwrite);
        }

        protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager p_143011_2_)
        {
            this.templatePosition = new BlockPos(tagCompound.getInteger("TPX"), tagCompound.getInteger("TPY"), tagCompound.getInteger("TPZ"));


            this.pieceName = tagCompound.getString("Template");
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.overwrite = tagCompound.getBoolean("OW");
            this.loadTemplate(p_143011_2_);
        }

        protected void handleDataMarker(String function, BlockPos pos, World worldIn, Random rand, StructureBoundingBox sbb)
        {
            if (function.startsWith("Chest"))
            {
                BlockPos blockpos = pos.down();

                if (sbb.isVecInside(blockpos))
                {
                    TileEntity tileentity = worldIn.getTileEntity(blockpos);

                    if (tileentity instanceof TileEntityChest)
                    {
                        ((TileEntityChest)tileentity).setLootTable(LootTableList.CHESTS_END_CITY_TREASURE, rand.nextLong());
                    }
                }
            }
            else if (function.startsWith("Sentry"))
            {
                EntityShulker entityshulker = new EntityShulker(worldIn);
                entityshulker.setPosition((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D);
                entityshulker.setAttachmentPos(pos);
                worldIn.spawnEntity(entityshulker);
            }
            else if (function.startsWith("Elytra"))
            {
                EntityItemFrame entityitemframe = new EntityItemFrame(worldIn, pos, this.rotation.rotate(EnumFacing.SOUTH));
                entityitemframe.setDisplayedItem(new ItemStack(Items.ELYTRA));
                worldIn.spawnEntity(entityitemframe);
            }
        }
    }

    interface IGenerator
    {
        void init();

        boolean generate(TemplateManager p_191086_1_, int p_191086_2_, CityTemplateMy p_191086_3_, BlockPos p_191086_4_, List<StructureComponent> p_191086_5_, Random p_191086_6_);
    }
}
