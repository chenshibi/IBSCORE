package com.huateng.report.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.springframework.util.CollectionUtils;

import com.huateng.report.pboc.entity.DataGenCorpEntity;
import com.huateng.report.pboc.entity.DataGenEntity;

/** 
* @author Grassy 
* @version 创建时间：2020年2月21日 下午12:46:12 
* 类说明 
*/
public class WriteDbToExcelUtil {
	
	 private static Logger log = Logger.getLogger(WriteDbToExcelUtil.class);
	
	private static final String OBJECT_VALUE="OBJECT_VALUE_";
	private static final String NUMBER="NUMBER_";
	private static final String LEVEL="LEVEL_";
	private static final String SHARE="SHARE_";
	private static final String DATE="DATE_";
	private static final String T_CORP_JUDGE_RECORD="T_CORP_JUDGE_RECORD";
	private static final String IND_ADDR="IND_ADDR";
	private static final String IND_AWARD="IND_AWARD";
	private static final String IND_CRD_DETAIL="IND_CRD_DETAIL";
	private static final String IND_DETAIL_INFO="IND_DETAIL_INFO";
	private static final String IND_SPECIAL="IND_SPECIAL";
	private static final String IND_SPECIAL_NEW="IND_SPECIAL_NEW";
	private static final String LOGRESPONSELAPS="LOGRESPONSELAPS";
	private static final String LOGRESPONSEAPS="LOGRESPONSEAPS";
	private static final String LOGRESPONSE="LOGRESPONSE";
	private static final String MONTHLYINSTALL_SEC_HOUSELOAN_OFF="MONTHLYINSTALL_SEC_HOUSELOAN_OFF";
	private static final String MONTHLYINSTALL_SEC_HL_OFF="MONTHLYINSTALL_SEC_HL_OFF";
	private static final String MONTHLYINSTALL_SEC_HOUSELOAN_ON="MONTHLYINSTALL_SEC_HOUSELOAN_ON";
	private static final String MONTHLYINSTALL_SEC_HL_ON="MONTHLYINSTALL_SEC_HL_ON";
	private static final String MONTHLYINSTALL_SEC_HOUSEFUND_OFF="MONTHLYINSTALL_SEC_HOUSEFUND_OFF";
	private static final String MONTHLYINSTALL_SEC_HF_OFF="MONTHLYINSTALL_SEC_HF_OFF";
	private static final String MONTHLYINSTALL_SEC_HOUSEFUND_ON="MONTHLYINSTALL_SEC_HOUSEFUND_ON";
	private static final String MONTHLYINSTALL_SEC_HF_ON="MONTHLYINSTALL_SEC_HF_ON";
	private static final String MONTHLYINSTALL_SEC_TOT_HOUSEFUND="MONTHLYINSTALL_SEC_TOT_HOUSEFUND";
	private static final String MONTHLYINSTALL_SEC_TOT_HF="MONTHLYINSTALL_SEC_TOT_HF";
	private static final String MONTHLYINSTALL_SEC_NOHOUSEFUND_OFF="MONTHLYINSTALL_SEC_NOHOUSEFUND_OFF";
	private static final String MONTHLYINSTALL_SEC_NOHOUSEFUND_ON="MONTHLYINSTALL_SEC_NOHOUSEFUND_ON";
	private static final String MONTHLYINSTALL_SEC_NHF_ON="MONTHLYINSTALL_SEC_NHF_ON";
	private static final String MONTHLYINSTALL_SEC_TOT_NOHOUSEFUND="MONTHLYINSTALL_SEC_TOT_NOHOUSEFUND";
	private static final String MONTHLYINSTALL_SEC_TOT_NHF="MONTHLYINSTALL_SEC_TOT_NHF";
	private static final String MONTHLYINSTALL_SEC_NHF_OFF="MONTHLYINSTALL_SEC_NHF_OFF";
	private static final String TOTALSECUREDLOANSMONTHLYINSTALLMENT="TOTALSECUREDLOANSMONTHLYINSTALLMENT";
	private static final String TOTALSLMONTHLYINSTALLMENT="TOTALSLMONTHLYINSTALLMENT";
	private static final String TOTALUNSECUREDLOANSMONTHLYINSTALLMENT="TOTALUNSECUREDLOANSMONTHLYINSTALLMENT";
	private static final String TOTALULMONTHLYINSTALLMENT="TOTALULMONTHLYINSTALLMENT";  
	
	public static Map<String,ArrayList<String>> getNewMap(ArrayList<DataGenEntity> entityList){
		ArrayList<String> rpdIdsList=new ArrayList<String>();
		ArrayList<String> inqCustAppIdsList=new ArrayList<String>();
		Map<String,ArrayList<String>>dataMap =new HashMap<String,ArrayList<String>>();
		if(CollectionUtils.isEmpty(entityList) == false) {
			for(DataGenEntity entity: entityList) {
				 if(StringUtils.isNotEmpty(entity.getRptId())) {
					 rpdIdsList.add(entity.getRptId().trim());
				 }if(StringUtils.isNotEmpty(entity.getInqCustAppId())) {
					 inqCustAppIdsList.add(entity.getInqCustAppId().trim());
				 }
			}
		}
		dataMap.put("reportId", rpdIdsList);
		dataMap.put("inqCustId", inqCustAppIdsList);
		return dataMap;
		
	}
	
	public static Map<String,ArrayList<String>> getNewMap2(ArrayList<DataGenCorpEntity> entityList){
		ArrayList<String> rpdIdsList=new ArrayList<String>();
		ArrayList<String> corpCustIdList=new ArrayList<String>();
		Map<String,ArrayList<String>>dataMap =new HashMap<String,ArrayList<String>>();
		if(CollectionUtils.isEmpty(entityList) == false) {
			for(DataGenCorpEntity entity: entityList) {
				 if(StringUtils.isNotEmpty(entity.getRptKey())) {
					 rpdIdsList.add(entity.getRptKey().trim());
				 }if((StringUtils.isNotEmpty(entity.getDetailrptKey())) && (!"-".equals(entity.getDetailrptKey()))) {
					  rpdIdsList.add(entity.getDetailrptKey().trim());
				 }if(StringUtils.isNotEmpty(entity.getCorpCustId())) {
					 corpCustIdList.add(entity.getCorpCustId().trim());
				 }
			}
		}
		dataMap.put("reportId", getNewList(rpdIdsList));
		dataMap.put("corpCustId", corpCustIdList);
		return dataMap;
		
	}
	
   public static ArrayList<String> getNewList(ArrayList<String> list){
	   ArrayList<String> listNew=new ArrayList<>(new TreeSet<String>(list));
	   return listNew;
   }
	
   public static Map<String,String> getParamMap(){

	return null;
   } 
	
	public static String[] getTables() {
		String[] arrs= {"t_detail_ind_app" ,
				"assure_ind_app" ,
				"t_corp_batch" ,
				"ind_assurance" ,
				"ind_assurance_detail" ,
				"ind_award" ,
				"ind_breach" ,
				"ind_car_trade" ,
				"ind_disposal" ,
				"ind_ensure" ,
				"ind_housefund" ,
				"ind_housefund_deposit" ,
				"ind_ins_deposit" ,
				"ind_ins_detail" ,
				"ind_ins_payment" ,
				"ind_no_close_cc" ,
				"ind_no_close_loan" ,
				"ind_no_close_pdc" ,
				"ind_overdue" ,
				"ind_owe_tax" ,
				"ind_pboc_score" ,
				"ind_prompt" ,
				"ind_public_record" ,
				"ind_special" ,
				"ind_special_new" ,
				"ind_statement" ,
				"ind_succour" ,
				"ind_sys_enqids" ,
				"ind_telecom_payment" ,
				"logrequest" ,
				"logrequestaps" ,
				"logrequestlaps" ,
				"logresponse" ,
				"logresponseaps" ,
				"logresponselaps" ,
				"sys_hist" ,
				"sys_user" ,
				"t_blacklist" ,
				"t_company" ,
				"t_corp_app" ,
				"t_corp_detail_assure" ,
				"t_corp_detail_assure_item" ,
				"t_corp_detail_loan" ,
				"t_corp_detail_others" ,
				"t_corp_detail_summary" ,
				"t_corp_history_enquiry" ,
				"t_corp_info_basic" ,
				"t_corp_info_executive" ,
				"t_corp_info_investor" ,
				"t_corp_info_relevant_corp" ,
				"t_corp_public_award" ,
				"t_corp_public_owe_tax" ,
				"t_corp_public_text" ,
				"t_corp_report" ,
				"t_corp_statement" ,
				"t_corp_sum_assure" ,
				"t_corp_sum_credit" ,
				"t_related_party_log" ,
				"tmp_company" ,
				"tmp_individual" ,
				"ind_scrub_info" ,
				"corp_cust" ,
				"corp_scurb_info" ,
				"t_corp_loancard_inq" ,
				"t_corp_loancard_resp" ,
				"T_CORP_DETAIL_APP" ,
				"corp_loancard_scurb_info" ,
				"TLR_INFO_CHANGE" ,
				"TLR_ROLE_REL_CHANGE" ,
				"inq_cust" ,
				"t_corp_sum_debit_history" ,
				"t_corp_sum_credit_items" ,
				"ind_overdue_detail" ,
				"ind_enquiry_summary" ,
				"ind_app" ,
				"ind_detail_info" ,
				"ind_addr" ,
				"ind_enquiry" ,
				"ind_crd_detail" ,
				"ind_crd_sum" ,
				"ind_lon_detail" ,
				"ind_info" ,
				"ind_job" ,
				"LOGRESPONSEAPS_EXD"
};
		
		return arrs;
		
	}
	
	
		public static void isChartPathExist(String dirPath) {        
			File file = new File(dirPath);       
			if (!file.exists()) {           
				file.mkdirs();       
				}    
			}
		private static String getNewFiled(String field) {
			if(WriteDbToExcelUtil.OBJECT_VALUE.equalsIgnoreCase(field)) {
				return getSubFileld(field);
			}if(WriteDbToExcelUtil.NUMBER.equalsIgnoreCase(field)) {
				return getSubFileld(field);
			}if(WriteDbToExcelUtil.LEVEL.equalsIgnoreCase(field)) {
				return getSubFileld(field);
			}if(WriteDbToExcelUtil.SHARE.equalsIgnoreCase(field)) {
				return getSubFileld(field);
			}if(WriteDbToExcelUtil.DATE.equalsIgnoreCase(field)) {
				return getSubFileld(field);
			}
			return field;
		}
		
		private static String getChangeField(String field) {
			if(WriteDbToExcelUtil.MONTHLYINSTALL_SEC_HL_OFF.equalsIgnoreCase(field)) {
			    return 	WriteDbToExcelUtil.MONTHLYINSTALL_SEC_HOUSELOAN_OFF;
			}if(WriteDbToExcelUtil.MONTHLYINSTALL_SEC_HL_ON.equalsIgnoreCase(field)) {
				return  WriteDbToExcelUtil.MONTHLYINSTALL_SEC_HOUSELOAN_ON;
			}if(WriteDbToExcelUtil.MONTHLYINSTALL_SEC_HF_OFF.equalsIgnoreCase(field)) {
				return  WriteDbToExcelUtil.MONTHLYINSTALL_SEC_HOUSEFUND_OFF;
			}if(WriteDbToExcelUtil.MONTHLYINSTALL_SEC_HF_ON.equalsIgnoreCase(field)) {
				return  WriteDbToExcelUtil.MONTHLYINSTALL_SEC_HOUSEFUND_ON;
			}if(WriteDbToExcelUtil.MONTHLYINSTALL_SEC_TOT_HF.equalsIgnoreCase(field)) {
				return  WriteDbToExcelUtil.MONTHLYINSTALL_SEC_TOT_HOUSEFUND;
			}if(WriteDbToExcelUtil.MONTHLYINSTALL_SEC_NHF_OFF.equalsIgnoreCase(field)) {
				return  WriteDbToExcelUtil.MONTHLYINSTALL_SEC_NOHOUSEFUND_OFF;
			}if(WriteDbToExcelUtil.MONTHLYINSTALL_SEC_NHF_ON.equalsIgnoreCase(field)) {
				return  WriteDbToExcelUtil.MONTHLYINSTALL_SEC_NOHOUSEFUND_ON;
			}if(WriteDbToExcelUtil.MONTHLYINSTALL_SEC_TOT_NHF.equalsIgnoreCase(field)) {
				return  WriteDbToExcelUtil.MONTHLYINSTALL_SEC_TOT_NOHOUSEFUND;
			}if(WriteDbToExcelUtil.TOTALSLMONTHLYINSTALLMENT.equalsIgnoreCase(field)) {
				return  WriteDbToExcelUtil.TOTALSECUREDLOANSMONTHLYINSTALLMENT;
			}if(WriteDbToExcelUtil.TOTALULMONTHLYINSTALLMENT.equalsIgnoreCase(field)) {
				return  WriteDbToExcelUtil.TOTALUNSECUREDLOANSMONTHLYINSTALLMENT;  
			}
			return field;
		}
		
		/**
		 * 一代 二代 导出excel通用工具类
		 * @param conn
		 * @param sql
		 * @param tableName
		 * @param path
		 * @return
		 */
		public static String writeDbtoExcel(Connection conn,String sql,String tableName,String path,int totalNum){
		//	String currentTime = DataMyUtil.getFullDateTime();
			String fileName = tableName+".xlsx";
			long start=System.currentTimeMillis();
			final int NUM_OF_ROWS=1000000;
			log.info("========开始导出时间======="+start+"ms");
			SXSSFWorkbook sxssfWorkbook=null;		
			SXSSFCell sxssfCell = null;
			SXSSFRow sxssfRow = null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			ResultSetMetaData rsmd=null;
			SXSSFSheet sxsssheet=null;
			XSSFCellStyle style =null; 
			BufferedOutputStream out=null;
			try {
			sxssfWorkbook=new SXSSFWorkbook(1000);
		    sxssfWorkbook.setCompressTempFiles(true); 
		    style=(XSSFCellStyle) sxssfWorkbook.createCellStyle();
			ps=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			long start1=System.currentTimeMillis();
			log.info("========开始查询时间======="+start1+"ms");
		    rs=ps.executeQuery(sql);
			long end1=System.currentTimeMillis();
			log.info("========结束查询时间======="+end1+"ms");
			log.info("========查询耗时======="+(end1-start1)+"ms");
			rsmd=rs.getMetaData();	
			int c=rsmd.getColumnCount();
			log.info("===生成的===="+tableName+"总共有====="+totalNum+"条数据");
			sxsssheet = (SXSSFSheet) sxssfWorkbook.createSheet();
			sxssfRow = (SXSSFRow) sxsssheet.createRow(0);
			for(int i=0;i<c;i++){
			    sxssfCell=(SXSSFCell) sxssfRow.createCell(i);	
			    String columnName = rsmd.getColumnName(i+1);
			    if(WriteDbToExcelUtil.IND_ADDR.equalsIgnoreCase(tableName) || WriteDbToExcelUtil.IND_AWARD.equalsIgnoreCase(tableName)
			 		   || WriteDbToExcelUtil.IND_CRD_DETAIL.equalsIgnoreCase(tableName) || WriteDbToExcelUtil.IND_DETAIL_INFO.equalsIgnoreCase(tableName)
			 		   || WriteDbToExcelUtil.IND_SPECIAL.equalsIgnoreCase(tableName) || WriteDbToExcelUtil.IND_SPECIAL_NEW.equalsIgnoreCase(tableName)
			 		   || WriteDbToExcelUtil.T_CORP_JUDGE_RECORD.equalsIgnoreCase(tableName)) {
			    	sxssfCell.setCellValue(getNewFiled(columnName));
			 		}else if(WriteDbToExcelUtil.LOGRESPONSELAPS.equalsIgnoreCase(tableName) || WriteDbToExcelUtil.LOGRESPONSEAPS.equalsIgnoreCase(tableName)
			 				|| WriteDbToExcelUtil.LOGRESPONSE.equalsIgnoreCase(tableName)){
			 			sxssfCell.setCellValue(getChangeField(columnName));
			 		}else {
			 			sxssfCell.setCellValue(columnName);
			 		}
			            sxssfCell.setCellStyle(style);
			            sxsssheet.autoSizeColumn((short) i  );
			 		}	
			int runNum=1;
			while(rs.next()){				
				if(runNum<totalNum) {
					if(runNum%NUM_OF_ROWS==0) {
						sxsssheet= (SXSSFSheet) sxssfWorkbook.createSheet();
						sxssfRow = (SXSSFRow) sxsssheet.createRow(0);
						for(int i=0;i<c;i++){
							  sxssfCell=(SXSSFCell) sxssfRow.createCell(i);			
							  sxssfCell.setCellValue(rsmd.getColumnName(i+1));
						}
						runNum=1;
					}
				}
				sxssfRow=(SXSSFRow) sxsssheet.createRow(runNum);		
			for(int cellnum=0;cellnum<c;cellnum++){				
				sxssfCell=(SXSSFCell) sxssfRow.createCell(cellnum);
			    String columnName = rsmd.getColumnName(cellnum+1);
			    sxssfCell.setCellValue(rs.getString(columnName)==null? "":rs.getString(columnName));
			    sxssfCell.setCellStyle(style);
			}
			runNum++;
			sxsssheet.flushRows();
			}
				out = new BufferedOutputStream(new FileOutputStream(path+fileName));
				sxssfWorkbook.write(out);			
			out.flush();
			sxssfWorkbook.dispose();
			long end=System.currentTimeMillis();
			log.info("========结束导出时间======="+end+"ms");
			log.info("========导出耗时======="+(end-start)+"ms");
			} catch (Exception e) {			
			  e.printStackTrace();		
			  }finally {
				  try {
					  if(null!=ps) {
						  ps.close();
					  }
				} catch (SQLException e) {
					e.printStackTrace();
				}
				  try {
					  if(null!=rs) {
						  rs.close();
					  }
				} catch (SQLException e) {
					e.printStackTrace();
				}
				  try {
					  if(null!=out) {
						  out.close();  
					  }
				} catch (IOException e) {
					e.printStackTrace();
				}
				}		return path;	
			  }
		
		
		private static void exportExcel(HttpServletResponse response, String fileName) {
			try {
				String encoding = System.getProperty("file.encoding");
				log.info("系统编码格式默认格式为:" + encoding);
				response.setContentType("application/vnd.ms-excel;charset=" + encoding);
				response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, encoding));
			} catch (Exception ex) {
				
				ex.printStackTrace();
			}
		}
		
		
		/**
		 * 一代 二代 导出excel通用工具类
		 * @param conn
		 * @param sql
		 * @param tableName
		 * @param path
		 * @return
		 */
		public static void createExcelToWeb(Connection conn,HttpServletResponse response,String sql,String tableName,int totalNum){
			long start=System.currentTimeMillis();
			final int NUM_OF_ROWS=1000000;
			log.info("========开始导出时间======="+start+"ms");
			SXSSFWorkbook sxssfWorkbook=null;		
			SXSSFCell sxssfCell = null;
			SXSSFRow sxssfRow = null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			ResultSetMetaData rsmd=null;
			SXSSFSheet sxsssheet=null;
			XSSFCellStyle style =null; 
			ServletOutputStream out=null;
			try {
			sxssfWorkbook=new SXSSFWorkbook(1000);
		    sxssfWorkbook.setCompressTempFiles(true); 
		    style=(XSSFCellStyle) sxssfWorkbook.createCellStyle();
		    ps=conn.prepareStatement(sql);
			long start1=System.currentTimeMillis();
			log.info("========开始查询时间======="+start1+"ms");
		    rs=ps.executeQuery(sql);
			long end1=System.currentTimeMillis();
			log.info("========结束查询时间======="+end1+"ms");
			log.info("========查询耗时======="+(end1-start1)+"ms");
			rsmd=rs.getMetaData();
			int c=rsmd.getColumnCount();
			log.info("===生成的===="+tableName+"====="+totalNum+"条数据");
			sxsssheet = (SXSSFSheet) sxssfWorkbook.createSheet();
			sxssfRow = (SXSSFRow) sxsssheet.createRow(0);
			for(int i=0;i<c;i++){
			    sxssfCell=(SXSSFCell) sxssfRow.createCell(i);//创建第一行的第i列	
			    if(WriteDbToExcelUtil.IND_ADDR.equalsIgnoreCase(tableName) || WriteDbToExcelUtil.IND_AWARD.equalsIgnoreCase(tableName)
				 		   || WriteDbToExcelUtil.IND_CRD_DETAIL.equalsIgnoreCase(tableName) || WriteDbToExcelUtil.IND_DETAIL_INFO.equalsIgnoreCase(tableName)
				 		   || WriteDbToExcelUtil.IND_SPECIAL.equalsIgnoreCase(tableName) || WriteDbToExcelUtil.IND_SPECIAL_NEW.equalsIgnoreCase(tableName)
				 		   || WriteDbToExcelUtil.T_CORP_JUDGE_RECORD.equalsIgnoreCase(tableName)) {
				    	sxssfCell.setCellValue(getNewFiled(rsmd.getColumnName(i+1)));
				 		}else {
				 			  sxssfCell.setCellValue(rsmd.getColumnName(i+1));
				 		}
			    sxsssheet.autoSizeColumn((short) i  );
			    sxssfCell.setCellStyle(style);			
			}		
			int runNum=1;
			while(rs.next()){				
				if(runNum<totalNum) {
					if(runNum%NUM_OF_ROWS==0) {
						sxsssheet= (SXSSFSheet) sxssfWorkbook.createSheet();
						sxssfRow = (SXSSFRow) sxsssheet.createRow(0);
						for(int i=0;i<c;i++){
							  sxssfCell=(SXSSFCell) sxssfRow.createCell(i);
							  if(WriteDbToExcelUtil.IND_ADDR.equalsIgnoreCase(tableName) || WriteDbToExcelUtil.IND_AWARD.equalsIgnoreCase(tableName)
							 		   || WriteDbToExcelUtil.IND_CRD_DETAIL.equalsIgnoreCase(tableName) || WriteDbToExcelUtil.IND_DETAIL_INFO.equalsIgnoreCase(tableName)
							 		   || WriteDbToExcelUtil.IND_SPECIAL.equalsIgnoreCase(tableName) || WriteDbToExcelUtil.IND_SPECIAL_NEW.equalsIgnoreCase(tableName)
							 		   || WriteDbToExcelUtil.T_CORP_JUDGE_RECORD.equalsIgnoreCase(tableName)) {
							    	sxssfCell.setCellValue(getNewFiled(rsmd.getColumnName(i+1)));
							 		}else {
							 			  sxssfCell.setCellValue(rsmd.getColumnName(i+1));
							 		}
						}
						runNum=1;
					}
				}
				sxssfRow=(SXSSFRow) sxsssheet.createRow(runNum);		
			for(int cellnum=0;cellnum<c;cellnum++){				
				sxssfCell=(SXSSFCell) sxssfRow.createCell(cellnum);
			    String columnName = rsmd.getColumnName(cellnum+1);
			    sxssfCell.setCellValue(rs.getString(columnName)==null? "":rs.getString(columnName));
			    sxssfCell.setCellStyle(style);
			}
			runNum++;
			sxsssheet.flushRows();
			}
			String path=tableName+".xlsx";
			exportExcel(response,path);
			long end=System.currentTimeMillis();
			log.info("========结束导出时间======="+end+"ms");
			out = response.getOutputStream();
			sxssfWorkbook.write(out);			
			out.flush();
			sxssfWorkbook.dispose();
			log.info("========"+tableName+"导出耗时======="+(end-start)+"ms");
			} catch (Exception e) {			
			  e.printStackTrace();		
			  }finally {
				  try {
					  if(null!=ps) {
						  ps.close();
					  }
				} catch (SQLException e) {
					e.printStackTrace();
				}
				  try {
					  if(null!=rs) {
						  rs.close();
					  }
				} catch (SQLException e) {
					e.printStackTrace();
				}
				  try {
					  if(null!=out) {
						  out.close();  
					  }
				} catch (IOException e) {
					e.printStackTrace();
				}
				  try {
					  if(null!=conn) {
						  conn.close();
					  }
				} catch (SQLException e) {
					e.printStackTrace();
				}
			  }
			
		}
		
		
		public static String getCorpTableMap(String key){
			Map<String,String> tableMap=new LinkedHashMap<String,String>();
			tableMap.put("1", "CR_COM_EAA       " );
			tableMap.put("2", "CR_COM_EA01CH    " );
			tableMap.put("3", "CR_COM_ECA       " );
			tableMap.put("4", "CR_COM_EC020H    " );
			tableMap.put("5", "CR_COM_EC030H    " );
			tableMap.put("6", "CR_COM_EC050H    " );
			tableMap.put("7", "CR_COM_EBA       " );
			tableMap.put("8", "CR_COM_EBB       " );
			tableMap.put("9", "CR_COM_EB02AH    " );
			tableMap.put("10", "CR_COM_EB02BH    " );
			tableMap.put("11", "CR_COM_EB02CH    " );
			tableMap.put("13", "CR_COM_EBC       " );
			tableMap.put("14", "CR_COM_EB03AH    " );
			tableMap.put("15", "CR_COM_EB03BH    " );
			tableMap.put("16", "CR_COM_EBD       " );
			tableMap.put("17", "CR_COM_EBE       " );
			tableMap.put("18", "CR_COM_EB05AH    " );
			tableMap.put("19", "CR_COM_EB05BH    " );
			tableMap.put("20", "CR_COM_EDA       " );
			tableMap.put("21", "CR_COM_ED01      " );
			tableMap.put("22", "CR_COM_ED02      " );
			tableMap.put("23", "CR_COM_ED03      " );
			tableMap.put("24", "CR_COM_ED01B     " );
			tableMap.put("25", "CR_COM_ED01C     " );
			tableMap.put("26", "CR_COM_ED01BH    " );
			tableMap.put("27", "CR_COM_ED01CH    " );
			tableMap.put("28", "CR_COM_EDB       " );
			tableMap.put("29", "CR_COM_ED04      " );
			tableMap.put("30", "CR_COM_ED04B     " );
			tableMap.put("31", "CR_COM_ED05      " );
			tableMap.put("32", "CR_COM_EDC       " );
			tableMap.put("33", "CR_COM_ED06      " );
			tableMap.put("34", "CR_COM_ED07      " );
			tableMap.put("35", "CR_COM_ED08      " );
			tableMap.put("36", "CR_COM_ED09      " );
			tableMap.put("37", "CR_COM_EEA       " );
			tableMap.put("38", "CR_COM_EE01BH    " );
			tableMap.put("39", "CR_COM_EFA       " );
			tableMap.put("40", "CR_COM_EFB       " );
			tableMap.put("41", "CR_COM_EFC       " );
			tableMap.put("42", "CR_COM_EFD       " );
			tableMap.put("43", "CR_COM_EF05BH    " );
			tableMap.put("44", "CR_COM_EFE       " );
			tableMap.put("45", "CR_COM_EFF       " );
			tableMap.put("46", "CR_COM_EFG       " );
			tableMap.put("47", "CR_COM_EGA       " );
			tableMap.put("48", "CR_COM_EHA       " );
			tableMap.put("49", "CR_COM_EIA       " );
			String value = tableMap.get(key).trim();
			return  value;
		}
		
		public static String getPerGen2TableName(String key) {
			Map<String,String> tableMap=new LinkedHashMap<String,String>();
			tableMap.put("1", "CR_PER_PRH       " );
			tableMap.put("2", "CR_PER_PA01CH    " );
			tableMap.put("3", "CR_PER_POQ       " );
			tableMap.put("4", "CR_PER_PQO    " );
			tableMap.put("5", "CR_PER_PBS    " );
			tableMap.put("6", "CR_PER_PF06ZH    " );
			tableMap.put("7", "CR_PER_PNO       " );
			tableMap.put("8", "CR_PER_PC030H       " );
			tableMap.put("9", "CR_PER_PPO    " );
			tableMap.put("10", "CR_PER_PC040H    " );
			tableMap.put("11", "CR_PER_PAP    " );
			tableMap.put("12", "CR_PER_PF04ZH    " );
			tableMap.put("13", "CR_PER_PAH       " );
			tableMap.put("14", "CR_PER_PF08ZH    " );
			tableMap.put("15", "CR_PER_PG010H    " );
			tableMap.put("16", "CR_PER_PND       " );
			tableMap.put("17", "CR_PER_PE01ZH       " );
			tableMap.put("18", "CR_PER_PF01ZH    " );
			tableMap.put("19", "CR_PER_PMM    " );
			tableMap.put("20", "CR_PER_PDA       " );
			tableMap.put("21", "CR_PER_PD01ZH      " );
			tableMap.put("22", "CR_PER_PD01HH      " );
			tableMap.put("23", "CR_PER_PD01FH      " );
			tableMap.put("24", "CR_PER_PD01GH     " );
			tableMap.put("25", "CR_PER_PD01DH     " );
			tableMap.put("26", "CR_PER_PD01EH    " );
			tableMap.put("27", "CR_PER_PRM    " );
			tableMap.put("28", "CR_PER_PCJ       " );
			tableMap.put("29", "CR_PER_PF02ZH      " );
			tableMap.put("30", "CR_PER_PSM     " );
			tableMap.put("31", "CR_PER_POS      " );
			tableMap.put("32", "CR_PER_POT       " );
			tableMap.put("33", "CR_PER_PCE      " );
			tableMap.put("34", "CR_PER_PF03ZH      " );
			tableMap.put("35", "CR_PER_PIM      " );
			tableMap.put("36", "CR_PER_PB01BH      " );
			tableMap.put("37", "CR_PER_PCA       " );
			tableMap.put("38", "CR_PER_PD02ZH    " );
			tableMap.put("39", "CR_PER_PCR       " );
			tableMap.put("40", "CR_PER_PD03ZH       " );
			tableMap.put("41", "CR_PER_PCO       " );
			tableMap.put("42", "CR_PER_PC02BH       " );
			tableMap.put("43", "CR_PER_PC02KH    " );
			tableMap.put("44", "CR_PER_PC02AH       " );
			tableMap.put("45", "CR_PER_PC02DH       " );
			tableMap.put("46", "CR_PER_PPQ       " );
			tableMap.put("47", "CR_PER_PF07ZH       " );
			tableMap.put("48", "CR_PER_POM       " );
			tableMap.put("49", "CR_PER_PHF       " );
			tableMap.put("50", "CR_PER_PF05ZH       " );
			tableMap.put("51", "IND_ADDR" );
			tableMap.put("52", "IND_APP" );
			tableMap.put("53", "IND_CRD_DETAIL" );
			tableMap.put("54", "IND_CRD_SUM" );
			tableMap.put("55", "IND_DETAIL_INFO" );
			tableMap.put("56", "IND_ENQUIRY" );
			tableMap.put("57", "IND_HOUSEFUND_DEPOSIT" );
			tableMap.put("58", "IND_INFO" );
			tableMap.put("59", "IND_JOB" );
			tableMap.put("60", "IND_LON_DETAIL" );
			tableMap.put("61", "IND_PBOC_SCORE" );
			tableMap.put("62", "IND_SPECIAL" );
			tableMap.put("63","T_BLACKLIST");
			tableMap.put("64","T_COMPANY");
			tableMap.put("65","SYS_HIST");
		    return  tableMap.get(key).trim();
		}
		
		public static LinkedHashMap<String,String> getPerGen2TableMap(String rptIds){
			LinkedHashMap<String,String> tableMap=new LinkedHashMap<String,String>();
			tableMap.put("CR_PER_PRH","select * from CR_PER_PRH where id in ("+rptIds+")" );
			tableMap.put("CR_PER_PA01CH","select * from CR_PER_PA01CH where batch_id in ("+rptIds+")" );
			tableMap.put("CR_PER_POQ" ,"select * from CR_PER_POQ where id in ("+rptIds+")");
			tableMap.put("CR_PER_PQO" ,"select * from CR_PER_PQO where id in ("+rptIds+")");
			tableMap.put("CR_PER_PBS" , "select * from CR_PER_PBS where id in ("+rptIds+")");
			tableMap.put("CR_PER_PF06ZH","select * from  CR_PER_PF06ZH where batch_id in ("+rptIds+")" );
			tableMap.put("CR_COM_EC050H" ,"select * from CR_COM_EC050H where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PNO" ,"select * from CR_PER_PNO where id in ("+rptIds+")");
			tableMap.put("CR_PER_PC030H","select * from CR_PER_PC030H where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PPO" ,"select * from CR_PER_PPO where id in ("+rptIds+")");
			tableMap.put("CR_PER_PC040H" ,"select * from CR_PER_PC040H where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PAP" ,"select * from CR_PER_PAP where id in ("+rptIds+")");
			tableMap.put("CR_PER_PF04ZH" ,"select * from CR_PER_PF04ZH where batch_id in ("+rptIds+")" );
			tableMap.put("CR_PER_PAH" ,"select * from CR_PER_PAH where id in ("+rptIds+")");
			tableMap.put("CR_PER_PF08ZH" ,"select * from CR_PER_PF08ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PG010H" ,"select * from CR_PER_PG010H where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PND" ,"select * from CR_PER_PND where id in ("+rptIds+")");
			tableMap.put("CR_PER_PE01ZH" ,"select * from CR_PER_PE01ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PF01ZH" ,"select * from CR_PER_PF01ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PMM" ,"select * from CR_PER_PMM where id in ("+rptIds+")");
			tableMap.put("CR_PER_PDA" ,"select * from CR_PER_PDA where id in ("+rptIds+")");
			tableMap.put("CR_PER_PD01ZH","select * from  CR_PER_PD01ZH where batch_id in ("+rptIds+")" );
			tableMap.put("CR_PER_PD01HH" ,"select * from CR_PER_PD01HH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PD01FH" ,"select * from CR_PER_PD01FH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PD01GH" ,"select * from CR_PER_PD01GH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PD01DH" ,"select * from CR_PER_PD01DH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PD01EH" ,"select * from CR_PER_PD01EH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PRM" ,"select * from CR_PER_PRM where id in ("+rptIds+")");
			tableMap.put("CR_PER_PCJ" ,"select * from CR_PER_PCJ where id in ("+rptIds+")");
			tableMap.put("CR_PER_PF02ZH" ,"select * from CR_PER_PF02ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PSM" ,"select * from CR_PER_PSM where id in ("+rptIds+")");
			tableMap.put("CR_PER_POS" ,"select * from CR_PER_POS where id in ("+rptIds+")");
			tableMap.put("CR_PER_POT" ,"select * from CR_PER_POT where id in ("+rptIds+")");
			tableMap.put("CR_PER_PCE" ,"select * from CR_PER_PCE where id in ("+rptIds+")");
			tableMap.put("CR_PER_PF03ZH" ,"select * from CR_PER_PF03ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PIM" ,"select * from CR_PER_PIM where id in ("+rptIds+")");
			tableMap.put("CR_PER_PB01BH" ,"select * from CR_PER_PB01BH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PCA" ,"select * from CR_PER_PCA where id in ("+rptIds+")");
			tableMap.put("CR_PER_PD02ZH" ,"select * from CR_PER_PD02ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PCR" ,"select * from CR_PER_PCR where id in ("+rptIds+")");
			tableMap.put("CR_PER_PD03ZH" ,"select * from CR_PER_PD03ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PCO" ,"select * from CR_PER_PCO where id in ("+rptIds+")");
			tableMap.put("CR_PER_PC02BH" ,"select * from CR_PER_PC02BH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PC02KH" ,"select * from CR_PER_PC02KH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PC02AH" ,"select * from CR_PER_PC02AH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PC02DH" ,"select * from CR_PER_PC02DH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PPQ" ,"select * from CR_PER_PPQ where id in ("+rptIds+")");
			tableMap.put("CR_PER_PF07ZH" ,"select * from CR_PER_PF07ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_POM" ,"select * from CR_PER_POM where id in ("+rptIds+")");
			tableMap.put("CR_PER_PHF","select * from CR_PER_PHF where id in ("+rptIds+")" );
			tableMap.put("CR_PER_PF05ZH","select * from CR_PER_PF05ZH where batch_id in ("+rptIds+")" );
			return tableMap;
		}
		
		
		public static String getPerGen2Sql(String rptIds,String key){
			LinkedHashMap<String,String> tableMap=new LinkedHashMap<String,String>();
			tableMap.put("CR_PER_PRH","select * from CR_PER_PRH where id in ("+rptIds+")" );
			tableMap.put("CR_PER_PA01CH","select * from CR_PER_PA01CH where batch_id in ("+rptIds+")" );
			tableMap.put("CR_PER_POQ" ,"select * from CR_PER_POQ where id in ("+rptIds+")");
			tableMap.put("CR_PER_PQO" ,"select * from CR_PER_PQO where id in ("+rptIds+")");
			tableMap.put("CR_PER_PBS" , "select * from CR_PER_PBS where id in ("+rptIds+")");
			tableMap.put("CR_PER_PF06ZH","select * from  CR_PER_PF06ZH where batch_id in ("+rptIds+")" );
			tableMap.put("CR_COM_EC050H" ,"select * from CR_COM_EC050H where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PNO" ,"select * from CR_PER_PNO where id in ("+rptIds+")");
			tableMap.put("CR_PER_PC030H","select * from CR_PER_PC030H where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PPO" ,"select * from CR_PER_PPO where id in ("+rptIds+")");
			tableMap.put("CR_PER_PC040H" ,"select * from CR_PER_PC040H where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PAP" ,"select * from CR_PER_PAP where id in ("+rptIds+")");
			tableMap.put("CR_PER_PF04ZH" ,"select * from CR_PER_PF04ZH where batch_id in ("+rptIds+")" );
			tableMap.put("CR_PER_PAH" ,"select * from CR_PER_PAH where id in ("+rptIds+")");
			tableMap.put("CR_PER_PF08ZH" ,"select * from CR_PER_PF08ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PG010H" ,"select * from CR_PER_PG010H where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PND" ,"select * from CR_PER_PND where id in ("+rptIds+")");
			tableMap.put("CR_PER_PE01ZH" ,"select * from CR_PER_PE01ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PF01ZH" ,"select * from CR_PER_PF01ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PMM" ,"select * from CR_PER_PMM where id in ("+rptIds+")");
			tableMap.put("CR_PER_PDA" ,"select * from CR_PER_PDA where id in ("+rptIds+")");
			tableMap.put("CR_PER_PD01ZH","select * from  CR_PER_PD01ZH where batch_id in ("+rptIds+")" );
			tableMap.put("CR_PER_PD01HH" ,"select * from CR_PER_PD01HH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PD01FH" ,"select * from CR_PER_PD01FH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PD01GH" ,"select * from CR_PER_PD01GH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PD01DH" ,"select * from CR_PER_PD01DH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PD01EH" ,"select * from CR_PER_PD01EH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PRM" ,"select * from CR_PER_PRM where id in ("+rptIds+")");
			tableMap.put("CR_PER_PCJ" ,"select * from CR_PER_PCJ where id in ("+rptIds+")");
			tableMap.put("CR_PER_PF02ZH" ,"select * from CR_PER_PF02ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PSM" ,"select * from CR_PER_PSM where id in ("+rptIds+")");
			tableMap.put("CR_PER_POS" ,"select * from CR_PER_POS where id in ("+rptIds+")");
			tableMap.put("CR_PER_POT" ,"select * from CR_PER_POT where id in ("+rptIds+")");
			tableMap.put("CR_PER_PCE" ,"select * from CR_PER_PCE where id in ("+rptIds+")");
			tableMap.put("CR_PER_PF03ZH" ,"select * from CR_PER_PF03ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PIM" ,"select * from CR_PER_PIM where id in ("+rptIds+")");
			tableMap.put("CR_PER_PB01BH" ,"select * from CR_PER_PB01BH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PCA" ,"select * from CR_PER_PCA where id in ("+rptIds+")");
			tableMap.put("CR_PER_PD02ZH" ,"select * from CR_PER_PD02ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PCR" ,"select * from CR_PER_PCR where id in ("+rptIds+")");
			tableMap.put("CR_PER_PD03ZH" ,"select * from CR_PER_PD03ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PCO" ,"select * from CR_PER_PCO where id in ("+rptIds+")");
			tableMap.put("CR_PER_PC02BH" ,"select * from CR_PER_PC02BH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PC02KH" ,"select * from CR_PER_PC02KH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PC02AH" ,"select * from CR_PER_PC02AH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PC02DH" ,"select * from CR_PER_PC02DH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_PPQ" ,"select * from CR_PER_PPQ where id in ("+rptIds+")");
			tableMap.put("CR_PER_PF07ZH" ,"select * from CR_PER_PF07ZH where batch_id in ("+rptIds+")");
			tableMap.put("CR_PER_POM" ,"select * from CR_PER_POM where id in ("+rptIds+")");
			tableMap.put("CR_PER_PHF","select * from CR_PER_PHF where id in ("+rptIds+")" );
			tableMap.put("CR_PER_PF05ZH","select * from CR_PER_PF05ZH where batch_id in ("+rptIds+")" );
			tableMap.put("IND_ADDR","select * from IND_ADDR  where  trim(rpt_id) in ("+rptIds+")" );
			tableMap.put("IND_APP","select  *  from IND_APP  where  trim(rpt_id) in ("+rptIds+")" );
			tableMap.put("IND_CRD_DETAIL","select  *  from IND_CRD_DETAIL  where  trim(rpt_id) in ("+rptIds+")" );
			tableMap.put("IND_CRD_SUM","select  *  from IND_CRD_SUM  where  trim(rpt_id) in ("+rptIds+")" );
			tableMap.put("IND_DETAIL_INFO","select  *  from IND_DETAIL_INFO  where  trim(rpt_id) in ("+rptIds+")" );
			tableMap.put("IND_ENQUIRY","select  *  from IND_ENQUIRY  where  trim(rpt_id) in ("+rptIds+")" );
			tableMap.put("IND_HOUSEFUND_DEPOSIT","select  *  from IND_HOUSEFUND_DEPOSIT  where  trim(rpt_id) in ("+rptIds+")" );
			tableMap.put("IND_INFO","select  *  from IND_INFO  where  trim(rpt_id) in ("+rptIds+")" );
			tableMap.put("IND_JOB", "select  *   from IND_JOB   where  trim(rpt_id) in ("+rptIds+")" );
			tableMap.put("IND_LON_DETAIL", "select  *   from IND_LON_DETAIL   where  trim(rpt_id) in ("+rptIds+")" );
			tableMap.put("IND_PBOC_SCORE", "select  *   from IND_PBOC_SCORE   where  trim(rpt_id) in ("+rptIds+")" );
			tableMap.put("IND_SPECIAL",    "select  *   from IND_SPECIAL      where  trim(rpt_id) in ("+rptIds+")" );
			tableMap.put("IND_SPECIAL",    "select  *   from IND_SPECIAL      where  trim(rpt_id) in ("+rptIds+")" );
			tableMap.put("T_BLACKLIST",    "select  *   from T_BLACKLIST      where 1=1 " );
			tableMap.put("T_COMPANY",    "select  *   from T_COMPANY      where  1=1  " );
			tableMap.put("SYS_HIST",    "select  *    from SYS_HIST      where  1=1  "+rptIds+"" );
			return tableMap.get(key).trim();
		}
		private static String getSubFileld(String field) {
			if(StringUtils.isNotEmpty(field)) {
			    return field.substring(0, field.length()-1);
			}
			return field;
		}
		
		
		public static LinkedHashMap<String,String> getGen2TableMap(String rptIds){
			LinkedHashMap<String,String> tableMap=new LinkedHashMap<String,String>();
			tableMap.put( "CR_COM_EAA" , "select * from CR_COM_EAA     where id in ("+rptIds+")" );
			tableMap.put( "CR_COM_EA01CH" , "select * from CR_COM_EA01CH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ECA" , "select * from CR_COM_ECA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EC020H" , "select * from CR_COM_EC020H  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EC030H" , "select * from CR_COM_EC030H  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EC050H" , "select * from CR_COM_EC050H  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EC050H" , "select * from CR_COM_EC050H  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EBA" , "select * from CR_COM_EBA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EBB" , "select * from CR_COM_EBB     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB02AH" , "select * from CR_COM_EB02AH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB02BH" , "select * from CR_COM_EB02BH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB02CH" , "select * from CR_COM_EB02CH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EBC" , "select * from CR_COM_EBC     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB03AH" , "select * from CR_COM_EB03AH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB03BH" , "select * from CR_COM_EB03BH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EBD" , "select * from CR_COM_EBD     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EBE" , "select * from CR_COM_EBE     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB05AH" , "select * from CR_COM_EB05AH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB05BH" , "select * from CR_COM_EB05BH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EDA" , "select * from CR_COM_EDA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED01" , "select * from CR_COM_ED01    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED02" , "select * from CR_COM_ED02    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED03" , "select * from CR_COM_ED03    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED01B" , "select * from CR_COM_ED01B   where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED01C" , "select * from CR_COM_ED01C   where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED01BH" , "select * from CR_COM_ED01BH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED01CH" , "select * from CR_COM_ED01CH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EDB" , "select * from CR_COM_EDB     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED04" , "select * from CR_COM_ED04    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED04B" , "select * from CR_COM_ED04B   where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED05" , "select * from CR_COM_ED05    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EDC" , "select * from CR_COM_EDC     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED06" , "select * from CR_COM_ED06    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED07" , "select * from CR_COM_ED07    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED08" , "select * from CR_COM_ED08    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED09" , "select * from CR_COM_ED09    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EEA" , "select * from CR_COM_EEA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EE01BH" , "select * from CR_COM_EE01BH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFA" , "select * from CR_COM_EFA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFB" , "select * from CR_COM_EFB     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFC" , "select * from CR_COM_EFC     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFD" , "select * from CR_COM_EFD     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EF05BH" , "select * from CR_COM_EF05BH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFE" , "select * from CR_COM_EFE     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFF" , "select * from CR_COM_EFF     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFG" , "select * from CR_COM_EFG     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EGA" , "select * from CR_COM_EGA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EHA" , "select * from CR_COM_EHA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EIA" , "select * from CR_COM_EIA     where id in ("+rptIds+")");
			return tableMap;
		}
		
		public static String getGen2Sql(String rptIds,String key){
			LinkedHashMap<String,String> tableMap=new LinkedHashMap<String,String>();
			tableMap.put( "CR_COM_EAA" , "select * from CR_COM_EAA     where id in ("+rptIds+")" );
			tableMap.put( "CR_COM_EA01CH" , "select * from CR_COM_EA01CH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ECA" , "select * from CR_COM_ECA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EC020H" , "select * from CR_COM_EC020H  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EC030H" , "select * from CR_COM_EC030H  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EC050H" , "select * from CR_COM_EC050H  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EC050H" , "select * from CR_COM_EC050H  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EBA" , "select * from CR_COM_EBA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EBB" , "select * from CR_COM_EBB     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB02AH" , "select * from CR_COM_EB02AH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB02BH" , "select * from CR_COM_EB02BH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB02CH" , "select * from CR_COM_EB02CH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EBC" , "select * from CR_COM_EBC     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB03AH" , "select * from CR_COM_EB03AH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB03BH" , "select * from CR_COM_EB03BH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EBD" , "select * from CR_COM_EBD     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EBE" , "select * from CR_COM_EBE     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB05AH" , "select * from CR_COM_EB05AH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EB05BH" , "select * from CR_COM_EB05BH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EDA" , "select * from CR_COM_EDA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED01" , "select * from CR_COM_ED01    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED02" , "select * from CR_COM_ED02    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED03" , "select * from CR_COM_ED03    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED01B" , "select * from CR_COM_ED01B   where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED01C" , "select * from CR_COM_ED01C   where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED01BH" , "select * from CR_COM_ED01BH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED01CH" , "select * from CR_COM_ED01CH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EDB" , "select * from CR_COM_EDB     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED04" , "select * from CR_COM_ED04    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED04B" , "select * from CR_COM_ED04B   where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED05" , "select * from CR_COM_ED05    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EDC" , "select * from CR_COM_EDC     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED06" , "select * from CR_COM_ED06    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED07" , "select * from CR_COM_ED07    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED08" , "select * from CR_COM_ED08    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_ED09" , "select * from CR_COM_ED09    where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EEA" , "select * from CR_COM_EEA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EE01BH" , "select * from CR_COM_EE01BH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFA" , "select * from CR_COM_EFA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFB" , "select * from CR_COM_EFB     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFC" , "select * from CR_COM_EFC     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFD" , "select * from CR_COM_EFD     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EF05BH" , "select * from CR_COM_EF05BH  where batch_id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFE" , "select * from CR_COM_EFE     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFF" , "select * from CR_COM_EFF     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EFG" , "select * from CR_COM_EFG     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EGA" , "select * from CR_COM_EGA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EHA" , "select * from CR_COM_EHA     where id in ("+rptIds+")");
			tableMap.put( "CR_COM_EIA" , "select * from CR_COM_EIA     where id in ("+rptIds+")");
			return tableMap.get(key).trim();
		}
	 
}
