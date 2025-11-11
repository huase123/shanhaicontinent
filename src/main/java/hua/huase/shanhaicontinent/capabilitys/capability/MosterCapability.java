package hua.huase.shanhaicontinent.capabilitys.capability;

import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.functiontypes.FunctionTypeInit;
import hua.huase.shanhaicontinent.functiontypes.functiontype.FunctionType;
import hua.huase.shanhaicontinent.init.SHRegistries;
import hua.huase.shanhaicontinent.item.ItemInit;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.List;

import static hua.huase.shanhaicontinent.SHMainBus.random;

/**
 * - @description:MosterCapability类
 * - @author: huase。
 * - @date: 2025/10/12 3:33
 */
public class MosterCapability extends AttributeBase implements Update{

    int nianxian;
    ItemStackHandler hunhuan = new ItemStackHandler();
    List<FunctionType> functionTypelist = new ArrayList();
    private boolean isupdate =true;

    public MosterCapability() {

    }
    public MosterCapability(Entity object) {

    }

    public boolean isIsupdate() {
        return isupdate;
    }

    public void setIsupdate(boolean isupdate) {
        this.isupdate = isupdate;
    }

    public List<FunctionType> getFunctionTypelist() {
        return functionTypelist;
    }

    public void setFunctionTypelist(List<FunctionType> functionTypelist) {
        this.functionTypelist = functionTypelist;
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
        nbt.putInt("nianxian", nianxian);
        nbt.put("hunhuan", hunhuan.serializeNBT());
        nbt.putBoolean("isupdate",isupdate);
        nbt.putInt("functionSize",functionTypelist.size());
        for (int i = 0; i < functionTypelist.size(); i++) {
            ResourceLocation key = SHRegistries.FUNCTION_TYPE_IForgeRegistry.getKey(functionTypelist.get(i));
            nbt.putString("functiontype"+i,key == null ? SHRegistries.FUNCTION_TYPE_IForgeRegistry.getKey(FunctionTypeInit.empty.get()).toString() : key.toString());
        }
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        this.nianxian = nbt.getInt("nianxian");
        isupdate = nbt.getBoolean("isupdate");
        if(nbt.get("hunhuan")!=null){
            this.hunhuan.deserializeNBT((CompoundTag) nbt.get("hunhuan"));
        }

        functionTypelist.clear();
        int functionSize = nbt.getInt("functionSize");
        for (int i = 0; i < functionSize; i++) {
            functionTypelist.add(SHRegistries.FUNCTION_TYPE_IForgeRegistry.getValue(new ResourceLocation(nbt.getString("functiontype"+i))));

        }
    }

    public void inti(Entity entity, int nianxian, FunctionType functionType) {
        this.nianxian = nianxian;
        this.addFunction(functionType);
        ItemStack hunhuan = new ItemStack(ItemInit.hunhuan0.get());
        hunhuan.getCapability(RegisterCapabilitys.HUNHUANCAPABILITY).ifPresent(c->{
            c.inti(entity,nianxian,functionType,hunhuan,this);
        });
        this.hunhuan.setStackInSlot(0,hunhuan);

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

    private void addFunction(FunctionType functionType) {
        functionTypelist.add(functionType);
    }


    @Override
    public float Hurt(LivingEntity directEntity, DamageSource source, float amount) {
        return super.Hurt(directEntity, source, amount);
    }
}
