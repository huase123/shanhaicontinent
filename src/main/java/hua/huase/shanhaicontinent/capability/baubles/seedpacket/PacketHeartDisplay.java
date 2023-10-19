package hua.huase.shanhaicontinent.capability.baubles.seedpacket;

import hua.huase.shanhaicontinent.client.particles.ParticlesHander;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketHeartDisplay implements IMessage{

	int number;
	int x;
	int y;
	int z;


	public PacketHeartDisplay() {
	}
	public PacketHeartDisplay(int number, int x, int y, int z) {
		this.number = number;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(number);
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		ByteBufUtils.writeVarShort(buffer,0);
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		number = buffer.readInt();
		x = buffer.readInt();
		y = buffer.readInt();
		z = buffer.readInt();
		ByteBufUtils.readVarShort(buffer);
	}




	public static class Handler implements IMessageHandler<PacketHeartDisplay, IMessage> {
		@Override
		public IMessage onMessage(PacketHeartDisplay message, MessageContext ctx) {

			Minecraft.getMinecraft().addScheduledTask(new Runnable() {
				public void run() {
					World world = FMLClientHandler.instance().getClient().world;

					if (world == null) return;
					world.spawnParticle(ParticlesHander.parTicleCritNum,false, (double) message.x, (double) message.y, (double) message.z, 1.0, 1.0, 1.0,  message.number, 0);



				}
			});
			return null;
		}
	}
}

