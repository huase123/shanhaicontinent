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

import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapability;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.entity.jinengitem.JinengItemEntity;
import hua.huase.shanhaicontinent.item.ItemInit;
import hua.huase.shanhaicontinent.item.jineng.Jineng;
import hua.huase.shanhaicontinent.network.SynsAPI;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CPacketHunji {

  public static void encode(CPacketHunji msg, FriendlyByteBuf buf) {
  }

  public static CPacketHunji decode(FriendlyByteBuf buf) {
    return new CPacketHunji();
  }

  private static long leveTime=0;

  public static void handle(CPacketHunji msg, Supplier<NetworkEvent.Context> ctx) {
    ctx.get().enqueueWork(() -> {
      ServerPlayer sender = ctx.get().getSender();

      if(sender.level().getGameTime()<=leveTime+200)return;
      leveTime=sender.level().getGameTime();
      sender.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {

        String wuhunName = capability.getWuhunName();
        if(wuhunName != null){
          int index = 0;
          for (MonsterAttributeCapability monsterAttributeCapability : capability.getWuhunList()) {
            ItemStack itemStack = creactItemStack(sender,wuhunName,monsterAttributeCapability.getNianxian(),index);
            JinengItemEntity.createEntity(sender,index,itemStack);
            index++;
          }

        }

        SynsAPI.synsPlayerAttribute(sender);
      });

    });
    ctx.get().setPacketHandled(true);
  }


//  生成技能物品
  private static ItemStack creactItemStack(ServerPlayer sender, String wuhunName, int nianxian, int index) {

    if(ItemInit.JINENGMAP.get(wuhunName) == null)return ItemStack.EMPTY;

    Item item = ItemInit.JINENGMAP.get(wuhunName).get(index).get();
    ItemStack itemStack = new ItemStack(item);
    if(item instanceof Jineng jineng){
      jineng.belongToPlayer(sender,itemStack);
      jineng.setNianxian(sender,itemStack,nianxian);
    }


    return itemStack;
  }
}
