package com.kaiyu56.common.core.utils;

import com.kaiyu56.common.core.enums.BaseEnum;

/**
 * @author: cssly
 * @date: 2021/4/7 10:54
 * @description:
 * @url:
 */
public class EnumUtils {

    public static <T extends Enum<?> & BaseEnum> T codeOf(Class<T> enumClass, String code) {
        T[] enumConstants = enumClass.getEnumConstants();
        for (T t : enumConstants) {
            if (t.getCode() == code) {
                return t;
            }
        }
        return null;
    }
}

