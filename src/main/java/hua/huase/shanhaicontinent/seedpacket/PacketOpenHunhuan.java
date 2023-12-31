package hua.huase.shanhaicontinent.seedpacket;

import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketOpenHunhuan implements IMessage, IMessageHandler<PacketOpenHunhuan, IMessage> {
	short hunhuankaiguan;

	public PacketOpenHunhuan() {}
	public PacketOpenHunhuan(Short hunhuankaiguan) {
		this.hunhuankaiguan=hunhuankaiguan;
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeShort(hunhuankaiguan);
		ByteBufUtils.writeVarShort(buffer,0);
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		this.hunhuankaiguan = buffer.readShort();
		ByteBufUtils.readVarShort(buffer);
	}

	@Override
	public IMessage onMessage(PacketOpenHunhuan message, MessageContext ctx) {
		IThreadListener mainThread = (WorldServer) ctx.getServerHandler().player.world;
		mainThread.addScheduledTask(new Runnable(){ public void run() {
//			ctx.getServerHandler().player.openContainer.onContainerClosed(ctx.getServerHandler().player);
			PlayerCapability capability = ctx.getServerHandler().player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);


			if(message.hunhuankaiguan>capability.getWuhunListsname().size()){

			}else {
				capability.setHunhuankaiguan(message.hunhuankaiguan);
				PacketHandler.INSTANCE.sendToAllTracking(new PacketPlayerCapability(capability, ctx.getServerHandler().player), new NetworkRegistry.TargetPoint(ctx.getServerHandler().player.dimension, ctx.getServerHandler().player.posX, ctx.getServerHandler().player.posY, ctx.getServerHandler().player.posZ, 60));
			}
		}});
		return null;
	}
}
