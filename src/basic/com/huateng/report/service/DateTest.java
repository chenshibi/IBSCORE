package com.huateng.report.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.huateng.report.utils.DateUtils;

public class DateTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String firstDay,lastDay;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 

		//获取前月的第一天
		Calendar cal_1=Calendar.getInstance();//获取当前日期 
		cal_1.add(Calendar.MONTH, -1);
		cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		firstDay = format.format(cal_1.getTime());
		System.out.println("-----1------firstDay:"+firstDay);
		//获取前月的最后一天
		Calendar cale = Calendar.getInstance(); 
		cale.set(Calendar.DAY_OF_MONTH,0);//设置为1号,当前日期既为本月第一天 
		lastDay = format.format(cale.getTime());
		System.out.println("-----2------lastDay:"+lastDay); 
		
		
		List<String> list=new ArrayList<String>();
		 list.add("297ed50b6bb5b551016bb6c0deb2000c");
		 list.add("297ed50b6bb5b551016bb6c112350200");
		 list.add("2018121715323911253284 ");
		 StringBuffer b=new StringBuffer();
		 for(String s:list) {
			  b.append(s).append(",");
		 }
		 String ids = b.toString();
		 String substring = StringUtils.substring(ids, 0, ids.length()-1);
		 System.out.println("-----------:"+substring);   
		
		 
		 String date1="Thu Aug 01 2019 00:00:00 GMT 0800 (中国标准时间)";
		 String date2="Sat Aug 31 2019 00:00:00 GMT 0800 (中国标准时间)";
	//	 String format2 = format.format(date1);
	//	 System.out.println("----格式化-------:"+format2); 
		 
		 
		 String d1="20190828";
		 String year=d1.substring(0, 4);
         String month=d1.substring(4, 6);		 
		 String day=d1.substring(6, 8);
		 System.out.println("----d1-------:"+year+"============"+month+"=========="+day); 
		 
		}
	
	   

}
