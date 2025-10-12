package hua.huase.shanhaicontinent.init;

import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryManager;

/**
 * - @description:SHRegistries类
 * - @author: huase。
 * - @date: 2025/10/12 6:08
 */
public class SHRegistries {

    public static final ResourceKey<Registry<FunctionType>> FUNCTION_TYPE_Resourcekey = createRegistryKey("function_type");

    public static final IForgeRegistry<FunctionType> FUNCTION_TYPE_Registry = RegistryManager.ACTIVE.getRegistry(FUNCTION_TYPE_Resourcekey);
    private static <T> ResourceKey<Registry<T>> createRegistryKey(String pName) {
        return ResourceKey.createRegistryKey(new ResourceLocation(pName));
    }
}
