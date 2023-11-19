package hua.huase.shanhaicontinent.item.jineng.jingubang;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.handers.HanderAny;
import hua.huase.shanhaicontinent.item.jineng.JinengMethond;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.UUID;

public class Wuqijingubang extends ItemSword implements JinengMethond
{
    public Wuqijingubang(String name, CreativeTabs Tabs)
    {
        super(EnumHelper.addToolMaterial(
                "hunqi",
                4,
                0,
                1.0F,
                66F,
                100));
        this.setUnlocalizedName(ExampleMod.MODID + name);

        this.setRegistryName(name);
        this.setCreativeTab(Tabs);
        HanderAny.itemList.add(this);
        JinengMethond.addJinengItem(this,"jingubang");
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        if(JinengMethond.isBinding(stack,attacker)){
            stack.damageItem(0, attacker);
            attacker.hurtResistantTime=4;
            return true;
        }
        return false;
    }


    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        return JinengMethond.isBinding(stack,entityLiving);
    }


    public boolean canHarvestBlock(IBlockState blockIn)
    {
        return true;
    }


    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        float speed = super.getDestroySpeed(stack, state);
        return  speed*15;
    }


    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
    {
        if(!JinengMethond.isBinding(item,player)){
            return false;
        }
            return true;
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


        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("item.jingubang.list0"));
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("item.jingubang.list1"));
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("item.jingubang.list2"));



    }

    @Override
    public void addAttributeModifiers(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityEquipmentSlot equipmentSlot) {
        if(JinengMethond.isBinding(itemStack,entityLivingBase)) {


            PlayerCapability capability = entityLivingBase.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
            entityLivingBase.getAttributeMap().applyAttributeModifiers(this.Multimap(capability));
            if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
                float v = ((int) ((capability.getDengji()) / 10f) + 1) * capability.getWugong() * 0.1f;
                if (itemStack.getTagCompound() == null) {
                    NBTTagCompound compound = new NBTTagCompound();
                    compound.setFloat("wugong", v);
                    itemStack.setTagCompound(compound);
                }
                itemStack.getTagCompound().setFloat("wugong", v);
                capability.addWugong(v);
            }
        }
    }

    @Override
    public void removeAttributeModifiers(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityEquipmentSlot equipmentSlot) {
        if(entityLivingBase instanceof EntityPlayer){
            PlayerCapability capability = entityLivingBase.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
            entityLivingBase.getAttributeMap().removeAttributeModifiers(this.Multimap(capability));

            if(equipmentSlot==EntityEquipmentSlot.MAINHAND) {
                if (itemStack.getTagCompound() == null) return;
                float wugong = itemStack.getTagCompound().getFloat("wugong");
                capability.addWugong(-wugong);
            }
        }
    }




    public Multimap<String, AttributeModifier> Multimap(PlayerCapability capability){

        Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();
        multimap.clear();


        multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", 1.0D, 2));
        multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", -2d+capability.getDengji()/20f, 0));
        multimap.put(EntityPlayer.REACH_DISTANCE.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", 2.0D, 0));
//        multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", (double)capability.getWugong(), 0));
//        multimap.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", capability.getMaxshengming(), 0));

        return multimap;
    }

    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {
        Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();
        return multimap;
    }


}
