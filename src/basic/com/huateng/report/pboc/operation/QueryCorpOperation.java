package com.huateng.report.pboc.operation;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.excel.imp.QueryUntils;
import com.huateng.report.dao.CrComEaaDAO;
import com.huateng.report.pboc.dao.CustPbocEntQueryDAO;
import com.huateng.report.pboc.util.Constant;
import com.huateng.report.service.NewSysParamsService;

import resource.bean.basic.TCorpPermit;
import resource.bean.crms.CrComEaa;
import resource.bean.crms.CustPbocEntQuery;

/**
 * 
 * @author Grassy
 *
 */
public class QueryCorpOperation extends BaseOperation {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(QueryCorpOperation.class);
    @Override
    public void beforeProc(OperationContext context) throws CommonException {
     
    }

    @Override
    public void execute(OperationContext context) {
        CustPbocEntQueryDAO dao = ROOTDAOUtils.getCustPbocEntQueryDAO();
        CrComEaaDAO crComEaaDAO = ROOTDAOUtils.getCrComEaaDAO();
        BusinessUploadService service=new BusinessUploadService();
        NewSysParamsService sysParamsService = NewSysParamsService.getInstance();
        if ("INSERT".equals(context.getAttribute("CMD"))) {
            Map<String, String> map = (Map<String, String>) context.getAttribute("CorpMakeMap");
            GlobalInfo globalInfo;
			try {
				globalInfo = GlobalInfo.getCurrentInstance();
				CustPbocEntQuery custPbocEntQuery = new CustPbocEntQuery();
				//Common Fields
				custPbocEntQuery.setCreateTime(DateUtil.get14Time());
				custPbocEntQuery.setCreateUser(globalInfo.getTlrno());
				custPbocEntQuery.setQueryDate(DateUtil.get8Date());
				custPbocEntQuery.setSendTime(DateUtil.get14Time());
				//Biz Fields
				custPbocEntQuery.setEntName(map.get("entName"));
				custPbocEntQuery.setEntCertType(map.get("entCertType"));
				custPbocEntQuery.setEntCertNum(map.get("entCertNum"));
				custPbocEntQuery.setQueryReason(map.get("queryReason"));
				custPbocEntQuery.setServiceCode(map.get("serviceCode"));
				if(null!=map.get("queryLevel")) {
					custPbocEntQuery.setQueryLevel(map.get("queryLevel"));
				}
				//已录入
				custPbocEntQuery.setStatus("00");
				custPbocEntQuery.setRsv4(QueryUntils.getRegionNo(globalInfo.getTlrno()));
				custPbocEntQuery.setRsv3(DateUtil.get6Date());
				custPbocEntQuery.setRsv7(GlobalInfo.getCurrentInstance().getIp());
				custPbocEntQuery.setRsv8(sysParamsService.getBankCode());
				//custPbocEntQuery.setRsv9(globalInfo.getTlrno());
			/*	int size = QueryUntils.QueryMatching(map.get("entCertNum"), DataMyUtil.get16Date());
				if (size > 0) {
					custPbocEntQuery.setCertAuthStatus(QueryUntils.Successful);
				} else {
					custPbocEntQuery.setCertAuthStatus(QueryUntils.Default);
				}*/
				List<TCorpPermit> list = service.getTCorpPermitQuery(map.get("entCertNum"));
				if(list!=null&&list.size()>0 ) {
					custPbocEntQuery.setCertAuthStatus(QueryUntils.Successful);
					custPbocEntQuery.setRsv10((list.get(0).getId().toString()));
				}else {
					custPbocEntQuery.setCertAuthStatus(QueryUntils.Default);
				}
				dao.save(custPbocEntQuery);
				context.setAttribute("id", custPbocEntQuery.getId());
			} catch (CommonException e) {
				e.printStackTrace();
			}
        }else if("BatchUpdate".equals(context.getAttribute("CMD"))){
       	 String uuid = (String) context.getAttribute("rptId");
         String status = (String) context.getAttribute("status");
         String respCode = (String) context.getAttribute("respCode");
         String respMsg = (String) context.getAttribute("respMsg");
         String id=(String) context.getAttribute("id");
         CustPbocEntQuery custPbocEntQuery = dao.findById(id);
         if (StringUtils.equals("success", status) && StringUtils.equals("0000",respCode)) {
        	 custPbocEntQuery.setStatus(Constant.RESP_QUERY_STATUS);
        	 custPbocEntQuery.setRespId(uuid);
        	 CrComEaa crComEaa = crComEaaDAO.findById(uuid);
        	 custPbocEntQuery.setRsv9(crComEaa.getEa01ai01());
         } else {
        	 custPbocEntQuery.setStatus(Constant.FAIL_QUERY_STATUS);
         }
         custPbocEntQuery.setQueryLevel("0");
         custPbocEntQuery.setQueryDate(DateUtil.get8Date());
	     custPbocEntQuery.setSendTime(DateUtil.get14Time());
	     custPbocEntQuery.setRespCode(respCode);
	     custPbocEntQuery.setRespMsg(StringUtils.substring(respMsg, 0, 1000));
	     custPbocEntQuery.setRespTime(DateUtil.get14Time());
         dao.update(custPbocEntQuery);
        }else if("ReQuery".equals(context.getAttribute("CMD"))) {
       	 GlobalInfo globalInfo;
       	 try {
				  globalInfo = GlobalInfo.getCurrentInstance();
				  Map<String, String> map = (Map<String, String>) context.getAttribute("reQueryMap");
				  String id=map.get("id").toString();
				  CustPbocEntQuery custPbocEntQuery = dao.findById(id);
				  CustPbocEntQuery custPbocEntQuery2=new CustPbocEntQuery();
				  BeanUtils.copyProperties(custPbocEntQuery, custPbocEntQuery2);
				  custPbocEntQuery2.setCreateUser(globalInfo.getTlrno());
				  custPbocEntQuery2.setCreateTime(DateUtil.get14Time());
				  custPbocEntQuery2.setQueryDate(DateUtil.get8Date());
				  custPbocEntQuery2.setSendTime(DateUtil.get14Time());
				  custPbocEntQuery2.setStatus("00");
				  custPbocEntQuery2.setRsv3(DateUtil.get6Date());
				  custPbocEntQuery2.setRsv4(QueryUntils.getRegionNo(globalInfo.getTlrno()));
				  custPbocEntQuery2.setRsv7(GlobalInfo.getCurrentInstance().getIp());
				  dao.save(custPbocEntQuery2);
				  context.setAttribute("id", custPbocEntQuery2.getId());
			} catch (CommonException e) {
				e.printStackTrace();
			}
       }
        
        else {
        	 String uuid = (String) context.getAttribute("uuid");
             String status = (String) context.getAttribute("status");
             String respCode = (String) context.getAttribute("respCode");
             String respMsg = (String) context.getAttribute("respMsg");
             String id=(String) context.getAttribute("id");
             CustPbocEntQuery custPbocEntQuery = dao.findById(id);
             if (StringUtils.equals("success", status) && StringUtils.equals("0000",respCode)) {
            	 CrComEaa crComEaa = crComEaaDAO.findById(uuid);
            	 custPbocEntQuery.setRsv9(crComEaa.getEa01ai01());
            	 custPbocEntQuery.setStatus(Constant.RESP_QUERY_STATUS);
            	 custPbocEntQuery.setRespId(uuid);
             } else if("9999".equals(respCode)){
            	 custPbocEntQuery.setStatus(Constant.FAIL_QUERY_STATUS);
                 context.setAttribute("entCertNum",custPbocEntQuery.getEntCertNum());
                 context.setAttribute("entName", custPbocEntQuery.getEntName());
             } else {
            	 custPbocEntQuery.setStatus(Constant.FAIL_QUERY_STATUS);
             }
             custPbocEntQuery.setRespCode(respCode);
             custPbocEntQuery.setRespMsg(StringUtils.substring(respMsg, 0, 1000));
             custPbocEntQuery.setRespTime(DateUtil.get14Time());
             dao.update(custPbocEntQuery);
        }

    }


    @Override
    public void afterProc(OperationContext context) throws CommonException {

    }
}
