package com.huateng.msgplatform.service;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.utils.LogExceptionUtils;

public class MsgplatformStatusUtil {
    private static final Logger logger = Logger.getLogger(MsgplatformStatusUtil.class);
    public static final String OP_MOD = "OP_MOD";
    public static final String OP_ADD = "OP_ADD";
    public static final String OP_DEL = "OP_DEL";

    public static void setMsgStatus(Object obj, String op) throws CommonException {
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
        if (OP_ADD.equalsIgnoreCase(op)) {
            // 设置系统属性
            try {
                PropertyUtils.setNestedProperty(obj, "creator", globalInfo.getTlrno());
                PropertyUtils.setNestedProperty(obj, "createdDate", DateUtil.get14Time());
                PropertyUtils.setNestedProperty(obj, "optType", "1");
//                PropertyUtils.setNestedProperty(obj, "optStatus", "0");
                PropertyUtils.setNestedProperty(obj, "optStatus", "1");
            } catch (Exception e) {
                LogExceptionUtils.logException(logger, e);
                logger.info("新增保存时，设置系统属性出错!");
                throw new CommonException("新增保存时，设置系统属性出错!");
            }

        } else if (OP_MOD.equalsIgnoreCase(op)) {
            try {
                PropertyUtils.setNestedProperty(obj, "creator", globalInfo.getTlrno());
                PropertyUtils.setNestedProperty(obj, "createdDate", DateUtil.get14Time());
                PropertyUtils.setNestedProperty(obj, "checkUser", "");
                PropertyUtils.setNestedProperty(obj, "checkDate", "");
                PropertyUtils.setNestedProperty(obj, "optType", "2");
                PropertyUtils.setNestedProperty(obj, "optStatus", "1");
//                PropertyUtils.setNestedProperty(obj, "optStatus", "0");

            } catch (Exception e) {
                LogExceptionUtils.logException(logger, e);
                logger.info("修改保存时，设置系统属性出错!");
                throw new CommonException("修改保存时，设置系统属性出错!");
            }
        } else if (OP_DEL.equalsIgnoreCase(op)) {
            try {
                PropertyUtils.setNestedProperty(obj, "creator", globalInfo.getTlrno());
                PropertyUtils.setNestedProperty(obj, "createdDate", DateUtil.get14Time());
                PropertyUtils.setNestedProperty(obj, "checkUser", "");
                PropertyUtils.setNestedProperty(obj, "checkDate", "");
                PropertyUtils.setNestedProperty(obj, "optType", "3");
                PropertyUtils.setNestedProperty(obj, "optStatus", "1");
//                PropertyUtils.setNestedProperty(obj, "optStatus", "0");
            } catch (Exception e) {
                LogExceptionUtils.logException(logger, e);
                logger.info("修改保存时，设置系统属性出错!");
                throw new CommonException("修改保存时，设置系统属性出错!");
            }
        }
    }

    public static void setAuditMsgStatus(Object obj, String approveStatus, String approveResult)
            throws CommonException {
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
        try {
            PropertyUtils.setNestedProperty(obj, "checkUser", globalInfo.getTlrno());
            PropertyUtils.setNestedProperty(obj, "checkDate", DateUtil.get14Time());
            PropertyUtils.setNestedProperty(obj, "optStatus", approveStatus);
            PropertyUtils.setNestedProperty(obj, "rsv1", approveResult);
        } catch (Exception e) {
            LogExceptionUtils.logException(logger, e);
            logger.info("审核时，设置系统属性出错!");
            throw new CommonException("审核时，设置系统属性出错!");
        }
    }
    

}
