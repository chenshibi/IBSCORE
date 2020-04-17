package com.huateng.report.pboc.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.excel.imp.QueryUntils;
import com.huateng.report.pboc.util.XLSXExcelStyleUtil;

/**
 * @author Grassy
 * @date 2019/2/24 17:12
 * @jdk.version 1.8
 * @desc
 */
public class FileXLSXDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String fileName="";
    	String flag=request.getParameter("flag");
			try {
				  HttpSession httpSession = request.getSession();
			        if (httpSession == null) {
			            throw new ServletException("Security Issue detected!");
			        }
			        GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
			        if (null != globalInfo) {
			            GlobalInfo.setCurrentInstance(globalInfo);
			            String sessionId = httpSession.getId();
			            globalInfo.setSessionId(sessionId);
			        } else {
			            throw new ServletException("User not login!");
			        }
				// GlobalInfo info = GlobalInfo.getCurrentInstance();
				 String trlNo=globalInfo.getTlrno();
//				 String regionNo= QueryUntils.getRegionNo(trlNo); 
				 String time=DateUtil.get8Date(Calendar.getInstance());
				 String batchNo=QueryUntils.getBatchInformation(flag);
				 fileName = time+"_"+batchNo+ ".xlsx";
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        XSSFWorkbook wb = new XSSFWorkbook();
        if("0".equals(flag)) {
        	  XSSFSheet sheet=wb.createSheet("批量个人征信查询");
              sheet.setVerticallyCenter(true);
              //设置表头样式
              XSSFCellStyle cellstyle = (XSSFCellStyle)wb.createCellStyle();
              //设置居中
              cellstyle.setAlignment(HorizontalAlignment.CENTER);
//              XSSFRow row1=sheet.createRow(0);
//              XSSFCell cell=row1.createCell(0);
//              cell.setCellValue("批量个人征信查询一览表");
//              cell.setCellStyle(XLSXExcelStyleUtil.getHeaderStyle(wb));
//              sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
              XSSFRow row2=sheet.createRow(0);
              XSSFCell cell_1=row2.createCell(0);
              cell_1.setCellValue("姓名");
              cell_1.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
              XSSFCell cell_2=row2.createCell(1);
              cell_2.setCellValue("证件类型");
              cell_2.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
              XSSFCell cell_3=row2.createCell(2);
              cell_3.setCellValue("证件号码");
              cell_3.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
              XSSFCell cell_4=row2.createCell(3);
              cell_4.setCellValue("查询原因");
              cell_4.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
              XSSFCell cell_5=row2.createCell(4);
              cell_5.setCellValue("服务代码");
              cell_5.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
              XSSFCell cell_6=row2.createCell(5);
              cell_6.setCellValue("信息记录标识号");
              cell_6.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
        }else {
        	XSSFSheet sheet=wb.createSheet("批量企业征信查询");
        	sheet.setVerticallyCenter(true);
        	//设置表头样式
        	XSSFCellStyle cellstyle = (XSSFCellStyle)wb.createCellStyle();
        	//设置居中
        	cellstyle.setAlignment(HorizontalAlignment.CENTER);
//        	XSSFRow row1=sheet.createRow(0);
//        	XSSFCell cell=row1.createCell(0);
//        	cell.setCellValue("批量企业征信查询一览表");
//        	cell.setCellStyle(XLSXExcelStyleUtil.getHeaderStyle(wb));
//        	sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));
        	XSSFRow row2=sheet.createRow(0);   
        	XSSFCell cell_2=row2.createCell(0);
        	cell_2.setCellValue("企业名称");
        	cell_2.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
        	XSSFCell cell_3=row2.createCell(1);
        	cell_3.setCellValue("企业身份标识类型");
        	cell_3.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
        	XSSFCell cell_4=row2.createCell(2);
        	cell_4.setCellValue("企业身份标识号码");
        	cell_4.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
        	XSSFCell cell_5=row2.createCell(3);
        	cell_5.setCellValue("查询原因");
        	cell_5.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
        	XSSFCell cell_6=row2.createCell(4);
        	cell_6.setCellValue("服务代码");
        	cell_6.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
         	XSSFCell cell_7=row2.createCell(5);
        	cell_7.setCellValue("信息记录标识号");
        	cell_7.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
        }
      
     //   String filename = DateUtil.get14Time() + ".xlsx";
        try {
            OutputStream out = response.getOutputStream();
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-disposition", "attachment;filename="
                    + URLEncoder.encode(fileName, "UTF-8"));
            wb.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
