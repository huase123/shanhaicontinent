package hua.huase.shanhaicontinent.seedpacket;

import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.MonsterCapability;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.entity.jinengitem.EntityJinengItem;
import hua.huase.shanhaicontinent.item.jineng.JinengMethond;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.HashMap;

public class PacketJiNengKaiguan implements IMessage, IMessageHandler<PacketJiNengKaiguan, IMessage> {

	static private HashMap<Integer, Long> useTime = new HashMap();

	public PacketJiNengKaiguan() {}

	@Override
	public void toBytes(ByteBuf buffer) {}

	@Override
	public void fromBytes(ByteBuf buffer) {}

	@Override
	public IMessage onMessage(PacketJiNengKaiguan message, MessageContext ctx) {
		EntityPlayerMP player = ctx.getServerHandler().player;
		if(player==null)return null;
		if(useTime.get(player.getEntityId())==null){
			useTime.put(player.getEntityId(),player.world.getWorldTime()-200L);
		}

		if(useTime.get(player.getEntityId())+200L<=player.world.getWorldTime()) {
			useTime.put(player.getEntityId(),player.world.getWorldTime());
			IThreadListener mainThread = (WorldServer) player.world;
			mainThread.addScheduledTask(new Runnable(){ public void run() {
				PlayerCapability capability = player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
				int i=0;
				if(capability.getMonsterCapabilityList()==null)return;
				for (MonsterCapability monsterCapability : capability.getMonsterCapabilityList()) {
					if(capability.getWuhunname().equals("null"))return;
					if(JinengMethond.monsterCapabilityLists.get(capability.getWuhunname())!=null&&JinengMethond.monsterCapabilityLists.get(capability.getWuhunname()).get(i)!=null){

						ItemStack itemStack = new ItemStack(JinengMethond.monsterCapabilityLists.get(capability.getWuhunname()).get(i),1,0);
						NBTTagCompound compound = new NBTTagCompound();
						compound.setInteger("nianxian",monsterCapability.getNianxian());
						compound.setInteger("playerid",player.getEntityId());
						compound.setString("playername",player.getName());
						itemStack.setTagCompound(compound);
						EntityJinengItem jinengItem = new EntityJinengItem(player.world,player,i,itemStack).setItemStack();
						player.world.spawnEntity(jinengItem);
						i++;
					}
				}
//
//				for (int i = 0; i < 9; i++) {
//
//					EntityJinengItem jinengItem = new EntityJinengItem(player.world,player,i);
//					player.world.spawnEntity(jinengItem);
//				}


			}});

		}
		return null;
	}
}


