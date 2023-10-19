package hua.huase.shanhaicontinent.WorldGen.structureal;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TemplateHander {
    public static void register() {

        GameRegistry.registerWorldGenerator(new OreGeneration(), 100);
        GameRegistry.registerWorldGenerator(new StructurealOne(),200);
        GameRegistry.registerWorldGenerator(new StructurealTow(),300);
        GameRegistry.registerWorldGenerator(new StructurealThree(),400);

    }
}
