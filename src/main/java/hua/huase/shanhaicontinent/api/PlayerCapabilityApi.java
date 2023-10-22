package hua.huase.shanhaicontinent.api;

import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.network.NetworkRegistryHandler;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Random;

public interface PlayerCapabilityApi {

    public static boolean isXishouHunhuan(EntityPlayer player){
        PlayerCapability capability = player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
        if((capability.getDengji()+1)%10==0&&capability.getJingyan()>=capability.getMaxjingyan()){
            return  true;
        }

        return false;
    }
    public static Boolean   tuPo(EntityPlayer player){
        PlayerCapability capability = player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
        int maxjingyan = capability.getMaxjingyan();
        int jingyan = capability.getJingyan();
        int dengji = capability.getDengji();
        if(jingyan>=maxjingyan&&(dengji+1)%10!=0&&dengji<=109){
            capability.setDengji(dengji+1);
            capability.setJingyan(0);
            capability.setMaxjingyan((int) (maxjingyan+maxjingyan*0.1));
            capability.addWugong(dengji*1);
            capability.addMaxshengming(dengji*10);
            capability.addWufang(dengji);
            capability.addWuchuan(dengji);
            capability.addMaxjingshenli(dengji*dengji);

            for (int i = 0; i < Math.round(dengji/5)+1; i++) {

                switch (new Random().nextInt(13)){

                    case 0:
                        capability.addBaojishanghai(2);
                        break;
                    case 1:
                        capability.addBaojilv(1);
                        break;
                    case 2:
                        capability.addZhenshang(2);
                        break;
                    case 3:
                        capability.addXixue(1);
                        break;
                    case 4:
                        capability.addShengminghuifu(1);
                        break;
                    case 5:
                        capability.addMinghzong(1);
                        break;
                    case 6:
                        capability.addShanbi(1);
                        break;
                    case 7:
                        capability.addKangbao(1);
                        break;

                }

            }
            NetworkRegistryHandler.PlayerListen.sendClientCustomPacket(player);
            return true;
        }
        return false;
    }
}
