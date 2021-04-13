package com.guighost.utils;

import java.util.UUID;

/**
 * @author GuiGhost
 * @date 2021/02/12
 * 说明：
 */
public class IDUtils {
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
