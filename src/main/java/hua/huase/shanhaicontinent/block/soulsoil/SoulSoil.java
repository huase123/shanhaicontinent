package hua.huase.shanhaicontinent.block.soulsoil;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.block.FlowerBlock;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class SoulSoil extends Block implements SoulSoilBase{
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 8);



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
        return 3;
    }

    public int getAge(IBlockState state)
    {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue();
    }

    public IBlockState withAge(int age)
    {
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
    }


    //    设置方块放置状态
    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing,
                                            float hitX, float hitY, float hitZ, int meta,
                                            EntityLivingBase placer, EnumHand hand)
    {
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(meta));
    }


    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        NonNullList<ItemStack> ret = NonNullList.create();
//        getDrops(ret, world, pos, state, fortune);
        ret.add(new ItemStack(this,1,this.getAge(state)));
        return ret;
    }


    public SoulSoil(String name, CreativeTabs creativeTabs)
    {
        super(Material.GROUND);
        this.setUnlocalizedName(ExampleMod.MODID +"."+ name);
        this.setRegistryName(name);
        this.setSoundType(SoundType.SAND);
        this.setCreativeTab(creativeTabs);
        this.setHardness(0.2F);
        this.setLightLevel(0.8F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));
        HanderAny.soulSoilItem = (ItemBlock) new ItemBlock(this){
            public int getMetadata(int damage)
            {
                return damage;
            }

            public String getUnlocalizedName(ItemStack stack)
            {
                return super.getUnlocalizedName() + "_age" + stack.getMetadata();
            }

        }.setHasSubtypes(true).setMaxDamage(0).setRegistryName(name).setUnlocalizedName(ExampleMod.MODID +"."+ name);


//        HanderAny.itemList.add(soulsoil);
        HanderAny.blockList.add(this);

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
        items.add(new ItemStack(this, 1, 7));
        items.add(new ItemStack(this, 1, 8));
    }









    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient,ItemStack stack) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state,ItemStack stack) {
        return true;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state, ItemStack stack, EntityPlayer player) {
        BlockPos blockpos = pos.up();
        int age = this.getAge(state);
        int i1 = stack.getMetadata()  * 2 + 3;


            for (int i = 0; i < i1; i++) {
                for (int j = 0; j < i1; j++) {

                        BlockPos blockpos1 = blockpos.add(-i1/2+i,0,-i1/2+j);
                        if (worldIn.isAirBlock(blockpos1)) {
                            Block block = worldIn.getBlockState(blockpos1.down()).getBlock();

                                if (block instanceof SoulSoilBase) {

                                    int i2 = 0;
                                   switch (stack.getMetadata()){
                                       case 0:
                                           i2 =rand.nextInt(5);
                                           break;
                                       case 1:
                                           i2 =rand.nextInt(6);
                                           break;
                                       case 2:
                                           i2 =rand.nextInt(4)+2;
                                           break;
                                       case 3:
                                           i2 =rand.nextInt(2)+4;
                                           break;
                                       case 4:
                                           i2 =rand.nextInt(3)+4;
                                           break;
                                       case 5:
                                           i2 =rand.nextInt(4)+4;
                                           break;
                                       case 6:
                                           i2 =rand.nextInt(2)+6;
                                           break;
                                       case 7:
                                           i2 =rand.nextInt(2)+7;
                                           break;
                                       case 8:
                                           i2 =rand.nextInt(2)+8;
                                           break;
                                   }



                                    if(i2>age&&rand.nextInt(i2-age)!=0){
                                        i2 = age;
                                    }
                                    if(FlowerBlock.flowerBlocksList!=null){

                                        FlowerBlock flowerBlock = FlowerBlock.flowerBlocksList.get(rand.nextInt(FlowerBlock.flowerBlocksList.size()));

                                        worldIn.setBlockState(blockpos1, flowerBlock.getStateFromMeta(i2), 3);
                                        ((WorldServer)worldIn).addScheduledTask(() ->
                                        {
                                            worldIn.observedNeighborChanged(blockpos1, flowerBlock, blockpos1);
                                            if(rand.nextInt(3)==0) {
                                                worldIn.playEvent(2005, blockpos1, 3);
                                            }
                                        });

                                    }
                                }
                        }
                }
            }

    }






//
//    @SideOnly(Side.CLIENT)
//    public BlockRenderLayer getBlockLayer()
//    {
//        return BlockRenderLayer.SOLID;
//    }


    //BlockContainer重写了getRenderType,需要重新覆盖来渲染方块
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
//        list.remove(list.size()-1);
        list.add(net.minecraft.util.text.translation.I18n.translateToLocal("soulsoil_list0"));
    }



}
