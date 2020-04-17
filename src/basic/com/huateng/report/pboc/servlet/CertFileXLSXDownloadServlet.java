package com.huateng.report.pboc.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

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
import com.huateng.report.pboc.util.XLSXExcelStyleUtil;
/**
 * 
 * @author Grassy
 *
 */
public class CertFileXLSXDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	String fileName="";
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
				 fileName ="授权书下载.xlsx";
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        XSSFWorkbook wb = new XSSFWorkbook();
        	  XSSFSheet sheet=wb.createSheet("查询授权书");
              sheet.setVerticallyCenter(true);
              //设置表头样式
              XSSFCellStyle cellstyle = (XSSFCellStyle)wb.createCellStyle();
              //设置居中
              cellstyle.setAlignment(HorizontalAlignment.CENTER);
              XSSFRow row2=sheet.createRow(0);
              XSSFCell cell_1=row2.createCell(0);
              cell_1.setCellValue("用户姓名");
              cell_1.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
              XSSFCell cell_2=row2.createCell(1);
              cell_2.setCellValue("中征码");
              cell_2.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
              XSSFCell cell_3=row2.createCell(2);
              cell_3.setCellValue("Client_LEID");
              cell_3.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
              XSSFCell cell_4=row2.createCell(3);
              cell_4.setCellValue("客户姓名");
              cell_4.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
              XSSFCell cell_5=row2.createCell(4);
              cell_5.setCellValue("更新时间");
              cell_5.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
              XSSFCell cell_6=row2.createCell(5);
              cell_6.setCellValue("有效期时间");
              cell_6.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
              XSSFCell cell_7=row2.createCell(6);
              cell_7.setCellValue("状态");
              cell_7.setCellStyle(XLSXExcelStyleUtil.getFontCellStyle(wb));
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
