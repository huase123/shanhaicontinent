package hua.huase.shanhaicontinent.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.client.model.lighting.ForgeModelBlockRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockRenderDispatcher.class)
public abstract class MixinBlockRenderDispatcher {

    @Mutable
    @Shadow @Final private ModelBlockRenderer modelRenderer;

    @Inject(at = @At(value = "RETURN"), method = "Lnet/minecraft/client/renderer/block/BlockRenderDispatcher;<init>(Lnet/minecraft/client/renderer/block/BlockModelShaper;Lnet/minecraft/client/renderer/BlockEntityWithoutLevelRenderer;Lnet/minecraft/client/color/block/BlockColors;)V")
   public void BlockRenderDispatcher(BlockModelShaper pBlockModelShaper, BlockEntityWithoutLevelRenderer pBlockEntityRenderer, BlockColors pBlockColors, CallbackInfo ci) {
        modelRenderer = new ForgeModelBlockRenderer(pBlockColors){
            @Override
            public void tesselateBlock(BlockAndTintGetter pLevel, BakedModel pModel, BlockState pState, BlockPos pPos, PoseStack pPoseStack, VertexConsumer pConsumer, boolean pCheckSides, RandomSource pRandom, long pSeed, int pPackedOverlay, net.minecraftforge.client.model.data.ModelData modelData, net.minecraft.client.renderer.RenderType renderType) {
                boolean flag = Minecraft.useAmbientOcclusion() && pState.getLightEmission(pLevel, pPos) == 0 && pModel.useAmbientOcclusion(pState, renderType);
                Vec3 vec3 = pState.getOffset(pLevel, pPos);
                pPoseStack.translate(vec3.x, vec3.y, vec3.z);

                LocalPlayer player = Minecraft.getInstance().player;
                if(player != null && player.isShiftKeyDown()){
                    BlockPos playerPos = player.getOnPos();
                    double distance = playerPos.distSqr(pPos);
                    if(distance <=8*8 ){
                        Vec3 v = playerPos.getCenter().vectorTo(pPos.getCenter()).normalize();
                        pPoseStack.last().pose().rotateYXZ((float) v.x, (float) v.y, (float) v.z);
                        pCheckSides = false;

                    }

                }

//                float v = pRandom.nextFloat();
//                float v1 = pRandom.nextFloat();
//                float v2 = pRandom.nextFloat();
//                float v3 = pRandom.nextFloat();
//                pPoseStack.last().pose().rotate(v,v1,v2,v3);
//                pCheckSides = false;

                try {
                    this.tesselateWithAO(pLevel, pModel, pState, pPos, pPoseStack, pConsumer, pCheckSides, pRandom, pSeed, pPackedOverlay, modelData, renderType);
                    if (flag) {
                    } else {
//                        this.tesselateWithoutAO(pLevel, pModel, pState, pPos, pPoseStack, pConsumer, pCheckSides, pRandom, pSeed, pPackedOverlay, modelData, renderType);
                    }

                } catch (Throwable throwable) {
                    CrashReport crashreport = CrashReport.forThrowable(throwable, "Tesselating block model");
                    CrashReportCategory crashreportcategory = crashreport.addCategory("Block model being tesselated");
                    CrashReportCategory.populateBlockDetails(crashreportcategory, pLevel, pPos, pState);
                    crashreportcategory.setDetail("Using AO", flag);
                    throw new ReportedException(crashreport);
                }
            }

        };
    }
}
