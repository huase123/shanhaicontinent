package hua.huase.shanhaicontinent.functiontypes;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.functiontypes.functiontype.*;
import hua.huase.shanhaicontinent.init.SHRegistries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.*;

/**
 * - @description:FunctionTypeInit类注册功能类型，会适用用于武魂，魂环，魂技
 * - @author: huase。
 * - @date: 2025/10/12 6:20
 */
public class FunctionTypeInit {

    public static final DeferredRegister<FunctionType> FUNCTION = DeferredRegister.create(SHRegistries.FUNCTION_TYPE_Resourcekey, SHMainBus.MOD_ID);
    /**
 * TODO 功能描述：    兽魂，器魂，植物，控制，治疗，防御，强攻，寒冰，火焰，雷电，
 * @author :huase
 * @date 2025/10/12 6:25
 */
    public static final RegistryObject<FunctionType> empty= FUNCTION.register("empty", () -> new FunctionType());

    public static final RegistryObject<FunctionType> shouhun = FUNCTION.register("shouhun", () -> new ShouhunType());
    public static final RegistryObject<FunctionType> qihun = FUNCTION.register("qihun", () -> new QihunType());
    public static final RegistryObject<FunctionType> zhiwu = FUNCTION.register("zhiwu", () -> new ZhiwuType());
    public static final RegistryObject<FunctionType> kongzhi = FUNCTION.register("kongzhi", () -> new KongzhiType());
    public static final RegistryObject<FunctionType> zhiliao = FUNCTION.register("zhiliao", () -> new ZiliaoType());
    public static final RegistryObject<FunctionType> fangyv = FUNCTION.register("fangyv", () -> new FangyvType());
    public static final RegistryObject<FunctionType> qianggong = FUNCTION.register("qianggong", () -> new QianggongType());
    public static final RegistryObject<FunctionType> hanbing = FUNCTION.register("hanbing", () -> new HanbingType());
    public static final RegistryObject<FunctionType> huoyan = FUNCTION.register("huoyan", () -> new HuoyanType());
    public static final RegistryObject<FunctionType> leidian = FUNCTION.register("leidian", () -> new LeidianType());
    public static final RegistryObject<FunctionType> defense = FUNCTION.register("defense", () -> new FunctionType());

}
