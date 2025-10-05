package hua.huase.shanhaicontinent.shaders;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import hua.huase.shanhaicontinent.SHMainBus;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterShadersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Objects;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid= SHMainBus.MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class ShadersInt {

    @Nullable

    private static ShaderInstance shmapshadertext;


    public static ShaderInstance getShmapshaderUnlitShader()
    {
        return Objects.requireNonNull(shmapshadertext, "Attempted to call shmapshader before shaders have finished loading.");
    }

    @SubscribeEvent
    public static void registerShaders(RegisterShadersEvent event) throws IOException
    {
        event.registerShader(new TimeShader(event.getResourceProvider(), new ResourceLocation("shmapshadertext"), DefaultVertexFormat.POSITION_TEX),
                (p_172645_) -> {
            shmapshadertext = p_172645_;
        });
    }
}
