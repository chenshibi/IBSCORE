/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.htaml.reportForm.util;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.apache.poi.hssf.util.Region;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.WebDownloadFile;
import com.huateng.ebank.framework.web.struts.BaseAction;
import com.huateng.msgplatform.service.DataMapService;
import com.huateng.report.utils.HuaTengUtils;
import com.huateng.report.utils.ReportUtils;

import resource.bean.basic.RoleInfo;
import resource.bean.basic.TlrInfoChange;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.1 $
 * @date 2005-8-5
 * 
 *       下载文件的Action.
 */
public class AuditTrialReportDownloadAction extends BaseAction {
	private static final Log log = LogFactory
			.getLog(AuditTrialReportDownloadAction.class);
	private Map mrole = null;
	private Map mcity = null;
	private Map mregion = null;
	private Map mdepartMent = null;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Connection conn = null;
		java.sql.PreparedStatement statement = null;
		java.sql.ResultSet rs = null;
		try {
			mrole = getRoleByNo();
			mcity = DataMapService.getNameByNo(503);
			mregion = DataMapService.getNameByNo(502);
			mdepartMent = DataMapService.getNameByNo(501);
			this.init(request);

			String reportDate = request.getParameter("reportDate");
			log.info(reportDate);

			// 生成reportDate当月报表
			Create_Sheet(reportDate);
			
			String fileToBeDownload = null;
			String filename = "AuditTrialReport" + reportDate + ".xls";
			String Download_Path = ReportUtils.getSysParamsValue("AuditTrial",
					"AuditTrial");
			filename=HuaTengUtils.toStringAndTrim(filename);
			fileToBeDownload = Download_Path + filename;
			 File file=new File(fileToBeDownload);
			WebDownloadFile.downloadFile(response, file, file.getName());
			
		} catch (CommonException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void Create_Sheet(String Query_time) {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		try {
			String sql = " select * from TLR_INFO_CHANGE where LAST_UPD_TMS like '"
					+ Query_time + "%' order by id";
			Iterator it = rootdao.queryBySQL2(sql.toString());
			if (it == null) {
				return;
			}
			// 创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 创建行
			HSSFRow row = null;
			// 创建单元格
			HSSFCell cell = null;
			// 创建一个sheet
			HSSFSheet sheet = workbook.createSheet("Audit Trial Report");
			// 左对齐 0x31 文本格式
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyle.setDataFormat((short) 0x31);

			
			String title = "No;Action Date/Time;Modified User;Action Type;Operator;Action Details";
			String titleList[] = title.split(";");
			
			String time = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
			setRegionStyle(sheet, new Region(0,(short)0,0,(short)5),cellStyle);
			sheet.addMergedRegion(new Region(0,(short)0,0,(short)5));
			// 设置字体   
			HSSFFont headfont = workbook.createFont();   
			headfont.setFontName("Arial");   
			headfont.setFontHeightInPoints((short) 22);// 字体大小   
			headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗   
			HSSFCellStyle headstyle  = workbook.createCellStyle();
			
			HSSFFont columnHeadFont = workbook.createFont();   
			columnHeadFont.setFontName("Arial");   
			columnHeadFont.setFontHeightInPoints((short) 10);   
			GlobalInfo globalinfo = GlobalInfo.getCurrentInstance();  
			
			HSSFRichTextString ts= new HSSFRichTextString("IBS         Generate by " + globalinfo.getTlrno() + " Date:" + time + "   Page:1");
			ts.applyFont(0,3,headfont);
			ts.applyFont(3,ts.length(),columnHeadFont);

			headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中   
			headstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中   
			headstyle.setDataFormat((short) 0x31);
			row = sheet.createRow(0);
			cell = row.createCell(0);
			cell.setCellStyle(headstyle);
			cell.setCellValue(ts);

			row = sheet.createRow(1);
			row.setHeight((short) 300);
			
			for (int i = 0; i < titleList.length; i++) {
				cell = row.createCell(i);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(titleList[i]);
				sheet.autoSizeColumn(i, true);
			}
			int i = 2;
			while (it.hasNext()) {
				Map map = (Map) it.next();
				String tlrno = transfer_toString(map.get("TLRNO"));
				String LAST_UPD_OPER = transfer_toString(map
						.get("LAST_UPD_OPER"));
				String OPER_STATUS = transfer_toString(map.get("OPER_STATUS"));

				String operStatus = null;
				String actionDetails = null;
				if(OPER_STATUS.equals("0")){
					operStatus = "Add";
					actionDetails = getAddAction(map);
				}else if(OPER_STATUS.equals("1")){
					operStatus = "Change";
					actionDetails = getChangeAction(map);
				}else if(OPER_STATUS.equals("2")){
					operStatus = "Deletion";
					actionDetails = "Delete ID [" + tlrno + "]";
				}
				
				String LAST_UPD_TMS = transfer_toString(map.get("LAST_UPD_TMS"));
				String lastupdtime = LAST_UPD_TMS.substring(0,4) + "/" + LAST_UPD_TMS.substring(4,6) + "/" + LAST_UPD_TMS.substring(6,8) + " " +
						LAST_UPD_TMS.substring(8,10) + ":" + LAST_UPD_TMS.substring(10,12) + ":" + LAST_UPD_TMS.substring(12,14);
				row = sheet.createRow(i);
				row.setHeight((short) 300);
				// no
				Create_Style_Value(0, cellStyle, i-1+"", row, cell);
				// Action Date/Time
				Create_Style_Value(1, cellStyle, lastupdtime, row, cell);
				// Modified User
				Create_Style_Value(2, cellStyle, tlrno, row, cell);
				// Action Type
				Create_Style_Value(3, cellStyle, operStatus, row, cell);
				// By Admin User
				Create_Style_Value(4, cellStyle, LAST_UPD_OPER, row, cell);
				// Action Details
				Create_Style_Value(5, cellStyle, actionDetails, row, cell);

				i++;
			}
			sheet.setColumnWidth(0, 250 * 10);
			sheet.setColumnWidth(1, 250 * 25);
			sheet.setColumnWidth(2, 250 * 15);
			sheet.setColumnWidth(3, 250 * 15);
			sheet.setColumnWidth(4, 250 * 15);
			sheet.setColumnWidth(5, 250 * 40);

			String fileToBeDownload = null;
			String filename = "AuditTrialReport" + Query_time + ".xls";
			String Download_Path = ReportUtils.getSysParamsValue("AuditTrial",
					"AuditTrial");
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String getAddAction(Map map) throws CommonException {
		String tlrno = transfer_toString(map.get("TLRNO"));
		String City = checkNull(mcity,transfer_toString(map.get("CITY")));
		String Region = checkNull(mregion,transfer_toString(map.get("REGION")));
		String Department = checkNull(mdepartMent,transfer_toString(map.get("DEPARTMENT")));
		String Role = getRoleString(transfer_toString(map.get("id")));
		String action = "Added ID [" + tlrno + "]" 
		+ "\nCity:" + City
		+ "\nRegion:" + Region
		+ "\nDepartment:" + Department
		+ "\nRole:" + Role;
		return action;
	}
	
	private String getChangeAction(Map map) throws CommonException {
		String id = transfer_toString(map.get("id"));
		String tlrno = transfer_toString(map.get("TLRNO"));
		String toCity = checkNull(mcity,transfer_toString(map.get("CITY")));
		String toRegion = checkNull(mregion,transfer_toString(map.get("REGION")));
		String toDepartment = checkNull(mdepartMent,transfer_toString(map.get("DEPARTMENT")));
		String toRole = getRoleString(id);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        StringBuffer hql =  new StringBuffer("select ri from TlrInfoChange ri" +
        									 " where ri.tlrno = '" + tlrno+ "' " +
        									   " and id < '"+id+"' " +
        									 " order by id desc ");
	  	List<TlrInfoChange> list = rootdao.queryByCondition(hql.toString());
	  	 String City = "--";
	  	 String Region = "--";
	  	 String Department = "--";
	  	 String Role = "--";
	  	if(list.size() == 0){
	  		;
	  	}else{
	  		 TlrInfoChange tlrInfoChange=list.get(0);
		     City = checkNull(mcity,transfer_toString(tlrInfoChange.getCity()));
		     Region = checkNull(mregion,transfer_toString(tlrInfoChange.getRegion()));
		     Department = checkNull(mdepartMent,transfer_toString(tlrInfoChange.getDepartment()));
		     Role = getRoleString(tlrInfoChange.getId().toString());
	  	}
	  
		String action = "Change ID [" + tlrno + "] from ["
				+ "\nCity:" + City
				+ "\nRegion:" + Region
				+ "\nDepartment:" + Department
				+ "\nRole:" + Role +"]"
				+ "\nto"
				+ "\n[City:" + toCity
				+ "\nRegion:" + toRegion
				+ "\nDepartment:" + toDepartment
				+ "\nRole:" + toRole +"]";
		return action;
	}

	private String getRoleString(String id) throws CommonException {
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String sql = " select * from TLR_ROLE_REL_CHANGE where CHANGE_ID = '"+ id + "' order by id";
		Iterator it = rootdao.queryBySQL2(sql.toString());
		String roleAll = null;
		while (it.hasNext()) {
			Map map = (Map) it.next();
			String role = checkNull(mrole,transfer_toString(map.get("role_id")));
			if(null == roleAll){
				roleAll = role;
			}else{
				roleAll = roleAll + ","+ role;
			}
		}
		return roleAll;
	}

	private void setResponse(HttpServletRequest request,
			HttpServletResponse response, String fileName) {
		// TODO Auto-generated method stub
		try {
			response.reset();
			String finalFileName;
			String userAgent = request.getHeader("USER-AGENT");
			if (StringUtils.contains(userAgent, "MSIE")) {// IE浏览器
				finalFileName = URLEncoder.encode(fileName, "UTF8");
			} else if (StringUtils.contains(userAgent, "Mozilla")) {// google,火狐浏览器
				finalFileName = new String(fileName.getBytes(), "ISO8859-1");
			} else {
				finalFileName = URLEncoder.encode(fileName, "UTF8");// 其他浏览器
			}
			String contentType = "application/octet-stream;charset=utf-8";
			// String headerValue = "attachment;   filename=" + fileName;
			response.setContentType(contentType);
			response.setHeader("Content-Disposition", "attachment;filename="
					+ finalFileName);
			// response.setHeader("Content-Disposition", headerValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

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
	public String checkNull(Map p, String t) {
		if (t == null) {
			return "";
		} else {
			return (String) p.get(t.trim());
		}
	}
	private void setRegionStyle(HSSFSheet sheet, Region region, HSSFCellStyle cs) {

		for (int i = region.getRowFrom(); i <= region.getRowTo(); i++) {
			HSSFRow row = HSSFCellUtil.getRow(i, sheet);
			for (int j = region.getColumnFrom(); j <= region.getColumnTo(); j++) {
				HSSFCell cell = HSSFCellUtil.getCell(row, (short) j);
				cell.setCellStyle(cs);
			}
		}
	}
	
	private  Map<String, String> getRoleByNo() throws CommonException{
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        StringBuffer hql =  new StringBuffer("select ri from RoleInfo ri ");
	  	List<RoleInfo> list = rootdao.queryByCondition(hql.toString());
	    Map<String, String> m=new HashMap<String, String>();
	    if(list !=null && list.size()>0){
	    	for(int i=0;i<list.size();i++){
	    		RoleInfo roleInfo=list.get(i);
	    		m.put(roleInfo.getId(), roleInfo.getRoleName());
	    	}
	    }
		return m;
	}
}
