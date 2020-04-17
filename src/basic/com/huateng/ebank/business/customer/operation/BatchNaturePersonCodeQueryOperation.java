package com.huateng.ebank.business.customer.operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts.upload.FormFile;

import resource.bean.basic.NaturalCodeBatchInfo;
import resource.bean.basic.TDetailIndApp;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.BatchNaturePersonCodeQueryService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;

/**
 * 
 * Filename:LoanersMaintainInfoOperation.java Description:批量自然人中证码
 * Copyright:Copyright (c)2012 Company: HuaTeng
 */
public class BatchNaturePersonCodeQueryOperation extends BaseOperation {
    private static final HtLog htlog = HtLogFactory.getLogger(BatchNaturePersonCodeQueryOperation.class);
    public static final String ID = "customer.BatchNaturePersonCodeQueryOperation";
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
    	System.out.println("BatchNaturePersonCodeQueryOperation start!!");
        String cmd = (String) context.getAttribute(CMD);
        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
       // BatchCorpService batchService=new BatchCorpService();
        TDetailIndApp tDetailIndApp = null;
        Date nowDay=new Date();
        ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
        BatchNaturePersonCodeQueryService batchService=new BatchNaturePersonCodeQueryService();
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
		List<TDetailIndApp> list=new ArrayList();
        if(".xlsx".equals(postfix)){
			try {
				List xlsxList=BatchNaturePersonCodeQueryService.parseXlsx(excelFile);
				if(null != xlsxList && xlsxList.size()>0){
					list.addAll(xlsxList);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(".xls".equals(postfix)){
			try {
				List xlsList=BatchNaturePersonCodeQueryService.parseXls(excelFile);
				if(null != xlsList && xlsList.size()>0){
					list.addAll(xlsList);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        
        //获取当前时间
        Date inputTime=DateUtil.getCurrentTime();
       //取出IndScrubInfo的最大的batchId
         int newBatchId=batchService.getMaxBatchId()+1;
        	int count = 0;
        	for (TDetailIndApp uploadBean : list) {
        		
        	    //
        		String idType=uploadBean.getIndividualIdType();
        		String individualIdType=batchService.parseNaturePersonCodeType(idType);
        		if("null".equals(individualIdType)){
        			individualIdType="";
        		}
        		String individualId=uploadBean.getIndividualId();
        		if("null".equals(individualId)){
        			individualId="";
        		}
        		String name=uploadBean.getName();
        		if("null".equals(name)){
        			name="";
        		}
    			
    			try{
    			if(count<list.size()){
    				System.out.println("++++++++list is not null！！！+++++++");
    					count++;
    					//若必填项不为空时
		    			if(!"".equals(individualIdType) && !"".equals(individualId) && !"".equals(name) ){
		    				   tDetailIndApp= new TDetailIndApp();
		    				    tDetailIndApp.setRptKey("-");
			                    tDetailIndApp.setIndividualIdType(individualIdType);
			                    tDetailIndApp.setIndividualId(individualId);
			                    tDetailIndApp.setType("0");
			                    tDetailIndApp.setInputUser(globalinfo.getTlrno());
			                /*    tDetailIndApp.setInputTime(nowDay);
			                    tDetailIndApp.setQueryTime(nowDay);
			                    tDetailIndApp.setReturnTime(nowDay);
			                    tDetailIndApp.setParseTime(nowDay);*/
			                    tDetailIndApp.setStatus("1");
			                    tDetailIndApp.setInputUserIp(globalinfo.getIp());
			                    tDetailIndApp.setName(name);
			                    //tDetailIndApp.setInputTime(DateUtil.getCurrentTime());
			                	rootDao.save(tDetailIndApp);
			                	
			                	
			                	//写入batch表
			                	NaturalCodeBatchInfo  naturalCodeBatchInfo =new NaturalCodeBatchInfo();
			                	naturalCodeBatchInfo.setBatchId(newBatchId);
//								corpScrubInfo.setRptKey(rptKey);
			                	naturalCodeBatchInfo.setName(name);
			                	naturalCodeBatchInfo.setIndividualIdType(individualIdType);;
			                	naturalCodeBatchInfo.setIndividualId(individualId);
								
			                	naturalCodeBatchInfo.setCreateUser(globalinfo.getTlrno());
			                	naturalCodeBatchInfo.setInputTime(inputTime);
			                	naturalCodeBatchInfo.setReturnTime(DateUtil.getCurrentTime());
			                	naturalCodeBatchInfo.setStatus("0");
			                	naturalCodeBatchInfo.setAppId(tDetailIndApp.getId());
			                	rootDao.save(naturalCodeBatchInfo);
		    			}else{
		    				//
		    				System.out.println("向batch表插入数据");
		    				NaturalCodeBatchInfo  naturalCodeBatchInfo =new NaturalCodeBatchInfo();
		    				naturalCodeBatchInfo.setBatchId(newBatchId);
//							corpScrubInfo.setRptKey(rptKey);
		    				naturalCodeBatchInfo.setName(name);
		    				naturalCodeBatchInfo.setIndividualIdType(individualIdType);;
		    				naturalCodeBatchInfo.setIndividualId(individualId);
							
		    				naturalCodeBatchInfo.setCreateUser(globalinfo.getTlrno());
		    				naturalCodeBatchInfo.setInputTime(inputTime);
		    				naturalCodeBatchInfo.setReturnTime(DateUtil.getCurrentTime());
		    				naturalCodeBatchInfo.setStatus("1");
		    				rootDao.save(naturalCodeBatchInfo);
		    			}
		    			continue;
    			}
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		}
        	}
        }
    @Override
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
    }
}
