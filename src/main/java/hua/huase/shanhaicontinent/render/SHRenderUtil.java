package hua.huase.shanhaicontinent.render;

import com.mojang.blaze3d.systems.RenderSystem;

/**
 * - @description:SHRenderUtil类
 * - @author: huase。
 * - @date: 2025/10/7 8:54
 */
public class SHRenderUtil {
    public static int getColor(int nianxian) {

        if(nianxian>=1000000){
            return 0xffffff55;
        }else if(nianxian>=100000){
            return 0xffdd0000;
        }else if(nianxian>=10000){
            return 0xff000000;
        }else if(nianxian>=1000){
            return 0xffdd00dd;
        }else if(nianxian>=100){
            return 0xffddff00;
        }else if(nianxian>=1){
            return 0xffffffff;
        }


        return 0xffffff55;
    }
}
