package com.huateng.ebank.business.customer.operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;



import org.apache.struts.upload.FormFile;

import resource.bean.basic.CorpCust;
import resource.bean.basic.CorpScurbInfo;
import resource.bean.basic.TCorpApp;
import resource.bean.basic.TCorpDetailApp;
import resource.bean.basic.TCorpUploadBean;

import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.BatchCorpService;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.utils.ReportUtils;

/**
 * 
 * Filename:LoanersMaintainInfoOperation.java Description:批量企业征信报告查询请求
 * Copyright:Copyright (c)2012 Company: HuaTeng
 */
public class BatchCorpOperation extends BaseOperation {
    private static final HtLog htlog = HtLogFactory.getLogger(BatchCorpOperation.class);
    public static final String ID = "customer.BatchCorpOperation";
    public static final String CMD = "CMD";
	public static final Object CMD_TYPE_FILE = "CMD_TYPE_FILE";
	public static final String IN_ORDER_FORMFILE = "IN_ORDER_FORMFILE";
	public static final String FLAG="FLAG";
    @Override
    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    @SuppressWarnings({ "unchecked", "unused" })
    @Override
    public void execute(OperationContext context) throws CommonException {
    	System.out.println("BatchCorpOperation start!!");
        String cmd = (String) context.getAttribute(CMD);
        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
        BatchCorpService batchService=new BatchCorpService();
        
        //查询参数表是否有人行查询记录
        String paramVal=ReportUtils.getSysParamsValue("BATCH_CORP", "BATCH_CORP");
        Pattern pattern=Pattern.compile("[0-9]+");
		boolean bool=pattern.matcher(paramVal).matches();
		if(bool==false){
			context.setAttribute(BatchCorpOperation.FLAG, bool);
			ExceptionUtil.throwCommonException("非紧急企业征信报告查询失效时限填写有误,请核对！");
		}
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
		List<TCorpUploadBean> list=new ArrayList();
        if(".xlsx".equals(postfix)){
			try {
				List xlsxList=batchService.parseXlsx(excelFile);
				if(null != xlsxList && xlsxList.size()>0){
					list.addAll(xlsxList);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(".xls".equals(postfix)){
			try {
				List xlsList=batchService.parseXls(excelFile);
				if(null != xlsList && xlsList.size()>0){
					list.addAll(xlsList);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        //获取当前时间
        Date inputTime=DateUtil.getCurrentTime();
      //取出corp_scurb_info的最大的batchId
        System.out.println("start query corp_scurb_info!!!");
        int newBatchId=batchService.getMaxBatchId()+1;
        System.out.println("end query corp_scurb_info!!!");
        	int count = 0;
        	for (TCorpUploadBean uploadBean : list) {
        		
        	    //贷款卡号码/中征码
        		String loanCardNo=uploadBean.getLoanCardNo();
        		if("null".equals(loanCardNo)){
        			loanCardNo="";
        		}
        	    //贷款卡密码
				String loanCardPass =uploadBean.getLoanCardPass();
        		if("null".equals(loanCardPass)){
        			loanCardPass="";
        		}
        		//贷款公司名称
        		String corpName =uploadBean.getCorpName();
        		if("null".equals(corpName)){
        			corpName="";
        		}
        		//注册机构号
        		String orgCode =uploadBean.getOrgCode();
        		if("null".equals(orgCode)){
        			orgCode="";
        		}
        		//loan_no
    			String loanNo = uploadBean.getLoanNo();
    			if("null".equals(loanNo)){
    				loanNo="";
        		}
    			//查询类型
    			String queryType = uploadBean.getQueryType();
    			if("null".equals(queryType)){
    				queryType="";
        		}
    			Pattern patterqueryType=Pattern.compile("[1-2]");
    			boolean boolqueryType=patterqueryType.matcher(queryType).matches();
    			//查询原因
    			String queryReason =uploadBean.getQueryReason();
    			if("null".equals(queryReason)){
    				queryReason="";
        		}
    			Pattern patterqueryReason=Pattern.compile("0[1-5]|08");
    			boolean boolQueryReason=patterqueryReason.matcher(queryReason).matches();
    			//客户属性
    			String custType = uploadBean.getCustType();
    			if("null".equals(custType)){
    				custType="";
        		}
    			Pattern pattercustType=Pattern.compile("[1-2]");
    			boolean boolcustType=pattercustType.matcher(custType).matches();
    			//担保公司中征码
    			String assureLoanCardNo = uploadBean.getAssureLoanCardNo();
    			if("null".equals(assureLoanCardNo)){
    				assureLoanCardNo="";
        		}
    			//担保公司名称
    			String assureCorpName =uploadBean.getAssureCorpName();
    			if("null".equals(assureCorpName)){
    				assureCorpName="";
        		}
    			//是否进行明细查询
    			String dealQuery = uploadBean.getDealQuery();
    			if("null".equals(dealQuery)){
    				dealQuery="";
        		}
    			Pattern patterdealQuery=Pattern.compile("[01]");
    			boolean booldealtag=patterdealQuery.matcher(dealQuery).matches();
    			boolean booldealQuery=false;
    			if(booldealtag){
    				if(dealQuery=="1"){
    					booldealQuery=true;
    				}
    			}
    			System.out.println("=========dealQuery========="+dealQuery+"=================");
    			System.out.println("=========custType=========="+custType+"===================");
    			System.out.println(booldealQuery);
    			System.out.println("end dealQuery");
    			try{
    			if(count<list.size()){
    				System.out.println("++++++++list is not null！！！+++++++");
    					count++;
    					//若必填项不为空时
		    			if(!"".equals(loanCardNo) && !"".equals(loanCardPass) && !"".equals(corpName) && !"".equals(dealQuery)
		    					&& !"".equals(queryType) && !"".equals(queryReason)  && !"".equals(custType) && boolQueryReason == true  
		    					&& booldealtag == true && boolcustType == true && boolqueryType==true && loanCardNo.length()<=16 &&
				  				loanCardPass.length()<=30 && corpName.length()<=50 && orgCode.length()<=20 && loanNo.length()<=100 &&
								queryType.length()<=2 && queryReason.length()<=2 && custType.length()<=2 && assureLoanCardNo.length()<=16 &&
								 assureCorpName.length()<=50 && queryReason.equals("03")){
		    				System.out.println("********************must is not null!!! ************************");
			    					//当客户属性为1-借款公司时  根据贷款卡号码/中征码查tcorpapp
		    				if("0".equals(dealQuery)){
				    					if("1".equals(custType)){
//				    							if(!"".equals(assureLoanCardNo) && !"".equals(assureCorpName)){
							    						//查询S天内有无TCorpApp数据
							    						List<TCorpApp> listTCorpApp=batchService.getTCorpApp(loanCardNo);
							    						System.out.println("listTCorpApp is null or not null!!!");
							    						System.out.println(null != listTCorpApp && listTCorpApp.size()>0);
								    					if(null != listTCorpApp && listTCorpApp.size()>0){
								    										//取TCorpApp id表 corpcust corpScrubInfo
								    										int id=listTCorpApp.get(0).getId();
								    										String rptKey=listTCorpApp.get(0).getRptKey();
								    										//向CorpCust表插入数据
								    										CorpCust corpCust=new CorpCust();
								    										corpCust.setCorpCustAppid(id); //征信查询客户关联t_corp_app的id
								    										corpCust.setCorpCustLoancard(loanCardNo);//征信查询的中证码
								    										corpCust.setCorpCustPswd(loanCardPass);//征信查询的贷款密码
								    										corpCust.setCorpCustCompanyname(corpName);//征信查询客户的名称
								    										corpCust.setQueryReason(queryReason);
								    										corpCust.setCorpCustType(custType);//征信查询客户的客户属性
//								    										corpCust.setRelCustId();//征信查询客户关联inq_cust、corp_cust的id
//								    										corpCust.setRelName(assureCorpName);//关联客户的名称（个人或企业）
//								    										corpCust.setRelCorpId(assureLoanCardNo);//关联客户中征码（企业时填写）
								    										corpCust.setCreateTime(DateUtil.getCurrentTime());
								    										corpCust.setCreateUser(globalinfo.getTlrno());
								    										corpCust.setConsentFilePath(fullUpPath);
								    										corpCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
								    										corpCust.setInqType("0");
								    										corpCust.setDetailFlag("2");
								    										try {
								    											rootDAO.save2(corpCust);
								    			    						} catch (CommonException e) {
								    			    							e.printStackTrace();
								    			    							ExceptionUtil.throwCommonException("corpCust表新增数据失败！");
								    			    						}
								    										
								    										//向corpScrubInfo表插入数据
								    										CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
								    										corpScrubInfo.setAppId(id);
								    										corpScrubInfo.setBatchId(newBatchId);
								    										corpScrubInfo.setRptKey(rptKey);
								    										corpScrubInfo.setName(corpName);
								    										corpScrubInfo.setLoancard(loanCardNo);
								    										corpScrubInfo.setPassword(loanCardPass);
								    										corpScrubInfo.setOrgcode(orgCode);
								    										corpScrubInfo.setLoanNo(loanNo);
								    										corpScrubInfo.setQueryReason(queryReason);
								    										corpScrubInfo.setCreateUser(globalinfo.getTlrno());
								    										corpScrubInfo.setInputTime(inputTime);
								    										corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
								    										corpScrubInfo.setStatus("2");
								    										try {
								    											rootDAO.save2(corpScrubInfo);
								    			    						} catch (CommonException e) {
								    			    							e.printStackTrace();
								    			    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
								    			    						}
								    					}else{
								    						//向tcorpApp表新增一条数据集	
								    						TCorpApp tcorpApp=new TCorpApp();
								    						tcorpApp.setBatchId(newBatchId);
								    						tcorpApp.setRptKey("-");
								    						tcorpApp.setLoanCardNo(loanCardNo);
								    						tcorpApp.setLoanCardPass(loanCardPass);
								    						tcorpApp.setQueryReason(ruturnQueryReason(queryReason));
								    						tcorpApp.setType("0");
								    						tcorpApp.setStatus("1");
//								    						tcorpApp.setStatusMsg(statusMsg);
								    						tcorpApp.setCreateTime(DateUtil.getCurrentTime());
								    						tcorpApp.setInputTime(DateUtil.getCurrentTime());
								    						tcorpApp.setReturnTime(DateUtil.getCurrentTime());
								    						tcorpApp.setParsedTime(DateUtil.getCurrentTime());
								    						tcorpApp.setQueryTime(DateUtil.getCurrentTime());
								    						int newId=(Integer) rootDAO.save2(tcorpApp);
								    						
								    						//向CorpCust表插入数据
				    										CorpCust corpCust=new CorpCust();
				    										corpCust.setCorpCustAppid(newId); //征信查询客户关联t_corp_app的id
				    										corpCust.setCorpCustLoancard(loanCardNo);//征信查询的中证码
				    										corpCust.setCorpCustPswd(loanCardPass);//征信查询的贷款密码
				    										corpCust.setCorpCustCompanyname(corpName);//征信查询客户的名称
				    										corpCust.setQueryReason(queryReason);
				    										corpCust.setCorpCustType(custType);//征信查询客户的客户属性
//				    										corpCust.setRelCustId();//征信查询客户关联inq_cust、corp_cust的id
//				    										corpCust.setRelName(assureCorpName);//关联客户的名称（个人或企业）
//				    										corpCust.setRelCorpId(assureLoanCardNo);//关联客户中征码（企业时填写）
				    										corpCust.setCreateTime(DateUtil.getCurrentTime());
				    										corpCust.setCreateUser(globalinfo.getTlrno());
				    										corpCust.setConsentFilePath(fullUpPath);
				    										corpCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
				    										corpCust.setInqType("0");
				    										corpCust.setDetailFlag("2");
				    										try {
				    											rootDAO.save2(corpCust);
				    			    						} catch (CommonException e) {
				    			    							e.printStackTrace();
				    			    							ExceptionUtil.throwCommonException("corpCust表新增数据失败！");
				    			    						}
				    										
				    										//向corpScrubInfo表插入数据
				    										CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
				    										corpScrubInfo.setAppId(newId);
				    										corpScrubInfo.setBatchId(newBatchId);
//				    										corpScrubInfo.setRptKey(rptKey);
				    										corpScrubInfo.setName(corpName);
				    										corpScrubInfo.setLoancard(loanCardNo);
				    										corpScrubInfo.setPassword(loanCardPass);
				    										corpScrubInfo.setOrgcode(orgCode);
				    										corpScrubInfo.setLoanNo(loanNo);
				    										corpScrubInfo.setQueryReason(queryReason);
				    										corpScrubInfo.setCreateUser(globalinfo.getTlrno());
				    										corpScrubInfo.setInputTime(inputTime);
				    										corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
				    										corpScrubInfo.setStatus("0");
				    										try {
				    											rootDAO.save2(corpScrubInfo);
				    			    						} catch (CommonException e) {
				    			    							e.printStackTrace();
				    			    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
				    			    						}
								    					}
//				    							}
				    					}else if("2".equals(custType)){
				    						if(!"".equals(assureLoanCardNo) && !"".equals(assureCorpName)){
				    								List<CorpCust> listCorpCust=batchService.querycorpCust(assureLoanCardNo, assureCorpName);
				    								//判断CorpCust有无该条记录 如果有取其id
				    								if(null != listCorpCust && listCorpCust.size()>0){
				    											//corpCust的id
				    											int id=listCorpCust.get(0).getId();
				    											List<TCorpApp> listTcorpApp=batchService.getTCorpApp(loanCardNo);
				    												//判断TCorpApp表有无S天内该条记录 如果有取其id
				    												if(null != listTcorpApp && listTcorpApp.size()>0){
				    														//TCorpApp的id
				    														int corpId=listTcorpApp.get(0).getId();
				    														String rptkey=listTcorpApp.get(0).getRptKey();
				    														
				    														//向CorpCust表插入数据
								    										CorpCust corpCust=new CorpCust();
								    										corpCust.setCorpCustAppid(corpId); //征信查询客户关联t_corp_app的id
								    										corpCust.setCorpCustLoancard(loanCardNo);//征信查询的中证码
								    										corpCust.setCorpCustPswd(loanCardPass);//征信查询的贷款密码
								    										corpCust.setCorpCustCompanyname(corpName);//征信查询客户的名称
								    										corpCust.setQueryReason(queryReason);
								    										corpCust.setCustId(id);
								    										corpCust.setCorpCustType(custType);//征信查询客户的客户属性
								    										corpCust.setCustId(id);//征信查询客户关联inq_cust、corp_cust的id
								    										corpCust.setRelName(assureCorpName);//关联客户的名称（个人或企业）
								    										corpCust.setRelCorpId(assureLoanCardNo);//关联客户中征码（企业时填写）
								    										corpCust.setCreateTime(DateUtil.getCurrentTime());
								    										corpCust.setCreateUser(globalinfo.getTlrno());
								    										corpCust.setConsentFilePath(fullUpPath);
								    										corpCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
								    										corpCust.setInqType("0");
								    										corpCust.setDetailFlag("2");
								    										try {
								    											rootDAO.save2(corpCust);
								    			    						} catch (CommonException e) {
								    			    							e.printStackTrace();
								    			    							ExceptionUtil.throwCommonException("corpCust表新增数据失败！");
								    			    						}
								    										//向corpScrubInfo表插入数据
								    										CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
								    										corpScrubInfo.setAppId(corpId);
								    										corpScrubInfo.setBatchId(newBatchId);
								    										corpScrubInfo.setRptKey(rptkey);
								    										corpScrubInfo.setName(corpName);
								    										corpScrubInfo.setLoancard(loanCardNo);
								    										corpScrubInfo.setPassword(loanCardPass);
								    										corpScrubInfo.setOrgcode(orgCode);
								    										corpScrubInfo.setLoanNo(loanNo);
								    										corpScrubInfo.setQueryReason(queryReason);
								    										corpScrubInfo.setCreateUser(globalinfo.getTlrno());
								    										corpScrubInfo.setInputTime(inputTime);
								    										corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
								    										corpScrubInfo.setStatus("2");
								    										try {
									    										rootDAO.save2(corpScrubInfo);
								    			    						} catch (CommonException e) {
								    			    							e.printStackTrace();
								    			    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
								    			    						}
								    										
				    												}else{
				    													//判断TCorpApp表有无S天内该条记录 如果无 新增tcorpApp记录 取其id 同时新增corpScrubInfo、corpCust表
				    													//向tcorpApp表新增一条数据集	
											    						TCorpApp tcorpApp=new TCorpApp();
											    						tcorpApp.setBatchId(newBatchId);
											    						tcorpApp.setRptKey("-");
											    						tcorpApp.setLoanCardNo(loanCardNo);
											    						tcorpApp.setLoanCardPass(ruturnQueryReason(loanCardPass));
											    						tcorpApp.setQueryReason(queryReason);
											    						tcorpApp.setType("0");
											    						tcorpApp.setStatus("1");
//											    						tcorpApp.setStatusMsg(statusMsg);
											    						tcorpApp.setCreateTime(DateUtil.getCurrentTime());
											    						tcorpApp.setInputTime(DateUtil.getCurrentTime());
											    						tcorpApp.setReturnTime(DateUtil.getCurrentTime());
											    						tcorpApp.setParsedTime(DateUtil.getCurrentTime());
											    						tcorpApp.setQueryTime(DateUtil.getCurrentTime());
											    						//新增该条记录到tcorpApp表 并取其id
											    						int newId=(Integer) rootDAO.save2(tcorpApp);
						    											
											    						//向CorpCust表插入数据
							    										CorpCust corpCust=new CorpCust();
							    										corpCust.setCorpCustAppid(newId); //征信查询客户关联t_corp_app的id
							    										corpCust.setCorpCustLoancard(loanCardNo);//征信查询的中证码
							    										corpCust.setCorpCustPswd(loanCardPass);//征信查询的贷款密码
							    										corpCust.setCorpCustCompanyname(corpName);//征信查询客户的名称
							    										corpCust.setQueryReason(queryReason);
							    										corpCust.setCustId(id);
							    										corpCust.setCorpCustType(custType);//征信查询客户的客户属性
//							    										corpCust.setRelCustId();//征信查询客户关联inq_cust、corp_cust的id
							    										corpCust.setRelName(assureCorpName);//关联客户的名称（个人或企业）
							    										corpCust.setRelCorpId(assureLoanCardNo);//关联客户中征码（企业时填写）
							    										corpCust.setCreateTime(DateUtil.getCurrentTime());
							    										corpCust.setCreateUser(globalinfo.getTlrno());
							    										corpCust.setConsentFilePath(fullUpPath);
							    										corpCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
							    										corpCust.setInqType("0");
							    										corpCust.setDetailFlag("2");
							    										try {
								    										rootDAO.save2(corpCust);
							    			    						} catch (CommonException e) {
							    			    							e.printStackTrace();
							    			    							ExceptionUtil.throwCommonException("corpCust表新增数据失败！");
							    			    						}
							    										
							    										//向corpScrubInfo表插入数据
							    										CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
							    										corpScrubInfo.setAppId(newId);
							    										corpScrubInfo.setBatchId(newBatchId);
//							    										corpScrubInfo.setRptKey(rptKey);
							    										corpScrubInfo.setName(corpName);
							    										corpScrubInfo.setLoancard(loanCardNo);
							    										corpScrubInfo.setPassword(loanCardPass);
							    										corpScrubInfo.setOrgcode(orgCode);
							    										corpScrubInfo.setLoanNo(loanNo);
							    										corpScrubInfo.setQueryReason(queryReason);
							    										corpScrubInfo.setCreateUser(globalinfo.getTlrno());	
							    										corpScrubInfo.setInputTime(inputTime);
							    										corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
							    										corpScrubInfo.setStatus("0");
							    										try {
								    										rootDAO.save2(corpScrubInfo);
							    			    						} catch (CommonException e) {
							    			    							e.printStackTrace();
							    			    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
							    			    						}
				    												}
				    								}else{
				    									//若corpCust没有找到符合担保公司中证码，名称，客户类型为借款公司的记录则 直接插corpScrubInfo表 且状态为检验不通过
				    									//向corpScrubInfo表插入数据
			    										CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
//			    										corpScrubInfo.setAppId(id);
			    										corpScrubInfo.setBatchId(newBatchId);
//			    										corpScrubInfo.setRptKey(rptKey);
			    										corpScrubInfo.setName(corpName);
			    										corpScrubInfo.setLoancard(loanCardNo);
			    										corpScrubInfo.setPassword(loanCardPass);
			    										corpScrubInfo.setOrgcode(orgCode);
			    										corpScrubInfo.setLoanNo(loanNo);
			    										corpScrubInfo.setQueryReason(queryReason);
			    										corpScrubInfo.setCreateUser(globalinfo.getTlrno());
			    										corpScrubInfo.setInputTime(inputTime);
			    										corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
			    										corpScrubInfo.setStatus("1");
			    										try {
			    											rootDAO.save2(corpScrubInfo);
			    			    						} catch (CommonException e) {
			    			    							e.printStackTrace();
			    			    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
			    			    						}
				    								}
				    					}else{
		    								//向corpScrubInfo表插入数据
    										CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
//    										corpScrubInfo.setAppId(id);
    										corpScrubInfo.setBatchId(newBatchId);
//    										corpScrubInfo.setRptKey(rptKey);
    										corpScrubInfo.setName(corpName);
    										corpScrubInfo.setLoancard(loanCardNo);
    										corpScrubInfo.setPassword(loanCardPass);
    										corpScrubInfo.setOrgcode(orgCode);
    										corpScrubInfo.setLoanNo(loanNo);
    										corpScrubInfo.setQueryReason(queryReason);
    										corpScrubInfo.setCreateUser(globalinfo.getTlrno());
    										corpScrubInfo.setInputTime(inputTime);
    										corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
    										corpScrubInfo.setStatus("1");
    										try {
    											rootDAO.save2(corpScrubInfo);
    			    						} catch (CommonException e) {
    			    							e.printStackTrace();
    			    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
    			    						}
				    					}
				    				}
				    		//当进行明细查询时 雪查询TCorpDetaailApp表
		    				}else if("1".equals(dealQuery)){
		    					//当客户属性为借款公司时
		    					if("1".equals(custType)){
		    							//查询S天内有无TCorpApp数据
		    						   System.out.println("dealQuery="+dealQuery+"!!!!!!!!!!!!!!!!!!!!!!!$$$$$$$$$$$$$");
		    							List<TCorpApp> listTCorpApp=batchService.getTCorpApp(loanCardNo);
		    							System.out.println("====kkkkkk===="+(null != listTCorpApp && listTCorpApp.size()>0)+"===kkkkk=====");
		    								if(null != listTCorpApp && listTCorpApp.size()>0){
		    											//取TCorpApp id、rpeKey
		    											int id=listTCorpApp.get(0).getId();
		    											String rptKey=listTCorpApp.get(0).getRptKey();
		    											//查询S天内有无TCorpDetailApp数据
							    						List<TCorpDetailApp> listTCorpDetailApp=batchService.getTCorpDetailApp(loanCardNo);
							    							if(null != listTCorpDetailApp && listTCorpDetailApp.size()>0){
							    											//取TCorpDetailApp id、rpeKey
																			int detailId=listTCorpDetailApp.get(0).getId();
																			//向CorpCust表插入数据
								    										CorpCust corpCust=new CorpCust();
								    										corpCust.setCorpCustAppid(id); //征信查询客户关联t_corp_app的id
								    										corpCust.setCorpCustDetailId(detailId);//征信查询关联t_corp_detail_app的id
								    										corpCust.setCorpCustLoancard(loanCardNo);//征信查询的中证码
								    										corpCust.setCorpCustPswd(loanCardPass);//征信查询的贷款密码
								    										corpCust.setCorpCustCompanyname(corpName);//征信查询客户的名称
								    										corpCust.setQueryReason(queryReason);
								    										corpCust.setCorpCustType(custType);//征信查询客户的客户属性
//								    										corpCust.setRelCustId();//征信查询客户关联inq_cust、corp_cust的id
//								    										corpCust.setRelName(assureCorpName);//关联客户的名称（个人或企业）
//								    										corpCust.setRelCorpId(assureLoanCardNo);//关联客户中征码（企业时填写）
								    										corpCust.setCreateTime(DateUtil.getCurrentTime());
								    										corpCust.setCreateUser(globalinfo.getTlrno());
								    										corpCust.setConsentFilePath(fullUpPath);
								    										corpCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
								    										corpCust.setInqType("0");
								    										corpCust.setDetailFlag("1");
								    										try {
								    											rootDAO.save2(corpCust);
								    			    						} catch (CommonException e) {
								    			    							e.printStackTrace();
								    			    							ExceptionUtil.throwCommonException("corpCust表新增数据失败！");
								    			    						}
								    										//向corpScrubInfo表插入数据
								    										CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
								    										corpScrubInfo.setAppId(id);
								    										corpScrubInfo.setDetailAppId(detailId);
								    										corpScrubInfo.setBatchId(newBatchId);
								    										corpScrubInfo.setRptKey(rptKey);
								    										corpScrubInfo.setName(corpName);
								    										corpScrubInfo.setLoancard(loanCardNo);
								    										corpScrubInfo.setPassword(loanCardPass);
								    										corpScrubInfo.setOrgcode(orgCode);
								    										corpScrubInfo.setLoanNo(loanNo);
								    										corpScrubInfo.setQueryReason(queryReason);
								    										corpScrubInfo.setCreateUser(globalinfo.getTlrno());
								    										corpScrubInfo.setInputTime(inputTime);
								    										corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
								    										corpScrubInfo.setStatus("2");
								    										try {
								    											rootDAO.save2(corpScrubInfo);
								    			    						} catch (CommonException e) {
								    			    							e.printStackTrace();
								    			    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
								    			    						}
							    							}else{
							    								
							    								//向TCorpDetailApp表新增一条数据集	
									    						TCorpDetailApp tcorpDetailApp=new TCorpDetailApp();
//									    						tcorpDetailApp.setBatchId(newBatchId);
									    						tcorpDetailApp.setRptKey("-");
									    						tcorpDetailApp.setLoanCardNo(loanCardNo);
									    						tcorpDetailApp.setLoanCardPass(loanCardPass);
									    						tcorpDetailApp.setQueryReason(queryReason);
									    						tcorpDetailApp.setType("0");
									    						tcorpDetailApp.setStatus("1");
//									    						tcorpApp.setStatusMsg(statusMsg);
									    						tcorpDetailApp.setInputTime(DateUtil.getCurrentTime());
									    						tcorpDetailApp.setReturnTime(DateUtil.getCurrentTime());
									    						tcorpDetailApp.setParsedTime(DateUtil.getCurrentTime());
									    						tcorpDetailApp.setQueryTime(DateUtil.getCurrentTime());
									    						tcorpDetailApp.setCreateTime(DateUtil.getCurrentTime());
									    						int newDetailId=(Integer) rootDAO.save2(tcorpDetailApp);
				    			    							
				    			    							
									    						//向CorpCust表插入数据
					    										CorpCust corpCust=new CorpCust();
					    										corpCust.setCorpCustAppid(id); //征信查询客户关联t_corp_app的id
					    										corpCust.setCorpCustDetailId(newDetailId);//征信查询关联t_corp_detail_app的id
					    										corpCust.setCorpCustLoancard(loanCardNo);//征信查询的中证码
					    										corpCust.setCorpCustPswd(loanCardPass);//征信查询的贷款密码
					    										corpCust.setCorpCustCompanyname(corpName);//征信查询客户的名称
					    										corpCust.setQueryReason(queryReason);
					    										corpCust.setCorpCustType(custType);//征信查询客户的客户属性
//					    										corpCust.setRelCustId();//征信查询客户关联inq_cust、corp_cust的id
//					    										corpCust.setRelName(assureCorpName);//关联客户的名称（个人或企业）
//					    										corpCust.setRelCorpId(assureLoanCardNo);//关联客户中征码（企业时填写）
					    										corpCust.setCreateTime(DateUtil.getCurrentTime());
					    										corpCust.setCreateUser(globalinfo.getTlrno());
					    										corpCust.setConsentFilePath(fullUpPath);
					    										corpCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
					    										corpCust.setInqType("0");
					    										corpCust.setDetailFlag("1");
					    										try {
					    											rootDAO.save2(corpCust);
					    			    						} catch (CommonException e) {
					    			    							e.printStackTrace();
					    			    							ExceptionUtil.throwCommonException("corpCust表新增数据失败！");
					    			    						}
					    										//向corpScrubInfo表插入数据
					    										CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
					    										corpScrubInfo.setAppId(id);
					    										corpScrubInfo.setDetailAppId(newDetailId);
					    										corpScrubInfo.setBatchId(newBatchId);
					    										corpScrubInfo.setRptKey(rptKey);
					    										corpScrubInfo.setName(corpName);
					    										corpScrubInfo.setLoancard(loanCardNo);
					    										corpScrubInfo.setPassword(loanCardPass);
					    										corpScrubInfo.setOrgcode(orgCode);
					    										corpScrubInfo.setLoanNo(loanNo);
					    										corpScrubInfo.setQueryReason(queryReason);
					    										corpScrubInfo.setCreateUser(globalinfo.getTlrno());
					    										corpScrubInfo.setInputTime(inputTime);
					    										corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
					    										corpScrubInfo.setStatus("2");
					    										try {
					    											rootDAO.save2(corpScrubInfo);
					    			    						} catch (CommonException e) {
					    			    							e.printStackTrace();
					    			    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
					    			    						}
							    							}
		    								}else{
		    									//向tcorpApp表新增一条数据集	
					    						TCorpApp tcorpApp=new TCorpApp();
					    						tcorpApp.setBatchId(newBatchId);
					    						tcorpApp.setRptKey("-");
					    						tcorpApp.setLoanCardNo(loanCardNo);
					    						tcorpApp.setLoanCardPass(loanCardPass);
					    						tcorpApp.setQueryReason(ruturnQueryReason(queryReason));
					    						tcorpApp.setType("0");
					    						tcorpApp.setStatus("1");
//					    						tcorpApp.setStatusMsg(statusMsg);
					    						tcorpApp.setCreateTime(DateUtil.getCurrentTime());
					    						tcorpApp.setInputTime(DateUtil.getCurrentTime());
					    						tcorpApp.setReturnTime(DateUtil.getCurrentTime());
					    						tcorpApp.setParsedTime(DateUtil.getCurrentTime());
					    						tcorpApp.setQueryTime(DateUtil.getCurrentTime());
					    						int newId=(Integer) rootDAO.save2(tcorpApp);
					    						
					    						//向TCorpDetailApp表新增一条数据集	
					    						TCorpDetailApp tcorpDetailApp=new TCorpDetailApp();
//					    						tcorpDetailApp.setBatchId(newBatchId);
					    						tcorpDetailApp.setRptKey("-");
					    						tcorpDetailApp.setLoanCardNo(loanCardNo);
					    						tcorpDetailApp.setLoanCardPass(loanCardPass);
					    						tcorpDetailApp.setQueryReason(queryReason);
					    						tcorpDetailApp.setType("0");
					    						tcorpDetailApp.setStatus("1");
//					    						tcorpApp.setStatusMsg(statusMsg);
					    						tcorpDetailApp.setInputTime(DateUtil.getCurrentTime());
					    						tcorpDetailApp.setReturnTime(DateUtil.getCurrentTime());
					    						tcorpDetailApp.setParsedTime(DateUtil.getCurrentTime());
					    						tcorpDetailApp.setQueryTime(DateUtil.getCurrentTime());
					    						tcorpDetailApp.setCreateTime(DateUtil.getCurrentTime());
					    						int newDetailId=(Integer) rootDAO.save2(tcorpDetailApp);
					    						
					    						//向CorpCust表插入数据
	    										CorpCust corpCust=new CorpCust();
	    										corpCust.setCorpCustAppid(newId); //征信查询客户关联t_corp_app的id
	    										corpCust.setCorpCustDetailId(newDetailId);//征信查询关联t_corp_detail_app的id
	    										corpCust.setCorpCustLoancard(loanCardNo);//征信查询的中证码
	    										corpCust.setCorpCustPswd(loanCardPass);//征信查询的贷款密码
	    										corpCust.setCorpCustCompanyname(corpName);//征信查询客户的名称
	    										corpCust.setQueryReason(queryReason);
	    										corpCust.setCorpCustType(custType);//征信查询客户的客户属性
//	    										corpCust.setRelCustId();//征信查询客户关联inq_cust、corp_cust的id
//	    										corpCust.setRelName(assureCorpName);//关联客户的名称（个人或企业）
//	    										corpCust.setRelCorpId(assureLoanCardNo);//关联客户中征码（企业时填写）
	    										corpCust.setCreateTime(DateUtil.getCurrentTime());
	    										corpCust.setCreateUser(globalinfo.getTlrno());
	    										corpCust.setConsentFilePath(fullUpPath);
	    										corpCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
	    										corpCust.setInqType("0");
	    										corpCust.setDetailFlag("1");
	    										try {
	    											rootDAO.save2(corpCust);
	    			    						} catch (CommonException e) {
	    			    							e.printStackTrace();
	    			    							ExceptionUtil.throwCommonException("corpCust表新增数据失败！");
	    			    						}
	    										//向corpScrubInfo表插入数据
	    										CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
	    										corpScrubInfo.setAppId(newId);
	    										corpScrubInfo.setDetailAppId(newDetailId);
	    										corpScrubInfo.setBatchId(newBatchId);
//	    										corpScrubInfo.setRptKey(rptKey);
	    										corpScrubInfo.setName(corpName);
	    										corpScrubInfo.setLoancard(loanCardNo);
	    										corpScrubInfo.setPassword(loanCardPass);
	    										corpScrubInfo.setOrgcode(orgCode);
	    										corpScrubInfo.setLoanNo(loanNo);
	    										corpScrubInfo.setQueryReason(queryReason);
	    										corpScrubInfo.setCreateUser(globalinfo.getTlrno());
	    										corpScrubInfo.setInputTime(inputTime);
	    										corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
	    										corpScrubInfo.setStatus("0");
	    										try {
	    											rootDAO.save2(corpScrubInfo);
	    			    						} catch (CommonException e) {
	    			    							e.printStackTrace();
	    			    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
	    			    						}
		    								}
		    					}else if("2".equals(custType)){
		    						//当客户属性为担保公司时 担保公司中证码 担保公司名称不能为空
		    						if(!"".equals(assureLoanCardNo) && !"".equals(assureCorpName)){
		    								List<CorpCust> listCorpCust=batchService.querycorpCust(assureLoanCardNo, assureCorpName);
		    								//判断CorpCust有无该条记录 如果有取其id
		    								if(null != listCorpCust && listCorpCust.size()>0){
		    												//corpCust的id
		    												int id=listCorpCust.get(0).getId();
		    												//查询S天内有无TCorpApp数据
		    				    							List<TCorpApp> listTCorpApp=batchService.getTCorpApp(loanCardNo);
		    				    							if(null != listTCorpApp && listTCorpApp.size()>0){
		    		    											//取TCorpApp id、
		    		    											int corpid=listTCorpApp.get(0).getId();
		    		    											String rptKey=listTCorpApp.get(0).getRptKey();
		    		    											//查询S天内有无TCorpDetailApp数据
		    							    						List<TCorpDetailApp> listTCorpDetailApp=batchService.getTCorpDetailApp(loanCardNo);
		    							    							if(null != listTCorpDetailApp && listTCorpDetailApp.size()>0){
		    							    										//取TCorpDetailApp id、
		    							    										int detailId=listTCorpDetailApp.get(0).getId();
		    							    										
		    							    										//向CorpCust表插入数据
		    							    										CorpCust corpCust=new CorpCust();
		    							    										corpCust.setCorpCustAppid(corpid); //征信查询客户关联t_corp_app的id
		    							    										corpCust.setCorpCustDetailId(detailId);//征信查询关联t_corp_detail_app的id
		    							    										corpCust.setCorpCustLoancard(loanCardNo);//征信查询的中证码
		    							    										corpCust.setCorpCustPswd(loanCardPass);//征信查询的贷款密码
		    							    										corpCust.setCorpCustCompanyname(corpName);//征信查询客户的名称
		    							    										corpCust.setQueryReason(queryReason);
		    							    										corpCust.setCustId(id);
		    							    										corpCust.setCorpCustType(custType);//征信查询客户的客户属性
		    							    										corpCust.setCustId(id);//征信查询客户关联inq_cust、corp_cust的id
		    							    										corpCust.setRelName(assureCorpName);//关联客户的名称（个人或企业）
		    							    										corpCust.setRelCorpId(assureLoanCardNo);//关联客户中征码（企业时填写）
		    							    										corpCust.setCreateTime(DateUtil.getCurrentTime());
		    							    										corpCust.setCreateUser(globalinfo.getTlrno());
		    							    										corpCust.setConsentFilePath(fullUpPath);
		    							    										corpCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
		    							    										corpCust.setInqType("0");
		    							    										corpCust.setDetailFlag("1");
		    							    										try {
			    							    										rootDAO.save2(corpCust);
		    							    			    						} catch (CommonException e) {
		    							    			    							e.printStackTrace();
		    							    			    							ExceptionUtil.throwCommonException("corpCust表新增数据失败！");
		    							    			    						}
		    							    										
		    							    										//向corpScrubInfo表插入数据
		    							    										CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
		    							    										corpScrubInfo.setAppId(corpid);
		    							    										corpScrubInfo.setDetailAppId(detailId);
		    							    										corpScrubInfo.setBatchId(newBatchId);
		    							    										corpScrubInfo.setRptKey(rptKey);
		    							    										corpScrubInfo.setName(corpName);
		    							    										corpScrubInfo.setLoancard(loanCardNo);
		    							    										corpScrubInfo.setPassword(loanCardPass);
		    							    										corpScrubInfo.setOrgcode(orgCode);
		    							    										corpScrubInfo.setLoanNo(loanNo);
		    							    										corpScrubInfo.setQueryReason(queryReason);
		    							    										corpScrubInfo.setCreateUser(globalinfo.getTlrno());
		    							    										corpScrubInfo.setInputTime(inputTime);
		    							    										corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
		    							    										corpScrubInfo.setStatus("2");
		    							    										try {
			    							    										rootDAO.save2(corpScrubInfo);
		    							    			    						} catch (CommonException e) {
		    							    			    							e.printStackTrace();
		    							    			    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
		    							    			    						}
		    							    							}else{
		    							    								
		    							    								//向TCorpDetailApp表新增一条数据集	
		    		    						    						TCorpDetailApp tcorpDetailApp=new TCorpDetailApp();
//		    		    						    						tcorpDetailApp.setBatchId(newBatchId);
		    		    						    						tcorpDetailApp.setRptKey("-");
		    		    						    						tcorpDetailApp.setLoanCardNo(loanCardNo);
		    		    						    						tcorpDetailApp.setLoanCardPass(loanCardPass);
		    		    						    						tcorpDetailApp.setQueryReason(queryReason);
		    		    						    						tcorpDetailApp.setType("0");
		    		    						    						tcorpDetailApp.setStatus("1");
//		    		    						    						tcorpApp.setStatusMsg(statusMsg);
		    		    						    						tcorpDetailApp.setInputTime(DateUtil.getCurrentTime());
		    		    						    						tcorpDetailApp.setReturnTime(DateUtil.getCurrentTime());
		    		    						    						tcorpDetailApp.setParsedTime(DateUtil.getCurrentTime());
		    		    						    						tcorpDetailApp.setQueryTime(DateUtil.getCurrentTime());
		    		    						    						tcorpDetailApp.setCreateTime(DateUtil.getCurrentTime());
		    		    						    						int newDetailId=(Integer) rootDAO.save2(tcorpDetailApp);
		    		    						    						
		    		    						    						//向CorpCust表插入数据
		    		    		    										CorpCust corpCust=new CorpCust();
		    		    		    										corpCust.setCorpCustAppid(corpid); //征信查询客户关联t_corp_app的id
		    		    		    										corpCust.setCorpCustDetailId(newDetailId);//征信查询关联t_corp_detail_app的id
		    		    		    										corpCust.setCorpCustLoancard(loanCardNo);//征信查询的中证码
		    		    		    										corpCust.setCorpCustPswd(loanCardPass);//征信查询的贷款密码
		    		    		    										corpCust.setCorpCustCompanyname(corpName);//征信查询客户的名称
		    		    		    										corpCust.setQueryReason(queryReason);
		    		    		    										corpCust.setCustId(id);
		    		    		    										corpCust.setCorpCustType(custType);//征信查询客户的客户属性
//		    		    		    										corpCust.setRelCustId();//征信查询客户关联inq_cust、corp_cust的id
		    		    		    										corpCust.setRelName(assureCorpName);//关联客户的名称（个人或企业）
		    		    		    										corpCust.setRelCorpId(assureLoanCardNo);//关联客户中征码（企业时填写）
		    		    		    										corpCust.setCreateTime(DateUtil.getCurrentTime());
		    		    		    										corpCust.setCreateUser(globalinfo.getTlrno());
		    		    		    										corpCust.setConsentFilePath(fullUpPath);
		    		    		    										corpCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
		    		    		    										corpCust.setInqType("0");
		    		    		    										corpCust.setDetailFlag("1");
		    		    		    										try {
		    		    		    											rootDAO.save2(corpCust);
    							    			    						} catch (CommonException e) {
    							    			    							e.printStackTrace();
    							    			    							ExceptionUtil.throwCommonException("corpCust表新增数据失败！");
    							    			    						}
		    		    		    										
		    		    		    										//向corpScrubInfo表插入数据
		    		    		    										CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
		    		    		    										corpScrubInfo.setAppId(corpid);
		    		    		    										corpScrubInfo.setDetailAppId(newDetailId);
		    		    		    										corpScrubInfo.setBatchId(newBatchId);
		    		    		    										corpScrubInfo.setRptKey(rptKey);
		    		    		    										corpScrubInfo.setName(corpName);
		    		    		    										corpScrubInfo.setLoancard(loanCardNo);
		    		    		    										corpScrubInfo.setPassword(loanCardPass);
		    		    		    										corpScrubInfo.setOrgcode(orgCode);
		    		    		    										corpScrubInfo.setLoanNo(loanNo);
		    		    		    										corpScrubInfo.setQueryReason(queryReason);
		    		    		    										corpScrubInfo.setCreateUser(globalinfo.getTlrno());
		    		    		    										corpScrubInfo.setInputTime(inputTime);
		    		    		    										corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
		    		    		    										corpScrubInfo.setStatus("0");
		    		    		    										try {
		    		    		    											rootDAO.save2(corpScrubInfo);
    							    			    						} catch (CommonException e) {
    							    			    							e.printStackTrace();
    							    			    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
    							    			    						}
		    							    							}
		    				    							}else{
		    				    								
		    			    									//向tcorpApp表新增一条数据集	
		    						    						TCorpApp tcorpApp=new TCorpApp();
		    						    						tcorpApp.setBatchId(newBatchId);
		    						    						tcorpApp.setRptKey("-");
		    						    						tcorpApp.setLoanCardNo(loanCardNo);
		    						    						tcorpApp.setLoanCardPass(loanCardPass);
		    						    						tcorpApp.setQueryReason(ruturnQueryReason(queryReason));
		    						    						tcorpApp.setType("0");
		    						    						tcorpApp.setStatus("1");
//		    						    						tcorpApp.setStatusMsg(statusMsg);
		    						    						tcorpApp.setCreateTime(DateUtil.getCurrentTime());
		    						    						tcorpApp.setInputTime(DateUtil.getCurrentTime());
		    						    						tcorpApp.setReturnTime(DateUtil.getCurrentTime());
		    						    						tcorpApp.setParsedTime(DateUtil.getCurrentTime());
		    						    						tcorpApp.setQueryTime(DateUtil.getCurrentTime());
		    						    						int newId=(Integer) rootDAO.save2(tcorpApp);
				    											
		    						    						//向TCorpDetailApp表新增一条数据集	
		    						    						TCorpDetailApp tcorpDetailApp=new TCorpDetailApp();
		    						    						tcorpDetailApp.setRptKey("-");
		    						    						tcorpDetailApp.setLoanCardNo(loanCardNo);
		    						    						tcorpDetailApp.setLoanCardPass(loanCardPass);
		    						    						tcorpDetailApp.setQueryReason(queryReason);
		    						    						tcorpDetailApp.setType("0");
		    						    						tcorpDetailApp.setStatus("1");
//		    						    						tcorpApp.setStatusMsg(statusMsg);
		    						    						tcorpDetailApp.setInputTime(DateUtil.getCurrentTime());
		    						    						tcorpDetailApp.setReturnTime(DateUtil.getCurrentTime());
		    						    						tcorpDetailApp.setParsedTime(DateUtil.getCurrentTime());
		    						    						tcorpDetailApp.setQueryTime(DateUtil.getCurrentTime());
		    						    						tcorpDetailApp.setCreateTime(DateUtil.getCurrentTime());
		    						    						int newDetailId=(Integer) rootDAO.save2(tcorpDetailApp);
		    						    						
		    						    						//向CorpCust表插入数据
		    		    										CorpCust corpCust=new CorpCust();
		    		    										corpCust.setCorpCustAppid(newId); //征信查询客户关联t_corp_app的id
		    		    										corpCust.setCorpCustDetailId(newDetailId);//征信查询关联t_corp_detail_app的id
		    		    										corpCust.setCorpCustLoancard(loanCardNo);//征信查询的中证码
		    		    										corpCust.setCorpCustPswd(loanCardPass);//征信查询的贷款密码
		    		    										corpCust.setCorpCustCompanyname(corpName);//征信查询客户的名称
		    		    										corpCust.setQueryReason(queryReason);
		    		    										corpCust.setCustId(id);
		    		    										corpCust.setCorpCustType(custType);//征信查询客户的客户属性
//		    		    										corpCust.setRelCustId();//征信查询客户关联inq_cust、corp_cust的id
		    		    										corpCust.setRelName(assureCorpName);//关联客户的名称（个人或企业）
		    		    										corpCust.setRelCorpId(assureLoanCardNo);//关联客户中征码（企业时填写）
		    		    										corpCust.setCreateTime(DateUtil.getCurrentTime());
		    		    										corpCust.setCreateUser(globalinfo.getTlrno());
		    		    										corpCust.setConsentFilePath(fullUpPath);
		    		    										corpCust.setCreateUserIp(GlobalInfo.getCurrentInstance().getIp());
		    		    										corpCust.setInqType("0");
		    		    										corpCust.setDetailFlag("1");
		    		    										try {
		    		    											rootDAO.save2(corpCust);
					    			    						} catch (CommonException e) {
					    			    							e.printStackTrace();
					    			    							ExceptionUtil.throwCommonException("corpCust表新增数据失败！");
					    			    						}
		    		    										
		    		    										//向corpScrubInfo表插入数据
		    		    										CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
		    		    										corpScrubInfo.setAppId(newId);
		    		    										corpScrubInfo.setDetailAppId(newDetailId);
		    		    										corpScrubInfo.setBatchId(newBatchId);
//		    		    										corpScrubInfo.setRptKey(rptKey);
		    		    										corpScrubInfo.setName(corpName);
		    		    										corpScrubInfo.setLoancard(loanCardNo);
		    		    										corpScrubInfo.setPassword(loanCardPass);
		    		    										corpScrubInfo.setOrgcode(orgCode);
		    		    										corpScrubInfo.setLoanNo(loanNo);
		    		    										corpScrubInfo.setQueryReason(queryReason);
		    		    										corpScrubInfo.setCreateUser(globalinfo.getTlrno());
		    		    										corpScrubInfo.setInputTime(inputTime);
		    		    										corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
		    		    										corpScrubInfo.setStatus("0");
		    		    										try {
		    		    											rootDAO.save2(corpScrubInfo);
					    			    						} catch (CommonException e) {
					    			    							e.printStackTrace();
					    			    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
					    			    						}
		    				    							}
		    								}else{
		    									//若corpCust没有找到符合担保公司中证码，名称，客户类型为借款公司的记录则 直接插corpScrubInfo表 且状态为检验不通过
		    									//向corpScrubInfo表插入数据
	    										CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
//	    										corpScrubInfo.setAppId(id);
	    										corpScrubInfo.setBatchId(newBatchId);
//	    										corpScrubInfo.setRptKey(rptKey);
	    										corpScrubInfo.setName(corpName);
	    										corpScrubInfo.setLoancard(loanCardNo);
	    										corpScrubInfo.setPassword(loanCardPass);
	    										corpScrubInfo.setOrgcode(orgCode);
	    										corpScrubInfo.setLoanNo(loanNo);
	    										corpScrubInfo.setQueryReason(queryReason);
	    										corpScrubInfo.setCreateUser(globalinfo.getTlrno());
	    										corpScrubInfo.setInputTime(inputTime);
	    										corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
	    										corpScrubInfo.setStatus("1");
	    										try {
	    											rootDAO.save2(corpScrubInfo);
	    			    						} catch (CommonException e) {
	    			    							e.printStackTrace();
	    			    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
	    			    						}
		    								}
		    					}else{
		    						
		    						//向corpScrubInfo表插入数据
									CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
//									corpScrubInfo.setAppId(id);
									corpScrubInfo.setBatchId(newBatchId);
//									corpScrubInfo.setRptKey(rptKey);
									corpScrubInfo.setName(corpName);
									corpScrubInfo.setLoancard(loanCardNo);
									corpScrubInfo.setPassword(loanCardPass);
									corpScrubInfo.setOrgcode(orgCode);
									corpScrubInfo.setLoanNo(loanNo);
									corpScrubInfo.setQueryReason(queryReason);
									corpScrubInfo.setCreateUser(globalinfo.getTlrno());
									corpScrubInfo.setInputTime(inputTime);
									corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
									corpScrubInfo.setStatus("1");
									try {
										rootDAO.save2(corpScrubInfo);
		    						} catch (CommonException e) {
		    							e.printStackTrace();
		    							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
		    						}
		    					}
		    				}
		    			}
		    		}else{
		    			//向corpScrubInfo表插入数据
						CorpScurbInfo corpScrubInfo=new CorpScurbInfo();
//						corpScrubInfo.setAppId(id);
						corpScrubInfo.setBatchId(newBatchId);
//						corpScrubInfo.setRptKey(rptKey);
						corpScrubInfo.setName(corpName);
						corpScrubInfo.setLoancard(loanCardNo);
						corpScrubInfo.setPassword(loanCardPass);
						corpScrubInfo.setOrgcode(orgCode);
						corpScrubInfo.setLoanNo(loanNo);
						corpScrubInfo.setQueryReason(queryReason);
						corpScrubInfo.setCreateUser(globalinfo.getTlrno());
						corpScrubInfo.setInputTime(inputTime);
						corpScrubInfo.setReturnTime(DateUtil.getCurrentTime());
						corpScrubInfo.setStatus("1");
						try {
							rootDAO.save2(corpScrubInfo);
						} catch (CommonException e) {
							e.printStackTrace();
							ExceptionUtil.throwCommonException("corpScrubInfo表新增数据失败！");
						}
		    		}
		    			continue;
    			}
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		}
        	}
        }
    public String ruturnQueryReason(String queryReason){
		String ruturnQueryReason=queryReason;
		if("05".equals(queryReason)){
			ruturnQueryReason="04";
		}else if("04".equals(queryReason)){
			ruturnQueryReason="05";
		}
		return ruturnQueryReason;
	}
    @Override
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
    }
}
