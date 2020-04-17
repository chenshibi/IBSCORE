package com.huateng.ebank.business.customer.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;


import org.apache.commons.lang.BooleanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.upload.FormFile;

import resource.bean.basic.CorpCust;
import resource.bean.basic.DataDic;
import resource.bean.basic.IndApp;
import resource.bean.basic.IndPermit;
import resource.bean.basic.IndScrubInfo;
import resource.bean.basic.InqCust;
import resource.bean.basic.SysParams;
import resource.bean.basic.TCorpApp;
import resource.bean.basic.IndUploadBean;
import resource.bean.basic.TlrInfo;
import resource.bean.basic.TlrUpdateInfoUploadBean;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.form.UploadfileForm;
import com.huateng.ebank.business.customer.operation.BatchIndOperation;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.excel.imp.DataMyUtil;
import com.huateng.report.databak.utils.ReportTableUtil;
import com.huateng.report.utils.ReportUtils;
import com.itextpdf.text.log.SysoLogger;


public class BatchTlrUpdateInfoService {

    private static final String DATASET_ID = "BatchTlrUpdateInfoService";
    private static final HtLog htlog = HtLogFactory.getLogger(BatchTlrUpdateInfoService.class);
	

    private ROOTDAO rootDao;

    public synchronized static BatchTlrUpdateInfoService getInstance() {
        return (BatchTlrUpdateInfoService) ApplicationContextUtils.getBean(DATASET_ID);
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
     * @param File
     * @param uploadFile
     * @return
     * @throws CommonException
     */
    @SuppressWarnings("unchecked")
	public String  uploadFile(FormFile excelFile) throws CommonException{
		String currentTime = DataMyUtil.getFullDateTime();
      	try {
      		//文件名
          	String excelFileName=excelFile.getFileName();
          	 //文件存放指定路径
          	String excelTargetPath=ReportUtils.getSysParamsValue("BATCH_TLR","UP_PATH")+DateUtil.get8Date(); 
            String excelpostfix= excelFileName.substring(excelFileName.lastIndexOf('.')).toLowerCase();
     		mkdirIfNotExists(excelTargetPath);
          	int batchId=getMaxBatchId()+1;
          	//文件存放全路径
              	String fullexcelFileName =currentTime+"_"+batchId+excelpostfix;
        		File file=new File(excelTargetPath,fullexcelFileName);
				FileOutputStream out=new FileOutputStream(file);
				
				
				InputStream excelStream=excelFile.getInputStream();
            	int bytesRead=0;
            	byte[] buffer=new byte[1024*1024*50];
            	while((bytesRead=excelStream.read(buffer, 0, 1024*1024*50)) != -1){
            		out.write(buffer, 0, bytesRead);
            	}
            	out.close();
            	excelStream.close();
				//获取许可文件全路径
				String fullUpPath =excelTargetPath+"/"+fullexcelFileName;
				return fullUpPath;
			
		} catch (Exception e) {
			ExceptionUtil.throwCommonException("文件上传失败！");
			e.printStackTrace();
		}
		return null;
    }
    
    /**
     * 用戶表
     * @param userI 根據userId查詢用戶信息
     * @return
     * @throws CommonException
     */
    @SuppressWarnings("unchecked")
	public List<TlrInfo> querytlrInfo(String userId) throws CommonException {
	  	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();		     											                                        
	  	 String hql = "select po from TlrInfo po where 1=1 and  po.tlrno = '"+userId+ "'";
	  	List<TlrInfo> list = rootdao.queryByCondition(hql.toString());
	  	if(null != list && list.size()>0){
	  		return list;
	  	}
		return null;
			
	  }
    /**
	   * 获取TlrUpdateInfoBatch表中最大的batch_id
	   * @return
	   * @throws CommonException
	   */	 
	 public int getMaxBatchId() throws CommonException {
			  	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			  	String hql = "select max(batchId) from TlrUpdateInfoBatch";
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
		     * 
		     * @param city
		     * @return
		     */
		    public  Map<String, String> getNameByNo(String dataName) throws CommonException{
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		          StringBuffer hql =  new StringBuffer("select po from DataDic po where 1=1 and po.dataTypeNo='503.00'");
		          hql.append("  and po.dataName='"+dataName+"'");
			  	List<DataDic> list = rootdao.queryByCondition(hql.toString());
			    Map<String, String> m=new HashMap<String, String>();
			    if(list !=null && list.size()>0){
			    	for(int i=0;i<list.size();i++){
			    		DataDic dc=list.get(i);
			    		m.put( dc.getDataName(),dc.getDataNo());
			    	}
			    }
				return m;
			}
		    
		    
		    /**
		     * 
		     * @param Region
		     * @return
		     */
		    public  Map<String, String> getRegionByNo(String dataName) throws CommonException{
				ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		          StringBuffer hql =  new StringBuffer("select po from DataDic po where 1=1 and po.dataTypeNo='502.00'");
		          hql.append("  and po.dataName='"+dataName+"'");
			  	List<DataDic> list = rootdao.queryByCondition(hql.toString());
			    Map<String, String> m=new HashMap<String, String>();
			    if(list !=null && list.size()>0){
			    	for(int i=0;i<list.size();i++){
			    		DataDic dc=list.get(i);
			    		m.put( dc.getDataName(),dc.getDataNo());
			    	}
			    }
				return m;
			}
		    
		    
		    /**
		     * 
		     * @param region
		     * @return
		     */
		    public String parseRegion(String region){
		    	if("1-North".equals(region)){
		    		region="1";
		    	}else if("2-South".equals(region)){
		    		region="2";
		    	}else if("3-West".equals(region)){
		    		region="3";
		    	}else if("4-East".equals(region)){
		    		region="4";
		    	}else {
		    		region="-";
		    	}
				return region;
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
							String userId =String.valueOf(xssfRow.getCell(0)).replace(".0","").trim();
							Map<String, String> map=getNameByNo(String.valueOf(xssfRow.getCell(1)).replace(".0","").trim());
							String city=map.get(String.valueOf(xssfRow.getCell(1)).replace(".0","").trim());
							Map<String, String> map2=getRegionByNo(String.valueOf(xssfRow.getCell(2)).replace(".0","").trim());
							String region=map2.get(String.valueOf(xssfRow.getCell(2)).replace(".0","").trim());
							TlrUpdateInfoUploadBean  uploadBean=new TlrUpdateInfoUploadBean();
							if(userId.length()>20){
								uploadBean.setUserId("");
							}else{
								uploadBean.setUserId(userId);
							}
							if(city.length()>20){
								uploadBean.setCity("");
							}else{
								uploadBean.setCity(city);
							}
							if(region.length()>150){
								uploadBean.setRegion("");
							}else{
								uploadBean.setRegion(region);
							}
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
									String userId =String.valueOf(hssfRow.getCell(0)).replace(".0","").trim();
									Map<String, String> dataName=getNameByNo(String.valueOf(hssfRow.getCell(1)).replace(".0","").trim());
									String city=dataName.get(dataName);
									Map<String, String> map2=getRegionByNo(String.valueOf(hssfRow.getCell(2)).replace(".0","").trim());
									String region=map2.get(String.valueOf(hssfRow.getCell(2)).replace(".0","").trim());
									TlrUpdateInfoUploadBean  uploadBean=new TlrUpdateInfoUploadBean();
									if(userId.length()>20){
										uploadBean.setUserId("");
									}else{
										uploadBean.setUserId(userId);
									}
									if(city.length()>20){
										uploadBean.setCity("");
									}else{
										uploadBean.setCity(city);
									}
									if(region.length()>150){
										uploadBean.setRegion("");
									}else{
										uploadBean.setRegion(region);
									}
									list.add(uploadBean);
									}
								}
			        		 }
					is.close();
					hssfWorkbook.close();
					return list;
		}
			 
			 
			 
		
}	    
					    

