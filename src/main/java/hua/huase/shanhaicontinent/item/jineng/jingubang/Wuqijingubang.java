package hua.huase.shanhaicontinent.item.jineng.jingubang;

import com.google.common.collect.Multimap;
import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.entity.jineng.EntityJiNengThread;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class Wuqijingubang extends ItemSword
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
    }

    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        stack.damageItem(0, attacker);
        target.addPotionEffect(new PotionEffect(MobEffects.WITHER,100,1,true,true));
        return true;
    }

    public boolean canHarvestBlock(IBlockState blockIn)
    {
        return true;
    }


    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        float speed = super.getDestroySpeed(stack, state);
        return  speed*25;
    }




    public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot)
    {

        Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);
        multimap.clear();

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND||equipmentSlot == EntityEquipmentSlot.OFFHAND)
        {
            multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", 1.0D, 2));
            multimap.put(EntityPlayer.REACH_DISTANCE.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", 2.0D, 0));
//            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", (double)this.getAttackDamage(), 0));
//            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", 4.0D, 0));
//            multimap.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", 100.0D, 0));



        }

        return multimap;
    }

    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {



    }




    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.getCooldownTracker().setCooldown(this, 400);
//        playerIn.setActiveHand(handIn);

        EntityPlayer entityLiving1 =  playerIn;

        float f = -MathHelper.sin(playerIn.rotationYaw * 0.017453292F) * MathHelper.cos(playerIn.rotationPitch * 0.017453292F);
        float f1 = -MathHelper.sin((playerIn.rotationPitch) * 0.017453292F);
        float f2 = MathHelper.cos(playerIn.rotationYaw * 0.017453292F) * MathHelper.cos(playerIn.rotationPitch * 0.017453292F);

        playerIn.motionX = 3.2*f;
        playerIn.motionY = 3.2*f1;
        playerIn.motionZ = 3.2*f2;




        if(!worldIn.isRemote){
            EntityJiNengThread jiNengThread = new EntityJiNengThread(worldIn,entityLiving1);
            jiNengThread.shoot(entityLiving1, entityLiving1.rotationPitch, entityLiving1.rotationYaw,0,2.0f,0.0f);
            worldIn.spawnEntity(jiNengThread);
            worldIn.playSound((EntityPlayer)null, entityLiving1.posX, entityLiving1.posY, entityLiving1.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 2.0F, 2.0F);
            entityLiving1.hurtResistantTime=20;
        }


        return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }

    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }







//添加数据
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt)
    {
        return null;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
//        list.remove(list.size()-1);
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("shendaozhijianlist1"));
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("shendaozhijianlist2"));
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("shendaozhijianlist3"));
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("shendaozhijianlist4"));
    }



}
