package hua.huase.shanhaicontinent.event;

import hua.huase.shanhaicontinent.api.HuitEventApi;
import hua.huase.shanhaicontinent.capability.MonsterCapability;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.client.particles.ParticlesHander;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler.MONSTER_CAPABILITY;
import static hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler.PLYAER_CAPABILITY;

@Mod.EventBusSubscriber
public class HurtEvent {

    //伤害检测
    @SubscribeEvent
    public static void onLivingHurt(LivingDamageEvent event) {

        DamageSource source = event.getSource();
        EntityLivingBase entityLiving = event.getEntityLiving();

        if(source.getTrueSource()==null){
            if(entityLiving.getCapability(PLYAER_CAPABILITY,null)!=null){
                PlayerCapability capability = entityLiving.getCapability(PLYAER_CAPABILITY, null);
                event.setAmount(HuitEventApi.otherHuitPlayer(capability,event.getAmount()));
                displayerDamage(entityLiving,event.getAmount());
                return;
            }

            if(entityLiving.getCapability(MONSTER_CAPABILITY,null)!=null){
                MonsterCapability capability = entityLiving.getCapability(MONSTER_CAPABILITY, null);
                event.setAmount(HuitEventApi.otherHuitMon(capability,event.getAmount()));
                displayerDamage(entityLiving,event.getAmount());
                return;
            }
            displayerDamage(entityLiving,event.getAmount());
            return;

        }

        if(source.getTrueSource()!=null){
            Entity trueSource = source.getTrueSource();

            entityLiving.hurtResistantTime=entityLiving.maxHurtResistantTime-4;
            if(trueSource.getCapability(MONSTER_CAPABILITY,null)!=null){
                if(entityLiving.getCapability(PLYAER_CAPABILITY,null)!=null){
                        MonsterCapability monsterCapability = trueSource.getCapability(MONSTER_CAPABILITY, null);
                        PlayerCapability playerCapability = entityLiving.getCapability(PLYAER_CAPABILITY, null);
                        event.setAmount(HuitEventApi.monHuitPlayer(monsterCapability,playerCapability, event.getAmount(), (EntityLivingBase) trueSource));
                    displayerDamage(entityLiving,event.getAmount());
                        return;
                }

                if(entityLiving.getCapability(MONSTER_CAPABILITY,null)!=null){
                    MonsterCapability monsterCapability0 = trueSource.getCapability(MONSTER_CAPABILITY, null);
                    MonsterCapability monsterCapability1 = entityLiving.getCapability(MONSTER_CAPABILITY, null);
                    event.setAmount(HuitEventApi.monHuitmon(monsterCapability0,monsterCapability1, event.getAmount(), (EntityLivingBase) trueSource));
                    displayerDamage(entityLiving,event.getAmount());
                    return;
                }

                MonsterCapability monsterCapability = trueSource.getCapability(MONSTER_CAPABILITY, null);
                event.setAmount(HuitEventApi.monHuitOther(monsterCapability,event.getAmount(),(EntityLivingBase) trueSource));
                displayerDamage(entityLiving,event.getAmount());
                return;
            }
            if(trueSource.getCapability(PLYAER_CAPABILITY,null)!=null){
                if(entityLiving.getCapability(PLYAER_CAPABILITY,null)!=null){
                        PlayerCapability playerCapability0 = trueSource.getCapability(PLYAER_CAPABILITY, null);
                        PlayerCapability playerCapability1 = entityLiving.getCapability(PLYAER_CAPABILITY, null);
                        event.setAmount(HuitEventApi.playerHuitPlayer(playerCapability0,playerCapability1, event.getAmount(), (EntityLivingBase) trueSource));
                    displayerDamage(entityLiving,event.getAmount());
                        return;
                }

                if(entityLiving.getCapability(MONSTER_CAPABILITY,null)!=null){
                    PlayerCapability playerCapability = trueSource.getCapability(PLYAER_CAPABILITY, null);
                    MonsterCapability monsterCapability = entityLiving.getCapability(MONSTER_CAPABILITY, null);
                    event.setAmount(HuitEventApi.playerHuitMon(playerCapability,monsterCapability, event.getAmount(), (EntityLivingBase) trueSource));
                    displayerDamage(entityLiving,event.getAmount());
                    return;
                }

                PlayerCapability playerCapability = trueSource.getCapability(PLYAER_CAPABILITY, null);
                event.setAmount(HuitEventApi.playerHuitOther(playerCapability,event.getAmount(),(EntityLivingBase) trueSource));
                displayerDamage(entityLiving,event.getAmount());
                return;
            }

            displayerDamage(entityLiving,event.getAmount());


        }

    }


    public static void displayerDamage  (EntityLivingBase target, float amount )
    {

        if(target==null)return;



        double x = target.posX;
        double y = target.posY;
        double z = target.posZ;


        if(amount>=0 && !target.world.isRemote){
            if(target.world==null)return;
            WorldServer mc = (WorldServer) target.world;
                mc.addScheduledTask(() ->
                {

//                    PacketHandler.INSTANCE.sendToAllTracking(new PacketHeartDisplay((int) amount, (int) x, (int) y, (int) z),new NetworkRegistry.TargetPoint(target.dimension,x,y,z,30));

//                    mc.spawnParticle(enumparticletypes, flag1, d0, d1, d2, i, d3, d4, d5, d6, aint);
                   mc.spawnParticle(ParticlesHander.parTicleCritNum,  x, y, z, 1, 1.0, 0, 0, 0D,  (int) amount, 0);
//                    Minecraft.getMinecraft().world.spawnParticle(ParticlesHander.parTicleCritNum, true, 1, 1, 1, 1, 1, 1, (int) x, (int) y, (int) z, (int) amount, 0);

                });
        }

    }


}
