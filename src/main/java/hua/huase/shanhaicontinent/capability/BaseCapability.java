package hua.huase.shanhaicontinent.capability;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import java.math.BigDecimal;

/*玩家属性
        物攻
        暴击伤害，
        暴击率
        真伤
        元素伤害
        吸血
        物防
        元素抗性，
        生命，
        最大生命，
        生命回复,
        命中，
        闪避
        精神力
        魂力值
        韧性
        物穿
        抗暴
        */

public class BaseCapability implements INBTSerializable<NBTTagCompound> {
    private float wugong;
    private float baojishanghai;
    private float baojilv;
    private float zhenshang;

    private float yuanshushanghai;
    private float xixue;
    private float wufang;
    private float yuansukangxing;
    private float shengming;
    private float maxshengming;
    private float shengminghuifu;
    private float minghzong;
    private float shanbi;
    private float jingshenli;
    private float hunlizhi;
    private float renxing;
    private float wuchuan;
    private float kangbao;


    public BaseCapability(float wugong, float baojishanghai, float baojilv, float zhenshang, float yuanshushanghai, float xixue, float wufang, float yuansukangxing,
                           float shengming, float maxshengming, float shengminghuifu, float minghzong, float shanbi, float jingshenli, float hunlizhi,
                           float renxing,float wuchuan , float kangbao){
        this.wugong=wugong;
        this.baojishanghai=baojishanghai;
        this.baojilv=baojilv;
        this.zhenshang=zhenshang;
        this.yuanshushanghai=yuanshushanghai;
        this.xixue=xixue;
        this.wufang=wufang;
        this.yuansukangxing=yuansukangxing;
        this.shengming=shengming;
        this.maxshengming=maxshengming;
        this.shengminghuifu=shengminghuifu;
        this.minghzong=minghzong;
        this.shanbi=shanbi;
        this.jingshenli=jingshenli;
        this.hunlizhi=hunlizhi;
        this.renxing=renxing;
        this.wuchuan=wuchuan;
        this.kangbao=kangbao;



    }


    public BaseCapability(){
        this.wugong=0;
        this.baojishanghai=0.0f;
        this.baojilv=0.00f;
        this.zhenshang=0;
        this.yuanshushanghai=0;
        this.xixue=0.0f;
        this.wufang=0;
        this.yuansukangxing=0;
        this.shengming=0;
        this.maxshengming=0;
        this.shengminghuifu=0;
        this.minghzong=0;
        this.shanbi=0f;
        this.jingshenli=0;
        this.hunlizhi=0;
        this.renxing=0;
        this.wuchuan=0;
        this.kangbao=0;

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
        nbt.setFloat("shengming",shengming);
        nbt.setFloat("maxshengming",maxshengming);
        nbt.setFloat("shengminghuifu",shengminghuifu);
        nbt.setFloat("minghzong",minghzong);
        nbt.setFloat("shanbi",shanbi);
        nbt.setFloat("jingshenli",jingshenli);
        nbt.setFloat("hunlizhi",hunlizhi);
        nbt.setFloat("renxing",renxing);
        nbt.setFloat("wuchuan",wuchuan);
        nbt.setFloat("kangbao",kangbao);

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
        this.shengming=nbt.getFloat("shengming");
        this.maxshengming=nbt.getFloat("maxshengming");
        this.shengminghuifu=nbt.getFloat("shengminghuifu");
        this.minghzong=nbt.getFloat("minghzong");
        this.shanbi=nbt.getFloat("shanbi");
        this.jingshenli=nbt.getFloat("jingshenli");
        this.hunlizhi=nbt.getFloat("hunlizhi");
        this.renxing=nbt.getFloat("renxing");
        this.wuchuan=nbt.getFloat("wuchuan");
        this.kangbao=nbt.getFloat("kangbao");
    }

    public float getWugong() {
        return wugong;
    }

    public void setWugong(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.wugong = value;
    }

    public float getBaojishanghai() {
        return baojishanghai;
    }

    public void setBaojishanghai(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.baojishanghai = value;
    }

    public float getBaojilv() {
        return baojilv;
    }

    public void setBaojilv(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.baojilv = value;
    }

    public float getZhenshang() {
        return zhenshang;
    }

    public void setZhenshang(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.zhenshang = value;
    }

    public float getYuanshushanghai() {
        return yuanshushanghai;
    }

    public void setYuanshushanghai(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.yuanshushanghai = value;
    }

    public float getXixue() {
        return xixue;
    }

    public void setXixue(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.xixue = value;
    }

    public float getWufang() {
        return wufang;
    }

    public void setWufang(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.wufang = value;
    }

    public float getYuansukangxing() {
        return yuansukangxing;
    }

    public void setYuansukangxing(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.yuansukangxing = value;
    }


    public float getShengming() {
        return shengming;
    }

    public void setShengming(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.shengming = value;
    }

    public float getMaxshengming() {
        return maxshengming;
    }

    public void setMaxshengming(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.maxshengming = value;
    }

    public float getShengminghuifu() {
        return shengminghuifu;
    }

    public void setShengminghuifu(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.shengminghuifu = value;
    }

    public float getMinghzong() {
        return minghzong;
    }

    public void setMinghzong(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.minghzong = value;
    }

    public float getShanbi() {
        return shanbi;
    }

    public void setShanbi(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.shanbi = value;
    }

    public float getJingshenli() {
        return jingshenli;
    }

    public void setJingshenli(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.jingshenli = value;
    }

    public float getHunlizhi() {
        return hunlizhi;
    }

    public void setHunlizhi(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.hunlizhi = value;
    }



    public float getRenxing() {
        return renxing;
    }

    public void setRenxing(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.renxing = value;
    }

    public float getWuchuan() {
        return wuchuan;
    }

    public void setWuchuan(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.wuchuan = value;
    }
    public float getKangbao() {
        return kangbao;
    }

    public void setKangbao(float value) {
        value = new BigDecimal(value).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        this.kangbao = value;
    }
}
