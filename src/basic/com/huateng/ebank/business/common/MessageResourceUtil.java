/**
 *
 */
package com.huateng.ebank.business.common;

import java.text.MessageFormat;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.exception.AppException;
import com.huateng.view.freemarker.FreeMarkerConfiguration;

/**
 * Title: ErrorCodeUtil Description: Copyright: Copyright (c) 2007 Company:
 * Shanghai Huateng Software Systems Co., Ltd.
 * 
 * @author shen_antonio
 * @version 1.1, 2007-12-29
 */
public class MessageResourceUtil {
    private static final Logger log = Logger.getLogger(MessageResourceUtil.class);

    /* modify by shen_antonio 20121221 JIRA:FPP-3 begin. */
    private static ResourceBundleMessageSource basicResource = new ResourceBundleMessageSource();

    /* modify by shen_antonio 20121221 JIRA:FPP-3 end. */
    private static ResourceBundleMessageSource errorResource = new ResourceBundleMessageSource();

    private static boolean ONOFF = false;

    static {
        try {
            basicResource.setBasenames(
                    new String[] { "resources.UIi18n", "resources.UIi18n_zh_CN", "resources.UIi18n_zh_TW", });
            errorResource.setBasenames(
                    new String[] { "resources.errorcode", "resources.errorcode_zh_CN", "resources.errorcode_zh_TW", });
            ONOFF = "ON".equalsIgnoreCase((String) FreeMarkerConfiguration.getConfigVal("internationalization"));
            if (ONOFF) {
                if (log.isInfoEnabled()) {
                    log.info("i18n is able to run");
                }
            } else {
                if (log.isInfoEnabled()) {
                    log.info("i18n is enable to run");
                }
            }
        } catch (AppException e) {
            log.error("#############i18n init error, parameter[Internationalization] is error ############# ", e);
        }
    }

    /**
     * 是否开启国际化
     * 
     * @return
     */
    public static boolean isIl8n() {
        return ONOFF;
    }

    /**
     * 表名加上国际化后缀，以区分不同数据字典表
     * 
     * @param tblNm
     * @return
     */
    public static String getDataDicTblNm(String tblNm) {
        String tableName = tblNm;
        if (ONOFF) {
            GlobalInfo gi = GlobalInfo.getCurrentInstanceWithoutException();
            if (gi != null && gi.getLocale() != null && (Locale.US.equals(gi.getLocale())
                    || Locale.CHINA.equals(gi.getLocale()) || Locale.TAIWAN.equals(gi.getLocale()))) {
                tableName = tableName + gi.getLocale();
            }
        }
        return tableName;

    }

    /**
     * 基础资源文件
     * 
     * @param msgCode
     * @param args
     * @return
     * @throws CommonException
     */
    public static String getBasicMessage(String msgCode, boolean nullable, Object... args) {
        return getMessage(basicResource, msgCode, nullable, args);
    }

    public static String getBasicMessage(String msgCode, Object... args) {
        return getBasicMessage(msgCode, false, args);
    }

    /**
     * 异常资源文件
     * 
     * @param msgCode
     * @param args
     * @return
     * @throws CommonException
     */
    public static String getErrorMessage(String msgCode, boolean nullable, Object... args) {
        return getMessage(errorResource, msgCode, nullable, args);
    }

    public static String getErrorMessage(String msgCode, Object... args) {
        return getErrorMessage(msgCode, false, args);
    }

    /**
     * 获取资源文件中给定的KEY对应的消息,并格式化
     * 
     * @param messResource
     * @param msgCode
     * @param args
     * @return
     * @throws CommonException
     */
    public static synchronized String getMessage(String msgCode) {
        if (!ONOFF) {
            return msgCode;
        }
        GlobalInfo gi = GlobalInfo.getCurrentInstanceWithoutException();
        String mess = null;
        try {
            mess = basicResource.getMessage(msgCode, null, gi == null ? Locale.getDefault() : gi.getLocale());
        } catch (NoSuchMessageException e) {
        }
        if (mess == null) {
            return msgCode;
        } else {
            return mess;
        }
    }

    /**
     * 获取资源文件中给定的KEY对应的消息,并格式化
     * 
     * @param messResource
     * @param msgCode
     * @param args
     * @return
     * @throws CommonException
     */
    private static synchronized String getMessage(ResourceBundleMessageSource messResource, String msgCode,
            boolean nullable, Object... args) {
        if (!ONOFF) {
            return msgCode;
        }
        GlobalInfo gi = GlobalInfo.getCurrentInstanceWithoutException();
        String mess = null;
        try {
            mess = messResource.getMessage(msgCode, args, gi == null ? Locale.getDefault() : gi.getLocale());
        } catch (NoSuchMessageException e) {
        }
        if (mess == null) {
            return nullable ? mess : msgCode;
        } else {
            return MessageFormat.format(mess, args);
        }
    }
}
