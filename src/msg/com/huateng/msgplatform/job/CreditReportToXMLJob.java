package com.huateng.msgplatform.job;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import resource.bean.basic.CorpCust;
import resource.bean.basic.IndApp;
import resource.bean.basic.IndPermit;
import resource.bean.basic.InqCust;
import resource.bean.basic.ReportJobConfig;
import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;
import resource.bean.basic.TCorpApp;
import resource.bean.basic.TCorpPermit;
import resource.bean.basic.TlrInfo;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.common.service.ReportCommonService;

public class CreditReportToXMLJob implements org.quartz.StatefulJob {
    @SuppressWarnings("unused")
	private Logger htlog = Logger.getLogger(CreditReportToXMLJob.class);

    @SuppressWarnings({ "rawtypes" })
	@Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String result = ReportCommonService.JOB_OK;
        Date startTm = null;
        Date endTm = null;
        String jobName = null;
        String jobId = null;
        String remark = "";
        try {
            startTm = new Date();
            jobId = context.getJobDetail().getJobDataMap().getString("jobId");// 定时器主键
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class, jobId);
            jobName = jobConfig.getJobName();
            remark = jobConfig.getJobRemark();
            startTm = new Date();

            if (DateUtil.isHoliday() && "Y".equals(jobConfig.getJustWorkdateRun())) {
                remark = "该JOB只在工作日执行";
                return;
            }
            BusinessUploadService service = new BusinessUploadService();
            DateFormat fmt =new SimpleDateFormat("yyyyMMdd");//年月日
            DateFormat fmt1 =new SimpleDateFormat("HH:mm:ss");//时分秒
            String day=fmt.format(startTm);//获取当前时间的年月日
            String time=fmt1.format(startTm);//获取当前时间的时分秒
            Calendar cal=Calendar.getInstance();
            cal.add(Calendar.DATE,-1);
            String yesterday=new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
            String yesterday1=new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
            String createTime=new SimpleDateFormat("yyyy-MM-dd HHmm").format(new Date());
            System.out.println(yesterday); 
            System.out.println(yesterday1);
            
	  	    SysParams params = new SysParams();
			params = (SysParams) rootdao.query(SysParams.class, new SysParamsPK(
					"XML", "FILEPATH"));
			String filePath=params.getParamVal();
			String fileDatePath=filePath+yesterday1+"/";
			if(!new File(fileDatePath).exists()){
				 new File(fileDatePath).mkdirs();
			 }
			//modify by chensibi start 一代改2代 
			/*String sql1="select inq.create_time,inq.inq_cust_name,inq.inq_cust_id_type," +
					"inq.inq_cust_id,inq.query_reason,ina.status,ind.approve_time,tlr.TLRNO,tlr.TLR_NAME," +
					"tlr.LOGIN_IP " +
					" from Inq_Cust inq left join Tlr_Info tlr on tlr.TLRNO=inq.create_user " +
					" left join Ind_App ina on ina.id=inq.inq_cust_appid" +
					" left join Ind_Permit ind on ind.id_Type = inq.inq_cust_id_type  and ind.name = inq.inq_cust_name and ind.individual_Id = inq.inq_cust_id " +*/
			String sql1="select inq.create_time,inq.name,inq.id_type,"+
					"inq.id_num,inq.query_reason,inq.status,to_char(ind.approve_time,'yyyy-MM-dd HH24:mi:ss'),tlr.TLRNO,tlr.TLR_NAME,"+
					"tlr.LOGIN_IP "+
					" from cust_pboc_per_query inq left join Tlr_Info tlr on tlr.TLRNO=inq.create_user "+
					 " left join Ind_Permit ind on ind.id_Type = inq.id_type and ind.name = inq.name and ind.individual_Id = inq.id_num "+
					" where (inq.create_Time >= '"+yesterday+"000000"+"'"+" and inq.create_Time <= '"+day+"000000"+"'"+")  and  ind.status='1' and tlr.CITY='26'";
			 System.out.println("sql1="+sql1);
// 		    StringBuffer hql =new StringBuffer( "select io from InqCust io where 1=1 ");
// 		    hql.append(" and io.createTime >= '"+yesterday+" 00:00:00"+"'");
//            hql.append(" and io.createTime <= '"+day+" 00:00:00"+"'");
// 	  	    List list=rootdao.queryByCondition(hql.toString());
			Iterator it=rootdao.queryBySQL2(sql1.toString());
 	  	    String filename=fileDatePath+"W10312900H0012_GRZXCXMX_"+createTime+".txt";
	 	  	if(new File(filename).exists()){
		  	    	(new File(filename)).delete();
		  	    }
	 	  	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true),"gbk"));
	 	     while(it.hasNext()){
	 		 Map map = (Map)it.next();
	 		 String tlrNo=transfer_toString(map.get("TLRNO"));
	 		 String tlrName=transfer_toString(map.get("TLR_NAME"));
	 		 String create_Time1=transfer_toString(map.get("CREATE_TIME"));
	 		 String inqCustName=transfer_toString(map.get("NAME"));
	 		 String inqCustIdType=transfer_toString(map.get("ID_TYPE"));
	 		 String inqCustId=transfer_toString(map.get("ID_NUM"));
	 		 String queryReason=transfer_toString(map.get("QUERY_REASON"));
	 		 String status=transfer_toString(map.get("STATUS"));
	 		 String approveTime=transfer_toString(map.get("TO_CHAR(IND.APPROVE_TIME,'YYYY-MM-DDHH24:MI:SS')"));
	 		 String loginIp=transfer_toString(map.get("LOGIN_IP"));
	 		 
	 		 
	 		out.write("W10312900H0012"+",");//机构代码，给出
			out.write("渣打银行西安分行"+",");//用户所属机构 ，给出
			out.write(subStringend("渣打银行西安分行",100)+",");//查询网点名称 ，给出
			out.write(subStringend(tlrNo,30)+",");//查询用户系统名
			out.write(subStringend(tlrName.replaceAll(",", " ").replaceAll("，", " "),20)+",");//查询用户真实姓名
			//给createTime改变格式
			String createTime1=create_Time1.substring(0, 4)+"-"+create_Time1.substring(4, 6)+"-"+create_Time1.substring(6, 8)+
			" "+create_Time1.substring(8, 10)+":"+create_Time1.substring(10, 12)+":"+create_Time1.substring(12, 14);
			out.write(createTime1+",");//查询时间
			out.write(subStringend(inqCustName.replaceAll(",", " ").replaceAll("，", " "),20)+",");//被查询人姓名
			out.write(inqCustIdType+",");//证件类型
			if(inqCustIdType.equals("10")){
				out.write(replaceIdCrad(subStringend(inqCustId,50))+",");//证件号码
			}else{
				out.write(replaceOtherCrad(subStringend(inqCustId,50))+",");//证件号码
			}
			out.write(queryReason+",");//查询原因
			out.write("01"+",");//查询版本 (01 银行版 02自主查询版)
			if(status.equals("03")){ //是否查得
				out.write("1"+",");
			}else{
				out.write("0"+",");
			}
			if(approveTime==null||approveTime.equals("")||approveTime.equals("NULL")){
				out.write(""+",");//查询授权时间
			}else{
			out.write(approveTime+",");//查询授权时间
			}
			out.write(loginIp);//查询机IP
			out.write("\r\n");
	 	   }
	 	    out.close();
	 	  	
// 	  	    if(list !=null&&list.size()>0){
// 	  	    for(int i=0;i<list.size();i++){
// 	  	    	TlrInfo tlrInfo=null;
// 	  	    	IndApp indApp= null;
// 	  	    	IndPermit indPermit=null;
// 	  	    	InqCust inq=(InqCust)list.get(i);
// 	  	    	StringBuffer hqlt =new StringBuffer( "select to from TlrInfo to where 1=1 and city='26'");
// 	  	    	hqlt.append(" and to.tlrno = '"+inq.getCreateUser()+"'");
// 	 	  	    List listt=rootdao.queryByCondition(hqlt.toString());
// 	 	  	    if(listt !=null&&listt.size()>0){
//	 	  	    	tlrInfo=(TlrInfo) listt.get(0);
//	 	  	    }
// 	 	  	 List<IndApp> listApp=service.getIndAppQuery(inq.getInqCustIdType(), inq.getInqCustName(), inq.getInqCustId());
//  	 	  	if(listApp !=null&&listApp.size()>0){
//  	 	  	     indApp = listApp.get(0);
// 		        }
// 		        List<IndPermit> listPermitQuery = service.getIndPermitQuery(inq.getInqCustIdType(), inq.getInqCustName(), inq.getInqCustId());	//查询许可文件	
// 		        if(listPermitQuery !=null&&listPermitQuery.size()>0){
// 		        	indPermit = listPermitQuery.get(0);
// 		        }
// 		      createInqCustTxt(filename,inq,tlrInfo,indPermit,indApp);
// 	  	    }
// 	  	     }else{
// 	  	     createInqCustTxt(filename,null,null,null,null);
// 	  	    }
// 	  	    //modify by chensibi start
	 	  /* String sql2="  select corp.create_time,corp.corp_cust_companyname,corp.corp_cust_loancard, corp.query_reason," +
	 	   		"ta.status,td.approve_time,tlr.TLRNO,tlr.TLR_NAME,tlr.LOGIN_IP " +
	 	   		" from corp_cust corp left join Tlr_Info tlr on tlr.TLRNO=corp.create_user " +
	 	   		" left join t_corp_app ta  on corp.corp_cust_appid=ta.id" +
	 	   		" left join t_corp_permit td  on td.loan_card_no=corp.corp_cust_loancard " +
	 	   		"  where tlr.CITY='26' and td.status='1'   and "+*/
	 	   String sql2="select utl_raw.cast_to_varchar2(utl_raw.cast_to_raw(corp.create_time)) as CREATE_TIME,corp.ent_name,corp.ent_cert_num, corp.query_reason,"+
	 			 " utl_raw.cast_to_varchar2(utl_raw.cast_to_raw(corp.status)) as STATUS,to_char(td.approve_time,'yyyy-MM-dd HH24:mi:ss'),tlr.TLRNO,tlr.TLR_NAME,tlr.LOGIN_IP "+
	 			 " from cust_pboc_ent_query corp left join Tlr_Info tlr on tlr.TLRNO=corp.create_user "+
	 			 " left join t_corp_permit td on td.loan_card_no=corp.ent_cert_num "+
	 			" where tlr.CITY='26' and td.status='1' and "+
	 	    	"  (corp.create_Time >= '"+yesterday+"000000"+"'"+" and corp.create_Time <= '"+day+"000000"+"'"+") ";
		 System.out.println("sql2="+sql2);
		 
		 Iterator it2=rootdao.queryBySQL2(sql2.toString());
// 	  	  StringBuffer hql2 =new StringBuffer( "select io from CorpCust io where 1=1 ");
//		    hql2.append(" and io.createTime >= '"+yesterday+" 00:00:00"+"'");
//          hql2.append(" and io.createTime <= '"+day+" 00:00:00"+"'");
//	  	    List list2=rootdao.queryByCondition(hql2.toString());
	  	    String filename2=filePath+yesterday1+"/"+"W10312900H0012_QYZXCXMX_"+createTime+".txt";
	  	    if(new File(filename2).exists()){
	  	    	(new File(filename2)).delete();
	  	    }
	  	  BufferedWriter out1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename2,true),"gbk"));
	 	     while(it2.hasNext()){
	 		 Map map = (Map)it2.next();
	 		 String tlrNo=transfer_toString(map.get("TLRNO"));
	 		 String tlrName=transfer_toString(map.get("TLR_NAME"));
	 		 String create_Time2=transfer_toString(map.get("CREATE_TIME"));
	 		 String corpCustCompanyName=transfer_toString(map.get("ENT_NAME"));//corp_cust_loancard
	 		 String corpCustLoancard=transfer_toString(map.get("ENT_CERT_NUM"));
	 		 String status=transfer_toString(map.get("STATUS"));
	 		 String approveTime=transfer_toString(map.get("TO_CHAR(TD.APPROVE_TIME,'YYYY-MM-DDHH24:MI:SS')"));
	 		 String loginIp=transfer_toString(map.get("LOGIN_IP"));
	 		 
	 		 
	 		out1.write("W10312900H0012"+",");//机构代码，给出
			out1.write("渣打银行西安分行"+",");//用户所属机构 ，给出
			out1.write(subStringend("渣打银行西安分行",100)+",");//查询网点名称 ，给出
			out1.write(subStringend(tlrNo,30)+",");//查询用户系统名
			out1.write(subStringend(tlrName.replaceAll(",", " ").replaceAll("，", " "),20)+",");//查询用户真实姓名
			//部门名称
			out1.write(subStringend("渣打银行西安分行",20)+",");
			String createTime2=create_Time2.substring(0, 4)+"-"+create_Time2.substring(4, 6)+"-"+create_Time2.substring(6, 8)+
					" "+create_Time2.substring(8, 10)+":"+create_Time2.substring(10, 12)+":"+create_Time2.substring(12, 14);
			out1.write(createTime2.toString()+",");//查询时间
			out1.write(subStringend(corpCustCompanyName.replaceAll(",", " ").replaceAll("，", " "),100)+",");//被查询单位名称
			out1.write(subStringend(corpCustLoancard,50)+",");//中证码
			if(status.equals("03")){ //是否查得
				out1.write("1"+",");
			}else{
				out1.write("0"+",");
			}
			out1.write(approveTime+",");//查询授权时间
			out1.write(loginIp);//查询机IP
			out1.write("\r\n");
	 	   }
	 	    out1.close();
//	  	    if(list2 !=null&& list2.size()>0){
//	  	    for(int i=0;i<list2.size();i++){
//	  	    	TlrInfo tlrInfo=null;
//	  	    	TCorpPermit tCorpPermit=null;
//	  	    	TCorpApp tCorpApp=null;
//	  	    	CorpCust corpCust=(CorpCust)list2.get(i);
//	  	    	StringBuffer hqlt =new StringBuffer( "select to from TlrInfo to where 1=1 and city='26'");
//	  	    	hqlt.append(" and to.tlrno = '"+corpCust.getCreateUser()+"'");
//	 	  	    List listt=rootdao.queryByCondition(hqlt.toString());
//	 	  	    if(listt !=null&&listt.size()>0){
//	 	  	    	tlrInfo=(TlrInfo) listt.get(0);
//	 	  	    }
//		        List<TCorpPermit> listPermitQuery = service.getTCorpPermitQuery(corpCust.getCorpCustLoancard());	//查询许可文件				
//		       if(listPermitQuery !=null&&listPermitQuery.size()>0){
//		    	  tCorpPermit = listPermitQuery.get(0);
//		       }
//		       List<TCorpApp> listCorpApp=service.getTCorpAppQuery(corpCust.getCorpCustLoancard());		
//		       if(listCorpApp !=null&&listCorpApp.size()>0){
//		    	   tCorpApp = listCorpApp.get(0);
//		       }
//		      createCorpCustTxt(filename2,corpCust,tlrInfo,tCorpPermit,tCorpApp);
//	  	    }
//	  	    }else{ 
//	  	    	createCorpCustTxt(filename2,null,null,null,null);
//	  	        }
         
        } catch (Exception e) {
            e.printStackTrace();
            result = ReportCommonService.JOB_FAILED;
            remark = e.getMessage();
        } finally {
            endTm = new Date();
            ReportCommonService.getInstance().saveJobLog(startTm, endTm, jobId, result, jobName, remark);
        }
    }
    
    
	private void createCorpCustTxt(String filename, CorpCust corpCust,
			TlrInfo tlrInfo, TCorpPermit tCorpPermit,TCorpApp tCorpApp) throws FileNotFoundException {
		BufferedWriter out=null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true),"gbk"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		if(corpCust==null||tlrInfo==null||tCorpPermit==null||tCorpApp==null){
		 try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		}else{
		try{
			out.write("W10312900H0012"+",");//机构代码，给出
			out.write("渣打银行西安分行"+",");//用户所属机构 ，给出
			out.write(subStringend("渣打银行西安分行",100)+",");//查询网点名称 ，给出
			out.write(subStringend(tlrInfo.getTlrno(),30)+",");//查询用户系统名
			out.write(subStringend(tlrInfo.getTlrName().replaceAll(",", " ").replaceAll("，", " "),20)+",");//查询用户真实姓名
			//部门名称
			out.write(subStringend("渣打银行西安分行",20)+",");
			out.write(corpCust.getCreateTime().toString()+",");//查询时间
			out.write(subStringend(corpCust.getCorpCustCompanyname().replaceAll(",", " ").replaceAll("，", " "),100)+",");//被查询单位名称
			out.write(subStringend(corpCust.getCorpCustLoancard(),50)+",");//中证码
			if(tCorpApp.getStatus().equals("0")){ //是否查得
				out.write("1"+",");
			}else{
				out.write("0"+",");
			}
			out.write(formatDate(tCorpPermit.getApproveTime().toString())+",");//查询授权时间
			out.write(tlrInfo.getLoginIp());//查询机IP
			out.write("\r\n");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				out.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		}
	}


	public static void createInqCustTxt(String file,InqCust inq,TlrInfo tlrInfo,IndPermit indPermit,IndApp indApp) throws FileNotFoundException{
		BufferedWriter out=null;
		if(inq==null||tlrInfo==null||indPermit==null||indApp==null){
			try {
				out= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"gbk"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
		try{
			out= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true),"gbk"));
			out.write("W10312900H0012"+",");//机构代码，给出
			out.write("渣打银行西安分行"+",");//用户所属机构 ，给出
			out.write(subStringend("渣打银行西安分行",100)+",");//查询网点名称 ，给出
			out.write(subStringend(tlrInfo.getTlrno(),30)+",");//查询用户系统名
			out.write(subStringend(tlrInfo.getTlrName().replaceAll(",", " "),20)+",");//查询用户真实姓名
			out.write(inq.getCreateTime().toString()+",");//查询时间
			out.write(subStringend(inq.getInqCustName().replaceAll(",", " "),20)+",");//被查询人姓名
			out.write(inq.getInqCustIdType()+",");//证件类型
			if(inq.getInqCustIdType().equals("0")){
				out.write(replaceIdCrad(subStringend(inq.getInqCustId(),50))+",");//证件号码
			}else{
				out.write(replaceOtherCrad(subStringend(inq.getInqCustId(),50))+",");//证件号码
			}
			out.write(inq.getQueryReason()+",");//查询原因
			out.write("01"+",");//查询版本 (01 银行版 02自主查询版)
			if(indApp.getStatus().equals("0")){ //是否查得
				out.write("1"+",");
			}else{
				out.write("0"+",");
			}
			if(indPermit.getApproveTime()==null||indPermit.getApproveTime().equals("")){
				out.write(""+",");//查询授权时间
			}else{
			out.write(formatDate(indPermit.getApproveTime().toString())+",");//查询授权时间
			}
			out.write(tlrInfo.getLoginIp());//查询机IP
			out.write("\r\n");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				out.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	  }
	}
	
	public static String replaceIdCrad(String num){
		String sbf=new String();
		if(null != num && num.length()>6){
			 sbf+=num.substring(0,6);
			 for (int i = 1; i <=num.length()-6; i++) {
			    sbf+="*";
			   if(sbf.length()>=14) break;
			 }
			 if(num.length()>14){
				 sbf+=num.substring(14);
			 }
			 return sbf;
		}
		return num;
	}
	
	
	public static String replaceOtherCrad(String num){
		String sbf=new String();
		if(null != num && num.length()>6){
			    sbf+=num.replace(num.substring(num.length()-6,num.length()), "******");
		}
		else{
			for(int i=0;i<num.length();i++){
				sbf+="*";
			}
		}
		return sbf;
	}
	
	
	
	public static String formatDate(String date){
		if(date==null||date==""||date.equals("")){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String returnDate = null;
		try {
			returnDate = sdf.format(sdf.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return returnDate;
	}
	
	public static String subStringend(String sub,int length){
		if(sub==null){
			return "";
		}else if(sub.length()>length){
			return sub.substring(0, length);
		}else{
			return sub;
		}
	}
	
	
	 private String transfer_toString(Object str_son) {
	    	if(null==str_son)
	    		return "NULL".toString();
	    	return str_son.toString();
	    }
    
}
