package hua.huase.shanhaicontinent.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import hua.huase.shanhaicontinent.entity.protectionbox.SHRenderTypes;
import hua.huase.shanhaicontinent.shaders.ShadersInt;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.ForgeRenderTypes;

import java.util.function.Function;

import static hua.huase.shanhaicontinent.SHMainBus.HUNHUAN;


/**
 * - @description:SHRenderType类
 * - @author: huase。
 * - @date: 2025/10/7 8:48
 */
public class SHRenderType extends RenderType  {

    public SHRenderType(String name, VertexFormat vertexFormat, VertexFormat.Mode mode, int bufferSize, boolean crumbling, boolean sort, Runnable setup, Runnable clear) {
        super(name, vertexFormat, mode, bufferSize, crumbling, sort, setup, clear);
    }
    /**
     * TODO 功能描述：意外收获，这个渲染类型获取到的纹理为真实的屏幕呈现的像素，可用于空间破碎效果，自定义设置的纹理不生效
     * @author :huase
     * @date 2025/10/7 7:24
     */
    public static final RenderType render_blitShader = RenderType.create("render_blitShader", DefaultVertexFormat.POSITION_TEX_COLOR, VertexFormat.Mode.QUADS, 256, false, true,
            RenderType.CompositeState.builder()
                    .setShaderState(new RenderStateShard.ShaderStateShard(() -> Minecraft.getInstance().gameRenderer.blitShader))
                    .setTextureState(new RenderStateShard.TextureStateShard(HUNHUAN, false, false))

                    .createCompositeState(false)
    );
/**
 * TODO 功能描述：效果不理想，暂不使用
 * @author :huase
 * @date 2025/10/9 0:17
 */
    public static final RenderType render_hunhuan = RenderType.create("render_hunhuan", DefaultVertexFormat.POSITION_COLOR_TEX, VertexFormat.Mode.QUADS, 256, false, true,
            RenderType.CompositeState.builder()
                    .setShaderState(new RenderStateShard.ShaderStateShard(ShadersInt::gethunhuanshader))
                    .setTexturingState(new SHRenderTypes.ProtectionBoxTexturingStateShard())
                    .setTransparencyState(TRANSLUCENT_TRANSPARENCY).setCullState(NO_CULL)
                    .setLightmapState(LIGHTMAP).setOverlayState(OVERLAY)
                    .createCompositeState(false)
    );


    public static Function<ResourceLocation, RenderType> render_Material = Util.memoize(SHRenderType::getText);
    private static RenderType getText(ResourceLocation locationIn) {
        RenderType.CompositeState rendertype$state = RenderType.CompositeState.builder()
//                着色器
                .setShaderState(RENDERTYPE_OUTLINE_SHADER)
//                材质
                .setTextureState(new RenderStateShard.TextureStateShard(locationIn, false, false))
//                混合模式
                .setTransparencyState(ignore_material_blending_fragments)
//                光照贴图
//                .setLightmapState(LIGHTMAP)
                .createCompositeState(false);
        return create("forge_text", DefaultVertexFormat.POSITION_COLOR_TEX, VertexFormat.Mode.QUADS, 256, false, true, rendertype$state);
    }

    protected static final RenderStateShard.TransparencyStateShard ignore_material_blending_fragments = new RenderStateShard.TransparencyStateShard("lightning_transparency",
        () -> {
            RenderSystem.setShaderColor(1, 1f, 1,0.8f);
            RenderSystem.enableBlend();
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

        },
        () -> {

            RenderSystem.setShaderColor(1, 1f, 1,1f);
            RenderSystem.disableBlend();
            RenderSystem.defaultBlendFunc();
        }
    );
    public static RenderType render_Material(ResourceLocation locationIn)
    {
        return render_Material.apply(locationIn);
    }
}
