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
import resource.bean.basic.TlrInfo;
import resource.bean.basic.TlrUpdateInfoBatch;
import resource.bean.basic.TlrUpdateInfoUploadBean;
import resource.bean.basic.base.BaseIndApp;

import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.BatchIndService;
import com.huateng.ebank.business.customer.service.BatchTlrUpdateInfoService;
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
public class BatchTlrUpdateInfoOperation extends BaseOperation {
    private static final HtLog htlog = HtLogFactory.getLogger(BatchTlrUpdateInfoOperation.class);
    public static final String ID = "customer.BatchTlrUpdateInfoOperation";
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
        BatchTlrUpdateInfoService batchService=new BatchTlrUpdateInfoService();
        //查询参数表 校验是否有人行查询记录 
		//  获取excel文件
        FormFile excelFile = (FormFile)context.getAttribute(IN_ORDER_FORMFILE);
        String excelfileName=excelFile.getFileName();
      	 //将文件存放在指定路径，获取文件存放全路径，
        String  fullUpPath=batchService.uploadFile(excelFile);
        String postfix= excelfileName.substring(excelfileName.lastIndexOf('.')).toLowerCase();
        //解析ecxel文件
		List<TlrUpdateInfoUploadBean> list=new ArrayList();
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
      //取出TlrUpdateInfoBatch的最大的batchId
        int newBatchId=batchService.getMaxBatchId()+1;
        int count = 0;
        	//遍历excel文件标题字段
        	for (TlrUpdateInfoUploadBean uploadBean : list) {
        		//userId
        		String userId =uploadBean.getUserId();
        		if("null".equals(userId)){
        			userId="";
        		}
        		//城市
        		String city =uploadBean.getCity();
        		if("null".equals(city)){
        			city="";
        		}
        		//區域
        		String region =uploadBean.getRegion();
        		if("null".equals(region)){
        			region="";
        		}
    			if(count<list.size()){
    			count++;
    			if(!"".equals(userId)){
    				List<TlrInfo> tlrInfoApp=batchService.querytlrInfo(userId);
    				if(null != tlrInfoApp && tlrInfoApp.size()>0){
						for (TlrInfo tlrInfo : tlrInfoApp) {
							if(city.equals(tlrInfo.getCity()) && region.equals(tlrInfo.getRegion())){
							
								//写入TlrUpdateInfoBatch表
			    				TlrUpdateInfoBatch tlrUpdateInfoBatch=new TlrUpdateInfoBatch();
			    				tlrUpdateInfoBatch.setBatchId(newBatchId);
			    				tlrUpdateInfoBatch.setUserId(userId);
			    				tlrUpdateInfoBatch.setCity(city);
			    				tlrUpdateInfoBatch.setRegion(region);
			    				tlrUpdateInfoBatch.setStatus("2");
			    				tlrUpdateInfoBatch.setInputTime(inputTime);
			    				tlrUpdateInfoBatch.setCreateUser(globalinfo.getTlrno());
								try {
									rootDAO.save2(tlrUpdateInfoBatch);
									htlog.info("写入TlrUpdateInfoBatch表成功！");
								} catch (CommonException e) {
									e.printStackTrace();
									ExceptionUtil.throwCommonException("TlrUpdateInfoBatch表新增数据失败！");
								}
							}else{
								//更新tlrInfo的信息
								tlrInfo.setCity(city);
								tlrInfo.setRegion(region);
								try {
									rootDAO.saveOrUpdate(tlrInfo);
									htlog.info("TlrInfo表更新成功！");
								} catch (Exception e) {
									e.printStackTrace();
									ExceptionUtil.throwCommonException("TlrInfo表更新失败！");
								}
								
								//写入TlrUpdateInfoBatch表
			    				TlrUpdateInfoBatch tlrUpdateInfoBatch=new TlrUpdateInfoBatch();
			    				tlrUpdateInfoBatch.setBatchId(newBatchId);
			    				tlrUpdateInfoBatch.setUserId(userId);
			    				tlrUpdateInfoBatch.setCity(city);
			    				tlrUpdateInfoBatch.setRegion(region);
			    				tlrUpdateInfoBatch.setStatus("1");
			    				tlrUpdateInfoBatch.setInputTime(inputTime);
			    				tlrUpdateInfoBatch.setCreateUser(globalinfo.getTlrno());
								try {
									rootDAO.save2(tlrUpdateInfoBatch);
									htlog.info("写入TlrUpdateInfoBatch表成功！");
								} catch (CommonException e) {
									e.printStackTrace();
									ExceptionUtil.throwCommonException("TlrUpdateInfoBatch表新增数据失败！");
								}
							}
							
						}
    				}else{
    					//写入TlrUpdateInfoBatch表
	    				TlrUpdateInfoBatch tlrUpdateInfoBatch=new TlrUpdateInfoBatch();
	    				tlrUpdateInfoBatch.setBatchId(newBatchId);
	    				tlrUpdateInfoBatch.setUserId(userId);
	    				tlrUpdateInfoBatch.setCity(city);
	    				tlrUpdateInfoBatch.setRegion(region);
	    				tlrUpdateInfoBatch.setStatus("3");
	    				tlrUpdateInfoBatch.setInputTime(inputTime);
	    				tlrUpdateInfoBatch.setCreateUser(globalinfo.getTlrno());
						try {
							rootDAO.save2(tlrUpdateInfoBatch);
							htlog.info("写入TlrUpdateInfoBatch表成功！");
						} catch (CommonException e) {
							e.printStackTrace();
							ExceptionUtil.throwCommonException("TlrUpdateInfoBatch表新增数据失败！");
						}
    					
    				}
    			}else{
    				//写入TlrUpdateInfoBatch表
    				TlrUpdateInfoBatch tlrUpdateInfoBatch=new TlrUpdateInfoBatch();
    				tlrUpdateInfoBatch.setBatchId(newBatchId);
    				tlrUpdateInfoBatch.setUserId(userId);
    				tlrUpdateInfoBatch.setCity(city);
    				tlrUpdateInfoBatch.setRegion(region);
    				tlrUpdateInfoBatch.setStatus("4");
    				tlrUpdateInfoBatch.setInputTime(inputTime);
    				tlrUpdateInfoBatch.setCreateUser(globalinfo.getTlrno());
					try {
						rootDAO.save2(tlrUpdateInfoBatch);
						htlog.info("写入TlrUpdateInfoBatch表成功！");
					} catch (CommonException e) {
						e.printStackTrace();
						ExceptionUtil.throwCommonException("TlrUpdateInfoBatch表新增数据失败！");
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
