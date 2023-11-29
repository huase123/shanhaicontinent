package hua.huase.shanhaicontinent.event;


import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.handers.HanderAny;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CreateEntityItem
{

    //创建EntityItem事件
    @SubscribeEvent
    public static void createEntityItem(net.minecraftforge.event.entity.item.ItemTossEvent event) throws IllegalAccessException, NoSuchFieldException {

//        if(!event.getEntityItem().getItem().isEmpty() && event.getEntityItem().getItem().getItem() == HanderAny.itemList.get(13) || event.getEntityItem().getItem().getItem() == HanderAny.itemList.get(12)){
        if(!event.getEntityItem().getItem().isEmpty()
                && event.getEntityItem().getItem().getItem() == HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":textpickaxe"))
                || event.getEntityItem().getItem().getItem() == HanderAny.bianhua.itemBlock
                || event.getEntityItem().getItem().getItem() == HanderAny.registry.getValue(new ResourceLocation(ExampleMod.MODID+":textsword"))){


            EntityItem entityItem = event.getEntityItem();
            entityItem.health=9999;
//            Field privateField = EntityItem.class.getDeclaredFields()[4];
//            privateField.setAccessible(true);
//            privateField.set(entityItem, 9999);

        }

    }



}
