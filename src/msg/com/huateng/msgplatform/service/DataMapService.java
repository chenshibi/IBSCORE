package com.huateng.msgplatform.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import resource.bean.basic.DataDic;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;

public class DataMapService {
	/*
	 * 通过data_dic字典data_type_no查询并返回data_no和data_name的map集合
	 * 	qx
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getNameByNo(Integer dataTypeNo) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
          StringBuffer hql =  new StringBuffer("select po from DataDic po where 1=1 ");
          hql.append(" and po.dataTypeNo="+dataTypeNo);
	  	List<DataDic> list = rootdao.queryByCondition(hql.toString());
	    Map<String, String> m=new HashMap<String, String>();
	    if(list !=null && list.size()>0){
	    	for(int i=0;i<list.size();i++){
	    		DataDic dc=list.get(i);
	    		m.put(dc.getDataNo(), dc.getDataName());
	    	}
	    }
		return m;
	}
}
