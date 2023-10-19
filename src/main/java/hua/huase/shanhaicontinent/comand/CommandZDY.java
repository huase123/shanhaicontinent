package hua.huase.shanhaicontinent.comand;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;

public class CommandZDY extends CommandBase {

    
    @Override
    public String getName() {
        return "comandzdy";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "commands.comandzdy.usage";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {


        sender.getCommandSenderEntity().changeDimension(21,new ITeleporter(){
            @Override
            public void placeEntity(World world, Entity entity, float yaw) {

            }

            @Override
            public boolean isVanilla() {
                return false;
            }
        });
/*
        if (!server.getWorld(0).isRemote && !entityIn.isRiding() && !entityIn.isBeingRidden() && entityIn.isNonBoss() && entityIn.getEntityBoundingBox().intersects(state.getBoundingBox(worldIn, pos).offset(pos)))
        {
            entityIn.changeDimension(1);
        }
        */
/*

        String im ="GetEcho";
        PlayerList list =server.getPlayerList();
        list.transferPlayerToDimension((EntityPlayerMP) list.getPlayers().toArray()[0],21,new Teleporter(server.getWorld(-1)));
        server.setPlayerList(list);
        if(args!=null&&args.length>0){
            for(String gtu:args){
                im+=gtu;
            }
            TextComponentString text= new TextComponentString(im);
            text.getStyle().setColor(TextFormatting.GREEN);
            sender.sendMessage(text);
        }else {
            TextComponentString text= new TextComponentString("You must Write <Messgage>!");
            text.getStyle().setColor(TextFormatting.RED);
            sender.sendMessage(text);
        }
*/

    }
    // 可以不覆写，但默认权限要求是 4（即游戏管理员），所以请按需覆写
    @Override
    public int getRequiredPermissionLevel() {
        return 0; // 0 代表任何人都能用
    }
}
