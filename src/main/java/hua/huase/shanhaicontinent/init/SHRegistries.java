package hua.huase.shanhaicontinent.init;

import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * - @description:SHRegistries类
 * - @author: huase。
 * - @date: 2025/10/12 6:08
 */
public class SHRegistries {

    public static final ResourceKey<Registry<FunctionType>> FUNCTION_TYPE_Resourcekey = createRegistryKey("function_type");

    private static <T> ResourceKey<Registry<T>> createRegistryKey(String pName) {
        return ResourceKey.createRegistryKey(new ResourceLocation(pName));
    }
/**
 * TODO 功能描述：利用反射添加自定义注册表FunctionType
 * @author :huase
 * @date 2025/10/14 11:17
 */
    public static void Init() {


        RegistryBuilder<FunctionType> functionTypeRegistryBuilder = new RegistryBuilder<FunctionType>().setName(FUNCTION_TYPE_Resourcekey.location()).setMaxID(1000);


        // 1. 获取Class对象
        Class<?> clazz = null;
        try {
            clazz = functionTypeRegistryBuilder.getClass();
            Method createMethod = clazz.getDeclaredMethod("create");
            createMethod.setAccessible(true);
            Object result = createMethod.invoke(functionTypeRegistryBuilder);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        // 2. 获取私有方法（假设无参数）

        // 3. 设置可访问性

        // 4.1 如果是实例方法需要先创建实例


//        new ForgeRegistry<FunctionType>(RegistryManager.ACTIVE, FUNCTION_TYPE_Resourcekey, new RegistryBuilder<>());
    }
}
