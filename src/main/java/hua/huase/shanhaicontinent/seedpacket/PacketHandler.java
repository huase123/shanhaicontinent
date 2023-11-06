package hua.huase.shanhaicontinent.seedpacket;

import hua.huase.shanhaicontinent.ExampleMod;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler
{
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ExampleMod.MODID.toLowerCase());

	public static void init()
	{
		INSTANCE.registerMessage(PacketOpenBaublesInventory.class, PacketOpenBaublesInventory.class, 0, Side.SERVER);
		INSTANCE.registerMessage(PacketOpenNormalInventory.class, PacketOpenNormalInventory.class, 1, Side.SERVER);
		INSTANCE.registerMessage(PacketSync.Handler.class, PacketSync.class, 2, Side.CLIENT);
		INSTANCE.registerMessage(PacketPlayerHunhuan.class, PacketPlayerHunhuan.class, 3, Side.SERVER);
		INSTANCE.registerMessage(PacketMonster.Handler.class, PacketMonster.class, 4, Side.CLIENT);
		INSTANCE.registerMessage(PacketTuPo.class, PacketTuPo.class, 5, Side.SERVER);
		INSTANCE.registerMessage(PacketOpenHunhuan.class, PacketOpenHunhuan.class, 6, Side.SERVER);
		INSTANCE.registerMessage(PacketPlayerCapability.Handler.class, PacketPlayerCapability.class, 7, Side.CLIENT);
		INSTANCE.registerMessage(PacketHunhuanKaiguan.Handler.class, PacketHunhuanKaiguan.class, 8, Side.CLIENT);
		INSTANCE.registerMessage(PacketJiNengKaiguan.class, PacketJiNengKaiguan.class, 9, Side.SERVER);

//		INSTANCE.registerMessage(PacketHeartDisplay.Handler.class, PacketHeartDisplay.class, 9, Side.CLIENT);
	}
}
