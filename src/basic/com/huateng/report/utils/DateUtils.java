package com.huateng.report.utils;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author YiSiliang
 */
public class DateUtils {
    private static final int TIME_LENGTH = 14;
    private static final int DATE_LENGTH = 8;

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

    public static final String PRETTY_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME14_FORMAT = "yyyyMMddHHmmss";
    public static final String PRETTY_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE8_FORMAT = "yyyyMMdd";

    public static String formatDate(Date paramDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PRETTY_DATE_FORMAT);
        return dateFormat.format(paramDate);
    }

    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }


    public static String get8Date() {
        return DateTime.now().toString(DATE8_FORMAT);
    }

    public static String get8Date(DateTime dateTime) {
        return dateTime.toString(DATE8_FORMAT);
    }

    public static String get14Time() {
        return DateTime.now().toString(TIME14_FORMAT);
    }
    
    public static String get14Time2() {
        return DateTime.now().toString(PRETTY_TIME_FORMAT);
    }

    public static int getCurrYear() {
        return DateTime.now().getYear();
    }

    public static int getCurrMonth() {
        return DateTime.now().getMonthOfYear();
    }

    public static int getCurrDay() {
        return DateTime.now().getDayOfMonth();
    }

    public static Date parseTime14(String time) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(TIME14_FORMAT);
        return DateTime.parse(time, formatter).toDate();
    }
    
    public static Date parseTime141(String time) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(PRETTY_TIME_FORMAT);
        return DateTime.parse(time, formatter).toDate();
    }
    
    
    public static Date parseTime(String time) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(TIME14_FORMAT);
        return DateTime.parse(time, formatter).toDate();
    }
    
    public static Date parseTime8(String time) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(DATE8_FORMAT);
        return DateTime.parse(time, formatter).toDate();
    }

    public static int getTotalDaysOfYear(int year) {
        DateTime dateTime = new DateTime(year, 1, 1, 0, 0);
        return dateTime.dayOfYear().getMaximumValue();
    }

    public static List<DateTime> getDaysOfYear(int year) {
        List<DateTime> days = new ArrayList<DateTime>();
        DateTime dateTime = new DateTime(year, 1, 1, 0, 0);
        int total = getTotalDaysOfYear(year);
        for (int i = 1; i <= total; i++) {
            DateTime date = dateTime.withDayOfYear(i);
            days.add(date);
        }
        return days;
    }

    public static String get14Time(DateTime time) {
        return time.toString(TIME14_FORMAT);
    }

    public static String getPrettyTime() {
        return toPrettyTime(DateTime.now().toDate());
    }

    public static String toPrettyTime(String time) {
        if (StringUtils.length(time) == TIME_LENGTH) {
            return StringUtils.substring(time, 0, 4) + "-"
                    + StringUtils.substring(time, 4, 6) + "-"
                    + StringUtils.substring(time, 6, 8) + " "
                    + StringUtils.substring(time, 8, 10) + ":"
                    + StringUtils.substring(time, 10, 12) + ":"
                    + StringUtils.substring(time, 12, 14);
        }
        return time;
    }

    public static String toPrettyTime(Date date) {
        if (date != null) {
            DateTime dateTime = new DateTime(date);
            return dateTime.toString(PRETTY_TIME_FORMAT);
        }
        return "";
    }

    public static String toPrettyDate(String date) {
        if (StringUtils.length(date) == DATE_LENGTH) {
            return StringUtils.substring(date, 0, 4) + "-"
                    + StringUtils.substring(date, 4, 6) + "-"
                    + StringUtils.substring(date, 6, 8);
        }
        return date;
    }

    public static String toPrettyDate(Date date) {
        if (date != null) {
            DateTime dateTime = new DateTime(date);
            return dateTime.toString(PRETTY_DATE_FORMAT);
        }
        return "";
    }

    public static String get19Time(String time14) {
        try {

            DateTimeFormatter formatter = DateTimeFormat.forPattern(TIME14_FORMAT);
            DateTime time = DateTime.parse(time14, formatter);
            return time.toString(PRETTY_TIME_FORMAT);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return "";
    }

    public static Date getDate() {
        Calendar localCalendar = Calendar.getInstance();
        return localCalendar.getTime();
    }

    public static int daysAgo(String dayStr, String strFormat) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(strFormat);
        Date ago = DateTime.parse(dayStr, formatter).toDate();
        return daysAgo(ago);
    }

    public static int daysAgo(Date ago) {
        return daysAgo(DateTime.now().toDate(), ago);
    }

    public static int daysAgo(Date today, Date ago) {
        DateTime jodaToday = new DateTime(today);
        DateTime jodaAgo = new DateTime(ago);
        return Days.daysBetween(jodaAgo, jodaToday).getDays();
    }
    
    public static String getFirstMonthDay() {
    	Calendar cal_1=Calendar.getInstance();//获取当前日期 
		cal_1.add(Calendar.MONTH, -1);
		cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		return formatDate(cal_1.getTime());
    }
    
    public static String getLastMonthDay() {
    	Calendar cale = Calendar.getInstance(); 
		cale.set(Calendar.DAY_OF_MONTH,0);//设置为1号,当前日期既为本月第一天 
		return formatDate(cale.getTime());
    }
    
    /**
     * 计算两个日期相隔的天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getDaysBetween(Date startDate, Date endDate) {
        Calendar calendarStartDate = Calendar.getInstance();
        Calendar calendarEndDate = Calendar.getInstance();

        // 设日历为相应日期
        calendarStartDate.setTime(startDate);
        calendarEndDate.setTime(endDate);
        if (startDate.after(endDate)) {
            Calendar swap = calendarStartDate;
            calendarStartDate = calendarEndDate;
            calendarEndDate = swap;
        }

        int days = calendarEndDate.get(Calendar.DAY_OF_YEAR)
                - calendarStartDate.get(Calendar.DAY_OF_YEAR);
        int y2 = calendarEndDate.get(Calendar.YEAR);
        while (calendarStartDate.get(Calendar.YEAR) < y2) {
            days += calendarStartDate.getActualMaximum(Calendar.DAY_OF_YEAR);
            calendarStartDate.add(Calendar.YEAR, 1);
        }

        return days;
    }
    
    /**
     * 计算两个日期相隔的月数(不足整月的算一个月)
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getMonthsBetween(Date startDate, Date endDate) {
        Calendar calendarStartDate = Calendar.getInstance();
        Calendar calendarEndDate = Calendar.getInstance();

        // 设日历为相应日期
        calendarStartDate.setTime(startDate);
        calendarEndDate.setTime(endDate);
        if (startDate.after(endDate)) {
            Calendar swap = calendarStartDate;
            calendarStartDate = calendarEndDate;
            calendarEndDate = swap;
        }

        int months = calendarEndDate.get(Calendar.MONTH)
                - calendarStartDate.get(Calendar.MONTH)
                + (calendarEndDate.get(Calendar.YEAR) - calendarStartDate
                        .get(Calendar.YEAR)) * 12;

        if (getEndDateByMonths(startDate, months).compareTo(endDate) < 0)
            months += 1;

        return months;
    }
    
    /**
     * 根据起始日和相隔月数计算终止日
     *
     * @param startDate
     * @param months
     * @return
     */
    public static Date getEndDateByMonths(Date startDate, int months) {
        Calendar calendarStartDate = Calendar.getInstance();
        calendarStartDate.setTime(startDate);
        calendarStartDate.add(Calendar.MONTH, months);

        return calendarStartDate.getTime();
    }
    
    /**
     * 根据起始日和相隔天数计算终止日
     *
     * @param startDate
     * @param days
     * @return
     */
    public static Date getEndDateByDays(Date startDate, int days) {
        Calendar calendarStartDate = Calendar.getInstance();
        calendarStartDate.setTime(startDate);
        calendarStartDate.add(Calendar.DAY_OF_YEAR, days);

        return calendarStartDate.getTime();
    }

    
    /**
     * 根据终止日和相隔天数计算起始日
     *
     * @param endDate
     * @param days
     * @return
     */
    public static Date getStartDateByDays(Date endDate, int days) {
        Calendar calendarEndDate = Calendar.getInstance();
        calendarEndDate.setTime(endDate);
        calendarEndDate.add(Calendar.DAY_OF_YEAR, 0 - days);

        return calendarEndDate.getTime();
    }

    /**
     * 根据终止日和相隔月数计算起始日
     *
     * @param endDate
     * @param months
     * @return
     */
    public static Date getStartDateByMonths(Date endDate, int months) {
        Calendar calendarEndDate = Calendar.getInstance();
        calendarEndDate.setTime(endDate);
        calendarEndDate.add(Calendar.MONTH, 0 - months);

        return calendarEndDate.getTime();
    }

}




