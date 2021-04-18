package com.kaiyu56.common.core.utils;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author: cssly
 * @date: 2021/4/9 15:35
 * @description:
 * @url:
 */
public class LambdaUtils {
    public static <T> Consumer<T> consumerWithIndex(BiConsumer<T, Integer> consumer) {
        class Obj {
            int i;
        }
        Obj obj = new Obj();
        return t -> {
            int index = obj.i++;
            consumer.accept(t, index);
        };
    }
}
