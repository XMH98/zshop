package com.xmh.zshop.util;

import java.util.UUID;

/**
 * Author: 徐明皓
 * Date: 2021-08-05 21:28
 * Description: <描述>
 */
public class StringUtils {
    public static String renameFileName(String filename){
        int dotIndex = filename.lastIndexOf(".");
        String suffix = filename.substring(dotIndex);
        return UUID.randomUUID().toString()+suffix;
    }
}
