package hua.huase.shanhaicontinent.shaders;

import com.mojang.blaze3d.shaders.Uniform;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceProvider;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class TimeShader extends ShaderInstance {
    public final @Nullable Uniform brightnessRot = this.getUniform("Rot");
    public final @Nullable Uniform brightnessiTime = this.getUniform("iTime");

    public TimeShader(ResourceProvider pResourceProvider, ResourceLocation shaderLocation, VertexFormat pVertexFormat) throws IOException {
        super(pResourceProvider, shaderLocation, pVertexFormat);
    }

    public void setBrightnessTime(float Time) {
        if (this.brightnessiTime.getFloatBuffer().get(0) != Time) {
            this.brightnessiTime.set(Time);
        }

    }

    public void addBrightness(float brightness) {
        this.brightnessRot.set(this.brightnessRot.getFloatBuffer().get(0)+brightness);
    }

    public void setBrightnessRot(float xRot, float yRot, float yRot1) {

        this.brightnessRot.set(xRot,yRot,yRot1);
    }

//    public void setWithLight(boolean withLight) {
//        int withLightInt = withLight ? 1 : 0;
//        if (this.withLight.getIntBuffer().get(0) != withLightInt) {
//            this.withLight.set(withLightInt);
//        }
//
//    }
}
