package com.huateng.ebank.business.management.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boa.enterprise.instrumentation.core.types.NameValue;
import com.huateng.boa.log4j.monitor.Actions;
import com.huateng.boa.log4j.monitor.CustLogMonitorService;
import com.huateng.boa.log4j.monitor.ProprieraryDataLabels;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.management.operation.RoleMngApplyOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.system.service.TaskListService;

import resource.bean.basic.RoleFuncRel;
import resource.bean.basic.RoleInfo;
import resource.dao.basic.RoleInfoDAO;

/**
 * @Description: 企业岗位增删改
 * @Package: com.huateng.ebank.business.custadmin.updater
 * @author: fubo
 * @date: 2010-7-30 下午11:07:43
 * @Copyright: Copyright (c) 2010
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class CustRoleSaveUpdater extends BaseUpdate {
    private final static String DATASET_ID = "RoleFuncMng";

    @Override
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0, HttpServletRequest arg1, HttpServletResponse arg2)
            throws AppException {
        GlobalInfo gi = GlobalInfo.getCurrentInstance();
        UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
        RoleInfoDAO roleInfoDAO = BaseDAOUtils.getRoleInfoDAO();
        List<RoleInfo> updateList = new ArrayList<RoleInfo>();
        List<RoleInfo> insertList = new ArrayList<RoleInfo>();
        TaskListService tls = TaskListService.getInstance();
        
        while (updateResultBean.hasNext()) {
            RoleInfo bean = new RoleInfo();
            Map<String, String> map = updateResultBean.next();
            mapToObject(bean, map);
            // mod by zhaozhiguo 2012/2/16 FPP-9 用户,岗位及机构的管理页面优化调整 end
            switch (updateResultBean.getRecodeState()) {
            case UpdateResultBean.INSERT:
                // 新增的时候,给生效日期赋值:
                bean.setEffectDate(DateUtil.get8Date());
                try {
                    // 新增的时候,给失效日期赋值:
                    bean.setExpireDate(DateUtil.get8Date());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                RoleInfo insertBean = new RoleInfo();
                // mod by zhaozhiguo 2012/2/16 FPP-9 用户,岗位及机构的管理页面优化调整 end

                insertBean.setEffectDate(bean.getEffectDate());
                insertBean.setExpireDate(bean.getExpireDate());
                insertBean.setId(String.valueOf(tls.getMaxId()+1));
                // 默认有效
                insertBean.setStatus("1");
                insertBean.setRoleName(bean.getRoleName());
                insertBean.setLastUpdDate(DateUtil.get14Time());
                insertBean.setBrclass(bean.getBrclass());
                insertBean.setLastUpdTlr(gi.getTlrno());
                insertBean.setMdTlr(gi.getTlrno());
                insertBean.setMdTime(DateUtil.get14Time());
                insertBean.setLastUpdFunc("");
                insertBean.setMisc("");
                insertBean.setMiscflgs("");
                insertBean.setTimestamps(DateUtil.get14Time());
                insertBean.setIsInqMaker(bean.getIsInqMaker());
                insertBean.setIsInqChecker(bean.getIsInqChecker());
                insertBean.setIsTxndtlMaker(bean.getIsTxndtlMaker());
                insertBean.setIsTxndtlChecker(bean.getIsTxndtlChecker());
                insertBean.setIsDynqueMaker(bean.getIsDynqueMaker());
                insertBean.setIsDynqueChecker(bean.getIsDynqueChecker());
                insertBean.setIsAllactMaker(bean.getIsAllactMaker());
                insertBean.setIsAllactChecker(bean.getIsAllactChecker());
                insertBean.setRoleGroup(bean.getRoleGroup());
                insertBean.setMail(bean.getMail());
                insertBean.setSt("4");
//                insertBean.setIsLock("1");
                insertBean.setRoleList(bean.getRoleList());
                insertList.add(insertBean);
                break;
            case UpdateResultBean.MODIFY:
                RoleInfo updateBean = new RoleInfo();
                updateBean = roleInfoDAO.findById(bean.getId());
                if (!DataFormat.isEmpty(bean.getEffectDate())) {
                    updateBean.setEffectDate(bean.getEffectDate());
                }
                if (!DataFormat.isEmpty(bean.getExpireDate())) {
                    updateBean.setExpireDate(bean.getExpireDate());
                }
                updateBean.setRoleName(bean.getRoleName());
                String status2 = bean.getStatus();
                if (status2 == null || status2.equals("")) {
                    // donothing
                } else {
                    // 这儿说明是点击了有效无效按钮
                    updateBean.setStatus(status2);
                }
                updateBean.setBrclass(bean.getBrclass());
                updateBean.setLastUpdDate(DateUtil.get14Time());
                updateBean.setLastUpdTlr(gi.getTlrno());
                updateBean.setMdTlr(gi.getTlrno());
                updateBean.setMdTime(DateUtil.get14Time());
                updateBean.setRoleList(bean.getRoleList());
                /**
                 * 法控查询录入、审核角色设置
                 */
                updateBean.setIsInqMaker(bean.getIsInqMaker());
                updateBean.setIsInqChecker(bean.getIsInqChecker());
                updateBean.setMail(bean.getMail());
                /**
                 * 电信查询录入、审核角色设置
                 */
                updateBean.setIsTxndtlMaker(bean.getIsTxndtlMaker());
                updateBean.setIsTxndtlChecker(bean.getIsTxndtlChecker());
                updateBean.setIsDynqueMaker(bean.getIsDynqueMaker());
                updateBean.setIsDynqueChecker(bean.getIsDynqueChecker());
                updateBean.setIsAllactMaker(bean.getIsAllactMaker());
                updateBean.setIsAllactChecker(bean.getIsAllactChecker());
                updateBean.setRoleGroup(bean.getRoleGroup());

                updateBean.setRoleList(bean.getRoleList());
                updateBean.setSt("4");
//                updateBean.setIsLock("1");
                updateList.add(updateBean);
                break;
                
            default:
                break;
            }
        }
        OperationContext oc = new OperationContext();
        oc.setAttribute(RoleMngApplyOperation.IN_INSERT, insertList);
        oc.setAttribute(RoleMngApplyOperation.IN_UPDATE, updateList);
        OPCaller.call(RoleMngApplyOperation.ID, oc);

        try {
            if (insertList != null && insertList.size() > 0) {
                List<List<NameValue>> proprieraryDataResords = new ArrayList<List<NameValue>>();

                List<RoleInfo> list = (List<RoleInfo>) insertList;
                for (RoleInfo objs : list) {
                    List<NameValue> valueList = new ArrayList<NameValue>();
                    RoleInfo j = (RoleInfo) objs;
                    valueList.add(new NameValue(ProprieraryDataLabels.ROLE_NAME, j.getRoleName()));
                    valueList.add(new NameValue(ProprieraryDataLabels.ROLE_STATUS, j.getStatus()));
                    valueList.add(new NameValue(ProprieraryDataLabels.ROLE_EMAIL, j.getMail()));
                    proprieraryDataResords.add(valueList);
                }
                CustLogMonitorService service = CustLogMonitorService.getInstance();
                service.BOALogMonitorProprierary(httpReq, GlobalInfo.getCurrentInstance().getTlrno(), Actions.CREATE,
                        proprieraryDataResords, com.boa.enterprise.instrumentation.core.types.Result.SUCCEEDED, null);
            }
            if (updateList != null && updateList.size() > 0) {
                List<List<NameValue>> proprieraryDataResords = new ArrayList<List<NameValue>>();

                List<RoleInfo> list = (List<RoleInfo>) updateList;
                for (RoleInfo objs : list) {
                    List<NameValue> valueList = new ArrayList<NameValue>();
                    RoleInfo j = (RoleInfo) objs;
                    valueList.add(new NameValue(ProprieraryDataLabels.ROLE_NAME, j.getRoleName()));
                    valueList.add(new NameValue(ProprieraryDataLabels.ROLE_STATUS, j.getStatus()));
                    valueList.add(new NameValue(ProprieraryDataLabels.ROLE_EMAIL, j.getMail()));
                    proprieraryDataResords.add(valueList);
                }
                CustLogMonitorService service = CustLogMonitorService.getInstance();
                service.BOALogMonitorProprierary(httpReq, GlobalInfo.getCurrentInstance().getTlrno(), Actions.UPDATE,
                        proprieraryDataResords, com.boa.enterprise.instrumentation.core.types.Result.SUCCEEDED, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updateReturnBean;
    }

}
