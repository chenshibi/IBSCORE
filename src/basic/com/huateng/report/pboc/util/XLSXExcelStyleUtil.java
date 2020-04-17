package com.huateng.report.pboc.util;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Grassy
 * @date 2019/2/27 15:29
 * @jdk.version 1.8
 * @desc
 */
public class XLSXExcelStyleUtil {
    /**
     *  标题样式
      * @param wb
     * @return
     */
    public static XSSFCellStyle getHeaderStyle(XSSFWorkbook wb ){
        //创建标题样式
        XSSFCellStyle headerStyle = (XSSFCellStyle)wb.createCellStyle();
        //设置水平居中
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        //创建字体样式
        XSSFFont headerFont = (XSSFFont)wb.createFont();
        // 设置背景色
        headerStyle.setFillForegroundColor((short) 13);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //字体加粗
        headerFont.setBold(true);
        //设置字体类型
        headerFont.setFontName("Times New Roman");
        //设置字体大小
        headerFont.setFontHeightInPoints((short) 8);
        //为标题样式设置字体样式
        headerStyle.setFont(headerFont);
        return  headerStyle;
    }

    /**
     * 创建标题样式
     * @param wb
     * @return
     */
    public static XSSFCellStyle getHeaderStyle_1(XSSFWorkbook wb){
        XSSFCellStyle headerStyle2 = (XSSFCellStyle)wb.createCellStyle();// 创建标题样式2
        headerStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle2.setAlignment(HorizontalAlignment.CENTER);
        XSSFFont headerFont2 = (XSSFFont)wb.createFont();
        headerFont2.setBold(true);// 字体加粗
        headerFont2.setFontName("宋体");
        headerFont2.setFontHeightInPoints((short) 8);
        headerStyle2.setFont(headerFont2);
        headerStyle2.setBorderBottom(BorderStyle.THIN); // 下边框
        headerStyle2.setBorderLeft(BorderStyle.THIN);// 左边框
        headerStyle2.setBorderTop(BorderStyle.THIN);// 上边框
        headerStyle2.setBorderRight(BorderStyle.THIN);// 右边框
        return  headerStyle2;
    }

    /**
     * 设置字体样式
     * @param wb
     * @return
     */
    public static XSSFCellStyle getFontCellStyle(XSSFWorkbook wb){
        XSSFCellStyle fontCellStyle = (XSSFCellStyle)wb.createCellStyle();
        fontCellStyle.setAlignment(HorizontalAlignment.CENTER);
        fontCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);// 垂直对齐居中
        fontCellStyle.setWrapText(true); // 设置为自动换行
        XSSFFont cell_Font = (XSSFFont)wb.createFont();
        cell_Font.setFontName("宋体");
     //   cell_Font.setBold(true);
        cell_Font.setFontHeightInPoints((short) 8);
        fontCellStyle.setFont(cell_Font);
        fontCellStyle.setBorderBottom(BorderStyle.THIN); // 下边框
        fontCellStyle.setBorderLeft(BorderStyle.THIN);// 左边框
        fontCellStyle.setBorderTop(BorderStyle.THIN);// 上边框
        fontCellStyle.setBorderRight(BorderStyle.THIN);// 右边框
        return fontCellStyle;
    }




}
