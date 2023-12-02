package hua.huase.shanhaicontinent.block;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.block.soulsoil.SoulSoilBase;
import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.handers.HanderAny;
import hua.huase.shanhaicontinent.potion.PotionRegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlowerBlock extends Block
{




    protected static final AxisAlignedBB BUSH_AABB = new AxisAlignedBB(0.20000001192092896D, 0.0D, 0.20000001192092896D, 0.799999988079071D, 0.7000000238418579D, 0.799999988079071D);

    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 9);

    public  final ItemBlock itemBlock;
    public FlowerBlock(String name, CreativeTabs creativeTabs)
    {

        super(Material.SAND);

        this.setSoundType(SoundType.PLANT);

        this.setUnlocalizedName(ExampleMod.MODID +"."+ name);
        this.setRegistryName(name);
        this.setCreativeTab(creativeTabs);
        this.setHardness(0.0F);
        this.setLightLevel(0.3F);
        this.setTickRandomly(true);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));

        itemBlock = (ItemBlock) new ItemBlock(this){
            public int getMetadata(int damage)
            {

                return damage==0?0:damage+3;
            }

            public String getUnlocalizedName(ItemStack stack)
            {
                return super.getUnlocalizedName() + "_age" + (stack.getMetadata());
            }
        }.setHasSubtypes(true).setMaxDamage(0).setRegistryName(name).setUnlocalizedName(ExampleMod.MODID +"."+ name);

        HanderAny.blockList.add(this);
//        HanderAny.itemList.add(itemBlock);
        if(!name.equals("bianhua")){

            flowerBlocksList.add(this);
        }
    }



    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        NonNullList<ItemStack> ret = NonNullList.create();
//        getDrops(ret, world, pos, state, fortune);\
        if(state.getBlock()==HanderAny.bianhua&&world instanceof WorldServer){

            float f = 6.0F;
            double d0 = (double)(((WorldServer)world).rand.nextFloat() * f) - 3.0D;
            double d1 = (double)(((WorldServer)world).rand.nextFloat() * f) - 3.0D;
            double d2 = (double)(((WorldServer)world).rand.nextFloat() * f) - 3.0D;
            EntityItem entityitem = new EntityItem(((WorldServer)world), (double)pos.getX() + d0, (double)pos.getY() + d1, (double)pos.getZ() + d2, new ItemStack(this,1,Math.max(this.getAge(state)-3,0)));
            entityitem.setDefaultPickupDelay();
            entityitem.health=999;
            ((WorldServer)world).spawnEntity(entityitem);
        }else {

            ret.add(new ItemStack(this,1,Math.max(this.getAge(state)-3,0)));
        }
        return ret;
    }




    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        items.add(new ItemStack(this, 1, 0));
        items.add(new ItemStack(this, 1, 1));
        items.add(new ItemStack(this, 1, 2));
        items.add(new ItemStack(this, 1, 3));
        items.add(new ItemStack(this, 1, 4));
        items.add(new ItemStack(this, 1, 5));
        items.add(new ItemStack(this, 1, 6));
    }





    //    右键方块活动
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos,
                                    IBlockState state, EntityPlayer playerIn, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {


//            EntityPlayer.SleepResult entityplayer$sleepresult = playerIn.trySleep(pos);
//            worldIn.setBlockState(pos, state, 4);
//                worldIn.setBlockToAir(pos);
//                worldIn.newExplosion((Entity)null, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 5.0F, true, true);
                return true;
        }
    }



    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.down()).getBlock() instanceof SoulSoilBase;
    }



    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        IBlockState blockState1 = worldIn.getBlockState(pos.down());
        if(blockState1.getBlock() instanceof SoulSoilBase){
            int age = ((SoulSoilBase) blockState1.getBlock()).getAge(blockState1);
            int i = this.getAge(state)-3;
            if(i<=age){

                if(rand.nextInt(9-age)==0&&rand.nextInt(Math.max(i,0)*3+1)==0){
                    grow(worldIn, pos, state);
                }

                if(rand.nextInt((10-age)*10*(10-this.getAge(state)))==0&&age<8) {
                    worldIn.setBlockState(pos.down(), ((SoulSoilBase)blockState1.getBlock()).withAge(age+1), 2);
                    worldIn.playEvent(2005, pos, 0);
                }
            }


//增加精神力
            i = Math.max(i,1);
            AxisAlignedBB axisalignedbb = (new AxisAlignedBB(pos)).grow(16);
            List<EntityPlayer> list = worldIn.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
            for (EntityPlayer entityplayer : list)
            {
                if(entityplayer!=null){
                    PlayerCapability capability = entityplayer.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
                    if(capability.getJingshenli()<capability.getMaxjingshenli()) {
                        capability.addJingshenli(i);
                        entityplayer.sendMessage(new TextComponentTranslation("message.addjingshenli.success", i));
                    }


                    if(state.getBlock()==HanderAny.bianhua){
                        ((EntityLivingBase)entityplayer).addPotionEffect(new PotionEffect(PotionRegistryHandler.Potion_Debuff_BiAnHua,200,0,true,true));

                    }

                }
            }


        }



    }
    public void grow(World worldIn, BlockPos pos,IBlockState state)
    {
        int i = this.getMetaFromState(state);
        if(i <this.getMaxAge()){
            worldIn.setBlockState(pos, this.withAge(i+1), 2);
            worldIn.playEvent(2005, pos, 5);
//            i = Math.max(i-3,1);
//            AxisAlignedBB axisalignedbb = (new AxisAlignedBB(pos)).grow(16);
//            List<EntityPlayer> list = worldIn.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
//            for (EntityPlayer entityplayer : list)
//            {
//                if(entityplayer!=null){
//                    PlayerCapability capability = entityplayer.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
//                    if(capability.getJingshenli()<capability.getMaxjingshenli()) {
//                        capability.addJingshenli(i);
//                        entityplayer.sendMessage(new TextComponentTranslation("message.addjingshenli.success", i));
//                    }
//                }
//            }


        }
    }



    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, AGE);
    }



    @Override
    public IBlockState getStateFromMeta(int meta)
    {

        return this.getDefaultState().withProperty(AGE, meta);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int age = state.getValue(AGE).intValue();
        return  age;
    }




    protected PropertyInteger getAgeProperty()
    {
        return AGE;
    }

    public int getMaxAge()
    {
        return 9;
    }

    protected int getAge(IBlockState state)
    {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue();
    }

    public IBlockState withAge(int age)
    {
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
    }





    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }


    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return BUSH_AABB;
    }

    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }

@Nullable
public static List<FlowerBlock> flowerBlocksList = new ArrayList<FlowerBlock>();


    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
//        list.remove(list.size()-1);
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("flowerblock_list0"));
    }



}
