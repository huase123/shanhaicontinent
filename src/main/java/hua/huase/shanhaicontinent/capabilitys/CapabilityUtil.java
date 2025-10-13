package hua.huase.shanhaicontinent.capabilitys;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capabilitys.capability.AttributeBase;
import hua.huase.shanhaicontinent.capabilitys.capability.MosterCapability;
import hua.huase.shanhaicontinent.capabilitys.capability.PlayerCapability;
import hua.huase.shanhaicontinent.compat.sophisticatedbackpacks.SophisticatedbackpacksAPI;
import hua.huase.shanhaicontinent.compat.twilightforest.TwilightforestAPI;
import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import hua.huase.shanhaicontinent.init.ItemInit;
import hua.huase.shanhaicontinent.init.SHRegistries;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * - @description:CapabilityUtil类
 * - @author: huase。
 * - @date: 2025/10/12 9:03
 */
public class CapabilityUtil {

    public static boolean juexingWuhun(Player entity, @NotNull PlayerCapability capability){
        if(capability.isIsjuexing()){
            entity.sendSystemMessage(Component.translatable("你已觉醒了武魂，无需再觉醒").withStyle(ChatFormatting.GRAY));
            return false;
        }
        Item item = ItemInit.wuhunlist.get(entity.level().random.nextInt(ItemInit.wuhunlist.size()));
        ItemStack itemStack = new ItemStack(item);
        itemStack.getCapability(RegisterCapabilitys.WUHUNCAPABILITY).ifPresent(wuhunCapability -> {
            wuhunCapability.init(itemStack);
        });
        capability.juexinWUhun(entity,itemStack,entity.level().random.nextInt(100)+1);
        capability.setIsjuexing(true);
        return true;
    }
    public static void genMonsterCapability(Entity entity, @NotNull MosterCapability capability){
        RandomSource random = entity.level().random;
        int nianxian = getNianxian(entity,random);
        FunctionType functionType = getFunctionType(entity,random);

        MosterCapability mosterCapability = new MosterCapability();
        mosterCapability.inti(entity,nianxian,functionType);

        capability.deserializeNBT(mosterCapability.serializeNBT());
    }

    private static FunctionType getFunctionType(Entity entity, RandomSource random) {
        List<FunctionType> list = SHRegistries.FUNCTION_TYPE_Registry.getValues().stream().toList();
        return  list.get(random.nextInt(list.size()));
    }

    public static int getNianxian(Entity entity, RandomSource random){
        int index = 0;
        if(SHMainBus.twilightforest_compat){
            index = TwilightforestAPI.getNianxian(entity,random);
        } else if (true) {
            index = genLevel(entity,random);
        }
        return index;
    }

    public static int genLevel(Entity entity, RandomSource random){

        int index = 0;

        if(entity instanceof Mob && entity instanceof Enemy){
            ResourceKey<Level> dimension = entity.level().dimension();
            if(dimension == Level.OVERWORLD){
//                1,331
                int i = random.nextInt(3) + 1;
                index = random.nextInt((int) Math.pow(14,i));

            }else if(dimension == Level.NETHER){
//                160,000+100
                int i = random.nextInt(4) + 1;
                index = random.nextInt((int) Math.pow(20,i))+100;
            }else if(dimension == Level.END){
//             531,441+100
                int i = random.nextInt(6) + 1;
                index = Math.min(random.nextInt((int) Math.pow(9,i)),1000000)+100;
            }else {
//             531,441+100
                int i = SHMainBus.random.nextInt(6) + 1;
                index = Math.min(SHMainBus.random.nextInt((int) Math.pow(9,i)),1000000)+100;
            }


            if(((Mob) entity).getMaxHealth() >60){
                if(SHMainBus.twilightforest_compat){
                    index = SophisticatedbackpacksAPI.getNianxian(entity,random,index);
                }else {
                    index = (int) (1+1000000*Math.log10(((Mob) entity).getMaxHealth()));
                }
            }
        }else {
            index = random.nextInt(10+1);
        }
        return index;
    }

    public static void synsMaxhealth(Entity entity, AttributeBase capability) {
        if (entity instanceof LivingEntity livingEntity){
            float maxshengming = capability.getMaxshengming();
            if(livingEntity.getAttribute(Attributes.MAX_HEALTH).getValue() != maxshengming){
                livingEntity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(maxshengming);
                if(!(entity instanceof Player)){
                    livingEntity.setHealth(maxshengming);
                }
            }
        }
    }

    public static void synsCustomName(Entity entity, MosterCapability capability) {
        if(entity.getCustomName() == null){
            int nianxian = capability.getNianxian();
            if(nianxian>=1000000){
                entity.setCustomName(Component.translatable(entity.getDisplayName().getString()+"-----------"+"§4"+nianxian+"年"));
            }else if(nianxian>=100000){
                entity.setCustomName(Component.translatable(entity.getDisplayName().getString()+"-----------"+"§c"+nianxian+"年"));
            }else if(nianxian>=10000){
                entity.setCustomName(Component.translatable(entity.getDisplayName().getString()+"-----------"+"§0"+nianxian+"年"));
            }else if(nianxian>=1000){
                entity.setCustomName(Component.translatable(entity.getDisplayName().getString()+"-----------"+"§5"+nianxian+"年"));
            }else if(nianxian>=100){
                entity.setCustomName(Component.translatable(entity.getDisplayName().getString()+"-----------"+"§e"+nianxian+"年"));
            }else if(nianxian>=1){
                entity.setCustomName(Component.translatable(entity.getDisplayName().getString()+"-----------"+"§f"+nianxian+"年"));
            }
        }
    }

    public static AttributeBase getCapability(Entity entity) {
        if(entity == null)return null;
        if(entity instanceof Player)return entity.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).orElseThrow(RuntimeException::new);
        if(entity instanceof LivingEntity)return entity.getCapability(RegisterCapabilitys.MOSTERCAPABILITY).orElseThrow(RuntimeException::new);
        return null;

    }
}
