package hua.huase.shanhaicontinent.seedpacket;

import hua.huase.shanhaicontinent.entity.jinengitem.EntityJinengItem;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
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
			useTime.put(player.getEntityId(),player.world.getWorldTime()-180);
		}

		if(useTime.get(player.getEntityId())+200L<=player.world.getWorldTime()) {
			useTime.put(player.getEntityId(),player.world.getWorldTime());
			IThreadListener mainThread = (WorldServer) player.world;
			mainThread.addScheduledTask(new Runnable(){ public void run() {
				for (int i = 0; i < 9; i++) {

					EntityJinengItem jinengItem = new EntityJinengItem(player.world,player,i);
					player.world.spawnEntity(jinengItem);
				}


			}});

		}
		return null;
	}
}


