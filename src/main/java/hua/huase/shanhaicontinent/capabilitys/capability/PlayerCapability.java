package hua.huase.shanhaicontinent.capabilitys.capability;

import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapability;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.items.ItemStackHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
//    转生数

    private float jingyan;
    private float maxjingyan;
    private float jingshenli;
    private float maxjingshenli;
    private int dengji;
    private int hunhuankuaiguan;
    private float tupochenggonggailv;

    ItemStackHandler wuhun =new ItemStackHandler();

    ItemStackHandler boneslot = new ItemStackHandler(7);


    private int zhuanshengshu = 0;

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
        nbt.putInt("zhuanshengshu",zhuanshengshu);

        nbt.put("boneslot", boneslot.serializeNBT());
        nbt.put("wuhun", wuhun.serializeNBT());
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
        this.zhuanshengshu=nbt.getInt("zhuanshengshu");
        if(nbt.get("boneslot")!=null){
            this.boneslot.deserializeNBT((CompoundTag) nbt.get("boneslot"));
        }
        if(nbt.get("wuhun")!=null){
            this.wuhun.deserializeNBT((CompoundTag) nbt.get("wuhun"));
        }

    }

}
