package com.project.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {

    private static final String EMPTY_STRING = "";

    public boolean isNotBlank(String str){
        return str != null && !str.equals(EMPTY_STRING);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.equals(EMPTY_STRING);
    }
}
