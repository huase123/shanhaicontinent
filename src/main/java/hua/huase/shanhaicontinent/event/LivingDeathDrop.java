package hua.huase.shanhaicontinent.event;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.capability.ItemCapabilityProvider;
import hua.huase.shanhaicontinent.capability.MonsterCapability;
import hua.huase.shanhaicontinent.entity.HunhuanEntity;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler.MONSTER_CAPABILITY;
import static hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler.random;

@Mod.EventBusSubscriber
public class LivingDeathDrop {

    @SubscribeEvent
    public static void onEntityStruckByLightning(LivingDeathEvent event){
        EntityLivingBase entityLiving = event.getEntityLiving();
        DamageSource damageSource = event.getSource();
        if(entityLiving instanceof IMob && entityLiving.getCapability(MONSTER_CAPABILITY,null)!=null&&!entityLiving.world.isRemote){
            int nianxian = entityLiving.getCapability(MONSTER_CAPABILITY, null).getNianxian();

            if ("player".equals(damageSource.getDamageType())) {

                MonsterCapability monsterCapability = entityLiving.getCapability(MONSTER_CAPABILITY, null);

                HunhuanEntity hunhuanEntity = new HunhuanEntity(entityLiving.world);
                hunhuanEntity.posX = entityLiving.posX;
                hunhuanEntity.posY = entityLiving.posY;
                hunhuanEntity.posZ = entityLiving.posZ;
                MonsterCapability monsterCapability1 = hunhuanEntity.getCapability(MONSTER_CAPABILITY, null);
                monsterCapability1.deserializeNBT(monsterCapability.serializeNBT());
                entityLiving.world.spawnEntity(hunhuanEntity);
                livingDrop(entityLiving,nianxian);
            }

//            PacketHandler.INSTANCE.sendToAllTracking(new PacketMonster(monsterCapability,hunhuanEntity.getEntityId()),hunhuanEntity);

        }



    }



    public static void livingDrop(EntityLivingBase entityLivingBase,int nianxian) {

        switch (random.nextInt(100)){
            case 0:
                entityLivingBase.entityDropItem(new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":exoskeletonbone")), 1, 0, new ItemCapabilityProvider(nianxian).serializeItemNBT()),0);
            break;
            case 1:
                entityLivingBase.entityDropItem(new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":headbone")), 1, 0, new ItemCapabilityProvider(nianxian).serializeItemNBT()),0);
            break;
            case 2:
                entityLivingBase.entityDropItem(new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":lefthandbone")), 1, 0, new ItemCapabilityProvider(nianxian).serializeItemNBT()),0);
            break;
            case 3:
                entityLivingBase.entityDropItem(new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":leftlegbone")), 1, 0, new ItemCapabilityProvider(nianxian).serializeItemNBT()),0);
            break;
            case 4:
                entityLivingBase.entityDropItem(new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":righthandbone")), 1, 0, new ItemCapabilityProvider(nianxian).serializeItemNBT()),0);
            break;
            case 5:
                entityLivingBase.entityDropItem(new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":rightlegbone")), 1, 0, new ItemCapabilityProvider(nianxian).serializeItemNBT()),0);
            break;
            case 6:
                entityLivingBase.entityDropItem(new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":trunkbone")), 1, 0, new ItemCapabilityProvider(nianxian).serializeItemNBT()),0);
            break;

        }
        if(nianxian>=1000000){
            entityLivingBase.entityDropItem(new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":hunye")), random.nextInt(10), 5),0);
        }else if(nianxian>=100000){
            entityLivingBase.entityDropItem(new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":hunye")), random.nextInt(10), 4),0);
        }else if(nianxian>=10000){
            entityLivingBase.entityDropItem(new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":hunye")), random.nextInt(10), 3),0);
        }else if(nianxian>=1000){
            entityLivingBase.entityDropItem(new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":hunye")), random.nextInt(10), 2),0);
        }else if(nianxian>=100){
            entityLivingBase.entityDropItem(new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":hunye")), random.nextInt(10), 1),0);
        }else if(nianxian>=1){
            entityLivingBase.entityDropItem(new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":hunye")), random.nextInt(10), 0),0);
        }



    }


}
