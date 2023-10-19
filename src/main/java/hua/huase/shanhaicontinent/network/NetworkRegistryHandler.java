package hua.huase.shanhaicontinent.network;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLEventChannel;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;

public class NetworkRegistryHandler
{
    public static void register()
    {

//        用于区别不同客户端的监听事件，即注册不同的端口号
        PlayerListen.CHANNEL.register(PlayerListen.class);
//        MonsterListen.CHANNEL.register(MonsterListen.class);


        NetworkRegistry.INSTANCE.registerGuiHandler(ExampleMod.MODID, new FMLTutorGuiHandler());
    }




    public static class PlayerListen
    {
        private static final String NAME = "PLAYERSHUXING";
        private static final FMLEventChannel CHANNEL = NetworkRegistry.INSTANCE.newEventDrivenChannel(NAME);
        public static void sendClientCustomPacket(EntityPlayer player)
        {
            PlayerCapability power = player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
            PacketBuffer buf = new PacketBuffer(Unpooled.buffer());

            player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(power.getMaxshengming());
//            power.setShengming(player.getHealth());
            buf.writeCompoundTag(power.serializeNBT());
            CHANNEL.sendTo(new FMLProxyPacket(buf, NAME), (EntityPlayerMP) player);
        }
        @SubscribeEvent
        @SideOnly(Side.CLIENT)
        public static void onClientCustomPacket(FMLNetworkEvent.ClientCustomPacketEvent event) throws IOException {
            PacketBuffer buf = (PacketBuffer) event.getPacket().payload();
            NBTTagCompound nbtTagCompound = buf.readCompoundTag();

            Minecraft mc = Minecraft.getMinecraft();
            mc.addScheduledTask(() ->
            {
                EntityPlayer player = mc.player;
                PlayerCapability power = player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
                power.deserializeNBT(nbtTagCompound);
            });
        }
    }





}
