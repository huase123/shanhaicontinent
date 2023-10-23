package hua.huase.shanhaicontinent.item.danfangdir;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.block.FlowerBlock;
import hua.huase.shanhaicontinent.capability.DanyaoItemCapabilityProvider;
import hua.huase.shanhaicontinent.handers.HanderAny;
import hua.huase.shanhaicontinent.network.FMLTutorGuiHandler;
import hua.huase.shanhaicontinent.tileentity.TileEntityPot;
import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemStackHandler;

import java.util.List;

public class DanFang extends Item implements DanFangBase {


    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
        if (this.isInCreativeTab(tab)) {
            list.add(new ItemStack(this, 1, 0));
            list.add(new ItemStack(this, 1, 1));
            list.add(new ItemStack(this, 1, 2));
            list.add(new ItemStack(this, 1, 3));
            list.add(new ItemStack(this, 1, 4));
            list.add(new ItemStack(this, 1, 5));
            list.add(new ItemStack(this, 1, 6));
            list.add(new ItemStack(this, 1, 7));
            list.add(new ItemStack(this, 1, 8));
        }
    }


    public int getMetadata(int damage)
    {
        return damage;
    }

    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "_age" + stack.getMetadata();
    }


    public DanFang(String name, CreativeTabs Tabs){
        super();
        setRegistryName(name);
        setUnlocalizedName(ExampleMod.MODID  +"."+  name);
        setCreativeTab(Tabs);
        setHasSubtypes(true);
        HanderAny.danfang= this;
        setMaxStackSize(16);
    }



    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        if (worldIn.isRemote)
        {
            BlockPos pos = playerIn.getPosition();
            int x = pos.getX(), y = pos.getY(), z = pos.getZ();
            playerIn.openGui(ExampleMod.MODID, FMLTutorGuiHandler.DANFANG, worldIn, x, y, z);
        }
        return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }


    public int update(TileEntityPot tileEntityPot, ItemStack danfang, ItemStackHandler solt0, ItemStackHandler solt1, ItemStackHandler slot7,int compressorProgress) {
        switch (this.getMetadata(danfang)){
            case 0:
                if (compressorProgress % 20 == 0) {
                    if (tileEntityPot.fuel!=0|| Items.COAL.equals(solt1.extractItem(0, 1, true).getItem())) {

                        if (compressorProgress == 40) {
                            ItemStack itemStack1 = solt1.extractItem(1, 1, true);
                            if (itemStack1.getItem() == HanderAny.baisuilan.itemBlock && itemStack1.getMetadata() == 1) {
                                solt1.extractItem(1, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 80) {
                            ItemStack itemStack1 = solt1.extractItem(2, 1, true);
                            if (itemStack1.getItem() == HanderAny.yueguanghua.itemBlock && itemStack1.getMetadata() == 1) {
                                solt1.extractItem(2, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }

                        if (compressorProgress == 120) {
                            ItemStack itemStack1 = solt1.extractItem(3, 1, true);
                            if (itemStack1.getItem() == HanderAny.baisuilan.itemBlock && itemStack1.getMetadata() == 1) {
                                solt1.extractItem(3, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 160) {
                            ItemStack itemStack1 = solt1.extractItem(4, 1, true);
                            if (itemStack1.getItem() == HanderAny.yueguanghua.itemBlock && itemStack1.getMetadata() == 1) {
                                solt1.extractItem(4, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 240) {
                            if (slot7.extractItem(0, 1, true).isEmpty()) {
                                ItemStack itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":danyao")), 1, 0, new DanyaoItemCapabilityProvider(0,0).serializeItemNBT());
                                slot7.insertItem(0, itemStack, false);
                                tileEntityPot.changeFuel();
                                tileEntityPot.getWorld().playEvent(1035, tileEntityPot.getPos(), 0);

                                return 0;
                            }
                            return compressorProgress;
                        }

                        return compressorProgress += 1;
                    }
                    return compressorProgress ;


                }
            return compressorProgress += 1;
            case 1:
                if (compressorProgress % 20 == 0) {
                    if (tileEntityPot.fuel!=0|| Items.COAL.equals(solt1.extractItem(0, 1, true).getItem())) {

                        if (compressorProgress == 40) {
                            ItemStack itemStack1 = solt1.extractItem(1, 1, true);
                            if (itemStack1.getItem() == HanderAny.zhushamei.itemBlock && itemStack1.getMetadata() == 2) {
                                solt1.extractItem(1, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 80) {
                            ItemStack itemStack1 = solt1.extractItem(2, 1, true);
                            if (itemStack1.getItem() == HanderAny.hanxiaohua.itemBlock && itemStack1.getMetadata() == 1) {
                                solt1.extractItem(2, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }

                        if (compressorProgress == 120) {
                            ItemStack itemStack1 = solt1.extractItem(3, 1, true);
                            if (itemStack1.getItem() == HanderAny.hehuan.itemBlock && itemStack1.getMetadata() == 1) {
                                solt1.extractItem(3, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 160) {
                            ItemStack itemStack1 = solt1.extractItem(4, 1, true);
                            if (itemStack1.getItem() == HanderAny.hanxiaohua.itemBlock && itemStack1.getMetadata() == 1) {
                                solt1.extractItem(4, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 200) {
                            ItemStack itemStack1 = solt1.extractItem(5, 1, true);
                            if (itemStack1.getItem() == HanderAny.hehuan.itemBlock && itemStack1.getMetadata() == 1) {
                                solt1.extractItem(5, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 240) {
                            if (slot7.extractItem(0, 1, true).isEmpty()) {
                                ItemStack itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":danyao")), 1, 1, new DanyaoItemCapabilityProvider(0,1).serializeItemNBT());
                                slot7.insertItem(0, itemStack, false);
                                tileEntityPot.changeFuel();
                                tileEntityPot.getWorld().playEvent(1035, tileEntityPot.getPos(), 0);

                                return 0;
                            }
                            return compressorProgress;
                        }

                        return compressorProgress += 1;
                    }
                    return compressorProgress ;


                }
            return compressorProgress += 1;
            case 2:
                if (compressorProgress % 20 == 0) {
                    if (tileEntityPot.fuel!=0|| Items.COAL.equals(solt1.extractItem(0, 1, true).getItem())) {

                        if (compressorProgress == 40) {
                            ItemStack itemStack1 = solt1.extractItem(1, 1, true);
                            ItemStack itemStack2 = solt1.extractItem(3, 1, true);
                            if (itemStack1.getItem() == HanderAny.yueguanghua.itemBlock && itemStack1.getMetadata() == 2&&
                                    itemStack2.getItem() == HanderAny.xunyicao.itemBlock && itemStack1.getMetadata() == 2) {
                                solt1.extractItem(1, 1, false);
                                solt1.extractItem(3, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 80) {
                            ItemStack itemStack1 = solt1.extractItem(2, 1, true);
                            if (itemStack1.getItem() == HanderAny.heshouwu.itemBlock && itemStack1.getMetadata() == 1) {
                                solt1.extractItem(2, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }

                        if (compressorProgress == 120) {
                            ItemStack itemStack1 = solt1.extractItem(3, 1, true);
                            if (itemStack1.getItem() == HanderAny.qiuhaitang.itemBlock && itemStack1.getMetadata() == 1) {
                                solt1.extractItem(3, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 160) {
                            ItemStack itemStack1 = solt1.extractItem(4, 1, true);
                            if (itemStack1.getItem() == HanderAny.heshouwu.itemBlock && itemStack1.getMetadata() == 1) {
                                solt1.extractItem(4, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 200) {
                            ItemStack itemStack1 = solt1.extractItem(5, 1, true);
                            if (itemStack1.getItem() == HanderAny.qiuhaitang.itemBlock && itemStack1.getMetadata() == 1) {
                                solt1.extractItem(5, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 240) {
                            if (slot7.extractItem(0, 1, true).isEmpty()) {
                                ItemStack itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":danyao")), 1, 2, new DanyaoItemCapabilityProvider(0,2).serializeItemNBT());
                                slot7.insertItem(0, itemStack, false);
                                tileEntityPot.changeFuel();
                                tileEntityPot.getWorld().playEvent(1035, tileEntityPot.getPos(), 0);

                                return 0;
                            }
                            return compressorProgress;
                        }

                        return compressorProgress += 1;
                    }
                    return compressorProgress ;


                }
            return compressorProgress += 1;
            case 3:
                if (compressorProgress % 20 == 0) {
                    if (tileEntityPot.fuel!=0|| Items.COAL.equals(solt1.extractItem(0, 1, true).getItem())) {

                        if (compressorProgress == 40) {
                            ItemStack itemStack1 = solt1.extractItem(1, 1, true);
                            if (itemStack1.getItem() == HanderAny.xiwu.itemBlock && itemStack1.getMetadata() == 2) {
                                solt1.extractItem(1, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 80) {
                            ItemStack itemStack1 = solt1.extractItem(2, 1, true);
                            if (itemStack1.getItem() == HanderAny.shancha.itemBlock && itemStack1.getMetadata() == 2) {
                                solt1.extractItem(2, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }

                        if (compressorProgress == 120) {
                            ItemStack itemStack1 = solt1.extractItem(3, 1, true);
                            if (itemStack1.getItem() == HanderAny.qiuhaitang.itemBlock && itemStack1.getMetadata() == 2) {
                                solt1.extractItem(3, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 160) {
                            ItemStack itemStack1 = solt1.extractItem(4, 1, true);
                            if (itemStack1.getItem() == HanderAny.wangyoucao.itemBlock && itemStack1.getMetadata() == 2) {
                                solt1.extractItem(4, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 200) {
                            ItemStack itemStack1 = solt1.extractItem(5, 1, true);
                            if (itemStack1.getItem() == HanderAny.xiwu.itemBlock && itemStack1.getMetadata() == 2) {
                                solt1.extractItem(5, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 240) {
                            if (slot7.extractItem(0, 1, true).isEmpty()) {
                                ItemStack itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":danyao")), 1, 3, new DanyaoItemCapabilityProvider(0,3).serializeItemNBT());
                                slot7.insertItem(0, itemStack, false);
                                tileEntityPot.changeFuel();
                                tileEntityPot.getWorld().playEvent(1035, tileEntityPot.getPos(), 0);

                                return 0;
                            }
                            return compressorProgress;
                        }

                        return compressorProgress += 1;
                    }
                    return compressorProgress ;


                }
            return compressorProgress += 1;
            case 4:
                if (compressorProgress % 20 == 0) {
                    if (tileEntityPot.fuel!=0|| Items.COAL.equals(solt1.extractItem(0, 1, true).getItem())) {

                        if (compressorProgress == 40) {
                            ItemStack itemStack1 = solt1.extractItem(1, 1, true);
                            ItemStack itemStack2 = solt1.extractItem(5, 1, true);
                            if (itemStack1.getItem() == HanderAny.qiuhaitang.itemBlock && itemStack1.getMetadata() == 3&&
                                    itemStack2.getItem() == HanderAny.shancha.itemBlock && itemStack2.getMetadata() == 3) {
                                solt1.extractItem(1, 1, false);
                                solt1.extractItem(5, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 80) {
                            ItemStack itemStack1 = solt1.extractItem(2, 1, true);
                            if (itemStack1.getItem() == HanderAny.heshouwu.itemBlock && itemStack1.getMetadata() == 2) {
                                solt1.extractItem(2, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }

                        if (compressorProgress == 120) {
                            ItemStack itemStack1 = solt1.extractItem(3, 1, true);
                            if (itemStack1.getItem() == HanderAny.hehuan.itemBlock && itemStack1.getMetadata() == 2) {
                                solt1.extractItem(3, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 160) {
                            ItemStack itemStack1 = solt1.extractItem(4, 1, true);
                            if (itemStack1.getItem() == HanderAny.heshouwu.itemBlock && itemStack1.getMetadata() == 2) {
                                solt1.extractItem(4, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 200) {
                            ItemStack itemStack1 = solt1.extractItem(5, 1, true);
                            if (itemStack1.getItem() == HanderAny.hehuan.itemBlock && itemStack1.getMetadata() == 2) {
                                solt1.extractItem(5, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 240) {
                            if (slot7.extractItem(0, 1, true).isEmpty()) {
                                ItemStack itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":danyao")), 1, 4, new DanyaoItemCapabilityProvider(0,4).serializeItemNBT());
                                slot7.insertItem(0, itemStack, false);
                                tileEntityPot.changeFuel();
                                tileEntityPot.getWorld().playEvent(1035, tileEntityPot.getPos(), 0);

                                return 0;
                            }
                            return compressorProgress;
                        }

                        return compressorProgress += 1;
                    }
                    return compressorProgress ;


                }
            return compressorProgress += 1;
            case 5:
                if (compressorProgress % 20 == 0) {
                    if (tileEntityPot.fuel!=0|| Items.COAL.equals(solt1.extractItem(0, 1, true).getItem())) {

                        if (compressorProgress == 40) {
                            ItemStack itemStack1 = solt1.extractItem(1, 1, true);
                            ItemStack itemStack2 = solt1.extractItem(5, 1, true);
                            if (itemStack1.getItem() == HanderAny.hanxiaohua.itemBlock && itemStack1.getMetadata() == 4&&
                                    itemStack2.getItem() == HanderAny.baisuilan.itemBlock && itemStack2.getMetadata() == 3) {
                                solt1.extractItem(1, 1, false);
                                solt1.extractItem(5, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 80) {
                            ItemStack itemStack1 = solt1.extractItem(2, 1, true);
                            if (itemStack1.getItem() == HanderAny.zhushamei.itemBlock && itemStack1.getMetadata() == 3) {
                                solt1.extractItem(2, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }

                        if (compressorProgress == 120) {
                            ItemStack itemStack1 = solt1.extractItem(3, 1, true);
                            if (itemStack1.getItem() == HanderAny.yueguanghua.itemBlock && itemStack1.getMetadata() == 3) {
                                solt1.extractItem(3, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 160) {
                            ItemStack itemStack1 = solt1.extractItem(4, 1, true);
                            if (itemStack1.getItem() == HanderAny.zhushamei.itemBlock && itemStack1.getMetadata() == 3) {
                                solt1.extractItem(4, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 200) {
                            ItemStack itemStack1 = solt1.extractItem(5, 1, true);
                            if (itemStack1.getItem() == HanderAny.yueguanghua.itemBlock && itemStack1.getMetadata() == 3) {
                                solt1.extractItem(5, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 240) {
                            if (slot7.extractItem(0, 1, true).isEmpty()) {
                                ItemStack itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":danyao")), 1, 5, new DanyaoItemCapabilityProvider(0,5).serializeItemNBT());
                                slot7.insertItem(0, itemStack, false);
                                tileEntityPot.changeFuel();
                                tileEntityPot.getWorld().playEvent(1035, tileEntityPot.getPos(), 0);

                                return 0;
                            }
                            return compressorProgress;
                        }

                        return compressorProgress += 1;
                    }
                    return compressorProgress ;


                }
            return compressorProgress += 1;
            case 6:
                if (compressorProgress % 20 == 0) {
                    if (tileEntityPot.fuel!=0|| Items.COAL.equals(solt1.extractItem(0, 1, true).getItem())) {

                        if (compressorProgress == 40) {
                            ItemStack itemStack1 = solt1.extractItem(1, 1, true);
                            if (itemStack1.getItem() == HanderAny.baisuilan.itemBlock && itemStack1.getMetadata() == 4) {
                                solt1.extractItem(1, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 80) {
                            ItemStack itemStack1 = solt1.extractItem(5, 1, true);
                            if (itemStack1.getItem() == HanderAny.hehuan.itemBlock && itemStack1.getMetadata() == 4) {
                                solt1.extractItem(5, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }

                        if (compressorProgress == 120) {
                            ItemStack itemStack1 = solt1.extractItem(3, 1, true);
                            if (itemStack1.getItem() == HanderAny.fengxinzi.itemBlock && itemStack1.getMetadata() == 4) {
                                solt1.extractItem(3, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 160) {
                            ItemStack itemStack1 = solt1.extractItem(4, 1, true);
                            if (itemStack1.getItem() == HanderAny.hanxiaohua.itemBlock && itemStack1.getMetadata() == 4) {
                                solt1.extractItem(4, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 200) {
                            ItemStack itemStack1 = solt1.extractItem(5, 1, true);
                            if (itemStack1.getItem() == HanderAny.hehuan.itemBlock && itemStack1.getMetadata() == 4) {
                                solt1.extractItem(5, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 240) {
                            if (slot7.extractItem(0, 1, true).isEmpty()) {
                                ItemStack itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":danyao")), 1, 6, new DanyaoItemCapabilityProvider(0,6).serializeItemNBT());
                                slot7.insertItem(0, itemStack, false);
                                tileEntityPot.changeFuel();
                                tileEntityPot.getWorld().playEvent(1035, tileEntityPot.getPos(), 0);

                                return 0;
                            }
                            return compressorProgress;
                        }

                        return compressorProgress += 1;
                    }
                    return compressorProgress ;


                }
            return compressorProgress += 1;
            case 7:
                if (compressorProgress % 20 == 0) {
                    if (tileEntityPot.fuel!=0|| Items.COAL.equals(solt1.extractItem(0, 1, true).getItem())) {

                        if (compressorProgress == 40) {
                            ItemStack itemStack1 = solt1.extractItem(1, 1, true);
                            if (itemStack1.getItem() == HanderAny.qiuhaitang.itemBlock && itemStack1.getMetadata() == 5) {
                                solt1.extractItem(1, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 80) {
                            ItemStack itemStack1 = solt1.extractItem(5, 1, true);
                            if (itemStack1.getItem() == HanderAny.shancha.itemBlock && itemStack1.getMetadata() == 5) {
                                solt1.extractItem(5, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }

                        if (compressorProgress == 120) {
                            ItemStack itemStack1 = solt1.extractItem(3, 1, true);
                            if (itemStack1.getItem() == HanderAny.wangyoucao.itemBlock && itemStack1.getMetadata() == 5) {
                                solt1.extractItem(3, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 160) {
                            ItemStack itemStack1 = solt1.extractItem(4, 1, true);
                            if (itemStack1.getItem() == HanderAny.xiwu.itemBlock && itemStack1.getMetadata() == 5) {
                                solt1.extractItem(4, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 200) {
                            ItemStack itemStack1 = solt1.extractItem(5, 1, true);
                            if (itemStack1.getItem() == HanderAny.xunyicao.itemBlock && itemStack1.getMetadata() == 4) {
                                solt1.extractItem(5, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 240) {
                            if (slot7.extractItem(0, 1, true).isEmpty()) {
                                ItemStack itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":danyao")), 1, 7, new DanyaoItemCapabilityProvider(0,7).serializeItemNBT());
                                slot7.insertItem(0, itemStack, false);
                                tileEntityPot.changeFuel();
                                tileEntityPot.getWorld().playEvent(1035, tileEntityPot.getPos(), 0);

                                return 0;
                            }
                            return compressorProgress;
                        }

                        return compressorProgress += 1;
                    }
                    return compressorProgress ;


                }
            return compressorProgress += 1;
            case 8:
                if (compressorProgress % 20 == 0) {
                    if (tileEntityPot.fuel!=0|| Items.COAL.equals(solt1.extractItem(0, 1, true).getItem())) {

                        if (compressorProgress == 40) {
                            ItemStack itemStack1 = solt1.extractItem(1, 1, true);
                            if (Block.getBlockFromItem(itemStack1.getItem()) instanceof FlowerBlock && itemStack1.getMetadata() == 6) {
                                solt1.extractItem(1, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 80) {
                            ItemStack itemStack1 = solt1.extractItem(5, 1, true);
                            if (itemStack1.getItem() == HanderAny.yueguanghua.itemBlock && itemStack1.getMetadata() == 5) {
                                solt1.extractItem(5, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }

                        if (compressorProgress == 120) {
                            ItemStack itemStack1 = solt1.extractItem(3, 1, true);
                            if (itemStack1.getItem() == HanderAny.zhushamei.itemBlock && itemStack1.getMetadata() == 5) {
                                solt1.extractItem(3, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 160) {
                            ItemStack itemStack1 = solt1.extractItem(4, 1, true);
                            if (itemStack1.getItem() == HanderAny.hehuan.itemBlock && itemStack1.getMetadata() == 5) {
                                solt1.extractItem(4, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 200) {
                            ItemStack itemStack1 = solt1.extractItem(5, 1, true);
                            if (itemStack1.getItem() == HanderAny.shancha.itemBlock && itemStack1.getMetadata() == 5) {
                                solt1.extractItem(5, 1, false);
                                tileEntityPot.changeFuel();
                            } else {
                                return compressorProgress;
                            }

                        }
                        if (compressorProgress == 240) {
                            if (slot7.extractItem(0, 1, true).isEmpty()) {
                                ItemStack itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":danyao")), 1, 8, new DanyaoItemCapabilityProvider(0,8).serializeItemNBT());
                                slot7.insertItem(0, itemStack, false);
                                tileEntityPot.changeFuel();
                                tileEntityPot.getWorld().playEvent(1035, tileEntityPot.getPos(), 0);

                                return 0;
                            }
                            return compressorProgress;
                        }

                        return compressorProgress += 1;
                    }
                    return compressorProgress ;


                }
            return compressorProgress += 1;




            default:
                return compressorProgress;
        }


    }

    @Override
    public boolean canUpdate() {
        return true;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
        String effect = I18n.format("");
        String material = I18n.format("");

        switch (this.getMetadata(itemstack)) {
            case 0:
                effect = I18n.format("danfang.qihundan.effect");
                material = I18n.format("danfang.qihundan.material");
                break;

            case 1:
                effect = I18n.format("danfang.jvlingdan.effect");
                material = I18n.format("danfang.jvlingdan.material");
                break;

            case 2:
                effect = I18n.format("danfang.xvanyuandan.effect");
                material = I18n.format("danfang.xvanyuandan.material");
                break;

            case 3:
                effect = I18n.format("danfang.yanghundan.effect");
                material = I18n.format("danfang.yanghundan.material");
                break;

            case 4:
                effect = I18n.format("danfang.lingbidan.effect");
                material = I18n.format("danfang.lingbidan.material");
                break;

            case 5:
                effect = I18n.format("danfang.haoyuan.effect");
                material = I18n.format("danfang.haoyuan.material");
                break;

            case 6:
                effect = I18n.format("danfang.xihundan.effect");
                material = I18n.format("danfang.xihundan.material");
                break;

            case 7:
                effect = I18n.format("danfang.huangjidan.effect");
                material = I18n.format("danfang.huangjidan.material");
                break;

            case 8:
                effect = I18n.format("danfang.lushendan.effect");
                material = I18n.format("danfang.lushendan.material");
                break;


            default:
                ;
                break;

        }

        list.add(effect);
        list.add(material);
    }


}
