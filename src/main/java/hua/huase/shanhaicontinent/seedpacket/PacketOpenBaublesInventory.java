package hua.huase.shanhaicontinent.seedpacket;

import hua.huase.shanhaicontinent.ExampleMod;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketOpenBaublesInventory implements IMessage, IMessageHandler<PacketOpenBaublesInventory, IMessage> {

	public PacketOpenBaublesInventory() {}

	@Override
	public void toBytes(ByteBuf buffer) {}

	@Override
	public void fromBytes(ByteBuf buffer) {}

	@Override
	public IMessage onMessage(PacketOpenBaublesInventory message, MessageContext ctx) {
		IThreadListener mainThread = (WorldServer) ctx.getServerHandler().player.world;
		mainThread.addScheduledTask(new Runnable(){ public void run() {
//			ctx.getServerHandler().player.openContainer.onContainerClosed(ctx.getServerHandler().player);
			ctx.getServerHandler().player.openGui(ExampleMod.MODID, 3, ctx.getServerHandler().player.world, 0, 0, 0);
		}});
		return null;
	}
}
