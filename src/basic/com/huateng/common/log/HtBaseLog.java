package com.huateng.common.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.huateng.common.DateUtil;

public class HtBaseLog {
    public String left_sign = "[";
    public String right_sign = "]";
    public String enter_sign = "\n";
    public static String lever_info = "INFO";
    public static String lever_debug = "DEBUG";
    public static String lever_error = "ERROR";
    public static String lever_warn = "WARN";
    public static String lever_fatal = "FATAL";
    public String lever_exception = "Basic.Exception";
    public String lever_system = "Basic.System";
    public static String lever_txnLog = "Basic.TxnLog";
    public String separator_sign = "*";
    public String log_start = "LOGSTART";
    public String log_end = "LOGEND";
    public String log_join = "Basic.Join";
    public String log_suspend_start = "LOGSUSPEND_START";
    public String log_suspend_over = "LOGSUSPEND_OVER";
    public String separator = "******************************************";
    public int bufferLength = 65688;
    public static ThreadLocal<StringBuffer> logBuffer = new ThreadLocal<StringBuffer>();
    public static ThreadLocal<Long> logPayTime = new ThreadLocal<Long>();
    public static ThreadLocal<Integer> stepNum = new ThreadLocal<Integer>();
    public static ThreadLocal<String> threadTransId = new ThreadLocal<String>();
    public static ThreadLocal<UUID> uuid = new ThreadLocal<UUID>();
    public static ThreadLocal<String> exceptionflag = new ThreadLocal<String>();

    public StringBuffer getCurrentStringBuffer() {
        if (logBuffer.get() == null) {
            logBuffer.set(new StringBuffer(""));
        }
        return (StringBuffer) logBuffer.get();
    }

    public Integer getNum() {
        if (stepNum.get() == null) {
            stepNum.set(new Integer(0));
        } else {
            stepNum.set(new Integer(((Integer) stepNum.get()).intValue() + 1));
        }
        return (Integer) stepNum.get();
    }

    public StringBuffer printMsg(String paramString1, String paramString2, Object paramObject, boolean paramBoolean) {
        return printMsg(null, paramString1, paramString2, paramObject, null, paramBoolean);
    }

    public StringBuffer printMsg(String paramString1, String paramString2, Object paramObject, Throwable paramThrowable,
            boolean paramBoolean) {
        return printMsg(null, paramString1, paramString2, paramObject, paramThrowable, paramBoolean);
    }

    public StringBuffer printMsg(String paramString1, String paramString2, String paramString3, Object paramObject,
            Throwable paramThrowable, boolean paramBoolean) {
        StringBuffer localStringBuffer = new StringBuffer("");
        if (paramBoolean) {
            localStringBuffer.append(separator_sign);
            if (paramString1 != null) {
                localStringBuffer.append(left_sign + paramString1 + right_sign);
            }
            localStringBuffer.append(left_sign + uuid.get() + right_sign);
            localStringBuffer.append(left_sign + DateUtil.getCurrDate() + right_sign);
            localStringBuffer.append(left_sign + DateUtil.getLocalTime10() + right_sign);
            if (paramThrowable == null) {
                localStringBuffer.append(left_sign + paramString2 + right_sign);
                localStringBuffer.append(left_sign + paramString3 + right_sign);
                localStringBuffer.append(left_sign + paramObject + right_sign);
                localStringBuffer.append(enter_sign);
            } else {
                StringWriter localStringWriter = new StringWriter();
                PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
                paramThrowable.printStackTrace(localPrintWriter);
                localPrintWriter.flush();
                localStringBuffer.append(left_sign + lever_exception + right_sign);
                localStringBuffer.append(left_sign + lever_system + right_sign);
                localStringBuffer.append(left_sign + paramObject + right_sign);
                localStringBuffer.append(localStringWriter);
                exceptionflag.set("true");
            }
        } else {
            localStringBuffer.append(paramObject);
            localStringBuffer.append(enter_sign);
        }
        return localStringBuffer;
    }

    public String getLogStartAndLog(String paramString1, String paramString2) {
        if (logPayTime.get() == null) {
            logPayTime.set(Long.valueOf(System.currentTimeMillis()));
        }
        if (threadTransId.get() == null) {
            threadTransId.set(paramString2);
        }
        if (exceptionflag.get() == null) {
            exceptionflag.set("false");
        }
        if (uuid.get() == null) {
            UUID localUUID = UUID.randomUUID();
            uuid.set(localUUID);
        }
        return separator + paramString1 + left_sign + (String) threadTransId.get() + right_sign + separator;
    }

    public String getBasicInitData(HttpServletRequest paramHttpServletRequest) {
        StringBuffer localStringBuffer = new StringBuffer("request.getParameterMap:");
        Enumeration<?> localEnumeration = paramHttpServletRequest.getParameterNames();
        while (localEnumeration.hasMoreElements()) {
            String str = (String) localEnumeration.nextElement();
            localStringBuffer.append(
                    "{[paramName: " + str + "],[paramValue: " + paramHttpServletRequest.getParameter(str) + "]};");
        }
        return localStringBuffer.toString();
    }
}
