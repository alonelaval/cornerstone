package com.alonelaval.common.date;

import org.apache.tomcat.jni.Local;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author huawei
 * @create 2018-09-06
 **/
public abstract  class DateTimeUtils {
    /**
     *获得某天最大时间 2017-10-15 23:59:59
     */
    public static LocalDateTime getEndOfDay(LocalDateTime localDateTime) {

        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return endOfDay.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }



    /***
     * 获得某天最小时间 2017-10-15 00:00:00
     * @param date
     * @return
     */
    public static LocalDateTime getStartOfDay(LocalDateTime localDateTime) {
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return startOfDay.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


    public static void main(String[] args) {

        System.out.println("今天开始时间：" + getStartOfDay(LocalDateTime.now()));
        System.out.println("今天结束时间：" + getEndOfDay(LocalDateTime.now()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(formatter.format(getStartOfDay(LocalDateTime.now())));
        System.out.println(formatter.format(getEndOfDay(LocalDateTime.now())));

    }
}
