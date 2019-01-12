package com.alonelaval.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author huawei
 * @create 2018-08-05
 **/

public class DateUtils {
    /**
     * Patterns
     */
    public static final String DAY_PATTERN = "yyyy-MM-dd";
    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * Parse date by 'yyyy-MM-dd' pattern
     *
     * @param str
     * @return
     */
    public static Date parseByDayPattern(String str) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DAY_PATTERN);
            return sdf.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Format date by 'yyyy-MM-dd HH:mm:ss' pattern
     *
     * @param date
     * @return
     */
    public static String formatByDateTimePattern(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_PATTERN);
        return sdf.format(date);
    }

    /**
     * Format date by 'yyyy-MM-dd' pattern
     *
     * @param date
     * @return
     */
    public static String formatByDatePattern(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DAY_PATTERN);
        return sdf.format(date);
    }
}