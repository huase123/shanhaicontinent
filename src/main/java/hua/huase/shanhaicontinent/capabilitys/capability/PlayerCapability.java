package hua.huase.shanhaicontinent.capabilitys.capability;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;


/**
 * - @description:PlayerCapability类
 * - @author: huase。
 * - @date: 2025/10/12 3:37
 */
public class PlayerCapability extends AttributeBase{
//    经验  最大经验
//    精神力 最大精神力
//    等级 魂环快关
//    突破成功概率
//    武魂      魂环
//    魂骨
//    是否觉醒
//    先天魂力

    private float jingyan;
    private float maxjingyan;
    private float jingshenli;
    private float maxjingshenli;
    private int dengji;
    private int hunhuankuaiguan;
    private float tupochenggonggailv;

    ItemStackHandler wuhun =new ItemStackHandler();

    ItemStackHandler boneslot = new ItemStackHandler(7);

    private boolean isjuexing;
    private int xiantianhunli;


    public PlayerCapability() {
    }



    @Override
    public CompoundTag serializeNBT() {

        CompoundTag nbt = super.serializeNBT();
        nbt.putFloat("jingyan",jingyan);
        nbt.putFloat("maxjingyan",maxjingyan);
        nbt.putFloat("jingshenli",jingshenli);
        nbt.putFloat("tupochenggonggailv",tupochenggonggailv);
        nbt.putFloat("maxjingshenli",maxjingshenli);
        nbt.putInt("dengji",dengji);
        nbt.putInt("hunhuankuaiguan",hunhuankuaiguan);
        nbt.putInt("xiantianhunli",xiantianhunli);

        nbt.put("boneslot", boneslot.serializeNBT());
        nbt.put("wuhun", wuhun.serializeNBT());
        nbt.putBoolean("isjuexing", isjuexing);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        super.deserializeNBT(nbt);
        this.jingyan=nbt.getFloat("jingyan");
        this.maxjingyan=nbt.getFloat("maxjingyan");
        this.jingshenli=nbt.getFloat("jingshenli");
        this.tupochenggonggailv=nbt.getFloat("tupochenggonggailv");
        this.maxjingshenli=nbt.getFloat("maxjingshenli");
        this.dengji=nbt.getInt("dengji");
        this.hunhuankuaiguan=nbt.getInt("hunhuankuaiguan");
        this.xiantianhunli=nbt.getInt("xiantianhunli");
        if(nbt.get("boneslot")!=null){
            this.boneslot.deserializeNBT((CompoundTag) nbt.get("boneslot"));
        }
        if(nbt.get("wuhun")!=null){
            this.wuhun.deserializeNBT((CompoundTag) nbt.get("wuhun"));
        }
        this.isjuexing=nbt.getBoolean("isjuexing");
    }

    public float getJingyan() {
        return jingyan;
    }

    public void setJingyan(float jingyan) {
        this.jingyan = jingyan;
    }

    public float getMaxjingyan() {
        return maxjingyan;
    }

    public void setMaxjingyan(float maxjingyan) {
        this.maxjingyan = maxjingyan;
    }

    public float getJingshenli() {
        return jingshenli;
    }

    public void setJingshenli(float jingshenli) {
        this.jingshenli = jingshenli;
    }

    public float getMaxjingshenli() {
        return maxjingshenli;
    }

    public void setMaxjingshenli(float maxjingshenli) {
        this.maxjingshenli = maxjingshenli;
    }

    public int getDengji() {
        return dengji;
    }

    public void setDengji(int dengji) {
        this.dengji = dengji;
    }

    public int getHunhuankuaiguan() {
        return hunhuankuaiguan;
    }

    public void setHunhuankuaiguan(int hunhuankuaiguan) {
        this.hunhuankuaiguan = hunhuankuaiguan;
    }

    public float getTupochenggonggailv() {
        return tupochenggonggailv;
    }

    public void setTupochenggonggailv(float tupochenggonggailv) {
        this.tupochenggonggailv = tupochenggonggailv;
    }

    public ItemStackHandler getWuhun() {
        return wuhun;
    }

    public void setWuhun(ItemStackHandler wuhun) {
        this.wuhun = wuhun;
    }

    public ItemStackHandler getBoneslot() {
        return boneslot;
    }

    public void setBoneslot(ItemStackHandler boneslot) {
        this.boneslot = boneslot;
    }

    public boolean isIsjuexing() {
        return isjuexing;
    }

    public void setIsjuexing(boolean isjuexing) {
        this.isjuexing = isjuexing;
    }

    public int getXiantianhunli() {
        return xiantianhunli;
    }

    public void setXiantianhunli(int xiantianhunli) {
        this.xiantianhunli = xiantianhunli;
    }

    public void juexinWUhun(Player entity, ItemStack itemStack, int xiantianhunli) {
        this.xiantianhunli = xiantianhunli;
        wuhun.setStackInSlot(0,itemStack);
        entity.sendSystemMessage(Component.translatable("成功觉醒武魂").withStyle(ChatFormatting.YELLOW));

    }
    public void addWUhun(Player entity, ItemStack itemStack, int xiantianhunli) {
        ItemStackHandler itemStackHandler = new ItemStackHandler(wuhun.getSlots() + 1);
        for (int i = 0; i < wuhun.getSlots(); i++) {
            if(wuhun.getStackInSlot(i).is(itemStack.getItem())){
                entity.sendSystemMessage(Component.translatable("武魂添加失败，已觉醒该武魂").withStyle(ChatFormatting.GRAY));
                return;
            }
            itemStackHandler.setStackInSlot(i,wuhun.getStackInSlot(i));
        }

        itemStackHandler.setStackInSlot(wuhun.getSlots(),itemStack);

        entity.sendSystemMessage(Component.translatable("武魂添加成功").withStyle(ChatFormatting.YELLOW));
    }
}
