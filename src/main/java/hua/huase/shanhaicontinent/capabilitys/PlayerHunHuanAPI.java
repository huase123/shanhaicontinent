package hua.huase.shanhaicontinent.capabilitys;

import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapability;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapability;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.entity.hunhuan.HunhuanEntityEntity;
import hua.huase.shanhaicontinent.init.AdvenceInit;
import hua.huase.shanhaicontinent.network.SynsAPI;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static hua.huase.shanhaicontinent.SHMainBus.random;
import static hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapability.wuhunListsnameall;

public interface PlayerHunHuanAPI {

    static void addWuHun(Player player) {

        LazyOptional<PlayerAttributeCapability> capability1 = player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY);
        if(capability1.isPresent()){
            PlayerAttributeCapability capability = capability1.orElseThrow(RuntimeException::new);
            Object[] array = wuhunListsnameall.toArray();
            boolean b = true;
            while (b){
                String s = (String) array[random.nextInt(array.length)];
                List<MonsterAttributeCapability> monsterAttributeCapabilities = capability.getMonsterCapabilityLists().get(s);
                if(monsterAttributeCapabilities ==null) {
                    capability.getMonsterCapabilityLists().put(s,new ArrayList<>());
                    capability.getWuhunListsname().add(s);
                    capability.setHunhuankuaiguan(capability.getMonsterCapabilityLists().size()-1);
                    player.sendSystemMessage(Component.translatable("成功觉醒武魂",s));
                    ((ServerPlayer)player).connection.send(new ClientboundSetTitleTextPacket(Component.translatable("成功觉醒武魂",s)));
                    b=!b;
                    if(random.nextInt(5) == 0){
                        juexingShuangsheng(player);
                    }
                    //排序
                    Collections.sort(capability.getWuhunListsname());
                    AdvenceInit.juexingwuhuntrigger.trigger((ServerPlayer) player, capability.getWuhunListsname().size());
                    SynsAPI.synsPlayerAttribute(player);
                }
            }
        }
    }
    static void juexingShuangsheng(Player player) {
        LazyOptional<PlayerAttributeCapability> capability1 = player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY);
        if(capability1.isPresent()){
            PlayerAttributeCapability capability = capability1.orElseThrow(RuntimeException::new);
            Object[] array = wuhunListsnameall.toArray();
            String s = (String) array[random.nextInt(array.length)];
            addWuHun(player,s);
        }
    }



    static void addWuHun(Player player,String name) {

        LazyOptional<PlayerAttributeCapability> capability1 = player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY);
        if(capability1.isPresent()){
            PlayerAttributeCapability capability = capability1.orElseThrow(RuntimeException::new);

            List<MonsterAttributeCapability> monsterAttributeCapabilities = capability.getMonsterCapabilityLists().get(name);
            if(monsterAttributeCapabilities ==null) {
                capability.getMonsterCapabilityLists().put(name,new ArrayList<>());
                capability.getWuhunListsname().add(name);
                capability.setHunhuankuaiguan(capability.getMonsterCapabilityLists().size()-1);
                player.sendSystemMessage(Component.translatable("成功觉醒武魂",name));
                ((ServerPlayer)player).connection.send(new ClientboundSetTitleTextPacket(Component.translatable("成功觉醒武魂",name)));


                AdvenceInit.juexingwuhuntrigger.trigger((ServerPlayer) player, capability.getWuhunListsname().size());

                SynsAPI.synsPlayerAttribute(player);
            }else {

                player.sendSystemMessage(Component.translatable("觉醒失败，已拥有该武魂"));
                ((ServerPlayer)player).connection.send(new ClientboundSetTitleTextPacket(Component.translatable("觉醒失败，已拥有该武魂")));
            }
        }
    }
//50000
//    年限计算精神力消耗
//     （2*年限* （log10(年限)*10+10） * （log10(年限)*10+10）)/（log10(年限)*log(年限)）

    /*
    1.20.1版精神力消耗对照表
年限     精神力
160     65.8
640     162
1280    265
2560    440
5120    744
10240   1273
20480   2203
40960   3850
81920   6786
163840  12051
327680  21543
655360  38742
1310720 70047
2621440 12726
           */
    static void xishouHunhuan(Player player, HunhuanEntityEntity entity){

        entity.getCapability(MonsterAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {

            double v1 = Math.log10(capability.getNianxian());
            double v = v1 * 10 + 10;

            player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability1 -> {
                float jingshenli = (float) ((capability.getNianxian() /(v1*v1*0.5))/v);
                capability1.setJingshenli(capability1.getJingshenli()-jingshenli);
                ((ServerPlayer)player).connection.send(new ClientboundSetActionBarTextPacket(Component.translatable("正在吸收魂环",(int)jingshenli)));

            });

            if(entity.getExistenceTime()>=v){
                addHunhuan(player,entity);
                entity.discard();
            }
        });
    }

    static void addHunhuan(Player player, HunhuanEntityEntity entity) {
        player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
            entity.getCapability(MonsterAttributeCapabilityProvider.CAPABILITY).ifPresent(capability1 -> {
                if(capability.getWuhunList() == null){
                    player.sendSystemMessage(Component.translatable("未开启或觉醒武魂"));
                    return;
                }
                capability.getWuhunList().add(capability1);

                AdvenceInit.xishouhunhuantrigger.trigger((ServerPlayer) player, capability1.getNianxian());
                player.sendSystemMessage(Component.translatable("成功吸收魂环",capability1.getNianxian()));
                SynsAPI.synsPlayerAttribute(player);
            });
        });
    }

    static void tupoDengji(ServerPlayer serverPlayer, @NotNull PlayerAttributeCapability capability) {
        if (isTupoDengji(serverPlayer,capability)){

            if(isTupoChenggong(serverPlayer,capability)){
                capability.setDengji(capability.getDengji()+1);
                capability.setJingyan(0);
                capability.setTupochenggonggailv(5);
                addTupoAttibute(capability.getDengji(),capability);

                AdvenceInit.changedengjitrigger.trigger(serverPlayer,capability.getDengji());

                serverPlayer.connection.send(new ClientboundSetTitleTextPacket(Component.translatable("突破成功",capability.getDengji())));
                if(capability.getDengji()==1){
                    addWuHun(serverPlayer);
                }

            }else {
                capability.setJingyan(capability.getMaxjingyan()/2);
                capability.setTupochenggonggailv(capability.getTupochenggonggailv()+5);
                serverPlayer.connection.send(new ClientboundSetTitleTextPacket(Component.translatable("突破失败")));
            }
            SynsAPI.synsPlayerAttribute(serverPlayer);
        }
    }

    static void addTupoAttibute(int dengji, PlayerAttributeCapability capability) {
        int zhuanshengshu = capability.getZhuanshengshu();
//        50000
        capability.setMaxjingshenli( (capability.getMaxjingshenli()+dengji*5f+zhuanshengshu*10));
//        100000
        capability.setMaxshengming( (capability.getMaxshengming()+dengji*1f+zhuanshengshu*10));

//        26000
//        capability.setMaxjingyan((int) (capability.getMaxjingyan()+dengji*5f));
        capability.setMaxjingyan( (capability.getMaxjingyan()+dengji*1f+zhuanshengshu*5));
//        25000
        capability.setWugong((int) (capability.getWugong()+dengji*1.2f+zhuanshengshu*2));
        capability.setWufang((int) (capability.getWufang()+dengji*0.8f+zhuanshengshu*2));
//5050
        capability.setWuchuan((int) (capability.getWuchuan()+dengji*1f+zhuanshengshu));
        capability.setZhenshang((int) (capability.getZhenshang()+dengji*0.2f+zhuanshengshu));
        capability.setShengminghuifu((int) (capability.getShengminghuifu()+dengji*0.1f));

    }

    static boolean isTupoChenggong(ServerPlayer serverPlayer, PlayerAttributeCapability capability) {
        int i = random.nextInt(90);
        float v = 100 - capability.getDengji() + capability.getTupochenggonggailv();
        return v>=i;
    }

    static boolean isTupoDengji(ServerPlayer serverPlayer, @NotNull PlayerAttributeCapability capability) {


        if(capability.getDengji()>= 100){
            serverPlayer.connection.send(new ClientboundSetTitleTextPacket(Component.translatable("已经满级")));
            return false;
        }


        int index = 0;
        for (Map.Entry<String, List<MonsterAttributeCapability>> stringListEntry : capability.getMonsterCapabilityLists().entrySet()) {
            int size = stringListEntry.getValue().size();
            index = size>=index? size:index;
        }

        if(capability.getDengji()>= index*10+15){
            serverPlayer.connection.send(new ClientboundSetTitleTextPacket(Component.translatable("不能突破")));
            return false;
        }

        return true;
    }

    static boolean isXishouHunhuan(ServerPlayer player, HunhuanEntityEntity hunhuanEntity) {
        LazyOptional<PlayerAttributeCapability> capability1 = player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY);
        if(capability1.isPresent()){
            PlayerAttributeCapability capability = capability1.orElseThrow(RuntimeException::new);


            List<MonsterAttributeCapability> wuhunList = capability.getWuhunList();
            if(wuhunList == null){
                player.sendSystemMessage(Component.translatable("未开启或觉醒武魂"));
                return false;
            }
            int size = wuhunList.size();
            if(capability.getDengji()+0>= size*10 && size<9){
                return true;
            }else {
                player.sendSystemMessage(Component.translatable("等级不够"));
            }
        }
        return false;
    }




    static void addManHunhuanT(Player player) {
        player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
                if(capability.getWuhunList() == null){
                    player.sendSystemMessage(Component.translatable("未开启或觉醒武魂"));
                    return;
                }
            capability.getWuhunList().clear();

//            for (int i = 0; i < 9; i++) {
//                MonsterAttributeCapability monsterAttributeCapability = new MonsterAttributeCapability(60 + i * i * i * i * i * i * i * 10);
//                capability.getWuhunList().add(monsterAttributeCapability);
//            }


            MonsterAttributeCapability monsterAttributeCapability1 = new MonsterAttributeCapability(1);
            MonsterAttributeCapability monsterAttributeCapability2 = new MonsterAttributeCapability(100);
            MonsterAttributeCapability monsterAttributeCapability3 = new MonsterAttributeCapability(1000);
            MonsterAttributeCapability monsterAttributeCapability4 = new MonsterAttributeCapability(10000);
            MonsterAttributeCapability monsterAttributeCapability5 = new MonsterAttributeCapability(100000);
            MonsterAttributeCapability monsterAttributeCapability6 = new MonsterAttributeCapability(1000000);
            MonsterAttributeCapability monsterAttributeCapability7 = new MonsterAttributeCapability(10000000);
            MonsterAttributeCapability monsterAttributeCapability8 = new MonsterAttributeCapability(1);
            MonsterAttributeCapability monsterAttributeCapability9 = new MonsterAttributeCapability(1);
            capability.getWuhunList().add(monsterAttributeCapability1);
            capability.getWuhunList().add(monsterAttributeCapability2);
            capability.getWuhunList().add(monsterAttributeCapability3);
            capability.getWuhunList().add(monsterAttributeCapability4);
            capability.getWuhunList().add(monsterAttributeCapability5);
            capability.getWuhunList().add(monsterAttributeCapability6);
            capability.getWuhunList().add(monsterAttributeCapability7);
            capability.getWuhunList().add(monsterAttributeCapability8);
            capability.getWuhunList().add(monsterAttributeCapability9);

                SynsAPI.synsPlayerAttribute(player);
        });
    }



    static void zhuansheng(PlayerAttributeCapability newplayerCapability, PlayerAttributeCapability oldItemCapability, ServerPlayer player) {

        if(newplayerCapability!=null&&oldItemCapability!=null){
            newplayerCapability.setWugong(newplayerCapability.getWugong()+oldItemCapability.getWugong()/20);
//            newplayerCapability.setBaojishanghai(newplayerCapability.getBaojishanghai()+oldItemCapability.getBaojishanghai()/10);
//            newplayerCapability.setBaojilv(newplayerCapability.getBaojilv()+oldItemCapability.getBaojilv()/10);
            newplayerCapability.setZhenshang(newplayerCapability.getZhenshang()+oldItemCapability.getZhenshang()/20);
//            newplayerCapability.setXixue(newplayerCapability.getXixue()+oldItemCapability.getXixue()/10);
            newplayerCapability.setWufang(newplayerCapability.getWufang()+oldItemCapability.getWufang()/20);
            newplayerCapability.setMaxshengming(newplayerCapability.getMaxshengming()+oldItemCapability.getMaxshengming()/20);
            newplayerCapability.setShengminghuifu(newplayerCapability.getShengminghuifu()+oldItemCapability.getShengminghuifu()/20);
//            newplayerCapability.setMingzhong(newplayerCapability.getMingzhong()+oldItemCapability.getMingzhong()/10);
//            newplayerCapability.setShanbi(newplayerCapability.getShanbi()+oldItemCapability.getShanbi()/10);
            newplayerCapability.setWuchuan(newplayerCapability.getWuchuan()+oldItemCapability.getWuchuan()/20);
            newplayerCapability.setKangbao(newplayerCapability.getKangbao()+oldItemCapability.getKangbao()/20);

            newplayerCapability.setMaxjingshenli((int) (newplayerCapability.getMaxjingshenli()+oldItemCapability.getMaxjingshenli()/20));
            newplayerCapability.setJingshenli(0);
            newplayerCapability.setZhuanshengshu(newplayerCapability.getZhuanshengshu()+oldItemCapability.getZhuanshengshu()+1);
//            魂骨蓸
            newplayerCapability.getBoneslot().deserializeNBT(oldItemCapability.getBoneslot().serializeNBT());

            player.setHealth(newplayerCapability.getMaxshengming());

        }

    }
}
