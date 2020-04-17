/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.opermng.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.system.bean.TlrInfoAuditBean;
import com.huateng.report.utils.ReportTaskUtil;

import resource.bean.basic.SysTaskInfo;
import resource.bean.basic.SysTaskLog;
import resource.bean.basic.TlrInfo;

/**
 * @author zhiguo.zhao
 * 
 */
public class OperMngModComSeriGetter extends BaseGetter {

    public Result call() throws AppException {
        try {
            PageQueryResult pageResult = getData();
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
                    getResult());

            result.setContent(pageResult.getQueryResult());
            result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
            result.init();
            result.setTotal(pageResult.getTotalCount());
            return result;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

    protected PageQueryResult getData() throws Exception {
        PageQueryResult result = new PageQueryResult();
        String tlrno = (String) getCommQueryServletRequest().getParameterMap().get("id");
        String st = (String) getCommQueryServletRequest().getParameterMap().get("st");
        String flag = (String) getCommQueryServletRequest().getParameterMap().get("flag");
        String tskId = (String) getCommQueryServletRequest().getParameter("tskId");

        List<TlrInfo> list = new ArrayList<TlrInfo>();
        if (flag.equals("0")) {
            if (st.equals("2")) {
                ReportTaskUtil rt = new ReportTaskUtil();
                ArrayList<String> condList = new ArrayList<String>();
                condList.add(tlrno);
                List<SysTaskInfo> taskList = ROOTDAOUtils.getROOTDAO().queryByQL2List(
                        "from SysTaskInfo where intInsId='100399' and adtRcdPk=? ", condList.toArray(), null);
                if (taskList.size() > 0) {
                    TlrInfoAuditBean auditBean = (TlrInfoAuditBean) ReportTaskUtil
                            .getObjctBySysTaskInfo(taskList.get(0));
                    list.add(auditBean.getTlrInfo());
                    result.setQueryResult(list);
                    result.setTotalCount(1);
                    if (auditBean.getTlrInfo().getRestFlg() != null
                            && auditBean.getTlrInfo().getRestFlg().equals("reset")) {
                        list.get(0).setReset("reset");
                    }
                }
            }
        }
        if (flag.equals("1")) {
            ReportTaskUtil rt = new ReportTaskUtil();
            SysTaskLog systasklog = ReportShowDetailService.getInstance().selectTaskLog(tskId);
            TlrInfoAuditBean newValue = null;
            if (systasklog.getNewVal1() != null) {
                newValue = (TlrInfoAuditBean) ReportTaskUtil.getNewObjectByTaskLog(systasklog);
            }
            if (newValue != null) {
                TlrInfo tlrInfo = newValue.getTlrInfo();
                list.add(tlrInfo);
                if (tlrInfo.getRestFlg() != null && tlrInfo.getRestFlg().equals("reset")) {
                    tlrInfo.setReset("reset");
                }
                result.setQueryResult(list);
                result.setTotalCount(1);
            }
        }
        return result;
    }
}
