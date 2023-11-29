package hua.huase.shanhaicontinent.item.jineng.huang;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.entity.jineng.huang.EntityWuHunHuangKPBS;
import hua.huase.shanhaicontinent.handers.HanderAny;
import hua.huase.shanhaicontinent.item.jineng.JinengMethond;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class WuHunHuangKPBS extends Item implements JinengMethond
{
    public WuHunHuangKPBS(String name, CreativeTabs Tabs)
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
        playerIn.getCooldownTracker().setCooldown(this, 200);
        EntityPlayer entityLiving1 =  playerIn;

//        playerIn.motionX = 3.2*f;
//        playerIn.motionY = 3.2*f1;
//        playerIn.motionZ = 3.2*f2;

        playerIn.world.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_LIGHTNING_IMPACT, SoundCategory.PLAYERS, 100.0F,   1.1F);
//        playerIn.world.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_LIGHTNING_IMPACT, SoundCategory.PLAYERS, 2.0F, 0.5F + 0.1F);

        if(!worldIn.isRemote){

            EntityWuHunHuangKPBS jiNengThread = new EntityWuHunHuangKPBS(worldIn,playerIn);
            jiNengThread.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw,0,2f,0.0f);
            worldIn.spawnEntity(jiNengThread);
            worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 2.0F, 2.0F);
            entityLiving1.hurtResistantTime=20;


        }

        float f = -MathHelper.sin(playerIn.rotationYaw * 0.017453292F) * MathHelper.cos(playerIn.rotationPitch * 0.017453292F);
        float f1 = -MathHelper.sin((playerIn.rotationPitch) * 0.017453292F);
        float f2 = MathHelper.cos(playerIn.rotationYaw * 0.017453292F) * MathHelper.cos(playerIn.rotationPitch * 0.017453292F);
        playerIn.setPosition(playerIn.posX+10.0*f, playerIn.posY+10.0*f1, playerIn.posZ+10.0*f2);
        playerIn.motionX = 3.2*f;
        playerIn.motionY = 3.2*f1;
        playerIn.motionZ = 3.2*f2;
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
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("item.wuhun.huang.kpbs.list0"));
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("item.wuhun.huang.kpbs.list1"));
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("item.wuhun.huang.kpbs.list2"));

    }


    public void addAttributeModifiers(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityEquipmentSlot equipmentSlot) {
        if(JinengMethond.isBinding(itemStack,entityLivingBase)) {
        }
    }

    public void removeAttributeModifiers(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityEquipmentSlot equipmentSlot) {
    }



}
