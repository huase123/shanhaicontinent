package hua.huase.shanhaicontinent.potion.potionjineng.jingubang;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import hua.huase.shanhaicontinent.ExampleMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

import java.util.UUID;

import static hua.huase.shanhaicontinent.potion.PotionRegistryHandler.POTION_LIST;

public class PotionWuqijnJLCY extends Potion
{
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ExampleMod.MODID + ":textures/potion/wuqijnjlcy.png");

    public PotionWuqijnJLCY()
    {
        super(false, 0xffffff);
        this.setRegistryName(ExampleMod.MODID + ":wuqijnjlcy");
        this.setPotionName("effect." + ExampleMod.MODID + ".wuqijnjlcy");

        POTION_LIST.add(this);
    }



    public Multimap<String, AttributeModifier> Multimap(){

        Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();
        multimap.clear();
        multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(UUID.fromString("7107DE5E-7CE8-4030-940E-514C1F161118"), "Weapon modifier", -0.5, 2));

        return multimap;
    }


    public void applyAttributesModifiersToEntity(EntityLivingBase entityLivingBaseIn, AbstractAttributeMap attributeMapIn, int amplifier)
    {

        PotionEffect potioneffect = entityLivingBaseIn.getActivePotionMap().get(this);
        if(potioneffect==null){




        }
        attributeMapIn.applyAttributeModifiers(this.Multimap());

        entityLivingBaseIn.setAbsorptionAmount(entityLivingBaseIn.getAbsorptionAmount() + (float)(4 * (amplifier + 1)));
        super.applyAttributesModifiersToEntity(entityLivingBaseIn, attributeMapIn, amplifier);
    }

    public void removeAttributesModifiersFromEntity(EntityLivingBase entityLivingBaseIn, AbstractAttributeMap attributeMapIn, int amplifier)
    {

        attributeMapIn.removeAttributeModifiers(this.Multimap());

        entityLivingBaseIn.setAbsorptionAmount(entityLivingBaseIn.getAbsorptionAmount() - (float)(4 * (amplifier + 1)));
        super.removeAttributesModifiersFromEntity(entityLivingBaseIn, attributeMapIn, amplifier);
    }



    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier)
    {

        if (entityLivingBaseIn.getHealth() > 1.0F)
        {
//            entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, 1.0F);
//            entityLivingBaseIn.hurtResistantTime=0;
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
