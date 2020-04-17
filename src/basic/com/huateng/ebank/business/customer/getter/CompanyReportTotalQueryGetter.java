package com.huateng.ebank.business.customer.getter;

import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;

import resource.bean.basic.IndAddr;
import resource.bean.basic.IndAssurance;
import resource.bean.basic.IndAssuranceDetail;
import resource.bean.basic.IndAward;
import resource.bean.basic.IndBreach;
import resource.bean.basic.IndCarTrade;
import resource.bean.basic.IndCrdDetail;
import resource.bean.basic.IndDetailInfo;
import resource.bean.basic.IndDisposal;
import resource.bean.basic.IndEnquiry;
import resource.bean.basic.IndEnquirySummary;
import resource.bean.basic.IndEnsure;
import resource.bean.basic.IndHousefundDeposit;
import resource.bean.basic.IndInfo;
import resource.bean.basic.IndInsDeposit;
import resource.bean.basic.IndInsPayment;
import resource.bean.basic.IndJob;
import resource.bean.basic.IndLonDetail;
import resource.bean.basic.IndNoCloseCc;
import resource.bean.basic.IndNoCloseLoan;
import resource.bean.basic.IndNoClosePdc;
import resource.bean.basic.IndOverdue;
import resource.bean.basic.IndOverdueDetail;
import resource.bean.basic.IndOweTax;
import resource.bean.basic.IndPbocScore;
import resource.bean.basic.IndPrompt;
import resource.bean.basic.IndPublicRecord;
import resource.bean.basic.IndSpecialNew;
import resource.bean.basic.IndStatement;
import resource.bean.basic.IndSuccour;
import resource.bean.basic.IndTelecomPayment;
import resource.bean.basic.TCorpInfoBasic;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CompanyReportTotalQueryGetter {
	public static List<Map> getTcorpInfoBasicByrptKey(String rptKey){
        try {
        	List<Map> list=new ArrayList<Map>();
            StringBuffer hql = new StringBuffer("select ii from TCorpInfoBasic ii where ii.rptKey='"+rptKey+"'");
            List<TCorpInfoBasic> listInfo= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
            if(null != listInfo && listInfo.size()>0){
            	for (int i = 0; i < listInfo.size(); i++) {
            		TCorpInfoBasic tcorpInfoBasic= listInfo.get(i);
            		   //企业信用报告
            		   Map<String, Object> map = new HashMap<String, Object>();
                           map.put("name", tcorpInfoBasic.getName());
                           map.put("address", tcorpInfoBasic.getAddress());
                           map.put("regOrganNo", tcorpInfoBasic.getRegOrganNo());
                           map.put("regOrganCode", tcorpInfoBasic.getRegOrganCode());
                           map.put("regDate", tcorpInfoBasic.getRegDate());
                           map.put("regEndDate", tcorpInfoBasic.getRegEndDate());
                           map.put("regStateTaxNo", tcorpInfoBasic.getRegStateTaxNo());
                           map.put("regLocalTaxNo", tcorpInfoBasic.getRegLocalTaxNo());
                           map.put("loancardId", tcorpInfoBasic.getLoancardId());
                           map.put("regOrganType", tcorpInfoBasic.getRegOrganType());
                           list.add(map);
				}
            }
            return list;
        }
        catch (Exception e){
            e.printStackTrace();
        }
		return null;
    }
	
}
