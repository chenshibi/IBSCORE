package com.huateng.ebank.business.customer.operation;

import java.util.Date;
import java.util.List;

import resource.bean.basic.CorpCust;
import resource.bean.basic.IndApp;
import resource.bean.basic.IndPermit;
import resource.bean.basic.InqCust;
import resource.bean.basic.TCorpApp;
import resource.bean.basic.TCorpDetailApp;
import resource.bean.basic.TCorpPermit;

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

public class PbocBatchCorpsEnquiryEmergencyOperation extends BaseOperation{
	private static final HtLog htlog = HtLogFactory
			.getLogger(PbocBatchCorpsEnquiryEmergencyOperation.class);
	public static final String ID = "customer.PbocBatchCorpsEnquiryEmergencyOperation";
	public static final String CMD = "CMD";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String IN_INQCUSTLIST = "IN_INQCUSTLIST";
	public static final String IN_CORPCUSTLIST = "IN_CORPCUSTLIST";
	public static final String IN_COMPANYLIST = "IN_COMPANYLIST";
	public static final String IN_OPERATION = "IN_OPERATION";
	public static final String FLAG="";
	public static final String FLAGC="";
	public static final String FLAGI="";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
	}

	@SuppressWarnings({ "unchecked", "rawtypes"})
	@Override
	public void execute(OperationContext context) throws CommonException {
		GlobalInfo globalinfo = GlobalInfo.getCurrentInstance();
		List<InqCust> inqList = (List) context.getAttribute(IN_INQCUSTLIST);
		List<CorpCust> corpList = (List) context.getAttribute(IN_CORPCUSTLIST);
		List<CorpCust> companyList = (List) context.getAttribute(IN_COMPANYLIST);
		BusinessUploadService service = new BusinessUploadService();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String flag="0";
		Date nowDay = new Date();
		//获取人征信报告信息
		for (int i = 0; i < corpList.size(); i++) {
			String loanCardId = corpList.get(i).getCorpCustLoancard();
			String cardPass = corpList.get(i).getCorpCustPswd();
			String corpCustCompanyname = corpList.get(i).getCorpCustCompanyname();	
			String queryReason = corpList.get(i).getQueryReason();
			String corpCustType = corpList.get(i).getCorpCustType();
			String detailFlag = corpList.get(i).getDetailFlag();
			String relCorpId = corpList.get(i).getRelCorpId();
			String relName=corpList.get(i).getRelName();
			String nonWorkhourFilepath = corpList.get(i).getNonWorkhourFilepath();
	        List<TCorpPermit> listTCorpPermitQuery = service.getTCorpPermitQuery(loanCardId);	//查询许可文件
	        if (null !=listTCorpPermitQuery&&listTCorpPermitQuery.size() > 0){
	        	Boolean isExpire = null;
				try {
					isExpire = service.isCompanyExpire(listTCorpPermitQuery,queryReason);
				} catch (Exception e) {
					e.printStackTrace();
				}//校验是否过期
	         	if(isExpire){	
					if("2".equals(corpCustType)){ //担保公司
						CorpCust corpCust=new CorpCust();
						corpCust.setCorpCustDetailId(null);
						List<CorpCust> listCorpCust=service.getCorpCust(relCorpId);
						if(null !=listCorpCust&&listCorpCust.size()>0){//CorpCust not null
							TCorpApp tCorpApp=new TCorpApp();
							tCorpApp.setRptKey("-");
							tCorpApp.setLoanCardNo(loanCardId);
							tCorpApp.setLoanCardPass(cardPass);
							tCorpApp.setQueryReason(ruturnQueryReason(queryReason));
							tCorpApp.setCreateTime(nowDay);
							tCorpApp.setReturnTime(nowDay);
							tCorpApp.setQueryTime(nowDay);
							tCorpApp.setInputTime(nowDay);
							tCorpApp.setParsedTime(nowDay);
							tCorpApp.setStatus("1");
							tCorpApp.setType("2");
							rootdao.save(tCorpApp); 
							
							if(detailFlag.equals("1")){ //根据isdetailEnquery 决定是否插TCorpdetailApp表
								TCorpDetailApp tCorpDetailApp=new TCorpDetailApp();
								tCorpDetailApp.setRptKey("-");
								tCorpDetailApp.setLoanCardNo(loanCardId);
								tCorpDetailApp.setLoanCardPass(cardPass);
								tCorpDetailApp.setQueryReason(queryReason);
								tCorpDetailApp.setStatus("1");
								tCorpDetailApp.setType("2");
								tCorpDetailApp.setCreateTime(nowDay);
								tCorpDetailApp.setReturnTime(nowDay);
								tCorpDetailApp.setQueryTime(nowDay);
								tCorpDetailApp.setInputTime(nowDay);
								tCorpDetailApp.setParsedTime(nowDay);
								rootdao.save(tCorpDetailApp);  
								corpCust.setCorpCustDetailId(tCorpDetailApp.getId());
							}
							corpCust.setCustId(listCorpCust.get(0).getId());
							corpCust.setCorpCustAppid(tCorpApp.getId());// CorpApp取ID 
							corpCust.setCorpCustCompanyname(corpCustCompanyname);
							corpCust.setCorpCustPswd(cardPass);
							corpCust.setCorpCustLoancard(loanCardId);
							corpCust.setQueryReason(queryReason);
							corpCust.setCorpCustType(corpCustType);
							corpCust.setDetailFlag(detailFlag);
							corpCust.setRelCorpId(relCorpId);
							corpCust.setRelName(relName);
							corpCust.setNonWorkhourFilepath(nonWorkhourFilepath);
							corpCust.setCreateTime(nowDay);
							corpCust.setConfirmFlag("1");
							corpCust.setCreateUser(globalinfo.getTlrno());
							corpCust.setInqType("2");//紧急
							corpCust.setConsentFilePath(listTCorpPermitQuery.get(0).getCustomerConUp());
							corpCust.setCreateUserIp(globalinfo.getIp());
							rootdao.save(corpCust);
						
						}else{
							ExceptionUtil.throwCommonException("请先查询借款公司的征信报告！");
						}
					  }else if("1".equals(corpCustType)){
						CorpCust corpCust=new CorpCust();
						TCorpDetailApp tCorpDetailApp=new TCorpDetailApp();
						for(int j=0;j<companyList.size();j++){
							String rloanCardId = companyList.get(j).getCorpCustLoancard();
							String rcorpCustCompanyname = companyList.get(j).getCorpCustCompanyname();
							String rcorpCustQueryReason= companyList.get(j).getQueryReason();
							//根据中证码  查询公司许可文件	
					        List<TCorpPermit> listTCorpPermitQuery1 = service.getTCorpPermitQuery(rloanCardId);
					        if (listTCorpPermitQuery1.size() > 0) {
					        	try {
									isExpire = service.isCompanyExpire(listTCorpPermitQuery1,rcorpCustQueryReason);
								} catch (Exception e) {
									e.printStackTrace();
								}//校验是否过期
							if(!isExpire){
								ExceptionUtil.throwCommonException("担保公司"+rcorpCustCompanyname+"许可文件过期!");
							}
					        }else{
								ExceptionUtil.throwCommonException("担保公司"+rcorpCustCompanyname+"没有许可文件!");
								}
						}
						for(int j=0;j<inqList.size();j++){
							String inqname = inqList.get(j).getInqCustName();
							String inqid=inqList.get(j).getInqCustId();
							String inqidType=inqList.get(j).getInqCustIdType();
							String inqQueryReason=inqList.get(j).getQueryReasonInd();
					        List<IndPermit> listPermitQueryinq = service.getIndPermitQuery(inqidType, inqname, inqid);	//查询许可文件				
					        if (listPermitQueryinq.size() > 0) {
					        	try {
									isExpire = service.isExpire(listPermitQueryinq,inqQueryReason);
								} catch (Exception e) {
									e.printStackTrace();
								}//校验是否过期
							if(!isExpire){
								ExceptionUtil.throwCommonException("担保人"+inqname+"许可文件过期!");
							}
						}else{
								ExceptionUtil.throwCommonException("担保人"+inqname+"没有许可文件!");
								}
					 }
						TCorpApp tCorpApp=new TCorpApp();
						tCorpApp.setRptKey("-");
						tCorpApp.setLoanCardNo(loanCardId);
						tCorpApp.setLoanCardPass(cardPass);
						tCorpApp.setQueryReason(ruturnQueryReason(queryReason));
						tCorpApp.setCreateTime(nowDay);
						tCorpApp.setReturnTime(nowDay);
						tCorpApp.setQueryTime(nowDay);
						tCorpApp.setInputTime(nowDay);
						tCorpApp.setParsedTime(nowDay);
						tCorpApp.setStatus("1");
						tCorpApp.setType("2");
						rootdao.save(tCorpApp); 
						
						tCorpDetailApp=new TCorpDetailApp();
						if(detailFlag.equals("1")){
						tCorpDetailApp.setRptKey("-");
						tCorpDetailApp.setLoanCardNo(loanCardId);
						tCorpDetailApp.setLoanCardPass(cardPass);
						tCorpDetailApp.setQueryReason(queryReason);
						tCorpDetailApp.setStatus("1");
						tCorpDetailApp.setType("2");
						tCorpDetailApp.setCreateTime(nowDay);
						tCorpDetailApp.setReturnTime(nowDay);
						tCorpDetailApp.setQueryTime(nowDay);
						tCorpDetailApp.setInputTime(nowDay);
						tCorpDetailApp.setParsedTime(nowDay);
						rootdao.save(tCorpDetailApp);  
						}
						corpCust.setCorpCustDetailId(tCorpDetailApp.getId());
						corpCust.setCorpCustAppid(tCorpApp.getId());
						corpCust.setCorpCustCompanyname(corpCustCompanyname);
						corpCust.setCorpCustPswd(cardPass);
						corpCust.setCorpCustLoancard(loanCardId);
						corpCust.setQueryReason(queryReason);
						corpCust.setCorpCustType(corpCustType);
						corpCust.setDetailFlag(detailFlag);
						//corpCust.setRelCorpId(relCorpId);
						//corpCust.setRelName(relName);
						corpCust.setNonWorkhourFilepath(nonWorkhourFilepath);
						corpCust.setCreateTime(nowDay);
						corpCust.setCreateUser(globalinfo.getTlrno());
						corpCust.setConsentFilePath(listTCorpPermitQuery.get(0).getCustomerConUp());
						corpCust.setInqType("2");
						corpCust.setConfirmFlag("1");
						corpCust.setCreateUserIp(globalinfo.getIp());
					//	corpCust.setCustId(custId);
						//corpCust.setRelCustId(relCustId);
						rootdao.save(corpCust);
					   	for(int j=0;j<companyList.size();j++){
							String rloanCardId = companyList.get(j).getCorpCustLoancard();//
							String rcardPass = companyList.get(j).getCorpCustPswd();//
							String rcorpCustQueryReason= companyList.get(j).getQueryReason();
							CorpCust corpCustd=new CorpCust();
							corpCustd.setDetailFlag(null);
							String rcorpCustCompanyname = companyList.get(j).getCorpCustCompanyname();//
							String rdetailFlag=companyList.get(j).getDetailFlag();
							List<TCorpPermit> listTCorpPermitQuery1 = service.getTCorpPermitQuery(rloanCardId);
							TCorpApp tCorpAppc=new TCorpApp();
							tCorpAppc.setRptKey("-");
							tCorpAppc.setLoanCardNo(rloanCardId);
							tCorpAppc.setLoanCardPass(rcardPass);
							tCorpAppc.setQueryReason(ruturnQueryReason(rcorpCustQueryReason));
							tCorpAppc.setCreateTime(nowDay);
							tCorpAppc.setReturnTime(nowDay);
							tCorpAppc.setQueryTime(nowDay);
							tCorpAppc.setInputTime(nowDay);
							tCorpAppc.setParsedTime(nowDay);
							tCorpAppc.setStatus("1");
							tCorpAppc.setType("2");
							rootdao.save(tCorpAppc); 
							
							if(rdetailFlag.equals("1")){// insert T_corp_detail_app
								tCorpDetailApp=new TCorpDetailApp();
								tCorpDetailApp.setRptKey("-");
								tCorpDetailApp.setLoanCardNo(rloanCardId);
								tCorpDetailApp.setLoanCardPass(rcardPass);
								tCorpDetailApp.setQueryReason(rcorpCustQueryReason);
								tCorpDetailApp.setStatus("1");
								tCorpDetailApp.setType("2");
								tCorpDetailApp.setCreateTime(nowDay);
								tCorpDetailApp.setReturnTime(nowDay);
								tCorpDetailApp.setQueryTime(nowDay);
								tCorpDetailApp.setInputTime(nowDay);
								tCorpDetailApp.setParsedTime(nowDay);
								rootdao.save(tCorpDetailApp);  
								corpCustd.setCorpCustDetailId(tCorpDetailApp.getId());
						   }
							corpCustd.setCustId(corpCust.getId());
							corpCustd.setCorpCustDetailId(tCorpDetailApp.getId());
							corpCustd.setCorpCustAppid(tCorpAppc.getId());// CorpApp取ID 
							corpCustd.setCorpCustLoancard(rloanCardId);
							corpCustd.setQueryReason(rcorpCustQueryReason);
							corpCustd.setCorpCustPswd(rcardPass);
							corpCustd.setCorpCustCompanyname(rcorpCustCompanyname);
							corpCustd.setCorpCustType("2");
							corpCustd.setRelCorpId(loanCardId);
							corpCustd.setRelName(corpCustCompanyname);
							corpCustd.setCreateTime(nowDay);
							corpCustd.setCreateUser(globalinfo.getTlrno());
							corpCustd.setDetailFlag(rdetailFlag);
							corpCustd.setNonWorkhourFilepath(nonWorkhourFilepath);
							corpCustd.setInqType("2");//紧急
							corpCustd.setConsentFilePath(listTCorpPermitQuery1.get(0).getCustomerConUp());
							corpCustd.setConfirmFlag("1");
							corpCustd.setCreateUserIp(globalinfo.getIp());
							rootdao.save(corpCustd);
							}
						for(int j=0;j<inqList.size();j++){
							String inqname = inqList.get(j).getInqCustName();
							String inqid=inqList.get(j).getInqCustId();
							String inqidType=inqList.get(j).getInqCustIdType();
							String inqQueryReason=inqList.get(j).getQueryReasonInd();
					        List<IndPermit> listPermitQueryinq = service.getIndPermitQuery(inqidType, inqname, inqid);

							IndApp indApp=new IndApp();
							indApp.setIndividualId(inqid);
							indApp.setName(inqname);
							indApp.setIdType(inqidType);
							indApp.setQueryReason(inqQueryReason);
							indApp.setInputTime(nowDay);
							indApp.setQueryTime(nowDay);
							indApp.setReturnTime(nowDay);
							indApp.setType("2");
							indApp.setStatus("1");
							indApp.setUploadedFilePath(listPermitQueryinq.get(0).getCustomerConUp());
							rootdao.save(indApp);
							
							
							InqCust inqCust=null;
							
							inqCust=new InqCust();
							inqCust.setInqCustName(inqname);
							inqCust.setInqCustId(inqid);
							inqCust.setQueryReason(inqQueryReason);
							inqCust.setInqCustAppid(indApp.getId());
							inqCust.setCustId(corpCust.getId());
							inqCust.setInqCustIdType(inqidType);
							inqCust.setInqCustType("1");//担保人 
							inqCust.setInqType("2");//单笔
							inqCust.setRelCorpId(loanCardId);
							inqCust.setRelName(corpCustCompanyname);
							inqCust.setConsentFilePath(listPermitQueryinq.get(0).getCustomerConUp());
							inqCust.setCreateTime(nowDay);
							inqCust.setNonWorkhourFilepath(nonWorkhourFilepath);
							inqCust.setCreateUser(globalinfo.getTlrno());
							inqCust.setConfirmFlag("1");
							inqCust.setCreateUserIp(globalinfo.getIp());
							rootdao.save(inqCust);
							
						}
						
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
