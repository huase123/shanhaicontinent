package hua.huase.shanhaicontinent.functiontypes;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import hua.huase.shanhaicontinent.init.SHRegistries;
import hua.huase.shanhaicontinent.item.SHEyeitem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;

/**
 * - @description:FunctionTypeInit类注册功能类型，会适用用于武魂，魂环，魂技
 * - @author: huase。
 * - @date: 2025/10/12 6:20
 */
public class FunctionTypeInit {

    public static final IForgeRegistry<FunctionType> FUNCTION_TYPE_Registry = RegistryManager.ACTIVE.getRegistry(SHRegistries.FUNCTION_TYPE_Resourcekey);
    public static final DeferredRegister<FunctionType> FUNCTION = DeferredRegister.create(FUNCTION_TYPE_Registry, SHMainBus.MOD_ID);
/**
 * TODO 功能描述：    强攻系、控制系、敏攻系、辅助系、食物系、防御系
 * @author :huase
 * @date 2025/10/12 6:25
 */
    public static final RegistryObject<FunctionType> strongattack = FUNCTION.register("strongattack", () -> new FunctionType());
    public static final RegistryObject<FunctionType> control = FUNCTION.register("control", () -> new FunctionType());
    public static final RegistryObject<FunctionType> sensitiveAttack = FUNCTION.register("sensitiveattack", () -> new FunctionType());
    public static final RegistryObject<FunctionType> assistance = FUNCTION.register("assistance", () -> new FunctionType());
    public static final RegistryObject<FunctionType> food = FUNCTION.register("food", () -> new FunctionType());
    public static final RegistryObject<FunctionType> defense = FUNCTION.register("defense", () -> new FunctionType());
    public static void register(IEventBus eventBus) {
        FUNCTION.register(eventBus);
    }

}
