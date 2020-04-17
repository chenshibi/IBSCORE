package com.huateng.ebank.business.customer.operation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.basic.FileSubmit;

/**
 * 
 * Filename:LoanersMaintainInfoOperation.java Description:借款人机构信息
 * Copyright:Copyright (c)2012 Company: HuaTeng
 */
public class FileGroupUploadOperation extends BaseOperation {
	private static final HtLog htlog = HtLogFactory
			.getLogger(FileGroupUploadOperation.class);
	public static final String ID = "customer.FileGroupUploadOperation";
	public static final String CMD = "CMD";
	public static final String IN_ORDER_FORMFILE = "IN_ORDER_FORMFILE";
	public static final String FILIED_MAP = "FILIED_MAP";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public void execute(OperationContext context) throws CommonException {
		System.out.println("开始写入FileSubmint表！operation");
		String cmd = (String) context.getAttribute(CMD);
		GlobalInfo globalinfo = GlobalInfo.getCurrentInstance();
		@SuppressWarnings("rawtypes")
		Map fieldMap = (Map) context.getAttribute("FILIED_MAP");
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		try {
			// 获取变量值
			String name = (String) fieldMap.get("fileName");
			String fullPath = (String) fieldMap.get("filepath");
			String form_sgement = (String) fieldMap.get("form_sgement");
			String form_product = (String) fieldMap.get("form_product");
			String form_scope = (String) fieldMap.get("form_scope");
			String form_note = (String) fieldMap.get("form_note");
			String form_effectiveDate = (String)fieldMap.get("form_effectiveDate");
			String form_expireDate = (String)fieldMap.get("form_expireDate");
			String form_flag = (String) fieldMap.get("form_flag");
			String form_fileType = (String) fieldMap.get("form_fileType");
			String form_city=(String) fieldMap.get("form_city");
			StringBuffer sb=new StringBuffer();
			StringBuffer sf=new StringBuffer();
			sb.append("select * FROM file_submit where file_name like").append("'").append("%").append(name).append("%").append("'");
		//	int size =rootDao.executeSql(sb.toString());
			Iterator it = rootDao.queryBySQL2(sb.toString());
			if(it!=null) {
				while(it.hasNext()) {
					Map map = (Map)it.next();
					FileSubmit fileSubmit = new FileSubmit();
					if(map.get("id")!=null) {
						fileSubmit.setId(Integer.valueOf(map.get("id").toString()));
						rootDao.delete(fileSubmit);
					}
				}
			}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String inputTime = sdf.format(date);
				System.out.println("begin insert fileSubmint！！！！");
				FileSubmit fileSubmit = new FileSubmit();
				fileSubmit.setFileName(name);
				fileSubmit.setFilePath(fullPath);
				fileSubmit.setCreateUser(globalinfo.getTlrno());
				fileSubmit.setInputTime(inputTime);
				fileSubmit.setStatus("1");
				fileSubmit.setSgement(form_sgement);
				fileSubmit.setProduct(form_product);
				fileSubmit.setScope(form_scope);
				fileSubmit.setNote(form_note);
				fileSubmit.setEffectiveDate(form_effectiveDate);
				fileSubmit.setExpireDate(form_expireDate);
				fileSubmit.setFlag(form_flag);
				fileSubmit.setCity(form_city);
				fileSubmit.setFileType(form_fileType);
				rootDao.save(fileSubmit);
				htlog.info("写入fileSubmint表成功！");
				System.out.println("写入fileSubmint表成功！");
		} catch (Exception e) {
			ExceptionUtil.throwCommonException("提交数据库失败！");
			e.printStackTrace();
		}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
	}
}
