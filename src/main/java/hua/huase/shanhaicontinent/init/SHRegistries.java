package hua.huase.shanhaicontinent.init;

import hua.huase.shanhaicontinent.animation.SHAnimationController;
import hua.huase.shanhaicontinent.functiontypes.FunctionTypeInit;
import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryManager;

import java.util.function.Consumer;


/**
 * - @description:SHRegistries类
 * - @author: huase。
 * - @date: 2025/10/12 6:08
 */
public class SHRegistries {

    public static final ResourceKey<Registry<FunctionType>> FUNCTION_TYPE_Resourcekey = createRegistryKey("function_type");
    public static final ResourceKey<Registry<SHAnimationController>> SHAnimationController = createRegistryKey("shanimationcontroller");

    private static <T> ResourceKey<Registry<T>> createRegistryKey(String pName) {
        return ResourceKey.createRegistryKey(new ResourceLocation(pName));
    }
    public static void registerNewRegistry(NewRegistryEvent event) {
        RegistryBuilder<FunctionType> functionTypeRegistryBuilder = new RegistryBuilder<FunctionType>().setName(FUNCTION_TYPE_Resourcekey.location()).setMaxID(1000);
        RegistryBuilder<FunctionType> shanimationcontroller = new RegistryBuilder<FunctionType>().setName(SHAnimationController.location()).setMaxID(1000);
        event.create(functionTypeRegistryBuilder, functionTypes -> FunctionTypeInit.FUNCTION_TYPE_Registry = functionTypes);
        event.create(shanimationcontroller);
    }
}
