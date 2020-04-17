package com.huateng.commquery.process.call;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.CommonFunction;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.commquery.config.CommonQueryUtil;
import com.huateng.commquery.config.bean.base.ICommonQueryBean;
import com.huateng.commquery.result.Page;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultParamBean;
import com.huateng.commquery.servlet.CommQueryServletContext;
import com.huateng.commquery.servlet.CommQueryServletRequest;
import com.huateng.exception.AppException;

public abstract class _CallGetter implements ICallGetter {
    protected ICommonQueryBean commonQueryBean = null;
    protected CommQueryServletRequest commQueryServletRequest = null;
    protected HttpServletRequest httpReq = null;
    protected Result result = null;

    protected String txnDesc = null;
    protected String txnLogFlag = null;
    protected HtLog logger = null;
    protected String uuId = null;
    protected String oprTxnCd = null;

    public Map<String, String> preProcess(Map<String, String> paramMap, HttpServletRequest paramHttpServletRequest)
            throws AppException {
        // System.out.println("_CallGetter preProcess started.");
        httpReq = paramHttpServletRequest;
        commQueryServletRequest = new CommQueryServletRequest(paramHttpServletRequest.getSession().getId(),
                paramHttpServletRequest.getContextPath());
        // System.out.println("_CallGetter commQueryServletRequest " +
        // commQueryServletRequest.getServerName());
        try {
            // System.out.println("_CallGetter (String) paramMap.get(CQId) " +
            // (String) paramMap.get("CQId"));
            commonQueryBean = CommonQueryUtil.getCommonQueryBean((String) paramMap.get("CQId"));
            // System.out.println("_CallGetter commonQueryBean " +
            // commonQueryBean.getId());
            // String str = commonQueryBean.getAnyValue("databusid");
            // System.out.println("_CallGetter str " + str);
            // if (str != null) {
            // Object localObject = commQueryServletRequest.getSession();
            // System.out.println("_CallGetter HttpSession " +
            // ((HttpSession)localObject).getId());
            // DataBus localDataBus =
            // CommonQueryDataBusMng.getDataBus(((HttpSession)
            // localObject).getId(), str,
            // localObject);
            // System.out.println("_CallGetter localDataBus " +
            // localDataBus.getId());
            // localDataBus = CommonQueryDataBusMng.mngDataBus(paramMap,
            // localDataBus, true, false);
            // System.out.println("_CallGetter localDataBus " +
            // localDataBus.getId());
            // paramMap.putAll(localDataBus.getFMap());
            // System.out.println("_CallGetter process putAll.");
            // }
            txnDesc = commonQueryBean.getAnyValue("txndesc");
            // System.out.println("_CallGetter process txnDesc." + txnDesc);
            txnLogFlag = CommonFunction.getAnyValueDefault(commonQueryBean.getAnyValue("txnlogflag"), "true");
            // System.out.println("_CallGetter process txnLogFlag." +
            // txnLogFlag);
            Object localObject = commonQueryBean.getAnyValue("getterclassname");
            // System.out.println("_CallGetter process localObject." +
            // localObject);
            logger = HtLogFactory.getLogger((String) localObject);
            if ((txnDesc != null) && (!txnDesc.equals(""))) {
                logger.printHead(txnDesc);
            } else {
                logger.printHead((String) localObject);
                logger.warn("no_getter_txn_desc", new String[] { commonQueryBean.getId() });
            }
            // System.out.println("_CallGetter process started.111111");
            logger.printRequstParams(paramHttpServletRequest);
            // System.out.println("_CallGetter process started.22222");
            uuId = ((UUID) HtLog.uuid.get()).toString().replaceAll("-", "").toLowerCase();
            // System.out.println("_CallGetter process started.333333" + uuId);
            oprTxnCd = ((String) paramMap.get("CQId") + ".getterclassname");
            // System.out.println("_CallGetter process started.4444444" +
            // oprTxnCd);
            CommQueryServletContext.megerReqest(commQueryServletRequest, paramHttpServletRequest, paramMap);
            // System.out.println("_CallGetter process started.55555");
            return paramMap;
        } catch (Exception localException) {
            throw new AppException("SY", "9999", localException);
        }
    }

    public ResultParamBean process(Map<String, String> paramMap, HttpServletRequest paramHttpServletRequest,
            HttpServletResponse paramHttpServletResponse) throws AppException {
        // System.out.println("_CallGetter process started.");
        preProcess(paramMap, paramHttpServletRequest);
        // System.out.println("_CallGetter preProcess end.");
        Page localPage = new Page();
        int i = Integer.parseInt(StringUtils.defaultString(commQueryServletRequest.getParameter("nextPage"), "1"));
        int j = Integer.parseInt(StringUtils.defaultString(commQueryServletRequest.getParameter("everyPage"),
                commonQueryBean.getAnyValueDefault("pagesize", "10")));
        // System.out.println("_CallGetter i " + i);
        // System.out.println("_CallGetter j " + j);
        // System.out.println("commonQueryBean " + commonQueryBean.getId());
        localPage.setCurrentPage(i);
        localPage.setEveryPage(j);
        result = new Result(localPage, null);
        result.setCqId(commonQueryBean.getId());
        result.getParamMap().putAll(commQueryServletRequest.getParameterMap());
        // System.out.println("before call " + commonQueryBean.getId());
        result = call();
        // System.out.println("after call " + commonQueryBean.getId());

        return postProcess();
    }

    public ResultParamBean postProcess() throws AppException {
        try {
            // System.out.println("postProcess begin ");
            // CommonQueryDataBusMng.processDataBus(commonQueryBean,
            // commQueryServletRequest);
            ResultParamBean localResultParamBean = new ResultParamBean();
            localResultParamBean.setPageCount(result.getPage().getTotalPage());
            localResultParamBean.setPageSize(result.getPage().getEveryPage());
            localResultParamBean.setPageIndex(result.getPage().getCurrentPage());
            localResultParamBean.setFieldString(commonQueryBean.toFieldString());
            localResultParamBean.setRecordString(result.getResultOprStr());
            localResultParamBean.setRecordOrigString(result.getResultOrigStr());
            localResultParamBean.setCqId(commonQueryBean.getId());
            localResultParamBean.setResCd("000000");
            localResultParamBean.setParameterString(result.getParamStr());
            localResultParamBean.setTotal(result.getTotal());

            // System.out.println("postProcess end ");
            return localResultParamBean;
        } catch (Exception localException) {
            throw new AppException("SY", "9999", localException);
        }
    }

    public abstract Result call() throws AppException;

    public ICommonQueryBean getCommonQueryBean() {
        return commonQueryBean;
    }

    public CommQueryServletRequest getCommQueryServletRequest() {
        return commQueryServletRequest;
    }

    public Result getResult() {
        return result;
    }

    public HttpServletRequest getHttpReq() {
        return httpReq;
    }

    public HtLog getLogger() {
        return logger;
    }

    public void setLogger(HtLog paramHtLog) {
        logger = paramHtLog;
    }
}

/*
 * Location:
 * /Users/YiSiliang/Documents/workspaceDXZP/TopReport/WebContent/WEB-INF/lib/
 * BasePackage.jar Qualified Name:
 * com.huateng.commquery.process.call._CallGetter Java Class Version: 5 (49.0)
 * JD-Core Version: 0.7.1
 */