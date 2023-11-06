package hua.huase.shanhaicontinent.entity;

import hua.huase.shanhaicontinent.ExampleMod;
import hua.huase.shanhaicontinent.api.PlayerCapabilityApi;
import hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler;
import hua.huase.shanhaicontinent.capability.MonsterCapability;
import hua.huase.shanhaicontinent.capability.PlayerCapability;
import hua.huase.shanhaicontinent.capability.api.ChangeCapability;
import hua.huase.shanhaicontinent.seedpacket.PacketHandler;
import hua.huase.shanhaicontinent.seedpacket.PacketHunhuanKaiguan;
import hua.huase.shanhaicontinent.seedpacket.PacketPlayerCapability;
import hua.huase.shanhaicontinent.network.NetworkRegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static hua.huase.shanhaicontinent.capability.CapabilityRegistryHandler.MONSTER_CAPABILITY;

public class HunhuanEntity extends Entity {
    public static final String ID = "Hunhuan";
    public static final String NAME = ExampleMod.MODID + ".HunHuan";
    private  long exiistTime;

    private static final DataParameter<Integer> STAGELIFE =
            EntityDataManager.createKey(HunhuanEntity.class, DataSerializers.VARINT);
    public HunhuanEntity(World worldIn) {
        super(worldIn);
        this.exiistTime = worldIn.getWorldTime();
    }




    @Override
    protected void entityInit() {
        this.getDataManager().register(STAGELIFE, 0);
    }
    public Integer getStage()
    {
        return this.getDataManager().get(STAGELIFE);
    }
    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {

        this.getDataManager().set(STAGELIFE, compound.getInteger("Stage"));
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {

        compound.setInteger("Stage", this.getDataManager().get(STAGELIFE));
    }


    public void onCollideWithPlayer(EntityPlayer entityIn)
    {

    }

    public  int viewPlayer=0;
    public  Boolean kaiguan=false;
    public   EntityPlayer playerTite = null;
    public void onUpdate()
    {
        super.onUpdate();

        if(exiistTime+2000<=this.world.getWorldTime()){

            for (EntityPlayer entityPlayer : Collections.singletonList(playerTite)) {
                if(entityPlayer!=null)
                    PacketHandler.INSTANCE.sendTo(new PacketHunhuanKaiguan(kaiguan), (EntityPlayerMP) entityPlayer);
            }

            this.setDead();
        }
        if (!this.world.isRemote)
        {

            int STAGE = viewPlayer;
            if(STAGE%20==0){
                this.getDataManager().set(STAGELIFE, this.getCapability(MONSTER_CAPABILITY, null).getNianxian());
                double k = this.posX;
                double l = this.posY;
                double i1 = this.posZ;
                AxisAlignedBB axisalignedbb = (new AxisAlignedBB((double)k, (double)l, (double)i1, (double)(k + 1), (double)(l + 1), (double)(i1 + 1))).grow(1).expand(0.0D, 0.0D, 0.0D);
                List<EntityPlayer> list = this.world.<EntityPlayer>getEntitiesWithinAABB(EntityPlayer.class, axisalignedbb);
                if(list.size()>1)return;
                EntityPlayer player = null;
                for (EntityPlayer entityplayer : list)
                {
                    player = entityplayer;
                }


                if (player==null){
                    if(STAGE!=0&&STAGE<340){

                        playerTite.sendMessage(new TextComponentTranslation("message.hunhuan.list-1"));
                    }
                    kaiguan=false;
                    for (EntityPlayer entityPlayer : Collections.singletonList(playerTite)) {
                        if(entityPlayer!=null)
                        PacketHandler.INSTANCE.sendTo(new PacketHunhuanKaiguan(kaiguan), (EntityPlayerMP) entityPlayer);
                    }
                    viewPlayer=0;
                    return;

                }else{

                    if(!player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY,null).isHunhuankaiguan()){
                        return;
                    }


                    playerTite = player;


                    PlayerCapability playerCapability = player.getCapability(CapabilityRegistryHandler.PLYAER_CAPABILITY, null);
                    MonsterCapability monsterCapability = this.getCapability(MONSTER_CAPABILITY, null);
                    int nianxian = monsterCapability.getNianxian();

                    if(STAGE==0){
                        player.sendMessage(new TextComponentTranslation("message.hunhuan.list0", nianxian));
                        viewPlayer= ++STAGE;
                        return;
                    }

                    if(PlayerCapabilityApi.isXishouHunhuan((EntityPlayer) player)){


                        if(STAGE>80){
                            if(!kaiguan){
                                kaiguan=true;
                                for (EntityPlayer entityPlayer : Collections.singletonList(playerTite)) {
                                    if(entityPlayer!=null)
                                        PacketHandler.INSTANCE.sendTo(new PacketHunhuanKaiguan(true), (EntityPlayerMP) entityPlayer);
                                }
                                viewPlayer= ++STAGE;
                                return;
                            }
                        }

                        float jingshenli = playerCapability.getJingshenli();
                        float v = jingshenli - nianxian / 100f;
                        if(v >=0){

                            if(STAGE==100){
                                playerCapability.setJingshenli(v);
                                NetworkRegistryHandler.PlayerListen.sendClientCustomPacket((EntityPlayer) player);
                                player.sendMessage(new TextComponentTranslation("message.hunhuan.list1", nianxian / 100f));
                                viewPlayer= ++STAGE;
                                return;
                            }
                            if(STAGE==160){

                                playerCapability.setJingshenli(v);
                                NetworkRegistryHandler.PlayerListen.sendClientCustomPacket((EntityPlayer) player);
                                player.sendMessage(new TextComponentTranslation("message.hunhuan.list2", nianxian / 100f));
                                viewPlayer= ++STAGE;
                                return;
                            }
                            if(STAGE==220){

                                playerCapability.setJingshenli(v);
                                NetworkRegistryHandler.PlayerListen.sendClientCustomPacket((EntityPlayer) player);
                                player.sendMessage(new TextComponentTranslation("message.hunhuan.list3", nianxian / 100f));
                                viewPlayer= ++STAGE;
                                return;
                            }
                            if(STAGE==280){

                                playerCapability.setJingshenli(v);
                                NetworkRegistryHandler.PlayerListen.sendClientCustomPacket((EntityPlayer) player);
                                player.sendMessage(new TextComponentTranslation("message.hunhuan.list4", nianxian / 100f));
                                viewPlayer= ++STAGE;
                                return;
                            }
                            if(STAGE==340){

                                playerCapability.setJingshenli(v);
                                if(new Random().nextInt(3)!=0||jingshenli>nianxian/10){
    //								playerCapability.getMonsterCapabilityList().add(entity.getCapability(MONSTER_CAPABILITY, null));
                                    List<MonsterCapability> monsterCapabilityList = playerCapability.getMonsterCapabilityList();
                                    monsterCapabilityList.add(this.getCapability(MONSTER_CAPABILITY, null));
                                    playerCapability.setMonsterCapabilityList(monsterCapabilityList);
                                    ChangeCapability.addHunhuan(playerCapability,this.getCapability(MONSTER_CAPABILITY, null),  player);
                                    playerCapability.addDengji(1);
                                    NetworkRegistryHandler.PlayerListen.sendClientCustomPacket((EntityPlayer) player);
                                    player.sendMessage(new TextComponentTranslation("message.hunhuan.sccuess", nianxian));
                                    viewPlayer= 0;
                                    kaiguan=false;
                                    for (EntityPlayer entityPlayer : Collections.singletonList(playerTite)) {
                                        if(entityPlayer!=null)
                                            PacketHandler.INSTANCE.sendTo(new PacketHunhuanKaiguan(kaiguan), (EntityPlayerMP) entityPlayer);
                                    }

                                    PacketHandler.INSTANCE.sendToAllTracking(new PacketPlayerCapability(playerCapability,player),new NetworkRegistry.TargetPoint(player.dimension,player.posX,player.posY,player.posZ,60));

                                    this.setDead();
                                    return;
                                }

                                ((EntityLivingBase)player).addPotionEffect(new PotionEffect(MobEffects.NAUSEA,200,0,true,true));
                                player.sendMessage(new TextComponentTranslation("message.hunhuan.fail", nianxian));
                            }

                        }else {

                                if(STAGE==300) {
                                    playerCapability.setJingshenli(0);
                                    NetworkRegistryHandler.PlayerListen.sendClientCustomPacket((EntityPlayer) player);
                                    player.sendMessage(new TextComponentTranslation("message.hunhuan.list.false", jingshenli));
                                    ((EntityLivingBase)player).addPotionEffect(new PotionEffect(MobEffects.NAUSEA,200,0,true,true));
                                }
                            }

                    }else {

                        if(STAGE%100==0) {
                            player.sendMessage(new TextComponentTranslation("message.hunhuan.list.no"));
                            viewPlayer= ++STAGE;
                            return;
                        }
                    }



                }

            }

            viewPlayer= ++STAGE;
        }
    }

}
