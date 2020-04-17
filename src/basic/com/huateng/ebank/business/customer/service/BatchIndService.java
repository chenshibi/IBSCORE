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
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Sheet;


import org.apache.commons.fileupload.FileItem;
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
import resource.bean.basic.IndApp;
import resource.bean.basic.IndPermit;
import resource.bean.basic.IndScrubInfo;
import resource.bean.basic.InqCust;
import resource.bean.basic.SysParams;
import resource.bean.basic.TCorpApp;
import resource.bean.basic.IndUploadBean;

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


public class BatchIndService {

    private static final String DATASET_ID = "BatchIndService";
    private static final HtLog htlog = HtLogFactory.getLogger(BatchIndService.class);
	

    private ROOTDAO rootDao;

    public synchronized static BatchIndService getInstance() {
        return (BatchIndService) ApplicationContextUtils.getBean(DATASET_ID);
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
              	String excelTargetPath=ReportUtils.getSysParamsValue("BATCH_IND","IND_PATH")+DateUtil.get8Date(); 
              	String uploadTargetPath=ReportUtils.getSysParamsValue("BATCH_APP", "IND_PATH")+DateUtil.get8Date(); 
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
					String fullUpPath =uploadTargetPath+"/"+fulluploadFileName;
					return fullUpPath;
				
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("文件上传失败！");
				e.printStackTrace();
			}
  		return null;
      }
      
    /**
     * 
     * @param File
     * @param uploadFile
     * @return
     * @throws CommonException
     */
    @SuppressWarnings("unchecked")
  	public String  uploadFile(FormFile uploadFile) throws CommonException{
    		String currentTime = DataMyUtil.getFullDateTime();
          	try {
          		//文件名
              	String uploadFileName=uploadFile.getFileName();
              	 //文件存放指定路径
              	String uploadTargetPath=ReportUtils.getSysParamsValue("UPLOAD", "PATH"); 
              	mkdirIfNotExists(uploadTargetPath);
              	//文件存放全路径
	            	String fulluploadFileName =currentTime+"_"+uploadFileName;
	          		File file=new File(uploadTargetPath,fulluploadFileName);
					FileOutputStream out=new FileOutputStream(file);
					//获取许可文件全路径
					String fullUpPath =uploadTargetPath+"/"+"_"+currentTime+"_"+uploadFileName;
					return fullUpPath;
				
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("文件上传失败！");
				e.printStackTrace();
			}
  		return null;
      }
    public List<InqCust> getInqCustQuery(String relName,String relCustId,String relCustIdType) throws CommonException {
	  	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
	  	String hql = "select po from InqCust po where 1=1 and inqCustType='2' and po.inqCustName = ? and po.inqCustId = ? and po.inqCustIdType = ?  order by po.createTime desc";
	  	 @SuppressWarnings("unchecked")
	       ArrayList<String> condList = new ArrayList<String>();
	       condList.add(relName);
	       condList.add(relCustId);
	       condList.add(relCustIdType);
	  	List<InqCust> list = rootdao.queryByCondition(hql,condList.toArray());
	  	
	  	if(null != list && list.size()>0){
	  		return list;
	  	}
		return null;
			
	  }

    
    /**
     * 企业流水表
     * @param relCorpId企业中证码  corpName 企业名称 corpCustType	征信查询客户的客户属性
     * @return
     * @throws CommonException
     */
    public List<CorpCust> querycorpCust(String relCorpId,String corpName) throws CommonException {
	  	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();		     											                                        
	  	 String hql = "select po from CorpCust po where 1=1 and po.corpCustType='1' and  po.corpCustLoancard = '"+relCorpId+"' and po.corpCustCompanyname='"+corpName+ "' order by po.createTime desc";
	  	List<CorpCust> list = rootdao.queryByCondition(hql);
	  	if(null != list && list.size()>0){
	  		return list;
	  	}
		return null;
			
	  }
    /**
     * 查IndApp有没有S天的数据
     * @param idType
     * @param name
     * @param individualId
     * @return
     * @throws CommonException
     */
    public List<IndApp> getIndApp(String idType,String name,String individualId) throws CommonException {
    	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        int dayNum=Integer.valueOf(ReportUtils.getSysParamsValue("BATCH_IND", "BATCH_IND")); 
        StringBuffer hql = new StringBuffer("select po from IndApp po where 1=1 and po.status <> '11' and po.status<>'10' ");
            hql.append(" and po.name = '").append(name).append("'");
            hql.append(" and po.individualId = '").append(individualId).append("'");
            hql.append(" and po.idType = '").append(idType).append("'");
            //hql.append(" and datediff(day,returnTime,getDate())").append("<=").append(dayNum);//datediff为sqlserver函数。
            hql.append(" and (sysdate - (returnTime-0))").append("<=").append(dayNum);//调适配为oracle  //to_date（to_char(xxxx,'yyyy-mm-dd'),'yyyy-mm-dd'）
            //hql.append(" and (systimestamp - to_date(to_char(returnTime,'yyyy-mm-dd'),'yyyy-mm-dd'))").append("<=").append(dayNum);
            hql.append(" order by po.inputTime desc ");
            List<IndApp> list = rootdao.queryByCondition(hql.toString());
            if(null != list && list.size()>0){
            	return list;
            }
            return null;
      }
		  
		  /**
		   * 获取IndScrubInfo表中最大的batch_id
		   * @return
		   * @throws CommonException
		   */
		  public int getMaxBatchId() throws CommonException {
			  	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			  	String hql = "select max(batchId) from IndScrubInfo";
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
		     * 0: 身份证 1: 户口簿 2: 护照 3: 军官证
			 *4: 士兵证 5: 港澳居民来往内地通行证
			 *6: 台湾同胞来往内地通行证 7: 临时身份证
			 *8: 外国人居留证 9: 警官证 X: 其它证件
			 *-: 都不是以上的证件类型
		     * @param idType
		     * @return
		     */
		    public String parseInType(String idType){
		    	if("身份证".equals(idType)){
		    		idType="0";
		    	}else if("户口簿".equals(idType)){
		    		idType="1";
		    	}else if("护照".equals(idType)){
		    		idType="2";
		    	}else if("军官证".equals(idType)){
		    		idType="3";
		    	}else if("士兵证".equals(idType)){
		    		idType="4";
		    	}else if("港澳居民来往内地通行证".equals(idType)){
		    		idType="5";
		    	}else if("台湾同胞来往内地通行证".equals(idType)){
		    		idType="6";
		    	}else if("临时身份证".equals(idType)){
		    		idType="7";
		    	}else if("外国人居留证".equals(idType)){
		    		idType="8";
		    	}else if("警官证".equals(idType)){
		    		idType="9";
		    	}else if("其它证件".equals(idType)||"其他证件".equals(idType)){
		    		idType="X";
		    	}else if("都不是以上的证件类型".equals(idType)){
		    		idType="-";
		    	}
				return idType;
		    }
		    
		    /**
		     * 01: 贷后管理 02: 贷款审批 03: 信用卡审批
			 *08: 担保资格审查 05: 异议查询 04: 本人查询
		     * @param queryReason
		     * @return
		     */
		    public String parseQueryReason(String queryReason){
		     	if("贷后管理".equals(queryReason)){
		     		queryReason="01";
		    	}else if("贷款审批".equals(queryReason)){
		    		queryReason="02";
		    	}else if("信用卡审批".equals(queryReason)){
		    		queryReason="03";
		    	}else if("本人查询".equals(queryReason)){
		    		queryReason="04";
		    	}else if("异议查询".equals(queryReason)){
		    		queryReason="05";
		    	}else if("担保资格审查".equals(queryReason)){
		    		queryReason="08";
		    	}
				return queryReason;
		    }
		    
		    /**
		     * 
		     * @param inqCustType
		     * @return
		     */
		    public String parseInqCustType(String inqCustType){
		    	if("担保人".equals(inqCustType)){
		    		inqCustType="1";
		    	}else if("主借款人".equals(inqCustType)){
		    		inqCustType="2";
		    	}else if("共同借款人".equals(inqCustType)){
		    		inqCustType="3";
		    	}
				return inqCustType;
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
						    String idType=parseInType(String.valueOf(xssfRow.getCell(0))).replace(".0","").trim();
							String individualId =String.valueOf(xssfRow.getCell(1)).replace(".0","").trim();
							String name = String.valueOf(xssfRow.getCell(2)).replace(".0","").trim();
							String queryReason =parseQueryReason(String.valueOf(xssfRow.getCell(3))).replace(".0","").trim();
							String applicationNo = String.valueOf(xssfRow.getCell(4)).replace(".0","").trim();
							String loanNo = String.valueOf(xssfRow.getCell(5)).replace(".0","").trim();
							String relationshipNo = String.valueOf(xssfRow.getCell(6)).replace(".0","").trim();
							String inqCustType = parseInqCustType(parseInqCustType(String.valueOf(xssfRow.getCell(7)))).replace(".0","").trim();
							String relCorpId = String.valueOf(xssfRow.getCell(8)).replace(".0","").trim();
							String corpName = String.valueOf(xssfRow.getCell(9)).replace(".0","").trim();
							String relCustIdType = parseInType(String.valueOf(xssfRow.getCell(10))).replace(".0","").trim();
							String relCustId = String.valueOf(xssfRow.getCell(11)).replace(".0","").trim();
							String relName =String.valueOf(xssfRow.getCell(12)).replace(".0","").trim();
							IndUploadBean  uploadBean=new IndUploadBean();
							if(idType.length()>2){
								uploadBean.setIdType("");
							}else{
								uploadBean.setIdType(idType);
							}
							if(individualId.length()>30){
								uploadBean.setIndividualId("");
							}else{
								uploadBean.setIndividualId(individualId);
							}
							if(name.length()>60){
								uploadBean.setName("");
							}else{
								uploadBean.setName(name);
							}
							if(queryReason.length()>2){
								uploadBean.setQueryReason("");
							}else{
								uploadBean.setQueryReason(queryReason);
							}
							if(applicationNo.length()>100){
								uploadBean.setApplicationNo("");
							}else{
								uploadBean.setApplicationNo(applicationNo);
							}
							if(loanNo.length()>100){
								uploadBean.setLoanNo("");
							}else{
								uploadBean.setLoanNo(loanNo);
							}
							if(relationshipNo.length()>100){
								uploadBean.setRelationshipNo("");
							}else{
								uploadBean.setRelationshipNo(relationshipNo);
							}
							if(inqCustType.length()>2){
								uploadBean.setInqCustType("");
							}else{
								uploadBean.setInqCustType(inqCustType);
							}
							if(relCorpId.length()>16){
								uploadBean.setRelCorpId("");
							}else{
								uploadBean.setRelCorpId(relCorpId);
							}
							if(corpName.length()>60){
								uploadBean.setCorpName("");
							}else{
								uploadBean.setCorpName(corpName);
							}
							if(relCustId.length()>30){
								uploadBean.setRelCustId("");
							}else{
								uploadBean.setRelCustId(relCustId);
							}
							if(relCustIdType.length()>2){
								uploadBean.setRelCustIdType("");
							}else{
								uploadBean.setRelCustIdType(relCustIdType);
							}
							if(relName.length()>60){
								uploadBean.setRelName("");
							}else{
								uploadBean.setRelName(relName);
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
			        			  	String idType=parseInType(String.valueOf(hssfRow.getCell(0))).replace(".0","").trim();
									String individualId =String.valueOf(hssfRow.getCell(1)).replace(".0","").trim();
									String name = String.valueOf(hssfRow.getCell(2)).replace(".0","").trim();
									String queryReason =parseQueryReason(String.valueOf(hssfRow.getCell(3))).replace(".0","").trim();
									String applicationNo = String.valueOf(hssfRow.getCell(4)).replace(".0","").trim();
									String loanNo = String.valueOf(hssfRow.getCell(5)).replace(".0","").trim();
									String relationshipNo = String.valueOf(hssfRow.getCell(6)).replace(".0","").trim();
									String inqCustType =parseInqCustType(String.valueOf(hssfRow.getCell(7))).replace(".0","").trim();
									String relCorpId = String.valueOf(hssfRow.getCell(8)).replace(".0","").trim();
									String corpName = String.valueOf(hssfRow.getCell(9)).replace(".0","").trim();
									String relCustIdType = parseInType(String.valueOf(hssfRow.getCell(10))).replace(".0","").trim();
									String relCustId = String.valueOf(hssfRow.getCell(11)).replace(".0","").trim();
									String relName =String.valueOf(hssfRow.getCell(12)).replace(".0","").trim();
									IndUploadBean  uploadBean=new IndUploadBean();
									if(idType.length()>2){
										uploadBean.setIdType("");
									}else{
										uploadBean.setIdType(idType);
									}
									if(individualId.length()>30){
										uploadBean.setIndividualId("");
									}else{
										uploadBean.setIndividualId(individualId);
									}
									if(name.length()>60){
										uploadBean.setName("");
									}else{
										uploadBean.setName(name);
									}
									if(queryReason.length()>2){
										uploadBean.setQueryReason("");
									}else{
										uploadBean.setQueryReason(queryReason);
									}
									if(applicationNo.length()>100){
										uploadBean.setApplicationNo("");
									}else{
										uploadBean.setApplicationNo(applicationNo);
									}
									if(loanNo.length()>100){
										uploadBean.setLoanNo("");
									}else{
										uploadBean.setLoanNo(loanNo);
									}
									if(relationshipNo.length()>100){
										uploadBean.setRelationshipNo("");
									}else{
										uploadBean.setRelationshipNo(relationshipNo);
									}
									if(inqCustType.length()>2){
										uploadBean.setInqCustType("");
									}else{
										uploadBean.setInqCustType(inqCustType);
									}
									if(relCorpId.length()>16){
										uploadBean.setRelCorpId("");
									}else{
										uploadBean.setRelCorpId(relCorpId);
									}
									if(corpName.length()>100){
										uploadBean.setCorpName("");
									}else{
										uploadBean.setCorpName(corpName);
									}
									if(relCustId.length()>30){
										uploadBean.setRelCustId("");
									}else{
										uploadBean.setRelCustId(relCustId);
									}
									if(relCustIdType.length()>2){
										uploadBean.setRelCustIdType("");
									}else{
										uploadBean.setRelCustIdType(relCustIdType);
									}
									if(relName.length()>60){
										uploadBean.setRelName("");
									}else{
										uploadBean.setRelName(relName);
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
					    

