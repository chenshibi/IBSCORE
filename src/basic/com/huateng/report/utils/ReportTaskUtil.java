package com.huateng.report.utils;

import java.io.IOException;

import com.huateng.common.DataFormat;
import com.huateng.common.DateUtil;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;

import resource.bean.basic.SysTaskInfo;
import resource.bean.basic.SysTaskLog;

public class ReportTaskUtil {

    private static final int Len = 2048;// 审计相关表中存数长度

    /**
     * 将字符拆分
     * 
     * @param str
     * @return
     * @throws CommonException
     */
    public static String[] getStrToArray(String str) throws CommonException {
        String[] array = new String[] { "", "" };
        if (!DataFormat.isEmpty(str)) {
            int strLen = str.length();
            if (strLen > Len) {
                array[0] = str.substring(0, Len);
                array[1] = str.substring(Len, strLen);
            } else {
                array[0] = str;
            }
        }
        return array;
    }

    private static String getTaskNo() throws CommonException {
        return ReportUtils.getUUID();
    }

    /**
     * 获取写入复核任务表Bean
     * 
     * @param intInsId
     *            审计功能码
     * @param updTransCd
     *            变更功能码
     * @param obj
     *            对象 （可以为空）
     * @param objId
     *            对象主键（可以为空）
     * @param oldSt
     *            原记录状态，用于审计不通过恢复状态 (创建时可以为空)
     * @return
     * @throws CommonException
     * @throws IOException
     * @throws IOException
     * @throws IOException
     */
    public static SysTaskInfo getSysTaskInfoBean(String intInsId, String updTransCd, Object obj, String objId,
            String oldSt) throws CommonException, IOException {
        GlobalInfo gd = GlobalInfo.getCurrentInstance();
        String crtDt = DateUtil.get8Date();
        String lastTms = DateUtil.get14Date();
        SysTaskInfo tskInf = new SysTaskInfo();
        tskInf.setId(getTaskNo());
        tskInf.setIntOperId(gd.getTlrno());
        tskInf.setInsCd(gd.getBrcode());
        tskInf.setIntInsId(intInsId);
        tskInf.setAdtRcdPk(objId == null ? "" : objId);
        tskInf.setUpdTransCd(updTransCd);
        tskInf.setCrtDt(crtDt);
        tskInf.setLastUpdOper(gd.getTlrno());
        tskInf.setLastUpdTms(lastTms);
        if (obj != null) {
            String[] jsons = getStrToArray(ReportObjectSerializerUtil.serialize(obj));
            tskInf.setNewVal1(jsons[0]);
            tskInf.setNewVal2(jsons[1]);
        }
        tskInf.setOldSt(oldSt);
        return tskInf;
    }

    // /**
    // * 审计任务表记录编辑
    // * @param oldAdtTskInf 审计任务原记录
    // * @param updTransCd 变更功能码
    // * @param newObj 新对象
    // * @param newObjId 新对象Id
    // * @return 新的审计任务对象
    // * @throws CommonException
    // */
    // public TblGcmsAdtTskInf getTblGcmsAdtTskInfBeanByEdit(TblGcmsAdtTskInf
    // oldAdtTskInf,String updTransCd,Object newObj,String newObjId) throws
    // CommonException{
    // GlobalInfo gd = GlobalInfo.getCurrentInstance();
    // String crtDt = DateUtil.get8Date();
    // String lastTms = DateUtil.get14Date();
    // oldAdtTskInf.setIntOperId(gd.getTlrno());
    // oldAdtTskInf.setInsCd(gd.getBrcode());
    // oldAdtTskInf.setAdtRcdPk(newObjId==null?"":newObjId);
    // oldAdtTskInf.setUpdTransCd(updTransCd);
    // oldAdtTskInf.setCrtDt(crtDt);
    // oldAdtTskInf.setLastUpdOper(gd.getTlrno());
    // oldAdtTskInf.setLastUpdTms(lastTms);
    // if (newObj!=null) {
    // String[] jsons =
    // GcmsJsonUtil.getStrToArray(GcmsJsonUtil.ObjectToString(newObj));
    //
    // oldAdtTskInf.setNewVal1(jsons[0]);
    // oldAdtTskInf.setNewVal2(jsons[1]);
    // }
    //
    // return oldAdtTskInf;
    // }

    /**
     * 从任务记录中获取序列化对象
     * 
     * @param tskInf
     * @return
     * @throws CommonException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static Object getObjctBySysTaskInfo(SysTaskInfo tskInf)
            throws CommonException, IOException, ClassNotFoundException {
        Object obj = null;
        if (tskInf != null) {
            StringBuffer result = new StringBuffer();
            if (!DataFormat.isEmpty(tskInf.getNewVal1())) {
                result.append(tskInf.getNewVal1());
            }

            if (!DataFormat.isEmpty(tskInf.getNewVal2())) {
                result.append(tskInf.getNewVal2());
            }
            obj = ReportObjectSerializerUtil.unserialize(result.toString());
        }
        return obj;
    }

    /**
     * 从任务记录旧表中获取序列化old对象
     * 
     * @param tskInf
     * @return
     * @throws CommonException
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public static Object getOldObjectByTaskLog(SysTaskLog tskInf)
            throws CommonException, IOException, ClassNotFoundException {
        Object obj = null;
        if (tskInf != null) {
            StringBuffer result = new StringBuffer();
            if (!DataFormat.isEmpty(tskInf.getOldVal1())) {
                result.append(tskInf.getOldVal1());
            }

            if (!DataFormat.isEmpty(tskInf.getOldVal2())) {
                result.append(tskInf.getOldVal2());
            }
            obj = ReportObjectSerializerUtil.unserialize(result.toString());
        }
        return obj;
    }

    // 获取日志表中的新值
    public static Object getNewObjectByTaskLog(SysTaskLog tsklog)
            throws CommonException, IOException, ClassNotFoundException {
        Object obj = null;
        if (tsklog != null) {
            StringBuffer result = new StringBuffer();
            if (!DataFormat.isEmpty(tsklog.getNewVal1())) {
                result.append(tsklog.getNewVal1());
            }

            if (!DataFormat.isEmpty(tsklog.getNewVal2())) {
                result.append(tsklog.getNewVal2());
            }
            obj = ReportObjectSerializerUtil.unserialize(result.toString());
        }
        return obj;
    }

}
