package hua.huase.shanhaicontinent.event;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.Mod;

import static hua.huase.shanhaicontinent.handers.HanderAny.shportal;
import static net.minecraft.init.Items.DIAMOND;

@Mod.EventBusSubscriber
public class ItemToss {

//    public static Map<Integer,Integer> stageHashMap=new HashMap<>();
//    @SideOnly(Side.CLIENT)
////    @SubscribeEvent
//    public static void playerTick(TickEvent.PlayerTickEvent event) {
//
//    }




//    @SubscribeEvent
    public static void itemCrafted(ItemTossEvent event) {
        EntityItem entityItem = event.getEntityItem();
        if(entityItem!=null && entityItem.getItem().getItem().equals(DIAMOND)){
            World entityWorld = entityItem.getEntityWorld();
            BlockPos position = entityItem.getPosition();
            boolean equals = entityWorld.getBlockState(position.down()).equals(Blocks.GRASS.getDefaultState());
            if(equals){

                entityWorld.setBlockState(position.down(),shportal.getDefaultState());
            }
        }

    }

}
