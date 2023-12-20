package hua.huase.shanhaicontinent.WorldGen;

import hua.huase.shanhaicontinent.WorldGen.Biome.*;
import hua.huase.shanhaicontinent.WorldGen.structureal.MapGenEndCityMy;
import hua.huase.shanhaicontinent.WorldGen.structureal.StructureEndCityPieces;
import hua.huase.shanhaicontinent.WorldGen.worldprovider.*;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class HanderBiome {
    public static List<Biome> biomeslist =new ArrayList<>();

    public static Biome biomeSHPlanins_ONE =new BiomeSHPlanins(BiomeSHPlanins.Type.ONE,"shanhaicontinent_planins_one");
    public static Biome biomeSHPlanins_TWO =new BiomeSHPlanins(BiomeSHPlanins.Type.TWO,"shanhaicontinent_planins_two");
    public static Biome biomeSHPlanins_THREE =new BiomeSHPlanins(BiomeSHPlanins.Type.THREE,"shanhaicontinent_planins_three");
    public static Biome biomeSHPlanins_FOUR =new BiomeSHPlanins(BiomeSHPlanins.Type.FOUR,"shanhaicontinent_planins_four");
    public static Biome biomeSHPlanins_FIVE =new BiomeSHPlanins(BiomeSHPlanins.Type.FIVE,"shanhaicontinent_planins_five");
    public static Biome biomeSHPlanins_SIX =new BiomeSHPlanins(BiomeSHPlanins.Type.SIX,"shanhaicontinent_planins_six");
//    public static Biome biomeSHOcean =new BiomeSHOcean(BiomeSHOcean.Type.ONE,"ocean");
    public static Biome biomeSHOcean_ONE =new BiomeSHOcean(BiomeSHOcean.Type.ONE,"shanhaicontinent_ocean_one");
    public static Biome biomeSHOcean_TWO =new BiomeSHOcean(BiomeSHOcean.Type.TWO,"shanhaicontinent_ocean_two");
    public static Biome biomeSHOcean_THREE =new BiomeSHOcean(BiomeSHOcean.Type.THREE,"shanhaicontinent_ocean_three");
    public static Biome biomeSHOcean_FOUR =new BiomeSHOcean(BiomeSHOcean.Type.FOUR,"shanhaicontinent_ocean_four");
    public static Biome biomeSHOcean_FIVE =new BiomeSHOcean(BiomeSHOcean.Type.FIVE,"shanhaicontinent_ocean_five");
    public static Biome biomeSHOcean_SIX =new BiomeSHOcean(BiomeSHOcean.Type.SIX,"shanhaicontinent_ocean_six");
//    public static Biome biomeSHNether =new BiomeSHNether(BiomeSHNether.Type.ONE,"nether");
    public static Biome biomeSHNether_ONE =new BiomeSHNether(BiomeSHNether.Type.ONE,"shanhaicontinent_nether_one");
    public static Biome biomeSHNether_TWO =new BiomeSHNether(BiomeSHNether.Type.TWO,"shanhaicontinent_nether_two");
    public static Biome biomeSHNether_THREE =new BiomeSHNether(BiomeSHNether.Type.THREE,"shanhaicontinent_nether_three");
    public static Biome biomeSHNether_FOUR =new BiomeSHNether(BiomeSHNether.Type.FOUR,"shanhaicontinent_nether_four");
    public static Biome biomeSHNether_FIVE =new BiomeSHNether(BiomeSHNether.Type.FIVE,"shanhaicontinent_nether_five");
    public static Biome biomeSHNether_SIX =new BiomeSHNether(BiomeSHNether.Type.SIX,"shanhaicontinent_nether_six");
//    public static Biome biomeSHIce =new BiomeSHIce(BiomeSHIce.Type.ONE,"ice");
    public static Biome biomeSHIce_ONE =new BiomeSHIce(BiomeSHIce.Type.ONE,"shanhaicontinent_ice_one");
    public static Biome biomeSHIce_TWO =new BiomeSHIce(BiomeSHIce.Type.TWO,"shanhaicontinent_ice_two");
    public static Biome biomeSHIce_THREE =new BiomeSHIce(BiomeSHIce.Type.THREE,"shanhaicontinent_ice_three");
    public static Biome biomeSHIce_FOUR =new BiomeSHIce(BiomeSHIce.Type.FOUR,"shanhaicontinent_ice_four");
    public static Biome biomeSHIce_FIVE =new BiomeSHIce(BiomeSHIce.Type.FIVE,"shanhaicontinent_ice_five");
    public static Biome biomeSHIce_SIX =new BiomeSHIce(BiomeSHIce.Type.SIX,"shanhaicontinent_ice_six");
//    public static Biome biomeSHHills =new BiomeSHHills(BiomeSHHills.Type.ONE,"hills");
    public static Biome biomeSHHills_ONE =new BiomeSHHills(BiomeSHHills.Type.ONE,"shanhaicontinent_hills_one");
    public static Biome biomeSHHills_TWO =new BiomeSHHills(BiomeSHHills.Type.TWO,"shanhaicontinent_hills_two");
    public static Biome biomeSHHills_THREE =new BiomeSHHills(BiomeSHHills.Type.THREE,"shanhaicontinent_hills_three");
    public static Biome biomeSHHills_FOUR =new BiomeSHHills(BiomeSHHills.Type.FOUR,"shanhaicontinent_hills_four");
    public static Biome biomeSHHills_FIVE =new BiomeSHHills(BiomeSHHills.Type.FIVE,"shanhaicontinent_hills_five");
    public static Biome biomeSHHills_SIX =new BiomeSHHills(BiomeSHHills.Type.SIX,"shanhaicontinent_hills_six");

    //注册群系
    @SubscribeEvent
    public static void registryBioms(RegistryEvent.Register<Biome> event){


        event.getRegistry().registerAll(biomeslist.toArray(new Biome[0]));


//        BiomeManager.addSpawnBiome(biome);
//        BiomeManager.addBiome(BiomeManager.BiomeType.WARM,new BiomeManager.BiomeEntry(biome,9999));
//        BiomeDictionary.addTypes(biome, BiomeDictionary.Type.COLD);
    }






    public static int dimID = 21;
    public static int dimensionTypeSH_ONE_ID = 1212;
    public static int dimensionTypeSH_TWO_ID = 1213;
    public static int dimensionTypeSH_THREE_ID = 1214;
    public static int dimensionTypeSH_FOUR_ID = 1215;
    public static int dimensionTypeSH_FIVE_ID = 1216;
    public static int dimensionTypeSH_SIX_ID = 1217;
    public static DimensionType myDim;
    public static DimensionType dimensionTypeSH_ONE;
    public static DimensionType dimensionTypeSH_TWO;
    public static DimensionType dimensionTypeSH_THREE;
    public static DimensionType dimensionTypeSH_FOUR;
    public static DimensionType dimensionTypeSH_FIVE;
    public static DimensionType dimensionTypeSH_SIX;

    public static void registerDimension() {
        // 第一个参数代表此维度的内部名称。
        // 第二个参数是村庄等数据保存时会用到的“当前维度的专有后缀名”。
        // 第三个参数是维度 ID。维度 ID 是基于 Minecraft 1.12.2 的 Forge Mod 开发中
        // 仍然需要手动指定数字 ID 的游戏内容，也因此几乎所有的 Modder 都会允许通过配置文件
        // 修改维度 ID。
        // 第四个参数是该维度使用的 WorldProvider 的类。要求这个类有零参构造器。
        // 第五个参数代表“是否保持该维度的 spawn 区块一直加载”。
//        myDim = DimensionType.register("my_dimension", "_my_dim", dimID, MyWorldProvider.class, false);
        dimensionTypeSH_ONE = DimensionType.register("shanhaicontinent_"+dimensionTypeSH_ONE_ID, "_SH_"+dimensionTypeSH_ONE_ID, dimensionTypeSH_ONE_ID, WorldProviderONE.class, false);
        dimensionTypeSH_TWO = DimensionType.register("shanhaicontinent_"+dimensionTypeSH_TWO_ID, "_SH_"+dimensionTypeSH_TWO_ID, dimensionTypeSH_TWO_ID, WorldProviderTWO.class, false);
        dimensionTypeSH_THREE = DimensionType.register("shanhaicontinent_"+dimensionTypeSH_THREE_ID, "_SH_"+dimensionTypeSH_THREE_ID, dimensionTypeSH_THREE_ID, WorldProviderTHREE.class, false);
        dimensionTypeSH_FOUR = DimensionType.register("shanhaicontinent_"+dimensionTypeSH_FOUR_ID, "_SH_"+dimensionTypeSH_FOUR_ID, dimensionTypeSH_FOUR_ID, WorldProviderFOUR.class, false);
        dimensionTypeSH_FIVE = DimensionType.register("shanhaicontinent_"+dimensionTypeSH_FIVE_ID, "_SH_"+dimensionTypeSH_FIVE_ID, dimensionTypeSH_FIVE_ID, WorldProviderFIVE.class, false);
        dimensionTypeSH_SIX = DimensionType.register("shanhaicontinent_"+dimensionTypeSH_SIX_ID, "_SH_"+dimensionTypeSH_SIX_ID, dimensionTypeSH_SIX_ID, WorldProviderSIX.class, false);
        // 在拿到自己的维度的 myDimType 后，需要再向 Forge 告知这一新的 DimensionType 的存在，
        // 否则某些 Forge 加入的功能会无法在你的新维度中工作。
        // 第一个参数仍然是维度 ID，和上面保持一致即可。
//        DimensionManager.registerDimension(dimID, myDim);
        DimensionManager.registerDimension(dimensionTypeSH_ONE_ID, dimensionTypeSH_ONE);
        DimensionManager.registerDimension(dimensionTypeSH_TWO_ID, dimensionTypeSH_TWO);
        DimensionManager.registerDimension(dimensionTypeSH_THREE_ID, dimensionTypeSH_THREE);
        DimensionManager.registerDimension(dimensionTypeSH_FOUR_ID, dimensionTypeSH_FOUR);
        DimensionManager.registerDimension(dimensionTypeSH_FIVE_ID, dimensionTypeSH_FIVE);
        DimensionManager.registerDimension(dimensionTypeSH_SIX_ID, dimensionTypeSH_SIX);



        MapGenStructureIO.registerStructure(MapGenEndCityMy.Start.class, "ECPxx");
        StructureEndCityPieces.registerPieces();
    }


}
