package hua.huase.shanhaicontinent.entity.mob.hunmin;

import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttrubuteAPI;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

import static hua.huase.shanhaicontinent.item.ItemInit.DANFANGLIST;
import static hua.huase.shanhaicontinent.item.ItemInit.DANYAOLIST;

public class HunminEntity extends ZombieVillager {
    public HunminEntity(EntityType<? extends ZombieVillager> p_34368_, Level p_34369_) {
        super(p_34368_, p_34369_);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, (double)0.43F).add(Attributes.ATTACK_DAMAGE, 8.0D).add(Attributes.ARMOR, 9.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }


    protected void dropAllDeathLoot(DamageSource p_28536_) {
        super.dropAllDeathLoot(p_28536_);

        this.dropitem(p_28536_);

    }

    private void dropitem(DamageSource damageSource) {
        if(random.nextInt(20)==0) {
            Entity entity = damageSource.getEntity();
            if(entity !=null && entity instanceof Player player){
                if(random.nextInt(5)==0) {
                    dropitem(DANFANGLIST.get(DANFANGLIST.size()-1-random.nextInt(7)).get());
                    return;
                }
                if(random.nextInt(10)==0) {
                    dropitem(DANFANGLIST.get(0).get());
                    return;
                }
                float dengji = PlayerAttrubuteAPI.getDengji(player);
                RegistryObject<Item> itemRegistryObject = DANFANGLIST.get(Math.min((int) (dengji/10f + 1), DANFANGLIST.size() - 1));
                this.dropitem(itemRegistryObject.get());
                return;
            }
        }

        if(random.nextInt(5)==0) {
            this.getCapability(MonsterAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
                double log = Math.log10(capability.getNianxian() + 1);
                RegistryObject<Item> itemRegistryObject = DANYAOLIST.get(Math.min((int) log, DANFANGLIST.size() - 1));
                dropitem(itemRegistryObject.get());
            });
        }
    }

    private void dropitem(Item netherStar) {

        ItemEntity itementity = this.spawnAtLocation(netherStar);
        if (itementity != null) {
            itementity.setExtendedLifetime();
        }
    }

}
