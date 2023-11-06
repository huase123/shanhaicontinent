package hua.huase.shanhaicontinent.comand;

import hua.huase.shanhaicontinent.capability.MonsterCapability;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentTranslation;

import java.util.List;

import static hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler.PLYAER_CAPABILITY;

public class Commandremovehunhuan extends CommandBase {

    
    @Override
    public String getName() {
        return "removehunhuan";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.removehunhuan.usage";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {

        Entity entity;

        if (args.length == 1)
        {
            entity = getEntity(server, sender, args[0]);
        }else if(args.length == 0){
            entity=sender.getCommandSenderEntity();
        }else{
            return;
        }
        PlayerCapability capability = entity.getCapability(PLYAER_CAPABILITY, null);


        List<MonsterCapability> monsterCapabilityList = capability.getMonsterCapabilityList();
        if(monsterCapabilityList!=null&&monsterCapabilityList.size()>0){
            capability.setDengji(monsterCapabilityList.size()*10-1);
            monsterCapabilityList.remove(monsterCapabilityList.size()-1);
            entity.getCommandSenderEntity().sendMessage(new TextComponentTranslation("message.removehunhuan.success"));

        }else {

            entity.getCommandSenderEntity().sendMessage(new TextComponentTranslation("message.removehunhuan.fail"));
        }





    }
    // 可以不覆写，但默认权限要求是 4（即游戏管理员），所以请按需覆写
    @Override
    public int getRequiredPermissionLevel() {
        return 4; // 0 代表任何人都能用
    }
}
