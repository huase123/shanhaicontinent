package hua.huase.shanhaicontinent.item.jineng.huang;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.handers.HanderAny;
import hua.huase.shanhaicontinent.item.jineng.JinengMethond;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class WuHunHuangLSF extends Item implements JinengMethond
{
    public WuHunHuangLSF(String name, CreativeTabs Tabs)
    {
        super();
        this.setUnlocalizedName(ExampleMod.MODID + name);

        this.setRegistryName(name);
        this.setCreativeTab(Tabs);
        setMaxStackSize(1);
        HanderAny.itemList.add(this);
        JinengMethond.addJinengItem(this,"huang");
    }


    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        return JinengMethond.isBinding(stack,entityLiving);
    }


    public boolean canHarvestBlock(IBlockState blockIn)
    {
        return true;
    }


    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
        if(!JinengMethond.isBinding(item,player)){
            return false;
        }
            return true;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if(!JinengMethond.isBinding(playerIn.getHeldItem(handIn),playerIn)) {

            return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
        }
        playerIn.getCooldownTracker().setCooldown(this, 240);
//        playerIn.setActiveHand(handIn);

        if(!worldIn.isRemote){
            List<Entity> list = worldIn.getEntitiesWithinAABBExcludingEntity(playerIn, playerIn.getEntityBoundingBox().grow(8.0D,1.0D,8.0D));
            for (Entity entity : list) {
                if (!worldIn.isRemote&&entity!=null&&entity instanceof EntityLivingBase && playerIn!=null && entity !=playerIn)
                {
                    playerIn.setHealth((playerIn.getMaxHealth()-playerIn.getHealth())*0.5f+playerIn.getHealth());
                    entity.attackEntityFrom(DamageSource.causePlayerDamage(playerIn),playerIn.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY,null).getWugong()*1.0f);
                    worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 2.0F, 2.0F);


                }
            }

        }

        return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

//添加数据
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt)
    {
        return null;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {

        if(itemstack.getTagCompound()!=null&&itemstack.getTagCompound().getString("playername")!=null){
            list.add(net.minecraft.util.text.translation.I18n.translateToLocal("itembanding.player.sccuess")
                    +""+
                    itemstack.getTagCompound().getString("playername")
            );
        }else {
            list.add(net.minecraft.util.text.translation.I18n.translateToLocal("itembanding.player.fail"));
        }
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("item.wuhun.huang.lsf.list0"));
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("item.wuhun.huang.lsf.list1"));
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("item.wuhun.huang.lsf.list2"));

    }


    public void addAttributeModifiers(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityEquipmentSlot equipmentSlot) {
        if(JinengMethond.isBinding(itemStack,entityLivingBase)) {
        }
    }

    public void removeAttributeModifiers(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityEquipmentSlot equipmentSlot) {
    }



}
