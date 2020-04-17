package com.huateng.ebank.business.customer.update;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import resource.bean.basic.AssureIndApp;
import resource.bean.basic.AssureIndCust;
import resource.bean.basic.IndPermit;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.AssureIndAppService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class NaturePersonQueryEmergencyOperation extends BaseOperation{
	@SuppressWarnings("unused")
	private static final HtLog htlog = HtLogFactory
			.getLogger(NaturePersonQueryEmergencyOperation.class);
	public static final String ID = "customer.NaturePersonQueryEmergencyOperation";
	public static final String IN_PARAM = "IN_PARAM";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo globalinfo = GlobalInfo.getCurrentInstance();
		List<AssureIndApp> assureIndAppList = (List) context.getAttribute(IN_PARAM);
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		AssureIndAppService service= new AssureIndAppService();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date nowDay = new Date();
		//获取人征信报告信息
		for (int i = 0; i < assureIndAppList.size(); i++) {
			String rptKey=assureIndAppList.get(i).getRptKey();
			String individualIdType=assureIndAppList.get(i).getIndividualIdType();
			String individualId=assureIndAppList.get(i).getIndividualId();
			String name=assureIndAppList.get(i).getName();
//			String inputUser=assureIndAppList.get(i).getInputUser();
//			Date inputTime=assureIndAppList.get(i).getInputTime();
//			Date queryTime=assureIndAppList.get(i).getQueryTime();
//			Date returnTime=assureIndAppList.get(i).getReturnTime();
//			Date parseTime=assureIndAppList.get(i).getParseTime();
			String status=assureIndAppList.get(i).getStatus();
			String consentFilePath=assureIndAppList.get(i).getConsentFilePath();
			//String inputUserIp=assureIndAppList.get(i).getInputUserIp();
			String nonConsentFilePath=assureIndAppList.get(i).getNonConsentFilePath();
			List<IndPermit> listPermitQuery = service.getIndPermitQuery(individualIdType, name, individualId);	//查询许可文件				
			AssureIndCust assureIndCust = new AssureIndCust();
			AssureIndApp assureIndApp = new AssureIndApp();
			assureIndApp.setRptKey("-");
			assureIndApp.setIndividualIdType(individualIdType);
			assureIndApp.setType("2");
			assureIndApp.setIndividualId(individualId);
			assureIndApp.setName(name);
			assureIndApp.setInputUser(globalinfo.getTlrno());
			assureIndApp.setInputTime(nowDay);
			assureIndApp.setQueryTime(nowDay);
			assureIndApp.setReturnTime(nowDay);
			assureIndApp.setParseTime(nowDay);
			assureIndApp.setStatus("1");
			assureIndApp.setConsentFilePath(listPermitQuery.get(0).getCustomerConUp());
			assureIndApp.setInputUserIp(globalinfo.getIp());
			assureIndApp.setNonConsentFilePath(nonConsentFilePath);
			rootdao.save(assureIndApp);
			assureIndCust.setAppId(assureIndApp.getId().toString());
			assureIndCust.setIndividualIdType(individualIdType);
			assureIndCust.setIndividualId(individualId);
			assureIndCust.setName(name);
			assureIndCust.setInputUser(globalinfo.getTlrno());
			assureIndCust.setInputTime(nowDay);
			assureIndCust.setConsentFilePath(listPermitQuery.get(0).getCustomerConUp());
			assureIndCust.setInputUserIp(globalinfo.getIp());
			assureIndCust.setNonConsentFilePath(nonConsentFilePath);
			rootdao.save(assureIndCust);
		}

	}

	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub

	}
	
	
	 
}
