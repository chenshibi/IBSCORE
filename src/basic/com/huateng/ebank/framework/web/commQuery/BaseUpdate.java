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
import com.huateng.commquery.process.call._CallUpdate;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
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
import com.huateng.report.utils.ReportUtils;

/**
 * @author yjw
 *
 */
public abstract class BaseUpdate extends _CallUpdate {

    private static final Logger log = Logger.getLogger(BaseUpdate.class);

    public String databusId = "";

    @Override
    public Map<String, String> preProcess(Map<String, String> param, HttpServletRequest request) throws AppException {
        Map<String, String> map = super.preProcess(param, request);
        init(request);
        return map;
    }

    @Override
    public UpdateReturnBean process(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
            HttpServletResponse response) throws AppException {
        GlobalInfo globalInfo = null;
        try {
            try {
                databusId = (String) ((multiUpdateResultBean.getParamMap()).get("databusId"));
                this.multiUpdateResultBean = multiUpdateResultBean;
                // init(request);
                globalInfo = GlobalInfo.getCurrentInstanceWithoutException();
                UpdateReturnBean update = super.process(multiUpdateResultBean, request, response);
                if (globalInfo != null) {
                    globalInfo.setTxnInfo(true, null);
                }
                logger.printNoLevel("TXN STATUS(SUCCESS)", "Basic.Monitor", true);
                return update;
            } catch (Throwable e) {
                if (globalInfo != null) {
                    globalInfo.setTxnInfo(false, e);
                }
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
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex);
        } catch (Throwable te) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, new Exception(te));
        } finally {
            /** 操作员交易描述存放 add by abudula at 20100927 CSYS-21 start */
            setTxnDescToGlobalInfo();
            /** 操作员日志信息存放 add by abudula at 20100927 CSYS-21 end */
            /** mod by abudula at 2010-9-26 start **/
            logger.genMsg();
            /** mod by abudula at 2010-9-26 end **/
        }
    }

    protected void init(HttpServletRequest request) throws CommonException {
        httpReq = request;
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
                                String sequence = ReportUtils.getUUID();
                                // 将操作员的流水号写入文件日志
                                globalInfo.setBaseTlsrno(sequence);
                                String tmpTxnCd = oprTxnCd;
                                if ((StringUtils.isBlank(tmpTxnCd) || StringUtils.equalsIgnoreCase(tmpTxnCd, "null"))
                                        && this.getMultiUpdateResultBean() != null
                                        && StringUtils.isNotBlank(this.getMultiUpdateResultBean().getUpdCqId())) {
                                    tmpTxnCd = this.getMultiUpdateResultBean().getUpdCqId();
                                }
                                logger.printNoLevel("操作员的流水号:" + sequence, HtBaseLog.lever_txnLog, true);
                                BizLogThreadPoolExecutor.addTask(globalInfo, globalInfo.getBaseTlsrno(),
                                        (String) list.get(i), txnLogFlag, uuId, tmpTxnCd);
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    }

                    if (stringLog != null && !stringLog.equals("")) {
                        try {
                            String sequence = ReportUtils.getUUID();
                            // 将操作员的流水号写入文件日志
                            globalInfo.setBaseTlsrno(sequence);
                            String tmpTxnCd = oprTxnCd;
                            if ((StringUtils.isBlank(tmpTxnCd) || StringUtils.equalsIgnoreCase(tmpTxnCd, "null"))
                                    && this.getMultiUpdateResultBean() != null
                                    && StringUtils.isNotBlank(this.getMultiUpdateResultBean().getUpdCqId())) {
                                tmpTxnCd = this.getMultiUpdateResultBean().getUpdCqId();
                            }
                            logger.printNoLevel("操作员的流水号:" + sequence, HtBaseLog.lever_txnLog, true);
                            BizLogThreadPoolExecutor.addTask(globalInfo, globalInfo.getBaseTlsrno(), stringLog,
                                    txnLogFlag, uuId, tmpTxnCd);
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

    protected GlobalInfo checkGlobalInfo(HttpServletRequest request) throws CommonException {
        GlobalInfo globalInfo = GlobalInfo.getFromRequest(request);
        System.out.println("Session id = " + request.getSession().getId());
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
        return TxnPrivilegeMng.checkTxnPrivilege(request, getMultiUpdateResultBean().getUpdCqId());
    }

    /**
     * 把map拷贝到object中,对时间设置默认值
     *
     * @param object
     * @param map
     * @throws AppException
     */
    public static void mapToObject(Object object, Map map) throws AppException {
        try {
            DataObjectUtils.mapToObject(object, map);
        } catch (Exception e) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, "属性拷贝出错", e);
        }
    }

    /**
     * 把map拷贝到object中,不对时间设置默认值
     *
     * @param object
     * @param map
     * @throws AppException
     */
    public static void mapToObject2(Object object, Map map) throws AppException {
        try {
            DataObjectUtils.mapToObject2(object, map);
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
            throw new AppException(appEx.getModuleName(), appEx.getErrCd(),
                    ErrorCodeUtil.convertErrorMessage(log, appEx), appEx);
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex);
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
