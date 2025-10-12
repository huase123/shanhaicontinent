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

package hua.huase.shanhaicontinent.network.server;

import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapability;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import hua.huase.shanhaicontinent.capabilitys.capability.PlayerCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.NonNullConsumer;
import net.minecraftforge.network.NetworkEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.function.Supplier;

public class SPacketPlayerAttribute {

  private int entityId;
  private CompoundTag nbt;

  public SPacketPlayerAttribute(int entityId, CompoundTag nbt) {
    this.entityId = entityId;
    this.nbt = nbt;
  }

  public static void encode(SPacketPlayerAttribute msg, FriendlyByteBuf buf) {
    buf.writeInt(msg.entityId);
    buf.writeNbt(msg.nbt);
  }

  public static SPacketPlayerAttribute decode(FriendlyByteBuf buf) {
    return new SPacketPlayerAttribute(buf.readInt(), buf.readNbt());
  }

  public static void handle(SPacketPlayerAttribute msg, Supplier<NetworkEvent.Context> ctx) {
    ctx.get().enqueueWork(() -> {
      ClientLevel world = Minecraft.getInstance().level;

      if (world != null) {
        Entity entity = world.getEntity(msg.entityId);
        if(entity != null){
          entity.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).ifPresent(playerCapability -> playerCapability.deserializeNBT(msg.nbt));
        }
      }
    });
    ctx.get().setPacketHandled(true);
  }
}
