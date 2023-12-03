package hua.huase.shanhaicontinent.WorldGen;

import com.google.common.collect.Lists;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.structure.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class WoodlandMansionMy extends MapGenStructure {
    private final int featureSpacing = 80;
    private final int minFeatureSeparation = 20;
    public static final List<Biome> ALLOWED_BIOMES;
    private final UW_ChunkGeneratorGarden provider;

    public WoodlandMansionMy(UW_ChunkGeneratorGarden p_i47240_1_) {
        this.provider = p_i47240_1_;
    }

    public String getStructureName() {
        return "Mansion";
    }

    protected boolean canSpawnStructureAtCoords(int p_75047_1_, int p_75047_2_) {
        int lvt_3_1_ = p_75047_1_;
        int lvt_4_1_ = p_75047_2_;
        if (p_75047_1_ < 0) {
            lvt_3_1_ = p_75047_1_ - 79;
        }

        if (p_75047_2_ < 0) {
            lvt_4_1_ = p_75047_2_ - 79;
        }

        int lvt_5_1_ = lvt_3_1_ / 80;
        int lvt_6_1_ = lvt_4_1_ / 80;
        Random lvt_7_1_ = this.world.setRandomSeed(lvt_5_1_, lvt_6_1_, 10387319);
        lvt_5_1_ *= 80;
        lvt_6_1_ *= 80;
        lvt_5_1_ += (lvt_7_1_.nextInt(60) + lvt_7_1_.nextInt(60)) / 2;
        lvt_6_1_ += (lvt_7_1_.nextInt(60) + lvt_7_1_.nextInt(60)) / 2;
        if (p_75047_1_ == lvt_5_1_ && p_75047_2_ == lvt_6_1_) {
            boolean lvt_8_1_ = this.world.getBiomeProvider().areBiomesViable(p_75047_1_ * 16 + 8, p_75047_2_ * 16 + 8, 32, ALLOWED_BIOMES);
            if (lvt_8_1_) {
                return true;
            }
        }

        return false;
    }

    public BlockPos getNearestStructurePos(World p_180706_1_, BlockPos p_180706_2_, boolean p_180706_3_) {
        this.world = p_180706_1_;
        BiomeProvider lvt_4_1_ = p_180706_1_.getBiomeProvider();
        return lvt_4_1_.isFixedBiome() && lvt_4_1_.getFixedBiome() != Biomes.ROOFED_FOREST ? null : findNearestStructurePosBySpacing(p_180706_1_, this, p_180706_2_, 80, 20, 10387319, true, 100, p_180706_3_);
    }

    protected StructureStart getStructureStart(int p_75049_1_, int p_75049_2_) {
        return new WoodlandMansionMy.Start(this.world, this.provider, this.rand, p_75049_1_, p_75049_2_);
    }

    static {
        ALLOWED_BIOMES = Arrays.asList(Biomes.ROOFED_FOREST, Biomes.MUTATED_ROOFED_FOREST);
    }

    public static class Start extends StructureStart {
        private boolean isValid;

        public Start() {
        }

        public Start(World p_i47235_1_, UW_ChunkGeneratorGarden p_i47235_2_, Random p_i47235_3_, int p_i47235_4_, int p_i47235_5_) {
            super(p_i47235_4_, p_i47235_5_);
            this.create(p_i47235_1_, p_i47235_2_, p_i47235_3_, p_i47235_4_, p_i47235_5_);
        }

        private void create(World p_191092_1_, UW_ChunkGeneratorGarden p_191092_2_, Random p_191092_3_, int p_191092_4_, int p_191092_5_) {
            Rotation lvt_6_1_ = Rotation.values()[p_191092_3_.nextInt(Rotation.values().length)];
            ChunkPrimer lvt_7_1_ = new ChunkPrimer();
            p_191092_2_.setBlocksInChunk(p_191092_4_, p_191092_5_, lvt_7_1_);
            int lvt_8_1_ = 5;
            int lvt_9_1_ = 5;
            if (lvt_6_1_ == Rotation.CLOCKWISE_90) {
                lvt_8_1_ = -5;
            } else if (lvt_6_1_ == Rotation.CLOCKWISE_180) {
                lvt_8_1_ = -5;
                lvt_9_1_ = -5;
            } else if (lvt_6_1_ == Rotation.COUNTERCLOCKWISE_90) {
                lvt_9_1_ = -5;
            }

            int lvt_10_1_ = lvt_7_1_.findGroundBlockIdx(7, 7);
            int lvt_11_1_ = lvt_7_1_.findGroundBlockIdx(7, 7 + lvt_9_1_);
            int lvt_12_1_ = lvt_7_1_.findGroundBlockIdx(7 + lvt_8_1_, 7);
            int lvt_13_1_ = lvt_7_1_.findGroundBlockIdx(7 + lvt_8_1_, 7 + lvt_9_1_);
            int lvt_14_1_ = Math.min(Math.min(lvt_10_1_, lvt_11_1_), Math.min(lvt_12_1_, lvt_13_1_));
            if (lvt_14_1_ < 60) {
                this.isValid = false;
            } else {
                BlockPos lvt_15_1_ = new BlockPos(p_191092_4_ * 16 + 8, lvt_14_1_ + 1, p_191092_5_ * 16 + 8);
                List<WoodlandMansionPieces.MansionTemplate> lvt_16_1_ = Lists.newLinkedList();
                WoodlandMansionPieces.generateMansion(p_191092_1_.getSaveHandler().getStructureTemplateManager(), lvt_15_1_, lvt_6_1_, lvt_16_1_, p_191092_3_);
                this.components.addAll(lvt_16_1_);
                this.updateBoundingBox();
                this.isValid = true;
            }
        }

        public void generateStructure(World p_75068_1_, Random p_75068_2_, StructureBoundingBox p_75068_3_) {
            super.generateStructure(p_75068_1_, p_75068_2_, p_75068_3_);
            int lvt_4_1_ = this.boundingBox.minY;

            for(int lvt_5_1_ = p_75068_3_.minX; lvt_5_1_ <= p_75068_3_.maxX; ++lvt_5_1_) {
                for(int lvt_6_1_ = p_75068_3_.minZ; lvt_6_1_ <= p_75068_3_.maxZ; ++lvt_6_1_) {
                    BlockPos lvt_7_1_ = new BlockPos(lvt_5_1_, lvt_4_1_, lvt_6_1_);
                    if (!p_75068_1_.isAirBlock(lvt_7_1_) && this.boundingBox.isVecInside(lvt_7_1_)) {
                        boolean lvt_8_1_ = false;
                        Iterator var9 = this.components.iterator();

                        while(var9.hasNext()) {
                            StructureComponent lvt_10_1_ = (StructureComponent)var9.next();
                            if (lvt_10_1_.getBoundingBox().isVecInside(lvt_7_1_)) {
                                lvt_8_1_ = true;
                                break;
                            }
                        }

                        if (lvt_8_1_) {
                            for(int lvt_9_1_ = lvt_4_1_ - 1; lvt_9_1_ > 1; --lvt_9_1_) {
                                BlockPos lvt_10_2_ = new BlockPos(lvt_5_1_, lvt_9_1_, lvt_6_1_);
                                if (!p_75068_1_.isAirBlock(lvt_10_2_) && !p_75068_1_.getBlockState(lvt_10_2_).getMaterial().isLiquid()) {
                                    break;
                                }

                                p_75068_1_.setBlockState(lvt_10_2_, Blocks.COBBLESTONE.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }

        }

        public boolean isSizeableStructure() {
            return this.isValid;
        }
    }
}
