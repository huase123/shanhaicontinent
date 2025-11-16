package hua.huase.shanhaicontinent.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapability;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.network.SynsAPI;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;

public class ChangeAttributeCommand {
	public static LiteralArgumentBuilder<CommandSourceStack> register() {
		return Commands.literal("attribute")
				.requires(cs -> cs.hasPermission(2))
				.then(Commands.argument("target", EntityArgument.entity())
					.then(Commands.literal("setmaxshengming")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setMaxshengming(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setJingshenli")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setJingshenli(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setmaxjingshenli")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setMaxjingshenli(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setWugong")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setWugong(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setWufang")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setWufang(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setBaojishanghai")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setBaojishanghai(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setBaojilv")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setBaojilv(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setZhenshang")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setZhenshang(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setWuchuan")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setWuchuan(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setKangbao")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setKangbao(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setXixue")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setXixue(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setShengminghuifu")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setShengminghuifu(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setMingzhong")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setMingzhong(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setShanbi")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setShanbi(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setDengji")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setDengji(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
					.then(Commands.literal("setZhuanshengshu")
						.then(Commands.argument("amount", IntegerArgumentType.integer())
								.executes(ctx -> setZhuanshengshu(EntityArgument.getEntity(ctx, "target"), IntegerArgumentType.getInteger(ctx, "amount")))
						))
				);
	}

	private static int setMaxshengming(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setMaxshengming(Math.max(1,num));
			player.sendSystemMessage(Component.translatable("最大生命",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}

	private static int setJingshenli(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setJingshenli(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("精神力",num,num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setMaxjingshenli(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setMaxjingshenli(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("获得最大精神力",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setWugong(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setWugong(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("物攻",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setWufang(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setWufang(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("物防",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setBaojishanghai(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setBaojishanghai(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("爆伤",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setBaojilv(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setBaojilv(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("爆率",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setZhenshang(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setZhenshang(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("真伤",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setWuchuan(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setWuchuan(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("物穿",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setKangbao(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setKangbao(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("抗暴",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setXixue(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setXixue(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("吸血",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setShengminghuifu(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setShengminghuifu(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("回复",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setMingzhong(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setMingzhong(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("命中",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setShanbi(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setShanbi(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("闪避",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setDengji(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setDengji(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("等级",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
	private static int setZhuanshengshu(Entity player, int num) {
		player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
			capability.setZhuanshengshu(Math.max(0,num));
			player.sendSystemMessage(Component.translatable("转生",num).withStyle(ChatFormatting.YELLOW));
		});
		SynsAPI.synsPlayerAttribute(player);
		return Command.SINGLE_SUCCESS;
	}
}
