package com.huateng.msgplatform.job;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import resource.bean.basic.ReportJobConfig;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.msgplatform.service.DataMapService;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.utils.ReportUtils;
@SuppressWarnings("rawtypes")
public class MsgPlatFormProduceCompanySheetJob implements org.quartz.StatefulJob {
    private Logger htlog = Logger.getLogger(MsgPlatFormProduceCompanySheetJob.class);
   
	private Map mstatus=null;
    private Map mcity=null;
    private Map mregion=null;
    private Map mdepartMent=null;
    private Map mreason=null;
    private Map midType=null;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	String result = ReportCommonService.JOB_OK;
        Date endTm = null;
        String jobName = null;
        String jobId = null;
        String remark = "";
        Date startTm=null;
        String Query_time=null;
        String Curr_Y_Month=null;
       
        try {
            jobId = context.getJobDetail().getJobDataMap().getString("jobId");// 定时器主键
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class, jobId);
            jobName = jobConfig.getJobName();
            remark = jobConfig.getJobRemark();
            startTm = new Date();
           // System.out.println("startTm"+startTm);
            String Curr_Date=new SimpleDateFormat("yyyy-MM-dd").format(startTm).toString();
            String Pre_Date=getSpecifiedDayBefore(Curr_Date);
            Query_time=Pre_Date.substring(0,4)+Pre_Date.substring(5,7);
            Curr_Y_Month=Pre_Date.substring(0,4)+Pre_Date.substring(5,7);
            System.out.println("模糊查询的Query_time="+Query_time+",生成报表的年和月份="+Curr_Y_Month);
            if (DateUtil.isHoliday() && "Y".equals(jobConfig.getJustWorkdateRun())) {
                remark = "该JOB只在工作日执行";
                return;
            }
            mstatus=DataMapService.getNameByNo(901);
            mcity=DataMapService.getNameByNo(503);
            mregion=DataMapService.getNameByNo(502);
            mdepartMent=DataMapService.getNameByNo(501);
            mreason=DataMapService.getNameByNo(507);
            midType = DataMapService.getNameByNo(6065);//企业身份标识
            Create_Sheet(Query_time,Curr_Y_Month);
        }
        catch (Exception e) {
                e.printStackTrace();
                result = ReportCommonService.JOB_FAILED;
                remark = e.getMessage();
            }finally {
            endTm = new Date();
            ReportCommonService.getInstance().saveJobLog(startTm, endTm, jobId, result, jobName, remark);
        }
        }
      
       private void Create_Sheet(String Query_time,String Curr_Y_Month) {
    	   ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
    	Connection conn = null,conn1=null,conn2=null;
    	java.sql.PreparedStatement statement = null,statement1=null,statement2=null;
		java.sql.ResultSet rs = null,rs1=null,rs2=null;
        try {
        /*String sql="select   ISNULL(a.create_user,'system') as operator_id,convert(varchar(100),a.create_time,120)  as create_time,convert(varchar(100),b.return_time,120) as return_time,"
        		+ "convert(varchar(100),b.query_time,120) as time,"
        		+ "convert(varchar(100),cdapp.query_time,120) as cdapp_query_time,convert(varchar(100),cdapp.return_time,120) as cdapp_return_time,cdapp.status as cdapp_status,"
        		+ "a.corp_cust_loancard ,a.corp_cust_companyname as company_name,a.query_reason as query_reson,"
        		+ "rtrim(b.status) as query_status,d.CITY ,d.REGION,d.DEPARTMENT,a.create_user_ip,a.consent_file_path,b.rpt_key as app_key,cdapp.rpt_key as detail_key "
        		+ "from corp_cust a left join t_corp_app b on a.corp_cust_appid=b.id left join t_corp_info_basic c on b.rpt_key=c.rpt_key left join "
        		+ "TLR_INFO d on d.TLRNO=a.create_user "
        		+ "left join T_CORP_DETAIL_APP cdapp on a.corp_cust_detail_id=cdapp.id "
        		+ "where convert(varchar(100),b.query_time,121) like '%"
        		+ Query_time+"%' order by return_time desc";*/
        //modify by chensibi 20200303 start  一代改二代，String类型改为Stringbuffer类型增加性能    企业
        StringBuffer sql=new StringBuffer();
        
        sql.append(" select nvl(a.create_user, 'system') as operator_id, utl_raw.cast_to_varchar2(utl_raw.cast_to_raw(NVL(a.create_time,''))) as create_time, utl_raw.cast_to_varchar2(utl_raw.cast_to_raw(NVL(a.resp_time,''))) as return_time,");
        sql.append("utl_raw.cast_to_varchar2(utl_raw.cast_to_raw(NVL(a.send_time,''))) as time, '' as cdapp_query_time, '' as cdapp_return_time,'' as cdapp_status,a.ENT_CERT_NUM as corp_cust_loancard,");
        sql.append(" a.ENT_NAME as company_name, a.query_reason as query_reson,utl_raw.cast_to_varchar2(utl_raw.cast_to_raw(a.status)) as query_status,d.CITY,d.REGION,d.DEPARTMENT,a.rsv7 as create_user_ip,");
        sql.append("b.CUSTOMER_CON_UP as consent_file_path,utl_raw.cast_to_varchar2(utl_raw.cast_to_raw(a.resp_id)) as app_key,'' as detail_key ");
        sql.append(" from cust_pboc_ent_query a ");
        sql.append("left join t_corp_permit b on a.ent_cert_num = b.loan_card_no and and b.status='1' ");
        sql.append("left join t_corp_info_basic c on a.resp_id = c.rpt_key ");
        sql.append("left join TLR_INFO d on d.TLRNO = a.create_user ");
        sql.append("where a.query_date like '%").append(Query_time).append("%' order by a.resp_time desc");
      
        //modify by chensibi 20200303 end 
        System.out.println("sql="+sql);
        Iterator it=rootdao.queryBySQL2(sql.toString());
            htlog.info(sql);
            if(it==null) {
                htlog.info("no message need to be sent.");
                return;
            }
    				//创建工作簿
    				HSSFWorkbook workbook = new HSSFWorkbook();
    				//创建行
    				HSSFRow row = null;
    				//创建单元格
    				HSSFCell cell = null;
    				// 创建一个sheet
    				HSSFSheet sheet = workbook.createSheet("指令相关报表");
    				//左对齐   0x31  文本格式
    		        HSSFCellStyle cellStyle = workbook.createCellStyle();
    		        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
    		        cellStyle.setDataFormat((short)0x31);
    		        //写入行名称
    		        //String title = "指令类型;案件编号;接收时间;maker;checker;反馈时间;反馈结果;金额;公司/个人;开户网点代码;申请机构名称";
    		        String title = "查询操作员ID;贷款卡号码;公司名称;查询原因;一般查询状态;明细报告状态;查询操作员IP;城市;区域;部门;许可文件路径;用户录入时间;一般报告返回时间;一般报告查询时间;明细报告的查询时间;明细报告的返回时间;一般报告查询 与用户录入时间差(秒);一般报告返回与用户录入时间差(秒);一般报告返回与一般报告查询时间差(秒);明细报告查询与用户录入时间差(秒);明细报告返回与用户录入时间差(秒);明细报告返回与明细报告查询时间差(秒);一般查询报告编号;明细查询报告编号;";
    		        String titleList[] = title.split(";");
    		        row = sheet.createRow(0);
    		        row.setHeight((short)300);
    		        for(int i=0 ;i<titleList.length ;i++ ){
    		       	 	cell = row.createCell(i);
    		            cell.setCellStyle(cellStyle);
    		            cell.setCellValue(titleList[i]);
    		            sheet.autoSizeColumn(i,true); 
    		        }
    		        int i=1;
    		        String query_create_time=null;
		        	String return_create_time=null;
		        	String return_query_time=null;
		        	String qc_time=null;
		        	String rc_time=null;
		        	String rq_time=null;
    		        while(it.hasNext()){
    		        	Map map = (Map)it.next();
    		        	String operator_id=transfer_toString(map.get("OPERATOR_ID"));
    		        	String query_time=transfer_toString(map.get("TIME"));
    		        	if(query_time!=null && !"".equals(query_time) && !"null".equals(query_time) && !"NULL".equals(query_time)){
    		        	query_time=query_time.substring(0, 4)+"-"+query_time.substring(4, 6)+"-"+query_time.substring(6, 8)+" "
  				              +query_time.substring(8, 10)+":"+query_time.substring(10, 12)+":"+query_time.substring(12, 14);
    		        	}
    		        	String return_time=transfer_toString(map.get("RETURN_TIME"));
    		        	if(return_time!=null && !"".equals(return_time) && !"NULL".equals(return_time) && !"null".equals(return_time)){
    		        	return_time= return_time.substring(0, 4)+"-"+return_time.substring(4, 6)+"-"+return_time.substring(6, 8)+" "
    				              +return_time.substring(8, 10)+":"+return_time.substring(10, 12)+":"+return_time.substring(12, 14);
    		        	}
    		        	String create_time=transfer_toString(map.get("CREATE_TIME"));
    		        	if(create_time!=null && !"".equals(create_time) && !"null".equals(create_time) && !"NULL".equals(create_time)){
    		        	create_time= create_time.substring(0, 4)+"-"+create_time.substring(4, 6)+"-"+create_time.substring(6, 8)+" "
    				              +create_time.substring(8, 10)+":"+create_time.substring(10, 12)+":"+create_time.substring(12, 14);
    		        	}
    		        	String cdapp_query_time=transfer_toString(map.get("CDAPP_QUERY_TIME"));
    		        	String cdapp_return_time=transfer_toString(map.get("CDAPP_RETURN_TIME"));
    		        	String cdapp_status=checkNull(mstatus,transfer_toString(map.get("CDAPP_STATUS")));
    		        	
    		        if(query_time.equals("NULL")||create_time.equals("NULL")||return_time.equals("NULL")){
    		        	 	 query_create_time=null;
    			        	 return_create_time=null;
    			        	 return_query_time=null;
    			        	 qc_time=null;
    			        	 rc_time=null;
    			        	 rq_time=null;
    		        }else{
    		        	 query_create_time=DateUtil.Between(query_time, create_time);
    		        	 return_create_time=DateUtil.Between(return_time, create_time);
    		        	 return_query_time=DateUtil.Between(return_time, query_time);
    		        	 //modify by chensibi 差值为null；
    		        	 /*qc_time=DateUtil.Between(cdapp_query_time, create_time);
    		        	 rc_time=DateUtil.Between(cdapp_return_time, create_time);
    		        	 rq_time=DateUtil.Between(cdapp_return_time, cdapp_query_time);*/
    		        	 qc_time=null;
    		        	 rc_time=null;
    		        	 rq_time=null;
    		        	 
    		        }	
    		        	
    		        	String loancard_id=transfer_toString(map.get("CORP_CUST_LOANCARD"));
    		        	String company_name=transfer_toString(map.get("COMPANY_NAME"));
    		        	String query_reson=checkNull(mreason,transfer_toString(map.get("QUERY_RESON")));
    		        	String query_status=checkNull(mstatus,transfer_toString(map.get("QUERY_STATUS")));
    		        
    		        	String query_operator_ip=transfer_toString(map.get("CREATE_USER_IP"));
    		        	String city=checkNull(mcity,transfer_toString(map.get("CITY")));
    		        	String region=checkNull(mregion,transfer_toString(map.get("REGION")));
    		        	String Department=checkNull(mdepartMent,transfer_toString(map.get("DEPARTMENT")));
    		        	String consent_file_path=	transfer_toString(map.get("CONSENT_FILE_PATH"));
    		        	String app_key=	transfer_toString(map.get("APP_KEY"));
    		        	String detail_key=	transfer_toString(map.get("DETAIL_KEY"));
    		        	row = sheet.createRow(i);
    		        	row.setHeight((short)300);
    		    		//查询操作员id
    		        	Create_Style_Value(0,cellStyle,operator_id,row,cell);
    		    		//证件类型
    		         	Create_Style_Value(1,cellStyle,loancard_id,row,cell);
    		    		//证件号
    		         	//Create_Style_Value(3,cellStyle,reg_organ_code,row,cell);
    		    		//姓名
    		         	Create_Style_Value(2,cellStyle,company_name,row,cell);
    		    		//查询原因
    		         	Create_Style_Value(3,cellStyle,query_reson,row,cell);
    		    		//查询状态
    		          	Create_Style_Value(4,cellStyle,query_status,row,cell);
    		            //查询时间
    		        	Create_Style_Value(5,cellStyle,cdapp_status,row,cell);
    		    		//查询操作员ip
    		        	Create_Style_Value(6,cellStyle,query_operator_ip,row,cell);
    		    		//city
    		        	Create_Style_Value(7,cellStyle,city,row,cell);
    		    		//region
    		        	Create_Style_Value(8,cellStyle,region,row,cell);
    		    		//Deparatment
    		        	Create_Style_Value(9,cellStyle,Department,row,cell);
    		    		//role
    		        	//Create_Style_Value(11,cellStyle,ROLE_NAME,row,cell);
    		    		//许可文件路径
    		        	Create_Style_Value(10,cellStyle,consent_file_path,row,cell);
    		        	//创建时间
    		        	Create_Style_Value(11,cellStyle,create_time,row,cell);
    		        	//返回时间
    		        	Create_Style_Value(12,cellStyle,return_time,row,cell);
    		        	//查询时间
    		        	Create_Style_Value(13,cellStyle,query_time,row,cell);
    		        	
    		        	//T_CORP_DETAIL_APP创建时间
    		        	Create_Style_Value(14,cellStyle,cdapp_query_time,row,cell);
    		        	//返回时间
    		        	Create_Style_Value(15,cellStyle,cdapp_return_time,row,cell);
    		        	
    		        	//IBS 查询时间-用户录入时间
    		        	Create_Style_Value(16,cellStyle,query_create_time,row,cell);
						//人行报告返回时间- 用户录入时间
    		        	Create_Style_Value(17,cellStyle,return_create_time,row,cell);
						//人行报告返回时间-IBS查询时间
    		        	Create_Style_Value(18,cellStyle,return_query_time,row,cell);
    		        	// 明细报告的  查询时间-用户录入时间
    		        	Create_Style_Value(19,cellStyle,qc_time,row,cell);
						//明细报告的   人行报告返回时间- 用户录入时间
    		        	Create_Style_Value(20,cellStyle,rc_time,row,cell);
						//明细报告的   人行报告返回时间-IBS查询时间
    		        	Create_Style_Value(21,cellStyle,rq_time,row,cell);
    		        	
    		        	Create_Style_Value(22,cellStyle,app_key,row,cell);
    		        	
    		        	Create_Style_Value(23,cellStyle,detail_key,row,cell);
    		        	
    		        	
    		    		i++;   
    		        }
    		    	sheet.setColumnWidth(0, 250*12);
    		    	sheet.setColumnWidth(2, 250*15);
    		    	//sheet.setColumnWidth(3, 250*20);
    		    	sheet.setColumnWidth(3, 250*10);
    		    	sheet.setColumnWidth(4, 250*10);
    		    	sheet.setColumnWidth(5, 250*15);
    		    	sheet.setColumnWidth(6, 250*15);
    		    	sheet.setColumnWidth(7, 250*10);
    		    	sheet.setColumnWidth(8, 250*10);
    		    	sheet.setColumnWidth(9, 250*10);
    		    	//sheet.setColumnWidth(11, 250*15);
    		    	sheet.setColumnWidth(10, 250*30);
    		    	sheet.setColumnWidth(11, 250*20);
    		    	sheet.setColumnWidth(12, 250*20);
    		    	sheet.setColumnWidth(1, 250*20);
    		    	sheet.setColumnWidth(13, 250*20);
    		    	sheet.setColumnWidth(14, 250*20);
    		    	sheet.setColumnWidth(15, 250*20);
    		    	sheet.setColumnWidth(16, 250*30);
    		    	sheet.setColumnWidth(17, 250*30);
    		    	sheet.setColumnWidth(18, 250*30);
    		    	sheet.setColumnWidth(19, 250*30);
    		    	sheet.setColumnWidth(20, 250*30);
    		    	sheet.setColumnWidth(21, 250*30);
    		    	sheet.setColumnWidth(22, 250*30);
    		    	sheet.setColumnWidth(23, 250*30);
    		    	
    		    /*	for(i=0;i<=12;i++) {
    		        sheet.autoSizeColumn((short)i);
    		    	}*/
    		       // String sql_download="select PARAM_VAL from SYS_PARAMS where PARAMGROUP_ID='COMP_DIALY' and PARAM_ID='COMP_REP'";
    		        String fileToBeDownload=null;
        		     htlog.info(Curr_Y_Month);
         		     String filename="monthly_corp_bureau_inquiry_record_"+Curr_Y_Month+".xls";
         		    String Download_Path=ReportUtils.getSysParamsValue("COMP_DIALY", "COMP_REP");
         		    htlog.info(Download_Path);
        		     fileToBeDownload=Download_Path+filename;
        		    File dir = new File(Download_Path);
        			if (!dir.exists()) {
        			    dir.mkdirs();
        			}
    		        FileOutputStream output=new FileOutputStream(fileToBeDownload);
    		        
    				workbook.write(output);
    				output.flush();
     		        output.close();
    				workbook.close();
    				   htlog.info("success");
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
		}
			
        } 
//      private String Number_translate_status(String status) {
//    	  status=status.replaceAll("\\s*","");
//    	  String query_status_array[]={"查询成功","未查询","正在查询","网络连接错误","网络超时","html解析错误","查无此人","密码错误","密码修改错误","登录出错","html不完整","没有报告编号"};
//     // 	System.out.println("Interge="+Integer.parseInt(status,10)+"swithc="+status);
//      	  if(isNumeric(status)&&(Integer.parseInt(status)>=0&&Integer.parseInt(status)<=11)) {
//      		  	System.out.println("Interge="+Integer.parseInt(status,10)+"swithc="+status);
//      		  return query_status_array[Integer.parseInt(status)];
//      	  }
//      		  return status;
//      }
    //城市
//      private String Number_translate_city(String city) {
//     	 city=city.replaceAll("\\s*","");
//    	  String query_status_array[]={"Beijing","Changsha","Chengdu","Chongqing","Dalian","Foshan","Fuzhou","Guangzhou","Hangzhou","Harbin","Huhhot","Jinan","Kunming"
//    			,"Kunshan","Nanchang","Nanjing","Ningbo","Qingdao","Shanghai","Shenyang","Shenzhen","Suzhou","Taiyuan","TJ","Wuhan","Xi’an","Xiamen","Zhengzhou","Zhuhai"};
//    	  //	System.out.println("Interge="+Integer.parseInt(status,10)+"swithc="+status);
//      	  if(isNumeric(city)&&(Integer.parseInt(city)>=1&&Integer.parseInt(city)<=29)) {
//      		  	System.out.println("Interge="+Integer.parseInt(city,10)+"swithc="+city);
//      		  return query_status_array[Integer.parseInt(city)-1];
//      	  }
//      		  return city;
//      }
      //部门
//      private String Number_translate_region(String region) {
//     	 region=region.replaceAll("\\s*","");
//     	 String query_status_array[]={"1-CIB_FI ","2-CIB_IC ","3-Commercial Banking ","4-Business Banking ","5-RB_Credit ","6-Operation ","7-GTO ","8-Admin"};
//     	 //	System.out.println("Interge="+Integer.parseInt(status,10)+"swithc="+status);
//     	 if(isNumeric(region)&&(Integer.parseInt(region)>=1&&Integer.parseInt(region)<=8)) {
//     		 System.out.println("Interge="+Integer.parseInt(region,10)+"swithc="+region);
//     		 return query_status_array[Integer.parseInt(region)-1];
//     	 }
//     	 return region;
//      }
    //区域
//      private String Number_translate_Department(String Department) {
//     	 Department=Department.replaceAll("\\s*","");
//    	  String query_status_array[]={"1-North ","2-South ","3-West ","4-East ","5-Head Office"};
//    	  //	System.out.println("Interge="+Integer.parseInt(status,10)+"swithc="+status);
//      	  if(isNumeric(Department)&&(Integer.parseInt(Department)>=1&&Integer.parseInt(Department)<=5)) {
//      		  	System.out.println("Interge="+Integer.parseInt(Department,10)+"swithc="+Department);
//      		  return query_status_array[Integer.parseInt(Department)-1];
//      	  }
//      		  return Department;
//      }
    //查询原因
//      private String Number_translate_query_reson(String query_reson) {
//     	 query_reson=query_reson.replaceAll("\\s*","");
//     	 String query_status_array[]={"贷后管理","贷款审批","信用卡审批","本人查询","异议查询","担保资格审查"};
//     //	 System.out.println("Interge="+Integer.parseInt(status,10)+"swithc="+status);
//     	 if(isNumeric(query_reson)){
//     	 	int queryReasonInt = Integer.parseInt(query_reson);
//     	 	queryReasonInt = queryReasonInt - 1;
//     	 	if(queryReasonInt == 7){
//     	 		queryReasonInt = 5;
//     	 	}
//     	 	if(queryReasonInt >= 0 && queryReasonInt <= 5) {
//     	 		System.out.println("Interge="+Integer.parseInt(query_reson,10)+"swithc="+query_reson);
//      		  	return query_status_array[queryReasonInt];
//     	 	} 
//     	 }
//      	 return query_reson;
//      }
    private void Create_Style_Value(int num,HSSFCellStyle cellStyle,String CellValue,HSSFRow row,HSSFCell cell) {
    	cell=row.createCell(num);
    	cell.setCellStyle(cellStyle);
    	cell.setCellValue(CellValue);
    }
    private String transfer_toString(Object str_son) {
    	if(null==str_son)
    		return "NULL".toString();
    	return str_son.toString();
    }
    public  String getSpecifiedDayBefore(String specifiedDay){ 
    	//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
    	Calendar c = Calendar.getInstance(); 
    	Date date=null; 
    	try { 
    	date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay); 
    	} catch (ParseException e) { 
    	e.printStackTrace(); 
    	} 
    	c.setTime(date); 
    	int day=c.get(Calendar.DATE); 
    	c.set(Calendar.DATE,day-1); 
    	String dayBefore=new SimpleDateFormat("yyyy-MM-dd").format(c.getTime()); 
    	return dayBefore; 
    	} 
   		public  boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();   
    }
   		public String checkNull(Map p,String t){
   			if(t==null){
   				return "";
   			}else{
   			return (String) p.get(t.trim());
   			}
   		}
   		
   		public void  daysBetween(String queryTime, String returnTime) {
   			
   			
   		}
}
