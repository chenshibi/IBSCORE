package com.huateng.report.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;


public class TestMain {

	public static void main(String[] args) {
		
	   String fileName="20190717_004.xlsx";
	   
	   String file="1-户口薄";
	   String a="01-贷前（保前）审查";
	   String s2 = file.trim().substring(0,
			   file.lastIndexOf("-"));
	   String s3 = a.trim().substring(0, a.lastIndexOf("-"));
//	   System.out.println("======"+s2);	
		
	//   System.out.println("----------"+s3); 
		// TODO Auto-generated method stub
		String str="<?xml version=\"1.0\" "
				+ "encoding=\"UTF-8\"?>\r\n" + 
				"<Document>\r\n" + 
				"    <Msg>\r\n" + 
				"        <ResultCode>AAA000</ResultCode>\r\n" + 
				"        <ResultDesc>处理成功</ResultDesc>\r\n" + 
				"        <ReportName>2019040300000001.xml</ReportName>\r\n" + 
				"        <ReportMessage>\r\n" + 
				"    </Msg>";
		String s1="B2.0.0W10312900H0012B000000000000120160301123018D10120160619000000010000000000";
		List<DataExtractionEntity> list=new ArrayList<DataExtractionEntity>();
		DataExtractionEntity aa=new DataExtractionEntity();
		aa.setCity("Xi’an");
		aa.setDepartment("BB_ClientService_North");
		aa.setId("2c948a836c1dd772016c1dd9ce3401f9");
		list.add(aa);
		DataExtractionEntity bb=new DataExtractionEntity();
		bb.setCity("Shanghai");
		bb.setDepartment("RB_Credit");
		bb.setId("402880e66bfde6be016bfde9bc400002");
		list.add(bb);
		DataExtractionEntity cc=new DataExtractionEntity();
		cc.setCity("Xi’an");
		cc.setDepartment("BB_ClientService_North");
		cc.setId("ff8080816bfa05e3016bfa07be2d0002");
		list.add(cc);
		
	//	list.stream().collect(Collectors.groupingBy(DataExtractionEntity::getCity));
		
	/*	List<DataExtractionEntity> newList = list.stream().
				collect(Collectors.collectingAndThen(Collectors.toCollection(() 
						-> new TreeSet<DataExtractionEntity>(Comparator.comparing(o ->o.getCity() + ";" + o.getDepartment()+";"+o.getId()))), ArrayList::new ));*/
	
	/*	List<DataExtractionEntity> newList = getNewList(list);
		for(DataExtractionEntity entity:newList) {
			System.out.println("====="+entity.getCity()+"===="+entity.getDepartment()+"===="+entity.getId());
		}*/
		
		/*List<DataExtractionEntity> removeDuplicateList = removeDuplicateWithOrder(list);
		for(DataExtractionEntity entity:newList) {
			System.out.println("====="+entity.getCity()+"===="+entity.getDepartment()+"===="+entity.getId());
		}*/
		
		String ids="2c948a836c1dd772016c1dd9ce3401f9,ff8080816bfa05e3016bfa07be2d0002,402880e66bfde6be016bfde9c73a00d1,ff8080816bfa05e3016bfa07be2d0002";
		String[][] arr=new String[ids.length()][1];
	//	System.out.println("========="+arr.length);
		String[] split = ids.split(",");
		String p="";
		StringBuffer b=new StringBuffer();
		b.append(p);
		for(String s:split) {
			 b = b.append("'").append(s).append("'").append(",");
//			 System.out.println("========="+s);
		}
		String substring = StringUtils.substring(b.toString(), 0, b.toString().length()-1);
		System.out.println("========="+substring);	
		
	}
	
	
	public static List<DataExtractionEntity> removeDuplicate(List<DataExtractionEntity> list) {   
	    HashSet<DataExtractionEntity> h = new HashSet<DataExtractionEntity>(list);   
	    list.clear();   
	    list.addAll(h);   
	    return list;   
	} 
	
	public static List<DataExtractionEntity> removeDuplicateWithOrder(List<DataExtractionEntity> list) {    
	    Set<DataExtractionEntity> set = new HashSet<DataExtractionEntity>();    
	     List<DataExtractionEntity> newList = new ArrayList<DataExtractionEntity>();    
	   for (Iterator<DataExtractionEntity> iter = list.iterator(); iter.hasNext();) {    
		    DataExtractionEntity next = iter.next();    
	         if (set.add(next))    
	            newList.add(next);    
	      }     
	     list.clear();    
	     list.addAll(newList);    
	 //   System.out.println( " remove duplicate " + list);    
		return list;
	 }   
	
	
	  private static List<DataExtractionEntity> getNewList(List<DataExtractionEntity> list) {
		    Map<String,DataExtractionEntity> tempMap=new  HashMap<String,DataExtractionEntity>();
		    for(DataExtractionEntity entity: list){
		    	String city=entity.getCity();
		    	String departMent=entity.getDepartment();
		    	String id=entity.getId();
		    	if(tempMap.containsKey(city+"_"+departMent)){
		    		DataExtractionEntity dataExtractionEntity=new DataExtractionEntity();
		    		dataExtractionEntity.setCity(city);
		    		dataExtractionEntity.setQueryDate(entity.getQueryDate());
		    		dataExtractionEntity.setQueryMonth(entity.getQueryMonth());
		    		dataExtractionEntity.setDepartment(departMent);
		    		dataExtractionEntity.setId(tempMap.get(city+"_"+departMent).getId()+","+entity.getId());
		    		tempMap.put(city+"_"+departMent, dataExtractionEntity);
		    	}else {
		    		tempMap.put(city+"_"+departMent, entity);
		    	}
		    }
		    
		    List<DataExtractionEntity> newList=new ArrayList<DataExtractionEntity>();
		    for(String o:tempMap.keySet()) {
		    	 newList.add(tempMap.get(o));
		    }
			return newList;
			  
		  }
	
	
	
	
	
	
	
	
	
	

}


class DataExtractionEntity {
	 private String city;
	 public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	private String department;

	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	private String trlNo;
	public String getTrlNo() {
		return trlNo;
	}
	public void setTrlNo(String trlNo) {
		this.trlNo = trlNo;
	}

	private String queryDate;
	public String getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

	private String queryMonth;
	public String getQueryMonth() {
		return queryMonth;
	}
	public void setQueryMonth(String queryMonth) {
		this.queryMonth = queryMonth;
	}
}




