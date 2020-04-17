package com.huateng.report.pboc.updater;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.pboc.operation.QueryCorpOperation;
import com.huateng.report.pboc.result.QueryResult;
import com.huateng.report.service.PbocD103Service;

public abstract class QueryCorpUpdate extends BaseUpdate {
    private static final Logger log = Logger.getLogger(QueryCorpUpdate.class);

    public UpdateReturnBean dealCorpData(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
                                         HttpServletResponse response) throws AppException {

        try {

        	String tlrno=request.getParameter("tlrno");
        	String brno=request.getParameter("brno");
        	String entName=request.getParameter("entName");
        	String entCertType=request.getParameter("entCertType");
        	String entCertNum=request.getParameter("entCertNum");
        	String queryReason=request.getParameter("queryReason");
        	String serviceCode=request.getParameter("serviceCode");
            Map<String,String> paramMap=new HashMap<String,String>();
            paramMap.put("tlrno", "HBF00000100001");
            paramMap.put("brno", "002");
            paramMap.put("entName", "北京报告样本公司");
            paramMap.put("entCertType", "01");
            paramMap.put("entCertNum", "68690571-9");
            paramMap.put("queryReason", "01");
            paramMap.put("serviceCode", "FW_QYXYBG_0043");

            OperationContext context = new OperationContext();
            context.setAttribute("CMD", "INSERT");
            context.setAttribute("CorpMakeMap", paramMap);
            OPCaller.call(QueryCorpOperation.class, context);
            boolean isOk = true;
            String rptId = "";
            PbocD103Service service = PbocD103Service.getInstance();
            try {
                    QueryResult queryResult = service.queryEnterprise(paramMap);
                    if (StringUtils.equals(queryResult.getCode(), "0000")) {
                        logger.info("queryResult = " + queryResult);
                        context.setAttribute("status", "success");
                        rptId = StringUtils.trimToEmpty(queryResult.getId());
                        context.setAttribute("rptId", rptId);
                        context.setAttribute("CMD", "UPDATE");
                        context.setAttribute("status", "success");
                        context.setAttribute("respCode", StringUtils.trimToEmpty(queryResult.getCode()));
                        context.setAttribute("respMsg", StringUtils.trimToEmpty(queryResult.getMsg()));
                        OPCaller.call(QueryCorpOperation.class, context);
                    } else {
                        isOk = false;
                        logger.error("queryResult = " + queryResult);
                        context.setAttribute("CMD", "UPDATE");
                        context.setAttribute("status", "failed");
                        OPCaller.call(QueryCorpOperation.class, context);
                        ExceptionUtil.throwCommonException("企业查询失败");
                    }
                    rptId = StringUtils.trimToEmpty(queryResult.getId());
                    context.setAttribute("rptId", rptId);
                    context.setAttribute("status", "success");
                    context.setAttribute("respCode", StringUtils.trimToEmpty(queryResult.getCode()));
                    context.setAttribute("respMsg", StringUtils.trimToEmpty(queryResult.getMsg()));
                    OPCaller.call(QueryCorpOperation.class, context);


            } catch (Exception e) {
                isOk = false;
                context.setAttribute("status", "failed");
                context.setAttribute("respCode", StringUtils.trimToEmpty("9999"));
                context.setAttribute("respMsg", StringUtils.trimToEmpty(e.getMessage()));
                OPCaller.call(QueryCorpOperation.class, context);
                ExceptionUtil.throwCommonException("企业查询异常");
            }
            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
            return updateReturnBean;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }




}
