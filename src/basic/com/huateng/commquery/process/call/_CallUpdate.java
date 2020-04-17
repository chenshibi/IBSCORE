package com.huateng.commquery.process.call;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.CommonFunction;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.commquery.config.CommonQueryUtil;
import com.huateng.commquery.config.bean.base.ICommonQueryOperationElement;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.exception.AppException;

public abstract class _CallUpdate implements ICallUpdate {
    protected UpdateReturnBean returnBean = null;
    protected MultiUpdateResultBean multiUpdateResultBean = null;
    protected HttpServletRequest httpReq = null;
    protected HtLog logger = null;
    protected String txnDesc = null;
    protected String txnLogFlag = null;
    protected String uuId = null;
    protected String oprTxnCd = null;

    public UpdateReturnBean getReturnBean() {
        return returnBean;
    }

    public HttpServletRequest getHttpReq() {
        return httpReq;
    }

    public void setReturnBean(UpdateReturnBean paramUpdateReturnBean) {
        returnBean = paramUpdateReturnBean;
    }

    public MultiUpdateResultBean getMultiUpdateResultBean() {
        return multiUpdateResultBean;
    }

    public void setMultiUpdateResultBean(MultiUpdateResultBean paramMultiUpdateResultBean) {
        multiUpdateResultBean = paramMultiUpdateResultBean;
    }

    public UpdateReturnBean postProcess() throws AppException {
        return null;
    }

    public Map<String, String> preProcess(Map<String, String> paramMap, HttpServletRequest paramHttpServletRequest)
            throws AppException {
        try {
            String str1 = multiUpdateResultBean.getUpdCqId();
            String str2 = multiUpdateResultBean.getUpdBtnId();
            ICommonQueryOperationElement localICommonQueryOperationElement = CommonQueryUtil.getCommonQueryBean(str1)
                    .getOperationsElement(str2);
            txnDesc = localICommonQueryOperationElement.getAnyValue("txndesc");
            txnLogFlag = CommonFunction.getAnyValueDefault(localICommonQueryOperationElement.getAnyValue("txnlogflag"),
                    "true");
            String str3 = localICommonQueryOperationElement.getAnyValue("updateclass");
            logger = HtLogFactory.getLogger(str3);
            if ((txnDesc != null) && (!txnDesc.equals(""))) {
                logger.printHead(txnDesc);
            } else {
                logger.printHead(str3);
                logger.warn("no_saveorupdate_txn_desc", new String[] { str1, str2 });
            }
            logger.printRequstParams(paramHttpServletRequest);
            uuId = ((UUID) HtLog.uuid.get()).toString().replaceAll("-", "").toLowerCase();
            oprTxnCd = (StringUtils.isEmpty(multiUpdateResultBean.getFuncId()) ? str1 + "_" + str2
                    : multiUpdateResultBean.getFuncId());
        } catch (Exception localException) {
            localException.printStackTrace();
        }
        return null;
    }

    public UpdateReturnBean process(MultiUpdateResultBean paramMultiUpdateResultBean,
            HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
            throws AppException {
        multiUpdateResultBean = paramMultiUpdateResultBean;
        preProcess(new HashMap(), paramHttpServletRequest);
        returnBean = saveOrUpdate(multiUpdateResultBean, paramHttpServletRequest, paramHttpServletResponse);
        returnBean.setResCd("000000");
        return returnBean;
    }

    public UpdateResultBean getUpdateResultBeanByID(String paramString) throws AppException {
        if (multiUpdateResultBean != null) {
            return multiUpdateResultBean.getUpdateResultBeanByID(paramString);
        }
        return null;
    }

    public abstract UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean,
            HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
            throws AppException;

    public void setHttpReq(HttpServletRequest paramHttpServletRequest) {
        httpReq = paramHttpServletRequest;
    }
}
