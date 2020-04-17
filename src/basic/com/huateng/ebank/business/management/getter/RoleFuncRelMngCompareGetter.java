package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.service.ReportShowDetailService;
import com.huateng.report.system.bean.RoleInfoBean;
import com.huateng.report.utils.ReportTaskUtil;

import resource.bean.basic.RoleInfo;
import resource.bean.basic.SysTaskInfo;
import resource.bean.basic.SysTaskLog;

public class RoleFuncRelMngCompareGetter extends BaseGetter {

    @Override
    public Result call() throws AppException {
        try {
            String id = getCommQueryServletRequest().getParameter("id");
            String st = getCommQueryServletRequest().getParameter("st");
            String tskId = getCommQueryServletRequest().getParameter("tskId");
            String flag = getCommQueryServletRequest().getParameter("flag");

            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            List<RoleInfoBean> resultList = new ArrayList<RoleInfoBean>();
            ReportTaskUtil rt = new ReportTaskUtil();
            if (flag.equals("0")) {
                RoleInfo roleInfo = rootdao.query(RoleInfo.class, (id));
                RoleInfoBean roleInfoBean = new RoleInfoBean();
                roleInfoBean.setRoleNameOld(roleInfo.getRoleName());
                roleInfoBean.setIdOld(roleInfo.getId());
                roleInfoBean.setIsInqCheckerOld(roleInfo.getIsInqChecker());
                roleInfoBean.setIsInqMakerOld(roleInfo.getIsInqMaker());
                roleInfoBean.setMailOld(roleInfo.getMail());
                roleInfoBean.setStatusOld(roleInfo.getStatus());
                roleInfoBean.setRoleNameOld(roleInfo.getRoleName());
                roleInfoBean.setIdOld(roleInfo.getId());
                roleInfoBean.setIsInqCheckerOld(roleInfo.getIsInqChecker());
                roleInfoBean.setIsInqMakerOld(roleInfo.getIsInqMaker());
                roleInfoBean.setMailOld(roleInfo.getMail());
                roleInfoBean.setIsTxndtlMakerOld(roleInfo.getIsTxndtlMaker());
                roleInfoBean.setIsTxndtlCheckerOld(roleInfo.getIsTxndtlChecker());
                roleInfoBean.setIsDynqueMakerOld(roleInfo.getIsDynqueMaker());
                roleInfoBean.setIsDynqueCheckerOld(roleInfo.getIsDynqueChecker());
                roleInfoBean.setIsAllactMakerOld(roleInfo.getIsAllactMaker());
                roleInfoBean.setIsAllactCheckerOld(roleInfo.getIsAllactChecker());
                roleInfoBean.setRoleGroupOld(roleInfo.getRoleGroup());

                if (st.equals("2")) {
                    ArrayList<String> condList = new ArrayList<String>();
                    condList.add(id);
                    List<SysTaskInfo> taskList = ROOTDAOUtils.getROOTDAO().queryByQL2List(
                            "from SysTaskInfo where intInsId='100299' and adtRcdPk= ? ", condList.toArray(), null);
                    if (taskList.size() > 0) {
                        RoleInfo seriBean = (RoleInfo) ReportTaskUtil.getObjctBySysTaskInfo(taskList.get(0));
                        roleInfoBean.setStatus(seriBean.getStatus());
                        roleInfoBean.setRoleName(seriBean.getRoleName());
                        roleInfoBean.setId(roleInfo.getId());
                        roleInfoBean.setIsInqChecker(seriBean.getIsInqChecker());
                        roleInfoBean.setIsInqMaker(seriBean.getIsInqMaker());
                        roleInfoBean.setMail(seriBean.getMail());

                        roleInfoBean.setIsTxndtlMaker(seriBean.getIsTxndtlMaker());
                        roleInfoBean.setIsTxndtlChecker(seriBean.getIsTxndtlChecker());
                        roleInfoBean.setIsDynqueMaker(seriBean.getIsDynqueMaker());
                        roleInfoBean.setIsDynqueChecker(seriBean.getIsDynqueChecker());
                        roleInfoBean.setIsAllactMaker(seriBean.getIsAllactMaker());
                        roleInfoBean.setIsAllactChecker(seriBean.getIsAllactChecker());
                        roleInfoBean.setRoleGroup(seriBean.getRoleGroup());
                    }
                }
                resultList.add(roleInfoBean);
            }
            if (flag.equals("1")) {
                SysTaskLog systasklog = ReportShowDetailService.getInstance().selectTaskLog(tskId);
                RoleInfo newBean = null;
                RoleInfo oldbean = null;
                RoleInfoBean roleInfoBean = new RoleInfoBean();
                if (systasklog.getOldVal1() != null) {
                    oldbean = (RoleInfo) ReportTaskUtil.getOldObjectByTaskLog(systasklog);
                }
                if (systasklog.getNewVal1() != null) {
                    newBean = (RoleInfo) ReportTaskUtil.getNewObjectByTaskLog(systasklog);
                }
                // 新增的时候
                if (st.equals("1")) {
                    roleInfoBean.setRoleName(newBean.getRoleName());
                    roleInfoBean.setId(newBean.getId());
                    roleInfoBean.setIsInqChecker(newBean.getIsInqChecker());
                    roleInfoBean.setIsInqMaker(newBean.getIsInqMaker());
                    roleInfoBean.setMail(newBean.getMail());

                    roleInfoBean.setIsTxndtlMaker(newBean.getIsTxndtlMaker());
                    roleInfoBean.setIsTxndtlChecker(newBean.getIsTxndtlChecker());
                    roleInfoBean.setIsDynqueMaker(newBean.getIsDynqueMaker());
                    roleInfoBean.setIsDynqueChecker(newBean.getIsDynqueChecker());
                    roleInfoBean.setIsAllactMaker(newBean.getIsAllactMaker());
                    roleInfoBean.setIsAllactChecker(newBean.getIsAllactChecker());
                    roleInfoBean.setRoleGroup(newBean.getRoleGroup());
                }
                // 修改的时候
                else if (st.equals("2")) {
                    roleInfoBean.setRoleName(newBean.getRoleName());
                    roleInfoBean.setId(newBean.getId());
                    roleInfoBean.setIsInqChecker(newBean.getIsInqChecker());
                    roleInfoBean.setIsInqMaker(newBean.getIsInqMaker());
                    roleInfoBean.setMail(newBean.getMail());
                    roleInfoBean.setIsTxndtlMaker(newBean.getIsTxndtlMaker());
                    roleInfoBean.setIsTxndtlChecker(newBean.getIsTxndtlChecker());
                    roleInfoBean.setIsDynqueMaker(newBean.getIsDynqueMaker());
                    roleInfoBean.setIsDynqueChecker(newBean.getIsDynqueChecker());
                    roleInfoBean.setIsAllactMaker(newBean.getIsAllactMaker());
                    roleInfoBean.setIsAllactChecker(newBean.getIsAllactChecker());
                    roleInfoBean.setRoleGroup(newBean.getRoleGroup());

                    roleInfoBean.setRoleNameOld(oldbean.getRoleName());
                    roleInfoBean.setIdOld(oldbean.getId());
                    roleInfoBean.setIsInqCheckerOld(oldbean.getIsInqChecker());
                    roleInfoBean.setIsInqMakerOld(oldbean.getIsInqMaker());
                    roleInfoBean.setMailOld(oldbean.getMail());
                    roleInfoBean.setIsTxndtlMakerOld(oldbean.getIsTxndtlMaker());
                    roleInfoBean.setIsTxndtlCheckerOld(oldbean.getIsTxndtlChecker());
                    roleInfoBean.setIsDynqueMakerOld(oldbean.getIsDynqueMaker());
                    roleInfoBean.setIsDynqueCheckerOld(oldbean.getIsDynqueChecker());
                    roleInfoBean.setIsAllactMakerOld(oldbean.getIsAllactMaker());
                    roleInfoBean.setIsAllactCheckerOld(oldbean.getIsAllactChecker());
                    roleInfoBean.setRoleGroupOld(oldbean.getRoleGroup());
                }
                resultList.add(roleInfoBean);
            }
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), resultList, getResult());
            result.setContent(resultList);
            result.getPage().setTotalPage(1);
            result.init();
            result.setTotal(resultList.size());
            return result;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }
}
