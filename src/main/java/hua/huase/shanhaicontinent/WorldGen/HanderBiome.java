package hua.huase.shanhaicontinent.WorldGen;

import hua.huase.shanhaicontinent.WorldGen.Biome.BiomeZDY;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;

import static hua.huase.shanhaicontinent.handers.HanderAny.soulsoil;

@Mod.EventBusSubscriber
public class HanderBiome {



    //注册群系
//    @SubscribeEvent
    public static void registryBioms(RegistryEvent.Register<Biome> event){
        Biome.BiomeProperties properties = new Biome.BiomeProperties("zdy_BIOME");
        properties.setBaseHeight(-5.0f).setHeightVariation(0.0f).setWaterColor(0x99ffffff);
        Biome biome = new BiomeZDY(properties);
        biome.setRegistryName("new biome");
        biome.topBlock= soulsoil.getStateFromMeta(0);
        biome.fillerBlock= soulsoil.getStateFromMeta(7);
        BiomeManager.addSpawnBiome(biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM,new BiomeManager.BiomeEntry(biome,9999));


        event.getRegistry().register(biome);

        BiomeDictionary.addTypes(biome, BiomeDictionary.Type.COLD);
    }






    public static int dimID = 21;
    public static DimensionType myDim;

    public static void registerDimension() {
        // 第一个参数代表此维度的内部名称。
        // 第二个参数是村庄等数据保存时会用到的“当前维度的专有后缀名”。
        // 第三个参数是维度 ID。维度 ID 是基于 Minecraft 1.12.2 的 Forge Mod 开发中
        // 仍然需要手动指定数字 ID 的游戏内容，也因此几乎所有的 Modder 都会允许通过配置文件
        // 修改维度 ID。
        // 第四个参数是该维度使用的 WorldProvider 的类。要求这个类有零参构造器。
        // 第五个参数代表“是否保持该维度的 spawn 区块一直加载”。
        myDim = DimensionType.register("my_dimension", "_my_dim", dimID, MyWorldProvider.class, false);
        // 在拿到自己的维度的 myDimType 后，需要再向 Forge 告知这一新的 DimensionType 的存在，
        // 否则某些 Forge 加入的功能会无法在你的新维度中工作。
        // 第一个参数仍然是维度 ID，和上面保持一致即可。
        DimensionManager.registerDimension(dimID, myDim);
    }


}
