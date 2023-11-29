package hua.huase.shanhaicontinent.item.jineng.huang;

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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.UUID;

public class WuHunHuangyishenweizhong extends Item implements JinengMethond
{
    public WuHunHuangyishenweizhong(String name, CreativeTabs Tabs)
    {
        super();

        this.setUnlocalizedName(ExampleMod.MODID + name);
        this.setRegistryName(name);
        this.setCreativeTab(Tabs);
        HanderAny.itemList.add(this);
        JinengMethond.addJinengItem(this,"huang");
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


        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("item.wuhun.huang.yishenweizhong.list0"));
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("item.wuhun.huang.yishenweizhong.list1"));
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("item.wuhun.huang.yishenweizhong.list2"));



    }

    @Override
    public void addAttributeModifiers(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityEquipmentSlot equipmentSlot) {
        if(JinengMethond.isBinding(itemStack,entityLivingBase)) {


            PlayerCapability capability = entityLivingBase.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
            entityLivingBase.getAttributeMap().applyAttributeModifiers(this.Multimap(capability));
            if (equipmentSlot == EntityEquipmentSlot.OFFHAND) {
                float v = ((int) ((capability.getDengji()) / 10f) + 1) * capability.getWugong() * 0.04f;
                float v1 = ((int) ((capability.getDengji()) / 10f) + 1) * capability.getWufang() * 0.04f;
                float v2 = ((int) ((capability.getDengji()) / 10f) + 1) * capability.getZhenshang() * 0.04f;
                float v3 = ((int) ((capability.getDengji()) / 10f) + 1) * capability.getBaojishanghai() * 0.04f;
                float v4 = ((int) ((capability.getDengji()) / 10f) + 1) * capability.getKangbao() * 0.04f;
                float v5 = ((int) ((capability.getDengji()) / 10f) + 1) * capability.getShengminghuifu() * 0.04f;
                if (itemStack.getTagCompound() == null) {
                    NBTTagCompound compound = new NBTTagCompound();
                    compound.setFloat("wugong", v);
                    compound.setFloat("wufang", v1);
                    compound.setFloat("zhenshang", v2);
                    compound.setFloat("baoshang", v3);
                    compound.setFloat("kangbao", v4);
                    compound.setFloat("huifu", v5);
                    itemStack.setTagCompound(compound);
                }
                itemStack.getTagCompound().setFloat("wugong", v);
                itemStack.getTagCompound().setFloat("wufang", v1);
                itemStack.getTagCompound().setFloat("zhenshang", v2);
                itemStack.getTagCompound().setFloat("baoshang", v3);
                itemStack.getTagCompound().setFloat("kangbao", v4);
                itemStack.getTagCompound().setFloat("huifu", v5);
                capability.addWugong(v);
                capability.addWufang(v1);
                capability.addZhenshang(v2);
                capability.addBaojishanghai(v3);
                capability.addKangbao(v4);
                capability.addShengminghuifu(v5);
            }
        }
    }

    @Override
    public void removeAttributeModifiers(ItemStack itemStack, EntityLivingBase entityLivingBase, EntityEquipmentSlot equipmentSlot) {
        if(entityLivingBase instanceof EntityPlayer){
            PlayerCapability capability = entityLivingBase.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
            entityLivingBase.getAttributeMap().removeAttributeModifiers(this.Multimap(capability));

            if(equipmentSlot==EntityEquipmentSlot.OFFHAND) {
                if (itemStack.getTagCompound() == null) return;
                float v = itemStack.getTagCompound().getFloat("wugong");
                float v1 = itemStack.getTagCompound().getFloat("wufang");
                float v2 = itemStack.getTagCompound().getFloat("zhenshang");
                float v3 = itemStack.getTagCompound().getFloat("baoshang");
                float v4 = itemStack.getTagCompound().getFloat("kangbao");
                float v5 = itemStack.getTagCompound().getFloat("huifu");
                capability.addWugong(-v);
                capability.addWufang(-v1);
                capability.addZhenshang(-v2);
                capability.addBaojishanghai(-v3);
                capability.addKangbao(-v4);
                capability.addShengminghuifu(-v5);
            }
        }
    }




    public Multimap<String, AttributeModifier> Multimap(PlayerCapability capability){

        Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();
        multimap.clear();


        multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA9"), "Weapon modifier", 1.0D, 2));
        multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA9"), "Weapon modifier", -2d+capability.getDengji()/20f, 0));
//        multimap.put(EntityPlayer.REACH_DISTANCE.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", 2.0D, 0));
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
