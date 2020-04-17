package com.huateng.ebank.business.customer.operation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import resource.bean.basic.CorpCust;
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

public class IndAppOperation extends BaseOperation{
	private static final HtLog htlog = HtLogFactory
			.getLogger(IndAppOperation.class);
	public static final String ID = "customer.IndAppOperation";
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
		List<InqCust> custList = (List) context.getAttribute(IN_PARAM);
		List<InqCust> commonList = (List) context.getAttribute(IN_COMMONLIST);
		BusinessUploadService service = new BusinessUploadService();
		List<IndPermit> listPermit = new ArrayList(); 
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String flag="0";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date nowDay = new Date();
		//获取人征信报告信息
		for (int i = 0; i < custList.size(); i++) {
			String inqCustName = custList.get(i).getInqCustName();//主借款人名称
			String inqCustId = custList.get(i).getInqCustId();//主借款人ID
			String inqCustIdType = custList.get(i).getInqCustIdType();//主借款人证件类型
			String queryReason = custList.get(i).getQueryReason();//查询原因
			String inqCustType = custList.get(i).getInqCustType();//
			String relName = custList.get(i).getRelName();//
			String relNamec = custList.get(i).getRelNamec();//
			String relCorpId = custList.get(i).getRelCorpId();
			String relCustIdType = custList.get(i).getRelCustIdType();
			String relCustId = custList.get(i).getRelCustId();
			String nonWorkhourFilepath = custList.get(i).getNonWorkhourFilepath();
	        List<IndPermit> listPermitQuery = service.getIndPermitQuery(inqCustIdType, inqCustName, inqCustId);	//查询许可文件				
			if (null !=listPermitQuery&&listPermitQuery.size() > 0) {
				String customerConUp = listPermitQuery.get(0).getCustomerConUp();
				Boolean isExpire = null;
				try {
					isExpire = service.isExpire(listPermitQuery,queryReason);
				} catch (Exception e) {
					e.printStackTrace();
				}//校验是否过期
				if(isExpire){
				if("1".equals(inqCustType)){

					List<CorpCust> listCorpCust=service.getCorpCust(relCorpId);//查询corpcust表
					if(null != listCorpCust && listCorpCust.size()>0){//公司流水表coprCust 不为空
						CorpCust corpCust=listCorpCust.get(0);
						IndApp indApp=null;
						List<IndApp> listApp=service.getIndAppQuery(inqCustIdType, inqCustName, inqCustId);//查询R天内是否有记录
						if(null == listApp || listApp.size()==0){//indApp 为空  往里面插数据，status=“1”，
							 indApp=new IndApp();
							 indApp.setIndividualId(inqCustId);
							 indApp.setName(inqCustName);
							 indApp.setIdType(inqCustIdType);
							 indApp.setQueryReason(queryReason);
							 indApp.setInputTime(nowDay);
							 indApp.setQueryTime(nowDay);
							 indApp.setReturnTime(nowDay);
							 indApp.setType("1");
							 indApp.setStatus("1");
							// indApp.setUploadedFilePath("");
							int id  =  (Integer) rootdao.save(indApp);
						}else{
							indApp=listApp.get(0);
							if(indApp.getStatus().equals("10")){
								 indApp=new IndApp();
								 indApp.setIndividualId(inqCustId);
								 indApp.setName(inqCustName);
								 indApp.setIdType(inqCustIdType);
								 indApp.setQueryReason(queryReason);
								 indApp.setInputTime(nowDay);
								 indApp.setQueryTime(nowDay);
								 indApp.setReturnTime(nowDay);
								 indApp.setType("1");
								 indApp.setStatus("1");
								 int id  =  (Integer) rootdao.save(indApp);
							}
							if(indApp.getStatus()!="0"){
								indApp.setType("1");
		            			ROOTDAOUtils.getROOTDAO().update(indApp);
							}
						}
						  // List<IndApp> listAppAfter=service.getIndAppQuery(inqCustIdType, inqCustName, inqCustId);//查询R天内是否有记录
                                                                                                                   //其实已经有记录，只是为了将记录拿出来
							// indApp=listAppAfter.get(0);
							 InqCust inqCustNew=new InqCust();
							 inqCustNew.setInqCustAppid(indApp.getId());
							 inqCustNew.setInqCustName(inqCustName);
							 inqCustNew.setInqCustId(inqCustId);
							 inqCustNew.setInqCustIdType(inqCustIdType);
							 inqCustNew.setQueryReason(queryReason);
							 inqCustNew.setInqCustType("1");
							 inqCustNew.setInqType("1");
							 inqCustNew.setRelName(relNamec);
							 inqCustNew.setCreateUser(globalinfo.getTlrno());
							 inqCustNew.setConsentFilePath(customerConUp);
							 inqCustNew.setRelCorpId(relCorpId);
							 inqCustNew.setCreateTime(nowDay);
							 inqCustNew.setNonWorkhourFilepath(nonWorkhourFilepath);
							 inqCustNew.setConfirmFlag("1");
							 inqCustNew.setCreateUserIp(globalinfo.getIp());
							 service.save(inqCustNew);  
					    
					}else{//公司流水表没查询到记录
						ExceptionUtil.throwCommonException("请先查询借款公司的征信报告！");
					}
				}else if("2".equals(inqCustType)){
					 for (int j = 0; j< commonList.size(); j++){
						 String name = commonList.get(j).getInqCustName();
						 String id=commonList.get(j).getInqCustId();
						 String idType=commonList.get(j).getInqCustIdType();
						 String queryreason=commonList.get(j).getQueryReason();
					     List<IndPermit> listPermitQueryinq = service.getIndPermitQuery(idType, name, id);	//查询许可文件
					     if(null !=listPermitQueryinq&&listPermitQueryinq.size() > 0){
					    	 try {
									isExpire = service.isExpire(listPermitQueryinq,queryreason);
								} catch (Exception e) {
									e.printStackTrace();
								}//校验是否过期
					    	 if(!isExpire){
							 ExceptionUtil.throwCommonException(id+"许可文件过期!");
						 }
					     }
						 }
					 List<IndApp> listApp=service.getIndAppQuery(inqCustIdType, inqCustName, inqCustId);//查询R天内是否有记录
					 IndApp indApp=null;
					 if(null == listApp || listApp.size()==0){
						 indApp=new IndApp();
						 indApp.setIndividualId(inqCustId);
						 indApp.setName(inqCustName);
						 indApp.setIdType(inqCustIdType);
						 indApp.setQueryReason(queryReason);
						 indApp.setQueryType("");
						 indApp.setReportFormat("");
						 indApp.setInputTime(nowDay);
						 indApp.setQueryTime(nowDay);
						 indApp.setReturnTime(nowDay);
						 indApp.setType("1");
						 indApp.setStatus("1");
						 //indApp.setUploadedFilePath("1");
  					     int id=(Integer) rootdao.save(indApp);
					 }else{
						 indApp=listApp.get(0);
						 if(indApp.getStatus().equals("10")){
							 indApp=new IndApp();
							 indApp.setIndividualId(inqCustId);
							 indApp.setName(inqCustName);
							 indApp.setIdType(inqCustIdType);
							 indApp.setQueryReason(queryReason);
							 indApp.setInputTime(nowDay);
							 indApp.setQueryTime(nowDay);
							 indApp.setReturnTime(nowDay);
							 indApp.setType("1");
							 indApp.setStatus("1");
							 int id  =  (Integer) rootdao.save(indApp);
						}
						 if(indApp.getStatus()!="0"){
								indApp.setType("1");
		            			ROOTDAOUtils.getROOTDAO().update(indApp);
							}
					 }
					// List<IndApp> listAppAfter=service.getIndAppQuery1(inqCustIdType, inqCustName, inqCustId);//再次查询R天内是否有记录
					// indApp=listAppAfter.get(0);
			         InqCust inqCustNew=new InqCust();
					 inqCustNew.setInqCustAppid(indApp.getId());
					 inqCustNew.setInqCustName(inqCustName);
					 inqCustNew.setQueryReason(queryReason);
					 inqCustNew.setInqCustId(inqCustId);
					 inqCustNew.setInqCustIdType(inqCustIdType);
					 inqCustNew.setInqCustType("2");
					 inqCustNew.setInqType("1");
					 inqCustNew.setCreateUser(globalinfo.getTlrno());
					 inqCustNew.setConsentFilePath(customerConUp);
					 inqCustNew.setCreateTime(nowDay);
					 inqCustNew.setNonWorkhourFilepath(nonWorkhourFilepath);
					 inqCustNew.setCreateUserIp(globalinfo.getIp());
					 service.save(inqCustNew);  
					
					 
					 for (int j = 0; j< commonList.size(); j++){
						 String name = commonList.get(j).getInqCustName();
						 String id=commonList.get(j).getInqCustId();
						 String idType=commonList.get(j).getInqCustIdType();
						 String queryreason=commonList.get(j).getQueryReason();
						 List<IndPermit> listPermitQueryinq = service.getIndPermitQuery(idType, name, id);
					 List<IndApp> listAppCommon=service.getIndAppQuery(idType, name, id);//查询R天内是否有记录
					 IndApp indAppCommon=null;
					 if(null == listAppCommon ||listAppCommon.size()==0){//没有记录 插indApp表
						 indAppCommon=new IndApp();
						 indAppCommon.setIndividualId(id);
						 indAppCommon.setName(name);
						 indAppCommon.setIdType(idType);
						 indAppCommon.setQueryReason(queryreason);
						 indAppCommon.setInputTime(nowDay);
						 indAppCommon.setQueryTime(nowDay);
						 indAppCommon.setReturnTime(nowDay);
						 indAppCommon.setType("1");
						 indAppCommon.setStatus("1");
						 //indAppCommon.setUploadedFilePath("");
						 int id1 =(Integer)rootdao.save(indAppCommon);
				 }else{
					 indAppCommon=listAppCommon.get(0);
					 if(indAppCommon.getStatus().equals("10")){
						 indAppCommon=new IndApp();
						 indAppCommon.setIndividualId(id);
						 indAppCommon.setName(name);
						 indAppCommon.setIdType(idType);
						 indAppCommon.setQueryReason(queryreason);
						 indAppCommon.setInputTime(nowDay);
						 indAppCommon.setQueryTime(nowDay);
						 indAppCommon.setReturnTime(nowDay);
						 indAppCommon.setType("1");
						 indAppCommon.setStatus("1");
						 //indAppCommon.setUploadedFilePath("");
						 int id1 =(Integer)rootdao.save(indAppCommon);
					}
					 if(indAppCommon.getStatus()!="0"){
						 indAppCommon.setType("1");
	            			ROOTDAOUtils.getROOTDAO().update(indAppCommon);
						}
				 }
					 
					// List<IndApp> listAppCommonAfter=service.getIndAppQuery(idType, name, id);//查询R天内是否有记录
					// indApp=listAppCommonAfter.get(0);
					 InqCust inqCustNewAfter=new InqCust();
					 inqCustNewAfter.setInqCustAppid(indAppCommon.getId());
					 inqCustNewAfter.setInqCustName(name);
					 inqCustNewAfter.setInqCustId(id);
					 inqCustNewAfter.setInqType("1");
					 inqCustNewAfter.setInqCustIdType(idType);
					 inqCustNewAfter.setInqCustType("3");
					 inqCustNewAfter.setRelName(inqCustName);
					 inqCustNewAfter.setRelCustId(inqCustId);
					 inqCustNewAfter.setQueryReason(queryreason);
					 inqCustNewAfter.setRelCustIdType(inqCustIdType);
					 inqCustNewAfter.setCreateUser(globalinfo.getTlrno());
					 inqCustNewAfter.setConsentFilePath(listPermitQueryinq.get(0).getCustomerConUp());
					 inqCustNewAfter.setCreateTime(nowDay);
					 inqCustNewAfter.setNonWorkhourFilepath(nonWorkhourFilepath);
					 inqCustNewAfter.setCreateUserIp(globalinfo.getIp());
					 service.save(inqCustNewAfter); 
					 }
				}else if("3".equals(inqCustType)){//共同借款人
						 List<InqCust> listCust=service.getInqCustQuery(relName, relCustId,relCustIdType);//查询R天内是否有记录
						 IndApp indApp=null;
						 if(null == listCust ||listCust.size()==0){
							 ExceptionUtil.throwCommonException("无主借款人记录,请先查询主借款人!");
						 }
						 
						 List<IndApp> listAppAfter=service.getIndAppQuery(inqCustIdType, inqCustName, inqCustId);//查询R天内是否有记录
                         IndApp indAppCommon=null;
						 if(null==listAppAfter||listAppAfter.size()==0){
							 indAppCommon=new IndApp();
							 indAppCommon.setIndividualId(inqCustId);
							 indAppCommon.setName(inqCustName);
							 indAppCommon.setIdType(inqCustIdType);
							 indAppCommon.setQueryReason(queryReason);
							 indAppCommon.setInputTime(nowDay);
							 indAppCommon.setQueryTime(nowDay);
							 indAppCommon.setReturnTime(nowDay);
							 indAppCommon.setType("1");
							 indAppCommon.setStatus("1");
							// indAppCommon.setUploadedFilePath("");
							 int id=(Integer) rootdao.save(indAppCommon); 
						 }else{
							 indAppCommon=listAppAfter.get(0);
							 if(indAppCommon.getStatus().equals("10")){
								 indAppCommon=new IndApp();
								 indAppCommon.setIndividualId(inqCustId);
								 indAppCommon.setName(inqCustName);
								 indAppCommon.setIdType(inqCustIdType);
								 indAppCommon.setQueryReason(queryReason);
								 indAppCommon.setInputTime(nowDay);
								 indAppCommon.setQueryTime(nowDay);
								 indAppCommon.setReturnTime(nowDay);
								 indAppCommon.setType("1");
								 indAppCommon.setStatus("1");
								// indAppCommon.setUploadedFilePath("");
								 int id=(Integer) rootdao.save(indAppCommon); 
							 }
							 if(indAppCommon.getStatus()!="0"){
								 indAppCommon.setType("1");
			            			ROOTDAOUtils.getROOTDAO().update(indAppCommon);
								}
						 }
						//List<IndApp> listAppCommAfter=service.getIndAppQuery(inqCustIdType, inqCustName, inqCustId);//查询R天内是否有记录 
						// indApp=listAppCommAfter.get(0);
						 InqCust inqCustNew=new InqCust();
						 inqCustNew.setInqCustName(inqCustName);
						 inqCustNew.setInqCustAppid(indAppCommon.getId());
						 inqCustNew.setInqCustId(inqCustId);
						 inqCustNew.setInqCustIdType(inqCustIdType);
					     //inqCustNew.setCustId(Integer.parseInt(relCustId));
						 inqCustNew.setQueryReason(queryReason);
						 inqCustNew.setInqCustType("3");
						 inqCustNew.setInqType("1");
						 inqCustNew.setRelName(relName);
						 inqCustNew.setRelCustIdType(relCustIdType);
						 inqCustNew.setConsentFilePath(customerConUp);
						 inqCustNew.setCreateUser(globalinfo.getTlrno());
						 inqCustNew.setCreateTime(nowDay);
						 inqCustNew.setNonWorkhourFilepath(nonWorkhourFilepath);
						 inqCustNew.setCreateUserIp(globalinfo.getIp());
						 service.save(inqCustNew);  
				}
				}else{
					ExceptionUtil.throwCommonException("许可文件过期!");
					}
				}else{
					flag="1";
					context.setAttribute(FLAG, flag);
					}
				
			          }

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
