package com.huateng.report.system.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.utils.ReportTaskUtil;

import resource.bean.basic.SysNotice;
import resource.bean.basic.SysTaskInfo;
import resource.bean.basic.SysTaskLog;

@SuppressWarnings("unchecked")
public class SysNoticeNewGetter extends BaseGetter {

    @Override
    public Result call() throws AppException {
        try {
            PageQueryResult queryResult = getData();
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), queryResult.getQueryResult(),
                    getResult());
            result.setContent(queryResult.getQueryResult());
            result.getPage().setTotalPage(queryResult.getPageCount(getResult().getPage().getEveryPage()));
            result.init();
            result.setTotal(queryResult.getTotalCount());
            return result;

        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

    private PageQueryResult getData() throws Exception {
        String id = getCommQueryServletRequest().getParameter("id");
        String st = getCommQueryServletRequest().getParameter("st");
        String taskId = (String) getCommQueryServletRequest().getParameter("taskId");
        PageQueryResult result = new PageQueryResult();
        List<SysNotice> list = new ArrayList<SysNotice>();
        if (StringUtils.isNotBlank(taskId)) {
            ReportTaskUtil rt = new ReportTaskUtil();
            SysTaskLog systasklog = ReportShowDetailService.getInstance().selectTaskLog(taskId);
            SysNotice sysNotice = null;
            if (systasklog.getNewVal1() != null) {
                sysNotice = (SysNotice) ReportTaskUtil.getNewObjectByTaskLog(systasklog);
            }
            if (sysNotice != null) {
                list.add(sysNotice);
                result.setQueryResult(list);
                result.setTotalCount(1);
            }
        } else {
            if (st.equals("2")) {
                ReportTaskUtil rt = new ReportTaskUtil();
                ArrayList<String> condList = new ArrayList<String>();
                condList.add(id);
                List<SysTaskInfo> taskList = ROOTDAOUtils.getROOTDAO().queryByQL2List(
                        "from SysTaskInfo where intInsId='120199' and adtRcdPk= ? ", condList.toArray(), null);
                if (taskList.size() > 0) {
                    SysNotice sysNotice = (SysNotice) ReportTaskUtil.getObjctBySysTaskInfo(taskList.get(0));
                    list.add(sysNotice);
                    result.setQueryResult(list);
                    result.setTotalCount(1);
                }
            }
        }
        return result;
    }
}
