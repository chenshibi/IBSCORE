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
import resource.bean.basic.TCorpLoancardInq;
import resource.bean.basic.TCorpUploadBean;

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


public class BatchCorpLoancardService {

    private static final String DATASET_ID = "BatchCorpLoancardService";
    private static final HtLog htlog = HtLogFactory.getLogger(BatchCorpLoancardService.class);
	

    private ROOTDAO rootDao;

    public synchronized static BatchCorpLoancardService getInstance() {
        return (BatchCorpLoancardService) ApplicationContextUtils.getBean(DATASET_ID);
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
     * 
     * @param excelFile
     * @param uploadFile
     * @return
     * @throws CommonException
     */
    @SuppressWarnings("unchecked")
  	public String  upFile(FormFile excelFile,FormFile uploadFile) throws CommonException{
    		String currentTime = DataMyUtil.getFullDateTime();
          	try {
          		//文件名
              	String excelFileName=excelFile.getFileName();
              	String uploadFileName=uploadFile.getFileName();
              	 //文件存放指定路径
              	String excelTargetPath=ReportUtils.getSysParamsValue("BATCH_LOAN", "LOAN_PATH")+DateUtil.get8Date(); 
                String excelpostfix= excelFileName.substring(excelFileName.lastIndexOf('.')).toLowerCase();
                String uploadpostfix= uploadFileName.substring(uploadFileName.lastIndexOf('.')).toLowerCase();
         		mkdirIfNotExists(excelTargetPath);
              	int batchId=getMaxBatchId();
              	//文件存放全路径
	              	String fullexcelFileName =currentTime+"_"+batchId+excelpostfix;
	            	String fulluploadFileName =currentTime+"_"+batchId+"_"+"approve"+uploadpostfix;
	        		File file=new File(excelTargetPath,fullexcelFileName);
					FileOutputStream out1=new FileOutputStream(file);
					

					InputStream excelStream=excelFile.getInputStream();
	            	int bytesRead=0;
	            	byte[] buffer=new byte[1024*1024*50];
	            	while((bytesRead=excelStream.read(buffer, 0, 1024*1024*50)) != -1){
	            		out1.write(buffer, 0, bytesRead);
	            	}
	            	out1.close();
	            	excelStream.close();
					//获取许可文件全路径
					String fullUpPath =excelTargetPath+fulluploadFileName;
					return fullUpPath;
				
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("文件上传失败！");
				e.printStackTrace();
			}
  		return null;
      }
      
  
		  /**
		   * 获取corp_loancard_scurb_info表中最大的batch_id
		   * @return
		   * @throws CommonException
		   */
		  public int getMaxBatchId() throws CommonException {
			  	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			  	String hql = "select max(batchId) from CorpLoancardScurbInfo";
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
		     * 文件目录不存在则创建文件目录，带层级
		     * @param path
		     */
		    private void mkdirIfNotExists(String path) {
		        File file = new File(path);
		        if (!file.exists()) {
		            file.mkdirs();
		        }
		    }
		    /**
		     * 01: 机构信用代码 02: 中征码 03: 组织机构代码 04:纳税人识别号(国税)
			 * 05: 纳税人识别号（地税） 06: 社会统一信用代码 
		     * @param queryReason
		     * @return
		     */
		    public String parseInquiryType(String InquiryType){
		     	if("机构信用代码".equals(InquiryType)){
		     		InquiryType="01";
		    	}else if("中征码".equals(InquiryType)){
		    		InquiryType="02";
		    	}else if("组织机构代码".equals(InquiryType)){
		    		InquiryType="03";
		    	}else if("纳税人识别号(国税)".equals(InquiryType)){
		    		InquiryType="04";
		    	}else if("纳税人识别号(地税)".equals(InquiryType)){
		    		InquiryType="05";
		    	}else if("社会统一信用代码".equals(InquiryType)){
		    		InquiryType="06";
		    	}else if("工商注册号".equals(InquiryType)){
		    		InquiryType="07";
		    	}else if(InquiryType.length()>2){
		    		InquiryType="-";
		    	}
		     	
				return InquiryType;
		    }
		    
		    /**
		     * 01: 贷后管理 02: 贷款审批 03: 信用卡审批
			 *08: 担保资格审查 05: 异议查询 04: 本人查询
		     * @param queryReason
		     * @return
		     */
		    public String parseQueryReason(String queryReason){
		     	if("对新客户的身份识别".equals(queryReason)){
		     		queryReason="01";
		    	}else if("持续客户身份识别或重新识别客户".equals(queryReason)){
		    		queryReason="02";
		    	}else if("本机构查询".equals(queryReason)){
		    		queryReason="03";
		    	}else if("异议处理查询".equals(queryReason)){ 
		    		queryReason="04";
		    	}else if("其他查询".equals(queryReason)){
		    		queryReason="05";
		    	}else if(queryReason.length()>2){
		    		queryReason="-";
		    	}
				return queryReason;
		    }
		    
		    
		    /**
		     * 此方法解析excel2010以上版本
		     * @param excelFile
		     * @return
		     * @throws IOException
		     * @throws CommonException
		     */
			 @SuppressWarnings("unchecked")
				public  List  parseXlsx(FormFile excelFile) throws IOException, CommonException {
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
						    	//查询类型
								String inquiryType =parseInquiryType(String.valueOf(xssfRow.getCell(0))).replace(".0","").trim();
								//贷款卡号码/中征码
								String inquiryValue=String.valueOf(xssfRow.getCell(1)).replace(".0","").trim();
								//查询原因
								String queryReason = parseQueryReason(String.valueOf(xssfRow.getCell(2))).replace(".0","").trim();
						
							
							TCorpLoancardInq  tcorpLoancardInq=new TCorpLoancardInq();
							tcorpLoancardInq.setInquiryType(inquiryType);
							tcorpLoancardInq.setInquiryValue(inquiryValue);
							tcorpLoancardInq.setQueryReason(queryReason);
							list.add(tcorpLoancardInq);
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
			public List parseXls(FormFile excelFile) throws IOException, CommonException {
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
									//查询类型
									String inquiryType =parseInquiryType(String.valueOf(hssfRow.getCell(0))).replace(".0","").trim();
									//贷款卡号码/中征码
									String inquiryValue=String.valueOf(hssfRow.getCell(1)).replace(".0","").trim();
									//查询原因
									String queryReason = parseQueryReason(String.valueOf(hssfRow.getCell(2))).replace(".0","").trim();
									TCorpLoancardInq  tcorpLoancardInq=new TCorpLoancardInq();
									tcorpLoancardInq.setInquiryType(inquiryType);
									tcorpLoancardInq.setInquiryValue(inquiryValue);
									tcorpLoancardInq.setQueryReason(queryReason);
									list.add(tcorpLoancardInq);

									}
								}
			        		 }
					is.close();
					hssfWorkbook.close();
					return list;
		}
			 
			 
}	    
					    

