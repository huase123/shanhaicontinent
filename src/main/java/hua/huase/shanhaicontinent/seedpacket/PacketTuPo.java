package hua.huase.shanhaicontinent.seedpacket;

import hua.huase.shanhaicontinent.api.PlayerCapabilityApi;
import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import static hua.huase.shanhaicontinent.api.PlayerCapabilityApi.juexingWuHun;

public class PacketTuPo implements IMessage, IMessageHandler<PacketTuPo, IMessage> {

	public PacketTuPo() {}

	@Override
	public void toBytes(ByteBuf buffer) {}

	@Override
	public void fromBytes(ByteBuf buffer) {}

	@Override
	public IMessage onMessage(PacketTuPo message, MessageContext ctx) {
		EntityPlayerMP player = ctx.getServerHandler().player;
		IThreadListener mainThread = (WorldServer) player.world;
		mainThread.addScheduledTask(new Runnable(){ public void run() {
			PlayerCapability capability = player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
			int maxjingyan = capability.getMaxjingyan();
			int jingyan = capability.getJingyan();
			int dengji = capability.getDengji();
			TextComponentTranslation iTextComponents =new TextComponentTranslation("message.tupo.fail" );
			if(PlayerCapabilityApi.tuPo(player)){
				iTextComponents = new TextComponentTranslation("message.tupo.sccuess" + -1, dengji + 1);


				int round = Math.round((dengji + 1) / 10);
				switch (round){
					case 0:
						iTextComponents=new TextComponentTranslation("message.tupo.sccuess" + round, dengji + 1);
						break;
					case 1:
						iTextComponents=new TextComponentTranslation("message.tupo.sccuess" + round, dengji + 1);
						break;
					case 2:
						iTextComponents=new TextComponentTranslation("message.tupo.sccuess" + round, dengji + 1);
						break;
					case 3:
						iTextComponents=new TextComponentTranslation("message.tupo.sccuess" + round, dengji + 1);
						break;
					case 4:
						iTextComponents=new TextComponentTranslation("message.tupo.sccuess" + round, dengji + 1);
						break;
					case 5:
						iTextComponents=new TextComponentTranslation("message.tupo.sccuess" + round, dengji + 1);
						break;
					case 6:
						iTextComponents=new TextComponentTranslation("message.tupo.sccuess" + round, dengji + 1);
						break;
					case 7:
						iTextComponents=new TextComponentTranslation("message.tupo.sccuess" + round, dengji + 1);
						break;
					case 8:
						iTextComponents=new TextComponentTranslation("message.tupo.sccuess" + round, dengji + 1);
						break;
					case 9:
						iTextComponents=new TextComponentTranslation("message.tupo.sccuess" + round, dengji + 1);
						break;
				}

				player.sendMessage(iTextComponents);

				if(dengji==5){
					boolean b = false;
					switch (player.world.rand.nextInt(2)){
						case 0:
							b = juexingWuHun(player,"jingubang");
						break;

						case 1:
							b = juexingWuHun(player, "huang");
							break;

					}
					if(b){

						switch (player.world.rand.nextInt(10)){
							case 0:
								juexingWuHun(player,"jingubang");
								break;

							case 1:
								juexingWuHun(player, "huang");
								break;

						}

					}



				}

				return;

			}
			player.sendMessage(iTextComponents);
		}});
		return null;
	}
}
