package hua.huase.shanhaicontinent.item;

import com.google.common.collect.Multimap;
import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.entity.jineng.EntityJiNengThread;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
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
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

import static hua.huase.shanhaicontinent.WorldGen.HanderBiome.dimensionTypeSH_ONE_ID;
import static hua.huase.shanhaicontinent.handers.HanderAny.shportal;

public class ItemTextSword extends ItemSword
{
    public ItemTextSword(String name, CreativeTabs Tabs)
    {
        super(EnumHelper.addToolMaterial(
                "weishenqi",
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

        if (equipmentSlot == EntityEquipmentSlot.MAINHAND)
        {
            multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", 1.0D, 2));
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", (double)this.getAttackDamage(), 0));
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", 4.0D, 0));
//            multimap.put(SharedMonsterAttributes.MAX_HEALTH.getName(), new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "Weapon modifier", 100.0D, 0));



        }

        return multimap;
    }

    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {



    }




    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.getCooldownTracker().setCooldown(this, 40);
//        playerIn.setActiveHand(handIn);

        EntityPlayer entityLiving1 =  playerIn;

        float f = -MathHelper.sin(playerIn.rotationYaw * 0.017453292F) * MathHelper.cos(playerIn.rotationPitch * 0.017453292F);
        float f1 = -MathHelper.sin((playerIn.rotationPitch) * 0.017453292F);
        float f2 = MathHelper.cos(playerIn.rotationYaw * 0.017453292F) * MathHelper.cos(playerIn.rotationPitch * 0.017453292F);

        playerIn.motionX = 3.2*f;
        playerIn.motionY = 3.2*f1;
        playerIn.motionZ = 3.2*f2;




        if(!worldIn.isRemote) {
            EntityJiNengThread jiNengThread = new EntityJiNengThread(worldIn, entityLiving1);
            jiNengThread.shoot(entityLiving1, entityLiving1.rotationPitch, entityLiving1.rotationYaw, 0, 2.0f, 0.0f);
            worldIn.spawnEntity(jiNengThread);
            worldIn.playSound((EntityPlayer) null, entityLiving1.posX, entityLiving1.posY, entityLiving1.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 2.0F, 2.0F);
            entityLiving1.hurtResistantTime = 20;


            for (int i = 0; i < 360; i++) {
                double d0 = (double) (-MathHelper.sin(i * 0.017453292F));
                double d1 = (double) MathHelper.cos(i * 0.017453292F);

                ((WorldServer) worldIn).spawnParticle(EnumParticleTypes.REDSTONE, entityLiving1.posX + d0, entityLiving1.posY + (double) entityLiving1.height * 0.5D, entityLiving1.posZ + d1, 0, d0, 0.0D, d1, 1.0D);

            }

            worldIn.setBlockState(playerIn.getPosition().down(),shportal.getDefaultState());



//            ((EntityPlayerMP) playerIn).changeDimension(21,new CommandTeleporter(playerIn.getPosition()));
            switch (worldIn.provider.getDimension()) {
                case 1217:
//                地狱
                    playerIn.changeDimension(0,new CommandTeleporter(playerIn.getPosition()));
                    break;
                case 0:
//                主世界
                    playerIn.changeDimension(dimensionTypeSH_ONE_ID,new CommandTeleporter(playerIn.getPosition()));
                    break;
                case 1:
//                末地
                    break;
                default:
                    playerIn.changeDimension(worldIn.provider.getDimension()+1,new CommandTeleporter(playerIn.getPosition()));
                    break;
            }





        }



        return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }






    public static class CommandTeleporter implements ITeleporter
    {
        private final BlockPos targetPos;

        public CommandTeleporter(BlockPos targetPos)
        {
            this.targetPos = targetPos;
        }

        @Override
        public void placeEntity(World world, Entity entity, float yaw)
        {
            entity.moveToBlockPosAndAngles(targetPos, yaw, entity.rotationPitch);
        }
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
