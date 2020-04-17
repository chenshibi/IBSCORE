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

public class CompanyReport2Sql {
	
	
	
	
	/**
	 * 二代企业征信信息查询
	 *
	 * @author quxin
	 * @param map
	 * @return
	 * @throws CommonException
	 */
	public static CompanyReport2Bean queryCompanyReport(Map<String, String> map) throws CommonException {
		CompanyReport2Bean bean = new CompanyReport2Bean();
		StringBuffer hql = new StringBuffer("from CustPbocEntQuery t where 1=1 ");
		
		if(StringUtils.isNotEmpty((String)map.get("entName"))) {
			hql.append(" and t.entName like '%"+map.get("entName")+"%'");
		}
		
		if(StringUtils.isNotEmpty((String)map.get("entCertNum"))) {
			hql.append(" and t.entCertNum = '"+map.get("entCertNum")+"'");
		}
		if(StringUtils.isNotEmpty((String)map.get("entCertType"))) {
			hql.append(" and t.entCertType = '"+map.get("entCertType")+"'");
		}
		if(StringUtils.isNotEmpty((String)map.get("queryReason"))) {
			hql.append(" and t.queryReason = '"+map.get("queryReason")+"'");
		}
				
		bean.setSql(hql.toString());
		return bean;
	}
	
	
}