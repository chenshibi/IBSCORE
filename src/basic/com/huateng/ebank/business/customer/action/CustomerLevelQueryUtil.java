package com.huateng.ebank.business.customer.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;

import resource.bean.basic.IndCrdDetail;

public class CustomerLevelQueryUtil {
	/**
	 * 使用键值填充数组
	 */
	public static  void arrayFill(String[] strs,int size,String value) {
		for(int i = 0 ; i < size ; i ++){
			strs[i] = value;
		}
	}
	/**
	 * 把数组元素组合为一个字符串,由fillStr填充
	 */
	public static String implode(String fillStr, String[] strs) {
		StringBuffer reStr = new StringBuffer();
		if(strs.length > 0){
			reStr.append(strs[0]);
			for(int i = 1 ;i < strs.length ; i++){
				reStr.append(fillStr).append(strs[i]);
			}
		}
		return reStr.toString();
	}
	public static String implode(String fillStr, ArrayList<String> list) {
		StringBuffer reStr = new StringBuffer();
		if(null != list && list.size() > 0){
			reStr.append(list.get(0));
			for(int i = 1 ;i < list.size() ; i++){
				reStr.append(fillStr).append(list.get(i));//把所有rpdids用‘,’分隔拼接成一个字符串
			}
		}
		return reStr.toString();
	}
	public static String implode(String fillStr, List<LevelQuerySub> list, String type) {
		StringBuffer reStr = new StringBuffer();
		if(null != list && list.size() > 0){
			if("id".equals(type)){
				reStr.append(list.get(0).getId());
				for(int i = 1 ;i < list.size() ; i++){
					reStr.append(fillStr).append(list.get(i).getId());
				}
			}else if("name".equals(type)){
				reStr.append(list.get(0).getName());
				for(int i = 1 ;i < list.size() ; i++){
					reStr.append(fillStr).append(list.get(i).getName());
				}
			}
		}
		return reStr.toString();
	}
	/**
	 * 将字符串str用strAdd填充至size长度
	 */
	public static String strRightPad(String str, int size, String strAdd) {
		if(size > str.length()){
			for(int length = str.length() ; length < size ; length ++){
				str = str + strAdd;
			}
		}
		return str;
	}
	/**
	 * 判断str是否可以转为整型
	 */
	public static boolean isInteger(String str) {  
	      Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");  
	      return pattern.matcher(str).matches();  
	}
	/**
	 * 获取map中所有值的总和
	 * @param enqmonth
	 * @return
	 */
	public static int getMapValueSum(Map<String, String> map) {
		int sum = 0;
		Iterator it = map.entrySet().iterator() ;
		while (it.hasNext())
		{
			Map.Entry entry = (Map.Entry)it.next() ;
			sum += Integer.parseInt((String)entry.getValue());
		}
		return sum;
	}
}
