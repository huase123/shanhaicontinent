package hua.huase.shanhaicontinent.init;

import hua.huase.shanhaicontinent.animation.SHAnimationController;
import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegistryBuilder;


/**
 * - @description:SHRegistries类添加自定义注册表
 * - @author: huase。
 * - @date: 2025/10/12 6:08
 */
public class SHRegistries {
/**
 * TODO 功能描述：创建注册表使用
 * @author :huase
 * @date 2025/11/10 9:44
 */
    public static final ResourceKey<Registry<FunctionType>> FUNCTION_TYPE_Resourcekey = createRegistryKey("function_type");
    public static final ResourceKey<Registry<SHAnimationController>> SHAnimationController = createRegistryKey("shanimationcontroller");

/**
 * TODO 功能描述：注册表查询使用
 * @author :huase
 * @date 2025/11/10 9:45
 */
    public static  IForgeRegistry<FunctionType> FUNCTION_TYPE_IForgeRegistry;
    public static  IForgeRegistry<SHAnimationController> shAnimationControllers__IForgeRegistry;
    private static <T> ResourceKey<Registry<T>> createRegistryKey(String pName) {
        return ResourceKey.createRegistryKey(new ResourceLocation(pName));
    }
    public static void registerNewRegistry(NewRegistryEvent event) {
//        未知原因这种方式获取的查询表为空集，改用一下方式获取
//        FUNCTION_TYPE_IForgeRegistry = event.create(new RegistryBuilder<FunctionType>().setName(FUNCTION_TYPE_Resourcekey.location()).setMaxID(1000)).get();
        event.create(new RegistryBuilder<FunctionType>().setName(FUNCTION_TYPE_Resourcekey.location()).setMaxID(1000), functionTypes -> FUNCTION_TYPE_IForgeRegistry = functionTypes);
        event.create(new RegistryBuilder<SHAnimationController>().setName(SHAnimationController.location()).setMaxID(1000), functionTypes -> shAnimationControllers__IForgeRegistry = functionTypes);
    }
}
