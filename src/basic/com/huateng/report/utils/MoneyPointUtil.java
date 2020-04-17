package com.huateng.report.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import resource.bean.crms.CrComEga;
import resource.bean.crms.base.BaseCrComEga;

public class MoneyPointUtil {
	
	public static void main(String[] args) throws Exception {
		CrComEga ega=new CrComEga();
		ega.setEg01ad01("123423");
		ega.setEg01ad02("457575");
		ega.setEg01ai01("46546");
	
		
		
	}
	

	public static String getPoint(String money) {
		String returnMoney = null;
		String integer = null;// 整数部分
		String point = null; // 小数部分		
		if (money == null || "".equals(money)) {
			return "";
		}
		Integer length = money.length();
		if (money.indexOf(".") > 0) {// 有小数
			Integer a = money.indexOf(".");
			integer = money.substring(0, a);
			point = money.substring(a, length);
			returnMoney = (addThousandSeparator(integer) + point);
		} else {
			returnMoney = addThousandSeparator(money);
		}

		return returnMoney;
	}

	public static String addThousandSeparator(String money) {
		int length = money.length();
		ArrayList<String> list = new ArrayList<>();
		while (length > 3) { 
			list.add(money.substring(length - 3, length));
			length -= 3;
		}
		list.add(money.substring(0, length));// 把前三位加入集合
		StringBuffer buffer = new StringBuffer();
		for (int i = list.size() - 1; i > 0; i--) {
			buffer.append(list.get(i)).append(",");
		}
		buffer.append(list.get(0));

		return buffer.toString();
	}
	
	
	

}
