package com.huateng.ebank.business.opermng.getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.system.bean.TlrInfoBean;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;

import resource.bean.basic.SysTaskInfo;
import resource.bean.basic.TlrInfo;
import resource.dao.basic.TlrInfoDAO;

public class OperMngAddCompareGetter extends BaseGetter {

    public Result call() throws AppException {

        String adtRcdPk = getCommQueryServletRequest().getParameter("adtRcdPk");
        SysTaskInfo sysTaskInfo = (SysTaskInfo) getSysTaskInfo(adtRcdPk).get(0);// 获取SysTaskInfo
        ReportTaskUtil reportTaskUtil = new ReportTaskUtil();
        TlrInfoBean tlrInfoBean = new TlrInfoBean();
        try {
            tlrInfoBean = (TlrInfoBean) ReportTaskUtil.getObjctBySysTaskInfo(sysTaskInfo);// 获取修改的bean
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        TlrInfo tlrInfo = null;
        if (ReportEnum.REPORT_TASK_TRANS_CD.NEW.value.equals(sysTaskInfo.getUpdTransCd())) {
            tlrInfo = new TlrInfo();
        } else {
            TlrInfoDAO tlrInfoDao = DAOUtils.getTlrInfoDAO();
            tlrInfo = tlrInfoDao.queryById(tlrInfoBean.getTlrno());// 获取旧bean
        }

        List<TlrInfoBean> resultList = new ArrayList<TlrInfoBean>();
        tlrInfoBean.setBrcodeOld(tlrInfo.getBrcode());
        tlrInfoBean.setFlagOld(tlrInfo.getFlag());
        tlrInfoBean.setTlrNameOld(tlrInfo.getTlrName());
        tlrInfoBean.setTlrnoOld(tlrInfo.getTlrno());
        resultList.add(tlrInfoBean);
        ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), resultList, getResult());

        result.setContent(resultList);
        result.getPage().setTotalPage(1);
        result.init();
        result.setTotal(resultList.size());
        return result;
    }

    public List getSysTaskInfo(String adtRcdPk) throws CommonException {
        ArrayList<String> condList = new ArrayList<String>();
        condList.add(adtRcdPk);
        String str = "select sti from SysTaskInfo sti where sti.adtRcdPk = ? and sti.intInsId = '"
                + ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value + "'";
        List fl = DAOUtils.getHQLDAO().queryByQL2List(str, condList.toArray(), null);
        return fl;
    }
}
