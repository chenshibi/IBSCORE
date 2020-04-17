package com.huateng.excel.imp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataMyUtil {

    public static String getFullDateTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return formatter.format(date);
    }

    /**
     * <b>method desc:获得当前服务器的时间日期</b> <br/>
     * method detail:格式为yyyyMMddHHmmss,一共14位
     * 
     * @return 14位时间日期字符串
     */
    public static String getDateTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(date);
    }

    /**
     * <b>method desc:获得当前服务器的时间日期</b> <br/>
     * method detail:格式为yyyyMMddHHmmss,一共14位
     * 
     * @return 14位时间日期字符串
     */
    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        return formatter.format(date);
    }
  
    /**
     * <b>method desc:获得当前服务器的时间日期</b> <br/>
     * method detail:格式为yyyy-MMdd-HHmmss,一共16位
     * 
     * @return 16位时间日期字符串
     */
    public static String get16Date() {
        Date date = new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }
}
