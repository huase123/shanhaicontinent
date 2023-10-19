package hua.huase.shanhaicontinent.capability.baubles.seedpacket;

import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import static hua.huase.shanhaicontinent.ExampleMod.playerHashMap;

public class PacketPlayerCapability implements IMessage{

	int playerId;
	PlayerCapability playerCapability=new PlayerCapability();

	public PacketPlayerCapability() {}

	public PacketPlayerCapability(PlayerCapability playerCapability, Entity entity) {
		this.playerId = entity.getEntityId();
		this.playerCapability = playerCapability;
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(playerId);
		ByteBufUtils.writeTag(buffer, playerCapability.serializeNBT());
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		playerId = buffer.readInt();
		NBTTagCompound compound = ByteBufUtils.readTag(buffer);
		playerCapability.deserializeNBT(compound);
	}




	public static class Handler implements IMessageHandler<PacketPlayerCapability, IMessage> {
		@Override
		public IMessage onMessage(PacketPlayerCapability message, MessageContext ctx) {

			Minecraft.getMinecraft().addScheduledTask(new Runnable() {
				public void run() {
					World world = FMLClientHandler.instance().getClient().world;

					if (world == null) return;
					Entity entity = world.getEntityByID(message.playerId);
					if (entity==null) return;
					PlayerCapability capability = entity.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
					if(capability==null){
						PlayerCapability monsterCapability1 = message.playerCapability;
						playerHashMap.put(message.playerId,message.playerCapability);
					}else {
						capability.deserializeNBT(message.playerCapability.serializeNBT());
					}


				}
			});
			return null;
		}
	}
}

