package com.huateng.report.utils;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.ServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import cn.com.infosec.netsign.agent.NetSignAgent;
import cn.com.infosec.netsign.agent.NetSignResult;
import cn.com.infosec.netsign.agent.exception.NetSignAgentException;
import cn.com.infosec.netsign.agent.exception.ServerProcessException;
/** 
* @author Grassy 
* @version 创建时间：2019年11月5日 下午4:29:27 
* 类说明 
*/
@Service
public class HuaTengUtils {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(HuaTengUtils.class);
	 private static final String jdField_int = "Copyright Client Server International Inc.";
	  private static final Log jdField_if = LogFactory.getLog(HuaTengUtils.class);
	  private static final char[] a = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	  private static final char[] jdField_for = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	  private static boolean jdField_try = true;
	  private static final long jdField_do = 3600000L;
	  private static String jdField_new = "some random value JKLMNOP_!#";
	  
	  public static String appendSpace(String paramString, int paramInt)
	  {
	    if (paramString == null) {
	      paramString = "";
	    }
	    int i = paramInt - paramString.length();
	    if (i <= 0) {
	      return paramString.substring(0, paramInt);
	    }
	    StringBuffer localStringBuffer = new StringBuffer(paramString);
	    for (int j = 0; j < i; j++) {
	      localStringBuffer.append(' ');
	    }
	    return localStringBuffer.toString();
	  }
	  
	  public static String appendSpaceWithChinese(String paramString, int paramInt)
	  {
	    if (paramString == null) {
	      paramString = "";
	    }
	    int i = paramInt - paramString.getBytes().length;
	    if (i <= 0) {
	      return paramString.substring(0, paramInt);
	    }
	    StringBuffer localStringBuffer = new StringBuffer(paramString);
	    for (int j = 0; j < i; j++) {
	      localStringBuffer.append(' ');
	    }
	    return localStringBuffer.toString();
	  }
	  
	  public static Calendar bocmDatetimeToCal(String paramString)
	  {
	    int i = Integer.parseInt(paramString.substring(0, 4));
	    int j = Integer.parseInt(paramString.substring(4, 6)) - 1;
	    int k = Integer.parseInt(paramString.substring(6, 8));
	    int m = Integer.parseInt(paramString.substring(8, 10));
	    int n = Integer.parseInt(paramString.substring(10, 12));
	    int i1 = Integer.parseInt(paramString.substring(12));
	    Calendar localCalendar = Calendar.getInstance();
	    localCalendar.clear();
	    localCalendar.set(i, j, k, m, n, i1);
	    return localCalendar;
	  }
	  
	  public static Calendar bocmDateToCal(String paramString)
	  {
	    int i = Integer.parseInt(paramString.substring(0, 4));
	    int j = Integer.parseInt(paramString.substring(4, 6)) - 1;
	    int k = Integer.parseInt(paramString.substring(6, 8));
	    Calendar localCalendar = Calendar.getInstance();
	    localCalendar.clear();
	    localCalendar.set(i, j, k, 0, 0, 0);
	    return localCalendar;
	  }
	  
	  public static final String bytes2HexStr(byte[] paramArrayOfByte)
	  {
	    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
	    for (int i = 0; i < paramArrayOfByte.length; i++)
	    {
	      localStringBuffer.append(a[(paramArrayOfByte[i] >>> 4 & 0xF)]);
	      localStringBuffer.append(a[(paramArrayOfByte[i] & 0xF)]);
	    }
	    return localStringBuffer.toString();
	  }
	  
	  public static final String bytes2HexStr(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
	  {
	    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 4 + 5);
	    int i = paramInt1 + paramInt2;
	    for (int j = paramInt1; j < i; j++)
	    {
	      localStringBuffer.append("\\x");
	      localStringBuffer.append(a[(paramArrayOfByte[j] >>> 4 & 0xF)]);
	      localStringBuffer.append(a[(paramArrayOfByte[j] & 0xF)]);
	    }
	    return localStringBuffer.toString();
	  }
	  
	  public static final String calToBocmDate(Calendar paramCalendar)
	  {
	    int i = paramCalendar.get(1);
	    int j = paramCalendar.get(2) + 1;
	    int k = paramCalendar.get(5);
	    return i + (j < 10 ? "0" + j : new StringBuffer().append(j).toString()) + (k < 10 ? "0" + k : new StringBuffer().append(k).toString());
	  }
	  
	  public static final String calToBocmDate(Calendar paramCalendar, char paramChar)
	  {
	    int i = paramCalendar.get(1);
	    int j = paramCalendar.get(2) + 1;
	    int k = paramCalendar.get(5);
	    return i + paramChar + (j < 10 ? "0" + j : new StringBuffer().append(j).toString()) + paramChar + (k < 10 ? "0" + k : new StringBuffer().append(k).toString());
	  }
	  
	  public static final java.sql.Date calToSqlDate(Calendar paramCalendar)
	  {
	    return new java.sql.Date(paramCalendar.getTime().getTime());
	  }
	  
	  
	  public static final byte[] copyByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
	  {
	    byte[] arrayOfByte = new byte[paramInt2];
	    for (int i = 0; i < paramInt2; i++) {
	      arrayOfByte[i] = paramArrayOfByte[(i + paramInt1)];
	    }
	    return arrayOfByte;
	  }
	  
	  public static final void copyIntoByteArray(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
	  {
	    for (int i = 0; i < paramInt2; i++) {
	      paramArrayOfByte2[(i + paramInt1)] = paramArrayOfByte1[i];
	    }
	  }
	  
	  public static final String dateToBocmDateTime(java.util.Date paramDate)
	  {
	    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	    return localSimpleDateFormat.format(paramDate);
	  }
	  
	  public static final long dayDiff(Calendar paramCalendar1, Calendar paramCalendar2)
	  {
	    Calendar localCalendar1 = (Calendar)paramCalendar1.clone();
	    Calendar localCalendar2 = (Calendar)paramCalendar2.clone();
	    localCalendar1.set(10, 0);
	    localCalendar1.set(12, 0);
	    localCalendar1.set(13, 0);
	    localCalendar1.set(14, 0);
	    localCalendar2.set(10, 0);
	    localCalendar2.set(12, 0);
	    localCalendar2.set(13, 0);
	    localCalendar2.set(14, 0);
	    long l1 = localCalendar2.getTime().getTime() - localCalendar1.getTime().getTime();
	    long l2 = (l1 + 3600000L) / 86400000L;
	    return l2;
	  }
	  
	  public static final String formatAmount(String paramString)
	  {
	    try
	    {
	      double d = Double.valueOf(paramString).doubleValue();
	      return formatCurrency(d, "#,##0.00");
	    }
	    catch (Exception localException) {}
	    return paramString;
	  }
	  
	  public static final String formatAmount(String paramString, int paramInt)
	  {
	    String str = "#,##0";
	    if (paramInt > 1)
	    {
	      StringBuffer localStringBuffer = new StringBuffer();
	      localStringBuffer.append(str);
	      localStringBuffer.append(".");
	      for (int j = 1; j < paramInt; j++) {
	        localStringBuffer.append("0");
	      }
	      str = localStringBuffer.toString();
	    }
	    try
	    {
	      double d = Double.valueOf(paramString).doubleValue() / paramInt;
	      NumberFormat localNumberFormat = NumberFormat.getInstance(Locale.US);
	      DecimalFormat localDecimalFormat = (DecimalFormat)localNumberFormat;
	      localDecimalFormat.applyPattern(str);
	      return localDecimalFormat.format(d);
	    }
	    catch (Exception localException)
	    {
	    	jdField_if.error("Exception in formatAmount(String,int): " + localException);
	    }
	    return " ";
	  }
	  
	  public static final String formatAmountNoNegative(String paramString)
	  {
	    String str = null;
	    try
	    {
	      if ((paramString.charAt(0) == '-') || (paramString.charAt(0) == '+')) {
	        str = paramString.substring(1);
	      } else {
	        str = paramString.substring(0);
	      }
	      return str;
	    }
	    catch (Exception localException)
	    {
	    	jdField_if.error("Exception in formatAmountNoNegative(String): " + localException);
	    }
	    return " ";
	  }
	  
	  public static final String formatBOCMDate(String paramString)
	  {
	    StringBuffer localStringBuffer = new StringBuffer(paramString.substring(0, 4));
	    localStringBuffer.append("-" + paramString.substring(4, 6));
	    localStringBuffer.append("-" + paramString.substring(6));
	    return localStringBuffer.toString();
	  }
	  
	  public static final String formatBOCMDateTime(String paramString)
	  {
	    StringBuffer localStringBuffer = new StringBuffer(paramString.substring(0, 4));
	    localStringBuffer.append("-" + paramString.substring(4, 6));
	    localStringBuffer.append("-" + paramString.substring(6, 8));
	    localStringBuffer.append(" " + paramString.substring(8, 10));
	    localStringBuffer.append(":" + paramString.substring(10, 12));
	    localStringBuffer.append(":" + paramString.substring(12));
	    return localStringBuffer.toString();
	  }
	  
	  public static final String formatBOCMSignedPackedDate(String paramString)
	  {
	    int i = 0;
	    if (paramString.startsWith("+0")) {
	      i = 2;
	    }
	    String str = paramString.substring(i);
	    StringBuffer localStringBuffer = new StringBuffer(str.substring(0, 4));
	    localStringBuffer.append("-" + str.substring(4, 6));
	    localStringBuffer.append("-" + str.substring(6));
	    return localStringBuffer.toString();
	  }
	  
	  public static final String formatBOCMTime(String paramString)
	  {
	    StringBuffer localStringBuffer = new StringBuffer(paramString.substring(0, 2));
	    localStringBuffer.append(":" + paramString.substring(2, 4));
	    localStringBuffer.append(":" + paramString.substring(4));
	    return localStringBuffer.toString();
	  }
	  
	  public static final String formatCurrency(double paramDouble)
	  {
	    try
	    {
	      paramDouble /= 100.0D;
	      NumberFormat localNumberFormat = NumberFormat.getInstance(Locale.US);
	      DecimalFormat localDecimalFormat = (DecimalFormat)localNumberFormat;
	      localDecimalFormat.applyPattern("#,##0.00");
	      return localDecimalFormat.format(paramDouble);
	    }
	    catch (Exception localException)
	    {
	    	jdField_if.error("Exception in formatCurrency(String): " + localException);
	    }
	    return " ";
	  }
	  
	  public static final String formatCurrency(double paramDouble, String paramString)
	  {
	    try
	    {
	      DecimalFormat localDecimalFormat = (DecimalFormat)NumberFormat.getInstance(Locale.US);
	      localDecimalFormat.applyPattern(paramString);
	      return localDecimalFormat.format(paramDouble);
	    }
	    catch (Exception localException)
	    {
	    	jdField_if.error("Exception in formatCurrency(double, String): " + localException);
	    }
	    return " ";
	  }
	  
	  public static final String formatCurrency(String paramString)
	  {
	    Object localObject = null;
	    try
	    {
	      double d = Double.valueOf(paramString).doubleValue() / 100.0D;
	      NumberFormat localNumberFormat = NumberFormat.getInstance(Locale.US);
	      DecimalFormat localDecimalFormat = (DecimalFormat)localNumberFormat;
	      localDecimalFormat.applyPattern("#,##0.00");
	      return localDecimalFormat.format(d);
	    }
	    catch (Exception localException)
	    {
	    	jdField_if.error("Exception in formatCurrency(String): " + localException);
	    }
	    return " ";
	  }
	  
	  public static final String formatCurrencyNoNegative(String paramString)
	  {
	    Object localObject = null;
	    try
	    {
	      double d = Double.valueOf(paramString).doubleValue() / 100.0D;
	      if (d < 0.0D) {
	        d = -d;
	      }
	      NumberFormat localNumberFormat = NumberFormat.getInstance(Locale.US);
	      DecimalFormat localDecimalFormat = (DecimalFormat)localNumberFormat;
	      localDecimalFormat.applyPattern("#,##0.00;#,##0.00");
	      return localDecimalFormat.format(d);
	    }
	    catch (Exception localException)
	    {
	    	jdField_if.error("Exception in formatCurrencyNoNegative(String): " + localException);
	    }
	    return " ";
	  }
	  
	  public static final String formatDatePart(java.util.Date paramDate)
	  {
	    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    localSimpleDateFormat.applyPattern("yyyy-MM-dd");
	    return localSimpleDateFormat.format(paramDate);
	  }
	  
	  public static final String formatTimePart(java.util.Date paramDate)
	  {
	    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	    localSimpleDateFormat.applyPattern("HH:mm:ss");
	    return localSimpleDateFormat.format(paramDate);
	  }
	  
	  private static java.security.cert.X509Certificate a(ServletRequest paramServletRequest)
	  {
	    String str = "javax.net.ssl.peer_certificates";
	    Object localObject1 = paramServletRequest.getAttribute(str);
	    Object localObject2;
	    if (localObject1 != null)
	    {
	      localObject2 = localObject1.getClass().getName();
	      if (((String)localObject2).indexOf("Ljava.security.cert.X509Certificate") == -1) {
	        localObject1 = paramServletRequest.getAttribute("javax.servlet.request.X509Certificate");
	      }
	    }
	    else
	    {
	      localObject1 = paramServletRequest.getAttribute("javax.servlet.request.X509Certificate");
	    }
	    if (localObject1 != null)
	    {
	      localObject2 = (java.security.cert.X509Certificate[])localObject1;
	      return (X509Certificate) localObject2;
	    }
	    return null;
	  }
	  
	  public static String getCN(ServletRequest paramServletRequest)
	  {
	    java.security.cert.X509Certificate localX509Certificate = a(paramServletRequest);
	    if (localX509Certificate == null) {
	      return "invalid";
	    }
	    return getCN(localX509Certificate);
	  }
	  
	  public static String getCN(java.security.cert.X509Certificate paramX509Certificate)
	  {
	    String str = paramX509Certificate.getSubjectDN().getName();
	    int i = str.indexOf("CN=");
	    if (i == -1) {
	      return "";
	    }
	    int j = str.indexOf(",", i + 1);
	    if (j == -1) {
	      return str.substring(i);
	    }
	    return str.substring(i, j);
	  }
	  
	  public static String getCNwithSN(ServletRequest paramServletRequest)
	  {
	    java.security.cert.X509Certificate localX509Certificate = a(paramServletRequest);
	    if (localX509Certificate == null) {
	      return "invalid";
	    }
	    return getCNwithSN(localX509Certificate);
	  }
	  
	  public static String getCNwithSN(java.security.cert.X509Certificate paramX509Certificate)
	  {
	    String str1 = getCN(paramX509Certificate);
	    String str2 = prefixZero(str1.getBytes().length, 2);
	    StringBuffer localStringBuffer = new StringBuffer();
	    localStringBuffer.append(str2);
	    localStringBuffer.append(str1);
	    BigInteger localBigInteger = paramX509Certificate.getSerialNumber();
	    String str3 = localBigInteger.toString(16);
	    if (str3.length() % 2 != 0) {
	      str3 = "0" + str3;
	    }
	    String str4 = prefixZero(str3.length(), 2);
	    localStringBuffer.append(str4);
	    localStringBuffer.append(str3);
	    return localStringBuffer.toString();
	  }
	  
	  public static String getSNFromRequest(ServletRequest paramServletRequest)
	  {
	    java.security.cert.X509Certificate localX509Certificate = a(paramServletRequest);
	    if (localX509Certificate == null) {
	      return "invalid";
	    }
	    return getSN(localX509Certificate);
	  }
	  
	  public static String getSN(Object paramObject)
	  {
	    BigInteger localBigInteger;
	    if ((paramObject instanceof java.security.cert.X509Certificate)) {
	      localBigInteger = ((java.security.cert.X509Certificate)paramObject).getSerialNumber();
	    } else {
	      localBigInteger = ((javax.security.cert.X509Certificate)paramObject).getSerialNumber();
	    }
	    String str = localBigInteger.toString(16);
	    if (str.length() % 2 != 0) {
	      str = "0" + str;
	    }
	    return str;
	  }
	  
	  public static String getIssuerDN(Object paramObject)
	  {
	    if ((paramObject instanceof java.security.cert.X509Certificate)) {
	      return ((java.security.cert.X509Certificate)paramObject).getIssuerDN().getName();
	    }
	    return ((javax.security.cert.X509Certificate)paramObject).getIssuerDN().getName();
	  }
	  
	  public static final String getCurrentDate()
	  {
	    Calendar localCalendar = Calendar.getInstance();
	    int i = localCalendar.get(1);
	    int j = localCalendar.get(2) + 1;
	    int k = localCalendar.get(5);
	    return i + (j < 10 ? "0" + j : new StringBuffer().append(j).toString()) + (k < 10 ? "0" + k : new StringBuffer().append(k).toString());
	  }
	  
	  public static final String getCurrentDateTime()
	  {
	    Calendar localCalendar = Calendar.getInstance();
	    int i = localCalendar.get(1);
	    int j = localCalendar.get(2) + 1;
	    int k = localCalendar.get(5);
	    int m = localCalendar.get(11);
	    int n = localCalendar.get(12);
	    int i1 = localCalendar.get(13);
	    return i + (j < 10 ? "0" + j : new StringBuffer().append(j).toString()) + (k < 10 ? "0" + k : new StringBuffer().append(k).toString()) + (m < 10 ? "0" + m : new StringBuffer().append(m).toString()) + (n < 10 ? "0" + n : new StringBuffer().append(n).toString()) + (i1 < 10 ? "0" + i1 : new StringBuffer().append(i1).toString());
	  }
	  
	  public static final int getCurrentDay()
	  {
	    Calendar localCalendar = Calendar.getInstance();
	    int i = localCalendar.get(5);
	    return i;
	  }
	  
	  public static final int getCurrentMonth()
	  {
	    Calendar localCalendar = Calendar.getInstance();
	    int i = localCalendar.get(2) + 1;
	    return i;
	  }
	  
	  public static final String getCurrentTime()
	  {
	    Calendar localCalendar = Calendar.getInstance();
	    int i = localCalendar.get(11);
	    int j = localCalendar.get(12);
	    int k = localCalendar.get(13);
	    return (i < 10 ? "0" + i : new StringBuffer().append(i).toString()) + (j < 10 ? "0" + j : new StringBuffer().append(j).toString()) + (k < 10 ? "0" + k : new StringBuffer().append(k).toString());
	  }
	  
	  public static final int getCurrentYear()
	  {
	    Calendar localCalendar = Calendar.getInstance();
	    int i = localCalendar.get(1);
	    return i;
	  }
	  
	  
	  public static final String getPrevMonth1stDay(String paramString)
	  {
	    int i = Integer.parseInt(paramString.substring(4, 6)) - 1;
	    if (i > 0) {
	      return paramString.substring(0, 4) + (i < 10 ? "0" + i : new StringBuffer().append(i).toString()) + "01";
	    }
	    int j = Integer.parseInt(paramString.substring(0, 4)) - 1;
	    return j + "1201";
	  }
	  
	  public static final byte[] hexStr2Bytes(String paramString)
	  {
	    byte[] arrayOfByte = new byte[paramString.length() / 2];
	    for (int i = 0; i < arrayOfByte.length; i++) {
	      arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(2 * i, 2 * i + 2), 16));
	    }
	    return arrayOfByte;
	  }
	  
	  public static final boolean isAsciiStr(String paramString)
	  {
	    for (int i = 0; i < paramString.length(); i++) {
	      if (paramString.charAt(i) > '') {
	        return false;
	      }
	    }
	    return true;
	  }
	  
	  public static final boolean isNumeric(String paramString)
	  {
	    try
	    {
	      Double localDouble = Double.valueOf(paramString);
	      return true;
	    }
	    catch (Exception localException) {}
	    return false;
	  }
	  
	  public static final boolean isSameProtocol(String paramString1, String paramString2)
	  {
	    int i = paramString1.indexOf(':');
	    String str = paramString1.substring(0, i);
	    i = paramString2.indexOf(':');
	    return str.equals(paramString2.substring(0, i));
	  }
	  
	  public static final String milliSecond2Yyyymmdd(long paramLong)
	  {
	    java.util.Date localDate = new java.util.Date(paramLong);
	    Calendar localCalendar = Calendar.getInstance();
	    localCalendar.setTime(localDate);
	    return calToBocmDate(localCalendar);
	  }
	  
	  public static final String null2Empty(String paramString)
	  {
	    return paramString == null ? "" : paramString;
	  }
	  
	  public static final String prefixZero(long paramLong, int paramInt)
	  {
	    String str = Long.toString(paramLong);
	    int i = paramInt - str.length();
	    StringBuffer localStringBuffer = new StringBuffer(paramInt);
	    for (int j = 0; j < i; j++) {
	      localStringBuffer.append('0');
	    }
	    localStringBuffer.append(str);
	    return localStringBuffer.toString();
	  }
	  
	  public static final String prefixZero(String paramString, int paramInt)
	  {
	    StringBuffer localStringBuffer = new StringBuffer(paramInt);
	    for (int i = 0; i < paramInt - paramString.length(); i++) {
	      localStringBuffer.append('0');
	    }
	    localStringBuffer.append(paramString);
	    return localStringBuffer.toString();
	  }
	  
	  public static final String rightNow()
	  {
	    java.util.Date localDate = new java.util.Date();
	    try
	    {
	      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
	      localSimpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
	      return localSimpleDateFormat.format(localDate);
	    }
	    catch (Exception localException) {}
	    return "";
	  }
	  
	  public static String edit(String paramString1, String paramString2)
	  {
	    int j = 0;
	    int k = 0;
	    int m = paramString2.length();
	    int n = paramString1.length();
	    StringBuffer localStringBuffer1 = new StringBuffer(paramString1).reverse();
	    StringBuffer localStringBuffer2 = new StringBuffer();
	    char c;
	    for (int i = m - 1; i >= 0; i--)
	    {
	      if (j < n) {
	        c = localStringBuffer1.charAt(j);
	      } else if ((paramString2.charAt(i) == 'z') && (paramString2.charAt(i) == 'Z')) {
	        c = ' ';
	      } else {
	        c = '0';
	      }
	      switch (paramString2.charAt(i))
	      {
	      case '9': 
	        if ((c >= '0') && (c <= '9')) {
	          localStringBuffer2.append(c);
	        } else if (c == ' ') {
	          localStringBuffer2.append('0');
	        } else {
	          localStringBuffer2.append(' ');
	        }
	        j++;
	        break;
	      case 'Z': 
	      case 'z': 
	        if ((c >= '0') && (c <= '9')) {
	          localStringBuffer2.append(c);
	        } else {
	          localStringBuffer2.append('0');
	        }
	        j++;
	        break;
	      case 'X': 
	      case 'x': 
	        localStringBuffer2.append(c);
	        j++;
	        break;
	      default: 
	        localStringBuffer2.append(paramString2.charAt(i));
	      }
	    }
	    localStringBuffer2 = localStringBuffer2.reverse();
	    for (int i = 0; i < m; i++)
	    {
	      c = localStringBuffer2.charAt(i);
	      if ((paramString2.charAt(i) == '9') || (paramString2.charAt(i) == 'x') || (paramString2.charAt(i) == 'X') || ((c >= '1') && (c <= '9'))) {
	        break;
	      }
	      localStringBuffer2.setCharAt(i, ' ');
	    }
	    return localStringBuffer2.toString();
	  }
	  
	  public static String scale(String paramString1, String paramString2, int paramInt)
	  {
	    int i = paramString2.length();
	    StringBuffer localStringBuffer = new StringBuffer();
	    int k = paramString1.length();
	    for (int j = 0; j < k; j++) {
	      if (paramString2.indexOf(paramString1.charAt(j)) == -1) {
	        localStringBuffer.append(paramString1.charAt(j));
	      }
	    }
	    k = localStringBuffer.length();
	    if (k < paramInt) {
	      for (int j = 0; j < paramInt - k; j++) {
	        localStringBuffer.insert(0, '0');
	      }
	    }
	    return localStringBuffer.toString();
	  }
	  
	  public static String formatAmount(String paramString1, String paramString2)
	  {
	    int j = paramString2.indexOf('.');
	    int i;
	    if (j != -1) {
	      i = paramString2.length() - 1 - j;
	    } else {
	      i = 0;
	    }
	    paramString1 = paramString1.trim();
	    String str = scale(paramString1, ",", 0);
	    int k = str.indexOf('.');
	    StringBuffer localStringBuffer = new StringBuffer(str);
	    int m;
	    if (k == -1)
	    {
	      for (m = 0; m < i; m++) {
	        localStringBuffer.append('0');
	      }
	    }
	    else
	    {
	      m = str.length() - 1 - k;
	      if (m > i)
	      {
	        localStringBuffer.delete(str.length() - (m - i), str.length());
	        localStringBuffer.deleteCharAt(k);
	      }
	      else
	      {
	        localStringBuffer.deleteCharAt(k);
	        for (int n = 0; n < i - m; n++) {
	          localStringBuffer.append('0');
	        }
	      }
	    }
	    str = localStringBuffer.toString();
	    return edit(str, paramString2);
	  }
	  
	  public static String[] getLocalAddresses()
	  {
	    try
	    {
	      InetAddress localInetAddress = InetAddress.getLocalHost();
	      InetAddress[] arrayOfInetAddress = InetAddress.getAllByName(localInetAddress.getHostName());
	      String[] arrayOfString = new String[arrayOfInetAddress.length];
	      for (int i = 0; i < arrayOfInetAddress.length; i++) {
	        arrayOfString[i] = arrayOfInetAddress[i].getHostAddress();
	      }
	      return arrayOfString;
	    }
	    catch (UnknownHostException localUnknownHostException) {}
	    return null;
	  }
	  
	  public static String getSubjectDN(Object paramObject)
	  {
	    if ((paramObject instanceof java.security.cert.X509Certificate)) {
	      return ((java.security.cert.X509Certificate)paramObject).getSubjectDN().getName();
	    }
	    return ((javax.security.cert.X509Certificate)paramObject).getSubjectDN().getName();
	  }
	  
	  public static String getLocalHostName()
	  {
	    String str = "";
	    try
	    {
	      InetAddress localInetAddress = InetAddress.getLocalHost();
	      str = localInetAddress.getHostName();
	      if (str == null) {
	        str = localInetAddress.getHostAddress();
	      }
	    }
	    catch (UnknownHostException localUnknownHostException)
	    {
	      str = "";
	    }
	    return str;
	  }
	  
	  public static Set string2Set(String paramString)
	  {
	    HashSet localHashSet = new HashSet();
	    String[] arrayOfString = paramString.split(",");
	    for (int i = 0; i < arrayOfString.length; i++) {
	      localHashSet.add(arrayOfString[i]);
	    }
	    return localHashSet;
	  }
	  
	  public static String readStringFromStream(InputStream paramInputStream, int paramInt, String paramString)
	  {
	    byte[] arrayOfByte = new byte[paramInt];
	    int i = 0;
	    try
	    {
	      while (i < paramInt)
	      {
	        int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
	        if (j < 0) {
	          break;
	        }
	        i += j;
	      }
	      return new String(arrayOfByte, 0, i, paramString);
	    }
	    catch (Exception localException) {}
	    return null;
	  }
	  
		public static boolean isNullOrEmpty(Object obj) {
			if (obj instanceof Object[]) {
				Object[] o = (Object[]) obj;
				for (int i = 0; i < o.length; i++) {
					Object object = o[i];
					if(object instanceof Date){
						if(object.equals(new Date(0))) return true;
					}else  if ((object == null) || (("").equals(object))) {
						return true;
					}
				}
			} else {
				if(obj instanceof Date){
					if(obj.equals(new Date(0))){
						return true;
					}
				}else if ((obj == null) || (("").equals(obj))) {
					return true;
				}
			}

			return false;
		}
		
		
	 public static String getSignResult(String msg,String signCertNo) throws UnsupportedEncodingException{
		 LOGGER.info("========数字签名域为====="+"调用签名服务器开始");
		 LOGGER.info("========得到签名证书主题为====="+signCertNo);
          byte[] laintext = msg.getBytes(StandardCharsets.UTF_8);
      	 //签名证书DN，null表示用服务器默认证书进行签名
      //   String subject ="C=CN,O=PBCCRC,CN=07c3a03a-a632-45f7-ad15-22aa030e7f30";
      	//摘要算法，null表示用服务器默认的摘要算法
          String digestAlg ="SM3";
         //是否做TSA签名
          boolean useTSA = false ;
          NetSignResult detachedSignature=null;
          String signedTextB64=null;
          String errorCode="";
          String errorMsg="";
		  try {
			    detachedSignature = NetSignAgent.detachedSignature(laintext,signCertNo,digestAlg,useTSA);
			    signedTextB64= detachedSignature.getStringResult(NetSignResult.SIGN_TEXT);
			    LOGGER.info("========数字签名域为====="+signedTextB64);
		} catch (NetSignAgentException e) {
			e.printStackTrace();
			LOGGER.info("错误代码为======"+errorCode + e.getErrorCode());
			LOGGER.info("错误代码为======"+errorMsg + e.getMessage());
		} catch (ServerProcessException e) {
			e.printStackTrace();
			LOGGER.info("错误代码为======"+errorCode + e.getErrorCode());
			LOGGER.info("错误代码为======"+errorMsg + e.getMessage());
		}
		return signedTextB64;
	 }
	 
	 /* public static Object getClientCertificate(Context paramContext, List paramList)
	  {
	    String str1 = null;
	    String str2 = null;
	    Object[] arrayOfObject = (Object[])paramContext.getRequestAttribute("javax.net.ssl.peer_certificates");
	    if (arrayOfObject != null)
	    {
	      if ((arrayOfObject[0] instanceof java.security.cert.X509Certificate))
	      {
	        str1 = ((java.security.cert.X509Certificate)arrayOfObject[0]).getSubjectDN().getName().trim();
	        str2 = ((java.security.cert.X509Certificate)arrayOfObject[0]).getIssuerDN().getName().trim();
	      }
	      else
	      {
	        str1 = ((javax.security.cert.X509Certificate)arrayOfObject[0]).getSubjectDN().getName().trim();
	        str2 = ((javax.security.cert.X509Certificate)arrayOfObject[0]).getIssuerDN().getName().trim();
	      }
	      jdField_if.info(str1);
	      jdField_if.info(str2);
	      if (paramList != null)
	      {
	        Iterator localIterator = paramList.iterator();
	        while (localIterator.hasNext()) {
	          if (str2.equals(localIterator.next())) {
	            return arrayOfObject[0];
	          }
	        }
	        return null;
	      }
	      return arrayOfObject[0];
	    }
	    return null;
	  }*/
	  
	  
		/**
		 * 文件目录不存在则创建文件目录，带层级
		 * 
		 * @param path
		 */
		public static void mkdirIfNotExists(String path) {
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
				FilePermissonUtils.setPermission755(path);
			}
		}
	  
	 
	 public static boolean isUTF8(String key) {
		 try {
			 
	            key.getBytes("utf-8");
			    return true;
	        } catch (UnsupportedEncodingException e) {
                return false;
			}		 
	 }
	    /**
	     * 
	     * @param object
	     * @return
	     */
		public static String toStringAndTrim(Object object) {
			if (object == null) {
				return "";
			} else {
				return object.toString().trim();
			}

		}
}
