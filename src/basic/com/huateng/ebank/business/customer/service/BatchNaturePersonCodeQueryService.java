package com.huateng.ebank.business.customer.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


import jxl.Sheet;


import oracle.jdbc.proxy.annotation.GetDelegate;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.upload.FormFile;

import resource.bean.basic.CorpCust;
import resource.bean.basic.IndApp;
import resource.bean.basic.InqCust;
import resource.bean.basic.TCorpApp;
import resource.bean.basic.TCorpDetailApp;
import resource.bean.basic.TCorpUploadBean;
import resource.bean.basic.TDetailIndApp;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.excel.imp.DataMyUtil;
import com.huateng.report.utils.ReportUtils;


public class BatchNaturePersonCodeQueryService {

    private static final String DATASET_ID = "BatchNaturePersonCodeQueryService";
    private static final HtLog htlog = HtLogFactory.getLogger(BatchNaturePersonCodeQueryService.class);
	

    private ROOTDAO rootDao;

    public synchronized static BatchCorpService getInstance() {
        return (BatchCorpService) ApplicationContextUtils.getBean(DATASET_ID);
    }


    // 通过id来获取实体映射类
    @SuppressWarnings("unchecked")
    public <T> T selectById(String id, T t) {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        T t1 = null;
        try {
            t1 = (T) rootdao.query(t.getClass(), id);
        } catch (CommonException e) {
            htlog.info("对象不存在");
            e.printStackTrace();
        }
        return t1;
    }

    


   
		  /**
		   * 获取corp_scurb_info表中最大的batch_id
		   * @return
		   * @throws CommonException
		   */
		  public int getMaxBatchId() throws CommonException {
			  	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			  	String hql = "select max(batchId) from NaturalCodeBatchInfo";
			  	List list =rootdao.queryByCondition(hql);
			  	int batchId;
			  	if(null==list.get(0)){
			  		batchId=0;
			  	}else{
			  		batchId=(Integer) list.get(0);
			  	}
				return batchId;
		 }
		  
		    
		    /**
		     * 此方法解析excel2010以上版本
		     * @param excelFile
		     * @return
		     * @throws IOException
		     * @throws CommonException
		     */
			 @SuppressWarnings("unchecked")
				public static  List  parseXlsx(FormFile excelFile) throws IOException, CommonException {
				 		List list=new ArrayList();
					   InputStream is = excelFile.getInputStream();
					   XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
					   for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
						     XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
						     if (xssfSheet == null) {
						    	continue;
						     }
						  for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
						    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
						    if (xssfRow != null) {
						    //贷款卡号码/中征码
						    String individualIdType=String.valueOf(xssfRow.getCell(0)).replace(".0","").trim();
						    //贷款卡密码
							String individualId =String.valueOf(xssfRow.getCell(1)).replace(".0","").trim();
							//贷款公司名称
							String name = String.valueOf(xssfRow.getCell(2)).replace(".0","").trim();
							
							//String queryType =parseQueryType(String.valueOf(xssfRow.getCell(5))).replace(".0","").trim();
							//查询原因
					
							
							TDetailIndApp uploadBean = new TDetailIndApp();
							uploadBean.setIndividualIdType(individualIdType);
							uploadBean.setIndividualId(individualId);
							uploadBean.setName(name);
							
							list.add(uploadBean);
							}
						}
					}
					is.close();
					xssfWorkbook.close();  
					return list;
			 } 
			 
			 
			 /**
			  * 此方法解析excel2007以下版本
			  * @param excelFile
			  * @return
			  * @throws IOException
			  * @throws CommonException
			  */
			 @SuppressWarnings("unchecked")
			public static List parseXls(FormFile excelFile) throws IOException, CommonException {
					List list=new ArrayList();
			    	InputStream is = excelFile.getInputStream();
					HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
					for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			        	HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			        	if (hssfSheet == null) {
			        		continue;
			        	 }
			        	for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
			        		  HSSFRow hssfRow = hssfSheet.getRow(rowNum);
			        		  if (hssfRow != null) {
			        			  //贷款卡号码/中征码
								    String individualIdType=String.valueOf(hssfRow.getCell(0)).replace(".0","").trim();
								    //贷款卡密码
									String individualId  =String.valueOf(hssfRow.getCell(1)).replace(".0","").trim();
									//贷款公司名称
									String name = String.valueOf(hssfRow.getCell(2)).replace(".0","").trim();
									
									//查询类型
									//String queryType  = parseQueryType(String.valueOf(hssfRow.getCell(5))).replace(".0","").trim();
								
									TDetailIndApp uploadBean = new TDetailIndApp();
									uploadBean.setIndividualIdType(individualIdType);
									uploadBean.setIndividualId(individualId);
									uploadBean.setName(name);
									
									list.add(uploadBean);
									}
								}
			        		 }
					is.close();
					hssfWorkbook.close();
					return list;
		}


			public String parseNaturePersonCodeType(String individualIdType) {
				if(individualIdType.equals("中征码")){
					individualIdType="c";
				}else if(individualIdType.equals("身份证")){
					individualIdType="0";
				}else if(individualIdType.equals("户口簿")){
					individualIdType="1";
				}else if(individualIdType.equals("护照")){
					individualIdType="2";
				}else if(individualIdType.equals("军官证")){
					individualIdType="3";
				}else if(individualIdType.equals("士兵证")){
					individualIdType="4";
				}else if(individualIdType.equals("港澳居民来往内地通行证")){
					individualIdType="5";
				}else if(individualIdType.equals("台湾同胞来往内地通行证")){
					individualIdType="6";
				}else if(individualIdType.equals("临时身份证")){
					individualIdType="7";
				}else{
					individualIdType="";
				}
				return individualIdType;
			}


			public String upFile(FormFile excelFile, FormFile uploadFile) throws CommonException{
				String currentTime = DataMyUtil.getFullDateTime();
	          	try {
	          		//文件名
	              	String excelFileName=excelFile.getFileName();
	              	String uploadFileName=uploadFile.getFileName();
	              	 //文件存放指定路径
	              	String excelTargetPath=ReportUtils.getSysParamsValue("BATCH_NA", "NA_PATH")+DateUtil.get8Date(); 
	              	String uploadTargetPath=ReportUtils.getSysParamsValue("BATCH_APP", "NA_PATH")+DateUtil.get8Date(); 
	                String excelpostfix= excelFileName.substring(excelFileName.lastIndexOf('.')).toLowerCase();
	                String uploadpostfix= uploadFileName.substring(uploadFileName.lastIndexOf('.')).toLowerCase();
	         		mkdirIfNotExists(excelTargetPath);
	              	mkdirIfNotExists(uploadTargetPath);
	              	int batchId=getMaxBatchId();
	              	//文件存放全路径
		              	String fullexcelFileName =currentTime+"_"+batchId+excelpostfix;
		            	String fulluploadFileName =currentTime+"_"+batchId+"_"+"approve"+uploadpostfix;
		        		File file1=new File(excelTargetPath,fullexcelFileName);
		          		File file2=new File(uploadTargetPath,fulluploadFileName);
						FileOutputStream out1=new FileOutputStream(file1);
						FileOutputStream out2=new FileOutputStream(file2);
						
						
						InputStream excelStream=excelFile.getInputStream();
		            	InputStream uploadStream=uploadFile.getInputStream();
		            	int bytesRead=0;
		            	byte[] buffer=new byte[1024*1024*50];
		            	while((bytesRead=excelStream.read(buffer, 0, 1024*1024*50)) != -1){
		            		out1.write(buffer, 0, bytesRead);
		            	}
		            	while((bytesRead=uploadStream.read(buffer, 0, 1024*1024*50)) != -1){
		            		out2.write(buffer, 0, bytesRead);
		            	}
		            	out1.close();
		            	out2.close();
		            	excelStream.close();
		            	uploadStream.close();
						
						//获取许可文件全路径
						String fullUpPath =uploadTargetPath+fulluploadFileName;
						return fullUpPath;
					
				} catch (Exception e) {
					ExceptionUtil.throwCommonException("文件上传失败！");
					e.printStackTrace();
				}
				return null;
			}
			/**
		     * 文件目录不存在则创建文件目录，带层级
		     * @param path
		     */
		    private void mkdirIfNotExists(String path) {
		        File file = new File(path);
		        if (!file.exists()) {
		            file.mkdirs();
		        }
		    }
			 
}	    
					    

