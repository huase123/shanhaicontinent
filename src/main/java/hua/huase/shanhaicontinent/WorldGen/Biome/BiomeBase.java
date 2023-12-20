package hua.huase.shanhaicontinent.WorldGen.Biome;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeBase extends Biome {

    protected final BiomeBase.Type type;

    public BiomeBase(BiomeProperties properties,BiomeBase.Type type) {
        super(properties);
        this.type = type;
    }

    public static enum Type
    {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX;
    }

    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos)
    {
        switch (this.type){
            case ONE:
                return getModdedBiomeGrassColor(0xffffff);
            case TWO:
                return getModdedBiomeGrassColor(0xffff00);
            case THREE:
                return getModdedBiomeGrassColor(0xee5efb);
            case FOUR:
                return getModdedBiomeGrassColor(0x2f1222);
            case FIVE:
                return getModdedBiomeGrassColor(0xf72828);
            case SIX:
                return getModdedBiomeGrassColor(0xffff66);

            default:
                return getModdedBiomeGrassColor(0x000000);
        }
    }


    public int getWaterColorMultiplier()
    {
        switch (this.type){
            case ONE:
                return getModdedBiomeGrassColor(0xffffff);
            case TWO:
                return getModdedBiomeGrassColor(0xffff00);
            case THREE:
                return getModdedBiomeGrassColor(0xee5efb);
            case FOUR:
                return getModdedBiomeGrassColor(0x2f1222);
            case FIVE:
                return getModdedBiomeGrassColor(0xf72828);
            case SIX:
                return getModdedBiomeGrassColor(0xffff66);

            default:
                return getModdedBiomeGrassColor(0x000000);
        }
    }


    public int getModdedBiomeFoliageColor(int original)
    {
        switch (this.type){
            case ONE:
                return getModdedBiomeGrassColor(0xffffff);
            case TWO:
                return getModdedBiomeGrassColor(0xffff00);
            case THREE:
                return getModdedBiomeGrassColor(0xee5efb);
            case FOUR:
                return getModdedBiomeGrassColor(0x2f1222);
            case FIVE:
                return getModdedBiomeGrassColor(0xf72828);
            case SIX:
                return getModdedBiomeGrassColor(0xffff66);

            default:
                return getModdedBiomeGrassColor(0x000000);
        }
    }



}
