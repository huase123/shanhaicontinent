package hua.huase.shanhaicontinent.api;

import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.MonsterCapability;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.network.NetworkRegistryHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentTranslation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static hua.huase.shanhaicontinent.capability.PlayerCapability.wuhunListsnameall;

public interface PlayerCapabilityApi {

    public static boolean isXishouHunhuan(EntityPlayer player){
        PlayerCapability capability = player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
//        if((capability.getDengji()+1)%10==0&&capability.getJingyan()>=capability.getMaxjingyan()){
//            return  true;
//        }

        if(capability.getMonsterCapabilityList()!=null &&(capability.getDengji()+1)/10>capability.getMonsterCapabilityList().size()&&capability.getMonsterCapabilityList().size()<=8){
            return  true;
        }

        return false;
    }
    public static Boolean   tuPo(EntityPlayer player){
        PlayerCapability capability = player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
        int maxjingyan = capability.getMaxjingyan();
        int jingyan = capability.getJingyan();
        int dengji = capability.getDengji();

        Map<String, List<MonsterCapability>> monsterCapabilityLists = capability.getMonsterCapabilityLists();
        int sizeMax = 0;
        for (Map.Entry<String, List<MonsterCapability>> stringListEntry : monsterCapabilityLists.entrySet()) {
            if(sizeMax < stringListEntry.getValue().size()) sizeMax = stringListEntry.getValue().size();

        }
        if(jingyan>=maxjingyan&& (capability.getDengji())/10<=sizeMax&&dengji<=98){
            capability.setDengji(dengji+1);
            capability.setJingyan(0);
            capability.setMaxjingyan((int) (maxjingyan+maxjingyan*0.1));
            capability.addWugong(dengji*1);
            capability.addMaxshengming(dengji*20);
            capability.addWufang(dengji);
            capability.addWuchuan(dengji/5f);
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


    public static boolean juexingWuHun(EntityPlayer player,String string){

        PlayerCapability capability = player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
        List<String> wuhunListsname = capability.getWuhunListsname();
        if(wuhunListsname.contains(string)){
            player.sendMessage(new TextComponentTranslation("message.juexingwuhun.fail.cf"));
            return false;
        }
        wuhunListsname.add(string);

        for (String s : wuhunListsnameall) {
            if(wuhunListsname.contains(s)){
                wuhunListsname.remove(s);
                wuhunListsname.add(s);

            }
        }

        Map<String, List<MonsterCapability>> monsterCapabilityLists = capability.getMonsterCapabilityLists();
        monsterCapabilityLists.put(string,new ArrayList<>());
        player.sendMessage(new TextComponentTranslation("message.juexingwuhun.sccuess."+string));
//        player.world.playSound(player,player.posX, player.posY, player.posZ, SoundEvents.ITEM_TOTEM_USE, player.getSoundCategory(), 1.0F, 1.0F);
        player.world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_LIGHTNING_IMPACT, SoundCategory.PLAYERS, 10000.0F,   1.1F);
        player.world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_LIGHTNING_THUNDER, SoundCategory.PLAYERS, 10000.0F,   1.1F);

        return true;
    }
}
