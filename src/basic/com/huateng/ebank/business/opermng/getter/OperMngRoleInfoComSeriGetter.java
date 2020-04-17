package com.huateng.ebank.business.opermng.getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.HTStringUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.system.bean.TlrInfoAuditBean;
import com.huateng.report.utils.ReportTaskUtil;
import com.huateng.report.utils.ReportUtils;

import resource.bean.basic.RoleInfo;
import resource.bean.basic.SysTaskInfo;
import resource.bean.basic.SysTaskLog;
import resource.bean.basic.TlrRoleRel;
import resource.bean.basic.view.TlrRoleRelationView;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngRoleInfoComSeriGetter extends BaseGetter {

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

    private PageQueryResult getData() throws CommonException, IOException, ClassNotFoundException {
        PageQueryResult pageQueryResult = new PageQueryResult();
        String st = (String) getCommQueryServletRequest().getParameterMap().get("st");
        String tlrno = (String) getCommQueryServletRequest().getParameterMap().get("id");
        String flag = (String) getCommQueryServletRequest().getParameterMap().get("flag");
        String tskId = (String) getCommQueryServletRequest().getParameter("tskId");
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

        List<TlrRoleRelationView> tlrRoleViewList = new ArrayList<TlrRoleRelationView>();
        List<String> roleIds = new ArrayList<String>();
        if (flag.equals("0")) {
            if (st.equals("2")) {
                ReportTaskUtil rt = new ReportTaskUtil();
                // ArrayList<String> condList = new ArrayList<String>();
                // condList.add(tlrno);
                List<SysTaskInfo> taskList = rootdao
                        .queryByQL2List("from SysTaskInfo where intInsId='100399' and adtRcdPk='" + tlrno + "'");
                // .queryByQL2List("from SysTaskInfo where intInsId='100399' and
                // adtRcdPk='" + tlrno + "'", condList.toArray(), null);

                if (taskList.size() > 0) {
                    TlrInfoAuditBean auditBean = (TlrInfoAuditBean) ReportTaskUtil
                            .getObjctBySysTaskInfo(taskList.get(0));
                    for (TlrRoleRel rr : auditBean.getRoleRellist()) {
                        roleIds.add(rr.getRoleId());
                    }
                    List roleList = DAOUtils.getRoleInfoDAO()
                            .queryByCondition(" po.id in" + ReportUtils.toInString(roleIds) + " order by po.roleGroup");
                    // 对以有的操作员岗位在岗位列表中显示
                    for (int i = 0; i < roleList.size(); i++) {
                        RoleInfo roleInfo = (RoleInfo) roleList.get(i);
//                        if (HTStringUtils.compareIgnoreCase(roleInfo.getBrno(), brno) == true) {
                            TlrRoleRelationView tlrRoleView = new TlrRoleRelationView();
                            tlrRoleView.setRoleId(String.valueOf(roleInfo.getId()));
                            tlrRoleView.setRoleName(roleInfo.getRoleName());
                            tlrRoleView.setSysGroup(roleInfo.getRoleGroup());
                            tlrRoleViewList.add(tlrRoleView);
//                        }
                    }
                    pageQueryResult.setQueryResult(tlrRoleViewList);
                    pageQueryResult.setTotalCount(tlrRoleViewList.size());
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
                for (TlrRoleRel rr : newValue.getRoleRellist()) {
                    roleIds.add(rr.getRoleId());
                }
                List roleList = DAOUtils.getRoleInfoDAO()
                        .queryByCondition(" po.id in" + ReportUtils.toInString(roleIds));
                // 对以有的操作员岗位在岗位列表中显示
                for (int i = 0; i < roleList.size(); i++) {
                    RoleInfo roleInfo = (RoleInfo) roleList.get(i);
                    TlrRoleRelationView tlrRoleView = new TlrRoleRelationView();
                    tlrRoleView.setRoleId(String.valueOf(roleInfo.getId()));
                    tlrRoleView.setRoleName(roleInfo.getRoleName());
                    tlrRoleView.setSysGroup(roleInfo.getRoleGroup());
                    tlrRoleViewList.add(tlrRoleView);
                }
                pageQueryResult.setQueryResult(tlrRoleViewList);
                pageQueryResult.setTotalCount(tlrRoleViewList.size());
            }
        }
        return pageQueryResult;
    }
}
