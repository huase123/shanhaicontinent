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


public class DanyaoItemCapability extends BaseCapability{

    private int jingyan;
    private int age;
    Random random =new Random();
    public DanyaoItemCapability(Boolean b){

    }
    public DanyaoItemCapability(int danfang , int age) {
        super();

        this.age = age;

        if(danfang==0){

            switch (age){
                case 0:
                    this.jingyan = 6+random.nextInt(2);
                    break;
                case 1:
                    this.jingyan = 18+random.nextInt(6);
                    break;
                case 2:
                    this.jingyan = 54+random.nextInt(18);
                    break;
                case 3:
                    this.jingyan = 162+random.nextInt(54);
                    break;
                case 4:
                    this.jingyan = 624+random.nextInt(208);
                    break;
                case 5:
                    this.jingyan = 648+random.nextInt(416);
                    break;
                case 6:
                    this.jingyan = 1296+random.nextInt(832);
                    break;
                case 7:
                    this.jingyan = 2592+random.nextInt(1664);
                    break;
                case 8:
                    this.jingyan = 5184+random.nextInt(3338);
                    break;
            }

                for (int i = 0; i <random.nextInt(8) ; i++) {
                    if(random.nextInt(2)==0)setRand(age+1);
                }
        }

        if(danfang==1){
            switch (age){
                case 0:
                    this.jingyan = 1;
                    break;
                case 1:
                    this.jingyan = 3;
                    break;
                case 2:
                    this.jingyan = 9;
                    break;
                case 3:
                    this.jingyan = 27;
                    break;
                case 4:
                    this.jingyan = 54;
                    break;
                case 5:
                    this.jingyan = 108;
                    break;
                case 6:
                    this.jingyan = 216;
                    break;
                case 7:
                    this.jingyan = 432;
                    break;
                case 8:
                    this.jingyan = 864;
                    break;
            }
        }

        if(danfang==2){
            this.setJingshenli(5);
            for (int i = 0; i <random.nextInt(8) ; i++) {
                if(random.nextInt(2)==0)setRand(1);
            }
        }

    }

    public void setRand(int age) {
        float g = 2 * age * age + (float) random.nextInt(2 * age * age) / 3;
        float l = (float) age /10 + (float) random.nextInt(2*age) / 30;

        switch (random.nextInt(14)){
            case 0:
                super.setWugong(g);
                break;
            case 1:
                super.setWufang(g);
                break;
            case 2:
                super.setWuchuan(g);
                break;
            case 3:
                super.setZhenshang(g/10);
                break;
            case 4:
                super.setShengming(g*5);
                break;
            case 5:
                super.setBaojilv(l);
                break;
            case 6:
                super.setBaojishanghai(l*3);
                break;
            case 7:
                super.setKangbao(l*2);
                break;
            case 8:
                super.setXixue(l);
                break;
            case 9:
                super.setMinghzong(l);
                break;
            case 10:
                super.setShanbi(l);
                break;
            case 11:
                super.setShengminghuifu(l*3);
                break;
        }

    }





    public DanyaoItemCapability() {
        super();
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound nbt = super.serializeNBT();

        nbt.setFloat("jingyan",jingyan);
        nbt.setFloat("age",age);
        return  nbt;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt) {
        super.deserializeNBT(nbt);

        this.jingyan=nbt.getInteger("jingyan");
        this.age=nbt.getInteger("age");
    }


    public int getJingyan() {
        return jingyan;
    }

    public void setJingyan(int jingyan) {
        this.jingyan = jingyan;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
