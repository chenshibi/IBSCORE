package com.huateng.ebank.business.customer.operation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.struts.upload.FormFile;

import resource.bean.basic.IndApp;
import resource.bean.basic.IndPermit;

import com.huateng.common.DateUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;


/**
 * 
 * Filename:LoanersMaintainInfoOperation.java Description:批量个人征信报告查询请求
 * Copyright:Copyright (c)2012 Company: HuaTeng
 */
public class IndAppUploadOperation extends BaseOperation {
    private static final HtLog htlog = HtLogFactory.getLogger(IndAppUploadOperation.class);
    public static final String ID = "customer.IndAppUploadOperation";
    public static final String CMD = "CMD";
	public static final Object CMD_TYPE_EXEC_EXCEl = "CMD_TYPE_EXEC_EXCEl";
	public static final String IN_ORDER_EXCEL_FORMFILE = "IN_ORDER_EXCEL_FORMFILE";
	private static final String tableNm = "IND_APP";// 临时间交换表
	private static final int txtWriteRow = 500;// 每500条写入一次文件
	private static final String txtSplit = ",";// 文本文件内容分隔符号
    @Override
    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    @SuppressWarnings({ "unchecked", "unused" })
    @Override
    public void execute(OperationContext context) throws CommonException {
        String cmd = (String) context.getAttribute(CMD);
        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
        FormFile excelFile = (FormFile)context.getAttribute(IN_ORDER_EXCEL_FORMFILE);
        BusinessUploadService service=new   BusinessUploadService();
		InputStream in = null;
		Workbook book = null;
		htlog.info("解析EXCEl：" + excelFile.getFileName());
		List<String> insertSqlList = new ArrayList<String>();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		try {
			in = excelFile.getInputStream();
			book = Workbook.getWorkbook(in);
			Sheet sheet = book.getSheet(0);
			int rownum = sheet.getRows();// 行数
			int columnum = sheet.getColumns(); // 得到列数
			Cell[] titleRow = sheet.getRow(0);
			Map<Integer, String> titleMap = new HashMap<Integer, String>();
			for (int i = 0; i < titleRow.length; i++) {
				titleMap.put(i, titleRow[i].getContents().trim().toString());
			}
			for (int i = 1; i < rownum; i++) {// 从第二行开始
				StringBuffer insertSql = new StringBuffer();
				StringBuffer insertSqlValue = new StringBuffer();
				for (int j = 0; j < columnum; j++) {
					Cell cell = sheet.getCell(j, i);
					String result = cell.getContents();
					String titNm = titleMap.get(j);
					String customerAttribute = sheet.getCell(8, i).getContents();
					if (cell != null) {
						if(j==5){
							insertSqlValue.append("'").append(DateUtil.get8Date()).append("'");
							insertSqlValue.append(",") ; 
						}else {
							insertSqlValue.append("'").append(result.trim()).append("'");
							insertSqlValue.append(",") ; 
						}
						
					}else{
						htlog.info(titNm + "列(第" + i + "行,值=" + result + ")无法写入数据库，找不到对应数据库配置!");
					}
				}
				insertSql.append("insert into ");
				insertSql.append(tableNm);
				insertSql.append("(name,id_type,individual_id,query_reason,query_type,input_time,type,status,customer_attribute)");
				insertSql.append(" Values(");
				insertSql.append(insertSqlValue.deleteCharAt(insertSqlValue.length()-1));
				insertSql.append(")");
				
				List<IndApp> listApp=service.queryIndApp(excelFile);
				if(null != listApp && listApp.size()>0){
					Calendar calendar=Calendar.getInstance();
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
					calendar.add(calendar.DATE, -30);
					String expireDate=sdf.format(calendar.getTime());
					for (IndApp indApp : listApp) {
							String inputTime=indApp.getInputTime().toString();
						if(inputTime.contains("-")){
							inputTime=inputTime.replaceAll("-", "");
							calendar.setTime(sdf.parse(inputTime));
						}
							if(Long.valueOf(inputTime)<Long.valueOf(expireDate)){
								// 写入数据库
								rootdao.executeSql(insertSql.toString());
								System.out.println("第" + i + "行=" + insertSql.toString());
							}
					}
				}else{
					// 写入数据库
					rootdao.executeSql(insertSql.toString());
					System.out.println("第" + i + "行=" + insertSql.toString());
				}
			}
		} catch (Exception e) {
			  ExceptionUtil.throwCommonException("执行EXCEL解析并写入数据库失败！");
		} finally {
			if (book != null) {
				book.close();
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (excelFile != null) {
				excelFile.destroy();
			}
		}
    }
                
       
//    private void saveLog(String bussiness) throws CommonException {
//        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
//        globalInfo.addBizLog("Updater.log",
//                new String[] { globalInfo.getTlrno(),  "消息平台-->接收用户组维护-->" + bussiness });
//        htlog.info("Updater.log",
//                new String[] { globalInfo.getTlrno(), "消息平台-->接收用户组维护-->" + bussiness });
//    }

    @Override
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
    }
}
