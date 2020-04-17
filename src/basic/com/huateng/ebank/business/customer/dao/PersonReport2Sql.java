package com.huateng.ebank.business.customer.dao;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.exception.AppException;
import com.huateng.report.constants.CreditReportConstants;
import com.huateng.report.utils.ReportUtils;

public class PersonReport2Sql {
	
	
	
	
	/**
	 * 二代企业征信信息查询
	 *
	 * @author quxin
	 * @param map
	 * @return
	 * @throws CommonException
	 */
	public static PersonReport2Bean queryPersonReport(Map<String, String> map) throws CommonException {
		PersonReport2Bean bean = new PersonReport2Bean();
		StringBuffer hql = new StringBuffer("from CustPbocPerQuery t where 1=1 ");
		
		if(StringUtils.isNotEmpty((String)map.get("name"))) {
			hql.append(" and t.name like '%"+map.get("name")+"%'");
		}
		
		if(StringUtils.isNotEmpty((String)map.get("idNum"))) {
			hql.append(" and t.idNum = '"+map.get("idNum")+"'");
		}
		if(StringUtils.isNotEmpty((String)map.get("idType"))) {
			hql.append(" and t.idType = '"+map.get("idType")+"'");
		}
		if(StringUtils.isNotEmpty((String)map.get("queryReason"))) {
			hql.append(" and t.queryReason = '"+map.get("queryReason")+"'");
		}
				
		bean.setSql(hql.toString());
		return bean;
	}
	
	
}