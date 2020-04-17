package com.huateng.report.system.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.system.bean.SysParamsEntryDetail;
import com.huateng.report.system.service.SysParamsService;
import com.huateng.report.utils.ReportTaskUtil;

import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;
import resource.bean.basic.SysTaskInfo;
import resource.bean.basic.SysTaskLog;

/**
 *
 * author by 计翔 2012.9.5 系统参数旧信息对比的getter
 */
public class SysParamsEntryDetailGetter extends BaseGetter {
    public Result call() throws AppException {
        String action = this.getCommQueryServletRequest().getParameter("action");

        List<SysParamsEntryDetail> list = new ArrayList<SysParamsEntryDetail>();

        String id1 = this.getCommQueryServletRequest().getParameter("id1");
        String id2 = this.getCommQueryServletRequest().getParameter("id2");
        String st = this.getCommQueryServletRequest().getParameter("st");
        String flag = this.getCommQueryServletRequest().getParameter("flag");
        String tskId = this.getCommQueryServletRequest().getParameter("tskId");

        SysParamsPK pk = new SysParamsPK();
        pk.setParamgroupId(id1);
        pk.setParamId(id2);

        try {

            if ("detail".equals(action)) {
                ReportTaskUtil rt = new ReportTaskUtil();
                if ("0".equals(flag)) {
                    SysParamsEntryDetail ber = new SysParamsEntryDetail();
                    SysParams oldbean = SysParamsService.getInstance().selectById(pk);
                    SysParams newBean = null;
                    ber.setOld_sysparams(oldbean);
                    // 从审计任务中获取
                    Iterator it = ReportShowDetailService.getInstance().selectByKey(id1 + "#" + id2);
                    Class cls = null;
                    while (it.hasNext()) {
                        SysTaskInfo tem = (SysTaskInfo) it.next();
                        Object temp = ReportTaskUtil.getObjctBySysTaskInfo(tem);
                        cls = temp.getClass();
                        if (cls.equals(SysParams.class)) {
                            newBean = (SysParams) temp;
                        }

                    }

                    ber.setSysparams(newBean);
                    list.add(ber);

                }

                else if ("1".equals(flag)) {
                    SysTaskLog systasklog = ReportShowDetailService.getInstance().selectTaskLog(tskId);
                    SysParams newBean = null;
                    SysParams oldbean = null;
                    SysParamsEntryDetail spe = new SysParamsEntryDetail();

                    if (systasklog.getOldVal1() != null) {

                        oldbean = (SysParams) ReportTaskUtil.getOldObjectByTaskLog(systasklog);

                    }
                    if (systasklog.getNewVal1() != null) {

                        newBean = (SysParams) ReportTaskUtil.getNewObjectByTaskLog(systasklog);

                    }
                    // 新增的时候
                    if (st.equals("1")) {
                        spe.setOld_sysparams(newBean);

                    }
                    // 修改的时候
                    else if (st.equals("2")) {
                        spe.setOld_sysparams(oldbean);
                        spe.setSysparams(newBean);
                    }
                    // 删除的时候
                    else if (st.equals("3")) {
                        spe.setOld_sysparams(oldbean);
                    }

                    list.add(spe);

                }

            }

            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
            getResult().setContent(list);
            getResult().getPage().setTotalPage(1);
            getResult().init();
            getResult().setTotal(list.size());

            return getResult();
        } catch (CommonException e) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, e.getMessage());
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }

    }

}
