package com.kaiyu56.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author cssly
 * @date 2021/5/13
 */
@Getter
@Setter
public class WeekCount extends ArrayList<Integer> {
    public static int MONDAY;
    public static int TUESDAY;
    public static int WEDNESDAY;
    public static int THURSDAY;
    public static int FRIDAY;
    public static int SATURDAY;
    public static int SUNDAY;

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public WeekCount() {
        super(Arrays.asList(0,0,0,0,0,0,0));
    }
}