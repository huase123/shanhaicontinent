package hua.huase.shanhaicontinent.capability.baubles.seedpacket;

import hua.huase.shanhaicontinent.capability.MonsterCapability;
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

import static hua.huase.shanhaicontinent.ExampleMod.monsterHashMapCapability;

public class PacketMonster implements IMessage{

	int monsterId;
	MonsterCapability monsterCapability=new MonsterCapability();

	public PacketMonster() {}

	public PacketMonster(MonsterCapability monsterCapability, Entity entity) {
		this.monsterId = entity.getEntityId();
		this.monsterCapability = monsterCapability;
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(monsterId);
		ByteBufUtils.writeTag(buffer, monsterCapability.serializeNBT());
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		monsterId = buffer.readInt();
		NBTTagCompound compound = ByteBufUtils.readTag(buffer);
		monsterCapability.deserializeNBT(compound);
	}




	public static class Handler implements IMessageHandler<PacketMonster, IMessage> {
		@Override
		public IMessage onMessage(PacketMonster message, MessageContext ctx) {

			Minecraft.getMinecraft().addScheduledTask(new Runnable() {
				public void run() {
					World world = FMLClientHandler.instance().getClient().world;

					if (world == null) return;


					MonsterCapability monsterCapability1 = message.monsterCapability;
					monsterHashMapCapability.put(message.monsterId,message.monsterCapability);



				}
			});
			return null;
		}
	}
}

