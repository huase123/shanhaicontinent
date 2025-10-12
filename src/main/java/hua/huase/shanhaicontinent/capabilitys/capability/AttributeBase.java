package hua.huase.shanhaicontinent.capabilitys.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public class
AttributeBase implements INBTSerializable<CompoundTag> {

/*基础属性
生命*          最大生命
物攻          物防
暴击伤害       暴击率
真伤          物穿
抗暴
吸血          生命回复
命中          闪避
       */
    private float maxshengming;
    private float wugong;
    private float wufang;
    private float baojishanghai;
    private float baojilv;
    private float zhenshang;
    private float wuchuan;
    private float kangbao;
    private float xixue;
    private float shengminghuifu;
    private float mingzhong;
    private float shanbi;
    public AttributeBase(){
        this.maxshengming = 20;
        this.wugong = 1;
        this.wufang = 1;
        this.baojishanghai = 1;
        this.baojilv = 1;
        this.zhenshang = 1;
        this.wuchuan = 1;
        this.kangbao = 1;
        this.xixue = 1;
        this.shengminghuifu = 1;
        this.mingzhong = 1;
        this.shanbi = 1;
    }

    public AttributeBase( float maxshengming, float wugong, float wufang, float baojishanghai, float baojilv, float zhenshang, float wuchuan, float kangbao, float xixue, float shengminghuifu, float mingzhong, float shanbi) {
        this.maxshengming = maxshengming;
        this.wugong = wugong;
        this.wufang = wufang;
        this.baojishanghai = baojishanghai;
        this.baojilv = baojilv;
        this.zhenshang = zhenshang;
        this.wuchuan = wuchuan;
        this.kangbao = kangbao;
        this.xixue = xixue;
        this.shengminghuifu = shengminghuifu;
        this.mingzhong = mingzhong;
        this.shanbi = shanbi;
    }

    @Override
    public CompoundTag serializeNBT() {

        CompoundTag nbt = new CompoundTag();
        nbt.putFloat("wugong",wugong);
        nbt.putFloat("baojishanghai",baojishanghai);
        nbt.putFloat("baojilv",baojilv);
        nbt.putFloat("zhenshang",zhenshang);
        nbt.putFloat("xixue",xixue);
        nbt.putFloat("wufang",wufang);
        nbt.putFloat("maxshengming",maxshengming);
        nbt.putFloat("shengminghuifu",shengminghuifu);
        nbt.putFloat("minghzong", mingzhong);
        nbt.putFloat("shanbi",shanbi);
        nbt.putFloat("wuchuan",wuchuan);
        nbt.putFloat("kangbao",kangbao);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.wugong=nbt.getFloat("wugong");
        this.baojishanghai=nbt.getFloat("baojishanghai");
        this.baojilv=nbt.getFloat("baojilv");
        this.zhenshang=nbt.getFloat("zhenshang");
        this.xixue=nbt.getFloat("xixue");
        this.wufang=nbt.getFloat("wufang");
        this.maxshengming=nbt.getFloat("maxshengming");
        this.shengminghuifu=nbt.getFloat("shengminghuifu");
        this.mingzhong =nbt.getFloat("minghzong");
        this.shanbi=nbt.getFloat("shanbi");
        this.wuchuan=nbt.getFloat("wuchuan");
        this.kangbao=nbt.getFloat("kangbao");

    }
    public float getMaxshengming() {
        return maxshengming;
    }

    public void setMaxshengming(float maxshengming) {
        this.maxshengming = maxshengming;
    }

    public float getWugong() {
        return wugong;
    }

    public void setWugong(float wugong) {
        this.wugong = wugong;
    }

    public float getWufang() {
        return wufang;
    }

    public void setWufang(float wufang) {
        this.wufang = wufang;
    }

    public float getBaojishanghai() {
        return baojishanghai;
    }

    public void setBaojishanghai(float baojishanghai) {
        this.baojishanghai = baojishanghai;
    }

    public float getBaojilv() {
        return baojilv;
    }

    public void setBaojilv(float baojilv) {
        this.baojilv = baojilv;
    }

    public float getZhenshang() {
        return zhenshang;
    }

    public void setZhenshang(float zhenshang) {
        this.zhenshang = zhenshang;
    }

    public float getWuchuan() {
        return wuchuan;
    }

    public void setWuchuan(float wuchuan) {
        this.wuchuan = wuchuan;
    }

    public float getKangbao() {
        return kangbao;
    }

    public void setKangbao(float kangbao) {
        this.kangbao = kangbao;
    }

    public float getXixue() {
        return xixue;
    }

    public void setXixue(float xixue) {
        this.xixue = xixue;
    }

    public float getShengminghuifu() {
        return shengminghuifu;
    }

    public void setShengminghuifu(float shengminghuifu) {
        this.shengminghuifu = shengminghuifu;
    }

    public float getMingzhong() {
        return mingzhong;
    }

    public void setMingzhong(float mingzhong) {
        this.mingzhong = mingzhong;
    }

    public float getShanbi() {
        return shanbi;
    }

    public void setShanbi(float shanbi) {
        this.shanbi = shanbi;
    }
}
