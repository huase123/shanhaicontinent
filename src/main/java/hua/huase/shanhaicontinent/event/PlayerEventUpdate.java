package hua.huase.shanhaicontinent.event;

import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.seedpacket.PacketHandler;
import hua.huase.shanhaicontinent.seedpacket.PacketPlayerCapability;
import hua.huase.shanhaicontinent.seedpacket.PacketSync;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber
public class PlayerEventUpdate {

//    public static Map<Integer,Integer> stageHashMap=new HashMap<>();
//    @SideOnly(Side.CLIENT)
////    @SubscribeEvent
//    public static void playerTick(TickEvent.PlayerTickEvent event) {
//
//    }




    @SubscribeEvent
    public static void onStartTracking(TickEvent.PlayerTickEvent event) {
        EntityPlayer target = event.player;
        EntityPlayer player =  target;
        if(target.isDead)return;
        PlayerCapability capability = player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
        if (event.phase==TickEvent.Phase.END&&target instanceof EntityPlayerMP && !target.world.isRemote &&target.ticksExisted%20==0) {
            if(player.getHealth()<player.getMaxHealth()&&player.getHealth()>0f){
                player.setHealth(player.getHealth()+capability.getShengminghuifu()/2f);
            }
            if(capability.getJingshenli()<capability.getMaxjingshenli()&&player.getHealth()>0f){
//                capability.addJingshenli(0.1f*capability.getMaxjingshenli());
                capability.addJingshenli(capability.getDengji()/10f);

            }
            PacketHandler.INSTANCE.sendToAllTracking(new PacketPlayerCapability(capability,player),new NetworkRegistry.TargetPoint(player.dimension,player.posX,player.posY,player.posZ,60));


        }


        if(event.phase==TickEvent.Phase.END&&capability.getDengji()>=50&&target.ticksExisted%100==0){
            player.capabilities.allowFlying=true;
        }


        if (!player.world.isRemote) {
            syncBaubles(player, player.inventory.armorInventory);
        }





    }


    private static void syncBaubles(EntityPlayer player, NonNullList<ItemStack> baubles) {


        for (int i = 0; i < baubles.size(); i++) {

            ItemStack stack = baubles.get(i);
            Set<EntityPlayer> receivers = null;
            if (!stack.isEmpty() && stack.getCapability(CapabilityRegistryHandler.DANYAOITEMCAPABILITYCAPABILITY, null) != null) {
                if (receivers == null) {
                    receivers = new HashSet<>(((WorldServer) player.world).getEntityTracker().getTrackingPlayers(player));
                    receivers.add(player);
                }
                syncSlot(player, i, stack, receivers);
            }
        }

    }

    private static void syncSlot(EntityPlayer player, int slot, ItemStack stack, Collection<? extends EntityPlayer> receivers) {
        PacketSync pkt = new PacketSync(player, slot, stack);
        for (EntityPlayer receiver : receivers) {
            PacketHandler.INSTANCE.sendTo(pkt, (EntityPlayerMP) receiver);
        }
    }


}
