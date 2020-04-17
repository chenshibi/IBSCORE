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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.huateng.ebank.business.common.ConfigReader;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.framework.exceptions.CommonException;

/**
 * @author valley
 * @date Dec 16, 2004
 * @description 格式转换(主要为页面输入输出转换使用)
 */
public class DataFormat {

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    private static final String DATE_NUMBER_PATTERN = "yyyyMMdd";

    private static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final String TIME_ONLY_PATTERN = "HHmmss";

    private static final String MONEY_PATTERN = "############0.00";

    private static final String CURRENCY_PATTERN = "#,###,###,###,##0.00";

    private static final String DAY_PATTERN = "00";

    public static final String YEAR_OF_TERM = "1"; // 获取期限中的年数
    public static final String MONTH_OF_TERM = "2";// 获取期限中的月数
    public static final String DAY_OF_TERM = "3";// 获取期限中的天数

    /**
     *
     */
    public DataFormat() {
        super();
    }

    /**
     * 由日期返回yyyy-MM-dd格式的字符串
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        if (date == null)
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DataFormat.DATE_PATTERN);
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

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DataFormat.DATE_NUMBER_PATTERN);
        return simpleDateFormat.format(date);
    }

    /**
     * 由返回自然日期（yyyyMMdd格式的字符串）
     *
     * @param date
     * @return
     */
    public static String getCurrentDateStr() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DataFormat.DATE_NUMBER_PATTERN);
        return simpleDateFormat.format(new Date());
    }

    public static String dateToNumberOrEmpty(Date date) {
        String d = null;
        try {
            d = dateToNumber(date);
        } catch (Exception ex) {
        }
        if (null == d) {
            return "";
        }
        return d;
    }

    /**
     * 由日期返回 dd 格式的字符串
     *
     * @param date
     * @return
     */
    public static String getDay(Date date) {
        if (date == null)
            return null;
        return DataFormat.dateToNumber(date).substring(6, 8);
    }

    /**
     * 由日期返回 mm 格式的字符串
     *
     * @param date
     * @return
     */
    public static String getMonth(Date date) {
        if (date == null)
            return null;
        return DataFormat.dateToNumber(date).substring(4, 6);
    }

    /**
     * 由日期返回 yyyy 格式的字符串
     *
     * @param date
     * @return
     */
    public static String getYear(Date date) {
        if (date == null)
            return null;
        return DataFormat.dateToNumber(date).substring(0, 4);
    }

    /**
     * 由日期返回yyyy-MM-dd HH:mm:ss格式的字符串
     *
     * @param time
     * @return
     */
    public static String timeToString(Date time) {
        if (time == null)
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DataFormat.TIME_PATTERN);
        return simpleDateFormat.format(time);
    }

    /**
     * 返回HHmmss格式字符串
     * 
     * @param time
     * @return
     */
    public static String onlyTimeToString(Date time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DataFormat.TIME_ONLY_PATTERN);
        return simpleDateFormat.format(time);
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

    /**
     * 由日期返回yyyy-MM-dd-HH.mm.ss.SSSSSS格式的字符串
     *
     * @param date
     *            Date格式日期
     * @return String yyyy-MM-dd-HH.mm.ss.SSSSSS格式 的字符串
     */
    public static String getTimeStampFormat(Date date) {
        if (date == null)
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss.SSSSSS");
        return simpleDateFormat.format(date);
    }

    /**
     * 由yyyy-MM-dd HH:mm:ss格式的字符串返回日期时间
     *
     * @param String
     *            时间
     * @return
     * @throws CommonException 
     */
    public static Date stringToTime(String string) throws CommonException {
        if (string == null)
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DataFormat.TIME_PATTERN);
        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_DATE_FORMAT_ERR);
        }
        return null;
    }

    /**
     * 字符串转整型类
     *
     * @param String
     *            时间
     * @return
     */
    public static Integer stringToInteger(String string) throws CommonException {
        if (string == null)
            return new Integer(0);

        try {
            return new Integer(string);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_CHANNEL_NUMBER_ERROR, string, e);
        }
        return null;
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

        if (string.trim().length() == 0)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DataFormat.DATE_PATTERN);
        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_DATE_FORMAT_ERR);
        }
        return null;
    }

    /**
     * 判断是否闰年
     * 
     * @param year
     * @return boolean
     */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * 取指定年、月的最大天数
     * 
     * @param year,
     *            month
     * @return number
     */
    public static int getMonthDay(int year, int month) {
        int[] numDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int n = numDays[month - 1];
        if (month == 2) {
            n = isLeapYear(year) ? 29 : 28;
        }
        return n;
    }

    /**
     * 由yyyyMMdd格式的字符串返回日期
     *
     * @param date
     * @return
     */
    public static Date numberToDate(String string) throws CommonException {
        if (DataFormat.isEmpty(DataFormat.trim(string)))
            return null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DataFormat.DATE_NUMBER_PATTERN);
        try {
            int year = Integer.parseInt(string.substring(0, 4));
            int month = Integer.parseInt(string.substring(4, 6));
            int day = Integer.parseInt(string.substring(6, 8));
            if (month < 1 || month > 12)
                throw new ParseException("ERROR", 1);
            if (day < 1 || day > getMonthDay(year, month))
                throw new ParseException("ERROR", 1);
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_DATE_FORMAT_ERR);
        }
        return null;
    }

    /**
     * 转换日期, 如果不能够转换, 返回缺省值(1900-01-01)
     *
     * @param string
     * @return
     */
    public static Date numberToDateOrEmpty(String string) {
        Date d = null;
        try {
            d = numberToDate(string);
        } catch (Exception ex) {
        }
        if (null == d) {
            d = DateUtil.getDefaultDate();
        }
        return d;
    }

    /**
     * 字符串转日期(total length 2bit, prefix 0)
     *
     * @param day
     * @return
     */

    public static String stringToDay(String day) {
        if (day == null)
            return DataFormat.DAY_PATTERN;
        DecimalFormat decimalFormat = new DecimalFormat(DataFormat.DAY_PATTERN);
        return decimalFormat.format(Integer.parseInt(day));
    }

    /**
     * 将整数转换为指定长度的右对齐，前补0的字符串
     *
     * @param n
     *            整数
     * @param l
     *            长度
     * @return
     */
    public static String intToString(long n, int l) {
        DecimalFormat decimalFormat = new DecimalFormat(DataFormat.initString('0', l));
        return decimalFormat.format(n);
    }

    /**
     * 以元为单位的金额转换为带分节符的右对齐的字符串
     *
     * @param money
     * @return
     */
    public static String doubleToCurrencyRA(double money) {
        DecimalFormat decimalFormat = new DecimalFormat(DataFormat.CURRENCY_PATTERN);
        String rtnValue = decimalFormat.format(money);
        return initString(' ', 12 - rtnValue.length()) + rtnValue;
    }

    /**
     * 以元为单位的金额转换为带分节符的左对齐的字符串
     *
     * @param money
     * @return
     */
    public static String doubleToCurrencyLA(double money) {
        DecimalFormat decimalFormat = new DecimalFormat(DataFormat.CURRENCY_PATTERN);
        return decimalFormat.format(money);
    }

    /**
     * 以元为单位的金额转换为不带分节符的右对齐的字符串
     *
     * @param money
     * @return
     */
    public static String doubleToMoneyRA(double money) {
        DecimalFormat decimalFormat = new DecimalFormat(DataFormat.MONEY_PATTERN);
        String rtnValue = decimalFormat.format(money);
        return initString(' ', 10 - rtnValue.length()) + rtnValue;
    }

    /**
     * 以元为单位的金额转换为不带分节符的左对齐的字符串
     *
     * @param money
     * @return
     */
    public static String doubleToMoneyLA(double money) {
        DecimalFormat decimalFormat = new DecimalFormat(DataFormat.MONEY_PATTERN);
        return decimalFormat.format(money);
    }

    /**
     * 不带分节符的字符串类型的以元为单位的金额转换为以元为单位的金额
     *
     * @param money
     * @return
     */
    public static double moneyToDouble(String money) {
        if (money == null)
            return 0.0;
        return Double.parseDouble(money);
    }

    /**
     * 带分节符的字符串类型的以元为单位的金额转换为以元为单位的金额
     *
     * @param money
     * @return
     */
    public static double currencyToDouble(String money) {
        if (money == null)
            return 0.0;
        return Double.parseDouble(money.replaceAll(",", ""));
    }

    /**
     * 将金额转换为大写人民币
     *
     * @param money
     * @return
     */
    public static String getRMBCapitalMoney(double money) {
        if (money == 0)
            return "零元整";

        String szChMoney = "", szNum = "";
        int iAddZero = 0;
        String mnUnit[] = { "分", "角", "元" };
        String hzUnit[] = { "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿" };
        String hzNum[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        szNum = DataFormat.doubleToMoneyLA(money).replaceAll("[.]", "");
        if (szNum.charAt(0) == '-') {
            szChMoney = "负";
            szNum = szNum.substring(1);
        }
        int iLen = szNum.length();

        if (iLen > 18 || iLen == 0)
            return "";

        for (int i = 1; i <= iLen; i++) {
            int iNum = Integer.parseInt(szNum.substring(i - 1, i));
            if (iNum == 0) {
                if ((iLen - i - 2) % 4 == 0 && iLen - i - 3 > 0 && (iLen - i >= 8 || iAddZero < 3))
                    szChMoney += hzUnit[(iLen - i - 3) % 8];
                iAddZero++;
            } else {
                if ((iAddZero != 0 && iLen - i >= 2) && (iLen - i - 1) % 4 != 0 || iAddZero >= 4)
                    szChMoney += hzNum[0];
                szChMoney += hzNum[iNum];
                iAddZero = 0;
            }

            if (iAddZero < 1 || iLen - i == 2)
                if (iLen - i >= 3) {
                    szChMoney += hzUnit[(iLen - i - 3) % 8];
                } else
                    szChMoney += mnUnit[(iLen - i) % 3];
        }

        if ("".equals(szChMoney.trim())) {
            return "零元整";
        }
        if (szNum.endsWith("0")) {
            szChMoney += "整";
        }
        if (szChMoney.startsWith("元")) {
            szChMoney = szChMoney.substring(1);
        }
        return szChMoney;
    }

    /**
     * 返回指定长度的，由指定字符组成的字符串(相当于c语言的memset)
     *
     * @param ch
     * @param length
     * @return
     */
    public static String initString(char ch, int length) {
        if (length < 0)
            return "";
        char chars[] = new char[length];
        for (int i = 0; i < length; i++)
            chars[i] = ch;
        return new String(chars);
    }

    /**
     * 修改字符串指定位
     *
     * @param string
     * @param idx
     * @param ch
     * @return
     */
    public static String setCharAt(String string, int idx, char ch) {
        StringBuffer sb = new StringBuffer(string);

        sb.setCharAt(idx, ch);
        return new String(sb);
    }

    /**
     * 判断string是否为空
     *
     * @param string
     * @return 如果为空则返回true，否则返回true
     */
    public static boolean isEmpty(String string) {
        if (string == null || string.trim().length() == 0)
            return true;
        else
            return false;
    }

    /**
     * 判断Object是否为null
     *
     * @param object
     * @return 如果为空则返回true，否则返回true
     */
    public static boolean isNull(Object object) {
        if (object == null)
            return true;
        else
            return false;
    }

    /**
     * 判断date是否为空
     *
     * @param date
     * @return 如果为空则返回true，否则返回true
     */
    public static boolean isEmpty(Date date) {
        if (date == null || DataFormat.dateToString(date).equals("1900-01-01"))
            return true;
        else
            return false;
    }

    /**
     * trim
     *
     * @param string
     * @return
     */
    public static String trim(String string) {
        if (string == null)
            return "";
        else
            return string.trim();
    }

    public static String trim(Object o) {
        if (o == null)
            // return "0";
            return "";
        else if (o.toString().trim().equals("")) {
            // return "0";
            return "";
        } else {
            return o.toString().trim();
        }
    }

    /**
     * 字符串加后缀
     *
     * @param string
     * @param ch
     * @param length
     * @return string
     */
    public static String suffixString(String string, char ch, int length) {

        int tmplen = length - string.trim().length();

        if (tmplen <= 0) {
            return string.trim();
        } else {
            String tmpStr = string.trim() + initString(ch, tmplen);
            return tmpStr;
        }
    }

    /**
     * 将double转换为右对齐，左补0的String(相当于c语言的printf("%0m.nf",dbl))
     *
     * @param dbl
     *            要转换的double
     * @param length
     *            小数点前长度（不包括符号位）
     * @param precision
     *            小数点后长度
     * @return
     * @throws CommonException
     */
    public static String dblRightAlign(double dbl, int length, int precision) throws CommonException {
        if (length <= 0 || precision < 0)
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_DATA_FORMAT_ERR);

        String format = initString('0', length);
        if (precision > 0)
            format = format + "." + initString('0', precision);
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(dbl);
    }

    /**
     * 将double转换为右对齐，左补0的String，小数四舍五入(相当于c语言的printf("%0m.0f",dbl))
     *
     * @param dbl
     *            要转换的double
     * @param length
     *            整数长度（不包括符号位）
     * @return
     * @throws CommonException
     */
    public static String dblRightAlign(double dbl, int length) throws CommonException {
        if (length <= 0)
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_DATA_FORMAT_ERR);

        String format = initString('0', length);
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(dbl);
    }

    /**
     * 根据输入的字符串，返回指定长度的String(相当于c语言的printf("%-n.ns",str))
     * 如果length小于str的长度，则截取指定长度； 如果length大于str的长度，则不足部分用空格补齐
     *
     * @param str
     * @param length
     *            长度
     * @return
     */
    public static String strLeftAlign(String str, int length) {
        if (str == null)
            return initString(' ', length);

        int len = str.length();
        if (length < len)
            return str.substring(0, length);
        else if (length == len)
            return str;
        else
            return str + initString(' ', length - len);
    }

    /**
     * 将List转换为以逗号分割的String
     *
     * @param strList
     * @return
     */
    public static String listToString(List strList) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < strList.size(); i++) {
            if (i != 0)
                buf = buf.append(",");
            buf = buf.append((String) strList.get(i));
        }
        return buf.toString();
    }

    /**
     * 将以逗号分割的String转换为List
     *
     * @param str
     * @return
     */
    public static List stringToList(String str) {
        List<String> list = new ArrayList<String>();
        if (DataFormat.isEmpty(str))
            return list;
        int startPos = 0;
        int endPos = str.indexOf(',', startPos);
        while (endPos >= 0) {
            list.add(str.substring(startPos, endPos));
            startPos = endPos + 1;
            endPos = str.indexOf(',', startPos);
        }
        if (startPos < str.length())
            list.add(str.substring(startPos));
        return list;
    }

    /**
     * 将整型的贷款期限转换为String
     *
     * @param str
     * @return
     */
    public static String termToString(int year, int month, int day) {
        return DataFormat.intToString(year, 3) + DataFormat.intToString(month, 3) + DataFormat.intToString(day, 4);
    }

    /**
     * 将YYMMDD格式的期限转换为n年n月n日的汉字描述
     *
     * @param term
     * @return
     */
    public static String termToDesc(String term) {
        int years = Integer.parseInt(term.substring(0, 2));
        int months = Integer.parseInt(term.substring(2, 4));
        int days = Integer.parseInt(term.substring(4, 6));
        StringBuffer buffer = new StringBuffer();
        if (years > 0)
            buffer.append(years).append("年");
        if (months > 0)
            buffer.append(months).append("月");
        if (days > 0)
            buffer.append(days).append("日");
        return buffer.toString();
    }

    /**
     * 将MMDD格式的期限转换为n月n日的汉字描述
     *
     * @param term
     * @return
     */
    public static String termToDesc1(String term) {

        int months = Integer.parseInt(term.substring(0, 2));
        int days = Integer.parseInt(term.substring(2, 4));
        StringBuffer buffer = new StringBuffer();

        if (months > 0)
            buffer.append(months).append("月");
        if (days > 0)
            buffer.append(days).append("日");
        return buffer.toString();
    }

    /**
     * 将整型的利率调整日期转换为String
     *
     * @param month
     * @param day
     * @return
     */
    public static String adjToString(int month, int day) {
        return DataFormat.intToString(month, 2) + DataFormat.intToString(day, 2);
    }

    /**
     * 将布尔值的选项转换为字符串类型
     *
     * @param
     * @return 5位的字符串
     */
    public static String getGuatType(boolean credit, boolean grarantee, boolean pledge, boolean impawn,
            boolean perform) {
        String str1 = credit ? "1" : "0";
        String str2 = grarantee ? "1" : "0";
        String str3 = pledge ? "1" : "0";
        String str4 = impawn ? "1" : "0";
        String str5 = perform ? "1" : "0";
        return str1 + str2 + str3 + str4 + str5;
    }

    /**
     * 将10位TERM的字符串转换为整形
     *
     * @param index
     *            - 如果为1则返回年(前3位)，2返回月(中间3位)，3返回天(后4位)
     * @return
     */
    public static int termToInt(String term, int index) {
        int value = 0;

        try {
            if (index == 1) {
                value = Integer.parseInt(term.substring(0, 3));
            } else if (index == 2) {
                value = Integer.parseInt(term.substring(3, 6));
            } else if (index == 3) {
                value = Integer.parseInt(term.substring(6));
            }
        } catch (Exception e) {

        }
        return value;
    }

    /**
     * 计算费率
     */
    public static float calIntrate(float basicIntrate, float percent) {
        long lb = (Math.round(basicIntrate * 1E6));
        long lp = (Math.round(percent * 1E4));
        double dIntrate = lb * (1E6 + lp) / 1E7; // 保证5位精度
        long lIntrate = Math.round(dIntrate);
        float fIntrate = (float) (lIntrate / 1E5);

        return fIntrate;
    }

    /**
     * 计算费率
     */
    public static float calIntrate(float basicIntrate, float percent, float value) {
        long lb = (Math.round(basicIntrate * 1E7));
        long lv = (Math.round(value * 1E7));
        long lp = (Math.round(percent * 1E4));
        double dIntrate = (lb + lv) * (1E6 + lp) / 1E7; // 保证6位精度
        long lIntrate = Math.round(dIntrate);
        float fIntrate = (float) (lIntrate / 1E6);

        return fIntrate;
    }

    /**
     * 金额大小比较。精度控制为0.00001
     */
    public static boolean equalsMoeny(double moeny1, double moeny2) {
        double result = moeny1 - moeny2;
        if (Math.abs(result) > 0.00001) {
            return true;
        } else {
            return false;
        }
    }

    public static String byte2hex(byte[] b) {

        String hs = "";
        String stmp = "";

        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = hs + ",";
        }

        return hs.toUpperCase();
    }

    // add by edison 20060515-------------------------------------
    /**
     * string's length is 5 eg: 15.01 to 01501 1.1 to 00110
     */
    public static String float2String(float f) {
        return intToString((int) (f * 100 + 0.5), 5);
    }

    /**
     * string's length is 5 eg: 01501 to 15.01 00110 to 1.1
     */
    public static float String2float(String s) {
        return Float.parseFloat(s) / 100.00f;
    }

    public static String array2String(String[] sa) {
        String result = "";
        for (int i = 0; i < sa.length; i++) {
            result += sa[i];
            if (i < sa.length - 1) {
                result += ":";
            }
        }
        return result;
    }

    public static String extendStringWithZero(String instr, int length) {
        if (instr.length() < length) {
            for (int i = instr.length(); i <= length; i++) {
                instr += "0";
            }
        }
        return instr;
    }

    // ************************************************************************************************
    // 以下为交行方法。
    // ************************************************************************************************
    /**
     * 由java.util.Date日期转换为 java.sql.Date
     *
     * @param date
     * @return
     */
    public static java.sql.Date trsUtilDateToSqlDate(java.util.Date date) throws CommonException {
        if (date == null)
            return null;

        return new java.sql.Date(date.getTime());
    }

    /**
     * 由日期返回yyyy-MM-dd HH:mm:ss格式的字符串，为空返回空串
     *
     * @param time
     * @return
     */
    public static String timeToStringEx1(Date time) {
        if (time == null)
            return "";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DataFormat.TIME_PATTERN);
        return simpleDateFormat.format(time);
    }

    /**
     * 带分节符的字符串类型的以元为单位的小写金额转换为大写金额
     *
     * @param money
     * @return
     */
    public static String currencyToChineseCurrency(double money) {
        if (money == 0.0) {
            return "零圆";
        }
        if (money > 9999999999999.99)
            return null;
        if (money < 0)
            return null;
        System.out.println(money);

        String number[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
        String monetary_unit[] = { "万", "仟", "佰", "拾", "亿", "仟", "佰", "拾", "万", "仟", "佰", "拾", "元", "角", "分" };
        // 初始化数组
        String returnMoney = "";
        int length;
        int flag = 1;
        int i;

        Double dblMoney = new Double(money);
        String strMoney = new Double(dblMoney.doubleValue()).toString();
        String strMoney1 = new Integer(dblMoney.intValue()).toString();

        String p = strMoney;
        // p="1642342342315";
        // //---------------------------------
        // p=doubleToMoneyLANoDiv100Test(money);
        // //----------------------------------

        length = p.length();
        if (p.indexOf('E') != -1) {

            int postfix = p.substring(2, p.indexOf('E')).length(); // 得到小数点后数字个数
            String sdecimal = p.substring(0, p.indexOf('E')); // E值前的小数值
            String pre = sdecimal.substring(0, 1); // 小数点前的
            String post = sdecimal.substring(2, 2 + postfix); // 小数点后的
            int last = Integer.parseInt(p.substring(p.indexOf('E') + 1, length));// 科学计数法的位数E9的9
            p = pre.concat(post);

            // 不齐后面补零
            if (last > postfix) {
                for (i = 0; i < last - postfix; i++) {
                    p = p.concat("0");
                }
            }
            if (last < postfix) {
                // endPoint:小数点后一位的值
                int endPoint = (new Integer(post.substring(last, last + 1))).intValue();
                // 取p的整数部分
                p = p.substring(0, 1 + last);
                // 比五大进位
                if (endPoint >= 5) {
                    char[] c = p.toCharArray();
                    int all9Flag = 1;
                    for (int j = 0; j < c.length; j++) {
                        if (c[j] != '9') {
                            all9Flag = 0;
                            break;
                        }
                    }
                    // 如果所有的数字都是九则变为1000000...
                    if (all9Flag == 1) {
                        String _p = "1";
                        for (int j = p.length(); j > 0; j--) {
                            _p = _p + "0";
                        }
                        p = _p;
                    }
                    // 进位加(非全九)
                    else {
                        String _p = "";
                        int addFlag = 1; // 进位标志
                        for (int j = p.length(); j > 0; j--) {
                            // 有进位
                            if (addFlag == 1) {
                                if ((new Integer(p.substring(j - 1, j))).intValue() == 9) {
                                    _p = "0" + _p;
                                    addFlag = 1;
                                } else {
                                    _p = (new Integer(p.substring(j - 1, j)).intValue() + 1) + _p;
                                    addFlag = 0;
                                }

                            }
                            // 无进位
                            else {
                                _p = _p + p.substring(j - 1, j);
                            }

                        }
                        p = _p;
                    }
                }
            }

            System.out.println(p);
            // String d = DataFormat.suffixString(c,'0',last-postfix);
            length = p.length();
            p = p.concat("/");

        } else {
            p = strMoney1;
            length = p.length();
            p = p.concat("/");
        }

        for (i = 15 - length; i < 15; i++) {
            if (p.charAt(i - 15 + length) != '0') {
                returnMoney = returnMoney
                        .concat(number[Integer.parseInt(p.substring(i - 15 + length, i - 15 + length + 1))]);

                returnMoney = returnMoney.concat(monetary_unit[i]);

            } else {
                if ((i != 4) && (i != 8) && (i != 12))
                    if ((p.charAt(i - 15 + length + 1) != '0') && (p.charAt(i - 15 + length + 1) != '/'))
                        returnMoney = returnMoney.concat(number[0]);
                if (i == 5) {
                    if ((p.charAt(i - 15 + length + 1) == '0') && (p.charAt(i - 15 + length + 2) == '0')
                            && (p.charAt(i - 15 + length + 3) == '0'))
                        flag = 0;
                } else {
                    if (i == 12 || (i == 8 && flag == 1) || i == 4)
                        returnMoney = returnMoney.concat(monetary_unit[i]);
                }
                if ((p.charAt(i - 15 + length) != '0') && (p.charAt(i - 15 + length + 1) != '0'))
                    returnMoney = returnMoney
                            .concat(number[Integer.parseInt(p.substring(i - 15 + length, i - 15 + length + 1))]);
            }
        }
        if ((p.charAt(length - 1) == '0') && (p.charAt(length - 2) == '0'))
            returnMoney = returnMoney.concat("整");
        return returnMoney;
    }

    /**
     * 带分节符的字符串类型的以元为单位的小写金额转换为大写金额
     *
     * @param money
     * @return
     */
    public static String currencyToChineseCurrency(String money) {
        // 去掉逗号
        money = money.replaceAll(",", "");
        if (money.equals("0")) {
            money = "0.0";
        }
        money = money.substring(0, money.length() - 3).concat(money.substring(money.length() - 2));
        return currencyToChineseCurrency(Double.parseDouble(money));
    }

    // BMS-2472 南京银行版本合并 jiang@2010-02-09 begin
    /**
     * 带分节符的字符串类型的以元为单位的小写金额转换为大写金额
     *
     * @param money
     * @return
     */
    public static String currencyToChineseCurrency(BigDecimal bigMoney) {
        String money = bigMoney.setScale(2).toString();
        if (money.equals("0")) {
            money = "0.0";
        }
        money = money.substring(0, money.length() - 3).concat(money.substring(money.length() - 2));
        return currencyToChineseCurrency(Double.parseDouble(money));
    }

    // BMS-2472 南京银行版本合并 jiang@2010-02-09 end
    /**
     *
     * @param string
     * @return
     */
    public static String null2String(String string) {
        if (string == null)
            return "";
        return string;
    }

    /**
     * 根据页面传入的利率获取实际利率（不带单位）
     * 
     * @param rateType
     * @param rate
     * @return
     */
    public static BigDecimal getRealRate(String rateType, BigDecimal rate) {
        if (rate == null || rateType == null)
            return null;
        BigDecimal realRate = rate;
        if (SystemConstant.RATE_TYPE_YEAR.equals(rateType)) {
            realRate = realRate.divide(new BigDecimal(100));
        } else if (SystemConstant.RATE_TYPE_MONTH.equals(rateType)) {
            realRate = realRate.divide(new BigDecimal(1000));
        } else if (SystemConstant.RATE_TYPE_DAY.equals(rateType)) {
            realRate = realRate.divide(new BigDecimal(10000));
        }
        return realRate;
    }

    /**
     * 根据数据库查询的利率获取页面展示利率（带单位）
     * 
     * @param rateType
     * @param rate
     * @return
     */
    public static BigDecimal getRevealRate(String rateType, BigDecimal rate) {
        if (rate == null || rateType == null)
            return null;

        BigDecimal revealRate = rate;
        if (SystemConstant.RATE_TYPE_YEAR.equals(rateType)) {
            revealRate = rate.multiply(new BigDecimal(100));
        } else if (SystemConstant.RATE_TYPE_MONTH.equals(rateType)) {
            revealRate = rate.multiply(new BigDecimal(1000));
        } else if (SystemConstant.RATE_TYPE_DAY.equals(rateType)) {
            revealRate = rate.multiply(new BigDecimal(10000));
        }
        return revealRate;
    }

    /**
     * 根据数据库保存的利率和利率类型转化成数据库保存的年利率格式
     * 
     * @param rateType
     * @param rate
     * @return
     */
    public static BigDecimal getYearRate(String rateType, BigDecimal rate) {
        BigDecimal yearRate = rate;
        if (SystemConstant.RATE_TYPE_YEAR.equals(rateType)) {
            return yearRate;
        } else if (SystemConstant.RATE_TYPE_MONTH.equals(rateType)) {
            yearRate = rate.multiply(BigDecimal.valueOf(12));
        } else if (SystemConstant.RATE_TYPE_DAY.equals(rateType)) {
            yearRate = rate.multiply(BigDecimal.valueOf(360));
        }
        return yearRate;
    }

    // BMS-2472 南京银行版本合并 jiang@2010-02-09 begin
    /**
     * 根据数据库保存的利率和利率类型转化成数据库保存的月利率格式
     * 
     * @param rateType
     * @param rate
     * @return
     */
    public static BigDecimal getMonthRate(String rateType, BigDecimal rate) {
        BigDecimal monthRate = rate;
        if (SystemConstant.RATE_TYPE_YEAR.equals(rateType)) {
            monthRate = rate.divide(BigDecimal.valueOf(12));
            ;
        } else if (SystemConstant.RATE_TYPE_MONTH.equals(rateType)) {
            return monthRate;
        } else if (SystemConstant.RATE_TYPE_DAY.equals(rateType)) {
            monthRate = rate.multiply(BigDecimal.valueOf(30));
        }
        return monthRate;
    }

    private final static String[] CN_Digits = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖", };

    /**
     * 将一组数字（不多于四个）转化成中文表示 <br/>
     * 作者：wallimn 时间：2009-4-11 下午07:41:25<br/>
     * 博客：http://wallimn.javaeye.com<br/>
     * 参数：<br/>
     *
     * @param partValue
     *            字符串形式的数字
     * @param bInsertZero
     *            是否在前面添加零
     * @return
     */
    private static String Part2CN(String partValue, boolean bInsertZero) {
        // 使用正则表达式，去除前面的0
        partValue = partValue.replaceFirst("^0+", "");
        int len = partValue.length();
        if (len == 0)
            return "零";
        StringBuffer sbResult = new StringBuffer();
        int digit;
        String[] CN_Carry = new String[] { "", "拾", "佰", "仟" };
        for (int i = 0; i < len; i++) {
            digit = Integer.parseInt(partValue.substring(i, i + 1));
            if (digit != 0) {
                sbResult.append(CN_Digits[digit]);
                sbResult.append(CN_Carry[len - 1 - i]);
            } else {
                // 若不是最后一位，且下不位不为零，追加零
                if (i != len - 1 && Integer.parseInt(partValue.substring(i + 1, i + 2)) != 0)
                    sbResult.append("零");
            }
        }
        if (bInsertZero && len != 4)
            sbResult.insert(0, "零");
        return sbResult.toString();
    }

    public static String getSmallAmount(BigDecimal money) {
        String Smoney = money.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        Smoney = Smoney.replaceAll("[.]", "");
        String smallMoney = "￥";
        for (int i = 0; i < Smoney.length(); i++) {
            smallMoney = smallMoney + Smoney.charAt(i);
        }
        return smallMoney;
    }

    /**
     * 获得打印页面利率（月） 单位千分号
     * 
     * @param rate
     * @return
     */
    public static String getPrintRate(String rateType, BigDecimal rate) {

        if (rateType == null || rate == null)
            return null;
        if (SystemConstant.RATE_TYPE_YEAR.equals(rateType)) {
            rate = rate.divide(new BigDecimal(12), 6, BigDecimal.ROUND_HALF_UP);
        } else if (SystemConstant.RATE_TYPE_MONTH.equals(rateType)) {

        } else if (SystemConstant.RATE_TYPE_DAY.equals(rateType)) {
            rate = rate.multiply(new BigDecimal(30));
        }

        return rate.multiply(new BigDecimal(1000)).toString();
    }

    public static String getPrintDate(String date8) {
        String year = date8.substring(0, 4);
        String mobth = date8.substring(4, 6);
        String day = date8.substring(6);
        return year + "    " + mobth + "    " + day;
    }

    public static Map getSmallAmount(Map<String, String> map, String smallAmount, String keyWord) {
        int m = 0;
        for (int i = 0; i < smallAmount.length(); i++) {
            map.put(keyWord + String.valueOf(i), String.valueOf(smallAmount.charAt(smallAmount.length() - 1 - i)));
        }
        return map;
    }

    public static String getPostcalCode(String postcalCode) {
        String returnString = "";
        for (int i = 0; i < postcalCode.length(); i++) {
            returnString += String.valueOf(postcalCode.charAt(i)) + " ";
        }
        return returnString;
    }

    public static Map getDraftNumber(Map<String, String> map, String draftNumber) {
        map.put("D1", String.valueOf(draftNumber.substring(0, 1)));
        map.put("D2", String.valueOf(draftNumber.substring(1, 2)));
        map.put("D3", String.valueOf(draftNumber.substring(2, 3)));
        map.put("D4", String.valueOf(draftNumber.substring(3, 4)));
        map.put("DRAFT_NUMBER", String.valueOf(draftNumber.substring(4)));
        return map;
    }

    private static final String[] NUMBERS = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };

    /** 通过 yyyyMMdd 得到中文大写格式 yyyy MM dd 日期 */
    public static synchronized String date8ToChinese(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(getSplitDateStr(str, 0)).append(",").append(getSplitDateStr(str, 1)).append(",")
                .append(getSplitDateStr(str, 2));
        return sb.toString();
    }

    /** 通过 yyyyMMdd 得到中文大写格式 yyyy年MM月dd日 日期 */
    public static synchronized String date8ToChinese2(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(getSplitDateStr(str, 0)).append("年").append(getSplitDateStr(str, 1)).append("月")
                .append(getSplitDateStr(str, 2)).append("日");
        return sb.toString();
    }

    /** 分别得到年月日的大写 默认分割符 "-" */
    public static String getSplitDateStr(String str, int unit) {
        // unit是单位 0=年 1=月 2日
        // String[] DateStr = str.split("-");
        String[] DateStr = new String[] { str.substring(0, 4), str.substring(4, 6), str.substring(6, 8) };
        if (unit > DateStr.length)
            unit = 0;
        String sb = "";
        for (int i = 0; i < DateStr[unit].length(); i++) {

            if ((unit == 1 || unit == 2) && Integer.valueOf(DateStr[unit]) > 9) {
                sb += convertNum(DateStr[unit].substring(0, 1)) + "拾" + convertNum(DateStr[unit].substring(1, 2));
                break;
            } else {
                sb += convertNum(DateStr[unit].substring(i, i + 1));
            }
        }
        if (unit == 1 || unit == 2) {
            // sb = sb.toString().replaceAll("^壹", "").replace("零", "");
            sb = sb.toString().replaceAll("零", "");
        }
        if ((unit == 1 || unit == 2)
                && (Integer.valueOf(DateStr[unit]) < 10 || Integer.valueOf(DateStr[unit]) % 10 == 0)) {
            sb = "零" + sb;
        }
        return sb;

    }

    /**
     * 将字符日期格式 yyyy-MM-dd 转为 Date格式 YYYY-MM-DD
     *
     * @author wuzhiwei @ 方法里MM 一定要大写
     * @param String
     * @return Date
     */
    public static Date ConvertDate(String param) {
        if (param == null || param.trim().length() < 1) {
            return null;
        }
        SimpleDateFormat convertDate = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date cDate;
        java.sql.Date date;
        try {
            cDate = convertDate.parse(param);
            date = new java.sql.Date(cDate.getTime());
            return date;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return null;
        }
    }

    /**
     * 将日期格式 Tue Feb 01 00:00:00 CST 2005 转为 Date格式 YYYY-MM-DD 2005-02-01
     *
     * @author wuzhiwei
     * @@param # 不确定是日期格式是否满足该方法日期格式 可调用之前判断 param.indexOf("CST")!=-1 则 调用此方法
     * @param String
     * @return Date
     */
    public static String ConvertCVTDate(Date param) {
        if (param == null || param.toString().trim().length() < 1) {
            return null;
        }
        // 由于各系统版本时区格式不兼容，采用以下形式转换
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // 规定日期格式
        return formatter.format(param);
    }

    /** 转换数字为大写 */
    private static String convertNum(String str) {
        return NUMBERS[Integer.valueOf(str)];
    }

    // BMS-2472 南京银行版本合并 jiang@2010-02-09 end
    // for test
    public static void main(String[] a) {
        System.out.println(float2String(12.10f));
        System.out.println(float2String(12.09f));
        System.out.println(float2String(12.01f));
        System.out.println(float2String(100.00f));
        System.out.println(float2String(2.1f));
        System.out.println(float2String(12f));
        System.out.println(float2String(12.0f));

        System.out.println(String2float("00000"));
        System.out.println(String2float("00110"));
        System.out.println(String2float("10000"));
        System.out.println(String2float("00100"));
        System.out.println(String2float("00002"));
    }
    // -------------------------------------add by edison 20060515

    /**
     * 暂时解决编译错误加的方法
     */
    static public String getOnlineTmpFilePath() {
        return "";
    }

    /**
     * @desc: 根据标志获取10位期限中的年数 月数或天数
     * @param term
     * @param flag
     * @return
     * @return: String
     * @Date: 2008-5-6
     * @Author: farly.yu
     */
    public static String getYoMoDOfTerm(String term, String flag) {
        String ymd = "";
        String tmpT = DataFormat.trim(term);
        String tmpF = DataFormat.trim(flag);
        if (tmpT.length() < 10 || tmpF.length() <= 0) {
            ymd = "0";
        } else {
            if (tmpF.equals(DataFormat.YEAR_OF_TERM)) {
                ymd = term.substring(0, 3);
            } else if (tmpF.equals(DataFormat.MONTH_OF_TERM)) {
                ymd = term.substring(3, 6);
            } else if (tmpF.equals(DataFormat.DAY_OF_TERM)) {
                ymd = term.substring(6, 10);
            } else {
                ymd = "000";
            }

        }
        return ymd;
    }

    /**
     * 将YYYYMMDD格式的年月日转换为n年n月n日的汉字描述
     *
     * @param term
     * @return
     */
    public static String date8ToDesc(String date8) {
        int years = Integer.parseInt(date8.substring(0, 4));
        int months = Integer.parseInt(date8.substring(4, 6));
        int days = Integer.parseInt(date8.substring(6, 8));
        StringBuffer buffer = new StringBuffer();
        if (years > 0)
            buffer.append(years).append("年");
        if (months > 0)
            buffer.append(months).append("月");
        if (days > 0)
            buffer.append(days).append("日");
        return buffer.toString();
    }

    /**
     * 由yyyyMMdd格式的字符串返回日期
     *
     * @param date
     * @return
     */
    public static Date stringToDate2(String string) throws CommonException {
        if (string == null)
            return null;
        if (string.trim().length() == 0)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DataFormat.DATE_NUMBER_PATTERN);
        try {
            return simpleDateFormat.parse(string);
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_DATE_FORMAT_ERR);
        }
        return null;
    }

    /**
     * 字符串转换为整形
     *
     * @param term
     * @param index
     * @return
     */
    public static int termToInt2(String term, int index) {
        int value = 0;

        try {
            if (index == 1) {
                value = Integer.parseInt(term.substring(0, 2));
            } else if (index == 2) {
                value = Integer.parseInt(term.substring(2, 4));
            } else if (index == 3) {
                value = Integer.parseInt(term.substring(4));
            }
        } catch (Exception e) {

        }
        return value;
    }

    /**
     * @Description：检验日期的合理性
     * @param String
     * @return boolean
     * @author Huang_Wisdom
     */
    public static boolean checkDate(String date) {
        boolean flag = false;
        if(date == null){
            return false;
        }
        if (DataFormat.trim(date).equals("")){
            return false;
        }
        if( date.length() != 8){
            return false;
        }
        else{
            int year = Integer.valueOf(date.substring(0, 4));
            int month = Integer.valueOf(date.substring(4, 6));
            int day = Integer.valueOf(date.substring(6, 8));

            if (year < 1900)
                flag = false;
            else if (month >= 13 || month <= 0)
                flag = false;
            else if (day >= (getLastDay(year, month) + 1) || day <= 0)
                flag = false;
            else
                flag = true;
        }
        return flag;
    }

    public static int getLastDay(int y, int m) // 取得每个月的最后一天
    {
        int lastday = 0;
        switch (m) {
        case 1:
            lastday = 31;
            break;
        case 2:
            if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0))
                lastday = 29;
            else
                lastday = 28;
            break;
        case 3:
            lastday = 31;
            break;
        case 4:
            lastday = 30;
            break;
        case 5:
            lastday = 31;
            break;
        case 6:
            lastday = 30;
            break;
        case 7:
            lastday = 31;
            break;
        case 8:
            lastday = 31;
            break;
        case 9:
            lastday = 30;
            break;
        case 10:
            lastday = 31;
            break;
        case 11:
            lastday = 30;
            break;
        case 12:
            lastday = 31;
            break;
        default:
            lastday = 0;
        }
        return lastday;
    }

    /**
     * 计算利率,包括利率浮动值
     */
    public static float calIntrateWithFloatValue(float basicIntrate, float percent, float floatValue) {
        long lf = (Math.round(floatValue * 1E6));
        long lb = (Math.round(basicIntrate * 1E6));
        long lp = (Math.round(percent * 1E4));
        double dIntrate = lb * (1E6 + lp) / 1E6 + lf; // 保证6位精度
        long lIntrate = Math.round(dIntrate);
        float fIntrate = (float) (lIntrate / 1E6);

        return fIntrate;
    }

    /**
     * 传入Date，返回yyyy年mm月dd日 by zhouc
     *
     * @param date
     * @return lilinfeng add
     */
    public static String dateToStringZh(Date date) {
        if (date == null)
            return "";
        return DataFormat.getYear(date) + "年" + DataFormat.getMonth(date) + "月" + DataFormat.getDay(date) + "日";
    }

    /**
     * 字符串加后缀 中文算2个长度
     *
     * @param string
     * @param ch
     * @param length
     * @return string
     */
    public static String suffixString4CN(String string, char ch, int length) {
        int tmplen = 0;
        try {
            tmplen = length - (new String(string.getBytes(), "8859_1")).length();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (tmplen <= 0) {
            return string.trim();
        } else {
            String tmpStr = string.trim() + initString(ch, tmplen);
            return tmpStr;
        }
    }

    /**
     * 字符串加前缀 add jiang@20080708
     *
     * @param string
     * @param ch
     * @param length
     * @return string
     */
    public static String prefixString(String string, char ch, int length) {

        int tmplen = length - string.trim().length();

        if (tmplen <= 0) {
            return string.trim();
        } else {
            String tmpStr = initString(ch, tmplen) + string.trim();
            return tmpStr;
        }
    }
}