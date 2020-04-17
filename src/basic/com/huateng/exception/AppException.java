package com.huateng.exception;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.ErrorCodeUnit;

public class AppException extends DomainException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public AppException(String paramString1, String paramString2, String paramString3) {
        super(paramString1, paramString2, paramString3);
    }

    public AppException() {
    }

    public AppException(String paramString) {
        super(paramString);
    }

    public AppException(String paramString, Throwable paramThrowable) {
        super(paramString, paramThrowable);
    }

    public AppException(String paramString1, String paramString2) {
        this(paramString1, paramString2, null, null);
    }

    public AppException(String paramString1, String paramString2, Exception paramException) {
        this(paramString1, paramString2, null, paramException);
    }

    public AppException(String paramString1, String paramString2, String paramString3, String paramString4,
            Exception paramException) {
        this(paramString1, paramString2, paramString3, paramException);
        errorPage = paramString4;
    }

    public AppException(String paramString1, String paramString2, String paramString3, Exception paramException) {
        super(paramString1, paramString2, paramString3, paramException);
        moduleName = paramString1;
        errCode = paramString2;
        errMessage = paramString3;
    }

    public String getErrCd() {
        if ((moduleName == null) || (errCode == null)) {
            return "999999";
        }
        if (errCode != null && (StringUtils.containsIgnoreCase(errCode, "Hibernate")
                || StringUtils.containsIgnoreCase(errCode, "JDBC"))) {
            return "999998";
        }
        return moduleName + errCode;
    }

    public String getErrMessage() {
        if (errMessage == null) {
            return ErrorCodeUnit.getErrorMessage(getErrCd());
        }
        if (errMessage != null && (StringUtils.containsIgnoreCase(errMessage, "Hibernate")
                || StringUtils.containsIgnoreCase(errMessage, "JDBC"))) {
            return "数据库操作失败。";
        }
        return errMessage;
    }

    @Override
    public String getMessage() {
        String msg = super.getMessage();
        if (msg != null
                && (StringUtils.containsIgnoreCase(msg, "Hibernate") || StringUtils.containsIgnoreCase(msg, "JDBC"))) {
            return "数据库操作失败。";
        } else {
            return msg;
        }
    }
}
