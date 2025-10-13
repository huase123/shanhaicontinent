package hua.huase.shanhaicontinent.capabilitys.capability;

import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import hua.huase.shanhaicontinent.init.SHRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.items.ItemStackHandler;

import static hua.huase.shanhaicontinent.SHMainBus.random;

/**
 * - @description:MosterCapability类
 * - @author: huase。
 * - @date: 2025/10/12 3:33
 */
public class MosterCapability extends AttributeBase{

    int nianxian;
    ItemStackHandler hunhuan = new ItemStackHandler();
    FunctionType functionType;

    public FunctionType getFunctionType() {
        return functionType;
    }

    public int getNianxian() {
        return nianxian;
    }

    public void setNianxian(int nianxian) {
        this.nianxian = nianxian;
    }

    public ItemStackHandler getHunhuan() {
        return hunhuan;
    }

    public void setHunhuan(ItemStackHandler hunhuan) {
        this.hunhuan = hunhuan;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = super.serializeNBT();
        nbt.put("hunhuan", hunhuan.serializeNBT());
        ResourceLocation key = SHRegistries.FUNCTION_TYPE_Registry.getKey(functionType);
        nbt.putString("functiontype",key == null ? "air" : key.toString());
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        if(nbt.get("hunhuan")!=null){
            this.hunhuan.deserializeNBT((CompoundTag) nbt.get("hunhuan"));
        }
        functionType = SHRegistries.FUNCTION_TYPE_Registry.getValue(new ResourceLocation(nbt.getString("functiontype")));
    }

    public void inti(Entity entity, int nianxian, FunctionType functionType) {
        this.nianxian = nianxian;
        this.functionType = functionType;

        if(nianxian<100){
            float g = 2 + (float) nianxian / 10 + random.nextInt(10);
            float l= 10 + (float) nianxian / 20 ;

            super.setWugong(g);
            super.setWufang(g/3);
            super.setWuchuan(g/5);
            super.setZhenshang(g/10);
            super.setMaxshengming(10*g);
            super.setBaojilv(l);
            super.setBaojishanghai(5*l);
            super.setKangbao(3*l);
            super.setXixue((l/4));
            super.setMingzhong(l);
            super.setShanbi(l);
            super.setShengminghuifu(0);

        }else if(nianxian<1000){

            float g = 50 + (float) nianxian / 10 + random.nextInt(50);
            float l= 20 + (float) nianxian / 1000 * 10 ;

            super.setWugong(g*2);
            super.setWufang(g/3);
            super.setWuchuan(g/5);
            super.setZhenshang(g/10);
            super.setMaxshengming(20*g);
            super.setBaojilv(l);
            super.setBaojishanghai(5*l);
            super.setKangbao(3*l);
            super.setXixue((l/4));
            super.setMingzhong(l);
            super.setShanbi(l);
            super.setShengminghuifu(0);

        }else if(nianxian<10000){

            float g = 250 + (float) nianxian / 20 + random.nextInt(250);
            float l= 30 + (float) nianxian / 10000 * 10 ;

            super.setWugong(g*2);
            super.setWufang(g/3);
            super.setWuchuan(g/5);
            super.setZhenshang(g/10);
            super.setMaxshengming(30*g);
            super.setBaojilv(l);
            super.setBaojishanghai(5*l);
            super.setKangbao(3*l);
            super.setXixue((l/4));
            super.setMingzhong(l);
            super.setShanbi(l);
            super.setShengminghuifu(0);
        }else if(nianxian<100000){
            float g = 750 + (float) nianxian / 67 + random.nextInt(750);
            float l= 40 + (float) nianxian / 100000 * 10 ;

            super.setWugong(g*2);
            super.setWufang(g/3);
            super.setWuchuan(g/5);
            super.setZhenshang(g/10);
            super.setMaxshengming(40*g);
            super.setBaojilv(l);
            super.setBaojishanghai(5*l);
            super.setKangbao(3*l);
            super.setXixue((l/4));
            super.setMingzhong(l);
            super.setShanbi(l);
            super.setShengminghuifu(0);
        }else if(nianxian<1000000){

            float g = 3750 + (float) nianxian / 133 + random.nextInt(3750);
            float l= 50 + (float) nianxian / 1000000 * 10 ;

            super.setWugong(g*2);
            super.setWufang(g/3);
            super.setWuchuan(g/5);
            super.setZhenshang(g/10);
            super.setMaxshengming(50*g);
            super.setBaojilv(l);
            super.setBaojishanghai(5*l);
            super.setKangbao(3*l);
            super.setXixue((l/4));
            super.setMingzhong(l);
            super.setShanbi(l);
            super.setShengminghuifu(0);
        }else if(nianxian>=1000000){
            float g = 18750 + (float) nianxian / 300 + random.nextInt(18750);
            float l= 80 ;

            super.setWugong(g*2);
            super.setWufang(g/3);
            super.setWuchuan(g/5);
            super.setZhenshang(g/10);
            super.setMaxshengming(60*g);
            super.setBaojilv(l);
            super.setBaojishanghai(5*l);
            super.setKangbao(3*l);
            super.setXixue((l/4));
            super.setMingzhong(l);
            super.setShanbi(l);
            super.setShengminghuifu(0);
        }
    }


    @Override
    public float Hurt(LivingEntity directEntity, DamageSource source, float amount) {
        return super.Hurt(directEntity, source, amount);
    }
}
