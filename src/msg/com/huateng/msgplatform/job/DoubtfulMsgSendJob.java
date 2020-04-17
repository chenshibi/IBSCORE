package com.huateng.msgplatform.job;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import nochump.util.extend.ZipOutput;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import resource.bean.basic.ReportJobConfig;
import resource.bean.basic.SysParams;
import resource.bean.basic.TlrInfo;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.management.service.SendMailServiceWithFj;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.htaml.reportForm.util.MailConstants;
import com.huateng.msgplatform.service.DataMapService;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.utils.ReportUtils;
import com.training.commons.file.FileUtils;

public class DoubtfulMsgSendJob implements org.quartz.StatefulJob {
	@SuppressWarnings("unused")
	private Logger htlog = Logger.getLogger(MsgPlatFormGetSendDetailsJob.class);
	private Map mcity = null;
	private Map mregion = null;
	private Map mdepartMent = null;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
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
			ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class,
					jobId);
			jobName = jobConfig.getJobName();
			remark = jobConfig.getJobRemark();
			startTm = new Date();

			String filepath = ReportUtils.getSysParamsValue("Doubtful", "xls");
			String date = new SimpleDateFormat("yyyyMMdd").format(new Date())
					.toString();
			// 报表生成路径
			File file = new File(filepath + date + "/xls/");

			String destFileName = null;// 附件名称

			if (DateUtil.isHoliday()
					&& "Y".equals(jobConfig.getJustWorkdateRun())) {
				remark = "该JOB只在工作日执行";
				return;
			}
			mcity = DataMapService.getNameByNo(503);
			mregion = DataMapService.getNameByNo(502);
			mdepartMent = DataMapService.getNameByNo(501);
			String City = null;
			String Region = null;
			String Department = null;

			String hqlm = "select po from SysParams po where 1=1 and po.id.paramgroupId = ? and po.id.paramId = ?";
			ArrayList<String> condList = new ArrayList<String>();
			condList.add("USER");
			condList.add("SUM_QUERY");
			List<SysParams> list = rootdao.queryByCondition(hqlm,
					condList.toArray());

			String hqln = "select po from SysParams po where 1=1 and po.id.paramgroupId = ? and po.id.paramId = ?";
			ArrayList<String> condListn = new ArrayList<String>();
			condListn.add("USER");
			condListn.add("LOCK");
			List<SysParams> listn = rootdao.queryByCondition(hqln,
					condListn.toArray());

			int M = Integer.parseInt(list.get(0).getParamVal());// 同一天做了M次查询
			int N = Integer.parseInt(listn.get(0).getParamVal());// 同一天做了N次查询

			DateFormat fmt = new SimpleDateFormat("yyyyMMdd");// 年月日
			DateFormat fmt1 = new SimpleDateFormat("HHmmss");// 时分秒
			String day = fmt.format(startTm);// 获取当前时间的年月日
			String time = fmt1.format(startTm);// 获取当前时间的时分秒
			String beginTime;
			String endTime;
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			String yesterday = new SimpleDateFormat("yyyyMMdd").format(cal
					.getTime());
			System.out.println(yesterday);

			//String hql = "select count(*) as number,s.create_User from (select *, row_number() over (partition by inq_Cust_Name,inq_Cust_Id,inq_Cust_Id_Type order by create_Time) as group_idx from inq_Cust  where 1=1  ";
			String hql = "select count(*) as numbers,s.create_User from (select i.*, row_number() over (partition by name,id_num,Id_Type order by create_Time) as group_idx from cust_pboc_per_query i  where 1=1  ";
			if ((fmt1.parse(time).getTime()) > (fmt1.parse("080000").getTime())
					&& (fmt1.parse(time).getTime()) < (fmt1.parse("123000")
							.getTime())) {
				System.out.println("查询八点到昨晚十八点半时间段数据");
				hql += " and create_Time >= '" + yesterday + "183000" + "'";
				hql += " and create_Time <= '" + day + "080000" + "'";
				//hql += " and to_char(create_time,'yyyymmdd hh24:mi:ssxff') >= '" + yesterday + " 18:30:00" + ".000000"+"'";
				//hql += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') <= '" + day + " 08:00:00" + ".000000"+"'";
				beginTime = "18:30:00";
				endTime = "08:00:00";
			} else if ((fmt1.parse(time).getTime()) > (fmt1.parse("123000")
					.getTime())
					&& (fmt1.parse(time).getTime()) < (fmt1.parse("183000")
							.getTime())) {
				System.out.println("查询八点到十二点半时间段数据");
				hql += " and create_Time >= '" + day + "080000" + "'";
				hql += " and create_Time <= '" + day + "123000" + "'";
			    //hql += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') >= '" + day + " 08:00:00" + ".000000"+"'";
				//hql += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') <= '" + day + " 12:30:00" + ".000000"+"'";
				beginTime = "08:00:00";
				endTime = "12:30:00";
			} else {
				System.out.println("查询十二点半到十八点半时间段数据");
				hql += " and create_Time >= '" + day + "123000" + "'";
				hql += " and create_Time <= '" + day + "183000" + "'";
				//hql += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') >= '" + day + " 12:30:00" + ".000000"+"'";
				//hql += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') <= '" + day + " 18:30:00" + ".000000"+"'";
				beginTime = "12:30:00";
				endTime = "18:30:00";
			}
			hql += " ) s where group_idx = 1 group by s.create_User ";
			Iterator it = ROOTDAOUtils.getROOTDAO().queryBySQL2(hql.toString());
			String title = "Warning of PBOC Bureau Report Enquiry - Personal";
			String content = "";
			content += "<h4>Dear Admin,</h4>";
			content += "During"
					+ beginTime
					+ "to "
					+ endTime
					+ ", we’ve found below suspicious/abnormal personal credit bureau enquiries.";
			content += "<br/>";
			content += "Please kindly find the detailed information listed.";
			content += "<html>    <table style='border:1px solid black;'>";
			content += " <tr> <th>ID</th><th>Name</th><th>Region</th><th>City</th><th>Dept</th><th>No. Inquiries</th> <th>Date</th></tr>";

			HSSFWorkbook workbook = new HSSFWorkbook();
			// 创建sheet
			HSSFSheet[] sheet = new HSSFSheet[8];
			// 创建行
			HSSFRow row = null;
			// 创建单元格
			HSSFCell cell = null;
			// 创建一个sheet
			sheet[0] = workbook.createSheet("Full User Inq Report");
			// 左对齐 0x31 文本格式
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyle.setDataFormat((short) 0x31);
			// 写入行名称
			String titleSSH = "ID;Name;Region;City;Dept;No. Inquiries;Date";
			String titleList[] = titleSSH.split(";");
			row = sheet[0].createRow(0);
			row.setHeight((short) 300);
			for (int i = 0; i < titleList.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(titleList[i]);
				sheet[0].autoSizeColumn(i, true);
			}
			int j = 1;
			int sum = 0;
			while (it.hasNext()) {
				Map map = (Map) it.next();
				BigDecimal count = (BigDecimal) map.get("NUMBERS");
				int count1=count.intValue();
				String name = (String) map.get("CREATE_USER");
				StringBuffer tlrhql = new StringBuffer(
						"select po from TlrInfo po where tlrno='" + name + "'");
				List<TlrInfo> listTlr = new ArrayList<TlrInfo>();
				listTlr = ROOTDAOUtils.getROOTDAO().queryByCondition(
						tlrhql.toString());
				if (listTlr != null && listTlr.size() > 0) {
					City = checkNull(mcity, listTlr.get(0).getCity());
					Region = checkNull(mregion, listTlr.get(0).getRegion());
					Department = checkNull(mdepartMent, listTlr.get(0)
							.getDepartment());
					row = sheet[0].createRow(j);
					row.setHeight((short) 300);
					// login ID
					cell = row.createCell(0);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(listTlr.get(0).getTlrno());
					// User name
					cell = row.createCell(1);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(listTlr.get(0).getTlrName());
					// Region
					cell = row.createCell(2);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(Region);
					// City
					cell = row.createCell(3);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(City);
					// Role
					cell = row.createCell(4);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(Department);
					// department
					cell = row.createCell(5);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(count1);

					cell = row.createCell(6);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(day);
					j++;
				}

				if (count1 > M) {
					sum++;    
					content += " <tr> <td>" + (listTlr.size()==0?"system":listTlr.get(0).getTlrno())
							+ "</td><td>" + (listTlr.size()==0?"system":listTlr.get(0).getTlrName())
							+ "</td><td>" + Region + "</td><td>" + City
							+ "</td><td>" + Department + "</td><td>" + count
							+ "</td> <td>" + day + "</td></tr>";
				}
			}
			sheet[0].setColumnWidth(0, 250 * 20);// login ID
			sheet[0].setColumnWidth(1, 250 * 20);// User name
			sheet[0].setColumnWidth(2, 250 * 20);// City
			sheet[0].setColumnWidth(3, 250 * 20);// Region
			sheet[0].setColumnWidth(4, 250 * 25);// Role
			sheet[0].setColumnWidth(5, 250 * 20);// department
			sheet[0].setColumnWidth(6, 250 * 20);//

			destFileName = filepath
					+ date
					+ "/xls/"
					+ "ind_full_userenq_sum_"
					+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
							.toString() + ".xls";

			String[] destFileNameArr = { destFileName };
			if (!file.exists()) {
				file.mkdirs();
			}
			FileOutputStream output = new FileOutputStream(destFileName);
			workbook.write(output);
			output.flush();
			output.close();
			workbook.close();
			content += " </table>  </html>";
			if (sum > 0) {
				SendMailServiceWithFj.getMailBeanAndSendMail(
						MailConstants.SEND_DOUBTFMSG, content, title,
						destFileNameArr);
			}else{
				content="";
				content += "<h4>Dear All,</h4>";
				content += "During "
						+ beginTime
						+ " to "
						+ endTime
						+ ", we’ve found nil suspicious/abnormal personal credit bureau enquiries.";
				content += "<br/>";
//				content += "Please kindly find the detailed information listed.";
				content += "<html>  ";
				
				content += " </html>";
				SendMailServiceWithFj.getMailBeanAndSendMail(
						MailConstants.SEND_DOUBTFMSG, content, title,
						destFileNameArr);
			}

			// 个人征信报告查询监控（单笔=1）
			String hql1 = "select count(*) as numbers,s.create_User from (select i.*, row_number() over (partition by name,id_num,Id_Type order by create_Time) as group_idx from cust_pboc_per_query i  where 1=1  and i.rsv5 is null ";
			//String hql1 = "select count(*) as number,s.create_User from (select *, row_number() over (partition by inq_Cust_Name,inq_Cust_Id,inq_Cust_Id_Type order by create_Time) as group_idx from inq_Cust  where 1=1 and inq_type=1 ";
			if ((fmt1.parse(time).getTime()) > (fmt1.parse("080000")
					.getTime())
					&& (fmt1.parse(time).getTime()) < (fmt1.parse("123000")
							.getTime())) {//
				System.out.println("查询八点到昨晚十八点半时间段数据");
				hql1 += " and create_Time >= '" + yesterday + "183000" + "'";
				hql1 += " and create_Time <= '" + day + "080000" + "'";
				//hql1 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') >= '" + yesterday + " 18:30:00" + ".000000"+"'";
				//hql1 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') <= '" + day + " 08:00:00" + ".000000"+"'";
				beginTime = "18:30:00";
				endTime = "080000";
			} else if ((fmt1.parse(time).getTime()) > (fmt1.parse("123000")
					.getTime())
					&& (fmt1.parse(time).getTime()) < (fmt1.parse("183000")
							.getTime())) {
				System.out.println("查询八点到十二点半时间段数据");
				hql1 += " and create_Time >= '" + day + "080000" + "'";
				hql1 += " and create_Time <= '" + day + "123000" + "'";
				//hql1 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') >= '" + day + " 08:00:00" + ".000000"+"'";
				//hql1 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') <= '" + day + " 12:30:00" + ".000000"+"'";
				beginTime = "08:00:00";
				endTime = "12:30:00";
			} else {
				System.out.println("查询十二点半到十八点半时间段数据");
				hql1 += " and create_Time >= '" + day + "123000" + "'";
				hql1 += " and create_Time <= '" + day + "183000" + "'";
				//hql1 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') >= '" + day + " 12:30:00" + ".000000"+"'";
				//hql1 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') <= '" + day + " 18:30:00" + ".000000"+"'";
				beginTime = "12:30:00";
				endTime = "18:30:00";
			}
			hql1 += " ) s where s.group_idx = 1 group by s.create_User ";
			Iterator it1 = ROOTDAOUtils.getROOTDAO().queryBySQL2(
					hql1.toString());
			String title1 = "Warning of PBOC Bureau Report Inquiry";
			String content1 = "";
			content1 += "<h4>Dear All,</h4>";
			content1 += "During "
					+ beginTime
					+ " to "
					+ endTime
					+ ", we’ve found below ** suspicious/abnormal individual credit bureau enquiries.";
			content1 += "<br/>";
			content1 += "Please kindly find the detailed information listed.";
			content1 += "<html>    <table style='border:1px solid black;'>";
			content1 += " <tr> <th>ID</th><th>Name</th><th>Region</th><th>City</th><th>Dept</th><th>No. Inquiries</th><th>Date</th> </tr>";
			HSSFWorkbook workbook1 = new HSSFWorkbook();
			// 创建sheet
			HSSFSheet[] sheet1 = new HSSFSheet[8];
			// 创建行
			HSSFRow row1 = null;
			// 创建单元格
			HSSFCell cell1 = null;
			// 创建一个sheet
			sheet1[0] = workbook1.createSheet("Doubtful Inq Report");
			// 左对齐 0x31 文本格式
			HSSFCellStyle cellStyle1 = workbook1.createCellStyle();
			cellStyle1.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyle1.setDataFormat((short) 0x31);
			// 写入行名称
			String titleSSH1 = "ID;Name;Region;City;Dept;No. Inquiries;Date";
			String titleList1[] = titleSSH1.split(";");
			row1 = sheet1[0].createRow(0);
			row1.setHeight((short) 300);
			for (int i = 0; i < titleList1.length; i++) {
				cell1 = row1.createCell(i);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(titleList1[i]);
				sheet1[0].autoSizeColumn(i, true);
			}

			HSSFWorkbook workbook11 = new HSSFWorkbook();
			// 创建sheet
			HSSFSheet[] sheet11 = new HSSFSheet[8];
			// 创建行
			HSSFRow row11 = null;
			// 创建单元格
			HSSFCell cell11 = null;
			// 创建一个sheet
			sheet11[0] = workbook11.createSheet("Doubtful Inq Report");
			// 左对齐 0x31 文本格式
			HSSFCellStyle cellStyle11 = workbook11.createCellStyle();
			cellStyle11.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyle11.setDataFormat((short) 0x31);
			// 写入行名称
			String titleSSH11 = "ID;Name;Region;City;Dept;No. Inquiries;Date";
			String titleList11[] = titleSSH11.split(";");
			row11 = sheet11[0].createRow(0);
			row11.setHeight((short) 300);
			for (int i = 0; i < titleList11.length; i++) {
				cell11 = row11.createCell(i);
				cell11.setCellStyle(cellStyle11);
				cell11.setCellValue(titleList11[i]);
				sheet11[0].autoSizeColumn(i, true);
			}
			int sum1 = 0;
			int j1 = 1;
			int j11=1;
			while (it1.hasNext()) {
				Map map = (Map) it1.next();
				BigDecimal count = (BigDecimal) map.get("NUMBERS");
				int count1=count.intValue();
				String name = (String) map.get("CREATE_USER");
				StringBuffer tlrhql = new StringBuffer(
						"select po from TlrInfo po where tlrno='" + name + "'");
				List<TlrInfo> listTlr = new ArrayList<TlrInfo>();
				listTlr = ROOTDAOUtils.getROOTDAO().queryByCondition(
						tlrhql.toString());
				if (listTlr != null && listTlr.size() > 0) {
					City = checkNull(mcity, listTlr.get(0).getCity());
					Region = checkNull(mregion, listTlr.get(0).getRegion());
					Department = checkNull(mdepartMent, listTlr.get(0)
							.getDepartment());
				}
				if (count1 > N) {
					sum1++;
					content1 += " <tr> <td>" + (listTlr.size()==0?"system":listTlr.get(0).getTlrno())
							+ "</td><td>" + (listTlr.size()==0?"system":listTlr.get(0).getTlrName())
							+ "</td><td>" + Region + "</td><td>" + City
							+ "</td><td>" + Department + "</td><td>" + count1
							+ "</td> <td>" + day + "</td></tr>";
					if(listTlr.size()>0){
					 TlrInfo tlrinfo = listTlr.get(0);
					 tlrinfo.setStatus("4");
					 ROOTDAOUtils.getROOTDAO().update(tlrinfo);
					}
					row11 = sheet11[0].createRow(j11);
					row11.setHeight((short) 300);
					// login ID
					cell11 = row11.createCell(0);
					cell11.setCellStyle(cellStyle11);
					cell11.setCellValue(listTlr.size()==0?"system":listTlr.get(0).getTlrno());
					// User name
					cell11 = row11.createCell(1);
					cell11.setCellStyle(cellStyle11);
					cell11.setCellValue(listTlr.size()==0?"system":listTlr.get(0).getTlrName());
					// Region
					cell11 = row11.createCell(2);
					cell11.setCellStyle(cellStyle11);
					cell11.setCellValue(Region);
					// City
					cell11 = row11.createCell(3);
					cell11.setCellStyle(cellStyle11);
					cell11.setCellValue(City);
					// Role
					cell11 = row11.createCell(4);
					cell11.setCellStyle(cellStyle11);
					cell11.setCellValue(Department);
					// department
					cell11 = row11.createCell(5);
					cell11.setCellStyle(cellStyle11);
					cell11.setCellValue(count1);
					j11++;
				}
				row1 = sheet1[0].createRow(j1);
				row1.setHeight((short) 300);
				// login ID
				cell1 = row1.createCell(0);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(listTlr.size()==0?"system":listTlr.get(0).getTlrno());
				// User name
				cell1 = row1.createCell(1);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(listTlr.size()==0?"system":listTlr.get(0).getTlrName());
				// Region
				cell1 = row1.createCell(2);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(Region);
				// City
				cell1 = row1.createCell(3);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(City);
				// Role
				cell1 = row1.createCell(4);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(Department);
				// department
				cell1 = row1.createCell(5);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(count1);

				cell1 = row1.createCell(6);
				cell1.setCellStyle(cellStyle1);
				cell1.setCellValue(day);
				j1++;

			}
			content1 += " </table>  </html>";
			sheet1[0].setColumnWidth(0, 250 * 20);// login ID
			sheet1[0].setColumnWidth(1, 250 * 20);// User name
			sheet1[0].setColumnWidth(2, 250 * 20);// City
			sheet1[0].setColumnWidth(3, 250 * 20);// Region
			sheet1[0].setColumnWidth(4, 250 * 25);// Role
			sheet1[0].setColumnWidth(5, 250 * 20);// department
			sheet1[0].setColumnWidth(6, 250 * 20);// 
			// 全量表
			sheet11[0].setColumnWidth(0, 250 * 20);// login ID
			sheet11[0].setColumnWidth(1, 250 * 20);// User name
			sheet11[0].setColumnWidth(2, 250 * 20);// City
			sheet11[0].setColumnWidth(3, 250 * 20);// Region
			sheet11[0].setColumnWidth(4, 250 * 25);// Role
			sheet11[0].setColumnWidth(5, 250 * 20);// department
			sheet11[0].setColumnWidth(6, 250 * 20);//
			// 全量
			destFileName = filepath
					+ date
					+ "/xls/"
					+ "Doubtful_inq1_fullUserInformation"
					+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
							.toString() + ".xls";
			// 可疑
			String destFileName1 = filepath
					+ date
					+ "/xls/"
					+ "Doubtful_inq_"
					+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
							.toString() + ".xls";
			File file1 = new File(filepath + date + "/xls/");

			String[] destFileNameArr1 = { destFileName };

			FileOutputStream output1 = new FileOutputStream(destFileName);
			workbook1.write(output1);
			output1.flush();
			output1.close();
			workbook1.close();
			if (!file1.exists()) {
				file1.mkdirs();
			}
			FileOutputStream output11 = new FileOutputStream(destFileName1);
			workbook11.write(output11);
			output11.flush();
			output11.close();
//			if (sum1 > 0) {
//				SendMailServiceWithFj.getMailBeanAndSendMail(
//						MailConstants.SEND_DOUBTFMSG, content1, title1,
//						destFileNameArr1);
//			}else{
//				content1="";
//				SendMailServiceWithFj.getMailBeanAndSendMail(
//						MailConstants.SEND_DOUBTFMSG, content1, title1,
//						destFileNameArr1);
//			}
			
			workbook11.close();

			/**
			 * 企業 单笔　和ｂａｔｃｈ
			 */
			String hql2 = "select count(*) as numbers,s.create_User from (select i.*, row_number() over (partition by ent_cert_num order by create_Time) as group_idx from cust_pboc_ent_query i  where 1=1  ";
			//String hql2 = "select count(*) as number,s.create_User from (select *, row_number() over (partition by corp_cust_loancard order by create_Time) as group_idx from corp_cust  where 1=1  ";
			if ((fmt1.parse(time).getTime()) > (fmt1.parse("080000")
					.getTime())
					&& (fmt1.parse(time).getTime()) < (fmt1.parse("123000")
							.getTime())) {//
				System.out.println("查询八点到昨晚十八点半时间段数据");
				hql2 += " and create_Time >= '" + yesterday + "183000" + "'";
				hql2 += " and create_Time <= '" + day + "080000" + "'";
				//hql2 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') >= '" + yesterday + " 18:30:00" + ".000000"+"'";
				//hql2 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') <= '" + day + " 08:00:00" + ".000000"+"'";
				beginTime = "18:30:00";
				endTime = "08:00:00";
			} else if ((fmt1.parse(time).getTime()) > (fmt1.parse("123000")
					.getTime())
					&& (fmt1.parse(time).getTime()) < (fmt1.parse("183000")
							.getTime())) {
				System.out.println("查询八点到十二点半时间段数据");
				hql2 += " and create_Time >= '" + day + "080000" + "'";
				hql2 += " and create_Time <= '" + day + "123000" + "'";
				//hql2 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') >= '" + day + " 08:00:00" + ".000000"+"'";
				//hql2 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') <= '" + day + " 12:30:00" + ".000000"+"'";
				beginTime = "08:00:00";
				endTime = "12:30:00";
			} else {
				System.out.println("查询十二点半到十八点半时间段数据");
				hql2 += " and create_Time >= '" + day + "123000" + "'";
				hql2 += " and create_Time <= '" + day + "183000" + "'";
				//hql2 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') >= '" + day + " 12:30:00" + ".000000"+"'";
				//hql2 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') <= '" + day + " 18:30:00" + ".000000"+"'";
				beginTime = "12:30:00";
				endTime = "18:30:00";
			}
			hql2 += " ) s where s.group_idx = 1 group by s.create_User ";
			Iterator it2 = ROOTDAOUtils.getROOTDAO().queryBySQL2(
					hql2.toString());
			String title2 = "Warning of PBOC Bureau Report Enquiry - Corp";
			String content2 = "";
			content2 += "<h4>Dear All,</h4>";
			content2 += "During "
					+ beginTime
					+ " to "
					+ endTime
					+ ", we’ve found below suspicious/abnormal corp.";
			content2 += "<br/>";
			content2 += "Please kindly find the detailed information listed.";
			content2 += "<html>    <table style='border:1px solid black;'>";
			content2 += " <tr> <th>ID</th><th>Name</th><th>Region</th><th>City</th><th>Dept</th><th>No. Inquiries</th><th>Date</th></tr>";

			HSSFWorkbook workbook111 = new HSSFWorkbook();
			// 创建sheet
			HSSFSheet[] sheet111 = new HSSFSheet[8];
			// 创建行
			HSSFRow row111 = null;
			// 创建单元格
			HSSFCell cell111 = null;
			// 创建一个sheet
			sheet111[0] = workbook111.createSheet("Doubtful Inq Report");
			// 左对齐 0x31 文本格式
			HSSFCellStyle cellStyle111 = workbook111.createCellStyle();
			cellStyle111.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyle111.setDataFormat((short) 0x31);
			// 写入行名称
			String titleSSH111 = "ID;Name;Region;City;Dept;No. Inquiries;Date";
			String titleList111[] = titleSSH111.split(";");
			row111 = sheet111[0].createRow(0);
			row111.setHeight((short) 300);
			for (int i = 0; i < titleList111.length; i++) {
				cell111 = row111.createCell(i);
				cell111.setCellStyle(cellStyle111);
				cell111.setCellValue(titleList111[i]);
				sheet111[0].autoSizeColumn(i, true);
			}
           
			int sum2 = 0;
			int j111=1;
			while (it2.hasNext()) {
				Map map = (Map) it2.next();
				BigDecimal count = (BigDecimal) map.get("NUMBERS");
				int count1=count.intValue();
				String name = (String) map.get("CREATE_USER");
				StringBuffer tlrhql = new StringBuffer(
						"select po from TlrInfo po where tlrno='" + name + "'");
				List<TlrInfo> listTlr = new ArrayList<TlrInfo>();
				listTlr = ROOTDAOUtils.getROOTDAO().queryByCondition(
						tlrhql.toString());
				if (listTlr != null && listTlr.size() > 0) {
					City = checkNull(mcity, listTlr.get(0).getCity());
					Region = checkNull(mregion, listTlr.get(0).getRegion());
					Department = checkNull(mdepartMent, listTlr.get(0)
							.getDepartment());
					row111 = sheet111[0].createRow(j111);
					row111.setHeight((short) 300);
					// login ID
					cell111 = row111.createCell(0);
					cell111.setCellStyle(cellStyle111);
					cell111.setCellValue(listTlr.get(0).getTlrno());
					// User name
					cell111 = row111.createCell(1);
					cell111.setCellStyle(cellStyle111);
					cell111.setCellValue(listTlr.get(0).getTlrName());
					// Region
					cell111 = row111.createCell(2);
					cell111.setCellStyle(cellStyle111);
					cell111.setCellValue(Region);
					// City
					cell111 = row111.createCell(3);
					cell111.setCellStyle(cellStyle111);
					cell111.setCellValue(City);
					// Role
					cell111 = row111.createCell(4);
					cell111.setCellStyle(cellStyle111);
					cell111.setCellValue(Department);
					// department
					cell111 = row111.createCell(5);
					cell111.setCellStyle(cellStyle111);
					cell111.setCellValue(count1);

					cell111 = row111.createCell(6);
					cell111.setCellStyle(cellStyle111);
					cell111.setCellValue(day);
					j111++;
				}
				if (count1 > M) {
					sum2++;
					content2 += " <tr> <td>" + (listTlr.size()==0?"system":listTlr.get(0).getTlrno())
							+ "</td><td>" + (listTlr.size()==0?"system":listTlr.get(0).getTlrName())
							+ "</td><td>" + Region + "</td><td>" + City
							+ "</td><td>" + Department + "</td><td>" + count1
							+ "</td> <td>" + day + "</td></tr>";
				}
			}
			sheet111[0].setColumnWidth(0, 250 * 20);// login ID
			sheet111[0].setColumnWidth(1, 250 * 20);// User name
			sheet111[0].setColumnWidth(2, 250 * 20);// City
			sheet111[0].setColumnWidth(3, 250 * 20);// Region
			sheet111[0].setColumnWidth(4, 250 * 25);// Role
			sheet111[0].setColumnWidth(5, 250 * 20);// department
			sheet111[0].setColumnWidth(6, 250 * 20);//
			destFileName = filepath
					+ date
					+ "/xls/"
					+ "corp_full_userenq_sum_"
					+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
							.toString() + ".xls";
			String[] destFileNameArr11 = { destFileName };
			if (!file.exists()) {
				file.mkdirs();
			}
			FileOutputStream output111 = new FileOutputStream(destFileName);
			workbook111.write(output111);
			output111.flush();
			output111.close();
			workbook111.close();
			content2 += " </table>  </html>";
			if (sum2 > 0) {
				SendMailServiceWithFj.getMailBeanAndSendMail(
						MailConstants.SEND_DOUBTFMSG, content2, title2,
						destFileNameArr11);
			}else{
				content2="";
				content2 += "<h4>Dear All,</h4>";
				content2 += "During "
						+ beginTime
						+ " to "
						+ endTime
						+ ", we’ve found nil suspicious/abnormal corp.";
				content2 += "<br/>";
//				content2 += "Please kindly find the detailed information listed.";
				content2 += "<html>";
				content2 += "</html>";
				SendMailServiceWithFj.getMailBeanAndSendMail(
						MailConstants.SEND_DOUBTFMSG, content2, title2,
						destFileNameArr11);
			}
			// 企业征信报告查询监控（单笔）
			//String hql3 = "select count(*) as number,s.create_User from (select *, row_number() over (partition by corp_cust_loancard order by create_Time) as group_idx from corp_cust  where 1=1 and inq_type=1 ";
			String hql3 = "select count(*) as numbers,s.create_User from (select i.*, row_number() over (partition by ent_cert_num order by create_Time) as group_idx from cust_pboc_ent_query i  where 1=1 and i.rsv5 is null  ";
			if ((fmt1.parse(time).getTime()) > (fmt1.parse("080000")
					.getTime())
					&& (fmt1.parse(time).getTime()) < (fmt1.parse("123000")
							.getTime())) {//
				System.out.println("查询八点到昨晚十八点半时间段数据");
				hql3 += " and create_Time >= '" + yesterday + "183000" + "'";
				hql3 += " and create_Time <= '" + day + "080000" + "'";
				//hql3 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') >= '" + yesterday + " 18:30:00" + ".000000"+"'";
				//hql3 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') <= '" + day + " 08:00:00" + ".000000"+"'";
				beginTime = "18:30:00";
				endTime = "08:00:00";
			} else if ((fmt1.parse(time).getTime()) > (fmt1.parse("123000")
					.getTime())
					&& (fmt1.parse(time).getTime()) < (fmt1.parse("183000")
							.getTime())) {
				System.out.println("查询八点到十二点半时间段数据");
				hql3 += " and create_Time >= '" + day + "080000" + "'";
				hql3 += " and create_Time <= '" + day + "123000" + "'";
				//hql3 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') >= '" + day + " 08:00:00" + ".000000"+"'";
				//hql3 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') <= '" + day + " 12:30:00" + ".000000"+"'";
				beginTime = "08:00:00";
				endTime = "12:30:00";
			} else {
				System.out.println("查询十二点半到十八点半时间段数据");
				hql3 += " and create_Time >= '" + day + "123000" + "'";
				hql3 += " and create_Time <= '" + day + "183000" + "'";
				//hql3 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') >= '" + day + " 12:30:00" + ".000000"+"'";
				//hql3 += " and to_char(create_time,'yyyy-mm-dd hh24:mi:ssxff') <= '" + day + " 18:30:00" + ".000000"+"'";
				beginTime = "12:30:00";
				endTime = "18:30:00";
			}
			hql3 += " ) s where s.group_idx = 1 group by s.create_User ";
			Iterator it3 = ROOTDAOUtils.getROOTDAO().queryBySQL2(
					hql3.toString());
			String title3 = "Warning of PBOC Bureau Report Inquiry";
			String content3 = "";
			content3 += "<h4>Dear Admin,</h4>";
			content3 += "During"
					+ beginTime
					+ "to "
					+ endTime
					+ ", we’ve found below ** suspicious/abnormal corporate credit bureau enquiries.";
			content3 += "<br/>";
			content3 += "Please kindly find the detailed information listed.";
			content3 += "<html>    <table style='border:1px solid black;'>";
			content3 += " <tr> <th>ID</th><th>Name</th><th>Region</th><th>City</th><th>Dept</th><th>No. Inquiries</th><th>Date</th></tr>";
			HSSFWorkbook workbook2 = new HSSFWorkbook();
			// 创建sheet
			HSSFSheet[] sheet2 = new HSSFSheet[8];
			// 创建行
			HSSFRow row2 = null;
			// 创建单元格
			HSSFCell cell2 = null;
			// 创建一个sheet
			sheet2[0] = workbook2.createSheet("Doubtful Corp Report");
			// 左对齐 0x31 文本格式
			HSSFCellStyle cellStyle2 = workbook2.createCellStyle();
			cellStyle2.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyle2.setDataFormat((short) 0x31);
			// 写入行名称
			String titleSSH2 = "ID;Name;Region;City;Dept;No. Inquiries;Date";
			String titleList2[] = titleSSH2.split(";");
			row2 = sheet2[0].createRow(0);
			row2.setHeight((short) 300);
			for (int i = 0; i < titleList2.length; i++) {
				cell2 = row2.createCell(i);
				cell2.setCellStyle(cellStyle2);
				cell2.setCellValue(titleList2[i]);
				sheet2[0].autoSizeColumn(i, true);
			}
			HSSFWorkbook workbook21 = new HSSFWorkbook();
			// 创建sheet
			HSSFSheet[] sheet21 = new HSSFSheet[8];
			// 创建行
			HSSFRow row21 = null;
			// 创建单元格
			HSSFCell cell21 = null;
			// 创建一个sheet
			sheet21[0] = workbook21.createSheet("Doubtful Corp Report");
			// 左对齐 0x31 文本格式
			HSSFCellStyle cellStyle21 = workbook21.createCellStyle();
			cellStyle21.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyle21.setDataFormat((short) 0x31);
			// 写入行名称
			String titleSSH21 = "ID;Name;Region;City;Dept;No. Inquiries;Date";
			String titleList21[] = titleSSH21.split(";");
			row21 = sheet21[0].createRow(0);
			row21.setHeight((short) 300);
			for (int i = 0; i < titleList21.length; i++) {
				cell21 = row21.createCell(i);
				cell21.setCellStyle(cellStyle21);
				cell21.setCellValue(titleList21[i]);
				sheet21[0].autoSizeColumn(i, true);
			}
			int sum3 = 0;
			int j2 = 1;
			int j21=1;
			while (it3.hasNext()) {
				Map map = (Map) it3.next();
				BigDecimal count = (BigDecimal) map.get("NUMBERS");
				int count1=count.intValue();
				String name = (String) map.get("CREATE_USER");
				StringBuffer tlrhql = new StringBuffer(
						"select po from TlrInfo po where tlrno='" + name + "'");
				List<TlrInfo> listTlr = new ArrayList<TlrInfo>();
				listTlr = ROOTDAOUtils.getROOTDAO().queryByCondition(
						tlrhql.toString());
				if (listTlr != null && listTlr.size() > 0) {
					City = checkNull(mcity, listTlr.get(0).getCity());
					Region = checkNull(mregion, listTlr.get(0).getRegion());
					Department = checkNull(mdepartMent, listTlr.get(0)
							.getDepartment());
				}
				if (count1 > N) {
					sum3++;
					content3 += " <tr> <td>" + (listTlr.size()==0?"system":listTlr.get(0).getTlrno())
							+ "</td><td>" + (listTlr.size()==0?"system":listTlr.get(0).getTlrName())
							+ "</td><td>" + Region + "</td><td>" + City
							+ "</td><td>" + Department + "</td><td>" + count1
							+ "</td><td>" + day + "</td> </tr>";
					if(listTlr.size()>0){
					 TlrInfo tlrinfo = listTlr.get(0);
					 tlrinfo.setStatus("4");
					 ROOTDAOUtils.getROOTDAO().update(tlrinfo);
					}
					row21 = sheet21[0].createRow(j21);
					row21.setHeight((short) 300);
					// login ID
					cell21 = row21.createCell(0);
					cell21.setCellStyle(cellStyle21);
					cell21.setCellValue(listTlr.size()==0?"system":listTlr.get(0).getTlrno());
					// User name
					cell21 = row21.createCell(1);
					cell21.setCellStyle(cellStyle21);
					cell21.setCellValue(listTlr.size()==0?"system":listTlr.get(0).getTlrName());
					// Region
					cell21 = row21.createCell(2);
					cell21.setCellStyle(cellStyle21);
					cell21.setCellValue(Region);
					// City
					cell21 = row21.createCell(3);
					cell21.setCellStyle(cellStyle21);
					cell21.setCellValue(City);
					// 
					cell21 = row21.createCell(4);
					cell21.setCellStyle(cellStyle21);
					cell21.setCellValue(Department);
					// 
					cell21 = row21.createCell(5);
					cell21.setCellStyle(cellStyle21);
					cell21.setCellValue(count1);
					j21++;
				}

				row2 = sheet2[0].createRow(j2);
				row2.setHeight((short) 300);
				// login ID
				cell2 = row2.createCell(0);
				cell2.setCellStyle(cellStyle2);
				cell2.setCellValue(listTlr.size()==0?"system":listTlr.get(0).getTlrno());
				// User name
				cell2 = row2.createCell(1);
				cell2.setCellStyle(cellStyle2);
				cell2.setCellValue(listTlr.size()==0?"system":listTlr.get(0).getTlrName());
				// Region
				cell2 = row2.createCell(2);
				cell2.setCellStyle(cellStyle2);
				cell2.setCellValue(Region);
				// City
				cell2 = row2.createCell(3);
				cell2.setCellStyle(cellStyle2);
				cell2.setCellValue(City);
				// Role
				cell2 = row2.createCell(4);
				cell2.setCellStyle(cellStyle2);
				cell2.setCellValue(Department);
				// department
				cell2 = row2.createCell(5);
				cell2.setCellStyle(cellStyle2);
				cell2.setCellValue(count1);

				cell2 = row2.createCell(6);
				cell2.setCellStyle(cellStyle2);
				cell2.setCellValue(day);
				j2++;

			}
			sheet21[0].setColumnWidth(0, 250 * 20);// login ID
			sheet21[0].setColumnWidth(1, 250 * 20);// User name
			sheet21[0].setColumnWidth(2, 250 * 20);// City
			sheet21[0].setColumnWidth(3, 250 * 20);// Region
			sheet21[0].setColumnWidth(4, 250 * 25);// Role
			sheet21[0].setColumnWidth(5, 250 * 20);// department

			sheet2[0].setColumnWidth(0, 250 * 20);// login ID
			sheet2[0].setColumnWidth(1, 250 * 20);// User name
			sheet2[0].setColumnWidth(2, 250 * 20);// City
			sheet2[0].setColumnWidth(3, 250 * 20);// Region
			sheet2[0].setColumnWidth(4, 250 * 25);// Role
			sheet2[0].setColumnWidth(5, 250 * 20);// department
			sheet2[0].setColumnWidth(6, 250 * 20);//
			// 全量
			destFileName = filepath
					+ date
					+ "/xls/"
					+ "Doubtful_corp1_fullUserInformation"
					+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
							.toString() + ".xls";
			// 可疑
			String destFileName2 = filepath
					+ date
					+ "/xls/"
					+ "Doubtful_corp_"
					+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
							.toString() + ".xls";
			String[] destFileNameArr111 = { destFileName };

			FileOutputStream output2 = new FileOutputStream(destFileName);
			workbook2.write(output2);
			output2.flush();
			output2.close();
			workbook2.close();

			File file2 = new File(filepath + date + "/xls/");
			content3 += " </table>  </html>";
			if (!file2.exists()) {
				file2.mkdirs();
			}
			FileOutputStream output21 = new FileOutputStream(destFileName2);
			workbook21.write(output21);
			output21.flush();
			output21.close();
//			if (sum3 > 0) {
//				SendMailServiceWithFj.getMailBeanAndSendMail(
//						MailConstants.SEND_DOUBTFMSG, content3, title3,
//						destFileNameArr111);
//			}else{
//				content2="";
//				SendMailServiceWithFj.getMailBeanAndSendMail(
//						MailConstants.SEND_DOUBTFMSG, content2, title2,
//						destFileNameArr11);
//			}
			workbook21.close();

			String putPath = filepath + date + "/" + "zip/";
			if (!new File(putPath).exists()) {
				new File(putPath).mkdirs();
			}
			final String zipdir = filepath + date + "/" + "xls/";
			final String zipfile = filepath + date + "/" + "zip/" + date
					+ ".zip";
			final String password = "";
			System.out.println("=======开始打包======");
			File filez = new File(zipdir);
			if (null != filez.listFiles()) {
				byte[] zipByte = ZipOutput.getEncryptZipByte(filez.listFiles(),
						password);
				FileUtils.writeByteFile(zipByte, new File(zipfile));
			}
			System.out.println("=======打包完成====");

		} catch (Exception e) {
			htlog.error("============定时任务出错============", e);
			e.printStackTrace();
			result = ReportCommonService.JOB_FAILED;
			remark = e.getMessage();
		} finally {
			endTm = new Date();
			ReportCommonService.getInstance().saveJobLog(startTm, endTm, jobId,
					result, jobName, remark);
		}
	}

	public String checkNull(Map p, String t) {
		if (t == null) {
			return "";
		} else {
			return (String) p.get(t.trim());
		}
	}

}
