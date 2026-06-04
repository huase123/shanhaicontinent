package hua.huase.shanhaicontinent.datagen;

import hua.huase.shanhaicontinent.particles.ParticleTypesInti;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ParticleDescriptionProvider;

/**
 * - @description:ModParticleDescriptionProvider类
 */
public class ModParticleDescriptionProvider extends ParticleDescriptionProvider {
    /**
     * Creates an instance of the data provider.
     *
     * @param output     the expected root directory the data generator outputs to
     * @param fileHelper the helper used to validate a texture's existence
     */
    protected ModParticleDescriptionProvider(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, fileHelper);
    }

    @Override
    protected void addDescriptions() {
        // Single sprite
        // this.sprite(ParticleTypes.DRIPPING_LAVA, new ResourceLocation("drip_hang"));
        // Multiple sprites
         this.spriteSet(ParticleTypesInti.potianshengunhunji2.get(), new ResourceLocation("generic"), 8, true);
    }
}
