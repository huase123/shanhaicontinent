package hua.huase.shanhaicontinent.capability.api;

import hua.huase.shanhaicontinent.capability.DanyaoItemCapability;
import hua.huase.shanhaicontinent.capability.ItemCapability;
import hua.huase.shanhaicontinent.capability.MonsterCapability;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.network.NetworkRegistryHandler;
import net.minecraft.entity.player.EntityPlayer;

public interface ChangeCapability {
    public static void addDanyao(PlayerCapability playerCapability, DanyaoItemCapability danyaoItemCapability, EntityPlayer player){

        if(playerCapability!=null&&danyaoItemCapability!=null){
            playerCapability.setJingyan(playerCapability.getJingyan()+danyaoItemCapability.getJingyan());
            playerCapability.setWugong(playerCapability.getWugong()+danyaoItemCapability.getWugong());
            playerCapability.setBaojishanghai(playerCapability.getBaojishanghai()+danyaoItemCapability.getBaojishanghai());
            playerCapability.setBaojilv(playerCapability.getBaojilv()+danyaoItemCapability.getBaojilv());
            playerCapability.setZhenshang(playerCapability.getZhenshang()+danyaoItemCapability.getZhenshang());
            playerCapability.setXixue(playerCapability.getXixue()+danyaoItemCapability.getXixue());
            playerCapability.setWufang(playerCapability.getWufang()+danyaoItemCapability.getWufang());
            playerCapability.setMaxshengming(playerCapability.getMaxshengming()+danyaoItemCapability.getShengming());
            playerCapability.setShengminghuifu(playerCapability.getShengminghuifu()+danyaoItemCapability.getShengminghuifu());
            playerCapability.setMinghzong(playerCapability.getMinghzong()+danyaoItemCapability.getMinghzong());
            playerCapability.setShanbi(playerCapability.getShanbi()+danyaoItemCapability.getShanbi());
            playerCapability.setWuchuan(playerCapability.getWuchuan()+danyaoItemCapability.getWuchuan());
            playerCapability.setKangbao(playerCapability.getKangbao()+danyaoItemCapability.getKangbao());

            playerCapability.addMaxjingshenli(danyaoItemCapability.getJingshenli());

            NetworkRegistryHandler.PlayerListen.sendClientCustomPacket(player);
        }
    }
    public static void addItem(PlayerCapability playerCapability, ItemCapability danyaoItemCapability, EntityPlayer player){

        if(playerCapability!=null&&danyaoItemCapability!=null){
            playerCapability.setWugong(playerCapability.getWugong()+danyaoItemCapability.getWugong());
            playerCapability.setBaojishanghai(playerCapability.getBaojishanghai()+danyaoItemCapability.getBaojishanghai());
            playerCapability.setBaojilv(playerCapability.getBaojilv()+danyaoItemCapability.getBaojilv());
            playerCapability.setZhenshang(playerCapability.getZhenshang()+danyaoItemCapability.getZhenshang());
            playerCapability.setXixue(playerCapability.getXixue()+danyaoItemCapability.getXixue());
            playerCapability.setWufang(playerCapability.getWufang()+danyaoItemCapability.getWufang());
            playerCapability.setMaxshengming(playerCapability.getMaxshengming()+danyaoItemCapability.getMaxshengming());
            playerCapability.setShengminghuifu(playerCapability.getShengminghuifu()+danyaoItemCapability.getShengminghuifu());
            playerCapability.setMinghzong(playerCapability.getMinghzong()+danyaoItemCapability.getMinghzong());
            playerCapability.setShanbi(playerCapability.getShanbi()+danyaoItemCapability.getShanbi());
            playerCapability.setWuchuan(playerCapability.getWuchuan()+danyaoItemCapability.getWuchuan());
            playerCapability.setKangbao(playerCapability.getKangbao()+danyaoItemCapability.getKangbao());

            NetworkRegistryHandler.PlayerListen.sendClientCustomPacket(player);
        }
    }
    public static void addHunhuan(PlayerCapability playerCapability, MonsterCapability danyaoItemCapability, EntityPlayer player){

        if(playerCapability!=null&&danyaoItemCapability!=null){
            playerCapability.setWugong(playerCapability.getWugong()+danyaoItemCapability.getWugong()/10);
            playerCapability.setBaojishanghai(playerCapability.getBaojishanghai()+danyaoItemCapability.getBaojishanghai()/10);
            playerCapability.setBaojilv(playerCapability.getBaojilv()+danyaoItemCapability.getBaojilv()/10);
            playerCapability.setZhenshang(playerCapability.getZhenshang()+danyaoItemCapability.getZhenshang()/10);
            playerCapability.setXixue(playerCapability.getXixue()+danyaoItemCapability.getXixue()/10);
            playerCapability.setWufang(playerCapability.getWufang()+danyaoItemCapability.getWufang()/10);
            playerCapability.setMaxshengming(playerCapability.getMaxshengming()+danyaoItemCapability.getShengming()/10);
            playerCapability.setShengminghuifu(playerCapability.getShengminghuifu()+danyaoItemCapability.getShengminghuifu()/10);
            playerCapability.setMinghzong(playerCapability.getMinghzong()+danyaoItemCapability.getMinghzong()/10);
            playerCapability.setShanbi(playerCapability.getShanbi()+danyaoItemCapability.getShanbi()/10);
            playerCapability.setWuchuan(playerCapability.getWuchuan()+danyaoItemCapability.getWuchuan()/10);
            playerCapability.setKangbao(playerCapability.getKangbao()+danyaoItemCapability.getKangbao()/10);

            NetworkRegistryHandler.PlayerListen.sendClientCustomPacket(player);
        }
    }
    public static void removeItem(PlayerCapability playerCapability, ItemCapability danyaoItemCapability, EntityPlayer player){

        if(playerCapability!=null&&danyaoItemCapability!=null){
            playerCapability.setWugong(playerCapability.getWugong()-danyaoItemCapability.getWugong());
            playerCapability.setBaojishanghai(playerCapability.getBaojishanghai()-danyaoItemCapability.getBaojishanghai());
            playerCapability.setBaojilv(playerCapability.getBaojilv()-danyaoItemCapability.getBaojilv());
            playerCapability.setZhenshang(playerCapability.getZhenshang()-danyaoItemCapability.getZhenshang());
            playerCapability.setXixue(playerCapability.getXixue()-danyaoItemCapability.getXixue());
            playerCapability.setWufang(playerCapability.getWufang()-danyaoItemCapability.getWufang());
            playerCapability.setMaxshengming(playerCapability.getMaxshengming()-danyaoItemCapability.getMaxshengming());
            playerCapability.setShengminghuifu(playerCapability.getShengminghuifu()-danyaoItemCapability.getShengminghuifu());
            playerCapability.setMinghzong(playerCapability.getMinghzong()-danyaoItemCapability.getMinghzong());
            playerCapability.setShanbi(playerCapability.getShanbi()-danyaoItemCapability.getShanbi());
            playerCapability.setWuchuan(playerCapability.getWuchuan()-danyaoItemCapability.getWuchuan());
            playerCapability.setKangbao(playerCapability.getKangbao()-danyaoItemCapability.getKangbao());

            NetworkRegistryHandler.PlayerListen.sendClientCustomPacket(player);
        }
    }
}
