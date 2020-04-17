package com.huateng.report.pboc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.report.common.PbocConstants;
import com.huateng.report.pboc.entity.DataExtractionEntity;
/**
 * 
 * @author Grassy
 *
 */
public class DevUtils {
	  /**
	   * 
	   * @param ids
	   * @return
	   */
	  public static String  spritIds(String ids) {
	/*		String[] id= {};
			String idIn="";
			if(org.apache.commons.lang3.StringUtils.isNotEmpty(ids)) {
				  String[] split = id = ids.split(",");
				  
				  String p="";
				  StringBuffer b=new StringBuffer();
				  b.append(p);
				  for(String s:split) {
					  b = b.append("'").append(s).append("'").append(",");
				  }
				  idIn = StringUtils.substring(b.toString(), 0, b.toString().length()-1);
			}*/
			return ids;
			
			
		} 
	  
		
	  public static List<DataExtractionEntity> getNewList(List<DataExtractionEntity> list) {
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
	  
	  
	  public static String TransferSpecial(String str){
		  if(StringUtils.containsIgnoreCase(str, PbocConstants.SPECIAL_XM1_01)
				  || StringUtils.containsIgnoreCase(str, PbocConstants.SPECIAL_XML_02)
				  || StringUtils.containsIgnoreCase(str, PbocConstants.SPECIAL_XML_03)
				  || StringUtils.containsIgnoreCase(str, PbocConstants.SPECIAL_XML_04)
				  || StringUtils.containsIgnoreCase(str, PbocConstants.SPECIAL_XML_05)){
			  String str1 = str.replaceAll(PbocConstants.SPECIAL_XML_03, PbocConstants.TRANSFER_SPECIAL_XML);
			  String str2=str1.replaceAll(PbocConstants.SPECIAL_XML_05,PbocConstants.TRANSFER_SPECIAL_XML);
			  String str3=str2.replaceAll(PbocConstants.SPECIAL_XM1_01, PbocConstants.TRANSFER_SPECIAL_XML);
			  String str4=str3.replaceAll(PbocConstants.SPECIAL_XML_02, PbocConstants.TRANSFER_SPECIAL_XML);
			  String str5=str4.replaceAll(PbocConstants.SPECIAL_XML_04, PbocConstants.TRANSFER_SPECIAL_XML);
			  return str5;
			}  
		return str;
	  }
	  
	  
		
	  public static List<DataExtractionEntity> getListGroup(List<DataExtractionEntity> list) {
		    Map<String,DataExtractionEntity> tempMap=new  HashMap<String,DataExtractionEntity>();
		    for(DataExtractionEntity entity: list){
		    	String id=entity.getId();
		    	String queryMonth=entity.getQueryMonth();
		    	if(tempMap.containsKey(id+"_"+queryMonth)){
		    		DataExtractionEntity dataExtractionEntity=new DataExtractionEntity();
		    		dataExtractionEntity.setQueryDate(entity.getQueryDate());
		    		dataExtractionEntity.setQueryMonth(entity.getQueryMonth());
		    		dataExtractionEntity.setId(tempMap.get(id+"_"+queryMonth).getId()+","+entity.getId());
		    		tempMap.put(id+"_"+queryMonth, dataExtractionEntity);
		    	}else {
		    		tempMap.put(id+"_"+queryMonth, entity);
		    	}
		    }
		    
		    List<DataExtractionEntity> newList=new ArrayList<DataExtractionEntity>();
		    for(String o:tempMap.keySet()) {
		    	 newList.add(tempMap.get(o));
		    }
			return newList;
	  
	}
	  
}
