package com.huateng.report.system.getter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.utils.ReportEnum.REPORT_TASK_TRANS_CD;
import com.huateng.report.utils.ReportTaskUtil;

import resource.bean.basic.SysNotice;
import resource.bean.basic.SysTaskLog;

@SuppressWarnings("unchecked")
public class SysNoticeOldGetter extends BaseGetter {

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
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String id = getCommQueryServletRequest().getParameter("id");
        String taskId = (String) getCommQueryServletRequest().getParameter("taskId");
        PageQueryResult result = new PageQueryResult();
        if (StringUtils.isNotBlank(taskId)) {
            ReportTaskUtil rt = new ReportTaskUtil();
            SysTaskLog systasklog = ReportShowDetailService.getInstance().selectTaskLog(taskId);
            SysNotice sysNotice = null;
            if (systasklog.getOldVal1() != null) {
                sysNotice = (SysNotice) ReportTaskUtil.getOldObjectByTaskLog(systasklog);
                if (sysNotice != null) {
                    List<SysNotice> list = new ArrayList<SysNotice>();
                    list.add(sysNotice);
                    result.setQueryResult(list);
                    result.setTotalCount(1);
                }
            }
            if (systasklog.getUpdTransCd().equals(REPORT_TASK_TRANS_CD.NEW.value)) {
                sysNotice = (SysNotice) ReportTaskUtil.getNewObjectByTaskLog(systasklog);
                if (sysNotice != null) {
                    List<SysNotice> list = new ArrayList<SysNotice>();
                    list.add(sysNotice);
                    result.setQueryResult(list);
                    result.setTotalCount(1);
                }
            }
        } else {
            ArrayList<String> condList = new ArrayList<String>();
            condList.add(id);
            StringBuffer hql = new StringBuffer("select bat from SysNotice bat where bat.id =? ");
            List<SysNotice> list = rootdao.queryByQL2List(hql.toString(), condList.toArray(), null);
            result.setQueryResult(list);
            result.setTotalCount(1);
        }
        return result;
    }
}
