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
import com.huateng.report.pboc.dao.CustPbocPerQueryDAO;
import com.huateng.report.pboc.util.Constant;
import com.huateng.report.service.NewSysParamsService;

import resource.bean.basic.IndPermit;
import resource.bean.crms.CustPbocPerQuery;

/**
 * 
 * @author Grassy
 *
 */
public class QueryPersonalOperation extends BaseOperation {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(QueryPersonalOperation.class);
    @Override
    public void beforeProc(OperationContext context) throws CommonException {

    }

    @Override
    public void execute(OperationContext context) {
        CustPbocPerQueryDAO dao = ROOTDAOUtils.getCustPbocPerQueryDAO();
        BusinessUploadService service=new BusinessUploadService();
        NewSysParamsService sysParamsService = NewSysParamsService.getInstance();
        if ("INSERT".equals(context.getAttribute("CMD"))) {
            Map<String, String> map = (Map<String, String>) context.getAttribute("PersonalMakeMap");
            GlobalInfo globalInfo;
			try {
				globalInfo = GlobalInfo.getCurrentInstance();
				CustPbocPerQuery custPbocPerQuery = new CustPbocPerQuery();
				//Common Fields
				custPbocPerQuery.setRsv2("00"); //接口标识
				custPbocPerQuery.setCreateTime(DateUtil.get14Time());
				custPbocPerQuery.setCreateUser(globalInfo.getTlrno());
				custPbocPerQuery.setQueryDate(DateUtil.get8Date());
				custPbocPerQuery.setSendTime(DateUtil.get14Time());
				//Biz Fields
				custPbocPerQuery.setName(map.get("name"));
				custPbocPerQuery.setIdType(map.get("idType"));
				custPbocPerQuery.setIdNum(map.get("idNum"));
				custPbocPerQuery.setQueryReason(map.get("queryReason"));
				if(null!=map.get("queryLevel")) {
					custPbocPerQuery.setQueryLevel(map.get("queryLevel"));
				}
				if("00".equals(map.get("serviceCode"))) {
					custPbocPerQuery.setServiceCode("FW_GRXYBG_0074");
				}else {
					custPbocPerQuery.setServiceCode("FW_GRXYBG_0010");
				}
				//已录入
				custPbocPerQuery.setStatus("00");
				//custPbocPerQuery.setRsv3(DateUtil.get6Date());
				custPbocPerQuery.setRsv4(QueryUntils.getRegionNo(globalInfo.getTlrno()));
				custPbocPerQuery.setRsv7(GlobalInfo.getCurrentInstance().getIp());
				custPbocPerQuery.setRsv8(sysParamsService.getBankCode());
			//	custPbocPerQuery.setRsv9(globalInfo.getTlrno());
				/*int size = QueryUntils.QueryMatchingPersoanl(map.get("idNum"), DataMyUtil.get16Date());
				if (size > 0) {
					custPbocPerQuery.setCertAuthStatus(QueryUntils.Successful);
				} else {
					custPbocPerQuery.setCertAuthStatus(QueryUntils.Default);
				}*/
				List<IndPermit> list=service.getIndPermitQuery(map.get("idType"), map.get("name"), map.get("idNum"));
				if(list!=null&&list.size()>0 ) {
					custPbocPerQuery.setCertAuthStatus(QueryUntils.Successful);
					custPbocPerQuery.setRsv10((list.get(0).getId().toString()));
				}else {
					custPbocPerQuery.setCertAuthStatus(QueryUntils.Default);
				}
				dao.save(custPbocPerQuery);
				context.setAttribute("id", custPbocPerQuery.getId());
			} catch (CommonException e) {
				e.printStackTrace();
			}
        }else if("ReQuery".equals(context.getAttribute("CMD"))) {
        	 GlobalInfo globalInfo;
        	 try {
				  globalInfo = GlobalInfo.getCurrentInstance();
				  Map<String, String> map = (Map<String, String>) context.getAttribute("reQueryMap");
				  String id=map.get("id").toString();
				  CustPbocPerQuery custPbocPerQuery = dao.findById(id);
				  CustPbocPerQuery custPbocPerQuery2=new CustPbocPerQuery();
				  BeanUtils.copyProperties(custPbocPerQuery, custPbocPerQuery2);
				  custPbocPerQuery2.setCreateUser(globalInfo.getTlrno());
				  custPbocPerQuery2.setCreateTime(DateUtil.get14Time());
				  custPbocPerQuery2.setQueryDate(DateUtil.get8Date());
				  custPbocPerQuery2.setSendTime(DateUtil.get14Time());
				  custPbocPerQuery2.setStatus("00");
				  //custPbocPerQuery2.setRsv3(DateUtil.get6Date());
				  custPbocPerQuery2.setRsv4(QueryUntils.getRegionNo(globalInfo.getTlrno()));
				  custPbocPerQuery2.setRsv7(GlobalInfo.getCurrentInstance().getIp());
				  custPbocPerQuery2.setQueryLevel("0");
				  dao.save(custPbocPerQuery2);
				  context.setAttribute("id", custPbocPerQuery2.getId());
			} catch (CommonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        else if("BatchUpdate".equals(context.getAttribute("CMD"))){
         	 String uuid = (String) context.getAttribute("rptId");
             String status = (String) context.getAttribute("status");
             String respCode = (String) context.getAttribute("respCode");
             String respMsg = (String) context.getAttribute("respMsg");
             String id=(String) context.getAttribute("id");
             CustPbocPerQuery custPbocPerQuery = dao.findById(id);
             if (StringUtils.equals("success", status) && StringUtils.equals("0000",respCode)) {
            	 custPbocPerQuery.setStatus(Constant.RESP_QUERY_STATUS);
            	 custPbocPerQuery.setRespId(uuid);
             } else {
            	 custPbocPerQuery.setStatus(Constant.FAIL_QUERY_STATUS);
             }
             custPbocPerQuery.setQueryDate(DateUtil.get8Date());
             custPbocPerQuery.setSendTime(DateUtil.get14Time());
             custPbocPerQuery.setRespCode(respCode);
             custPbocPerQuery.setRespMsg(StringUtils.substring(respMsg, 0, 1000));
             custPbocPerQuery.setRespTime(DateUtil.get14Time());
             dao.update(custPbocPerQuery);
        }else {
        	 String uuid = (String) context.getAttribute("uuid");
             String status = (String) context.getAttribute("status");
             String respCode = (String) context.getAttribute("respCode");
             String respMsg = (String) context.getAttribute("respMsg");
             String id=(String) context.getAttribute("id");
             CustPbocPerQuery custPbocPerQuery = dao.findById(id);
             if (StringUtils.equals("success", status) && StringUtils.equals("0000",respCode)) {
                 custPbocPerQuery.setStatus(Constant.RESP_QUERY_STATUS);
                 custPbocPerQuery.setRespId(uuid);
             } else if("9999".equals(respCode)){
                 custPbocPerQuery.setStatus(Constant.FAIL_QUERY_STATUS);
                 context.setAttribute("idNum",custPbocPerQuery.getIdNum());
                 context.setAttribute("name", custPbocPerQuery.getIdNum());
             }else {
            	 custPbocPerQuery.setStatus(Constant.FAIL_QUERY_STATUS);
             }
             custPbocPerQuery.setRespCode(respCode);
             custPbocPerQuery.setRespMsg(StringUtils.substring(respMsg, 0, 1000));
             custPbocPerQuery.setRespTime(DateUtil.get14Time());
             dao.update(custPbocPerQuery);
        }

    }


    @Override
    public void afterProc(OperationContext context) throws CommonException {

    }
}
