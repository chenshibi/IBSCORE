package com.huateng.msgplatform.job;

import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
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
public class NaturePersonSheetJob implements org.quartz.StatefulJob {
	private Logger htlog = Logger.getLogger(NaturePersonSheetJob.class);
	private Map mstatus = null;
	private Map mcity = null;
	private Map mregion = null;
	private Map mdepartMent = null;
	private Map midtype = null;

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		String result = ReportCommonService.JOB_OK;
		Date endTm = null;
		String jobName = null;
		String jobId = null;
		String remark = "";
		Date startTm = null;
		String Query_time = null;
		String Curr_Y_Month = null;
		try {
			jobId = context.getJobDetail().getJobDataMap().getString("jobId");// 定时器主键
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class,
					jobId);
			jobName = jobConfig.getJobName();
			remark = jobConfig.getJobRemark();
			startTm = new Date();
			System.out.println("startTm" + startTm);
			String Curr_Date = new SimpleDateFormat("yyyy-MM-dd").format(
					startTm).toString();
			String Pre_Date = getSpecifiedDayBefore(Curr_Date);
			Query_time = Pre_Date.substring(0, 7);
			Curr_Y_Month = Pre_Date.substring(0, 4) + Pre_Date.substring(5, 7);
			System.out.println("模糊查询的Query_time=" + Query_time + ",生成报表的年和月份="
					+ Curr_Y_Month);
			if (DateUtil.isHoliday()
					&& "Y".equals(jobConfig.getJustWorkdateRun())) {
				remark = "该JOB只在工作日执行";
				return;
			}
			mstatus = DataMapService.getNameByNo(506);
			mcity = DataMapService.getNameByNo(503);
			mregion = DataMapService.getNameByNo(502);
			mdepartMent = DataMapService.getNameByNo(501);
			midtype = DataMapService.getNameByNo(5512);
			Create_Sheet(Query_time, Curr_Y_Month);
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

	private void Create_Sheet(String Query_time, String Curr_Y_Month) {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		try {
			String sql = "select ISNULL(b.input_user,'system') as operator_id," +
					"convert(varchar(100),b.input_time,120)  as create_time,convert(varchar(100)," +
					"a.query_time,120) as time,ltrim(rtrim((a.Individual_id))) as credit_number," +
					"a.name as name,convert(varchar(100),a.return_time,120) as return_time," +
					"rtrim(a.status) as query_status,c.city as city,c.region as region," +
					"b.input_user_ip as create_user_ip,c.DEPARTMENT as Department," +
					"b.consent_file_path as permission_path ,b.individual_id_type as individual_id_type " +
					"from Assure_Ind_App a  left join Assure_Ind_Cust b on b.app_id =a.id " +
					"left join tlr_info c on c.tlrno=b.input_user " +
					"where convert(varchar(100),a.query_time,121) like '%"+ Query_time + "%' " +
					" order by return_time desc";
			Iterator it = rootdao.queryBySQL2(sql.toString());
			htlog.info(sql);
			if (it == null) {
				htlog.info("no message need to be sent.");
				return;
			}
			// 创建工作簿
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
			SXSSFWorkbook workbook = new SXSSFWorkbook(xssfWorkbook,1000);
			long start = System.currentTimeMillis();
			Date dateStart= new Date();
			String fileToBeDownload = null;
			String Download_Path = null;
			htlog.info(Curr_Y_Month);
			
			String filename = "monthly_nature_bureau_inquiry_record_"
					+ Curr_Y_Month + ".xls";
			Download_Path = ReportUtils.getSysParamsValue("PER_DIALY",
					"NA_REPORT");
			htlog.info(Download_Path);
			fileToBeDownload = Download_Path + filename;
			File dir = new File(Download_Path);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File file = new File(fileToBeDownload);
				Sheet sheet = workbook.getSheet("sheet");
				if(sheet==null){
					sheet = workbook.createSheet("sheet");
				}
				Map<Integer,Object> firstTitles=new HashMap<Integer,Object>();
				firstTitles.put(0, "查询操作员ID");
				firstTitles.put(1, "证件号");
				firstTitles.put(2, "证件号类型");   //
				firstTitles.put(3, "姓名");
				firstTitles.put(4, "查询状态");
				firstTitles.put(5, "查询操作员IP");
				firstTitles.put(6, "城市");
				firstTitles.put(7, "区域");
				firstTitles.put(8, "部门");
				firstTitles.put(9, "许可文件路径");
				firstTitles.put(10, "用户录入时间");
				firstTitles.put(11, "人行报告返回时间");
				firstTitles.put(12, "IBS查询时间");
				firstTitles.put(13, "IBS查询 与用户录入时间差");
				firstTitles.put(14, "人行报告返回与用户录入时间差");
				firstTitles.put(15, "人行报告返回与IBS查询时间差");
				genSheetHead(sheet,0,firstTitles);
				int rownum=1;
			while (it.hasNext()) {
				Map map = (Map) it.next();
				String operator_id = transfer_toString(map.get("operator_id"));
				String individual_id_type = checkNull(midtype, transfer_toString(map.get("individual_id_type")));
				/*String query_time = transfer_toString(map.get("time"));
				String return_time = transfer_toString(map.get("return_time"));
				String create_time = transfer_toString(map.get("create_time"));*/
				String query_time = transfer_toString(map.get("time")).substring(0, 22);
				String return_time = transfer_toString(map.get("return_time")).substring(0, 22);
				String create_time = transfer_toString(map.get("create_time")).substring(0, 22);
				String query_create_time = DateUtil.Between(query_time,
						create_time);
				String return_create_time = DateUtil.Between(return_time,
						create_time);
				String return_query_time = DateUtil.Between(return_time,
						query_time);
		
				String credit_number = transfer_toString(map
						.get("credit_number"));
				
				String name = transfer_toString(map.get("name"));
		
			
				String query_status = checkNull(mstatus,
						transfer_toString(map.get("query_status")));
	
				String query_operator_ip = transfer_toString(map
						.get("create_user_ip"));
		
				String city = checkNull(mcity,
						transfer_toString(map.get("city")));
				String region = checkNull(mregion,
						transfer_toString(map.get("region")));
				String Department = checkNull(mdepartMent,
						transfer_toString(map.get("Department")));
				
				String permission_path = transfer_toString(map
						.get("permission_path"));

				Row row = sheet.createRow(rownum);
				int k=-1;
				createCell(row,++k,operator_id);
				createCell(row,++k,credit_number);
				createCell(row,++k,individual_id_type);
				createCell(row,++k,name);
				createCell(row,++k,query_status);
				createCell(row,++k,query_operator_ip);
				createCell(row,++k,city);
				createCell(row,++k,region);
				createCell(row,++k,Department);
				createCell(row,++k,permission_path);
				createCell(row,++k,create_time);
				createCell(row,++k,return_time);
				createCell(row,++k,query_time);
				createCell(row,++k,query_create_time);
				createCell(row,++k,return_create_time);
				createCell(row,++k,return_query_time);
				rownum++;
				}

			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
			Date dateStop= new Date();
			System.out.println("开始时间："+dateStart);
			System.out.println("结束时间："+dateStop);
			System.out.println("用时："+(System.currentTimeMillis()-start));
			out.close();
			htlog.info("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void genSheetHead(Sheet sheet,int rowNum,Map<Integer,Object> values){
		Row row = sheet.createRow(rowNum);
		for(Integer cellNum:values.keySet()){
			Cell cell = row.createCell(cellNum);
			Object value = values.get(cellNum);
			generateValue(value,cell);
		}
	}
	
	public static void createCell(Row row,int cellNum,Object value){
		Cell cell = row.createCell(cellNum);
		generateValue(value,cell);
	}
	
	public static void generateValue(Object value,Cell cell){
		if(value instanceof String){
			cell.setCellValue((String) value);
		}else if(value instanceof Boolean){
			cell.setCellValue((Boolean) value);
		}else if(value instanceof Double){
			cell.setCellValue((Double) value);
		}else if(value instanceof Date){
			cell.setCellValue((Date) value);
		}else if(value instanceof Calendar){
			cell.setCellValue((Calendar) value);
		}else if(value instanceof RichTextString){
			cell.setCellValue((RichTextString) value);
		}
	}

	private String transfer_toString(Object str_son) {
		if (null == str_son)
			return "NULL".toString();
		return str_son.toString();
	}

	public String getSpecifiedDayBefore(String specifiedDay) {
		// SimpleDateFormat simpleDateFormat = new
		// SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);
		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
				.getTime());
		return dayBefore;
	}

	public boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	public String checkNull(Map p, String t) {
		if (t == null) {
			return "";
		} else {
			return (String) p.get(t.trim());
		}
	}
}
