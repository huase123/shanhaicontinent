package hua.huase.shanhaicontinent.functiontypes.functiontype;

import hua.huase.shanhaicontinent.functiontypes.MonsterType;

/**
 * - @description:FunctionType类
 * - @author: huase。
 * - @date: 2025/10/12 6:18
 */
public class FunctionType {
    public FunctionType() {
    }

    public boolean isMonster(){
        return this instanceof MonsterType;
    }
    public boolean isHunji(){
        return this instanceof MonsterType;
    }
    public boolean isWuhun(){
        return this instanceof MonsterType;
    }
}
