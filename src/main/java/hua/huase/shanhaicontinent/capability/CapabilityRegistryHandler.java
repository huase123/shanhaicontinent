package hua.huase.shanhaicontinent.capability;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.api.BaublesApi;
import hua.huase.shanhaicontinent.api.IBaublesItemHandler;
import hua.huase.shanhaicontinent.capability.baubles.*;
import hua.huase.shanhaicontinent.seedpacket.PacketHandler;
import hua.huase.shanhaicontinent.seedpacket.PacketMonster;
import hua.huase.shanhaicontinent.entity.HunhuanEntity;
import hua.huase.shanhaicontinent.item.Danyao;
import hua.huase.shanhaicontinent.network.NetworkRegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;
import java.util.UUID;

import static hua.huase.shanhaicontinent.capability.baubles.BaublesCapabilities.CAPABILITY_ITEM_BAUBLE;
import static net.minecraft.entity.SharedMonsterAttributes.MAX_HEALTH;
import static net.minecraft.entity.SharedMonsterAttributes.MOVEMENT_SPEED;

@EventBusSubscriber
public class CapabilityRegistryHandler
{
    @CapabilityInject(PlayerCapability.class)
    public static Capability<PlayerCapability> PLYAER_CAPABILITY;
    @CapabilityInject(MonsterCapability.class)
    public static Capability<MonsterCapability> MONSTER_CAPABILITY;
    @CapabilityInject(ItemCapability.class)
    public static Capability<ItemCapability> ITEM_CAPABILITY;
    @CapabilityInject(DanyaoItemCapability.class)
    public static Capability<DanyaoItemCapability> DANYAOITEMCAPABILITYCAPABILITY;

    public static Random random = new Random();

    public static void register()
    {


        CapabilityManager.INSTANCE.register(IBaublesItemHandler.class,
                new BaublesCapabilities.CapabilityBaubles<>(), BaublesContainer.class);

        CapabilityManager.INSTANCE.register(IBauble.class, new BaublesCapabilities.CapabilityItemBaubleStorage(),
                () -> new BaubleItem(BaubleType.HEAD));




        CapabilityManager.INSTANCE.register(PlayerCapability.class, new Capability.IStorage<PlayerCapability>()
        {
            @Override
            public NBTBase writeNBT(Capability<PlayerCapability> cap, PlayerCapability instance, EnumFacing side)
            {
                return instance.serializeNBT();
            }

            @Override
            public void readNBT(Capability<PlayerCapability> cap, PlayerCapability instance, EnumFacing side, NBTBase nbt)
            {
                if (nbt instanceof NBTTagCompound)
                {
                    instance.deserializeNBT((NBTTagCompound) nbt);
                }
            }
        }, PlayerCapability::new);


        CapabilityManager.INSTANCE.register(MonsterCapability.class, new Capability.IStorage<MonsterCapability>()
        {
            @Override
            public NBTBase writeNBT(Capability<MonsterCapability> cap, MonsterCapability instance, EnumFacing side)
            {
                return instance.serializeNBT();
            }

            @Override
            public void readNBT(Capability<MonsterCapability> cap, MonsterCapability instance, EnumFacing side, NBTBase nbt)
            {
                if (nbt instanceof NBTTagCompound)
                {
                    instance.deserializeNBT((NBTTagCompound) nbt);
                }
            }
        }, MonsterCapability::new);

        CapabilityManager.INSTANCE.register(ItemCapability.class, new Capability.IStorage<ItemCapability>()
        {
            @Override
            public NBTBase writeNBT(Capability<ItemCapability> cap, ItemCapability instance, EnumFacing side)
            {
                return instance.serializeNBT();
            }

            @Override
            public void readNBT(Capability<ItemCapability> cap, ItemCapability instance, EnumFacing side, NBTBase nbt)
            {
                if (nbt instanceof NBTTagCompound)
                {
                    instance.deserializeNBT((NBTTagCompound) nbt);
                }
            }
        }, ItemCapability::new);

        CapabilityManager.INSTANCE.register(DanyaoItemCapability.class, new Capability.IStorage<DanyaoItemCapability>()
        {
            @Override
            public NBTBase writeNBT(Capability<DanyaoItemCapability> cap, DanyaoItemCapability instance, EnumFacing side)
            {
                return instance.serializeNBT();
            }

            @Override
            public void readNBT(Capability<DanyaoItemCapability> cap, DanyaoItemCapability instance, EnumFacing side, NBTBase nbt)
            {
                if (nbt instanceof NBTTagCompound)
                {
                    instance.deserializeNBT((NBTTagCompound) nbt);
                }
            }
        }, DanyaoItemCapability::new);


    }

//    实体增加Capabilities事件
    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent event)
    {

        if (event.getObject() instanceof EntityPlayer)
        {

            PlayerCapabilityProvider playerCapabilityProvider = new PlayerCapabilityProvider();
            event.addCapability(new ResourceLocation(ExampleMod.MODID + ":shanhaicontinent_Capability"), playerCapabilityProvider);



            event.addCapability(new ResourceLocation(ExampleMod.MODID,"container"), new BaublesContainerProvider(new BaublesContainer()));


       }
        if (event.getObject() instanceof IMob&&event.getObject()instanceof Entity){
            Entity entity = (Entity) event.getObject();


            ((EntityLivingBase) entity).getAttributeMap().registerAttribute(NIANLING);
            if((entity).hasCapability(CapabilityRegistryHandler.MONSTER_CAPABILITY,null)||event.getObject()==null)
                return;

            MonsterCapabilityProvider monsterCapabilityProvider = new MonsterCapabilityProvider(false);
            switch (entity.world.provider.getDimension()) {
                case -1:
                    if(random.nextInt(3)==0) monsterCapabilityProvider = new MonsterCapabilityProvider(entity.world.provider.getDimension(),random);
                    break;
                case 0:
                    if(random.nextInt(3)==0) monsterCapabilityProvider = new MonsterCapabilityProvider(entity.world.provider.getDimension(),random);
                    break;
                case 1:
                    if(random.nextInt(3)==0) monsterCapabilityProvider = new MonsterCapabilityProvider(entity.world.provider.getDimension(),random);
                    break;

                default:

            }

            event.addCapability(new ResourceLocation(ExampleMod.MODID + ":shanhaicontinent_Capability"), monsterCapabilityProvider);


        }
        if (event.getObject() instanceof HunhuanEntity){
            if(((HunhuanEntity) event.getObject()).getCapability(MONSTER_CAPABILITY,null)==null){
                MonsterCapabilityProvider monsterCapabilityProvider = new MonsterCapabilityProvider(false);
                event.addCapability(new ResourceLocation(ExampleMod.MODID + ":shanhaicontinent_Capability"), monsterCapabilityProvider);
            }

        }

    }

    @SubscribeEvent
    public static void itemCapabilityAttach(AttachCapabilitiesEvent<ItemStack> event)
    {
        ItemStack stack = event.getObject();
        if (!(stack.isEmpty() || !(stack.getItem() instanceof IBauble) || stack.hasCapability(CAPABILITY_ITEM_BAUBLE, null)
                || event.getCapabilities().values().stream().anyMatch(c -> c.hasCapability(CAPABILITY_ITEM_BAUBLE, null)))) {

            event.addCapability(new ResourceLocation(ExampleMod.MODID + "itme_Capability"), new ICapabilityProvider() {

                @Override
                public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
                    return capability == CAPABILITY_ITEM_BAUBLE;
                }

                @Nullable
                @Override
                public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
                    return capability == CAPABILITY_ITEM_BAUBLE
                            ? CAPABILITY_ITEM_BAUBLE.cast((IBauble) stack.getItem())
                            : null;
                }
            });
        }

        if (!(stack.isEmpty() || !(stack.getItem() instanceof Danyao) || stack.hasCapability(DANYAOITEMCAPABILITYCAPABILITY, null)
                || event.getCapabilities().values().stream().anyMatch(c -> c.hasCapability(DANYAOITEMCAPABILITYCAPABILITY, null)))) {

            event.addCapability(new ResourceLocation(ExampleMod.MODID + "Danyao_itme_Capability"), new DanyaoItemCapabilityProvider());
        }




    }

    private static final UUID MAX_HEALTHID = UUID.fromString("1707f7535-349a-4613-b33f-4a5eaf4d0ed7");

    public static final IAttribute NIANLING = (new RangedAttribute((IAttribute)null, "generic.nianling", 0, -1, Double.MAX_VALUE)).setDescription("nianling").setShouldWatch(true);


    //实体加入世界事件
    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinWorldEvent event){
        if(event==null)return;
        Entity entity = event.getEntity();

        if(entity==null)return;

        if (!entity.world.isRemote )
        {




            if (entity instanceof EntityPlayer) {


                NetworkRegistryHandler.PlayerListen.sendClientCustomPacket((EntityPlayer) entity);

            }else if (entity instanceof IMob && entity instanceof EntityLivingBase) {

                MonsterCapability monsterCapability = entity.getCapability(MONSTER_CAPABILITY, null);
                if(monsterCapability==null)return;



                int nianxian = monsterCapability.getNianxian();
                if(nianxian<=0) return;


                ((EntityLivingBase)entity).getEntityAttribute(NIANLING)
                        .setBaseValue(monsterCapability.getNianxian());


                ((EntityLivingBase)entity).getEntityAttribute(MAX_HEALTH)
                        .setBaseValue(monsterCapability.getMaxshengming());
                ((EntityLivingBase)entity).setHealth(monsterCapability.getMaxshengming());


                if(nianxian>=1000000){
                    ((EntityLivingBase)entity).getEntityAttribute(MOVEMENT_SPEED).setBaseValue(0.6D);
                }else if(nianxian>=100000){
                    ((EntityLivingBase)entity).getEntityAttribute(MOVEMENT_SPEED).setBaseValue(0.5D);
                }else if(nianxian>=10000){
                    ((EntityLivingBase)entity).getEntityAttribute(MOVEMENT_SPEED).setBaseValue(0.45D);
                }else if(nianxian>=1000){
                    ((EntityLivingBase)entity).getEntityAttribute(MOVEMENT_SPEED).setBaseValue(0.4D);
                }else if(nianxian>=100){
                    ((EntityLivingBase)entity).getEntityAttribute(MOVEMENT_SPEED).setBaseValue(0.35D);
                }else if(nianxian>=1){
                    ((EntityLivingBase)entity).getEntityAttribute(MOVEMENT_SPEED).setBaseValue(0.3D);
                }





                entity.setCustomNameTag("");
                if(nianxian>=1000000){
                    entity.setCustomNameTag(I18n.translateToLocalFormatted(entity.getDisplayName().getFormattedText())+"---------------"+I18n.translateToLocalFormatted("0nianxian")+ monsterCapability.getNianxian());
                }else if(nianxian>=100000){
                    entity.setCustomNameTag(I18n.translateToLocalFormatted(entity.getDisplayName().getFormattedText())+"---------------"+I18n.translateToLocalFormatted("1nianxian")+ monsterCapability.getNianxian());
               }else if(nianxian>=10000){
                    entity.setCustomNameTag(I18n.translateToLocalFormatted(entity.getDisplayName().getFormattedText())+"---------------"+I18n.translateToLocalFormatted("2nianxian")+ monsterCapability.getNianxian());
                }else if(nianxian>=1000){
                    entity.setCustomNameTag(I18n.translateToLocalFormatted(entity.getDisplayName().getFormattedText())+"---------------"+I18n.translateToLocalFormatted("3nianxian")+monsterCapability.getNianxian());
                }else if(nianxian>=100){
                    entity.setCustomNameTag(I18n.translateToLocalFormatted(entity.getDisplayName().getFormattedText())+"---------------"+I18n.translateToLocalFormatted("4nianxian")+ monsterCapability.getNianxian());
                }else if(nianxian>=1){
                    entity.setCustomNameTag(I18n.translateToLocalFormatted(entity.getDisplayName().getFormattedText())+"---------------"+I18n.translateToLocalFormatted("5nianxian")+ monsterCapability.getNianxian());
                }





            }else if (entity instanceof HunhuanEntity) {
                MonsterCapability monsterCapability = entity.getCapability(MONSTER_CAPABILITY, null);
                PacketHandler.INSTANCE.sendToAllAround(new PacketMonster(monsterCapability,entity),new NetworkRegistry.TargetPoint(entity.dimension,entity.posX,entity.posY,entity.posZ,60));

            }
        }
//
        if (entity.world.isRemote ){

            if ((entity instanceof IMob && entity instanceof EntityLivingBase)||entity instanceof HunhuanEntity) {

                MonsterCapability monsterCapability1 = ExampleMod.monsterHashMapCapability.get(entity.getEntityId());
                if(monsterCapability1!=null){

                    MonsterCapability monsterCapability = entity.getCapability(MONSTER_CAPABILITY, null);
                    monsterCapability.deserializeNBT(monsterCapability1.serializeNBT());

//                    ExampleMod.monsterHashMap.remove(entity.getEntityId());

                }

            }

        }


    }




//    玩家生成事件
    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event)
    {

        PlayerCapability newPlayerCapobility = event.getEntityPlayer().getCapability(PLYAER_CAPABILITY, null);
        PlayerCapability oldPlayerCapobility = event.getOriginal().getCapability(PLYAER_CAPABILITY, null);

        newPlayerCapobility.deserializeNBT(oldPlayerCapobility.serializeNBT());
        NetworkRegistryHandler.PlayerListen.sendClientCustomPacket(event.getEntityPlayer());

//        PacketHandler.INSTANCE.sendToAllTracking(new PacketPlayerCapability(newPlayerCapobility,event.getEntityPlayer()),new NetworkRegistry.TargetPoint(event.getEntityPlayer().dimension,event.getEntityPlayer().posX,event.getEntityPlayer().posY,event.getEntityPlayer().posZ,60));

        BaublesContainer bco = (BaublesContainer) BaublesApi.getBaublesHandler(event.getOriginal());
            NBTTagCompound nbt = bco.serializeNBT();
            BaublesContainer bcn = (BaublesContainer) BaublesApi.getBaublesHandler(event.getEntityPlayer());
            bcn.deserializeNBT(nbt);


    }


    //玩家加入游戏事件
    @SubscribeEvent
    public static void onPlayerLogin(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        NetworkRegistryHandler.PlayerListen.sendClientCustomPacket(player);


        player.sendMessage(new TextComponentTranslation("join world",player.getName()));

    }


}
