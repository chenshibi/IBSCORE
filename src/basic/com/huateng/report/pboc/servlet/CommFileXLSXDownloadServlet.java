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

import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.excel.imp.QueryUntils;
import com.huateng.report.pboc.util.XLSXExcelStyleUtil;
import com.huateng.report.utils.ReportUtils;

/**
 * @author Grassy
 * @date 2019/2/24 17:12
 * @jdk.version 1.8
 * @desc
 */
public class CommFileXLSXDownloadServlet extends HttpServlet {
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
				 String batchNo=QueryUntils.getInformation(flag);
				 fileName = time+"_"+batchNo+ ".xlsx";
			} catch (Exception e1) {
				e1.printStackTrace();
			}
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFCellStyle fontCellStyle = XLSXExcelStyleUtil.getFontCellStyle(wb);
		if("0".equals(flag)) {
        	  XSSFSheet sheet=wb.createSheet("批量个人征信查询");
        	  DataValidationHelper helper = sheet.getDataValidationHelper();   
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
              cell_1.setCellStyle(fontCellStyle);
              XSSFCell cell_2=row2.createCell(1);
              cell_2.setCellValue("证件类型");
              cell_2.setCellStyle(fontCellStyle);
              CellRangeAddressList regions = new CellRangeAddressList(1,10000,1,1);
             //生成下拉框内容
              String idTypeList[]=ReportUtils.transferArrayParam("IDTYPE", "PER");
            /*  String idTypeList[]= {"1-户口薄","2-护照","5-港澳居民来往内地通行证","6-台湾同胞来往内地通行证","8-外国人居留证","9-警官证","A-香港身份证","B-澳门身份证","C-台湾身份证",
            		                "X-其他证件","10-身份证","20-军人身份证件"};*/
              String queryReason[]=ReportUtils.transferArrayParam("QREASON", "PER");
          //    String queryReason[]= {"01-贷后管理","02-贷款审批","03-信用卡审批","08-担保资格审查","19-特约商户实名审查","22-法人代表、负责人、高管等资信审查","23-客户准入资格审查","25-资信审查"};
              String serviceCode[]= {"FW_GRXYBG_0074","FW_GRXYBG_0100"};
              DataValidationConstraint constraint = helper.createExplicitListConstraint(idTypeList);
              DataValidationConstraint queryReasonC = helper.createExplicitListConstraint(queryReason);
              DataValidationConstraint serviceCodeC = helper.createExplicitListConstraint(serviceCode);
              DataValidation dataValidation = helper.createValidation(constraint, regions);
          //    CTDataValidation constraint = (CTDataValidation) DVConstraint.createExplicitListConstraint(idTypeList);
            //绑定下拉框和作用区域
            //  XSSFDataValidation data_validation = new  XSSFDataValidation(regions,constraint);
              
            //处理Excel兼容性问题  
              if(dataValidation instanceof XSSFDataValidation) {  
                  dataValidation.setSuppressDropDownArrow(true);  
                  dataValidation.setShowErrorBox(true);  
              }else {  
                  dataValidation.setSuppressDropDownArrow(false);  
              }  
              sheet.addValidationData(dataValidation);
              XSSFCell cell_3=row2.createCell(2);
              cell_3.setCellValue("证件号码");
              XSSFDataFormat format  = wb.createDataFormat();
              XSSFCellStyle fontCellStyle2= XLSXExcelStyleUtil.getFontCellStyle(wb);
              fontCellStyle2.setDataFormat(format.getFormat("@"));
              cell_3.setCellStyle(fontCellStyle2);
              sheet.setDefaultColumnStyle(2,fontCellStyle2);
              XSSFCell cell_4=row2.createCell(3);
              cell_4.setCellValue("查询原因");
              cell_4.setCellStyle(fontCellStyle);
              CellRangeAddressList regions_1 = new CellRangeAddressList(1,10000,3,3);
              DataValidation dataValidation_1 = helper.createValidation(queryReasonC, regions_1);
              //处理Excel兼容性问题  
              if(dataValidation_1 instanceof XSSFDataValidation) {  
            	  dataValidation_1.setSuppressDropDownArrow(true);  
            	  dataValidation_1.setShowErrorBox(true);  
              }else {  
            	  dataValidation_1.setSuppressDropDownArrow(false);  
              }  
              sheet.addValidationData(dataValidation_1); 
              XSSFCell cell_5=row2.createCell(4);
              cell_5.setCellValue("服务代码");
              cell_5.setCellStyle(fontCellStyle);
              CellRangeAddressList regions_2 = new CellRangeAddressList(1,10000,4,4);
              DataValidation dataValidation_2 = helper.createValidation(serviceCodeC, regions_2);
              XSSFCell cell_6=row2.createCell(5);
            //处理Excel兼容性问题  
              if(dataValidation_2 instanceof XSSFDataValidation) {  
            	  dataValidation_2.setSuppressDropDownArrow(true);  
            	  dataValidation_2.setShowErrorBox(true);  
              }else {  
            	  dataValidation_2.setSuppressDropDownArrow(false);  
              } 
              sheet.addValidationData(dataValidation_2); 
        }else {
        	XSSFSheet sheet=wb.createSheet("批量企业征信查询");
        	 DataValidationHelper helper = sheet.getDataValidationHelper();
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
        	cell_2.setCellStyle(fontCellStyle);
        	XSSFCell cell_3=row2.createCell(1);
        	String entCertType[]=ReportUtils.transferArrayParam("IDTYPE", "ENT");
      /*  	String entCertType[]= {"10-中征码 ","20-统一社会信用代码","30-组织机构代码","01-工商注册号","02-机关和事业单位登记号 ","03-社会团体登记号","04-民办非企业登记号 ","05-基金会登记号 ",
        			"06-宗教证书登记号 ","41-纳税人识别号（国税）","42-纳税人识别号（地税）","11-机构信用代码"};*/
        //	String queryReason[]= {"01-贷前(保前)审查","02-贷中操作","03-贷后(在保)管理","04-其他原因","05-关联查询","17-额度审批","18-担保审查"};
        	String queryReason[]=ReportUtils.transferArrayParam("QREASON", "ENT");
        	String serviceCode[]= {"FW_QYXYBG_0043"};
        	cell_3.setCellValue("企业身份标识类型");
        	cell_3.setCellStyle(fontCellStyle);
        	CellRangeAddressList regions = new CellRangeAddressList(1,10000,1,1);
        	XSSFCell cell_4=row2.createCell(2);
        	cell_4.setCellValue("企业身份标识号码");
       	    XSSFDataFormat format  = wb.createDataFormat();
            XSSFCellStyle fontCellStyle2= XLSXExcelStyleUtil.getFontCellStyle(wb);
            fontCellStyle2.setDataFormat(format.getFormat("@"));
            cell_4.setCellStyle(fontCellStyle2);
            sheet.setDefaultColumnStyle(2,fontCellStyle2);
        	cell_4.setCellStyle(fontCellStyle);
        	XSSFCell cell_5=row2.createCell(3);
        	cell_5.setCellValue("查询原因");
        	cell_5.setCellStyle(fontCellStyle);
        	XSSFCell cell_6=row2.createCell(4);
        	CellRangeAddressList regions_1 = new CellRangeAddressList(1,10000,3,3);
        	cell_6.setCellValue("服务代码");
        	cell_6.setCellStyle(fontCellStyle);
         	XSSFCell cell_7=row2.createCell(5);
           DataValidationConstraint constraint = helper.createExplicitListConstraint(entCertType);
           DataValidationConstraint queryReasonC = helper.createExplicitListConstraint(queryReason);
           DataValidationConstraint serviceCodeC = helper.createExplicitListConstraint(serviceCode);
           DataValidation dataValidation = helper.createValidation(constraint, regions);
           DataValidation dataValidation_1 = helper.createValidation(queryReasonC, regions_1);
           CellRangeAddressList regions_2 = new CellRangeAddressList(1,10000,4,4);
           DataValidation dataValidation_2 = helper.createValidation(serviceCodeC, regions_2);
           //处理Excel兼容性问题  
           if(dataValidation instanceof XSSFDataValidation) {  
               dataValidation.setSuppressDropDownArrow(true);  
               dataValidation.setShowErrorBox(true);  
           }else {  
               dataValidation.setSuppressDropDownArrow(false);  
           }  
           sheet.addValidationData(dataValidation);
           sheet.addValidationData(dataValidation_1); 
           //处理Excel兼容性问题  
           if(dataValidation_1 instanceof XSSFDataValidation) {  
         	  dataValidation_1.setSuppressDropDownArrow(true);  
         	  dataValidation_1.setShowErrorBox(true);  
           }else {  
         	  dataValidation_1.setSuppressDropDownArrow(false);  
           } 
           //处理Excel兼容性问题  
           if(dataValidation_2 instanceof XSSFDataValidation) {  
         	  dataValidation_2.setSuppressDropDownArrow(true);  
         	  dataValidation_2.setShowErrorBox(true);  
           }else {  
         	  dataValidation_2.setSuppressDropDownArrow(false);  
           } 
           sheet.addValidationData(dataValidation_2); 
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
