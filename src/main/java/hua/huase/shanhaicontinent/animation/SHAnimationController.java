package hua.huase.shanhaicontinent.animation;

import net.minecraft.world.entity.Entity;

public interface SHAnimationController {
    //动画播放的时间
    long getDuration(Entity livingEntity);

    //服务端与客户端实体tick
    void tick(Entity entity);
    Object getRendererInternal();

}
