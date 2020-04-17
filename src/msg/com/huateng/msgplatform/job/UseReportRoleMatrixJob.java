package com.huateng.msgplatform.job;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.apache.poi.hssf.util.Region;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import resource.bean.basic.ReportJobConfig;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.management.service.SendMailService;
import com.huateng.ebank.business.management.service.SendMailServiceWithFj;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.htaml.reportForm.util.MailConstants;
import com.huateng.msgplatform.service.DataMapService;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.utils.ReportUtils;

@SuppressWarnings("rawtypes")
public class UseReportRoleMatrixJob implements org.quartz.StatefulJob {

	private Logger htlog = Logger.getLogger(UseReportRoleMatrixJob.class);

	private Map mstatus = null;
	private Map mcity = null;
	private Map mregion = null;
	private Map mdepartMent = null;
	private Map mflag = null;

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		String result = ReportCommonService.JOB_OK;
		Date endTm = null;
		String jobName = null;
		String jobId = null;
		String remark = "";
		Date startTm = null;
		// Date dt=null;
		try {
			jobId = context.getJobDetail().getJobDataMap().getString("jobId");
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class,
					jobId);
			jobName = jobConfig.getJobName();
			remark = jobConfig.getJobRemark();
			startTm = new Date();
			// dt = new Date();
			// String dttime =new
			// SimpleDateFormat("yyyyMMdd").format(dt).toString();
			String CurrDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(startTm).toString();

			if (DateUtil.isHoliday()
					&& "Y".equals(jobConfig.getJustWorkdateRun())) {
				remark = "该JOB只在工作日执行";
				return;
			}
			mstatus = DataMapService.getNameByNo(888);
			mflag = DataMapService.getNameByNo(38);
			mcity = DataMapService.getNameByNo(503);
			mregion = DataMapService.getNameByNo(502);
			mdepartMent = DataMapService.getNameByNo(501);
			getExcelData(CurrDate);
			Thread.sleep(17);
		} catch (Exception e) {
			e.printStackTrace();
			result = ReportCommonService.JOB_FAILED;
			remark = e.getMessage();
		} finally {
			endTm = new Date();
			ReportCommonService.getInstance().saveJobLog(startTm, endTm, jobId,
					result, jobName, remark);
		}

	}

	private String getSpecifiedDayBefore(String currDate) {
		// TODO Auto-generated method stub
		return null;
	}

	private void getExcelData(String CurrDate) throws SQLException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		Date dt = new Date();
		Date dt2 = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		dt2 = cal.getTime();
		String dttime = new SimpleDateFormat("yyyyMMdd").format(dt2).toString();
		String sql = "select a.TLRNO,a.TLR_NAME,a.CITY,a.REGION,a.DEPARTMENT,a.FLAG,a.STATUS,a.LAST_UPD_TMS,"
				+ "a.MAKETIME,a.LASTACCESSTM,c.ROLE_NAME from TLR_ROLE_REL b,ROLE_INFO c, TLR_INFO a "
				+ "where a.TLRNO = b.TLRNO and c.ROLE_ID = b.ROLE_ID ";
		String sql1 = "select a.TLRNO,a.TLR_NAME,a.CITY,a.REGION,a.DEPARTMENT,a.FLAG,a.STATUS,a.LAST_UPD_TMS,"
				+ "a.MAKETIME,a.LASTACCESSTM,c.ROLE_NAME from TLR_ROLE_REL b,ROLE_INFO c, TLR_INFO a "
				+ "where a.TLRNO = b.TLRNO and c.ROLE_ID = b.ROLE_ID  and a.LAST_UPD_TMS like '%"
				+ dttime + "%'";

		try {
			Iterator it = rootdao.queryBySQL2(sql.toString());
			Iterator it1 = rootdao.queryBySQL2(sql1.toString());
			// 创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFWorkbook workbook1 = new HSSFWorkbook();
			// 创建sheet
			HSSFSheet[] sheet = new HSSFSheet[8];
			HSSFSheet[] sheet1 = new HSSFSheet[8];
			// 创建行
			HSSFRow row = null;
			HSSFRow row1 = null;
			// 创建单元格
			HSSFCell cell = null;
			HSSFCell cell1 = null;
			// 创建一个sheet
			sheet[0] = workbook.createSheet("User Report");
			sheet1[0] = workbook1.createSheet("User Report Time");
			// 左对齐 0x31 文本格式
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyle.setDataFormat((short) 0x31);
			HSSFCellStyle cellStyle1 = workbook1.createCellStyle();
			cellStyle1.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyle1.setDataFormat((short) 0x31);
			// 写入行名称
			String title = "login ID;User name;City;Region;Role;department;Lock or Unlock;Time of last update;Time of last login;creation time;Personal bureau enquiry;Corp bureau enquiry;User status";
			String titleList[] = title.split(";");

			String time = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
			setRegionStyle(sheet[0], new Region(0,(short)0,0,(short)12),cellStyle);
			sheet[0].addMergedRegion(new Region(0,(short)0,0,(short)12));
			// 设置字体   
			HSSFFont headfont = workbook.createFont();   
			headfont.setFontName("Arial");   
			headfont.setFontHeightInPoints((short) 22);// 字体大小   
			headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗   
			HSSFCellStyle headstyle  = workbook.createCellStyle();
			
			HSSFFont columnHeadFont = workbook.createFont();   
			columnHeadFont.setFontName("Arial");   
			columnHeadFont.setFontHeightInPoints((short) 10);   
			HSSFRichTextString ts= new HSSFRichTextString("IBS        Date:" + time + "   Page:1");
			ts.applyFont(0,3,headfont);
			ts.applyFont(3,ts.length(),columnHeadFont);

			headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中   
			headstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中   
			headstyle.setDataFormat((short) 0x31);
			row = sheet[0].createRow(0);
			cell = row.createCell(0);
			cell.setCellStyle(headstyle);
			cell.setCellValue(ts);

			row = sheet[0].createRow(1);
			row.setHeight((short) 300);
			
			row1 = sheet1[0].createRow(0);
			row1.setHeight((short) 300);
			for (int i = 0; i < titleList.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(titleList[i]);
				sheet[0].autoSizeColumn(i, true);
			}
			row1 = sheet1[0].createRow(0);
			row1.setHeight((short) 300);
			for (int i = 0; i < titleList.length; i++) {
				cell1 = row1.createCell(i);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(titleList[i]);
				sheet1[0].autoSizeColumn(i, true);
			}
			int i = 2;
			int j = 1;
			while (it.hasNext()) {
				Map map = (Map) it.next();
				String login_ID = transfer_toString(map.get("TLRNO"));
				String User_name = transfer_toString(map.get("TLR_NAME"));
				String City = checkNull(mcity,
						transfer_toString(map.get("CITY")));
				String Region = checkNull(mregion,
						transfer_toString(map.get("REGION")));
				String Role = transfer_toString(map.get("ROLE_NAME"));
				String department = checkNull(mdepartMent,
						transfer_toString(map.get("DEPARTMENT")));
				String flag = checkNull(mflag,
						transfer_toString(map.get("FLAG")));
				String status = checkNull(mstatus,
						transfer_toString(map.get("STATUS")));
				// String status=transfer_toString(map.get("STATUS"));
				if (("normal").equals(status)) {
					status = "active";
				} else if (("disable".equals(status))) {
					status = "inactive";
				} else{
					status = "active";
				}
				String last_upd_time = transfer_toString(map
						.get("LAST_UPD_TMS"));
				String lastaccesstm = transfer_toString(map.get("LASTACCESSTM"));
				String maketime = transfer_toString(map.get("MAKETIME"));
				row = sheet[0].createRow(i);
				row.setHeight((short) 300);
				// login ID
				cell = row.createCell(0);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(login_ID);
				// User name
				cell = row.createCell(1);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(User_name);
				// City
				cell = row.createCell(2);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(City);
				// Region
				cell = row.createCell(3);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(Region);
				// Role
				cell = row.createCell(4);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(Role);
				// department
				cell = row.createCell(5);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(department);
				// flag
				cell = row.createCell(6);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(flag);
				// last_upd_time
				cell = row.createCell(7);
				cell.setCellStyle(cellStyle);

				if (!"".equals(last_upd_time) && null != last_upd_time
						&& "NULL" != last_upd_time) {
					String str1 = last_upd_time.substring(0, 8);
					String str2 = last_upd_time.substring(8, 10);
					String str3 = last_upd_time.substring(10, 12);
					String str4 = last_upd_time.substring(12, 14);
					String sub_latest_maintenance_time = str1 + " " + str2
							+ ":" + str3 + ":" + str4;
					try {
						Date sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss")
								.parse(sub_latest_maintenance_time);
						cell.setCellValue(new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss").format(sdf));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					cell.setCellValue(last_upd_time);
				}
				// lastaccesstm
				cell = row.createCell(8);
				cell.setCellStyle(cellStyle);
				if (!"".equals(lastaccesstm) && null != lastaccesstm
						&& "NULL" != lastaccesstm) {
					String str5 = lastaccesstm.substring(0, 8);
					String str6 = lastaccesstm.substring(8, 10);
					String str7 = lastaccesstm.substring(10, 12);
					String str8 = lastaccesstm.substring(12, 14);
					String sub_lastaccesstm = str5 + " " + str6 + ":" + str7
							+ ":" + str8;
					try {
						Date sdf1 = new SimpleDateFormat("yyyyMMdd HH:mm:ss")
								.parse(sub_lastaccesstm);
						cell.setCellValue(new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss").format(sdf1));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					cell.setCellValue(lastaccesstm);
				}
				// maketime
				cell = row.createCell(9);
				cell.setCellStyle(cellStyle);
				if (!"".equals(maketime) && "NULL" != maketime
						&& null != maketime) {
					String str9 = maketime.substring(0, 8);
					String str11 = maketime.substring(8, 10);
					String str12 = maketime.substring(10, 12);
					String str13 = maketime.substring(12, 14);
					String sub_maketime = str9 + " " + str11 + ":" + str12
							+ ":" + str13;
					try {
						Date sdf2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss")
								.parse(sub_maketime);
						cell.setCellValue(new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss").format(sdf2));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					cell.setCellValue(maketime);
				}
				// Personal bureau enquiry
				cell = row.createCell(10);
				cell.setCellStyle(cellStyle);
				if ("Ind Enq".equals(Role) || "Ind Enq Batch".equals(Role)
						|| "Ind Enq Emerg".equals(Role)) {

					cell.setCellValue("Y");
				} else {
					cell.setCellValue("N");
				}

				// Corp bureau enquiry
				cell = row.createCell(11);
				cell.setCellStyle(cellStyle);
				if ("Com Enq".equals(Role) || "Com Enq Batch".equals(Role)
						|| "Com Enq Emerg".equals(Role)) {

					cell.setCellValue("Y");
				} else {
					cell.setCellValue("N");
				}
				// status
				cell = row.createCell(12);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(status);
				i++;
			}
			while (it1.hasNext()) {
				Map map = (Map) it1.next();
				String login_ID = transfer_toString(map.get("TLRNO"));
				String User_name = transfer_toString(map.get("TLR_NAME"));
				String City = checkNull(mcity,
						transfer_toString(map.get("CITY")));
				String Region = checkNull(mregion,
						transfer_toString(map.get("REGION")));
				String Role = transfer_toString(map.get("ROLE_NAME"));
				String department = checkNull(mdepartMent,
						transfer_toString(map.get("DEPARTMENT")));
				String flag = checkNull(mflag,
						transfer_toString(map.get("FLAG")));
				String status = checkNull(mstatus,
						transfer_toString(map.get("STATUS")));
				// String status=transfer_toString(map.get("STATUS"));
				if (("normal").equals(status)) {
					status = "active";
				} else if (("disable").equals(status)) {
					status = "inactive";
				}else{
					status = "active";
				}
				String last_upd_time = transfer_toString(map
						.get("LAST_UPD_TMS"));
				String lastaccesstm = transfer_toString(map.get("LASTACCESSTM"));
				String maketime = transfer_toString(map.get("MAKETIME"));
				 
				row1 = sheet1[0].createRow(j);
				row1.setHeight((short) 300);
				// login ID
				cell1 = row1.createCell(0);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(login_ID);
				// User name
				cell1 = row1.createCell(1);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(User_name);
				// City
				cell1 = row1.createCell(2);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(City);
				// Region
				cell1 = row1.createCell(3);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(Region);
				// Role
				cell1 = row1.createCell(4);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(Role);
				// department
				cell1 = row1.createCell(5);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(department);
				// flag
				cell1 = row1.createCell(6);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(flag);
				// last_upd_time
				cell1 = row1.createCell(7);
				cell1.setCellStyle(cellStyle1);

				if (!"".equals(last_upd_time) && null != last_upd_time
						&& "NULL" != last_upd_time) {
					String str1 = last_upd_time.substring(0, 8);
					String str2 = last_upd_time.substring(8, 10);
					String str3 = last_upd_time.substring(10, 12);
					String str4 = last_upd_time.substring(12, 14);
					String sub_latest_maintenance_time = str1 + " " + str2
							+ ":" + str3 + ":" + str4;
					try {
						Date sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss")
								.parse(sub_latest_maintenance_time);
						cell1.setCellValue(new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss").format(sdf));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					cell1.setCellValue(last_upd_time);
				}
				// lastaccesstm
				cell1 = row1.createCell(8);
				cell1.setCellStyle(cellStyle1);
				if (!"".equals(lastaccesstm) && null != lastaccesstm
						&& "NULL" != lastaccesstm) {
					String str5 = lastaccesstm.substring(0, 8);
					String str6 = lastaccesstm.substring(8, 10);
					String str7 = lastaccesstm.substring(10, 12);
					String str8 = lastaccesstm.substring(12, 14);
					String sub_lastaccesstm = str5 + " " + str6 + ":" + str7
							+ ":" + str8;
					try {
						Date sdf1 = new SimpleDateFormat("yyyyMMdd HH:mm:ss")
								.parse(sub_lastaccesstm);
						cell1.setCellValue(new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss").format(sdf1));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					cell1.setCellValue(lastaccesstm);
				}
				// maketime
				cell1 = row1.createCell(9);
				cell1.setCellStyle(cellStyle1);
				if (!"".equals(maketime) && "NULL" != maketime
						&& null != maketime) {
					String str9 = maketime.substring(0, 8);
					String str11 = maketime.substring(8, 10);
					String str12 = maketime.substring(10, 12);
					String str13 = maketime.substring(12, 14);
					String sub_maketime = str9 + " " + str11 + ":" + str12
							+ ":" + str13;
					try {
						Date sdf2 = new SimpleDateFormat("yyyyMMdd HH:mm:ss")
								.parse(sub_maketime);
						cell1.setCellValue(new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss").format(sdf2));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else {
					cell1.setCellValue(maketime);
				}
				// Personal bureau enquiry
				cell1 = row1.createCell(10);
				cell1.setCellStyle(cellStyle1);
				if ("Ind Enq".equals(Role) || "Ind Enq Batch".equals(Role)
						|| "Ind Enq Emerg".equals(Role)) {

					cell1.setCellValue("Y");
				} else {
					cell1.setCellValue("N");
				}

				// Corp bureau enquiry
				cell1 = row1.createCell(11);
				cell1.setCellStyle(cellStyle1);
				if ("Com Enq".equals(Role) || "Com Enq Batch".equals(Role)
						|| "Com Enq Emerg".equals(Role)) {

					cell1.setCellValue("Y");
				} else {
					cell1.setCellValue("N");
				}
				// status
				cell1 = row1.createCell(12);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(status);
				j++;
			}
			sheet[0].setColumnWidth(0, 250 * 20);// login ID
			sheet[0].setColumnWidth(1, 250 * 20);// User name
			sheet[0].setColumnWidth(2, 250 * 20);// City
			sheet[0].setColumnWidth(3, 250 * 20);// Region
			sheet[0].setColumnWidth(4, 250 * 25);// Role
			sheet[0].setColumnWidth(5, 250 * 20);// department
			sheet[0].setColumnWidth(6, 250 * 20);// status
			sheet[0].setColumnWidth(7, 250 * 20);// latest maintenance time
			sheet[0].setColumnWidth(8, 250 * 20);// lastaccesstm
			sheet[0].setColumnWidth(9, 250 * 20);// maketime
			sheet[0].setColumnWidth(10, 280 * 20);// Personal bureau enquiry
			sheet[0].setColumnWidth(11, 250 * 20);// Corp bureau enquiry
			sheet[0].setColumnWidth(12, 250 * 20);// User status

			sheet1[0].setColumnWidth(0, 250 * 20);// login ID
			sheet1[0].setColumnWidth(1, 250 * 20);// User name
			sheet1[0].setColumnWidth(2, 250 * 20);// City
			sheet1[0].setColumnWidth(3, 250 * 20);// Region
			sheet1[0].setColumnWidth(4, 250 * 25);// Role
			sheet1[0].setColumnWidth(5, 250 * 20);// department
			sheet1[0].setColumnWidth(6, 250 * 20);// status
			sheet1[0].setColumnWidth(7, 250 * 20);// latest maintenance time
			sheet1[0].setColumnWidth(8, 250 * 20);// lastaccesstm
			sheet1[0].setColumnWidth(9, 250 * 20);// maketime
			sheet1[0].setColumnWidth(10, 280 * 20);// Personal bureau enquiry
			sheet1[0].setColumnWidth(11, 250 * 20);// Corp bureau enquiry
			sheet1[0].setColumnWidth(12, 250 * 20);// User status
			String filepath = ReportUtils.getSysParamsValue("UserReport",
					"User");
			String destFileName = filepath + "User_Report_" + CurrDate + ".xls";
			String destFileName1 = filepath + "User_Report_Time_" + dttime
					+ ".xls";

			String[] Filename = { destFileName1 };
			String[] Filename1 = { destFileName };

			File file = new File(filepath);
			if (!file.exists()) {
				file.mkdirs();
			}
			FileOutputStream output = new FileOutputStream(destFileName);
			FileOutputStream output1 = new FileOutputStream(destFileName1);
			workbook.write(output);
			workbook1.write(output1);
			output.flush();
			output.close();
			output1.flush();
			output1.close();
			workbook.close();
			workbook1.close();
			String content = "<h4>Dear All,</h4>"+
					"Attached user change report for your reference.<br>" +
					"  ·         column K=’Y’ stands for personal bureau enquiry access<br>"+
					"  ·         column L=’Y’ stands for corp bureau enquiry access";
			SendMailServiceWithFj.getMailBeanAndSendMail(
					MailConstants.SEND_TLRMODIFY, content,
					"Daily User change report", Filename);

			String Pre_Date = getSpecifiedDayBefore(CurrDate);
			String day = CurrDate.substring(8, 10);
			if (day == "01" || day.equals("01")) {
				SendMailServiceWithFj.getMailBeanAndSendMail(
						MailConstants.SEND_TLRMODIFY, "User_Report的xls请见附件",
						"Daily User change report", Filename1);

			}
			//daily user enquiry report的邮件
			dailyUserEnquiryReport();
			htlog.info("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void dailyUserEnquiryReport() throws Exception{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		
		Date nowDay = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(nowDay);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date yesterday = cal.getTime();
		String CreatDate = new SimpleDateFormat("yyyyMMdd").format(yesterday);
		
		
		StringBuffer sql = new StringBuffer();
		sql.append("select num.COUNT,num.create_user,info.TLR_NAME,info.CITY,info.REGION,info.DEPARTMENT ");
		  sql.append("from ( ");
				sql.append(" select COUNT(cust.create_user) as COUNT,NVL(cust.create_user,'system') as create_user ");
				  sql.append(" from cust_pboc_per_query cust ");
				  sql.append("where cust.create_time >= '" + CreatDate + "000000' ");
				    sql.append("and cust.create_time <= '" + CreatDate + "235959' ");
				  sql.append("group by cust.create_user) num ");
		  sql.append("left join TLR_INFO info ");
		  sql.append( " on num.create_user = info.TLRNO ");
		  
		StringBuffer sqlCorp = new StringBuffer();
		sqlCorp.append("select num.COUNT,num.create_user,info.TLR_NAME,info.CITY,info.REGION,info.DEPARTMENT ");
	  	  sqlCorp.append("from ( ");
	  	  		sqlCorp.append(" select COUNT(cust.create_user) as COUNT,NVL(cust.create_user,'system') as create_user ");
	  	  		  sqlCorp.append(" from cust_pboc_ent_query cust ");
	  	  		  sqlCorp.append("where cust.create_time >= '" + CreatDate + "000000' ");
	  	  		    sqlCorp.append("and cust.create_time <= '" + CreatDate + "235959' ");
	  	  		  sqlCorp.append("group by cust.create_user) num ");
		  sqlCorp.append("left join TLR_INFO info ");
		  sqlCorp.append( " on num.create_user = info.TLRNO ");  
		  
		  
		Iterator it = rootdao.queryBySQL2(sql.toString());
		Iterator itCorp = rootdao.queryBySQL2(sqlCorp.toString());
		
		// 创建工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFWorkbook workbookCorp = new HSSFWorkbook();
		// 创建sheet
		HSSFSheet[] sheet = new HSSFSheet[8];
		HSSFSheet[] sheetCorp = new HSSFSheet[8];
		// 创建行
		HSSFRow row = null;
		HSSFRow rowCorp = null;
		// 创建单元格
		HSSFCell cell = null;
		HSSFCell cellCorp = null;
		// 创建一个sheet
		sheet[0] = workbook.createSheet("Daily user enquiry report");
		sheetCorp[0] = workbookCorp.createSheet("Daily user enquiry report");
		// 左对齐 0x31 文本格式
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		cellStyle.setDataFormat((short) 0x31);
		
		HSSFCellStyle cellStyleCorp = workbookCorp.createCellStyle();
		cellStyleCorp.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		cellStyleCorp.setDataFormat((short) 0x31);
		// 写入行名称
		String title = "login ID;User name;City;Region;department;Role;enquiry number;Date";
		String titleList[] = title.split(";");
		row = sheet[0].createRow(0);
		row.setHeight((short) 300);
		for (int i = 0; i < titleList.length; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(titleList[i]);
			sheet[0].autoSizeColumn(i, true);
		}
		rowCorp = sheetCorp[0].createRow(0);
		rowCorp.setHeight((short) 300);
		for (int i = 0; i < titleList.length; i++) {
			cellCorp = rowCorp.createCell(i);
			cellCorp.setCellStyle(cellStyleCorp);
			cellCorp.setCellValue(titleList[i]);
			sheetCorp[0].autoSizeColumn(i, true);
		}
		int i = 1;
		int j = 1;
		while (it.hasNext()) {
			Map map = (Map) it.next();
			String count = transfer_toString(map.get("COUNT"));
			String tlrno = transfer_toString(map.get("create_user"));
			if(tlrno.equals("system")){
				continue;
			}
			String name = transfer_toString(map.get("TLR_NAME"));
			String city = checkNull(mcity, transfer_toString(map.get("CITY")));
			String region = checkNull(mregion, transfer_toString(map.get("REGION")));
			String department = checkNull(mdepartMent, transfer_toString(map.get("DEPARTMENT")));
			row = sheet[0].createRow(i);
			row.setHeight((short) 300);
			// login ID
			cell = row.createCell(0);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(tlrno);
			// User name
			cell = row.createCell(1);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(name);
			// City
			cell = row.createCell(2);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(city);
			// Region
			cell = row.createCell(3);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(region);
			// Department
			cell = row.createCell(4);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(department);
			// Role
			cell = row.createCell(5);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("ind enquery");
			// count
			cell = row.createCell(6);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(count);
			
			// count
			cell = row.createCell(7);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(CreatDate);
			i++;
		}
		
		while (itCorp.hasNext()) {
			Map map = (Map) itCorp.next();
			String count = transfer_toString(map.get("COUNT"));
			String tlrno = transfer_toString(map.get("create_user"));
			if(tlrno.equals("system")){
				continue;
			}
			String name = transfer_toString(map.get("TLR_NAME"));
			String city = checkNull(mcity, transfer_toString(map.get("CITY")));
			String region = checkNull(mregion, transfer_toString(map.get("REGION")));
			String department = checkNull(mdepartMent, transfer_toString(map.get("DEPARTMENT")));
			rowCorp = sheetCorp[0].createRow(j);
			rowCorp.setHeight((short) 300);
			// login ID
			cellCorp = rowCorp.createCell(0);
			cellCorp.setCellStyle(cellStyleCorp);
			cellCorp.setCellValue(tlrno);
			// User name
			cellCorp = rowCorp.createCell(1);
			cellCorp.setCellStyle(cellStyleCorp);
			cellCorp.setCellValue(name);
			// City
			cellCorp = rowCorp.createCell(2);
			cellCorp.setCellStyle(cellStyleCorp);
			cellCorp.setCellValue(city);
			// Region
			cellCorp = rowCorp.createCell(3);
			cellCorp.setCellStyle(cellStyleCorp);
			cellCorp.setCellValue(region);
			// Department
			cellCorp = rowCorp.createCell(4);
			cellCorp.setCellStyle(cellStyleCorp);
			cellCorp.setCellValue(department);
			// Role
			cellCorp = rowCorp.createCell(5);
			cellCorp.setCellStyle(cellStyleCorp);
			cellCorp.setCellValue("corp enquery");
			// count
			cellCorp = rowCorp.createCell(6);
			cellCorp.setCellStyle(cellStyleCorp);
			cellCorp.setCellValue(count);
			
			// count
			cellCorp = rowCorp.createCell(7);
			cellCorp.setCellStyle(cellStyleCorp);
			cellCorp.setCellValue(CreatDate);
			j++;
		}
		
		
		sheet[0].setColumnWidth(0, 250 * 20);// login ID
		sheet[0].setColumnWidth(1, 250 * 20);// User name
		sheet[0].setColumnWidth(2, 250 * 20);// City
		sheet[0].setColumnWidth(3, 250 * 20);// Region
		sheet[0].setColumnWidth(4, 250 * 25);// Role
		sheet[0].setColumnWidth(5, 250 * 20);// department
		sheet[0].setColumnWidth(6, 250 * 20);// count
		sheet[0].setColumnWidth(7, 250 * 20);// date
		
		sheetCorp[0].setColumnWidth(0, 250 * 20);// login ID
		sheetCorp[0].setColumnWidth(1, 250 * 20);// User name
		sheetCorp[0].setColumnWidth(2, 250 * 20);// City
		sheetCorp[0].setColumnWidth(3, 250 * 20);// Region
		sheetCorp[0].setColumnWidth(4, 250 * 25);// Role
		sheetCorp[0].setColumnWidth(5, 250 * 20);// department
		sheetCorp[0].setColumnWidth(6, 250 * 20);// count
		sheetCorp[0].setColumnWidth(7, 250 * 20);// date
		
		String filepath = ReportUtils.getSysParamsValue("UserReport", "User");
		
		
		String destFileName = filepath + "Daily_User_Ind_Enquiry_Report_" + CreatDate + ".xls";
		String destFileNameCorp = filepath + "Daily_User_Corp_Enquiry_Report_" + CreatDate + ".xls";
		
		
		//String[] FilenameCorp = { destFileNameCorp };
		
		File file = new File(filepath);
		if (!file.exists()) {
			file.mkdirs();
		}
		FileOutputStream output = new FileOutputStream(destFileName);
		workbook.write(output);
		output.flush();
		output.close();
		workbook.close();
		
		FileOutputStream outputCorp = new FileOutputStream(destFileNameCorp);
		workbookCorp.write(outputCorp);
		outputCorp.flush();
		outputCorp.close();
		workbookCorp.close();
		
		String[] Filename = { destFileName,destFileNameCorp};
		SendMailServiceWithFj.getMailBeanAndSendMail(
				MailConstants.SEND_TLRMODIFY, "daily user enquiry report的xls请见附件",
				"Daily User enquiry summary report", Filename);
	}
	private String transfer_toString(Object str_son) {
		if (null == str_son)
			return "NULL".toString();
		return str_son.toString();
	}

	public String checkNull(Map p, String t) {
		if (t == null) {
			return "";
		} else {
			return (String) p.get(t.trim());
		}
	}
	
	/**
	* 设置单元格边框（解决合并单元格显示部分边框问题）
	* @param sheet 
	* @param region
	* @param cs
	*/
	private void setRegionStyle(HSSFSheet sheet, Region region, HSSFCellStyle cs) {

		for (int i = region.getRowFrom(); i <= region.getRowTo(); i++) {
			HSSFRow row = HSSFCellUtil.getRow(i, sheet);
			for (int j = region.getColumnFrom(); j <= region.getColumnTo(); j++) {
				HSSFCell cell = HSSFCellUtil.getCell(row, (short) j);
				cell.setCellStyle(cs);
			}
		}
	}

}
