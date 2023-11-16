package hua.huase.shanhaicontinent.potion.potionjineng;

import hua.huase.shanhaicontinent.ExampleMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;

import static hua.huase.shanhaicontinent.potion.PotionRegistryHandler.POTION_LIST;

public class PotionChangewugong extends Potion
{
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ExampleMod.MODID + ":textures/potion/changewugong.png");

    public PotionChangewugong()
    {
        super(false, 0x00ff00);
        this.setRegistryName(ExampleMod.MODID + ":changewugong");
        this.setPotionName("effect." + ExampleMod.MODID + ".changewugong");

        POTION_LIST.add(this);
    }



    public void applyAttributesModifiersToEntity(EntityLivingBase entityLivingBaseIn, AbstractAttributeMap attributeMapIn, int amplifier)
    {

        PotionEffect potioneffect = entityLivingBaseIn.getActivePotionMap().get(this);
        if(potioneffect==null){

        }

        entityLivingBaseIn.setAbsorptionAmount(entityLivingBaseIn.getAbsorptionAmount() + (float)(4 * (amplifier + 1)));
        super.applyAttributesModifiersToEntity(entityLivingBaseIn, attributeMapIn, amplifier);
    }

    public void removeAttributesModifiersFromEntity(EntityLivingBase entityLivingBaseIn, AbstractAttributeMap attributeMapIn, int amplifier)
    {
        entityLivingBaseIn.setAbsorptionAmount(entityLivingBaseIn.getAbsorptionAmount() - (float)(4 * (amplifier + 1)));
        super.removeAttributesModifiersFromEntity(entityLivingBaseIn, attributeMapIn, amplifier);
    }



    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier)
    {

        if (entityLivingBaseIn.getHealth() > 1.0F)
        {
            entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, 1.0F);
        }
    }

    public boolean isReady(int duration, int amplifier)
    {
        return true;
    }




    //打开背包时效果
    @Override
    public void renderInventoryEffect(int x, int y, PotionEffect e, Minecraft mc)
    {
        int duration = e.getDuration();
        int fIndex = (duration % 16) / 2;
        mc.getTextureManager().bindTexture(TEXTURE);
        mc.currentScreen.drawTexturedModalRect(x + 6, y + 7, fIndex * 18, 0, 18, 18);
    }


//    HUD界面
    @Override
    public void renderHUDEffect(int x, int y, PotionEffect e, Minecraft mc, float alpha)
    {
        int duration = e.getDuration();
        int fIndex = (duration % 16) / 2;
        mc.getTextureManager().bindTexture(TEXTURE);
        mc.ingameGUI.drawTexturedModalRect(x + 3, y + 3, fIndex * 18, 0, 18, 18);
    }
}
