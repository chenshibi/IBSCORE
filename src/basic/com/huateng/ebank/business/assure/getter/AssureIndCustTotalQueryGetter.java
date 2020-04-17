package com.huateng.ebank.business.assure.getter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import resource.bean.basic.AssureIndGuarantee;
import resource.bean.basic.AssureIndGuarantorList;
import resource.bean.basic.AssureIndMainInfo;
import resource.bean.basic.AssureIndPledgeList;
import resource.bean.basic.AssureIndSum;

import com.huateng.ebank.business.common.ROOTDAOUtils;

public class AssureIndCustTotalQueryGetter {
	
	//自然人对外担保信息汇总表
	public static List<Map> getAssureIndSum(String rptKey){
        try {
        	List<Map> list=new ArrayList<Map>();
            StringBuffer hql = new StringBuffer("select ii from AssureIndSum ii where ii.rptKey='"+rptKey+"'");
            List<AssureIndSum> listAssureIndSum = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
            if(null != listAssureIndSum && listAssureIndSum.size()>0){
            	for (int i = 0; i < listAssureIndSum.size(); i++) {
            		AssureIndSum assureIndSum = listAssureIndSum.get(i);
            		   //个人信用报告
            		   Map<String, Object> map = new HashMap<String, Object>();
            			   map.put("rptKey",assureIndSum.getRptKey());
                           map.put("contractType", assureIndSum.getContractType());
                           map.put("sumAmount",numToCurrency(assureIndSum.getSumAmount()));
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
	
	//自然人对外担保信息汇总表-----保证-guarant
	public static List<Map> getAssureIndGuaranteeGuarant(String rptKey){
        try {
        	List<Map> list=new ArrayList<Map>();
            StringBuffer hql = new StringBuffer("select ii from AssureIndGuarantee ii where ii.contractType='guarant' and ii.rptKey='"+rptKey+"' Order by id" );
            
            @SuppressWarnings("unchecked")
			List<AssureIndGuarantee> listAssureIndGuarantee = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
            if(null != listAssureIndGuarantee && listAssureIndGuarantee.size()>0){
            	for (int i = 0; i < listAssureIndGuarantee.size(); i++) {
            		AssureIndGuarantee assureIndGuarantee = listAssureIndGuarantee.get(i);
            		   //个人信用报告
            		   Map<String, Object> map = new HashMap<String, Object>();
            		   	   map.put("rptKey", assureIndGuarantee.getRptKey());
            		   	   map.put("contractType", assureIndGuarantee.getContractType());
            			   map.put("no", assureIndGuarantee.getNo());
                           map.put("contractNo",assureIndGuarantee.getContractNo() );
                           map.put("contract_eff_flag",assureIndGuarantee.getContractEffFlag());
                           map.put("contract_no_amount", numToCurrency(assureIndGuarantee.getContractNoAmount()));
                           map.put("contract_no_currency", assureIndGuarantee.getContractNoCurrency());
                           map.put("guarantee_amount", numToCurrency(assureIndGuarantee.getGuaranteeAmount()));
                           map.put("guarantee_currency", assureIndGuarantee.getGuaranteeCurrency());
                           map.put("financial_org", assureIndGuarantee.getFinancialOrg());
                           map.put("contract_sign_date", assureIndGuarantee.getContractSignDate());
                           map.put("contract_style", assureIndGuarantee.getContractStyle());
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
	
	
	
	
	
	//自然人对外担保信息汇总表-----抵押-pledge
		public static List<Map> getAssureIndGuaranteePledge(String rptKey){
	        try {
	        	List<Map> list=new ArrayList<Map>();
	            StringBuffer hql = new StringBuffer("select ii from AssureIndGuarantee ii where ii.contractType='pledge' and ii.rptKey='"+rptKey+"' Order by id" );
	            
	            @SuppressWarnings("unchecked")
				List<AssureIndGuarantee> listAssureIndGuarantee = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
	            if(null != listAssureIndGuarantee && listAssureIndGuarantee.size()>0){
	            	for (int i = 0; i < listAssureIndGuarantee.size(); i++) {
	            		AssureIndGuarantee assureIndGuarantee = listAssureIndGuarantee.get(i);
	            		   //个人信用报告
	            		   Map<String, Object> map = new HashMap<String, Object>();
	            		   	   map.put("rptKey", assureIndGuarantee.getRptKey());
	            		   	   map.put("contractType", assureIndGuarantee.getContractType());
	            			   map.put("no", assureIndGuarantee.getNo());
	                           map.put("contractNo",assureIndGuarantee.getContractNo() );
	                           map.put("contract_eff_flag",assureIndGuarantee.getContractEffFlag());
	                           map.put("contract_no_amount", numToCurrency(assureIndGuarantee.getContractNoAmount()));
	                           map.put("contract_no_currency", assureIndGuarantee.getContractNoCurrency());
	                           map.put("guarantee_amount", numToCurrency(assureIndGuarantee.getGuaranteeAmount()));
	                           map.put("guarantee_currency", assureIndGuarantee.getGuaranteeCurrency());
	                           map.put("financial_org", assureIndGuarantee.getFinancialOrg());
	                           map.put("contract_sign_date", assureIndGuarantee.getContractSignDate());
	                           map.put("contract_style", assureIndGuarantee.getContractStyle());
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
		
		//自然人对外担保信息汇总表-----质押-impawn
		public static List<Map> getAssureIndGuaranteeImpawn(String rptKey){
	        try {
	        	List<Map> list=new ArrayList<Map>();
	            StringBuffer hql = new StringBuffer("select ii from AssureIndGuarantee ii where ii.contractType='impawn' and ii.rptKey='"+rptKey+"' Order by id" );
	            
	            @SuppressWarnings("unchecked")
				List<AssureIndGuarantee> listAssureIndGuarantee = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
	            if(null != listAssureIndGuarantee && listAssureIndGuarantee.size()>0){
	            	for (int i = 0; i < listAssureIndGuarantee.size(); i++) {
	            		AssureIndGuarantee assureIndGuarantee = listAssureIndGuarantee.get(i);
	            		   //个人信用报告
	            		   Map<String, Object> map = new HashMap<String, Object>();
	            		   	   map.put("rptKey", assureIndGuarantee.getRptKey());
	            		   	   map.put("contractType", assureIndGuarantee.getContractType());
	            			   map.put("no", assureIndGuarantee.getNo());
	                           map.put("contractNo",assureIndGuarantee.getContractNo() );
	                           map.put("contract_eff_flag",assureIndGuarantee.getContractEffFlag());
	                           map.put("contract_no_amount", numToCurrency(assureIndGuarantee.getContractNoAmount()));
	                           map.put("contract_no_currency", assureIndGuarantee.getContractNoCurrency());
	                           map.put("guarantee_amount", numToCurrency(assureIndGuarantee.getGuaranteeAmount()));
	                           map.put("guarantee_currency", assureIndGuarantee.getGuaranteeCurrency());
	                           map.put("financial_org", assureIndGuarantee.getFinancialOrg());
	                           map.put("contract_sign_date", assureIndGuarantee.getContractSignDate());
	                           map.put("contract_style", assureIndGuarantee.getContractStyle());
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
		
		
		
		//自然人对外担保信息汇总表详细  
				public static List<Map> getAssureIndGuaranteeGuarantDetail(String rptKey,String contractNo,String no,String contractType){
			        try {
			        	List<Map> list=new ArrayList<Map>();
			            StringBuffer hql = new StringBuffer("select ii from AssureIndGuarantee ii where   ii.contractType='"+contractType+"' and  ii.no='"+no+"' and  ii.contractNo='"+contractNo+"' and ii.rptKey='"+rptKey+"'" );
			            @SuppressWarnings("unchecked")
						List<AssureIndGuarantee> listAssureIndGuarantee = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
			            if(null != listAssureIndGuarantee && listAssureIndGuarantee.size()>0){
			            	for (int i = 0; i < listAssureIndGuarantee.size(); i++) {
			            		AssureIndGuarantee assureIndGuarantee = listAssureIndGuarantee.get(i);
			            		   //个人信用报告
			            		   Map<String, Object> map = new HashMap<String, Object>();
			            		   	   map.put("rptKey", assureIndGuarantee.getRptKey());
			            		   	   map.put("contractType", assureIndGuarantee.getContractType());
			            			   map.put("no", assureIndGuarantee.getNo());
			                           map.put("contractNo",assureIndGuarantee.getContractNo() );
			                           map.put("contract_eff_flag",assureIndGuarantee.getContractEffFlag());
			                           map.put("contract_no_amount", numToCurrency(assureIndGuarantee.getContractNoAmount()));
			                           map.put("contract_no_currency", assureIndGuarantee.getContractNoCurrency());
			                           map.put("guarantee_amount", numToCurrency(assureIndGuarantee.getGuaranteeAmount()));
			                           map.put("guarantee_currency", assureIndGuarantee.getGuaranteeCurrency());
			                           map.put("financial_org", assureIndGuarantee.getFinancialOrg());
			                           map.put("contract_sign_date", assureIndGuarantee.getContractSignDate());
			                           map.put("contract_style", assureIndGuarantee.getContractStyle());
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
			
		
		
		//自然人对外担保担保人表
		public static List<Map> getAssureIndGuarantorList(String rptKey,String contractNo,String no,String contractType){
	        try {
	        	List<Map> list=new ArrayList<Map>();
	            StringBuffer hql = new StringBuffer("select ii from AssureIndGuarantorList ii where ii.contractNo='"+contractNo+"' and ii.rptKey='"+rptKey+"' " );
	            
	            @SuppressWarnings("unchecked")
				List<AssureIndGuarantorList> listAssureIndGuaranteeList = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
	            if(null != listAssureIndGuaranteeList && listAssureIndGuaranteeList.size()>0){
	            	for (int i = 0; i < listAssureIndGuaranteeList.size(); i++) {
	            	AssureIndGuarantorList assureIndGuaranteeList = listAssureIndGuaranteeList.get(i);
	            		   //个人信用报告
	            		   Map<String, Object> map = new HashMap<String, Object>();
	            		   	   map.put("rptKey", assureIndGuaranteeList.getRptKey());
	            		   	   map.put("assure_type", assureIndGuaranteeList.getAssureType());
	            			   map.put("no", assureIndGuaranteeList.getNo());
	                           map.put("contractNo",assureIndGuaranteeList.getContractNo() );
	                           map.put("guarantor_name",assureIndGuaranteeList.getGuarantorName());
	                           map.put("guarantor_loancard_no", assureIndGuaranteeList.getGuarantorLoancardNo());
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

		//该担保合同对应主业务汇总信息
		public static List<Map> getAssureIndMainInfo(String rptKey,String contractNo,String no,String contractType){
	        try {
	        	List<Map> list=new ArrayList<Map>();
	            StringBuffer hql = new StringBuffer("select ii from AssureIndMainInfo ii where ii.contractNo='"+contractNo+"' and ii.rptKey='"+rptKey+"' " );
	            
	            @SuppressWarnings("unchecked")
				List<AssureIndMainInfo> listAssureIndMainInfo = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
	            if(null != listAssureIndMainInfo && listAssureIndMainInfo.size()>0){
	            	for (int i = 0; i < listAssureIndMainInfo.size(); i++) {
	            		AssureIndMainInfo assureIndMainInfo = listAssureIndMainInfo.get(i);
	            		   //个人信用报告
	            		   Map<String, Object> map = new HashMap<String, Object>();
	            		   	   map.put("rptKey", assureIndMainInfo.getRptKey());
	            		   	   map.put("assure_type", assureIndMainInfo.getAssureType());
	            			   map.put("no", assureIndMainInfo.getNo());
	                           map.put("contractNo",assureIndMainInfo.getContractNo() );
	                           map.put("biz_type",assureIndMainInfo.getBizType());
	                           map.put("biz_amount", numToCurrency(assureIndMainInfo.getBizAmount()));
	                           map.put("biz_balance", numToCurrency(assureIndMainInfo.getBizBalance()));
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

		//抵押物详细列表信息 
		public static List<Map> getAssureGuarantDetail(String rptKey,String contractNo,String no,String contractType){
	        try {
	        	List<Map> list=new ArrayList<Map>();
	            StringBuffer hql = new StringBuffer("select ii from AssureIndPledgeList ii where   ii.contractType='"+contractType+"' and  ii.no='"+no+"' and  ii.contractNo='"+contractNo+"' and ii.rptKey='"+rptKey+"'" );
	            @SuppressWarnings("unchecked")
				List<AssureIndPledgeList> listAssureIndPledge = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
	            if(null != listAssureIndPledge && listAssureIndPledge.size()>0){
	            	for (int i = 0; i < listAssureIndPledge.size(); i++) {
	            		AssureIndPledgeList assureIndPledgeList = listAssureIndPledge.get(i);
	            		   //抵押物详细
	            		   Map<String, Object> map = new HashMap<String, Object>();
	            		   	   map.put("rptKey", assureIndPledgeList.getRptKey());
	            		   	   map.put("contractType", assureIndPledgeList.getContractType());
	            			   map.put("no", assureIndPledgeList.getNo());
	                           map.put("contractNo",assureIndPledgeList.getContractNo() );
	                           map.put("pledgeNo",assureIndPledgeList.getPledgeNo());
	                           map.put("pledgeAmount", numToCurrency(assureIndPledgeList.getPledgeAmount()));
	                           map.put("pledgeCurrency", assureIndPledgeList.getPledgeCurrency());
	                           map.put("pledgeEstAmount", numToCurrency(assureIndPledgeList.getPledgeEstAmount()));
	                           map.put("pledgeEstCurrency", assureIndPledgeList.getPledgeEstCurrency());
	                           map.put("estDate", assureIndPledgeList.getEstDate());
	                           map.put("estOrgName", assureIndPledgeList.getEstOrgName());
	                           map.put("estOrgCode", assureIndPledgeList.getEstOrgCode());
	                           map.put("pledgeType", assureIndPledgeList.getPledgeType());
	                           map.put("registerOrg", assureIndPledgeList.getRegisterOrg());
	                           map.put("registerDate", assureIndPledgeList.getRegisterDate());
	                           map.put("pledgeDesc", assureIndPledgeList.getPledgeDesc());
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
