package com.huateng.msgplatform.job;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.apache.poi.hssf.util.Region;

public class Text {
	public static void main(String[] args) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 创建sheet
		HSSFSheet[] sheet = new HSSFSheet[8];
		// 创建行
		HSSFRow row = null;
		// 创建单元格
		HSSFCell cell = null;
		// 创建一个sheet
		sheet[0] = workbook.createSheet("User Report");
		// 左对齐 0x31 文本格式
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		cellStyle.setDataFormat((short) 0x31);
		// 写入行名称
		String title = "login ID;User name;City;Region;Role;department;Lock or Unlock;Time of last update;Time of last login;creation time;Personal bureau enquiry;Corp bureau enquiry;User status";
		String titleList[] = title.split(";");
		String time = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		setRegionStyle(sheet[0], new Region(0,(short)0,0,(short)12),cellStyle);
		sheet[0].addMergedRegion(new Region(0,(short)0,0,(short)12));
		// 设置字体   
		HSSFFont headfont = workbook.createFont();   
		headfont.setFontName("Arial");   
		headfont.setFontHeightInPoints((short) 22);// 字体大小   
		headfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 加粗   
		HSSFCellStyle headstyle  = workbook.createCellStyle();
		
		HSSFFont columnHeadFont = workbook.createFont();   
		columnHeadFont.setFontName("Arial");   
		columnHeadFont.setFontHeightInPoints((short) 10);   
		HSSFRichTextString ts= new HSSFRichTextString("IBS        " + time + "   Page:1");
		ts.applyFont(0,3,headfont);
		ts.applyFont(3,ts.length(),columnHeadFont);

		headstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中   
		headstyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中   
		headstyle.setDataFormat((short) 0x31);
		row = sheet[0].createRow(0);
		cell = row.createCell(0);
		cell.setCellStyle(headstyle);
		cell.setCellValue(ts);

		row = sheet[0].createRow(1);
		row.setHeight((short) 300);
		for (int i = 0; i < titleList.length; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(titleList[i]);
			sheet[0].autoSizeColumn(i, true);
		}
		
		
		String filepath = "F:\\text\\";
		
		String destFileName = filepath + "Daily_User_Ind_Enquiry_Report_" + "111" + ".xls";
		
		FileOutputStream output;
		try {
			output = new FileOutputStream(destFileName);
			workbook.write(output);
			output.flush();
			output.close();
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@SuppressWarnings("deprecation")
	public static void setRegionStyle(HSSFSheet sheet, Region region, HSSFCellStyle cs) {

		for (int i = region.getRowFrom(); i <= region.getRowTo(); i++) {
			HSSFRow row = HSSFCellUtil.getRow(i, sheet);
			for (int j = region.getColumnFrom(); j <= region.getColumnTo(); j++) {
				HSSFCell cell = HSSFCellUtil.getCell(row, (short) j);
				cell.setCellStyle(cs);
			}
		}
	}
}
