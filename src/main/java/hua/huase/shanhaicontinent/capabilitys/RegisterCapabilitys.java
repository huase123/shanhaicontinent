package hua.huase.shanhaicontinent.capabilitys;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capabilitys.capability.*;
import hua.huase.shanhaicontinent.entity.hunhuan.HunhuanEntityEntity;
import hua.huase.shanhaicontinent.item.Hunhuan;
import hua.huase.shanhaicontinent.item.Hunji;
import hua.huase.shanhaicontinent.item.Wuhun;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
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
        if (event.getObject() instanceof Player player) {
            event.addCapability(new ResourceLocation(SHMainBus.MOD_ID, "playercapability"),
                    new SHCapabilityProvider(new PlayerCapability(player))
            );
        }
        if (event.getObject() instanceof Mob || event.getObject() instanceof HunhuanEntityEntity) {
            event.addCapability(new ResourceLocation(SHMainBus.MOD_ID, "mostercapability"),
                    new SHCapabilityProvider(new MosterCapability(event.getObject()))
            );
        }

    }

    //    实体增加Capabilities事件
    @SubscribeEvent
    public static void onAttachItemCapabilities(AttachCapabilitiesEvent<ItemStack> event)
    {
        if (event.getObject().getItem() instanceof Wuhun) {
            event.addCapability(new ResourceLocation(SHMainBus.MOD_ID, "wuhunitme"),
                    new SHCapabilityProvider(new WuhunCapability())
            );
        }
        if (event.getObject().getItem() instanceof Hunhuan) {
            event.addCapability(new ResourceLocation(SHMainBus.MOD_ID, "hunhuanitem"),
                    new SHCapabilityProvider(new HunhuanCapability())
            );
        }
        if (event.getObject().getItem() instanceof Hunji) {
            event.addCapability(new ResourceLocation(SHMainBus.MOD_ID, "hunjiitem"),
                    new SHCapabilityProvider(new HunjiCapability())
            );
        }

    }

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event){
        Entity entity = event.getEntity();
        if(entity==null)return;
//修改怪属性
        if (entity instanceof LivingEntity livingEntity)
        {
            monsterJoin(livingEntity);
        }
        if (entity instanceof ServerPlayer serverPlayer)
        {
            CapabilityUtil.synsMaxhealth(serverPlayer,CapabilityUtil.getCapability(serverPlayer));
        }

    }

    public static void monsterJoin(LivingEntity livingEntity){

        if(!livingEntity.level().isClientSide){
            AttributeBase capability1 = CapabilityUtil.getCapability(livingEntity);
            if(capability1 !=null && capability1 instanceof MosterCapability mosterCapability){
                if(mosterCapability.getNianxian() ==0){
                    CapabilityUtil.genMonsterCapability(livingEntity,mosterCapability);
                }

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
