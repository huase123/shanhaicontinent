package hua.huase.shanhaicontinent.comand;

import hua.huase.shanhaicontinent.capability.PlayerCapability;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentTranslation;

import static hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler.PLYAER_CAPABILITY;

public class Commandaddjingshenli extends CommandBase {

    
    @Override
    public String getName() {
        return "addjingshenli";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.addjingshenli.usage";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        if(args==null)return;


        if(Float.parseFloat(args[0])>1000||Float.parseFloat(args[0])<-1000) {
            sender.getCommandSenderEntity().sendMessage(new TextComponentTranslation(net.minecraft.client.resources.I18n.format("message.addjingshenli.fail", args[0])));
            return;
        }


        if(args!=null&&sender.getCommandSenderEntity()!=null){

            PlayerCapability capability = sender.getCommandSenderEntity().getCapability(PLYAER_CAPABILITY, null);

            capability.addJingshenli(Float.parseFloat(args[0]));
            sender.getCommandSenderEntity().sendMessage(new TextComponentTranslation(net.minecraft.client.resources.I18n.format("message.addjingshenli.success", args[0])));


        }


    }
    // 可以不覆写，但默认权限要求是 4（即游戏管理员），所以请按需覆写
    @Override
    public int getRequiredPermissionLevel() {
        return 4; // 0 代表任何人都能用
    }
}
