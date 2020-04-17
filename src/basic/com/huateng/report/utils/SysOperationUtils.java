package com.huateng.report.utils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.constants.SYSConstant;
import com.huateng.report.constants.SYSErrorCode;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import resource.bean.basic.DataDic;
import resource.dao.basic.DataDicDAO;

import java.util.List;


public class SysOperationUtils {
    private static final Logger logger = Logger.getLogger(SysOperationUtils.class);

    public static boolean isNotNullOrEmpty(List<?> list) {
        return !isNullOrEmpty(list);
    }

    public static boolean isNullOrEmpty(List<?> list) {
        if (list == null) {
            return true;
        } else if (list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 设置bean的mdTime，mdTlrno和status=00
     *
     * @param obj
     * @throws Exception
     */
    public static void setTempItemMakeStatus(Object obj) throws CommonException {
        try {
            GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
            String time = DateUtil.get14Time();
            PropertyUtils.setNestedProperty(obj, "ckTime", null);
            PropertyUtils.setNestedProperty(obj, "ckTlrno", null);
            PropertyUtils.setNestedProperty(obj, "mdTime", time);
            PropertyUtils.setNestedProperty(obj, "mdTlrno", globalInfo.getTlrno());
            PropertyUtils.setNestedProperty(obj, "status", SYSConstant.OPERATION_STATUS_PENDING);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CommonException(e.getMessage());
        }
    }

    /**
     * 设置bean的ckTime，ckTlrno和status=00
     *
     * @param obj
     * @throws Exception
     */
    public static void setTempItemCheckStatus(Object obj) throws CommonException {
        try {
            GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
            String time = DateUtil.get14Time();
            PropertyUtils.setNestedProperty(obj, "ckTime", time);
            PropertyUtils.setNestedProperty(obj, "ckTlrno", globalInfo.getTlrno());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CommonException(e.getMessage());
        }
    }

    /**
     * 将临时表属性复制到主表
     *
     * @param tmp
     * @param main
     * @throws Exception
     */
    public static void copyTempToMain(Object tmp, Object main) throws CommonException {
        try {

            if (SYSConstant.OPERATION_TYPE_ADD.equals(PropertyUtils.getNestedProperty(tmp, "opType"))) {
                PropertyUtils.setNestedProperty(main, "crtTime", PropertyUtils.getNestedProperty(tmp, "mdTime"));
                PropertyUtils.setNestedProperty(main, "crtTlrno", PropertyUtils.getNestedProperty(tmp, "mdTlrno"));
            }
            PropertyUtils.copyProperties(main, tmp);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CommonException(e.getMessage());
        }
    }

    /**
     * 将源对象属性复制到目标对象
     *
     * @param dest 目标
     * @param orig 源
     * @throws Exception
     */
    public static void copyOrigToDest(Object dest, Object orig) throws CommonException {
        try {
            PropertyUtils.copyProperties(dest, orig);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new CommonException(e.getMessage());
        }
    }

    /**
     * @param data       需要检查的
     * @param dataTypeNo data_dic表的dataTypeNo字段
     * @return true: 合法的值； false: 非法值，需要抛出异常到前台。
     */
    public static boolean isDataInDataDic(String data, int dataTypeNo) {
        DataDicDAO dao = ROOTDAOUtils.getDataDicDAO();
        List<DataDic> list = dao.findByDataTypeNo(dataTypeNo);
        for (DataDic dic : list) {
            if (dic.getDataNo().equals(data)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 锁定状态为00-待审核的临时表记录
     *
     * @param bean: 临时表bean
     * @throws CommonException
     */
    public static void lockNoWaitForCheck(Object bean) throws CommonException {
        lockNoWaitForCheck(bean, "status", "00");
    }

    /**
     * 锁定状态为00-待审核的临时表记录
     *
     * @param bean: 临时表bean
     * @throws CommonException
     */
    public static void lockNoWaitForCheck(Object bean, String statusColumn, String statusValue) throws CommonException {
        if (bean == null) {
            SYSErrorCode.throwCommonException("需要锁定的表为空！", SYSErrorCode.RECORD_NOT_EXIST);
        }

        String tableName = bean.getClass().getSimpleName();
        String id = null;
        try {
            id = (String) PropertyUtils.getNestedProperty(bean, "id");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SYSErrorCode.throwCommonException("获取不到Bean的id字段！" + e.getMessage(), SYSErrorCode.RECORD_NOT_EXIST);
        }
        String hql = " from " + tableName + " as po where id = ? and " + statusColumn +
                " = ?";
        boolean rlst = ROOTDAOUtils.getROOTDAO().findAndLockNoWait(hql, "po", new String[]{id, statusValue});
        if (rlst == false) {
            SYSErrorCode.throwCommonException("锁定数据失败，请重新查询！", SYSErrorCode.RECORD_NOT_EXIST);
        }
    }

    /**
     * @param id aml_Datasource_tmp
     * @throws CommonException
     */
    public static void lockTxnTmpNoWaitForCheck(String id) throws CommonException {
        if (StringUtils.isBlank(id)) {
            SYSErrorCode.throwCommonException("需要锁定的表ID为空！", SYSErrorCode.RECORD_NOT_EXIST);
        }

        String hql = " from AmlDatasourceTmp as po where id = ? and cStatus = ?";
        boolean rlst = ROOTDAOUtils.getROOTDAO().findAndLockNoWait(hql, "po", new String[]{id, "00"});
        if (rlst == false) {
            SYSErrorCode.throwCommonException("锁定数据失败，请重新查询！", SYSErrorCode.RECORD_NOT_EXIST);
        }
    }

    public static String getPrettyString(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list == null || list.size() == 0) {
            return "";
        }
        int i = 0;
        for (String str : list) {
            stringBuffer.append(i);
            stringBuffer.append(':');
            stringBuffer.append(str);
            stringBuffer.append('\n');
            i++;
        }
        return stringBuffer.toString();
    }

}

