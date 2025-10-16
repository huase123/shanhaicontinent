package hua.huase.shanhaicontinent.capability;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capability.itemattribute.ItemAttributeCapability;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapability;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterCapabilityAPI;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapability;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.entity.hunhuan.HunhuanEntityEntity;
import hua.huase.shanhaicontinent.item.ItemAttribute;
import hua.huase.shanhaicontinent.network.SynsAPI;
import hua.huase.shanhaicontinent.network.server.SPacketEntityAttribute;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class CapabilityRegistryHandler{

    public static void registerCaps(RegisterCapabilitiesEvent event) {
        event.register(PlayerAttributeCapability.class);
        event.register(MonsterAttributeCapability.class);
        event.register(ItemAttributeCapability.class);
    }
    @Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class RegisterCapabilitys{
        @SubscribeEvent
        public static void registerCaps(RegisterCapabilitiesEvent event) {
            event.register(PlayerAttributeCapability.class);
            event.register(MonsterAttributeCapability.class);
            event.register(ItemAttributeCapability.class);
        }

        //    实体增加Capabilities事件
        @SubscribeEvent
        public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event)
        {
            if (event.getObject() instanceof Player)
            {
                PlayerAttributeCapabilityProvider playerAttributeCapabilityProvider = new PlayerAttributeCapabilityProvider();
                event.addCapability(new ResourceLocation(SHMainBus.MOD_ID,"player_attribute"), playerAttributeCapabilityProvider);
            }
            if (event.getObject() instanceof Mob || event.getObject() instanceof HunhuanEntityEntity)
            {
                MonsterAttributeCapabilityProvider monsterAttributeCapabilityProvider = new MonsterAttributeCapabilityProvider<>();
                event.addCapability(new ResourceLocation(SHMainBus.MOD_ID,"monster_attribute"), monsterAttributeCapabilityProvider);
            }

        }

        //    实体增加Capabilities事件
        @SubscribeEvent
        public static void onAttachItemCapabilities(AttachCapabilitiesEvent<ItemStack> event)
        {
            if (event.getObject().getItem() instanceof ItemAttribute itemAttribute)
            {
                event.addCapability(new ResourceLocation(SHMainBus.MOD_ID,"item_attribute"), itemAttribute.creatItemAttribute());
            }

        }

        @SubscribeEvent
        public static void onEntityJoin(EntityJoinLevelEvent event){
            Entity entity = event.getEntity();
            if(entity==null)return;
// 魂环属性
            if(entity instanceof HunhuanEntityEntity hunhuan){
                hunhuanJoin(hunhuan);
            }

//修改怪属性
            if (entity instanceof Mob monsterentity )
            {
                monsterJoin(monsterentity);
            }
//修改玩家属性
            if (entity instanceof ServerPlayer serverPlayerEntity)
            {
                serverplayerJoin(serverPlayerEntity);
            }

        }

        public static void serverplayerJoin(ServerPlayer serverPlayerEntity){

            LazyOptional<PlayerAttributeCapability> capability = serverPlayerEntity.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY);
            capability.ifPresent(playerCapability -> {
                float maxshengming = playerCapability.getMaxshengming();
                serverPlayerEntity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(maxshengming);
                SynsAPI.synsPlayerAttribute(serverPlayerEntity);
            });

        }
        public static void monsterJoin(Mob entity){

            if(!entity.level().isClientSide){
                LazyOptional<MonsterAttributeCapability> capability = entity.getCapability(MonsterAttributeCapabilityProvider.CAPABILITY);
                capability.ifPresent(playerCapability -> {
                    if(playerCapability.getNianxian()==0){
                        MonsterAttributeCapability monsterAttributeCapability = MonsterCapabilityAPI.genMonsterCapability(entity);
                        playerCapability.deserializeNBT(monsterAttributeCapability.serializeNBT());
                        float maxshengming = playerCapability.getMaxshengming();
                        entity.getAttribute(Attributes.MAX_HEALTH).setBaseValue(maxshengming);
                        entity.setHealth(maxshengming);


                    }

                    if(entity.getCustomName() == null){
                        int nianxian = playerCapability.getNianxian();
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

                    SynsAPI.synsEntityAttribute(entity);

                });
            }else {
                CompoundTag compoundTag = SPacketEntityAttribute.monsterHashMapCapability.get(entity.getId());
                if(compoundTag!=null){
                    entity.getCapability(MonsterAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
                        capability.deserializeNBT(compoundTag);
                    });

//                    SPacketEntityAttribute.monsterHashMapCapability.remove(entity.getId());
                }
            }
        }
        public static void hunhuanJoin(HunhuanEntityEntity entity){

            if(!entity.level().isClientSide){
                LazyOptional<MonsterAttributeCapability> capability = entity.getCapability(MonsterAttributeCapabilityProvider.CAPABILITY);
                capability.ifPresent(monsterentity -> {
                    SynsAPI.synsEntityAttribute(entity);

                });
            }else {
                CompoundTag compoundTag = SPacketEntityAttribute.monsterHashMapCapability.get(entity.getId());
                if(compoundTag!=null){
                    entity.getCapability(MonsterAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
                        capability.deserializeNBT(compoundTag);

                        SPacketEntityAttribute.monsterHashMapCapability.remove(entity.getId());
                    });
                }
            }
        }


//
//    玩家生成事件
        @SubscribeEvent
        public static void onPlayerClone(PlayerEvent.Clone event)
        {
            event.getOriginal().reviveCaps();
            event.getOriginal().getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(oriState->{
                event.getEntity().getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(newState ->{
                    newState.deserializeNBT(oriState.serializeNBT());
                });
            });
            event.getOriginal().invalidateCaps();



//            if(event.isWasDeath()){
//            }


        }



    }
}
