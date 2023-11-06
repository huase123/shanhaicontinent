package hua.huase.shanhaicontinent.seedpacket;

import hua.huase.shanhaicontinent.api.PlayerCapabilityApi;
import hua.huase.shanhaicontinent.capability.MonsterCapability;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.entity.HunhuanEntity;
import hua.huase.shanhaicontinent.network.NetworkRegistryHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.List;
import java.util.Random;

import static hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler.MONSTER_CAPABILITY;
import static hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler.PLYAER_CAPABILITY;

public class PacketPlayerHunhuan implements IMessage, IMessageHandler<PacketPlayerHunhuan, IMessage>  {

	int playerId;
	int time=0;
	int hunhuanEntityId;

	public PacketPlayerHunhuan() {}

	public PacketPlayerHunhuan(EntityPlayer p, int time, HunhuanEntity hunhuanEntity) {
		this.hunhuanEntityId = hunhuanEntity.getEntityId();
		this.time = time;
		this.playerId = p.getEntityId();
	}

	@Override
	public void toBytes(ByteBuf buffer) {
		buffer.writeInt(playerId);
		buffer.writeInt(time);
		buffer.writeInt(hunhuanEntityId);
		ByteBufUtils.writeVarShort(buffer, 0);
	}

	@Override
	public void fromBytes(ByteBuf buffer) {
		playerId = buffer.readInt();
		time = buffer.readInt();
		hunhuanEntityId = buffer.readInt();
		int i  = ByteBufUtils.readVarShort(buffer);
	}

	public IMessage onMessage(PacketPlayerHunhuan message, MessageContext ctx) {

		IThreadListener mainThread = (WorldServer) ctx.getServerHandler().player.world;
		mainThread.addScheduledTask(new Runnable(){ public void run() {

			Entity player = ctx.getServerHandler().player;
			Entity entity = player.world.getEntityByID(message.hunhuanEntityId);
			if (player==null||entity==null) return;
			PlayerCapability playerCapability = player.getCapability(PLYAER_CAPABILITY, null);
			int nianxian = ((HunhuanEntity) entity).getCapability(MONSTER_CAPABILITY, null).getNianxian();
			int time = message.time;
			if (player instanceof EntityPlayer&&entity instanceof HunhuanEntity) {

				if(time==0){
					player.sendMessage(new TextComponentTranslation("message.hunhuan.list0", nianxian));
					return;
				}

				if(PlayerCapabilityApi.isXishouHunhuan((EntityPlayer) player)){
					float jingshenli = playerCapability.getJingshenli();
					float v = jingshenli - nianxian / 500;
					if(v >=0){

						if(time==100){
							playerCapability.setJingshenli(v);
							NetworkRegistryHandler.PlayerListen.sendClientCustomPacket((EntityPlayer) player);
							player.sendMessage(new TextComponentTranslation("message.hunhuan.list1", nianxian / 500));
							return;
						}
						if(time==160){

							playerCapability.setJingshenli(v);
							NetworkRegistryHandler.PlayerListen.sendClientCustomPacket((EntityPlayer) player);
							player.sendMessage(new TextComponentTranslation("message.hunhuan.list2", nianxian / 500));
							return;
						}
						if(time==220){

							playerCapability.setJingshenli(v);
							NetworkRegistryHandler.PlayerListen.sendClientCustomPacket((EntityPlayer) player);
							player.sendMessage(new TextComponentTranslation("message.hunhuan.list3", nianxian / 500));
							return;
						}
						if(time==280){

							playerCapability.setJingshenli(v);
							NetworkRegistryHandler.PlayerListen.sendClientCustomPacket((EntityPlayer) player);
							player.sendMessage(new TextComponentTranslation("message.hunhuan.list4", nianxian / 500));
							return;
						}
						if(time==340){

							playerCapability.setJingshenli(v);
							entity.setDead();
							if(new Random().nextInt(4)!=0||jingshenli>nianxian/10){
//								playerCapability.getMonsterCapabilityList().add(entity.getCapability(MONSTER_CAPABILITY, null));
								List<MonsterCapability> monsterCapabilityList = playerCapability.getMonsterCapabilityList();
								monsterCapabilityList.add(entity.getCapability(MONSTER_CAPABILITY, null));
								playerCapability.setMonsterCapabilityList(monsterCapabilityList);
								playerCapability.addDengji(1);
								NetworkRegistryHandler.PlayerListen.sendClientCustomPacket((EntityPlayer) player);
								player.sendMessage(new TextComponentTranslation("message.hunhuan.sccuess", nianxian ));
								return;
							}

							((EntityLivingBase)player).addPotionEffect(new PotionEffect(MobEffects.NAUSEA,200,0,true,true));
							player.sendMessage(new TextComponentTranslation("message.hunhuan.fail", nianxian));
						}

					}else {

						if(time==300) {
							playerCapability.setJingshenli(0);
							NetworkRegistryHandler.PlayerListen.sendClientCustomPacket((EntityPlayer) player);
							player.sendMessage(new TextComponentTranslation("message.hunhuan.list.false", jingshenli));
							((EntityLivingBase)player).addPotionEffect(new PotionEffect(MobEffects.NAUSEA,200,0,true,true));
						}
					}

				}else {

					if(time%100==0) {
						player.sendMessage(new TextComponentTranslation("message.hunhuan.list.no"));
					}
				}

			}
		}});
		return null;
	}
}

