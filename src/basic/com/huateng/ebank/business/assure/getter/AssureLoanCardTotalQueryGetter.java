package com.huateng.ebank.business.assure.getter;

import com.huateng.ebank.business.common.ROOTDAOUtils;

import resource.bean.basic.TDetailIndInfo;
import resource.bean.basic.TDetailIndResult;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssureLoanCardTotalQueryGetter {

	// 自然人中证码
	public static List<Map> getTDetailIndResult(String rptKey) {
		try {
			List<Map> list = new ArrayList<Map>();
			StringBuffer hql = new StringBuffer(
					"select ii from TDetailIndResult ii where ii.rptKey='" + rptKey + "'");
			StringBuffer hqlTDetailIndInfo = new StringBuffer(
					"select ii from TDetailIndInfo ii where ii.rptKey='" + rptKey + "'");
			List<TDetailIndResult> listTDetailIndResult = ROOTDAOUtils
					.getROOTDAO().queryByCondition(hql.toString());
			List<TDetailIndInfo> listTDetailIndInfo = ROOTDAOUtils.getROOTDAO()
					.queryByCondition(hqlTDetailIndInfo.toString());
			
			if (null != listTDetailIndResult && listTDetailIndResult.size() > 0) {
				
				for (int i = 0; i < listTDetailIndResult.size(); i++) {
					Map<String, Object> map = new HashMap<String, Object>();
					if (null != listTDetailIndInfo && listTDetailIndInfo.size() > 0) {
						TDetailIndInfo tDetailIndInfo = listTDetailIndInfo.get(0);
						map.put("individualId", nullToSpase(tDetailIndInfo.getIndividualId()));
						map.put("individualType", nullToSpase(tDetailIndInfo.getIndividualType()));
						map.put("address", nullToSpase(tDetailIndInfo.getAddress()));
						map.put("contactAddress", nullToSpase(tDetailIndInfo.getContactAddress()));
						map.put("contactNo", nullToSpase(tDetailIndInfo.getPhone()));
					}
					TDetailIndResult tDetailIndResult = listTDetailIndResult .get(i);
					map.put("rptKey", nullToSpase(tDetailIndResult.getRptKey()));
					map.put("chineseName", nullToSpase(tDetailIndResult.getChineseName()));
					map.put("englistName", nullToSpase(tDetailIndResult.getEnglistName()));
					map.put("orgCreditCode", nullToSpase(tDetailIndResult.getOrgCreditCode()));
					map.put("orgCode", nullToSpase(tDetailIndResult.getOrgCode()));
					map.put("loancardNo", nullToSpase(tDetailIndResult.getLoancardNo()));
					map.put("registType", nullToSpase(tDetailIndResult.getRegistType()));
					map.put("registCode", nullToSpase(tDetailIndResult.getRegistCode()));
					map.put("countryTaxCode", nullToSpase(tDetailIndResult.getCountryTaxCode()));
					map.put("regionTaxCode", nullToSpase(tDetailIndResult.getRegionTaxCode()));
					list.add(map);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String nullToSpase(String s){
		if(s != null){
			return s;
		}else{
			return "";
		}
	}
	/**
	 * 转换金额类型
	 * 
	 * @param amount
	 * @return
	 */
	public static String numToCurrency(Float amount) {
		if (null != amount) {
			DecimalFormat df = null;
			df = new DecimalFormat("###,##0.00");
			double number = Double.parseDouble(String.valueOf(amount.toString()
					.replaceAll(",", "")));
			return df.format(number);
		}
		return amount.toString();
	}

	public static String numToCurrency(String amount) {
		if (null != amount && (!"--".equals(amount))) {
			DecimalFormat df = null;
			df = new DecimalFormat("###,##0.00");
			double number = Double.parseDouble(String.valueOf(amount
					.replaceAll(",", "")));
			return df.format(number);
		}
		return amount;
	}

}
