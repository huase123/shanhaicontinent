package hua.huase.shanhaicontinent.capability.baubles.seedpacket;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import static hua.huase.shanhaicontinent.client.event.ClientEventHandler.jingtoukaiguan;

public class PacketHunhuanKaiguan implements IMessage{

	public Boolean kaiguan;

	public PacketHunhuanKaiguan() {}
	public PacketHunhuanKaiguan(Boolean b) {
		this.kaiguan=b;
	}


	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeBoolean(kaiguan);
		ByteBufUtils.writeVarShort(buffer,0);
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		kaiguan = buffer.readBoolean();
		ByteBufUtils.readVarShort(buffer);
	}




	public static class Handler implements IMessageHandler<PacketHunhuanKaiguan, IMessage>
	{
		@Override
		public IMessage onMessage(PacketHunhuanKaiguan message, MessageContext ctx) {

			Minecraft.getMinecraft().addScheduledTask(new Runnable() {
				public void run() {

					if(message.kaiguan){
						jingtoukaiguan = true;
						Minecraft.getMinecraft().gameSettings.thirdPersonView = 1;
					}else{
						jingtoukaiguan = false;
					}
				}
			});
			return null;
		}
	}
}

