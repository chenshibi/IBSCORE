package com.huateng.ebank.business.customer.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.common.bean.IndEnquiryBean;
import com.huateng.ebank.business.common.bean.OverCreditBean;
import com.huateng.ebank.business.customer.action.CustomerLevelQueryUtil;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

import resource.bean.basic.IndCrdDetail;
import resource.bean.basic.IndLonDetail;


public class CustomerLevelService {

    private static final String DATASET_ID = "CustomerLevelService";
    private static final HtLog htlog = HtLogFactory.getLogger(CustomerLevelService.class);
	

    private ROOTDAO rootdao;

    public synchronized static CustomerLevelService getInstance() {
        return (CustomerLevelService) ApplicationContextUtils.getBean(DATASET_ID);
    }

    public <T> T selectById(String id, T t)
    {
      ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
      Object t1 = null;
      try {
        t1 = rootdao.query(t.getClass(), id);
      } catch (CommonException e) {
        htlog.info("对象不存在");
        e.printStackTrace();
      }
      return (T) t1;
    }
    //获取 1个或多个 担保人 对应的不同业务类型的   最近 24个月的还款状态集合 ("/////////////////////NNC","/////////////*NNN1NN3NNN",....)
	public  ArrayList<String>  getMonth24s(ArrayList<String> listRpdids, String type) throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		ArrayList<String> listMonth24s = new ArrayList<String>();
		String rptId = listRpdids.get(0);
		for(int i = 1 ;i < listRpdids.size();i++){
			rptId = rptId + "','" + listRpdids.get(i);//用','分隔拼成长字符串:"2016062100002952336883,2016062100002952309411"       
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		StringBuffer hql = null;
		if (type.equals("CARD")) {
			hql = new StringBuffer("select po from IndCrdDetail po where 1=1 and rptId in ('"+rptId+"')");
			hql.append(" ORDER BY GETDATE DESC");
			List<IndCrdDetail> listIndCrdDetail = rootdao.queryByCondition(hql.toString());
			for(IndCrdDetail crdDetail: listIndCrdDetail){
				String cmonth24 = getCurrentMonth24(crdDetail.getMonth24(),sdf.format(crdDetail.getYearmonth()));
				listMonth24s.add(cmonth24);
			}
		} else if (type.equals("LOAN")) {
			hql = new StringBuffer("select po from IndLonDetail po where 1=1 and  rptId in ('"+rptId+"')");
			hql.append(" ORDER BY GETDATE DESC");
			List<IndLonDetail> listIndLonDetail= rootdao.queryByCondition(hql.toString());
			for(IndLonDetail lonDetail: listIndLonDetail){
				String cmonth24 = getCurrentMonth24(lonDetail.getMonth24(),sdf.format(lonDetail.getYearmonth()));
				listMonth24s.add(cmonth24);
			}
		}
  		return listMonth24s;
	}
	//获取最近24个月的还款状态
	  public String getCurrentMonth24(String month24, String yearmonth) {
		    String cmonth24 = month24;
		    Date nowdate = new Date();
		    String[] yearmon = yearmonth.split("-");
		    SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
		    SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
		    int nowYear = Integer.parseInt(sdfYear.format(nowdate));
		    int nowMonth = Integer.parseInt(sdfMonth.format(nowdate));
		    int currentmonth = nowYear * 12 + nowMonth - 1;
		    int cmonth = Integer.parseInt(yearmon[0]) * 12 + Integer.parseInt(yearmon[1]);
		    int cm = currentmonth - cmonth;
		    if (cm > 0) {
		      for (int j = 0; j < cm; j++) {
		        cmonth24 = cmonth24 + "*";
		      }
		      cmonth24 = cmonth24.substring(cmonth24.length() - 24, cmonth24.length());
		    }

		    return cmonth24;
		  }
	//将对应n个担保人最近24个月的还款状态全部按条件(逾期和正常)替换，其他都默认为"*"状态,merged_month24融合成为对应n个担保人最近24个月还款状态的字符串,[注意]将每个月状态筛选替换为所有当月最大逾期数(1-7)或者N
	  public String getMergedMonth24(ArrayList<String> month24s)
	  {
	    ArrayList<String> merged_month24 = new ArrayList<String>();
	    for (int i = 0; i < 24; i++)
	      merged_month24.add("*");
	      String month24;
	      for (int i = 0; i < 24; i++) {
	      for (int j = 0; j < month24s.size(); j++) {
	        month24 = (String)month24s.get(j);
	        String c = month24.substring(i, i + 1);
	        if (Character.isDigit(c.toCharArray()[0])) {
	          if ((((String)merged_month24.get(i)).equals("*")) || (((String)merged_month24.get(i)).equals("N")))
	            merged_month24.set(i, c);
	          else if ((Character.isDigit(((String)merged_month24.get(i)).toCharArray()[0])) && (Integer.parseInt(c) > Integer.parseInt((String)merged_month24.get(i))))
	            merged_month24.set(i, c);
	        }
	        else if (("N".equals(c)) && ("*".equals(merged_month24.get(i)))) {
	          merged_month24.set(i, c);
	        }
	      }
	    }
	    StringBuffer mergedmonth24 = new StringBuffer();
	    for (String a : merged_month24) {
	      mergedmonth24.append(a);
	    }
	    return mergedmonth24.toString();
	  }
	
	/**
	 * 如果在最近的24个月内没有任何贷款/信用卡，或贷款/信用卡使用记录（即还款状态在N，1-7的范围内），则该变量返回值应为missing
	 * 担保人最近24个月使用借贷业务时，返回担保人最近24个月每个月最大逾期次数加总(同一个月中，所有记录逾期  天  数只取最大);没使用借贷业务时，返回"missing"
	 * 如果在最近的24个月内没有任何贷款/信用卡，或贷款/信用卡使用记录（即还款状态在N，1-7的范围内），则该变量返回值应为missing。
	 * 
	 * @param total_merged_month24
	 * @return count 或  "missing"
	 */
	public  String getDPDX24M(String total_merged_month24)
	{
		if (check_Missing(total_merged_month24, 24, 24)) {//担保人最近24个月没使用卡，即没有碰借贷这块业务，返回missing
			return "missing";
		}
		   int count = 0;
		    for (int i = 0; i < 24; i++) {
		      String c = total_merged_month24.substring(i, i + 1);
		      if ((!Character.isDigit(c.toCharArray()[0])) || 
		        (Integer.parseInt(c) <= 0)) continue;
		      count++;
		    }

		    return String.valueOf(count);
	}
	
	public  boolean check_Missing(String month24,int length,int count)//(total_merged_month24, 24, 24)//(total_merged_month24, 12, 12) //(crd_merged, 12, 8)
	{
		int mc = 0;
		for (int i = 1;i <= length; i++) {//24//12
			String c = month24.substring(24 - i, 25 - i);//(23,24)(22,23).。。(0,1)前24个状态 倒排    担保人的状态
			if ("*".equals(c)) {//'*-当月未使用额度且不需要还款''*-本月没有还款历史'
				mc++;;//担保人没使用卡的次数
			}
		}
	  return mc >= count;//mc >=24  担保人没使用卡
	}
	/**
	 * 如果在最近的12个月内，没有任何贷款/信用卡，或没有贷款/信用卡使用记录，则该变量返回值为Missing
	 * 0的意义为没有一个月份是在正常状态。所以0和missing要区分。
	 * 担保人最近12个月使用借贷业务，返回担保人最近12个月正常还款次数加总 (所有对应记录必须同一个月都正常还款);没使用返回 "missing"
	 * @param total_merged_month24
	 * @return count 或  "missing"
	 */
	public  String getCurrent12M(String total_merged_month24)
	{
		  if (check_Missing(total_merged_month24, 12, 12)) {//(23,24)(22,23)...(12,13)担保人最近12个月没使用借贷业务
		    return "missing";
		  }
		 int count = 0;
		  for (int i = 1; i <= 12; i++) {
		    String c = total_merged_month24.substring(24-i,25-i);//担保人最近12个月正常还款次数加总
		    if ("N".equals(c)) {//N-正常
		    	count++;
		    }
		  }
		  return String.valueOf(count);
	}
	/**
	 * 
	 * 判断有记录的月份次数是否达到8个月及以上，否则该变量应用missing值覆盖
	 * 担保人最近12个月使用借贷业务小于等于4次时，返回担保人最近12个月最大逾期数(同一个月中，所有记录逾期次数只取最大);使用大于4次时返回"missing";
	 * @param merged
	 * @param length
	 * @param count
	 * @return str(最大逾期数) 或  "missing"
	 */
	public String getLastMaxMonth(String merged, int length, int count) {//(crd_merged, 12, 8)
		if (check_Missing(merged, length, count)) {//担保人 卡业务 最近12个月没使用借贷次数大于等于8次
			return "missing";
		}
		char str = '0';
		for (int i = 1; i <= length; i ++) {
			
		    char sub = merged.charAt(merged.length() - i);//担保人最近12个月状态  24-1=23,22...12
		    if ((!Character.isDigit(sub)) || 
		            (sub <= str)) continue;
		          str = sub;
		  }
		 return String.valueOf(str);
	}
	
	/**
	 * 如果最近6个月内没有任何信用卡，则该变量返回值应为missing;
	 * 0的意义为没有信用卡使用记录
	 * 对应担保人的信用报告最近12个月((从前12个月的1号开始算到查询当天))因（'贷款审批','信用卡审批','担保资格审查'）每个月被查询平均次数（如n个人，每个月查询有n条次数，选取每个月查询次数的最大值）
	 * @param rpdids
	 * @return dfAvg.format((double)sum/12)
	 * @throws CommonException
	 */
	public String getAvgEnq12M(ArrayList<String> rpdids) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Map<String,String> enqmonth = new HashMap<String,String>();
		SimpleDateFormat dfMonth = new SimpleDateFormat("M");
		SimpleDateFormat dfYear = new SimpleDateFormat("yyyy");
		SimpleDateFormat dfTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		DecimalFormat dfAvg = new DecimalFormat("0.00000000");//格式化小数    
		String nowMonth = dfMonth.format(new Date());//10
		String nowYear = dfYear.format(new Date());//2019
		String nowYearString = null;
		for (int i = 0; i <= 12; i ++) {
			int monthTmp = Integer.parseInt(nowMonth) - i;//10,9,8...0,-1,-2
			if(monthTmp <= 0){//i=10/11/12
				monthTmp = 12 + monthTmp;//12,11,10
				nowYearString =(Integer.parseInt(nowYear)-1) + "";//"2018"
			}else{
				nowYearString=nowYear;//"2019"
			}
			String months = monthTmp+"";
			enqmonth.put(nowYearString+"-"+months, "0");//("2019-10","0"),("2019-9","0")...("2018-10","0")最近12个月
		}
		int enqDateMonths = Integer.parseInt(nowMonth) - 12;//-2
		if(enqDateMonths <= 0){
			enqDateMonths = 12 + enqDateMonths;//10
			nowYear =(Integer.parseInt(nowYear)-1) + "";//2018
		}
		String enq_date = nowYear + "-" + enqDateMonths + "-01";//"2018-10-01"   最近12个月的第1个月1日 
		String rpt_str = CustomerLevelQueryUtil.implode("','", rpdids);////把所有rpdids用 ',' 分隔拼接成一个字符串
		StringBuffer hql = new StringBuffer("select count(rpt_id) as rptId,to_char(enq_date,'YYYY') as eyear,substr(to_char(enq_date,'YYYY-MM'),-1,2) as emonth from Ind_Enquiry where 1=1 ");
 		hql.append(" and rpt_id in ('"+rpt_str+"')");
 		hql.append(" and reason in ('贷款审批','信用卡审批','担保资格审查') ");
 		//调整为Orace格式的
 		hql.append(" and to_char").append("(").append("enq_date").append(",").append("'").append("YYYY-MM-DD HH:MI:SS").append("'").append(")")
 		.append(">=to_char(to_date(").append("'").append(enq_date).append(" 12:00:00").append("'").append(",").append("'").append("YYYY-MM-DD HH:MI:SS").append("'")
 		.append(")").append(",").append("'").append("YYYY-MM-DD HH:MI:SS").append("'").append(")");
 	//	hql.append(" and enq_date >='" +enq_date+" 00:00:00"+"'");//最近12个月
 		hql.append(" group by rpt_id,");
 		hql.append("to_char").append("(").append("enq_date").append(",").append("'").append("YYYY").append("'").append(")").append(",");
 		hql.append("substr").append("(").append("to_char").append("(").append("enq_date").append(",").
 		append("'").append("YYYY-MM").append("'").append(")").append(",").append("-1").append(",").append("2").append(")")
 		.append("order by rpt_id");
 	  	 Iterator queryBySQL = rootdao.queryBySQLK(hql.toString());
 	  	 List<IndEnquiryBean> rowsList=new ArrayList<IndEnquiryBean>();
    	 while(queryBySQL.hasNext()) {
    		   Map map = (Map)queryBySQL.next();
    		   IndEnquiryBean  indBean=new IndEnquiryBean();
    		   if(map.get("rptId")!=null) {
    			   indBean.setRptId(map.get("rptId").toString());
    		   }
    		   if(map.get("eyear")!=null) {
    			   indBean.setEyear(map.get("eyear").toString());
    		   }
    		   if(map.get("emonth")!=null) {
    			   indBean.setEmonth(map.get("emonth").toString());
    		   }
    		   rowsList.add(indBean);
    	 }
 		
		if(null != rowsList && rowsList.size() > 0){
			for (int i = 0; i < rowsList.size(); i++) {
				// Object[] obj=(Object[]) rowsList.get(i);//
				IndEnquiryBean indEnquiryBean = rowsList.get(i);
			//	String month = String.valueOf(obj[1]) + "-" + String.valueOf(obj[2]);//年月 "2018-10"
				String month=indEnquiryBean.getEyear()+"-"+indEnquiryBean.getEmonth();
				Long number =Long.valueOf(indEnquiryBean.getRptId()) ;//次数
				 if ((enqmonth.get(month) == null) || 
				          (Long.valueOf(number.longValue()).compareTo(Long.valueOf((String)enqmonth.get(month))) <= 0)) continue;
				        enqmonth.put(month, String.valueOf(number));
				
			}
		}
		int sum = CustomerLevelQueryUtil.getMapValueSum(enqmonth);
		return dfAvg.format(sum / 12.0D);
	}
	/**
	 * 最近6个月担保人(贷记卡/准贷记卡)的  已使用额度占共享授信额度比例
	 * @param rptids
	 * @return
	 * @throws CommonException
	 */
	public String getAvgCCUtil6M(ArrayList<String> rptids) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Date nowDate = new Date();
		Calendar dar = Calendar.getInstance();
		dar.setTime(nowDate);
		dar.add(Calendar.MONTH, -6);
		Date nowDateBefore6Month = dar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		DecimalFormat dfAvg = new DecimalFormat("0.00000000");//格式化小数   
		String date =  sdf.format(nowDateBefore6Month);//6个月前的年月2019-04
		String rpt_str = CustomerLevelQueryUtil.implode("','", rptids);//把所有rpdids用‘,’分隔拼接成一个字符串
		StringBuffer hql = new StringBuffer("select count(rpt_id) as rptId from Ind_Crd_Detail  where 1=1 ");//最近6个月担保人信用卡记录总次数
		hql.append(" and rpt_id in ('"+rpt_str+"')");
	//	hql.append(" and yearmonth >='" +date+"-01 00:00:00.000"+"'");
		hql.append(" and to_char").append("(").append("yearmonth").append(",").append("'").append("YYYY-MM HH:MI").append("'").append(")");
		hql.append(">=to_char(to_date(").append("'").append(date).append("'").append(",").append("'").append("YYYY-MM HH:MI").append("'");
		hql.append(")").append(",").append("'").append("YYYY-MM HH:MI").append("'").append(")");
	//	hql.append(">=").append("'").append(date).append(" 00:00:00").append("'");
		Iterator queryBySQLRpdID = rootdao.queryBySQLRpdID(hql.toString());
		List<String> rowsList = new ArrayList<String>();
		 while(queryBySQLRpdID.hasNext()) {
  		   Map map = (Map)queryBySQLRpdID.next();
  		   if(map.get("rptId")!=null) {
  			   rowsList.add(map.get("rptId").toString());
  		   }
  	 }
		if(null != rowsList && rowsList.size() > 0){
			if(rowsList.get(0).toString().equals("0")){
				return "missing";//没有记录则返回"missing";
			}
		}
	    StringBuffer hqlSum = new StringBuffer("select sum(overdue) as overdue, sum(share_) as credit from Ind_Crd_Detail where 1=1 ");
		hqlSum.append(" and rpt_id in ('"+rpt_str+"')");
		//	hqlSum.append(" and yearmonth >='" +date+"-01 00:00:00.000"+"'");//最近6个月担保人信用卡 已使用额度总和 和 共享授信额度总和
		hqlSum.append(" and to_char").append("(").append("yearmonth").append(",").append("'").append("YYYY-MM HH:MI").append("'").append(")");
		hqlSum.append(">=to_char(to_date(").append("'").append(date).append("'").append(",").append("'").append("YYYY-MM HH:MI").append("'");
		hqlSum.append(")").append(",").append("'").append("YYYY-MM HH:MI").append("'").append(")");
		Iterator queryBySQLF = rootdao.queryBySQLF(hqlSum.toString());
		List<OverCreditBean> listSum = new ArrayList<OverCreditBean>();
		 while(queryBySQLF.hasNext()) {
	  		   Map map = (Map)queryBySQLF.next();
	  		   OverCreditBean bean=new OverCreditBean();
	  		   if(map.get("overdue")!=null) {
	  			    bean.setOverdue(map.get("overdue").toString());
	  		   }if(map.get("credit")!=null) {
	  			    bean.setCredit(map.get("credit").toString());
	  		   }
	  		   listSum.add(bean);
	  	 }
		StringBuffer credit = new StringBuffer("");
		StringBuffer overdue = new StringBuffer("");
		if(null != listSum && listSum.size() > 0){
			OverCreditBean overCreditBean = listSum.get(0);
	//		Object[] obj=(Object[]) listSum.get(0);
			overdue.append(overCreditBean.getOverdue());
			credit.append(overCreditBean.getCredit());
		}else{
			return "0";
		}
		/*if(credit.toString().compareTo("0") > 0 && credit.toString().compareTo("0.0") > 0){
			return dfAvg.format((double)(1.0 * Double.parseDouble(overdue.toString()) / Double.parseDouble(credit.toString())));
		}else{
			return "0";
		}*/
		 if ((credit.toString().compareTo("0") > 0) && (credit.toString().compareTo("0.0") > 0)) {
		      return dfAvg.format(1.0D * Double.parseDouble(overdue.toString()) / Double.parseDouble(credit.toString()));
		    }
		    return "0";
	}


	
	public void CustomerLevelQuerySave(String loanCardId,String companyName,List queryList,String DPDX24M,String Current12M,String WorstCCStatus12M,String WorstPLStatus12M,String AvgEnq12M,String AvgCCUtil6M) throws Exception {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		GlobalInfo globalInfo=GlobalInfo.getCurrentInstance(); 
		 List<String> listRpdids=new ArrayList();
		 List<String> listNames=new ArrayList();
		 if(null != queryList && queryList.size()>0){
		        for (int i = 0; i < queryList.size(); i++) {
		        	Iterator<Entry<String,String>> itor=((Map<String, String>) queryList.get(i)).entrySet().iterator();
		        	while(itor.hasNext()){
		        		Entry<String,String> entry=itor.next();
		        		listRpdids.add(entry.getKey());
		        		listNames.add(entry.getValue());
		        	}
		     	}
		 }
		 
		String listRpdid = listRpdids.get(0);
		for(int i = 1 ;i < listRpdids.size();i++){
			if(null != listRpdids.get(i) && !"".equals(listRpdids.get(i))){
				listRpdid = listRpdid + "," + listRpdids.get(i);
			}
		}
		 
		String listName = listNames.get(0);
		for(int i = 1 ;i < listNames.size();i++){
			if(null != listNames.get(i) && !"".equals(listNames.get(i))){
				listName = listName + "," + listNames.get(i);
			}
		}
		//插入oracle报错：month valid , 原sqlserver数据库中creatime字段类型为datetime,新oracle中为timestamp类型，故将sysdate替换为systimestamp（测试为最简洁方式）.另一种方式 ：to_timestamp(to_char(sysdate,'yyyy-mm-dd hh24:mi:ssxff'),'yyyy-mm-dd hh24:mi:ssxff')
		//sysdate      插入精度为：'2020-01-10 16:19:31.000000'   
		//systimestamp 插入精度为：'2020-01-10 16:19:31.383000'
		//String sql = " INSERT INTO t_customer_enquiry (loancardid ,accomname ,keymanids ,keymannames ,input_time,pwid ,DPDX24M,Current12M,WorstCCStatus12M,WorstPLStatus12M,AvgEnq12M,AvgCCUtil6M ) "
		//		+" VALUES ('"+loanCardId+"','"+companyName+"','"+listRpdid+"','"+listName+"',sysdate,'"+globalInfo.getTlrno()+"','"+DPDX24M+"','"+Current12M+"','"+WorstCCStatus12M+"','"+WorstPLStatus12M+"','"+AvgEnq12M+"','"+AvgCCUtil6M+ "')";
		String sql = " INSERT INTO t_customer_enquiry (loancardid ,accomname ,keymanids ,keymannames ,input_time,pwid ,DPDX24M,Current12M,WorstCCStatus12M,WorstPLStatus12M,AvgEnq12M,AvgCCUtil6M ) "
				+" VALUES ('"+loanCardId+"','"+companyName+"','"+listRpdid+"','"+listName+"',systimestamp,'"+globalInfo.getTlrno()+"','"+DPDX24M+"','"+Current12M+"','"+WorstCCStatus12M+"','"+WorstPLStatus12M+"','"+AvgEnq12M+"','"+AvgCCUtil6M+ "')";
 		rootdao.executeSql(sql);   
	}
	
	
	
}	    
					    

