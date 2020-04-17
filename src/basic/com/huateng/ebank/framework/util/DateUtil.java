/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.ebank.framework.util;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.exceptions.CommonException;

import resource.bean.boa.CustHoliday;
import resource.dao.boa.CustHolidayDAO;

/**
 * @author valley
 * @date Nov 29, 2004
 * @description
 */
public class DateUtil {

    public static Date defaultDate = null;

    public static Date date19700101 = null;

    private static Logger log = Logger.getLogger(DateUtil.class);

    static {
        try {
            defaultDate = DataFormat.numberToDate("19000101");
            date19700101 = DataFormat.numberToDate("19700101");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DateUtil() {
        super();
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static java.sql.Date getCurrentDate() {
        return new java.sql.Date(System.currentTimeMillis());
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Time getCurrentTime() {
        return new Time(System.currentTimeMillis());
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 返回yyyy-MM-dd格式的字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        if (date == null)
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.DATE_PATTERN);
        return simpleDateFormat.format(date);
    }

    /**
     * 由日期返回yyyyMMdd格式的字符串
     * 
     * @param date
     * @return
     */
    public static String dateToNumber(Date date) {
        if (date == null)
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.DATE_PATTERN_2);
        return simpleDateFormat.format(date);
    }

    /**
     * 由日期返回yyMMdd格式的字符串
     * 
     * @param date
     * @return
     */
    public static String dateToNumber6(Date date) {
        if (date == null)
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.DATE_PATTERN_2);
        return simpleDateFormat.format(date);
    }

    /**
     * 返回yyyy-MM-dd hh : mm : ss 格式的字符串
     *
     * @param date
     * @return
     */
    public static String Time14ToString(java.sql.Timestamp time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.TIME14_PATTERN);
        return simpleDateFormat.format(time);
    }

    /* add by haizhou.li 2010-11-19 begin */
    /**
     * 返回yyyy-MM-dd hh : mm : ss 格式的字符串
     *
     * @param date
     * @return
     * @author haizhou.li
     */
    public static String Time14ToString2(java.util.Date time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.TIME14_PATTERN);
        return simpleDateFormat.format(time);
    }

    /* add by haizhou.li 2010-11-19 begin */
    /* add by haizhou.li 2010-11-19 begin */
    /**
     * 返回yyyy-MM-dd hh : mm : ss 格式的字符串
     *
     * @param date
     * @return
     * @author haizhou.li
     */
    public static String Time14ToString2(java.sql.Timestamp time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.TIME14_PATTERN2);
        return simpleDateFormat.format(time);
    }
    /* add by haizhou.li 2010-11-19 begin */

    /**
     * 返回yyyy-MM-dd hh : mm : ss 格式的字符串
     */

    public static String Time14ToString3(java.sql.Timestamp time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.TIME14_PATTERN);
        return simpleDateFormat.format(time);
    }

    /**
     * 返回 hh : mm : ss 格式的字符串
     *
     * @param date
     * @return
     */
    public static String Time6ToString(java.sql.Timestamp time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.TIME6_PATTERN);
        return simpleDateFormat.format(time);
    }

    /**
     * 由yyyy-MM-dd格式的字符串返回日期
     *
     * @param date
     * @return
     */
    public static Date stringToDate(String string) throws CommonException {
        if (string == null)
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.DATE_PATTERN);
        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_DATE_FORMAT_ERR);
        }
        return null;
    }

    /**
     * 由yyyymmdd格式的字符串返回日期
     *
     * @param date
     * @return
     */
    public static Date stringToDate2(String string) throws CommonException {
        if (DataFormat.isEmpty(string))
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SystemConstant.DATE_PATTERN_2);
        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_DATE_FORMAT_ERR);
        }
        return null;
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

        int days = calendarEndDate.get(Calendar.DAY_OF_YEAR) - calendarStartDate.get(Calendar.DAY_OF_YEAR);
        int y2 = calendarEndDate.get(Calendar.YEAR);
        while (calendarStartDate.get(Calendar.YEAR) < y2) {
            days += calendarStartDate.getActualMaximum(Calendar.DAY_OF_YEAR);
            calendarStartDate.add(Calendar.YEAR, 1);
        }

        return days;
    }

    /**
     * 
     * 计算两个日期相隔天数，其中满月按30天算，不满月按实际天数
     * 
     * @param
     * 
     * @return 天数
     * 
     */
    public static int getDaysBetween30(Date startDate, Date endDate) {

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

        int months =

                calendarEndDate.get(Calendar.MONTH)

                        - calendarStartDate.get(Calendar.MONTH)

                        + (calendarEndDate.get(Calendar.YEAR)

                                - calendarStartDate.get(Calendar.YEAR))

                                * 12;

        Date newEndDate = getEndDateByMonths(startDate, months);

        if (newEndDate.compareTo(endDate) <= 0

                || isSameDate(newEndDate, endDate) == true)

            months += 1;

        int days = (months - 1) * 30;

        Date newStartDate = getEndDateByMonths(startDate, months - 1);

        days += getDaysBetween(newStartDate, endDate);

        return days;

    }

    /**
     * 计算两个日期相隔年数(不比较月、日)
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getYearsBetween(Date startDate, Date endDate) {
        Calendar calendarStartDate = Calendar.getInstance();
        Calendar calendarEndDate = Calendar.getInstance();

        // 设日历为相应日期
        calendarStartDate.setTime(startDate);
        calendarEndDate.setTime(endDate);
        return calendarEndDate.get(Calendar.YEAR) - calendarStartDate.get(Calendar.YEAR);
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

        int months = calendarEndDate.get(Calendar.MONTH) - calendarStartDate.get(Calendar.MONTH)
                + (calendarEndDate.get(Calendar.YEAR) - calendarStartDate.get(Calendar.YEAR)) * 12;

        if (getEndDateByMonths(startDate, months).compareTo(endDate) < 0)
            months += 1;

        return months;
    }

    /**
     * 计算两个日期相隔的月数(不比较日)
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getActualMonths(Date startDate, Date endDate) {
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

        int months = calendarEndDate.get(Calendar.MONTH) - calendarStartDate.get(Calendar.MONTH)
                + (calendarEndDate.get(Calendar.YEAR) - calendarStartDate.get(Calendar.YEAR)) * 12;

        return months;
    }

    /**
     * 计算两个日期相隔的月数 比较日(不足月的不算1个月)
     */
    public static int getActualMonths2(Date startDate, Date endDate) {
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

        int months = calendarEndDate.get(Calendar.MONTH) - calendarStartDate.get(Calendar.MONTH)
                + (calendarEndDate.get(Calendar.YEAR) - calendarStartDate.get(Calendar.YEAR)) * 12;

        if (getEndDateByMonths(startDate, months).after(endDate))
            months = months - 1;

        return months;
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
     * 根据起始日和期限计算终止日
     * 
     * @param startDate
     * @param term
     *            YYMMDD格式的贷款期限
     * @return
     */
    public static Date getEndDateByTerm(Date startDate, String term) {
        int years = Integer.parseInt(term.substring(0, 2));
        int months = Integer.parseInt(term.substring(2, 4));
        int days = Integer.parseInt(term.substring(4, 6));
        return getEndDateByDays(getEndDateByMonths(startDate, years * 12 + months), days);
    }

    /**
     * 根据起始日期和终止日期计算期限
     * 
     * @param startDate
     * @param endDate
     * @return YYMMDD格式的贷款期限
     */
    public static String getTermBetween(Date startDate, Date endDate) {
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

        int months = calendarEndDate.get(Calendar.MONTH) - calendarStartDate.get(Calendar.MONTH)
                + (calendarEndDate.get(Calendar.YEAR) - calendarStartDate.get(Calendar.YEAR)) * 12;
        int days = 0;
        Date tempEndDate = getEndDateByMonths(startDate, months);

        if (tempEndDate.compareTo(endDate) < 0) {
            days = getDaysBetween(tempEndDate, endDate);
        } else if (tempEndDate.compareTo(endDate) > 0) {
            months -= 1;
            tempEndDate = getEndDateByMonths(startDate, months);
            days = getDaysBetween(tempEndDate, endDate);
        }

        int years = months / 12;
        months = months % 12;

        return DataFormat.termToString(years, months, days);
    }

    /**
     * 根据起始日和期限计算终止日
     * 
     * @param startDate
     * @param years
     * @param months
     * @param days
     * @return
     */
    public static Date getEndDateByTerm(Date startDate, int years, int months, int days) {
        return getEndDateByDays(getEndDateByMonths(startDate, years * 12 + months), days);
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

    public static Date getStartDateByYears(Date endDate, int years) {
        Calendar calendarEndDate = Calendar.getInstance();
        calendarEndDate.setTime(endDate);
        calendarEndDate.add(Calendar.YEAR, 0 - years);

        return calendarEndDate.getTime();
    }

    /**
     * 判断两个日期是否对日
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean isSameDate(Date startDate, Date endDate) {
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

        if (calendarStartDate.get(Calendar.DATE) == calendarEndDate.get(Calendar.DATE))
            return true;

        if (calendarStartDate.get(Calendar.DATE) > calendarEndDate.get(Calendar.DATE)) {
            if (calendarEndDate.get(Calendar.DATE) == calendarEndDate.getActualMaximum(Calendar.DATE))
                return true;
        }

        return false;
    }

    /**
     * 判断日期是否与指定的日期对日
     *
     * @param date
     * @param dd
     * @return
     */
    public static boolean isSameDate(Date date, String dd) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = Integer.parseInt(dd);

        if (calendar.get(Calendar.DATE) == day)
            return true;

        if (calendar.get(Calendar.DATE) < day) {
            if (calendar.get(Calendar.DATE) == calendar.getActualMaximum(Calendar.DATE))
                return true;
        }

        return false;
    }

    /**
     * 判断两个日期是否同一个月
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean isSameMonth(Date startDate, Date endDate) {
        if (startDate == null || endDate == null)
            return false;

        Calendar calendarStartDate = Calendar.getInstance();
        Calendar calendarEndDate = Calendar.getInstance();

        // 设日历为相应日期
        calendarStartDate.setTime(startDate);
        calendarEndDate.setTime(endDate);

        if (calendarStartDate.get(Calendar.YEAR) == calendarEndDate.get(Calendar.YEAR)
                && calendarStartDate.get(Calendar.MONTH) == calendarEndDate.get(Calendar.MONTH))
            return true;

        return false;
    }

    /**
     * 得到本月第一天的日期
     *
     * @param today
     * @return
     */
    public static Date getFirstDate(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, 1);

        return calendar.getTime();
    }

    /**
     * 得到本月最后一天的日期
     *
     * @param today
     * @return
     */
    public static Date getLastDate(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));

        return calendar.getTime();
    }

    /**
     * 得到昨日
     *
     * @param today
     * @return
     */
    public static Date getLastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -1);

        return calendar.getTime();
    }

    /**
     * 缺省的日期. 为1900年1月1号0点0分0秒.
     *
     * @return
     */
    public static Date getDefaultDate() {
        return defaultDate;
    }

    /**
     * double 转换为 bigdecimal
     * 
     * @param input
     * @return
     */
    public static BigDecimal convertDouble2BigDecimal(double input) {
        return new BigDecimal(Double.toString(input));
    }

    public static String iSODateTimeTo8Date(String iSODateTime) {
        if (DataFormat.trim(iSODateTime).length() >= 10) {
            return iSODateTime.substring(0, 4) + iSODateTime.substring(5, 7) + iSODateTime.substring(8, 10);
        } else
            return iSODateTime;
    }

    public static String formatDate8(String date) {
        if (date.length() == 8) {
            return date;
        }
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8);

        StringBuffer rtnDate = new StringBuffer(year).append(month).append(day);
        return rtnDate.toString().trim();
    }

    // add by shouhao 20091125 BMS-2244 begin
    /**
     * 获取当前日期
     */
    public static String getCurrentDate(String formatString) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(formatString);
        String date = sDateFormat.format(new java.util.Date());
        return date;
    }
    // add by shouhao 20091125 BMS-2244 end

    // add by shouhao 20091125 BMS-2336 begin
    /**
     * @param dateString
     *            该字符串须是date类型的字符串 例如：20091221等
     */
    public static String convertStringToTimeString(String dateString) {
        Date date1 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            date1 = simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String day = format1.format(date1);
        return day;

    }

    public static boolean isHoliday() {
        Date date = new Date();
        SimpleDateFormat format8 = new java.text.SimpleDateFormat("yyyyMMdd");
        String startDate = format8.format(date);
        return isHoliday(startDate);
    }

    public static boolean isHoliday(String startDate) {
        CustHolidayDAO dao = ROOTDAOUtils.getCustHolidayDAO();
        CustHoliday holiday = dao.findByHdate(startDate);
        if (holiday != null && "0".equals(holiday.getWork())) {
            return true;
        } else {
            return false;
        }
    }

    public static int calcHoliday(String startDate, String endDate) {
        int holidatcnt = 0;
        String sql = "select count(*) from cust_holiday where hdate > '" + startDate.substring(0, 8) + "' and hdate < '"
                + endDate.substring(0, 8) + "' and work = '0'";
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        try {
            holidatcnt = rootdao.queryBySqlToCount(sql);
        } catch (CommonException e) {
            e.printStackTrace();
        }
        return holidatcnt;
    }

    public static long dateDiffHour(String startTime, String format) {
        // 按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        // 获得两个时间的毫秒时间差异
        long diff = 0;
        int holidaycnt = 0;
        try {

            diff = (new Date()).getTime() - sd.parse(startTime).getTime();
            holidaycnt = calcHoliday(startTime, sd.format(new Date()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
        long hour = diff / nh;// 计算差多少小时
        log.info("时间相差：" + hour + "小时");
        hour = hour - (holidaycnt * 24);
        log.info("间隔假期：" + holidaycnt + "天" + "hour:" + hour + "小时。");
        return hour;
    }

    public static long dateDiffDay(String startTime, String format) {
        // 按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long ms = 1000 * 60 * 60 * 24;// 一天的毫秒数
        // 获得两个时间的毫秒时间差异
        long diff = 0;
        try {
            diff = (new Date()).getTime() - sd.parse(startTime).getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
        long day = diff / ms;// 计算差多少天
        log.info("时间相差：" + day + "天[" + startTime + "]to[" + new Date() + "]");
        return day;
    }

    public static long dateDiffMinute(String startTime, String format) {
        // 按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long nm = 1000 * 60;// 一分钟的毫秒数
        // 获得两个时间的毫秒时间差异
        long diff = 0;
        try {
            diff = (new Date()).getTime() - sd.parse(startTime).getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
        long minute = diff / nm;// 计算差多少分钟
        log.info("时间相差：" + minute + "分钟");

        return minute;
    }

    public static long dateDiffHour(String startTime, String endTime, String format) {
        // 按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat(format);
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数long diff;try {
        // 获得两个时间的毫秒时间差异
        long diff = 0;
        try {
            diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return 0;
        }
        long hour = diff / nh;// 计算差多少小时
        System.out.println("时间相差：" + hour + "小时.");
        return hour;
    }

    /**
     * @param dateString
     *            该字符串须是date类型的字符串 例如：20091221等
     * @param adateStrteStr
     * @return
     */
    public static String convertString2TimeString(String adateStrteStr) {
        Date date1 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssS");
        try {
            date1 = simpleDateFormat.parse(adateStrteStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        SimpleDateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");

        String day = format1.format(date1);
        return day;

    }
    // add by shouhao 20091125 BMS-2336 end

    /**
     * 取得TXN操作日期
     * 
     * @return TXN操作日期
     */
    public static String getTXNDate() {
        // TODO:取得操作日期
        return get8Date();
    }

    /**
     * 取得YYYYmmdd形式表示的8位当前日期
     * 
     * @return
     */
    public static String get8Date() {
        SimpleDateFormat format8 = new java.text.SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        return format8.format(calendar.getTime());
    }
    
    /**
         * 取得YYYYmm形式表示的6位当前日期
     * @return
     */
    public static String get6Date() {
        SimpleDateFormat format6 = new java.text.SimpleDateFormat("yyyyMM");
        Calendar calendar = Calendar.getInstance();
        return format6.format(calendar.getTime());
    }
    
    

    /**
     * 以YYYYmmdd获取日期
     * 
     * @return
     */
    public static Date getDateFromDate8(String yyyymmdd) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        if (StringUtils.isBlank(yyyymmdd) || yyyymmdd.length() != 8) {
            return date;
        }
        try {
            date = df.parse(yyyymmdd); // 将字符串类型的日期/时间解析为Date类型
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 以YYYYmmdd获取日期
     * 
     * @return
     */
    public static Date getDateFromTime14(String yyyymmdd) {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = null;
        if (StringUtils.isBlank(yyyymmdd) || yyyymmdd.length() != 14) {
            return date;
        }
        try {
            date = df.parse(yyyymmdd); // 将字符串类型的日期/时间解析为Date类型
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 以yyyyMMddHHmmss得到CICS回执的日期格式：×年×月×日*时*分
     * 
     * @return
     */
    public static String getCicsReturnDateFromTime14(String yyyyMMddHHmmss) {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = null;
        if (StringUtils.isBlank(yyyyMMddHHmmss) || yyyyMMddHHmmss.length() != 14) {
            return yyyyMMddHHmmss;
        }
        try {
            SimpleDateFormat formatCicsReturn = new java.text.SimpleDateFormat("yyyy年MM月dd日HH时mm分");
            date = df.parse(yyyyMMddHHmmss); // 将字符串类型的日期/时间解析为Date类型
            return formatCicsReturn.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return yyyyMMddHHmmss;
    }

    public static String get19Time() {
        SimpleDateFormat format19 = new java.text.SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        return format19.format(calendar.getTime());
    }

    /**
     * 取得YYYYmmddHHMMSS形式表示的14位当前日期
     * 
     * @return
     */
    public static String get14Time() {
        SimpleDateFormat format14 = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
        Calendar calendar = Calendar.getInstance();
        return format14.format(calendar.getTime());
    }

    
	public static String get14Date() {
		Calendar var0 = Calendar.getInstance();
		return String.format("%1$4tY%1$2tm%1$td%1$2TH%1$2TM%1$2TS", var0);
	}
    /**
     * 取得YYYYmmdd形式表示的8位日期
     * 
     * @param date
     *            日期
     * @return YYYYmmdd形式表示的日期
     */
    public static String get8Date(Calendar date) {
        return String.format("%1$4tY%1$2tm%1$td", date);
    }
    
    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        return formatter.format(date);
    }

    /**
     * 取得YYYYmmddHHMMSS形式表示的14位当前日期
     * 
     * @param date
     *            日期
     * @return YYYYmmddHHMMSS形式表示的日期
     */
    public static String get14Date(Calendar date) {
        return String.format("%1$4tY%1$2tm%1$td%1$2TH%1$2TM%1$2TS", date);
    }

    /**
     * 取得YYYYmmddHHMMSS形式表示的14位当前日期
     * 
     * @param date
     *            日期
     * @return YYYYmmddHHMMSS形式表示的日期
     */
    public static String get14Date(Date date) {
        SimpleDateFormat format14 = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
        return format14.format(date);
    }

    /**
     * 取得日期转换成的Calendar对象
     * 
     * @param date
     *            8位或14位的日期
     * @return Calendar对象
     * @throws CommonException
     *             当转换出错时产生错误
     */
    public static Calendar getCalFromDate(String date) throws CommonException {
        Calendar calendar = Calendar.getInstance();
        int year = 0;
        int month = 0;
        int date_of_month = 0;
        int hourOfDay = 0;
        int minute = 0;
        int second = 0;
        try {
            if (date.length() >= 8) {
                year = Integer.valueOf(date.substring(0, 4));
                month = Integer.valueOf(date.substring(4, 6)) - 1;
                date_of_month = Integer.valueOf(date.substring(6, 8));
            }
            if (date.length() >= 14) {
                hourOfDay = Integer.valueOf(date.substring(8, 10));
                minute = Integer.valueOf(date.substring(10, 12));
                second = Integer.valueOf(date.substring(12, 14));
            }
        } catch (NumberFormatException e) {
            ExceptionUtil.throwCommonException(e.getLocalizedMessage(), ErrorCode.ERROR_CODE_NORMAL, e);
        }
        calendar.set(year, month, date_of_month, hourOfDay, minute, second);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    /**
     * 通过传入格式为yyyyMMddhhmmss的字符串参数，将其转换成YYYY-mm-dd HH:MM:SS 格式的时间字符串 *
     * 
     * @return
     * @author lizh
     */
    public static String get19Date(String dtime) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        Calendar calendar = Calendar.getInstance();
        try {
            Date dateTime = simpleDateFormat.parse(dtime);
            calendar.setTime(dateTime);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return String.format("%1$4tY-%1$2tm-%1$td %1$2TH:%1$2TM:%1$2TS", calendar);
    }

    public static String getTermCh(String term) {
        String year = term.substring(0, 2);
        if (year.substring(0, 1).equals("0"))
            year = year.substring(1, 2);
        String month = term.substring(2, 4);
        if (month.substring(0, 1).equals("0"))
            month = month.substring(1, 2);
        String day = term.substring(4, 6);
        if (day.substring(0, 1).equals("0"))
            day = day.substring(1, 2);
        term = year + "年" + month + "月" + day + "天";
        return term;
    }

    public static Date get20Date(String source) throws CommonException {
        if (source == null || source.equals("")) {
            ExceptionUtil.throwCommonException(ErrorCode.DATE_IS_NULL);
        }
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            date = format.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 通过传入yyyyMMdd格式的日期字符串，将其转换成yyyy-MM-dd格式的日期字符串
     *
     * @param source
     * @return yyyy-MM-dd
     */
    public static String get21Date(String source) {
        if (source == null || source.equals(""))
            return null;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format1.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format2.format(date);
    }

    public static int getWeek(Date startDate) {
        Calendar calendarStartDate = Calendar.getInstance();
        calendarStartDate.setTime(startDate);
        int weekday = calendarStartDate.get(Calendar.DAY_OF_WEEK);
        return weekday;
    }

    /**
     * 通过传入long格式的时间间隔(ms)，将其转换成 hh : mm : ss 格式的字符串
     * 
     * @param procTime
     * @return
     */
    public static String getProcTime(long procTime) {
        String flg = "";
        if (procTime < 0) {
            flg = "-";
            procTime *= -1;
        }
        procTime = procTime / 1000; // 得到秒级别的
        long hh = procTime / 3600;
        long mm = (procTime - hh * 3600) / 60;
        long ss = procTime - mm * 60 - hh * 3600;
        return flg + hh + ":" + mm + ":" + ss;
    }

    /**
     * 由日期返回yyyyMMddHHmmss格式的字符串
     * 
     * @param time
     * @return
     */
    public static String timeToNumber(Date time) {
        if (time == null)
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(time);
    }

    public static String convterDateFmt(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            Date dt = sdf.parse(date);
            return new SimpleDateFormat("yyMMdd").format(dt);
        } catch (ParseException e) {
            return date;
        }
    }

    public static String getFormatStr(Date dt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(dt);
    }

    public static Date convterToDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }

    /**
     * 获取当前日期 年 月 日
     * 
     * @return
     */
    public static String getCurrDate() {
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);// 获取年份
        int month = ca.get(Calendar.MONTH) + 1;// 获取月份
        int day = ca.get(Calendar.DATE);// 获取日
        return year + "年" + month + "月" + day + "日";
    }

    public static void main(String[] args) {
        // File file = new
        // File("/Users/YiSiliang/Documents/workspace_CICS/CICS_AutoTest/src/com/huateng/cics/autotest/../../judicialQrySumForm.java");
        // System.out.println(file.getName());
        // System.out.println(File.separator);
        //
        // ArrayList<String> list = new ArrayList<String>();
        // for(String s:list){System.out.println(s);}
        // list.add("aaaaa");
        // list.add("bbbbb");
        // list.add("aaaaa");
        // list.add("ccccc");
        // list.add("aaaaa");
        // for(String s:list){System.out.println(s);}
        //
        // System.out.println(DateUtil.get14Time());
        // System.out.println(DateUtil.get19Time());
        // System.out.println(DateUtil.get8Date());
        // System.out.println("aaaaaaaafdasfdsf".indexOf("aaaaaaaa"));
        // System.out.println("aaaaaaaafdasfdsf".indexOf("aaaaaaa1111a"));
        System.out.println(DateUtil.getCicsReturnDateFromTime14("20160310112613"));
    }
    
   //时间差
    public static String Between(String date1,String date2){
    	DateFormat  df =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    	Date time1;
//    	Date time2;
    	long d=0;
    	long h=0;
    	long m=0;
    	long s=0;
    	long ss=0;
    	Date one ;
    	Date two ;
    	try{
	    	one = df.parse(date1);
	    	two = df.parse(date2);
	    	long time1=one.getTime();
	    	long time2=two.getTime();
	    	long diff;
		    		diff=time1-time2;
//	    	d=diff/(24*60*60*1000);
//	    	h=(diff/(60*60*1000)- d * 24);
//	    	m = ((diff/(60*1000))-d*24*60-h*60);
//	    	s=(diff/1000-d*24*60*60-h*60*60-m*60);
	    	//ss=(diff-d*24*60*60*1000-h*60*60*1000-m*60*1000-s*1000);
		    		long day = diff/(24*60*60*1000);
					 h = (diff/(24*60*60*1000)-day*24);		
					 m = (diff/(24*60*60*1000)-day*24*60-h*60);
					 s = (diff/1000-day*24*60*60-h*60*60-m*60);		
    	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    	}
    	return s+"";
    	//return d+"天"+h+"："+m+"："+s+"";
    }  
    
}