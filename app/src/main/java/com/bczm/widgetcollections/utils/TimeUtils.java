package com.bczm.widgetcollections.utils;

/**
 * @author：Jorge on 2015/10/12 13:16
 */
public class TimeUtils {
    /**
     * convert time str
     *
     * @param time
     * @return
     */
    public static String convertTime(int time) {

        time /= 1000;
        int minute = time / 60;
        int second = time % 60;
        minute %= 60;
        return String.format("%02d:%02d", minute, second);
    }
}
