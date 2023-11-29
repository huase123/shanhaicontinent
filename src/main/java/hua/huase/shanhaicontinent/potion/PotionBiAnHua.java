package hua.huase.shanhaicontinent.potion;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

import static hua.huase.shanhaicontinent.potion.PotionRegistryHandler.POTION_LIST;

public class PotionBiAnHua extends Potion
{
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ExampleMod.MODID + ":textures/potion/bianhua.png");

    public PotionBiAnHua()
    {
        super(false, 0x00ff00);
        this.setRegistryName(ExampleMod.MODID + ":bianhua");
        this.setPotionName("effect." + ExampleMod.MODID + ".bianhua");

        POTION_LIST.add(this);
    }



    public Multimap<String, AttributeModifier> Multimap(){

        Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();
        multimap.clear();
//        multimap.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(UUID.fromString("7107DE5E-7CE8-4030-940E-514C1F161117"), "Weapon modifier", 0.10, 2));

        return multimap;
    }



    public void applyAttributesModifiersToEntity(EntityLivingBase entityLivingBaseIn, AbstractAttributeMap attributeMapIn, int amplifier)
    {

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

        if (!entityLivingBaseIn.isDead)
        {

            PlayerCapability capability = entityLivingBaseIn.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);

            switch (entityLivingBaseIn.getEntityWorld().provider.getDimension()) {
                case -1:
//                地狱
                    if(capability.getJingshenli()<capability.getMaxjingshenli())capability.addJingshenli(capability.getMaxjingshenli()/100f);
                    if(entityLivingBaseIn.getHealth()>0) entityLivingBaseIn.setHealth(entityLivingBaseIn.getHealth()-capability.getDengji());
                    break;
                case 0:
                    if(entityLivingBaseIn.getHealth()<entityLivingBaseIn.getMaxHealth()) entityLivingBaseIn.setHealth(entityLivingBaseIn.getHealth()+capability.getDengji());
                    break;
//                主世界
                case 1:

//                末地
            }
        }
    }




    public boolean isReady(int duration, int amplifier)
    {
        if(duration%20==0&&amplifier>=0){

            return true;
        }
        return false;
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
