package hua.huase.shanhaicontinent.network;

import hua.huase.shanhaicontinent.client.network.DanfangGui;
import hua.huase.shanhaicontinent.client.network.GuiPlayerExpanded;
import hua.huase.shanhaicontinent.client.network.GuiPot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class FMLTutorGuiHandler implements IGuiHandler
{
    public static final int DIRT_COMPRESSOR = 1;
    public static final int PLAERCApABILITY = 2;
    public static final int PLAEREXPANSED = 3;
    public static final int POTGUI = 4;
    public static final int DANFANG = 5;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        if (id == DIRT_COMPRESSOR)
        {
        }
        if (id == PLAERCApABILITY)
        {
//            return new PlayerCapability(player, world, x, y, z);
        }
        if (id == PLAEREXPANSED)
        {
            return new ContainerPlayerExpanded(player.inventory, !player.getEntityWorld().isRemote, player);
        }
        if (id == POTGUI)
        {
            return new ContainerGuiPot(player, world, x, y, z);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        if (id == DIRT_COMPRESSOR)
        {
        }
        if (id == PLAERCApABILITY)
        {
        }
        if (id == PLAEREXPANSED)
        {
            return new GuiPlayerExpanded(player);
        }
        if (id == POTGUI)
        {
            return new GuiPot(player, world, x, y, z);
        }
        if (id == DANFANG)
        {
            return new DanfangGui(player.getHeldItemMainhand());
        }
        return null;
    }
}
