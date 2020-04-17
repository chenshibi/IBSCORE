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


public class BatchCorpService {

    private static final String DATASET_ID = "BatchCorpService";
    private static final HtLog htlog = HtLogFactory.getLogger(BatchCorpService.class);
	

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
              	String excelTargetPath=ReportUtils.getSysParamsValue("BATCH_CORP", "CORP_PATH")+DateUtil.get8Date(); 
              	String uploadTargetPath=ReportUtils.getSysParamsValue("BATCH_APP", "CORP_PATH")+DateUtil.get8Date(); 
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
    public List<CorpCust> querycorpCust(String assureLoanCardNo,String assureCorpName) throws CommonException {
	  	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();		     											                                        
	  	 String hql = "select po from CorpCust po where 1=1 and po.corpCustType='1' and  po.corpCustLoancard = '"+assureLoanCardNo+"' and po.corpCustCompanyname='"+assureCorpName+ "' order by po.createTime desc";
	  	List<CorpCust> list = rootdao.queryByCondition(hql);
	  	if(null != list && list.size()>0){
	  		return list;
	  	}
		return null;
			
	  }
    /**
     * IndApp
     * @param idType
     * @param name
     * @param individualId
     * @return
     * @throws CommonException
     */
    public List<IndApp> getIndApp(String idType,String name,String individualId) throws CommonException {
  	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
      String sql = "select po from IndApp po where 1=1 and  po.idType = ? and po.name = ? and po.individualId = ?  order by inputTime desc";
      @SuppressWarnings("unchecked")
      ArrayList<String> condList = new ArrayList<String>();
      condList.add(idType);
      condList.add(name);
      condList.add(individualId);
		List<IndApp> list = rootdao.queryByCondition(sql,condList.toArray());
          return list;

  }
    
    
    /**
     * 查TCorpApp有没有S天的数据
     * @param loanCardNo
     * @return
     * @throws CommonException
     */
    public List<TCorpApp> getTCorpApp(String loanCardNo) throws CommonException {
    	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        int dayNum=Integer.valueOf(ReportUtils.getSysParamsValue("BATCH_CORP", "BATCH_CORP")); 
        StringBuffer hql = new StringBuffer("select po from TCorpApp po where 1=1 and status<>'10' and status<>'11'");
            hql.append(" and po.loanCardNo = '").append(loanCardNo).append("'");
          //hql.append(" and datediff(day,returnTime,getDate())").append("<=").append(dayNum);//datediff为sqlserver函数。
           // hql.append(" and (sysdate - returnTime)").append("<=").append(dayNum);//调适配为oracle20200120  修改两个时间戳类型相减
            hql.append(" and (sysdate - (returnTime-0))").append("<=").append(dayNum);//调适配为oracle20200120
            hql.append(" order by po.inputTime desc ");
            List<TCorpApp> list = rootdao.queryByCondition(hql.toString());
            if(null != list && list.size()>0){
            	return list;
            }
            return null;
      }
		  
    /**
     * 查TCorpDetailApp有没有S天的数据
     * @param loanCardNo
     * @return
     * @throws CommonException
     */
    public List<TCorpDetailApp> getTCorpDetailApp(String loanCardNo) throws CommonException {
    	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        int dayNum=Integer.valueOf(ReportUtils.getSysParamsValue("BATCH_CORP", "BATCH_CORP")); 
        StringBuffer hql = new StringBuffer("select po from TCorpDetailApp po where 1=1 and status<>'10' and status<>'11'");
            hql.append(" and po.loanCardNo = '").append(loanCardNo).append("'");
          //hql.append(" and datediff(day,returnTime,getDate())").append("<=").append(dayNum);//datediff为sqlserver函数。
            hql.append(" and (sysdate - (returnTime-0))").append("<=").append(dayNum);//调适配为oracle
            hql.append(" order by po.inputTime desc ");
            List<TCorpDetailApp> list = rootdao.queryByCondition(hql.toString());
            if(null != list && list.size()>0){
            	return list;
            }
            return null;
      }
    
    /**
	   * 查询出指定天数
	   * @throws CommonException
	   */
	 public int getParamVal() throws CommonException{
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		  	String hql = "select PARAM_VAL  from SysParams";
			List list = rootdao.queryByCondition(hql);
			if(null !=list && list.size()>0){
				int ParamVal=(Integer)list.get(0);
				return ParamVal;
			}
			return 0;
	 }  
		  /**
		   * 获取corp_scurb_info表中最大的batch_id
		   * @return
		   * @throws CommonException
		   */
		  public int getMaxBatchId() throws CommonException {
			  	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			  	String hql = "select max(batchId) from CorpScurbInfo";
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
		     * 01: 贷前(保前)审查02: 贷中操作 03: 贷后(在保)管理
			 *08: 关联查询 05: 其它理由
		     * @param queryReason
		     * @return
		     */
		    public String parseQueryReason(String queryReason){
		     	if("贷前(保前)审查".equals(queryReason)){
		     		queryReason="01";
		    	}else if("贷中操作".equals(queryReason)){
		    		queryReason="02";
		    	}else if("贷后(在保)管理".equals(queryReason)){
		    		queryReason="03";
		    	}else if("关联查询".equals(queryReason)){
		    		queryReason="04";
		    	}else if("其它理由".equals(queryReason)){
		    		queryReason="05";
		    	}
				return queryReason;
		    }
		    
		    /**
		     * 1: online 2: batch 
		     * @param queryType
		     * @return
		     */
		    public String parseQueryType(String queryType){
		     	if("online".equals(queryType)){
		     		queryType="1";
		    	}else if("batch".equals(queryType)){
		    		queryType="2";
		    	}
				return queryType;
		    }
		    
		    
		    /**
		     * 
		     * @param CustType
		     * @return
		     */
		    public String parseCustType(String custType){
		    	if("借款公司".equals(custType)){
		    		custType="1";
		    	}else if("担保公司".equals(custType)){
		    		custType="2";
		    	}
				return custType;
		    }
		    
		    
		    
		    /**
		     * 
		     * @param dealQuery
		     * @return
		     */
		    public String parseDealQuery(String dealQuery){
		    	if("否".equals(dealQuery)){
		    		dealQuery="0";
		    	}else if("是".equals(dealQuery)){
		    		dealQuery="1";
		    	}
				return dealQuery;
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
						    //贷款卡号码/中征码
						    String loanCardNo=String.valueOf(xssfRow.getCell(0)).replace(".0","").trim();
						    //贷款卡密码
							String loanCardPass =String.valueOf(xssfRow.getCell(1)).replace(".0","").trim();
							//贷款公司名称
							String corpName = String.valueOf(xssfRow.getCell(2)).replace(".0","").trim();
							//注册机构号
							String orgCode =String.valueOf(xssfRow.getCell(3)).replace(".0","").trim();
							//loan_no
							String loanNo = String.valueOf(xssfRow.getCell(4)).replace(".0","").trim();
							//查询类型
							String queryType =parseQueryType(String.valueOf(xssfRow.getCell(5))).replace(".0","").trim();
							//查询原因
							String queryReason = parseQueryReason(String.valueOf(xssfRow.getCell(6))).replace(".0","").trim();
							//客户属性
							String custType =parseCustType(String.valueOf(xssfRow.getCell(7))).replace(".0","").trim();
							//担保公司中征码
							String assureLoanCardNo = String.valueOf(xssfRow.getCell(8)).replace(".0","").trim();
							//担保公司名称
							String  assureCorpName = String.valueOf(xssfRow.getCell(9)).replace(".0","").trim();
							//是否进行明细查询
							String dealQuery = parseDealQuery(String.valueOf(xssfRow.getCell(10))).replace(".0","").trim();
							
							TCorpUploadBean  uploadBean=new TCorpUploadBean();
							if(loanCardNo.length()>16){
								uploadBean.setLoanCardNo("");
							}else{
								uploadBean.setLoanCardNo(loanCardNo);
							}
							
							if(orgCode.length()>20){
								uploadBean.setOrgCode("");
							}else{
								uploadBean.setOrgCode(orgCode);
							}
							
							if(loanNo.length()>100){
								uploadBean.setLoanNo("");
							}else{
								uploadBean.setLoanNo(loanNo);
							}
						
							if(assureLoanCardNo.length()>16){
								uploadBean.setAssureLoanCardNo("");
							}else{
								uploadBean.setAssureLoanCardNo(assureLoanCardNo);
							}
							if(loanCardPass.length()>30){
								uploadBean.setLoanCardPass("");
							}else{
								uploadBean.setLoanCardPass(loanCardPass);
							}
							
							if(queryReason.length()>2){
								uploadBean.setQueryReason("");
							}else{
								uploadBean.setQueryReason(queryReason);
							}
							if(custType.length()>2){
								uploadBean.setCustType("");
							}else{
								uploadBean.setCustType(custType);
							}
							if(corpName.length()>200){
								uploadBean.setCorpName("");
							}else{
								uploadBean.setCorpName(corpName);
							}
							if(assureCorpName.length()>200){
								uploadBean.setAssureCorpName("");
							}else{
								uploadBean.setAssureCorpName(assureCorpName);
							}
							if(queryType.length()>2){
								uploadBean.setQueryType("");
							}else{
								uploadBean.setQueryType(queryType);
							}
							uploadBean.setDealQuery(dealQuery);
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
			        			  //贷款卡号码/中征码
								    String loanCardNo=String.valueOf(hssfRow.getCell(0)).replace(".0","").trim();
								    //贷款卡密码
									String loanCardPass  =String.valueOf(hssfRow.getCell(1)).replace(".0","").trim();
									//贷款公司名称
									String corpName = String.valueOf(hssfRow.getCell(2)).replace(".0","").trim();
									//注册机构号
									String orgCode  =String.valueOf(hssfRow.getCell(3)).replace(".0","").trim();
									//loan_no
									String loanNo = String.valueOf(hssfRow.getCell(4)).replace(".0","").trim();
									//查询类型
									String queryType  = parseQueryType(String.valueOf(hssfRow.getCell(5))).replace(".0","").trim();
									//查询原因
									String queryReason = parseQueryReason(String.valueOf(hssfRow.getCell(6))).replace(".0","").trim();
									//客户属性
									String custType =parseCustType(String.valueOf(hssfRow.getCell(7))).replace(".0","").trim();
									//担保公司中征码
									String assureLoanCardNo = String.valueOf(hssfRow.getCell(8)).replace(".0","").trim();
									//担保公司名称
									String  assureCorpName = String.valueOf(hssfRow.getCell(9)).replace(".0","").trim();
									//是否进行明细查询
									String dealQuery = parseDealQuery(String.valueOf(hssfRow.getCell(10))).replace(".0","").trim();
								
									TCorpUploadBean  uploadBean=new TCorpUploadBean();
									if(loanCardNo.length()>16){
										uploadBean.setLoanCardNo("");
									}else{
										uploadBean.setLoanCardNo(loanCardNo);
									}
									
									if(orgCode.length()>20){
										uploadBean.setOrgCode("");
									}else{
										uploadBean.setOrgCode(orgCode);
									}
									
									if(loanNo.length()>100){
										uploadBean.setLoanNo("");
									}else{
										uploadBean.setLoanNo(loanNo);
									}
									if(assureLoanCardNo.length()>16){
										uploadBean.setAssureLoanCardNo("");
									}else{
										uploadBean.setAssureLoanCardNo(assureLoanCardNo);
									}
									if(loanCardPass.length()>30){
										uploadBean.setLoanCardPass("");
									}else{
										uploadBean.setLoanCardPass(loanCardPass);
									}
									
									if(queryReason.length()>2){
										uploadBean.setQueryReason("");
									}else{
										uploadBean.setQueryReason(queryReason);
									}
									if(custType.length()>2){
										uploadBean.setCustType("");
									}else{
										uploadBean.setCustType(custType);
									}
									if(corpName.length()>60){
										uploadBean.setCorpName("");
									}else{
										uploadBean.setCorpName(corpName);
									}
									if(assureCorpName.length()>60){
										uploadBean.setAssureCorpName("");
									}else{
										uploadBean.setAssureCorpName(assureCorpName);
									}
									if(queryType.length()>2){
										uploadBean.setQueryType("");
									}else{
										uploadBean.setQueryType(queryType);
									}
									uploadBean.setDealQuery(dealQuery);
									list.add(uploadBean);
									}
								}
			        		 }
					is.close();
					hssfWorkbook.close();
					return list;
		}

			 
}	    
					    

