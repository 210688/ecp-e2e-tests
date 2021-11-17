package ru.mos.smart.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * получения даты и времени.
 */
public class DateTime {

    /**
     * сокращенный вариант даты и времени.
     */
    public static String getDateAndTimeShort() {
        return new SimpleDateFormat("yyMMddHHmm").format(new Date());
    }
}
