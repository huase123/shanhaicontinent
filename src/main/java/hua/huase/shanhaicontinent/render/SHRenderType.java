package hua.huase.shanhaicontinent.render;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;

import static hua.huase.shanhaicontinent.SHMainBus.HUNHUAN;

/**
 * - @description:SHRenderType类
 * - @author: huase。
 * - @date: 2025/10/7 8:48
 */
public class SHRenderType {

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
    public static final RenderType render_hunhuan = RenderType.create("render_hunhuan", DefaultVertexFormat.POSITION_COLOR_TEX, VertexFormat.Mode.QUADS, 256, false, true,
            RenderType.CompositeState.builder()
                    .setShaderState(new RenderStateShard.ShaderStateShard(GameRenderer::getPositionColorTexShader))
                    .setTextureState(new RenderStateShard.TextureStateShard(HUNHUAN, false, false))

                    .createCompositeState(false)
    );
}
