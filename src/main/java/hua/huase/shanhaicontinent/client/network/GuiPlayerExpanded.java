package hua.huase.shanhaicontinent.client.network;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.capability.MonsterCapability;
import hua.huase.shanhaicontinent.client.keybinding.MyKeyBinding;
import hua.huase.shanhaicontinent.network.ContainerPlayerExpanded;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler.PLYAER_CAPABILITY;
import static net.minecraft.entity.SharedMonsterAttributes.MAX_HEALTH;

@SideOnly(Side.CLIENT)
public  class GuiPlayerExpanded extends GuiContainer
{

	public static final ResourceLocation background =
			new ResourceLocation(ExampleMod.MODID, "textures/gui/playercapabilityx.png");
	public static final ResourceLocation hunhuan =
			new ResourceLocation(ExampleMod.MODID, "textures/picture/particletext.png");
	/**
	 * The old x position of the mouse pointer
	 */
	private float oldMouseX;
	/**
	 * The old y position of the mouse pointer
	 */
	private float oldMouseY;

	EntityPlayer player;


	public GuiPlayerExpanded(EntityPlayer player) {
		super(new ContainerPlayerExpanded(player.inventory, !player.getEntityWorld().isRemote, player));

		this.xSize = (int) (480*0.8);
		this.ySize = (int) (270*0.8);
		this.player = player;
	}


	//    绘制画板
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		super.renderHoveredToolTip(mouseX, mouseY);
	}


	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int mouseX, int mouseY) {

		int left = (this.width - this.xSize) / 2;
		int top = (this.height - this.ySize) / 2;
		int x = this.xSize / 16;
		int y = this.ySize / 16;


		this.mc.getTextureManager().bindTexture(background);//获取背景图片
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		bufferbuilder.pos((left+0), (top+this.ySize), this.zLevel).tex(0.0D, 1D).endVertex();
		bufferbuilder.pos((left+this.xSize), (top+this.ySize), this.zLevel).tex(1D, 1D).endVertex();
		bufferbuilder.pos((left+this.xSize), (top+0), this.zLevel).tex(1D, 0.0D).endVertex();
		bufferbuilder.pos((left+0), (top+0), this.zLevel).tex(0.0D, 0.0D).endVertex();
		tessellator.draw(); //将数组和渲染方式提交到GPU
		GuiInventory.drawEntityOnScreen(left+192, top+108, 30, (float)(left+192) - mouseX, (float)(top+108-50) - mouseY, this.mc.player);


		hua.huase.shanhaicontinent.capability.PlayerCapability capability =player.getCapability(PLYAER_CAPABILITY, null);
		if(capability!=null){
			drawCapability(capability,left+24,top+13);
		}
		List<MonsterCapability> monsterCapabilityList = capability.getMonsterCapabilityList();
		if(monsterCapabilityList==null)return;
		for (int i = 0; i < Math.min(monsterCapabilityList.size(),5); i++) {
			MonsterCapability monsterCapability = monsterCapabilityList.get(i);
			drawHunhuan(monsterCapability.getNianxian(),left+277,top+12+i*40,x,y);
			drawNianxian(monsterCapability.getNianxian(),left+277,top+12+i*40,x,y);
		}
		for (int i = 5; i < monsterCapabilityList.size(); i++) {

			MonsterCapability monsterCapability = monsterCapabilityList.get(i);
			drawHunhuan(monsterCapability.getNianxian(),left+332,top+12+(i-5)*40,x,y);
			drawNianxian(monsterCapability.getNianxian(),left+332,top+12+(i-5)*40,x,y);
		}


	}



	protected void drawNianxian(int nianxian,int left,int top,int x,int y) {
		String s ="";
		if(nianxian>=1000000){
			s = net.minecraft.util.text.translation.I18n.translateToLocalFormatted("nianxian.display0.name", nianxian);
		}else if(nianxian>=100000){
			s = net.minecraft.util.text.translation.I18n.translateToLocalFormatted("nianxian.display1.name", nianxian);
		}else if(nianxian>=10000){
			s = net.minecraft.util.text.translation.I18n.translateToLocalFormatted("nianxian.display2.name", nianxian);
		}else if(nianxian>=1000){
			s = net.minecraft.util.text.translation.I18n.translateToLocalFormatted("nianxian.display3.name", nianxian);
		}else if(nianxian>=100){
			s = net.minecraft.util.text.translation.I18n.translateToLocalFormatted("nianxian.display4.name", nianxian);
		}else if(nianxian>=1){
			s = net.minecraft.util.text.translation.I18n.translateToLocalFormatted("nianxian.display5.name", nianxian);
		}


		GlStateManager.pushMatrix();
		GlStateManager.translate(left+ x, top+ 2*y, 0);

		GlStateManager.scale(0.6F, 0.6F, 1F);

		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
		int strLenHalved = fontRenderer.getStringWidth(s) / 2;

		fontRenderer.drawString(s, -strLenHalved, 0, 0xf0f01010,true);
		GlStateManager.popMatrix();





	}


	int time =0;
	protected void drawHunhuan(int color,int left,int top,int x,int y) {

		int limitFramerate = Minecraft.getMinecraft().gameSettings.limitFramerate;
		float ticks = (float) ((float)time/(float)limitFramerate);

		GlStateManager.pushMatrix();
		GlStateManager.translate(left+ x, top+ y, 40);
		GlStateManager.rotate(-45, 1, 0, 0);
		GlStateManager.rotate(ticks*5, 0, 0, 1);


		if(color>=1000000){
			GlStateManager.color(1f, 0, 0,0.8f);
			GlStateManager.scale(1.18f, 1.18f, 0);
		}else if(color>=100000){
			GlStateManager.color(1f, 0, 0,0.8f);
		}else if(color>=10000){
			GlStateManager.color(0, 0f, 0,0.8f);
		}else if(color>=1000){
			GlStateManager.color(1f, 0f, 1f,0.8f);
		}else if(color>=100){
			GlStateManager.color(1f, 1f, 0,0.8f);
		}else if(color>=1){
			GlStateManager.color(1f, 1f, 1f,0.8f);
		}


		this.mc.getTextureManager().bindTexture(hunhuan);//获取背景图片
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		bufferbuilder.pos((-x), (-x), this.zLevel).tex(0.0D, 0.0D).endVertex();
		bufferbuilder.pos((-x), x, this.zLevel).tex(0.0D, 1D).endVertex();
		bufferbuilder.pos(x, x, this.zLevel).tex(1D, 1D).endVertex();
		bufferbuilder.pos(x, (-x), this.zLevel).tex(1D, 0.0D).endVertex();
		tessellator.draw();
		GlStateManager.popMatrix();

		if(time>= 18*limitFramerate){
			time=0;
		}else {
			++time;
		}

	}


	protected void drawCapability(hua.huase.shanhaicontinent.capability.PlayerCapability capability, int left, int top) {
		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.shengming.name", Math.round(player.getHealth())+"/"+new BigDecimal(player.getEntityAttribute(MAX_HEALTH).getBaseValue()).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue()),left,top);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.gongjili.name", capability.getWugong()),left,top+13*1);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.baojishanghai.name", capability.getBaojishanghai()),left,top+13*2);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.baojilv.name", capability.getBaojilv()),left,top+13*3);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.zhenshang.name", capability.getZhenshang()),left,top+13*4);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.xixue.name", capability.getXixue()),left,top+13*5);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.wufang.name", capability.getWufang()),left,top+13*6);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.huifu.name", capability.getShengminghuifu()),left,top+13*7);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.mingzhong.name", capability.getMinghzong()),left,top+13*8);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.shanbi.name", capability.getShanbi()),left,top+13*9);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.jingshenli.name", capability.getJingshenli()+"/"+capability.getMaxjingshenli()),left,top+13*10);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.wuchuan.name", capability.getWuchuan()),left,top+13*11);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.kangbao.name", capability.getKangbao()),left,top+13*12);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.dengji.name", capability.getDengji()),left,top+13*13);

		drawText(net.minecraft.util.text.translation.I18n.translateToLocalFormatted("player.shanhaicontinent.jingyan.name", capability.getJingyan()+"/"+capability.getMaxjingyan()),left,top+13*14);


	}


	@Override
	protected void actionPerformed(GuiButton button) {
		if (button.id == 0) {
			//this.mc.displayGuiScreen(new GuiAchievements(this, this.mc.player.getStatFileWriter()));
		}

		if (button.id == 1) {
			this.mc.displayGuiScreen(new GuiStats(this, this.mc.player.getStatFileWriter()));
		}
	}

	@Override
	protected void keyTyped(char par1, int par2) throws IOException {
		if (par2 == MyKeyBinding.MYKEY_O.getKeyCode()) {
			this.mc.player.closeScreen();
		} else
			super.keyTyped(par1, par2);
	}


	protected void drawText(String text,int left,int top) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.5,0.5,0.5);
		fontRenderer.drawString(text,left, top, 0xff1a1104,false);
		GlStateManager.popMatrix();
	}
}
