package hua.huase.shanhaicontinent.capability;

import net.minecraft.nbt.NBTTagCompound;

import java.util.Random;



/*
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

       魂兽属性
        年限
        属性

*/


public class MonsterCapability extends BaseCapability{

    private int nianxian;
    private int shuxing;
    Random random =new Random();

    public MonsterCapability(int nianxian,int shuxing) {

        this.nianxian = nianxian;
        this.shuxing = shuxing;

        if(nianxian<=100){
            float g = 10 + (float) nianxian / 5 + random.nextInt(10);
            float l= 10 + (float) nianxian / 100 * 10 ;

            super.setWugong(g);
            super.setWufang(g/3);
            super.setWuchuan(g/3);
            super.setZhenshang(g/10);
            super.setMaxshengming(10*g);
            super.setShengming(10*g);
            super.setBaojilv(l);
            super.setBaojishanghai(5*l);
            super.setKangbao(3*l);
            super.setXixue((l/4));
            super.setMinghzong(l);
            super.setShanbi(l);
            super.setYuansukangxing((float) (0));
            super.setShengminghuifu(0);
            super.setYuanshushanghai(0);
            super.setJingshenli(0);
            super.setHunlizhi(0);
            super.setRenxing(0);

        }else if(nianxian<=1000){

            float g = 50 + (float) nianxian / 10 + random.nextInt(50);
            float l= 20 + (float) nianxian / 1000 * 10 ;

            super.setWugong(g);
            super.setWufang(g/3);
            super.setWuchuan(g/3);
            super.setZhenshang(g/10);
            super.setMaxshengming(10*g);
            super.setShengming(10*g);
            super.setBaojilv(l);
            super.setBaojishanghai(5*l);
            super.setKangbao(3*l);
            super.setXixue((l/4));
            super.setMinghzong(l);
            super.setShanbi(l);
            super.setYuansukangxing((float) (0));
            super.setShengminghuifu(0);
            super.setYuanshushanghai(0);
            super.setJingshenli(0);
            super.setHunlizhi(0);
            super.setRenxing(0);

        }else if(nianxian<=10000){

            float g = 250 + (float) nianxian / 20 + random.nextInt(250);
            float l= 30 + (float) nianxian / 10000 * 10 ;

            super.setWugong(g);
            super.setWufang(g/3);
            super.setWuchuan(g/3);
            super.setZhenshang(g/10);
            super.setMaxshengming(10*g);
            super.setShengming(10*g);
            super.setBaojilv(l);
            super.setBaojishanghai(5*l);
            super.setKangbao(3*l);
            super.setXixue((l/4));
            super.setMinghzong(l);
            super.setShanbi(l);
            super.setYuansukangxing((float) (0));
            super.setShengminghuifu(0);
            super.setYuanshushanghai(0);
            super.setJingshenli(0);
            super.setHunlizhi(0);
            super.setRenxing(0);
        }else if(nianxian<=100000){
            float g = 750 + (float) nianxian / 67 + random.nextInt(750);
            float l= 40 + (float) nianxian / 100000 * 10 ;

            super.setWugong(g);
            super.setWufang(g/3);
            super.setWuchuan(g/3);
            super.setZhenshang(g/10);
            super.setMaxshengming(10*g);
            super.setShengming(10*g);
            super.setBaojilv(l);
            super.setBaojishanghai(5*l);
            super.setKangbao(3*l);
            super.setXixue((l/4));
            super.setMinghzong(l);
            super.setShanbi(l);
            super.setYuansukangxing((float) (0));
            super.setShengminghuifu(0);
            super.setYuanshushanghai(0);
            super.setJingshenli(0);
            super.setHunlizhi(0);
            super.setRenxing(0);
        }else if(nianxian>1000000){

            float g = 3750 + (float) nianxian / 133 + random.nextInt(3750);
            float l= 50 + (float) nianxian / 1000000 * 10 ;

            super.setWugong(g);
            super.setWufang(g/3);
            super.setWuchuan(g/3);
            super.setZhenshang(g/10);
            super.setMaxshengming(10*g);
            super.setShengming(10*g);
            super.setBaojilv(l);
            super.setBaojishanghai(5*l);
            super.setKangbao(3*l);
            super.setXixue((l/4));
            super.setMinghzong(l);
            super.setShanbi(l);
            super.setYuansukangxing((float) (0));
            super.setShengminghuifu(0);
            super.setYuanshushanghai(0);
            super.setJingshenli(0);
            super.setHunlizhi(0);
            super.setRenxing(0);
        }else if(nianxian>=1000000){
            float g = 18750 + random.nextInt(18750);
            float l= 80 ;

            super.setWugong(g);
            super.setWufang(g/3);
            super.setWuchuan(g/3);
            super.setZhenshang(g/10);
            super.setMaxshengming(10*g);
            super.setShengming(10*g);
            super.setBaojilv(l);
            super.setBaojishanghai(5*l);
            super.setKangbao(3*l);
            super.setXixue((l/4));
            super.setMinghzong(l);
            super.setShanbi(l);
            super.setYuansukangxing((float) (0));
            super.setShengminghuifu(0);
            super.setYuanshushanghai(0);
            super.setJingshenli(0);
            super.setHunlizhi(0);
            super.setRenxing(0);
        }



    }

    public MonsterCapability() {
        super();
        nianxian=0;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = super.serializeNBT();

        nbt.setFloat("nianxian",nianxian);
        nbt.setFloat("shuxing",shuxing);
        return  nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        super.deserializeNBT(nbt);

        this.nianxian=nbt.getInteger("nianxian");
        this.shuxing=nbt.getInteger("shuxing");
    }


    public int getNianxian() {
        return nianxian;
    }


    public void setNianxian(float nianxian1) {
        this.nianxian = nianxian;
    }
    public int getShuxing() {
        return shuxing;
    }


    public void setShuxing(float nianxian1) {
        this.shuxing = shuxing;
    }
}
