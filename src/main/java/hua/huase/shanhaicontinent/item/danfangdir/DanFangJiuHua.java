package hua.huase.shanhaicontinent.item.danfangdir;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.capability.DanyaoItemCapabilityProvider;
import hua.huase.shanhaicontinent.handers.HanderAny;
import hua.huase.shanhaicontinent.network.FMLTutorGuiHandler;
import hua.huase.shanhaicontinent.tileentity.TileEntityPot;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemStackHandler;

import java.util.List;

public class DanFangJiuHua extends Item implements DanFangBase {

//
//    @Override
//    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
//        if (this.isInCreativeTab(tab)) {
//            list.add(new ItemStack(this, 1, 0));
//            list.add(new ItemStack(this, 1, 1));
//            list.add(new ItemStack(this, 1, 2));
//            list.add(new ItemStack(this, 1, 3));
//            list.add(new ItemStack(this, 1, 4));
//            list.add(new ItemStack(this, 1, 5));
//            list.add(new ItemStack(this, 1, 6));
//            list.add(new ItemStack(this, 1, 7));
//            list.add(new ItemStack(this, 1, 8));
//        }
//    }

//
//    public int getMetadata(int damage)
//    {
//        return damage;
//    }
//
//    public String getUnlocalizedName(ItemStack stack)
//    {
//        return super.getUnlocalizedName() + "_age" + stack.getMetadata();
//    }
//

    public DanFangJiuHua(String name, CreativeTabs Tabs){
        super();
        setRegistryName(name);
        setUnlocalizedName(ExampleMod.MODID  +"."+  name);
        setCreativeTab(Tabs);
        setHasSubtypes(true);
        HanderAny.danfangjiuhua= this;
        setMaxStackSize(16);

        HanderAny.itemList.add(this);
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
        if(danfang.getItem()instanceof DanFangJiuHua){

            if (compressorProgress % 20 == 0) {
                if (tileEntityPot.fuel!=0|| Items.COAL.equals(solt1.extractItem(0, 1, true).getItem())) {

                    if (compressorProgress == 40) {
                        ItemStack itemStack1 = solt1.extractItem(1, 1, true);
                        if (itemStack1.getItem() == HanderAny.hehuan.itemBlock  && itemStack1.getMetadata() >= 2) {
                            solt1.extractItem(1, 1, false);
                            tileEntityPot.changeFuel();
                        } else {
                            return compressorProgress;
                        }

                    }
                    if (compressorProgress == 80) {
                        ItemStack itemStack1 = solt1.extractItem(2, 1, true);
                        if (itemStack1.getItem() == HanderAny.qiuhaitang.itemBlock  && itemStack1.getMetadata() >= 2) {
                            solt1.extractItem(2, 1, false);
                            tileEntityPot.changeFuel();
                        } else {
                            return compressorProgress;
                        }

                    }

                    if (compressorProgress == 120) {
                        ItemStack itemStack1 = solt1.extractItem(3, 1, true);
                        if (itemStack1.getItem() == HanderAny.shancha.itemBlock && itemStack1.getMetadata() >= 2) {
                            solt1.extractItem(3, 1, false);
                            tileEntityPot.changeFuel();
                        } else {
                            return compressorProgress;
                        }

                    }
                    if (compressorProgress == 160) {
                        ItemStack itemStack1 = solt1.extractItem(4, 1, true);
                        if (itemStack1.getItem() == HanderAny.xiwu.itemBlock && itemStack1.getMetadata() >= 2) {
                            solt1.extractItem(4, 1, false);
                            tileEntityPot.changeFuel();
                        } else {
                            return compressorProgress;
                        }

                    }

                    if (compressorProgress == 200) {
                        ItemStack itemStack1 = solt1.extractItem(5, 1, true);
                        if (itemStack1.getItem() == HanderAny.yueguanghua.itemBlock  && itemStack1.getMetadata() >= 2) {
                            solt1.extractItem(5, 1, false);
                            tileEntityPot.changeFuel();
                        } else {
                            return compressorProgress;
                        }

                    }


                    if (compressorProgress == 240) {
                        if (slot7.extractItem(0, 1, true).isEmpty()) {
                            ItemStack itemStack = new ItemStack(HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":danyaojiuhua")), 1, 0, new DanyaoItemCapabilityProvider(2,0).serializeItemNBT());
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
        }

        return compressorProgress;
    }

    @Override
    public boolean canUpdate() {
        return true;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
        String effect = I18n.format("danfang.jiuhua.effect");
        String material = I18n.format("danfang.jiuhua.material");


        list.add(effect);
        list.add(material);
    }


}
