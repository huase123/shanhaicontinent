package hua.huase.shanhaicontinent.event.server;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capabilitys.CapabilityUtil;
import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.capabilitys.capability.AttributeBase;
import hua.huase.shanhaicontinent.capabilitys.capability.MosterCapability;
import hua.huase.shanhaicontinent.capabilitys.capability.Update;
import hua.huase.shanhaicontinent.item.Hunhuan;
import hua.huase.shanhaicontinent.item.Hunji;
import hua.huase.shanhaicontinent.network.NetworkHandler;
import hua.huase.shanhaicontinent.network.SynsAPI;
import hua.huase.shanhaicontinent.network.client.CPacketCapability;
import hua.huase.shanhaicontinent.network.client.CPacketHunji;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemStackHandler;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PWLivingTickEvent {

    @SubscribeEvent
    public static void onLivingTickEvent(LivingEvent.LivingTickEvent event){
        livngUseHunji(event);
        capabilitySyns(event);
    }

    private static void capabilitySyns(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
//        服务端同步至客户端
        if(event.getEntity()!=null &&!event.getEntity().level().isClientSide && entity.isAlive()){
            AttributeBase capability = CapabilityUtil.getCapability(entity);
            if(capability instanceof Update update && update.isIsupdate()){
                    update.setIsupdate(false);
                    SynsAPI.synsCapability(entity,capability);
            }
        }
//        客户端同步至服务端
        if(event.getEntity()!=null &&event.getEntity().level().isClientSide && entity.isAlive()){
            AttributeBase capability = CapabilityUtil.getCapability(entity);
            if(capability instanceof Update update && update.isIsupdate()){
                update.setIsupdate(false);
                NetworkHandler.INSTANCE.sendToServer(new CPacketCapability(event.getEntity().getId()));
            }
        }
    }

    private static void livngUseHunji(LivingEvent.LivingTickEvent event) {
        if(event.getEntity()!=null &&!event.getEntity().level().isClientSide){
            AttributeBase capability = CapabilityUtil.getCapability(event.getEntity());
            if(capability instanceof MosterCapability mosterCapability){
                ItemStackHandler hunhuanlist = mosterCapability.getHunhuan();
                for (int i = 0; i <hunhuanlist.getSlots(); i++) {
                    ItemStack hunhuanitemstack = hunhuanlist.getStackInSlot(i);
                    if(!hunhuanitemstack.isEmpty() && hunhuanitemstack.getItem()instanceof Hunhuan hunhuan){
                        hunhuanitemstack.getCapability(RegisterCapabilitys.HUNHUANCAPABILITY).ifPresent(hunhuanCapability -> {
                            ItemStackHandler hunjilist = hunhuanCapability.getHunji();
                            for (int j = 0; j < hunjilist.getSlots(); j++) {
                                ItemStack hunjiitemstack = hunjilist.getStackInSlot(j);
                                if(!hunjiitemstack.isEmpty() && hunjiitemstack.getItem() instanceof Hunji hunji){
                                    hunji.monsterHoldTick(event.getEntity(),mosterCapability,hunhuanitemstack,hunhuanCapability,hunjiitemstack);
                                }
                            }
                        });
                    }
                }

            }
        }
    }
}
