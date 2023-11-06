package hua.huase.shanhaicontinent.seedpacket;

import hua.huase.shanhaicontinent.api.BaublesApi;
import hua.huase.shanhaicontinent.api.IBaublesItemHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSync implements IMessage {

	int playerId;
	byte slot=0;
	ItemStack bauble;

	public PacketSync() {}

	public PacketSync(EntityPlayer p, int slot, ItemStack bauble) {
		this.slot = (byte) slot;
		this.bauble = bauble;
		this.playerId = p.getEntityId();
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(playerId);
		buffer.writeByte(slot);
//		ByteBufUtils.writeItemStack(buffer, bauble);
		ByteBufUtils.writeTag(buffer, bauble.serializeNBT());
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		playerId = buffer.readInt();
		slot = buffer.readByte();
//		bauble = ByteBufUtils.readItemStack(buffer);
		NBTTagCompound compound = ByteBufUtils.readTag(buffer);
		bauble =new ItemStack(compound);
	}

	public static class Handler implements IMessageHandler<PacketSync, IMessage>
	{
		@Override
		public IMessage onMessage(PacketSync message, MessageContext ctx) {
			Minecraft.getMinecraft().addScheduledTask(new Runnable(){ public void run() {
				World world = FMLClientHandler.instance().getClient().world;
				if (world==null) return;
				Entity p = world.getEntityByID(message.playerId);
				if (p !=null && p instanceof EntityPlayer) {
					IBaublesItemHandler baubles = BaublesApi.getBaublesHandler((EntityPlayer) p);
					baubles.setStackInSlot(message.slot, message.bauble);
				}
			}});
			return null;
		}
	}
}
