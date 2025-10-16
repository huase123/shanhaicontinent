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

package hua.huase.shanhaicontinent.network.client;

import hua.huase.shanhaicontinent.capabilitys.CapabilityUtil;
import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.capabilitys.capability.AttributeBase;
import hua.huase.shanhaicontinent.capabilitys.capability.Update;
import hua.huase.shanhaicontinent.network.NetworkHandler;
import hua.huase.shanhaicontinent.network.server.SPacketCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;

import java.util.HashMap;
import java.util.function.Supplier;

public class CPacketCapability {

  private int entityId;

  public CPacketCapability(int entityId) {
    this.entityId = entityId;
  }

  public static void encode(CPacketCapability msg, FriendlyByteBuf buf) {
    buf.writeInt(msg.entityId);
  }

  public static CPacketCapability decode(FriendlyByteBuf buf) {
    return new CPacketCapability(buf.readInt());
  }

  public static void handle(CPacketCapability msg, Supplier<NetworkEvent.Context> ctx) {
    ctx.get().enqueueWork(() -> {
      ServerPlayer sender = ctx.get().getSender();
      if (sender != null) {
        Entity entity = sender.level().getEntity(msg.entityId);
        if(entity != null){
          AttributeBase capability = CapabilityUtil.getCapability(entity);
          NetworkHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> sender), new SPacketCapability(entity.getId(),capability.serializeNBT()));
        }
      }
    });
    ctx.get().setPacketHandled(true);
  }
}
