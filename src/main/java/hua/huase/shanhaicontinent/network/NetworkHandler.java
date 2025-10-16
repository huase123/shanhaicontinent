/*
 * Copyright (c) 2018-2020 C4
 *
 * This file is part of Curios, a mod made for Minecraft.
 *
 * Curios is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Curios is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Curios.  If not, see <https://www.gnu.org/licenses/>.
 */

package hua.huase.shanhaicontinent.network;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.network.client.*;
import hua.huase.shanhaicontinent.network.server.*;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class NetworkHandler {

  private static final String PTC_VERSION = "1";

  public static SimpleChannel INSTANCE;

  private static int id = 0;

  public static void register() {

    INSTANCE = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(SHMainBus.MOD_ID, "main"))
        .networkProtocolVersion(() -> PTC_VERSION).clientAcceptedVersions(PTC_VERSION::equals)
        .serverAcceptedVersions(PTC_VERSION::equals).simpleChannel();

    //Client Packets
//    register(CPacketDemo.class, CPacketDemo::encode, CPacketDemo::decode, CPacketDemo::handle);
    register(CPacketCapability.class, CPacketCapability::encode, CPacketCapability::decode, CPacketCapability::handle);
    register(CPacketOpenAttrGUI.class, CPacketOpenAttrGUI::encode, CPacketOpenAttrGUI::decode, CPacketOpenAttrGUI::handle);
    register(CPacketQiehuanWuhun.class, CPacketQiehuanWuhun::encode, CPacketQiehuanWuhun::decode, CPacketQiehuanWuhun::handle);
    register(CPacketHunji.class, CPacketHunji::encode, CPacketHunji::decode, CPacketHunji::handle);

    // Server Packets
//    register(SPacketDemo.class, SPacketDemo::encode, SPacketDemo::decode, SPacketDemo::handle);
    register(SPacketCapability.class, SPacketCapability::encode, SPacketCapability::decode, SPacketCapability::handle);
    register(SPacketEntityAttribute.class, SPacketEntityAttribute::encode, SPacketEntityAttribute::decode, SPacketEntityAttribute::handle);
    register(AreaProtectionPacket.class, AreaProtectionPacket::encode, AreaProtectionPacket::new, AreaProtectionPacket.Handler::onMessage);

  }

  private static <M> void register(Class<M> messageType, BiConsumer<M, FriendlyByteBuf> encoder,
                                   Function<FriendlyByteBuf, M> decoder,
                                   BiConsumer<M, Supplier<NetworkEvent.Context>> messageConsumer) {
    INSTANCE.registerMessage(id++, messageType, encoder, decoder, messageConsumer);
  }
}
