package com.huateng.ebank.business.customer.operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;



import org.apache.struts.upload.FormFile;

import resource.bean.basic.CorpLoancardScurbInfo;
import resource.bean.basic.TCorpLoancardInq;

import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.BatchCorpLoancardService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * 
 * Filename:LoanersMaintainInfoOperation.java Description:批量个人征信报告查询请求
 * Copyright:Copyright (c)2012 Company: HuaTeng
 */
public class BatchCorpLoancardOperation extends BaseOperation {
    private static final HtLog htlog = HtLogFactory.getLogger(BatchCorpLoancardOperation.class);
    public static final String ID = "customer.BatchCorpLoancardOperation";
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
        BatchCorpLoancardService batchService=new BatchCorpLoancardService();
		//获取excel文件
		FormFile excelFile = (FormFile) context.getAttribute(IN_ORDER_FORMFILE);
        
        String excelfileName=((FormFile) excelFile).getFileName();
      	 //将文件存放在指定路径，获取文件存放全路径，
        String postfix= excelfileName.substring(excelfileName.lastIndexOf('.')).toLowerCase();
        //解析ecxel文件
		List<TCorpLoancardInq> list=new ArrayList();
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
       Date inputCurrentTime=DateUtil.getCurrentTime();
      //取出IndScrubInfo的最大的batchId
        int newBatchId=batchService.getMaxBatchId()+1;
        int count = 0;
        	//遍历excel文件标题字段
        	for (TCorpLoancardInq tcorpLoancardInq : list) {
        		//查询条件
        		String inquiryType =batchService.parseInquiryType(tcorpLoancardInq.getInquiryType());
        		if("null".equals(inquiryType)){
        			inquiryType="";
        		}
        		Pattern patterinquiryType=Pattern.compile("0[1-7]");
    			boolean boolpatterinquiryType=patterinquiryType.matcher(inquiryType).matches();
        		//查询原因
        		String queryReason =batchService.parseQueryReason(tcorpLoancardInq.getQueryReason());
        		if("null".equals(queryReason)){
        			queryReason="";
        		}
        		Pattern patterqueryReason=Pattern.compile("0[1-5]");
    			boolean boolQueryReason=patterqueryReason.matcher(queryReason).matches();
        	
    			//Loan_no
    			String inquiryValue = tcorpLoancardInq.getInquiryValue();
    			if("null".equals(inquiryValue)){
    				inquiryValue="";
        		}
    			Date inputTime=DateUtil.getCurrentTime();
    			if(count<list.size()){
    			count++;
    			//必填字段不许为空，出现空时 直接新增ind_scrub_info表
    			if(boolQueryReason == true && boolpatterinquiryType==true){
    				TCorpLoancardInq tCorpLoancardInq=new TCorpLoancardInq();
    				tCorpLoancardInq.setInquiryType(inquiryType);
    				tCorpLoancardInq.setInquiryValue(inquiryValue);
    				tCorpLoancardInq.setQueryReason(queryReason);
    				tCorpLoancardInq.setInputTime(inputCurrentTime);
    				tCorpLoancardInq.setStatus("1");
    				tCorpLoancardInq.setPwid(globalinfo.getTlrno());
    				tCorpLoancardInq.setCreateUserIp(globalinfo.getIp());
    				int id=(Integer) rootDAO.save2(tCorpLoancardInq);
    				htlog.info("写入tCorpLoancardInq表成功！");
    				
    				CorpLoancardScurbInfo corpLoancardScurbInfo=new CorpLoancardScurbInfo();
    				corpLoancardScurbInfo.setAppId(id);
    				corpLoancardScurbInfo.setBatchId(newBatchId);
    				corpLoancardScurbInfo.setStatus("0");
    				corpLoancardScurbInfo.setInquiryType(inquiryType);
    				corpLoancardScurbInfo.setInquiryValue(inquiryValue);
    				corpLoancardScurbInfo.setInputTime(inputCurrentTime);
//    				corpLoancardScurbInfo.setReturnTime(DateUtil.getCurrentTime());
    				corpLoancardScurbInfo.setCreateUser(globalinfo.getTlrno());
    				rootDAO.save2(corpLoancardScurbInfo);
    				htlog.info("写入corpLoancardScurbInfo表成功！");
    				
    			}else{
    				CorpLoancardScurbInfo corpLoancardScurbInfo=new CorpLoancardScurbInfo();
    				corpLoancardScurbInfo.setBatchId(newBatchId);
    				corpLoancardScurbInfo.setStatus("1");
    				corpLoancardScurbInfo.setInquiryType(inquiryType);
    				corpLoancardScurbInfo.setInquiryValue(inquiryValue);
    				corpLoancardScurbInfo.setInputTime(inputCurrentTime);
//    				corpLoancardScurbInfo.setReturnTime(DateUtil.getCurrentTime());
    				corpLoancardScurbInfo.setCreateUser(globalinfo.getTlrno());
    				rootDAO.save2(corpLoancardScurbInfo);
    				htlog.info("写入corpLoancardScurbInfo表成功！");
    			}
    		}
    	}
    }
    @Override
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
    }
}
