package hua.huase.shanhaicontinent.WorldGen;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderEnd;

public class MyWorldProviderSurface extends WorldProviderEnd {
    public DimensionType getDimensionType()
    {
        return DimensionType.OVERWORLD;
    }
}
