package com.huateng.ebank.business.customer.operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts.upload.FormFile;

import resource.bean.basic.AssureBatchInfo;
import resource.bean.basic.AssureIndApp;
import resource.bean.basic.AssureIndCust;
import resource.bean.basic.TDetailIndApp;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.AssureIndAppService;
import com.huateng.ebank.business.customer.service.BatchNaturePersonQueryService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;

/**
 * 
 * Filename:LoanersMaintainInfoOperation.java Description:批量自然人对外担保
 * Copyright:Copyright (c)2012 Company: HuaTeng
 */
public class BatchNaturePersonQueryOperation extends BaseOperation {
    private static final HtLog htlog = HtLogFactory.getLogger(BatchNaturePersonQueryOperation.class);
    public static final String ID = "customer.BatchNaturePersonQueryOperation";
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
    	System.out.println("BatchNaturePersonQueryOperation start!!");
        String cmd = (String) context.getAttribute(CMD);
        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
        AssureIndAppService service= new AssureIndAppService();
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
       // BatchCorpService batchService=new BatchCorpService();
        TDetailIndApp tDetailIndApp = null;
        AssureIndCust assureIndCust=null;
        AssureIndApp assureIndApp =null;
        Date nowDay=new Date();
        ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
        BatchNaturePersonQueryService batchService=new BatchNaturePersonQueryService();
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
		List<AssureIndApp> list=new ArrayList();
        if(".xlsx".equals(postfix)){
			try {
				List xlsxList=BatchNaturePersonQueryService.parseXlsx(excelFile);
				if(null != xlsxList && xlsxList.size()>0){
					list.addAll(xlsxList);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(".xls".equals(postfix)){
			try {
				List xlsList=BatchNaturePersonQueryService.parseXls(excelFile);
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
        	for (AssureIndApp uploadBean : list) {
        		
        		String idType=uploadBean.getIndividualIdType();
        		String individualIdType=batchService.parseNaturePersonType(idType);
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
//		    				List<IndPermit> listPermitQuery = service.getIndPermitQuery(individualIdType, name, individualId);	//查询许可文件				
		    				int listAssureIndApp=service.getAssureIndApp(individualIdType, individualId);//查询R天内是否有记录
		    				assureIndCust = new AssureIndCust();
		    				if(listAssureIndApp==0){
		    				assureIndApp = new AssureIndApp();
		    				assureIndApp.setRptKey("-");
		    				assureIndApp.setIndividualIdType(individualIdType);
		    				assureIndApp.setIndividualId(individualId);
		    				assureIndApp.setType("0");
		    				assureIndApp.setName(name);
		    				assureIndApp.setInputUser(globalinfo.getTlrno());
		    				assureIndApp.setInputTime(nowDay);
		    				assureIndApp.setQueryTime(nowDay);
		    				assureIndApp.setReturnTime(nowDay);
		    				assureIndApp.setParseTime(nowDay);
		    				assureIndApp.setStatus("1");
		    				assureIndApp.setConsentFilePath(fullUpPath);
		    				assureIndApp.setInputUserIp(globalinfo.getIp());
		    				assureIndApp.setNonConsentFilePath("");
		    				rootDao.save2(assureIndApp);
		    				assureIndCust.setAppId(assureIndApp.getId().toString());
		    				}else{
		    					assureIndCust.setAppId(listAssureIndApp+"");
		    				}
		    				
		    				assureIndCust.setIndividualIdType(individualIdType);
		    				assureIndCust.setIndividualId(individualId);
		    				assureIndCust.setName(name);
		    				assureIndCust.setInputUser(globalinfo.getTlrno());
		    				assureIndCust.setInputTime(nowDay);
		    				assureIndCust.setConsentFilePath(fullUpPath);
		    				assureIndCust.setInputUserIp(globalinfo.getIp());
		    				rootDao.save(assureIndCust);
			                	
			                	//写入batch表
		    				//向corpScrubInfo表插入数据
		    				AssureBatchInfo  assureBatchInfo =new AssureBatchInfo ();
		    				assureBatchInfo.setBatchId(newBatchId);
		    				assureBatchInfo.setAppId(Integer.parseInt(assureIndCust.getAppId()));
		    				assureBatchInfo.setName(name);
		    				assureBatchInfo.setIndividualIdType(individualIdType);;
		    				assureBatchInfo.setIndividualId(individualId);
							
		    				assureBatchInfo.setCreateUser(globalinfo.getTlrno());
		    				assureBatchInfo.setInputTime(inputTime);
		    				assureBatchInfo.setReturnTime(DateUtil.getCurrentTime());
		    				assureBatchInfo.setStatus("0");
		    				rootDao.save(assureBatchInfo);
		    			}else{
		    				//
		    				System.out.println("向batch表插入数据");
		    				//向corpScrubInfo表插入数据
		    				AssureBatchInfo  assureBatchInfo =new AssureBatchInfo ();
		    				assureBatchInfo.setBatchId(newBatchId);
//							corpScrubInfo.setRptKey(rptKey);
		    				assureBatchInfo.setName(name);
		    				assureBatchInfo.setIndividualIdType(individualIdType);;
		    				assureBatchInfo.setIndividualId(individualId);
							
		    				assureBatchInfo.setCreateUser(globalinfo.getTlrno());
		    				assureBatchInfo.setInputTime(inputTime);
		    				assureBatchInfo.setReturnTime(DateUtil.getCurrentTime());
		    				assureBatchInfo.setStatus("1");
		    				rootDao.save(assureBatchInfo);
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
