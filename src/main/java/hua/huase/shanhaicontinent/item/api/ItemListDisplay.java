package hua.huase.shanhaicontinent.item.api;

import hua.huase.shanhaicontinent.capability.DanyaoItemCapability;
import hua.huase.shanhaicontinent.capability.ItemCapability;
import net.minecraft.util.text.translation.I18n;

import java.util.List;

public interface ItemListDisplay {
    static void addBoneLsit(List list, ItemCapability capability){

//        list.clear();
        if(capability.getNianxian()>0)	list.add(I18n.translateToLocalFormatted("hungu.nianxian", capability.getNianxian()));
        if(capability.getWugong()>0)	list.add(I18n.translateToLocalFormatted("hungu:wugong", capability.getWugong()));
        if(capability.getBaojishanghai()>0)	list.add(I18n.translateToLocalFormatted("hungu:baojishanghai", capability.getBaojishanghai()));
        if(capability.getBaojilv()>0)	list.add(I18n.translateToLocalFormatted("hungu:baojilv", capability.getBaojilv()));
        if(capability.getZhenshang()>0)	list.add(I18n.translateToLocalFormatted("hungu:zhenshang", capability.getZhenshang()));
        if(capability.getYuanshushanghai()>0)	list.add(I18n.translateToLocalFormatted("hungu:yuanshushanghai", capability.getYuanshushanghai()));
        if(capability.getXixue()>0)	list.add(I18n.translateToLocalFormatted("hungu:xixue", capability.getXixue()));
        if(capability.getWufang()>0)	list.add(I18n.translateToLocalFormatted("hungu:wufang", capability.getWufang()));
        if(capability.getYuansukangxing()>0)	list.add(I18n.translateToLocalFormatted("hungu:yuansukangxing", capability.getYuansukangxing()));
        if(capability.getMaxshengming()>0)	list.add(I18n.translateToLocalFormatted("hungu:maxshengming", capability.getMaxshengming()));
        if(capability.getShengminghuifu()>0)	list.add(I18n.translateToLocalFormatted("hungu:shengminghuifu", capability.getShengminghuifu()));
        if(capability.getMinghzong()>0)	list.add(I18n.translateToLocalFormatted("hungu:minghzong", capability.getMinghzong()));
        if(capability.getShanbi()>0)	list.add(I18n.translateToLocalFormatted("hungu:shanbi", capability.getShanbi()));
        if(capability.getJingshenli()>0)	list.add(I18n.translateToLocalFormatted("hungu:jingshenli", capability.getJingshenli()));
        if(capability.getHunlizhi()>0)	list.add(I18n.translateToLocalFormatted("hungu:hunlizhi", capability.getHunlizhi()));
        if(capability.getRenxing()>0)	list.add(I18n.translateToLocalFormatted("hungu:renxing", capability.getRenxing()));
        if(capability.getWuchuan()>0)	list.add(I18n.translateToLocalFormatted("hungu:wuchuan", capability.getWuchuan()));
        if(capability.getKangbao()>0)	list.add(I18n.translateToLocalFormatted("hungu:kangbao", capability.getKangbao()));
    };


    static void addDanyaoLsit(List list, DanyaoItemCapability capability){

//        list.clear();
        if(capability.getJingyan()>0)	list.add(I18n.translateToLocalFormatted("hungu:jingyan", capability.getJingyan()));
        if(capability.getWugong()>0)	list.add(I18n.translateToLocalFormatted("hungu:wugong", capability.getWugong()));
        if(capability.getBaojishanghai()>0)	list.add(I18n.translateToLocalFormatted("hungu:baojishanghai", capability.getBaojishanghai()));
        if(capability.getBaojilv()>0)	list.add(I18n.translateToLocalFormatted("hungu:baojilv", capability.getBaojilv()));
        if(capability.getZhenshang()>0)	list.add(I18n.translateToLocalFormatted("hungu:zhenshang", capability.getZhenshang()));
        if(capability.getXixue()>0)	list.add(I18n.translateToLocalFormatted("hungu:xixue", capability.getXixue()));
        if(capability.getWufang()>0)	list.add(I18n.translateToLocalFormatted("hungu:wufang", capability.getWufang()));
        if(capability.getShengming()>0)	list.add(I18n.translateToLocalFormatted("hungu:maxshengming", capability.getShengming()));
        if(capability.getShengminghuifu()>0)	list.add(I18n.translateToLocalFormatted("hungu:shengminghuifu", capability.getShengminghuifu()));
        if(capability.getMinghzong()>0)	list.add(I18n.translateToLocalFormatted("hungu:minghzong", capability.getMinghzong()));
        if(capability.getShanbi()>0)	list.add(I18n.translateToLocalFormatted("hungu:shanbi", capability.getShanbi()));
        if(capability.getWuchuan()>0)	list.add(I18n.translateToLocalFormatted("hungu:wuchuan", capability.getWuchuan()));
        if(capability.getKangbao()>0)	list.add(I18n.translateToLocalFormatted("hungu:kangbao", capability.getKangbao()));










    };
}
