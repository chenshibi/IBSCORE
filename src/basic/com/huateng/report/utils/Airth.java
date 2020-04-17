package com.huateng.report.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;

public class Airth {
	private Airth() {}
	
	public static double add(double v1,double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return  b1.add(b2).doubleValue();   
	}
	
	public static String DoubleToStr(Double str) {
		DecimalFormat format = new DecimalFormat("#.00");
		return format.format(str);
	}
	
	public static Double StringToDouble(String str) {
	  Double num=0.00;
	  if(StringUtils.isNotEmpty(str)) {
		  num=Double.valueOf(str.toString());
	  }
	  return num;
	}

}
