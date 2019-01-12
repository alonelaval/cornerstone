package com.alonelaval.common.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author huawei
 * @create 2018-07-28
 **/
public class TimeUtils {
    /**
     * yyyy-MM-dd
     */
    static public final String FORMAT_DATE_ONLY         = "yyyy-MM-dd";
    /**
     * yyyy/MM/dd
     */
    static public final String FORMAT_DATE_ONLY_SLASH        = "yyyy/MM/dd";
    static public final String FORMAT_DATE_ONLY_ZH     = "yyyy年MM月dd日";
    static public final String FORMAT_TIME_ONLY          = "HH:mm:ss";
    static public final String FORMAT_COMPACT            = "yyyyMMddHHmmss";
    static public final String FORMAT_NORMAL              = "yyyy-MM-dd HH:mm:ss";
    static public final String FORMAT_DETAIL                  = "yyyy-MM-dd HH:mm:ss.SSS";
    static public final String FORMAT_NO_SECOND         = "yyyy-MM-dd HH:mm";
    static public final String FORMAT_DATE_ONLY_DOT     ="yyyy.MM.dd";

    /**
     *yyyyMMddHH
     */
    static public final String FORMAT_YYYYMMDDHH = "yyyyMMddHH";

    static public final long DATE_SECOND = 86400;// 一天有86400秒
    static public final long DATE_MINUTE = 1440;// 一天有1440分
    static public final long MINUTE_SECOND = 60;// 一天有60分

    public static Date parse(String str, String format)
    {
        try
        {
            SimpleDateFormat sf = new SimpleDateFormat(format);
            sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            return sf.parse(str);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static String format(Date date, String format)
    {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return sf.format(date);
    }

    public static String format(Timestamp date, String format)
    {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        sf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return sf.format(date);
    }

    public static boolean isExpire(String strTime, String strExpiredTime)
    {
        Date time = parse(strTime, FORMAT_NORMAL);
        Date expiredTime = parse(strExpiredTime, FORMAT_NORMAL);

        return (time.compareTo(expiredTime) >= 0);
    }

    /**
     * 生成制定日期的Date对象，从0点开始
     *
     * @param year
     * @param month
     * @param days
     * @return
     */
    public static Date createDate(int year, int month, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, days, 0, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 计算时间差
     *
     * @param beginTime
     *            开始时间，格式：yyyy-MM-dd HH:mm:ss
     * @param endTime
     *            结束时间，格式：yyyy-MM-dd HH:mm:ss
     * @return 从开始时间到结束时间之间的时间差（秒）
     */
    public static long getTimeDifference(String beginTime, String endTime)
    {
        long between = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date end = null;
        Date begin = null;
        try
        {
            // 将截取到的时间字符串转化为时间格式的字符串
            end = sdf.parse(endTime);
            begin = sdf.parse(beginTime);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        between = (end.getTime() - begin.getTime()) / 1000;// 除以1000是为了转换成秒

        return between;
    }

    public static String getTimeDifference(Date beginTime, Date endTime)
    {

        long between = endTime.getTime() - beginTime.getTime();
        if (between <= 0)
        {
            return "已过期";
        }

        between = between / 1000;// 除以1000是为了转换成秒
        long date = between / DATE_SECOND;
        long hour = (between - date * DATE_SECOND) / 3600;
        long minute = (between - date * DATE_SECOND - hour * 3600) / 60;
        long sec = (between - date * DATE_SECOND - hour * 3600 - minute * 60);
        if (date == 0)
        {
            return hour + "小时" + minute + "分钟" + sec + "秒";
        }
        else
        {
            return date + "天" + hour + "小时" + minute + "分钟" + sec + "秒";
        }
    }

    // 得到X天X小时时间
    public static String getDateExplain(long second)
    {
        String time = "";
        long hourCount_ = second / 3600;
        long dayCount_ = hourCount_ / 24;
        long remnantHour = hourCount_ % 24;
        if (dayCount_ != 0)
        {
            time = dayCount_ + "天";
        }
        if (remnantHour != 0)
        {
            time += remnantHour + "小时";
        }
        return time;
    }

    // 得到当前时间后x天的日期
    public static Date getFutrueDate(Date oldDate, int addDay)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(oldDate);
        c.add(Calendar.DATE, addDay);

        return c.getTime();
    }

    // 得到当前时间后x天的日期
    public static Date getFutrueDate(String oldDate, int addDay)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(parse(oldDate, FORMAT_DATE_ONLY));
        c.add(Calendar.DATE, addDay);

        return c.getTime();
    }

    // 比较两日期大小.
    public static String compare(Date d1, Date d2)
    {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        if (c1.after(c2))
        {
            return ">";
        }
        else
        if (c1.before(c2))
        {
            return "<";
        }
        else
        {
            return "=";
        }
    }

    // 比较两日期大小
    public static String compare(String s1, String s2)
    {
        Date d1 = parse(s1, FORMAT_DATE_ONLY);
        Date d2 = parse(s2, FORMAT_DATE_ONLY);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        if (c1.after(c2))
        {
            return ">";
        }
        else
        if (c1.before(c2))
        {
            return "<";
        }
        else
        {
            return "=";
        }
    }

    public static void main(String[] args) throws ParseException
    {
        Date startTime = parse("2014-09-10 16:58:20.093", FORMAT_DETAIL);
        Date endTime = new Date();
        System.out.println(getMonthsDifference(startTime, endTime));
        System.out.println(getDiffYearMonth(startTime));
//        System.out.println(getLastDayOfPreviousMonth(new Date(),true));
//        System.out.println(getFirstDayOfNextMonth(new Date(),true));
//        System.out.println(format(getFirstDayOfMonth(new Date()),FORMAT_NORMAL));
//        System.out.println(format(getLastDayOfMonth(new Date()),FORMAT_NORMAL));
//        System.out.println(format(format(new Date()),FORMAT_NORMAL));
    }

    /**
     *
     * getMonthsDifference：俩个时间的年份之差
     *
     * @param startTime
     * @param endTime
     * @return
     *
     * @see <参见的内容>
     */
    public static int getYearsDifference(Date startTime,Date endTime) {
        Calendar calendarStart = Calendar.getInstance();
        Calendar calendarEnd = Calendar.getInstance();
        calendarStart.setTime(startTime);
        calendarEnd.setTime(endTime);
        return (calendarEnd.get(Calendar.YEAR) - calendarStart.get(Calendar.YEAR))+(calendarStart.get(Calendar.MONTH)==0?0:1);
    }
    /**
     *
     * getMonthsDifference：俩个时间的月份之差
     *
     * @param startTime
     * @param endTime
     * @return
     *
     * @see <参见的内容>
     */
    public static int getMonthsDifference(Date startTime,Date endTime) {
        Calendar calendarStart = Calendar.getInstance();
        Calendar calendarEnd = Calendar.getInstance();
        calendarStart.setTime(startTime);
        calendarEnd.setTime(endTime);
        return (calendarEnd.get(Calendar.YEAR) - calendarStart.get(Calendar.YEAR))* 12+( calendarEnd.get(Calendar.MONTH)-calendarStart.get(Calendar.MONTH));
    }

    /**
     *
     * getMonthsDifference：俩个时间的月份之差
     *
     * @param startTime
     * @return
     *
     * @see <参见的内容>
     */
    public static int getMonthsDifference(Date startTime) {
        return getMonthsDifference(startTime, new Date());
    }



    /**
     *
     * getMonthsDifference：俩个时间的月份之差
     *
     * @param startTime
     * @return
     *
     * @see <参见的内容>
     */
    public static String getDiffYearMonth(Date startTime) {
        if(startTime == null)
            return "未知";
        Integer months =getMonthsDifference(startTime, new Date());
        Integer y= months/12;
        Integer m= months%12;
        return y ==0 ? m+"月" : y+"年"+m+"月";
    }

    /**
     *
     * getMonthsDifference：俩个时间的年份之差
     *
     * @param startTime
     * @return
     *
     * @see <参见的内容>
     */
    public static int getYearsDifference(Date startTime) {
        return getYearsDifference(startTime, new Date());
    }


    /**
     * 得到上个月最后一天
     * @return isFormatDate is true return string else return date
     *
     */
    public static Object getLastDayOfPreviousMonth(Date date,boolean isFormatDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONDAY,calendar.get(Calendar.MONTH)-1);
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);

        if(isFormatDate)
            return formatDate(getLastDayOfMonth(calendar.getTime()));
        return getLastDayOfMonth(calendar.getTime());
    }
    /**
     * 得到下个月第一天
     * @return isFormatDate is true return string else return date
     *
     */
    public static Object getFirstDayOfNextMonth(Date date,boolean isFormatDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MONDAY,calendar.get(Calendar.MONTH)+1);
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        if(isFormatDate)
            return formatDate(getFirstDayOfMonth(calendar.getTime()));
        return getFirstDayOfMonth(calendar.getTime());
    }


    public static String formatDate(Date date)
    {
        return format(date, FORMAT_NORMAL);
    }

    /**
     * 得到当前月最后一天
     * @param date
     * @return
     *
     */
    public static Date getLastDayOfMonth(Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE,1);
        c.roll(Calendar.DAY_OF_MONTH,-1);
        c.set(Calendar.HOUR_OF_DAY,23);
        c.set(Calendar.MINUTE,59);
        c.set(Calendar.SECOND,59);
        return c.getTime();
    }
    /**
     * 得到当前月的第一天
     * @param date
     * @return
     *
     */
    public static Date getFirstDayOfMonth(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE,1);
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        return c.getTime();
    }
    /***
     *
     * format：格式当前时间为00:00:00
     *
     * @param date
     * @return
     *
     * @see <参见的内容>
     */
    public static Date formatTimeBegin(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,0);
        c.set(Calendar.SECOND,0);
        return c.getTime();
    }
    /***
     *
     * format：格式当前时间为59:59:59
     *
     * @param date
     * @return
     *
     * @see <参见的内容>
     */
    public static Date formatTimeEnd(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.HOUR_OF_DAY,23);
        c.set(Calendar.MINUTE,59);
        c.set(Calendar.SECOND,59);
        return c.getTime();
    }

    /**
     * 根据日期起止日期，如 2011-01-01 - 2011-01-01
     * 给出 mysql 查询条件 datetime >= and < 的起止日期数组
     */
    public static Date[] getDateTimeBetween(String beginDateStr, String endDateStr, String format)
    {
        Date beginDate = parse(beginDateStr, format);
        Date endDate = parse(endDateStr, format);

        beginDate = formatTimeBegin(beginDate);
        endDate = getFutrueDate(endDate, 1);
        endDate = formatTimeBegin(endDate);

        return new Date[]{beginDate, endDate};
    }

    public static Date[] getDateTimeBetween(String beginDateStr, String endDateStr)
    {
        Date beginDate = parse(beginDateStr, FORMAT_DATE_ONLY);
        Date endDate = parse(endDateStr, FORMAT_DATE_ONLY);

        beginDate = formatTimeBegin(beginDate);
        endDate = getFutrueDate(endDate, 1);
        endDate = formatTimeBegin(endDate);

        return new Date[]{beginDate, endDate};
    }
}
