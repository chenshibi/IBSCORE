package com.huateng.ebank.business.customer.operation;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts.upload.FormFile;

import resource.bean.basic.IndPermit;
import resource.bean.crms.CustPbocEntQuery;
import resource.bean.crms.CustPbocPerQuery;

import com.huateng.common.DateUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.common.service.BizLogTask;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.pboc.dao.CustPbocEntQueryDAO;
import com.huateng.report.pboc.dao.CustPbocPerQueryDAO;
import com.huateng.report.utils.ReportUtils;


/**
 * 
 * Filename:LoanersMaintainInfoOperation.java Description:借款人机构信息
 * Copyright:Copyright (c)2012 Company: HuaTeng
 */
public class IndPermitOperation2 extends BaseOperation {
    private static final HtLog htlog = HtLogFactory.getLogger(IndPermitOperation2.class);
    public static final String ID = "customer.IndPermitOperation";
    public static final String CMD = "CMD";
	public static final String IN_ORDER_FORMFILE="IN_ORDER_FORMFILE";
	public static final String FILIED_MAP="FILIED_MAP";
    @Override
    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    @SuppressWarnings("unchecked")
    @Override
    public void execute(OperationContext context) throws CommonException {
    	System.out.println("开始写入indPermit表！operation");
        String cmd = (String) context.getAttribute(CMD);
        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
        @SuppressWarnings("rawtypes")
		Map fieldMap = (Map) context.getAttribute("FILIED_MAP");
        ROOTDAO rootDao =  ROOTDAOUtils.getROOTDAO();
		try {
		    //获取变量值
	        String name=(String) fieldMap.get("form_name");
	        String individualId =(String) fieldMap.get("form_individualId");
	        String idType =(String) fieldMap.get("form_idType");
	        String fullPath=(String) fieldMap.get("filepath");
	        String date =(String) fieldMap.get("form_expireDate");
	        String time =(String) fieldMap.get("form_approveTime");
	        String id=(String) fieldMap.get("form_id");
	        if(date.indexOf("/") > 0){
	        	 String[] dates = date.split("/");
	        	 if(dates[1].length() == 1){
	        		 dates[1] = "0" + dates[1];
	        	 }
	        	 if(dates[2].length() == 1){
	        		 dates[2] = "0" + dates[2];
	        	 }
	        	 date = dates[0] + dates[1] + dates[2];
	        }
	        if(time.indexOf("/") > 0){
	        	 String[] times = time.split("/");
	        	 if(times[1].length() == 1){
	        		 times[1] = "0" + times[1];
	        	 }
	        	 if(times[2].length() == 1){
	        		 times[2] = "0" + times[2];
	        	 }
	        	 time = times[0] + times[1] + times[2];
	        }
	       
	        System.out.println("======================="+time+"=========================");
	        System.out.println("======================="+date+"=========================");
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
	        System.out.println(" parse start!!");
	        Date expireDate= sdf.parse(date);
	        Date approveTime= sdf.parse(time);
	        System.out.println(" parse end!!");
		    BusinessUploadService service=new BusinessUploadService();
		    System.out.println("query  satart!!!");
		    List<IndPermit> list=service.getIndPermitQuery(idType, name, individualId);
		    System.out.println("query  success!!");
		    if(null != list && list.size()>0){
		    	for (IndPermit indpermit : list) {
					String status=indpermit.getStatus();
					//0是无效 1是有效
					indpermit.setStatus("0");
					rootDao.saveOrUpdate(indpermit);
					System.out.println("list not null!!");
					htlog.info("修改indPermit表状态成功！");
				}
		    }
		    System.out.println("begin insert indpermit！！！！");
	        IndPermit indPermit=new IndPermit();
	        indPermit.setIndividualId(individualId);
	        indPermit.setIdType(idType);
	        indPermit.setName(name);
	        indPermit.setCustomerConUp(fullPath);
	        indPermit.setCreateUser(globalinfo.getTlrno());
	        indPermit.setInputTime(DateUtil.getTimestamp());
	        indPermit.setExpireDate(expireDate);
	        indPermit.setApproveTime(approveTime);
	        indPermit.setStatus("1");
	        rootDao.save(indPermit);
	        htlog.info("写入indPermit表成功！");
	        if(StringUtils.isNotEmpty(id)) {
	        	CustPbocPerQueryDAO dao = ROOTDAOUtils.getCustPbocPerQueryDAO();
	  	        CustPbocPerQuery custPbocPerQuery = dao.findById(id);
	  	        custPbocPerQuery.setCertAuthStatus("01");
	  	        dao.update(custPbocPerQuery);
	        }
	      
		} catch (ParseException e) {
			ExceptionUtil.throwCommonException("提交数据库失败！");
			e.printStackTrace();
		}
}
                
       

    @Override
    public void afterProc(OperationContext context) throws CommonException {
    }
}
