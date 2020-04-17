package com.huateng.report.pboc.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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

import resource.bean.crms.CrComEa01ch;
import resource.bean.crms.CrComEaa;
import resource.bean.crms.CrComEb02ah;
import resource.bean.crms.CrComEb02bh;
import resource.bean.crms.CrComEb02ch;
import resource.bean.crms.CrComEb03ah;
import resource.bean.crms.CrComEb03bh;
import resource.bean.crms.CrComEb05ah;
import resource.bean.crms.CrComEb05bh;
import resource.bean.crms.CrComEba;
import resource.bean.crms.CrComEbb;
import resource.bean.crms.CrComEbc;
import resource.bean.crms.CrComEbd;
import resource.bean.crms.CrComEbe;
import resource.bean.crms.CrComEc020h;
import resource.bean.crms.CrComEc030h;
import resource.bean.crms.CrComEc050h;
import resource.bean.crms.CrComEca;
import resource.bean.crms.CrComEd01;
import resource.bean.crms.CrComEd01b;
import resource.bean.crms.CrComEd01bh;
import resource.bean.crms.CrComEd01c;
import resource.bean.crms.CrComEd01ch;
import resource.bean.crms.CrComEd02;
import resource.bean.crms.CrComEd03;
import resource.bean.crms.CrComEd04;
import resource.bean.crms.CrComEd04b;
import resource.bean.crms.CrComEd05;
import resource.bean.crms.CrComEd06;
import resource.bean.crms.CrComEd07;
import resource.bean.crms.CrComEd08;
import resource.bean.crms.CrComEd09;
import resource.bean.crms.CrComEda;
import resource.bean.crms.CrComEdb;
import resource.bean.crms.CrComEdc;
import resource.bean.crms.CrComEdd;
import resource.bean.crms.CrComEe01bh;
import resource.bean.crms.CrComEea;
import resource.bean.crms.CrComEf05bh;
import resource.bean.crms.CrComEfa;
import resource.bean.crms.CrComEfb;
import resource.bean.crms.CrComEfc;
import resource.bean.crms.CrComEfd;
import resource.bean.crms.CrComEfe;
import resource.bean.crms.CrComEff;
import resource.bean.crms.CrComEfg;
import resource.bean.crms.CrComEga;
import resource.bean.crms.CrComEha;
import resource.bean.crms.CrComEia;

@Service
public class DataExtractionWriteExcelService {

	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(DataExtractionWriteExcelService.class);

	public static DataExtractionWriteExcelService getInstance() {
		return ApplicationContextUtils.getBean(DataExtractionWriteExcelService.class);
	}

	
	public void excelCrComEaaWrite(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-报告头";
		// 标题
		String[] title = new String[] { "序号", "报告编号", "报告生成时间", "查询机构代码", "查询原因", "企业名称", "企业身份标识个数", "异议标注数目",
				"美元折人民币汇率", "汇率有效日期", "创建人", "创建时间", "审核人", "审核时间", "发送时间", "返回时间", "记录状态" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EAA.xlsx";
	/*	String[] ids = spritIds(id);
		CrComEaa crComEaa = new CrComEaa();
		crComEaa.setId(id);*/
		
		try {
			List<CrComEaa> crComEaaList = BaseDAOUtils.getCrComEaaDAO().findByIdProperties(id);
			createCrComEaaWrite(filepath,sheetName, title, fileName, crComEaaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 创建EXCEL
	 * 
	 * @param sheetName
	 * @param tirrle
	 * @param tcsUserExportList
	 */
	public void createCrComEaaWrite(String filepath,String sheetName, String title[], String fileName,
			List<CrComEaa> list) {
		logger.info("start create excel-->");
		String[][] values = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEaa crComEaa = list.get(i);
			values[i][0] = String.valueOf(crComEaa.getId()) == "null" ? "" : String.valueOf(crComEaa.getId());
			values[i][1] = String.valueOf(crComEaa.getEa01ai01()) == "null" ? ""
					: String.valueOf(crComEaa.getEa01ai01());
			values[i][2] = String.valueOf(crComEaa.getEa01ar01()) == "null" ? ""
					: String.valueOf(crComEaa.getEa01ar01());
			values[i][3] = String.valueOf(crComEaa.getEa01bi01()) == "null" ? ""
					: String.valueOf(crComEaa.getEa01bi01());
			values[i][4] = String.valueOf(crComEaa.getEa01bd02()) == "null" ? ""
					: String.valueOf(crComEaa.getEa01bd02());
			if ("01".equals(values[i][4])) {
				values[i][4] = "01-贷前（保前）审查";
			} else if ("02".equals(values[i][4])) {
				values[i][4] = "02-贷中操作";
			} else if ("03".equals(values[i][4])) {
				values[i][4] = "03-贷后（在保）管理";
			} else if ("04".equals(values[i][4])) {
				values[i][4] = "04-其他原因";
			} else if ("05".equals(values[i][4])) {
				values[i][4] = "05-关联查询";
			} else if ("17".equals(values[i][4])) {
				values[i][4] = "17-额度审批";
			} else if ("18".equals(values[i][4])) {
				values[i][4] = "18-担保审查";
			}
			values[i][5] = String.valueOf(crComEaa.getEa01cq01()) == "null" ? ""
					: String.valueOf(crComEaa.getEa01cq01());
			values[i][6] = String.valueOf(crComEaa.getEa01cs01()) == "null" ? ""
					: String.valueOf(crComEaa.getEa01cs01());
			values[i][7] = String.valueOf(crComEaa.getEa01ds01()) == "null" ? ""
					: String.valueOf(crComEaa.getEa01ds01());
			values[i][8] = String.valueOf(crComEaa.getEa01eq01()) == "null" ? ""
					: String.valueOf(crComEaa.getEa01eq01());
			values[i][9] = String.valueOf(crComEaa.getEa01er01()) == "null" ? ""
					: String.valueOf(crComEaa.getEa01er01());
			values[i][10] = String.valueOf(crComEaa.getCreateUser()) == "null" ? ""
					: String.valueOf(crComEaa.getCreateUser());
			values[i][11] = String.valueOf(crComEaa.getCreateTime()) == "null" ? ""
					: String.valueOf(crComEaa.getCreateTime());
			values[i][12] = String.valueOf(crComEaa.getCheckUser()) == "null" ? ""
					: String.valueOf(crComEaa.getCheckUser());
			values[i][13] = String.valueOf(crComEaa.getCheckTime()) == "null" ? ""
					: String.valueOf(crComEaa.getCheckTime());
			values[i][14] = String.valueOf(crComEaa.getSendTime()) == "null" ? ""
					: String.valueOf(crComEaa.getSendTime());
			values[i][15] = String.valueOf(crComEaa.getRespTime()) == "null" ? ""
					: String.valueOf(crComEaa.getRespTime());
			values[i][16] = String.valueOf(crComEaa.getStatus()) == "null" ? "" : String.valueOf(crComEaa.getStatus());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	

	public void excelCrComEa01ChExport(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-报告头-身份标识信息段-企业身份信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "企业身份标识类型", "企业身份标识号码" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EA01CH.xlsx";
		/*CrComEa01ch crComEa01ch = new CrComEa01ch();
		crComEa01ch.setBatchId(id);*/
		
		try {
			List<CrComEa01ch> crComEa01chList = BaseDAOUtils.getCrComEa01chDao().findByIdProperties(id);
			createCrComEa01ChExcel(filepath,sheetName, title, fileName, crComEa01chList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excelCrComEca(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-基本概况信息";
		// 标题
		String[] title = new String[] { "序号", "经济类型", "组织机构类型", "企业规模", "所属行业", "登记地址", "成立年份", "登记证书有效截止日期", "办公/经营地址",
				"存续状态", "注册资本（折人民币合计）", "主要出资人个数", "注册资本及主要出资人信息更新日期", "主要组成人员个数", "主要组成人员个数更新日期", "上级机构类型", "上级机构名称",
				"上级机构身份标识类型", "上级机构身份标识号码", "上级机构信息更新日期", "实际控制人个数", "实际控制人信息更新日期" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_ECA.xlsx";
	/*	CrComEca crComEca = new CrComEca();
		crComEca.setId(id);*/
		
		try {
			List<CrComEca> crComEcaList = BaseDAOUtils.getCrComEcaDAO().findByIdProperties(id);
			createCrComEcaExcel(filepath,sheetName, title, fileName, crComEcaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excelCrComEc02oh(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-注册资本及主要出资人信息-出资人信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "出资人类型", "出资人身份类别", "出资人名称", "出资人身份标识类型", "出资人身份标识号码", "出资比例" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EC020H.xlsx";
	/*	CrComEc020h crComEc020h = new CrComEc020h();
		crComEc020h.setBatchId(id);*/
		
		try {
			List<CrComEc020h> crComEc02OhList = BaseDAOUtils.getCrComEc020hDAO().findByIdProperties(id);
			createCrComEc02OhExcel(filepath, sheetName, title, fileName, crComEc02OhList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excelCrComEc03oh(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-主要组成人员信息-主要组成人员信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "姓名", "证件类型", "证件号码", "职位" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EC030H.xlsx";
		/*CrComEc030h crComEc030h = new CrComEc030h();
		crComEc030h.setBatchId(id);*/
		
		try {
			List<CrComEc030h> crComEc02OhList = BaseDAOUtils.getCrComEc030hDAO().findByIdProperties(id);
			createCrComEc03OhExcel(filepath, sheetName, title, fileName, crComEc02OhList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excelCrComEc05oh(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-实际控制人信息-实际控制人信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "实际控制人身份类型", "实际控制人名称", "实际控制人身份标识类型", "实际控制人身份标识号码" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EC050H.xlsx";
		CrComEc050h crComEc050h = new CrComEc050h();
		crComEc050h.setBatchId(id);
		
		try {
			List<CrComEc050h> crComEc02OhList = BaseDAOUtils.getCrComEc050hDAO().findByIdProperties(id);
			createCrComEc05OhExcel(filepath, sheetName, title, fileName, crComEc02OhList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excelCrComEba(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-信用提示信息";
		// 标题
		String[] title = new String[] { "序号", "首次有信贷交易的年份", "首次有相关还款责任的年份", "发生信贷交易的机构数", "当前有未结清 \r\n" + "信贷交易的机构数",
				"借贷交易余额", "被追偿的借贷交易余额", "关注类借贷交易余额", "不良类借贷交易余额", "担保交易余额", "关注类担保交易余额", "不良类担保交易余额", "非信贷交易账户数",
				"欠税记录条数", "民事判决记录条数", "强制执行记录条数", "行政处罚记录条数" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EBA.xlsx";
		/*CrComEba crComEba = new CrComEba();
		crComEba.setId(id);*/
		
		try {
			List<CrComEba> crComEbaList = BaseDAOUtils.getCrComEbaDAO().findByIdProperties(id);
			createCrComEbaExcel(filepath, sheetName, title, fileName, crComEbaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excelCrComEbb(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-借贷交易汇总信息";
		// 标题
		String[] title = new String[] { "序号", "未结清借贷交易汇总资产处置业务账户数", "未结清借贷交易汇总资产处置业务余额", "未结清借贷交易汇总最近一次处置日期",
				"未结清借贷交易汇总垫款业务账户数", "未结清借贷交易汇总垫款业务余额", "未结清借贷交易汇总垫款最近一次还款日期", "未结清借贷交易汇总逾期总额", "未结清借贷交易汇总逾期本金",
				"未结清借贷交易汇总逾期利息及其他", "未结清借贷交易汇总其他借贷交易分类 \r\n" + "汇总条目数量", "已结清借贷交易资产处置业务账户数", "已结清借贷交易资产处置业务金额",
				"已结清借贷交易处置完成日期", "已结清借贷交易结清日期", "已结清借贷交易垫款业务账户数", "已结清借贷交易垫款业务金额", "已结清借贷交易其他借贷交易分类 \r\n" + "汇总条目数量",
				"负债历史汇总月份数" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EBB.xlsx";
	/*	CrComEbb crComEbb = new CrComEbb();
		crComEbb.setId(id);*/
		
		try {
			List<CrComEbb> crComEbbList = BaseDAOUtils.getCrComEbbDAO().findByIdProperties(id);
			createCrComEbbExcel(filepath, sheetName, title, fileName, crComEbbList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excelCrComEb02ah(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-借贷交易汇总信息-未结清借贷交易汇总信息段-其他借贷交易分类汇总信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "业务类型", "资产质量分类", "账户数", "余额" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EBB.xlsx";
	/*	CrComEb02ah crComEb02ah = new CrComEb02ah();
		crComEb02ah.setBatchId(id);*/
		
		try {
			List<CrComEb02ah> crComEb02ahList = BaseDAOUtils.getCrComEb02ahDAO().findByIdProperties(id);
			createCrComEb02ahExcel(filepath, sheetName, title, fileName, crComEb02ahList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEb02ahExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEb02ah> crComEb02ahList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEb02ahList.size()][];
		for (int i = 0; i < crComEb02ahList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEb02ah crComEb02ah = crComEb02ahList.get(i);
			values[i][0] = String.valueOf(crComEb02ah.getId()) == "null" ? "" : String.valueOf(crComEb02ah.getId());
			values[i][1] = String.valueOf(crComEb02ah.getBatchId()) == "null" ? ""
					: String.valueOf(crComEb02ah.getBatchId());
			values[i][2] = String.valueOf(crComEb02ah.getEb02ad01()) == "null" ? ""
					: String.valueOf(crComEb02ah.getEb02ad01());
			values[i][3] = String.valueOf(crComEb02ah.getEb02ad02()) == "null" ? ""
					: String.valueOf(crComEb02ah.getEb02ad02());
			values[i][4] = String.valueOf(crComEb02ah.getEb02as04()) == "null" ? ""
					: String.valueOf(crComEb02ah.getEb02as04());
			values[i][5] = String.valueOf(crComEb02ah.getEb02aj06()) == "null" ? ""
					: String.valueOf(crComEb02ah.getEb02aj06());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEb02bh(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-借贷交易汇总信息-已结清借贷交易汇总信息段-其他借贷交易分类汇总信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "业务类型", "资产质量分类", "账户数", "余额" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EB02BH.xlsx";
		/*CrComEb02bh crComEb02bh = new CrComEb02bh();
		crComEb02bh.setBatchId(id);*/
		
		try {
			List<CrComEb02bh> crComEb02bhList = BaseDAOUtils.getCrComEb02bhDAO().findByIdProperties(id);
			createCrComEb02bhExcel(filepath, sheetName, title, fileName, crComEb02bhList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEb02bhExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEb02bh> crComEb02bhList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEb02bhList.size()][];
		for (int i = 0; i < crComEb02bhList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEb02bh crComEb02bh = crComEb02bhList.get(i);
			values[i][0] = String.valueOf(crComEb02bh.getId()) == "null" ? "" : String.valueOf(crComEb02bh.getId());
			values[i][1] = String.valueOf(crComEb02bh.getBatchId()) == "null" ? ""
					: String.valueOf(crComEb02bh.getBatchId());
			values[i][2] = String.valueOf(crComEb02bh.getEb02bd01()) == "null" ? ""
					: String.valueOf(crComEb02bh.getEb02bd01());
			values[i][3] = String.valueOf(crComEb02bh.getEb02bd02()) == "null" ? ""
					: String.valueOf(crComEb02bh.getEb02bd02());
			values[i][4] = String.valueOf(crComEb02bh.getEb02bs04()) == "null" ? ""
					: String.valueOf(crComEb02bh.getEb02bs04());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEb02ch(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-借贷交易汇总信息-负债历史汇总信息段-负债历史汇总信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "月份", "全部负债账户数", "全部负债余额", "关注类负债账户数", "关注类负债余额", "不良类负债账户数",
				"不良类负债余额", "逾期账户数", "逾期总额", "逾期本金账户数", "逾期本金" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EB02CH.xlsx";
		/*CrComEb02ch crComEb02ch = new CrComEb02ch();
		crComEb02ch.setBatchId(id);*/
		
		try {
			List<CrComEb02ch> crComEb02chList = BaseDAOUtils.getCrComEb02chDAO().findByIdProperties(id);
			createCrComEb02chExcel(filepath, sheetName, title, fileName, crComEb02chList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEb02chExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEb02ch> crComEb02chList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEb02chList.size()][];
		for (int i = 0; i < crComEb02chList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEb02ch crComEb02ch = crComEb02chList.get(i);
			values[i][0] = String.valueOf(crComEb02ch.getId()) == "null" ? "" : String.valueOf(crComEb02ch.getId());
			values[i][1] = String.valueOf(crComEb02ch.getBatchId()) == "null" ? ""
					: String.valueOf(crComEb02ch.getBatchId());
			values[i][2] = String.valueOf(crComEb02ch.getEb02cr01()) == "null" ? ""
					: String.valueOf(crComEb02ch.getEb02cr01());
			values[i][3] = String.valueOf(crComEb02ch.getEb02cs02()) == "null" ? ""
					: String.valueOf(crComEb02ch.getEb02cs02());
			values[i][4] = String.valueOf(crComEb02ch.getEb02cj01()) == "null" ? ""
					: String.valueOf(crComEb02ch.getEb02cj01());
			values[i][5] = String.valueOf(crComEb02ch.getEb02cs03()) == "null" ? ""
					: String.valueOf(crComEb02ch.getEb02cs03());
			values[i][6] = String.valueOf(crComEb02ch.getEb02cj02()) == "null" ? ""
					: String.valueOf(crComEb02ch.getEb02cj02());
			values[i][7] = String.valueOf(crComEb02ch.getEb02cs04()) == "null" ? ""
					: String.valueOf(crComEb02ch.getEb02cs04());
			values[i][8] = String.valueOf(crComEb02ch.getEb02cj03()) == "null" ? ""
					: String.valueOf(crComEb02ch.getEb02cj03());
			values[i][9] = String.valueOf(crComEb02ch.getEb02cs05()) == "null" ? ""
					: String.valueOf(crComEb02ch.getEb02cs05());
			values[i][10] = String.valueOf(crComEb02ch.getEb02cj04()) == "null" ? ""
					: String.valueOf(crComEb02ch.getEb02cj04());
			values[i][11] = String.valueOf(crComEb02ch.getEb02cs06()) == "null" ? ""
					: String.valueOf(crComEb02ch.getEb02cs06());
			values[i][12] = String.valueOf(crComEb02ch.getEb02cj05()) == "null" ? ""
					: String.valueOf(crComEb02ch.getEb02cj05());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEbc(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-担保交易汇总信息";
		// 标题
		String[] title = new String[] { "序号", "未结清担保交易汇总担保交易分类汇总条目数量", "已结清担保交易汇总担保交易分类汇总条目数量" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EBC.xlsx";
		/*CrComEbc crComEbc = new CrComEbc();
		crComEbc.setId(id);*/
		
		try {
			List<CrComEbc> crComEbcList = BaseDAOUtils.getCrComEbcDAO().findByIdProperties(id);
			createCrComEbcExcel(filepath, sheetName, title, fileName, crComEbcList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建EXCEL
	 * 
	 * @param sheetName
	 * @param tirrle
	 * @param tcsUserExportList
	 */
	public void createCrComEbcExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEbc> crComEbcList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEbcList.size()][];
		for (int i = 0; i < crComEbcList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEbc crComEbc = crComEbcList.get(i);
			values[i][0] = String.valueOf(crComEbc.getId()) == "null" ? "" : String.valueOf(crComEbc.getId());
			values[i][1] = String.valueOf(crComEbc.getEb03as01()) == "null" ? ""
					: String.valueOf(crComEbc.getEb03as01());
			values[i][2] = String.valueOf(crComEbc.getEb03bs01()) == "null" ? ""
					: String.valueOf(crComEbc.getEb03bs01());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEb03ah(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-担保交易汇总信息-未结清担保交易汇总信息段-未结清担保交易汇总信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "业务类型", "资产质量分类", "账户数", "余额" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EB03AH.xlsx";
	/*	CrComEb03ah crComEb03ah = new CrComEb03ah();
		crComEb03ah.setBatchId(id);*/
		
		try {
			List<CrComEb03ah> crComEb03ahList = BaseDAOUtils.getCrComEb03ahDAO().findByIdProperties(id);
			createCrComEb03ahExcel(filepath, sheetName, title, fileName, crComEb03ahList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEb03ahExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEb03ah> crComEb03ahList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEb03ahList.size()][];
		for (int i = 0; i < crComEb03ahList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEb03ah crComEb03ah = crComEb03ahList.get(i);
			values[i][0] = String.valueOf(crComEb03ah.getId()) == "null" ? "" : String.valueOf(crComEb03ah.getId());
			values[i][1] = String.valueOf(crComEb03ah.getBatchId()) == "null" ? ""
					: String.valueOf(crComEb03ah.getBatchId());
			values[i][2] = String.valueOf(crComEb03ah.getEb03ad01()) == "null" ? ""
					: String.valueOf(crComEb03ah.getEb03ad01());
			values[i][3] = String.valueOf(crComEb03ah.getEb03ad02()) == "null" ? ""
					: String.valueOf(crComEb03ah.getEb03ad02());
			values[i][4] = String.valueOf(crComEb03ah.getEb03as02()) == "null" ? ""
					: String.valueOf(crComEb03ah.getEb03as02());
			values[i][5] = String.valueOf(crComEb03ah.getEb03aj01()) == "null" ? ""
					: String.valueOf(crComEb03ah.getEb03aj01());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEb03bh(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-担保交易汇总信息-已结清担保交易汇总信息段-已结清担保交易汇总信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "业务类型", "资产质量分类", "账户数" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EB03BH.xlsx";
		/*CrComEb03bh crComEb03bh = new CrComEb03bh();
		crComEb03bh.setBatchId(id);*/
		
		try {
			List<CrComEb03bh> crComEb03bhList = BaseDAOUtils.getCrComEb03bhDAO().findByIdProperties(id);
			createCrComEb03bhExcel(filepath, sheetName, title, fileName, crComEb03bhList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEb03bhExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEb03bh> crComEb03bhList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEb03bhList.size()][];
		for (int i = 0; i < crComEb03bhList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEb03bh crComEb03bh = crComEb03bhList.get(i);
			values[i][0] = String.valueOf(crComEb03bh.getId()) == "null" ? "" : String.valueOf(crComEb03bh.getId());
			values[i][1] = String.valueOf(crComEb03bh.getBatchId()) == "null" ? ""
					: String.valueOf(crComEb03bh.getBatchId());
			values[i][2] = String.valueOf(crComEb03bh.getEb03bd01()) == "null" ? ""
					: String.valueOf(crComEb03bh.getEb03bd01());
			values[i][3] = String.valueOf(crComEb03bh.getEb03bd02()) == "null" ? ""
					: String.valueOf(crComEb03bh.getEb03bd02());
			values[i][4] = String.valueOf(crComEb03bh.getEb03bs02()) == "null" ? ""
					: String.valueOf(crComEb03bh.getEb03bs02());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEbd(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-授信协议汇总信息";
		// 标题
		String[] title = new String[] { "序号", "非循环信用额度合计", "已使用的非循环信用额度合计", "剩余可用的非循环额度合计", "循环信用额度合计", "已使用的循环信用额度合计",
				"剩余可用的循环额度合计", "是否包含授信限" };
		String currentTime = DataMyUtil.getFullDateTime();
		// 文件名
		String fileName = currentTime+"_"+"CR_COM_EBD.xlsx";
		/*CrComEbd crComEbd = new CrComEbd();
		crComEbd.setId(id);*/
		
		try {
			List<CrComEbd> crComEbdList = BaseDAOUtils.getCrComEbdDAO().findByIdProperties(id);
			createCrComEbdExcel(filepath, sheetName, title, fileName, crComEbdList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEbdExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEbd> crComEbdList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEbdList.size()][];
		for (int i = 0; i < crComEbdList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEbd crComEbd = crComEbdList.get(i);
			values[i][0] = String.valueOf(crComEbd.getId()) == "null" ? "" : String.valueOf(crComEbd.getId());
			values[i][1] = String.valueOf(crComEbd.getEb040j01()) == "null" ? ""
					: String.valueOf(crComEbd.getEb040j01());
			values[i][2] = String.valueOf(crComEbd.getEb040j02()) == "null" ? ""
					: String.valueOf(crComEbd.getEb040j02());
			values[i][3] = String.valueOf(crComEbd.getEb040j03()) == "null" ? ""
					: String.valueOf(crComEbd.getEb040j03());
			values[i][4] = String.valueOf(crComEbd.getEb040j04()) == "null" ? ""
					: String.valueOf(crComEbd.getEb040j04());
			values[i][5] = String.valueOf(crComEbd.getEb040j05()) == "null" ? ""
					: String.valueOf(crComEbd.getEb040j05());
			values[i][6] = String.valueOf(crComEbd.getEb040j06()) == "null" ? ""
					: String.valueOf(crComEbd.getEb040j06());
			values[i][7] = String.valueOf(crComEbd.getEb040d01()) == "null" ? ""
					: String.valueOf(crComEbd.getEb040d01());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		sheet.autoSizeColumn((short) 7);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEbe(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-相关还款责任汇总信息";
		// 标题
		String[] title = new String[] { "序号", "借贷交易相关还款责任类型数量", "担保交易相关还款责任类型数量" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EBE.xlsx";
		/*CrComEbe crComEbe = new CrComEbe();
		crComEbe.setId(id);*/
		
		try {
			List<CrComEbe> crComEbeList = BaseDAOUtils.getCrComEbeDAO().findByIdProperties(id);
			createCrComEbeExcel(filepath, sheetName, title, fileName, crComEbeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEbeExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEbe> crComEbeList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEbeList.size()][];
		for (int i = 0; i < crComEbeList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEbe crComEbe = crComEbeList.get(i);
			values[i][0] = String.valueOf(crComEbe.getId()) == "null" ? "" : String.valueOf(crComEbe.getId());
			values[i][1] = String.valueOf(crComEbe.getEb05as01()) == "null" ? ""
					: String.valueOf(crComEbe.getEb05as01());
			values[i][2] = String.valueOf(crComEbe.getEb05bs01()) == "null" ? ""
					: String.valueOf(crComEbe.getEb05bs01());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEb05ah(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-相关还款责任汇总信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "责任类型", "被追偿账户的还款责任金额", "被追偿账户数", "被追偿账户余额", "其他借贷交易的还款责任金额",
				"其他借贷交易账户数", "其他借贷交易账户余额", "其他借贷交易账户关注类余额", "其他借贷交易账户不良类余额" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EB05AH.xlsx";
		/*CrComEb05ah crComEb05ah = new CrComEb05ah();
		crComEb05ah.setBatchId(id);*/
		
		try {
			List<CrComEb05ah> crComEb05ahList = BaseDAOUtils.getCrComEb05ahDAO().findByIdProperties(id);
			createCrComEb05ahExcel(filepath, sheetName, title, fileName, crComEb05ahList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEb05ahExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEb05ah> crComEb05ahList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEb05ahList.size()][];
		for (int i = 0; i < crComEb05ahList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEb05ah crComEb05ah = crComEb05ahList.get(i);
			values[i][0] = String.valueOf(crComEb05ah.getId()) == "null" ? "" : String.valueOf(crComEb05ah.getId());
			values[i][1] = String.valueOf(crComEb05ah.getBatchId()) == "null" ? ""
					: String.valueOf(crComEb05ah.getBatchId());
			values[i][2] = String.valueOf(crComEb05ah.getEb05ad01()) == "null" ? ""
					: String.valueOf(crComEb05ah.getEb05ad01());
			values[i][3] = String.valueOf(crComEb05ah.getEb05aj01()) == "null" ? ""
					: String.valueOf(crComEb05ah.getEb05aj01());
			values[i][4] = String.valueOf(crComEb05ah.getEb05as02()) == "null" ? ""
					: String.valueOf(crComEb05ah.getEb05as02());
			values[i][5] = String.valueOf(crComEb05ah.getEb05aj02()) == "null" ? ""
					: String.valueOf(crComEb05ah.getEb05aj02());
			values[i][6] = String.valueOf(crComEb05ah.getEb05aj03()) == "null" ? ""
					: String.valueOf(crComEb05ah.getEb05aj03());
			values[i][7] = String.valueOf(crComEb05ah.getEb05as03()) == "null" ? ""
					: String.valueOf(crComEb05ah.getEb05as03());
			values[i][8] = String.valueOf(crComEb05ah.getEb05aj04()) == "null" ? ""
					: String.valueOf(crComEb05ah.getEb05aj04());
			values[i][9] = String.valueOf(crComEb05ah.getEb05aj05()) == "null" ? ""
					: String.valueOf(crComEb05ah.getEb05aj05());
			values[i][10] = String.valueOf(crComEb05ah.getEb05aj06()) == "null" ? ""
					: String.valueOf(crComEb05ah.getEb05aj06());
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
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEb05bh(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-相关还款责任汇总信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "责任类型", "还款责任金额", "账户数", "余额", "关注类余额", "不良类余额" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EB05BH.xlsx";
		/*CrComEb05bh crComEb05bh = new CrComEb05bh();
		crComEb05bh.setBatchId(id);*/
		
		try {
			List<CrComEb05bh> crComEb05bhList = BaseDAOUtils.getCrComEb05bhDAO().findByIdProperties(id);
			createCrComEb05bhExcel(filepath, sheetName, title, fileName, crComEb05bhList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEb05bhExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEb05bh> crComEb05bhList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEb05bhList.size()][];
		for (int i = 0; i < crComEb05bhList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEb05bh crComEb05bh = crComEb05bhList.get(i);
			values[i][0] = String.valueOf(crComEb05bh.getId()) == "null" ? "" : String.valueOf(crComEb05bh.getId());
			values[i][1] = String.valueOf(crComEb05bh.getBatchId()) == "null" ? ""
					: String.valueOf(crComEb05bh.getBatchId());
			values[i][2] = String.valueOf(crComEb05bh.getEb05bd01()) == "null" ? ""
					: String.valueOf(crComEb05bh.getEb05bd01());
			values[i][3] = String.valueOf(crComEb05bh.getEb05bj01()) == "null" ? ""
					: String.valueOf(crComEb05bh.getEb05bj01());
			values[i][4] = String.valueOf(crComEb05bh.getEb05bs02()) == "null" ? ""
					: String.valueOf(crComEb05bh.getEb05bs02());
			values[i][5] = String.valueOf(crComEb05bh.getEb05bj02()) == "null" ? ""
					: String.valueOf(crComEb05bh.getEb05bj02());
			values[i][6] = String.valueOf(crComEb05bh.getEb05bj03()) == "null" ? ""
					: String.valueOf(crComEb05bh.getEb05bj03());
			values[i][7] = String.valueOf(crComEb05bh.getEb05bj04()) == "null" ? ""
					: String.valueOf(crComEb05bh.getEb05bj04());

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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		sheet.autoSizeColumn((short) 7);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEda(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-借贷账户信息";
		// 标题
		String[] title = new String[] { "序号", "借贷账户编号", "账户活动状态", "借贷账户类型", "借款期限", "基本信息段业务管理机构类型", "基本信息段业务管理机构代码",
				"基本信息段授信协议编号", "基本信息段借贷业务种类大类", "基本信息段借贷业务种类细分", "基本信息段开户日期", "基本信息段币种", "基本信息段借款金额", "基本信息段信用额度",
				"基本信息段到期日期", "基本信息段担保方式", "其他还款保证方式", "基本信息段发放形式", "基本信息段共同借款标识", "基本信息段关闭日期", "基本信息段信息报告日期",
				"还款表现记录条数", "特定交易个数", "贴现账户分机构汇总信息编号", "贴现账户分机构汇总业务管理机构类型", "贴现账户分机构汇总业务管理机构代码", "贴现账户分机构汇总业务种类",
				"贴现账户分机构汇总五级分类", "贴现账户分机构汇总未结清账户数", "贴现账户分机构汇总余额合计", "贴现账户分机构汇总逾期总额合计", "贴现账户分机构汇总逾期本金合计",
				"贴现账户分机构汇总已结清账户数", "贴现账户分机构汇总已结清账户贴现金额合计", "欠息信息编号", "欠息信息业务管理机构类型", "欠息信息业务管理机构代码", "欠息信息币种", "欠息余额",
				"欠息信息余额变化日期", "欠息类型", "欠息信息报告日期" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EDA.xlsx";
	/*	CrComEda crComEda = new CrComEda();
		crComEda.setId(id);*/
		
		try {
			List<CrComEda> crComEdaList = BaseDAOUtils.getCrComEdaDAO().findByIdProperties(id);
			createCrComEdaExcel(filepath, sheetName, title, fileName, crComEdaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEdaExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEda> crComEdaList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEdaList.size()][];
		for (int i = 0; i < crComEdaList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEda crComEda = crComEdaList.get(i);
			values[i][1] = String.valueOf(crComEda.getEd01ai01()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ai01());
			values[i][2] = String.valueOf(crComEda.getEd01ad01()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ad01());
			values[i][3] = String.valueOf(crComEda.getEd01ad02()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ad02());
			values[i][4] = String.valueOf(crComEda.getEd01ad03()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ad03());
			values[i][5] = String.valueOf(crComEda.getEd01ad04()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ad04());
			values[i][6] = String.valueOf(crComEda.getEd01ai02()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ai02());
			values[i][7] = String.valueOf(crComEda.getEd01ai03()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ai03());
			values[i][8] = String.valueOf(crComEda.getEd01ad05()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ad05());
			values[i][9] = String.valueOf(crComEda.getEd01ad06()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ad06());
			values[i][10] = String.valueOf(crComEda.getEd01ar01()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ar01());
			values[i][11] = String.valueOf(crComEda.getEd01ad07()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ad07());
			values[i][12] = String.valueOf(crComEda.getEd01aj01()) == "null" ? ""
					: String.valueOf(crComEda.getEd01aj01());
			values[i][13] = String.valueOf(crComEda.getEd01aj02()) == "null" ? ""
					: String.valueOf(crComEda.getEd01aj02());
			values[i][14] = String.valueOf(crComEda.getEd01ar02()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ar02());
			values[i][15] = String.valueOf(crComEda.getEd01ad08()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ad08());
			values[i][16] = String.valueOf(crComEda.getEd01ad09()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ad09());
			values[i][17] = String.valueOf(crComEda.getEd01ad10()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ad10());
			values[i][18] = String.valueOf(crComEda.getEd01ad11()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ad11());
			values[i][19] = String.valueOf(crComEda.getEd01ar03()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ar03());
			values[i][20] = String.valueOf(crComEda.getEd01ar04()) == "null" ? ""
					: String.valueOf(crComEda.getEd01ar04());
			values[i][21] = String.valueOf(crComEda.getEd01bs01()) == "null" ? ""
					: String.valueOf(crComEda.getEd01bs01());
			values[i][22] = String.valueOf(crComEda.getEd01cs01()) == "null" ? ""
					: String.valueOf(crComEda.getEd01cs01());
			values[i][23] = String.valueOf(crComEda.getEd020i01()) == "null" ? ""
					: String.valueOf(crComEda.getEd020i01());
			values[i][24] = String.valueOf(crComEda.getEd020d01()) == "null" ? ""
					: String.valueOf(crComEda.getEd020d01());
			values[i][25] = String.valueOf(crComEda.getEd020i02()) == "null" ? ""
					: String.valueOf(crComEda.getEd020i02());
			values[i][26] = String.valueOf(crComEda.getEd020d02()) == "null" ? ""
					: String.valueOf(crComEda.getEd020d02());
			values[i][27] = String.valueOf(crComEda.getEd020d03()) == "null" ? ""
					: String.valueOf(crComEda.getEd020d03());
			values[i][28] = String.valueOf(crComEda.getEd020s01()) == "null" ? ""
					: String.valueOf(crComEda.getEd020s01());
			values[i][29] = String.valueOf(crComEda.getEd020j01()) == "null" ? ""
					: String.valueOf(crComEda.getEd020j01());
			values[i][30] = String.valueOf(crComEda.getEd020j02()) == "null" ? ""
					: String.valueOf(crComEda.getEd020j02());
			values[i][31] = String.valueOf(crComEda.getEd020j03()) == "null" ? ""
					: String.valueOf(crComEda.getEd020j03());
			values[i][32] = String.valueOf(crComEda.getEd020s02()) == "null" ? ""
					: String.valueOf(crComEda.getEd020s02());
			values[i][33] = String.valueOf(crComEda.getEd020j04()) == "null" ? ""
					: String.valueOf(crComEda.getEd020j04());
			values[i][34] = String.valueOf(crComEda.getEd030i01()) == "null" ? ""
					: String.valueOf(crComEda.getEd030i01());
			values[i][35] = String.valueOf(crComEda.getEd030d01()) == "null" ? ""
					: String.valueOf(crComEda.getEd030d01());
			values[i][36] = String.valueOf(crComEda.getEd030i02()) == "null" ? ""
					: String.valueOf(crComEda.getEd030i02());
			values[i][37] = String.valueOf(crComEda.getEd030d02()) == "null" ? ""
					: String.valueOf(crComEda.getEd030d02());
			values[i][38] = String.valueOf(crComEda.getEd030j01()) == "null" ? ""
					: String.valueOf(crComEda.getEd030j01());
			values[i][39] = String.valueOf(crComEda.getEd030r01()) == "null" ? ""
					: String.valueOf(crComEda.getEd030r01());
			values[i][40] = String.valueOf(crComEda.getEd030d03()) == "null" ? ""
					: String.valueOf(crComEda.getEd030d03());
			values[i][41] = String.valueOf(crComEda.getEd030r02()) == "null" ? ""
					: String.valueOf(crComEda.getEd030r02());

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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		sheet.autoSizeColumn((short) 19);
		sheet.autoSizeColumn((short) 20);
		sheet.autoSizeColumn((short) 21);
		sheet.autoSizeColumn((short) 22);
		sheet.autoSizeColumn((short) 23);
		sheet.autoSizeColumn((short) 24);
		sheet.autoSizeColumn((short) 25);
		sheet.autoSizeColumn((short) 26);
		sheet.autoSizeColumn((short) 27);
		sheet.autoSizeColumn((short) 28);
		sheet.autoSizeColumn((short) 29);
		sheet.autoSizeColumn((short) 30);
		sheet.autoSizeColumn((short) 31);
		sheet.autoSizeColumn((short) 32);
		sheet.autoSizeColumn((short) 33);
		sheet.autoSizeColumn((short) 34);
		sheet.autoSizeColumn((short) 35);
		sheet.autoSizeColumn((short) 36);
		sheet.autoSizeColumn((short) 37);
		sheet.autoSizeColumn((short) 38);
		sheet.autoSizeColumn((short) 39);
		sheet.autoSizeColumn((short) 40);
		sheet.autoSizeColumn((short) 41);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEd01(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-借贷账户信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "借贷账户编号", "账户活动状态", "借贷账户类型", "借款期限", "基本信息段业务管理机构类型",
				"基本信息段业务管理机构代码", "基本信息段授信协议编号", "基本信息段借贷业务种类大类", "基本信息段借贷业务种类细分", "基本信息段开户日期", "基本信息段币种", "基本信息段借款金额",
				"基本信息段信用额度", "基本信息段到期日期", "基本信息段担保方式", "其他还款保证方式", "基本信息段发放形式", "基本信息段共同借款标识", "基本信息段关闭日期",
				"基本信息段信息报告日期" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_ED01.xlsx";
		/*CrComEd01 crComEd01 = new CrComEd01();
		crComEd01.setBatchId(id);*/
		
		try {
			List<CrComEd01> crComEd01List = BaseDAOUtils.getCrComEd01DAO().findByIdProperties(id);
			createCrComEd01Excel(filepath, sheetName, title, fileName, crComEd01List);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEd01Excel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEd01> crComEd01List) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEd01List.size()][];
		for (int i = 0; i < crComEd01List.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd01 crComEd01 = crComEd01List.get(i);
			values[i][0] = String.valueOf(crComEd01.getId()) == "null" ? "" : String.valueOf(crComEd01.getId());
			values[i][1] = String.valueOf(crComEd01.getBatchId()) == "null" ? ""
					: String.valueOf(crComEd01.getBatchId());
			values[i][2] = String.valueOf(crComEd01.getEd01ai01()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ai01());
			values[i][3] = String.valueOf(crComEd01.getEd01ad01()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ad01());
			values[i][4] = String.valueOf(crComEd01.getEd01ad02()) == "null" ? ""
					: String.valueOf(crComEd01.getBatchId());
			values[i][5] = String.valueOf(crComEd01.getEd01ad03()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ai01());
			values[i][6] = String.valueOf(crComEd01.getEd01ad04()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ad04());
			values[i][7] = String.valueOf(crComEd01.getEd01ai02()) == "null" ? ""
					: String.valueOf(crComEd01.getBatchId());
			values[i][8] = String.valueOf(crComEd01.getEd01ai03()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ai01());
			values[i][9] = String.valueOf(crComEd01.getEd01ad05()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ad05());
			values[i][10] = String.valueOf(crComEd01.getEd01ad06()) == "null" ? ""
					: String.valueOf(crComEd01.getBatchId());
			values[i][11] = String.valueOf(crComEd01.getEd01ar01()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ai01());
			values[i][12] = String.valueOf(crComEd01.getEd01ad07()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ad07());
			values[i][13] = String.valueOf(crComEd01.getEd01aj01()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01aj01());
			values[i][14] = String.valueOf(crComEd01.getEd01aj02()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01aj02());
			values[i][15] = String.valueOf(crComEd01.getEd01ar02()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ar02());
			values[i][16] = String.valueOf(crComEd01.getEd01ad08()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ad08());
			values[i][17] = String.valueOf(crComEd01.getEd01ad09()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ad09());
			values[i][18] = String.valueOf(crComEd01.getEd01ad10()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ad10());
			values[i][19] = String.valueOf(crComEd01.getEd01ad11()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ad11());
			values[i][20] = String.valueOf(crComEd01.getEd01ar03()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ar03());
			values[i][21] = String.valueOf(crComEd01.getEd01ar04()) == "null" ? ""
					: String.valueOf(crComEd01.getEd01ar04());

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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		sheet.autoSizeColumn((short) 19);
		sheet.autoSizeColumn((short) 20);
		sheet.autoSizeColumn((short) 21);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEd01b(String path,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-欠息信息";
		String currentTime = DataMyUtil.getFullDateTime();
		// 标题
		String[] title = new String[] { "序号", "序号", "还款表现记录条数", "CR_COM_ED01表ID"};
		// 文件名
		String fileName = currentTime+"_"+"CR_COM_ED01B.xlsx";
		isChartPathExist(path);
		try {
			List<CrComEd01b> crComEd01bList = BaseDAOUtils.getCrComEd01bDAO().findByIdProperties(id);
			createCrComEd01bExcel(path, sheetName, title, fileName, crComEd01bList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrComEd01bExcel(String path, String sheetName, String title[], String fileName,
			List<CrComEd01b> crComEd01bList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEd01bList.size()][];
		for (int i = 0; i < crComEd01bList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd01b crComEd01b = crComEd01bList.get(i);
			values[i][0] = String.valueOf(crComEd01b.getId()) == "null" ? "" : String.valueOf(crComEd01b.getId());
			values[i][1] = String.valueOf(crComEd01b.getBatchId()) == "null" ? ""
					: String.valueOf(crComEd01b.getBatchId());
			values[i][2] = String.valueOf(crComEd01b.getEd01bs01()) == "null" ? ""
					: String.valueOf(crComEd01b.getEd01bs01());
			values[i][3] = String.valueOf(crComEd01b.getParentId()) == "null" ? ""
					: String.valueOf(crComEd01b.getParentId());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		try {
			FileOutputStream os=new FileOutputStream(path+"_"+fileName);
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrComEd01c(String path,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-欠息信息";
		String currentTime = DataMyUtil.getFullDateTime();
		isChartPathExist(path);
		// 标题
		String[] title = new String[] { "序号", "序号", "特定交易个数", "CR_COM_ED01表ID"};
		// 文件名
		String fileName = currentTime+"_"+"CR_COM_ED01C.xlsx";
		try {
			List<CrComEd01c> crComEd01cList = BaseDAOUtils.getCrComEd01cDAO().findByIdProperties(id);
			createCrComEd01cExcel(path, sheetName, title, fileName, crComEd01cList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrComEd01cExcel(String path, String sheetName, String title[], String fileName,
			List<CrComEd01c> crComEd01cList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEd01cList.size()][];
		for (int i = 0; i < crComEd01cList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd01c crComEd01c = crComEd01cList.get(i);
			values[i][0] = String.valueOf(crComEd01c.getId()) == "null" ? "" : String.valueOf(crComEd01c.getId());
			values[i][1] = String.valueOf(crComEd01c.getBatchId()) == "null" ? ""
					: String.valueOf(crComEd01c.getBatchId());
			values[i][2] = String.valueOf(crComEd01c.getEd01cs01()) == "null" ? ""
					: String.valueOf(crComEd01c.getEd01cs01());
			values[i][3] = String.valueOf(crComEd01c.getParentId()) == "null" ? ""
					: String.valueOf(crComEd01c.getParentId());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		try {
			FileOutputStream os=new FileOutputStream(path+"_"+fileName);
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrComEd02(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-贴现账户分机构汇总信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "借贷账户编号", "贴现账户分机构汇总信息编号", "贴现账户分机构汇总业务管理机构类型", "贴现账户分机构汇总业务管理机构代码",
				"贴现账户分机构汇总业务种类", "贴现账户分机构汇总五级分类", "贴现账户分机构汇总未结清账户数", "贴现账户分机构汇总余额合计", "贴现账户分机构汇总逾期总额合计",
				"贴现账户分机构汇总逾期本金合计", "贴现账户分机构汇总已结清账户数", "贴现账户分机构汇总已结清账户贴现金额合计" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"CR_COM_ED02.xlsx";
		/*CrComEd02 crComEd02 = new CrComEd02();
		crComEd02.setBatchId(id);*/
		
		try {
			List<CrComEd02> crComEd02List = BaseDAOUtils.getCrComEd02DAO().findByIdProperties(id);
			createCrComEd02Excel(filepath, sheetName, title, fileName, crComEd02List);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEd02Excel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEd02> crComEd02List) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEd02List.size()][];
		for (int i = 0; i < crComEd02List.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd02 crComEd02 = crComEd02List.get(i);
			values[i][0] = String.valueOf(crComEd02.getId()) == "null" ? "" : String.valueOf(crComEd02.getId());
			values[i][1] = String.valueOf(crComEd02.getBatchId()) == "null" ? ""
					: String.valueOf(crComEd02.getBatchId());
			values[i][2] = String.valueOf(crComEd02.getEd020i01()) == "null" ? ""
					: String.valueOf(crComEd02.getEd020i01());
			values[i][3] = String.valueOf(crComEd02.getEd020d01()) == "null" ? ""
					: String.valueOf(crComEd02.getEd020d01());
			values[i][4] = String.valueOf(crComEd02.getEd020i02()) == "null" ? ""
					: String.valueOf(crComEd02.getEd020i02());
			values[i][5] = String.valueOf(crComEd02.getEd020d02()) == "null" ? ""
					: String.valueOf(crComEd02.getEd020d02());
			values[i][6] = String.valueOf(crComEd02.getEd020d03()) == "null" ? ""
					: String.valueOf(crComEd02.getEd020d03());
			values[i][7] = String.valueOf(crComEd02.getEd020s01()) == "null" ? ""
					: String.valueOf(crComEd02.getEd020s01());
			values[i][8] = String.valueOf(crComEd02.getEd020j01()) == "null" ? ""
					: String.valueOf(crComEd02.getEd020j01());
			values[i][9] = String.valueOf(crComEd02.getEd020j02()) == "null" ? ""
					: String.valueOf(crComEd02.getEd020j02());
			values[i][10] = String.valueOf(crComEd02.getEd020j03()) == "null" ? ""
					: String.valueOf(crComEd02.getEd020j03());
			values[i][11] = String.valueOf(crComEd02.getEd020s02()) == "null" ? ""
					: String.valueOf(crComEd02.getEd020s02());
			values[i][12] = String.valueOf(crComEd02.getEd020j04()) == "null" ? ""
					: String.valueOf(crComEd02.getEd020j04());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEd03(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-欠息信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "借贷账户编号", "贴现账户分机构汇总信息编号", "贴现账户分机构汇总业务管理机构类型", "贴现账户分机构汇总业务管理机构代码",
				"贴现账户分机构汇总业务种类", "贴现账户分机构汇总五级分类", "贴现账户分机构汇总未结清账户数", "贴现账户分机构汇总余额合计", "贴现账户分机构汇总逾期总额合计",
				"贴现账户分机构汇总逾期本金合计", "贴现账户分机构汇总已结清账户数", "贴现账户分机构汇总已结清账户贴现金额合计" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_ED03.xlsx";
		/*CrComEd03 crComEd03 = new CrComEd03();
		crComEd03.setBatchId(id);*/
		
		try {
			List<CrComEd03> crComEd03List = BaseDAOUtils.getCrComEd03DAO().findByIdProperties(id);
			createCrComEd03Excel(filepath, sheetName, title, fileName, crComEd03List);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEd03Excel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEd03> crComEd03List) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEd03List.size()][];
		for (int i = 0; i < crComEd03List.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd03 crComEd03 = crComEd03List.get(i);
			values[i][0] = String.valueOf(crComEd03.getId()) == "null" ? "" : String.valueOf(crComEd03.getId());
			values[i][1] = String.valueOf(crComEd03.getBatchId()) == "null" ? ""
					: String.valueOf(crComEd03.getBatchId());
			values[i][2] = String.valueOf(crComEd03.getEd030i01()) == "null" ? ""
					: String.valueOf(crComEd03.getEd030i01());
			values[i][3] = String.valueOf(crComEd03.getEd030d01()) == "null" ? ""
					: String.valueOf(crComEd03.getEd030d01());
			values[i][4] = String.valueOf(crComEd03.getEd030i02()) == "null" ? ""
					: String.valueOf(crComEd03.getEd030i02());
			values[i][5] = String.valueOf(crComEd03.getEd030d02()) == "null" ? ""
					: String.valueOf(crComEd03.getEd030d02());
			values[i][6] = String.valueOf(crComEd03.getEd030j01()) == "null" ? ""
					: String.valueOf(crComEd03.getEd030j01());
			values[i][7] = String.valueOf(crComEd03.getEd030r01()) == "null" ? ""
					: String.valueOf(crComEd03.getEd030r01());
			values[i][8] = String.valueOf(crComEd03.getEd030d03()) == "null" ? ""
					: String.valueOf(crComEd03.getEd030d03());
			values[i][9] = String.valueOf(crComEd03.getEd030r02()) == "null" ? ""
					: String.valueOf(crComEd03.getEd030r02());
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
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEd01bh(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-借贷账户信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "信息报告日期", "余额", "余额变化日期", "五级分类", "五级分类认定日期", "最近一次实际还款日期",
				"最近一次实际还款总额", "最近一次还款形式", "最近一次约定还款日期", "最近一次应还总额", "逾期总额", "逾期本金", "逾期月数", "剩余还款月数" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_ED01BH.xlsx";
	/*	CrComEd01bh crComEd01bh = new CrComEd01bh();
		crComEd01bh.setBatchId(id);*/
		
		try {
			List<CrComEd01bh> crComEd01bhList = BaseDAOUtils.getCrComEd01bhDAO().findByIdProperties(id);
			createCrComEd01bhExcel(filepath, sheetName, title, fileName, crComEd01bhList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEd01bhExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEd01bh> crComEd01bhList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEd01bhList.size()][];
		for (int i = 0; i < crComEd01bhList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd01bh crComEd01bh = crComEd01bhList.get(i);
			values[i][0] = String.valueOf(crComEd01bh.getId()) == "null" ? "" : String.valueOf(crComEd01bh.getId());
			values[i][1] = String.valueOf(crComEd01bh.getBatchId()) == "null" ? ""
					: String.valueOf(crComEd01bh.getBatchId());
			values[i][2] = String.valueOf(crComEd01bh.getEd01br01()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01br01());
			values[i][3] = String.valueOf(crComEd01bh.getEd01bj01()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01bj01());
			values[i][4] = String.valueOf(crComEd01bh.getEd01br02()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01br02());
			values[i][5] = String.valueOf(crComEd01bh.getEd01bd01()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01bd01());
			values[i][6] = String.valueOf(crComEd01bh.getEd01br03()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01br03());
			values[i][7] = String.valueOf(crComEd01bh.getEd01br04()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01br04());
			values[i][8] = String.valueOf(crComEd01bh.getEd01bj02()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01bj02());
			values[i][9] = String.valueOf(crComEd01bh.getEd01bd02()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01bd02());
			values[i][10] = String.valueOf(crComEd01bh.getEd01br05()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01br05());
			values[i][11] = String.valueOf(crComEd01bh.getEd01bj03()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01bj03());
			values[i][12] = String.valueOf(crComEd01bh.getEd01bj04()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01bj04());
			values[i][13] = String.valueOf(crComEd01bh.getEd01bj05()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01bj05());
			values[i][14] = String.valueOf(crComEd01bh.getEd01bs02()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01bs02());
			values[i][15] = String.valueOf(crComEd01bh.getEd01bs03()) == "null" ? ""
					: String.valueOf(crComEd01bh.getEd01bs03());

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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEd01ch(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-借贷账户信息-特定交易信息段-特定交易信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "交易类型", "交易日期", "交易金额", "到期日期变更月数", "交易明细信息" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_ED01CH.xlsx";
		/*CrComEd01ch crComEd01ch = new CrComEd01ch();
		crComEd01ch.setBatchId(id);*/
		
		try {
			List<CrComEd01ch> crComEd01chList = BaseDAOUtils.getCrComEd01chDAO().findByIdProperties(id);
			createCrComEd01chExcel(filepath, sheetName, title, fileName, crComEd01chList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEd01chExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEd01ch> crComEd01chList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEd01chList.size()][];
		for (int i = 0; i < crComEd01chList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd01ch crComEd01ch = crComEd01chList.get(i);
			values[i][0] = String.valueOf(crComEd01ch.getId()) == "null" ? "" : String.valueOf(crComEd01ch.getId());
			values[i][1] = String.valueOf(crComEd01ch.getBatchId()) == "null" ? ""
					: String.valueOf(crComEd01ch.getBatchId());
			values[i][2] = String.valueOf(crComEd01ch.getEd01cd01()) == "null" ? ""
					: String.valueOf(crComEd01ch.getEd01cd01());
			values[i][3] = String.valueOf(crComEd01ch.getEd01cr01()) == "null" ? ""
					: String.valueOf(crComEd01ch.getEd01cr01());
			values[i][4] = String.valueOf(crComEd01ch.getEd01cj01()) == "null" ? ""
					: String.valueOf(crComEd01ch.getEd01cj01());
			values[i][5] = String.valueOf(crComEd01ch.getEd01cs02()) == "null" ? ""
					: String.valueOf(crComEd01ch.getEd01cs02());
			values[i][6] = String.valueOf(crComEd01ch.getEd01cq01()) == "null" ? ""
					: String.valueOf(crComEd01ch.getEd01cq01());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEdb(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-担保账户信息";
		// 标题
		String[] title = new String[] { "序号", "担保账户编号", "担保账户类型", "业务管理机构类型", "业务管理机构代码", "授信协议编号", "担保交易业务种类细分",
				"开立日期", "币种", "金额", "到期日期", "反担保方式", "其他还款保证方式", "保证金比例", "信息报告日期", "账户活动状态", "余额", "五级分类", "风险敞口",
				"代偿（垫款）标志", "共同债务标识", "关闭日期", "担保账户分机构汇总信息编号", "担保账户分机构汇总信息业务管理机构类型", "担保账户分机构汇总信息业务管理机构代码",
				"担保账户分机构汇总信息担保交易业务种类细分", "担保账户分机构汇总信息五级分类", "担保账户分机构汇总信息未结清账户数", "担保账户分机构汇总信息余额",
				"担保账户分机构汇总信息30 天内到期的余额", "担保账户分机构汇总信息60 天内到期的余额", "担保账户分机构汇总信息90 天内到期的余额", "担保账户分机构汇总信息90 天后到期的余额",
				"担保账户分机构汇总信息已结清账户数", "担保账户分机构汇总信息垫款标志" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EDB.xlsx";
		/*CrComEdb crComEdb = new CrComEdb();
		crComEdb.setId(id);*/
		try {
			List<CrComEdb> crComEdbList = BaseDAOUtils.getCrComEdbDAO().findByIdProperties(id);
			createCrComEdbExcel(filepath, sheetName, title, fileName, crComEdbList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEdbExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEdb> crComEdbList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEdbList.size()][];
		for (int i = 0; i < crComEdbList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEdb crComEdb = crComEdbList.get(i);
			values[i][0] = String.valueOf(crComEdb.getId()) == "null" ? "" : String.valueOf(crComEdb.getId());
			values[i][1] = String.valueOf(crComEdb.getEd04ai01()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04ai01());
			values[i][2] = String.valueOf(crComEdb.getEd04ad01()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04ad01());
			values[i][3] = String.valueOf(crComEdb.getEd04ad02()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04ad02());
			values[i][4] = String.valueOf(crComEdb.getEd04ai02()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04ai02());
			values[i][5] = String.valueOf(crComEdb.getEd04ai03()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04ai03());
			values[i][6] = String.valueOf(crComEdb.getEd04ad03()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04ad03());
			values[i][7] = String.valueOf(crComEdb.getEd04ar01()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04ar01());
			values[i][8] = String.valueOf(crComEdb.getEd04ad04()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04ad04());
			values[i][9] = String.valueOf(crComEdb.getEd04aj01()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04aj01());
			values[i][10] = String.valueOf(crComEdb.getEd04ar02()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04ar02());
			values[i][11] = String.valueOf(crComEdb.getEd04ad05()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04ad05());
			values[i][12] = String.valueOf(crComEdb.getEd04ad06()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04ad06());
			values[i][13] = String.valueOf(crComEdb.getEd04aq01()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04aq01());
			values[i][14] = String.valueOf(crComEdb.getEd04br01()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04br01());
			values[i][15] = String.valueOf(crComEdb.getEd04bd01()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04bd01());
			values[i][16] = String.valueOf(crComEdb.getEd04bj01()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04bj01());
			values[i][17] = String.valueOf(crComEdb.getEd04bd02()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04bd02());
			values[i][18] = String.valueOf(crComEdb.getEd04bj02()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04bj02());
			values[i][19] = String.valueOf(crComEdb.getEd04bd03()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04bd03());
			values[i][20] = String.valueOf(crComEdb.getEd04bd04()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04bd04());
			values[i][21] = String.valueOf(crComEdb.getEd04br02()) == "null" ? ""
					: String.valueOf(crComEdb.getEd04br02());
			values[i][22] = String.valueOf(crComEdb.getEd050i01()) == "null" ? ""
					: String.valueOf(crComEdb.getEd050i01());
			values[i][23] = String.valueOf(crComEdb.getEd050d01()) == "null" ? ""
					: String.valueOf(crComEdb.getEd050d01());
			values[i][24] = String.valueOf(crComEdb.getEd050i02()) == "null" ? ""
					: String.valueOf(crComEdb.getEd050i02());
			values[i][25] = String.valueOf(crComEdb.getEd050d02()) == "null" ? ""
					: String.valueOf(crComEdb.getEd050d02());
			values[i][26] = String.valueOf(crComEdb.getEd050d03()) == "null" ? ""
					: String.valueOf(crComEdb.getEd050d03());
			values[i][27] = String.valueOf(crComEdb.getEd050s01()) == "null" ? ""
					: String.valueOf(crComEdb.getEd050s01());
			values[i][28] = String.valueOf(crComEdb.getEd050j01()) == "null" ? ""
					: String.valueOf(crComEdb.getEd050j01());
			values[i][29] = String.valueOf(crComEdb.getEd050j02()) == "null" ? ""
					: String.valueOf(crComEdb.getEd050j02());
			values[i][30] = String.valueOf(crComEdb.getEd050j03()) == "null" ? ""
					: String.valueOf(crComEdb.getEd050j03());
			values[i][31] = String.valueOf(crComEdb.getEd050j04()) == "null" ? ""
					: String.valueOf(crComEdb.getEd050j04());
			values[i][32] = String.valueOf(crComEdb.getEd050j05()) == "null" ? ""
					: String.valueOf(crComEdb.getEd050j05());
			values[i][33] = String.valueOf(crComEdb.getEd050s02()) == "null" ? ""
					: String.valueOf(crComEdb.getEd050s02());
			values[i][34] = String.valueOf(crComEdb.getEd050d04()) == "null" ? ""
					: String.valueOf(crComEdb.getEd050d04());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		sheet.autoSizeColumn((short) 19);
		sheet.autoSizeColumn((short) 20);
		sheet.autoSizeColumn((short) 21);
		sheet.autoSizeColumn((short) 22);
		sheet.autoSizeColumn((short) 23);
		sheet.autoSizeColumn((short) 24);
		sheet.autoSizeColumn((short) 25);
		sheet.autoSizeColumn((short) 26);
		sheet.autoSizeColumn((short) 27);
		sheet.autoSizeColumn((short) 28);
		sheet.autoSizeColumn((short) 29);
		sheet.autoSizeColumn((short) 30);
		sheet.autoSizeColumn((short) 31);
		sheet.autoSizeColumn((short) 32);
		sheet.autoSizeColumn((short) 33);
		sheet.autoSizeColumn((short) 34);

		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEdb04(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-担保账户信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "担保账户编号", "担保账户类型", "业务管理机构类型", "业务管理机构代码", "授信协议编号", "担保交易业务种类细分",
				"开立日期", "币种", "金额", "到期日期", "反担保方式", "其他还款保证方式", "保证金比例", "信息报告日期", "账户活动状态", "余额", "五级分类", "风险敞口",
				"代偿（垫款）标志", "共同债务标识", "关闭日期" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName =currentTime+"_"+"CR_COM_ED04.xlsx";
		/*CrComEd04 crComEd04 = new CrComEd04();
		crComEd04.setBatchId(id);*/
		
		try {
			List<CrComEd04> crComEdb04List = BaseDAOUtils.getCrComEd04DAO().findByIdProperties(id);
			createCrComEdb04Excel(filepath, sheetName, title, fileName, crComEdb04List);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEdb04Excel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEd04> crComEdb04List) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEdb04List.size()][];
		for (int i = 0; i < crComEdb04List.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd04 crComEdb04 = crComEdb04List.get(i);
			values[i][0] = String.valueOf(crComEdb04.getId()) == "null" ? "" : String.valueOf(crComEdb04.getId());
			values[i][1] = String.valueOf(crComEdb04.getBatchId()) == "null" ? ""
					: String.valueOf(crComEdb04.getBatchId());
			values[i][2] = String.valueOf(crComEdb04.getEd04ai01()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04ai01());
			values[i][3] = String.valueOf(crComEdb04.getEd04ad01()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04ad01());
			values[i][4] = String.valueOf(crComEdb04.getEd04ad02()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04ad02());
			values[i][5] = String.valueOf(crComEdb04.getEd04ai02()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04ai02());
			values[i][6] = String.valueOf(crComEdb04.getEd04ai03()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04ai03());
			values[i][7] = String.valueOf(crComEdb04.getEd04ad03()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04ad03());
			values[i][8] = String.valueOf(crComEdb04.getEd04ar01()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04ar01());
			values[i][9] = String.valueOf(crComEdb04.getEd04ad04()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04ad04());
			values[i][10] = String.valueOf(crComEdb04.getEd04aj01()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04aj01());
			values[i][11] = String.valueOf(crComEdb04.getEd04ar02()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04ar02());
			values[i][12] = String.valueOf(crComEdb04.getEd04ad05()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04ad05());
			values[i][13] = String.valueOf(crComEdb04.getEd04ad06()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04ad06());
			values[i][14] = String.valueOf(crComEdb04.getEd04aq01()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04aq01());
			values[i][15] = String.valueOf(crComEdb04.getEd04br01()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04br01());
			values[i][16] = String.valueOf(crComEdb04.getEd04bd01()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04bd01());
			values[i][17] = String.valueOf(crComEdb04.getEd04bj01()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04bj01());
			values[i][18] = String.valueOf(crComEdb04.getEd04bd02()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04bd02());
			values[i][19] = String.valueOf(crComEdb04.getEd04bj02()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04bj02());
			values[i][20] = String.valueOf(crComEdb04.getEd04bd03()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04bd03());
			values[i][21] = String.valueOf(crComEdb04.getEd04bd04()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04bd04());
			values[i][22] = String.valueOf(crComEdb04.getEd04br02()) == "null" ? ""
					: String.valueOf(crComEdb04.getEd04br02());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		sheet.autoSizeColumn((short) 19);
		sheet.autoSizeColumn((short) 20);
		sheet.autoSizeColumn((short) 21);
		sheet.autoSizeColumn((short) 22);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEd04b(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-担保账户信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "序号", "信息报告日期", "账户活动状态", "余额", "五级分类", "风险敞口", "代偿（垫款）标志",
				"共同债务标识", "关闭日期" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_ED04B.xlsx";
		
		try {
			List<CrComEd04b> crComEdb04bList = BaseDAOUtils.getCrComEd04bDAO().findByIdProperties(id);
			createCrComEd04bExcel(filepath, sheetName, title, fileName, crComEdb04bList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEd04bExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEd04b> crComEdb04bList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEdb04bList.size()][];
		for (int i = 0; i < crComEdb04bList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd04b crComEd04b = crComEdb04bList.get(i);
			values[i][0] = String.valueOf(crComEd04b.getId()) == "null" ? "" : String.valueOf(crComEd04b.getId());
			values[i][1] = String.valueOf(crComEd04b.getBatchId()) == "null" ? ""
					: String.valueOf(crComEd04b.getBatchId());
			values[i][2] = String.valueOf(crComEd04b.getParentId()) == "null" ? ""
					: String.valueOf(crComEd04b.getParentId());
			values[i][3] = String.valueOf(crComEd04b.getEd04br01()) == "null" ? ""
					: String.valueOf(crComEd04b.getEd04br01());
			values[i][4] = String.valueOf(crComEd04b.getEd04bd01()) == "null" ? ""
					: String.valueOf(crComEd04b.getEd04bd01());
			values[i][5] = String.valueOf(crComEd04b.getEd04bj01()) == "null" ? ""
					: String.valueOf(crComEd04b.getEd04bj01());
			values[i][6] = String.valueOf(crComEd04b.getEd04bd02()) == "null" ? ""
					: String.valueOf(crComEd04b.getEd04bd02());
			values[i][7] = String.valueOf(crComEd04b.getEd04bj02()) == "null" ? ""
					: String.valueOf(crComEd04b.getEd04bj02());
			values[i][8] = String.valueOf(crComEd04b.getEd04bd03()) == "null" ? ""
					: String.valueOf(crComEd04b.getEd04bd03());
			values[i][9] = String.valueOf(crComEd04b.getEd04bd04()) == "null" ? ""
					: String.valueOf(crComEd04b.getEd04bd04());
			values[i][10] = String.valueOf(crComEd04b.getEd04br02()) == "null" ? ""
					: String.valueOf(crComEd04b.getEd04br02());
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
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEd05(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-担保账户分机构汇总信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "担保账户分机构汇总信息编号", "担保账户分机构汇总信息业务管理机构类型", "担保账户分机构汇总信息业务管理机构代码",
				"担保账户分机构汇总信息担保交易业务种类细分", "担保账户分机构汇总信息五级分类", "担保账户分机构汇总信息未结清账户数", "担保账户分机构汇总信息余额",
				"担保账户分机构汇总信息30 天内到期的余额", "担保账户分机构汇总信息60 天内到期的余额", "担保账户分机构汇总信息90 天内到期的余额", "担保账户分机构汇总信息90 天后到期的余额",
				"担保账户分机构汇总信息已结清账户数", "担保账户分机构汇总信息垫款标志" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_ED05.xlsx";
		/*CrComEd05 crComEd05 = new CrComEd05();
		crComEd05.setBatchId(id);*/
		
		try {
			List<CrComEd05> crComEdb05List = BaseDAOUtils.getCrComEd05DAO().findByIdProperties(id);
			createCrComEd05Excel(filepath, sheetName, title, fileName, crComEdb05List);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEd05Excel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEd05> crComEdb05List) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEdb05List.size()][];
		for (int i = 0; i < crComEdb05List.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd05 crComEd05 = crComEdb05List.get(i);
			values[i][0] = String.valueOf(crComEd05.getId()) == "null" ? "" : String.valueOf(crComEd05.getId());
			values[i][1] = String.valueOf(crComEd05.getBatchId()) == "null" ? ""
					: String.valueOf(crComEd05.getBatchId());
			values[i][2] = String.valueOf(crComEd05.getEd050i01()) == "null" ? ""
					: String.valueOf(crComEd05.getEd050i01());
			values[i][3] = String.valueOf(crComEd05.getEd050d01()) == "null" ? ""
					: String.valueOf(crComEd05.getEd050d01());
			values[i][4] = String.valueOf(crComEd05.getEd050i02()) == "null" ? ""
					: String.valueOf(crComEd05.getEd050i02());
			values[i][5] = String.valueOf(crComEd05.getEd050d02()) == "null" ? ""
					: String.valueOf(crComEd05.getEd050d02());
			values[i][6] = String.valueOf(crComEd05.getEd050d03()) == "null" ? ""
					: String.valueOf(crComEd05.getEd050d03());
			values[i][7] = String.valueOf(crComEd05.getEd050s01()) == "null" ? ""
					: String.valueOf(crComEd05.getEd050s01());
			values[i][8] = String.valueOf(crComEd05.getEd050j01()) == "null" ? ""
					: String.valueOf(crComEd05.getEd050j01());
			values[i][9] = String.valueOf(crComEd05.getEd050j02()) == "null" ? ""
					: String.valueOf(crComEd05.getEd050j02());
			values[i][10] = String.valueOf(crComEd05.getEd050j03()) == "null" ? ""
					: String.valueOf(crComEd05.getEd050j03());
			values[i][11] = String.valueOf(crComEd05.getEd050j04()) == "null" ? ""
					: String.valueOf(crComEd05.getEd050j04());
			values[i][12] = String.valueOf(crComEd05.getEd050j05()) == "null" ? ""
					: String.valueOf(crComEd05.getEd050j05());
			values[i][13] = String.valueOf(crComEd05.getEd050s02()) == "null" ? ""
					: String.valueOf(crComEd05.getEd050s02());
			values[i][14] = String.valueOf(crComEd05.getEd050d04()) == "null" ? ""
					: String.valueOf(crComEd05.getEd050d04());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEdc(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-授信协议信息";
		// 标题
		String[] title = new String[] { "序号", "授信协议编号", "业务管理机构类型", "业务管理机构代码", "授信额度类型", "额度循环标志", "币种", "授信额度",
				"已用额度", "授信限额", "授信限额编号", "生效日期", "终止日期", "信息报告日期" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EDC.xlsx";
		/*CrComEdc crComEdc = new CrComEdc();
		crComEdc.setId(id);*/
		
		try {
			List<CrComEdc> crComEdcList = BaseDAOUtils.getCrComEdcDAO().findByIdProperties(id);
			createCrComEdcExcel(filepath, sheetName, title, fileName, crComEdcList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEdcExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEdc> crComEdcList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEdcList.size()][];
		for (int i = 0; i < crComEdcList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEdc crComEdc = crComEdcList.get(i);
			values[i][0] = String.valueOf(crComEdc.getId()) == "null" ? "" : String.valueOf(crComEdc.getId());
			values[i][1] = String.valueOf(crComEdc.getEd060i01()) == "null" ? ""
					: String.valueOf(crComEdc.getEd060i01());
			values[i][2] = String.valueOf(crComEdc.getEd060d01()) == "null" ? ""
					: String.valueOf(crComEdc.getEd060d01());
			values[i][3] = String.valueOf(crComEdc.getEd060i02()) == "null" ? ""
					: String.valueOf(crComEdc.getEd060i02());
			values[i][4] = String.valueOf(crComEdc.getEd060d02()) == "null" ? ""
					: String.valueOf(crComEdc.getEd060d02());
			values[i][5] = String.valueOf(crComEdc.getEd060d03()) == "null" ? ""
					: String.valueOf(crComEdc.getEd060d03());
			values[i][6] = String.valueOf(crComEdc.getEd060d04()) == "null" ? ""
					: String.valueOf(crComEdc.getEd060d04());
			values[i][7] = String.valueOf(crComEdc.getEd060j01()) == "null" ? ""
					: String.valueOf(crComEdc.getEd060j01());
			values[i][8] = String.valueOf(crComEdc.getEd060j04()) == "null" ? ""
					: String.valueOf(crComEdc.getEd060j04());
			values[i][9] = String.valueOf(crComEdc.getEd060j03()) == "null" ? ""
					: String.valueOf(crComEdc.getEd060j03());
			values[i][10] = String.valueOf(crComEdc.getEd060i03()) == "null" ? ""
					: String.valueOf(crComEdc.getEd060i03());
			values[i][11] = String.valueOf(crComEdc.getEd060r01()) == "null" ? ""
					: String.valueOf(crComEdc.getEd060r01());
			values[i][12] = String.valueOf(crComEdc.getEd060r02()) == "null" ? ""
					: String.valueOf(crComEdc.getEd060r02());
			values[i][13] = String.valueOf(crComEdc.getEd060r03()) == "null" ? ""
					: String.valueOf(crComEdc.getEd060r03());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEdd(String filepath,String  id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-相关还款责任信息";
		// 标题
		String[] title = new String[] { "序号", "借贷账户（不含贴现）信息账户编号", "借贷账户（不含贴现）信息主借款人身份类别", "借贷账户（不含贴现）信息账户类型",
				"借贷账户（不含贴现）信息相关还款责任人类型", "借贷账户（不含贴现）信息币种（相关还款责任金额）", "借贷账户（不含贴现）信息相关还款责任金额", "借贷账户（不含贴现）信息业务管理机构类型",
				"借贷账户（不含贴现）信息业务管理机构代码", "借贷账户（不含贴现）信息业务种类", "借贷账户（不含贴现）信息业务种类细分", "借贷账户（不含贴现）信息开立日期",
				"借贷账户（不含贴现）信息到期日期", "借贷账户（不含贴现）信息币种", "借贷账户（不含贴现）信息余额", "借贷账户（不含贴现）信息五级分类", "借贷账户（不含贴现）信息逾期总额",
				"借贷账户（不含贴现）信息逾期本金", "借贷账户（不含贴现）信息逾期月数", "借贷账户（不含贴现）信息还款状态", "借贷账户（不含贴现）信息剩余还款月数", "借贷账户（不含贴现）信息信息报告日期",
				"借贷账户（不含贴现）信息借款金额", "借贷账户（不含贴现）信息信用额度", "借贷账户（不含贴现）信息保证合同编号", "贴现账户分机构汇总信息编号", "贴现账户分机构汇总相关还款责任类型",
				"贴现账户分机构汇总业务管理机构类型", "贴现账户分机构汇总业务管理机构代码", "贴现账户分机构汇总业务种类细分", "贴现账户分机构汇总五级分类", "贴现账户分机构汇总相关还款责任金额",
				"贴现账户分机构汇总账户数", "贴现账户分机构汇总余额", "贴现账户分机构汇总逾期总额", "贴现账户分机构汇总逾期本金", "贴现账户分机构汇总借款金额", "贴现账户分机构汇总保证合同编号",
				"担保账户分机构汇总信息编号", "担保账户分机构汇总相关还款责任类型", "担保账户分机构汇总业务管理机构类型", "担保账户分机构汇总业务管理机构代码", "担保账户分机构汇总业务种类细分",
				"担保账户分机构汇总五级分类", "担保账户分机构汇总相关还款责任金额", "担保账户分机构汇总账户数", "担保账户分机构汇总余额", "担保账户分机构汇总担保金额",
				"担保账户分机构汇总保证合同编号" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EDD.xlsx";
		/*CrComEdd crComEdd = new CrComEdd();
		crComEdd.setId(id);*/
		
		try {
			List<CrComEdd> crComEddList = BaseDAOUtils.getCrComEddDAO().findByIdProperties(id);
			createCrComEddExcel(filepath, sheetName, title, fileName, crComEddList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEddExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEdd> crComEddList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEddList.size()][];
		for (int i = 0; i < crComEddList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEdd crComEdd = crComEddList.get(i);
			values[i][0] = String.valueOf(crComEdd.getId()) == "null" ? "" : String.valueOf(crComEdd.getId());
			values[i][1] = String.valueOf(crComEdd.getEd070i01()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070i01());
			values[i][2] = String.valueOf(crComEdd.getEd070d01()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070d01());
			values[i][3] = String.valueOf(crComEdd.getEd070d02()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070d02());
			values[i][4] = String.valueOf(crComEdd.getEd070d03()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070d03());
			values[i][5] = String.valueOf(crComEdd.getEd070d10()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070d10());
			values[i][6] = String.valueOf(crComEdd.getEd070j01()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070j01());
			values[i][7] = String.valueOf(crComEdd.getEd070d04()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070d04());
			values[i][8] = String.valueOf(crComEdd.getEd070i02()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070i02());
			values[i][9] = String.valueOf(crComEdd.getEd070d05()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070d05());
			values[i][10] = String.valueOf(crComEdd.getEd070d06()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070d06());
			values[i][11] = String.valueOf(crComEdd.getEd070r01()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070r01());
			values[i][12] = String.valueOf(crComEdd.getEd070r02()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070r02());
			values[i][13] = String.valueOf(crComEdd.getEd070d07()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070d07());
			values[i][14] = String.valueOf(crComEdd.getEd070j02()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070j02());
			values[i][15] = String.valueOf(crComEdd.getEd070d08()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070d08());
			values[i][16] = String.valueOf(crComEdd.getEd070j03()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070j03());
			values[i][17] = String.valueOf(crComEdd.getEd070j04()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070j04());
			values[i][18] = String.valueOf(crComEdd.getEd070s01()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070s01());
			values[i][19] = String.valueOf(crComEdd.getEd070d09()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070d09());
			values[i][20] = String.valueOf(crComEdd.getEd070s02()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070s02());
			values[i][21] = String.valueOf(crComEdd.getEd070r03()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070r03());
			values[i][22] = String.valueOf(crComEdd.getEd070j05()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070j05());
			values[i][23] = String.valueOf(crComEdd.getEd070j06()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070j06());
			values[i][24] = String.valueOf(crComEdd.getEd070i03()) == "null" ? ""
					: String.valueOf(crComEdd.getEd070i03());
			values[i][25] = String.valueOf(crComEdd.getEd080i01()) == "null" ? ""
					: String.valueOf(crComEdd.getEd080i01());
			values[i][26] = String.valueOf(crComEdd.getEd080d01()) == "null" ? ""
					: String.valueOf(crComEdd.getEd080d01());
			values[i][27] = String.valueOf(crComEdd.getEd080d02()) == "null" ? ""
					: String.valueOf(crComEdd.getEd080d02());
			values[i][28] = String.valueOf(crComEdd.getEd080i02()) == "null" ? ""
					: String.valueOf(crComEdd.getEd080i02());
			values[i][29] = String.valueOf(crComEdd.getEd080d03()) == "null" ? ""
					: String.valueOf(crComEdd.getEd080d03());
			values[i][30] = String.valueOf(crComEdd.getEd080d04()) == "null" ? ""
					: String.valueOf(crComEdd.getEd080d04());
			values[i][31] = String.valueOf(crComEdd.getEd080j01()) == "null" ? ""
					: String.valueOf(crComEdd.getEd080j01());
			values[i][32] = String.valueOf(crComEdd.getEd080s01()) == "null" ? ""
					: String.valueOf(crComEdd.getEd080s01());
			values[i][33] = String.valueOf(crComEdd.getEd080j02()) == "null" ? ""
					: String.valueOf(crComEdd.getEd080j02());
			values[i][34] = String.valueOf(crComEdd.getEd080j03()) == "null" ? ""
					: String.valueOf(crComEdd.getEd080j03());
			values[i][35] = String.valueOf(crComEdd.getEd080j04()) == "null" ? ""
					: String.valueOf(crComEdd.getEd080j04());
			values[i][36] = String.valueOf(crComEdd.getEd080j05()) == "null" ? ""
					: String.valueOf(crComEdd.getEd080j05());
			values[i][37] = String.valueOf(crComEdd.getEd080i03()) == "null" ? ""
					: String.valueOf(crComEdd.getEd080i03());
			values[i][38] = String.valueOf(crComEdd.getEd090i01()) == "null" ? ""
					: String.valueOf(crComEdd.getEd090i01());
			values[i][39] = String.valueOf(crComEdd.getEd090d01()) == "null" ? ""
					: String.valueOf(crComEdd.getEd090d01());
			values[i][40] = String.valueOf(crComEdd.getEd090d02()) == "null" ? ""
					: String.valueOf(crComEdd.getEd090d02());
			values[i][41] = String.valueOf(crComEdd.getEd090i02()) == "null" ? ""
					: String.valueOf(crComEdd.getEd090i02());
			values[i][42] = String.valueOf(crComEdd.getEd090d03()) == "null" ? ""
					: String.valueOf(crComEdd.getEd090d03());
			values[i][43] = String.valueOf(crComEdd.getEd090d04()) == "null" ? ""
					: String.valueOf(crComEdd.getEd090d04());
			values[i][44] = String.valueOf(crComEdd.getEd090j01()) == "null" ? ""
					: String.valueOf(crComEdd.getEd090j01());
			values[i][45] = String.valueOf(crComEdd.getEd090s01()) == "null" ? ""
					: String.valueOf(crComEdd.getEd090s01());
			values[i][46] = String.valueOf(crComEdd.getEd090j02()) == "null" ? ""
					: String.valueOf(crComEdd.getEd090j02());
			values[i][47] = String.valueOf(crComEdd.getEd100j03()) == "null" ? ""
					: String.valueOf(crComEdd.getEd100j03());
			values[i][48] = String.valueOf(crComEdd.getEd090i03()) == "null" ? ""
					: String.valueOf(crComEdd.getEd090i03());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		sheet.autoSizeColumn((short) 19);
		sheet.autoSizeColumn((short) 20);
		sheet.autoSizeColumn((short) 21);
		sheet.autoSizeColumn((short) 22);
		sheet.autoSizeColumn((short) 23);
		sheet.autoSizeColumn((short) 24);
		sheet.autoSizeColumn((short) 25);
		sheet.autoSizeColumn((short) 26);
		sheet.autoSizeColumn((short) 27);
		sheet.autoSizeColumn((short) 28);
		sheet.autoSizeColumn((short) 29);
		sheet.autoSizeColumn((short) 30);
		sheet.autoSizeColumn((short) 31);
		sheet.autoSizeColumn((short) 32);
		sheet.autoSizeColumn((short) 33);
		sheet.autoSizeColumn((short) 34);
		sheet.autoSizeColumn((short) 35);
		sheet.autoSizeColumn((short) 36);
		sheet.autoSizeColumn((short) 37);
		sheet.autoSizeColumn((short) 38);
		sheet.autoSizeColumn((short) 39);
		sheet.autoSizeColumn((short) 40);
		sheet.autoSizeColumn((short) 41);
		sheet.autoSizeColumn((short) 42);
		sheet.autoSizeColumn((short) 43);
		sheet.autoSizeColumn((short) 44);
		sheet.autoSizeColumn((short) 45);
		sheet.autoSizeColumn((short) 46);
		sheet.autoSizeColumn((short) 47);
		sheet.autoSizeColumn((short) 48);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
	
	public void excelCrComEd06(String path,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-相关还款责任信息";
		// 标题
		String[] title = new String[] { "序号", "授信协议编号", "授信机构", "授信额度类型",
				"额度循环标志", "生效日期", "到期日", "信息报告日期",
				"币种", "授信额度", "已用额度", "授信限额",
				"授信限额编号"};
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_ED06.xlsx";

		try {
			List<CrComEd06> crComEd06List = BaseDAOUtils.getCrComEd06Dao().findByIdProperties(id);
			createCrComEd06Excel(path, sheetName, title, fileName, crComEd06List);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createCrComEd06Excel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEd06> crComEd06List) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEd06List.size()][];
		for (int i = 0; i < crComEd06List.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd06 crComEd06 = crComEd06List.get(i);
			values[i][0] = String.valueOf(crComEd06.getId()) == "null" ? "" : String.valueOf(crComEd06.getId());
			values[i][1] = String.valueOf(crComEd06.getEd060i01()) == "null" ? ""
					: String.valueOf(crComEd06.getEd060i01());
			values[i][2] = String.valueOf(crComEd06.getEd060i02()) == "null" ? ""
					: String.valueOf(crComEd06.getEd060i02());
			values[i][3] = String.valueOf(crComEd06.getEd060d02()) == "null" ? ""
					: String.valueOf(crComEd06.getEd060d02());
			values[i][4] = String.valueOf(crComEd06.getEd060d03()) == "null" ? ""
					: String.valueOf(crComEd06.getEd060d03());
			values[i][5] = String.valueOf(crComEd06.getEd060r01()) == "null" ? ""
					: String.valueOf(crComEd06.getEd060r01());
			values[i][6] = String.valueOf(crComEd06.getEd060r02()) == "null" ? ""
					: String.valueOf(crComEd06.getEd060r02());
			values[i][7] = String.valueOf(crComEd06.getEd060r03()) == "null" ? ""
					: String.valueOf(crComEd06.getEd060r03());
			values[i][8] = String.valueOf(crComEd06.getEd060d04()) == "null" ? ""
					: String.valueOf(crComEd06.getEd060d04());
			values[i][9] = String.valueOf(crComEd06.getEd060j01()) == "null" ? ""
					: String.valueOf(crComEd06.getEd060j01());
			values[i][10] = String.valueOf(crComEd06.getEd060j04()) == "null" ? ""
					: String.valueOf(crComEd06.getEd060j04());
			values[i][11] = String.valueOf(crComEd06.getEd060j03()) == "null" ? ""
					: String.valueOf(crComEd06.getEd060j03());
			values[i][12] = String.valueOf(crComEd06.getEd060i03()) == "null" ? ""
					: String.valueOf(crComEd06.getEd060i03());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		sheet.autoSizeColumn((short) 19);
		sheet.autoSizeColumn((short) 20);
		sheet.autoSizeColumn((short) 21);
		sheet.autoSizeColumn((short) 22);
		sheet.autoSizeColumn((short) 23);
		sheet.autoSizeColumn((short) 24);
		sheet.autoSizeColumn((short) 25);
		sheet.autoSizeColumn((short) 26);
		sheet.autoSizeColumn((short) 27);
		sheet.autoSizeColumn((short) 28);
		sheet.autoSizeColumn((short) 29);
		sheet.autoSizeColumn((short) 30);
		sheet.autoSizeColumn((short) 31);
		sheet.autoSizeColumn((short) 32);
		sheet.autoSizeColumn((short) 33);
		sheet.autoSizeColumn((short) 34);
		sheet.autoSizeColumn((short) 35);
		sheet.autoSizeColumn((short) 36);
		sheet.autoSizeColumn((short) 37);
		sheet.autoSizeColumn((short) 38);
		sheet.autoSizeColumn((short) 39);
		sheet.autoSizeColumn((short) 40);
		sheet.autoSizeColumn((short) 41);
		sheet.autoSizeColumn((short) 42);
		sheet.autoSizeColumn((short) 43);
		sheet.autoSizeColumn((short) 44);
		sheet.autoSizeColumn((short) 45);
		sheet.autoSizeColumn((short) 46);
		sheet.autoSizeColumn((short) 47);
		sheet.autoSizeColumn((short) 48);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEd07(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-借贷账户（不含贴现）信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "借贷账户（不含贴现）信息账户编号", "借贷账户（不含贴现）信息主借款人身份类别", "借贷账户（不含贴现）信息账户类型",
				"借贷账户（不含贴现）信息相关还款责任人类型", "借贷账户（不含贴现）信息币种（相关还款责任金额）", "借贷账户（不含贴现）信息相关还款责任金额", "借贷账户（不含贴现）信息业务管理机构类型",
				"借贷账户（不含贴现）信息业务管理机构代码", "借贷账户（不含贴现）信息业务种类", "借贷账户（不含贴现）信息业务种类细分", "借贷账户（不含贴现）信息开立日期",
				"借贷账户（不含贴现）信息到期日期", "借贷账户（不含贴现）信息币种", "借贷账户（不含贴现）信息余额", "借贷账户（不含贴现）信息五级分类", "借贷账户（不含贴现）信息逾期总额",
				"借贷账户（不含贴现）信息逾期本金", "借贷账户（不含贴现）信息逾期月数", "借贷账户（不含贴现）信息还款状态", "借贷账户（不含贴现）信息剩余还款月数", "借贷账户（不含贴现）信息信息报告日期",
				"借贷账户（不含贴现）信息借款金额", "借贷账户（不含贴现）信息信用额度", "借贷账户（不含贴现）信息保证合同编号" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_ED07.xlsx";
	/*	CrComEd07 crComEd07 = new CrComEd07();
		crComEd07.setBatchId(id);*/
		
		try {
			List<CrComEd07> crComEd07List = BaseDAOUtils.getCrComEd07DAO().findByIdProperties(id);
			createCrComEd07Excel(filepath, sheetName, title, fileName, crComEd07List);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEd07Excel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEd07> crComEd07List) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEd07List.size()][];
		for (int i = 0; i < crComEd07List.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd07 crComEd07 = crComEd07List.get(i);
			values[i][0] = String.valueOf(crComEd07.getId()) == "null" ? "" : String.valueOf(crComEd07.getId());
			values[i][1] = String.valueOf(crComEd07.getBatchId()) == "null" ? ""
					: String.valueOf(crComEd07.getBatchId());
			values[i][2] = String.valueOf(crComEd07.getEd070i01()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070i01());
			values[i][3] = String.valueOf(crComEd07.getEd070d01()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070d01());
			values[i][4] = String.valueOf(crComEd07.getEd070d02()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070d02());
			values[i][5] = String.valueOf(crComEd07.getEd070d03()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070d03());
			values[i][6] = String.valueOf(crComEd07.getEd070d10()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070d10());
			values[i][7] = String.valueOf(crComEd07.getEd070j01()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070j01());
			values[i][8] = String.valueOf(crComEd07.getEd070d04()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070d04());
			values[i][9] = String.valueOf(crComEd07.getEd070i02()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070i02());
			values[i][10] = String.valueOf(crComEd07.getEd070d05()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070d05());
			values[i][11] = String.valueOf(crComEd07.getEd070d06()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070d06());
			values[i][12] = String.valueOf(crComEd07.getEd070r01()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070r01());
			values[i][13] = String.valueOf(crComEd07.getEd070r02()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070r02());
			values[i][14] = String.valueOf(crComEd07.getEd070d07()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070d07());
			values[i][15] = String.valueOf(crComEd07.getEd070j02()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070j02());
			values[i][16] = String.valueOf(crComEd07.getEd070d08()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070d08());
			values[i][17] = String.valueOf(crComEd07.getEd070j03()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070j03());
			values[i][18] = String.valueOf(crComEd07.getEd070j04()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070j04());
			values[i][19] = String.valueOf(crComEd07.getEd070s01()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070s01());
			values[i][20] = String.valueOf(crComEd07.getEd070d09()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070d09());
			values[i][21] = String.valueOf(crComEd07.getEd070s02()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070s02());
			values[i][22] = String.valueOf(crComEd07.getEd070r03()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070r03());
			values[i][23] = String.valueOf(crComEd07.getEd070j05()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070j05());
			values[i][24] = String.valueOf(crComEd07.getEd070j06()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070j06());
			values[i][25] = String.valueOf(crComEd07.getEd070i03()) == "null" ? ""
					: String.valueOf(crComEd07.getEd070i03());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		sheet.autoSizeColumn((short) 19);
		sheet.autoSizeColumn((short) 20);
		sheet.autoSizeColumn((short) 21);
		sheet.autoSizeColumn((short) 22);
		sheet.autoSizeColumn((short) 23);
		sheet.autoSizeColumn((short) 24);
		sheet.autoSizeColumn((short) 25);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEd08(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-贴现账户分机构汇总信息编号";
		// 标题
		String[] title = new String[] { "序号", "序号", "贴现账户分机构汇总信息编号", "贴现账户分机构汇总相关还款责任类型", "贴现账户分机构汇总业务管理机构类型",
				"贴现账户分机构汇总业务管理机构代码", "贴现账户分机构汇总业务种类细分", "贴现账户分机构汇总五级分类", "贴现账户分机构汇总相关还款责任金额", "贴现账户分机构汇总账户数",
				"贴现账户分机构汇总余额", "贴现账户分机构汇总逾期总额", "贴现账户分机构汇总逾期本金", "贴现账户分机构汇总借款金额", "贴现账户分机构汇总保证合同编号", "担保账户分机构汇总信息编号",
				"担保账户分机构汇总相关还款责任类型", "担保账户分机构汇总业务管理机构类型", "担保账户分机构汇总业务管理机构代码", "担保账户分机构汇总业务种类细分", "担保账户分机构汇总五级分类",
				"担保账户分机构汇总相关还款责任金额", "担保账户分机构汇总账户数", "担保账户分机构汇总余额", "担保账户分机构汇总担保金额", "担保账户分机构汇总保证合同编号" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_ED08.xlsx";
		/*CrComEd08 crComEd08 = new CrComEd08();
		crComEd08.setBatchId(id);*/
		
		try {
			List<CrComEd08> crComEd08List = BaseDAOUtils.getCrComEd08DAO().findByIdProperties(id);
			createCrComEd08Excel(filepath, sheetName, title, fileName, crComEd08List);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEd08Excel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEd08> crComEd08List) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEd08List.size()][];
		for (int i = 0; i < crComEd08List.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd08 crComEd08 = crComEd08List.get(i);
			values[i][0] = String.valueOf(crComEd08.getId()) == "null" ? "" : String.valueOf(crComEd08.getId());
			values[i][1] = String.valueOf(crComEd08.getBatchId()) == "null" ? ""
					: String.valueOf(crComEd08.getBatchId());
			values[i][2] = String.valueOf(crComEd08.getEd080i01()) == "null" ? ""
					: String.valueOf(crComEd08.getEd080i01());
			values[i][3] = String.valueOf(crComEd08.getEd080d01()) == "null" ? ""
					: String.valueOf(crComEd08.getEd080d01());
			values[i][4] = String.valueOf(crComEd08.getEd080d02()) == "null" ? ""
					: String.valueOf(crComEd08.getEd080d02());
			values[i][5] = String.valueOf(crComEd08.getEd080i02()) == "null" ? ""
					: String.valueOf(crComEd08.getEd080i02());
			values[i][6] = String.valueOf(crComEd08.getEd080d03()) == "null" ? ""
					: String.valueOf(crComEd08.getEd080d03());
			values[i][7] = String.valueOf(crComEd08.getEd080d04()) == "null" ? ""
					: String.valueOf(crComEd08.getEd080d04());
			values[i][8] = String.valueOf(crComEd08.getEd080j01()) == "null" ? ""
					: String.valueOf(crComEd08.getEd080j01());
			values[i][9] = String.valueOf(crComEd08.getEd080s01()) == "null" ? ""
					: String.valueOf(crComEd08.getEd080s01());
			values[i][10] = String.valueOf(crComEd08.getEd080j02()) == "null" ? ""
					: String.valueOf(crComEd08.getEd080j02());
			values[i][11] = String.valueOf(crComEd08.getEd080j03()) == "null" ? ""
					: String.valueOf(crComEd08.getEd080j03());
			values[i][12] = String.valueOf(crComEd08.getEd080j04()) == "null" ? ""
					: String.valueOf(crComEd08.getEd080j04());
			values[i][13] = String.valueOf(crComEd08.getEd080j05()) == "null" ? ""
					: String.valueOf(crComEd08.getEd080j05());
			values[i][14] = String.valueOf(crComEd08.getEd080i03()) == "null" ? ""
					: String.valueOf(crComEd08.getEd080i03());
			values[i][15] = String.valueOf(crComEd08.getEd090i01()) == "null" ? ""
					: String.valueOf(crComEd08.getEd090i01());
			values[i][16] = String.valueOf(crComEd08.getEd090d01()) == "null" ? ""
					: String.valueOf(crComEd08.getEd090d01());
			values[i][17] = String.valueOf(crComEd08.getEd090d02()) == "null" ? ""
					: String.valueOf(crComEd08.getEd090d02());
			values[i][18] = String.valueOf(crComEd08.getEd090i02()) == "null" ? ""
					: String.valueOf(crComEd08.getEd090i02());
			values[i][19] = String.valueOf(crComEd08.getEd090d03()) == "null" ? ""
					: String.valueOf(crComEd08.getEd090d03());
			values[i][20] = String.valueOf(crComEd08.getEd090d04()) == "null" ? ""
					: String.valueOf(crComEd08.getEd090d04());
			values[i][21] = String.valueOf(crComEd08.getEd090j01()) == "null" ? ""
					: String.valueOf(crComEd08.getEd090j01());
			values[i][22] = String.valueOf(crComEd08.getEd090s01()) == "null" ? ""
					: String.valueOf(crComEd08.getEd090s01());
			values[i][23] = String.valueOf(crComEd08.getEd090j02()) == "null" ? ""
					: String.valueOf(crComEd08.getEd090j02());
			values[i][24] = String.valueOf(crComEd08.getEd100j03()) == "null" ? ""
					: String.valueOf(crComEd08.getEd100j03());
			values[i][25] = String.valueOf(crComEd08.getEd090i03()) == "null" ? ""
					: String.valueOf(crComEd08.getEd090i03());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		sheet.autoSizeColumn((short) 19);
		sheet.autoSizeColumn((short) 20);
		sheet.autoSizeColumn((short) 21);
		sheet.autoSizeColumn((short) 22);
		sheet.autoSizeColumn((short) 23);
		sheet.autoSizeColumn((short) 24);
		sheet.autoSizeColumn((short) 25);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEd09(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-贴现账户分机构汇总信息编号";
		String[] title = new String[] { "序号                                " ,
				"序号                                " ,
				"担保账户分机构汇总信息编号          " ,
				"担保账户分机构汇总相关还款责任类型  " ,
				"担保账户分机构汇总业务管理机构类型  " ,
				"担保账户分机构汇总业务管理机构代码  " ,
				"担保账户分机构汇总业务种类细分      " ,
				"担保账户分机构汇总五级分类          " ,
				"担保账户分机构汇总相关还款责任金额  " ,
				"担保账户分机构汇总账户数            " ,
				"担保账户分机构汇总余额              " ,
				"担保账户分机构汇总担保金额          " ,
				"担保账户分机构汇总保证合同编号      "
 };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_ED09.xlsx";
	/*	CrComEd09 crComEd09 = new CrComEd09();
		crComEd09.setBatchId(id);*/
		
		try {
			List<CrComEd09> crComEd09List = BaseDAOUtils.getCrComEd09DAO().findByIdProperties(id);
			createCrComEd09Excel(filepath, sheetName, title, fileName, crComEd09List);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEd09Excel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEd09> crComEd09List) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEd09List.size()][];
		for (int i = 0; i < crComEd09List.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEd09 crComEd09 = crComEd09List.get(i);
			values[i][0] = String.valueOf(crComEd09.getId()) == "null" ? "" : String.valueOf(crComEd09.getId());
			values[i][1] = String.valueOf(crComEd09.getBatchId()) == "null" ? ""
					: String.valueOf(crComEd09.getBatchId());
			values[i][2] = String.valueOf(crComEd09.getEd090i01()) == "null" ? ""
					: String.valueOf(crComEd09.getEd090i01());
			values[i][3] = String.valueOf(crComEd09.getEd090d01()) == "null" ? ""
					: String.valueOf(crComEd09.getEd090d01());
			values[i][4] = String.valueOf(crComEd09.getEd090d02()) == "null" ? ""
					: String.valueOf(crComEd09.getEd090d02());
			values[i][5] = String.valueOf(crComEd09.getEd090i02()) == "null" ? ""
					: String.valueOf(crComEd09.getEd090i02());
			values[i][6] = String.valueOf(crComEd09.getEd090d03()) == "null" ? ""
					: String.valueOf(crComEd09.getEd090d03());
			values[i][7] = String.valueOf(crComEd09.getEd090d04()) == "null" ? ""
					: String.valueOf(crComEd09.getEd090d04());
			values[i][8] = String.valueOf(crComEd09.getEd090j01()) == "null" ? ""
					: String.valueOf(crComEd09.getEd090j01());
			values[i][9] = String.valueOf(crComEd09.getEd090s01()) == "null" ? ""
					: String.valueOf(crComEd09.getEd090s01());
			values[i][10] = String.valueOf(crComEd09.getEd090j02()) == "null" ? ""
					: String.valueOf(crComEd09.getEd090j02());
			values[i][11] = String.valueOf(crComEd09.getEd090J03()) == "null" ? ""
					: String.valueOf(crComEd09.getEd090J03());
			values[i][12] = String.valueOf(crComEd09.getEd090i03()) == "null" ? ""
					: String.valueOf(crComEd09.getEd090i03());

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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEea(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-公共事业缴费信息";
		// 标题
		String[] title = new String[] { "序号", "公用事业缴费账户编号", "公用事业单位名称", "业务类型", "缴费状态", "累计欠费金额", "统计年月",
				"过去 24 个月缴费情况缴费记录条数" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EEA.xlsx";
		/*CrComEea crComEea = new CrComEea();
		crComEea.setId(id);*/
		
		try {
			List<CrComEea> crComEeaList = BaseDAOUtils.getCrComEeaDAO().findByIdProperties(id);
			createCrComEeaExcel(filepath, sheetName, title, fileName, crComEeaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEeaExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEea> crComEeaList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEeaList.size()][];
		for (int i = 0; i < crComEeaList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEea crComEd09 = crComEeaList.get(i);
			values[i][0] = String.valueOf(crComEd09.getId()) == "null" ? "" : String.valueOf(crComEd09.getId());
			values[i][1] = String.valueOf(crComEd09.getEe01ai01()) == "null" ? ""
					: String.valueOf(crComEd09.getEe01ai01());
			values[i][2] = String.valueOf(crComEd09.getEe01aq01()) == "null" ? ""
					: String.valueOf(crComEd09.getEe01aq01());
			values[i][3] = String.valueOf(crComEd09.getEe01ad01()) == "null" ? ""
					: String.valueOf(crComEd09.getEe01ad01());
			values[i][4] = String.valueOf(crComEd09.getEe01ad02()) == "null" ? ""
					: String.valueOf(crComEd09.getEe01ad02());
			values[i][5] = String.valueOf(crComEd09.getEe01aj01()) == "null" ? ""
					: String.valueOf(crComEd09.getEe01aj01());
			values[i][6] = String.valueOf(crComEd09.getEe01ar01()) == "null" ? ""
					: String.valueOf(crComEd09.getEe01ar01());
			values[i][7] = String.valueOf(crComEd09.getEe01bs01()) == "null" ? ""
					: String.valueOf(crComEd09.getEe01bs01());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		sheet.autoSizeColumn((short) 7);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEe01bh(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-公共事业缴费信息";
		// 标题
		String[] title = new String[] { "序号", "序号", "统计年月", "缴费状态", "本月应缴金额", "本月实缴金额", "累计欠费金额" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EE01BH.xlsx";
		/*CrComEe01bh crComEe01bh = new CrComEe01bh();
		crComEe01bh.setBatchId(id);*/
		
		try {
			List<CrComEe01bh> crComEe01bhList = BaseDAOUtils.getCrComEe01bhDAO().findByIdProperties(id);
			createCrComEe01bhExcel(filepath, sheetName, title, fileName, crComEe01bhList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEe01bhExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEe01bh> crComEe01bhList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEe01bhList.size()][];
		for (int i = 0; i < crComEe01bhList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEe01bh crComEe01bh = crComEe01bhList.get(i);
			values[i][0] = String.valueOf(crComEe01bh.getId()) == "null" ? "" : String.valueOf(crComEe01bh.getId());
			values[i][1] = String.valueOf(crComEe01bh.getBatchId()) == "null" ? ""
					: String.valueOf(crComEe01bh.getBatchId());
			values[i][2] = String.valueOf(crComEe01bh.getEe01br01()) == "null" ? ""
					: String.valueOf(crComEe01bh.getEe01br01());
			values[i][3] = String.valueOf(crComEe01bh.getEe01bd01()) == "null" ? ""
					: String.valueOf(crComEe01bh.getEe01bd01());
			values[i][4] = String.valueOf(crComEe01bh.getEe01bj01()) == "null" ? ""
					: String.valueOf(crComEe01bh.getEe01bj01());
			values[i][5] = String.valueOf(crComEe01bh.getEe01bj02()) == "null" ? ""
					: String.valueOf(crComEe01bh.getEe01bj02());
			values[i][6] = String.valueOf(crComEe01bh.getEe01bj03()) == "null" ? ""
					: String.valueOf(crComEe01bh.getEe01bj03());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEfa(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-欠税记录信息";
		// 标题
		String[] title = new String[] { "序号", "欠税记录编号", "主管税务机关名称", "欠税总额", "欠税统计时间" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EFA.xlsx";
	/*	CrComEfa crComEfa = new CrComEfa();
		crComEfa.setId(id);*/
		
		try {
			List<CrComEfa> crComEfaList = BaseDAOUtils.getCrComEfaDAO().findByIdProperties(id);
			createCrComEfaExcel(filepath, sheetName, title, fileName, crComEfaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEfaExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEfa> crComEfaList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEfaList.size()][];
		for (int i = 0; i < crComEfaList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEfa crComEfa = crComEfaList.get(i);
			values[i][0] = String.valueOf(crComEfa.getId()) == "null" ? "" : String.valueOf(crComEfa.getId());
			values[i][1] = String.valueOf(crComEfa.getEf010i01()) == "null" ? ""
					: String.valueOf(crComEfa.getEf010i01());
			values[i][2] = String.valueOf(crComEfa.getEf010q01()) == "null" ? ""
					: String.valueOf(crComEfa.getEf010q01());
			values[i][3] = String.valueOf(crComEfa.getEf010j01()) == "null" ? ""
					: String.valueOf(crComEfa.getEf010j01());
			values[i][4] = String.valueOf(crComEfa.getEf010r01()) == "null" ? ""
					: String.valueOf(crComEfa.getEf010r01());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEfb(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-法院信息";
		// 标题
		String[] title = new String[] { "序号", "民事判决记录编号", "民事判决立案法院名称", "民事判决案号", "民事判决立案日期", "民事判决案由", "民事判决诉讼地位",
				"民事判决审判程序", "民事判决诉讼标的", "民事判决诉讼标的金额", "民事判决结案方式", "民事判决/调解生效日期", "民事判决/调解结果", "强制执行记录编号", "强制执行执行法院名称",
				"强制执行案号", "强制执行立案日期", "强制执行执行案由", "强制执行申请执行标的", "强制执行申请执行标的金额", "强制执行案件状态", "强制执行结案方式", "强制执行已执行标的",
				"强制执行已执行标的金额" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EFB.xlsx";
		/*CrComEfb crComEfb = new CrComEfb();
		crComEfb.setId(id);*/
		
		try {
			List<CrComEfb> crComEfbList = BaseDAOUtils.getCrComEfbDAO().findByIdProperties(id);
			createCrComEfbExcel(filepath, sheetName, title, fileName, crComEfbList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEfbExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEfb> crComEfbList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEfbList.size()][];
		for (int i = 0; i < crComEfbList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEfb crComEfb = crComEfbList.get(i);
			values[i][0] = String.valueOf(crComEfb.getId()) == "null" ? "" : String.valueOf(crComEfb.getId());
			values[i][1] = String.valueOf(crComEfb.getEf020i01()) == "null" ? ""
					: String.valueOf(crComEfb.getEf020i01());
			values[i][2] = String.valueOf(crComEfb.getEf020q01()) == "null" ? ""
					: String.valueOf(crComEfb.getEf020q01());
			values[i][3] = String.valueOf(crComEfb.getEf020i02()) == "null" ? ""
					: String.valueOf(crComEfb.getEf020i02());
			values[i][4] = String.valueOf(crComEfb.getEf020r01()) == "null" ? ""
					: String.valueOf(crComEfb.getEf020r01());
			values[i][5] = String.valueOf(crComEfb.getEf020q02()) == "null" ? ""
					: String.valueOf(crComEfb.getEf020q02());
			values[i][6] = String.valueOf(crComEfb.getEf020d01()) == "null" ? ""
					: String.valueOf(crComEfb.getEf020d01());
			values[i][7] = String.valueOf(crComEfb.getEf020d02()) == "null" ? ""
					: String.valueOf(crComEfb.getEf020d02());
			values[i][8] = String.valueOf(crComEfb.getEf020q03()) == "null" ? ""
					: String.valueOf(crComEfb.getEf020q03());
			values[i][9] = String.valueOf(crComEfb.getEf020j01()) == "null" ? ""
					: String.valueOf(crComEfb.getEf020j01());
			values[i][10] = String.valueOf(crComEfb.getEf020d03()) == "null" ? ""
					: String.valueOf(crComEfb.getEf020d03());
			values[i][11] = String.valueOf(crComEfb.getEf020r02()) == "null" ? ""
					: String.valueOf(crComEfb.getEf020r02());
			values[i][12] = String.valueOf(crComEfb.getEf020q04()) == "null" ? ""
					: String.valueOf(crComEfb.getEf020q04());
			values[i][13] = String.valueOf(crComEfb.getEf030i01()) == "null" ? ""
					: String.valueOf(crComEfb.getEf030i01());
			values[i][14] = String.valueOf(crComEfb.getEf030q01()) == "null" ? ""
					: String.valueOf(crComEfb.getEf030q01());
			values[i][15] = String.valueOf(crComEfb.getEf030i02()) == "null" ? ""
					: String.valueOf(crComEfb.getEf030i02());
			values[i][16] = String.valueOf(crComEfb.getEf030r01()) == "null" ? ""
					: String.valueOf(crComEfb.getEf030r01());
			values[i][17] = String.valueOf(crComEfb.getEf030q02()) == "null" ? ""
					: String.valueOf(crComEfb.getEf030q02());
			values[i][18] = String.valueOf(crComEfb.getEf030q03()) == "null" ? ""
					: String.valueOf(crComEfb.getEf030q03());
			values[i][19] = String.valueOf(crComEfb.getEf030j01()) == "null" ? ""
					: String.valueOf(crComEfb.getEf030j01());
			values[i][20] = String.valueOf(crComEfb.getEf030q04()) == "null" ? ""
					: String.valueOf(crComEfb.getEf030q04());
			values[i][21] = String.valueOf(crComEfb.getEf030d01()) == "null" ? ""
					: String.valueOf(crComEfb.getEf030d01());
			values[i][22] = String.valueOf(crComEfb.getEf030q05()) == "null" ? ""
					: String.valueOf(crComEfb.getEf030q05());
			values[i][23] = String.valueOf(crComEfb.getEf030j02()) == "null" ? ""
					: String.valueOf(crComEfb.getEf030j02());

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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		sheet.autoSizeColumn((short) 19);
		sheet.autoSizeColumn((short) 20);
		sheet.autoSizeColumn((short) 21);
		sheet.autoSizeColumn((short) 22);
		sheet.autoSizeColumn((short) 23);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEfc(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-行政处罚信息";
		// 标题
		String[] title = new String[] { "序号", "行政处罚记录编号", "处罚机构名称", "处罚决定书文号", "违法行为", "处罚决定", "处罚日期", "处罚金额", "处罚执行情况",
				"行政复议结果" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EFC.xlsx";
		/*CrComEfc crComEfc = new CrComEfc();
		crComEfc.setId(id);*/
		
		try {
			List<CrComEfc> crComEfcList = BaseDAOUtils.getCrComEfcDAO().findByIdProperties(id);
			createCrComEfcExcel(filepath, sheetName, title, fileName, crComEfcList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEfcExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEfc> crComEfcList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEfcList.size()][];
		for (int i = 0; i < crComEfcList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEfc crComEfc = crComEfcList.get(i);
			values[i][0] = String.valueOf(crComEfc.getId()) == "null" ? "" : String.valueOf(crComEfc.getId());
			values[i][1] = String.valueOf(crComEfc.getEf040i01()) == "null" ? ""
					: String.valueOf(crComEfc.getEf040i01());
			values[i][2] = String.valueOf(crComEfc.getEf040q01()) == "null" ? ""
					: String.valueOf(crComEfc.getEf040q01());
			values[i][3] = String.valueOf(crComEfc.getEf040i02()) == "null" ? ""
					: String.valueOf(crComEfc.getEf040i02());
			values[i][4] = String.valueOf(crComEfc.getEf040q02()) == "null" ? ""
					: String.valueOf(crComEfc.getEf040q02());
			values[i][5] = String.valueOf(crComEfc.getEf040q03()) == "null" ? ""
					: String.valueOf(crComEfc.getEf040q03());
			values[i][6] = String.valueOf(crComEfc.getEf040r01()) == "null" ? ""
					: String.valueOf(crComEfc.getEf040r01());
			values[i][7] = String.valueOf(crComEfc.getEf040j01()) == "null" ? ""
					: String.valueOf(crComEfc.getEf040j01());
			values[i][8] = String.valueOf(crComEfc.getEf040q04()) == "null" ? ""
					: String.valueOf(crComEfc.getEf040q04());
			values[i][9] = String.valueOf(crComEfc.getEf040q05()) == "null" ? ""
					: String.valueOf(crComEfc.getEf040q05());
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
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEfd(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-行政处罚信息";
		// 标题
		String[] title = new String[] { "序号", "账户编号", "初缴年月", "职工人数", "缴费基数", "最近一次缴费日期", "缴至年月", "缴费状态", "累计欠费金额",
				"统计年月", "缴费记录条数" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EFD.xlsx";
	/*	CrComEfd crComEfd = new CrComEfd();
		crComEfd.setId(id);*/
		
		try {
			List<CrComEfd> crComEfdList = BaseDAOUtils.getCrComEfdDAO().findByIdProperties(id);
			createCrComEfdExcel(filepath, sheetName, title, fileName, crComEfdList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEfdExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEfd> crComEfdList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEfdList.size()][];
		for (int i = 0; i < crComEfdList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEfd crComEfd = crComEfdList.get(i);
			values[i][0] = String.valueOf(crComEfd.getId()) == "null" ? "" : String.valueOf(crComEfd.getId());
			values[i][1] = String.valueOf(crComEfd.getEf05ai01()) == "null" ? ""
					: String.valueOf(crComEfd.getEf05ai01());
			values[i][2] = String.valueOf(crComEfd.getEf05ar01()) == "null" ? ""
					: String.valueOf(crComEfd.getEf05ar01());
			values[i][3] = String.valueOf(crComEfd.getEf05as01()) == "null" ? ""
					: String.valueOf(crComEfd.getEf05as01());
			values[i][4] = String.valueOf(crComEfd.getEf05aj01()) == "null" ? ""
					: String.valueOf(crComEfd.getEf05aj01());
			values[i][5] = String.valueOf(crComEfd.getEf05ar02()) == "null" ? ""
					: String.valueOf(crComEfd.getEf05ar02());
			values[i][6] = String.valueOf(crComEfd.getEf05ar03()) == "null" ? ""
					: String.valueOf(crComEfd.getEf05ar03());
			values[i][7] = String.valueOf(crComEfd.getEf05ad01()) == "null" ? ""
					: String.valueOf(crComEfd.getEf05ad01());
			values[i][8] = String.valueOf(crComEfd.getEf05aj02()) == "null" ? ""
					: String.valueOf(crComEfd.getEf05aj02());
			values[i][9] = String.valueOf(crComEfd.getEf05ar04()) == "null" ? ""
					: String.valueOf(crComEfd.getEf05ar04());
			values[i][10] = String.valueOf(crComEfd.getEf05bs01()) == "null" ? ""
					: String.valueOf(crComEfd.getEf05bs01());
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
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEf05bh(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-住房公积金缴费记录信息-过去 24 个月缴费情况信息段-缴费情况信息 ";
		// 标题
		String[] title = new String[] { "序号", "序号", "统计年月", "缴费状态", "本月应缴金额", "本月实缴金额", "累计欠费金额" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EF05BH.xlsx";
		/*CrComEf05bh crComEf05bh = new CrComEf05bh();
		crComEf05bh.setBatchId(id);*/
		
		try {
			List<CrComEf05bh> crComEf05bhList = BaseDAOUtils.getCrComEf05bhDAO().findByIdProperties(id);
			createCrComEf05bhExcel(filepath, sheetName, title, fileName, crComEf05bhList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEf05bhExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEf05bh> crComEf05bhList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEf05bhList.size()][];
		for (int i = 0; i < crComEf05bhList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEf05bh crComEf05bh = crComEf05bhList.get(i);
			values[i][0] = String.valueOf(crComEf05bh.getId()) == "null" ? "" : String.valueOf(crComEf05bh.getId());
			values[i][1] = String.valueOf(crComEf05bh.getBatchId()) == "null" ? ""
					: String.valueOf(crComEf05bh.getBatchId());
			values[i][2] = String.valueOf(crComEf05bh.getEf05br01()) == "null" ? ""
					: String.valueOf(crComEf05bh.getEf05br01());
			values[i][3] = String.valueOf(crComEf05bh.getEf05bd01()) == "null" ? ""
					: String.valueOf(crComEf05bh.getEf05bd01());
			values[i][4] = String.valueOf(crComEf05bh.getEf05bj01()) == "null" ? ""
					: String.valueOf(crComEf05bh.getEf05bj01());
			values[i][5] = String.valueOf(crComEf05bh.getEf05bj02()) == "null" ? ""
					: String.valueOf(crComEf05bh.getEf05bj02());
			values[i][6] = String.valueOf(crComEf05bh.getEf05bj03()) == "null" ? ""
					: String.valueOf(crComEf05bh.getEf05bj03());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEfe(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-获得认证奖励相关信息 ";
		// 标题
		String[] title = new String[] { "序号", "许可记录编号", "许可部门名称", "许可类型", "许可日期", "获得许可记录截止日期", "许可内容", "认证记录编号",
				"认证部门名称", "认证类型", "认证日期", "获得认证记录截止日期", "认证内容", "资质记录编号", "获得资质记录认定部门名称", "资质类型", "获得资质记录批准日期",
				"获得资质记录截止日期", "资质内容", "奖励记录编号", "奖励部门名称", "奖励名称", "获得奖励记录授予日期", "获得奖励记录截止日期", "奖励事实", "拥有专利信息编号",
				"专利名称", "专利号", "拥有专利申请日期", "拥有专利授予日期", "专利有效期" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EFE.xlsx";
		/*CrComEfe crComEfe = new CrComEfe();
		crComEfe.setId(id);*/
		
		try {
			List<CrComEfe> crComEfeList = BaseDAOUtils.getCrComEfeDAO().findByIdProperties(id);
			createCrComEfeExcel(filepath, sheetName, title, fileName, crComEfeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEfeExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEfe> crComEfeList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEfeList.size()][];
		for (int i = 0; i < crComEfeList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEfe crComEfe = crComEfeList.get(i);
			values[i][0] = String.valueOf(crComEfe.getId()) == "null" ? "" : String.valueOf(crComEfe.getId());
			values[i][1] = String.valueOf(crComEfe.getEf060i01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf060i01());
			values[i][2] = String.valueOf(crComEfe.getEf060q01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf060q01());
			values[i][3] = String.valueOf(crComEfe.getEf060q02()) == "null" ? ""
					: String.valueOf(crComEfe.getEf060q02());
			values[i][4] = String.valueOf(crComEfe.getEf060r01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf060r01());
			values[i][5] = String.valueOf(crComEfe.getEf060r02()) == "null" ? ""
					: String.valueOf(crComEfe.getEf060r02());
			values[i][6] = String.valueOf(crComEfe.getEf060q03()) == "null" ? ""
					: String.valueOf(crComEfe.getEf060q03());
			values[i][7] = String.valueOf(crComEfe.getEf070i01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf070i01());
			values[i][8] = String.valueOf(crComEfe.getEf070q01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf070q01());
			values[i][9] = String.valueOf(crComEfe.getEf070q02()) == "null" ? ""
					: String.valueOf(crComEfe.getEf070q02());
			values[i][10] = String.valueOf(crComEfe.getEf070r01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf070r01());
			values[i][11] = String.valueOf(crComEfe.getEf070r02()) == "null" ? ""
					: String.valueOf(crComEfe.getEf070r02());
			values[i][12] = String.valueOf(crComEfe.getEf070q03()) == "null" ? ""
					: String.valueOf(crComEfe.getEf070q03());
			values[i][13] = String.valueOf(crComEfe.getEf080i01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf080i01());
			values[i][14] = String.valueOf(crComEfe.getEf080q01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf080q01());
			values[i][15] = String.valueOf(crComEfe.getEf080q02()) == "null" ? ""
					: String.valueOf(crComEfe.getEf080q02());
			values[i][16] = String.valueOf(crComEfe.getEf080r01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf080r01());
			values[i][17] = String.valueOf(crComEfe.getEf080r02()) == "null" ? ""
					: String.valueOf(crComEfe.getEf080r02());
			values[i][18] = String.valueOf(crComEfe.getEf080q03()) == "null" ? ""
					: String.valueOf(crComEfe.getEf080q03());
			values[i][19] = String.valueOf(crComEfe.getEf090i01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf090i01());
			values[i][20] = String.valueOf(crComEfe.getEf090q01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf090q01());
			values[i][21] = String.valueOf(crComEfe.getEf090q02()) == "null" ? ""
					: String.valueOf(crComEfe.getEf090q02());
			values[i][22] = String.valueOf(crComEfe.getEf090r01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf090r01());
			values[i][23] = String.valueOf(crComEfe.getEf090r02()) == "null" ? ""
					: String.valueOf(crComEfe.getEf090r02());
			values[i][24] = String.valueOf(crComEfe.getEf090q03()) == "null" ? ""
					: String.valueOf(crComEfe.getEf090q03());
			values[i][25] = String.valueOf(crComEfe.getEf100i01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf100i01());
			values[i][26] = String.valueOf(crComEfe.getEf100q01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf100q01());
			values[i][27] = String.valueOf(crComEfe.getEf100i02()) == "null" ? ""
					: String.valueOf(crComEfe.getEf100i02());
			values[i][28] = String.valueOf(crComEfe.getEf100r01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf100r01());
			values[i][29] = String.valueOf(crComEfe.getEf100r02()) == "null" ? ""
					: String.valueOf(crComEfe.getEf100r02());
			values[i][30] = String.valueOf(crComEfe.getEf100s01()) == "null" ? ""
					: String.valueOf(crComEfe.getEf100s01());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		sheet.autoSizeColumn((short) 19);
		sheet.autoSizeColumn((short) 20);
		sheet.autoSizeColumn((short) 21);
		sheet.autoSizeColumn((short) 22);
		sheet.autoSizeColumn((short) 23);
		sheet.autoSizeColumn((short) 24);
		sheet.autoSizeColumn((short) 25);
		sheet.autoSizeColumn((short) 26);
		sheet.autoSizeColumn((short) 27);
		sheet.autoSizeColumn((short) 28);
		sheet.autoSizeColumn((short) 29);
		sheet.autoSizeColumn((short) 30);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEff(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-进出口检验相关信息";
		// 标题
		String[] title = new String[] { "序号", "出入境检验检疫绿色通道信息信息编号", "出入境检验检疫绿色通道信息批准部门名称", "出入境检验检疫绿色通道信息出口商品名称",
				"出入境检验检疫绿色通道信息生效日期", "进出口商品免验信息信息编号", "进出口商品免验信息批准部门名称", "进出口商品免验信息免验商品名称", "进出口商品免验信息免验号",
				"进出口商品免验信息截至日期", "进出口商品检验分类监管信息编号", "进出口商品检验分类监管监管部门名称", "进出口商品检验分类监管管辖直属局", "进出口商品检验分类监管监管级别",
				"进出口商品检验分类监管生效日期", "进出口商品检验分类监管截至日期" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EFF.xlsx";
		/*CrComEff crComEff = new CrComEff();
		crComEff.setId(id);*/
		
		try {
			List<CrComEff> crComEffList = BaseDAOUtils.getCrComEffDAO().findByIdProperties(id);
			createCrComEffExcel(filepath, sheetName, title, fileName, crComEffList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEffExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEff> crComEffList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEffList.size()][];
		for (int i = 0; i < crComEffList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEff crComEff = crComEffList.get(i);
			values[i][0] = String.valueOf(crComEff.getId()) == "null" ? "" : String.valueOf(crComEff.getId());
			values[i][1] = String.valueOf(crComEff.getEf110i01()) == "null" ? ""
					: String.valueOf(crComEff.getEf110i01());
			values[i][2] = String.valueOf(crComEff.getEf110q01()) == "null" ? ""
					: String.valueOf(crComEff.getEf110q01());
			values[i][3] = String.valueOf(crComEff.getEf110q02()) == "null" ? ""
					: String.valueOf(crComEff.getEf110q02());
			values[i][4] = String.valueOf(crComEff.getEf110r01()) == "null" ? ""
					: String.valueOf(crComEff.getEf110r01());
			values[i][5] = String.valueOf(crComEff.getEf120i01()) == "null" ? ""
					: String.valueOf(crComEff.getEf120i01());
			values[i][6] = String.valueOf(crComEff.getEf120q01()) == "null" ? ""
					: String.valueOf(crComEff.getEf120q01());
			values[i][7] = String.valueOf(crComEff.getEf120q02()) == "null" ? ""
					: String.valueOf(crComEff.getEf120q02());
			values[i][8] = String.valueOf(crComEff.getEf120i02()) == "null" ? ""
					: String.valueOf(crComEff.getEf120i02());
			values[i][9] = String.valueOf(crComEff.getEf120r02()) == "null" ? ""
					: String.valueOf(crComEff.getEf120r02());
			values[i][10] = String.valueOf(crComEff.getEf130i01()) == "null" ? ""
					: String.valueOf(crComEff.getEf130i01());
			values[i][11] = String.valueOf(crComEff.getEf130q01()) == "null" ? ""
					: String.valueOf(crComEff.getEf130q01());
			values[i][12] = String.valueOf(crComEff.getEf130q02()) == "null" ? ""
					: String.valueOf(crComEff.getEf130q02());
			values[i][13] = String.valueOf(crComEff.getEf130q02()) == "null" ? ""
					: String.valueOf(crComEff.getEf130d01());
			values[i][14] = String.valueOf(crComEff.getEf130r01()) == "null" ? ""
					: String.valueOf(crComEff.getEf130r01());
			values[i][15] = String.valueOf(crComEff.getEf130r02()) == "null" ? ""
					: String.valueOf(crComEff.getEf130r02());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEfg(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-融资规模控制信息";
		// 标题
		String[] title = new String[] { "序号", "信息编号", "所属名录", "融资控制类型", "年度", "规模" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EFG.xlsx";
		/*CrComEfg crComEfg = new CrComEfg();
		crComEfg.setId(id);*/
		
		try {
			List<CrComEfg> crComEfgList = BaseDAOUtils.getCrComEfgDAO().findByIdProperties(id);
			createCrComEfgExcel(filepath, sheetName, title, fileName, crComEfgList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEfgExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEfg> crComEfgList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEfgList.size()][];
		for (int i = 0; i < crComEfgList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEfg crComEfg = crComEfgList.get(i);
			values[i][0] = String.valueOf(crComEfg.getId()) == "null" ? "" : String.valueOf(crComEfg.getId());
			values[i][1] = String.valueOf(crComEfg.getEf140i01()) == "null" ? ""
					: String.valueOf(crComEfg.getEf140i01());
			values[i][2] = String.valueOf(crComEfg.getEf140d01()) == "null" ? ""
					: String.valueOf(crComEfg.getEf140d01());
			values[i][3] = String.valueOf(crComEfg.getEf140d02()) == "null" ? ""
					: String.valueOf(crComEfg.getEf140d02());
			values[i][4] = String.valueOf(crComEfg.getEf140r01()) == "null" ? ""
					: String.valueOf(crComEfg.getEf140r01());
			values[i][5] = String.valueOf(crComEfg.getEf140j01()) == "null" ? ""
					: String.valueOf(crComEfg.getEf140j01());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEga(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-财务信息";
		// 标题
		String[] title = new String[] { " 序号                                                                        ",
				" 企业资产负债表（2002 版）信息财务报表编号                                   ",
				" 企业资产负债表（2002 版）信息业务管理机构                                   ",
				" 企业资产负债表（2002 版）信息业务管理机构代码                               ",
				" 企业资产负债表（2002 版）信息报表年份                                       ",
				" 企业资产负债表（2002 版）信息报表类型                                       ",
				" 企业资产负债表（2002 版）信息报表类型细分                                   ",
				" 企业资产负债表（2002 版）信息货币资金                                       ",
				" 企业资产负债表（2002 版）信息短期投资                                       ",
				" 企业资产负债表（2002 版）信息应收票据                                       ",
				" 企业资产负债表（2002 版）信息应收股利                                       ",
				" 企业资产负债表（2002 版）信息应收利息                                       ",
				" 企业资产负债表（2002 版）信息应收账款                                       ",
				" 企业资产负债表（2002 版）信息其他应收款                                     ",
				" 企业资产负债表（2002 版）信息预付账款                                       ",
				" 企业资产负债表（2002 版）信息期货保证金                                     ",
				" 企业资产负债表（2002 版）信息应收补贴款                                     ",
				" 企业资产负债表（2002 版）信息应收出口退税                                   ",
				" 企业资产负债表（2002 版）信息存货                                           ",
				" 企业资产负债表（2002 版）信息存货原材料                                     ",
				" 企业资产负债表（2002 版）信息存货产成品                                     ",
				" 企业资产负债表（2002 版）信息待摊费用                                       ",
				" 企业资产负债表（2002 版）信息待处理流动资产净损失                           ",
				" 企业资产负债表（2002 版）信息一年内到期的长期债权投资                       ",
				" 企业资产负债表（2002 版）信息其他流动资产                                   ",
				" 企业资产负债表（2002 版）信息流动资产合计                                   ",
				" 企业资产负债表（2002 版）信息长期投资                                       ",
				" 企业资产负债表（2002 版）信息长期股权投资                                   ",
				" 企业资产负债表（2002 版）信息长期债权投资                                   ",
				" 企业资产负债表（2002 版）信息合并价差                                       ",
				" 企业资产负债表（2002 版）信息长期投资合计                                   ",
				" 企业资产负债表（2002 版）信息固定资产原价                                   ",
				" 企业资产负债表（2002 版）信息累计折旧                                       ",
				" 企业资产负债表（2002 版）信息固定资产净值                                   ",
				" 企业资产负债表（2002 版）信息固定资产值减值准备                             ",
				" 企业资产负债表（2002 版）信息固定资产净额                                   ",
				" 企业资产负债表（2002 版）信息固定资产清理                                   ",
				" 企业资产负债表（2002 版）信息工程物资                                       ",
				" 企业资产负债表（2002 版）信息在建工程                                       ",
				" 企业资产负债表（2002 版）信息待处理固定资产净损失                           ",
				" 企业资产负债表（2002 版）信息固定资产合计                                   ",
				" 企业资产负债表（2002 版）信息无形资产                                       ",
				" 企业资产负债表（2002 版）信息（无形资产科目下）土地使用权                   ",
				" 企业资产负债表（2002 版）信息递延资产                                       ",
				" 企业资产负债表（2002 版）信息（递延资产科目下）固定资产修理                 ",
				" 企业资产负债表（2002 版）信息（递延资产科目下）固定资产改良支出             ",
				" 企业资产负债表（2002 版）信息其他长期资产                                   ",
				" 企业资产负债表（2002 版）信息（其他长期资产科目下）特准储备物资             ",
				" 企业资产负债表（2002 版）信息无形及其他资产合计                             ",
				" 企业资产负债表（2002 版）信息递延税款借项                                   ",
				" 企业资产负债表（2002 版）信息资产总计                                       ",
				" 企业资产负债表（2002 版）信息短期借款                                       ",
				" 企业资产负债表（2002 版）信息应付票据                                       ",
				" 企业资产负债表（2002 版）信息应付账款                                       ",
				" 企业资产负债表（2002 版）信息预收账款                                       ",
				" 企业资产负债表（2002 版）信息应付工资                                       ",
				" 企业资产负债表（2002 版）信息应付福利费                                     ",
				" 企业资产负债表（2002 版）信息应付利润                                       ",
				" 企业资产负债表（2002 版）信息应交税金                                       ",
				" 企业资产负债表（2002 版）信息其他应交款                                     ",
				" 企业资产负债表（2002 版）信息其他应付款                                     ",
				" 企业资产负债表（2002 版）信息预提费用                                       ",
				" 企业资产负债表（2002 版）信息预计负债                                       ",
				" 企业资产负债表（2002 版）信息一年内到期的长期负债                           ",
				" 企业资产负债表（2002 版）信息其他流动负债                                   ",
				" 企业资产负债表（2002 版）信息流动负债合计                                   ",
				" 企业资产负债表（2002 版）信息长期借款                                       ",
				" 企业资产负债表（2002 版）信息应付债券                                       ",
				" 企业资产负债表（2002 版）信息长期应付款                                     ",
				" 企业资产负债表（2002 版）信息专项应付款                                     ",
				" 企业资产负债表（2002 版）信息其他长期负债                                   ",
				" 企业资产负债表（2002 版）信息（其他长期负债科目下）特准储备基金             ",
				" 企业资产负债表（2002 版）信息长期负债合计                                   ",
				" 企业资产负债表（2002 版）信息递延税款贷项                                   ",
				" 企业资产负债表（2002 版）信息负债合计                                       ",
				" 企业资产负债表（2002 版）信息少数股东权益                                   ",
				" 企业资产负债表（2002 版）信息实收资本                                       ",
				" 企业资产负债表（2002 版）信息国家资本                                       ",
				" 企业资产负债表（2002 版）信息集体资本                                       ",
				" 企业资产负债表（2002 版）信息法人资本                                       ",
				" 企业资产负债表（2002 版）信息（法人资本科目下）国有法人资本                 ",
				" 企业资产负债表（2002 版）信息（法人资本科目下）集体法人资本                 ",
				" 企业资产负债表（2002 版）信息个人资本                                       ",
				" 企业资产负债表（2002 版）信息外商资本                                       ",
				" 企业资产负债表（2002 版）信息资本公积                                       ",
				" 企业资产负债表（2002 版）信息盈余公积                                       ",
				" （盈余公积科目下）法定盈余公积                                              ",
				" （盈余公积科目下）公益金                                                    ",
				" 企业资产负债表（2002 版）信息（盈余公积科目下）补充流动资本                 ",
				" 企业资产负债表（2002 版）信息未确认的投资损失                               ",
				" 企业资产负债表（2002 版）信息未分配利润                                     ",
				" 企业资产负债表（2002 版）信息外币报表折算差额                               ",
				" 企业资产负债表（2002 版）信息所有者权益合计                                 ",
				" 企业资产负债表（2002 版）信息负债和所有者权益总计                           ",
				" 企业资产负债表（2007 版）信息财务报表编号                                   ",
				" 企业资产负债表（2007 版）信息业务管理机构                                   ",
				" 企业资产负债表（2007 版）信息业务管理机构代码                               ",
				" 企业资产负债表（2007 版）信息报表年份                                       ",
				" 企业资产负债表（2007 版）信息报表类型                                       ",
				" 企业资产负债表（2007 版）信息报表类型细分                                   ",
				" 企业资产负债表（2007 版）信息货币资金                                       ",
				" 企业资产负债表（2007 版）信息交易性金融资产                                 ",
				" 企业资产负债表（2007 版）信息应收票据                                       ",
				" 企业资产负债表（2007 版）信息应收账款                                       ",
				" 企业资产负债表（2007 版）信息预付账款                                       ",
				" 企业资产负债表（2007 版）信息应收利息                                       ",
				" 企业资产负债表（2007 版）信息应收股利                                       ",
				" 企业资产负债表（2007 版）信息其他应收款                                     ",
				" 企业资产负债表（2007 版）信息存货                                           ",
				" 企业资产负债表（2007 版）信息一年内到期的非流动资产                         ",
				" 企业资产负债表（2007 版）信息其他流动资产                                   ",
				" 企业资产负债表（2007 版）信息流动资产合计                                   ",
				" 企业资产负债表（2007 版）信息可供出售的金融资产                             ",
				" 企业资产负债表（2007 版）信息持有至到期投资                                 ",
				" 企业资产负债表（2007 版）信息长期股权投资                                   ",
				" 企业资产负债表（2007 版）信息长期应收款                                     ",
				" 企业资产负债表（2007 版）信息投资性房地产                                   ",
				" 企业资产负债表（2007 版）信息固定资产                                       ",
				" 企业资产负债表（2007 版）信息在建工程                                       ",
				" 企业资产负债表（2007 版）信息工程物资                                       ",
				" 企业资产负债表（2007 版）信息固定资产清理                                   ",
				" 企业资产负债表（2007 版）信息生产性生物资产                                 ",
				" 企业资产负债表（2007 版）信息油气资产                                       ",
				" 企业资产负债表（2007 版）信息无形资产                                       ",
				" 企业资产负债表（2007 版）信息开发支出                                       ",
				" 企业资产负债表（2007 版）信息商誉                                           ",
				" 企业资产负债表（2007 版）信息长期待摊费用                                   ",
				" 企业资产负债表（2007 版）信息递延所得税资产                                 ",
				" 企业资产负债表（2007 版）信息其他非流动资产                                 ",
				" 企业资产负债表（2007 版）信息非流动资产合计                                 ",
				" 企业资产负债表（2007 版）信息资产总计                                       ",
				" 企业资产负债表（2007 版）信息短期借款                                       ",
				" 企业资产负债表（2007 版）信息交易性金融负债                                 ",
				" 企业资产负债表（2007 版）信息应付票据                                       ",
				" 企业资产负债表（2007 版）信息应付账款                                       ",
				" 企业资产负债表（2007 版）信息预收账款                                       ",
				" 企业资产负债表（2007 版）信息应付利息                                       ",
				" 企业资产负债表（2007 版）信息应付职工薪酬                                   ",
				" 企业资产负债表（2007 版）信息应交税费                                       ",
				" 企业资产负债表（2007 版）信息应付股利                                       ",
				" 企业资产负债表（2007 版）信息其他应付款                                     ",
				" 企业资产负债表（2007 版）信息一年内到期的非流动负债                         ",
				" 企业资产负债表（2007 版）信息其他流动负债                                   ",
				" 企业资产负债表（2007 版）信息流动负债合计                                   ",
				" 企业资产负债表（2007 版）信息长期借款                                       ",
				" 企业资产负债表（2007 版）信息应付债券                                       ",
				" 企业资产负债表（2007 版）信息长期应付款                                     ",
				" 企业资产负债表（2007 版）信息专项应付款                                     ",
				" 企业资产负债表（2007 版）信息预计负债                                       ",
				" 企业资产负债表（2007 版）信息递延所得税负债                                 ",
				" 企业资产负债表（2007 版）信息其他非流动负债                                 ",
				" 企业资产负债表（2007 版）信息非流动负债合计                                 ",
				" 企业资产负债表（2007 版）信息负债合计                                       ",
				" 企业资产负债表（2007 版）信息实收资本（或股本）                             ",
				" 企业资产负债表（2007 版）信息资本公积                                       ",
				" 企业资产负债表（2007 版）信息减：库存股                                     ",
				" 企业资产负债表（2007 版）信息盈余公积                                       ",
				" 企业资产负债表（2007 版）信息未分配利润                                     ",
				" 企业资产负债表（2007 版）信息所有者权益合计                                 ",
				" 企业资产负债表（2007 版）信息负债和所有者权益合计                           ",
				" 企业利润及利润分配表（2002 版）信息财务报表编号                             ",
				" 企业利润及利润分配表（2002 版）信息业务管理机构                             ",
				" 企业利润及利润分配表（2002 版）信息业务管理机构代码                         ",
				" 企业利润及利润分配表（2002 版）信息报表年份                                 ",
				" 企业利润及利润分配表（2002 版）信息报表类型                                 ",
				" 企业利润及利润分配表（2002 版）信息报表类型细分                             ",
				" 企业利润及利润分配表（2002 版）信息主营业务收入                             ",
				" 企业利润及利润分配表（2002 版）信息（主营业务收入科目下）出口产品销售收入   ", " 企业利润及利润分配表（2002 版）信息（主营业务收入科目下）进口产品销售收入   ",
				" 企业利润及利润分配表（2002 版）信息销售折扣与折让                           ",
				" 企业利润及利润分配表（2002 版）信息主营业务收入净额                         ",
				" 企业利润及利润分配表（2002 版）信息主营业务成本                             ",
				" 企业利润及利润分配表（2002 版）信息（主营业务成本科目下）出口产品销售成本   ", " 企业利润及利润分配表（2002 版）信息主营业务税金及附加                       ",
				" 企业利润及利润分配表（2002 版）信息经营费用                                  ",
				" 企业利润及利润分配表（2002 版）信息其他（业务成本）                          ",
				" 企业利润及利润分配表（2002 版）信息递延收益                                  ",
				" 企业利润及利润分配表（2002 版）信息代购代销收入                              ",
				" 企业利润及利润分配表（2002 版）信息其他（收入）                              ",
				" 企业利润及利润分配表（2002 版）信息主营业务利润                              ",
				" 企业利润及利润分配表（2002 版）信息其他业务利润                              ",
				" 企业利润及利润分配表（2002 版）信息营业费用                                  ",
				" 企业利润及利润分配表（2002 版）信息管理费用                                  ",
				" 企业利润及利润分配表（2002 版）信息财务费用                                  ",
				" 企业利润及利润分配表（2002 版）信息其他（费用）                              ",
				" 企业利润及利润分配表（2002 版）信息营业利润                                  ",
				" 企业利润及利润分配表（2002 版）信息投资收益                                  ",
				" 企业利润及利润分配表（2002 版）信息期货收益                                  ",
				" 企业利润及利润分配表（2002 版）信息补贴收入                                  ",
				" 企业利润及利润分配表（2002 版）信息（补贴收入科目下）补贴前亏损的企业补贴收入        ",
				" 营业外收入                                                                           ",
				" 企业利润及利润分配表（2002 版）信息（营业外收入科目下）处置固定资产净收益            ",
				" 企业利润及利润分配表（2002 版）信息（营业外收入科目下）非货币性交易收益              ",
				" 企业利润及利润分配表（2002 版）信息（营业外收入科目下）出售无形资产收益              ",
				" 企业利润及利润分配表（2002 版）信息（营业外收入科目下）罚款净收入                    ",
				" 企业利润及利润分配表（2002 版）信息其他（利润）                                      ",
				" 企业利润及利润分配表（2002 版）信息（其他科目下）用以前年度含量工资节余弥补利润      ",
				" 企业利润及利润分配表（2002 版）信息营业外支出                                        ",
				" 企业利润及利润分配表（2002 版）信息（营业外支出科目下）处置固定资产净损失            ",
				" 企业利润及利润分配表（2002 版）信息（营业外支出科目下）债务重组损失                  ",
				" 企业利润及利润分配表（2002 版）信息（营业外支出科目下）罚款支出                      ",
				" 企业利润及利润分配表（2002 版）信息（营业外支出科目下）捐赠支出                      ",
				" 企业利润及利润分配表（2002 版）信息其他支出                                          ",
				" 企业利润及利润分配表（2002 版）信息（其他支出）结转的含量工资包干节余                ",
				" 企业利润及利润分配表（2002 版）信息利润总额                                          ",
				" 企业利润及利润分配表（2002 版）信息所得税                                            ",
				" 企业利润及利润分配表（2002 版）信息少数股东损益                                      ",
				" 企业利润及利润分配表（2002 版）信息未确认的投资损失                                  ",
				" 企业利润及利润分配表（2002 版）信息净利润                                            ",
				" 企业利润及利润分配表（2002 版）信息年初未分配利润                                    ",
				" 企业利润及利润分配表（2002 版）信息盈余公积补亏                                      ",
				" 企业利润及利润分配表（2002 版）信息其他调整因素                                      ",
				" 企业利润及利润分配表（2002 版）信息可供分配的利润                                    ",
				" 企业利润及利润分配表（2002 版）信息单项留用的利润                                    ",
				" 企业利润及利润分配表（2002 版）信息补充流动资本                                      ",
				" 企业利润及利润分配表（2002 版）信息提取法定盈余公积                                  ",
				" 企业利润及利润分配表（2002 版）信息提取法定公益金                                    ",
				" 企业利润及利润分配表（2002 版）信息提取职工奖励及福利基金                            ",
				" 企业利润及利润分配表（2002 版）信息提取储备基金                                      ",
				" 企业利润及利润分配表（2002 版）信息提取企业发展基金                                  ",
				" 企业利润及利润分配表（2002 版）信息利润归还投资                                      ",
				" 企业利润及利润分配表（2002 版）信息（可供分配的利润科目下）其他                      ",
				" 企业利润及利润分配表（2002 版）信息可供投资者分配的利润                              ",
				" 企业利润及利润分配表（2002 版）信息应付优先股股利                                    ",
				" 企业利润及利润分配表（2002 版）信息提取任意盈余公积                                  ",
				" 企业利润及利润分配表（2002 版）信息应付普通股股利                                    ",
				" 企业利润及利润分配表（2002 版）信息转作资本的普通股股利                              ",
				" 企业利润及利润分配表（2002 版）信息（可供投资者分配的利润科目下）其他                ",
				" 企业利润及利润分配表（2002 版）信息未分配利润                                        ",
				" 企业利润及利润分配表（2002 版）信息（未分配利润科目下）应由以后年度税前利润弥补的亏损",
				" 企业利润及利润分配表（2007 版）信息财务报表编号                                      ",
				" 企业利润及利润分配表（2007 版）信息业务管理机构                                      ",
				" 企业利润及利润分配表（2007 版）信息业务管理机构代码                                  ",
				" 企业利润及利润分配表（2007 版）信息报表年份                                          ",
				" 企业利润及利润分配表（2007 版）信息报表类型                                          ",
				" 企业利润及利润分配表（2007 版）信息报表类型细分                                      ",
				" 企业利润及利润分配表（2007 版）信息营业收入                                          ",
				" 企业利润及利润分配表（2007 版）信息营业成本                                          ",
				" 企业利润及利润分配表（2007 版）信息营业税金及附加                                    ",
				" 企业利润及利润分配表（2007 版）信息销售费用                                          ",
				" 企业利润及利润分配表（2007 版）信息管理费用                                          ",
				" 企业利润及利润分配表（2007 版）信息财务费用                                          ",
				" 企业利润及利润分配表（2007 版）信息资产减值损失                                      ",
				" 企业利润及利润分配表（2007 版）信息公允价值变动净收益                                ",
				" 企业利润及利润分配表（2007 版）信息投资净收益                                        ",
				" 企业利润及利润分配表（2007 版）信息对联营企业和合营企业的投资收益                    ",
				" 企业利润及利润分配表（2007 版）信息营业利润                                          ",
				" 企业利润及利润分配表（2007 版）信息营业外收入                                        ",
				" 企业利润及利润分配表（2007 版）信息营业外支出                                        ",
				" 企业利润及利润分配表（2007 版）信息非流动资产损失（其中：非流动资产处置损失）        ",
				" 企业利润及利润分配表（2007 版）信息利润总额                                          ",
				" 企业利润及利润分配表（2007 版）信息所得税费用                                        ",
				" 企业利润及利润分配表（2007 版）信息净利润                                            ",
				" 企业利润及利润分配表（2007 版）信息基本每股收益                                      ",
				" 企业利润及利润分配表（2007 版）信息稀释每股收益                                      ",
				" 企业现金流量表（2002 版）信息财务报表编号                                            ",
				" 企业现金流量表（2002 版）信息业务管理机构                                            ",
				" 企业现金流量表（2002 版）信息业务管理机构代码                                        ",
				" 企业现金流量表（2002 版）信息报表年份                                                ",
				" 企业现金流量表（2002 版）信息报表类型                                                ",
				" 企业现金流量表（2002 版）信息报表类型细分                                            ",
				" 企业现金流量表（2002 版）信息销售商品和提供劳务收到的现金                            ",
				" 企业现金流量表（2002 版）信息收到的税费返还                                          ",
				" 企业现金流量表（2002 版）信息收到的其他与经营活动有关的现金                          ",
				" 企业现金流量表（2002 版）信息经营活动现金流入小计                                    ",
				" 企业现金流量表（2002 版）信息购买商品、接受劳务支付的现金                            ",
				" 企业现金流量表（2002 版）信息支付给职工以及为职工支付的现金                          ",
				" 企业现金流量表（2002 版）信息支付的各项税费                                          ",
				" 企业现金流量表（2002 版）信息支付的其他与经营活动有关的现金                          ",
				" 企业现金流量表（2002 版）信息经营活动现金流出小计                                    ",
				" 企业现金流量表（2002 版）信息经营活动产生的现金流量净额                              ",
				" 企业现金流量表（2002 版）信息收回投资所收到的现金                                    ",
				" 企业现金流量表（2002 版）信息取得投资收益所收到的现金                                ",
				" 企业现金流量表（2002 版）信息处置固定资产无形资产和其他长期资产所收回的现金净额      ",
				" 企业现金流量表（2002 版）信息收到的其他与投资活动有关的现金                          ",
				" 企业现金流量表（2002 版）信息投资活动现金流入小计                                    ",
				" 企业现金流量表（2002 版）信息购建固定资产无形资产和其他长期资产所支付的现金          ",
				" 企业现金流量表（2002 版）信息投资所支付的现金                                        ",
				" 企业现金流量表（2002 版）信息支付的其他与投资活动有关的现金                          ",
				" 企业现金流量表（2002 版）信息投资活动现金流出小计                                    ",
				" 企业现金流量表（2002 版）信息投资活动产生的现金流量净额                              ",
				" 企业现金流量表（2002 版）信息吸收投资所收到的现金                                    ",
				" 企业现金流量表（2002 版）信息借款所收到的现金                                        ",
				" 企业现金流量表（2002 版）信息收到的其他与筹资活动有关的现金                          ",
				" 企业现金流量表（2002 版）信息筹资活动现金流入小计                                    ",
				" 企业现金流量表（2002 版）信息偿还债务所支付的现金                                    ",
				" 企业现金流量表（2002 版）信息分配股利、利润或偿付利息所支付的现金                    ",
				" 企业现金流量表（2002 版）信息支付的其他与筹资活动有关的现金                          ",
				" 企业现金流量表（2002 版）信息筹资活动现金流出小计                                    ",
				" 企业现金流量表（2002 版）信息筹集活动产生的现金流量净额                              ",
				" 企业现金流量表（2002 版）信息汇率变动对现金的影响                                    ",
				" 企业现金流量表（2002 版）信息现金及现金等价物净增加额                                ",
				" 企业现金流量表（2002 版）信息净利润                                                  ",
				" 企业现金流量表（2002 版）信息计提的资产减值准备                                      ",
				" 企业现金流量表（2002 版）信息固定资产拆旧                                            ",
				" 企业现金流量表（2002 版）信息无形资产摊销                                            ",
				" 企业现金流量表（2002 版）信息长期待摊费用摊销                                        ",
				" 企业现金流量表（2002 版）信息待摊费用减少                                            ",
				" 企业现金流量表（2002 版）信息用增加                                                  ",
				" 企业现金流量表（2002 版）信息处置固定资产无形资产和其他长期资产的损失                ",
				" 企业现金流量表（2002 版）信息企业现金流量表（2002 版）信息固定资产报废损失           ",
				" 企业现金流量表（2002 版）信息财务费用                                                ",
				" 企业现金流量表（2002 版）信息投资损失                                                ",
				" 企业现金流量表（2002 版）信息递延税款贷项                                            ",
				" 企业现金流量表（2002 版）信息存货的减少                                              ",
				" 企业现金流量表（2002 版）信息经营性应收项目的减少                                    ",
				" 企业现金流量表（2002 版）信息经营性应付项目的增加                                    ",
				" 企业现金流量表（2002 版）信息（净利润调节为经营活动现金流量科目下）其他              ",
				" 企业现金流量表（2002 版）信息经营活动产生的现金流量净额                              ",
				" 企业现金流量表（2002 版）信息债务转为资本                                            ",
				" 企业现金流量表（2002 版）信息一年内到期的可转换公司债券                              ",
				" 企业现金流量表（2002 版）信息融资租入固定资产                                        ",
				" 企业现金流量表（2002 版）信息（不涉及现金收支的投资和筹资活动科目下）其他            ",
				" 企业现金流量表（2002 版）信息现金的期末余额                                          ",
				" 企业现金流量表（2002 版）信息现金的期初余额                                          ",
				" 企业现金流量表（2002 版）信息现金等价物的期末余额                                    ",
				" 企业现金流量表（2002 版）信息现金等价物的期初余额                                    ",
				" 企业现金流量表（2002 版）信息现金及现金等价物净增加额                                ",
				" 企业现金流量表（2007 版）信息财务报表编号                                            ",
				" 企业现金流量表（2007 版）信息业务管理机构                                            ",
				" 企业现金流量表（2007 版）信息业务管理机构代码                                        ",
				" 企业现金流量表（2007 版）信息报表年份                                                ",
				" 企业现金流量表（2007 版）信息报表类型                                                ",
				" 企业现金流量表（2007 版）信息报表类型细分                                            ",
				" 企业现金流量表（2007 版）信息销售商品和提供劳务收到的现金                            ",
				" 企业现金流量表（2007 版）信息收到的税费返还                                          ",
				" 企业现金流量表（2007 版）信息收到其他与经营活动有关的现金                            ",
				" 企业现金流量表（2007 版）信息经营活动现金流入小计                                    ",
				" 企业现金流量表（2007 版）信息购买商品、接受劳务支付的现金                            ",
				" 企业现金流量表（2007 版）信息支付给职工以及为职工支付的现金                          ",
				" 企业现金流量表（2007 版）信息支付的各项税费                                          ",
				" 企业现金流量表（2007 版）信息支付其他与经营活动有关的现金                            ",
				" 企业现金流量表（2007 版）信息经营活动现金流出小计                                    ",
				" 企业现金流量表（2007 版）信息经营活动产生的现金流量净额                              ",
				" 企业现金流量表（2007 版）信息收回投资所收到的现金                                    ",
				" 企业现金流量表（2007 版）信息取得投资收益所收到的现金                                ",
				" 企业现金流量表（2007 版）信息处置固定资产无形资产和其他长期资产所收回的现金净额      ",
				" 企业现金流量表（2007 版）信息处置子公司及其他营业单位收到的现金净额                  ",
				" 企业现金流量表（2007 版）信息收到其他与投资活动有关的现金                            ",
				" 企业现金流量表（2007 版）信息投资活动现金流入小计                                    ",
				" 企业现金流量表（2007 版）信息购建固定资产无形资产和其他长期资产所支付的现金          ",
				" 企业现金流量表（2007 版）信息投资所支付的现金                                        ",
				" 企业现金流量表（2007 版）信息取得子公司及其他营业单位支付的现金净额                  ",
				" 企业现金流量表（2007 版）信息支付其他与投资活动有关的现金                            ",
				" 企业现金流量表（2007 版）信息投资活动现金流出小计                                    ",
				" 企业现金流量表（2007 版）信息投资活动产生的现金流量净额                              ",
				" 企业现金流量表（2007 版）信息吸收投资收到的现金                                      ",
				" 企业现金流量表（2007 版）信息取得借款收到的现金                                      ",
				" 企业现金流量表（2007 版）信息收到其他与筹资活动有关的现金                            ",
				" 企业现金流量表（2007 版）信息筹资活动现金流入小计                                    ",
				" 企业现金流量表（2007 版）信息偿还债务所支付的现金                                    ",
				" 企业现金流量表（2007 版）信息分配股利、利润或偿付利息所支付的现金                    ",
				" 企业现金流量表（2007 版）信息支付其他与筹资活动有关的现金                            ",
				" 企业现金流量表（2007 版）信息筹资活动现金流出小计                                    ",
				" 企业现金流量表（2007 版）信息筹集活动产生的现金流量净额                              ",
				" 企业现金流量表（2007 版）信息汇率变动对现金及现金等价物的影响                        ",
				" 企业现金流量表（2007 版）信息现金及现金等价物净增加额                                ",
				" 企业现金流量表（2007 版）信息期初现金及现金等价物余额                                ",
				" 企业现金流量表（2007 版）信息期末现金及现金等价物余额                                ",
				" 企业现金流量表（2007 版）信息净利润                                                  ",
				" 企业现金流量表（2007 版）信息资产减值准备                                            ",
				" 企业现金流量表（2007 版）信息固定资产折旧、油气资产折耗、生产性生物资产折旧          ",
				" 企业现金流量表（2007 版）信息无形资产摊销                                            ",
				" 企业现金流量表（2007 版）信息长期待摊费用摊销                                        ",
				" 企业现金流量表（2007 版）信息待摊费用减少                                            ",
				" 企业现金流量表（2007 版）信息预提费用增加                                            ",
				" 企业现金流量表（2007 版）信息处置固定资产无形资产和其他长期资产的损失                ",
				" 企业现金流量表（2007 版）信息固定资产报废损失                                        ",
				" 企业现金流量表（2007 版）信息公允价值变动损失                                        ",
				" 企业现金流量表（2007 版）信息财务费用                                                ",
				" 企业现金流量表（2007 版）信息投资损失                                                ",
				" 企业现金流量表（2007 版）信息递延所得税资产减少                                      ",
				" 企业现金流量表（2007 版）信息递延所得税负债增加                                      ",
				" 企业现金流量表（2007 版）信息存货的减少                                              ",
				" 企业现金流量表（2007 版）信息经营性应收项目的减少                                    ",
				" 企业现金流量表（2007 版）信息经营性应付项目的增加                                    ",
				" 企业现金流量表（2007 版）信息（净利润调节为经营活动现金流量科目下）其他              ",
				" 企业现金流量表（2007 版）信息经营活动产生的现金流量净额                              ",
				" 企业现金流量表（2007 版）信息债务转为资本                                            ",
				" 企业现金流量表（2007 版）信息一年内到期的可转换公司债券                              ",
				" 企业现金流量表（2007 版）信息融资租入固定资产                                        ",
				" 企业现金流量表（2007 版）信息现金的期末余额                                          ",
				" 企业现金流量表（2007 版）信息现金的期初余额                                          ",
				" 企业现金流量表（2007 版）信息现金等价物的期末余额                                    ",
				" 企业现金流量表（2007 版）信息现金等价物的期初余额                                    ",
				" 企业现金流量表（2007 版）信息现金及现金等价物净增加额                                ",
				" 企业现金流量表（2007 版）信息（不涉及现金收支的投资和筹资活动科目下）其他            ",
				" 事业单位资产负债表（1997 版）信息财务报表编号                                        ",
				" 事业单位资产负债表（1997 版）信息业务管理机构                                        ",
				" 事业单位资产负债表（1997 版）信息业务管理机构代码                                    ",
				" 事业单位资产负债表（1997 版）信息报表年份                                            ",
				" 事业单位资产负债表（1997 版）信息报表类型                                            ",
				" 事业单位资产负债表（1997 版）信息报表类型细分                                        ",
				" 事业单位资产负债表（1997 版）信息现金                                                ",
				" 事业单位资产负债表（1997 版）信息银行存款                                            ",
				" 事业单位资产负债表（1997 版）信息应收票据                                            ",
				" 事业单位资产负债表（1997 版）信息应收账款                                            ",
				" 事业单位资产负债表（1997 版）信息预付账款                                            ",
				" 事业单位资产负债表（1997 版）信息其他应收款                                          ",
				" 事业单位资产负债表（1997 版）信息材料                                                ",
				" 事业单位资产负债表（1997 版）信息产成品                                              ",
				" 事业单位资产负债表（1997 版）信息对外投资                                            ",
				" 事业单位资产负债表（1997 版）信息固定资产                                            ",
				" 事业单位资产负债表（1997 版）信息无形资产                                            ",
				" 事业单位资产负债表（1997 版）信息资产合计                                            ",
				" 事业单位资产负债表（1997 版）信息拨出经费                                            ",
				" 事业单位资产负债表（1997 版）信息拨出专款                                            ",
				" 事业单位资产负债表（1997 版）信息专款支出                                            ",
				" 事业单位资产负债表（1997 版）信息事业支出                                            ",
				" 事业单位资产负债表（1997 版）信息经营支出                                            ",
				" 事业单位资产负债表（1997 版）信息成本费用                                            ",
				" 事业单位资产负债表（1997 版）信息销售税金                                            ",
				" 事业单位资产负债表（1997 版）信息上缴上级支出                                        ",
				" 事业单位资产负债表（1997 版）信息对附属单位补助                                      ",
				" 事业单位资产负债表（1997 版）信息结转自筹基建                                        ",
				" 事业单位资产负债表（1997 版）信息支出合计                                            ",
				" 事业单位资产负债表（1997 版）信息资产部类总计                                        ",
				" 事业单位资产负债表（1997 版）信息借记款项                                            ",
				" 事业单位资产负债表（1997 版）信息应付票据                                            ",
				" 事业单位资产负债表（1997 版）信息应付账款                                            ",
				" 事业单位资产负债表（1997 版）信息预收账款                                            ",
				" 事业单位资产负债表（1997 版）信息其他应付款                                          ",
				" 事业单位资产负债表（1997 版）信息应缴预算款                                          ",
				" 事业单位资产负债表（1997 版）信息应缴财政专户款                                      ",
				" 事业单位资产负债表（1997 版）信息应交税金                                            ",
				" 事业单位资产负债表（1997 版）信息负债合计                                            ",
				" 事业单位资产负债表（1997 版）信息事业基金                                            ",
				" 事业单位资产负债表（1997 版）信息一般基金                                            ",
				" 事业单位资产负债表（1997 版）信息投资基金                                            ",
				" 事业单位资产负债表（1997 版）信息固定基金                                            ",
				" 事业单位资产负债表（1997 版）信息专用基金                                            ",
				" 事业单位资产负债表（1997 版）信息事业结余                                            ",
				" 事业单位资产负债表（1997 版）信息经营结余                                            ",
				" 事业单位资产负债表（1997 版）信息净资产合计                                          ",
				" 事业单位资产负债表（1997 版）信息财政补助收入                                        ",
				" 事业单位资产负债表（1997 版）信息上级补助收入                                        ",
				" 事业单位资产负债表（1997 版）信息拨入专款                                            ",
				" 事业单位资产负债表（1997 版）信息事业收入                                            ",
				" 事业单位资产负债表（1997 版）信息经营收入                                            ",
				" 事业单位资产负债表（1997 版）信息附属单位缴款                                        ",
				" 事业单位资产负债表（1997 版）信息其他收入                                            ",
				" 事业单位资产负债表（1997 版）信息收入合计                                            ",
				" 事业单位资产负债表（1997 版）信息负债部类总计                                        ",
				" 事业单位资产负债表（2013 版）信息财务报表编号                                        ",
				" 事业单位资产负债表（2013 版）信息业务管理机构                                        ",
				" 事业单位资产负债表（2013 版）信息业务管理机构代码                                    ",
				" 事业单位资产负债表（2013 版）信息报表年份                                            ",
				" 事业单位资产负债表（2013 版）信息报表类型                                            ",
				" 事业单位资产负债表（2013 版）信息报表类型细分                                        ",
				" 事业单位资产负债表（2013 版）信息货币资金                                            ",
				" 事业单位资产负债表（2013 版）信息短期投资                                            ",
				" 事业单位资产负债表（2013 版）信息财政应返还额度                                      ",
				" 事业单位资产负债表（2013 版）信息应收票据                                            ",
				" 事业单位资产负债表（2013 版）信息应收账款                                            ",
				" 事业单位资产负债表（2013 版）信息预付账款                                            ",
				" 事业单位资产负债表（2013 版）信息其他应收款                                          ",
				" 事业单位资产负债表（2013 版）信息存货                                                ",
				" 事业单位资产负债表（2013 版）信息其他流动资产                                        ",
				" 事业单位资产负债表（2013 版）信息流动资产合计                                        ",
				" 事业单位资产负债表（2013 版）信息长期投资                                            ",
				" 事业单位资产负债表（2013 版）信息固定资产                                            ",
				" 事业单位资产负债表（2013 版）信息固定资产原价                                        ",
				" 事业单位资产负债表（2013 版）信息累计折旧                                            ",
				" 事业单位资产负债表（2013 版）信息在建工程                                            ",
				" 事业单位资产负债表（2013 版）信息无形资产                                            ",
				" 事业单位资产负债表（2013 版）信息无形资产原价                                        ",
				" 事业单位资产负债表（2013 版）信息累计摊销                                            ",
				" 事业单位资产负债表（2013 版）信息待处置资产损溢                                      ",
				" 事业单位资产负债表（2013 版）信息非流动资产合计                                      ",
				" 事业单位资产负债表（2013 版）信息资产总计                                            ",
				" 事业单位资产负债表（2013 版）信息短期借款                                            ",
				" 事业单位资产负债表（2013 版）信息应缴税费                                            ",
				" 事业单位资产负债表（2013 版）信息应缴国库款                                          ",
				" 事业单位资产负债表（2013 版）信息应缴财政专户款                                      ",
				" 事业单位资产负债表（2013 版）信息应付职工薪酬                                        ",
				" 事业单位资产负债表（2013 版）信息应付票据                                            ",
				" 事业单位资产负债表（2013 版）信息应付账款                                            ",
				" 事业单位资产负债表（2013 版）信息预收账款                                            ",
				" 事业单位资产负债表（2013 版）信息其他应付款                                          ",
				" 事业单位资产负债表（2013 版）信息其他流动负债                                        ",
				" 事业单位资产负债表（2013 版）信息流动负债合计                                        ",
				" 事业单位资产负债表（2013 版）信息长期借款                                            ",
				" 事业单位资产负债表（2013 版）信息长期应付款                                          ",
				" 事业单位资产负债表（2013 版）信息非流动负债合计                                      ",
				" 事业单位资产负债表（2013 版）信息负债合计                                            ",
				" 事业单位资产负债表（2013 版）信息事业基金                                            ",
				" 事业单位资产负债表（2013 版）信息非流动资产基金                                      ",
				" 事业单位资产负债表（2013 版）信息专用基金                                            ",
				" 事业单位资产负债表（2013 版）信息财政补助结转                                        ",
				" 事业单位资产负债表（2013 版）信息财政补助结余                                        ",
				" 事业单位资产负债表（2013 版）信息非财政补助结转                                      ",
				" 事业单位资产负债表（2013 版）信息非财政补助结余                                      ",
				" 事业单位资产负债表（2013 版）信息事业结余                                            ",
				" 事业单位资产负债表（2013 版）信息经营结余                                            ",
				" 事业单位资产负债表（2013 版）信息净资产合计                                          ",
				" 事业单位资产负债表（2013 版）信息负债和净资产总计                                    ",
				" 事业单位收入支出表（1997 版）信息财务报表编号                                        ",
				" 事业单位收入支出表（1997 版）信息业务管理机构                                        ",
				" 事业单位收入支出表（1997 版）信息业务管理机构代码                                    ",
				" 事业单位收入支出表（1997 版）信息报表年份                                            ",
				" 事业单位收入支出表（1997 版）信息报表类型                                            ",
				" 事业单位收入支出表（1997 版）信息报表类型细分                                        ",
				" 事业单位收入支出表（1997 版）信息财政补助收入                                        ",
				" 事业单位收入支出表（1997 版）信息上级补助收入                                        ",
				" 事业单位收入支出表（1997 版）信息附属单位缴款                                        ",
				" 事业单位收入支出表（1997 版）信息事业收入                                            ",
				" 事业单位收入支出表（1997 版）信息预算外资金收入                                      ",
				" 事业单位收入支出表（1997 版）信息其他收入                                            ",
				" 事业单位收入支出表（1997 版）信息事业收入小计                                        ",
				" 事业单位收入支出表（1997 版）信息经营收入                                            ",
				" 事业单位收入支出表（1997 版）信息经营收入小计                                        ",
				" 事业单位收入支出表（1997 版）信息拨入专款                                            ",
				" 事业单位收入支出表（1997 版）信息拨入专款小计                                        ",
				" 事业单位收入支出表（1997 版）信息收入总计                                            ",
				" 事业单位收入支出表（1997 版）信息拨出经费                                            ",
				" 事业单位收入支出表（1997 版）信息上缴上级支出                                        ",
				" 事业单位收入支出表（1997 版）信息对附属单位补助                                      ",
				" 事业单位收入支出表（1997 版）信息事业支出                                            ",
				" 事业单位收入支出表（1997 版）信息财政补助支出                                        ",
				" 事业单位收入支出表（1997 版）信息预算外资金支出                                      ",
				" 事业单位收入支出表（1997 版）信息销售税金                                            ",
				" 事业单位收入支出表（1997 版）信息结转自筹基建                                        ",
				" 事业单位收入支出表（1997 版）信息事业支出小计                                        ",
				" 事业单位收入支出表（1997 版）信息经营支出                                            ",
				" 事业单位收入支出表（1997 版）信息销售税金                                            ",
				" 事业单位收入支出表（1997 版）信息经营支出小计                                        ",
				" 事业单位收入支出表（1997 版）信息拨出专款                                            ",
				" 事业单位收入支出表（1997 版）信息专款支出                                            ",
				" 事业单位收入支出表（1997 版）信息专款小计                                            ",
				" 事业单位收入支出表（1997 版）信息支出总计                                            ",
				" 事业单位收入支出表（1997 版）信息事业结余                                            ",
				" 事业单位收入支出表（1997 版）信息正常收入结余                                        ",
				" 事业单位收入支出表（1997 版）信息收回以前年度事业支出                                ",
				" 事业单位收入支出表（1997 版）信息经营结余                                            ",
				" 事业单位收入支出表（1997 版）信息以前年度经营亏损                                    ",
				" 事业单位收入支出表（1997 版）信息结余分配                                            ",
				" 事业单位收入支出表（1997 版）信息应交所得税                                          ",
				" 事业单位收入支出表（1997 版）信息提取专用基金                                        ",
				" 事业单位收入支出表（1997 版）信息转入事业基金                                        ",
				" 事业单位收入支出表（1997 版）信息其他结余分配                                        ",
				" 事业单位收入支出表（2013 版）信息财务报表编号                                        ",
				" 事业单位收入支出表（2013 版）信息业务管理机构                                        ",
				" 事业单位收入支出表（2013 版）信息业务管理机构代码                                    ",
				" 事业单位收入支出表（2013 版）信息报表年份                                            ",
				" 事业单位收入支出表（2013 版）信息报表类型                                            ",
				" 事业单位收入支出表（2013 版）信息报表类型细分                                        ",
				" 事业单位收入支出表（2013 版）本期财政补助结转结余                                    ",
				" 事业单位收入支出表（2013 版）财政补助收入                                            ",
				" 事业单位收入支出表（2013 版）事业支出（财政补助支出）                                ",
				" 事业单位收入支出表（2013 版）本期事业结转结余                                        ",
				" 事业单位收入支出表（2013 版）事业类收入                                              ",
				" 事业单位收入支出表（2013 版）事业收入                                                ",
				" 事业单位收入支出表（2013 版）上级补助收入                                            ",
				" 事业单位收入支出表（2013 版）附属单位上缴收入                                        ",
				" 事业单位收入支出表（2013 版）其他收入                                                ",
				" 事业单位收入支出表（2013 版）（其他收入科目下）捐赠收入                              ",
				" 事业单位收入支出表（2013 版）事业类支出                                              ",
				" 事业单位收入支出表（2013 版）事业支出（非财政补助支出）                              ",
				" 事业单位收入支出表（2013 版）上缴上级支出                                            ",
				" 事业单位收入支出表（2013 版）对附属单位补助支出                                      ",
				" 事业单位收入支出表（2013 版）其他支出                                                ",
				" 事业单位收入支出表（2013 版）本期经营结余                                            ",
				" 事业单位收入支出表（2013 版）经营收入                                                ",
				" 事业单位收入支出表（2013 版）经营支出                                                ",
				" 事业单位收入支出表（2013 版）弥补以前年度亏损后的经营结余                            ",
				" 事业单位收入支出表（2013 版）本年非财政补助结转结余                                  ",
				" 事业单位收入支出表（2013 版）非财政补助结转                                          ",
				" 事业单位收入支出表（2013 版）本年非财政补助结余                                      ",
				" 事业单位收入支出表（2013 版）应缴企业所得税                                          ",
				" 事业单位收入支出表（2013 版）提取专用基金                                            ",
				" 事业单位收入支出表（2013 版）转入事业基金                                            " };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EGA.xlsx";
		/*CrComEga crComEga = new CrComEga();
		crComEga.setId(id);*/
		
		try {
			List<CrComEga> crComEgaList = BaseDAOUtils.getCrComEgaDAO().findByIdProperties(id);
			createCrComEgaExcel(filepath, sheetName, title, fileName, crComEgaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEgaExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEga> crComEgaList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEgaList.size()][];
		for (int i = 0; i < crComEgaList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEga crComEga = crComEgaList.get(i);
			values[i][0] = String.valueOf(crComEga.getId()) == "null" ? "" : String.valueOf(crComEga.getId());
			values[i][1] = String.valueOf(crComEga.getEg01ai01()) == "null" ? ""
					: String.valueOf(crComEga.getEg01ai01());
			values[i][2] = String.valueOf(crComEga.getEg01ad01()) == "null" ? ""
					: String.valueOf(crComEga.getEg01ad01());
			values[i][3] = String.valueOf(crComEga.getEg01ai02()) == "null" ? ""
					: String.valueOf(crComEga.getEg01ai02());
			values[i][4] = String.valueOf(crComEga.getEg01ar01()) == "null" ? ""
					: String.valueOf(crComEga.getEg01ar01());
			values[i][5] = String.valueOf(crComEga.getEg01ad02()) == "null" ? ""
					: String.valueOf(crComEga.getEg01ad02());
			values[i][6] = String.valueOf(crComEga.getEg01ad03()) == "null" ? ""
					: String.valueOf(crComEga.getEg01ad03());
			values[i][7] = String.valueOf(crComEga.getEg01bj01()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj01());
			values[i][8] = String.valueOf(crComEga.getEg01bj02()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj02());
			values[i][9] = String.valueOf(crComEga.getEg01bj03()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj03());
			values[i][10] = String.valueOf(crComEga.getEg01bj04()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj04());
			values[i][11] = String.valueOf(crComEga.getEg01bj05()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj05());
			values[i][12] = String.valueOf(crComEga.getEg01bj06()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj06());
			values[i][13] = String.valueOf(crComEga.getEg01bj07()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj07());
			values[i][14] = String.valueOf(crComEga.getEg01bj08()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj08());
			values[i][15] = String.valueOf(crComEga.getEg01bj09()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj09());
			values[i][16] = String.valueOf(crComEga.getEg01bj10()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj10());
			values[i][17] = String.valueOf(crComEga.getEg01bj11()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj11());
			values[i][18] = String.valueOf(crComEga.getEg01bj12()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj12());
			values[i][19] = String.valueOf(crComEga.getEg01bj13()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj13());
			values[i][20] = String.valueOf(crComEga.getEg01bj14()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj14());
			values[i][21] = String.valueOf(crComEga.getEg01bj15()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj15());
			values[i][22] = String.valueOf(crComEga.getEg01bj16()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj16());
			values[i][23] = String.valueOf(crComEga.getEg01bj17()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj17());
			values[i][24] = String.valueOf(crComEga.getEg01bj18()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj18());
			values[i][25] = String.valueOf(crComEga.getEg01bj19()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj19());
			values[i][26] = String.valueOf(crComEga.getEg01bj20()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj20());
			values[i][27] = String.valueOf(crComEga.getEg01bj21()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj21());
			values[i][28] = String.valueOf(crComEga.getEg01bj22()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj22());
			values[i][29] = String.valueOf(crComEga.getEg01bj23()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj23());
			values[i][30] = String.valueOf(crComEga.getEg01bj24()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj24());
			values[i][31] = String.valueOf(crComEga.getEg01bj25()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj25());
			values[i][32] = String.valueOf(crComEga.getEg01bj26()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj26());
			values[i][33] = String.valueOf(crComEga.getEg01bj27()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj27());
			values[i][34] = String.valueOf(crComEga.getEg01bj28()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj28());
			values[i][35] = String.valueOf(crComEga.getEg01bj29()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj29());
			values[i][36] = String.valueOf(crComEga.getEg01bj30()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj30());
			values[i][37] = String.valueOf(crComEga.getEg01bj31()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj31());
			values[i][38] = String.valueOf(crComEga.getEg01bj32()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj32());
			values[i][39] = String.valueOf(crComEga.getEg01bj33()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj33());
			values[i][40] = String.valueOf(crComEga.getEg01bj34()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj34());
			values[i][41] = String.valueOf(crComEga.getEg01bj35()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj35());
			values[i][42] = String.valueOf(crComEga.getEg01bj36()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj36());
			values[i][43] = String.valueOf(crComEga.getEg01bj37()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj37());
			values[i][44] = String.valueOf(crComEga.getEg01bj38()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj38());
			values[i][45] = String.valueOf(crComEga.getEg01bj39()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj39());
			values[i][46] = String.valueOf(crComEga.getEg01bj40()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj40());
			values[i][47] = String.valueOf(crComEga.getEg01bj41()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj41());
			values[i][48] = String.valueOf(crComEga.getEg01bj42()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj42());
			values[i][49] = String.valueOf(crComEga.getEg01bj43()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj43());
			values[i][50] = String.valueOf(crComEga.getEg01bj44()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj44());
			values[i][51] = String.valueOf(crComEga.getEg01bj45()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj45());
			values[i][52] = String.valueOf(crComEga.getEg01bj46()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj46());
			values[i][53] = String.valueOf(crComEga.getEg01bj47()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj47());
			values[i][54] = String.valueOf(crComEga.getEg01bj48()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj48());
			values[i][55] = String.valueOf(crComEga.getEg01bj49()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj49());
			values[i][56] = String.valueOf(crComEga.getEg01bj50()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj50());
			values[i][57] = String.valueOf(crComEga.getEg01bj51()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj51());
			values[i][58] = String.valueOf(crComEga.getEg01bj52()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj52());
			values[i][59] = String.valueOf(crComEga.getEg01bj53()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj53());
			values[i][60] = String.valueOf(crComEga.getEg01bj54()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj54());
			values[i][61] = String.valueOf(crComEga.getEg01bj55()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj55());
			values[i][62] = String.valueOf(crComEga.getEg01bj56()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj56());
			values[i][63] = String.valueOf(crComEga.getEg01bj57()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj57());
			values[i][64] = String.valueOf(crComEga.getEg01bj58()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj58());
			values[i][65] = String.valueOf(crComEga.getEg01bj59()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj59());
			values[i][66] = String.valueOf(crComEga.getEg01bj60()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj60());
			values[i][67] = String.valueOf(crComEga.getEg01bj61()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj61());
			values[i][68] = String.valueOf(crComEga.getEg01bj62()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj62());
			values[i][69] = String.valueOf(crComEga.getEg01bj63()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj63());
			values[i][70] = String.valueOf(crComEga.getEg01bj64()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj64());
			values[i][71] = String.valueOf(crComEga.getEg01bj65()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj65());
			values[i][72] = String.valueOf(crComEga.getEg01bj66()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj66());
			values[i][73] = String.valueOf(crComEga.getEg01bj67()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj67());
			values[i][74] = String.valueOf(crComEga.getEg01bj68()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj68());
			values[i][75] = String.valueOf(crComEga.getEg01bj69()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj69());
			values[i][76] = String.valueOf(crComEga.getEg01bj70()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj70());
			values[i][77] = String.valueOf(crComEga.getEg01bj71()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj71());
			values[i][78] = String.valueOf(crComEga.getEg01bj72()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj72());
			values[i][79] = String.valueOf(crComEga.getEg01bj73()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj73());
			values[i][80] = String.valueOf(crComEga.getEg01bj74()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj74());
			values[i][81] = String.valueOf(crComEga.getEg01bj75()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj75());
			values[i][82] = String.valueOf(crComEga.getEg01bj76()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj76());
			values[i][83] = String.valueOf(crComEga.getEg01bj77()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj77());
			values[i][84] = String.valueOf(crComEga.getEg01bj78()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj78());
			values[i][85] = String.valueOf(crComEga.getEg01bj79()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj79());
			values[i][86] = String.valueOf(crComEga.getEg01bj80()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj80());
			values[i][87] = String.valueOf(crComEga.getEg01bj81()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj81());
			values[i][88] = String.valueOf(crComEga.getEg01bj82()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj82());
			values[i][89] = String.valueOf(crComEga.getEg01bj83()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj83());
			values[i][90] = String.valueOf(crComEga.getEg01bj84()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj84());
			values[i][91] = String.valueOf(crComEga.getEg01bj85()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj85());
			values[i][92] = String.valueOf(crComEga.getEg01bj86()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj86());
			values[i][93] = String.valueOf(crComEga.getEg01bj87()) == "null" ? ""
					: String.valueOf(crComEga.getEg01bj87());
			values[i][94] = String.valueOf(crComEga.getEg02ai01()) == "null" ? ""
					: String.valueOf(crComEga.getEg02ai01());
			values[i][95] = String.valueOf(crComEga.getEg02ad01()) == "null" ? ""
					: String.valueOf(crComEga.getEg02ad01());
			values[i][96] = String.valueOf(crComEga.getEg02ai02()) == "null" ? ""
					: String.valueOf(crComEga.getEg02ai02());
			values[i][97] = String.valueOf(crComEga.getEg02ar01()) == "null" ? ""
					: String.valueOf(crComEga.getEg02ar01());
			values[i][98] = String.valueOf(crComEga.getEg02ad02()) == "null" ? ""
					: String.valueOf(crComEga.getEg02ad02());
			values[i][99] = String.valueOf(crComEga.getEg02ad03()) == "null" ? ""
					: String.valueOf(crComEga.getEg02ad03());
			values[i][100] = String.valueOf(crComEga.getEg02bj01()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj01());
			values[i][101] = String.valueOf(crComEga.getEg02bj02()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj02());
			values[i][102] = String.valueOf(crComEga.getEg02bj03()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj03());
			values[i][103] = String.valueOf(crComEga.getEg02bj04()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj04());
			values[i][104] = String.valueOf(crComEga.getEg02bj05()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj05());
			values[i][105] = String.valueOf(crComEga.getEg02bj06()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj06());
			values[i][106] = String.valueOf(crComEga.getEg02bj07()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj07());
			values[i][107] = String.valueOf(crComEga.getEg02bj08()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj08());
			values[i][108] = String.valueOf(crComEga.getEg02bj09()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj09());
			values[i][109] = String.valueOf(crComEga.getEg02bj10()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj10());
			values[i][110] = String.valueOf(crComEga.getEg02bj11()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj11());
			values[i][111] = String.valueOf(crComEga.getEg02bj12()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj12());
			values[i][112] = String.valueOf(crComEga.getEg02bj13()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj13());
			values[i][113] = String.valueOf(crComEga.getEg02bj14()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj14());
			values[i][114] = String.valueOf(crComEga.getEg02bj15()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj15());
			values[i][115] = String.valueOf(crComEga.getEg02bj16()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj16());
			values[i][116] = String.valueOf(crComEga.getEg02bj17()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj17());
			values[i][117] = String.valueOf(crComEga.getEg02bj18()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj18());
			values[i][118] = String.valueOf(crComEga.getEg02bj19()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj19());
			values[i][119] = String.valueOf(crComEga.getEg02bj20()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj20());
			values[i][120] = String.valueOf(crComEga.getEg02bj21()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj21());
			values[i][121] = String.valueOf(crComEga.getEg02bj22()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj22());
			values[i][122] = String.valueOf(crComEga.getEg02bj23()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj23());
			values[i][123] = String.valueOf(crComEga.getEg02bj24()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj24());
			values[i][124] = String.valueOf(crComEga.getEg02bj25()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj25());
			values[i][125] = String.valueOf(crComEga.getEg02bj26()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj26());
			values[i][126] = String.valueOf(crComEga.getEg02bj27()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj27());
			values[i][127] = String.valueOf(crComEga.getEg02bj28()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj28());
			values[i][128] = String.valueOf(crComEga.getEg02bj29()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj29());
			values[i][129] = String.valueOf(crComEga.getEg02bj30()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj30());
			values[i][130] = String.valueOf(crComEga.getEg02bj31()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj31());
			values[i][131] = String.valueOf(crComEga.getEg02bj32()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj32());
			values[i][132] = String.valueOf(crComEga.getEg02bj33()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj33());
			values[i][133] = String.valueOf(crComEga.getEg02bj34()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj34());
			values[i][134] = String.valueOf(crComEga.getEg02bj35()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj35());
			values[i][135] = String.valueOf(crComEga.getEg02bj36()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj36());
			values[i][136] = String.valueOf(crComEga.getEg02bj37()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj37());
			values[i][137] = String.valueOf(crComEga.getEg02bj38()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj38());
			values[i][138] = String.valueOf(crComEga.getEg02bj39()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj39());
			values[i][139] = String.valueOf(crComEga.getEg02bj40()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj40());
			values[i][140] = String.valueOf(crComEga.getEg02bj41()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj41());
			values[i][141] = String.valueOf(crComEga.getEg02bj42()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj42());
			values[i][142] = String.valueOf(crComEga.getEg02bj43()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj43());
			values[i][143] = String.valueOf(crComEga.getEg02bj44()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj44());
			values[i][144] = String.valueOf(crComEga.getEg02bj45()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj45());
			values[i][145] = String.valueOf(crComEga.getEg02bj46()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj46());
			values[i][146] = String.valueOf(crComEga.getEg02bj47()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj47());
			values[i][147] = String.valueOf(crComEga.getEg02bj48()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj48());
			values[i][148] = String.valueOf(crComEga.getEg02bj49()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj49());
			values[i][149] = String.valueOf(crComEga.getEg02bj50()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj50());
			values[i][150] = String.valueOf(crComEga.getEg02bj51()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj51());
			values[i][151] = String.valueOf(crComEga.getEg02bj52()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj52());
			values[i][152] = String.valueOf(crComEga.getEg02bj53()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj53());
			values[i][153] = String.valueOf(crComEga.getEg02bj54()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj54());
			values[i][154] = String.valueOf(crComEga.getEg02bj55()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj55());
			values[i][155] = String.valueOf(crComEga.getEg02bj56()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj56());
			values[i][156] = String.valueOf(crComEga.getEg02bj57()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj57());
			values[i][157] = String.valueOf(crComEga.getEg02bj58()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj58());
			values[i][158] = String.valueOf(crComEga.getEg02bj59()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj59());
			values[i][159] = String.valueOf(crComEga.getEg02bj60()) == "null" ? ""
					: String.valueOf(crComEga.getEg02bj60());
			values[i][160] = String.valueOf(crComEga.getEg03ai01()) == "null" ? ""
					: String.valueOf(crComEga.getEg03ai01());
			values[i][161] = String.valueOf(crComEga.getEg03ad01()) == "null" ? ""
					: String.valueOf(crComEga.getEg03ad01());
			values[i][162] = String.valueOf(crComEga.getEg03ai02()) == "null" ? ""
					: String.valueOf(crComEga.getEg03ai02());
			values[i][163] = String.valueOf(crComEga.getEg03ar01()) == "null" ? ""
					: String.valueOf(crComEga.getEg03ar01());
			values[i][164] = String.valueOf(crComEga.getEg03ad02()) == "null" ? ""
					: String.valueOf(crComEga.getEg03ad02());
			values[i][165] = String.valueOf(crComEga.getEg03ad03()) == "null" ? ""
					: String.valueOf(crComEga.getEg03ad03());
			values[i][166] = String.valueOf(crComEga.getEg03bj01()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj01());
			values[i][167] = String.valueOf(crComEga.getEg03bj02()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj02());
			values[i][168] = String.valueOf(crComEga.getEg03bj03()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj03());
			values[i][169] = String.valueOf(crComEga.getEg03bj04()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj04());
			values[i][170] = String.valueOf(crComEga.getEg03bj05()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj05());
			values[i][171] = String.valueOf(crComEga.getEg03bj06()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj06());
			values[i][172] = String.valueOf(crComEga.getEg03bj07()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj07());
			values[i][173] = String.valueOf(crComEga.getEg03bj08()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj08());
			values[i][174] = String.valueOf(crComEga.getEg03bj09()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj09());
			values[i][175] = String.valueOf(crComEga.getEg03bj10()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj10());
			values[i][176] = String.valueOf(crComEga.getEg03bj11()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj11());
			values[i][177] = String.valueOf(crComEga.getEg03bj12()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj12());
			values[i][178] = String.valueOf(crComEga.getEg03bj13()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj13());
			values[i][179] = String.valueOf(crComEga.getEg03bj14()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj14());
			values[i][180] = String.valueOf(crComEga.getEg03bj15()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj15());
			values[i][181] = String.valueOf(crComEga.getEg03bj16()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj16());
			values[i][182] = String.valueOf(crComEga.getEg03bj17()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj17());
			values[i][183] = String.valueOf(crComEga.getEg03bj18()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj18());
			values[i][184] = String.valueOf(crComEga.getEg03bj19()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj19());
			values[i][185] = String.valueOf(crComEga.getEg03bj20()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj20());
			values[i][186] = String.valueOf(crComEga.getEg03bj21()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj21());
			values[i][187] = String.valueOf(crComEga.getEg03bj22()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj22());
			values[i][188] = String.valueOf(crComEga.getEg03bj23()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj23());
			values[i][189] = String.valueOf(crComEga.getEg03bj24()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj24());
			values[i][190] = String.valueOf(crComEga.getEg03bj25()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj25());
			values[i][191] = String.valueOf(crComEga.getEg03bj26()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj26());
			values[i][192] = String.valueOf(crComEga.getEg03bj27()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj27());
			values[i][193] = String.valueOf(crComEga.getEg03bj28()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj28());
			values[i][194] = String.valueOf(crComEga.getEg03bj29()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj29());
			values[i][195] = String.valueOf(crComEga.getEg03bj30()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj30());
			values[i][196] = String.valueOf(crComEga.getEg03bj31()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj31());
			values[i][197] = String.valueOf(crComEga.getEg03bj32()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj32());
			values[i][198] = String.valueOf(crComEga.getEg03bj33()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj33());
			values[i][199] = String.valueOf(crComEga.getEg03bj34()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj34());
			values[i][200] = String.valueOf(crComEga.getEg03bj35()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj35());
			values[i][201] = String.valueOf(crComEga.getEg03bj36()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj36());
			values[i][202] = String.valueOf(crComEga.getEg03bj37()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj37());
			values[i][203] = String.valueOf(crComEga.getEg03bj38()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj38());
			values[i][204] = String.valueOf(crComEga.getEg03bj39()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj39());
			values[i][205] = String.valueOf(crComEga.getEg03bj40()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj40());
			values[i][206] = String.valueOf(crComEga.getEg03bj41()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj41());
			values[i][207] = String.valueOf(crComEga.getEg03bj42()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj42());
			values[i][208] = String.valueOf(crComEga.getEg03bj43()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj43());
			values[i][209] = String.valueOf(crComEga.getEg03bj44()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj44());
			values[i][210] = String.valueOf(crComEga.getEg03bj45()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj45());
			values[i][211] = String.valueOf(crComEga.getEg03bj46()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj46());
			values[i][212] = String.valueOf(crComEga.getEg03bj47()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj47());
			values[i][213] = String.valueOf(crComEga.getEg03bj48()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj48());
			values[i][214] = String.valueOf(crComEga.getEg03bj49()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj49());
			values[i][215] = String.valueOf(crComEga.getEg03bj50()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj50());
			values[i][216] = String.valueOf(crComEga.getEg03bj51()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj51());
			values[i][217] = String.valueOf(crComEga.getEg03bj52()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj52());
			values[i][218] = String.valueOf(crComEga.getEg03bj53()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj53());
			values[i][219] = String.valueOf(crComEga.getEg03bj54()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj54());
			values[i][220] = String.valueOf(crComEga.getEg03bj55()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj55());
			values[i][221] = String.valueOf(crComEga.getEg03bj56()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj56());
			values[i][222] = String.valueOf(crComEga.getEg03bj57()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj57());
			values[i][223] = String.valueOf(crComEga.getEg03bj58()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj58());
			values[i][224] = String.valueOf(crComEga.getEg03bj59()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj59());
			values[i][225] = String.valueOf(crComEga.getEg03bj60()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj60());
			values[i][226] = String.valueOf(crComEga.getEg03bj61()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj61());
			values[i][227] = String.valueOf(crComEga.getEg03bj62()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj62());
			values[i][228] = String.valueOf(crComEga.getEg03bj63()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj63());
			values[i][229] = String.valueOf(crComEga.getEg03bj64()) == "null" ? ""
					: String.valueOf(crComEga.getEg03bj64());
			values[i][230] = String.valueOf(crComEga.getEg04ai01()) == "null" ? ""
					: String.valueOf(crComEga.getEg04ai01());
			values[i][231] = String.valueOf(crComEga.getEg04ad01()) == "null" ? ""
					: String.valueOf(crComEga.getEg04ad01());
			values[i][232] = String.valueOf(crComEga.getEg04ai02()) == "null" ? ""
					: String.valueOf(crComEga.getEg04ai02());
			values[i][233] = String.valueOf(crComEga.getEg04ar01()) == "null" ? ""
					: String.valueOf(crComEga.getEg04ar01());
			values[i][234] = String.valueOf(crComEga.getEg04ad02()) == "null" ? ""
					: String.valueOf(crComEga.getEg04ad02());
			values[i][235] = String.valueOf(crComEga.getEg04ad03()) == "null" ? ""
					: String.valueOf(crComEga.getEg04ad03());
			values[i][236] = String.valueOf(crComEga.getEg04bj01()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj01());
			values[i][237] = String.valueOf(crComEga.getEg04bj02()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj02());
			values[i][238] = String.valueOf(crComEga.getEg04bj03()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj03());
			values[i][239] = String.valueOf(crComEga.getEg04bj04()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj04());
			values[i][240] = String.valueOf(crComEga.getEg04bj05()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj05());
			values[i][241] = String.valueOf(crComEga.getEg04bj06()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj06());
			values[i][242] = String.valueOf(crComEga.getEg04bj07()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj07());
			values[i][243] = String.valueOf(crComEga.getEg04bj08()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj08());
			values[i][244] = String.valueOf(crComEga.getEg04bj09()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj09());
			values[i][245] = String.valueOf(crComEga.getEg04bj10()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj10());
			values[i][246] = String.valueOf(crComEga.getEg04bj11()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj11());
			values[i][247] = String.valueOf(crComEga.getEg04bj12()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj12());
			values[i][248] = String.valueOf(crComEga.getEg04bj13()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj13());
			values[i][249] = String.valueOf(crComEga.getEg04bj14()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj14());
			values[i][250] = String.valueOf(crComEga.getEg04bj15()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj15());
			values[i][251] = String.valueOf(crComEga.getEg04bj16()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj16());
			values[i][252] = String.valueOf(crComEga.getEg04bj17()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj17());
			values[i][253] = String.valueOf(crComEga.getEg04bj18()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj18());
			values[i][254] = String.valueOf(crComEga.getEg04bj19()) == "null" ? ""
					: String.valueOf(crComEga.getEg04bj19());
			values[i][255] = String.valueOf(crComEga.getEg05ai01()) == "null" ? ""
					: String.valueOf(crComEga.getEg05ai01());
			values[i][256] = String.valueOf(crComEga.getEg05ad01()) == "null" ? ""
					: String.valueOf(crComEga.getEg05ad01());
			values[i][257] = String.valueOf(crComEga.getEg05ai02()) == "null" ? ""
					: String.valueOf(crComEga.getEg05ai02());
			values[i][258] = String.valueOf(crComEga.getEg05ar01()) == "null" ? ""
					: String.valueOf(crComEga.getEg05ar01());
			values[i][259] = String.valueOf(crComEga.getEg05ad02()) == "null" ? ""
					: String.valueOf(crComEga.getEg05ad02());
			values[i][260] = String.valueOf(crComEga.getEg05ad03()) == "null" ? ""
					: String.valueOf(crComEga.getEg05ad03());
			values[i][261] = String.valueOf(crComEga.getEg05bj01()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj01());
			values[i][262] = String.valueOf(crComEga.getEg05bj02()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj02());
			values[i][263] = String.valueOf(crComEga.getEg05bj03()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj03());
			values[i][264] = String.valueOf(crComEga.getEg05bj04()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj04());
			values[i][265] = String.valueOf(crComEga.getEg05bj05()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj05());
			values[i][266] = String.valueOf(crComEga.getEg05bj06()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj06());
			values[i][267] = String.valueOf(crComEga.getEg05bj07()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj07());
			values[i][268] = String.valueOf(crComEga.getEg05bj08()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj08());
			values[i][269] = String.valueOf(crComEga.getEg05bj09()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj09());
			values[i][270] = String.valueOf(crComEga.getEg05bj10()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj10());
			values[i][271] = String.valueOf(crComEga.getEg05bj11()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj11());
			values[i][272] = String.valueOf(crComEga.getEg05bj12()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj12());
			values[i][273] = String.valueOf(crComEga.getEg05bj13()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj13());
			values[i][274] = String.valueOf(crComEga.getEg05bj14()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj14());
			values[i][275] = String.valueOf(crComEga.getEg05bj15()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj15());
			values[i][276] = String.valueOf(crComEga.getEg05bj16()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj16());
			values[i][277] = String.valueOf(crComEga.getEg05bj17()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj17());
			values[i][278] = String.valueOf(crComEga.getEg05bj18()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj18());
			values[i][279] = String.valueOf(crComEga.getEg05bj19()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj19());
			values[i][280] = String.valueOf(crComEga.getEg05bj20()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj20());
			values[i][281] = String.valueOf(crComEga.getEg05bj21()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj21());
			values[i][282] = String.valueOf(crComEga.getEg05bj22()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj22());
			values[i][283] = String.valueOf(crComEga.getEg05bj23()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj23());
			values[i][284] = String.valueOf(crComEga.getEg05bj24()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj24());
			values[i][285] = String.valueOf(crComEga.getEg05bj25()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj25());
			values[i][286] = String.valueOf(crComEga.getEg05bj26()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj26());
			values[i][287] = String.valueOf(crComEga.getEg05bj27()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj27());
			values[i][288] = String.valueOf(crComEga.getEg05bj28()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj28());
			values[i][289] = String.valueOf(crComEga.getEg05bj29()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj29());
			values[i][290] = String.valueOf(crComEga.getEg05bj30()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj30());
			values[i][291] = String.valueOf(crComEga.getEg05bj31()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj31());
			values[i][292] = String.valueOf(crComEga.getEg05bj32()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj32());
			values[i][293] = String.valueOf(crComEga.getEg05bj33()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj33());
			values[i][294] = String.valueOf(crComEga.getEg05bj34()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj34());
			values[i][295] = String.valueOf(crComEga.getEg05bj35()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj35());
			values[i][296] = String.valueOf(crComEga.getEg05bj36()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj36());
			values[i][297] = String.valueOf(crComEga.getEg05bj37()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj37());
			values[i][298] = String.valueOf(crComEga.getEg05bj38()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj38());
			values[i][299] = String.valueOf(crComEga.getEg05bj39()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj39());
			values[i][300] = String.valueOf(crComEga.getEg05bj40()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj40());
			values[i][301] = String.valueOf(crComEga.getEg05bj41()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj41());
			values[i][302] = String.valueOf(crComEga.getEg05bj42()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj42());
			values[i][303] = String.valueOf(crComEga.getEg05bj43()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj43());
			values[i][304] = String.valueOf(crComEga.getEg05bj44()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj44());
			values[i][305] = String.valueOf(crComEga.getEg05bj45()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj45());
			values[i][306] = String.valueOf(crComEga.getEg05bj46()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj46());
			values[i][307] = String.valueOf(crComEga.getEg05bj47()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj47());
			values[i][308] = String.valueOf(crComEga.getEg05bj48()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj48());
			values[i][309] = String.valueOf(crComEga.getEg05bj49()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj49());
			values[i][310] = String.valueOf(crComEga.getEg05bj50()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj50());
			values[i][311] = String.valueOf(crComEga.getEg05bj51()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj51());
			values[i][312] = String.valueOf(crComEga.getEg05bj52()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj52());
			values[i][313] = String.valueOf(crComEga.getEg05bj53()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj53());
			values[i][314] = String.valueOf(crComEga.getEg05bj54()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj54());
			values[i][315] = String.valueOf(crComEga.getEg05bj55()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj55());
			values[i][316] = String.valueOf(crComEga.getEg05bj56()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj56());
			values[i][317] = String.valueOf(crComEga.getEg05bj57()) == "null" ? ""
					: String.valueOf(crComEga.getEg05bj57());
			values[i][318] = String.valueOf(crComEga.getEg06ai01()) == "null" ? ""
					: String.valueOf(crComEga.getEg06ai01());
			values[i][319] = String.valueOf(crComEga.getEg06ad01()) == "null" ? ""
					: String.valueOf(crComEga.getEg06ad01());
			values[i][320] = String.valueOf(crComEga.getEg06ai02()) == "null" ? ""
					: String.valueOf(crComEga.getEg06ai02());
			values[i][321] = String.valueOf(crComEga.getEg06ar01()) == "null" ? ""
					: String.valueOf(crComEga.getEg06ar01());
			values[i][322] = String.valueOf(crComEga.getEg06ad02()) == "null" ? ""
					: String.valueOf(crComEga.getEg06ad02());
			values[i][323] = String.valueOf(crComEga.getEg06ad03()) == "null" ? ""
					: String.valueOf(crComEga.getEg06ad03());
			values[i][324] = String.valueOf(crComEga.getEg06bj01()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj01());
			values[i][325] = String.valueOf(crComEga.getEg06bj02()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj02());
			values[i][326] = String.valueOf(crComEga.getEg06bj03()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj03());
			values[i][327] = String.valueOf(crComEga.getEg06bj04()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj04());
			values[i][328] = String.valueOf(crComEga.getEg06bj05()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj05());
			values[i][329] = String.valueOf(crComEga.getEg06bj06()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj06());
			values[i][330] = String.valueOf(crComEga.getEg06bj07()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj07());
			values[i][331] = String.valueOf(crComEga.getEg06bj08()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj08());
			values[i][332] = String.valueOf(crComEga.getEg06bj09()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj09());
			values[i][333] = String.valueOf(crComEga.getEg06bj10()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj10());
			values[i][334] = String.valueOf(crComEga.getEg06bj11()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj11());
			values[i][335] = String.valueOf(crComEga.getEg06bj12()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj12());
			values[i][336] = String.valueOf(crComEga.getEg06bj13()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj13());
			values[i][337] = String.valueOf(crComEga.getEg06bj14()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj14());
			values[i][338] = String.valueOf(crComEga.getEg06bj15()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj15());
			values[i][339] = String.valueOf(crComEga.getEg06bj16()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj16());
			values[i][340] = String.valueOf(crComEga.getEg06bj17()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj17());
			values[i][341] = String.valueOf(crComEga.getEg06bj18()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj18());
			values[i][342] = String.valueOf(crComEga.getEg06bj19()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj19());
			values[i][343] = String.valueOf(crComEga.getEg06bj20()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj20());
			values[i][344] = String.valueOf(crComEga.getEg06bj21()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj21());
			values[i][345] = String.valueOf(crComEga.getEg06bj22()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj22());
			values[i][346] = String.valueOf(crComEga.getEg06bj23()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj23());
			values[i][347] = String.valueOf(crComEga.getEg06bj24()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj24());
			values[i][348] = String.valueOf(crComEga.getEg06bj25()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj25());
			values[i][349] = String.valueOf(crComEga.getEg06bj26()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj26());
			values[i][350] = String.valueOf(crComEga.getEg06bj27()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj27());
			values[i][351] = String.valueOf(crComEga.getEg06bj28()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj28());
			values[i][352] = String.valueOf(crComEga.getEg06bj29()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj29());
			values[i][353] = String.valueOf(crComEga.getEg06bj30()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj30());
			values[i][354] = String.valueOf(crComEga.getEg06bj31()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj31());
			values[i][355] = String.valueOf(crComEga.getEg06bj32()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj32());
			values[i][356] = String.valueOf(crComEga.getEg06bj33()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj33());
			values[i][357] = String.valueOf(crComEga.getEg06bj34()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj34());
			values[i][358] = String.valueOf(crComEga.getEg06bj35()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj35());
			values[i][359] = String.valueOf(crComEga.getEg06bj36()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj36());
			values[i][360] = String.valueOf(crComEga.getEg06bj37()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj37());
			values[i][361] = String.valueOf(crComEga.getEg06bj38()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj38());
			values[i][362] = String.valueOf(crComEga.getEg06bj39()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj39());
			values[i][363] = String.valueOf(crComEga.getEg06bj40()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj40());
			values[i][364] = String.valueOf(crComEga.getEg06bj41()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj41());
			values[i][365] = String.valueOf(crComEga.getEg06bj42()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj42());
			values[i][366] = String.valueOf(crComEga.getEg06bj43()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj43());
			values[i][367] = String.valueOf(crComEga.getEg06bj44()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj44());
			values[i][368] = String.valueOf(crComEga.getEg06bj45()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj45());
			values[i][369] = String.valueOf(crComEga.getEg06bj46()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj46());
			values[i][370] = String.valueOf(crComEga.getEg06bj47()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj47());
			values[i][371] = String.valueOf(crComEga.getEg06bj48()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj48());
			values[i][372] = String.valueOf(crComEga.getEg06bj49()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj49());
			values[i][373] = String.valueOf(crComEga.getEg06bj50()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj50());
			values[i][374] = String.valueOf(crComEga.getEg06bj51()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj51());
			values[i][375] = String.valueOf(crComEga.getEg06bj52()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj52());
			values[i][376] = String.valueOf(crComEga.getEg06bj53()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj53());
			values[i][377] = String.valueOf(crComEga.getEg06bj54()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj54());
			values[i][378] = String.valueOf(crComEga.getEg06bj55()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj55());
			values[i][379] = String.valueOf(crComEga.getEg06bj56()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj56());
			values[i][380] = String.valueOf(crComEga.getEg06bj57()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj57());
			values[i][381] = String.valueOf(crComEga.getEg06bj58()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj58());
			values[i][382] = String.valueOf(crComEga.getEg06bj59()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj59());
			values[i][383] = String.valueOf(crComEga.getEg06bj60()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj60());
			values[i][384] = String.valueOf(crComEga.getEg06bj61()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj61());
			values[i][385] = String.valueOf(crComEga.getEg06bj62()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj62());
			values[i][386] = String.valueOf(crComEga.getEg06bj63()) == "null" ? ""
					: String.valueOf(crComEga.getEg06bj63());
			values[i][387] = String.valueOf(crComEga.getEg07ai01()) == "null" ? ""
					: String.valueOf(crComEga.getEg07ai01());
			values[i][388] = String.valueOf(crComEga.getEg07ad01()) == "null" ? ""
					: String.valueOf(crComEga.getEg07ad01());
			values[i][389] = String.valueOf(crComEga.getEg07ai02()) == "null" ? ""
					: String.valueOf(crComEga.getEg07ai02());
			values[i][390] = String.valueOf(crComEga.getEg07ar01()) == "null" ? ""
					: String.valueOf(crComEga.getEg07ar01());
			values[i][391] = String.valueOf(crComEga.getEg07ad02()) == "null" ? ""
					: String.valueOf(crComEga.getEg07ad02());
			values[i][392] = String.valueOf(crComEga.getEg07ad03()) == "null" ? ""
					: String.valueOf(crComEga.getEg07ad03());
			values[i][393] = String.valueOf(crComEga.getEg07bj01()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj01());
			values[i][394] = String.valueOf(crComEga.getEg07bj02()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj02());
			values[i][395] = String.valueOf(crComEga.getEg07bj03()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj03());
			values[i][396] = String.valueOf(crComEga.getEg07bj04()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj04());
			values[i][397] = String.valueOf(crComEga.getEg07bj05()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj05());
			values[i][398] = String.valueOf(crComEga.getEg07bj06()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj06());
			values[i][399] = String.valueOf(crComEga.getEg07bj07()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj07());
			values[i][400] = String.valueOf(crComEga.getEg07bj08()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj08());
			values[i][401] = String.valueOf(crComEga.getEg07bj09()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj09());
			values[i][402] = String.valueOf(crComEga.getEg07bj10()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj10());
			values[i][403] = String.valueOf(crComEga.getEg07bj11()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj11());
			values[i][404] = String.valueOf(crComEga.getEg07bj12()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj12());
			values[i][405] = String.valueOf(crComEga.getEg07bj13()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj13());
			values[i][406] = String.valueOf(crComEga.getEg07bj14()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj14());
			values[i][407] = String.valueOf(crComEga.getEg07bj15()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj15());
			values[i][408] = String.valueOf(crComEga.getEg07bj16()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj16());
			values[i][409] = String.valueOf(crComEga.getEg07bj17()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj17());
			values[i][410] = String.valueOf(crComEga.getEg07bj18()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj18());
			values[i][411] = String.valueOf(crComEga.getEg07bj19()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj19());
			values[i][412] = String.valueOf(crComEga.getEg07bj20()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj20());
			values[i][413] = String.valueOf(crComEga.getEg07bj21()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj21());
			values[i][414] = String.valueOf(crComEga.getEg07bj22()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj22());
			values[i][415] = String.valueOf(crComEga.getEg07bj23()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj23());
			values[i][416] = String.valueOf(crComEga.getEg07bj24()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj24());
			values[i][417] = String.valueOf(crComEga.getEg07bj25()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj25());
			values[i][418] = String.valueOf(crComEga.getEg07bj26()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj26());
			values[i][419] = String.valueOf(crComEga.getEg07bj27()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj27());
			values[i][420] = String.valueOf(crComEga.getEg07bj28()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj28());
			values[i][421] = String.valueOf(crComEga.getEg07bj29()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj29());
			values[i][422] = String.valueOf(crComEga.getEg07bj30()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj30());
			values[i][423] = String.valueOf(crComEga.getEg07bj31()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj31());
			values[i][424] = String.valueOf(crComEga.getEg07bj32()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj32());
			values[i][425] = String.valueOf(crComEga.getEg07bj33()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj33());
			values[i][426] = String.valueOf(crComEga.getEg07bj34()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj34());
			values[i][427] = String.valueOf(crComEga.getEg07bj35()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj35());
			values[i][428] = String.valueOf(crComEga.getEg07bj36()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj36());
			values[i][429] = String.valueOf(crComEga.getEg07bj37()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj37());
			values[i][430] = String.valueOf(crComEga.getEg07bj38()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj38());
			values[i][431] = String.valueOf(crComEga.getEg07bj39()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj39());
			values[i][432] = String.valueOf(crComEga.getEg07bj40()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj40());
			values[i][433] = String.valueOf(crComEga.getEg07bj41()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj41());
			values[i][434] = String.valueOf(crComEga.getEg07bj42()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj42());
			values[i][435] = String.valueOf(crComEga.getEg07bj43()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj43());
			values[i][436] = String.valueOf(crComEga.getEg07bj44()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj44());
			values[i][437] = String.valueOf(crComEga.getEg07bj45()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj45());
			values[i][438] = String.valueOf(crComEga.getEg07bj46()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj46());
			values[i][439] = String.valueOf(crComEga.getEg07bj47()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj47());
			values[i][440] = String.valueOf(crComEga.getEg07bj48()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj48());
			values[i][441] = String.valueOf(crComEga.getEg07bj49()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj49());
			values[i][442] = String.valueOf(crComEga.getEg07bj50()) == "null" ? ""
					: String.valueOf(crComEga.getEg07bj50());
			values[i][443] = String.valueOf(crComEga.getEg08ai01()) == "null" ? ""
					: String.valueOf(crComEga.getEg08ai01());
			values[i][444] = String.valueOf(crComEga.getEg08ad01()) == "null" ? ""
					: String.valueOf(crComEga.getEg08ad01());
			values[i][445] = String.valueOf(crComEga.getEg08ai02()) == "null" ? ""
					: String.valueOf(crComEga.getEg08ai02());
			values[i][446] = String.valueOf(crComEga.getEg08ar01()) == "null" ? ""
					: String.valueOf(crComEga.getEg08ar01());
			values[i][447] = String.valueOf(crComEga.getEg08ad02()) == "null" ? ""
					: String.valueOf(crComEga.getEg08ad02());
			values[i][448] = String.valueOf(crComEga.getEg08ad03()) == "null" ? ""
					: String.valueOf(crComEga.getEg08ad03());
			values[i][449] = String.valueOf(crComEga.getEg08bj01()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj01());
			values[i][450] = String.valueOf(crComEga.getEg08bj02()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj02());
			values[i][451] = String.valueOf(crComEga.getEg08bj03()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj03());
			values[i][452] = String.valueOf(crComEga.getEg08bj04()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj04());
			values[i][453] = String.valueOf(crComEga.getEg08bj05()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj05());
			values[i][454] = String.valueOf(crComEga.getEg08bj06()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj06());
			values[i][455] = String.valueOf(crComEga.getEg08bj07()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj07());
			values[i][456] = String.valueOf(crComEga.getEg08bj08()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj08());
			values[i][457] = String.valueOf(crComEga.getEg08bj09()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj09());
			values[i][458] = String.valueOf(crComEga.getEg08bj10()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj10());
			values[i][459] = String.valueOf(crComEga.getEg08bj11()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj11());
			values[i][460] = String.valueOf(crComEga.getEg08bj12()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj12());
			values[i][461] = String.valueOf(crComEga.getEg08bj13()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj13());
			values[i][462] = String.valueOf(crComEga.getEg08bj14()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj14());
			values[i][463] = String.valueOf(crComEga.getEg08bj15()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj15());
			values[i][464] = String.valueOf(crComEga.getEg08bj16()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj16());
			values[i][465] = String.valueOf(crComEga.getEg08bj17()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj17());
			values[i][466] = String.valueOf(crComEga.getEg08bj18()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj18());
			values[i][467] = String.valueOf(crComEga.getEg08bj19()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj19());
			values[i][468] = String.valueOf(crComEga.getEg08bj20()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj20());
			values[i][469] = String.valueOf(crComEga.getEg08bj21()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj21());
			values[i][470] = String.valueOf(crComEga.getEg08bj22()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj22());
			values[i][471] = String.valueOf(crComEga.getEg08bj23()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj23());
			values[i][472] = String.valueOf(crComEga.getEg08bj24()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj24());
			values[i][473] = String.valueOf(crComEga.getEg08bj25()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj25());
			values[i][474] = String.valueOf(crComEga.getEg08bj26()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj26());
			values[i][475] = String.valueOf(crComEga.getEg08bj27()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj27());
			values[i][476] = String.valueOf(crComEga.getEg08bj28()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj28());
			values[i][477] = String.valueOf(crComEga.getEg08bj29()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj29());
			values[i][478] = String.valueOf(crComEga.getEg08bj30()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj30());
			values[i][479] = String.valueOf(crComEga.getEg08bj31()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj31());
			values[i][480] = String.valueOf(crComEga.getEg08bj32()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj32());
			values[i][481] = String.valueOf(crComEga.getEg08bj33()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj33());
			values[i][482] = String.valueOf(crComEga.getEg08bj34()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj34());
			values[i][483] = String.valueOf(crComEga.getEg08bj35()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj35());
			values[i][484] = String.valueOf(crComEga.getEg08bj36()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj36());
			values[i][485] = String.valueOf(crComEga.getEg08bj37()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj37());
			values[i][486] = String.valueOf(crComEga.getEg08bj38()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj38());
			values[i][487] = String.valueOf(crComEga.getEg08bj39()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj39());
			values[i][488] = String.valueOf(crComEga.getEg08bj40()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj40());
			values[i][489] = String.valueOf(crComEga.getEg08bj41()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj41());
			values[i][490] = String.valueOf(crComEga.getEg08bj42()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj42());
			values[i][491] = String.valueOf(crComEga.getEg08bj43()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj43());
			values[i][492] = String.valueOf(crComEga.getEg08bj44()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj44());
			values[i][493] = String.valueOf(crComEga.getEg08bj45()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj45());
			values[i][494] = String.valueOf(crComEga.getEg08bj46()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj46());
			values[i][495] = String.valueOf(crComEga.getEg08bj47()) == "null" ? ""
					: String.valueOf(crComEga.getEg08bj47());
			values[i][496] = String.valueOf(crComEga.getEg09ai01()) == "null" ? ""
					: String.valueOf(crComEga.getEg09ai01());
			values[i][497] = String.valueOf(crComEga.getEg09ad01()) == "null" ? ""
					: String.valueOf(crComEga.getEg09ad01());
			values[i][498] = String.valueOf(crComEga.getEg09ai02()) == "null" ? ""
					: String.valueOf(crComEga.getEg09ai02());
			values[i][499] = String.valueOf(crComEga.getEg09ar01()) == "null" ? ""
					: String.valueOf(crComEga.getEg09ar01());
			values[i][500] = String.valueOf(crComEga.getEg09ad02()) == "null" ? ""
					: String.valueOf(crComEga.getEg09ad02());
			values[i][501] = String.valueOf(crComEga.getEg09ad03()) == "null" ? ""
					: String.valueOf(crComEga.getEg09ad03());
			values[i][502] = String.valueOf(crComEga.getEg09bj01()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj01());
			values[i][503] = String.valueOf(crComEga.getEg09bj02()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj02());
			values[i][504] = String.valueOf(crComEga.getEg09bj03()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj03());
			values[i][505] = String.valueOf(crComEga.getEg09bj04()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj04());
			values[i][506] = String.valueOf(crComEga.getEg09bj05()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj05());
			values[i][507] = String.valueOf(crComEga.getEg09bj06()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj06());
			values[i][508] = String.valueOf(crComEga.getEg09bj07()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj07());
			values[i][509] = String.valueOf(crComEga.getEg09bj08()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj08());
			values[i][510] = String.valueOf(crComEga.getEg09bj09()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj09());
			values[i][511] = String.valueOf(crComEga.getEg09bj10()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj10());
			values[i][512] = String.valueOf(crComEga.getEg09bj11()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj11());
			values[i][513] = String.valueOf(crComEga.getEg09bj12()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj12());
			values[i][514] = String.valueOf(crComEga.getEg09bj13()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj13());
			values[i][515] = String.valueOf(crComEga.getEg09bj14()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj14());
			values[i][516] = String.valueOf(crComEga.getEg09bj15()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj15());
			values[i][517] = String.valueOf(crComEga.getEg09bj16()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj16());
			values[i][518] = String.valueOf(crComEga.getEg09bj17()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj17());
			values[i][519] = String.valueOf(crComEga.getEg09bj18()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj18());
			values[i][520] = String.valueOf(crComEga.getEg09bj19()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj19());
			values[i][521] = String.valueOf(crComEga.getEg09bj20()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj20());
			values[i][522] = String.valueOf(crComEga.getEg09bj21()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj21());
			values[i][523] = String.valueOf(crComEga.getEg09bj22()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj22());
			values[i][524] = String.valueOf(crComEga.getEg09bj23()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj23());
			values[i][525] = String.valueOf(crComEga.getEg09bj24()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj24());
			values[i][526] = String.valueOf(crComEga.getEg09bj25()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj25());
			values[i][527] = String.valueOf(crComEga.getEg09bj26()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj26());
			values[i][528] = String.valueOf(crComEga.getEg09bj27()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj27());
			values[i][529] = String.valueOf(crComEga.getEg09bj28()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj28());
			values[i][530] = String.valueOf(crComEga.getEg09bj29()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj29());
			values[i][531] = String.valueOf(crComEga.getEg09bj30()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj30());
			values[i][532] = String.valueOf(crComEga.getEg09bj31()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj31());
			values[i][533] = String.valueOf(crComEga.getEg09bj32()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj32());
			values[i][534] = String.valueOf(crComEga.getEg09bj33()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj33());
			values[i][535] = String.valueOf(crComEga.getEg09bj34()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj34());
			values[i][536] = String.valueOf(crComEga.getEg09bj35()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj35());
			values[i][537] = String.valueOf(crComEga.getEg09bj36()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj36());
			values[i][538] = String.valueOf(crComEga.getEg09bj37()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj37());
			values[i][539] = String.valueOf(crComEga.getEg09bj38()) == "null" ? ""
					: String.valueOf(crComEga.getEg09bj38());
			values[i][540] = String.valueOf(crComEga.getEg10ai01()) == "null" ? ""
					: String.valueOf(crComEga.getEg10ai01());
			values[i][541] = String.valueOf(crComEga.getEg10ad01()) == "null" ? ""
					: String.valueOf(crComEga.getEg10ad01());
			values[i][542] = String.valueOf(crComEga.getEg10ai02()) == "null" ? ""
					: String.valueOf(crComEga.getEg10ai02());
			values[i][543] = String.valueOf(crComEga.getEg10ar01()) == "null" ? ""
					: String.valueOf(crComEga.getEg10ar01());
			values[i][544] = String.valueOf(crComEga.getEg10ad02()) == "null" ? ""
					: String.valueOf(crComEga.getEg10ad02());
			values[i][545] = String.valueOf(crComEga.getEg10ad03()) == "null" ? ""
					: String.valueOf(crComEga.getEg10ad03());
			values[i][546] = String.valueOf(crComEga.getEg10bj01()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj01());
			values[i][547] = String.valueOf(crComEga.getEg10bj02()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj02());
			values[i][548] = String.valueOf(crComEga.getEg10bj03()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj03());
			values[i][549] = String.valueOf(crComEga.getEg10bj04()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj04());
			values[i][550] = String.valueOf(crComEga.getEg10bj05()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj05());
			values[i][551] = String.valueOf(crComEga.getEg10bj06()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj06());
			values[i][552] = String.valueOf(crComEga.getEg10bj07()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj07());
			values[i][553] = String.valueOf(crComEga.getEg10bj08()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj08());
			values[i][554] = String.valueOf(crComEga.getEg10bj09()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj09());
			values[i][555] = String.valueOf(crComEga.getEg10bj10()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj10());
			values[i][556] = String.valueOf(crComEga.getEg10bj11()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj11());
			values[i][557] = String.valueOf(crComEga.getEg10bj12()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj12());
			values[i][558] = String.valueOf(crComEga.getEg10bj13()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj13());
			values[i][559] = String.valueOf(crComEga.getEg10bj14()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj14());
			values[i][560] = String.valueOf(crComEga.getEg10bj15()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj15());
			values[i][561] = String.valueOf(crComEga.getEg10bj16()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj16());
			values[i][562] = String.valueOf(crComEga.getEg10bj17()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj17());
			values[i][563] = String.valueOf(crComEga.getEg10bj18()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj18());
			values[i][564] = String.valueOf(crComEga.getEg10bj19()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj19());
			values[i][565] = String.valueOf(crComEga.getEg10bj20()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj20());
			values[i][566] = String.valueOf(crComEga.getEg10bj21()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj21());
			values[i][567] = String.valueOf(crComEga.getEg10bj22()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj22());
			values[i][568] = String.valueOf(crComEga.getEg10bj23()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj23());
			values[i][569] = String.valueOf(crComEga.getEg10bj24()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj24());
			values[i][570] = String.valueOf(crComEga.getEg10bj25()) == "null" ? ""
					: String.valueOf(crComEga.getEg10bj25());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		sheet.autoSizeColumn((short) 19);
		sheet.autoSizeColumn((short) 20);
		sheet.autoSizeColumn((short) 21);
		sheet.autoSizeColumn((short) 22);
		sheet.autoSizeColumn((short) 23);
		sheet.autoSizeColumn((short) 24);
		sheet.autoSizeColumn((short) 25);
		sheet.autoSizeColumn((short) 26);
		sheet.autoSizeColumn((short) 27);
		sheet.autoSizeColumn((short) 28);
		sheet.autoSizeColumn((short) 29);
		sheet.autoSizeColumn((short) 30);
		sheet.autoSizeColumn((short) 31);
		sheet.autoSizeColumn((short) 32);
		sheet.autoSizeColumn((short) 33);
		sheet.autoSizeColumn((short) 34);
		sheet.autoSizeColumn((short) 35);
		sheet.autoSizeColumn((short) 36);
		sheet.autoSizeColumn((short) 37);
		sheet.autoSizeColumn((short) 38);
		sheet.autoSizeColumn((short) 39);
		sheet.autoSizeColumn((short) 40);
		sheet.autoSizeColumn((short) 41);
		sheet.autoSizeColumn((short) 42);
		sheet.autoSizeColumn((short) 43);
		sheet.autoSizeColumn((short) 44);
		sheet.autoSizeColumn((short) 45);
		sheet.autoSizeColumn((short) 46);
		sheet.autoSizeColumn((short) 47);
		sheet.autoSizeColumn((short) 48);
		sheet.autoSizeColumn((short) 49);
		sheet.autoSizeColumn((short) 50);
		sheet.autoSizeColumn((short) 51);
		sheet.autoSizeColumn((short) 52);
		sheet.autoSizeColumn((short) 53);
		sheet.autoSizeColumn((short) 54);
		sheet.autoSizeColumn((short) 55);
		sheet.autoSizeColumn((short) 56);
		sheet.autoSizeColumn((short) 57);
		sheet.autoSizeColumn((short) 58);
		sheet.autoSizeColumn((short) 59);
		sheet.autoSizeColumn((short) 60);
		sheet.autoSizeColumn((short) 61);
		sheet.autoSizeColumn((short) 62);
		sheet.autoSizeColumn((short) 63);
		sheet.autoSizeColumn((short) 64);
		sheet.autoSizeColumn((short) 65);
		sheet.autoSizeColumn((short) 66);
		sheet.autoSizeColumn((short) 67);
		sheet.autoSizeColumn((short) 68);
		sheet.autoSizeColumn((short) 69);
		sheet.autoSizeColumn((short) 70);
		sheet.autoSizeColumn((short) 71);
		sheet.autoSizeColumn((short) 72);
		sheet.autoSizeColumn((short) 73);
		sheet.autoSizeColumn((short) 74);
		sheet.autoSizeColumn((short) 75);
		sheet.autoSizeColumn((short) 76);
		sheet.autoSizeColumn((short) 77);
		sheet.autoSizeColumn((short) 78);
		sheet.autoSizeColumn((short) 79);
		sheet.autoSizeColumn((short) 80);
		sheet.autoSizeColumn((short) 81);
		sheet.autoSizeColumn((short) 82);
		sheet.autoSizeColumn((short) 83);
		sheet.autoSizeColumn((short) 84);
		sheet.autoSizeColumn((short) 85);
		sheet.autoSizeColumn((short) 86);
		sheet.autoSizeColumn((short) 87);
		sheet.autoSizeColumn((short) 88);
		sheet.autoSizeColumn((short) 89);
		sheet.autoSizeColumn((short) 90);
		sheet.autoSizeColumn((short) 91);
		sheet.autoSizeColumn((short) 92);
		sheet.autoSizeColumn((short) 93);
		sheet.autoSizeColumn((short) 94);
		sheet.autoSizeColumn((short) 95);
		sheet.autoSizeColumn((short) 96);
		sheet.autoSizeColumn((short) 97);
		sheet.autoSizeColumn((short) 98);
		sheet.autoSizeColumn((short) 99);
		sheet.autoSizeColumn((short) 100);
		sheet.autoSizeColumn((short) 101);
		sheet.autoSizeColumn((short) 102);
		sheet.autoSizeColumn((short) 103);
		sheet.autoSizeColumn((short) 104);
		sheet.autoSizeColumn((short) 105);
		sheet.autoSizeColumn((short) 106);
		sheet.autoSizeColumn((short) 107);
		sheet.autoSizeColumn((short) 108);
		sheet.autoSizeColumn((short) 109);
		sheet.autoSizeColumn((short) 110);
		sheet.autoSizeColumn((short) 111);
		sheet.autoSizeColumn((short) 112);
		sheet.autoSizeColumn((short) 113);
		sheet.autoSizeColumn((short) 114);
		sheet.autoSizeColumn((short) 115);
		sheet.autoSizeColumn((short) 116);
		sheet.autoSizeColumn((short) 117);
		sheet.autoSizeColumn((short) 118);
		sheet.autoSizeColumn((short) 119);
		sheet.autoSizeColumn((short) 120);
		sheet.autoSizeColumn((short) 121);
		sheet.autoSizeColumn((short) 122);
		sheet.autoSizeColumn((short) 123);
		sheet.autoSizeColumn((short) 124);
		sheet.autoSizeColumn((short) 125);
		sheet.autoSizeColumn((short) 126);
		sheet.autoSizeColumn((short) 127);
		sheet.autoSizeColumn((short) 128);
		sheet.autoSizeColumn((short) 129);
		sheet.autoSizeColumn((short) 130);
		sheet.autoSizeColumn((short) 131);
		sheet.autoSizeColumn((short) 132);
		sheet.autoSizeColumn((short) 133);
		sheet.autoSizeColumn((short) 134);
		sheet.autoSizeColumn((short) 135);
		sheet.autoSizeColumn((short) 136);
		sheet.autoSizeColumn((short) 137);
		sheet.autoSizeColumn((short) 138);
		sheet.autoSizeColumn((short) 139);
		sheet.autoSizeColumn((short) 140);
		sheet.autoSizeColumn((short) 141);
		sheet.autoSizeColumn((short) 142);
		sheet.autoSizeColumn((short) 143);
		sheet.autoSizeColumn((short) 144);
		sheet.autoSizeColumn((short) 145);
		sheet.autoSizeColumn((short) 146);
		sheet.autoSizeColumn((short) 147);
		sheet.autoSizeColumn((short) 148);
		sheet.autoSizeColumn((short) 149);
		sheet.autoSizeColumn((short) 150);
		sheet.autoSizeColumn((short) 151);
		sheet.autoSizeColumn((short) 152);
		sheet.autoSizeColumn((short) 153);
		sheet.autoSizeColumn((short) 154);
		sheet.autoSizeColumn((short) 155);
		sheet.autoSizeColumn((short) 156);
		sheet.autoSizeColumn((short) 157);
		sheet.autoSizeColumn((short) 158);
		sheet.autoSizeColumn((short) 159);
		sheet.autoSizeColumn((short) 160);
		sheet.autoSizeColumn((short) 161);
		sheet.autoSizeColumn((short) 162);
		sheet.autoSizeColumn((short) 163);
		sheet.autoSizeColumn((short) 164);
		sheet.autoSizeColumn((short) 165);
		sheet.autoSizeColumn((short) 166);
		sheet.autoSizeColumn((short) 167);
		sheet.autoSizeColumn((short) 168);
		sheet.autoSizeColumn((short) 169);
		sheet.autoSizeColumn((short) 170);
		sheet.autoSizeColumn((short) 171);
		sheet.autoSizeColumn((short) 172);
		sheet.autoSizeColumn((short) 173);
		sheet.autoSizeColumn((short) 174);
		sheet.autoSizeColumn((short) 175);
		sheet.autoSizeColumn((short) 176);
		sheet.autoSizeColumn((short) 177);
		sheet.autoSizeColumn((short) 178);
		sheet.autoSizeColumn((short) 179);
		sheet.autoSizeColumn((short) 180);
		sheet.autoSizeColumn((short) 181);
		sheet.autoSizeColumn((short) 182);
		sheet.autoSizeColumn((short) 183);
		sheet.autoSizeColumn((short) 184);
		sheet.autoSizeColumn((short) 185);
		sheet.autoSizeColumn((short) 186);
		sheet.autoSizeColumn((short) 187);
		sheet.autoSizeColumn((short) 188);
		sheet.autoSizeColumn((short) 189);
		sheet.autoSizeColumn((short) 190);
		sheet.autoSizeColumn((short) 191);
		sheet.autoSizeColumn((short) 192);
		sheet.autoSizeColumn((short) 193);
		sheet.autoSizeColumn((short) 194);
		sheet.autoSizeColumn((short) 195);
		sheet.autoSizeColumn((short) 196);
		sheet.autoSizeColumn((short) 197);
		sheet.autoSizeColumn((short) 198);
		sheet.autoSizeColumn((short) 199);
		sheet.autoSizeColumn((short) 200);
		sheet.autoSizeColumn((short) 201);
		sheet.autoSizeColumn((short) 202);
		sheet.autoSizeColumn((short) 203);
		sheet.autoSizeColumn((short) 204);
		sheet.autoSizeColumn((short) 205);
		sheet.autoSizeColumn((short) 206);
		sheet.autoSizeColumn((short) 207);
		sheet.autoSizeColumn((short) 208);
		sheet.autoSizeColumn((short) 209);
		sheet.autoSizeColumn((short) 210);
		sheet.autoSizeColumn((short) 211);
		sheet.autoSizeColumn((short) 212);
		sheet.autoSizeColumn((short) 213);
		sheet.autoSizeColumn((short) 214);
		sheet.autoSizeColumn((short) 215);
		sheet.autoSizeColumn((short) 216);
		sheet.autoSizeColumn((short) 217);
		sheet.autoSizeColumn((short) 218);
		sheet.autoSizeColumn((short) 219);
		sheet.autoSizeColumn((short) 220);
		sheet.autoSizeColumn((short) 221);
		sheet.autoSizeColumn((short) 222);
		sheet.autoSizeColumn((short) 223);
		sheet.autoSizeColumn((short) 224);
		sheet.autoSizeColumn((short) 225);
		sheet.autoSizeColumn((short) 226);
		sheet.autoSizeColumn((short) 227);
		sheet.autoSizeColumn((short) 228);
		sheet.autoSizeColumn((short) 229);
		sheet.autoSizeColumn((short) 230);
		sheet.autoSizeColumn((short) 231);
		sheet.autoSizeColumn((short) 232);
		sheet.autoSizeColumn((short) 233);
		sheet.autoSizeColumn((short) 234);
		sheet.autoSizeColumn((short) 235);
		sheet.autoSizeColumn((short) 236);
		sheet.autoSizeColumn((short) 237);
		sheet.autoSizeColumn((short) 238);
		sheet.autoSizeColumn((short) 239);
		sheet.autoSizeColumn((short) 240);
		sheet.autoSizeColumn((short) 241);
		sheet.autoSizeColumn((short) 242);
		sheet.autoSizeColumn((short) 243);
		sheet.autoSizeColumn((short) 244);
		sheet.autoSizeColumn((short) 245);
		sheet.autoSizeColumn((short) 246);
		sheet.autoSizeColumn((short) 247);
		sheet.autoSizeColumn((short) 248);
		sheet.autoSizeColumn((short) 249);
		sheet.autoSizeColumn((short) 250);
		sheet.autoSizeColumn((short) 251);
		sheet.autoSizeColumn((short) 252);
		sheet.autoSizeColumn((short) 253);
		sheet.autoSizeColumn((short) 254);
		sheet.autoSizeColumn((short) 255);
		sheet.autoSizeColumn((short) 256);
		sheet.autoSizeColumn((short) 257);
		sheet.autoSizeColumn((short) 258);
		sheet.autoSizeColumn((short) 259);
		sheet.autoSizeColumn((short) 260);
		sheet.autoSizeColumn((short) 261);
		sheet.autoSizeColumn((short) 262);
		sheet.autoSizeColumn((short) 263);
		sheet.autoSizeColumn((short) 264);
		sheet.autoSizeColumn((short) 265);
		sheet.autoSizeColumn((short) 266);
		sheet.autoSizeColumn((short) 267);
		sheet.autoSizeColumn((short) 268);
		sheet.autoSizeColumn((short) 269);
		sheet.autoSizeColumn((short) 270);
		sheet.autoSizeColumn((short) 271);
		sheet.autoSizeColumn((short) 272);
		sheet.autoSizeColumn((short) 273);
		sheet.autoSizeColumn((short) 274);
		sheet.autoSizeColumn((short) 275);
		sheet.autoSizeColumn((short) 276);
		sheet.autoSizeColumn((short) 277);
		sheet.autoSizeColumn((short) 278);
		sheet.autoSizeColumn((short) 279);
		sheet.autoSizeColumn((short) 280);
		sheet.autoSizeColumn((short) 281);
		sheet.autoSizeColumn((short) 282);
		sheet.autoSizeColumn((short) 283);
		sheet.autoSizeColumn((short) 284);
		sheet.autoSizeColumn((short) 285);
		sheet.autoSizeColumn((short) 286);
		sheet.autoSizeColumn((short) 287);
		sheet.autoSizeColumn((short) 288);
		sheet.autoSizeColumn((short) 289);
		sheet.autoSizeColumn((short) 290);
		sheet.autoSizeColumn((short) 291);
		sheet.autoSizeColumn((short) 292);
		sheet.autoSizeColumn((short) 293);
		sheet.autoSizeColumn((short) 294);
		sheet.autoSizeColumn((short) 295);
		sheet.autoSizeColumn((short) 296);
		sheet.autoSizeColumn((short) 297);
		sheet.autoSizeColumn((short) 298);
		sheet.autoSizeColumn((short) 299);
		sheet.autoSizeColumn((short) 300);
		sheet.autoSizeColumn((short) 301);
		sheet.autoSizeColumn((short) 302);
		sheet.autoSizeColumn((short) 303);
		sheet.autoSizeColumn((short) 304);
		sheet.autoSizeColumn((short) 305);
		sheet.autoSizeColumn((short) 306);
		sheet.autoSizeColumn((short) 307);
		sheet.autoSizeColumn((short) 308);
		sheet.autoSizeColumn((short) 309);
		sheet.autoSizeColumn((short) 310);
		sheet.autoSizeColumn((short) 311);
		sheet.autoSizeColumn((short) 312);
		sheet.autoSizeColumn((short) 313);
		sheet.autoSizeColumn((short) 314);
		sheet.autoSizeColumn((short) 315);
		sheet.autoSizeColumn((short) 316);
		sheet.autoSizeColumn((short) 317);
		sheet.autoSizeColumn((short) 318);
		sheet.autoSizeColumn((short) 319);
		sheet.autoSizeColumn((short) 320);
		sheet.autoSizeColumn((short) 321);
		sheet.autoSizeColumn((short) 322);
		sheet.autoSizeColumn((short) 323);
		sheet.autoSizeColumn((short) 324);
		sheet.autoSizeColumn((short) 325);
		sheet.autoSizeColumn((short) 326);
		sheet.autoSizeColumn((short) 327);
		sheet.autoSizeColumn((short) 328);
		sheet.autoSizeColumn((short) 329);
		sheet.autoSizeColumn((short) 330);
		sheet.autoSizeColumn((short) 331);
		sheet.autoSizeColumn((short) 332);
		sheet.autoSizeColumn((short) 333);
		sheet.autoSizeColumn((short) 334);
		sheet.autoSizeColumn((short) 335);
		sheet.autoSizeColumn((short) 336);
		sheet.autoSizeColumn((short) 337);
		sheet.autoSizeColumn((short) 338);
		sheet.autoSizeColumn((short) 339);
		sheet.autoSizeColumn((short) 340);
		sheet.autoSizeColumn((short) 341);
		sheet.autoSizeColumn((short) 342);
		sheet.autoSizeColumn((short) 343);
		sheet.autoSizeColumn((short) 344);
		sheet.autoSizeColumn((short) 345);
		sheet.autoSizeColumn((short) 346);
		sheet.autoSizeColumn((short) 347);
		sheet.autoSizeColumn((short) 348);
		sheet.autoSizeColumn((short) 349);
		sheet.autoSizeColumn((short) 350);
		sheet.autoSizeColumn((short) 351);
		sheet.autoSizeColumn((short) 352);
		sheet.autoSizeColumn((short) 353);
		sheet.autoSizeColumn((short) 354);
		sheet.autoSizeColumn((short) 355);
		sheet.autoSizeColumn((short) 356);
		sheet.autoSizeColumn((short) 357);
		sheet.autoSizeColumn((short) 358);
		sheet.autoSizeColumn((short) 359);
		sheet.autoSizeColumn((short) 360);
		sheet.autoSizeColumn((short) 361);
		sheet.autoSizeColumn((short) 362);
		sheet.autoSizeColumn((short) 363);
		sheet.autoSizeColumn((short) 364);
		sheet.autoSizeColumn((short) 365);
		sheet.autoSizeColumn((short) 366);
		sheet.autoSizeColumn((short) 367);
		sheet.autoSizeColumn((short) 368);
		sheet.autoSizeColumn((short) 369);
		sheet.autoSizeColumn((short) 370);
		sheet.autoSizeColumn((short) 371);
		sheet.autoSizeColumn((short) 372);
		sheet.autoSizeColumn((short) 373);
		sheet.autoSizeColumn((short) 374);
		sheet.autoSizeColumn((short) 375);
		sheet.autoSizeColumn((short) 376);
		sheet.autoSizeColumn((short) 377);
		sheet.autoSizeColumn((short) 378);
		sheet.autoSizeColumn((short) 379);
		sheet.autoSizeColumn((short) 380);
		sheet.autoSizeColumn((short) 381);
		sheet.autoSizeColumn((short) 382);
		sheet.autoSizeColumn((short) 383);
		sheet.autoSizeColumn((short) 384);
		sheet.autoSizeColumn((short) 385);
		sheet.autoSizeColumn((short) 386);
		sheet.autoSizeColumn((short) 387);
		sheet.autoSizeColumn((short) 388);
		sheet.autoSizeColumn((short) 389);
		sheet.autoSizeColumn((short) 390);
		sheet.autoSizeColumn((short) 391);
		sheet.autoSizeColumn((short) 392);
		sheet.autoSizeColumn((short) 393);
		sheet.autoSizeColumn((short) 394);
		sheet.autoSizeColumn((short) 395);
		sheet.autoSizeColumn((short) 396);
		sheet.autoSizeColumn((short) 397);
		sheet.autoSizeColumn((short) 398);
		sheet.autoSizeColumn((short) 399);
		sheet.autoSizeColumn((short) 400);
		sheet.autoSizeColumn((short) 401);
		sheet.autoSizeColumn((short) 402);
		sheet.autoSizeColumn((short) 403);
		sheet.autoSizeColumn((short) 404);
		sheet.autoSizeColumn((short) 405);
		sheet.autoSizeColumn((short) 406);
		sheet.autoSizeColumn((short) 407);
		sheet.autoSizeColumn((short) 408);
		sheet.autoSizeColumn((short) 409);
		sheet.autoSizeColumn((short) 410);
		sheet.autoSizeColumn((short) 411);
		sheet.autoSizeColumn((short) 412);
		sheet.autoSizeColumn((short) 413);
		sheet.autoSizeColumn((short) 414);
		sheet.autoSizeColumn((short) 415);
		sheet.autoSizeColumn((short) 416);
		sheet.autoSizeColumn((short) 417);
		sheet.autoSizeColumn((short) 418);
		sheet.autoSizeColumn((short) 419);
		sheet.autoSizeColumn((short) 420);
		sheet.autoSizeColumn((short) 421);
		sheet.autoSizeColumn((short) 422);
		sheet.autoSizeColumn((short) 423);
		sheet.autoSizeColumn((short) 424);
		sheet.autoSizeColumn((short) 425);
		sheet.autoSizeColumn((short) 426);
		sheet.autoSizeColumn((short) 427);
		sheet.autoSizeColumn((short) 428);
		sheet.autoSizeColumn((short) 429);
		sheet.autoSizeColumn((short) 430);
		sheet.autoSizeColumn((short) 431);
		sheet.autoSizeColumn((short) 432);
		sheet.autoSizeColumn((short) 433);
		sheet.autoSizeColumn((short) 434);
		sheet.autoSizeColumn((short) 435);
		sheet.autoSizeColumn((short) 436);
		sheet.autoSizeColumn((short) 437);
		sheet.autoSizeColumn((short) 438);
		sheet.autoSizeColumn((short) 439);
		sheet.autoSizeColumn((short) 440);
		sheet.autoSizeColumn((short) 441);
		sheet.autoSizeColumn((short) 442);
		sheet.autoSizeColumn((short) 443);
		sheet.autoSizeColumn((short) 444);
		sheet.autoSizeColumn((short) 445);
		sheet.autoSizeColumn((short) 446);
		sheet.autoSizeColumn((short) 447);
		sheet.autoSizeColumn((short) 448);
		sheet.autoSizeColumn((short) 449);
		sheet.autoSizeColumn((short) 450);
		sheet.autoSizeColumn((short) 451);
		sheet.autoSizeColumn((short) 452);
		sheet.autoSizeColumn((short) 453);
		sheet.autoSizeColumn((short) 454);
		sheet.autoSizeColumn((short) 455);
		sheet.autoSizeColumn((short) 456);
		sheet.autoSizeColumn((short) 457);
		sheet.autoSizeColumn((short) 458);
		sheet.autoSizeColumn((short) 459);
		sheet.autoSizeColumn((short) 460);
		sheet.autoSizeColumn((short) 461);
		sheet.autoSizeColumn((short) 462);
		sheet.autoSizeColumn((short) 463);
		sheet.autoSizeColumn((short) 464);
		sheet.autoSizeColumn((short) 465);
		sheet.autoSizeColumn((short) 466);
		sheet.autoSizeColumn((short) 467);
		sheet.autoSizeColumn((short) 468);
		sheet.autoSizeColumn((short) 469);
		sheet.autoSizeColumn((short) 470);
		sheet.autoSizeColumn((short) 471);
		sheet.autoSizeColumn((short) 472);
		sheet.autoSizeColumn((short) 473);
		sheet.autoSizeColumn((short) 474);
		sheet.autoSizeColumn((short) 475);
		sheet.autoSizeColumn((short) 476);
		sheet.autoSizeColumn((short) 477);
		sheet.autoSizeColumn((short) 478);
		sheet.autoSizeColumn((short) 479);
		sheet.autoSizeColumn((short) 480);
		sheet.autoSizeColumn((short) 481);
		sheet.autoSizeColumn((short) 482);
		sheet.autoSizeColumn((short) 483);
		sheet.autoSizeColumn((short) 484);
		sheet.autoSizeColumn((short) 485);
		sheet.autoSizeColumn((short) 486);
		sheet.autoSizeColumn((short) 487);
		sheet.autoSizeColumn((short) 488);
		sheet.autoSizeColumn((short) 489);
		sheet.autoSizeColumn((short) 490);
		sheet.autoSizeColumn((short) 491);
		sheet.autoSizeColumn((short) 492);
		sheet.autoSizeColumn((short) 493);
		sheet.autoSizeColumn((short) 494);
		sheet.autoSizeColumn((short) 495);
		sheet.autoSizeColumn((short) 496);
		sheet.autoSizeColumn((short) 497);
		sheet.autoSizeColumn((short) 498);
		sheet.autoSizeColumn((short) 499);
		sheet.autoSizeColumn((short) 500);
		sheet.autoSizeColumn((short) 501);
		sheet.autoSizeColumn((short) 502);
		sheet.autoSizeColumn((short) 503);
		sheet.autoSizeColumn((short) 504);
		sheet.autoSizeColumn((short) 505);
		sheet.autoSizeColumn((short) 506);
		sheet.autoSizeColumn((short) 507);
		sheet.autoSizeColumn((short) 508);
		sheet.autoSizeColumn((short) 509);
		sheet.autoSizeColumn((short) 510);
		sheet.autoSizeColumn((short) 511);
		sheet.autoSizeColumn((short) 512);
		sheet.autoSizeColumn((short) 513);
		sheet.autoSizeColumn((short) 514);
		sheet.autoSizeColumn((short) 515);
		sheet.autoSizeColumn((short) 516);
		sheet.autoSizeColumn((short) 517);
		sheet.autoSizeColumn((short) 518);
		sheet.autoSizeColumn((short) 519);
		sheet.autoSizeColumn((short) 520);
		sheet.autoSizeColumn((short) 521);
		sheet.autoSizeColumn((short) 522);
		sheet.autoSizeColumn((short) 523);
		sheet.autoSizeColumn((short) 524);
		sheet.autoSizeColumn((short) 525);
		sheet.autoSizeColumn((short) 526);
		sheet.autoSizeColumn((short) 527);
		sheet.autoSizeColumn((short) 528);
		sheet.autoSizeColumn((short) 529);
		sheet.autoSizeColumn((short) 530);
		sheet.autoSizeColumn((short) 531);
		sheet.autoSizeColumn((short) 532);
		sheet.autoSizeColumn((short) 533);
		sheet.autoSizeColumn((short) 534);
		sheet.autoSizeColumn((short) 535);
		sheet.autoSizeColumn((short) 536);
		sheet.autoSizeColumn((short) 537);
		sheet.autoSizeColumn((short) 538);
		sheet.autoSizeColumn((short) 539);
		sheet.autoSizeColumn((short) 540);
		sheet.autoSizeColumn((short) 541);
		sheet.autoSizeColumn((short) 542);
		sheet.autoSizeColumn((short) 543);
		sheet.autoSizeColumn((short) 544);
		sheet.autoSizeColumn((short) 545);
		sheet.autoSizeColumn((short) 546);
		sheet.autoSizeColumn((short) 547);
		sheet.autoSizeColumn((short) 548);
		sheet.autoSizeColumn((short) 549);
		sheet.autoSizeColumn((short) 550);
		sheet.autoSizeColumn((short) 551);
		sheet.autoSizeColumn((short) 552);
		sheet.autoSizeColumn((short) 553);
		sheet.autoSizeColumn((short) 554);
		sheet.autoSizeColumn((short) 555);
		sheet.autoSizeColumn((short) 556);
		sheet.autoSizeColumn((short) 557);
		sheet.autoSizeColumn((short) 558);
		sheet.autoSizeColumn((short) 559);
		sheet.autoSizeColumn((short) 560);
		sheet.autoSizeColumn((short) 561);
		sheet.autoSizeColumn((short) 562);
		sheet.autoSizeColumn((short) 563);
		sheet.autoSizeColumn((short) 564);
		sheet.autoSizeColumn((short) 565);
		sheet.autoSizeColumn((short) 566);
		sheet.autoSizeColumn((short) 567);
		sheet.autoSizeColumn((short) 568);
		sheet.autoSizeColumn((short) 569);
		sheet.autoSizeColumn((short) 570);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEha(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-评级信息 ";
		// 标题
		String[] title = new String[] { "序号", "评级信息编号", "评级机构名称", "评级日期", "评级结果" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"_"+"CR_COM_EHA.xlsx";
		/*CrComEha crComEha = new CrComEha();
		crComEha.setId(id);*/
		try {
			List<CrComEha> crComEhaList = BaseDAOUtils.getCrComEhaDAO().findByIdProperties(id);
			createCrComEhaExcel(filepath, sheetName, title, fileName, crComEhaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEhaExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEha> crComEhaList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEhaList.size()][];
		for (int i = 0; i < crComEhaList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEha crComEha = crComEhaList.get(i);
			values[i][0] = String.valueOf(crComEha.getId()) == "null" ? "" : String.valueOf(crComEha.getId());
			values[i][1] = String.valueOf(crComEha.getEh010i01()) == "null" ? ""
					: String.valueOf(crComEha.getEh010i01());
			values[i][2] = String.valueOf(crComEha.getEh010q01()) == "null" ? ""
					: String.valueOf(crComEha.getEh010q01());
			values[i][3] = String.valueOf(crComEha.getEh010r01()) == "null" ? ""
					: String.valueOf(crComEha.getEh010r01());
			values[i][4] = String.valueOf(crComEha.getEh010d01()) == "null" ? ""
					: String.valueOf(crComEha.getEh010d01());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	public void excelCrComEia(String filepath,String id) throws IOException {
		// sheet名
		String sheetName = "征信查询企业征信结果-声明及标注信息  ";
		// 标题
		String[] title = new String[] { "序号", "对象类型", "对象标识", "标注及声明类型", "标注或声明内容", "添加日期" };
		// 文件名
		String currentTime = DataMyUtil.getFullDateTime();
		String fileName = currentTime+"CR_COM_EIA.xlsx";
	/*	CrComEia crComEia = new CrComEia();
		crComEia.setId(id);*/
		
		try {
			List<CrComEia> crComEiaList = BaseDAOUtils.getCrComEiaDAO().findByIdProperties(id);
			createCrComEiaExcel(filepath, sheetName, title, fileName, crComEiaList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createCrComEiaExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEia> crComEiaList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEiaList.size()][];
		for (int i = 0; i < crComEiaList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEia crComEia = crComEiaList.get(i);
			values[i][0] = String.valueOf(crComEia.getId()) == "null" ? "" : String.valueOf(crComEia.getId());
			values[i][1] = String.valueOf(crComEia.getEi010d01()) == "null" ? ""
					: String.valueOf(crComEia.getEi010d01());
			values[i][2] = String.valueOf(crComEia.getEi010i01()) == "null" ? ""
					: String.valueOf(crComEia.getEi010i01());
			values[i][3] = String.valueOf(crComEia.getEi010d02()) == "null" ? ""
					: String.valueOf(crComEia.getEi010d02());
			values[i][4] = String.valueOf(crComEia.getEi010q01()) == "null" ? ""
					: String.valueOf(crComEia.getEi010q01());
			values[i][5] = String.valueOf(crComEia.getEi010r01()) == "null" ? ""
					: String.valueOf(crComEia.getEi010r01());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	/**
	 * 创建EXCEL
	 * 
	 * @param sheetName
	 * @param tirrle
	 * @param tcsUserExportList
	 */
	public void createCrComEa01ChExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEa01ch> crComEa01chList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEa01chList.size()][];
		for (int i = 0; i < crComEa01chList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEa01ch crComEa01ch = crComEa01chList.get(i);
			values[i][0] = String.valueOf(crComEa01ch.getId()) == "null" ? "" : String.valueOf(crComEa01ch.getId());
			values[i][1] = String.valueOf(crComEa01ch.getBatchId()) == "null" ? ""
					: String.valueOf(crComEa01ch.getBatchId());
			values[i][2] = String.valueOf(crComEa01ch.getEa01cd01()) == "null" ? ""
					: String.valueOf(crComEa01ch.getEa01cd01());
			if ("10".equals(values[i][2])) {
				values[i][3] = "10-中征码";
			} else if ("20".equals(values[i][2])) {
				values[i][3] = "20-统一社会信用代码";
			} else if ("30".equals(values[i][2])) {
				values[i][3] = "30-组织机构代码";
			} else if ("01".equals(values[i][2])) {
				values[i][3] = "01-工商注册号";
			} else if ("02".equals(values[i][2])) {
				values[i][3] = "02-机关和事业单位登记号";
			} else if ("03".equals(values[i][2])) {
				values[i][3] = "03-社会团体登记号";
			} else if ("04".equals(values[i][2])) {
				values[i][3] = "04-民办非企业登记号";
			} else if ("05".equals(values[i][2])) {
				values[i][3] = "05-基金会登记号";
			} else if ("06".equals(values[i][2])) {
				values[i][3] = "06-宗教证书登记号";
			} else if ("41".equals(values[i][2])) {
				values[i][3] = "41-纳税人识别号（国税）";
			} else if ("42".equals(values[i][2])) {
				values[i][3] = "42-纳税人识别号（地税）";
			}
			values[i][3] = String.valueOf(crComEa01ch.getEa01ci01()) == "null" ? ""
					: String.valueOf(crComEa01ch.getEa01ci01());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	/**
	 * 创建EXCEL
	 * 
	 * @param sheetName
	 * @param tirrle
	 * @param tcsUserExportList
	 */
	public void createCrComEcaExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEca> crComEcaList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEcaList.size()][];
		for (int i = 0; i < crComEcaList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEca crComEca = crComEcaList.get(i);
			values[i][0] = String.valueOf(crComEca.getId()) == "null" ? "" : String.valueOf(crComEca.getId());
			values[i][1] = String.valueOf(crComEca.getEc010d01()) == "null" ? ""
					: String.valueOf(crComEca.getEc010d01());
			values[i][2] = String.valueOf(crComEca.getEc010d02()) == "null" ? ""
					: String.valueOf(crComEca.getEc010d02());
			values[i][3] = String.valueOf(crComEca.getEc010d03()) == "null" ? ""
					: String.valueOf(crComEca.getEc010d03());
			values[i][4] = String.valueOf(crComEca.getEc010d04()) == "null" ? ""
					: String.valueOf(crComEca.getEc010d04());
			values[i][5] = String.valueOf(crComEca.getEc010q01()) == "null" ? ""
					: String.valueOf(crComEca.getEc010q01());
			values[i][6] = String.valueOf(crComEca.getEc010r01()) == "null" ? ""
					: String.valueOf(crComEca.getEc010r01());
			values[i][7] = String.valueOf(crComEca.getEc010r02()) == "null" ? ""
					: String.valueOf(crComEca.getEc010r02());
			values[i][8] = String.valueOf(crComEca.getEc010q02()) == "null" ? ""
					: String.valueOf(crComEca.getEc010q02());
			values[i][9] = String.valueOf(crComEca.getEc010d05()) == "null" ? ""
					: String.valueOf(crComEca.getEc010d05());
			values[i][10] = String.valueOf(crComEca.getEc020j01()) == "null" ? ""
					: String.valueOf(crComEca.getEc020j01());
			values[i][11] = String.valueOf(crComEca.getEc020s01()) == "null" ? ""
					: String.valueOf(crComEca.getEc020s01());
			values[i][12] = String.valueOf(crComEca.getEc020r01()) == "null" ? ""
					: String.valueOf(crComEca.getEc020r01());
			values[i][13] = String.valueOf(crComEca.getEc030s01()) == "null" ? ""
					: String.valueOf(crComEca.getEc030s01());
			values[i][14] = String.valueOf(crComEca.getEc030r01()) == "null" ? ""
					: String.valueOf(crComEca.getEc030r01());
			values[i][15] = String.valueOf(crComEca.getEc040d01()) == "null" ? ""
					: String.valueOf(crComEca.getEc040d01());
			values[i][16] = String.valueOf(crComEca.getEc040q01()) == "null" ? ""
					: String.valueOf(crComEca.getEc040q01());
			values[i][17] = String.valueOf(crComEca.getEc040d02()) == "null" ? ""
					: String.valueOf(crComEca.getEc040d02());
			values[i][18] = String.valueOf(crComEca.getEc040i01()) == "null" ? ""
					: String.valueOf(crComEca.getEc040i01());
			values[i][19] = String.valueOf(crComEca.getEc040r01()) == "null" ? ""
					: String.valueOf(crComEca.getEc040r01());
			values[i][20] = String.valueOf(crComEca.getEc050s01()) == "null" ? ""
					: String.valueOf(crComEca.getEc050s01());
			values[i][21] = String.valueOf(crComEca.getEc050r01()) == "null" ? ""
					: String.valueOf(crComEca.getEc050r01());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		sheet.autoSizeColumn((short) 19);
		sheet.autoSizeColumn((short) 20);
		sheet.autoSizeColumn((short) 21);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	/**
	 * 创建EXCEL
	 * 
	 * @param sheetName
	 * @param tirrle
	 * @param tcsUserExportList
	 */
	public void createCrComEc02OhExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEc020h> crComEc02OhList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEc02OhList.size()][];
		for (int i = 0; i < crComEc02OhList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEc020h crComEc02Oh = crComEc02OhList.get(i);
			values[i][0] = String.valueOf(crComEc02Oh.getId()) == "null" ? "" : String.valueOf(crComEc02Oh.getId());
			values[i][1] = String.valueOf(crComEc02Oh.getBatchId()) == "null" ? ""
					: String.valueOf(crComEc02Oh.getBatchId());
			values[i][2] = String.valueOf(crComEc02Oh.getEc020d01()) == "null" ? ""
					: String.valueOf(crComEc02Oh.getEc020d01());
			values[i][3] = String.valueOf(crComEc02Oh.getEc020d02()) == "null" ? ""
					: String.valueOf(crComEc02Oh.getEc020d02());
			values[i][4] = String.valueOf(crComEc02Oh.getEc020q01()) == "null" ? ""
					: String.valueOf(crComEc02Oh.getEc020q01());
			values[i][5] = String.valueOf(crComEc02Oh.getEc020d03()) == "null" ? ""
					: String.valueOf(crComEc02Oh.getEc020d03());
			values[i][6] = String.valueOf(crComEc02Oh.getEc020i01()) == "null" ? ""
					: String.valueOf(crComEc02Oh.getEc020i01());
			values[i][7] = String.valueOf(crComEc02Oh.getEc020q02()) == "null" ? ""
					: String.valueOf(crComEc02Oh.getEc020q02());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		sheet.autoSizeColumn((short) 6);
		sheet.autoSizeColumn((short) 7);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	/**
	 * 创建EXCEL
	 * 
	 * @param sheetName
	 * @param tirrle
	 * @param tcsUserExportList
	 */
	public void createCrComEc03OhExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEc030h> crComEc03OhList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEc03OhList.size()][];
		for (int i = 0; i < crComEc03OhList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEc030h crComEc03Oh = crComEc03OhList.get(i);
			values[i][0] = String.valueOf(crComEc03Oh.getId()) == "null" ? "" : String.valueOf(crComEc03Oh.getId());
			values[i][1] = String.valueOf(crComEc03Oh.getBatchId()) == "null" ? ""
					: String.valueOf(crComEc03Oh.getBatchId());
			values[i][2] = String.valueOf(crComEc03Oh.getEc030q01()) == "null" ? ""
					: String.valueOf(crComEc03Oh.getEc030q01());
			values[i][3] = String.valueOf(crComEc03Oh.getEc030d01()) == "null" ? ""
					: String.valueOf(crComEc03Oh.getEc030d01());
			values[i][4] = String.valueOf(crComEc03Oh.getEc030i01()) == "null" ? ""
					: String.valueOf(crComEc03Oh.getEc030i01());
			values[i][5] = String.valueOf(crComEc03Oh.getEc030d02()) == "null" ? ""
					: String.valueOf(crComEc03Oh.getEc030d02());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	/**
	 * 创建EXCEL
	 * 
	 * @param sheetName
	 * @param tirrle
	 * @param tcsUserExportList
	 */
	public void createCrComEc05OhExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEc050h> crComEc05OhList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEc05OhList.size()][];
		for (int i = 0; i < crComEc05OhList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEc050h crComEc05Oh = crComEc05OhList.get(i);
			values[i][0] = String.valueOf(crComEc05Oh.getId()) == "null" ? "" : String.valueOf(crComEc05Oh.getId());
			values[i][1] = String.valueOf(crComEc05Oh.getBatchId()) == "null" ? ""
					: String.valueOf(crComEc05Oh.getBatchId());
			values[i][2] = String.valueOf(crComEc05Oh.getEc050d01()) == "null" ? ""
					: String.valueOf(crComEc05Oh.getEc050d01());
			values[i][3] = String.valueOf(crComEc05Oh.getEc050q01()) == "null" ? ""
					: String.valueOf(crComEc05Oh.getEc050q01());
			values[i][4] = String.valueOf(crComEc05Oh.getEc050d02()) == "null" ? ""
					: String.valueOf(crComEc05Oh.getEc050d02());
			values[i][5] = String.valueOf(crComEc05Oh.getEc050i01()) == "null" ? ""
					: String.valueOf(crComEc05Oh.getEc050i01());
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
		sheet.autoSizeColumn((short) 0);
		sheet.autoSizeColumn((short) 1);
		sheet.autoSizeColumn((short) 2);
		sheet.autoSizeColumn((short) 3);
		sheet.autoSizeColumn((short) 4);
		sheet.autoSizeColumn((short) 5);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	/**
	 * 创建EXCEL
	 * 
	 * @param sheetName
	 * @param tirrle
	 * @param tcsUserExportList
	 */
	public void createCrComEbaExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEba> crComEbaList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEbaList.size()][];
		for (int i = 0; i < crComEbaList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEba crComEba = crComEbaList.get(i);
			values[i][0] = String.valueOf(crComEba.getId()) == "null" ? "" : String.valueOf(crComEba.getId());
			values[i][1] = String.valueOf(crComEba.getEb01ar01()) == "null" ? ""
					: String.valueOf(crComEba.getEb01ar01());
			values[i][2] = String.valueOf(crComEba.getEb01ar02()) == "null" ? ""
					: String.valueOf(crComEba.getEb01ar02());
			values[i][3] = String.valueOf(crComEba.getEb01as01()) == "null" ? ""
					: String.valueOf(crComEba.getEb01as01());
			values[i][4] = String.valueOf(crComEba.getEb01as02()) == "null" ? ""
					: String.valueOf(crComEba.getEb01as02());
			values[i][5] = String.valueOf(crComEba.getEb01aj01()) == "null" ? ""
					: String.valueOf(crComEba.getEb01aj01());
			values[i][6] = String.valueOf(crComEba.getEb01aj02()) == "null" ? ""
					: String.valueOf(crComEba.getEb01aj02());
			values[i][7] = String.valueOf(crComEba.getEb01aj03()) == "null" ? ""
					: String.valueOf(crComEba.getEb01aj03());
			values[i][8] = String.valueOf(crComEba.getEb01aj04()) == "null" ? ""
					: String.valueOf(crComEba.getEb01aj04());
			values[i][9] = String.valueOf(crComEba.getEb01aj05()) == "null" ? ""
					: String.valueOf(crComEba.getEb01aj05());
			values[i][10] = String.valueOf(crComEba.getEb01aj06()) == "null" ? ""
					: String.valueOf(crComEba.getEb01aj06());
			values[i][11] = String.valueOf(crComEba.getEb01aj07()) == "null" ? ""
					: String.valueOf(crComEba.getEb01aj07());
			values[i][12] = String.valueOf(crComEba.getEb01bs01()) == "null" ? ""
					: String.valueOf(crComEba.getEb01bs01());
			values[i][13] = String.valueOf(crComEba.getEb01bs02()) == "null" ? ""
					: String.valueOf(crComEba.getEb01bs02());
			values[i][14] = String.valueOf(crComEba.getEb01bs03()) == "null" ? ""
					: String.valueOf(crComEba.getEb01bs03());
			values[i][15] = String.valueOf(crComEba.getEb01bs04()) == "null" ? ""
					: String.valueOf(crComEba.getEb01bs04());
			values[i][16] = String.valueOf(crComEba.getEb01bs05()) == "null" ? ""
					: String.valueOf(crComEba.getEb01bs05());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}

	/**
	 * 创建EXCEL
	 * 
	 * @param sheetName
	 * @param tirrle
	 * @param tcsUserExportList
	 */
	public void createCrComEbbExcel(String filepath, String sheetName, String title[], String fileName,
			List<CrComEbb> crComEbbList) {
		logger.info("start create excel-->");
		String[][] values = new String[crComEbbList.size()][];
		for (int i = 0; i < crComEbbList.size(); i++) {
			values[i] = new String[title.length];
			// 将对象内容转换成string
			CrComEbb crComEbb = crComEbbList.get(i);
			values[i][0] = String.valueOf(crComEbb.getId()) == "null" ? "" : String.valueOf(crComEbb.getId());
			values[i][1] = String.valueOf(crComEbb.getEb02as01()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02as01());
			values[i][2] = String.valueOf(crComEbb.getEb02aj01()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02aj01());
			values[i][3] = String.valueOf(crComEbb.getEb02ar01()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02ar01());
			values[i][4] = String.valueOf(crComEbb.getEb02as02()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02as02());
			values[i][5] = String.valueOf(crComEbb.getEb02aj02()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02aj02());
			values[i][6] = String.valueOf(crComEbb.getEb02ar02()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02ar02());
			values[i][7] = String.valueOf(crComEbb.getEb02aj03()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02aj03());
			values[i][8] = String.valueOf(crComEbb.getEb02aj04()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02aj04());
			values[i][9] = String.valueOf(crComEbb.getEb02aj05()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02aj05());
			values[i][10] = String.valueOf(crComEbb.getEb02as03()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02as03());
			values[i][11] = String.valueOf(crComEbb.getEb02bs01()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02bs01());
			values[i][12] = String.valueOf(crComEbb.getEb02bj01()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02bj01());
			values[i][13] = String.valueOf(crComEbb.getEb02br01()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02br01());
			values[i][14] = String.valueOf(crComEbb.getEb02br02()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02br02());
			values[i][15] = String.valueOf(crComEbb.getEb02bs02()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02bs02());
			values[i][16] = String.valueOf(crComEbb.getEb02bj02()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02bj02());
			values[i][17] = String.valueOf(crComEbb.getEb02bs03()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02bs03());
			values[i][18] = String.valueOf(crComEbb.getEb02cs01()) == "null" ? ""
					: String.valueOf(crComEbb.getEb02cs01());
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
		sheet.autoSizeColumn((short) 11);
		sheet.autoSizeColumn((short) 12);
		sheet.autoSizeColumn((short) 13);
		sheet.autoSizeColumn((short) 14);
		sheet.autoSizeColumn((short) 15);
		sheet.autoSizeColumn((short) 16);
		sheet.autoSizeColumn((short) 17);
		sheet.autoSizeColumn((short) 18);
		try {
			FileOutputStream os=new FileOutputStream(filepath+"_"+fileName);
			
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("end create excel <--");
	}
    
	
	/**     * 判断文件夹是否存在，如果不存在则新建     *      * @param dirPath 文件夹路径     */    
	private static void isChartPathExist(String dirPath) {        
		File file = new File(dirPath);       
		if (!file.exists()) {           
			file.mkdirs();       
			}    
		}
	
	private static String[]  spritIds(String ids) {
		String[] id= {};
		if(org.apache.commons.lang3.StringUtils.isNotEmpty(ids)) {
			  id = ids.split(",");
		}
		return id;
		
	} 
	
}
