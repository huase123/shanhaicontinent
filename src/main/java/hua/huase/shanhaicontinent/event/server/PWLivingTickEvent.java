package hua.huase.shanhaicontinent.event.server;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.item.Hunhuan;
import hua.huase.shanhaicontinent.item.Hunji;
import hua.huase.shanhaicontinent.network.SynsAPI;
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
        if(event.getEntity()!=null &&!event.getEntity().level().isClientSide){
            event.getEntity().getCapability(RegisterCapabilitys.MOSTERCAPABILITY).ifPresent(mosterCapability->{
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
            });
        }
    }
}
