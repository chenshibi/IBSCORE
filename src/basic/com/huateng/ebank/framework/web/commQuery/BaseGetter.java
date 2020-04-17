/**
 *
 */
package com.huateng.ebank.framework.web.commQuery;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.common.DataObjectUtils;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.common.log.HtBaseLog;
import com.huateng.commquery.process.call._CallGetter;
import com.huateng.commquery.result.ResultParamBean;
import com.huateng.commquery.result.databus.CommonQueryDataBusMng;
import com.huateng.commquery.result.databus.DataBus;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.ErrorCodeUtil;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.service.BizLogThreadPoolExecutor;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.session.SessionManager;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.exception.AppException;

/**
 * Title: CustCropCallGetter Description: Copyright: Copyright (c) 2007 Company:
 * Shanghai Huateng Software Systems Co., Ltd.
 *
 * @author shen_antonio
 * @version 1.1, 2007-11-19
 */
public abstract class BaseGetter extends _CallGetter {

    private static final Logger log = Logger.getLogger(BaseGetter.class);
    private String databusId = "";

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.huateng.commquery.process.call._CallGetter#process(java.util.Map,
     * javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public ResultParamBean process(Map param, HttpServletRequest request, HttpServletResponse response)
            throws AppException {
        GlobalInfo globalInfo = null;
        try {
            try {

                ResultParamBean resultParamBean = super.process(param, request, response);

                GlobalInfo ginfo = GlobalInfo.getCurrentInstanceWithoutException();
                if (ginfo != null) {

                    // 记录查询日志
                    // if
                    // (param.containsKey(ReportConstant.SAVE_QUERY_LOG_SIGN)) {
                    // String isSaveLog = (String)
                    // param.get(ReportConstant.SAVE_QUERY_LOG_SIGN);
                    // if (isSaveLog != null && isSaveLog.equals("1") &&
                    // "1".equals(ginfo.getSaveQueryLog())) {// 记录日志
                    String busiName = this.getClass().getSimpleName();
                    if (busiName != null && busiName.trim().length() > 0) {
                        ginfo.addBizLog("Updater.log", new String[] { ginfo.getTlrno(),busiName });
                    }
                    // }
                    // }
                }

                logger.printNoLevel("TXN STATUS(SUCCESS)", "Basic.Monitor", true);
                return resultParamBean;
            } catch (Throwable e) {
                logger.error("", e);
                logger.printNoLevel("TXN STATUS(FAIL)", "Basic.Monitor", true);
                throw e;
            }
        } catch (CommonException cex) {
            throw new AppException("", cex.getKey(), ErrorCodeUtil.convertErrorMessage(log, cex), cex);
        } catch (AppException appEx) {
            throw new AppException(appEx.getModuleName(), appEx.getErrCd(),
                    ErrorCodeUtil.convertErrorMessage(log, appEx), appEx);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex);
        } catch (Throwable te) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, new Exception(te));
        } finally {
            /** 操作员交易描述存放 add by abudula at 20100927 CSYS-21 start */
            setTxnDescToGlobalInfo();
            /** 操作员日志信息存放 add by abudula at 20100927 CSYS-21 end */
            // 日志写入结束
            /** mod by abudula at 2010-9-26 start BUG:CSYS-4 **/
            logger.genMsg();
            /** mod by abudula at 2010-9-26 end **/
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.huateng.commquery.process.call.ICallGetter#preProcess(java.util.Map,
     * javax.servlet.http.HttpServletRequest)
     */
    @Override
    public Map preProcess(Map param, HttpServletRequest request) throws AppException {
        Map paramMap = super.preProcess(param, request);
        databusId = (String) (param.get("databusId"));
        if (StringUtils.isEmpty(databusId)) {
            databusId = getCommonQueryBean().getAnyValue("databusid");
        }
        init(request);
        return paramMap;
    }

    protected void init(HttpServletRequest request) throws CommonException {
        checkGlobalInfo(request);
        // String txnId = checkTxnPrivilege(request);
        setGlobalInfoToThreadLoacl(request);
    }

    /** add by abudula at 20100927 CSYS-21 start */
    protected void setTxnDescToGlobalInfo() throws CommonException {
        // 取得当前的GlobalInfo
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstanceWithoutException();
        if (globalInfo != null) {
            // 测试
            globalInfo.setFuncIdLogFlag("true");
            String funcLogFlag = globalInfo.getFuncIdLogFlag();
            if (funcLogFlag != null && !funcLogFlag.equals("")) {
                if (txnLogFlag != null && txnLogFlag.equals("true") && funcLogFlag.equals("true")) {
                    // 交易中保存多条操作员日志
                    List list = globalInfo.getCurrentLogList();
                    // 串联一条日志信息
                    String stringLog = globalInfo.getCurrentStringBuffer().toString();
                    if (list != null && list.size() != 0) {
                        logger.printNoLevel("插入多条操作员日志信息 ", HtBaseLog.lever_txnLog, true);
                        for (int i = 0; i < list.size(); i++) {
                            // 取得操作员的流水号
                            try {
                                String condStr = getGetterParams();
                                BizLogThreadPoolExecutor.addTask(globalInfo, globalInfo.getBaseTlsrno(),
                                        (String) list.get(i) + condStr, txnLogFlag, uuId, oprTxnCd);
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }

                    if (stringLog != null && !stringLog.equals("")) {
                        try {
                            String condStr = getGetterParams();
                            BizLogThreadPoolExecutor.addTask(globalInfo, globalInfo.getBaseTlsrno(),
                                    stringLog + condStr, txnLogFlag, uuId, oprTxnCd);
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    // 清除操作员的日志信息
                    globalInfo.clean();
                }
            }
        }
    }

    /** add by abudula at 20100927 CSYS-21 end */
    /*
     * set GlobalInfo to ThreadLocal
     */
    protected void setGlobalInfoToThreadLoacl(HttpServletRequest request) throws CommonException {
        HttpSession httpSession = request.getSession();
        GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
        if (null != globalInfo) {
            GlobalInfo.setCurrentInstance(globalInfo);
            String sessionId = httpSession.getId();
            globalInfo.setSessionId(sessionId);
            // globalInfo.setFuncCode(funcCode);
        }
    }

    private String getGetterParams() {
        StringBuffer sb = new StringBuffer();
        Map map = getCommQueryServletRequest().getParameterMap();
        if (map == null || map.size() == 0) {
            return "";
        }
        map.entrySet();

        for (Object o : map.keySet()) {
            if (StringUtils.isNotBlank((String) map.get(o))) {
                sb.append("[" + o + "]=[" + map.get(o) + "]");
            }
        }
        return sb.toString();
    }

    protected GlobalInfo checkGlobalInfo(HttpServletRequest request) throws CommonException {

        GlobalInfo globalInfo = GlobalInfo.getFromRequest(request);
        if (null == globalInfo) {
            ExceptionUtil.throwCommonException("用户没有登录.", ErrorCode.ERROR_CODE_TLRNO_SESSION_INVALID);
        }
        /** add jiang@20091102 */
        /*
         * if(UserMgrService.getInstance().isKicked(globalInfo,request.
         * getSession())) { request.getSession().invalidate();
         * ExceptionUtil.throwCommonException("用户已在别处登录.",
         * ErrorCode.ERROR_CODE_TLRNO_SESSION_BINDED); } .
         */
        /** end jiang@20091102 */
        /** 操作员交易描述存放 add by abudula at 20100927 CSYS-21 start */
        Date txnDate = new Date();
        globalInfo.setTxnStartTime(txnDate);
        globalInfo.setTxnDate(txnDate);
        /** 操作员日志信息存放 add by abudula at 20100927 CSYS-21 end */
        GlobalInfo.setCurrentInstance(globalInfo);
        return globalInfo;
    }

    /**
     * 检查交易权限
     * 
     * @param request
     * @throws CommonException
     */
    protected String checkTxnPrivilege(HttpServletRequest request) throws CommonException {
        return TxnPrivilegeMng.checkTxnPrivilege(request, this.getCommonQueryBean().getId());
    }

    /**
     * @author yjw 注册 java.utils.date 到beanutils中
     * @param bean
     * @param map
     */
    public void BeanUtilsEx(Object bean, Map map) throws AppException {
        try {
            // BeanUtils.populate(bean, map);
            DataObjectUtils.mapToObject2(bean, map);
        } catch (Exception e) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, "属性拷贝出错", e);
        }
    }

    public void setValue2DataBus(String fieldId, String fieldValue) throws AppException {
        try {
            if (fieldValue == null)
                fieldValue = "";
            HttpSession session = null;
            if (httpReq instanceof HttpServletRequest) {
                session = (httpReq).getSession();
            }
            DataBus dataBus = CommonQueryDataBusMng.getDataBus(session.getId(), databusId, session);
            dataBus.setField(fieldId, fieldValue);
        } catch (AppException appEx) {
            appEx.printStackTrace();
            // throw new AppException(appEx.getModuleName(), appEx.getErrCd(),
            // ErrorCodeUtil.convertErrorMessage(log, appEx), appEx);
        } catch (Exception ex) {
            ex.printStackTrace();
            // throw new AppException(Module.SYSTEM_MODULE,
            // Rescode.DEFAULT_RESCODE, ex);
        }
    }

    public String getValueFromDataBus(String fieldId) throws AppException {
        try {
            HttpSession session = null;
            if (httpReq instanceof HttpServletRequest) {
                session = (httpReq).getSession();
            }
            DataBus dataBus = CommonQueryDataBusMng.getDataBus(session.getId(), databusId, session);
            return dataBus.getFieldValue(fieldId);
        } catch (AppException appEx) {
            throw new AppException(appEx.getModuleName(), appEx.getErrCd(),
                    ErrorCodeUtil.convertErrorMessage(log, appEx), appEx);
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex);
        }
    }

    /**
     * Session data manage For session data
     */
    /**
     * Retrieve a session object based on the request and the attribute name.
     */
    protected Object getSessionObject(String attrName) {
        Object object = SessionManager.getInstance().getSessionObject(httpReq, attrName);
        if (object != null && !object.equals("")) {
            removeSessionObject(attrName);
            return object;
        } else {
            return null;
        }

    }

    /**
     * Set a session object based on the request and the attribute name.
     */
    protected boolean setSessionObject(String attrName, Object value) {
        return SessionManager.getInstance().setSessionObject(httpReq, attrName, value);
    }

    /**
     * Remove a session object based on the request and the attribute name.
     */
    protected boolean removeSessionObject(String attrName) {
        return SessionManager.getInstance().removeSessionObject(httpReq, attrName);
    }

}
