package com.huateng.msgplatform.service;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;



import nochump.util.extend.ZipOutput;

import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.utils.ReportUtils;
import com.training.commons.file.FileUtils;


public class ZipUtil {
	
/*	public static void zip(String filePath,String putPath,int day,String name)throws Exception{
		if(!new File(putPath).exists()){
			 new File(putPath).mkdirs();
		 }
		File file=new File(filePath);
		File[] fl=file.listFiles();
			for(int i=0;i<fl.length;i++){
				if(isNumeric(fl[i].getName().replaceAll("-", ""))){
				if(Integer.parseInt(fl[i].getName().replaceAll("-", ""))==day){
					String pass =String.valueOf((Math.sqrt(day)%1)*1000000);
					String password=pass.equals("0.0")?"000000":pass.substring(0, 6);//4491.237246015846
					 byte[] zipByte1 =ZipOutput.getEncryptZipByte(fl[i].listFiles(),password);
					 String zipName=putPath+name+"-"+fl[i].getName()+".zip";
		       	    FileUtils.writeByteFile(zipByte1, new File(zipName));
				}
			}
		}
		
	}
	*/
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void zip(String filePath,String putPath,String password,int day,String name)throws Exception{
		if(!new File(putPath).exists()){
			 new File(putPath).mkdirs();
		 }
		File file=new File(filePath);
		File[] fl=file.listFiles();
		for(int i=0;i<fl.length;i++){
			if(isNumeric(fl[i].getName().replaceAll("-", ""))){
				if(Integer.parseInt(fl[i].getName().replaceAll("-", ""))==day){
			        String zipName=putPath+name+"-"+fl[i].getName()+".zip";
			        String pass =String.valueOf((Math.sqrt(day)%1)*1000000);//237913
					  //创建压缩文件
		            ZipFile zipFile = new ZipFile(zipName);
		           // ArrayList files = new ArrayList();
		            File file1 = new File(fl[i].toString());
		          //  File[] f2=file1.listFiles();
//		            for(File f1:f2){
//		            	files.add(f1);
//		            }

		            ZipParameters parameters = new ZipParameters();
		            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);

		            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

		            parameters.setEncryptFiles(true);

		            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);

		            parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);

		            parameters.setPassword(password);
		            zipFile.addFolder(file1, parameters);
		            deleteAll(file1);
				}
			}
		}
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void zip(String filePath,String putPath,int day,String name)throws Exception{
		if(!new File(putPath).exists()){
			 new File(putPath).mkdirs();
		 }
		File file=new File(filePath);
		File[] fl=file.listFiles();
		for(int i=0;i<fl.length;i++){
			if(isNumeric(fl[i].getName().replaceAll("-", ""))){
				if(Integer.parseInt(fl[i].getName().replaceAll("-", ""))==day){
			        String zipName=putPath+name+"-"+fl[i].getName()+".zip";
			        String pass =String.valueOf((Math.sqrt(day)%1)*1000000);//237913
					String password=pass.equals("0.0")?"000000":pass.substring(0, 6);//4491.237246015846
					  //创建压缩文件
		            ZipFile zipFile = new ZipFile(zipName);
		           // ArrayList files = new ArrayList();
		            File file1 = new File(fl[i].toString());
		          //  File[] f2=file1.listFiles();
//		            for(File f1:f2){
//		            	files.add(f1);
//		            }

		            ZipParameters parameters = new ZipParameters();
		            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);

		            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

		            parameters.setEncryptFiles(true);

		            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);

		            parameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);

		            parameters.setPassword(password);
		            zipFile.addFolder(file1, parameters);
				   
				}
				
			}
		}
		
	}
	public static void delete(String filePath,int day,String type){
		if(new File(filePath).exists()){
			File file=new File(filePath);
			File[] fl=file.listFiles();
			for(int i=0;i<fl.length;i++){
				System.out.println(fl[i].getName());
				if(fl[i].isFile()){
					if(fl[i].getName().startsWith(type)&&fl[i].getName().endsWith(".zip")&&trimChar(fl[i].getName())<=day){
						fl[i].delete();
					}
				}
			}
		}
	}
	
	
	
	public static boolean isNumeric(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum=pattern.matcher(str);
		if(! isNum.matches()){
			return false;
		}
		return true;
	}

	

	
	
	public static int trimChar(String str){
		Pattern pattern = Pattern.compile("[^0-9]");
		
		Matcher m=pattern.matcher(str);
		return Integer.parseInt(m.replaceAll("").trim());
	}
	
	
	public static void deleteAll(File filePath){
		 if(filePath.exists()){
				File[] fl=filePath.listFiles();
				if(fl.length == 0){
					filePath.delete();
				}else{
					for(int i=0;i<fl.length;i++){
						if(fl[i].isFile()){
								fl[i].delete();
						}else{
							deleteAll(fl[i]);
						}
					}
					deleteAll(filePath);
				}
			}
	}
	public static void main(String[] args) throws Exception{
		
		
		 String filePath="C:\\pack\\2018-11-16";
		 File file = new File(filePath);
		 deleteAll(file);
}
	private static void Create_Style_Value(int num,XSSFCellStyle cellStyle,String CellValue,XSSFRow row,XSSFCell cell) {
    	cell=row.createCell(num);
    	cell.setCellStyle(cellStyle);
    	cell.setCellValue(CellValue);
    }
}
