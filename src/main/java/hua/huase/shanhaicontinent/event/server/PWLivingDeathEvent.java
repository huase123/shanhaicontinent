package hua.huase.shanhaicontinent.event.server;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capability.itemattribute.ItemAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttrubuteAPI;
import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.capabilitys.capability.MosterCapability;
import hua.huase.shanhaicontinent.entity.hunhuan.HunhuanEntity;
import hua.huase.shanhaicontinent.entity.mob.hunmin.HunminEntity;
import hua.huase.shanhaicontinent.init.EntityInit;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import static hua.huase.shanhaicontinent.SHMainBus.random;
import static hua.huase.shanhaicontinent.init.ItemInit.HUNGULIST;
import static hua.huase.shanhaicontinent.init.ItemInit.SEEDLIST;

@Mod.EventBusSubscriber(modid = SHMainBus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PWLivingDeathEvent {
    @SubscribeEvent
    public static void livingDeathEvent(LivingDeathEvent event){
        LivingEntity entity = event.getEntity();
        if(entity == null || entity.level().isClientSide)return;

        Entity entity1 = event.getSource().getEntity();
        if(entity1 instanceof Player player){
            entity.getCapability(RegisterCapabilitys.MOSTERCAPABILITY).ifPresent(capability -> {
                addHunhuanEntity(capability,entity.level(),entity.getOnPos());
                addItemSeed(entity,player);
                addHungu(entity,capability.getNianxian());
            });
        }


    }

    private static void addHungu(LivingEntity entity, int nianxian) {

        if(random.nextInt(16) != 0)return;

        Item item = HUNGULIST.get(random.nextInt(7)).get();
        ItemStack itemStack = new ItemStack(item);
        itemStack.getCapability(ItemAttributeCapabilityProvider.CAPABILITY).ifPresent(capability1 -> {
            capability1.toUpdateNianxian(nianxian);

            CompoundTag tag = itemStack.getOrCreateTag();
            tag.put("shanhaiitematuble",capability1.serializeNBT());

            ItemEntity itemEntity = entity.spawnAtLocation(itemStack);
            if (itemEntity != null) {
                itemEntity.setExtendedLifetime();
            }
        });

    }

    private static void addItemSeed(LivingEntity entity, Player player) {
        if(entity instanceof HunminEntity)return;

        if(random.nextInt(20)==0){
            float dengji = PlayerAttrubuteAPI.getDengji(player)/10;
            ItemEntity itemEntity = entity.spawnAtLocation(SEEDLIST.get((int) Math.min(dengji, 8)).get());
            if (itemEntity != null) {
                itemEntity.setExtendedLifetime();
            }
            return;
        }

        if(random.nextInt(10)==0){

            ItemEntity itemEntity = entity.spawnAtLocation(SEEDLIST.get(random.nextInt(4) + 9).get());
            if (itemEntity != null) {
                itemEntity.setExtendedLifetime();
            }
        }

    }

    public static void  addHunhuanEntity(@NotNull MosterCapability capability, Level level, BlockPos onPos){

        HunhuanEntity hunhuanEntity = new HunhuanEntity(EntityInit.HUNHUAN.get(), level);
        hunhuanEntity.getCapability(RegisterCapabilitys.MOSTERCAPABILITY).ifPresent(capability1 -> {
            capability1.deserializeNBT(capability.serializeNBT());
            hunhuanEntity.setPos(onPos.getCenter().add(0,1,0));
            level.addFreshEntity(hunhuanEntity);
        });
    }

}
