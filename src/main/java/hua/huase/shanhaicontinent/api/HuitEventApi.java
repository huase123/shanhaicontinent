package hua.huase.shanhaicontinent.api;

import hua.huase.shanhaicontinent.capability.MonsterCapability;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import net.minecraft.entity.EntityLivingBase;

import java.util.Random;

public interface HuitEventApi {

    Random random=new Random();
    public static float otherHuitPlayer(PlayerCapability capability,float amount){
        float v1 = Math.max(capability.getShanbi(), 0f) / (Math.max(capability.getShanbi(), 0f) + 100f);
        if((float)random.nextInt(100)/100f<=v1){
            return 0f;
        }
        return amount*(1f-capability.getWufang()/(capability.getWufang()+500f));
    }
    public static float otherHuitMon(MonsterCapability capability, float amount){
        float v1 = Math.max(capability.getShanbi(), 0f) / (Math.max(capability.getShanbi(), 0f) + 100f);
        if((float)random.nextInt(100)/100f<=v1){
            return 0f;
        }
        return amount*(1f-capability.getWufang()/(capability.getWufang()+500f));
    }

    public static float playerHuitOther(PlayerCapability capability,float amount,EntityLivingBase entityLiving){

        boolean b = random.nextInt(100) <= capability.getBaojilv();
        float v = b? (amount+capability.getWugong()+capability.getZhenshang()) * Math.max((capability.getBaojishanghai()+100f)/100f,1f):amount+capability.getWugong()+capability.getZhenshang();
        if(!entityLiving.isDead)
        entityLiving.setHealth(capability.getXixue()/(capability.getXixue()+100)*v+entityLiving.getHealth());

        return v;
    }
    public static float monHuitOther(MonsterCapability capability, float amount,EntityLivingBase entityLiving){
        boolean b = random.nextInt(100) <= capability.getBaojilv();
        float v = b? (amount+capability.getWugong()+capability.getZhenshang()) * Math.max((capability.getBaojishanghai()+100f)/100f,1f):amount+capability.getWugong()+capability.getZhenshang();
        if(!entityLiving.isDead)
        entityLiving.setHealth(capability.getXixue()/(capability.getXixue()+100)*v+entityLiving.getHealth());
        return v;
    }




    public static float monHuitPlayer(MonsterCapability capability0, PlayerCapability capability1, float amount, EntityLivingBase entityLiving){
        float v1 = Math.max(capability1.getShanbi() - capability0.getMinghzong(), 0f) / (Math.max(capability1.getShanbi() - capability0.getMinghzong(), 0f) + 100f);
        if((float)random.nextInt(100)/100f<=v1){
            return 0f;
        }
        boolean b = random.nextInt(100) <= capability0.getBaojilv();
        float jianshang =1f- Math.max(capability1.getWufang() - capability0.getWuchuan(), 0f)/(Math.max(capability1.getWufang() - capability0.getWuchuan(), 0f)+500f);
        float v = b? (capability0.getWugong()*jianshang + capability0.getZhenshang()+amount*jianshang) * Math.max((capability0.getBaojishanghai()-capability1.getKangbao()+100f)/100f,1f):(capability0.getWugong()*jianshang + capability0.getZhenshang()+amount);
        if(!entityLiving.isDead)
        entityLiving.setHealth(capability0.getXixue()/(capability0.getXixue()+100)*v+entityLiving.getHealth());
        return v;
    }
    public static float monHuitmon(MonsterCapability capability0,MonsterCapability capability1, float amount, EntityLivingBase entityLiving){
        float v1 = Math.max(capability1.getShanbi() - capability0.getMinghzong(), 0f) / (Math.max(capability1.getShanbi() - capability0.getMinghzong(), 0f) + 100f);
        if((float)random.nextInt(100)/100f<=v1){
            return 0f;
        }
        boolean b = random.nextInt(100) <= capability0.getBaojilv();
        float jianshang =1- Math.max(capability1.getWufang() - capability0.getWuchuan(), 0f)/(Math.max(capability1.getWufang() - capability0.getWuchuan(), 0f)+500f);
        float v = b? (capability0.getWugong()*jianshang + capability0.getZhenshang()+amount*jianshang) * Math.max((capability0.getBaojishanghai()-capability1.getKangbao()+100f)/100f,1f):(capability0.getWugong()*jianshang + capability0.getZhenshang()+amount);
        if(!entityLiving.isDead)
        entityLiving.setHealth(capability0.getXixue()/(capability0.getXixue()+100)*v+entityLiving.getHealth());
        return v;
    }
    public static float playerHuitPlayer(PlayerCapability capability0,PlayerCapability capability1,float amount, EntityLivingBase entityLiving){
        float v1 = Math.max(capability1.getShanbi() - capability0.getMinghzong(), 0f) / (Math.max(capability1.getShanbi() - capability0.getMinghzong(), 0f) + 100f);
        if((float)random.nextInt(100)/100f<=v1){
            return 0f;
        }
        boolean b = random.nextInt(100) <= capability0.getBaojilv();
        float jianshang =1- Math.max(capability1.getWufang() - capability0.getWuchuan(), 0f)/(Math.max(capability1.getWufang() - capability0.getWuchuan(), 0f)+500f);
        float v = b? (capability0.getWugong()*jianshang + capability0.getZhenshang()+amount*jianshang) * Math.max((capability0.getBaojishanghai()-capability1.getKangbao()+100f)/100f,1f):(capability0.getWugong()*jianshang + capability0.getZhenshang()+amount);
        if(!entityLiving.isDead)
        entityLiving.setHealth(capability0.getXixue()/(capability0.getXixue()+100)*v+entityLiving.getHealth());
        return v;
    }
    public static float playerHuitMon(PlayerCapability capability0,MonsterCapability capability1, float amount, EntityLivingBase entityLiving){
        float v1 = Math.max(capability1.getShanbi() - capability0.getMinghzong(), 0f) / (Math.max(capability1.getShanbi() - capability0.getMinghzong(), 0f) + 100f);
        if((float)random.nextInt(100)/100f<=v1){
            return 0f;
        }

        boolean b = random.nextInt(100) <= capability0.getBaojilv();
        float jianshang =1- Math.max(capability1.getWufang() - capability0.getWuchuan(), 0f)/(Math.max(capability1.getWufang() - capability0.getWuchuan(), 0f)+500f);
        float v = b? (capability0.getWugong()*jianshang + capability0.getZhenshang()+amount*jianshang) * Math.max((capability0.getBaojishanghai()-capability1.getKangbao()+100f)/100f,1f):(capability0.getWugong()*jianshang + capability0.getZhenshang()+amount);
        if(!entityLiving.isDead)
        entityLiving.setHealth(capability0.getXixue()/(capability0.getXixue()+100)*v+entityLiving.getHealth());

        return v;
    }
}
