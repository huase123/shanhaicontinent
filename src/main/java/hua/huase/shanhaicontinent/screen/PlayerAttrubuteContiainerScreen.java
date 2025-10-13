package hua.huase.shanhaicontinent.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import hua.huase.shanhaicontinent.SHMainBus;
import hua.huase.shanhaicontinent.capability.monsterattribute.MonsterAttributeCapability;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttributeCapabilityProvider;
import hua.huase.shanhaicontinent.capability.playerattribute.PlayerAttrubuteAPI;
import hua.huase.shanhaicontinent.capabilitys.RegisterCapabilitys;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import org.joml.Matrix4f;

import java.util.LinkedList;
import java.util.List;

import static hua.huase.shanhaicontinent.init.KeyMappingInit.KAIGUAN_MAPPING;
import static net.minecraft.client.gui.screens.inventory.InventoryScreen.renderEntityInInventoryFollowsMouse;

public class PlayerAttrubuteContiainerScreen extends AbstractContainerScreen<PlayerAttrubuteContainerMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(SHMainBus.MOD_ID, "textures/gui/playercapabilityx.png");

    private float xMouse;
    private float yMouse;


    List<MutableComponent> mutableComponents = new LinkedList<>();
    public PlayerAttrubuteContiainerScreen(PlayerAttrubuteContainerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        this.imageWidth = 384;
        this.imageHeight = 216;
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }


    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
        this.xMouse = (float)mouseX;
        this.yMouse = (float)mouseY;
    }
    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
//渲染背景
        guiGraphics.blit(TEXTURE, x, y,  0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

        Player player = this.menu.player;
//        渲染属性
        renderPlayerAttibute(guiGraphics,player,x,y);

//        渲染魂环
        renderHunhuan(guiGraphics,player,x,y,pPartialTick);

        int i = 51+140;
        int j = 110;

        renderEntityInInventoryFollowsMouse(guiGraphics, x + i, y + j, 30, (float)(x + i) - this.xMouse, (float)(y + j ) - this.yMouse, this.minecraft.player);

    }


    private static final ResourceLocation HUNHUAN = new ResourceLocation(SHMainBus.MOD_ID, "textures/gui/hunhuan.png");
    private void renderHunhuan(GuiGraphics guiGraphics, Player player, int x, int y, float pPartialTick){




        player.getCapability(PlayerAttributeCapabilityProvider.CAPABILITY).ifPresent(capability -> {
            if(capability.getWuhunListsname().size()-1<capability.getHunhuankuaiguan()||capability.getHunhuankuaiguan()<0)return;
            String s = capability.getWuhunListsname().get(capability.getHunhuankuaiguan());
            int i =0;
            for (MonsterAttributeCapability monsterAttributeCapability : capability.getMonsterCapabilityLists().get(s)) {
                PoseStack pose = guiGraphics.pose();
                pose.pushPose();
                Matrix4f matrix4f = pose.last().pose();
                matrix4f.translate(300+50*(i%2)+x,30+(i/2)*40+y,0);
                matrix4f.scale(1.0f,0.7f,1.0f);
                matrix4f.rotate((float) (0.02*(player.level().getGameTime()+pPartialTick)),0f,0f,1f);
                renderGUIHunhuanAttribute(monsterAttributeCapability.getNianxian(),player.level().getGameTime()+pPartialTick);
                guiGraphics.blit(HUNHUAN, -30, -30,  0, 0, 60, 60, 60, 60);

                pose.popPose();
                i++;
            }
            i =0;

            for (MonsterAttributeCapability monsterAttributeCapability : capability.getMonsterCapabilityLists().get(s)) {
                PoseStack pose = guiGraphics.pose();
                pose.pushPose();
                Matrix4f matrix4f = pose.last().pose();
                matrix4f.translate(300+50*(i%2)+x,28+(i/2)*40+y,0);
                matrix4f.scale(0.8f,0.8f,1.0f);
                MutableComponent c = Component.translatable(monsterAttributeCapability.getNianxian()+"年");
                int width1 = font.width(c);
                font.drawInBatch(c, 0 -width1/2, 0+0f, 0xffff00, false, matrix4f, guiGraphics.bufferSource(), Font.DisplayMode.SEE_THROUGH, 0, 999999);

                pose.popPose();
                i++;
            }

            RenderSystem.setShaderColor(1, 1f, 1f,1f);
        });


    }

    private void renderGUIHunhuanAttribute(int nianxian, float partialTick) {

        if(nianxian>=1000000){
            RenderSystem.setShaderColor((float) Math.sin(partialTick*0.1f)*0.25f+0.75f,0,0,0.8f);
        }else if(nianxian>=100000){
            RenderSystem.setShaderColor(1.0f, 0, 0,0.8f);

        }else if(nianxian>=10000){
            RenderSystem.setShaderColor(0, 0f, 0,0.8f);
        }else if(nianxian>=1000){

            RenderSystem.setShaderColor(1.0f, 0f, 0.5f,0.8f);
        }else if(nianxian>=100){

            RenderSystem.setShaderColor(1.0f, 1.0f, 0,0.8f);
        }else if(nianxian>=1){
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f,0.8f);
        }
    }





    private void renderPlayerAttibute(GuiGraphics guiGraphics,Player player,int x,int y ){
        mutableComponents.clear();
        player.getCapability(RegisterCapabilitys.PLAYERCAPABILITY).ifPresent(c->{
            mutableComponents.add(Component.translatable("生命", (int)player.getHealth(),(int)player.getMaxHealth()));
            mutableComponents.add(Component.translatable("精神力", (int)c.getJingshenli(player),(int)c.getMaxjingshenli(player)));
            mutableComponents.add(Component.translatable("物攻", (int) c.getWugong(player)));
            mutableComponents.add(Component.translatable("物防", (int)c.getWufang(player)));
            mutableComponents.add(Component.translatable("爆伤", (int)c.getBaojishanghai(player)));
            mutableComponents.add(Component.translatable("爆率", (int)c.getBaojilv(player)));
            mutableComponents.add(Component.translatable("真伤", (int)c.getZhenshang(player)));
            mutableComponents.add(Component.translatable("物穿", (int)c.getWuchuan(player)));
            mutableComponents.add(Component.translatable("抗暴", (int)c.getKangbao(player)));
            mutableComponents.add(Component.translatable("吸血", (int)c.getXixue(player)));
            mutableComponents.add(Component.translatable("回复", (int)c.getShengminghuifu(player)));
            mutableComponents.add(Component.translatable("命中", (int)c.getMingzhong(player)));
            mutableComponents.add(Component.translatable("闪避", (int)c.getShanbi(player)));
            mutableComponents.add(Component.translatable("经验", (int)c.getJingyan(player),(int)c.getMaxjingyan(player)));
            mutableComponents.add(Component.translatable("等级", (int)c.getDengji(player)));
//            mutableComponents.add(Component.translatable("转生", (int)c.getZhuansheng(player)));
        });

//        renderListText(guiGraphics,mutableComponents, x+60, y+36);
        renderListText(guiGraphics,mutableComponents, x, y);

//        pose.scale(1/0.8f,1/0.8f,1.0f);
//        pose1.popPose();
    }


    private void renderListText(GuiGraphics guiGraphics, List<MutableComponent> list, int x, int y){

        PoseStack poseStack = guiGraphics.pose();
//        Matrix4f matrix4f = poseStack.last().pose();


        float index = 0;
        for (MutableComponent mutableComponent : list) {
            poseStack.pushPose();

            Matrix4f matrix4f = poseStack.last().pose();
            matrix4f.translate(x+24,y+11 +index,0);
            matrix4f.scale(0.8f,0.8f,1.0f);

            font.drawInBatch(mutableComponent, 0, 0, 0, false, matrix4f, guiGraphics.bufferSource(), Font.DisplayMode.SEE_THROUGH, 100, 000000);
//            var font = net.minecraftforge.client.extensions.common.IClientItemExtensions.of(p_281330_).getFont(p_281330_, net.minecraftforge.client.extensions.common.IClientItemExtensions.FontContext.ITEM_COUNT);
//            guiGraphics.drawString(this.font,mutableComponent, x + 0, y+index,4210752, false);

            index += 12.8f;
            poseStack.popPose();
        }


    }

    public boolean keyPressed(int key, int i, int j) {

        return super.keyPressed(key,i,j);
    }

}
