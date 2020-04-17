package com.huateng.ebank.business.customer.operation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import resource.bean.basic.CorpCust;
import resource.bean.basic.FileSubmit;
import resource.bean.basic.IndApp;
import resource.bean.basic.IndPermit;
import resource.bean.basic.InqCust;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class EditFileOperation extends BaseOperation{
	private static final HtLog htlog = HtLogFactory
			.getLogger(EditFileOperation.class);
	public static final String ID = "customer.EditFileOperation";
	public static final String CMD = "CMD";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String IN_COMMONLIST = "IN_COMMONLIST";
	public static final String IN_OPERATION = "IN_OPERATION";
	public static final String FLAG="";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo globalinfo = GlobalInfo.getCurrentInstance();
		List<FileSubmit> fileSubmitList = (List) context.getAttribute(IN_PARAM);
		BusinessUploadService service = new BusinessUploadService();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date nowDay = new Date();
		//获取人征信报告信息
		FileSubmit fileSubmit = fileSubmitList.get(0);
		int fileId = fileSubmit.getId();
		String scope = fileSubmit.getScope();
		String sgement = fileSubmit.getSgement();
		String product = fileSubmit.getProduct();
		String flag = fileSubmit.getFlag();
		String note = fileSubmit.getNote();
		String whereString = "select po from FileSubmit po where id = ? ";
		ArrayList condList = new ArrayList();
		condList.add(fileId);
		List<FileSubmit> fileSubmitYuanList = rootdao.queryByCondition(whereString,condList.toArray());
		FileSubmit fileSubmitYuan = fileSubmitYuanList.get(0);
		fileSubmitYuan.setScope(scope);
		fileSubmitYuan.setSgement(sgement);
		fileSubmitYuan.setFlag(flag);
		fileSubmitYuan.setNote(note);
		fileSubmitYuan.setProduct(product);
		rootdao.save(fileSubmitYuan);
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}

	// 算时间差
	public static int daysBetween(Date date1, Date date2) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		date1 = sdf.parse(sdf.format(date1));
		date2 = sdf.parse(sdf.format(date2));
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		long between_days = (time1 - time2) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}
}
