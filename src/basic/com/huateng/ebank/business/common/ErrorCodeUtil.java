/**
 *
 */
package com.huateng.ebank.business.common;

import org.apache.log4j.Logger;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;

/**
 * Title: ErrorCodeUtil Description: Copyright: Copyright (c) 2007 Company:
 * Shanghai Huateng Software Systems Co., Ltd.
 * 
 * @author shen_antonio
 * @version 1.1, 2007-12-29
 */
public class ErrorCodeUtil {
    private static final Logger slog = Logger.getLogger(ErrorCodeUtil.class);

    public static String convertErrorMessage(Logger logger, Exception ex) {
        /* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 begin . */
        Logger log = null;
        if (logger == null) {
            log = slog;
        } else {
            log = logger;
        }
        // Throwable t = ex.getCause();

        String errorMsg = "";
        String detailMsg = ex.getMessage();

        if (ex instanceof CommonException) {
            CommonException ce = (CommonException) ex;
            Object[] objs = ce.getObjs();
            String key = ce.getKey();

            errorMsg = "";
            if (DataFormat.trim(key) == "") {
                // errorMsg = "没有错误代码";
                errorMsg = MessageResourceUtil.getErrorMessage("NO_ERR_CODE");
            } else {
                // MessageResources mr = MessageResources.getInstance();
                // errorMsg = mr.getMessage(key, objs);
                errorMsg = MessageResourceUtil.getErrorMessage(key, objs);
                if (null == errorMsg) {
                    // errorMsg = "未知的错误代码定义: " + key + ".";
                    errorMsg = MessageResourceUtil.getErrorMessage("UNKNOW_CODE") + key + ".";
                } else {
                    // errorMsg = "错误信息:" + errorMsg + ".";
                    errorMsg = MessageResourceUtil.getErrorMessage("ERROR_INFO") + errorMsg + ".";
                }
            }
            log.error("异常\nError Code :" + key + '\n' + "Error Message :" + errorMsg, ex);
        } else {
            log.error("异常:" + ex.getMessage(), ex);
        }

        StringBuffer sb = new StringBuffer(errorMsg);
        if (null != detailMsg && !"".equals(detailMsg)) {
            if (-1 == detailMsg.indexOf("exception")) {// 如果不是数据库操作掷出的异常信息,进行显示.
                // sb.append("\n详细信息:").append(detailMsg).append(".");
                sb.append("\n").append(MessageResourceUtil.getErrorMessage("DETAIL_INFO")).append(detailMsg)
                        .append(".");
            }
        }
        /* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 end. */
        /*
         * if (sb.toString().length() < 256) { if (t != null) { String m =
         * t.getMessage(); sb.append("\n调试信息:").append(m).append("."); } }
         */

        String msg = sb.toString();
        if (msg.length() > 256) {
            msg = msg.substring(0, 256) + "......";
        }
        return msg;
    }

}
