package hua.huase.shanhaicontinent.client.network;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.item.danfangdir.DanFang;
import hua.huase.shanhaicontinent.item.danfangdir.DanFangJiuHua;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class DanfangGui extends GuiContainer
{
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ExampleMod.MODID + ":textures/gui/danfang/danfang.png");

    private  int handStack;
    private  ItemStack itemStack;
    public DanfangGui(ItemStack itemStack)
    {
        super(new Container() {
            @Override
            public boolean canInteractWith(EntityPlayer playerIn) {
                return false;
            }
        });
        this.xSize = (int) (480*0.8);
        this.ySize = (int) (270*0.8);
        this.handStack = itemStack.getItem().getDamage(itemStack);
        this.itemStack=itemStack;
    }

//    绘制画板
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    //    绘制GUI
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        int left = (this.width - this.xSize) / 2;
        int top = (this.height - this.ySize) / 2;
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);//获取背景图片
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos((left+0), (top+this.ySize), this.zLevel).tex(0.0D, 1D).endVertex();
        bufferbuilder.pos((left+this.xSize), (top+this.ySize), this.zLevel).tex(1D, 1D).endVertex();
        bufferbuilder.pos((left+this.xSize), (top+0), this.zLevel).tex(1D, 0.0D).endVertex();
        bufferbuilder.pos((left+0), (top+0), this.zLevel).tex(0.0D, 0.0D).endVertex();
        tessellator.draw();

        String title = I18n.format("");
        String introduce = I18n.format("");
        String effect = I18n.format("");
        String material = I18n.format("");
        if(itemStack.getItem() instanceof DanFang){
            switch (handStack){
                case 0: title =I18n.format("danfang.qihundan");
                    introduce =I18n.format("danfang.qihundan.introduce");
                    effect =I18n.format("danfang.qihundan.effect");
                    material =I18n.format("danfang.qihundan.material");
                    break;

                case 1: title =I18n.format("danfang.jvlingdan");
                    introduce =I18n.format("danfang.jvlingdan.introduce");
                    effect =I18n.format("danfang.jvlingdan.effect");
                    material =I18n.format("danfang.jvlingdan.material");
                    break;

                case 2: title =I18n.format("danfang.xvanyuandan");
                    introduce =I18n.format("danfang.xvanyuandan.introduce");
                    effect =I18n.format("danfang.xvanyuandan.effect");
                    material =I18n.format("danfang.xvanyuandan.material");
                    break;

                case 3: title =I18n.format("danfang.yanghundan");
                    introduce =I18n.format("danfang.yanghundan.introduce");
                    effect =I18n.format("danfang.yanghundan.effect");
                    material =I18n.format("danfang.yanghundan.material");
                    break;

                case 4: title =I18n.format("danfang.lingbidan");
                    introduce =I18n.format("danfang.lingbidan.introduce");
                    effect =I18n.format("danfang.lingbidan.effect");
                    material =I18n.format("danfang.lingbidan.material");
                    break;

                case 5: title =I18n.format("danfang.haoyuan");
                    introduce =I18n.format("danfang.haoyuan.introduce");
                    effect =I18n.format("danfang.haoyuan.effect");
                    material =I18n.format("danfang.haoyuan.material");
                    break;

                case 6: title =I18n.format("danfang.xihundan");
                    introduce =I18n.format("danfang.xihundan.introduce");
                    effect =I18n.format("danfang.xihundan.effect");
                    material =I18n.format("danfang.xihundan.material");
                    break;

                case 7: title =I18n.format("danfang.huangjidan");
                    introduce =I18n.format("danfang.huangjidan.introduce");
                    effect =I18n.format("danfang.huangjidan.effect");
                    material =I18n.format("danfang.huangjidan.material");
                    break;

                case 8: title =I18n.format("danfang.lushendan");
                    introduce =I18n.format("danfang.lushendan.introduce");
                    effect =I18n.format("danfang.lushendan.effect");
                    material =I18n.format("danfang.lushendan.material");
                    break;



                default: ;break;
            }

        }
        if(itemStack.getItem() instanceof DanFangJiuHua){
            title =I18n.format("danfang.jiuhua");
            introduce =I18n.format("danfang.jiuhua.introduce");
            effect =I18n.format("danfang.jiuhua.effect");
            material =I18n.format("danfang.jiuhua.material");
        }

//        this.drawCenteredString(this.fontRenderer, text, this.xSize / 2, 6, 0x00404040);



        GlStateManager.pushMatrix();
        GlStateManager.translate(1,1,1);
        fontRenderer.drawString(title,left+192-fontRenderer.getStringWidth(String.valueOf(title)) / 2, top+48, 0xff1a1104,true);
        GlStateManager.popMatrix();


        GlStateManager.pushMatrix();
        GlStateManager.translate(0.8,0.8,1);
        fontRenderer.drawString(introduce,left+192-fontRenderer.getStringWidth(String.valueOf(introduce)) / 2, top+48+18, 0xff1a1104,true);
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.translate(0.8,0.8,1);
        fontRenderer.drawString(effect,left+192-fontRenderer.getStringWidth(String.valueOf(effect)) / 2, top+48+34, 0xff1a1104,true);
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.translate(0.8,0.8,1);
        fontRenderer.drawString(material,left+192-fontRenderer.getStringWidth(String.valueOf(material)) / 2, top+48+50, 0xff1a1104,true);
        GlStateManager.popMatrix();

    }






}
