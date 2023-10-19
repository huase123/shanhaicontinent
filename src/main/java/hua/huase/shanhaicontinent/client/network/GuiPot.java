package hua.huase.shanhaicontinent.client.network;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.network.ContainerGuiPot;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiPot extends GuiContainer
{
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ExampleMod.MODID + ":textures/gui/potdisplayer.png");
    private static final ResourceLocation FIRE =
            new ResourceLocation(ExampleMod.MODID + ":textures/gui/fire.png");

    public GuiPot(EntityPlayer player, World world, int x, int y, int z)
    {
        super(new ContainerGuiPot(player, world, x, y, z));
        this.xSize = (int) (480*0.8);
        this.ySize = (int) (270*0.8);
    }

//    绘制画板
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        super.renderHoveredToolTip(mouseX, mouseY);
    }

    //    绘制GUI
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        int left = (this.width - this.xSize) / 2;
        int top = (this.height - this.ySize) / 2;
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);//获取背景图片
//        this.drawTexturedModalRect(left, left, 0, 0, this.xSize, this.ySize);//完全跟画板重合
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos((left+0), (top+this.ySize), this.zLevel).tex(0.0D, 1D).endVertex();
        bufferbuilder.pos((left+this.xSize), (top+this.ySize), this.zLevel).tex(1D, 1D).endVertex();
        bufferbuilder.pos((left+this.xSize), (top+0), this.zLevel).tex(1D, 0.0D).endVertex();
        bufferbuilder.pos((left+0), (top+0), this.zLevel).tex(0.0D, 0.0D).endVertex();
        tessellator.draw();

        int compressorProgress = ((ContainerGuiPot) this.inventorySlots).getCompressorProgress();

        float height = 100f - compressorProgress*100f/240f;
        this.mc.getTextureManager().bindTexture(FIRE);//获取背景图片
        Tessellator tessellatorx = Tessellator.getInstance();
        BufferBuilder bufferbuilderx = tessellatorx.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilderx.pos((left+211+0), (top+15+102), this.zLevel).tex(0.0D,1D).endVertex();
        bufferbuilderx.pos((left+211+93), (top+15+102), this.zLevel).tex(1D, 1D).endVertex();
        bufferbuilderx.pos((left+211+93), (top+15+height), this.zLevel).tex(1D, height/102).endVertex();
        bufferbuilderx.pos((left+211+0), (top+15+height), this.zLevel).tex(0.0D, height/102).endVertex();
        tessellator.draw();
        int itemStace = ((ContainerGuiPot) this.inventorySlots).getItemStace();

        String list0="";
        String[] list1=null;
        String[] list2=null;
        String[] list3=null;
        String[] list4=null;
        String[] list5=null;
        String list6="";

        switch (itemStace){
            case 0:
                list0 =I18n.format("danfang0.peifang.list0");
                list1 = new String[]{I18n.format("danfang0.peifang.list1")};
                list2 = new String[]{I18n.format("danfang0.peifang.list2")};
                list3 = new String[]{I18n.format("danfang0.peifang.list3")};
                list4 = new String[]{I18n.format("danfang0.peifang.list4")};
                list5 = new String[]{I18n.format("danfang0.peifang.list5")};
                list6 =I18n.format("danfang0.peifang.list6");
                break;
            case 1:
                list0 =I18n.format("danfang1.peifang.list0");
                list1 = new String[]{I18n.format("danfang1.peifang.list1")};
                list2 = new String[]{I18n.format("danfang1.peifang.list2")};
                list3 = new String[]{I18n.format("danfang1.peifang.list3")};
                list4 = new String[]{I18n.format("danfang1.peifang.list4")};
                list5 = new String[]{I18n.format("danfang1.peifang.list5")};
                list6 =I18n.format("danfang1.peifang.list6");
                break;
            case 2:
                list0 =I18n.format("danfang2.peifang.list0");
                list1 = new String[]{I18n.format("danfang2.peifang.list1.0"),I18n.format("danfang2.peifang.list1.1")};
                list2 = new String[]{I18n.format("danfang2.peifang.list2")};
                list3 = new String[]{I18n.format("danfang2.peifang.list3")};
                list4 = new String[]{I18n.format("danfang2.peifang.list4")};
                list5 = new String[]{I18n.format("danfang2.peifang.list5")};
                list6 =I18n.format("danfang2.peifang.list6");
                break;
            case 3:
                list0 =I18n.format("danfang3.peifang.list0");
                list1 = new String[]{I18n.format("danfang3.peifang.list1")};
                list2 = new String[]{I18n.format("danfang3.peifang.list2")};
                list3 = new String[]{I18n.format("danfang3.peifang.list3")};
                list4 = new String[]{I18n.format("danfang3.peifang.list4")};
                list5 = new String[]{I18n.format("danfang3.peifang.list5")};
                list6 =I18n.format("danfang3.peifang.list6");
                break;
            case 4:
                list0 =I18n.format("danfang4.peifang.list0");
                list1 = new String[]{I18n.format("danfang4.peifang.list1.0"),I18n.format("danfang4.peifang.list1.1")};
                list2 = new String[]{I18n.format("danfang4.peifang.list2")};
                list3 = new String[]{I18n.format("danfang4.peifang.list3")};
                list4 = new String[]{I18n.format("danfang4.peifang.list4")};
                list5 = new String[]{I18n.format("danfang4.peifang.list5")};
                list6 =I18n.format("danfang4.peifang.list6");
                break;
            case 5:
                list0 =I18n.format("danfang5.peifang.list0");
                list1 = new String[]{I18n.format("danfang5.peifang.list1.0"),I18n.format("danfang4.peifang.list1.1")};
                list2 = new String[]{I18n.format("danfang5.peifang.list2")};
                list3 = new String[]{I18n.format("danfang5.peifang.list3")};
                list4 = new String[]{I18n.format("danfang5.peifang.list4")};
                list5 = new String[]{I18n.format("danfang5.peifang.list5")};
                list6 =I18n.format("danfang5.peifang.list6");
                break;
            case 6:
                list0 =I18n.format("danfang6.peifang.list0");
                list1 = new String[]{I18n.format("danfang6.peifang.list1")};
                list2 = new String[]{I18n.format("danfang6.peifang.list2")};
                list3 = new String[]{I18n.format("danfang6.peifang.list3")};
                list4 = new String[]{I18n.format("danfang6.peifang.list4")};
                list5 = new String[]{I18n.format("danfang6.peifang.list5")};
                list6 =I18n.format("danfang6.peifang.list6");
                break;
            case 7:
                list0 =I18n.format("danfang7.peifang.list0");
                list1 = new String[]{I18n.format("danfang7.peifang.list1")};
                list2 = new String[]{I18n.format("danfang7.peifang.list2")};
                list3 = new String[]{I18n.format("danfang7.peifang.list3")};
                list4 = new String[]{I18n.format("danfang7.peifang.list4")};
                list5 = new String[]{I18n.format("danfang7.peifang.list5")};
                list6 =I18n.format("danfang7.peifang.list6");
                break;
            case 8:
                list0 =I18n.format("danfang8.peifang.list0");
                list1 = new String[]{I18n.format("danfang8.peifang.list1")};
                list2 = new String[]{I18n.format("danfang8.peifang.list2")};
                list3 = new String[]{I18n.format("danfang8.peifang.list3")};
                list4 = new String[]{I18n.format("danfang8.peifang.list4")};
                list5 = new String[]{I18n.format("danfang8.peifang.list5")};
                list6 =I18n.format("danfang8.peifang.list6");
                break;

        }





            drawText(list0,left+17,top+130);
            if(compressorProgress>0&&compressorProgress<=40){

                drawTextarrage(list1,left+19,top+134+18*1);
            }
            if(compressorProgress>40&&compressorProgress<=80){

                drawTextarrage(list2,left+19,top+134+18*1);
            }
            if(compressorProgress>80&&compressorProgress<=120){

                drawTextarrage(list3,left+19,top+134+18*1);
            }
            if(compressorProgress>120&&compressorProgress<=160){

                drawTextarrage(list4,left+19,top+134+18*1);
            }
            if(compressorProgress>160&&compressorProgress<=200){

                drawTextarrage(list5,left+19,top+134+18*1);
            }
            if(compressorProgress>200&&compressorProgress<=240){

                drawText(list6,left+19,top+134+18*1);
            }



    }


    protected void drawText(String text,int left,int top)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate(1,1,1);
        fontRenderer.drawString(text,left, top, 0xff1a1104,true);
        GlStateManager.popMatrix();
    }
    protected void drawTextarrage(String[] texts,int left,int top)
    {
        if(texts!=null){

            for (String text:texts) {
                GlStateManager.pushMatrix();
                GlStateManager.translate(1, 1, 1);
                fontRenderer.drawString(text, left, top, 0xff1a1104, true);
                GlStateManager.popMatrix();
                top += 18;
            }
        }
    }
}
