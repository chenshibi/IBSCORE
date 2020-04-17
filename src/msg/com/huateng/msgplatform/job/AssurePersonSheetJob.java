package com.huateng.msgplatform.job;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.msgplatform.service.DataMapService;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.utils.ReportUtils;

import resource.bean.basic.ReportJobConfig;

@SuppressWarnings("rawtypes")

public class AssurePersonSheetJob implements org.quartz.StatefulJob {
	private Logger htlog = Logger.getLogger(AssurePersonSheetJob.class);
	private Map mstatus = null;
	private Map mreason=null;
	private Map midType=null;
	private Map assureIdType=null;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub

    	String result = ReportCommonService.JOB_OK;
        Date endTm = null;
        String jobName = null;
        String jobId = null;
        String remark = "";
        Date startTm=null;
        String Query_time=null;
        String day=null;
        String Curr_Y_Month=null;//得到yyyyMM的格式
        
        try {
            jobId = context.getJobDetail().getJobDataMap().getString("jobId");// 定时器主键
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class, jobId);
            jobName = jobConfig.getJobName();
            remark = jobConfig.getJobRemark();
            startTm = new Date();
            System.out.println("startTm"+startTm);
            String Curr_Date=new SimpleDateFormat("yyyy-MM-dd").format(startTm).toString();
            String Pre_Date=getSpecifiedDayBefore(Curr_Date);
            Query_time=Pre_Date.substring(0, 7);  
            day=Curr_Date.substring(8,10);
            if(day=="01"||day.equals("01")){
            	return;
            }
            Curr_Y_Month=Pre_Date.substring(0,4)+Pre_Date.substring(5,7);
            System.out.println("模糊查询的Query_time="+Query_time+",生成报表的年和月份="+Curr_Y_Month);
            if (DateUtil.isHoliday() && "Y".equals(jobConfig.getJustWorkdateRun())) {
                remark = "该JOB只在工作日执行";
                return;
            }
            mstatus=DataMapService.getNameByNo(506);
            mreason=DataMapService.getNameByNo(504);
            midType=DataMapService.getNameByNo(9001);
            assureIdType=DataMapService.getNameByNo(5513);
            Create_Sheet(Query_time, Curr_Y_Month);
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
      try {
	        String sql="select ta.name as name, rtrim(ta.status) as status, ta.type as type,"
	        		+ " convert(varchar(100),ta.input_time,120) as input_time, convert(varchar(100),ta.query_time,120) as query_time,"
	        		+ " convert(varchar(100),ta.return_time,120) as return_time, ta.input_user_ip as input_user_ip,"
	        		+ " ta.individual_id_type as individual_id_type,"
	        		+ " ta.individual_id as individual_id, ta.input_user as input_user, ta.rpt_key as rpt_key"
	        		+ " from t_detail_ind_app ta"
	        		+ " where convert(varchar(100),ta.input_time,121) like '%"+ Query_time + "%' "
	        		+  "order by ta.return_time desc ";
	       String sql1="select convert(varchar(100),c.input_time,120) as input_time,c.pwid as pwid,c.inquiry_type as inquiry_type,"
		       		+ "c.inquiry_value as inquiry_value,c.query_reason as query_reason,rtrim(c.status) as status,c.create_user_ip as create_user_ip"
		       		+ " from t_corp_loancard_inq c"
		       		+ " where convert(varchar(100),c.input_time,121) like '%"+ Query_time + "%' " 
		       		+" order by input_time desc";
	        System.out.println("sql="+sql);
	        System.out.println("sql="+sql1);
	        Iterator it=rootdao.queryBySQL2(sql.toString());
	        Iterator it2=rootdao.queryBySQL2(sql1.toString());
          if(it==null) {
              htlog.info("no message need to be sent.");
              return;
          }if(it2==null) {
              htlog.info("no message need to be sent.");
              return;
          }
      	String fileDir=ReportUtils.getSysParamsValue("ASS_DIALY", "NA_REPORT");

                 File file = new File(fileDir);
					if (!file.exists()) {
						file.mkdirs();
					}
					String destFileName=fileDir+ "monthly_nature_loancardno_inquiry_record_"
							+Curr_Y_Month+".xls";
					//企业
					String destFileName1=fileDir+ "monthly_corp_loancardno_inquiry_record_"
							+Curr_Y_Month+".xls";
		    		//创建工作簿
					XSSFWorkbook workbook = new XSSFWorkbook();
					XSSFWorkbook workbook1 = new XSSFWorkbook();
	  				String sheetName="自然人中征码月报表";
	  				String sheetName1="企业中征码月报表";
	  				// 创建一个sheet
	  				XSSFSheet sheet = workbook.createSheet(sheetName);
	  				XSSFSheet sheet1 = workbook1.createSheet(sheetName1);
  				try
  				{
  					String title   = "name;status;type;input_time;query_time;return_time;input_user_ip;individual_id_type;individual_id;input_user;rpt_key";
  					String title1   = "pwid;status;query_reason;inquiry_type;inquiry_value;input_time;create_user_ip";
  					String titleRow[] = title.split(";");
  					String titleRow1[] = title1.split(";");
  					XSSFRow row =workbook.getSheet(sheetName).createRow(0);
  					XSSFRow row1 =workbook1.getSheet(sheetName1).createRow(0);
  					XSSFCell cell = null;
  					XSSFCell cell1 = null;
  					row.setHeight((short)300);
  					row1.setHeight((short)300);
  					
  					for(int i = 0;i < titleRow.length;i++)
  					{
  					    cell=row.createCell(i);
  						cell.setCellValue(titleRow[i]);
  					}
  					for(int i = 0;i < titleRow1.length;i++)
  					{
  					    cell1=row1.createCell(i);
  						cell1.setCellValue(titleRow1[i]);
  					}
  					//左对齐   0x31  文本格式
		    	     XSSFCellStyle cellStyle = workbook.createCellStyle();
		    	     cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		    	     cellStyle.setDataFormat((short)0x31);
		    	     XSSFCellStyle cellStyle1 = workbook1.createCellStyle();
		    	     cellStyle1.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		    	     cellStyle1.setDataFormat((short)0x31);
		    	     int i=1;
		    	     int j=1;
		    	     while(it.hasNext()){
	    		        	Map map = (Map)it.next();

	    		        	String name=transfer_toString(map.get("name"));
	    		        	String status=checkNull(mstatus,transfer_toString(map.get("status")));
	    		        	String type=transfer_toString(map.get("type"));
	    		        	String input_time=transfer_toString(map.get("input_time"));
	    		        	String query_time=transfer_toString(map.get("query_time"));
	    		        	String return_time=transfer_toString(map.get("return_time"));
	    		        	String input_user_ip=transfer_toString(map.get("input_user_ip"));
	    		        	String individual_id_type=checkNull(assureIdType,transfer_toString(map.get("individual_id_type")));
	    		        	String individual_id=transfer_toString(map.get("individual_id"));
	    		        	String input_user=transfer_toString(map.get("input_user"));
	    		        	String rpt_key=transfer_toString(map.get("rpt_key"));
	    		        	
	    		        	row = sheet.createRow(i);
	    		        	Create_Style_Value(0,cellStyle,name,row,cell);
	    		        	
	    		        	Create_Style_Value(1,cellStyle,status,row,cell);
	    		        	
	    		        	Create_Style_Value(2,cellStyle,type,row,cell);
	    		        	
	    		         	Create_Style_Value(3,cellStyle,input_time,row,cell);
	    		         	
	    		         	Create_Style_Value(4,cellStyle,query_time,row,cell);
	    		         	
	    		         	Create_Style_Value(5,cellStyle,return_time,row,cell);
	    		         	
	    		          	Create_Style_Value(6,cellStyle,input_user_ip,row,cell);
	    		          	
	    		        	Create_Style_Value(7,cellStyle,individual_id_type,row,cell);
	    		        	
	    		        	Create_Style_Value(8,cellStyle,individual_id,row,cell);
	    		        	
	    		         	Create_Style_Value(9,cellStyle,input_user,row,cell);
	    		         	
	    		          	Create_Style_Value(10,cellStyle,rpt_key,row,cell);
	    		        	
	    		        	i++;  
	    		        }
		    	     while(it2.hasNext()){
	    		        	Map map = (Map)it2.next();

	    		        	String input_time=transfer_toString(map.get("input_time"));
	    		        	String pwid=transfer_toString(map.get("pwid"));
//	    		        	String inquiry_type=transfer_toString(map.get("inquiry_type"));
	    		        	String inquiry_type=checkNull(midType,transfer_toString(map.get("inquiry_type")));
	    		        	String inquiry_value=transfer_toString(map.get("inquiry_value"));
	    		        //	String query_reason=transfer_toString(map.get("query_reason"));
	    		        	String query_reason=checkNull(mreason,transfer_toString(map.get("query_reason")));
	    		        	String status=checkNull(mstatus,transfer_toString(map.get("status")));
	    		        	String create_user_ip =transfer_toString(map.get("create_user_ip"));
	    		        	
	    		        	row1 = sheet1.createRow(j);
	    		        	Create_Style_Value(0,cellStyle1,pwid,row1,cell1);
	    		        	
	    		        	Create_Style_Value(1,cellStyle1,status,row1,cell1);
	    		        	
	    		        	Create_Style_Value(2,cellStyle1,query_reason,row1,cell1);
	    		        	
	    		         	Create_Style_Value(3,cellStyle1,inquiry_type,row1,cell1);
	    		         	
	    		         	Create_Style_Value(4,cellStyle1,inquiry_value,row1,cell1);	
	    		         	
	    		        	Create_Style_Value(5,cellStyle1,input_time,row1,cell1);
	    		        	
	    		        	Create_Style_Value(6,cellStyle1,create_user_ip,row1,cell1);
	    		        	j++;  
	    		        }
	    		       	sheet.setColumnWidth(0, 250*12);
	    		    	sheet.setColumnWidth(1, 250*20);
	    		    	sheet.setColumnWidth(2, 250*15);
	    		    	sheet.setColumnWidth(3, 250*22);
	    		    	sheet.setColumnWidth(4, 250*22);
	    		    	sheet.setColumnWidth(5, 250*22);
	    		    	sheet.setColumnWidth(6, 250*22);
	    		    	sheet.setColumnWidth(7, 250*18);
	    		    	sheet.setColumnWidth(8, 250*15);
	    		    	sheet.setColumnWidth(9, 250*10);
	    		    	sheet.setColumnWidth(10, 250*10);
	    		    	
	    		    	sheet1.setColumnWidth(0, 250*10);
	    		    	sheet1.setColumnWidth(1, 250*20);
	    		    	sheet1.setColumnWidth(2, 250*15);
	    		    	sheet1.setColumnWidth(3, 250*20);
	    		    	sheet1.setColumnWidth(4, 250*15);
	    		    	sheet1.setColumnWidth(5, 250*22);
	    		    	sheet1.setColumnWidth(6, 250*15);
	    		        FileOutputStream output=new FileOutputStream(destFileName);
	    		        FileOutputStream output1=new FileOutputStream(destFileName1);
  					workbook.write(output);
  					output.close();
  					output.flush();
  					workbook1.write(output1);
  					output1.close();
  					output1.flush();
  				}catch(Exception e)
  				{
  					throw e;
  				} finally {    
  		            try {    
  		    			workbook.close();	
  		    			workbook1.close();	
  		    			htlog.info("success"); 
  		            } catch (IOException e) {    
  		                e.printStackTrace();  
  		            }    
  				}  
  			} catch (Exception e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
      } 
  private void Create_Style_Value(int num,XSSFCellStyle cellStyle,String CellValue,XSSFRow row,XSSFCell cell) {
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
	  	Calendar c = Calendar.getInstance(); 
	  	Date date=null; 
	  	try { 
	  	date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay); 
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
	
	
	
}
