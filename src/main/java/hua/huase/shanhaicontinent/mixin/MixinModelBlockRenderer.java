package hua.huase.shanhaicontinent.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelBlockRenderer.class)
public abstract class MixinModelBlockRenderer {



    @Inject(method = "tesselateBlock(Lnet/minecraft/world/level/BlockAndTintGetter;Lnet/minecraft/client/resources/model/BakedModel;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;ZLnet/minecraft/util/RandomSource;JILnet/minecraftforge/client/model/data/ModelData;Lnet/minecraft/client/renderer/RenderType;)V",at = @At(
            value ="INVOKE",
            target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(DDD)V", shift = At.Shift.AFTER
    ))
    public void tesselateBlock(BlockAndTintGetter pLevel, BakedModel pModel, BlockState pState, BlockPos pPos, PoseStack pPoseStack, VertexConsumer pConsumer, boolean pCheckSides, RandomSource pRandom, long pSeed, int pPackedOverlay, net.minecraftforge.client.model.data.ModelData modelData, net.minecraft.client.renderer.RenderType renderType ,CallbackInfo ci) {
//        pPoseStack.scale(0.8f,0.8f,0.8f);
        float v = pRandom.nextFloat();
        float v1 = pRandom.nextFloat();
        float v2 = pRandom.nextFloat();
        float v3 = pRandom.nextFloat();
        pPoseStack.last().pose().rotate(v,v1,v2,v3);
        pCheckSides = false;
    }

}
