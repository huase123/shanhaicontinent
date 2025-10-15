package hua.huase.shanhaicontinent.capabilitys;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capabilitys.capability.*;
import hua.huase.shanhaicontinent.entity.NoHunhuan;
import hua.huase.shanhaicontinent.entity.hunhuan.HunhuanEntity;
import hua.huase.shanhaicontinent.item.Hunhuan;
import hua.huase.shanhaicontinent.item.Hunji;
import hua.huase.shanhaicontinent.item.Wuhun;
import hua.huase.shanhaicontinent.network.SynsAPI;
import hua.huase.shanhaicontinent.network.server.SPacketEntityAttribute;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.NonNullSupplier;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


//@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RegisterCapabilitys {

    public static Capability<HunhuanCapability> HUNHUANCAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});
    public static Capability<HunjiCapability> HUNJICAPABILITY = CapabilityManager.get(new CapabilityToken<>(){});
    public static Capability<MosterCapability> MOSTERCAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
    public static Capability<WuhunCapability> WUHUNCAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
    public static Capability<PlayerCapability> PLAYERCAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
    @SubscribeEvent
    public static void registerCaps(RegisterCapabilitiesEvent event) {
        event.register(HunhuanCapability.class);
        event.register(HunjiCapability.class);
        event.register(MosterCapability.class);
        event.register(WuhunCapability.class);
        event.register(PlayerCapability.class);
    }

    //    实体增加Capabilities事件
    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof Player) {
            event.addCapability(new ResourceLocation(SHMainBus.MOD_ID, "playercapability"),
                new ICapabilityProvider() {
                    private PlayerCapability capability =new PlayerCapability();
                    @Override
                    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
                        if(cap != PLAYERCAPABILITY) return LazyOptional.empty();
                        return LazyOptional.of((NonNullSupplier<Object>) () -> capability).cast();
                    }
                }
            );
        }
        if (event.getObject() instanceof Mob || event.getObject() instanceof HunhuanEntity) {
            event.addCapability(new ResourceLocation(SHMainBus.MOD_ID, "mostercapability"),
                    new ICapabilityProvider() {
                        private MosterCapability capability =new MosterCapability();
                        @Override
                        public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
                            if(cap != MOSTERCAPABILITY) return LazyOptional.empty();
                            return LazyOptional.of((NonNullSupplier<Object>) () -> capability).cast();
                        }
                    }
            );
        }

    }

    //    实体增加Capabilities事件
    @SubscribeEvent
    public static void onAttachItemCapabilities(AttachCapabilitiesEvent<ItemStack> event)
    {
        if (event.getObject().getItem() instanceof Wuhun) {
            event.addCapability(new ResourceLocation(SHMainBus.MOD_ID, "wuhunitme"),
                    new ItemICapabilityProvider(new WuhunCapability())
            );
        }
        if (event.getObject().getItem() instanceof Hunhuan) {
            event.addCapability(new ResourceLocation(SHMainBus.MOD_ID, "hunhuanitem"),
                    new ItemICapabilityProvider(new HunhuanCapability())
            );
        }
        if (event.getObject().getItem() instanceof Hunji) {
            event.addCapability(new ResourceLocation(SHMainBus.MOD_ID, "hunjiitem"),
                    new ItemICapabilityProvider(new HunjiCapability())
            );
        }

    }

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event){
        Entity entity = event.getEntity();
        if(entity==null)return;


//修改怪属性
        if (entity instanceof Mob  || entity instanceof HunhuanEntity)
        {
            monsterJoin(entity);
        }
//修改玩家属性
        if (entity instanceof ServerPlayer serverPlayerEntity)
        {
            serverplayerJoin(serverPlayerEntity);
        }

    }

    public static void serverplayerJoin(ServerPlayer serverPlayerEntity){
        serverPlayerEntity.getCapability(PLAYERCAPABILITY).ifPresent(playerCapability -> {
            SynsAPI.synsPlayerCapability(serverPlayerEntity,playerCapability);
        });
    }
    public static void monsterJoin(Entity entity){

        if(!entity.level().isClientSide){
            entity.getCapability(MOSTERCAPABILITY).ifPresent(capability ->{
                if(!(entity instanceof NoHunhuan)){
                    CapabilityUtil.genMonsterCapability(entity,capability);
                }
                SynsAPI.synsEntityCapability(entity,capability);
            });
        }else {
            CompoundTag compoundTag = SPacketEntityAttribute.monsterHashMapCapability.get(entity.getId());
            if(compoundTag!=null){
                entity.getCapability(MOSTERCAPABILITY).ifPresent(capability -> capability.deserializeNBT(compoundTag));
                SPacketEntityAttribute.monsterHashMapCapability.remove(entity.getId());
            }
        }
    }
//    玩家生成事件
    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event)
    {
        event.getOriginal().reviveCaps();
        event.getOriginal().getCapability(PLAYERCAPABILITY).ifPresent(oriState->{
            event.getEntity().getCapability(PLAYERCAPABILITY).ifPresent(newState ->{
                newState.deserializeNBT(oriState.serializeNBT());
            });
        });
        event.getOriginal().invalidateCaps();



//            if(event.isWasDeath()){
//            }


    }


}
