package hua.huase.shanhaicontinent.client.renderer.jiuneng;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SideOnly(Side.CLIENT)
public class RenderJiNengItme extends RenderEntity {

    private final RenderItem itemRenderer;
    private final Random random = new Random();
    private final ItemStack item ;
    private static final ResourceLocation POLAR_BEAR_TEXTURE = new ResourceLocation("shanhaicontinent:textures/picture/particletext1.png");
    private static final ResourceLocation POLAR_ITEM_TEXTURE = new ResourceLocation("shanhaicontinent:textures/items/textsword.png");

    public static Map<Integer, Integer> timemap=new HashMap();
    public RenderJiNengItme(RenderManager renderManagerIn,Item item,RenderItem itemRenderer)
    {
        super(renderManagerIn);
        this.itemRenderer = itemRenderer;
        this.shadowSize = 0.15F;
        this.shadowOpaque = 0.75F;
        this.item=new ItemStack(item,1);
    }
    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {

        if(timemap.get(entity.getEntityId()) == null) timemap.put(entity.getEntityId(),0);
        int time = timemap.get(entity.getEntityId()).intValue();
        int limitFramerate = Minecraft.getMinecraft().gameSettings.limitFramerate;
        float ticks = (float) ((float)time/(float)limitFramerate);



        GlStateManager.pushMatrix();

        GlStateManager.translate((float)x, (float)y+0.15+0.1f*MathHelper.sin(ticks/4.5f*3.14159265359f), (float)z);
        GlStateManager.rotate(ticks*40, 0.0F, 1.0F, 0.0F);
        IBakedModel ibakedmodel = Minecraft.getMinecraft().getRenderItem().getItemModelWithOverrides(item, entity.world, (EntityLivingBase)null);
        IBakedModel transformedModel = net.minecraftforge.client.ForgeHooksClient.handleCameraTransforms(ibakedmodel, ItemCameraTransforms.TransformType.GROUND, false);
        Minecraft.getMinecraft().getRenderItem().renderItem(item, transformedModel);
        GlStateManager.popMatrix();

        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y+0.2, (float)z);
        GlStateManager.rotate(90, 1, 0, 0);
        GlStateManager.rotate(ticks*20f, 0, 0, 1);
//        GlStateManager.scale(1f, 1f, 1);
        float v = ticks/3;

        Minecraft.getMinecraft().getTextureManager().bindTexture(POLAR_BEAR_TEXTURE);
        Tessellator tessellator = Tessellator.getInstance(); //获取Tessellator的一般方式
        BufferBuilder buffer = tessellator.getBuffer();//获取记录顶点信息的"数组"

        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX); //指定数组的组织方式(位置 + UV方式), 以及要画的图像的顶点数(矩形四个顶点)
//        buffer.begin(7, DefaultVertexFormats.POSITION_TEX); //指定数组的组织方式(位置 + UV方式), 以及要画的图像的顶点数(矩形四个顶点)

        buffer.pos(  -0.5,   -0.5, 0).tex(0, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(  -0.5, 0.5, 0).tex(0, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(0.5, 0.5, 0).tex(1, 1).endVertex(); //提供矩形的四个顶点, 并绑定UV
        buffer.pos(0.5,   -0.5, 0).tex(1, 0).endVertex(); //提供矩形的四个顶点, 并绑定UV


        tessellator.draw(); //将数组和渲染方式提交到GPU

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.popMatrix();






//        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        timemap.put(entity.getEntityId(),time>= 9*limitFramerate ? 0:++time);


    }



    protected ResourceLocation getEntityTexture(EntityItem entity)
    {
        return POLAR_ITEM_TEXTURE;
    }
}
