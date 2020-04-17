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

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PersonInfoTotalQueryGetter {
	public static List<Map> getIndInfoByRptId(String rptId){
        try {
        	List<Map> list=new ArrayList<Map>();
            StringBuffer hql = new StringBuffer("select ii from IndInfo ii where ii.rptId='"+rptId+"'");
            List<IndInfo> listInfo = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
            if(null != listInfo && listInfo.size()>0){
            	for (int i = 0; i < listInfo.size(); i++) {
            			IndInfo indInfo = listInfo.get(i);
            		   //个人信用报告
            		   Map<String, Object> map = new HashMap<String, Object>();
            		   map.put("flagReport", "f"); 
            		   map.put("flagCheck", "f"); 
            		   map.put("flagIdentity", "f");
            		   map.put("flagSpouse", "f");
            		   if(null != indInfo.getBirthday() || null != indInfo.getRptId() ||  null != indInfo.getEnquiryDate() ||
            				  null != indInfo.getReportDate() || null != indInfo.getNameQueried() || null != indInfo.getIdTypeQueried() ||
            				  null != indInfo.getIdNoQueried() || null != indInfo.getEnquiryName() || null != indInfo.getEnquiryReson()){
                           map.put("Rpt_id", indInfo.getRptId());
                           map.put("Enquiry_date", indInfo.getEnquiryDate());
                           map.put("Report_date", indInfo.getReportDate());
                           map.put("name_queried", replaceName(indInfo.getNameQueried()));
                           map.put("id_type_queried", parseIdType(indInfo.getIdTypeQueried()));
                           map.put("id_no_queried", replaceIdCrad(indInfo.getIdNoQueried()));
                           map.put("enquiry_name", indInfo.getEnquiryName());
                           map.put("enquiry_reason", indInfo.getEnquiryReson());
                           map.put("flagReport", "success"); 
            		   }
                    
                       //个人基本信息
                       //公安部居民身份证核查信息
                       if(null != indInfo.getVerifyResult()){
                    	   map.put("verify_result", indInfo.getVerifyResult());
                           map.put("issue_org", indInfo.getIssueOrg());
                           map.put("flagCheck", "success"); 
                       }
                       //身份信息
                       if(indInfo.getGender() != null || indInfo.getBirthday() != null || indInfo.getMarriage() != null ||
                    		   indInfo.getMobile() != null || indInfo.getPhoneCom() != null || indInfo.getPhoneLiv() != null ||
                    		   indInfo.getEducation() != null || indInfo.getDegree() != null || indInfo.getAddr() != null || indInfo.getHukouAddr() != null){
                    	   map.put("Gender", parseGender(indInfo.getGender()));
                           map.put("Birthday", "****-**-**");
                           map.put("Marriage", replaceAllInformation(indInfo.getMarriage()));
                           map.put("Mobile", replaceNum(indInfo.getMobile()));
                           map.put("Phone_com", replaceNum(indInfo.getPhoneCom()));
                           map.put("Phone_liv", replaceNum(indInfo.getPhoneLiv()));
                           map.put("Education", indInfo.getEducation());
                           map.put("Degree", indInfo.getDegree());
                           map.put("Addr", replaceInformation(indInfo.getAddr()));
                           map.put("Hukou_addr", replaceInformation(indInfo.getHukouAddr()));
                           map.put("flagIdentity", "success");
                       }
                    
                       if(null != indInfo.getSpouse() || null !=  indInfo.getSpouseIdType() || null != indInfo.getSpouseIdNumber()
                    		 || null != indInfo.getSpouseCom() || null != indInfo.getSpousePhone()){
                    	   map.put("spouse", replaceName(indInfo.getSpouse()));
                    	   map.put("Spouse_id_type", parseIdType(indInfo.getSpouseIdType()));
                    	   map.put("Spouse_id_number", replaceIdCrad(indInfo.getSpouseIdNumber()));
                    	   map.put("Spouse_com", replaceInformation(indInfo.getSpouseCom()));
                    	   map.put("Spouse_phone", replaceNum(indInfo.getSpousePhone()));
                    	   map.put("flagSpouse", "success");
                       }
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
	
	//居住信息
	public static List<Map> getIndAddrByRptId(String rptId){
        try {
        	List<Map> list=new ArrayList<Map>();
            StringBuffer hql = new StringBuffer("select ii from IndAddr ii where ii.rptId='"+rptId+"'");
            List<IndAddr> listIndAddr = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
            if(null != listIndAddr && listIndAddr.size()>0){
            	for (int i = 0; i < listIndAddr.size(); i++) {
            		IndAddr indAddr = listIndAddr.get(i);
            		   //个人信用报告
            		   Map<String, Object> map = new HashMap<String, Object>();
            		   if(null != indAddr.getAddress() || null != indAddr.getStatus() ||  null != indAddr.getGetDate()){
            			   map.put("no", i+1);
            			   map.put("Address", replaceInformation(indAddr.getAddress()));
                           map.put("status", indAddr.getStatus());
                           map.put("get_date", TimeSubDate(indAddr.getGetDate()));
                           map.put("flagLive", "success"); 
            		   }
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
	
	//职业信息  
	public static List<Map> getIndJobByRptId(String rptId){
        try {
        	List<Map> list=new ArrayList<Map>();
            StringBuffer hql = new StringBuffer("select ii from IndJob ii where ii.rptId='"+rptId+"' Order by no" );
            
            List<IndJob> listIndJob = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
            if(null != listIndJob && listIndJob.size()>0){
            	for (int i = 0; i < listIndJob.size(); i++) {
            		IndJob indJob = listIndJob.get(i);
            		   //个人信用报告
            		   Map<String, Object> map = new HashMap<String, Object>();
            		   if(null != indJob.getNo() || null != indJob.getName() ||  null != indJob.getAddr() ||
            				   null != indJob.getProfession() || null != indJob.getIndustry() ||
            				   null != indJob.getTitle() || null != indJob.getTitleTec() || 
            				   null != indJob.getStartdate() || null != indJob.getGetdate()){
            			   map.put("No", indJob.getNo());
                           map.put("name", replaceInformation(indJob.getName()));
                           map.put("addr", replaceInformation(indJob.getAddr()));
                           map.put("Profession", replaceInformation(indJob.getProfession()));
                           map.put("Industry", replaceInformation(indJob.getIndustry()));
                           map.put("Title", replaceInformation(indJob.getTitle()));
                           map.put("Title_tec", indJob.getTitleTec());
                           map.put("Startdate", TimeSubYear(indJob.getStartdate()));
                           map.put("getdate", TimeSubDate(indJob.getGetdate()));
                           
                           map.put("flagProfession", "success"); 
                           list.add(map);

            		   }

				}
            }
            return list;
        }
        catch (Exception e){
            e.printStackTrace();
        }
		return null;
    }
	
	//信息概要 
	public static List<Map> getIndPromptRptId(String rptId){
        try {
        	List<Map> list=new ArrayList<Map>();
            StringBuffer hql = new StringBuffer("select ii from IndPrompt ii where ii.rptId='"+rptId+"'" );
            
            List<IndPrompt> listIndPrompt= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
            if(null != listIndPrompt && listIndPrompt.size()>0){
            	for (int i = 0; i < listIndPrompt.size(); i++) {
            		IndPrompt indPrompt = listIndPrompt.get(i);
            		   //个人信用报告
            		   Map<String, Object> map = new HashMap<String, Object>();
            		   if(null != indPrompt.getPersonHouseLoan() || null != indPrompt.getPersonBizHouseLoan() ||  null != indPrompt.getOtherLoan() ||
            				   null != indPrompt.getFirstLoanIssueDate() || null !=  indPrompt.getCrdAccount() ||
            				   null != indPrompt.getFirstCcIssueDate() || null != indPrompt.getPdcAccount() || 
            				   null != indPrompt.getFirstPdcIssueDate() || null != indPrompt.getDissentCount()){
            			   if(null != indPrompt.getPersonHouseLoan()){
            				   map.put("person_house_loan", indPrompt.getPersonHouseLoan());
            			   }else {
            				   map.put("person_house_loan", ""); 
            			   }
            			   if(null !=indPrompt.getPersonBizHouseLoan()){
            				   map.put("person_biz_house_loan", indPrompt.getPersonBizHouseLoan());
            			   }else {
            				   map.put("person_biz_house_loan", ""); 
            			   }
            			   if(null !=  indPrompt.getOtherLoan()){
            				   map.put("other_loan", indPrompt.getOtherLoan());
            			   }else {
            				   map.put("other_loan", ""); 
            			   }
            			   if(null != indPrompt.getFirstLoanIssueDate()){
            				   map.put("first_loan_issue_date", TimeSubMon(indPrompt.getFirstLoanIssueDate()));
            			   }else {
            				   map.put("first_loan_issue_date", "--"); 
            			   }
            			   if(null != indPrompt.getCrdAccount()){
            				   map.put("crd_account", indPrompt.getCrdAccount());
            			   }else {
            				   map.put("crd_account", ""); 
            			   }
            			   if(null !=indPrompt.getFirstCcIssueDate()){
            				   map.put("first_cc_issue_date", TimeSubMon(indPrompt.getFirstCcIssueDate()));
            			   }else {
            				   map.put("first_cc_issue_date", "--"); 
            			   }
            			   if(null != indPrompt.getPdcAccount()){
            				   map.put("pdc_account", indPrompt.getPdcAccount());
            			   }else {
            				   map.put("pdc_account", ""); 
            			   }
            			   if(null != indPrompt.getFirstPdcIssueDate()){
            				   map.put("first_pdc_issue_date", TimeSubMon(indPrompt.getFirstPdcIssueDate()));
            			   }else {
            				   map.put("first_pdc_issue_date", "--"); 
            			   }
            			   if(null !=  indPrompt.getDissentCount()){
            				   map.put("dissent_count", indPrompt.getDissentCount());
            			   }else {
            				   map.put("dissent_count", ""); 
            			   }
            			   if(null != indPrompt.getSelfStatementCount()){
            				   map.put("self_statement_count", indPrompt.getSelfStatementCount());
            			   }else {
            				   map.put("self_statement_count", ""); 
            			   }
                           
                           map.put("flagIndPrompt", "success"); 
            		   }
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
	
	//中征信“信用1000”评分
	//信息概要 
		public static List<Map> getindPbocScoreRptId(String rptId){
	        try {
	        	List<Map> list=new ArrayList<Map>();
	            StringBuffer hql = new StringBuffer("select ii from IndPbocScore ii where ii.rptId='"+rptId+"'" );
	            
	            List<IndPbocScore> listIndPbocScore= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
	            if(null != listIndPbocScore && listIndPbocScore.size()>0){
	            	for (int i = 0; i < listIndPbocScore.size(); i++) {
	            		IndPbocScore indPbocScore = listIndPbocScore.get(i);
	            		   //个人信用报告
	            		   Map<String, Object> map = new HashMap<String, Object>();
	            		   if(null != indPbocScore.getScore() || null != indPbocScore.getScoreDate() ){
	            			   map.put("score_date", TimeSubDate(indPbocScore.getScoreDate()));
	                           map.put("score_description", indPbocScore.getScoreDescription());
	                           map.put("pboc_score", indPbocScore.getPbocScore());
	                           map.put("score_percentile", indPbocScore.getScorePercentile());
	                           
	                           map.put("flagIndPbocScore", "success"); 
		                       list.add(map);

	            		   }
					}
	            	
	            }
	            return list;
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
			return null;
	    }
		
		
		
		// 逾期及违约信息概要
		
		public static List<Map> getIndBreachRptId(String rptId){
	        try {
	        	List<Map> list=new ArrayList<Map>();
	            StringBuffer hql = new StringBuffer("select ii from IndBreach ii where ii.rptId='"+rptId+"'" );
	            
	            List<IndBreach> listIndBreach= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
	            if(null != listIndBreach && listIndBreach.size()>0){
	            	for (int i = 0; i < listIndBreach.size(); i++) {
	            		IndBreach indBreach = listIndBreach.get(i);
	            		   Map<String, Object> map = new HashMap<String, Object>();
	            		   //逾期及违约信息概要
	            		   if(null != indBreach.getBadDebtCount() || null != indBreach.getBadDebtAmount() ||
	            				   null != indBreach.getDisposalCount() || null != indBreach.getDisposalAmount() ||
	            				   null != indBreach.getEnsurePayCount() || null != indBreach.getEnsurePayAmount()){
	            			   map.put("bad_debt_count", indBreach.getBadDebtCount());
	                           map.put("bad_debt_amount", numToCurrency(indBreach.getBadDebtAmount()));
	                           map.put("disposal_count", indBreach.getDisposalCount());
	                           map.put("disposal_amount", numToCurrency(indBreach.getDisposalAmount()));
	                           map.put("ensure_pay_count", indBreach.getEnsurePayCount());
	                           map.put("ensure_pay_amount", numToCurrency(indBreach.getEnsurePayAmount()));
	                           map.put("flagindBreach", "success"); 
		                       list.add(map);

	            		   }
	            		  
					}
	            }
	            return list;
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
			return null;
	    }
		
		
		   //逾期（透支）信息汇总
		   public static List<Map> getIndOverdueRptId(String rptId){
		        try {
		        	List<Map> list=new ArrayList<Map>();
		            StringBuffer hql = new StringBuffer("select ii from IndOverdue ii where ii.rptId='"+rptId+"'" );
		            
		            List<IndOverdue> listIndOverdue= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
		            if(null != listIndOverdue && listIndOverdue.size()>0){
		            	for (int i = 0; i < listIndOverdue.size(); i++) {
		            		IndOverdue indOverdue = listIndOverdue.get(i);
		            		   Map<String, Object> map = new HashMap<String, Object>();
		            		   //逾期（透支）信息汇总
		            		   if(null != indOverdue.getLoanCount() || null != indOverdue.getLoanMonthCount() ||
		            				 null !=indOverdue.getLoanMaxAmount() || null !=  indOverdue.getLoanMaxMonth() ||
		            				 null != indOverdue.getCcCount() ||  null != indOverdue.getCcMonthCount() ||
		            				 null != indOverdue.getCcMaxAmount() || null != indOverdue.getCcMaxMonth() ||
		            				 null != indOverdue.getPdcCount() || null != indOverdue.getPdcMonthCount() ||
		            				 null != indOverdue.getPcdMaxAmount() ||  null != indOverdue.getPdcMaxMonth()){
		            			   map.put("loan_count", indOverdue.getLoanCount());
		            			   map.put("loan_month_count", indOverdue.getLoanMonthCount());
		            			   map.put("loan_max_amount", numToCurrency(indOverdue.getLoanMaxAmount()));
		            			   map.put("loan_max_month", indOverdue.getLoanMaxMonth());
		            			   map.put("cc_count", indOverdue.getCcCount());
		            			   map.put("cc_month_count", indOverdue.getCcMonthCount());
		            			   map.put("cc_max_amount", numToCurrency(indOverdue.getCcMaxAmount()));
		            			   map.put("cc_max_month", indOverdue.getCcMaxMonth());
		            			   map.put("pdc_count", indOverdue.getPdcCount());
		            			   map.put("pdc_month_count", indOverdue.getPdcMonthCount());
		            			   map.put("pcd_max_amount", numToCurrency(indOverdue.getPcdMaxAmount()));
		            			   map.put("pdc_max_month", indOverdue.getPdcMaxMonth());
		            			   map.put("flagindOverdue", "success"); 
			                       list.add(map);

		            		   }
		            		  
						}
		            }
		            return list;
		        }
		        catch (Exception e){
		            e.printStackTrace();
		        }
				return null;
		    }
		   
		   //授信及负债信息概要
		   public static List<Map> getIndNoCloseLoanByRptId(String rptId){
		        try {
		        	List<Map> list=new ArrayList<Map>();
		            StringBuffer hql = new StringBuffer("select ii from IndNoCloseLoan ii where ii.rptId='"+rptId+"'" );
		            
		            List<IndNoCloseLoan> listIndNoCloseLoan= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
		            if(null != listIndNoCloseLoan && listIndNoCloseLoan.size()>0){
		            	for (int i = 0; i < listIndNoCloseLoan.size(); i++) {
		            		IndNoCloseLoan indNoCloseLoan = listIndNoCloseLoan.get(i);
		            		
		            		   Map<String, Object> map = new HashMap<String, Object>();
		            		   //逾期（透支）信息汇总
		            		   if(null != indNoCloseLoan.getLawOrgCount() || null != indNoCloseLoan.getOrgCount() ||
		            				 null !=indNoCloseLoan.getCount() || null !=  indNoCloseLoan.getTotalAmount() ||
		            				 null != indNoCloseLoan.getTotalBalance() ||  null != indNoCloseLoan.getAvgMonthPayL6m() ){
		            			   map.put("law_org_count", indNoCloseLoan.getLawOrgCount());
		            			   map.put("org_count", indNoCloseLoan.getOrgCount());
		            			   map.put("count", indNoCloseLoan.getCount());
		            			   map.put("total_amount", numToCurrency(indNoCloseLoan.getTotalAmount()));
		            			   map.put("total_balance", numToCurrency(indNoCloseLoan.getTotalBalance()));
		            			   map.put("avg_month_pay_l6m", numToCurrency(indNoCloseLoan.getAvgMonthPayL6m()));
		            			   map.put("flagindNoCloseLoan", "success"); 
			                       list.add(map);
		            		   }
						}
		            }
		            return list;
		        }
		        catch (Exception e){
		            e.printStackTrace();
		        }
				return null;
		    }
		   
		   //未销户贷记卡信息汇总
		   //授信及负债信息概要
		   public static List<Map> getIndNoCloseCcByRptId(String rptId){
		        try {
		        	List<Map> list=new ArrayList<Map>();
		            StringBuffer hql = new StringBuffer("select ii from IndNoCloseCc ii where ii.rptId='"+rptId+"'" );
		            
		            List<IndNoCloseCc> listIndNoCloseCc= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
		            if(null != listIndNoCloseCc && listIndNoCloseCc.size()>0){
		            	for (int i = 0; i < listIndNoCloseCc.size(); i++) {
		            		IndNoCloseCc indNoCloseCc = listIndNoCloseCc.get(i);
		            		
		            		   Map<String, Object> map = new HashMap<String, Object>();
		            		   //逾期（透支）信息汇总
		            		   if(null != indNoCloseCc.getLawOrgCount() || null != indNoCloseCc.getOrgCount() ||
		            				 null !=indNoCloseCc.getCount() || null !=  indNoCloseCc.getTotalCreditAmount() ||
		            				 null != indNoCloseCc.getMaxCreditAmount() ||  null != indNoCloseCc.getMinCreditAmount() ||
		            				 null != indNoCloseCc.getTotalUsed() || null != indNoCloseCc.getAvgUsedL6m()){
		            			   map.put("law_org_count", indNoCloseCc.getLawOrgCount());
		            			   map.put("org_count", indNoCloseCc.getOrgCount());
		            			   map.put("count", indNoCloseCc.getCount());
		            			   map.put("total_credit_amount", numToCurrency(indNoCloseCc.getTotalCreditAmount()));
		            			   map.put("max_credit_amount", numToCurrency(indNoCloseCc.getMaxCreditAmount()));
		            			   map.put("min_credit_amount", numToCurrency(indNoCloseCc.getMinCreditAmount()));
		            			   map.put("total_used", numToCurrency(indNoCloseCc.getTotalUsed()));
		            			   map.put("avg_used_l6m", numToCurrency(indNoCloseCc.getAvgUsedL6m()));
		            			   map.put("flagindNoCloseCc", "success"); 
			                       list.add(map);
		            		   }
						}
		            }
		            return list;
		        }
		        catch (Exception e){
		            e.printStackTrace();
		        }
				return null;
		    }
		   
		   //未销户准贷记卡信息汇总
		   public static List<Map> getIndNoClosePdcByRptId(String rptId){
		        try {
		        	List<Map> list=new ArrayList<Map>();
		            StringBuffer hql = new StringBuffer("select ii from IndNoClosePdc ii where ii.rptId='"+rptId+"'" );
		            
		            List<IndNoClosePdc> listIndNoClosePdc= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
		            if(null != listIndNoClosePdc && listIndNoClosePdc.size()>0){
		            	for (int i = 0; i < listIndNoClosePdc.size(); i++) {
		            		IndNoClosePdc indNoClosePdc = listIndNoClosePdc.get(i);
		            		
		            		   Map<String, Object> map = new HashMap<String, Object>();
		            		   //逾期（透支）信息汇总
		            		   if(null != indNoClosePdc.getLawOrgCount() || null != indNoClosePdc.getOrgCount() ||
		            				 null !=indNoClosePdc.getCount() || null !=  indNoClosePdc.getTotalCreditAmount() ||
		            				 null != indNoClosePdc.getMaxCreditAmount() ||  null != indNoClosePdc.getMinCreditAmount() ||
		            				 null != indNoClosePdc.getTotalOverdraw() || null != indNoClosePdc.getAvgOverdrawL6m()){
		            			   map.put("law_org_count", indNoClosePdc.getLawOrgCount());
		            			   map.put("org_count", indNoClosePdc.getOrgCount());
		            			   map.put("count", indNoClosePdc.getCount());
		            			   map.put("total_credit_amount", numToCurrency(indNoClosePdc.getTotalCreditAmount()));
		            			   map.put("max_credit_amount", numToCurrency(indNoClosePdc.getMaxCreditAmount()));
		            			   map.put("min_credit_amount", numToCurrency(indNoClosePdc.getMinCreditAmount()));
		            			   map.put("total_overdraw", numToCurrency(indNoClosePdc.getTotalOverdraw()));
		            			   map.put("avg_overdraw_l6m", numToCurrency(indNoClosePdc.getAvgOverdrawL6m()));
		            			   map.put("flagindNoClosePdc", "success"); 
			                       list.add(map);
		            		   }
						}
		            }
		            return list;
		        }
		        catch (Exception e){
		            e.printStackTrace();
		        }
				return null;
		    }
		   
		   
		   //对外担保信息汇总ind_assurance
		   public static List<Map> getIndAssuranceByRptId(String rptId){
		        try {
		        	List<Map> list=new ArrayList<Map>();
		            StringBuffer hql = new StringBuffer("select ii from IndAssurance ii where ii.rptId='"+rptId+"'" );
		            
		            List<IndAssurance> listIndAssurance= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
		            if(null != listIndAssurance && listIndAssurance.size()>0){
		            	for (int i = 0; i < listIndAssurance.size(); i++) {
		            		IndAssurance indAssurance = listIndAssurance.get(i);
		            		
		            		   Map<String, Object> map = new HashMap<String, Object>();
		            		   //逾期（透支）信息汇总
		            		   if(null !=indAssurance.getCount() || null != indAssurance.getBankAssurance() ||
		            				 null !=indAssurance.getBalance() ){
		            			   map.put("count", indAssurance.getCount());
		            			   map.put("bank_assurance", indAssurance.getBankAssurance());
		            			   map.put("balance", numToCurrency(indAssurance.getBalance()));
		            			   map.put("flagindAssurance", "success"); 
			                       list.add(map);
		            		   }
						}
		            	
		            }
		            return list;
		        }
		        catch (Exception e){
		            e.printStackTrace();
		        }
				return null;
		    }
		   
		   
		   //信贷交易信息明细
		   //资产处置信息
		   
		   public static List<Map> getIndDisposalByRptId(String rptId){
		        try {
		        	List<Map> list=new ArrayList<Map>();
		            StringBuffer hql = new StringBuffer("select ii from IndDisposal ii where ii.rptId='"+rptId+"'" );
		            
		            List<IndDisposal> listIndDisposal= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
		            if(null != listIndDisposal && listIndDisposal.size()>0){
		            	for (int i = 0; i < listIndDisposal.size(); i++) {
		            		IndDisposal indDisposal = listIndDisposal.get(i);
		            		
		            		   Map<String, Object> map = new HashMap<String, Object>();
		            		   //逾期（透支）信息汇总
		            		   if(null != indDisposal.getNo() || null != indDisposal.getManagerOrg() ||
		            				 null !=indDisposal.getExpropriateDate() || null !=  indDisposal.getExpropriateAmount() ||
		            				 null != indDisposal.getLastPayDate() ||  null != indDisposal.getBalance()){
		            			   map.put("no", indDisposal.getNo());
		            			   map.put("manager_org", indDisposal.getManagerOrg());
		            			   map.put("expropriate_date", TimeSubDate(indDisposal.getExpropriateDate()));
		            			   map.put("expropriate_amount", numToCurrency(indDisposal.getExpropriateAmount()));
		            			   map.put("last_pay_date", TimeSubDate(indDisposal.getLastPayDate()));
		            			   map.put("balance", numToCurrency(indDisposal.getBalance()));
		            			   map.put("flagindDisposal", "success"); 
			                       list.add(map);
		            		   }
						}
		            	
		            }
		            return list;
		        }
		        catch (Exception e){
		            e.printStackTrace();
		        }
				return null;
		    }
		   
		   
		   //保证人代偿信息
		   public static List<Map> getIndEnsureByRptId(String rptId){
		        try {
		        	List<Map> list=new ArrayList<Map>();
		            StringBuffer hql = new StringBuffer("select ii from IndEnsure ii where ii.rptId='"+rptId+"'" );
		            
		            List<IndEnsure> listIndEnsure= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
		            if(null != listIndEnsure && listIndEnsure.size()>0){
		            	for (int i = 0; i < listIndEnsure.size(); i++) {
		            		IndEnsure indEnsure = listIndEnsure.get(i);
		            		
		            		   Map<String, Object> map = new HashMap<String, Object>();
		            		   //逾期（透支）信息汇总
		            		   if(null != indEnsure.getNo() || null != indEnsure.getEnsureOrg() ||
		            				 null !=indEnsure.getLastEnsurePayDate() || null !=  indEnsure.getTotalPayAmount() ||
		            				 null != indEnsure.getLastPayDate() ||  null != indEnsure.getBalance()){
		            			   map.put("no", indEnsure.getNo());
		            			   map.put("ensure_org", indEnsure.getEnsureOrg());
		            			   map.put("last_ensure_pay_date", TimeSubDate(indEnsure.getLastEnsurePayDate()));
		            			   map.put("total_pay_amount", numToCurrency(indEnsure.getTotalPayAmount()));
		            			   map.put("last_pay_date", TimeSubDate(indEnsure.getLastPayDate()));
		            			   map.put("balance", numToCurrency(indEnsure.getBalance()));
		            			   map.put("flagindEnsure", "success"); 
			                       list.add(map);
		            		   }
						}
		            	
		            }
		            return list;
		        }
		        catch (Exception e){
		            e.printStackTrace();
		        }
				return null;
		    }
		   //贷款
		   public static List<Map> getIndLonDetailorInfoByRptId(String rptId){
		        try {
		        	List<Map> list=new ArrayList<Map>();
		        	StringBuffer hql = new StringBuffer("select ii from IndLonDetail ii where ii.rptId='"+rptId+"'  order by no" );
		            List<IndLonDetail> listIndLonDetail= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
		            if(null != listIndLonDetail && listIndLonDetail.size()>0){
		            	for (int i = 0; i < listIndLonDetail.size(); i++) {
		            		Map<String, Object> map = new HashMap<String, Object>();
		            		String acc_status=listIndLonDetail.get(i).getAccStatus();
		            		map.put("Acc_status", listIndLonDetail.get(i).getAccStatus());
            				map.put("Overdue_amount", numToCurrency(listIndLonDetail.get(i).getOverdueAmount()));
			            	map.put("Balance", numToCurrency(listIndLonDetail.get(i).getBalance()));
			            	map.put("Left_month", listIndLonDetail.get(i).getLeftMonth());
			            	map.put("Pay_month", numToCurrency((float)listIndLonDetail.get(i).getPayMonth()));
			            	map.put("Pay_real", numToCurrency(listIndLonDetail.get(i).getPayReal()));
			            	map.put("Recent_pay_date", TimeSubDate(listIndLonDetail.get(i).getRecentPayDate()));
			            	map.put("Overdue_count",listIndLonDetail.get(i).getOverdueCount());
				            map.put("Over31",numToCurrency(listIndLonDetail.get(i).getOver31()));
				            map.put("Over61", numToCurrency(listIndLonDetail.get(i).getOver61()));
				            map.put("Over91", numToCurrency(listIndLonDetail.get(i).getOver91()));
				            map.put("Over180", numToCurrency(listIndLonDetail.get(i).getOver180()));
				            map.put("month_count",listIndLonDetail.get(i).getMonthCount());
				            map.put("amount", numToCurrency(listIndLonDetail.get(i).getAmount()));
				            map.put("No", listIndLonDetail.get(i).getNo());
				            String issurance_date = TimeSubDate(listIndLonDetail.get(i).getIssurenceDate());
				            String issurance_ym=issurance_date.substring(0,7);
	            			String issurance_ymr=issurance_ym.substring(0, 4)+ "年" + issurance_ym.substring(5, 7)+"月";
				            List list24=new ArrayList();
				            for (int j = 0; j < 24; j++) {
				            	String month24value=listIndLonDetail.get(i).getMonth24().substring(j, j+1);
				            	list24.add(month24value);
							}
				            map.put("month24", list24);
				            
				            String getDate=listIndLonDetail.get(i).getYearmonth().toString();
				            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				            Calendar dar = Calendar.getInstance();
							dar.setTime(sdf.parse(getDate.substring(0,10)));
							dar.add(Calendar.MONTH, -23);
							Date yearmonthBefore2year = dar.getTime();
							String yearmonthBefore2yearString = sdf.format(yearmonthBefore2year);
				            String endyear=getDate.substring(0,4);
							String month=getDate.substring(5,7);
				            String StratyearMonth=yearmonthBefore2yearString.substring(0,4)+"年"+yearmonthBefore2yearString.substring(5,7)+"月";
				            String EndyearMonth=endyear+"年"+month+"月";
				            String yearMonth=StratyearMonth+"-"+EndyearMonth+"的还款记录";
							dar.add(Calendar.MONTH, -1);
							Date yearmonth2year = dar.getTime();
							String yearmonth2yearString = sdf.format(yearmonth2year);
				            String yqendyear=yearmonth2yearString.substring(0,4);
							String yqendmonth=yearmonth2yearString.substring(5,7);
				            String yqendyearMonth=yqendyear+"年"+yqendmonth+"月";
				            dar.add(Calendar.MONTH, -35);
							Date startyearmonth2year = dar.getTime();
							String startyearmonth2yearString = sdf.format(startyearmonth2year);
				            String yqstartyearMonth=startyearmonth2yearString.substring(0,4)+"年"+startyearmonth2yearString.substring(5,7)+"月";
				            int result = startyearmonth2yearString.compareTo(issurance_ym);
				            String yqyearMonth = "";
				            if(acc_status.equals("结清") ){
					            if (result >= 0){
					            	yqyearMonth=yqstartyearMonth+"-"+EndyearMonth+"的逾期记录";
					            }
					            if (result<0)
					            {
					            	yqyearMonth=issurance_ymr+"-"+EndyearMonth+"的逾期记录";
					            }
				            }
				            else{
				            	 if (result >= 0){
						            	yqyearMonth=yqstartyearMonth+"-"+yqendyearMonth+"的逾期记录";
						            }
						            if (result<0)
						            {
						            	yqyearMonth=issurance_ymr+"-"+yqendyearMonth+"的逾期记录";
						            }
				            }
							map.put("yqyearMonth", yqyearMonth);
				            map.put("yearMonth", yearMonth);
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
		   //贷款 24month
		   public static List<Map> getIndLonDetailorInfoByRptId24(String rptId,int no){
		        try {
		        	List<Map> list24=new ArrayList();
		        	StringBuffer hql = new StringBuffer("select ii from IndLonDetail ii where ii.rptId='"+rptId+"' and ii.no='"+no+"' order by no" );
		            List<IndLonDetail> listIndLonDetail= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
		            if(null != listIndLonDetail && listIndLonDetail.size()>0){
		        	
		            for (int j = 0; j < 24; j++) {
	            		Map<String, Object> map = new HashMap<String, Object>();
		            	String month24value=listIndLonDetail.get(0).getMonth24().substring(j, j+1);
		            	map.put("month24value",month24value);
		            	list24.add(map);
						}

		            }
		            return list24;

		        }
		         
		        catch (Exception e){
		            e.printStackTrace();
		        }
				return null;
		    }
		   
		 //贷款2
		   public static List<Map> getIndLonDetailorInfoTwoByRptId(String rptId,int no){
		        try {
				        	List<Map> list=new ArrayList<Map>();
				            Map<String, Object> map = new HashMap<String, Object>();
				            StringBuffer hql1 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'LOAN' and code = 'DESC'" );
				            List<IndDetailInfo> listIndDetailInfoOne= ROOTDAOUtils.getROOTDAO().queryByCondition(hql1.toString());
				            if(null != listIndDetailInfoOne && listIndDetailInfoOne.size()>0){
					            	map.put("valueDesc", listIndDetailInfoOne.get(0).getValue());
					            	map.put("flagDesc", "success");
				            }else{
				            	map.put("flagDesc", "error");
				            }
		            		StringBuffer hql3 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'LOAN' and code = 'L5CLASS'" );
				            List<IndDetailInfo> listIndDetailInfoThree= ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
				            if(null != listIndDetailInfoThree && listIndDetailInfoThree.size()>0){
					            	map.put("valueClass", listIndDetailInfoThree.get(0).getValue());
				            }
				            StringBuffer hql2 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'LOAN' and code = 'PAYDAY'" );
				            List<IndDetailInfo> listIndDetailInfoTwo= ROOTDAOUtils.getROOTDAO().queryByCondition(hql2.toString());
				            if(null != listIndDetailInfoTwo && listIndDetailInfoTwo.size()>0){
					            	map.put("valuePayday", listIndDetailInfoTwo.get(0).getValue());
					            	map.put("flagPayday", "success");
				            }else{
				            	map.put("flagPayday", "error");
				            }
				            StringBuffer hql4 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'LOAN' and code = 'ORGDESC' order by get_date desc" );
				            List<IndDetailInfo> listIndDetailInfoOrgdesc= ROOTDAOUtils.getROOTDAO().queryByCondition(hql4.toString());
				            if(null != listIndDetailInfoOrgdesc && listIndDetailInfoOrgdesc.size()>0){
				            	map.put("valueOrgdesc", listIndDetailInfoOrgdesc.get(0).getValue());
				            	if(null != listIndDetailInfoOrgdesc.get(0).getDate()){
				            		map.put("dateOrgdesc", TimeSubDate(listIndDetailInfoOrgdesc.get(0).getDate()));
				            	}else{
				            		map.put("dateOrgdesc", "--");
				            	}
				            	map.put("flagOrgdesc", "success");
				            }else{
				            	map.put("flagOrgdesc", "error");
				            }
				            StringBuffer hql5 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'LOAN' and code = 'SELFSTATEMENT' order by get_date desc " );
				            List<IndDetailInfo> listIndDetailInfoSelfStatement= ROOTDAOUtils.getROOTDAO().queryByCondition(hql5.toString());
				            if(null != listIndDetailInfoSelfStatement && listIndDetailInfoSelfStatement.size()>0){
				            	map.put("valueSelfStatement", listIndDetailInfoSelfStatement.get(0).getValue());
				            	if(null != listIndDetailInfoSelfStatement.get(0).getDate()){
				            		map.put("dateSelfStatement", TimeSubDate(listIndDetailInfoSelfStatement.get(0).getDate()));
				            	}else{
				            		map.put("dateSelfStatement", "--");
				            	}
				            	map.put("flagSelfStatement", "success");
				            }else{
				            	map.put("flagSelfStatement", "error");
				            }
				            StringBuffer hql6 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'LOAN' and code = 'DISSENT' order by get_date desc " );
				            List<IndDetailInfo> listIndDetailInfoDissent= ROOTDAOUtils.getROOTDAO().queryByCondition(hql6.toString());
				            if(null != listIndDetailInfoDissent && listIndDetailInfoDissent.size()>0){
				            	map.put("valueDissent", listIndDetailInfoDissent.get(0).getValue());
				            	map.put("dateDissent", listIndDetailInfoDissent.get(0).getDate());
				            	if(null != listIndDetailInfoDissent.get(0).getDate()){
				            		map.put("dateDissent", TimeSubDate(listIndDetailInfoSelfStatement.get(0).getDate()));
				            	}else{
				            		map.put("dateDissent", "--");
				            	}
				            	map.put("flagDissent", "success");
				            }else{
				            	map.put("flagDissent", "error");
				            }
				            list.add(map);
				            return list;
		        }
		        catch (Exception e){
		            e.printStackTrace();
		        }
				return null;
		    }
		   //贷款
		   public static List<Map> getIndOverdueDetailByRptId(String rptId,int no){
		        try {
		        	List<Map> list=new ArrayList<Map>();
				            StringBuffer hql1 = new StringBuffer("select ii from IndOverdueDetail ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"'  and type = 'LOAN' order by month desc" );
				            List<IndOverdueDetail> listIndOverdueDetail= ROOTDAOUtils.getROOTDAO().queryByCondition(hql1.toString());
				            if(null != listIndOverdueDetail && listIndOverdueDetail.size()>0){
				            	for (int i = 0; i < listIndOverdueDetail.size(); i++) {
						            Map<String, Object> map = new HashMap<String, Object>();
				            		map.put("month", TimeSubMon(listIndOverdueDetail.get(i).getMonth()));
					            	map.put("month_count", listIndOverdueDetail.get(i).getMonthCount());
					            	map.put("amount", numToCurrency(listIndOverdueDetail.get(i).getAmount()));
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
		   
		   
		   //贷款
		   public static List<Map> getIndSpecialNewByRptId(String rptId,int no){
		        try {
            		List<Map> list=new ArrayList<Map>();
				            StringBuffer hql1 = new StringBuffer("select ii from IndSpecialNew ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and  acc_type = 'LOAN'" );
				            List<IndSpecialNew> listIndSpecialNew= ROOTDAOUtils.getROOTDAO().queryByCondition(hql1.toString());
				            if(null != listIndSpecialNew && listIndSpecialNew.size()>0){
					            Map<String, Object> map = new HashMap<String, Object>();
					            	map.put("type", listIndSpecialNew.get(0).getType());
					            	map.put("date", TimeSubDate(listIndSpecialNew.get(0).getDate()));
					            	map.put("change_month", listIndSpecialNew.get(0).getChangeMonth());
					            	map.put("amount", numToCurrency(listIndSpecialNew.get(0).getAmount()));
					            	map.put("details", listIndSpecialNew.get(0).getDetails());
					            	list.add(map);
				            }
				            return list;
		        }
		        catch (Exception e){
		            e.printStackTrace();
		        }
				return null;
		    }
		   
		 //贷记卡 准贷记卡 24month
		   public static List<Map> getIndCrdDetailorInfoByRptId24(String rptId,int no,String CardType){
		        try {
		        	List<Map> list24=new ArrayList();
		        	StringBuffer hql = new StringBuffer("select ii from IndCrdDetail ii where ii.rptId='"+rptId+"' and ii.no='"+no+"' and Card_type = '"+CardType+"' order by no" );
		            List<IndCrdDetail> listIndCrdDetail= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
		            if(null != listIndCrdDetail && listIndCrdDetail.size()>0){
		        	
		            for (int j = 0; j < 24; j++) {
	            		Map<String, Object> map = new HashMap<String, Object>();
		            	String month24value=listIndCrdDetail.get(0).getMonth24().substring(j, j+1);
		            	map.put("month24value",month24value);
		            	list24.add(map);
						}

		            }
		            return list24;

		        }
		         
		        catch (Exception e){
		            e.printStackTrace();
		        }
				return null;
		    }
		   
		   
		   
		   //贷记卡
			public static List<Map> getIndCrdDetailByRptId(String rptId){
		        try {
		        	List<Map> list=new ArrayList<Map>();
		            StringBuffer hql = new StringBuffer("select ii from IndCrdDetail ii where ii.rptId='"+rptId+"' and Card_type = '贷记卡' order by no");
		            List<IndCrdDetail> listIndCrdDetail = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
		            if(null != listIndCrdDetail && listIndCrdDetail.size()>0){
		            	for (int i = 0; i < listIndCrdDetail.size(); i++) {
		            		   //个人信用报告
		            		   Map<String, Object> map = new HashMap<String, Object>();
		            			   map.put("No", listIndCrdDetail.get(i).getNo());
		            			   String acc_status=listIndCrdDetail.get(i).getAccStatus();
		            			   String dateofcreate = TimeSubDate(listIndCrdDetail.get(i).getDateofcreate());
						           String dateofcreate_ym=dateofcreate.substring(0,7);
		            			   String dateofcreate_ymr=dateofcreate_ym.substring(0, 4)+ "年" + dateofcreate_ym.substring(5, 7)+"月";
		            			   map.put("Acc_status", listIndCrdDetail.get(i).getAccStatus());
		                           map.put("Overdue", numToCurrency(listIndCrdDetail.get(i).getOverdue()));
		                           map.put("Max_debit", numToCurrency(listIndCrdDetail.get(i).getMaxDebit()));
		                           map.put("Pay_month", numToCurrency(listIndCrdDetail.get(i).getPayMonth()));
		                           map.put("Pay_real", numToCurrency(listIndCrdDetail.get(i).getPayReal()));
		                           map.put("Recent_date", TimeSubDate(listIndCrdDetail.get(i).getRecentDate()));
		                           map.put("Over_count", listIndCrdDetail.get(i).getOverCount());
		                           map.put("over_amount", numToCurrency(listIndCrdDetail.get(i).getOverAmount()));
		                           List list1=new ArrayList();
						            for (int j = 0; j < 24; j++) {
						            	String month24=listIndCrdDetail.get(i).getMonth24().substring(j, j+1);
						            	list1.add(month24);
									}
						            map.put("month24", list1);
						            String getDate=listIndCrdDetail.get(i).getYearmonth().toString();
						            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						            Calendar dar = Calendar.getInstance();
									dar.setTime(sdf.parse(getDate.substring(0,10)));
									dar.add(Calendar.MONTH, -23);
									Date yearmonthBefore2year = dar.getTime();
									String yearmonthBefore2yearString = sdf.format(yearmonthBefore2year);
						            String endyear=getDate.substring(0,4);
									String month=getDate.substring(5,7);
						            String StratyearMonth=yearmonthBefore2yearString.substring(0,4)+"年"+yearmonthBefore2yearString.substring(5,7)+"月";
						            String EndyearMonth=endyear+"年"+month+"月";
						            String yearMonth=StratyearMonth+"-"+EndyearMonth+"的还款记录";
						            dar.add(Calendar.MONTH, -1);
									Date yearmonth2year = dar.getTime();
									String yearmonth2yearString = sdf.format(yearmonth2year);
						            String yqendyear=yearmonth2yearString.substring(0,4);
									String yqendmonth=yearmonth2yearString.substring(5,7);
						            String yqendyearMonth=yqendyear+"年"+yqendmonth+"月";
						            dar.add(Calendar.MONTH, -35);
									Date startyearmonth2year = dar.getTime();
									String startyearmonth2yearString = sdf.format(startyearmonth2year);
						            String yqstartyearMonth=startyearmonth2yearString.substring(0,4)+"年"+startyearmonth2yearString.substring(5,7)+"月";
						            String yqyearMonth;
						            int result = startyearmonth2yearString.compareTo(dateofcreate_ym);
						            if(acc_status.equals("销户")){
						            	if (result>=0)
						            	{
											yqyearMonth=yqstartyearMonth+"-"+EndyearMonth+"的逾期记录";
						            	}
						            	else
						            	{
											yqyearMonth=dateofcreate_ymr+"-"+EndyearMonth+"的逾期记录";

						            	}
						            }
						            else{
						            	if (result>=0)
						            	{
											yqyearMonth=yqstartyearMonth+"-"+yqendyearMonth+"的逾期记录";
						            	}
						            	else
						            	{
											yqyearMonth=dateofcreate_ymr+"-"+yqendyearMonth+"的逾期记录";

						            	}
						            }
						            map.put("yqyearMonth", yqyearMonth);
						            map.put("yearMonth", yearMonth);
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
		//贷记卡
		 public static List<Map> getIndDetailInfoCardByRptId(String rptId,int no){
			        try {
					        	List<Map> list=new ArrayList<Map>();
					            Map<String, Object> map = new HashMap<String, Object>();
					            StringBuffer hql1 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'CARD' and code = 'DESC'" );
					            List<IndDetailInfo> listIndDetailInfoDesc= ROOTDAOUtils.getROOTDAO().queryByCondition(hql1.toString());
					            if(null != listIndDetailInfoDesc && listIndDetailInfoDesc.size()>0){
						            	map.put("valueDesc", listIndDetailInfoDesc.get(0).getValue());
					            }
					            
			            		StringBuffer hql2 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'CARD' and code = 'AVGUSEDL6M'" );
					            List<IndDetailInfo> listIndDetailInfoAvgusedl6m= ROOTDAOUtils.getROOTDAO().queryByCondition(hql2.toString());
					            if(null != listIndDetailInfoAvgusedl6m && listIndDetailInfoAvgusedl6m.size()>0){
						            	map.put("valueAvgusedl6m", numToCurrency(listIndDetailInfoAvgusedl6m.get(0).getValue()));
					            }
					            
					            StringBuffer hql3 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'CARD' and code = 'BILLDAY'" );
					            List<IndDetailInfo> listIndDetailInfoBillday= ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
					            if(null != listIndDetailInfoBillday && listIndDetailInfoBillday.size()>0){
						            	map.put("valueBillday", listIndDetailInfoBillday.get(0).getValue());
					            }
					            
					            StringBuffer hql4 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'CARD' and code = 'ORGDESC' order by get_date desc" );
					            List<IndDetailInfo> listIndDetailInfoOrgdesc= ROOTDAOUtils.getROOTDAO().queryByCondition(hql4.toString());
					            if(null != listIndDetailInfoOrgdesc && listIndDetailInfoOrgdesc.size()>0){
					            	map.put("valueOrgdesc", listIndDetailInfoOrgdesc.get(0).getValue());
					            	map.put("dateOrgdesc", TimeSubDate(listIndDetailInfoOrgdesc.get(0).getDate()));
					            	map.put("flagOrgdesc", "success");	
					            }else{
					            	map.put("flagOrgdesc", "error");
					            }
					            
					            StringBuffer hql5 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'CARD' and code = 'SELFSTATEMENT' order by get_date desc" );
					            List<IndDetailInfo> listIndDetailInfoSelfStatement= ROOTDAOUtils.getROOTDAO().queryByCondition(hql5.toString());
					            if(null != listIndDetailInfoSelfStatement && listIndDetailInfoSelfStatement.size()>0){
					            	map.put("valueSelfStatement", listIndDetailInfoSelfStatement.get(0).getValue());
					            	map.put("dateSelfStatements", TimeSubDate(listIndDetailInfoSelfStatement.get(0).getDate()));
					            	map.put("flagSelfStatements", "success");
					            }else{
					            	map.put("flagSelfStatements", "error");
					            }
					            
					            
					            StringBuffer hql6 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'CARD' and code = 'DISSENT' order by get_date desc" );
					            List<IndDetailInfo> listIndDetailInfoDissent= ROOTDAOUtils.getROOTDAO().queryByCondition(hql5.toString());
					            if(null != listIndDetailInfoDissent && listIndDetailInfoDissent.size()>0){
					            	map.put("valueDissent", listIndDetailInfoDissent.get(0).getValue());
					            	map.put("dateDissent", TimeSubDate(listIndDetailInfoDissent.get(0).getDate()));
					            	map.put("flagDissent", "success");
					            }else{
					            	map.put("flagDissent", "error");
					            }
					            
					            list.add(map);
					            return list;
			        }
			        catch (Exception e){
			            e.printStackTrace();
			        }
					return null;
			    }
		 //贷记卡
		   public static List<Map> getIndOverdueDetailCardByRptId(String rptId,int no){
		        try {
				        	List<Map> list=new ArrayList<Map>();
				            StringBuffer hql1 = new StringBuffer("select ii from IndOverdueDetail ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"'   and type = 'CARD' order by month desc" );
				            List<IndOverdueDetail> listIndOverdueDetail= ROOTDAOUtils.getROOTDAO().queryByCondition(hql1.toString());
				            if(null != listIndOverdueDetail && listIndOverdueDetail.size()>0){
				            	for (int i = 0; i < listIndOverdueDetail.size(); i++) {
						            Map<String, Object> map = new HashMap<String, Object>();
					            	map.put("month", TimeSubMon(listIndOverdueDetail.get(i).getMonth()));
					            	map.put("month_count", listIndOverdueDetail.get(i).getMonthCount());
					            	map.put("amount", numToCurrency(listIndOverdueDetail.get(i).getAmount()));
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
		   
		   
				   //贷记卡
				   public static List<Map> getIndSpecialNewCardByRptId(String rptId,int no){
				        try {
			        		List<Map> list=new ArrayList<Map>();
						            StringBuffer hql1 = new StringBuffer("select ii from IndSpecialNew ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"'   and acc_type = 'CARD' " );
						            List<IndSpecialNew> listIndSpecialNew= ROOTDAOUtils.getROOTDAO().queryByCondition(hql1.toString());
						            if(null != listIndSpecialNew && listIndSpecialNew.size()>0){
							            Map<String, Object> map = new HashMap<String, Object>();
							            	map.put("type", listIndSpecialNew.get(0).getType());
							            	map.put("date", TimeSubDate(listIndSpecialNew.get(0).getDate()));
							            	map.put("change_month", listIndSpecialNew.get(0).getChangeMonth());
							            	map.put("amount", numToCurrency(listIndSpecialNew.get(0).getAmount()));
							            	map.put("details", listIndSpecialNew.get(0).getDetails());
							            	map.put("flagSpecialNew", "success");
										list.add(map);
						            }
						            return list;
				        }
				        catch (Exception e){
				            e.printStackTrace();
				        }
						return null;
				    }
				   
				   
				   //准贷记卡
					public static List<Map> getIndCrdDetailQuaByRptId(String rptId){
				        try {
				        	List<Map> list=new ArrayList<Map>();
				            StringBuffer hql = new StringBuffer("select ii from IndCrdDetail ii where ii.rptId='"+rptId+"' and Card_type = '准贷记卡' order by no");
				            List<IndCrdDetail> listIndCrdDetail = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
				            if(null != listIndCrdDetail && listIndCrdDetail.size()>0){
				            	for (int i = 0; i < listIndCrdDetail.size(); i++) {
				            		   //个人信用报告
						        	  		Map<String, Object> map = new HashMap<String, Object>();
				            			   map.put("No", listIndCrdDetail.get(i).getNo());
				            			   map.put("Acc_status", listIndCrdDetail.get(i).getAccStatus());
				            			   String acc_status=listIndCrdDetail.get(i).getAccStatus();
				            			   String dateofcreate=TimeSubDate(listIndCrdDetail.get(i).getDateofcreate());
				            			   String dateofcreate_ym=dateofcreate.substring(0, 7);
				            			   String dateofcreate_ymr=dateofcreate_ym.substring(0, 4)+ "年" + dateofcreate_ym.substring(5, 7)+"月";
				                           map.put("Overdue", numToCurrency(listIndCrdDetail.get(i).getOverdue()));
				                           map.put("Max_debit", numToCurrency(listIndCrdDetail.get(i).getMaxDebit()));
				                           map.put("Pay_real", numToCurrency(listIndCrdDetail.get(i).getPayReal()));
				                           map.put("Recent_date", TimeSubDate(listIndCrdDetail.get(i).getRecentDate()));
				                           map.put("Over180", numToCurrency(listIndCrdDetail.get(i).getOver180()));
				                           List list1=new ArrayList();
								            for (int j = 0; j < 24; j++) {
								            	String month24=listIndCrdDetail.get(i).getMonth24().substring(j, j+1);
								            	list1.add(month24);
											}
								            map.put("month24", list1);
								            String getDate=listIndCrdDetail.get(i).getYearmonth().toString();
								            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								            Calendar dar = Calendar.getInstance();
											dar.setTime(sdf.parse(getDate.substring(0,10)));
											dar.add(Calendar.MONTH, -23);
											Date yearmonthBefore2year = dar.getTime();
								            
											String yearmonthBefore2yearString = sdf.format(yearmonthBefore2year);
								            String endyear=getDate.substring(0,4);
								            int startyear=Integer.valueOf(getDate.substring(0,4))-2;
											String month=getDate.substring(5,7);
								            String StratyearMonth=yearmonthBefore2yearString.substring(0,4)+"年"+yearmonthBefore2yearString.substring(5,7)+"月";
								            String EndyearMonth=endyear+"年"+month+"月";
								            String yearMonth=StratyearMonth+"-"+EndyearMonth+"的还款记录";
								            dar.add(Calendar.MONTH, -1);
											Date yearmonth2year = dar.getTime();
											String yearmonth2yearString = sdf.format(yearmonth2year);
								            String yqendyear=yearmonth2yearString.substring(0,4);
											String yqendmonth=yearmonth2yearString.substring(5,7);
								            String yqendyearMonth=yqendyear+"年"+yqendmonth+"月";
								            dar.add(Calendar.MONTH, -35);
											Date startyearmonth2year = dar.getTime();
											String startyearmonth2yearString = sdf.format(startyearmonth2year);
								            String yqstartyearMonth=startyearmonth2yearString.substring(0,4)+"年"+startyearmonth2yearString.substring(5,7)+"月";
								            String yqyearMonth;
								            int result = startyearmonth2yearString.compareTo(dateofcreate_ym);
								            if(acc_status.equals("销户")){
								            	if (result>=0)
								            	{
													yqyearMonth=yqstartyearMonth+"-"+EndyearMonth+"60天以上的透支记录";
								            	}
								            	else
								            	{
													yqyearMonth=dateofcreate_ymr+"-"+EndyearMonth+"60天以上的透支记录";

								            	}
								            }
								            else{
								            	if (result>=0)
								            	{
													yqyearMonth=yqstartyearMonth+"-"+yqendyearMonth+"60天以上的透支记录";
								            	}
								            	else
								            	{
													yqyearMonth=dateofcreate_ymr+"-"+yqendyearMonth+"60天以上的透支记录";

								            	}
								            }
								            map.put("yqyearMonth", yqyearMonth);
								            map.put("yearMonth", yearMonth);
								            map.put("flagIndCrdDetailQua", "success");
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
					
					//准贷记卡
					 public static List<Map> getIndDetailInfoCardQuaByRptId(String rptId,int no){
						        try {
								        	List<Map> list=new ArrayList<Map>();
								            Map<String, Object> map = new HashMap<String, Object>();
								            
							            	map.put("Descflag", "f");
							            	map.put("Avgusedl6mflag",  "f");
							            	map.put("Billdayflag", "f");
							            	map.put("OrgDescflag", "f");
							            	map.put("SelfStatementflag", "f");
							            	map.put("Dissentflag", "f");
								            
								            StringBuffer hql1 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"'  and type = 'PDC' and code = 'DESC' " );
								            List<IndDetailInfo> listIndDetailInfoDesc= ROOTDAOUtils.getROOTDAO().queryByCondition(hql1.toString());
								            if(null != listIndDetailInfoDesc && listIndDetailInfoDesc.size()>0){
									            	map.put("valueDesc", listIndDetailInfoDesc.get(0).getValue());
									            	map.put("Descflag","success");
								            }
								            
								            
						            		StringBuffer hql2 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"'  and type = 'PDC' and code = 'AVGUSEDL6M' " );
								            List<IndDetailInfo> listIndDetailInfoAvgusedl6m= ROOTDAOUtils.getROOTDAO().queryByCondition(hql2.toString());
								            if(null != listIndDetailInfoAvgusedl6m && listIndDetailInfoAvgusedl6m.size()>0){
									            	map.put("valueAvgusedl6m", numToCurrency(listIndDetailInfoAvgusedl6m.get(0).getValue()));
									            	map.put("Avgusedl6mflag",  "success");
								            }
								            
								            StringBuffer hql3 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"'  and type = 'PDC' and code = 'BILLDAY'" );
								            List<IndDetailInfo> listIndDetailInfoBillday= ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
								            if(null != listIndDetailInfoBillday && listIndDetailInfoBillday.size()>0){
									            	map.put("valueBillday", listIndDetailInfoBillday.get(0).getValue());
									            	map.put("Billdayflag", "success");
								            }
								            StringBuffer hql4 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'PDC' and code = 'ORGDESC' order by get_date desc" );
								            List<IndDetailInfo> listIndDetailInfoOrgDesc= ROOTDAOUtils.getROOTDAO().queryByCondition(hql4.toString());
								            if(null != listIndDetailInfoOrgDesc && listIndDetailInfoOrgDesc.size()>0){
								            	map.put("valueOrgDesc", listIndDetailInfoOrgDesc.get(0).getValue());
								            	map.put("dateOrgDesc", TimeSubDate(listIndDetailInfoOrgDesc.get(0).getDate()));
								            	map.put("OrgDescflag", "success");
								            }
								            
								            StringBuffer hql5 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'PDC' and code = 'SELFSTATEMENT' order by get_date desc" );
								            List<IndDetailInfo> listIndDetailInfoSelfStatement= ROOTDAOUtils.getROOTDAO().queryByCondition(hql5.toString());
								            if(null != listIndDetailInfoSelfStatement && listIndDetailInfoSelfStatement.size()>0){
								            	map.put("valueSelfStatement", listIndDetailInfoSelfStatement.get(0).getValue());
								            	map.put("dateSelfStatement",TimeSubDate(listIndDetailInfoSelfStatement.get(0).getDate()));
								            	map.put("SelfStatementflag", "success");
								            }
								            
								            
								            StringBuffer hql6 = new StringBuffer("select ii from IndDetailInfo ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'PDC' and code = 'DISSENT' order by get_date desc" );
								            List<IndDetailInfo> listIndDetailInfoDissent= ROOTDAOUtils.getROOTDAO().queryByCondition(hql6.toString());
								            if(null != listIndDetailInfoDissent && listIndDetailInfoDissent.size()>0){
								            	map.put("valueDissent", listIndDetailInfoDissent.get(0).getValue());
								            	map.put("dateDissent", TimeSubDate(listIndDetailInfoDissent.get(0).getDate()));
								            	map.put("Dissentflag", "success");
								            }
								            
								            list.add(map);
								            return list;
						        }
						        catch (Exception e){
						            e.printStackTrace();
						        }
								return null;
						    }
					 
					 //准贷记卡
					   public static List<Map> getIndOverdueDetailCardQuaByRptId(String rptId,int no){
					        try {
							        	List<Map> list=new ArrayList<Map>();
							            StringBuffer hql1 = new StringBuffer("select ii from IndOverdueDetail ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"' and type = 'PDC' order by month desc" );
							            List<IndOverdueDetail> listIndOverdueDetail= ROOTDAOUtils.getROOTDAO().queryByCondition(hql1.toString());
							            if(null != listIndOverdueDetail && listIndOverdueDetail.size()>0){
							            	for (int i = 0; i < listIndOverdueDetail.size(); i++) {
									            Map<String, Object> map = new HashMap<String, Object>();
								            	map.put("month", TimeSubMon(listIndOverdueDetail.get(i).getMonth()));
								            	map.put("month_count", listIndOverdueDetail.get(i).getMonthCount());
								            	map.put("amount", numToCurrency(listIndOverdueDetail.get(i).getAmount()));
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
					   
					   //准贷记卡
					   public static List<Map> getIndSpecialNewQuaByRptId(String rptId,int no){
					        try {
							        	List<Map> list=new ArrayList<Map>();
							            StringBuffer hql1 = new StringBuffer("select ii from IndSpecialNew ii where  ii.rptId='"+rptId+"' and ii.no='"+no+"'  and acc_type = 'PDC'" );
							            List<IndSpecialNew> listIndSpecialNew= ROOTDAOUtils.getROOTDAO().queryByCondition(hql1.toString());
							            if(null != listIndSpecialNew && listIndSpecialNew.size()>0){
								            Map<String, Object> map = new HashMap<String, Object>();
								            	map.put("type", listIndSpecialNew.get(0).getType());
								            	map.put("date", TimeSubDate(listIndSpecialNew.get(0).getDate()));
								            	map.put("change_month", listIndSpecialNew.get(0).getChangeMonth());
								            	map.put("amount", numToCurrency(listIndSpecialNew.get(0).getAmount()));
								            	map.put("details", listIndSpecialNew.get(0).getDetails());
								            	list.add(map);
							            }
							            return list;
					        }
					        catch (Exception e){
					            e.printStackTrace();
					        }
							return null;
					    }
					   
					   
					   
					   //担保信息
						public static List<Map> getIndAssuranceDetailByRptId(String rptId){
					        try {
					        	List<Map> list=new ArrayList<Map>();
					        	 //担保信息
					            StringBuffer hql = new StringBuffer("select ii from IndAssuranceDetail ii where ii.rptId='"+rptId+"' order by no");
					            List<IndAssuranceDetail> listIndAssuranceDetail = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
					            if(null != listIndAssuranceDetail && listIndAssuranceDetail.size()>0){
						        	 Map<String, Object> map = new HashMap<String, Object>();
					            		map.put("flag", "success");
					                       list.add(map);
								}
					            return list;
					            
					        }
					        catch (Exception e){
					            e.printStackTrace();
					        }
							return null;
					    }
								
						
						
						 //对外贷款担保信息
						public static List<Map> getIndAssuranceDetailLoanByRptId(String rptId){
					        try {
					        	List<Map> list=new ArrayList<Map>();
					            
					           
					            StringBuffer hql2 = new StringBuffer("select ii from IndAssuranceDetail ii where ii.rptId='"+rptId+"' and type = '贷款' order by no ");
					            List<IndAssuranceDetail> listIndAssuranceDetailLoan = ROOTDAOUtils.getROOTDAO().queryByCondition(hql2.toString());
					            if(null != listIndAssuranceDetailLoan && listIndAssuranceDetailLoan.size()>0){
					            	for (int i = 0; i < listIndAssuranceDetailLoan.size(); i++) {
							        	 Map<String, Object> map = new HashMap<String, Object>();
					            		map.put("no", listIndAssuranceDetailLoan.get(i).getNo());
					            		map.put("assurance_org", listIndAssuranceDetailLoan.get(i).getAssuranceOrg());
					            		map.put("contract_amount", numToCurrency(listIndAssuranceDetailLoan.get(i).getContractAmount()));
					            		map.put("issue_date", TimeSubDate(listIndAssuranceDetailLoan.get(i).getIssueDate()));
					            		map.put("end_date", TimeSubDate(listIndAssuranceDetailLoan.get(i).getEndDate()));
					            		map.put("assurance_amount", numToCurrency(listIndAssuranceDetailLoan.get(i).getAssuranceAmount()));
					            		map.put("balance", numToCurrency(listIndAssuranceDetailLoan.get(i).getBalance()));
					            		map.put("l5class", listIndAssuranceDetailLoan.get(i).getL5class());
					            	    map.put("yearMonth", TimeSubDate(listIndAssuranceDetailLoan.get(i).getYearmonth()));
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
					   
						//对外信用卡担保信息
						public static List<Map> getIndAssuranceDetailCreditByRptId(String rptId){
					        try {
					        	List<Map> list=new ArrayList<Map>();
					            
					            StringBuffer hql3 = new StringBuffer("select ii from IndAssuranceDetail ii where ii.rptId='"+rptId+"'  and type = '信用卡' order by no  ");
					            List<IndAssuranceDetail> listIndAssuranceDetailCredit = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
					            if(null != listIndAssuranceDetailCredit && listIndAssuranceDetailCredit.size()>0){
					            	for (int i = 0; i < listIndAssuranceDetailCredit.size(); i++) {
							        	 Map<String, Object> map = new HashMap<String, Object>();
					            		map.put("no", listIndAssuranceDetailCredit.get(i).getNo());
					            		map.put("assurance_org", listIndAssuranceDetailCredit.get(i).getAssuranceOrg());
					            		map.put("contract_amount", numToCurrency(listIndAssuranceDetailCredit.get(i).getContractAmount()));
					            		map.put("issue_date", TimeSubDate(listIndAssuranceDetailCredit.get(i).getIssueDate()));
					            		map.put("end_date", TimeSubDate(listIndAssuranceDetailCredit.get(i).getEndDate()));
					            		map.put("assurance_amount", numToCurrency(listIndAssuranceDetailCredit.get(i).getAssuranceAmount()));
					            		map.put("balance", numToCurrency(listIndAssuranceDetailCredit.get(i).getBalance()));
					            		map.put("l5class", listIndAssuranceDetailCredit.get(i).getL5class());
					            		map.put("yearMonth", TimeSubDate(listIndAssuranceDetailCredit.get(i).getYearmonth()));
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
					// 判断公共信息明细记录是否大于零
				 public static Long getCountByRptId(String rptId) throws CommonException{
							StringBuffer hql1 = new StringBuffer("select count(rptId)  from IndOweTax where rptId='"+rptId+"'" );
							StringBuffer hql2 = new StringBuffer("select count(rptId)  from IndPublicRecord where rptId='"+rptId+"' and recordType in ('民事判决记录','强制执行记录','行政处罚记录')" );
							StringBuffer hql3 = new StringBuffer("select count(rptId)  from IndHousefundDeposit where rptId='"+rptId+"'" );
							StringBuffer hql4 = new StringBuffer("select count(rptId)  from IndInsDeposit where rptId='"+rptId+"'" );
							StringBuffer hql5 = new StringBuffer("select count(rptId)  from IndInsPayment where rptId='"+rptId+"'" );
							StringBuffer hql6 = new StringBuffer("select count(rptId)  from IndSuccour where rptId='"+rptId+"'" );
							StringBuffer hql7 = new StringBuffer("select count(rptId)  from IndAward where rptId='"+rptId+"' and recordType in ('执业资格记录', '行政奖励记录')" );
							StringBuffer hql8 = new StringBuffer("select count(rptId)  from IndCarTrade where rptId='"+rptId+"'" );
							StringBuffer hql9 = new StringBuffer("select count(rptId)  from IndTelecomPayment where rptId='"+rptId+"'" );
							Long count1=  (Long)ROOTDAOUtils.getROOTDAO().queryByCondition(hql1.toString()).get(0);
							Long count2=  (Long)ROOTDAOUtils.getROOTDAO().queryByCondition(hql2.toString()).get(0);
							Long count3=  (Long)ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString()).get(0);
							Long count4=  (Long)ROOTDAOUtils.getROOTDAO().queryByCondition(hql4.toString()).get(0);
							Long count5=  (Long)ROOTDAOUtils.getROOTDAO().queryByCondition(hql5.toString()).get(0);
							Long count6=  (Long)ROOTDAOUtils.getROOTDAO().queryByCondition(hql6.toString()).get(0);
							Long count7=  (Long)ROOTDAOUtils.getROOTDAO().queryByCondition(hql7.toString()).get(0);
							Long count8=  (Long)ROOTDAOUtils.getROOTDAO().queryByCondition(hql8.toString()).get(0);
							Long count9=  (Long)ROOTDAOUtils.getROOTDAO().queryByCondition(hql9.toString()).get(0);
							Long count=count1+count2+count3+count4+count5+count6+count7+count8+count9;
							return count;
				}
    	//欠税记录
		public static List<Map> getIndOweTaxByRptId(String rptId){
	        try {
	        	List<Map> list=new ArrayList<Map>();
	            
	            StringBuffer hql3 = new StringBuffer("select ii from IndOweTax ii where ii.rptId='"+rptId+"' ");
	            List<IndOweTax> listIndOweTax = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
	            if(null != listIndOweTax && listIndOweTax.size()>0){
	            	for (int i = 0; i < listIndOweTax.size(); i++) {
	   	        	 Map<String, Object> map = new HashMap<String, Object>();
	            		map.put("no", listIndOweTax.get(i).getNo());
	            		map.put("manager", listIndOweTax.get(i).getManager());
	            		map.put("amount", numToCurrency(listIndOweTax.get(i).getAmount()));
	            		map.put("tax_date", TimeSubDate(listIndOweTax.get(i).getTaxDate()));
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
		
		//民事判决记录
		public static List<Map> getIndPublicRecordCivilByRptId(String rptId){
	        try {
	        	List<Map> list=new ArrayList<Map>();
	            StringBuffer hql3 = new StringBuffer("select ii from IndPublicRecord ii where ii.rptId='"+rptId+"' and record_type = '民事判决记录'");
	            List<IndPublicRecord> listIndPublicRecord = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
	            if(null != listIndPublicRecord && listIndPublicRecord.size()>0){
	            	for (int i = 0; i < listIndPublicRecord.size(); i++) {
	   	        	 Map<String, Object> map = new HashMap<String, Object>();
	            		map.put("no", listIndPublicRecord.get(i).getNo());
	            		map.put("organ", listIndPublicRecord.get(i).getOrgan());
	            		map.put("reason", listIndPublicRecord.get(i).getReason());
	            		map.put("init_date", TimeSubDate(listIndPublicRecord.get(i).getInitDate()));
	            		map.put("type", listIndPublicRecord.get(i).getType());
	            		map.put("type", listIndPublicRecord.get(i).getType());
	            		map.put("result", listIndPublicRecord.get(i).getResult());
	            		map.put("end_date", TimeSubDate(listIndPublicRecord.get(i).getEndDate()));
	            		map.put("subject_name", listIndPublicRecord.get(i).getSubjectName());
	            		map.put("subject_amount", listIndPublicRecord.get(i).getSubjectAmount());
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
		// 强制执行记录
		public static List<Map> getIndPublicRecordForceByRptId(String rptId){
	        try {
	        	List<Map> list=new ArrayList<Map>();
	            StringBuffer hql3 = new StringBuffer("select ii from IndPublicRecord ii where ii.rptId='"+rptId+"'  and record_type = '强制执行记录'");
	            List<IndPublicRecord> listIndPublicRecord = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
	            if(null != listIndPublicRecord && listIndPublicRecord.size()>0){
	            	for (int i = 0; i < listIndPublicRecord.size(); i++) {
	   	        	 Map<String, Object> map = new HashMap<String, Object>();
	            		map.put("no", listIndPublicRecord.get(i).getNo());
	            		map.put("organ", listIndPublicRecord.get(i).getOrgan());
	            		map.put("reason", listIndPublicRecord.get(i).getReason());
	            		map.put("init_date", TimeSubDate(listIndPublicRecord.get(i).getInitDate()));
	            		map.put("type", listIndPublicRecord.get(i).getType());
	            		map.put("status", listIndPublicRecord.get(i).getStatus());
	            		map.put("result", listIndPublicRecord.get(i).getResult());
	            		map.put("end_date", TimeSubDate(listIndPublicRecord.get(i).getEndDate()));
	            		map.put("subject_name", listIndPublicRecord.get(i).getSubjectName());
	            		map.put("subject_amount", numToCurrency(listIndPublicRecord.get(i).getSubjectAmount()));
	            		map.put("object_name", listIndPublicRecord.get(i).getObjectName());
	            		map.put("object_amount", numToCurrency(listIndPublicRecord.get(i).getObjectAmount()));
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
		
		//行政处罚记录
		public static List<Map> getIndPublicRecordAdminByRptId(String rptId){
	        try {
	        	List<Map> list=new ArrayList<Map>();
	            StringBuffer hql3 = new StringBuffer("select ii from IndPublicRecord ii where ii.rptId='"+rptId+"'  and record_type = '行政处罚记录'");
	            List<IndPublicRecord> listIndPublicRecord = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
	            if(null != listIndPublicRecord && listIndPublicRecord.size()>0){
	            	for (int i = 0; i < listIndPublicRecord.size(); i++) {
	   	        	 Map<String, Object> map = new HashMap<String, Object>();
	            		map.put("no", listIndPublicRecord.get(i).getNo());
	            		map.put("organ", listIndPublicRecord.get(i).getOrgan());
	            		map.put("reason", listIndPublicRecord.get(i).getReason());
	            		map.put("subject_name", listIndPublicRecord.get(i).getSubjectName());
	            		if(null != listIndPublicRecord.get(i).getInitDate()){
	            			map.put("init_date", TimeSubDate(listIndPublicRecord.get(i).getInitDate()));
	            		}else{
	            			map.put("init_date", "--");
	            		}
	            		if(null != listIndPublicRecord.get(i).getEndDate()){
	            			map.put("end_date", TimeSubDate(listIndPublicRecord.get(i).getEndDate()));
	            		}else{
	            			map.put("end_date", "--");
	            		}
	            		
	            		
	            		map.put("result", listIndPublicRecord.get(i).getResult());
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
		
		//住房公积金参缴记录
			public static List<Map> getIndHousefundDepositByRptId(String rptId){
		        try {
		        	List<Map> list=new ArrayList<Map>();
		            StringBuffer hql3 = new StringBuffer("select ii from IndHousefundDeposit ii where ii.rptId='"+rptId+"'");
		            List<IndHousefundDeposit> listIndHousefundDeposit = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
		            if(null != listIndHousefundDeposit && listIndHousefundDeposit.size()>0){
		            	for (int i = 0; i < listIndHousefundDeposit.size(); i++) {
				        	 Map<String, Object> map = new HashMap<String, Object>();
		            		map.put("no", listIndHousefundDeposit.get(i).getNo());
		            		map.put("city", replaceInformation(listIndHousefundDeposit.get(i).getCity()));
		            		map.put("init_date", TimeSubDate(listIndHousefundDeposit.get(i).getInitDate()));
		            		map.put("first_month", TimeSubMon(listIndHousefundDeposit.get(i).getFirstMonth()));
		            		map.put("to_month", TimeSubMon(listIndHousefundDeposit.get(i).getToMonth()));
		            		map.put("status", listIndHousefundDeposit.get(i).getStatus());
		            		map.put("monthly_amount", numToCurrency(listIndHousefundDeposit.get(i).getMonthlyAmount()));
		            		map.put("persent_per", listIndHousefundDeposit.get(i).getPersentPer());
		            		map.put("percent_com", listIndHousefundDeposit.get(i).getPercentCom());
		            		map.put("organ", replaceInformation(listIndHousefundDeposit.get(i).getOrgan()));
		            		map.put("update_date", TimeSubDate(listIndHousefundDeposit.get(i).getUpdateDate()));
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
		  //养老保险金缴存记录
			   public static List<Map> getIndInsDepositByRptId(String rptId){
			        try {
			        	List<Map> list=new ArrayList<Map>();
			            StringBuffer hql3 = new StringBuffer("select ii from IndInsDeposit ii where ii.rptId='"+rptId+"'");
			            List<IndInsDeposit> listIndInsDeposit = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
			            if(null != listIndInsDeposit && listIndInsDeposit.size()>0){
			            	for (int i = 0; i < listIndInsDeposit.size(); i++) {
					        	 Map<String, Object> map = new HashMap<String, Object>();
			            		map.put("no", listIndInsDeposit.get(i).getNo());
			            		map.put("city", replaceInformation(listIndInsDeposit.get(i).getCity()));
			            		map.put("init_date", TimeSubDate(listIndInsDeposit.get(i).getInitDate()));
			            		map.put("total_month", TimeSubMon(listIndInsDeposit.get(i).getTotalMonth()));
			            		map.put("work_month", TimeSubMon(listIndInsDeposit.get(i).getWorkMonth()));
			            		map.put("status", listIndInsDeposit.get(i).getStatus());
			            		map.put("base_amount", numToCurrency(listIndInsDeposit.get(i).getBaseAmount()));
			            		map.put("deposit_amount", numToCurrency(listIndInsDeposit.get(i).getDepositAmount()));
			            		map.put("update_date", TimeSubDate(listIndInsDeposit.get(i).getUpdateDate()));
			            		map.put("organ", replaceInformation(listIndInsDeposit.get(i).getOrgan()));
			            		map.put("end_reason", listIndInsDeposit.get(i).getEndReason());
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
			   
			   //养老保险金发放记录
			   public static List<Map> getIndInsPaymentByRptId(String rptId){
			        try {
			        	List<Map> list=new ArrayList<Map>();
			            StringBuffer hql3 = new StringBuffer("select ii from IndInsPayment ii where ii.rptId='"+rptId+"'");
			            List<IndInsPayment> listIndInsPayment = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
			            if(null != listIndInsPayment && listIndInsPayment.size()>0){
			            	for (int i = 0; i < listIndInsPayment.size(); i++) {
					        	 Map<String, Object> map = new HashMap<String, Object>();
			            		map.put("no", listIndInsPayment.get(i).getNo());
			            		map.put("city", replaceInformation(listIndInsPayment.get(i).getCity()));
			            		map.put("type", listIndInsPayment.get(i).getType());
			            		map.put("retire_month", TimeSubMon(listIndInsPayment.get(i).getRetireMonth()));
			            		map.put("work_month", TimeSubMon(listIndInsPayment.get(i).getWorkMonth()));
			            		map.put("pay_amount", numToCurrency(listIndInsPayment.get(i).getPayAmount()));
			            		map.put("end_reason", listIndInsPayment.get(i).getEndReason());
			            		map.put("update_date", TimeSubDate(listIndInsPayment.get(i).getUpdateDate()));
			            		map.put("organ", replaceInformation(listIndInsPayment.get(i).getOrgan()));
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
			   //低保救助记录
			   public static List<Map> getIndSuccourByRptId(String rptId){
			        try {
			        	List<Map> list=new ArrayList<Map>();
			            StringBuffer hql3 = new StringBuffer("select ii from IndSuccour ii where ii.rptId='"+rptId+"'");
			            List<IndSuccour> listIndSuccour = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
			            if(null != listIndSuccour && listIndSuccour.size()>0){
			            	for (int i = 0; i < listIndSuccour.size(); i++) {
					        	 Map<String, Object> map = new HashMap<String, Object>();
			            		map.put("no", listIndSuccour.get(i).getNo());
			            		map.put("city", listIndSuccour.get(i).getCity());
			            		map.put("type", listIndSuccour.get(i).getType());
			            		map.put("organ", listIndSuccour.get(i).getOrgan());
			            		map.put("family_income", listIndSuccour.get(i).getFamilyIncome());
			            		if(null != listIndSuccour.get(i).getApplyDate()){
			            			map.put("apply_date", TimeSubDate(listIndSuccour.get(i).getApplyDate()));
			            		}else{
			            			map.put("apply_date", "--");
			            		}
			            		if(null != listIndSuccour.get(i).getIssueDate()){
			            			map.put("issue_date", TimeSubDate(listIndSuccour.get(i).getIssueDate()));
			            		}else{
			            			map.put("issue_date", "--");
			            		}
			            		if(null != listIndSuccour.get(i).getUpdateDate()){
			            			map.put("update_date", TimeSubDate(listIndSuccour.get(i).getUpdateDate()));
			            		}else{
			            			map.put("update_date", "--");
			            		}
			            		
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
			   //执业资格记录
			   
		            public static List<Map> getIndAwardByRptId(String rptId){
				        try {
				        	List<Map> list=new ArrayList<Map>();
				            StringBuffer hql3 = new StringBuffer("select ii from IndAward ii where ii.rptId='"+rptId+"' and record_type = '执业资格记录'");
				            List<IndAward> listindAward = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
				            if(null != listindAward && listindAward.size()>0){
				            	for (int i = 0; i < listindAward.size(); i++) {
						        	 Map<String, Object> map = new HashMap<String, Object>();
				            		map.put("no", listindAward.get(i).getNo());
				            		map.put("name", listindAward.get(i).getCity());
				            		map.put("level", listindAward.get(i).getLevel());
				            		if(null != listindAward.get(i).getInitDate()){
				            			map.put("init_date", TimeSubDate(listindAward.get(i).getInitDate()));
				            		}else{
				            			map.put("init_date", "--");
				            		}
				            		if(null != listindAward.get(i).getExpireDate()){
				            			map.put("expire_date", TimeSubDate(listindAward.get(i).getExpireDate()));
				            		}else{
				            			map.put("expire_date", "--");
				            		}
				            		if(null != listindAward.get(i).getEndDate()){
				            			map.put("end_date", TimeSubDate(listindAward.get(i).getEndDate()));
				            		}else{
				            			map.put("end_date", "--");
				            		}
				            		map.put("organ", listindAward.get(i).getOrgan());
				            		map.put("city", listindAward.get(i).getCity());
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
		   //行政奖励记录
		            public static List<Map> getIndAwardAdminAwardByRptId(String rptId){
				        try {
				        	List<Map> list=new ArrayList<Map>();
				            StringBuffer hql3 = new StringBuffer("select ii from IndAward ii where ii.rptId='"+rptId+"' and record_type = '行政奖励记录'");
				            List<IndAward> listindAward = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
				            if(null != listindAward && listindAward.size()>0){
				            	for (int i = 0; i < listindAward.size(); i++) {
						        	 Map<String, Object> map = new HashMap<String, Object>();
				            		map.put("no", listindAward.get(i).getNo());
				            		map.put("organ", listindAward.get(i).getOrgan());
				            		map.put("content", listindAward.get(i).getCity());
				            		if(null != listindAward.get(i).getLevel()){
				            			map.put("init_date", TimeSubDate(listindAward.get(i).getLevel()));
				            		}else{
				            			map.put("init_date", "--");
				            		}
				            		if(null != listindAward.get(i).getInitDate()){
				            			map.put("expire_date", TimeSubDate(listindAward.get(i).getInitDate()));
				            		}else{
				            			map.put("expire_date", "--");
				            		}
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
		            
		    //车辆交易和抵押记录
		            public static List<Map> getIndCarTradeByRptId(String rptId){
				        try {
				        	List<Map> list=new ArrayList<Map>();
				            StringBuffer hql3 = new StringBuffer("select ii from IndCarTrade ii where ii.rptId='"+rptId+"'");
				            List<IndCarTrade> listIndCarTrade = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
				            if(null != listIndCarTrade && listIndCarTrade.size()>0){
				            	for (int i = 0; i < listIndCarTrade.size(); i++) {
						        	Map<String, Object> map = new HashMap<String, Object>();
				            		map.put("no", listIndCarTrade.get(i).getNo());
				            		map.put("car_number", listIndCarTrade.get(i).getCarNumber());
				            		map.put("engine_number", listIndCarTrade.get(i).getEngineNumber());
				            		map.put("brand", listIndCarTrade.get(i).getBrand());
				            		map.put("type", listIndCarTrade.get(i).getType());
				            		map.put("car_usage", listIndCarTrade.get(i).getCarUsage());
				            		map.put("status", listIndCarTrade.get(i).getStatus());
				            		map.put("pledged", listIndCarTrade.get(i).getPledged());
				            		if(null != listIndCarTrade.get(i).getUpdateDate()){
				            			map.put("update_date", TimeSubDate(listIndCarTrade.get(i).getUpdateDate()));
				            		}else{
				            			map.put("update_date", "--");
				            		}
				            		
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
		            
		   //电信缴费记录
		            
		            public static List<Map> getIndTelecomPaymentByRptId(String rptId){
				        try {
				        	List<Map> list=new ArrayList<Map>();
				            StringBuffer hql3 = new StringBuffer("select ii from IndTelecomPayment ii where ii.rptId='"+rptId+"'");
				            List<IndTelecomPayment> listIndTelecomPayment = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
				            if(null != listIndTelecomPayment && listIndTelecomPayment.size()>0){
				            	for (int i = 0; i < listIndTelecomPayment.size(); i++) {
						        	Map<String, Object> map = new HashMap<String, Object>();
						        	map.put("no", listIndTelecomPayment.get(i).getNo());
				            		map.put("organ", listIndTelecomPayment.get(i).getOrgan());
				            		map.put("type", listIndTelecomPayment.get(i).getType());
				            		map.put("init_date", TimeSubDate(listIndTelecomPayment.get(i).getInitDate()));
				            		map.put("status", listIndTelecomPayment.get(i).getStatus());
				            		map.put("owe_amount", numToCurrency(listIndTelecomPayment.get(i).getOweAmount()));
				            		map.put("owe_month", listIndTelecomPayment.get(i).getOweMonth());
				            	    List list24=new ArrayList();
						            for (int j = 0; j < 24; j++) {
						            	String month24value=listIndTelecomPayment.get(i).getMonth24().substring(j, j+1);
						            	list24.add(month24value);
									}
						            map.put("month24", list24);
						            /*
						            String getDate=listIndTelecomPayment.get(i).getYearmonth().toString();
						            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						            Calendar dar = Calendar.getInstance();
									dar.setTime(sdf.parse(getDate.substring(0,10)));
									dar.add(Calendar.MONTH, -23);
									Date yearmonthBefore2year = dar.getTime();
						            
									String yearmonthBefore2yearString = sdf.format(yearmonthBefore2year);
						            String endyear=getDate.substring(0,4);
						            int startyear=Integer.valueOf(getDate.substring(0,4))-2;
									String month=getDate.substring(5,7);
						            String StratyearMonth=yearmonthBefore2yearString.substring(0,4)+"年"+yearmonthBefore2yearString.substring(5,7)+"月";
						            String EndyearMonth=endyear+"年"+month+"月";
						            String yearMonth=StratyearMonth+"-"+EndyearMonth+"的还款记录";
						            map.put("yearMonth", yearMonth);*/
						            map.put("yearMonth", listIndTelecomPayment.get(i).getYearmonth());
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
		          //电信缴费记录 24month
		 		   public static List<Map> getIndTelecomPaymentByRptId24(String rptId,int no){
		 		        try {
		 		        	List<Map> list24=new ArrayList();
		 		        	StringBuffer hql = new StringBuffer("select ii from IndTelecomPayment ii where ii.rptId='"+rptId+"' and ii.no='"+no+"'  order by no" );
		 		            List<IndTelecomPayment> listIndTelecomPayment= ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
		 		            if(null != listIndTelecomPayment && listIndTelecomPayment.size()>0){
		 		        	
		 		            for (int j = 0; j < 24; j++) {
		 	            		Map<String, Object> map = new HashMap<String, Object>();
		 		            	String month24value=listIndTelecomPayment.get(0).getMonth24().substring(j, j+1);
		 		            	map.put("month24value",month24value);
		 		            	list24.add(map);
		 						}

		 		            }
		 		            return list24;

		 		        }
		 		         
		 		        catch (Exception e){
		 		            e.printStackTrace();
		 		        }
		 				return null;
		 		    }
		            
		            
		  
		            //本人声明
		            public static List<Map> getIndStatementByRptId(String rptId){
				        try {
				        	List<Map> list=new ArrayList<Map>();
				        	  //本人声明
				            StringBuffer hql1 = new StringBuffer("select ii from IndStatement ii where ii.rptId='"+rptId+"' and record_type = '本人声明'");
				            List<IndStatement> listIndStatement = ROOTDAOUtils.getROOTDAO().queryByCondition(hql1.toString());
				            if(null != listIndStatement && listIndStatement.size()>0){
				            	for (int i = 0; i < listIndStatement.size(); i++) {
						        	 Map<String, Object> map = new HashMap<String, Object>();
				            		map.put("noStatement", listIndStatement.get(i).getNo());
				            		map.put("contentStatement", listIndStatement.get(i).getContent());
				            		map.put("init_dateStatement", TimeSubDate(listIndStatement.get(i).getInitDate()));
				            		map.put("flagStatement", "success");
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
		            
		          //异议标注
		            public static List<Map> getIndStatementDissentByRptId(String rptId){
				        try {
				        	List<Map> list=new ArrayList<Map>();
				            //异议标注
				            StringBuffer hql2 = new StringBuffer("select ii from IndStatement ii where ii.rptId='"+rptId+"' and record_type = '异议标注'");
				            List<IndStatement> listIndStatementDissent = ROOTDAOUtils.getROOTDAO().queryByCondition(hql2.toString());
				            if(null != listIndStatementDissent && listIndStatementDissent.size()>0){
				            	for (int i = 0; i < listIndStatementDissent.size(); i++) {
				            		 Map<String, Object> map = new HashMap<String, Object>();
				            		map.put("noDissent", listIndStatementDissent.get(i).getNo());
				            		map.put("contentDissent", listIndStatementDissent.get(i).getContent());
				            		map.put("init_dateDissent", TimeSubDate(listIndStatementDissent.get(i).getInitDate()));
				            		map.put("flagDissent", "success");
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
     
		            
		  //查询记录汇总	
		            public static List<Map> getIndEnquirySummaryByRptId(String rptId){
				        try {
				        	List<Map> list=new ArrayList<Map>();
				            StringBuffer hql3 = new StringBuffer("select ii from IndEnquirySummary ii where ii.rptId='"+rptId+"'");
				            List<IndEnquirySummary> listIndEnquirySummary = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
				            if(null != listIndEnquirySummary && listIndEnquirySummary.size()>0){
				            	for (int i = 0; i < listIndEnquirySummary.size(); i++) {
						        	 Map<String, Object> map = new HashMap<String, Object>();
						        	 if(null !=listIndEnquirySummary.get(i).getSelfL1m()){
						        		 map.put("self_l1m", listIndEnquirySummary.get(i).getSelfL1m());
						        	 }else{
						        		 map.put("self_l1m", "");
						        	 }
						        	map.put("loan_approve_org_l1m", listIndEnquirySummary.get(i).getLoanApproveOrgL1m());
				            		map.put("cc_approve_org_l1m", listIndEnquirySummary.get(i).getCcApproveOrgL1m());
				            		map.put("loan_approve_l1m", listIndEnquirySummary.get(i).getLoanApproveL1m());
				            		map.put("cc_approve_l1m", listIndEnquirySummary.get(i).getCcApproveL1m());
				            		map.put("loan_manage_l2y", listIndEnquirySummary.get(i).getLoanManageL2y());
				            		map.put("assurance_check_l2y", listIndEnquirySummary.get(i).getAssuranceCheckL2y());
				            		map.put("real_name_check_l2y", listIndEnquirySummary.get(i).getRealNameCheckL2y());
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
		            
		            
		           //信贷审批查询记录明细
		            public static List<Map> getIndEnquiryByRptId(String rptId){
				        try {
				        	List<Map> list=new ArrayList<Map>();
				            StringBuffer hql3 = new StringBuffer("select ii from IndEnquiry ii where ii.rptId='"+rptId+"'");
				            List<IndEnquiry> listIndEnquiry = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
				            if(null != listIndEnquiry && listIndEnquiry.size()>0){
				            	for (int i = 0; i < listIndEnquiry.size(); i++) {
						        	 Map<String, Object> map = new HashMap<String, Object>();
				            		map.put("no", listIndEnquiry.get(i).getNo());
				            		map.put("Enq_date", TimeSubDate(listIndEnquiry.get(i).getEnqDate()));
				            		if(null != listIndEnquiry.get(i).getEnquirer() && listIndEnquiry.get(i).getEnquirer().length()>=2){
				            			map.put("enquirer",listIndEnquiry.get(i).getEnquirer().substring(0,2));
					    				
					    			}
				            		else{
				            		map.put("enquirer", listIndEnquiry.get(i).getEnquirer());
				            		}
				            		map.put("reason", listIndEnquiry.get(i).getReason());
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
		            
		            /**
		    		 * 将证件号中间部分替换成*            
		    		 * @param num
		    		 * @return
		    		  */
		            public static String replaceIdCrad(String num){
		    			String sbf=new String();
		    			if(null != num && num.length()>=3){
		    				 sbf=num.substring(0,3);
		    				 for (int i = 3; i < num.length()-3; i++) {
		    				    sbf+="*";
		    				 }
		    				 if(num.length()>3){
		    				 sbf+=num.substring(num.length()-3,num.length());
		    				 }
		    				 return sbf;
		    			}
		    			return num;
		    		}
		    		            
		    		/**
		    		 * 将电话号码中间部分替换成*            
		    		 * @param num
		    		 * @return
		    		 */
		    		public static String replaceNum(String num){
		    			String sbf=new String();
		    			if(null != num && num.length()>=1){
		    				sbf=num.substring(0,1);
		    				for (int i = 1; i < num.length()-1; i++) {
		    					sbf+="*";;
		    				}
		    				sbf+=num.substring(num.length()-1,num.length());
		    				return sbf;
		    			}
		    			return num;
		    		}
		    		/**
		    		 * 将部分信息替换成*
		    		 * @param Information
		    		 * @return
		    		 */
		    		public static String replaceInformation(String Information){
		    			String sbf=new String();
		    			if(null != Information && Information.length()>=2){
		    				sbf=Information.substring(0,2);
		    				for (int i = 2; i < Information.length(); i++) {
		    					sbf+="*";
		        			}
		    				return sbf;
		    			}
		    			return Information;
		    		}
		    		/**
		    		 * 将部分信息全部替换成*
		    		 * @param Information
		    		 * @return
		    		 */
		    		public static String replaceAllInformation(String Information){
		    			String sbf=new String();
		    			if(null != Information){
		    				for (int i = 0; i < Information.length(); i++) {
		    					sbf+="*";
		    				}
		    				return sbf;  
		    			}
		    			return Information;
		    		}
		    		/**
		    		 * 将名字替换成*
		    		 * @param name
		    		 * @return
		    		 */
		    		public static String replaceName(String name){
		    			String sbf=new String();
		    			if(null != name && name.length()>=1){
		    				sbf+=name.substring(0,1);
		    				for (int i = 1; i < name.length(); i++) {
		    					sbf+="*";
		    				}
		    				return sbf;
		    			}
		    			return name;
		    		}
		    		/**
		    		 * 将时间截取成日期
		    		 * @param name
		    		 * @return
		    		 */
		    		
		    		public static String TimeSubDate(String date) {
		    			if(null != date && date.length()>=10){
		    				if("1900-01-01".equals(date.substring(0, 10)))
		    				{
		    					return "--";
		    				}
		    				return date.substring(0, 10);  
		    			}
		    			return date;
		    		}  
		    		public static String TimeSubMon(String date) {
		    			if(null != date && date.length()>=10){
		    				if("1900-01".equals(date.substring(0, 7)))
		    				{
		    					return "--";
		    				}
		    				return date.substring(0, 7);  
		    			}
		    			return date;
		    		}  
		    		public static String TimeSubYear(String date) {
		    			if(null != date && date.length()>=10){
		    				if("1900".equals(date.substring(0, 4)))
		    				{
		    					return "--";
		    				}
		    				return date.substring(0, 4);  
		    			}
		    			return date;
		    		} 
		    		public static String TimeSubYear(Date date) {  
		    			if(null != date && date.toString().length()>=4){
		    				if("1900".equals(date.toString().substring(0, 4)))
		    				{
		    					return "--";
		    				}
		    				return date.toString().substring(0, 4);  
		    			}
		    			return "--";
		    		} 
		    		public static String TimeSubMon(Date date) {  
		    			if(null != date && date.toString().length()>=7){
		    				if("1900-01".equals(date.toString().substring(0, 7)))
		    				{
		    					return "--";
		    				}
		    				return date.toString().substring(0, 7);  
		    			}
		    			return "--";
		    		} 
		    		
		    		public static String TimeSubDate(Date date) {  
		    			if(null != date && date.toString().length()>=10){
		    				if("1900-01-01".equals(date.toString().substring(0, 10)))
		    				{
		    					return "--";
		    				}
		    				return date.toString().substring(0, 10);  
		    			}
		    			return "--";
		    		} 
		    		/**
		    		 * 数据字典证件类型转换
		    		 * X-其他证件
		    		 * 0: 身份证 1: 户口簿 2: 护照 3: 军官证
		    		 * 4: 士兵证 5: 港澳居民来往内地通行证
		    		 * 6: 台湾同胞来往内地通行证 7: 临时身份证
		    		 * 8: 外国人居留证 9: 警官证 X: 其它证件
		    		 * -: 都不是以上的证件类型
		    		 * @param idType
		    		 * @return
		    		 */
		    		public static String parseIdType(String idType){
		    			if(null != idType){
		    				if("0".equals(idType)){
			    	    		idType="身份证";
			    	    	}else if("1".equals(idType)){
			    	    		idType="户口簿";
			    	    	}else if("2".equals(idType)){
			    	    		idType="护照";
			    	    	}else if("3".equals(idType)){
			    	    		idType="军官证";
			    	    	}else if("4".equals(idType)){
			    	    		idType="士兵证";
			    	    	}else if("5".equals(idType)){
			    	    		idType="港澳居民来往内地通行证";
			    	    	}else if("6".equals(idType)){
			    	    		idType="台湾同胞来往内地通行证";
			    	    	}else if("7".equals(idType)){
			    	    		idType="临时身份证";
			    	    	}else if("8".equals(idType)){
			    	    		idType="外国人居留证";
			    	    	}else if("9".equals(idType)){
			    	    		idType="警官证";
			    	    	}else if("X".equals(idType)){
			    	    		idType="其它证件";
			    	    	}else if("-".equals(idType)){
			    	    		idType="-";
			    	    	}
			    			return idType;
		    			}
						return idType;
		    	    }
		    		
		    		/**
		    		 * 数据字典性别转换
		    		 *1-男性
		    		 *2-女性
		    		 *9-未说明性别
		    		 * @param idType
		    		 * @return
		    		 */
		    		public static String parseGender(String gender){
		    			if(null != gender){
		    				if("1".equals(gender)){
			    	    		gender="男性";
			    	    	}else if("2".equals(gender)){
			    	    		gender="女性";
			    	    	}else if("9".equals(gender)){
			    	    		gender="未说明性别";
			    	    	}
			    			return gender;
		    			}
						return gender;
		    	    }
		    		/**
		    		 * 转换金额类型
		    		 * @param amount
		    		 * @return
		    		 */
		    		public static String numToCurrency(Float amount){
			    			if(null != amount){ 
								DecimalFormat df = null;
								df = new DecimalFormat("###,##0.00");
								double number = Double.parseDouble(String.valueOf(amount.toString().replaceAll(",", "")));
								return df.format(number);
			    			}
		    			return amount.toString();
		    		}
		    		public static String numToCurrency(String amount){
		    				if(null != amount && (!"--".equals(amount))){
			    				DecimalFormat df = null;
			    				df = new DecimalFormat("###,##0.00");
			    				double number = Double.parseDouble(String.valueOf(amount.replaceAll(",", "")));
			    				return df.format(number);
			    			}
		    			return amount;
		    		}
		    		

}
