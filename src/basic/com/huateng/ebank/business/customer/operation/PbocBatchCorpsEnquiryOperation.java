package com.huateng.ebank.business.customer.operation;

import java.util.Date;
import java.util.List;

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

import resource.bean.basic.CorpCust;
import resource.bean.basic.IndApp;
import resource.bean.basic.IndPermit;
import resource.bean.basic.InqCust;
import resource.bean.basic.TCorpApp;
import resource.bean.basic.TCorpDetailApp;
import resource.bean.basic.TCorpPermit;

public class PbocBatchCorpsEnquiryOperation extends BaseOperation{
	@SuppressWarnings("unused")
	private static final HtLog htlog = HtLogFactory
			.getLogger(PbocBatchCorpsEnquiryOperation.class);
	public static final String ID = "customer.PbocBatchCorpsEnquiryOperation";
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
			String entCertType=corpList.get(i).getEntCertType();
			String entCertNum=corpList.get(i).getEntCertNum();
			String serviceCode=corpList.get(i).getServiceCode();
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
						List<TCorpApp> listCorpApp=null;
						Boolean listNorCorpApp=null;
						List<TCorpDetailApp> listCorpDetailApp=null;
						TCorpApp tCorpApp=null;
						CorpCust corpCust=new CorpCust();
						corpCust.setCorpCustDetailId(null);
						TCorpDetailApp tCorpDetailApp=null;
						List<CorpCust> listCorpCust=service.getCorpCust(relCorpId);
						if(null !=listCorpCust&&listCorpCust.size()>0){//CorpCust not null 借款公司不为空
							listNorCorpApp=service.checkStatus(loanCardId);//不是0、1、2、4、9，不限制R天
							if(listNorCorpApp){
								//将批量改成单笔  corp_cust表 inq_type由0改成1
		            			//查询该担保公司查询属性
		            			CorpCust corpCustInqType=service.getCorpCust(relCorpId).get(0);
		            			if(corpCustInqType.getInqType().equals("0")){
		            				corpCustInqType.setInqType("1");
		            				ROOTDAOUtils.getROOTDAO().update(corpCustInqType);
		            			}
		            			
								listCorpApp=service.getTCorpAppQuery(loanCardId);//去TCorpApp 查询历史记录
								if(listCorpApp==null||listCorpApp.size()==0){//无，插入一条记录
									
									tCorpApp=new TCorpApp();
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
									tCorpApp.setType("1");
									rootdao.save(tCorpApp); 
									if(detailFlag.equals("1")){ //根据isdetailEnquery 决定是否插TCorpdetailApp表
										tCorpDetailApp=new TCorpDetailApp();
										tCorpDetailApp.setRptKey("-");
										tCorpDetailApp.setLoanCardNo(loanCardId);
										tCorpDetailApp.setLoanCardPass(cardPass);
										tCorpDetailApp.setQueryReason(queryReason);
										tCorpDetailApp.setStatus("1");
										tCorpDetailApp.setType("1");
										tCorpDetailApp.setCreateTime(nowDay);
										tCorpDetailApp.setReturnTime(nowDay);
										tCorpDetailApp.setParsedTime(nowDay);
										tCorpDetailApp.setQueryTime(nowDay);
										tCorpDetailApp.setInputTime(nowDay);
										rootdao.save(tCorpDetailApp);  
										corpCust.setCorpCustDetailId(tCorpDetailApp.getId()); //CorpdetailApp的 ID
									}
								}else{//TCorpApp 不为空
									tCorpApp=listCorpApp.get(0);
									if(tCorpApp.getStatus()!="0"){
				            			tCorpApp.setType("1");
				            			ROOTDAOUtils.getROOTDAO().update(tCorpApp);
									}
									if(detailFlag.equals("1")){
										listCorpDetailApp=service.getTCorpDetailAppQuery(loanCardId);
										if(listCorpDetailApp !=null&&listCorpDetailApp.size()>0){//有记录
											tCorpDetailApp=listCorpDetailApp.get(0);
											corpCust.setCorpCustDetailId(tCorpDetailApp.getId());
											if(tCorpDetailApp.getStatus()!="0"){
												tCorpDetailApp.setType("1");
						            			ROOTDAOUtils.getROOTDAO().update(tCorpDetailApp);
											}
										}
									}
								}
							}else{
								tCorpApp=new TCorpApp();
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
								tCorpApp.setType("1");
								rootdao.save(tCorpApp); 
								if(detailFlag.equals("1")){ //根据isdetailEnquery 决定是否插TCorpdetailApp表
									tCorpDetailApp=new TCorpDetailApp();
									tCorpDetailApp.setRptKey("-");
									tCorpDetailApp.setLoanCardNo(loanCardId);
									tCorpDetailApp.setLoanCardPass(cardPass);
									tCorpDetailApp.setQueryReason(queryReason);
									tCorpDetailApp.setStatus("1");
									tCorpDetailApp.setType("1");
									tCorpDetailApp.setCreateTime(nowDay);
									tCorpDetailApp.setReturnTime(nowDay);
									tCorpDetailApp.setParsedTime(nowDay);
									tCorpDetailApp.setQueryTime(nowDay);
									tCorpDetailApp.setInputTime(nowDay);
									rootdao.save(tCorpDetailApp);  
									corpCust.setCorpCustDetailId(tCorpDetailApp.getId()); //CorpdetailApp的 ID
								}
							}
						
							corpCust.setCustId(listCorpCust.get(0).getId());
							corpCust.setCorpCustAppid(tCorpApp.getId());// CorpApp取ID 
							corpCust.setCorpCustCompanyname(corpCustCompanyname);
							corpCust.setCorpCustPswd(cardPass);
							corpCust.setCorpCustLoancard(loanCardId);
							corpCust.setQueryReason(queryReason);
							corpCust.setCorpCustType(corpCustType);
							//corpCust.setCustId(custId);//关联公司的ID relName的那个ID
							//corpCust.setRelCustId(relCustId);//关联客户证件号（个人时填写）
							corpCust.setDetailFlag(detailFlag);
							corpCust.setRelCorpId(relCorpId);//关联客户中征码（企业时填写）
							corpCust.setRelName(relName);
							corpCust.setNonWorkhourFilepath(nonWorkhourFilepath);
							corpCust.setCreateTime(nowDay);
							corpCust.setCreateUser(globalinfo.getTlrno());
							corpCust.setInqType("1");//单笔
							corpCust.setConsentFilePath(listTCorpPermitQuery.get(0).getCustomerConUp());
							corpCust.setCreateUserIp(globalinfo.getIp());
							corpCust.setServiceCode(serviceCode);
							corpCust.setEntCertNum(entCertNum);
							corpCust.setEntCertType(entCertType);
							//corpCust.setConfirmFlag("1");
							rootdao.save(corpCust);
						
						}else{
							ExceptionUtil.throwCommonException("请先查询借款公司的征信报告！");
						}
					  }else if("1".equals(corpCustType)){
						CorpCust corpCust=new CorpCust();
						corpCust.setCorpCustDetailId(null);
						List<TCorpApp> listCorpApp=null;
						Boolean checkFlag;
						List<TCorpDetailApp> listCorpDetailApp=null;
						TCorpApp tCorpApp=new TCorpApp();
						TCorpDetailApp tCorpDetailApp=null;
						for(int j=0;j<companyList.size();j++){
							String rloanCardId = companyList.get(j).getCorpCustLoancard();
							String rcorpCustCompanyname = companyList.get(j).getCorpCustCompanyname();
							String rcorpCustQueryreason = companyList.get(j).getQueryReason();
							//根据中证码和名字  查询公司许可文件	
					        List<TCorpPermit> listTCorpPermitQuery1 = service.getTCorpPermitQuery(rloanCardId);
					        if (listTCorpPermitQuery1.size() > 0) {
					        	try {
									isExpire = service.isCompanyExpire(listTCorpPermitQuery1,rcorpCustQueryreason);
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
						checkFlag=service.checkStatus(loanCardId);//不是0、1、2、4、9，不限制R天
						if(checkFlag){
						listCorpApp=service.getTCorpAppQuery(loanCardId);//去TCorpcust 查询历史记录
						if(listCorpApp==null||listCorpApp.size()==0){//无，插入一条记录
							
							tCorpApp=new TCorpApp();
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
							tCorpApp.setType("1");
							rootdao.save(tCorpApp); 
							if(detailFlag.equals("1")){ //根据isdetailEnquery 决定是否插TCorpdetailApp表
								tCorpDetailApp=new TCorpDetailApp();
								tCorpDetailApp.setRptKey("-");
								tCorpDetailApp.setLoanCardNo(loanCardId);
								tCorpDetailApp.setLoanCardPass(cardPass);
								tCorpDetailApp.setQueryReason(queryReason);
								tCorpDetailApp.setStatus("1");
								tCorpDetailApp.setType("1");
								tCorpDetailApp.setCreateTime(nowDay);
								tCorpDetailApp.setReturnTime(nowDay);
								tCorpDetailApp.setQueryTime(nowDay);
								tCorpDetailApp.setInputTime(nowDay);
								tCorpDetailApp.setParsedTime(nowDay);
								rootdao.save(tCorpDetailApp);  
								corpCust.setCorpCustDetailId(tCorpDetailApp.getId());
							}
						}else{//TCorpApp 不为空
							tCorpApp=listCorpApp.get(0);
							if(tCorpApp.getStatus()!="0"){
		            			tCorpApp.setType("1");
		            			ROOTDAOUtils.getROOTDAO().update(tCorpApp);
							}
							if(detailFlag.equals("1")){
								listCorpDetailApp=service.getTCorpDetailAppQuery(loanCardId);
								if(listCorpDetailApp !=null&&listCorpDetailApp.size()>0){//有记录
									tCorpDetailApp=listCorpDetailApp.get(0);
									corpCust.setCorpCustDetailId(tCorpDetailApp.getId());
									if(tCorpDetailApp.getStatus()!="0"){
										tCorpDetailApp.setType("1");
				            			ROOTDAOUtils.getROOTDAO().update(tCorpDetailApp);
									}
								}
							}
						}
					  }else{
						//无，插入一条记录
							
							tCorpApp=new TCorpApp();
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
							tCorpApp.setType("1");
							rootdao.save(tCorpApp); 
							if(detailFlag.equals("1")){ //根据isdetailEnquery 决定是否插TCorpdetailApp表
								tCorpDetailApp=new TCorpDetailApp();
								tCorpDetailApp.setRptKey("-");
								tCorpDetailApp.setLoanCardNo(loanCardId);
								tCorpDetailApp.setLoanCardPass(cardPass);
								tCorpDetailApp.setQueryReason(queryReason);
								tCorpDetailApp.setStatus("1");
								tCorpDetailApp.setType("1");
								tCorpDetailApp.setCreateTime(nowDay);
								tCorpDetailApp.setReturnTime(nowDay);
								tCorpDetailApp.setQueryTime(nowDay);
								tCorpDetailApp.setInputTime(nowDay);
								tCorpDetailApp.setParsedTime(nowDay);
								rootdao.save(tCorpDetailApp);  
								corpCust.setCorpCustDetailId(tCorpDetailApp.getId());
							}
						
					  }
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
						corpCust.setInqType("1");
						corpCust.setConfirmFlag("1");
						corpCust.setCreateUserIp(globalinfo.getIp());
						corpCust.setServiceCode(serviceCode);
						corpCust.setEntCertType(entCertType);
						corpCust.setEntCertNum(entCertNum);
					//	corpCust.setCustId(custId);
						//corpCust.setRelCustId(relCustId);
						rootdao.save(corpCust);
						for(int j=0;j<companyList.size();j++){
							CorpCust corpCustd=new CorpCust();
							TCorpApp tCorpApp1=new TCorpApp();
							String rloanCardId = companyList.get(j).getCorpCustLoancard();
							String rcardPass = companyList.get(j).getCorpCustPswd();
							String rcorpCustCompanyname = companyList.get(j).getCorpCustCompanyname();
							String rdetailFlag=companyList.get(j).getDetailFlag();
							String rcorpCustQueryreason = companyList.get(j).getQueryReason();
					        List<TCorpPermit> listTCorpPermitQuery1 = service.getTCorpPermitQuery(rloanCardId);
					        Boolean listNorCorpApp;
					        listNorCorpApp=service.checkStatus(rloanCardId);//不是0、1、2、4、9，不限制R天
							tCorpDetailApp=new TCorpDetailApp();
							if(listNorCorpApp){
							listCorpApp=service.getTCorpAppQuery(rloanCardId);
							if(listCorpApp==null||listCorpApp.size()==0){//TCorpApp   查询是否有查询记录
								// insert T_corp_app
								tCorpApp1.setRptKey("-");
								tCorpApp1.setLoanCardNo(rloanCardId);
								tCorpApp1.setLoanCardPass(rcardPass);
								tCorpApp1.setQueryReason(ruturnQueryReason(rcorpCustQueryreason));
								tCorpApp1.setCreateTime(nowDay);
								tCorpApp1.setReturnTime(nowDay);
								tCorpApp1.setQueryTime(nowDay);
								tCorpApp1.setInputTime(nowDay);
								tCorpApp1.setParsedTime(nowDay);
								tCorpApp1.setStatus("1");
								tCorpApp1.setType("1");
								rootdao.save(tCorpApp1);  
								if(rdetailFlag.equals("1")){// insert T_corp_detail_app
									tCorpDetailApp.setRptKey("-");
									tCorpDetailApp.setLoanCardNo(rloanCardId);
									tCorpDetailApp.setLoanCardPass(rcardPass);
									tCorpDetailApp.setQueryReason(rcorpCustQueryreason);
									tCorpDetailApp.setStatus("1");
									tCorpDetailApp.setType("1");
									tCorpDetailApp.setCreateTime(nowDay);
									tCorpDetailApp.setReturnTime(nowDay);
									tCorpDetailApp.setQueryTime(nowDay);
									tCorpDetailApp.setInputTime(nowDay);
									tCorpDetailApp.setParsedTime(nowDay);
									rootdao.save(tCorpDetailApp);  
									corpCustd.setCorpCustDetailId(tCorpDetailApp.getId());
							   }
							}else{//TCorpApp   not null
								tCorpApp1=listCorpApp.get(0);
								if(tCorpApp1.getStatus()!="0"){
									tCorpApp1.setType("1");
			            			ROOTDAOUtils.getROOTDAO().update(tCorpApp1);
								}
								if(rdetailFlag.equals("1")){
									listCorpDetailApp=service.getTCorpDetailAppQuery(rloanCardId);
									if(listCorpDetailApp !=null&&listCorpDetailApp.size()>0){
										tCorpDetailApp=listCorpDetailApp.get(0);
										corpCustd.setCorpCustDetailId(tCorpDetailApp.getId());
										if(tCorpDetailApp.getStatus()!="0"){
											tCorpDetailApp.setType("1");
					            			ROOTDAOUtils.getROOTDAO().update(tCorpDetailApp);
										}
									}
								}
							}
							}else{
								//TCorpApp   查询是否有查询记录
								// insert T_corp_app
								tCorpApp1.setRptKey("-");
								tCorpApp1.setLoanCardNo(rloanCardId);
								tCorpApp1.setLoanCardPass(rcardPass);
								tCorpApp1.setQueryReason(ruturnQueryReason(rcorpCustQueryreason));
								tCorpApp1.setCreateTime(nowDay);
								tCorpApp1.setReturnTime(nowDay);
								tCorpApp1.setQueryTime(nowDay);
								tCorpApp1.setInputTime(nowDay);
								tCorpApp1.setParsedTime(nowDay);
								tCorpApp1.setStatus("1");
								tCorpApp1.setType("1");
								rootdao.save(tCorpApp1);  
								if(rdetailFlag.equals("1")){// insert T_corp_detail_app
									tCorpDetailApp.setRptKey("-");
									tCorpDetailApp.setLoanCardNo(rloanCardId);
									tCorpDetailApp.setLoanCardPass(rcardPass);
									tCorpDetailApp.setQueryReason(rcorpCustQueryreason);
									tCorpDetailApp.setStatus("1");
									tCorpDetailApp.setType("1");
									tCorpDetailApp.setCreateTime(nowDay);
									tCorpDetailApp.setReturnTime(nowDay);
									tCorpDetailApp.setQueryTime(nowDay);
									tCorpDetailApp.setInputTime(nowDay);
									tCorpDetailApp.setParsedTime(nowDay);
									rootdao.save(tCorpDetailApp);  
									corpCustd.setCorpCustDetailId(tCorpDetailApp.getId());
							   }
							
							}
							corpCustd.setCorpCustAppid(tCorpApp1.getId());
							corpCustd.setCorpCustLoancard(rloanCardId);
							corpCustd.setQueryReason(rcorpCustQueryreason);
							corpCustd.setCorpCustPswd(rcardPass);
							corpCustd.setCorpCustCompanyname(rcorpCustCompanyname);
							corpCustd.setCorpCustType("2");
							corpCustd.setRelCorpId(loanCardId);//关联客户中征码（企业时填写）
							corpCustd.setCustId(corpCust.getId());
							corpCustd.setRelName(corpCustCompanyname);
							corpCustd.setCreateTime(nowDay);
							corpCustd.setCreateUser(globalinfo.getTlrno());
							corpCustd.setConsentFilePath(listTCorpPermitQuery1.get(0).getCustomerConUp());
							corpCustd.setDetailFlag(rdetailFlag);
							corpCustd.setNonWorkhourFilepath(nonWorkhourFilepath);
							corpCustd.setInqType("1");
							corpCustd.setConfirmFlag("1");
							corpCustd.setCreateUserIp(globalinfo.getIp());
							corpCustd.setServiceCode(serviceCode);
							corpCustd.setEntCertType(entCertType);
							corpCustd.setEntCertNum(entCertNum);
							rootdao.save(corpCustd);
							}
						for(int j=0;j<inqList.size();j++){
							String inqname = inqList.get(j).getInqCustName();
							String inqid=inqList.get(j).getInqCustId();
							String inqidType=inqList.get(j).getInqCustIdType();
							String inqQueryReason=inqList.get(j).getQueryReasonInd();
					        List<IndPermit> listPermitQueryinq = service.getIndPermitQuery(inqidType, inqname, inqid);	
					        List<IndApp> listinqApp=service.getIndAppQuery(inqidType, inqname, inqid);//查询R天内是否有记录
							IndApp indApp=null;
							InqCust inqCust=null;
							if(null==listinqApp||listinqApp.size()==0){
								indApp=new IndApp();
								indApp.setIndividualId(inqid);
								indApp.setName(inqname);
								indApp.setIdType(inqidType);
								indApp.setQueryReason(inqQueryReason);
								indApp.setInputTime(nowDay);
								indApp.setQueryTime(nowDay);
								indApp.setReturnTime(nowDay);
								indApp.setType("1");
								indApp.setStatus("1");
								indApp.setUploadedFilePath(listPermitQueryinq.get(0).getCustomerConUp());
								rootdao.save(indApp);
							}else{
								indApp=listinqApp.get(0);
								if(indApp.getStatus()!="0"){
									indApp.setType("1");
			            			ROOTDAOUtils.getROOTDAO().update(indApp);
								}
							}
							
							inqCust=new InqCust();
							inqCust.setInqCustName(inqname);
							inqCust.setInqCustId(inqid);
							inqCust.setInqCustIdType(inqidType);
							inqCust.setQueryReason(inqQueryReason);
							inqCust.setInqCustAppid(indApp.getId());
							inqCust.setCustId(corpCust.getId());
							inqCust.setInqCustType("1");//担保人 
							inqCust.setInqType("1");//单笔
							inqCust.setRelCorpId(loanCardId);
							inqCust.setRelName(corpCustCompanyname);
							inqCust.setConsentFilePath(listPermitQueryinq.get(0).getCustomerConUp());
							inqCust.setNonWorkhourFilepath(nonWorkhourFilepath);
							inqCust.setCreateTime(nowDay);
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
