package com.huateng.ebank.business.customer.operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;


import oracle.jdbc.OracleConnection.CommitOption;

import org.apache.struts.upload.FormFile;

import resource.bean.basic.CorpCust;
import resource.bean.basic.IndApp;
import resource.bean.basic.IndScrubInfo;
import resource.bean.basic.InqCust;
import resource.bean.basic.TCorpApp;
import resource.bean.basic.IndUploadBean;
import resource.bean.basic.base.BaseIndApp;

import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.BatchIndService;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.utils.ReportUtils;

/**
 * 
 * Filename:LoanersMaintainInfoOperation.java Description:批量个人征信报告查询请求
 * Copyright:Copyright (c)2012 Company: HuaTeng
 */
public class BatchIndOperation extends BaseOperation {
    private static final HtLog htlog = HtLogFactory.getLogger(BatchIndOperation.class);
    public static final String ID = "customer.BatchIndOperation";
    public static final String CMD = "CMD";
	public static final Object CMD_TYPE_FILE = "CMD_TYPE_FILE";
	public static final String FLAG = "FLAG";
	public static final String IN_ORDER_FORMFILE = "IN_ORDER_FORMFILE";
    @Override
    public void beforeProc(OperationContext context) throws CommonException { }
    @SuppressWarnings({ "unchecked", "unused" })
    @Override
    public void execute(OperationContext context) throws CommonException {
        String cmd = (String) context.getAttribute(CMD);
        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
        BatchIndService batchService=new BatchIndService();
        //查询参数表 校验是否有人行查询记录 
        String paramVal=ReportUtils.getSysParamsValue("BATCH_IND", "BATCH_IND");
        Pattern pattern=Pattern.compile("[0-9]+");
		boolean bool=pattern.matcher(paramVal).matches();
		if(bool==false){
			context.setAttribute(BatchIndOperation.FLAG, bool);
			ExceptionUtil.throwCommonException("非紧急个人征信报告查询失效时限填写有误,请核对！");
		}
		//获取文件数组
        List<FormFile> files = (List<FormFile>)context.getAttribute(IN_ORDER_FORMFILE);
        for(int i=0;i<files.size()-1;i++){
        //获取excel文件
        FormFile excelFile=files.get(i);
        if(excelFile.toString().equals("")){
        	continue;
        }
        String excelfileName=excelFile.getFileName();
        //获取许可证文件
        FormFile uploadFile=files.get(10);
      	 //将文件存放在指定路径，获取文件存放全路径，
        String  fullUpPath=batchService.upFile(excelFile, uploadFile);
        String postfix= excelfileName.substring(excelfileName.lastIndexOf('.')).toLowerCase();
        //解析ecxel文件
		List<IndUploadBean> list=new ArrayList();
		//当excel文件版本是xlsx后缀结尾时
        if(".xlsx".equals(postfix)){
			try {
				List xlsxList=batchService.parseXlsx(excelFile);
				if(null != xlsxList && xlsxList.size()>0){
					list.addAll(xlsxList);
				}
			} catch (IOException e) {
				e.printStackTrace();
				ExceptionUtil.throwCommonException("解析excel文件失败！");
			}
		}else if(".xls".equals(postfix)){
			try {
				List xlsList=batchService.parseXls(excelFile);
				if(null != xlsList && xlsList.size()>0){
					list.addAll(xlsList);
				}
			} catch (IOException e) {
				e.printStackTrace();
				ExceptionUtil.throwCommonException("解析excel文件失败！");
			}
		}
        //获取当前时间
       Date inputTime=DateUtil.getCurrentTime();
      //取出IndScrubInfo的最大的batchId
        int newBatchId=batchService.getMaxBatchId()+1;
        int count = 0;
        	//遍历excel文件标题字段
        	for (IndUploadBean uploadBean : list) {
        		//证件类型
        		String idType=batchService.parseInType(uploadBean.getIdType());
        		if("null".equals(idType)){
        			idType="";
        		}
        		Pattern patteridType=Pattern.compile("[0-9]|X");
    			boolean boolidType=patteridType.matcher(idType).matches();
        		//证件号
        		String individualId =uploadBean.getIndividualId();
        		if("null".equals(individualId)){
        			individualId="";
        		}
        		//名称
        		String name =uploadBean.getName();
        		if("null".equals(name)){
        			name="";
        		}
        		//查询原因
        		String queryReason =batchService.parseQueryReason(uploadBean.getQueryReason());
        		if("null".equals(queryReason)){
        			queryReason="";
        		}
        		Pattern patterqueryReason=Pattern.compile("0[1-5]|08");
    			boolean boolQueryReason=patterqueryReason.matcher(queryReason).matches();
        		//Application_no
    			String applicationNo = uploadBean.getApplicationNo();
    			if("null".equals(applicationNo)){
    				applicationNo="";
        		}
    			//Loan_no
    			String loanNo = uploadBean.getLoanNo();
    			if("null".equals(loanNo)){
    				loanNo="";
        		}
    			//Relationship_no
    			String relationshipNo = uploadBean.getRelationshipNo();
    			if("null".equals(relationshipNo)){
    				relationshipNo="";
        		}
    			//客户属性
    			String inqCustType =batchService.parseInqCustType(uploadBean.getInqCustType());
    			if("null".equals(inqCustType)){
    				inqCustType="";
        		}
    			Pattern patterinqCustType=Pattern.compile("[1-3]");
    			boolean boolinqCustType=patterinqCustType.matcher(inqCustType).matches();
    			//被担保企业中征码
    			String relCorpId = uploadBean.getRelCorpId();
    			if("null".equals(relCorpId)){
    				relCorpId="";
        		}
    			//被担保企业名称
    			String corpName = uploadBean.getCorpName();
    			if("null".equals(corpName)){
    				corpName="";
        		}
    			//主借款人证件类型
    			String relCustIdType =batchService.parseInType(uploadBean.getRelCustIdType());
    			if("null".equals(relCustIdType)){
    				relCustIdType="";
        		}
    			boolean boolrelCustIdType = true;
    			if(!"".equals(relCustIdType)){
	    			Pattern patterrelCustIdType=Pattern.compile("[0-9]|X");
	    			boolrelCustIdType=patterrelCustIdType.matcher(relCustIdType).matches();
    			}
    			//主借款人证件号
    			String relCustId = uploadBean.getRelCustId();
    			if("null".equals(relCustId)){
    				relCustId="";
        		}
    			//主借款人名称
    			String relName =uploadBean.getRelName();
    			if("null".equals(relName)){
    				relName="";
        		}
    			if(count<list.size()){
    			count++;
    			//必填字段不许为空，出现空时 直接新增ind_scrub_info表
    			if(!"".equals(idType) && !"".equals(individualId) && !"".equals(name)
    					&& !"".equals(queryReason) && !"".equals(inqCustType) && boolQueryReason==true
    					&& boolidType==true && boolinqCustType==true && boolrelCustIdType==true &&
    					idType.length()<=2 && individualId.length()<=30 && name.length()<=60 && queryReason.length()<=2 && 
    					applicationNo.length()<=100 &&loanNo.length()<=100 && inqCustType.length()<=2 &&relCorpId.length()<=16 &&
    					corpName.length()<=50 && relCustIdType.length()<=2 && relCustId.length()<=50 && relName.length()<=60
    					&& queryReason.equals("01")){
    					//当客户属性为主借款人时
	    				if("2".equals(inqCustType)){
	    					//查询S天内 IndApp中是否有记录 如果没有新增IndApp、ind_scrub_info、inq_cust表
	    					//如果有新增ind_scrub_info、inq_cust表
	    					String idTyper=idType.contains("'")?idType.replaceAll("'", "''"):idType;
	    					String namer=name.contains("'")?name.replaceAll("'", "''"):name;
	    					String individualIdr=individualId.contains("'")?individualId.replaceAll("'", "''"):individualId;
	    					List<IndApp> listApp=batchService.getIndApp(idTyper, namer, individualIdr);
	    					if(null != listApp && listApp.size()>0){
	    							Date returnTime=listApp.get(0).getReturnTime();
	    							int id=listApp.get(0).getId();
	    							String rptId=listApp.get(0).getRptId();
	    								// 写入indScrubInfo表
	    								IndScrubInfo indScrubInfo=new IndScrubInfo();
	    								indScrubInfo.setAppId(id);
	    								indScrubInfo.setRptId(rptId);
	    								indScrubInfo.setBatchId(newBatchId);
	    								indScrubInfo.setLoanNo(loanNo);
	    								indScrubInfo.setStatus("2");
	    								indScrubInfo.setIndividual(individualId);
	    								indScrubInfo.setName(name);
	    								indScrubInfo.setIndividualType(idType);
	    								indScrubInfo.setQueryReason(queryReason);
	    								indScrubInfo.setCreateUser(globalinfo.getTlrno());
	    								indScrubInfo.setInputTime(inputTime);
	    								indScrubInfo.setApplicationNo(applicationNo);
	    								indScrubInfo.setRelationshipNo(relationshipNo);
	    								try {
	    									rootDAO.save2(indScrubInfo);
	    									htlog.info("写入indScrubInfo表成功！");
										} catch (Exception e) {
											e.printStackTrace();
											ExceptionUtil.throwCommonException("indScrubInfo表新增数据失败！");
										}
	    								
	    								// 写入inqCust表
	    								InqCust inqCust=new InqCust();
	    								inqCust.setInqCustAppid(id);//征信查询客户关联ind_app的id
    									inqCust.setInqCustName(name);//征信查询客户的名称
    									inqCust.setInqCustId(individualId);//征信查询客户的证件号
    									inqCust.setInqCustIdType(idType);//征信查询客户的证件类型
    									inqCust.setInqCustType(inqCustType);//征信查询客户的客户属性
    									inqCust.setQueryReason(queryReason);//查询原因
    									inqCust.setCreateTime(DateUtil.getCurrentTime());
    									inqCust.setCreateUser(globalinfo.getTlrno());
    									inqCust.setConsentFilePath(fullUpPath);
    									inqCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
    									inqCust.setInqType("0");//查询属性
	    								try {
	    									rootDAO.save2(inqCust);
	    									htlog.info("写入inqCust表成功！");
										} catch (Exception e) {
											e.printStackTrace();
											ExceptionUtil.throwCommonException("inqCust表新增数据失败！");
										}
	    					}else{
	    						// 写入indApp表
	    						IndApp indApp=new IndApp();
	    						indApp.setIndividualId(individualId);
	    						indApp.setIdType(idType);
	    						indApp.setName(name);
	    						indApp.setStatus("1");
	    						indApp.setType("0");
	    						indApp.setQueryReason(queryReason);
	    						indApp.setInputTime(DateUtil.getCurrentTime());
								indApp.setReturnTime(DateUtil.getCurrentTime());
								indApp.setQueryTime(DateUtil.getCurrentTime());
	    						int newId=(Integer)rootDAO.save2(indApp);
								htlog.info("写入indApp表成功！");
	    						
								// 写入indScrubInfo表
	    						IndScrubInfo indScrubInfo=new IndScrubInfo();
	    						indScrubInfo.setAppId(newId);
	    						indScrubInfo.setBatchId(newBatchId);
	    						indScrubInfo.setLoanNo(loanNo);
	    						indScrubInfo.setStatus("0");
	    						indScrubInfo.setApplicationNo(applicationNo);
	    						indScrubInfo.setRelationshipNo(relationshipNo);
	    						indScrubInfo.setIndividual(individualId);
								indScrubInfo.setName(name);
								indScrubInfo.setIndividualType(idType);
								indScrubInfo.setQueryReason(queryReason);
								indScrubInfo.setCreateUser(globalinfo.getTlrno());
								indScrubInfo.setInputTime(inputTime);
	    						try {
	    							rootDAO.save2(indScrubInfo);
									htlog.info("写入indScrubInfo表成功！");
	    						} catch (CommonException e) {
	    							e.printStackTrace();
	    							ExceptionUtil.throwCommonException("indScrubInfo表新增数据失败！");
	    						}
	    						
	    						InqCust inqCust=new InqCust();
	    						inqCust.setInqCustAppid(newId);//征信查询客户关联ind_app的id
								inqCust.setInqCustName(name);//征信查询客户的名称
								inqCust.setInqCustId(individualId);//征信查询客户的证件号
								inqCust.setInqCustIdType(idType);//征信查询客户的证件类型
								inqCust.setInqCustType(inqCustType);//征信查询客户的客户属性
								inqCust.setQueryReason(queryReason);//查询原因
								inqCust.setCreateTime(DateUtil.getCurrentTime());
								inqCust.setCreateUser(globalinfo.getTlrno());
								inqCust.setConsentFilePath(fullUpPath);
								inqCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
								inqCust.setInqType("0");//查询属性
	    						// 写入inqCust表
	    						try {
	    							rootDAO.save2(inqCust);
									htlog.info("写入inqCust表成功！");
	    						} catch (CommonException e) {
	    							e.printStackTrace();
	    							ExceptionUtil.throwCommonException("inqCust表新增数据失败！");
	    						}
	    					}
	    				//客户属性为担保人时
			    		}else if("1".equals(inqCustType)){
			    					//当中证码和企业名称不为空时
			    					if( !"".equals(relCorpId)  && !"".equals(corpName)){
			    					//根据中证码去查
			    				    String relCorpIdr=relCorpId.contains("'")?relCorpId.replaceAll("'", "''"):relCorpId;
			    				    String corpNamer=corpName.contains("'")?corpName.replaceAll("'", "''"):corpName;
			    					List<CorpCust> listCorpCust=batchService.querycorpCust(relCorpIdr, corpNamer);
			    					if(null != listCorpCust && listCorpCust.size()>0){
			    						List<IndApp> listApp=batchService.getIndApp(idType, name, individualId);
			    							if(null != listApp && listApp.size()>0){
			    									int id=listApp.get(0).getId();
			    									String rptId=listApp.get(0).getRptId();
			    										// 写入indScrubInfo表
			        									IndScrubInfo indScrubInfo=new IndScrubInfo();
			        									indScrubInfo.setAppId(id);
			        									indScrubInfo.setRptId(rptId);
			        									indScrubInfo.setBatchId(newBatchId);
			        									indScrubInfo.setLoanNo(loanNo);
			        									indScrubInfo.setStatus("2");
			        									indScrubInfo.setApplicationNo(applicationNo);
			        									indScrubInfo.setRelationshipNo(relationshipNo);
			        									indScrubInfo.setIndividual(individualId);
			    	    								indScrubInfo.setName(name);
			    	    								indScrubInfo.setIndividualType(idType);
			    	    								indScrubInfo.setQueryReason(queryReason);
			    	    								indScrubInfo.setCreateUser(globalinfo.getTlrno());
			    	    								indScrubInfo.setInputTime(inputTime);
			        									try {
			        										rootDAO.save2(indScrubInfo);
			        										htlog.info("写入indScrubInfo表成功！");
			        		    						} catch (CommonException e) {
			        		    							e.printStackTrace();
			        		    							ExceptionUtil.throwCommonException("indScrubInfo表新增数据失败！");
			        		    						}
			        									
			        									// 写入inqCust表
			        									InqCust inqCust=new InqCust();
			        									inqCust.setInqCustAppid(id);//征信查询客户关联ind_app的id
			        									inqCust.setInqCustName(name);//征信查询客户的名称
			        									inqCust.setInqCustId(individualId);//征信查询客户的证件号
			        									inqCust.setInqCustIdType(idType);//征信查询客户的证件类型
			        									inqCust.setInqCustType(inqCustType);//征信查询客户的客户属性
			        									inqCust.setCustId(listCorpCust.get(0).getId());//征信查询客户关联inq_cust、corp_cust的id
			        									inqCust.setRelCorpId(relCorpId);//关联客户中征码（企业时填写）
			        									inqCust.setRelName(corpName);//关联客户的名称（个人或企业）
			        									inqCust.setRelCustId(relCustId);//关联客户证件号（个人时填写）
			        									inqCust.setRelCustIdType(relCustIdType);//关联客户证件类型（个人时填写）
			        									inqCust.setQueryReason(queryReason);//查询原因
			        									inqCust.setCreateTime(DateUtil.getCurrentTime());
			        									inqCust.setCreateUser(globalinfo.getTlrno());
			        									inqCust.setConsentFilePath(fullUpPath);
			        									inqCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
			        									inqCust.setInqType("0");//查询属性
			        									
			        									rootDAO.save2(inqCust);
			    							}else{
			    								IndApp indApp=new IndApp();
	        		    						indApp.setIndividualId(individualId);
	        		    						indApp.setIdType(idType);
	        		    						indApp.setName(name);
	        		    						indApp.setStatus("1");
	        		    						indApp.setType("0");
	        		    						indApp.setQueryReason(queryReason);
	        		    						indApp.setInputTime(DateUtil.getCurrentTime());
	        									indApp.setReturnTime(DateUtil.getCurrentTime());
	        									indApp.setQueryTime(DateUtil.getCurrentTime());
	        		    						// 写入indApp表
	        		    						int newId=(Integer) rootDAO.save(indApp);
        										htlog.info("写入indApp表成功！");
	        		    						
        										// 写入indScrubInfo表
	        									IndScrubInfo indScrubInfo=new IndScrubInfo();
	        									indScrubInfo.setAppId(newId);
	        									indScrubInfo.setBatchId(newBatchId);
	        									indScrubInfo.setLoanNo(loanNo);
	        									indScrubInfo.setStatus("0");
	        									indScrubInfo.setApplicationNo(applicationNo);
	        									indScrubInfo.setRelationshipNo(relationshipNo);
	        									indScrubInfo.setIndividual(individualId);
	    	    								indScrubInfo.setName(name);
	    	    								indScrubInfo.setIndividualType(idType);
	    	    								indScrubInfo.setQueryReason(queryReason);
	    	    								indScrubInfo.setCreateUser(globalinfo.getTlrno());
	    	    								indScrubInfo.setInputTime(inputTime);
	        									try {
	        										rootDAO.save2(indScrubInfo);
	        										htlog.info("写入indScrubInfo表成功！");
	        		    						} catch (CommonException e) {
	        		    							e.printStackTrace();
	        		    							ExceptionUtil.throwCommonException("indScrubInfo表新增数据失败！");
	        		    						}
	        									
	        									// 写入inqCust表
	        									InqCust inqCust=new InqCust();
	        									inqCust.setInqCustAppid(newId);//征信查询客户关联ind_app的id
	        									inqCust.setInqCustName(name);//征信查询客户的名称
	        									inqCust.setInqCustId(individualId);//征信查询客户的证件号
	        									inqCust.setInqCustIdType(idType);//征信查询客户的证件类型
	        									inqCust.setInqCustType(inqCustType);//征信查询客户的客户属性
	        									inqCust.setCustId(listCorpCust.get(0).getId());//征信查询客户关联inq_cust、corp_cust的id
	        									inqCust.setRelCorpId(relCorpId);//关联客户中征码（企业时填写）
	        									inqCust.setRelName(corpName);//关联客户的名称（个人或企业）
	        									inqCust.setRelCustId(relCustId);//关联客户证件号（个人时填写）
	        									inqCust.setRelCustIdType(relCustIdType);//关联客户证件类型（个人时填写）
	        									inqCust.setQueryReason(queryReason);//查询原因
	        									inqCust.setCreateTime(DateUtil.getCurrentTime());
	        									inqCust.setCreateUser(globalinfo.getTlrno());
	        									inqCust.setConsentFilePath(fullUpPath);
	        									inqCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
	        									inqCust.setInqType("0");//查询属性
	        									try {
	        										rootDAO.save2(inqCust);
	        										htlog.info("写入inqCust表成功！");
	        		    						} catch (CommonException e) {
	        		    							e.printStackTrace();
	        		    							ExceptionUtil.throwCommonException("inqCust表新增数据失败！");
	        		    						}
			    							}
			    					}else{
			    						//写入indScrubInfo表
			    						IndScrubInfo indScrubInfo=new IndScrubInfo();
			    						indScrubInfo.setStatus("1");       
			    						indScrubInfo.setBatchId(newBatchId);
			    						indScrubInfo.setLoanNo(loanNo);
			    						indScrubInfo.setApplicationNo(applicationNo);
			    						indScrubInfo.setRelationshipNo(relationshipNo);
			    						indScrubInfo.setIndividual(individualId);
	    								indScrubInfo.setName(name);
	    								indScrubInfo.setIndividualType(idType);
	    								indScrubInfo.setQueryReason(queryReason);
	    								indScrubInfo.setCreateUser(globalinfo.getTlrno());
	    								indScrubInfo.setInputTime(inputTime);
	    								try {
	    									rootDAO.save2(indScrubInfo);
    										htlog.info("写入inqCust表成功！");
    		    						} catch (CommonException e) {
    		    							e.printStackTrace();
    		    							ExceptionUtil.throwCommonException("inqCust表新增数据失败！");
    		    						}
			    					}
		    					}else{
		    						//写入indScrubInfo表
		    						IndScrubInfo indScrubInfo=new IndScrubInfo();
		    						indScrubInfo.setStatus("1");       
		    						indScrubInfo.setBatchId(newBatchId);
		    						indScrubInfo.setLoanNo(loanNo);
		    						indScrubInfo.setApplicationNo(applicationNo);
		    						indScrubInfo.setRelationshipNo(relationshipNo);
		    						indScrubInfo.setIndividual(individualId);
    								indScrubInfo.setName(name);
    								indScrubInfo.setIndividualType(idType);
    								indScrubInfo.setQueryReason(queryReason);
    								indScrubInfo.setCreateUser(globalinfo.getTlrno());
    								indScrubInfo.setInputTime(inputTime);
		    						try {
		    							rootDAO.save2(indScrubInfo);
										htlog.info("写入indScrubInfo表成功！");
		    						} catch (CommonException e) {
		    							e.printStackTrace();
		    							ExceptionUtil.throwCommonException("indScrubInfo表新增数据失败！");
		    						}
		    					}
			    			//当客户属性为共同借款人时
				    		}else if("3".equals(inqCustType)){
		    					if(!"".equals(relCustIdType) && !"".equals(relCustId) && !"".equals(relName)){
		    					String relNamer=relName.contains("'")?relName.replaceAll("'", "''"):relName;
		    					String relCustIdr=relCustId.contains("'")?relCustId.replaceAll("'", "''"):relCustId;
		    					String relCustIdTyper=relCustIdType.contains("'")?relCustIdType.replaceAll("'", "''"):relCustIdType;
		    					List<InqCust> listInqcust=batchService.getInqCustQuery(relNamer, relCustIdr, relCustIdTyper);
		    					if(null != listInqcust && listInqcust.size()>0){
		    						    String namer=name.contains("'")?name.replaceAll("'", "''"):name;
		    						    String individualIdr=individualId.contains("'")?individualId.replaceAll("'", "''"):individualId;
		    							List<IndApp> listapp=batchService.getIndApp(idType, namer, individualIdr);
		    							if(null != listapp && listapp.size()>0){
		    										// 写入inqCust表
				    								InqCust inqCust=new InqCust();
				    								inqCust.setInqCustAppid(listapp.get(0).getId());//征信查询客户关联ind_app的id
				    								inqCust.setInqCustName(name);//征信查询客户的名称
				    								inqCust.setInqCustId(individualId);//征信查询客户的证件号
				    								inqCust.setInqCustIdType(idType);//征信查询客户的证件类型
				    								inqCust.setInqCustType(inqCustType);//征信查询客户的客户属性
				    								inqCust.setCustId(listInqcust.get(0).getId());//征信查询客户关联inq_cust、corp_cust的id
				    								inqCust.setRelCustId(relCustId);//关联客户证件号（个人时填写）
				    								inqCust.setRelName(relName);//关联客户的名称（个人或企业）
				    								inqCust.setRelCorpId(relCorpId);//关联客户中征码（企业时填写）
				    								inqCust.setQueryReason(queryReason);//查询原因
				    								inqCust.setRelCustIdType(relCustIdType);//关联客户证件类型（个人时填写）
				    								inqCust.setCreateTime(DateUtil.getCurrentTime());
				    								inqCust.setCreateUser(globalinfo.getTlrno());
				    								inqCust.setConsentFilePath(fullUpPath);
				    								inqCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
				    								inqCust.setInqType("0");//查询属性
				    								try {
				    									rootDAO.save2(inqCust);
														htlog.info("写入inqCust表成功！");
						    						} catch (CommonException e) {
						    							e.printStackTrace();
						    							ExceptionUtil.throwCommonException("inqCust表新增数据失败！");
						    						}
				    								//写入indScrubInfo表
				    								IndScrubInfo indScrubInfo=new IndScrubInfo();
				    								indScrubInfo.setAppId(listapp.get(0).getId());
						    						indScrubInfo.setStatus("2");       
						    						indScrubInfo.setBatchId(newBatchId);
						    						indScrubInfo.setLoanNo(loanNo);
						    						indScrubInfo.setApplicationNo(applicationNo);
						    						indScrubInfo.setRelationshipNo(relationshipNo);
						    						indScrubInfo.setIndividual(individualId);
				    								indScrubInfo.setName(name);
				    								indScrubInfo.setIndividualType(idType);
				    								indScrubInfo.setQueryReason(queryReason);
				    								indScrubInfo.setCreateUser(globalinfo.getTlrno());
				    								indScrubInfo.setInputTime(inputTime);
				    								try {
				    									rootDAO.save2(indScrubInfo);
														htlog.info("写入indScrubInfo表成功！");
						    						} catch (CommonException e) {
						    							e.printStackTrace();
						    							ExceptionUtil.throwCommonException("indScrubInfo表新增数据失败！");
						    						}
		    						}else{
		    							// 写入indApp表
		    							IndApp indApp=new IndApp();
	    								indApp.setIndividualId(individualId);
	    								indApp.setIdType(idType);
	    								indApp.setName(name);
	    								indApp.setStatus("1");
	    								indApp.setType("0");
	    								indApp.setQueryReason(queryReason);
	    								indApp.setQueryReason(queryReason);
	    								indApp.setInputTime(DateUtil.getCurrentTime());
	    								indApp.setReturnTime(DateUtil.getCurrentTime());
	    								indApp.setQueryTime(DateUtil.getCurrentTime());
	    								int newId=(Integer) rootDAO.save2(indApp);
										htlog.info("写入indScrubInfo表成功！");
										
										// 写入inqCust表
	    								InqCust inqCust=new InqCust();
	    								inqCust.setInqCustAppid(newId);
	    								inqCust.setInqCustName(name);
	    								inqCust.setInqCustId(individualId);
	    								inqCust.setInqCustIdType(idType);
	    								inqCust.setInqCustType(inqCustType);
	    								inqCust.setCustId(listInqcust.get(0).getId());
	    								inqCust.setRelCustId(relCustId);
	    								inqCust.setRelName(relName);
	    								inqCust.setRelCorpId(relCorpId);
	    								inqCust.setQueryReason(queryReason);
	    								inqCust.setRelCustIdType(relCustIdType);
	    								inqCust.setCreateTime(DateUtil.getCurrentTime());
	    								inqCust.setCreateUser(globalinfo.getTlrno());
	    								inqCust.setConsentFilePath(fullUpPath);
	    								inqCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
	    								inqCust.setInqType("0");
	    								try {
	    									rootDAO.save2(inqCust);
											htlog.info("写入inqCust表成功！");
			    						} catch (CommonException e) {
			    							e.printStackTrace();
			    							ExceptionUtil.throwCommonException("inqCust表新增数据失败！");
			    						}
	    								
	    								//写入indScrubInfo表
	    								IndScrubInfo indScrubInfo=new IndScrubInfo();
			    						indScrubInfo.setStatus("0");       
			    						indScrubInfo.setAppId(newId);
			    						indScrubInfo.setBatchId(newBatchId);
			    						indScrubInfo.setLoanNo(loanNo);
			    						indScrubInfo.setApplicationNo(applicationNo);
			    						indScrubInfo.setRelationshipNo(relationshipNo);
			    						indScrubInfo.setIndividual(individualId);
	    								indScrubInfo.setName(name);
	    								indScrubInfo.setIndividualType(idType);
	    								indScrubInfo.setQueryReason(queryReason);
	    								indScrubInfo.setCreateUser(globalinfo.getTlrno());
	    								indScrubInfo.setInputTime(inputTime);
	    								try {
	    									rootDAO.save2(indScrubInfo);
											htlog.info("写入indScrubInfo表成功！");
			    						} catch (CommonException e) {
			    							e.printStackTrace();
			    							ExceptionUtil.throwCommonException("indScrubInfo表新增数据失败！");
			    						}
		    						}
		    					}else{
		    						//写入indScrubInfo表
		    						IndScrubInfo indScrubInfo=new IndScrubInfo();
		    						indScrubInfo.setStatus("1");       
		    						indScrubInfo.setBatchId(newBatchId);
		    						indScrubInfo.setLoanNo(loanNo);
		    						indScrubInfo.setApplicationNo(applicationNo);
		    						indScrubInfo.setRelationshipNo(relationshipNo);
		    						indScrubInfo.setIndividual(individualId);
    								indScrubInfo.setName(name);
    								indScrubInfo.setIndividualType(idType);
    								indScrubInfo.setQueryReason(queryReason);
    								indScrubInfo.setCreateUser(globalinfo.getTlrno());
    								indScrubInfo.setInputTime(inputTime);
    								try {
    									rootDAO.save2(indScrubInfo);
										htlog.info("写入indScrubInfo表成功！");
		    						} catch (CommonException e) {
		    							e.printStackTrace();
		    							ExceptionUtil.throwCommonException("indScrubInfo表新增数据失败！");
		    						}
		    						
		    					}
		    				}else{
		    					//写入indScrubInfo表
		    					IndScrubInfo indScrubInfo=new IndScrubInfo();
		        				indScrubInfo.setStatus("1");
		        				indScrubInfo.setBatchId(newBatchId);
		        				indScrubInfo.setLoanNo(loanNo);
		        				indScrubInfo.setApplicationNo(applicationNo);
		        				indScrubInfo.setRelationshipNo(relationshipNo);
		        				indScrubInfo.setIndividual(individualId);
								indScrubInfo.setName(name);
								indScrubInfo.setIndividualType(idType);
								indScrubInfo.setQueryReason(queryReason);
								indScrubInfo.setCreateUser(globalinfo.getTlrno());
								indScrubInfo.setInputTime(inputTime);
								try {
									rootDAO.save2(indScrubInfo);
									htlog.info("写入indScrubInfo表成功！");
	    						} catch (CommonException e) {
	    							e.printStackTrace();
	    							ExceptionUtil.throwCommonException("indScrubInfo表新增数据失败！");
	    						}
		        				
		    				}
		    		  }
    			}else{
    				//写入indScrubInfo表
    				IndScrubInfo indScrubInfo=new IndScrubInfo();
    				indScrubInfo.setStatus("1");
    				indScrubInfo.setBatchId(newBatchId);
    				indScrubInfo.setLoanNo(loanNo);
    				indScrubInfo.setApplicationNo(applicationNo);
    				indScrubInfo.setRelationshipNo(relationshipNo);
    				indScrubInfo.setIndividual(individualId);
					indScrubInfo.setName(name);
					indScrubInfo.setIndividualType(idType);
					indScrubInfo.setQueryReason(queryReason);
					indScrubInfo.setCreateUser(globalinfo.getTlrno());
					indScrubInfo.setInputTime(inputTime);
					try {
						rootDAO.save2(indScrubInfo);
						htlog.info("写入indScrubInfo表成功！");
					} catch (CommonException e) {
						e.printStackTrace();
						ExceptionUtil.throwCommonException("indScrubInfo表新增数据失败！");
					}
    			}
    		}
    	}
        	}
    }
    @Override
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
    }
}
