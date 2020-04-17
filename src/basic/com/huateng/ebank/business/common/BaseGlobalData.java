package com.huateng.ebank.business.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.huateng.exception.AppException;
import com.huateng.inter.I18MReadLogMsg;
import com.huateng.report.utils.LogExceptionUtils;

/**
 *
 * @author abudula
 *
 */
public class BaseGlobalData implements IGlobalData {

    // private static ThreadLocal session = new ThreadLocal();
    private static Logger log = Logger.getLogger(BaseGlobalData.class);
    /**
     * 
     */
    private static final long serialVersionUID = -8844428968998305344L;

    // public ResourceBundle logMsg =new I18MReadLogMsg().getResourceBundle(new
    // Locale("en", "US"));
    public ResourceBundle logMsg = new I18MReadLogMsg().getResourceBundle();

    private static ThreadLocal<StringBuffer> logBuffer = new ThreadLocal<StringBuffer>();

    private static ThreadLocal<List> logList = new ThreadLocal<List>();

    /**
     * 添加多条日志
     */
    public void addBizLog(String bizLog) {
        addBizLog(bizLog, null);
    }

    public void addBizLog(String id, String[] obj1) {
        Object obj = null;
        try {
            if (obj1 == null) {

                String value = logMsg.getString(id);
                if (value != null && !value.equals("")) {
                    obj = value;
                } else {
                    obj = id;
                }

            } else {
                String value = logMsg.getString(id);
                if (value != null && !value.equals("")) {
                    for (int i = 0; i < obj1.length; i++) {
                        value = value.replace("${" + i + "}", obj1[i]);
                    }
                }
                obj = value;
            }
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
            obj = id;
        }
        // if(getCurrentLogList()!=null&&(getCurrentStringBuffer().length())<=4092){
        getCurrentLogList().add((String) obj);
        // }
    }

    /**
     * 取得当前线程日志信息组
     * 
     * @return
     */
    public List<String> getCurrentLogList() {

        if (logList.get() == null) {
            logList.set(new ArrayList<String>());
        }
        return logList.get();
    }

    /**
     * 取得当前线程中日志信息。
     */
    public StringBuffer getCurrentStringBuffer() {

        if (logBuffer.get() == null) {
            logBuffer.set(new StringBuffer(""));
        }
        return logBuffer.get();

    }

    /**
     * 添加日志
     * 
     * @param bizLog
     */
    public void appendBizLog(String bizLog) {
        appendBizLog(bizLog, null);
    }

    /**
     * 添加日志
     * 
     * @param bizLog
     * @param resource
     *            Message_zh_CN.properties
     */
    public void appendBizLog(String id, String[] obj1) {
        Object obj = null;
        try {
            if (obj1 == null) {
                /** mod by abudula at 20100927 CSYS-21 start */
                String value = logMsg.getString(id);
                if (value != null && !value.equals("")) {
                    obj = value;
                } else {
                    obj = id;
                }
                /** mod by abudula at 20100927 CSYS-21 end */
            } else {
                String value = logMsg.getString(id);
                if (value != null && !value.equals("")) {
                    for (int i = 0; i < obj1.length; i++) {
                        value = value.replace("${" + i + "}", obj1[i]);
                    }
                }
                obj = value;
            }
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
            obj = id;
        }
        if (getCurrentStringBuffer() != null && (getCurrentStringBuffer().length()) <= 4092) {
            getCurrentStringBuffer().append(obj);
        }
    }

    /**
     * 清空对象
     */
    public void clean() {
        logBuffer.remove();
        logList.remove();
    }

    /**
     * 交易日志流水号
     */
    public String tlsrno;

    // private String sessionId = "";
    /* 操作员交易日期 */
    public Date txnDate;
    /* 操作员交易开始时间 */
    public Date txnStartTime;
    /* 操作员交易开始时间 */
    /* 操作员交易标识符 02---成功 99---失败 */
    public String txnStatus;
    /* 操作员交易错误 */
    public String txnFailLog;
    // IP
    public String ip;
    // 操作员号
    public String tlrno;
    // 机构号
    public String brcode;
    // 功能Id
    public String funcId;
    // 功能交易操作员日志打印开关
    public String funcIdLogFlag;

    /**
     * 初始化流水号
     * 
     * @param tlsrnoPr
     * @param tlsrnoEx
     */
    public void setBaseTlsrno(String tlsrno) {
        this.tlsrno = tlsrno;
    }

    /**
     * 取得流水号
     * 
     * @return
     */
    public String getBaseTlsrno() {
        return tlsrno;
    }

    public Date getTxnStartTime() {
        return txnStartTime;
    }

    public void setTxnStartTime(Date txnStartTime) {
        this.txnStartTime = txnStartTime;
    }

    public String getTxnStatus() {
        return txnStatus;
    }

    public void setTxnStatus(String txnStatus) {
        this.txnStatus = txnStatus;
    }

    public String getTxnFailLog() {
        return txnFailLog;
    }

    public void setTxnFailLog(String txnFailLog) {
        this.txnFailLog = txnFailLog;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTlrno() {
        return tlrno;
    }

    public void setTlrno(String tlrno) {
        this.tlrno = tlrno;
    }

    public String getBrcode() {
        return brcode;
    }

    public void setBrcode(String brcode) {
        this.brcode = brcode;
    }

    public String getFuncId() {
        return funcId;
    }

    public void setFuncId(String funcId) {
        this.funcId = funcId;
    }

    public String getFuncIdLogFlag() {
        return funcIdLogFlag;
    }

    public void setFuncIdLogFlag(String funcIdLogFlag) {
        this.funcIdLogFlag = funcIdLogFlag;
    }

    public Date getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    // public String getSessionId() {
    // return sessionId;
    // }
    //
    // public void setSessionId(String sessionId) {
    // this.sessionId = sessionId;
    // }

    public void setTxnInfo(boolean successFlag, Throwable ex) {
        if (successFlag) {
            setTxnStatus(TXN_STATUS_02_S);
            return;
        } else {
            setTxnStatus(TXN_STATUS_02_F);
            StringWriter sw = null;
            PrintWriter pw = null;
            StringBuffer sb = null;
            StringBuffer txnFailLog = new StringBuffer();
            ;
            try {
                sw = new StringWriter();
                pw = new PrintWriter(sw, true);
                ex.printStackTrace(pw);
                pw.flush();
                sw.flush();
                sb = sw.getBuffer();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (sw != null) {
                        sw.close();
                    }
                    if (pw != null) {
                        pw.close();
                    }
                } catch (IOException e) {
                    LogExceptionUtils.logException(log, e);
                    e.printStackTrace();
                }
            }
            if (ex instanceof AppException) {
                txnFailLog.append(((AppException) ex).getErrMessage());
            }
            txnFailLog.append("  " + ex.getMessage());
            if (sb != null) {
                txnFailLog.append(sb);
            }
            setTxnFailLog(txnFailLog.toString());
        }
    }
}
