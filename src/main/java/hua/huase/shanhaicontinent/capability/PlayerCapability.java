package hua.huase.shanhaicontinent.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import java.math.BigDecimal;
import java.util.*;

/*玩家属性
        物攻
        暴击伤害，
        暴击率
        真伤
        元素伤害
        吸血
        物防
        元素抗性，
        元素亲和力
        生命，
        最大生命，
        生命回复,
        命中，
        闪避
        精神力
        魂力值
        魂力转化率
        境界
        韧性
        魂环开关
        物穿
        抗暴




        年限
        属性
        （原始伤害（）+物攻）*暴击伤害(new Random.nextFloat()<=(暴击率-抗暴)? 暴击伤害：1)
        (1-max((怪物护甲-player穿甲),0)/(max((怪物护甲-player穿甲),0)+200))

        经验
        最大经验
        等级
        魂环
        魂骨
        最大精神力


生命          最大生命
物攻          物防
暴击伤害       暴击率
真伤          物穿
元素伤害       元素抗性
抗暴          韧性
吸血          生命回复
命中          闪避
元素亲和       精神力
魂力值         魂力转化
境界          魂环开关






        */

public class PlayerCapability  implements INBTSerializable<NBTTagCompound> {
    private float wugong;
    private float baojishanghai;
    private float baojilv;
    private float zhenshang;
    private float yuanshushanghai;
    private float xixue;
    private float wufang;
    private float yuansukangxing;
    private float yuansuqinheli;
    private float shengming;
    private float maxshengming;
    private float shengminghuifu;
    private float minghzong;
    private float shanbi;
    private float jingshenli;
    private float hunlizhi;
    private float hunlizhuanhualv;
    private float renxing;
    private int jingjie;
    private short hunhuankaiguan;
    private float wuchuan;
    private float kangbao;
    private int jingyan;
    private int maxjingyan;
    private int dengji;
    private Map<String,List<MonsterCapability>> monsterCapabilityLists;
    private List<String> wuhunListsname;

    public static HashSet<String> wuhunListsnameall= new HashSet<>();

    static {
        wuhunListsnameall.add("jingubang");
        wuhunListsnameall.add("huang");
    }

    private List<ItemCapability> itemCapabilityList;

    private float maxjingshenli;


    public PlayerCapability (float wugong, float baojishanghai, float baojilv, float zhenshang, float yuanshushanghai, float xixue, float wufang, float yuansukangxing,
                             float yuansuqinheli, float shengming, float maxshengming, float shengminghuifu, float minghzong, float shanbi, float jingshenli, float hunlizhi,
                             float hunlizhuanhualv,int jingjie, float renxing, short hunhuankaiguan, float wuchuan , float kangbao,int jingyan,int maxjingyan){
        this.wugong=wugong;
        this.baojishanghai=baojishanghai;

        this.zhenshang=zhenshang;
        this.yuanshushanghai=yuanshushanghai;
        this.xixue=xixue;
        this.wufang=wufang;
        this.yuansukangxing=yuansukangxing;
        this.yuansuqinheli=yuansuqinheli;
        this.shengming=shengming;
        this.maxshengming=maxshengming;
        this.shengminghuifu=shengminghuifu;
        this.minghzong=minghzong;
        this.shanbi=shanbi;
        this.jingshenli=jingshenli;
        this.hunlizhi=hunlizhi;
        this.hunlizhuanhualv=hunlizhuanhualv;
        this.jingjie=jingjie;
        this.renxing=renxing;
        this.hunhuankaiguan=hunhuankaiguan;
        this.wuchuan=wuchuan;
        this.kangbao=kangbao;
        this.jingyan=jingyan;
        this.maxjingyan=maxjingyan;



    }


    public PlayerCapability (){
        this.wugong=1;
        this.baojishanghai=50f;
        this.baojilv=10f;
        this.zhenshang=0;
        this.yuanshushanghai=0;
        this.xixue=1.0f;
        this.wufang=0;
        this.yuansukangxing=0;
        this.yuansuqinheli=0;
        this.shengming=21;
        this.maxshengming=21;
        this.shengminghuifu=1f;
        this.minghzong=1f;
        this.shanbi=1f;
        this.jingshenli=1;
        this.hunlizhi=0;
        this.hunlizhuanhualv=0;
        this.jingjie=1;
        this.renxing=0;
        this.hunhuankaiguan=0;
        this.wuchuan=0;
        this.kangbao=0;
        this.jingyan=0;
        this.maxjingyan=50;
        this.dengji=0;
        this.monsterCapabilityLists=new HashMap<>();
        this.wuhunListsname=new ArrayList<>();
        this.itemCapabilityList=new ArrayList<>();
        this.maxjingshenli=1;

//        this.wuhunListsname.add("jingubang");
//        monsterCapabilityLists.put(wuhunListsname.get(0),new ArrayList<>());

    }



    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();

        nbt.setFloat("wugong",wugong);
        nbt.setFloat("baojishanghai",baojishanghai);
        nbt.setFloat("baojilv",baojilv);
        nbt.setFloat("zhenshang",zhenshang);
        nbt.setFloat("yuanshushanghai",yuanshushanghai);
        nbt.setFloat("xixue",xixue);
        nbt.setFloat("wufang",wufang);
        nbt.setFloat("yuansukangxing",yuansukangxing);
        nbt.setFloat("yuansuqinheli",yuansuqinheli);
        nbt.setFloat("shengming",shengming);
        nbt.setFloat("maxshengming",maxshengming);
        nbt.setFloat("shengminghuifu",shengminghuifu);
        nbt.setFloat("minghzong",minghzong);
        nbt.setFloat("shanbi",shanbi);
        nbt.setFloat("jingshenli",jingshenli);
        nbt.setFloat("hunlizhi",hunlizhi);
        nbt.setFloat("hunlizhuanhualv",hunlizhuanhualv);
        nbt.setInteger("jingjie",jingjie);
        nbt.setFloat("renxing",renxing);
        nbt.setShort("hunhuankaiguan",hunhuankaiguan);
        nbt.setFloat("wuchuan",wuchuan);
        nbt.setFloat("kangbao",kangbao);
        nbt.setInteger("jingyan",jingyan);
        nbt.setInteger("maxjingyan",maxjingyan);
        nbt.setInteger("dengji",dengji);
        nbt.setFloat("maxjingshenli",maxjingshenli);

        for (String s : wuhunListsname) {
            nbt.setString(s,s);
        }

        for (Map.Entry<String, List<MonsterCapability>> stringListEntry : monsterCapabilityLists.entrySet()) {
            int i=0;

            nbt.setTag(stringListEntry.getKey()+":monsterCapability",new NBTTagCompound());
            for (MonsterCapability monsterCapability : stringListEntry.getValue()) {
                nbt.setTag(stringListEntry.getKey()+":monsterCapability"+i,monsterCapability.serializeNBT());
                i++;
            }

        }

        for (int i = 0; i < itemCapabilityList.size(); i++) {
            nbt.setTag("itemCapability"+i,itemCapabilityList.get(i).serializeNBT());
        }


        return nbt;
    }


    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        this.wugong=nbt.getFloat("wugong");
        this.baojishanghai=nbt.getFloat("baojishanghai");
        this.baojilv=nbt.getFloat("baojilv");
        this.zhenshang=nbt.getFloat("zhenshang");
        this.yuanshushanghai=nbt.getFloat("yuanshushanghai");
        this.xixue=nbt.getFloat("xixue");
        this.wufang=nbt.getFloat("wufang");
        this.yuansukangxing=nbt.getFloat("yuansukangxing");
        this.yuansuqinheli=nbt.getFloat("yuansuqinheli");
        this.shengming=nbt.getFloat("shengming");
        this.maxshengming=nbt.getFloat("maxshengming");
        this.shengminghuifu=nbt.getFloat("shengminghuifu");
        this.minghzong=nbt.getFloat("minghzong");
        this.shanbi=nbt.getFloat("shanbi");
        this.jingshenli=nbt.getFloat("jingshenli");
        this.hunlizhi=nbt.getFloat("hunlizhi");
        this.hunlizhuanhualv=nbt.getFloat("hunlizhuanhualv");
        this.jingjie=nbt.getInteger("jingjie");
        this.renxing=nbt.getFloat("renxing");
        this.hunhuankaiguan=nbt.getShort("hunhuankaiguan");
        this.wuchuan=nbt.getFloat("wuchuan");
        this.kangbao=nbt.getFloat("kangbao");
        this.jingyan=nbt.getInteger("jingyan");
        this.maxjingyan=nbt.getInteger("maxjingyan");
        this.dengji=nbt.getInteger("dengji");
        this.maxjingshenli=nbt.getFloat("maxjingshenli");


        wuhunListsname.clear();
        for (String s : wuhunListsnameall) {
            if(nbt.hasKey(s)){

                wuhunListsname.add(nbt.getString(s));
            }
        }




        this.monsterCapabilityLists.clear();
        for (String s : wuhunListsnameall) {
            if(nbt.hasKey(s+":monsterCapability")){
//                for (int i = 0; nbt.getTag(s+":monsterCapability"+i)!=null; i++) {
                monsterCapabilityLists.put(s,new ArrayList<>());
                for (int i = 0; nbt.hasKey(s+":monsterCapability"+i); i++) {
                    MonsterCapability monsterCapability = new MonsterCapability();
                    monsterCapability.deserializeNBT((NBTTagCompound) nbt.getTag(s+":monsterCapability"+i));
                    monsterCapabilityLists.get(s).add(monsterCapability);
                }
            }

        }


        this.itemCapabilityList.clear();
        for (int i = 0; nbt.hasKey("itemCapability"+i); i++) {
            ItemCapability itemCapability = new ItemCapability();
            itemCapability.deserializeNBT((NBTTagCompound) nbt.getTag("itemCapability"+i));
            this.itemCapabilityList.add(itemCapability);
        }


    }

    public float getWugong() {
        return wugong;
    }

    public void setWugong(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.wugong = value;
    }
    public void addWugong(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.wugong += value;
    }

    public float getBaojishanghai() {
        return baojishanghai;
    }

    public void setBaojishanghai(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.baojishanghai = value;
    }
    public void addBaojishanghai(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.baojishanghai += value;
    }

    public float getBaojilv() {
        return baojilv;
    }

    public void setBaojilv(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.baojilv = value;
    }
    public void addBaojilv(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.baojilv += value;
    }

    public float getZhenshang() {
        return zhenshang;
    }

    public void setZhenshang(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.zhenshang = value;
    }
    public void addZhenshang(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.zhenshang += value;
    }

    public float getYuanshushanghai() {
        return yuanshushanghai;
    }

    public void setYuanshushanghai(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.yuanshushanghai = value;
    }
    public void addYuanshushanghai(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.yuanshushanghai += value;
    }

    public float getXixue() {
        return xixue;
    }

    public void setXixue(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.xixue = value;
    }
    public void addXixue(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.xixue += value;
    }

    public float getWufang() {
        return wufang;
    }

    public void setWufang(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.wufang = value;
    }
    public void addWufang(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.wufang += value;
    }

    public float getYuansukangxing() {
        return yuansukangxing;
    }

    public void setYuansukangxing(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.yuansukangxing = value;
    }
    public void addYuansukangxing(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.yuansukangxing += value;
    }

    public float getYuansuqinheli() {
        return yuansuqinheli;
    }

    public void setYuansuqinheli(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.yuansuqinheli = value;
    }
    public void addYuansuqinheli(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.yuansuqinheli += value;
    }

    public float getShengming() {
        return shengming;
    }

    public void setShengming(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.shengming = value;
    }
    public void addShengming(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.shengming += value;
    }

    public float getMaxshengming() {
        return maxshengming;
    }

    public void setMaxshengming(float value) {
        new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.maxshengming = value;
    }
    public void addMaxshengming(float value) {
        new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.maxshengming += value;
    }

    public float getShengminghuifu() {
        return shengminghuifu;
    }

    public void setShengminghuifu(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.shengminghuifu = value;
    }
    public void addShengminghuifu(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.shengminghuifu += value;
    }

    public float getMinghzong() {
        return minghzong;
    }

    public void setMinghzong(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.minghzong = value;
    }
    public void addMinghzong(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.minghzong += value;
    }

    public float getShanbi() {
        return shanbi;
    }

    public void setShanbi(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.shanbi = value;
    }
    public void addShanbi(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.shanbi += value;
    }

    public float getJingshenli() {
        return jingshenli;
    }

    public void setJingshenli(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.jingshenli = value;
    }
    public void addJingshenli(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.jingshenli += value;
    }

    public float getHunlizhi() {
        return hunlizhi;
    }

    public void setHunlizhi(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.hunlizhi = value;
    }
    public void addHunlizhi(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.hunlizhi += value;
    }

    public float getHunlizhuanhualv() {
        return hunlizhuanhualv;
    }

    public void setHunlizhuanhualv(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.hunlizhuanhualv = value;
    }
    public void addHunlizhuanhualv(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.hunlizhuanhualv += value;
    }

    public int getJingjie() {
        return jingjie;
    }

    public void setJingjie(short value) {
        this.jingjie = value;
    }

    public void addJingjie(short value) {
        this.jingjie += value;
    }

    public float getRenxing() {
        return renxing;
    }

    public void setRenxing(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.renxing = value;
    }
    public void addRenxing(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.renxing += value;
    }

    public short getHunhuankaiguan() {
        return hunhuankaiguan;
    }

    public void setHunhuankaiguan(short value) {
        this.hunhuankaiguan = value;
    }
    public float getWuchuan() {
        return wuchuan;
    }

    public void setWuchuan(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.wuchuan = value;
    }
    public void addWuchuan(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.wuchuan += value;
    }
    public float getKangbao() {
        return kangbao;
    }

    public void setKangbao(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.kangbao = value;
    }
    public void addKangbao(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.kangbao += value;
    }

    public int getJingyan() {
        return jingyan;
    }

    public void setJingyan(int value) {
        if(value>maxjingyan){
            this.jingyan = maxjingyan;
            return;
        }
        this.jingyan = value;
    }
    public void addJingyan(int value) {

        if(jingyan +value>maxjingyan){
            this.jingyan = maxjingyan;
            return;
        }
        this.jingyan += value;
    }
    public int getMaxjingyan() {
        return maxjingyan;
    }

    public void setMaxjingyan(int value) {
        this.maxjingyan = value;
    }
    public void addMaxjingyan(int value) {
        this.maxjingyan += value;
    }
    public int getDengji() {
        return dengji;
    }
    public void setDengji(int value) {
        this.dengji = value;
    }
    public void addDengji(int value) {
        this.dengji += value;
    }

    public float getMaxjingshenli() {
        return maxjingshenli;
    }

    public void setMaxjingshenli(int value) {
        this.maxjingshenli = value;
    }
    public void addMaxjingshenli(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.maxjingshenli += value;
    }

    public List<ItemCapability> getItemCapabilityList() {
        return itemCapabilityList;
    }

    public void setItemCapabilityList(List<ItemCapability> itemCapabilityList) {
        this.itemCapabilityList = itemCapabilityList;
    }

    public void setMonsterCapabilityListAll(Map<String, List<MonsterCapability>> monsterCapabilityList) {
        this.monsterCapabilityLists = monsterCapabilityLists;
    }

    public Map<String, List<MonsterCapability>> getMonsterCapabilityLists() {
        return monsterCapabilityLists;
    }

/*

    public void setMonsterCapabilityList(Map<String, List<MonsterCapability>> monsterCapabilityList) {
        this.monsterCapabilityLists = monsterCapabilityLists;
    }
*/

    public List<MonsterCapability> getMonsterCapabilityList() {
        if(hunhuankaiguan==0)return null;
        return monsterCapabilityLists.get(wuhunListsname.get(getHunhuankaiguan()-1));


    }



    public void setWuhunListsname(List wuhunListsname) {
        this.wuhunListsname = wuhunListsname;
    }

    public List<String> getWuhunListsname() {
        return wuhunListsname;
    }

    public String getWuhunname() {
        if(hunhuankaiguan==0)return "null";
        return wuhunListsname.get(hunhuankaiguan-1);
    }




}
