package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class TestDemo {
	public static void genSheetHead(Sheet sheet,int rowNum,Map<Integer,Object> values){
		Row row = sheet.createRow(rowNum);
		for(Integer cellNum:values.keySet()){
			Cell cell = row.createCell(cellNum);
			Object value = values.get(cellNum);
			generateValue(value,cell);
		}
	}
	
	public static void createCell(Row row,int cellNum,Object value){
		Cell cell = row.createCell(cellNum);
		generateValue(value,cell);
	}
	
	public static void generateValue(Object value,Cell cell){
		if(value instanceof String){
			cell.setCellValue((String) value);
		}else if(value instanceof Boolean){
			cell.setCellValue((Boolean) value);
		}else if(value instanceof Double){
			cell.setCellValue((Double) value);
		}else if(value instanceof Date){
			cell.setCellValue((Date) value);
		}else if(value instanceof Calendar){
			cell.setCellValue((Calendar) value);
		}else if(value instanceof RichTextString){
			cell.setCellValue((RichTextString) value);
		}
	}
	
	public static void main(String[] args)throws Exception{
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
		SXSSFWorkbook workbook = new SXSSFWorkbook(xssfWorkbook,1000);
		long start = System.currentTimeMillis();
		Date dateStart= new Date();
		
		File file = new File("F:/user2.xlsx");
			Sheet sheet = workbook.getSheet("sheet");
			if(sheet==null){
				sheet = workbook.createSheet("sheet");
			}
			Map<Integer,Object> firstTitles=new HashMap<Integer,Object>();
			firstTitles.put(0, "部门");
			firstTitles.put(1, "test1221");
			firstTitles.put(7, "时间");
			firstTitles.put(8, "2017-09-11");
			genSheetHead(sheet,0,firstTitles);
			
			
			for(int rownum=1;rownum<1048574;rownum++){
				Row row = sheet.createRow(rownum);
				int k=-1;
				createCell(row,++k,"第"+rownum+"行");
				createCell(row,++k,"第"+rownum+"行");
				createCell(row,++k,"第"+rownum+"行");
				createCell(row,++k,"第"+rownum+"行");
				createCell(row,++k,"第"+rownum+"行");
				createCell(row,++k,"第"+rownum+"行");
				createCell(row,++k,"第"+rownum+"行");
				createCell(row,++k,"第"+rownum+"行");
				System.out.println("第"+rownum+"行");
				
			}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		Date dateStop= new Date();
		System.out.println("开始时间："+dateStart);
		System.out.println("结束时间："+dateStop);
		System.out.println("用时："+(System.currentTimeMillis()-start));
		out.close();
	}
}
