package com.huateng.report.pboc.operation;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.dao.CollateralEntQueryDao;
import com.huateng.report.pboc.util.Constant;

import resource.bean.crms.CollateralEntQuery;

/**
 * 
 * @author Grassy
 *
 */
public class QueryCollateralOperation extends BaseOperation {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(QueryCollateralOperation.class);
    @Override
    public void beforeProc(OperationContext context) throws CommonException {
     
    }

    @Override
    public void execute(OperationContext context) {
    	CollateralEntQueryDao dao = ROOTDAOUtils.getCollateralEntQueryDAO();
        if ("INSERT".equals(context.getAttribute("CMD"))) {
            Map<String, String> map = (Map<String, String>) context.getAttribute("CollateralMakeMap");
            GlobalInfo globalInfo;
			try {
				globalInfo = GlobalInfo.getCurrentInstance();
				CollateralEntQuery collateralEntQuery = new CollateralEntQuery();
				collateralEntQuery.setCreateTime(DateUtil.get14Time());
				collateralEntQuery.setCreateUser(globalInfo.getTlrno());
				collateralEntQuery.setQueryDate(DateUtil.get8Date());
				collateralEntQuery.setSendTime(DateUtil.get14Time());
				collateralEntQuery.setEntName(map.get("entName"));
				collateralEntQuery.setEntCertType(map.get("entCertType"));
				collateralEntQuery.setEntCertNum(map.get("entCertNum"));
				collateralEntQuery.setQueryReason(map.get("queryReason"));
				collateralEntQuery.setServiceCode(map.get("serviceCode"));
				collateralEntQuery.setIp(GlobalInfo.getCurrentInstance().getIp());
				//已录入
				collateralEntQuery.setStatus("00");
				dao.save(collateralEntQuery);
				context.setAttribute("id", collateralEntQuery.getId());
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
             CollateralEntQuery collateralEntQuery = dao.findById(id);
             if (StringUtils.equals("success", status) && StringUtils.equals("0000",respCode)) {
            	 collateralEntQuery.setStatus(Constant.RESP_QUERY_STATUS);
            	 collateralEntQuery.setRespId(uuid);
             } else if("9999".equals(respCode)){
            	 collateralEntQuery.setStatus(Constant.FAIL_QUERY_STATUS);
                 context.setAttribute("entCertNum",collateralEntQuery.getEntCertNum());
                 context.setAttribute("entName", collateralEntQuery.getEntName());
             } else {
            	 collateralEntQuery.setStatus(Constant.FAIL_QUERY_STATUS);
             }
             collateralEntQuery.setRespCode(respCode);
             collateralEntQuery.setRespMsg(StringUtils.substring(respMsg, 0, 1000));
             collateralEntQuery.setRespTime(DateUtil.get14Time());
             dao.update(collateralEntQuery);
        }

    }


    @Override
    public void afterProc(OperationContext context) throws CommonException {

    }
}
