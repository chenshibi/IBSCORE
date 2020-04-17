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

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.msgplatform.service.DataMapService;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.utils.ReportUtils;

import resource.bean.basic.ReportJobConfig;

@SuppressWarnings("rawtypes")
public class MsgPlatFormProduceSheetJob implements org.quartz.StatefulJob {
	private Logger htlog = Logger.getLogger(MsgPlatFormProduceSheetJob.class);
	private Map mstatus = null;
	private Map mcity = null;
	private Map mregion = null;
	private Map mdepartMent = null;
	private Map mreason = null;
	private Map midType = null;

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
			Query_time = Pre_Date.substring(0, 4) + Pre_Date.substring(5, 7);
			Curr_Y_Month = Pre_Date.substring(0, 4) + Pre_Date.substring(5, 7);
			System.out.println("模糊查询的Query_time=" + Query_time + ",生成报表的年和月份="
					+ Curr_Y_Month);
			if (DateUtil.isHoliday()
					&& "Y".equals(jobConfig.getJustWorkdateRun())) {
				remark = "该JOB只在工作日执行";
				return;
			}
			mstatus = DataMapService.getNameByNo(901);
			mcity = DataMapService.getNameByNo(503);
			mregion = DataMapService.getNameByNo(502);
			mdepartMent = DataMapService.getNameByNo(501);
			mreason = DataMapService.getNameByNo(504);
			midType = DataMapService.getNameByNo(6002);//个人证件类型
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
			/*String sql = "select ISNULL(b.create_user,'system') as operator_id,convert(varchar(100),b.create_time,120)  as create_time,convert(varchar(100),a.rpt_id,120) as rpt_id,"
					+ "convert(varchar(100),a.query_time,120) as time,ltrim(rtrim((a.Individual_id))) as credit_number,a.id_type as credit_type,a.name as name,"
					+ "a.query_reason as query_reson,convert(varchar(100),a.return_time,120) as return_time,rtrim(a.status) as query_status,"
					+ "c.city as city,c.region as region,b.create_user_ip as create_user_ip,c.DEPARTMENT as Department,b.consent_file_path as permission_path "
					+ "from ind_app a  left join inq_cust b on b.inq_cust_appid =a.id "
					+ "left join tlr_info c on c.tlrno=b.create_user "
					+ "where convert(varchar(100),a.query_time,121) like '%"
					+ Query_time + "%' order by return_time desc";*/
			//modify by chensibi start
			StringBuffer sql=new StringBuffer();
			sql.append(" select NVL(a.create_user, 'system') as operator_id,NVL(a.create_time, '') as create_time,a.resp_id as rpt_id,");
			sql.append("NVL(a.send_time, '') as time,trim(a.id_num) as credit_number,a.id_type as credit_type,a.name as name,");
			sql.append("a.query_reason as query_reson,NVL(a.resp_time,'') as return_time,trim(a.status) as query_status,");
			sql.append("c.city as city,c.region as region,a.rsv7 as create_user_ip,c.DEPARTMENT as Department,b.CUSTOMER_CON_UP as permission_path");
			sql.append(" from cust_pboc_per_query a");
			sql.append(" left join tlr_info c on c.tlrno = a.create_user ");
			sql.append(" left join ind_permit b on a.ID_NUM=b.INDIVIDUAL_ID and a.ID_TYPE=b.ID_TYPE and b.status='1' ");
			sql.append("where a.query_date like '%").append(Query_time);
			sql.append("%' order by a.resp_time desc");
			
			//modify by chensibi end
			Iterator it = rootdao.queryBySQL2(sql.toString());
			htlog.info(sql);
			if (it == null) {
				htlog.info("no message need to be sent.");
				return;
			}
			// 创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 创建行
			HSSFRow row = null;
			// 创建单元格
			HSSFCell cell = null;
			// 创建一个sheet

			// 左对齐 0x31 文本格式
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyle.setDataFormat((short) 0x31);
			// 写入行名称
			// String title =
			// "指令类型;案件编号;接收时间;maker;checker;反馈时间;反馈结果;金额;公司/个人;开户网点代码;申请机构名称";
			String title = "查询操作员ID;证件类型;证件号;姓名;查询原因;查询状态;查询操作员IP;城市;区域;部门;许可文件路径;用户录入时间;人行报告返回时间;IBS查询时间;IBS查询 与用户录入时间差;人行报告返回与用户录入时间差;人行报告返回与IBS查询时间差;报告编号";
			String titleList[] = title.split(";");
			int k = 1;
			int i = 1;
			HSSFSheet sheet = null;
			while (it.hasNext()) {

				if (k % 50000 == 1) {
					k=1;
					sheet = workbook.createSheet("指令相关报表" + i);
					row = sheet.createRow(0);
					row.setHeight((short) 300);
					for (int j = 0; j < titleList.length; j++) {
						cell = row.createCell(j);
						cell.setCellStyle(cellStyle);
						cell.setCellValue(titleList[j]);
						sheet.autoSizeColumn(j, true);
					}
					i++;
				}

				Map map = (Map) it.next();
				String operator_id = transfer_toString(map.get("OPERATOR_ID"));
				String query_time = transfer_toString(map.get("TIME"));  
				//add by chensibi start
				if(query_time!=null && !"".equals(query_time) && !"null".equals(query_time) && !"NULL".equals(query_time)){
				query_time=query_time.substring(0, 4)+"-"+query_time.substring(4, 6)+"-"+query_time.substring(6, 8)+" "
				              +query_time.substring(8, 10)+":"+query_time.substring(10, 12)+":"+query_time.substring(12, 14);
				}
				String return_time = transfer_toString(map.get("RETURN_TIME"));
				if(return_time!=null && !"".equals(return_time) && !"NULL".equals(return_time) && !"null".equals(return_time)){
				return_time= return_time.substring(0, 4)+"-"+return_time.substring(4, 6)+"-"+return_time.substring(6, 8)+" "
			              +return_time.substring(8, 10)+":"+return_time.substring(10, 12)+":"+return_time.substring(12, 14);
				}
				String create_time = transfer_toString(map.get("CREATE_TIME"));
				if(create_time!=null && !"".equals(create_time) && !"null".equals(create_time) && !"NULL".equals(create_time)){
				create_time= create_time.substring(0, 4)+"-"+create_time.substring(4, 6)+"-"+create_time.substring(6, 8)+" "
			              +create_time.substring(8, 10)+":"+create_time.substring(10, 12)+":"+create_time.substring(12, 14);
				}
				//return_time和create_time只取年份月份
				//add by chensibi start
				
				//add by chensibi end

				String query_create_time = DateUtil.Between(query_time,
						create_time);
				String return_create_time = DateUtil.Between(return_time,
						create_time);
				String return_query_time = DateUtil.Between(return_time,
						query_time);

				// SimpleDateFormat format0 = new
				// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// Date Date_time=format0.parse(time);
				// Date Date_rttime=format0.parse(rttime);
				// Date Date_crttime=format0.parse(crttime);
				// String query_time =
				// format0.format(Date_time.getTime());//这个就是把时间戳经过处理得到期望格式的时间
				// String return_time =
				// format0.format(Date_rttime.getTime());
				// String create_time =
				// format0.format(Date_crttime.getTime());
				String credit_number = transfer_toString(map
						.get("CREDIT_NUMBER"));
				String credit_type = checkNull(midType,
						transfer_toString(map.get("CREDIT_TYPE")));
				String name = transfer_toString(map.get("NAME"));
				// String
				// credit_type=transfer_toString(midType.get(rs.getString("credit_type").trim()));
				// String
				// query_reson=transfer_toString(rs.getString("query_reson"));
				String query_reson = checkNull(mreason,
						transfer_toString(map.get("QUERY_RESON")));
				String query_status = checkNull(mstatus,
						transfer_toString(map.get("QUERY_STATUS")));
				// String
				// query_reson=transfer_toString(mreason.get(rs.getString("query_reson").trim()));
				// String
				// query_status=transfer_toString(mstatus.get(rs.getString("query_status").trim()));
				String query_operator_ip = transfer_toString(map
						.get("CREATE_USER_IP"));
				// String
				// sql_ip="select TOP 1 LOGIN_ADDR from TLR_LOGIN_LOG where TLR_NO='"
				// +
				// operator_id+"' and LOGIN_SUC_TM<='"+query_time+"' order by LOG_ID desc";
				// conn1 =
				// SessionFactoryUtils.getDataSource(ROOTDAOUtils.getROOTDAO().getSessionFactory()).getConnection();
				// statement1 = conn1.prepareStatement(sql_ip);
				// rs1 = statement1.executeQuery();
				// String query_operator_ip;
				// if(rs1.next()) {
				// query_operator_ip=transfer_toString(rs1.getString("LOGIN_ADDR"));
				// }
				// else
				// query_operator_ip="";
				String city = checkNull(mcity, transfer_toString(map.get("CITY")));
				String region = checkNull(mregion, transfer_toString(map.get("REGION")));
				String Department = checkNull(mdepartMent, transfer_toString(map.get("DEPARTMENT")));
				// String
				// city=transfer_toString(mcity.get(rs.getString("city").trim()));
				// String
				// region=transfer_toString(mregion.get(rs.getString("region").trim()));
				// String
				// Department=transfer_toString(mdepartMent.get(rs.getString("Department").trim()));
				// String role=transfer_toString(rs.getString("role"));
				String permission_path = transfer_toString(map.get("PERMISSION_PATH"));
				String rpt_id = transfer_toString(map.get("RPT_ID"));
				
				row = sheet.createRow(k);
				row.setHeight((short) 300);
				// 查询操作员id
				Create_Style_Value(0, cellStyle, operator_id, row, cell);
				// 证件类型
				Create_Style_Value(1, cellStyle, credit_type, row, cell);
				// 证件号
				Create_Style_Value(2, cellStyle, credit_number, row, cell);
				// 姓名
				Create_Style_Value(3, cellStyle, name, row, cell);
				// 查询原因
				Create_Style_Value(4, cellStyle, query_reson, row, cell);
				// 查询状态
				Create_Style_Value(5, cellStyle, query_status, row, cell);
				// 查询操作员ip
				Create_Style_Value(6, cellStyle, query_operator_ip, row, cell);
				// city
				Create_Style_Value(7, cellStyle, city, row, cell);
				// region
				Create_Style_Value(8, cellStyle, region, row, cell);
				// Deparatment
				Create_Style_Value(9, cellStyle, Department, row, cell);
				// role
				// Create_Style_Value(11,cellStyle,role,row,cell);
				// 许可文件路径
				Create_Style_Value(10, cellStyle, permission_path, row, cell);
				// 创建时间
				Create_Style_Value(11, cellStyle, create_time, row, cell);
				// 返回时间
				Create_Style_Value(12, cellStyle, return_time, row, cell);
				// 查询时间
				Create_Style_Value(13, cellStyle, query_time, row, cell);

				// IBS 查询时间-用户录入时间
				Create_Style_Value(14, cellStyle, query_create_time, row, cell);
				// 人行报告返回时间- 用户录入时间
				Create_Style_Value(15, cellStyle, return_create_time, row, cell);
				// 人行报告返回时间-IBS查询时间
				Create_Style_Value(16, cellStyle, return_query_time, row, cell);
				Create_Style_Value(17, cellStyle, rpt_id, row, cell);
				sheet.setColumnWidth(0, 250 * 12);
				sheet.setColumnWidth(1, 250 * 15);
				sheet.setColumnWidth(2, 250 * 20);
				sheet.setColumnWidth(3, 250 * 10);
				sheet.setColumnWidth(4, 250 * 10);
				sheet.setColumnWidth(5, 250 * 15);
				sheet.setColumnWidth(6, 250 * 15);
				sheet.setColumnWidth(7, 250 * 10);
				sheet.setColumnWidth(8, 250 * 10);
				sheet.setColumnWidth(9, 250 * 10);
				sheet.setColumnWidth(10, 250 * 30);
				sheet.setColumnWidth(11, 250 * 20);
				sheet.setColumnWidth(12, 250 * 20);
				sheet.setColumnWidth(13, 250 * 20);
				//
				sheet.setColumnWidth(14, 250 * 30);
				sheet.setColumnWidth(15, 250 * 30);
				sheet.setColumnWidth(16, 250 * 30);
				sheet.setColumnWidth(17, 250 * 30);
				k++;
			}

			/*
			 * for(i=0;i<=12;i++) { sheet.autoSizeColumn((short)i); }
			 */
			// String
			// sql_download="select PARAM_VAL from SYS_PARAMS where PARAMGROUP_ID='PER_DIALY' and PARAM_ID='DIA_REPORT'";
			String fileToBeDownload = null;
			String Download_Path = null;
			htlog.info(Curr_Y_Month);
			String filename = "monthly_ind_bureau_inquiry_record_" + Curr_Y_Month + ".xls";
			Download_Path = ReportUtils.getSysParamsValue("PER_DIALY", "DIA_REPORT");
			htlog.info(Download_Path);
			fileToBeDownload = Download_Path + filename;
			File dir = new File(Download_Path);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			FileOutputStream output = new FileOutputStream(fileToBeDownload);

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

	// private String Number_translate_status(String status) {
	// status=status.replaceAll("\\s*","");
	// String
	// query_status_array[]={"查询成功","未查询","正在查询","网络连接错误","网络超时","html解析错误","查无此人","密码错误","密码修改错误","登录出错","html不完整","没有报告编号"};
	// //
	// System.out.println("Interge="+Integer.parseInt(status,10)+"swithc="+status);
	// if(isNumeric(status)&&(Integer.parseInt(status)>=0&&Integer.parseInt(status)<=11))
	// {
	// System.out.println("Interge="+Integer.parseInt(status,10)+"swithc="+status);
	// return query_status_array[Integer.parseInt(status)];
	// }
	// return status;
	// }
	// private String Number_translate_idType(String id_type) {
	// id_type=id_type.replaceAll("\\s*","");
	// String
	// id_type_array[]={"0-身份证","1-户口簿","2-护照","3-军官证","4-士兵证","5-港澳居民来往内地通行证","6-台湾同胞来往内地通行证","7-临时身份证","8-外国人居留证","9-警官证","X-其他证件"};
	// //
	// System.out.println("id_type="+Integer.parseInt(id_type,10)+"swithc="+id_type);
	// if(id_type.equals("X")) {
	// return id_type_array[10];
	// }
	// if(isNumeric(id_type)&&(Integer.parseInt(id_type)>=0&&Integer.parseInt(id_type)<=9))
	// {
	// return id_type_array[Integer.parseInt(id_type)];
	// }
	// return id_type;
	// }
	// //城市
	// private String Number_translate_city(String city) {
	// city=city.replaceAll("\\s*","");
	// String
	// query_status_array[]={"Beijing","Changsha","Chengdu","Chongqing","Dalian","Foshan","Fuzhou","Guangzhou","Hangzhou","Harbin","Huhhot","Jinan","Kunming"
	// ,"Kunshan","Nanchang","Nanjing","Ningbo","Qingdao","Shanghai","Shenyang","Shenzhen","Suzhou","Taiyuan","TJ","Wuhan","Xi’an","Xiamen","Zhengzhou","Zhuhai"};
	// //
	// System.out.println("Interge="+Integer.parseInt(status,10)+"swithc="+status);
	// if(isNumeric(city)&&(Integer.parseInt(city)>=1&&Integer.parseInt(city)<=29))
	// {
	// System.out.println("Interge="+Integer.parseInt(city,10)+"swithc="+city);
	// return query_status_array[Integer.parseInt(city)-1];
	// }
	// return city;
	// }
	// //部门
	// private String Number_translate_region(String region) {
	// region=region.replaceAll("\\s*","");
	// String
	// query_status_array[]={"1-CIB_FI ","2-CIB_IC ","3-Commercial Banking ","4-Business Banking ","5-RB_Credit ","6-Operation ","7-GTO ","8-Admin"};
	// //
	// System.out.println("Interge="+Integer.parseInt(status,10)+"swithc="+status);
	// if(isNumeric(region)&&(Integer.parseInt(region)>=1&&Integer.parseInt(region)<=8))
	// {
	// System.out.println("Interge="+Integer.parseInt(region,10)+"swithc="+region);
	// return query_status_array[Integer.parseInt(region)-1];
	// }
	// return region;
	// }
	// //区域
	// private String Number_translate_Department(String Department) {
	// Department=Department.replaceAll("\\s*","");
	// String
	// query_status_array[]={"1-North ","2-South ","3-West ","4-East ","5-Head Office"};
	// //
	// System.out.println("Interge="+Integer.parseInt(status,10)+"swithc="+status);
	// if(isNumeric(Department)&&(Integer.parseInt(Department)>=1&&Integer.parseInt(Department)<=5))
	// {
	// System.out.println("Interge="+Integer.parseInt(Department,10)+"swithc="+Department);
	// return query_status_array[Integer.parseInt(Department)-1];
	// }
	// return Department;
	// }
	// //查询原因
	// private String Number_translate_query_reson(String query_reson) {
	// query_reson=query_reson.replaceAll("\\s*","");
	// String
	// query_status_array[]={"贷后管理","贷款审批","信用卡审批","本人查询","异议查询","担保资格审查"};
	// //
	// System.out.println("Interge="+Integer.parseInt(status,10)+"swithc="+status);
	// if(isNumeric(query_reson)){
	// int queryReasonInt = Integer.parseInt(query_reson);
	// queryReasonInt = queryReasonInt - 1;
	// if(queryReasonInt == 7){
	// queryReasonInt = 5;
	// }
	// if(queryReasonInt >= 0 && queryReasonInt <= 5) {
	// System.out.println("Interge="+Integer.parseInt(query_reson,10)+"swithc="+query_reson);
	// return query_status_array[queryReasonInt];
	// }
	// }
	// return query_reson;
	// }
	private void Create_Style_Value(int num, HSSFCellStyle cellStyle,
			String CellValue, HSSFRow row, HSSFCell cell) {
		cell = row.createCell(num);
		cell.setCellStyle(cellStyle);
		cell.setCellValue(CellValue);
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
