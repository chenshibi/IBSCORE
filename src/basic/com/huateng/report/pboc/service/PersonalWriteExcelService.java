package com.huateng.report.pboc.service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.excel.imp.DataMyUtil;

import resource.bean.crms.CrPerPa01ch;
import resource.bean.crms.CrPerPah;
import resource.bean.crms.CrPerPap;
import resource.bean.crms.CrPerPb01bh;
import resource.bean.crms.CrPerPbs;
import resource.bean.crms.CrPerPc02ah;
import resource.bean.crms.CrPerPc02bh;
import resource.bean.crms.CrPerPc02dh;
import resource.bean.crms.CrPerPc02kh;
import resource.bean.crms.CrPerPc030h;
import resource.bean.crms.CrPerPc040h;
import resource.bean.crms.CrPerPca;
import resource.bean.crms.CrPerPce;
import resource.bean.crms.CrPerPcj;
import resource.bean.crms.CrPerPco;
import resource.bean.crms.CrPerPcr;
import resource.bean.crms.CrPerPd01dh;
import resource.bean.crms.CrPerPd01eh;
import resource.bean.crms.CrPerPd01fh;
import resource.bean.crms.CrPerPd01gh;
import resource.bean.crms.CrPerPd01hh;
import resource.bean.crms.CrPerPd01zh;
import resource.bean.crms.CrPerPd02zh;
import resource.bean.crms.CrPerPd03zh;
import resource.bean.crms.CrPerPda;
import resource.bean.crms.CrPerPe01zh;
import resource.bean.crms.CrPerPf01zh;
import resource.bean.crms.CrPerPf02zh;
import resource.bean.crms.CrPerPf03zh;
import resource.bean.crms.CrPerPf04zh;
import resource.bean.crms.CrPerPf05zh;
import resource.bean.crms.CrPerPf06zh;
import resource.bean.crms.CrPerPf07zh;
import resource.bean.crms.CrPerPf08zh;
import resource.bean.crms.CrPerPg010h;
import resource.bean.crms.CrPerPhf;
import resource.bean.crms.CrPerPim;
import resource.bean.crms.CrPerPmm;
import resource.bean.crms.CrPerPnd;
import resource.bean.crms.CrPerPno;
import resource.bean.crms.CrPerPom;
import resource.bean.crms.CrPerPoq;
import resource.bean.crms.CrPerPos;
import resource.bean.crms.CrPerPot;
import resource.bean.crms.CrPerPpo;
import resource.bean.crms.CrPerPpq;
import resource.bean.crms.CrPerPqo;
import resource.bean.crms.CrPerPrh;
import resource.bean.crms.CrPerPrm;
import resource.bean.crms.CrPerPsm;
@Service
public class PersonalWriteExcelService {

	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(PersonalWriteExcelService.class);

	public static PersonalWriteExcelService getInstance() {
		return ApplicationContextUtils.getBean(PersonalWriteExcelService.class);
	}
	
	public void excelPerPrhExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-报告头";
		// 标题
		String[] title = new String[] {"序号                 "  ,
				"序号                 "  ,
				"报告编号             "  ,
				"报告时间             "  ,
				"被查询者姓名         "  ,
				"被查询者证件类型     "  ,
				"被查询者证件号码     "  ,
				"查询机构代码         "  ,
				"查询原因代码         "  ,
				"身份标识个数         "  ,
				"防欺诈警示标志       "  ,
				"防欺诈警示联系电话   "  ,
				"防欺诈警示生效日期   "  ,
				"防欺诈警示截止日期   "  ,
				"异议标注数目         "  ,
				"创建人               "  ,
				"创建时间             "  ,
				"审核人               "  ,
				"审核时间             "  ,
				"发送时间             "  ,
				"返回时间             "  ,
				"记录状态             "  
};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PRH.xlsx";
		
		try {
			List<CrPerPrh> crPerPrhList = BaseDAOUtils.getCrPerPrhDAO().findByIdProperties(id);
			createcrPerPrhExcel(response,sheetName,title,fileName,crPerPrhList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createcrPerPrhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPrh> crPerPrhList) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPrhList.size()][];
		for (int i = 0; i < crPerPrhList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrPerPrh crPerPrh = crPerPrhList.get(i);
			values[i][0 ] = String.valueOf(crPerPrh.getId()) == "null" ? "" : String.valueOf(crPerPrh.getId());
			values[i][1 ] = String.valueOf(crPerPrh.getBatchId()) == "null" ? "": String.valueOf(crPerPrh.getBatchId());
			values[i][2 ] = String.valueOf(crPerPrh.getPa01ai01()) == "null" ? "": String.valueOf(crPerPrh.getPa01ai01());
			values[i][3 ] = String.valueOf(crPerPrh.getPa01ar01()) == "null" ? "": String.valueOf(crPerPrh.getPa01ar01());
			values[i][4 ] = String.valueOf(crPerPrh.getPa01bq01()) == "null" ? "": String.valueOf(crPerPrh.getPa01bq01());
			values[i][5 ] = String.valueOf(crPerPrh.getPa01bd01()) == "null" ? "": String.valueOf(crPerPrh.getPa01bd01());
			values[i][6 ] = String.valueOf(crPerPrh.getPa01bi01()) == "null" ? "": String.valueOf(crPerPrh.getPa01bi01());
			values[i][7 ] = String.valueOf(crPerPrh.getPa01bi02()) == "null" ? "": String.valueOf(crPerPrh.getPa01bi02());
			values[i][8 ] = String.valueOf(crPerPrh.getPa01bd02()) == "null" ? "": String.valueOf(crPerPrh.getPa01bd02());
			values[i][9 ] = String.valueOf(crPerPrh.getPa01cs01()) == "null" ? "": String.valueOf(crPerPrh.getPa01cs01());
		    values[i][10] = String.valueOf(crPerPrh.getPa01dq01()) == "null" ? "": String.valueOf(crPerPrh.getPa01dq01());
			values[i][11] = String.valueOf(crPerPrh.getPa01dq02()) == "null" ? "": String.valueOf(crPerPrh.getPa01dq02());
			values[i][12] = String.valueOf(crPerPrh.getPa01dr01()) == "null" ? "": String.valueOf(crPerPrh.getPa01dr01());
			values[i][13] = String.valueOf(crPerPrh.getPa01dr02()) == "null" ? "": String.valueOf(crPerPrh.getPa01dr02());
			values[i][14] = String.valueOf(crPerPrh.getPa01es01()) == "null" ? "": String.valueOf(crPerPrh.getPa01es01());
			values[i][15] = String.valueOf(crPerPrh.getCreateUser()) == "null" ? "": String.valueOf(crPerPrh.getCreateUser());
			values[i][16] = String.valueOf(crPerPrh.getCreateTime() ) == "null" ? "": String.valueOf(crPerPrh.getCreateTime());
			values[i][17] = String.valueOf(crPerPrh.getCheckUser() ) == "null" ? "": String.valueOf(crPerPrh.getCheckUser() );
			values[i][18] = String.valueOf(crPerPrh.getCheckTime() ) == "null" ? "": String.valueOf(crPerPrh.getCheckTime() );
			values[i][19] = String.valueOf(crPerPrh.getSendTime()  ) == "null" ? "": String.valueOf(crPerPrh.getSendTime() );
			values[i][20] = String.valueOf(crPerPrh.getRespTime()  ) == "null" ? "": String.valueOf(crPerPrh.getRespTime() );
			values[i][21] = String.valueOf(crPerPrh.getStatus()) == "null" ? "": String.valueOf(crPerPrh.getStatus());
		 }

		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0  );
		sheet.autoSizeColumn((short) 1  );
		sheet.autoSizeColumn((short) 2  );
		sheet.autoSizeColumn((short) 3  );
		sheet.autoSizeColumn((short) 4  );
		sheet.autoSizeColumn((short) 5  );
		sheet.autoSizeColumn((short) 6  );
		sheet.autoSizeColumn((short) 7  );
		sheet.autoSizeColumn((short) 8  );
		sheet.autoSizeColumn((short) 9  );
		sheet.autoSizeColumn((short) 10 );
		sheet.autoSizeColumn((short) 11 );
		sheet.autoSizeColumn((short) 12 );
		sheet.autoSizeColumn((short) 13 );
		sheet.autoSizeColumn((short) 14 );
		sheet.autoSizeColumn((short) 15 );
		sheet.autoSizeColumn((short) 16 );
		sheet.autoSizeColumn((short) 17 );
		sheet.autoSizeColumn((short) 18 );
		sheet.autoSizeColumn((short) 19 );
		sheet.autoSizeColumn((short) 20 );
		sheet.autoSizeColumn((short) 21 );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	
	
	public void excelCrPerPa01chExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-报告头-其他身份标识信息段-身份信息";
		// 标题
		String[] title = new String[] { "序号      " ,
				 "序号      " ,
				 "证件类型  " ,
				 "证件号码  "};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PA01CH.xlsx";
		
		try {
			List<CrPerPa01ch> crPerPa01chList = BaseDAOUtils.getCrPerPa01chDAO().findByIdProperties(id);
			createCrPerPa01chExcel(response,sheetName,title,fileName,crPerPa01chList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPa01chExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPa01ch> crPerPrhList) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPrhList.size()][];
		for (int i = 0; i < crPerPrhList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrPerPa01ch crPerPa01ch = crPerPrhList.get(i);
			values[i][0 ] = String.valueOf(crPerPa01ch.getId()) == "null" ? "" : String.valueOf(crPerPa01ch.getId());
			values[i][1 ] = String.valueOf(crPerPa01ch.getBatchId()) == "null" ? "": String.valueOf(crPerPa01ch.getBatchId());
			values[i][2 ] = String.valueOf(crPerPa01ch.getPa01cd01()) == "null" ? "": String.valueOf(crPerPa01ch.getPa01cd01());
			values[i][3 ] = String.valueOf(crPerPa01ch.getPa01ci01()) == "null" ? "": String.valueOf(crPerPa01ch.getPa01ci01());
		 }

		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0  );
		sheet.autoSizeColumn((short) 1  );
		sheet.autoSizeColumn((short) 2  );
		sheet.autoSizeColumn((short) 3  );
		sheet.autoSizeColumn((short) 4  );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	
	public void excelCrPerPoqExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-报告头-其他身份标识信息段-身份信息";
		// 标题
		String[] title = new String[] { "序号      " ,
				 "序号      " ,
				 "证件类型  " ,
				 "证件号码  "};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_POQ.xlsx";
		
		try {
			List<CrPerPoq> crPerPoqList = BaseDAOUtils.getCrPerPoqDAO().findByIdProperties(id);
			createCrPerPoqExcel(response,sheetName,title,fileName,crPerPoqList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPoqExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPoq> crPerPoqList) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPoqList.size()][];
		for (int i = 0; i < crPerPoqList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrPerPoq crPerPoq = crPerPoqList.get(i);
			values[i][0 ] = String.valueOf(crPerPoq.getId()) == "null" ? "": String.valueOf(crPerPoq.getId());
			values[i][1 ] = String.valueOf(crPerPoq.getBatchId()) == "null" ? "": String.valueOf(crPerPoq.getBatchId());
			values[i][2 ] = String.valueOf(crPerPoq.getPh010r01()) == "null" ? "": String.valueOf(crPerPoq.getPh010r01());
			values[i][3 ] = String.valueOf(crPerPoq.getPh010d01()) == "null" ? "": String.valueOf(crPerPoq.getPh010d01());
            values[i][3 ] = String.valueOf(crPerPoq.getPh010q02()) == "null" ? "": String.valueOf(crPerPoq.getPh010q02());
			values[i][4 ] = String.valueOf(crPerPoq.getPh010q03()) == "null" ? "": String.valueOf(crPerPoq.getPh010q03());
                                                       
		 }

		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0  );
		sheet.autoSizeColumn((short) 1  );
		sheet.autoSizeColumn((short) 2  );
		sheet.autoSizeColumn((short) 3  );
		sheet.autoSizeColumn((short) 4  );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPqoExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-报告头-其他身份标识信息段-身份信息";
		// 标题
		String[] title = new String[] {"  序号                                        "   ,
				"   序号                                       "   ,
				"  上一次查询日期                              "   ,
				"  上一次查询机构机构类型                      "   ,
				"  上一次查询机构代码                          "   ,
				"  上一次查询原因                              "   ,
				"  最近 1 个月内的查询机构数（贷款审批）       "   ,
				"  最近 1 个月内的查询机构数（信用卡审批）     "   ,
				"  最近 1 个月内的查询次数（贷款审批）         "   ,
				"  最近 1 个月内的查询次数（信用卡审批）       "   ,
				"  最近 1 个月内的查询次数（本人查询）         "   ,
				"  最近 2 年内的查询次数（贷后管理）           "   ,
				"  最近 2 年内的查询次数（担保资格审查）       "   ,
				"  最近 2 年内的查询次数（特约商户实名审查）   "

};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PQO.xlsx";
		
		try {
			List<CrPerPqo> crPerPqoList = BaseDAOUtils.getCrPerPqoDAO().findByIdProperties(id);
			createCrPerPqoExcel(response,sheetName,title,fileName,crPerPqoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void createCrPerPqoExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPqo> crPerPqoList) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPqoList.size()][];
		for (int i = 0; i < crPerPqoList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrPerPqo crPerPqo = crPerPqoList.get(i);
			values[i][0 ] = String.valueOf(crPerPqo.getId()) == "null" ? "":   String.valueOf(crPerPqo.getId());
			values[i][1 ] = String.valueOf(crPerPqo.getBatchId()) == "null" ? "":   String.valueOf(crPerPqo.getBatchId());
			values[i][2 ] = String.valueOf(crPerPqo.getPc05ar01()) == "null" ? "": String.valueOf(crPerPqo.getPc05ar01());
			values[i][3 ] = String.valueOf(crPerPqo.getPc05ad01()) == "null" ? "": String.valueOf(crPerPqo.getPc05ad01());
			values[i][4 ] = String.valueOf(crPerPqo.getPc05ai01()) == "null" ? "": String.valueOf(crPerPqo.getPc05ai01());
			values[i][5 ] = String.valueOf(crPerPqo.getPc05aq01()) == "null" ? "": String.valueOf(crPerPqo.getPc05aq01());
			values[i][6 ] = String.valueOf(crPerPqo.getPc05bs01()) == "null" ? "": String.valueOf(crPerPqo.getPc05bs01());
			values[i][7 ] = String.valueOf(crPerPqo.getPc05bs02()) == "null" ? "": String.valueOf(crPerPqo.getPc05bs02());
			values[i][8 ] = String.valueOf(crPerPqo.getPc05bs03()) == "null" ? "": String.valueOf(crPerPqo.getPc05bs03());
			values[i][9 ] = String.valueOf(crPerPqo.getPc05bs04()) == "null" ? "": String.valueOf(crPerPqo.getPc05bs04());
			values[i][10] = String.valueOf(crPerPqo.getPc05bs05()) == "null" ? "": String.valueOf(crPerPqo.getPc05bs05());
			values[i][11] = String.valueOf(crPerPqo.getPc05bs06()) == "null" ? "": String.valueOf(crPerPqo.getPc05bs06());
			values[i][12] = String.valueOf(crPerPqo.getPc05bs07()) == "null" ? "": String.valueOf(crPerPqo.getPc05bs07());
			values[i][13] = String.valueOf(crPerPqo.getPc05bs08()) == "null" ? "": String.valueOf(crPerPqo.getPc05bs08());
                                                       
		 }

		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0  );
		sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		sheet.autoSizeColumn((short) 5   );
		sheet.autoSizeColumn((short) 6   );
		sheet.autoSizeColumn((short) 7   );
		sheet.autoSizeColumn((short) 8   );
		sheet.autoSizeColumn((short) 9   );
		sheet.autoSizeColumn((short) 10  );
		sheet.autoSizeColumn((short) 11  );
		sheet.autoSizeColumn((short) 12  );
		sheet.autoSizeColumn((short) 13  );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	
	public void excelCrPerPbsExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-低保救助记录";
		// 标题
		String[] title = new String[] {" 序号            "   ,
				" 序号            "   ,
				" 人员类别        "   ,
				" 所在地          "   ,
				" 工作单位        "   ,
				" 家庭月收入      "   ,
				" 申请日期        "   ,
				" 批准日期        "   ,
				" 信息更新日期    "   ,
				" 标注及声明个数  "   };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PBS.xlsx";
		
		try {
			List<CrPerPbs> crPerPbsList = BaseDAOUtils.getCrPerPbsDAO().findByIdProperties(id);
			createCrPerPbsExcel(response,sheetName,title,fileName,crPerPbsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPbsExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPbs> crPerPbsList) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPbsList.size()][];
		for (int i = 0; i < crPerPbsList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrPerPbs crPerPbs = crPerPbsList.get(i);
			values[i][0 ] = String.valueOf(crPerPbs.getId()) == "null" ? "":   String.valueOf(crPerPbs.getId());
			values[i][1 ] = String.valueOf(crPerPbs.getBatchId()) == "null" ? "":  String.valueOf(crPerPbs.getBatchId());
			values[i][2 ] = String.valueOf(crPerPbs.getPf06ad01()) == "null" ? "": String.valueOf( crPerPbs.getPf06ad01());
			values[i][3 ] = String.valueOf(crPerPbs.getPf06aq01()) == "null" ? "": String.valueOf( crPerPbs.getPf06aq01());
			values[i][4 ] = String.valueOf(crPerPbs.getPf06aq02()) == "null" ? "": String.valueOf( crPerPbs.getPf06aq02());
			values[i][5 ] = String.valueOf(crPerPbs.getPf06aq03()) == "null" ? "": String.valueOf( crPerPbs.getPf06aq03());
			values[i][6 ] = String.valueOf(crPerPbs.getPf06ar01()) == "null" ? "": String.valueOf( crPerPbs.getPf06ar01());
			values[i][7 ] = String.valueOf(crPerPbs.getPf06ar02()) == "null" ? "": String.valueOf( crPerPbs.getPf06ar02());
			values[i][8 ] = String.valueOf(crPerPbs.getPf06ar03()) == "null" ? "": String.valueOf( crPerPbs.getPf06ar03());
			values[i][9 ] = String.valueOf(crPerPbs.getPf06zs01()) == "null" ? "": String.valueOf( crPerPbs.getPf06zs01());
		 }

		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0  );
		sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		sheet.autoSizeColumn((short) 5   );
		sheet.autoSizeColumn((short) 6   );
		sheet.autoSizeColumn((short) 7   );
		sheet.autoSizeColumn((short) 8   );
		sheet.autoSizeColumn((short) 9   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	
	public void excelCrPerPf06zhExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-低保救助记录-标注及声明信息段-标注及声明信息";
		// 标题
		String[] title = new String[] {" 序号            "   ,
				"序号            "   ,
				"标注及声明类型       "   ,
				"标注或声明内容         "   ,
				"添加日期"
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PF06ZH.xlsx";
		
		try {
			List<CrPerPf06zh> crPerPf06zhlist = BaseDAOUtils.getCrPerPf06zhDAO().findByIdProperties(id);
			createCrPerPf06zhExcel(response,sheetName,title,fileName,crPerPf06zhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPf06zhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPf06zh> crPerPf06zhList) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPf06zhList.size()][];
		for (int i = 0; i < crPerPf06zhList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrPerPf06zh crPerPf06zh = crPerPf06zhList.get(i);
			values[i][0]=String.valueOf(crPerPf06zh.getId()) == "null" ? "":   String.valueOf(crPerPf06zh.getId());
			values[i][1] = String.valueOf(crPerPf06zh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPf06zh.getBatchId());
			values[i][2] = String.valueOf(crPerPf06zh.getPf06zd01()) == "null" ? "": String.valueOf(crPerPf06zh.getPf06zd01());
			values[i][3] = String.valueOf(crPerPf06zh.getPf06zq01()) == "null" ? "": String.valueOf(crPerPf06zh.getPf06zq01());
            values[i][4] = String.valueOf(crPerPf06zh.getPf06zr01()) == "null" ? "": String.valueOf(crPerPf06zh.getPf06zr01());
		 }

		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0  );
		sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPnoExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-非信贷交易信息概要";
		// 标题
		String[] title = new String[] {" 序号            "   ,
				"序号            "   ,
				"后付费业务类型数量       "   
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PNO.xlsx";
		
		try {
			List<CrPerPno> crPerPnolist = BaseDAOUtils.getCrPerPnoDAO().findByIdProperties(id);
			createCrPerPnoExcel(response,sheetName,title,fileName,crPerPnolist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPnoExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPno> crPerPnolist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPnolist.size()][];
		for (int i = 0; i < crPerPnolist.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrPerPno crPerPno = crPerPnolist.get(i);
			values[i][0]=String.valueOf(crPerPno.getId()) == "null" ? "":   String.valueOf(crPerPno.getId());
			values[i][1] = String.valueOf(crPerPno.getBatchId()) ==  "null" ? "": String.valueOf(crPerPno.getBatchId());
			values[i][2] = String.valueOf(crPerPno.getPc030s01()) == "null" ? "": String.valueOf(crPerPno.getPc030s01());
		 }

		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0  );
		sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPc03ohExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-非信贷交易信息概要-后付费业务欠费信息汇总信息单元段\r\n" + 
				"-后付费业务欠费信息汇总信息";
		// 标题
		String[] title = new String[] {"序号           " ,
				"序号           " ,
				"后付费业务类型 " ,
				"欠费账户数     " ,
				"欠费金额       "
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PC030H.xlsx";
		
		try {
			List<CrPerPc030h> crPerPc03Ohlist = BaseDAOUtils.getCrPerPc030hDAO().findByIdProperties(id);
			createCrPerPc03OhExcel(response,sheetName,title,fileName,crPerPc03Ohlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPc03OhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPc030h> crPerPc03Ohlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPc03Ohlist.size()][];
		for (int i = 0; i < crPerPc03Ohlist.size(); i++){
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrPerPc030h crPerPc030h = crPerPc03Ohlist.get(i);
			values[i][0]=String.valueOf(crPerPc030h.getId()) == "null" ? "":   String.valueOf(crPerPc030h.getId());
			values[i][1] = String.valueOf(crPerPc030h.getBatchId()) ==  "null" ? "": String.valueOf(crPerPc030h.getBatchId());
			values[i][2] = String.valueOf(crPerPc030h.getPc030d01()) == "null" ? "": String.valueOf(crPerPc030h.getPc030d01());
			values[i][3] = String.valueOf(crPerPc030h.getPc030s02()) == "null" ? "": String.valueOf(crPerPc030h.getPc030s02());
			values[i][4] = String.valueOf(crPerPc030h.getPc030j01()) == "null" ? "": String.valueOf(crPerPc030h.getPc030j01());
		 }

		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i < title.length; i++) {
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++) {
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0  );
		sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPpoExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-公共信息概要";
		// 标题
		String[] title = new String[] {" 序号            "   ,
				"序号            "   ,
				"公共信息类型数量       "   
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PPO.xlsx";
		
		try {
			List<CrPerPpo> crPerPpolist = BaseDAOUtils.getCrPerPpoDAO().findByIdProperties(id);
			createCrPerPpoExcel(response,sheetName,title,fileName,crPerPpolist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPpoExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPpo> crPerPpolist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPpolist.size()][];
		for (int i = 0; i < crPerPpolist.size(); i++){
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrPerPpo crPerPpo = crPerPpolist.get(i);
			values[i][0] =  String.valueOf(crPerPpo.getId()) == "null" ? "":   String.valueOf(crPerPpo.getId());
			values[i][1] =  String.valueOf(crPerPpo.getBatchId()) ==  "null" ? "": String.valueOf(crPerPpo.getBatchId());
			values[i][2] =  String.valueOf(crPerPpo.getPc040s01()) == "null" ? "": String.valueOf(crPerPpo.getPc040s01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPc04ohExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-公共信息概要-公共信息概要信息单元段\r\n" + 
				"-公共信息概要信息";
		// 标题
		String[] title = new String[] {" 序号            "   ,
				"序号            "   ,
				"公共信息类型       " ,
				"记录数",
				"涉及金额"
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PC040H.xlsx";
		
		try {
			List<CrPerPc040h> crPerPc04Ohlist = BaseDAOUtils.getCrPerPc040hDAO().findByIdProperties(id);
			createCrPerPc040hExcel(response,sheetName,title,fileName,crPerPc04Ohlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPc040hExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPc040h> crPerPc04Ohlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPc04Ohlist.size()][];
		for (int i = 0; i < crPerPc04Ohlist.size(); i++){
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrPerPc040h crPerPc040h = crPerPc04Ohlist.get(i);
			values[i][0] =  String.valueOf(crPerPc040h.getId()) == "null" ? "":   String.valueOf(crPerPc040h.getId());
			values[i][1] =  String.valueOf(crPerPc040h.getBatchId()) ==  "null" ? "": String.valueOf(crPerPc040h.getBatchId());
			values[i][2] =  String.valueOf(crPerPc040h.getPc040d01()) == "null" ? "": String.valueOf(crPerPc040h.getPc040d01());
			values[i][3] =  String.valueOf(crPerPc040h.getPc040s02()) == "null" ? "": String.valueOf(crPerPc040h.getPc040s02());
			values[i][4] =  String.valueOf(crPerPc040h.getPc040j01()) == "null" ? "": String.valueOf(crPerPc040h.getPc040j01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPapExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-公共信息概要-公共信息概要信息单元段\r\n" + 
				"-公共信息概要信息";
		// 标题
		String[] title = new String[] {"序号           ", 
				"序号           ",
				"处罚机构       ",
				"处罚内容       ",
				"处罚金额       ",
				"处罚生效日期   ",
				"处罚截止日期   ",
				"行政复议结果   ",
				"标注及声明个数 "
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PAP.xlsx";
		
		try {
			List<CrPerPap> crPerPaplist = BaseDAOUtils.getCrPerPapDAO().findByIdProperties(id);
			createCrPerPapExcel(response,sheetName,title,fileName,crPerPaplist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPapExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPap> crPerPaplist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPaplist.size()][];
		for (int i = 0; i < crPerPaplist.size(); i++){
			values[i] = new String[title.length];
			// 将对象内容转换成string
			 CrPerPap crPerPap= crPerPaplist.get(i);
			 values[i][0] =  String.valueOf(crPerPap.getId()) == "null" ? "":   String.valueOf(crPerPap.getId());
			 values[i][1] =  String.valueOf(crPerPap.getBatchId()) ==  "null" ? "": String.valueOf(crPerPap.getBatchId());
			 values[i][2] =  String.valueOf(crPerPap.getPf04aq01()) == "null" ? "": String.valueOf(crPerPap.getPf04aq01());
			 values[i][3] =  String.valueOf(crPerPap.getPf04aq02()) == "null" ? "": String.valueOf(crPerPap.getPf04aq02());
			 values[i][4] =  String.valueOf(crPerPap.getPf04aj01()) == "null" ? "": String.valueOf(crPerPap.getPf04aj01());
			 values[i][5] =  String.valueOf(crPerPap.getPf04ar01()) == "null" ? "": String.valueOf(crPerPap.getPf04ar01());
			 values[i][6] =  String.valueOf(crPerPap.getPf04ar02()) == "null" ? "": String.valueOf(crPerPap.getPf04ar02());
			 values[i][7] =  String.valueOf(crPerPap.getPf04aq03()) == "null" ? "": String.valueOf(crPerPap.getPf04aq03());
			 values[i][8] =  String.valueOf(crPerPap.getPf04zs01()) == "null" ? "": String.valueOf(crPerPap.getPf04zs01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		sheet.autoSizeColumn((short) 7);
		sheet.autoSizeColumn((short) 8);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPf04zhExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-行政处罚记录-标注及声明信息段-标注及声明信息";
		// 标题
		String[] title = new String[] {" 序号            "   ,
				"序号            "   ,
				"标注及声明类型       " ,
				"标注或声明内容",
				"添加日期"
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PF04ZH.xlsx";
		
		try {
			List<CrPerPf04zh> crPerPf04zhlist = BaseDAOUtils.getCrPerPf04zhDAO().findByIdProperties(id);
			createCrPerPf04zhExcel(response,sheetName,title,fileName,crPerPf04zhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPf04zhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPf04zh> crPerPf04zhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPf04zhlist.size()][];
		for (int i = 0; i < crPerPf04zhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPf04zh crPerPf04zh = crPerPf04zhlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPf04zh.getId()) == "null" ? "":   String.valueOf(crPerPf04zh.getId());
			 values[i][1] =  String.valueOf(crPerPf04zh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPf04zh.getBatchId());
			 values[i][2] =  String.valueOf(crPerPf04zh.getPf04zd01()) == "null" ? "": String.valueOf(crPerPf04zh.getPf04zd01());
			 values[i][3] =  String.valueOf(crPerPf04zh.getPf04zq01()) == "null" ? "": String.valueOf(crPerPf04zh.getPf04zq01());
			 values[i][4] =  String.valueOf(crPerPf04zh.getPf04zr01()) == "null" ? "": String.valueOf(crPerPf04zh.getPf04zr01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		sheet.autoSizeColumn((short) 7);
		sheet.autoSizeColumn((short) 8);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPahExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-行政处罚记录-标注及声明信息段-标注及声明信息";
		// 标题
		String[] title = new String[] { " 序号             " ,
				 " 序号             " ,
				 " 奖励机构         " ,
				 " 奖励内容         " ,
				 " 生效年月         " ,
				 " 截止年月         " ,
				 " 标注及声明个数   " };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PAH.xlsx";
		
		try {
			List<CrPerPah> crPerPahlist = BaseDAOUtils.getCrPerPahDAO().findByIdProperties(id);
			createCrPerPahExcel(response,sheetName,title,fileName,crPerPahlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPahExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPah> crPerPahlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPahlist.size()][];
		for (int i = 0; i < crPerPahlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPah crPerPah = crPerPahlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPah.getId()) == "null" ? "":   String.valueOf(crPerPah.getId());
			 values[i][1] =  String.valueOf(crPerPah.getBatchId()) ==  "null" ? "": String.valueOf(crPerPah.getBatchId());
			 values[i][2] =  String.valueOf(crPerPah.getPf08aq01()) == "null" ? "": String.valueOf(crPerPah.getPf08aq01());
			 values[i][3] =  String.valueOf(crPerPah.getPf08aq02()) == "null" ? "": String.valueOf(crPerPah.getPf08aq02());
			 values[i][4] =  String.valueOf(crPerPah.getPf08ar01()) == "null" ? "": String.valueOf(crPerPah.getPf08ar01());
			 values[i][5] =  String.valueOf(crPerPah.getPf08ar02()) == "null" ? "": String.valueOf(crPerPah.getPf08ar02());
			 values[i][6] =  String.valueOf(crPerPah.getPf08zs01()) == "null" ? "": String.valueOf(crPerPah.getPf08zs01());
                                                                                                            
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPapExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-行政处罚记录-标注及声明信息段-标注及声明信息";
		// 标题
		String[] title = new String[] { " 序号             " ,
				 " 序号             " ,
				 " 奖励机构         " ,
				 " 奖励内容         " ,
				 " 生效年月         " ,
				 " 截止年月         " ,
				 " 标注及声明个数   " };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PAP.xlsx";
		
		try {
			List<CrPerPap> crPerPaplist = BaseDAOUtils.getCrPerPapDAO().findByIdProperties(id);
			createCrPerPapExcel(response,sheetName,title,fileName,crPerPaplist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excelCrPahExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-行政处罚记录-标注及声明信息段-标注及声明信息";
		// 标题
		String[] title = new String[] { " 序号             " ,
				 " 序号             " ,
				 " 奖励机构         " ,
				 " 奖励内容         " ,
				 " 生效年月         " ,
				 " 截止年月         " ,
				 " 标注及声明个数   " };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PAH.xlsx";
		
		try {
			List<CrPerPah> crPerPahlist = BaseDAOUtils.getCrPerPahDAO().findByIdProperties(id);
			createCrPerPahExcel(response,sheetName,title,fileName,crPerPahlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excelCrPf08zhExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-行政处罚记录-标注及声明信息段-标注及声明信息";
		// 标题
		String[] title = new String[] { " 序号             " ,
				 " 序号             " ,
				 " 标注及声明类型         " ,
				 " 标注或声明内容         " ,
				 " 添加日期         " 
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PF08ZH.xlsx";
		
		try {
			List<CrPerPf08zh> crPerPf08zhlist = BaseDAOUtils.getCrPerPf08zhDAO().findByIdProperties(id);
			createCrPerPf08zhExcel(response,sheetName,title,fileName,crPerPf08zhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPf08zhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPf08zh> crPerPf08zhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPf08zhlist.size()][];
		for (int i = 0; i < crPerPf08zhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPf08zh crPerPf08zh = crPerPf08zhlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPf08zh.getId()) == "null" ? "":   String.valueOf(crPerPf08zh.getId());
			 values[i][1] =  String.valueOf(crPerPf08zh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPf08zh.getBatchId());
			 values[i][2] =  String.valueOf(crPerPf08zh.getPf08zd01()) == "null" ? "": String.valueOf(crPerPf08zh.getPf08zd01());
			 values[i][3] =  String.valueOf(crPerPf08zh.getPf08zq01()) == "null" ? "": String.valueOf(crPerPf08zh.getPf08zq01());
			 values[i][4] =  String.valueOf(crPerPf08zh.getPf08zr01()) == "null" ? "": String.valueOf(crPerPf08zh.getPf08zr01());
                                                                                                            
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	
	
	public void excelCrPg01OhExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-行政奖励记录-标注及声明信息段-标注及声明信息";
		// 标题
		String[] title = new String[] { " 序号             " ,
				 " 序号             " ,
				 " 标注及声明类型         " ,
				 " 标注或声明内容         " ,
				 " 添加日期         " 
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PG010H.xlsx";
		
		try {
			List<CrPerPg010h> crPerPg010hlist = BaseDAOUtils.getCrPerPg010hDAO().findByIdProperties(id);
			createCrPerPg010hExcel(response,sheetName,title,fileName,crPerPg010hlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPg010hExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPg010h> crPerPg010hlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPg010hlist.size()][];
		for (int i = 0; i < crPerPg010hlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPg010h crPerPg010h = crPerPg010hlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPg010h.getId()) == "null" ? "":   String.valueOf(crPerPg010h.getId());
			 values[i][1] =  String.valueOf(crPerPg010h.getBatchId()) ==  "null" ? "": String.valueOf(crPerPg010h.getBatchId());
			 values[i][2] =  String.valueOf(crPerPg010h.getPg010d03()) == "null" ? "": String.valueOf(crPerPg010h.getPg010d03());
			 values[i][3] =  String.valueOf(crPerPg010h.getPg010q01()) == "null" ? "": String.valueOf(crPerPg010h.getPg010q01());
			 values[i][4] =  String.valueOf(crPerPg010h.getPg010r01()) == "null" ? "": String.valueOf(crPerPg010h.getPg010r01());
                                                                                                            
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPndExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-后付费业务信息";
		// 标题
		String[] title = new String[] {" 序号                    "  ,
				" 序号                    "  ,
				" 后付费账户类型          "  ,
				" 机构名称                "  ,
				" 业务类型                "  ,
				" 业务开通日期            "  ,
				" 当前缴费状态            "  ,
				" 当前欠费金额            "  ,
				" 记账年月                "  ,
				" 最近 24 个月缴费记录    "  ,
				" 标注及声明个数          "  
};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PND.xlsx";
		
		try {
			List<CrPerPnd> crPerPndlist = BaseDAOUtils.getCrPerPndDAO().findByIdProperties(id);
			createCrPerPndExcel(response,sheetName,title,fileName,crPerPndlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPndExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPnd> crPerPndlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPndlist.size()][];
		for (int i = 0; i < crPerPndlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPnd crPerPnd = crPerPndlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPnd.getId()) == "null" ? "":   String.valueOf(crPerPnd.getId());
			 values[i][1] =  String.valueOf(crPerPnd.getBatchId()) ==  "null" ? "": String.valueOf(crPerPnd.getBatchId());
			 values[i][2] =  String.valueOf(crPerPnd.getPe01ad01()) == "null" ? "": String.valueOf(crPerPnd.getPe01ad01());
			 values[i][3] =  String.valueOf(crPerPnd.getPe01aq01()) == "null" ? "": String.valueOf(crPerPnd.getPe01aq01());
			 values[i][4] =  String.valueOf(crPerPnd.getPe01ad02()) == "null" ? "": String.valueOf(crPerPnd.getPe01ad02());
			 values[i][5] =  String.valueOf(crPerPnd.getPe01ar01()) == "null" ? "": String.valueOf(crPerPnd.getPe01ar01());
			 values[i][6] =  String.valueOf(crPerPnd.getPe01ad03()) == "null" ? "": String.valueOf(crPerPnd.getPe01ad03());
			 values[i][7] =  String.valueOf(crPerPnd.getPe01aj01()) == "null" ? "": String.valueOf(crPerPnd.getPe01aj01());
			 values[i][8] =  String.valueOf(crPerPnd.getPe01ar02()) == "null" ? "": String.valueOf(crPerPnd.getPe01ar02());
			 values[i][9] =  String.valueOf(crPerPnd.getPe01aq02()) == "null" ? "": String.valueOf(crPerPnd.getPe01aq02());
			 values[i][10] =  String.valueOf(crPerPnd.getPe01zs01()) == "null" ? "": String.valueOf(crPerPnd.getPe01zs01());

                                                                                                            
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		sheet.autoSizeColumn((short) 7);
		sheet.autoSizeColumn((short) 8);
		sheet.autoSizeColumn((short) 9);
		sheet.autoSizeColumn((short) 10);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPe01zhExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-后付费业务信息";
		// 标题
		String[] title = new String[] {" 序号                    "  ,
				" 序号                    "  ,
				" 标注及声明类型          "  ,
				" 标注或声明内容                "  ,
				" 添加日期                "  ,
				
};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PE01ZH.xlsx";
		
		try {
			List<CrPerPe01zh> crPerPe01zhlist = BaseDAOUtils.getCrPerPe01zhDAO().findByIdProperties(id);
			createCrPerPe01zhExcel(response,sheetName,title,fileName,crPerPe01zhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPe01zhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPe01zh> crPerPe01zhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPe01zhlist.size()][];
		for (int i = 0; i < crPerPe01zhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPe01zh crPerPe01zh = crPerPe01zhlist.get(i);
			// 将对象内容转换成string
			  values[i][0] =  String.valueOf(crPerPe01zh.getId()) == "null" ? "":   String.valueOf(crPerPe01zh.getId());
			  values[i][1] =  String.valueOf(crPerPe01zh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPe01zh.getBatchId());
			  values[i][2] =  String.valueOf(crPerPe01zh.getPe01zd01()) == "null" ? "": String.valueOf(crPerPe01zh.getPe01zd01());
			  values[i][3] =  String.valueOf(crPerPe01zh.getPe01zq01()) == "null" ? "": String.valueOf(crPerPe01zh.getPe01zq01());
			  values[i][4] =  String.valueOf(crPerPe01zh.getPe01zr01()) == "null" ? "": String.valueOf(crPerPe01zh.getPe01zr01());

                                                                                                            
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPf01zhExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-后付费业务信息";
		// 标题
		String[] title = new String[] {" 序号                    "  ,
				" 序号                    "  ,
				" 标注及声明类型          "  ,
				" 标注或声明内容                "  ,
				" 添加日期                "  ,
				
};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PF01ZH.xlsx";
		
		try {
			List<CrPerPf01zh> crPerPe01zhlist = BaseDAOUtils.getCrPerPf01zhDAO().findByIdProperties(id);
			createCrPerPf01zhExcel(response,sheetName,title,fileName,crPerPe01zhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPf01zhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPf01zh> crPerPf01zhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPf01zhlist.size()][];
		for (int i = 0; i < crPerPf01zhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPf01zh crPerPf01zh = crPerPf01zhlist.get(i);
			// 将对象内容转换成string
			  values[i][0] =  String.valueOf(crPerPf01zh.getId()) == "null" ? "":   String.valueOf(crPerPf01zh.getId());
			  values[i][1] =  String.valueOf(crPerPf01zh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPf01zh.getBatchId());
			  values[i][2] =  String.valueOf(crPerPf01zh.getPf01zd01()) == "null" ? "": String.valueOf(crPerPf01zh.getPf01zd01());
			  values[i][3] =  String.valueOf(crPerPf01zh.getPf01zq01()) == "null" ? "": String.valueOf(crPerPf01zh.getPf01zq01());
			  values[i][4] =  String.valueOf(crPerPf01zh.getPf01zr01()) == "null" ? "": String.valueOf(crPerPf01zh.getPf01zr01());
			

                                                                                                            
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	
	public void excelCrPerPmmExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-婚姻信息";
		// 标题
		String[] title = new String[] {"序号             " ,
				"序号             " ,
				"婚姻状况         " ,
				"配偶姓名         " ,
				"配偶证件类型     " ,
				"配偶证件号码     " ,
				"配偶工作单位     " ,
				"配偶联系电话     " };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PMM.xlsx";
		
		try {
			List<CrPerPmm> crPerPmmlist = BaseDAOUtils.getCrPerPmmDAO().findByIdProperties(id);
			createCrPerPmmExcel(response,sheetName,title,fileName,crPerPmmlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPmmExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPmm> crPerPmmlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPmmlist.size()][];
		for (int i = 0; i < crPerPmmlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPmm crPerPmm = crPerPmmlist.get(i);
			// 将对象内容转换成string
			  values[i][1] =  String.valueOf(crPerPmm.getBatchId()) ==  "null" ? "": String.valueOf(crPerPmm.getBatchId());
			  values[i][2] =  String.valueOf(crPerPmm.getPb020d01()) == "null" ? "": String.valueOf(crPerPmm.getPb020d01());
			  values[i][3] =  String.valueOf(crPerPmm.getPb020q01()) == "null" ? "": String.valueOf(crPerPmm.getPb020q01());
			  values[i][4] =  String.valueOf(crPerPmm.getPb020d02()) == "null" ? "": String.valueOf(crPerPmm.getPb020d02());
			  values[i][5] =  String.valueOf(crPerPmm.getPb020i01()) == "null" ? "": String.valueOf(crPerPmm.getPb020i01());
			  values[i][6] =  String.valueOf(crPerPmm.getPb020q02()) == "null" ? "": String.valueOf(crPerPmm.getPb020q02());
			  values[i][7] =  String.valueOf(crPerPmm.getPb020q03()) == "null" ? "": String.valueOf(crPerPmm.getPb020q03());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		sheet.autoSizeColumn((short) 7);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPdaExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-婚姻信息";
		// 标题
		String[] title = new String[] {"序号                                               " ,
				"序号                                               " ,
				"账户编号                                           " ,
				"账户类型                                           " ,
				"业务管理机构类型                                   " ,
				"业务管理机构代码                                   " ,
				"账户标识                                           " ,
				"授信协议编号                                       " ,
				"业务种类                                           " ,
				"开立日期                                           " ,
				"币种                                               " ,
				"借款金额                                           " ,
				"账户授信额度                                       " ,
				"共享授信额度                                       " ,
				"到期日期                                           " ,
				"还款方式                                           " ,
				"还款频率                                           " ,
				"还款期数                                           " ,
				"担保方式                                           " ,
				"贷款发放形式                                       " ,
				"共同借款标志                                       "  ,
				"债权转移时的还款状态                               "  ,
				"最新表现信息账户状态                               "  ,
				"最新表现信息关闭日期                               "  ,
				"最新表现信息转出月份                               "  ,
				"最新表现信息余额                                   "  ,
				"最新表现信息最近一次还款日期                       "  ,
				"最新表现信息最近一次还款金额                       "  ,
				"最新表现信息五级分类                               "  ,
				"最新表现信息还款状态                               "  ,
				"最新表现信息信息报告日期                           "  ,
				"最近一次月度表现信息月份                           "  ,
				"最近一次月度表现信息账户状态                       "  ,
				"最近一次月度表现信息余额                           "  ,
				"最近一次月度表现信息已用额度                       "  ,
				"最近一次月度表现信息未出单的大额专项分期余额       "  ,
				"最近一次月度表现信息五级分类                       "  ,
				"最近一次月度表现信息剩余还款期数                   "  ,
				"最近一次月度表现信息结算/应还款日                  "  ,
				"最近一次月度表现信息本月应还款                     "  ,
				"最近一次月度表现信息本月实还款                     "  ,
				"最近一次月度表现信息最近一次还款日期               "  ,
				"最近一次月度表现信息当前逾期期数                   "  ,
				"最近一次月度表现信息当前逾期总额                   "  ,
				"最近一次月度表现信息逾期 31—60 天未还本金          "  ,
				"最近一次月度表现信息逾期 61－90 天未还本金         "  ,
				"最近一次月度表现信息逾期 91－180 天未还本金        "  ,
				"最近一次月度表现信息逾期 180 天以上未还本金        "  ,
				"最近一次月度表现信息透支 180 天以上未付余额        "  ,
				"最近一次月度表现信息最近 6 个月平均使用额度        "  ,
				"最近一次月度表现信息最近 6 个月平均透支余额        "  ,
				"最近一次月度表现信息最大使用额度                   "  ,
				"最近一次月度表现信息最大透支余额                   "  ,
				"最近一次月度表现信息信息报告日期                   "  ,
				"最近 24 个月还款状态信息起始年月                   "  ,
				"最近 24 个月还款状态信息截止年月                   "  ,
				"最近 5 年内的历史表现信息起始年月                  "  ,
				"最近 5 年内的历史表现信息截止年月                  "  ,
				"最近 5 年内的历史表现信息月数                      "  ,
				"特殊交易个数                                       "  ,
				"特殊事件说明个数                                   "  ,
				"大额专项分期笔数                                   "  ,
				"标注及声明个数                                     "
};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PDA.xlsx";
		
		try {
			List<CrPerPda> crPerPdalist = BaseDAOUtils.getCrPerPdaDAO().findByIdProperties(id);
			createCrPdaPmmExcel(response,sheetName,title,fileName,crPerPdalist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPdaPmmExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPda> crPerPdalist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPdalist.size()][];
		for (int i = 0; i < crPerPdalist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPda crPerPda = crPerPdalist.get(i);
			// 将对象内容转换成string
			  values[i][0 ] =  String.valueOf(crPerPda.getId()) ==  "null" ? "": String.valueOf(crPerPda.getId());
              values[i][1 ] =  String.valueOf(crPerPda.getBatchId()) ==  "null" ? "": String.valueOf(crPerPda.getBatchId());
			  values[i][2 ] =  String.valueOf(crPerPda.getPd01ai01()) == "null" ? "": String.valueOf(crPerPda.getPd01ai01());
			  values[i][3 ] =  String.valueOf(crPerPda.getPd01ad01()) == "null" ? "": String.valueOf(crPerPda.getPd01ad01());
			  values[i][4 ] =  String.valueOf(crPerPda.getPd01ad02()) == "null" ? "": String.valueOf(crPerPda.getPd01ad02());
			  values[i][5 ] =  String.valueOf(crPerPda.getPd01ai02()) == "null" ? "": String.valueOf(crPerPda.getPd01ai02());
			  values[i][6 ] =  String.valueOf(crPerPda.getPd01ai03()) == "null" ? "": String.valueOf(crPerPda.getPd01ai03());
			  values[i][7 ] =  String.valueOf(crPerPda.getPd01ai04()) == "null" ? "": String.valueOf(crPerPda.getPd01ai04());
			  values[i][8 ] =  String.valueOf(crPerPda.getPd01ad03()) ==  "null" ? "": String.valueOf(crPerPda.getPd01ad03());
			  values[i][9 ] =  String.valueOf(crPerPda.getPd01ar01()) == "null" ? "": String.valueOf(crPerPda.getPd01ar01());
			  values[i][10] =  String.valueOf(crPerPda.getPd01ad04()) == "null" ? "": String.valueOf(crPerPda.getPd01ad04());
			  values[i][11] =  String.valueOf(crPerPda.getPd01aj01()) == "null" ? "": String.valueOf(crPerPda.getPd01aj01());
			  values[i][12] =  String.valueOf(crPerPda.getPd01aj02()) == "null" ? "": String.valueOf(crPerPda.getPd01aj02());
			  values[i][13] =  String.valueOf(crPerPda.getPd01aj03()) == "null" ? "": String.valueOf(crPerPda.getPd01aj03());
			  values[i][14] =  String.valueOf(crPerPda.getPd01ar02()) == "null" ? "": String.valueOf(crPerPda.getPd01ar02());
			  values[i][15] =  String.valueOf(crPerPda.getPd01ad05()) ==  "null" ? "": String.valueOf(crPerPda.getPd01ad05());
			  values[i][16] =  String.valueOf(crPerPda.getPd01ad06()) == "null" ? "": String.valueOf(crPerPda.getPd01ad06());
			  values[i][17] =  String.valueOf(crPerPda.getPd01as01()) == "null" ? "": String.valueOf(crPerPda.getPd01as01());
			  values[i][18] =  String.valueOf(crPerPda.getPd01ad07()) == "null" ? "": String.valueOf(crPerPda.getPd01ad07());
			  values[i][19] =  String.valueOf(crPerPda.getPd01ad08()) == "null" ? "": String.valueOf(crPerPda.getPd01ad08());
			  values[i][20] =  String.valueOf(crPerPda.getPd01ad09()) == "null" ? "": String.valueOf(crPerPda.getPd01ad09());
			  values[i][21] =  String.valueOf(crPerPda.getPd01ad10()) == "null" ? "": String.valueOf(crPerPda.getPd01ad10());
			  values[i][22] =  String.valueOf(crPerPda.getPd01bd01()) ==  "null" ? "": String.valueOf(crPerPda.getPd01bd01());
			  values[i][23] =  String.valueOf(crPerPda.getPd01br01()) == "null" ? "": String.valueOf(crPerPda.getPd01br01());
			  values[i][24] =  String.valueOf(crPerPda.getPd01br04()) == "null" ? "": String.valueOf(crPerPda.getPd01br04());
			  values[i][25] =  String.valueOf(crPerPda.getPd01bj01()) == "null" ? "": String.valueOf(crPerPda.getPd01bj01());
			  values[i][26] =  String.valueOf(crPerPda.getPd01br02()) == "null" ? "": String.valueOf(crPerPda.getPd01br02());
			  values[i][27] =  String.valueOf(crPerPda.getPd01bj02()) == "null" ? "": String.valueOf(crPerPda.getPd01bj02());
			  values[i][28] =  String.valueOf(crPerPda.getPd01bd03()) == "null" ? "": String.valueOf(crPerPda.getPd01bd03());
			  values[i][29] =  String.valueOf(crPerPda.getPd01bd04()) ==  "null" ? "": String.valueOf(crPerPda.getPd01bd04());
			  values[i][30] =  String.valueOf(crPerPda.getPd01br03()) == "null" ? "": String.valueOf(crPerPda.getPd01br03());
			  values[i][31] =  String.valueOf(crPerPda.getPd01cr01()) == "null" ? "": String.valueOf(crPerPda.getPd01cr01());
			  values[i][32] =  String.valueOf(crPerPda.getPd01cd01()) == "null" ? "": String.valueOf(crPerPda.getPd01cd01());
			  values[i][33] =  String.valueOf(crPerPda.getPd01cj01()) == "null" ? "": String.valueOf(crPerPda.getPd01cj01());
			  values[i][34] =  String.valueOf(crPerPda.getPd01cj02()) == "null" ? "": String.valueOf(crPerPda.getPd01cj02());
			  values[i][35] =  String.valueOf(crPerPda.getPd01cj03()) == "null" ? "": String.valueOf(crPerPda.getPd01cj03());
			  values[i][36] =  String.valueOf(crPerPda.getPd01cd02()) ==  "null" ? "": String.valueOf(crPerPda.getPd01cd02());
			  values[i][37] =  String.valueOf(crPerPda.getPd01cs01()) == "null" ? "": String.valueOf(crPerPda.getPd01cs01());
			  values[i][38] =  String.valueOf(crPerPda.getPd01cr02()) == "null" ? "": String.valueOf(crPerPda.getPd01cr02());
			  values[i][39] =  String.valueOf(crPerPda.getPd01cj04()) == "null" ? "": String.valueOf(crPerPda.getPd01cj04());
			  values[i][40] =  String.valueOf(crPerPda.getPd01cj05()) == "null" ? "": String.valueOf(crPerPda.getPd01cj05());
			  values[i][41] =  String.valueOf(crPerPda.getPd01cr03()) == "null" ? "": String.valueOf(crPerPda.getPd01cr03());
			  values[i][42] =  String.valueOf(crPerPda.getPd01cs02()) == "null" ? "": String.valueOf(crPerPda.getPd01cs02());
			  values[i][43] =  String.valueOf(crPerPda.getPd01cj06()) ==  "null" ? "": String.valueOf(crPerPda.getPd01cj06());
			  values[i][44] =  String.valueOf(crPerPda.getPd01cj07()) == "null" ? "": String.valueOf(crPerPda.getPd01cj07());
			  values[i][45] =  String.valueOf(crPerPda.getPd01cj08()) == "null" ? "": String.valueOf(crPerPda.getPd01cj08());
			  values[i][46] =  String.valueOf(crPerPda.getPd01cj09()) == "null" ? "": String.valueOf(crPerPda.getPd01cj09());
			  values[i][47] =  String.valueOf(crPerPda.getPd01cj10()) == "null" ? "": String.valueOf(crPerPda.getPd01cj10());
			  values[i][48] =  String.valueOf(crPerPda.getPd01cj11()) == "null" ? "": String.valueOf(crPerPda.getPd01cj11());
			  values[i][49] =  String.valueOf(crPerPda.getPd01cj12()) == "null" ? "": String.valueOf(crPerPda.getPd01cj12());
			  values[i][50] =  String.valueOf(crPerPda.getPd01cj13()) ==  "null" ? "": String.valueOf(crPerPda.getPd01cj13());
			  values[i][51] =  String.valueOf(crPerPda.getPd01cj14()) == "null" ? "": String.valueOf(crPerPda.getPd01cj14());
			  values[i][52] =  String.valueOf(crPerPda.getPd01cj15()) == "null" ? "": String.valueOf(crPerPda.getPd01cj15());
			  values[i][53] =  String.valueOf(crPerPda.getPd01cr04()) == "null" ? "": String.valueOf(crPerPda.getPd01cr04());
			  values[i][54] =  String.valueOf(crPerPda.getPd01dr01()) == "null" ? "": String.valueOf(crPerPda.getPd01dr01());
			  values[i][55] =  String.valueOf(crPerPda.getPd01dr02()) == "null" ? "": String.valueOf(crPerPda.getPd01dr02());
			  values[i][56] =  String.valueOf(crPerPda.getPd01er01()) == "null" ? "": String.valueOf(crPerPda.getPd01er01());
			  values[i][57] =  String.valueOf(crPerPda.getPd01er02()) ==  "null" ? "": String.valueOf(crPerPda.getPd01er02());
			  values[i][58] =  String.valueOf(crPerPda.getPd01es01()) == "null" ? "": String.valueOf(crPerPda.getPd01es01());
			  values[i][59] =  String.valueOf(crPerPda.getPd01fs01()) == "null" ? "": String.valueOf(crPerPda.getPd01fs01());
			  values[i][60] =  String.valueOf(crPerPda.getPd01fs01()) == "null" ? "": String.valueOf(crPerPda.getPd01fs01());
			  values[i][61] =  String.valueOf(crPerPda.getPd01hs01()) == "null" ? "": String.valueOf(crPerPda.getPd01hs01());
			  values[i][62] =  String.valueOf(crPerPda.getPd01zs01()) == "null" ? "": String.valueOf(crPerPda.getPd01zs01());

		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		sheet.autoSizeColumn((short) 5   ) ;
		sheet.autoSizeColumn((short) 6   );
		sheet.autoSizeColumn((short) 7   );
		sheet.autoSizeColumn((short) 8   );
		sheet.autoSizeColumn((short) 9   );
		sheet.autoSizeColumn((short) 10  );
		sheet.autoSizeColumn((short) 11  );
		sheet.autoSizeColumn((short) 12  );
		sheet.autoSizeColumn((short) 13  ) ;
		sheet.autoSizeColumn((short) 14  );
		sheet.autoSizeColumn((short) 15  );
		sheet.autoSizeColumn((short) 16  );
		sheet.autoSizeColumn((short) 17  );
		sheet.autoSizeColumn((short) 18  );
		sheet.autoSizeColumn((short) 19  );
		sheet.autoSizeColumn((short) 20  );
		sheet.autoSizeColumn((short) 21  ) ;
		sheet.autoSizeColumn((short) 22  );
		sheet.autoSizeColumn((short) 23  );
		sheet.autoSizeColumn((short) 24  );
		sheet.autoSizeColumn((short) 25  );
		sheet.autoSizeColumn((short) 26  );
		sheet.autoSizeColumn((short) 27  );
		sheet.autoSizeColumn((short) 28  );
		sheet.autoSizeColumn((short) 29  ) ;
		sheet.autoSizeColumn((short) 30  );
		sheet.autoSizeColumn((short) 31  );
		sheet.autoSizeColumn((short) 32  );
		sheet.autoSizeColumn((short) 33  );
		sheet.autoSizeColumn((short) 34  );
		sheet.autoSizeColumn((short) 35  );
		sheet.autoSizeColumn((short) 36  );
		sheet.autoSizeColumn((short) 37  ) ;
		sheet.autoSizeColumn((short) 38  );
		sheet.autoSizeColumn((short) 39  );
		sheet.autoSizeColumn((short) 40  );
		sheet.autoSizeColumn((short) 41  );
		sheet.autoSizeColumn((short) 42  );
		sheet.autoSizeColumn((short) 43  );
		sheet.autoSizeColumn((short) 44  );
		sheet.autoSizeColumn((short) 45  ) ;
		sheet.autoSizeColumn((short) 46  );
		sheet.autoSizeColumn((short) 47  );
		sheet.autoSizeColumn((short) 48  );
		sheet.autoSizeColumn((short) 49  );
		sheet.autoSizeColumn((short) 50  );
		sheet.autoSizeColumn((short) 51  );
		sheet.autoSizeColumn((short) 52  );
		sheet.autoSizeColumn((short) 53  ) ;
		sheet.autoSizeColumn((short) 54  );
		sheet.autoSizeColumn((short) 55  );
		sheet.autoSizeColumn((short) 56  );
		sheet.autoSizeColumn((short) 57  );
		sheet.autoSizeColumn((short) 58  );
		sheet.autoSizeColumn((short) 59  );
		sheet.autoSizeColumn((short) 60  );
		sheet.autoSizeColumn((short) 61  ) ;
		sheet.autoSizeColumn((short) 62  );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPd01zhExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-借贷账户信息-标注及声明信息段-标注及声明信息";
		// 标题
		String[] title = new String[] {"序号          ",
				"序号          ",
				"标注及声明类型",
				"标注或声明内容",
				"添加日期      ",
				"CR_PER_PDA的ID"
         };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PD01ZH.xlsx";
		
		try {
			List<CrPerPd01zh> crPerPmmlist = BaseDAOUtils.getCrPerPd01zhDAO().findByIdProperties(id);
			createCrPerPd01zhExcel(response,sheetName,title,fileName,crPerPmmlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPd01zhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPd01zh> crPerPd01zhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPd01zhlist.size()][];
		for (int i = 0; i < crPerPd01zhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPd01zh crPerPd01zh = crPerPd01zhlist.get(i);
			// 将对象内容转换成string
			  values[i][0] =  String.valueOf(crPerPd01zh.getId()) ==  "null" ? "": String.valueOf(crPerPd01zh.getId());
			  values[i][1] =  String.valueOf(crPerPd01zh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPd01zh.getBatchId());
			  values[i][2] =  String.valueOf(crPerPd01zh.getPd01zd01()) == "null" ? "": String.valueOf(crPerPd01zh.getPd01zd01());
			  values[i][3] =  String.valueOf(crPerPd01zh.getPd01zq01()) == "null" ? "": String.valueOf(crPerPd01zh.getPd01zq01());
			  values[i][4] =  String.valueOf(crPerPd01zh.getPd01zr01()) == "null" ? "": String.valueOf(crPerPd01zh.getPd01zr01());
			  values[i][5] =  String.valueOf(crPerPd01zh.getParentId()) == "null" ? "": String.valueOf(crPerPd01zh.getParentId());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	
	public void excelCrPerPd01hhExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-借贷账户信息-大额专项分期信息段-大额专项分期信息";
		// 标题
		String[] title = new String[] {"序号","序号","大额专项分期额度","分期额度生效日期","分期额度到期日期","已用分期金额","CR_PER_PDA的ID"};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PD01HH.xlsx";
		
		try {
			List<CrPerPd01hh> crPerPd01hhlist = BaseDAOUtils.getCrPerPd01hhDAO().findByIdProperties(id);
			createCrPerPd01hhExcel(response,sheetName,title,fileName,crPerPd01hhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPd01hhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPd01hh> crPerPd01hhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPd01hhlist.size()][];
		for (int i = 0; i < crPerPd01hhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPd01hh crPerPd01hh = crPerPd01hhlist.get(i);
			// 将对象内容转换成string
			  values[i][0] =  String.valueOf(crPerPd01hh.getId()) ==  "null" ? "": String.valueOf(crPerPd01hh.getId());
			  values[i][1] =  String.valueOf(crPerPd01hh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPd01hh.getBatchId());
			  values[i][2] =  String.valueOf(crPerPd01hh.getPd01hj01()) == "null" ? "": String.valueOf(crPerPd01hh.getPd01hj01());
			  values[i][3] =  String.valueOf(crPerPd01hh.getPd01hr01()) == "null" ? "": String.valueOf(crPerPd01hh.getPd01hr01());
			  values[i][4] =  String.valueOf(crPerPd01hh.getPd01hr02()) == "null" ? "": String.valueOf(crPerPd01hh.getPd01hr02());
			  values[i][5] =  String.valueOf(crPerPd01hh.getPd01hj01()) == "null" ? "": String.valueOf(crPerPd01hh.getPd01hj01());
			  values[i][6] =  String.valueOf(crPerPd01hh.getParentId()) == "null" ? "": String.valueOf(crPerPd01hh.getParentId());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPd01fhExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-借贷账户信息-特殊交易信息段-特殊交易信息";
		// 标题
		String[] title = new String[] {"序号            ", 
				"序号            ",
				"特殊交易类型    ",
				"特殊交易发生日期",
				"到期日期变更月数",
				"特殊交易发生金额",
				"特殊交易明细记录",
				"CR_PER_PDA的ID"};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PD01FH.xlsx";
		
		try {
			List<CrPerPd01fh> crPerPd01fhlist = BaseDAOUtils.getCrPerPd01fhDAO().findByIdProperties(id);
			createCrPerPd01fhExcel(response,sheetName,title,fileName,crPerPd01fhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPd01fhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPd01fh> crPerPd01fhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPd01fhlist.size()][];
		for (int i = 0; i < crPerPd01fhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPd01fh crPerPd01fh = crPerPd01fhlist.get(i);
			// 将对象内容转换成string
			  values[i][0] =  String.valueOf(crPerPd01fh.getId()) ==  "null" ? "": String.valueOf(crPerPd01fh.getId());
			  values[i][1] =  String.valueOf(crPerPd01fh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPd01fh.getBatchId());
			  values[i][2] =  String.valueOf(crPerPd01fh.getPd01fd01()) == "null" ? "": String.valueOf(crPerPd01fh.getPd01fd01());
			  values[i][3] =  String.valueOf(crPerPd01fh.getPd01fr01()) == "null" ? "": String.valueOf(crPerPd01fh.getPd01fr01());
			  values[i][4] =  String.valueOf(crPerPd01fh.getPd01fs02()) == "null" ? "": String.valueOf(crPerPd01fh.getPd01fs02());
			  values[i][5] =  String.valueOf(crPerPd01fh.getPd01fj01()) == "null" ? "": String.valueOf(crPerPd01fh.getPd01fj01());
			  values[i][6] =  String.valueOf(crPerPd01fh.getPd01fq01()) == "null" ? "": String.valueOf(crPerPd01fh.getPd01fq01());
			  values[i][7] =  String.valueOf(crPerPd01fh.getParentId()) == "null" ? "": String.valueOf(crPerPd01fh.getParentId());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		sheet.autoSizeColumn((short) 7);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	
	public void excelCrPerPd01ghExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-借贷账户信息-特特殊事件说明信息段-特殊事件说明信息";
		// 标题
		String[] title = new String[] {"序号","序号","特殊事件发生月份","特殊事件类型","CR_PER_PDA的ID"};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PD01GH.xlsx";
		
		try {
			List<CrPerPd01gh> crPerPd01ghlist = BaseDAOUtils.getCrPerPd01ghDAO().findByIdProperties(id);
			createCrPerPd01ghExcel(response,sheetName,title,fileName,crPerPd01ghlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPd01ghExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPd01gh> crPerPd01ghlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPd01ghlist.size()][];
		for (int i = 0; i < crPerPd01ghlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPd01gh crPerPd01gh = crPerPd01ghlist.get(i);
			// 将对象内容转换成string
			  values[i][0] =  String.valueOf(crPerPd01gh.getId()) ==  "null" ? "": String.valueOf(crPerPd01gh.getId());
			  values[i][1] =  String.valueOf(crPerPd01gh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPd01gh.getBatchId());
			  values[i][2] =  String.valueOf(crPerPd01gh.getPd01gr01()) == "null" ? "": String.valueOf(crPerPd01gh.getPd01gr01());
			  values[i][3] =  String.valueOf(crPerPd01gh.getPd01gd01()) == "null" ? "": String.valueOf(crPerPd01gh.getPd01gd01());
			  values[i][4] =  String.valueOf(crPerPd01gh.getParentId()) == "null" ? "": String.valueOf(crPerPd01gh.getParentId());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	
	public void excelCrPerPd01dhExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-借贷账户信息-最近24个月还款记录信息段-还款状态信息";
		// 标题
		String[] title = new String[] {"序号","序号","月份","还款状态","CR_PER_PDA的ID"};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PD01DH.xlsx";
		
		try {
			List<CrPerPd01dh> crPerPd01dhlist = BaseDAOUtils.getCrPerPd01dhDAO().findByIdProperties(id);
			createCrPerPd01dhExcel(response,sheetName,title,fileName,crPerPd01dhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPd01dhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPd01dh> crPerPd01dhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPd01dhlist.size()][];
		for (int i = 0; i < crPerPd01dhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPd01dh crPerPd01dh = crPerPd01dhlist.get(i);
			// 将对象内容转换成string
			  values[i][0] =  String.valueOf(crPerPd01dh.getId()) ==  "null" ? "": String.valueOf(crPerPd01dh.getId());
			  values[i][1] =  String.valueOf(crPerPd01dh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPd01dh.getBatchId());
			  values[i][2] =  String.valueOf(crPerPd01dh.getPd01dr03()) == "null" ? "": String.valueOf(crPerPd01dh.getPd01dr03());
			  values[i][3] =  String.valueOf(crPerPd01dh.getPd01dd01()) == "null" ? "": String.valueOf(crPerPd01dh.getPd01dd01());
			  values[i][4] =  String.valueOf(crPerPd01dh.getParentId()) == "null" ? "": String.valueOf(crPerPd01dh.getParentId());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPd01ehExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-借贷账户信息-最近5年内历史表现信息段-历史表现信息";
		// 标题
		String[] title = new String[] {"序号","序号","月份","还款状态","逾期（透支）总额","CR_PER_PDA的ID"};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PD01EH.xlsx";
		
		try {
			List<CrPerPd01eh> crPerPd01ehlist = BaseDAOUtils.getCrPerPd01ehDAO().findByIdProperties(id);
			createCrPerPd01ehExcel(response,sheetName,title,fileName,crPerPd01ehlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPd01ehExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPd01eh> crPerPd01ehlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPd01ehlist.size()][];
		for (int i = 0; i < crPerPd01ehlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPd01eh crPerPd01eh = crPerPd01ehlist.get(i);
			// 将对象内容转换成string
			  values[i][0] =  String.valueOf(crPerPd01eh.getId()) ==  "null" ? "": String.valueOf(crPerPd01eh.getId());
			  values[i][1] =  String.valueOf(crPerPd01eh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPd01eh.getBatchId());
			  values[i][2] =  String.valueOf(crPerPd01eh.getPd01er03()) == "null" ? "": String.valueOf(crPerPd01eh.getPd01er03());
			  values[i][3] =  String.valueOf(crPerPd01eh.getPd01ed01()) == "null" ? "": String.valueOf(crPerPd01eh.getPd01ed01());
			  values[i][4] =  String.valueOf(crPerPd01eh.getPd01ej01()) == "null" ? "": String.valueOf(crPerPd01eh.getPd01ej01());
			  values[i][5] =  String.valueOf(crPerPd01eh.getParentId()) == "null" ? "": String.valueOf(crPerPd01eh.getParentId());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPrmExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-居住信息";
		// 标题
		String[] title = new String[] {"序号","序号","居住状况","居住地址","住宅电话","信息更新日期"};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PRM.xlsx";
		
		try {
			List<CrPerPrm> crPerPrmlist = BaseDAOUtils.getCrPerPrmDAO().findByIdProperties(id);
			createCrPerPrmExcel(response,sheetName,title,fileName,crPerPrmlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPrmExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPrm> crPerPrmlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPrmlist.size()][];
		for (int i = 0; i < crPerPrmlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPrm crPerPrm = crPerPrmlist.get(i);
			// 将对象内容转换成string
			  values[i][0] =  String.valueOf(crPerPrm.getId()) ==  "null" ? "": String.valueOf(crPerPrm.getId());
              values[i][1] =  String.valueOf(crPerPrm.getBatchId()) ==  "null" ? "": String.valueOf(crPerPrm.getBatchId());
			  values[i][2] =  String.valueOf(crPerPrm.getPb030d01()) == "null" ? "": String.valueOf(crPerPrm.getPb030d01());
			  values[i][3] =  String.valueOf(crPerPrm.getPb030q01()) == "null" ? "": String.valueOf(crPerPrm.getPb030q01());
			  values[i][4] =  String.valueOf(crPerPrm.getPb030q02()) == "null" ? "": String.valueOf(crPerPrm.getPb030q02());
			  values[i][5] =  String.valueOf(crPerPrm.getPb030r01()) == "null" ? "": String.valueOf(crPerPrm.getPb030r01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPcjExcel(HttpServletResponse response,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询个人征信结果-民事判决记录";
		// 标题
		String[] title = new String[] {"序号                " ,
				"序号                " ,
				"立案法院            " ,
				"案由                " ,
				"立案日期            " ,
				"结案方式            " ,
				"判决/调解结果       " ,
				"判决/调解生效日期   " ,
				"诉讼标的            " ,
				"诉讼标的金额        " ,
				"标注及声明个数      " };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PCJ.xlsx";
		
		try {
			List<CrPerPcj> crPerPcjlist = BaseDAOUtils.getCrPerPcjDAO().findByIdProperties(id);
			createCrPerPcjExcel(response,sheetName,title,fileName,crPerPcjlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPcjExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPcj> crPerPcjlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPcjlist.size()][];
		for (int i = 0; i < crPerPcjlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPcj crPerPcj = crPerPcjlist.get(i);
			// 将对象内容转换成string
			  values[i][0] =  String.valueOf(crPerPcj.getId()) ==  "null" ? "":  String.valueOf(crPerPcj.getId());
			  values[i][1] =  String.valueOf(crPerPcj.getBatchId()) ==  "null" ? "":  String.valueOf(crPerPcj.getBatchId());
			  values[i][2] =  String.valueOf(crPerPcj.getPf02aq01()) == "null" ? "": String.valueOf(crPerPcj.getPf02aq01());
			  values[i][3] =  String.valueOf(crPerPcj.getPf02aq02()) == "null" ? "": String.valueOf(crPerPcj.getPf02aq02());
			  values[i][4] =  String.valueOf(crPerPcj.getPf02ar01()) == "null" ? "": String.valueOf(crPerPcj.getPf02ar01());
			  values[i][5] =  String.valueOf(crPerPcj.getPf02ad01()) == "null" ? "": String.valueOf(crPerPcj.getPf02ad01());
   		      values[i][6] =  String.valueOf(crPerPcj.getPf02aq03()) == "null" ? "": String.valueOf(crPerPcj.getPf02aq03());
			  values[i][7] =  String.valueOf(crPerPcj.getPf02ar02()) == "null" ? "": String.valueOf(crPerPcj.getPf02ar02());
			  values[i][8] =  String.valueOf(crPerPcj.getPf02aq04()) == "null" ? "": String.valueOf(crPerPcj.getPf02aq04());
			  values[i][9] =  String.valueOf(crPerPcj.getPf02aj01()) == "null" ? "": String.valueOf(crPerPcj.getPf02aj01());
			  values[i][10] =  String.valueOf(crPerPcj.getPf02zs01()) == "null" ? "": String.valueOf(crPerPcj.getPf02zs01());
			
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		sheet.autoSizeColumn((short) 5   ) ;
		sheet.autoSizeColumn((short) 6   );
		sheet.autoSizeColumn((short) 7   );
		sheet.autoSizeColumn((short) 8   );
		sheet.autoSizeColumn((short) 9   );
		sheet.autoSizeColumn((short) 10  );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPf02zhExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-民事判决记录";
		// 标题
		String[] title = new String[] {"序号                " ,
				"序号                " ,
				"标注及声明类型            " ,
				"标注或声明内容                " ,
				"添加日期"
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PF02ZH.xlsx";
		
		try {
			List<CrPerPf02zh> crPerPf02zhlist = BaseDAOUtils.getCrPerPf02zhDAO().findByIdProperties(id);
			createCrPerPf02zhExcel(response,sheetName,title,fileName,crPerPf02zhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPf02zhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPf02zh> crPerPf02zhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPf02zhlist.size()][];
		for (int i = 0; i < crPerPf02zhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPf02zh crPerPf02zh = crPerPf02zhlist.get(i);
			// 将对象内容转换成string
			  values[i][0] =  String.valueOf(crPerPf02zh.getId()) ==  "null" ? "":  String.valueOf(crPerPf02zh.getId());
			  values[i][1] =  String.valueOf(crPerPf02zh.getBatchId()) ==  "null" ? "":  String.valueOf(crPerPf02zh.getBatchId());
			  values[i][2] =  String.valueOf(crPerPf02zh.getPf02zd01()) == "null" ? "": String.valueOf(crPerPf02zh.getPf02zd01());
			  values[i][3] =  String.valueOf(crPerPf02zh.getPf02zq01()) == "null" ? "": String.valueOf(crPerPf02zh.getPf02zq01());
			  values[i][4] =  String.valueOf(crPerPf02zh.getPf02zr01()) == "null" ? "": String.valueOf(crPerPf02zh.getPf02zr01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	
	public void excelCrPerPsmExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-评分信息";
		// 标题
		String[] title = new String[] {"序号                " ,
				"序号                " ,
				"数字解读            " ,
				"相对位置",
				"分数说明条数                " ,
				"分数说明"
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PSM.xlsx";
		
		try {
			List<CrPerPsm> crPerPsmlist = BaseDAOUtils.getCrPerPsmDAO().findByIdProperties(id);
			createCrPerPsmExcel(response,sheetName,title,fileName,crPerPsmlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPsmExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPsm> crPerPsmlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPsmlist.size()][];
		for (int i = 0; i < crPerPsmlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPsm crPerPsm = crPerPsmlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPsm.getId()) ==  "null" ? "": String.valueOf(crPerPsm.getId());
			 values[i][1] =  String.valueOf(crPerPsm.getBatchId()) ==  "null" ? "": String.valueOf(crPerPsm.getBatchId());
			 values[i][2] =  String.valueOf(crPerPsm.getPc010q01()) == "null" ? "": String.valueOf(crPerPsm.getPc010q01());
			 values[i][3] =  String.valueOf(crPerPsm.getPc010q02()) == "null" ? "": String.valueOf(crPerPsm.getPc010q02());
			 values[i][4] =  String.valueOf(crPerPsm.getPc010s01()) == "null" ? "": String.valueOf(crPerPsm.getPc010s01());
			 values[i][5] =  String.valueOf(crPerPsm.getPc010d01()) == "null" ? "": String.valueOf(crPerPsm.getPc010d01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		sheet.autoSizeColumn((short) 5   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPosExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-其他标注及声明信息";
		// 标题
		String[] title = new String[] {"序号                " ,
				"序号                " ,
				"对象类型            " ,
				"对象标识",
				"标注及声明个数                " 
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_POS.xlsx";
		
		try {
			List<CrPerPos> crPerPoslist = BaseDAOUtils.getCrPerPosDAO().findByIdProperties(id);
			createCrPerPosExcel(response,sheetName,title,fileName,crPerPoslist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPosExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPos> crPerPoslist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPoslist.size()][];
		for (int i = 0; i < crPerPoslist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPos crPerPos = crPerPoslist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPos.getId()) ==  "null" ? "": String.valueOf(crPerPos.getId());
			 values[i][1] =  String.valueOf(crPerPos.getBatchId()) ==  "null" ? "": String.valueOf(crPerPos.getBatchId());
			 values[i][2] =  String.valueOf(crPerPos.getPg010d01()) == "null" ? "": String.valueOf(crPerPos.getPg010d01());
			 values[i][3] =  String.valueOf(crPerPos.getPg010d02()) == "null" ? "": String.valueOf(crPerPos.getPg010d02());
			 values[i][4] =  String.valueOf(crPerPos.getPg010s01()) == "null" ? "": String.valueOf(crPerPos.getPg010s01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPotExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-欠税记录";
		// 标题
		String[] title = new String[] {"序号                " ,
				"序号                " ,
				"主管税务机关            " ,
				"欠税总额",
				"欠税统计日期                " ,
				"标注及声明个数"
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_POT.xlsx";
		
		try {
			List<CrPerPot> crPerPotlist = BaseDAOUtils.getCrPerPotDAO().findByIdProperties(id);
			createCrPerPotExcel(response,sheetName,title,fileName,crPerPotlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPotExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPot> crPerPotlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPotlist.size()][];
		for (int i = 0; i < crPerPotlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPot crPerPot = crPerPotlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPot.getId()) ==  "null" ? "": String.valueOf(crPerPot.getId());
			 values[i][1] =  String.valueOf(crPerPot.getBatchId()) ==  "null" ? "": String.valueOf(crPerPot.getBatchId());
			 values[i][2] =  String.valueOf(crPerPot.getPf01aq01()) == "null" ? "": String.valueOf(crPerPot.getPf01aq01());
			 values[i][3] =  String.valueOf(crPerPot.getPf01aj01()) == "null" ? "": String.valueOf(crPerPot.getPf01aj01());
			 values[i][4] =  String.valueOf(crPerPot.getPf01ar01()) == "null" ? "": String.valueOf(crPerPot.getPf01ar01());
			 values[i][5] =  String.valueOf(crPerPot.getPf01zs01()) == "null" ? "": String.valueOf(crPerPot.getPf01zs01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		sheet.autoSizeColumn((short) 5   ) ;
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPceExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-欠税记录";
		// 标题
		String[] title = new String[] {"序号               " ,
				"序号               " ,
				"执行法院           " ,
				"执行案由           " ,
				"立案日期           " ,
				"结案方式           " ,
				"案件状态           " ,
				"结案日期           " ,
				"申请执行标的       " ,
				"申请执行标的金额   " ,
				"已执行标的         " ,
				"已执行标的金额     " ,
				"标注及声明个数     "};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PCE.xlsx";
		
		try {
			List<CrPerPce> crPerPcelist = BaseDAOUtils.getCrPerPceDAO().findByIdProperties(id);
			createCrPerPceExcel(response,sheetName,title,fileName,crPerPcelist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPceExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPce> crPerPcelist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPcelist.size()][];
		for (int i = 0; i < crPerPcelist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPce crPerPce = crPerPcelist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPce.getId()) ==  "null" ? "": String.valueOf(crPerPce.getId());
	         values[i][1] =  String.valueOf(crPerPce.getBatchId()) ==  "null" ? "":  String.valueOf(crPerPce.getBatchId());
			 values[i][2] =  String.valueOf(crPerPce.getPf03aq01()) == "null" ? "": String.valueOf(crPerPce.getPf03aq01());
			 values[i][3] =  String.valueOf(crPerPce.getPf03aq02()) == "null" ? "": String.valueOf(crPerPce.getPf03aq02());
			 values[i][4] =  String.valueOf(crPerPce.getPf03ar01()) == "null" ? "": String.valueOf(crPerPce.getPf03ar01());
			 values[i][5] =  String.valueOf(crPerPce.getPf03ad01()) == "null" ? "": String.valueOf(crPerPce.getPf03ad01());
			 values[i][6] =  String.valueOf(crPerPce.getPf03aq03()) == "null" ? "": String.valueOf(crPerPce.getPf03aq03());
			 values[i][7] =  String.valueOf(crPerPce.getPf03ar02()) == "null" ? "": String.valueOf(crPerPce.getPf03ar02());
			 values[i][8] =  String.valueOf(crPerPce.getPf03aq04()) ==  "null" ? "":String.valueOf(crPerPce.getPf03aq04());
			 values[i][9] =  String.valueOf(crPerPce.getPf03aj01()) == "null" ? "": String.valueOf(crPerPce.getPf03aj01());
			 values[i][10] = String.valueOf(crPerPce.getPf03aq05()) == "null" ? "": String.valueOf(crPerPce.getPf03aq05());
			 values[i][11] = String.valueOf(crPerPce.getPf03aj02()) == "null" ? "": String.valueOf(crPerPce.getPf03aj02());
		     values[i][12] = String.valueOf(crPerPce.getPf03zs01()) == "null" ? "": String.valueOf(crPerPce.getPf03zs01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		    sheet.autoSizeColumn((short) 0   );
		    sheet.autoSizeColumn((short) 1   );
			sheet.autoSizeColumn((short) 2   );
			sheet.autoSizeColumn((short) 3   );
			sheet.autoSizeColumn((short) 4   );
			sheet.autoSizeColumn((short) 5   ) ;
			sheet.autoSizeColumn((short) 6   );
			sheet.autoSizeColumn((short) 7   );
			sheet.autoSizeColumn((short) 8   );
			sheet.autoSizeColumn((short) 9   );
			sheet.autoSizeColumn((short) 10  );
			sheet.autoSizeColumn((short) 11  );
			sheet.autoSizeColumn((short) 12  );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	
	public void excelCrPerPf03zhExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-欠税记录";
		// 标题
		String[] title = new String[] {"序号               " ,
				"序号               " ,
				"标注及声明类型           " ,
				"标注或声明内容           " ,
				"添加日期           " 
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PF03ZH.xlsx";
		
		try {
			List<CrPerPf03zh> crPerPf03zhlist = BaseDAOUtils.getCrPerPf03zhDAO().findByIdProperties(id);
			createCrPerPf03zhExcel(response,sheetName,title,fileName,crPerPf03zhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPf03zhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPf03zh> crPerPf03zhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPf03zhlist.size()][];
		for (int i = 0; i < crPerPf03zhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPf03zh crPerPf03zh = crPerPf03zhlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPf03zh.getId()) ==  "null" ? "": String.valueOf(crPerPf03zh.getId());
             values[i][1] =  String.valueOf(crPerPf03zh.getBatchId()) ==  "null" ? "":String.valueOf(crPerPf03zh.getBatchId());
			 values[i][2] =  String.valueOf(crPerPf03zh.getPf03zd01()) == "null" ? "": String.valueOf(crPerPf03zh.getPf03zd01());
			 values[i][3] =  String.valueOf(crPerPf03zh.getPf03zq01()) == "null" ? "": String.valueOf(crPerPf03zh.getPf03zq01());
			 values[i][4] =  String.valueOf(crPerPf03zh.getPf03zr01()) == "null" ? "": String.valueOf(crPerPf03zh.getPf03zr01());
			 
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		    sheet.autoSizeColumn((short) 0   );
		    sheet.autoSizeColumn((short) 1   );
			sheet.autoSizeColumn((short) 2   );
			sheet.autoSizeColumn((short) 3   );
			sheet.autoSizeColumn((short) 4   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPimExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-身份信息";
		// 标题
		String[] title = new String[] {"序号         " , 
				"序号         " ,
				"性别         " ,
				"出生日期     " ,
				"学历         " ,
				"学位         " ,
				"就业状况     " ,
				"电子邮箱     " ,
				"通讯地址     " ,
				"国籍         " ,
				"户籍地址     " ,
				"手机号码个数 "};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PIM.xlsx";
		
		try {
			List<CrPerPim> crPerPimlist = BaseDAOUtils.getCrPerPimDAO().findByIdProperties(id);
			createCrPerPimExcel(response,sheetName,title,fileName,crPerPimlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPimExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPim> crPerPimlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPimlist.size()][];
		for (int i = 0; i < crPerPimlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPim crPerPim = crPerPimlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPim.getId()) ==  "null" ? "": String.valueOf(crPerPim.getId());
			 values[i][1] =  String.valueOf(crPerPim.getBatchId()) ==  "null" ? "": String.valueOf(crPerPim.getBatchId());
			 values[i][2] =  String.valueOf(crPerPim.getPb01ad01()) == "null" ? "": String.valueOf(crPerPim.getPb01ad01());
			 values[i][3] =  String.valueOf(crPerPim.getPb01ar01()) == "null" ? "": String.valueOf(crPerPim.getPb01ar01());
			 values[i][4] =  String.valueOf(crPerPim.getPb01ad02()) == "null" ? "": String.valueOf(crPerPim.getPb01ad02());
			 values[i][5] =  String.valueOf(crPerPim.getPb01ad03()) ==  "null" ? "":String.valueOf(crPerPim.getPb01ad03());
			 values[i][6] =  String.valueOf(crPerPim.getPb01ad04()) == "null" ? "": String.valueOf(crPerPim.getPb01ad04());
			 values[i][7] =  String.valueOf(crPerPim.getPb01aq01()) == "null" ? "": String.valueOf(crPerPim.getPb01aq01());
			 values[i][8] =  String.valueOf(crPerPim.getPb01aq02()) == "null" ? "": String.valueOf(crPerPim.getPb01aq02());
			 values[i][9] =  String.valueOf(crPerPim.getPb01ad05()) == "null" ? "": String.valueOf(crPerPim.getPb01ad05());
			 values[i][10] = String.valueOf(crPerPim.getPb01aq03()) == "null" ? "": String.valueOf(crPerPim.getPb01aq03());
			 values[i][11] = String.valueOf(crPerPim.getPb01bs01()) == "null" ? "": String.valueOf(crPerPim.getPb01bs01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		    sheet.autoSizeColumn((short) 0   );
		    sheet.autoSizeColumn((short) 1   );
			sheet.autoSizeColumn((short) 2   );
			sheet.autoSizeColumn((short) 3   );
			sheet.autoSizeColumn((short) 4   );
			sheet.autoSizeColumn((short) 5   ) ;
			sheet.autoSizeColumn((short) 6   );
			sheet.autoSizeColumn((short) 7   );
			sheet.autoSizeColumn((short) 8   );
			sheet.autoSizeColumn((short) 9   );
			sheet.autoSizeColumn((short) 10  );
			sheet.autoSizeColumn((short) 11  );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPb01bhExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-身份信息";
		// 标题
		String[] title = new String[] {"序号         " , 
				"序号         " ,
				"手机号码         " ,
				"信息更新日期    " 
			};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PB01BH.xlsx";
		
		try {
			List<CrPerPb01bh> crPerPb01bhlist = BaseDAOUtils.getCrPerPb01bhDAO().findByIdProperties(id);
			createCrPerPb01bhExcel(response,sheetName,title,fileName,crPerPb01bhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPb01bhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPb01bh> crPerPb01bhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPb01bhlist.size()][];
		for (int i = 0; i < crPerPb01bhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPb01bh crPerPb01bh = crPerPb01bhlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPb01bh.getId()) ==  "null" ? "": String.valueOf(crPerPb01bh.getId());
			 values[i][1] =  String.valueOf(crPerPb01bh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPb01bh.getBatchId());
			 values[i][2] =  String.valueOf(crPerPb01bh.getPb01bq01()) == "null" ? "": String.valueOf(crPerPb01bh.getPb01bq01());
			 values[i][3] =  String.valueOf(crPerPb01bh.getPb01br01()) == "null" ? "": String.valueOf(crPerPb01bh.getPb01br01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		    sheet.autoSizeColumn((short) 0   );
		    sheet.autoSizeColumn((short) 1   );
			sheet.autoSizeColumn((short) 2   );
			sheet.autoSizeColumn((short) 3   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPcaExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-身份信息";
		// 标题
		String[] title = new String[] {
				"序号              "  , 
				"序号              "  ,
				"授信协议编号      "  ,
				"业务管理机构类型  "  ,
				"业务管理机构      "  ,
				"授信协议标识      "  ,
				"授信额度用途      "  ,
				"授信额度          "  ,
				"币种              "  ,
				"生效日期          "  ,
				"到期日期          "  ,
				"授信协议状态      "  ,
				"已用额度          "  ,
				"授信限额          "  ,
				"授信限额编号      "  ,
				"标注及声明个数    "};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PCA.xlsx";
		
		try {
			List<CrPerPca> crPerPcalist = BaseDAOUtils.getCrPerPcaDAO().findByIdProperties(id);
			createCrPerPcaExcel(response,sheetName,title,fileName,crPerPcalist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPcaExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPca> crPerPcalist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPcalist.size()][];
		for (int i = 0; i < crPerPcalist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPca crPerPca = crPerPcalist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPca.getId()) ==  "null" ? "": String.valueOf(crPerPca.getId());
			 values[i][1] =  String.valueOf(crPerPca.getBatchId()) ==  "null" ? "": String.valueOf(crPerPca.getBatchId());
			 values[i][2] =  String.valueOf(crPerPca.getPd02ai01()) == "null" ? "": String.valueOf(crPerPca.getPd02ai01());
			 values[i][3] =  String.valueOf(crPerPca.getPd02ad01()) == "null" ? "": String.valueOf(crPerPca.getPd02ad01());
			 values[i][4] =  String.valueOf(crPerPca.getPd02ai02()) == "null" ? "": String.valueOf(crPerPca.getPd02ai02());
			 values[i][5] =  String.valueOf(crPerPca.getPd02ai03()) == "null" ? "": String.valueOf(crPerPca.getPd02ai03());
			 values[i][6] =  String.valueOf(crPerPca.getPd02ad02()) ==  "null" ? "":String.valueOf(crPerPca.getPd02ad02());
			 values[i][7] =  String.valueOf(crPerPca.getPd02aj01()) == "null" ? "": String.valueOf(crPerPca.getPd02aj01());
			 values[i][8] =  String.valueOf(crPerPca.getPd02ad03()) == "null" ? "": String.valueOf(crPerPca.getPd02ad03());
			 values[i][9] =  String.valueOf(crPerPca.getPd02ar01()) == "null" ? "": String.valueOf(crPerPca.getPd02ar01());
			 values[i][10] = String.valueOf(crPerPca.getPd02ar02()) == "null" ? "": String.valueOf(crPerPca.getPd02ar02());
			 values[i][11] = String.valueOf(crPerPca.getPd02ad04()) == "null" ? "": String.valueOf(crPerPca.getPd02ad04());
			 values[i][12] = String.valueOf(crPerPca.getPd02aj04()) == "null" ? "": String.valueOf(crPerPca.getPd02aj04());
			 values[i][13] = String.valueOf(crPerPca.getPd02aj03()) == "null" ? "": String.valueOf(crPerPca.getPd02aj03());
			 values[i][14] = String.valueOf(crPerPca.getPd02ai04()) == "null" ? "": String.valueOf(crPerPca.getPd02ai04());
			 values[i][15] = String.valueOf(crPerPca.getPd02zs01()) == "null" ? "": String.valueOf(crPerPca.getPd02zs01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		    sheet.autoSizeColumn((short) 0   );
		    sheet.autoSizeColumn((short) 1   );
			sheet.autoSizeColumn((short) 2   );
			sheet.autoSizeColumn((short) 3   );
			sheet.autoSizeColumn((short) 4   );
			sheet.autoSizeColumn((short) 5   ) ;
			sheet.autoSizeColumn((short) 6   );
			sheet.autoSizeColumn((short) 7   );
			sheet.autoSizeColumn((short) 8   );
			sheet.autoSizeColumn((short) 9   );
			sheet.autoSizeColumn((short) 10  );
			sheet.autoSizeColumn((short) 11  );
			sheet.autoSizeColumn((short) 12  );
			sheet.autoSizeColumn((short) 13  ) ;
			sheet.autoSizeColumn((short) 14  );
			sheet.autoSizeColumn((short) 15  );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPd02zhExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-民事判决记录-标注及声明信息段-标注及声明信息";
		// 标题
		String[] title = new String[] {
				"序号              "  , 
				"序号              "  ,
				"标注及声明类型      "  ,
				"标注或声明内容  "  ,
				"添加日期"
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PD02ZH.xlsx";
		
		try {
			List<CrPerPd02zh> crPerPd02zhlist = BaseDAOUtils.getCrPerPd02zhDAO().findByIdProperties(id);
			createCrPerPd02zhExcel(response,sheetName,title,fileName,crPerPd02zhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPd02zhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPd02zh> crPerPd02zhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPd02zhlist.size()][];
		for (int i = 0; i < crPerPd02zhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPd02zh crPerPd02zh = crPerPd02zhlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPd02zh.getId()) ==  "null" ? "": String.valueOf(crPerPd02zh.getId());
			 values[i][1] =  String.valueOf(crPerPd02zh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPd02zh.getBatchId());
			 values[i][2] =  String.valueOf(crPerPd02zh.getPd02zd01()) == "null" ? "": String.valueOf(crPerPd02zh.getPd02zd01());
			 values[i][3] =  String.valueOf(crPerPd02zh.getPd02zq01()) == "null" ? "": String.valueOf(crPerPd02zh.getPd02zq01());
			 values[i][4] =  String.valueOf(crPerPd02zh.getPd02zr01()) == "null" ? "": String.valueOf(crPerPd02zh.getPd02zr01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		    sheet.autoSizeColumn((short) 0   );
		    sheet.autoSizeColumn((short) 1   );
			sheet.autoSizeColumn((short) 2   );
			sheet.autoSizeColumn((short) 3   );
			sheet.autoSizeColumn((short) 4   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPcrExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-相关还款责任信息";
		// 标题
		String[] title = new String[] {"序号                 " ,
				"序号                 " ,
				"主借款人身份类别     " ,
				"业务管理机构类型     " ,
				"业务管理机构         " ,
				"业务种类             " ,
				"开立日期             " ,
				"到期日期             " ,
				"相关还款责任人类型   " ,
				"保证合同编号         " ,
				"相关还款责任金额     " ,
				"币种                 " ,
				"余额                 " ,
				"五级分类             " ,
				"账户类型             " ,
				"还款状态             " ,
				"逾期月数             " ,
				"信息报告日期         " ,
				"标注及声明个数       "};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PCR.xlsx";
		
		try {
			List<CrPerPcr> crPerPcrlist = BaseDAOUtils.getCrPerPcrDAO().findByIdProperties(id);
			createCrPerPcrExcel(response,sheetName,title,fileName,crPerPcrlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPcrExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPcr> crPerPcrlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPcrlist.size()][];
		for (int i = 0; i < crPerPcrlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPcr crPerPcr = crPerPcrlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPcr.getId()) ==  "null" ? "": String.valueOf(crPerPcr.getId());
			 values[i][1] =  String.valueOf(crPerPcr.getBatchId()) ==  "null" ? "":  String.valueOf(crPerPcr.getBatchId());
			 values[i][2] =  String.valueOf(crPerPcr.getPd03ad08()) == "null" ? "": String.valueOf(crPerPcr.getPd03ad08());
			 values[i][3] =  String.valueOf(crPerPcr.getPd03ad01()) == "null" ? "": String.valueOf(crPerPcr.getPd03ad01());
			 values[i][4] =  String.valueOf(crPerPcr.getPd03aq01()) == "null" ? "": String.valueOf(crPerPcr.getPd03aq01());
			 values[i][5] =  String.valueOf(crPerPcr.getPd03ad02()) == "null" ? "": String.valueOf(crPerPcr.getPd03ad02());
			 values[i][6] =  String.valueOf(crPerPcr.getPd03ar01()) ==  "null" ? "":String.valueOf(crPerPcr.getPd03ar01());
			 values[i][7] =  String.valueOf(crPerPcr.getPd03ar02()) == "null" ? "": String.valueOf(crPerPcr.getPd03ar02());
			 values[i][8] =  String.valueOf(crPerPcr.getPd03ad03()) == "null" ? "": String.valueOf(crPerPcr.getPd03ad03());
			 values[i][9] =  String.valueOf(crPerPcr.getPd03aq02()) == "null" ? "": String.valueOf(crPerPcr.getPd03aq02());
			 values[i][10] = String.valueOf(crPerPcr.getPd03aj01()) == "null" ? "": String.valueOf(crPerPcr.getPd03aj01());
			 values[i][11] = String.valueOf(crPerPcr.getPd03ad04()) == "null" ? "": String.valueOf(crPerPcr.getPd03ad04());
			 values[i][12] = String.valueOf(crPerPcr.getPd03aj02()) == "null" ? "": String.valueOf(crPerPcr.getPd03aj02());
			 values[i][13] = String.valueOf(crPerPcr.getPd03ad05()) == "null" ? "": String.valueOf(crPerPcr.getPd03ad05());
			 values[i][14] = String.valueOf(crPerPcr.getPd03ad06()) == "null" ? "": String.valueOf(crPerPcr.getPd03ad06());
			 values[i][15] = String.valueOf(crPerPcr.getPd03ad07()) == "null" ? "": String.valueOf(crPerPcr.getPd03ad07());
			 values[i][16] = String.valueOf(crPerPcr.getPd03as01()) == "null" ? "": String.valueOf(crPerPcr.getPd03as01());
			 values[i][17] = String.valueOf(crPerPcr.getPd03ar03()) == "null" ? "": String.valueOf(crPerPcr.getPd03ar03());
			 values[i][18] = String.valueOf(crPerPcr.getPd03zs01()) == "null" ? "": String.valueOf(crPerPcr.getPd03zs01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
        sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		sheet.autoSizeColumn((short) 5   ) ;
		sheet.autoSizeColumn((short) 6   );
		sheet.autoSizeColumn((short) 7   );
		sheet.autoSizeColumn((short) 8   );
		sheet.autoSizeColumn((short) 9   );
		sheet.autoSizeColumn((short) 10  );
		sheet.autoSizeColumn((short) 11  );
		sheet.autoSizeColumn((short) 12  );
		sheet.autoSizeColumn((short) 13  ) ;
		sheet.autoSizeColumn((short) 14  );
		sheet.autoSizeColumn((short) 15  );
		sheet.autoSizeColumn((short) 16  );
		sheet.autoSizeColumn((short) 17  );
		sheet.autoSizeColumn((short) 18  );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	
	public void excelCrPerPd03zhExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-相关还款责任信息-标注及声明信息段-标注及声明信息";
		// 标题
		String[] title = new String[] {"序号                 " ,
				"序号                 " ,
				"标注及声明类型    " ,
				"标注或声明内容     " ,
				"添加日期         " 
			};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PD03ZH.xlsx";
		
		try {
			List<CrPerPd03zh> crPerPd03zhlist = BaseDAOUtils.getCrPerPd03zhDAO().findByIdProperties(id);
			createCrPerPd03zhExcel(response,sheetName,title,fileName,crPerPd03zhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPd03zhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPd03zh> crPerPd03zhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPd03zhlist.size()][];
		for (int i = 0; i < crPerPd03zhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPd03zh crPerPd03zh = crPerPd03zhlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPd03zh.getId()) ==  "null" ? "": String.valueOf(crPerPd03zh.getId());
			 values[i][1] =  String.valueOf(crPerPd03zh.getBatchId()) ==  "null" ? "":  String.valueOf(crPerPd03zh.getBatchId());
			 values[i][2] =  String.valueOf(crPerPd03zh.getPd03zd01()) == "null" ? "": String.valueOf(crPerPd03zh.getPd03zd01());
			 values[i][3] =  String.valueOf(crPerPd03zh.getPd03zq01()) == "null" ? "": String.valueOf(crPerPd03zh.getPd03zq01());
			 values[i][4] =  String.valueOf(crPerPd03zh.getPd03zr01()) == "null" ? "": String.valueOf(crPerPd03zh.getPd03zr01());
			
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
        sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	
	public void excelCrPerPcoExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-信贷交易信息概要信息";
		// 标题
		String[] title = new String[] {                                           
				"序号                                       " ,
				"序号                                       " ,
				"信贷交易提示信息账户数合计                 " ,
				"信贷交易提示信息业务类型数量               " ,
				"被追偿汇总信息账户数合计                   " ,
				"被追偿汇总信息余额合计                     " ,
				"被追偿汇总信息业务类型数量                 " ,
				"呆账汇总信息账户数                         " ,
				"呆账汇总信息余额                           " ,
				"逾期（透支）汇总信息账户类型数量           " ,
				"非循环贷账户管理机构数                     " ,
				"非循环贷账户账户数                         " ,
				"非循环贷账户授信总额                       " ,
				"非循环贷账户贷余额                         " ,
				"非循环贷账户最近 6 个月平均应还款          " ,
				"循环额度下分账户管理机构数                 " ,
				"循环额度下分账户账户数                     " ,
				"循环额度下分账户授信总额                   " ,
				"循环额度下分账户余额                       " ,
				"循环额度下分账户最近 6 个月平均应还款      " ,
				"循环贷账户管理机构数                       " ,
				"循环贷账户账户数                           " ,
				"循环贷账户授信总额                         " ,
				"循环贷账户余额                             " ,
				"循环贷账户最近6 个月平均应还款             " ,
				"贷记卡账户发卡机构数                       " ,
				"贷记卡账户账户数                           " ,
				"贷记卡账户授信总额                         " ,
				"贷记卡账户单家行最高授信额                 " ,
				"贷记卡账户单家行最低授信额                 " ,
				"贷记卡账户已用额度                         " ,
				"贷记卡账户最近 6 个月平均使用额度          " ,
				"准贷记卡账户发卡机构数                     " ,
				"准贷记卡账户账户数                         " ,
				"准贷记卡账户授信总额                       " ,
				"准贷记卡账户单家行最高授信额               " ,
				"准贷记卡账户单家行最低授信额               " ,
				"准贷记卡账户透支余额                       " ,
				"准贷记卡账户最近 6 个月平均透支余额        " ,
				"相关还款责任个数                           "};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PCO.xlsx";
		
		try {
			List<CrPerPco> crPerPcolist = BaseDAOUtils.getCrPerPcoDAO().findByIdProperties(id);
			createCrPerPcoExcel(response,sheetName,title,fileName,crPerPcolist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPcoExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPco> crPerPcolist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPcolist.size()][];
		for (int i = 0; i < crPerPcolist.size(); i++){
			  values[i] = new String[title.length];
			  CrPerPco crPerPco = crPerPcolist.get(i);
			// 将对象内容转换成string
			  values[i][0] =  String.valueOf(crPerPco.getId()) ==  "null" ? "": String.valueOf(crPerPco.getId());
			  values[i][1 ] =  String.valueOf(crPerPco.getBatchId())==  "null" ? "":  String.valueOf(crPerPco.getBatchId());
			  values[i][2 ] =  String.valueOf(crPerPco.getPc02as01()) == "null" ? "": String.valueOf(crPerPco.getPc02as01());
			  values[i][3 ] =  String.valueOf(crPerPco.getPc02as02()) == "null" ? "": String.valueOf(crPerPco.getPc02as02());
			  values[i][4 ] =  String.valueOf(crPerPco.getPc02bs01()) == "null" ? "": String.valueOf(crPerPco.getPc02bs01());
			  values[i][5 ] =  String.valueOf(crPerPco.getPc02bj01()) == "null" ? "": String.valueOf(crPerPco.getPc02bj01());
			  values[i][6 ] =  String.valueOf(crPerPco.getPc02bs02()) == "null" ? "": String.valueOf(crPerPco.getPc02bs02());
			  values[i][7 ] =  String.valueOf(crPerPco.getPc02cs01()) == "null" ? "": String.valueOf(crPerPco.getPc02cs01());
			  values[i][8 ] =  String.valueOf(crPerPco.getPc02cj01()) ==  "null" ? "":String.valueOf(crPerPco.getPc02cj01());
			  values[i][9 ] =  String.valueOf(crPerPco.getPc02ds01()) == "null" ? "": String.valueOf(crPerPco.getPc02ds01());
			  values[i][10] =  String.valueOf(crPerPco.getPc02es01()) == "null" ? "": String.valueOf(crPerPco.getPc02es01());
			  values[i][11] =  String.valueOf(crPerPco.getPc02es02()) == "null" ? "": String.valueOf(crPerPco.getPc02es02());
			  values[i][12] =  String.valueOf(crPerPco.getPc02ej01()) == "null" ? "": String.valueOf(crPerPco.getPc02ej01());
			  values[i][13] =  String.valueOf(crPerPco.getPc02ej02()) == "null" ? "": String.valueOf(crPerPco.getPc02ej02());
			  values[i][14] =  String.valueOf(crPerPco.getPc02ej03()) == "null" ? "": String.valueOf(crPerPco.getPc02ej03());
			  values[i][15] =  String.valueOf(crPerPco.getPc02fs01()) ==  "null" ? "":String.valueOf(crPerPco.getPc02fs01());
			  values[i][16] =  String.valueOf(crPerPco.getPc02fs02()) == "null" ? "": String.valueOf(crPerPco.getPc02fs02());
			  values[i][17] =  String.valueOf(crPerPco.getPc02fj01()) == "null" ? "": String.valueOf(crPerPco.getPc02fj01());
			  values[i][18] =  String.valueOf(crPerPco.getPc02fj02()) == "null" ? "": String.valueOf(crPerPco.getPc02fj02());
			  values[i][19] =  String.valueOf(crPerPco.getPc02fj03()) == "null" ? "": String.valueOf(crPerPco.getPc02fj03());
			  values[i][20] =  String.valueOf(crPerPco.getPc02gs01()) == "null" ? "": String.valueOf(crPerPco.getPc02gs01());
			  values[i][21] =  String.valueOf(crPerPco.getPc02gs02()) == "null" ? "": String.valueOf(crPerPco.getPc02gs02());
			  values[i][22] =  String.valueOf(crPerPco.getPc02gj01()) ==  "null" ? "":String.valueOf(crPerPco.getPc02gj01());
			  values[i][23] =  String.valueOf(crPerPco.getPc02gj02()) == "null" ? "": String.valueOf(crPerPco.getPc02gj02());
			  values[i][24] =  String.valueOf(crPerPco.getPc02gj03()) == "null" ? "": String.valueOf(crPerPco.getPc02gj03());
			  values[i][25] =  String.valueOf(crPerPco.getPc02hs01()) == "null" ? "": String.valueOf(crPerPco.getPc02hs01());
			  values[i][26] =  String.valueOf(crPerPco.getPc02hs02()) == "null" ? "": String.valueOf(crPerPco.getPc02hs02());
			  values[i][27] =  String.valueOf(crPerPco.getPc02hj01()) == "null" ? "": String.valueOf(crPerPco.getPc02hj01());
			  values[i][28] =  String.valueOf(crPerPco.getPc02hj02()) == "null" ? "": String.valueOf(crPerPco.getPc02hj02());
			  values[i][29] =  String.valueOf(crPerPco.getPc02hj03()) ==  "null" ? "":String.valueOf(crPerPco.getPc02hj03());
			  values[i][30] =  String.valueOf(crPerPco.getPc02hj04()) == "null" ? "": String.valueOf(crPerPco.getPc02hj04());
			  values[i][31] =  String.valueOf(crPerPco.getPc02hj05()) == "null" ? "": String.valueOf(crPerPco.getPc02hj05());
			  values[i][32] =  String.valueOf(crPerPco.getPc02is01()) == "null" ? "": String.valueOf(crPerPco.getPc02is01());
			  values[i][33] =  String.valueOf(crPerPco.getPc02is02()) == "null" ? "": String.valueOf(crPerPco.getPc02is02());
			  values[i][34] =  String.valueOf(crPerPco.getPc02ij01()) == "null" ? "": String.valueOf(crPerPco.getPc02ij01());
			  values[i][35] =  String.valueOf(crPerPco.getPc02ij02()) == "null" ? "": String.valueOf(crPerPco.getPc02ij02());
			  values[i][36] =  String.valueOf(crPerPco.getPc02ij03()) ==  "null" ? "":String.valueOf(crPerPco.getPc02ij03());
			  values[i][37] =  String.valueOf(crPerPco.getPc02ij04()) == "null" ? "": String.valueOf(crPerPco.getPc02ij04());
			  values[i][38] =  String.valueOf(crPerPco.getPc02ij05()) == "null" ? "": String.valueOf(crPerPco.getPc02ij05());
			  values[i][39] =  String.valueOf(crPerPco.getPc02ks01()) == "null" ? "": String.valueOf(crPerPco.getPc02ks01());
			
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应

        sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		sheet.autoSizeColumn((short) 5   ) ;
		sheet.autoSizeColumn((short) 6   );
		sheet.autoSizeColumn((short) 7   );
		sheet.autoSizeColumn((short) 8   );
		sheet.autoSizeColumn((short) 9   );
		sheet.autoSizeColumn((short) 10  );
		sheet.autoSizeColumn((short) 11  );
		sheet.autoSizeColumn((short) 12  );
		sheet.autoSizeColumn((short) 13  ) ;
		sheet.autoSizeColumn((short) 14  );
		sheet.autoSizeColumn((short) 15  );
		sheet.autoSizeColumn((short) 16  );
		sheet.autoSizeColumn((short) 17  );
		sheet.autoSizeColumn((short) 18  );
		sheet.autoSizeColumn((short) 19  );
		sheet.autoSizeColumn((short) 20  );
		sheet.autoSizeColumn((short) 21  ) ;
		sheet.autoSizeColumn((short) 22  );
		sheet.autoSizeColumn((short) 23  );
		sheet.autoSizeColumn((short) 24  );
		sheet.autoSizeColumn((short) 25  );
		sheet.autoSizeColumn((short) 26  );
		sheet.autoSizeColumn((short) 27  );
		sheet.autoSizeColumn((short) 28  );
		sheet.autoSizeColumn((short) 29  ) ;
		sheet.autoSizeColumn((short) 30  );
		sheet.autoSizeColumn((short) 31  );
		sheet.autoSizeColumn((short) 32  );
		sheet.autoSizeColumn((short) 33  );
		sheet.autoSizeColumn((short) 34  );
		sheet.autoSizeColumn((short) 35  );
		sheet.autoSizeColumn((short) 36  );
		sheet.autoSizeColumn((short) 37  ) ;
		sheet.autoSizeColumn((short) 38  );
		sheet.autoSizeColumn((short) 39  );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPc02bhExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-欠税记录";
		// 标题
		String[] title = new String[] {"序号               " ,
				"序号               " ,
				"业务类型           " ,
				"账户数           " ,
				"余额         " 
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PC02BH.xlsx";
		
		try {
			List<CrPerPc02bh> crPerPc02bhlist = BaseDAOUtils.getCrPerPc02bhDAO().findByIdProperties(id);
			createCrPerPc02bhExcel(response,sheetName,title,fileName,crPerPc02bhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPc02bhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPc02bh> crPerPc02bhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPc02bhlist.size()][];
		for (int i = 0; i < crPerPc02bhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPc02bh crPerPc02bh = crPerPc02bhlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPc02bh.getId()) ==  "null" ? "": String.valueOf(crPerPc02bh.getId());
			 values[i][1] =  String.valueOf(crPerPc02bh.getBatchId()) ==  "null" ? "":  String.valueOf(crPerPc02bh.getBatchId());
			 values[i][2] =  String.valueOf(crPerPc02bh.getPc02bd01()) == "null" ? "": String.valueOf(crPerPc02bh.getPc02bd01());
			 values[i][3] =  String.valueOf(crPerPc02bh.getPc02bs03()) == "null" ? "": String.valueOf(crPerPc02bh.getPc02bs03());
			 values[i][4] =  String.valueOf(crPerPc02bh.getPc02bj02()) == "null" ? "": String.valueOf(crPerPc02bh.getPc02bj02());
			
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
        sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPc02khExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-信贷交易信息概要信息-相关还款责任汇总信息段-相关还款责任汇总信息";
		// 标题
		String[] title = new String[] {"序号               " ,
				"序号               " ,
				"借款人身份类别          " ,
				"还款责任类型           " ,
				"账户数        " ,
				"还款责任金额",
				"余额"
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PC02KH.xlsx";
		
		try {
			List<CrPerPc02kh> crPerPc02khlist = BaseDAOUtils.getCrPerPc02khDAO().findByIdProperties(id);
			createCrPerPc02khExcel(response,sheetName,title,fileName,crPerPc02khlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPc02khExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPc02kh> crPerPc02khlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPc02khlist.size()][];
		for (int i = 0; i < crPerPc02khlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPc02kh crPerPc02kh = crPerPc02khlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPc02kh.getId()) ==  "null" ? "": String.valueOf(crPerPc02kh.getId());
			 values[i][1] =  String.valueOf(crPerPc02kh.getBatchId()) ==  "null" ? "":  String.valueOf(crPerPc02kh.getBatchId());
			 values[i][2] =  String.valueOf(crPerPc02kh.getPc02kd01()) == "null" ? "": String.valueOf(crPerPc02kh.getPc02kd01());
			 values[i][3] =  String.valueOf(crPerPc02kh.getPc02kd02()) == "null" ? "": String.valueOf(crPerPc02kh.getPc02kd02());
			 values[i][4] =  String.valueOf(crPerPc02kh.getPc02ks02()) == "null" ? "": String.valueOf(crPerPc02kh.getPc02ks02());
			 values[i][5] =  String.valueOf(crPerPc02kh.getPc02kj01()) == "null" ? "": String.valueOf(crPerPc02kh.getPc02kj01());
			 values[i][6] =  String.valueOf(crPerPc02kh.getPc02kj02()) == "null" ? "": String.valueOf(crPerPc02kh.getPc02kj02());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
        sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		sheet.autoSizeColumn((short) 5   );
		sheet.autoSizeColumn((short) 6   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPc02ahExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-信贷交易信息概要信息-信贷交易提示信息段-信贷交易提示信息";
		// 标题
		String[] title = new String[] {"序号               " ,
				"序号               " ,
				"业务类型          " ,
				"业务大类           " ,
				"账户数        " ,
				"首笔业务发放月份"
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PC02AH.xlsx";
		
		try {
			List<CrPerPc02ah> crPerPc02ahlist = BaseDAOUtils.getCrPerPc02ahDAO().findByIdProperties(id);
			createCrPerPc02ahExcel(response,sheetName,title,fileName,crPerPc02ahlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPc02ahExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPc02ah> crPerPc02ahlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPc02ahlist.size()][];
		for (int i = 0; i < crPerPc02ahlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPc02ah crPerPc02ah = crPerPc02ahlist.get(i);
			// 将对象内容转换成string
			 values[i][0] =  String.valueOf(crPerPc02ah.getId()) ==  "null" ? "": String.valueOf(crPerPc02ah.getId());
			 values[i][1] =  String.valueOf(crPerPc02ah.getBatchId()) ==  "null" ? "":  String.valueOf(crPerPc02ah.getBatchId());
			 values[i][2] =  String.valueOf(crPerPc02ah.getPc02ad01()) == "null" ? "": String.valueOf(crPerPc02ah.getPc02ad01());
			 values[i][3] =  String.valueOf(crPerPc02ah.getPc02ad02()) == "null" ? "": String.valueOf(crPerPc02ah.getPc02ad02());
			 values[i][4] =  String.valueOf(crPerPc02ah.getPc02as03()) == "null" ? "": String.valueOf(crPerPc02ah.getPc02as03());
			 values[i][5] =  String.valueOf(crPerPc02ah.getPc02ar01()) == "null" ? "": String.valueOf(crPerPc02ah.getPc02ar01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
        sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		sheet.autoSizeColumn((short) 5   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPc02dhExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-信贷交易信息概要信息-逾期（透支）汇总信息段-逾期（透支）汇总信息";
		// 标题
		String[] title = new String[] {"序号                       " ,
				"序号                       " ,
				"账户类型                   " ,
				"账户数                     " ,
				"月份数                     " ,
				"单月最高逾期（透支）总额   " ,
				"最长逾期（透支）月数       " };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PC02DH.xlsx";
		
		try {
			List<CrPerPc02dh> crPerPc02dhlist = BaseDAOUtils.getCrPerPc02dhDAO().findByIdProperties(id);
			createCrPerPc02dhExcel(response,sheetName,title,fileName,crPerPc02dhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPc02dhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPc02dh> crPerPc02dhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPc02dhlist.size()][];
		for (int i = 0; i < crPerPc02dhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPc02dh crPerPc02dh = crPerPc02dhlist.get(i);
			// 将对象内容转换成string
			  values[i][0] =  String.valueOf(crPerPc02dh.getId()) ==  "null" ? "": String.valueOf(crPerPc02dh.getId());
			  values[i][1 ] =  String.valueOf(crPerPc02dh.getBatchId()) ==  "null" ? "":   String.valueOf(crPerPc02dh.getBatchId());
			  values[i][2 ] =  String.valueOf(crPerPc02dh.getPc02dd01()) == "null" ? "": String.valueOf(crPerPc02dh.getPc02dd01());
			  values[i][3 ] =  String.valueOf(crPerPc02dh.getPc02ds02()) == "null" ? "": String.valueOf(crPerPc02dh.getPc02ds02());
			  values[i][4 ] =  String.valueOf(crPerPc02dh.getPc02ds03()) == "null" ? "": String.valueOf(crPerPc02dh.getPc02ds03());
			  values[i][5 ] =  String.valueOf(crPerPc02dh.getPc02dj01()) == "null" ? "": String.valueOf(crPerPc02dh.getPc02dj01());
			  values[i][6 ] =  String.valueOf(crPerPc02dh.getPc02ds04()) == "null" ? "": String.valueOf(crPerPc02dh.getPc02ds04());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
        sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		sheet.autoSizeColumn((short) 5   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPpqExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-执业资格记录";
		// 标题
		String[] title = new String[] {"序号           " ,
				"序号           " ,
				"执业资格名称   " ,
				"颁发机构       " ,
				"等级           " ,
				"机构所在地     " ,
				"获得年月       " ,
				"到期年月       " ,
				"吊销年月       " ,
				"标注及声明个数 " };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PPQ.xlsx";
		
		try {
			List<CrPerPpq> crPerPpqlist = BaseDAOUtils.getCrPerPpqDAO().findByIdProperties(id);
			createCrPerPpqExcel(response,sheetName,title,fileName,crPerPpqlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPpqExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPpq> crPerPpqlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPpqlist.size()][];
		for (int i = 0; i < crPerPpqlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPpq crPerPpq = crPerPpqlist.get(i);
			// 将对象内容转换成string
			  values[i][0 ] =  String.valueOf(crPerPpq.getId()) ==  "null" ? "": String.valueOf(crPerPpq.getId()); 
			  values[i][1 ] =  String.valueOf(crPerPpq.getBatchId()) ==  "null" ? "": String.valueOf(crPerPpq.getBatchId());
			  values[i][2 ] =  String.valueOf(crPerPpq.getPf07aq01()) == "null" ? "": String.valueOf(crPerPpq.getPf07aq01());
			  values[i][3 ] =  String.valueOf(crPerPpq.getPf07aq02()) == "null" ? "": String.valueOf(crPerPpq.getPf07aq02());
			  values[i][4 ] =  String.valueOf(crPerPpq.getPf07ad01()) == "null" ? "": String.valueOf(crPerPpq.getPf07ad01());
			  values[i][5 ] =  String.valueOf(crPerPpq.getPf07ad02()) == "null" ? "": String.valueOf(crPerPpq.getPf07ad02());
			  values[i][6 ] =  String.valueOf(crPerPpq.getPf07ar01()) == "null" ? "": String.valueOf(crPerPpq.getPf07ar01());
			  values[i][7 ] =  String.valueOf(crPerPpq.getPf07ar02()) == "null" ? "": String.valueOf(crPerPpq.getPf07ar02());
			  values[i][8 ] =  String.valueOf(crPerPpq.getPf07ar03()) ==  "null" ? "":String.valueOf(crPerPpq.getPf07ar03());
			  values[i][9 ] =  String.valueOf(crPerPpq.getPf07zs01()) == "null" ? "": String.valueOf(crPerPpq.getPf07zs01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
        sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		sheet.autoSizeColumn((short) 5   );
		sheet.autoSizeColumn((short) 6   );
		sheet.autoSizeColumn((short) 7   );
		sheet.autoSizeColumn((short) 8   );
		sheet.autoSizeColumn((short) 9   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPf07zhExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-执业资格记录-标注及声明信息段-标注及声明信息";
		// 标题
		String[] title = new String[] {"序号           " ,
				"序号           " ,
				"标注及声明类型   " ,
				"标注或声明内容       " ,
				"添加日期           " 
				};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PF07ZH.xlsx";
		
		try {
			List<CrPerPf07zh> crPerPf07zhlist = BaseDAOUtils.getCrPerPf07zhDAO().findByIdProperties(id);
			createCrPerPf07zhExcel(response,sheetName,title,fileName,crPerPf07zhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPf07zhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPf07zh> crPerPf07zhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPf07zhlist.size()][];
		for (int i = 0; i < crPerPf07zhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPf07zh crPerPf07zh = crPerPf07zhlist.get(i);
			// 将对象内容转换成string
			  values[i][0 ] =  String.valueOf(crPerPf07zh.getId()) ==  "null" ? "": String.valueOf(crPerPf07zh.getId()); 
			  values[i][1 ] =  String.valueOf(crPerPf07zh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPf07zh.getBatchId());
			  values[i][2 ] =  String.valueOf(crPerPf07zh.getPf07zd01()) == "null" ? "": String.valueOf(crPerPf07zh.getPf07zd01());
			  values[i][3 ] =  String.valueOf(crPerPf07zh.getPf07zq01()) == "null" ? "": String.valueOf(crPerPf07zh.getPf07zq01());
			  values[i][4 ] =  String.valueOf(crPerPf07zh.getPf07zr01()) == "null" ? "": String.valueOf(crPerPf07zh.getPf07zr01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
        sheet.autoSizeColumn((short) 0   );
	    sheet.autoSizeColumn((short) 1   );
		sheet.autoSizeColumn((short) 2   );
		sheet.autoSizeColumn((short) 3   );
		sheet.autoSizeColumn((short) 4   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPomExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-职业信息";
		// 标题
		String[] title = new String[] { 
				"序号",
				"序号           " ,
				"就业状况       " ,
				"工作单位       " ,
				"单位性质       " ,
				"行业           " ,
				"单位地址       " ,
				"单位电话       " ,
				"职业           " ,
				"职务           " ,
				"职称           " ,
				"进入本单位年份 " ,
				"信息更新日期   " };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_POM.xlsx";
		
		try {
			List<CrPerPom> crPerPomlist = BaseDAOUtils.getCrPerPomDAO().findByIdProperties(id);
			createCrPerPomExcel(response,sheetName,title,fileName,crPerPomlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void createCrPerPomExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPom> crPerPomlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPomlist.size()][];
		for (int i = 0; i < crPerPomlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPom crPerPom = crPerPomlist.get(i);
			// 将对象内容转换成string
			  values[i][0 ] =  String.valueOf(crPerPom.getId()) ==  "null" ? "": String.valueOf(crPerPom.getId()); 
			  values[i][1 ] =  String.valueOf(crPerPom.getBatchId()) ==  "null" ? "": String.valueOf(crPerPom.getBatchId());
			  values[i][2 ] =  String.valueOf(crPerPom.getPb040d01()) == "null" ? "": String.valueOf(crPerPom.getPb040d01());
			  values[i][3 ] =  String.valueOf(crPerPom.getPb040q01()) == "null" ? "": String.valueOf(crPerPom.getPb040q01());
			  values[i][4 ] =  String.valueOf(crPerPom.getPb040d02()) == "null" ? "": String.valueOf(crPerPom.getPb040d02());
			  values[i][5 ] =  String.valueOf(crPerPom.getPb040d03()) == "null" ? "": String.valueOf(crPerPom.getPb040d03());
			  values[i][6 ] =  String.valueOf(crPerPom.getPb040q02()) == "null" ? "": String.valueOf(crPerPom.getPb040q02());
			  values[i][7 ] =  String.valueOf(crPerPom.getPb040q03()) == "null" ? "": String.valueOf(crPerPom.getPb040q03());
			  values[i][8 ] =  String.valueOf(crPerPom.getPb040d04()) ==  "null" ? "":String.valueOf(crPerPom.getPb040d04());
			  values[i][9 ] =  String.valueOf(crPerPom.getPb040d05()) == "null" ? "": String.valueOf(crPerPom.getPb040d05());
			  values[i][10] =  String.valueOf(crPerPom.getPb040d06()) == "null" ? "": String.valueOf(crPerPom.getPb040d06());
			  values[i][11] =  String.valueOf(crPerPom.getPb040r01()) == "null" ? "": String.valueOf(crPerPom.getPb040r01());
			  values[i][12] =  String.valueOf(crPerPom.getPb040r02())== "null" ? "": String.valueOf(crPerPom.getPb040r02());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		    sheet.autoSizeColumn((short) 0   );
		    sheet.autoSizeColumn((short) 1   );
			sheet.autoSizeColumn((short) 2   );
			sheet.autoSizeColumn((short) 3   );
			sheet.autoSizeColumn((short) 4   );
			sheet.autoSizeColumn((short) 5   ) ;
			sheet.autoSizeColumn((short) 6   );
			sheet.autoSizeColumn((short) 7   );
			sheet.autoSizeColumn((short) 8   );
			sheet.autoSizeColumn((short) 9   );
			sheet.autoSizeColumn((short) 10  );
			sheet.autoSizeColumn((short) 11  );
			sheet.autoSizeColumn((short) 12  );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPhfExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-住房公积金参缴记录";
		// 标题
		String[] title = new String[] {"序号           " ,  
				"序号           " ,
				"参缴地         " ,
				"参缴日期       " ,
				"缴费状态       " ,
				"初缴月份       " ,
				"缴至月份       " ,
				"单位缴存比例   " ,
				"个人缴存比例   " ,
				"月缴存额       " ,
				"缴费单位       " ,
				"信息更新日期   " ,
				"标注及声明个数 "};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PHF.xlsx";
		
		try {
			List<CrPerPhf> crPerPhflist = BaseDAOUtils.getCrPerPhfDAO().findByIdProperties(id);
			createCrPerPhfExcel(response,sheetName,title,fileName,crPerPhflist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPhfExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPhf> crPerPhflist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPhflist.size()][];
		for (int i = 0; i < crPerPhflist.size(); i++){
			 values[i] = new String[title.length];
			  CrPerPhf crPerPhf = crPerPhflist.get(i);
			// 将对象内容转换成string
			  values[i][1 ] =  String.valueOf(crPerPhf.getBatchId()) ==  "null" ? "": String.valueOf(crPerPhf.getBatchId());
			  values[i][2 ] =  String.valueOf(crPerPhf.getPf05aq01()) == "null" ? "": String.valueOf(crPerPhf.getPf05aq01());
			  values[i][3 ] =  String.valueOf(crPerPhf.getPf05ar01()) == "null" ? "": String.valueOf(crPerPhf.getPf05ar01());
			  values[i][4 ] =  String.valueOf(crPerPhf.getPf05ad01()) == "null" ? "": String.valueOf(crPerPhf.getPf05ad01());
			  values[i][5 ] =  String.valueOf(crPerPhf.getPf05ar02()) == "null" ? "": String.valueOf(crPerPhf.getPf05ar02());
			  values[i][6 ] =  String.valueOf(crPerPhf.getPf05ar03()) == "null" ? "": String.valueOf(crPerPhf.getPf05ar03());
			  values[i][7 ] =  String.valueOf(crPerPhf.getPf05aq02()) == "null" ? "": String.valueOf(crPerPhf.getPf05aq02());
			  values[i][8 ] =  String.valueOf(crPerPhf.getPf05aq03()) ==  "null" ? "":String.valueOf(crPerPhf.getPf05aq03());
			  values[i][9 ] =  String.valueOf(crPerPhf.getPf05aj01()) == "null" ? "": String.valueOf(crPerPhf.getPf05aj01());
			  values[i][10] =  String.valueOf(crPerPhf.getPf05aq04()) == "null" ? "": String.valueOf(crPerPhf.getPf05aq04());
			  values[i][11] =  String.valueOf(crPerPhf.getPf05ar04()) == "null" ? "": String.valueOf(crPerPhf.getPf05ar04());
			  values[i][12] =  String.valueOf(crPerPhf.getPf05zs01()) == "null" ? "": String.valueOf(crPerPhf.getPf05zs01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		    sheet.autoSizeColumn((short) 0   );
		    sheet.autoSizeColumn((short) 1   );
			sheet.autoSizeColumn((short) 2   );
			sheet.autoSizeColumn((short) 3   );
			sheet.autoSizeColumn((short) 4   );
			sheet.autoSizeColumn((short) 5   ) ;
			sheet.autoSizeColumn((short) 6   );
			sheet.autoSizeColumn((short) 7   );
			sheet.autoSizeColumn((short) 8   );
			sheet.autoSizeColumn((short) 9   );
			sheet.autoSizeColumn((short) 10  );
			sheet.autoSizeColumn((short) 11  );
			sheet.autoSizeColumn((short) 12  );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrPerPf05zhExcel(HttpServletResponse response,String id) throws IOException{
		// sheet名
		String sheetName = "征信查询个人征信结果-住房公积金参缴记录-标注及声明信息段-标注及声明信息";
		// 标题
		String[] title = new String[] {"序号           " ,  
				"序号           " ,
				"标注及声明类型         " ,
				"标注或声明内容       " ,
				"添加日期       " 
			};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = "CR_PER_PF05ZH.xlsx";
		
		try {
			List<CrPerPf05zh> crPerPf05zhlist = BaseDAOUtils.getCrPerPf05zhDAO().findByIdProperties(id);
			createCrPerPf05zhExcel(response,sheetName,title,fileName,crPerPf05zhlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrPerPf05zhExcel(HttpServletResponse response, String sheetName, String title[], String fileName,
			List<CrPerPf05zh> crPerPf05zhlist) {
		logger.info("start create excel-->");
		String[][] values = new String[crPerPf05zhlist.size()][];
		for (int i = 0; i < crPerPf05zhlist.size(); i++){
			 values[i] = new String[title.length];
			 CrPerPf05zh crPerPf05zh = crPerPf05zhlist.get(i);
			// 将对象内容转换成string
			  values[i][0 ] =  String.valueOf(crPerPf05zh.getId()) ==  "null" ? "": String.valueOf(crPerPf05zh.getId());
			  values[i][1 ] =  String.valueOf(crPerPf05zh.getBatchId()) ==  "null" ? "": String.valueOf(crPerPf05zh.getBatchId());
			  values[i][2 ] =  String.valueOf(crPerPf05zh.getPf05zd01()) == "null" ? "": String.valueOf(crPerPf05zh.getPf05zd01());
			  values[i][3 ] =  String.valueOf(crPerPf05zh.getPf05zq01()) == "null" ? "": String.valueOf(crPerPf05zh.getPf05zq01());
			  values[i][4 ] =  String.valueOf(crPerPf05zh.getPf05zr01()) == "null" ? "": String.valueOf(crPerPf05zh.getPf05zr01());
		 }
		// 第一步，创建一个webbook，对应一个Excel文件
		XSSFWorkbook wb = new XSSFWorkbook();
		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		XSSFSheet sheet = wb.createSheet(sheetName);
		sheet.setDefaultColumnWidth(20);
		sheet.setDefaultRowHeightInPoints(20);
		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
		XSSFRow row = sheet.createRow(0);
		// 设置字体
		XSSFFont font = wb.createFont();
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		// 第四步，创建单元格，并设置值表头 设置表头居中
		XSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(XSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
		style.setFont(font);

		XSSFCell cell = null;
		// 创建标题
		for (int i = 0; i <title.length;i++){
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		// 创建内容
		for (int i = 0; i < values.length; i++){
			row = sheet.createRow(i + 1);
			for (int j = 0; j < values[i].length; j++) {
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		// 设置列宽为自适应
		    sheet.autoSizeColumn((short) 0   );
		    sheet.autoSizeColumn((short) 1   );
			sheet.autoSizeColumn((short) 2   );
			sheet.autoSizeColumn((short) 3   );
			sheet.autoSizeColumn((short) 4   );
		try {
			this.exportExcel(response, fileName);OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	
	/**
	 * 导出EXCEL
	 * 
	 * @param response
	 * @param fileName
	 * @throws IOException
	 */
	public void exportExcel(HttpServletResponse response, String fileName) {
		try {
			String encoding = System.getProperty("file.encoding");
			logger.debug("系统编码格式默认格式为:" + encoding);
			response.setContentType("application/vnd.ms-excel;charset=" + encoding);
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, encoding));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
    	
 	/**     * 判断文件夹是否存在，如果不存在则新建     *      * @param dirPath 文件夹路径     */    
	private static void isChartPathExist(String dirPath) {        
		File file = new File(dirPath);       
		if (!file.exists()) {           
			file.mkdirs();       
			}    
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	

}
