package hua.huase.shanhaicontinent.item;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.lang.reflect.Method;
import java.util.List;

public class Lianyaohu  extends Item {


    // Lasso.
    public static final String MOB = "capturedMob";
    public static final String MOB_NAME = "mobName";
    public static final String MOB_DATA = "mobData";
    public static final String MOB_HEALTH = "mobHealth";
    public static final String MOB_MAX_HEALTH = "mobMaxHealth";
    public static final String MOB_HOSTILE = "mobHostile";
    public static final String MOB_LOOTTABLE_LOCATION = "mobLootTableLocation";

    public static NBTTagCompound getBaseTag(ItemStack stack) {
        return getOrCreateTag(stack).getCompoundTag(MOB);
    }

    public static void setBaseTag(ItemStack stack, NBTTagCompound nbt) {
        getOrCreateTag(stack).setTag(MOB, nbt);
    }

    public Lianyaohu(String name, CreativeTabs Tabs){
        super();
        setRegistryName(name);
        setUnlocalizedName(ExampleMod.MODID  +"."+  name);
        HanderAny.itemList.add(this);
        setCreativeTab(Tabs);
        setHasSubtypes(true);
        setMaxStackSize(16);
    }


    @Override
    public boolean itemInteractionForEntity(ItemStack stackold, EntityPlayer player, EntityLivingBase target, EnumHand hand) {
        if (hasMob(stackold) || target.isDead || !(target instanceof EntityLiving)) return false;

        ItemStack stack = new ItemStack(this);
        NBTTagCompound nbt = getBaseTag(stack);

        if (!player.world.isRemote) {
            NBTTagCompound mobData = target.serializeNBT();
            mobData.removeTag("Rotation");
            nbt.setTag(MOB_DATA, mobData);
            nbt.setString(MOB_NAME, target.getName());
            nbt.setString(MOB_LOOTTABLE_LOCATION, getLootTableLocation((EntityLiving) target));
            nbt.setDouble(MOB_HEALTH, Math.round(target.getHealth() * 10) / 10.0);
            nbt.setDouble(MOB_MAX_HEALTH, target.getMaxHealth());
            nbt.setBoolean(MOB_HOSTILE, target.isCreatureType(EnumCreatureType.MONSTER, false));

            setBaseTag(stack, nbt);
            player.addItemStackToInventory(stack);
            if (!player.capabilities.isCreativeMode) {
                stackold.shrink(1);
            }
            target.setDead();
            player.inventory.markDirty();
        }

        return true;
    }


    private static Method getLootTable;

    public static String getLootTableLocation(EntityLiving entityLiving) {
        ResourceLocation location = null;

        try {
            if (getLootTable == null) {
                getLootTable = ReflectionHelper.findMethod(EntityLiving.class, "getLootTable", "func_184647_J", new Class[0]);
            }
            Object lootTableLocation = getLootTable.invoke(entityLiving);
            if (lootTableLocation instanceof ResourceLocation) {
                location = (ResourceLocation) lootTableLocation;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return location == null ? "" : location.toString();
    }




    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack stack = player.inventory.getCurrentItem();

        if (!hasMob(stack)) return EnumActionResult.FAIL;

        if (!player.canPlayerEdit(pos, facing, stack)) return EnumActionResult.FAIL;

        if (!world.isRemote) {
            NBTTagCompound nbt = getBaseTag(stack);
            NBTTagCompound mobData = nbt.getCompoundTag(MOB_DATA);

            BlockPos newPos = pos.offset(facing);

            NBTTagDouble x = new NBTTagDouble(newPos.getX() + 0.5);
            NBTTagDouble y = new NBTTagDouble(newPos.getY());
            NBTTagDouble z = new NBTTagDouble(newPos.getZ() + 0.5);
            NBTTagList mobPos = createNBTList(x, y, z);
            mobData.setTag("Pos", mobPos);
            mobData.setInteger("Dimension", world.provider.getDimension());

            Entity mob = EntityList.createEntityFromNBT(mobData, world);
            if (mob != null) world.spawnEntity(mob);

            getOrCreateTag(stack).removeTag(MOB);

            stack.damageItem(1, player);
            player.inventory.markDirty();
        }

        return EnumActionResult.SUCCESS;
    }




    public static NBTTagCompound getOrCreateTag(ItemStack stack) {
        NBTTagCompound nbt = stack.getTagCompound();
        if (nbt == null) {
            nbt = new NBTTagCompound();
            stack.setTagCompound(nbt);
        }
        return nbt;
    }

    public static boolean hasMob(ItemStack stack) {
        return getOrCreateTag(stack).hasKey(MOB);
    }

    public static NBTTagList createNBTList(NBTBase... tags) {
        NBTTagList list = new NBTTagList();
        for (NBTBase i: tags) list.appendTag(i);

        return list;
    }


    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {



        if (hasMob(stack)) {
            NBTTagCompound nbt = getBaseTag(stack);
            String name = nbt.getString(MOB_NAME);
            double health = nbt.getDouble(MOB_HEALTH);
            double maxHealth = nbt.getDouble(MOB_MAX_HEALTH);

            tooltip.add(I18n.format("lianyaohu.mob_name", name));
            tooltip.add(I18n.format("lianyaohu.health", health, maxHealth));
//            if (nbt.getBoolean(MOB_HOSTILE)) tooltip.add(I18n.format("tinymobfarm.tooltip.hostile"));
        } else {
            tooltip.add(I18n.format("lianyaohu_kong"));
        }


        tooltip.add(net.minecraft.util.text.translation.I18n.translateToLocal("lianyaohu_list0"));
        tooltip.add(net.minecraft.util.text.translation.I18n.translateToLocal("lianyaohu_list1"));
    }


    @Override
    public boolean hasEffect(ItemStack stack) {
        return hasMob(stack);
    }
}