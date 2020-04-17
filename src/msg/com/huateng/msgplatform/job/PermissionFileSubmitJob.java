package com.huateng.msgplatform.job;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
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

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.msgplatform.service.DataMapService;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.utils.ReportUtils;

import resource.bean.basic.ReportJobConfig;

@SuppressWarnings("rawtypes")
public class PermissionFileSubmitJob implements org.quartz.StatefulJob {
    private Logger htlog = Logger.getLogger(PermissionFileSubmitJob.class);
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
            mstatus=DataMapService.getNameByNo(600);
            mcity=DataMapService.getNameByNo(503);
            mregion=DataMapService.getNameByNo(501);
            mdepartMent=DataMapService.getNameByNo(502);
            mreason=DataMapService.getNameByNo(504);
            midType=DataMapService.getNameByNo(5511);
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
        try {
	        String sql="select create_user,approve_time,input_time,expire_date,customer_con_up,id_type,Individual_id,name,status from ind_permit  where input_time> dateadd(dd,-day(getdate())+1,Convert(varchar(10),getdate(),120)) and input_time<getdate() and status='1'";
	       String sql1="select b.create_user,b.approve_time,b.loan_card_no,b.corp_name,b.customer_con_up,b.input_time,b.expire_Date,b.status from t_corp_permit as b where input_time> dateadd(dd,-day(getdate())+1,Convert(varchar(10),getdate(),120)) and input_time<getdate() and status='1'";
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
        	String fileDir=ReportUtils.getSysParamsValue("BATCH_APP", "LOAD_PATH");

                   File file = new File(fileDir);
					if (!file.exists()) {
						file.mkdirs();
					}
					String destFileName=fileDir+Curr_Y_Month+".xls";
		    				//创建工作簿
                  
              
            		//POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
    				HSSFWorkbook workbook = new HSSFWorkbook();
    				String sheetName="许可上传文件月报表";
    				// 创建一个sheet
    				HSSFSheet sheet = workbook.createSheet(sheetName);
    				//FileOutputStream out=null;
    				try
    				{
    					String title   = "上传操作员ID;授权时间;上传时间;过期日期;上传文件路径;证件类型;中征码;证件号;名称;status";
        		        String titleRow[] = title.split(";");
    					HSSFRow row =workbook.getSheet(sheetName).createRow(0);
    					HSSFCell cell = null;
    				  row.setHeight((short)300);
    					for(int i = 0;i < titleRow.length;i++)
    					{
    					    cell=row.createCell(i);
    						cell.setCellValue(titleRow[i]);
    					}
    					//左对齐   0x31  文本格式
		    	     HSSFCellStyle cellStyle = workbook.createCellStyle();
		    	     cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		    	     cellStyle.setDataFormat((short)0x31);
		    	     int i=1;
		    	     while(it.hasNext()){
	    		        	Map map = (Map)it.next();

	    		        	String id=transfer_toString(map.get("create_user"));
	    		        	String approve_time=transfer_toString(map.get("approve_time"));
	    		        	String input_time=transfer_toString(map.get("input_time"));
	    		        	String expire_date=transfer_toString(map.get("expire_date"));
	    		        	String customer_con_up=transfer_toString(map.get("customer_con_up"));
	    		        	String id_type=checkNull(midType,transfer_toString(map.get("id_type")));
	    		        			//(String) midType.get(rs.getString("id_type").trim());
	    		        	String Individual_id=transfer_toString(map.get("Individual_id"));
	    		        	String name=transfer_toString(map.get("name"));
	    		        	String status=checkNull(mstatus,transfer_toString(map.get("status")));

	    		        	row = sheet.createRow(i);
	    		    		//上传操作员id
	    		        	Create_Style_Value(0,cellStyle,id,row,cell);
	    		        	//授权时间
	    		        	Create_Style_Value(1,cellStyle,approve_time,row,cell);
	    		    		//上传时间
	    		        	Create_Style_Value(2,cellStyle,input_time,row,cell);
	    		        	//过期日期
	    		         	Create_Style_Value(3,cellStyle,expire_date,row,cell);
	    		         	//上传许可路径
	    		         	Create_Style_Value(4,cellStyle,customer_con_up,row,cell);
	    		         	
	    		         	
	    		         	//客户类型
	    		         	Create_Style_Value(5,cellStyle,id_type,row,cell);
	    		    		//证件号
	    		         	Create_Style_Value(7,cellStyle,Individual_id,row,cell);
	    		         	
	    		         	
	    		         	//个人名称
	    		          	Create_Style_Value(8,cellStyle,name,row,cell);
	    		          //状态
	    		        	Create_Style_Value(9,cellStyle,status,row,cell);
	    		        	i++;  
	    		        }
//	    		        while(rs2.next()){
//	    		        	String id=transfer_toString(rs2.getString("create_user"));
//	    		        	String approve_time=rs2.getString("approve_time");
//	    		        	String input_time=rs2.getString("input_time");
//	    		        	String expire_date=rs2.getString("expire_date");
//	    		        	String customer_con_up=rs2.getString("customer_con_up");       	
//	    		        	String loan_card_no=rs2.getString("loan_card_no");
//	    		        	String corp_name=rs2.getString("corp_name");
//	    		        	//String status=checkNull(mstatus,rs.getString("status"));
//	    		        	String status=(String) mstatus.get(rs2.getString("status").trim());
//	    		        	conn1 = SessionFactoryUtils.getDataSource(ROOTDAOUtils.getROOTDAO().getSessionFactory()).getConnection();
	    		        
		    	     while(it2.hasNext()){
	    		        	Map map = (Map)it2.next();

	    		        	String id=transfer_toString(map.get("create_user"));
	    		        	String approve_time=transfer_toString(map.get("approve_time"));
	    		        	String input_time=transfer_toString(map.get("input_time"));
	    		        	String expire_date=transfer_toString(map.get("expire_Date"));
	    		        	String customer_con_up=transfer_toString(map.get("customer_con_up"));
	    		        	String loan_card_no=transfer_toString(map.get("loan_card_no"));
	    		        	String corp_name=transfer_toString(map.get("corp_name"));
	    		        	String id_type=checkNull(midType,transfer_toString(map.get("id_type")));
	    		        			//(String) midType.get(rs.getString("id_type").trim());
	    		        	String Individual_id=transfer_toString(map.get("Individual_id"));
	    		        	String name=transfer_toString(map.get("name"));
	    		        	String status=checkNull(mstatus,transfer_toString(map.get("status")));

		    	     row = sheet.createRow(i);
	    		    		//上传操作员id
	    		        	Create_Style_Value(0,cellStyle,id,row,cell);
	    		        	//授权
	    		        	Create_Style_Value(1,cellStyle,approve_time,row,cell);
	    		    		//上传时间
	    		        	Create_Style_Value(2,cellStyle,input_time,row,cell);
	    		        	//过期日期
	    		         	Create_Style_Value(3,cellStyle,expire_date,row,cell);
	    		    		//上传许可路径
	    		         	Create_Style_Value(4,cellStyle,customer_con_up,row,cell);	
	    		         	
	    		         	
	    		    		//中征号
	    		        	Create_Style_Value(6,cellStyle,loan_card_no,row,cell);
	    		        	
	    		    		//公司名称
	    		        	Create_Style_Value(8,cellStyle,corp_name,row,cell);
	    		        	//状态
	    		        	Create_Style_Value(9,cellStyle,status,row,cell);
	    		    		i++;  
	    		        }
	    		       sheet.setColumnWidth(0, 250*12);
	    		    	sheet.setColumnWidth(1, 250*20);
	    		    	sheet.setColumnWidth(2, 250*15);
	    		    	sheet.setColumnWidth(3, 250*20);
	    		    	sheet.setColumnWidth(4, 250*10);
	    		    	sheet.setColumnWidth(5, 250*10);
	    		    	sheet.setColumnWidth(6, 250*15);
	    		    	sheet.setColumnWidth(7, 250*15);
	    		    	sheet.setColumnWidth(8, 250*10);
	    		    	sheet.setColumnWidth(9, 250*10);
	    		        FileOutputStream output=new FileOutputStream(destFileName);
    					workbook.write(output);
    					output.close();
    					output.flush();
    				}catch(Exception e)
    				{
    					throw e;
    				} finally {    
    		            try {    
    		    			workbook.close();		
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
