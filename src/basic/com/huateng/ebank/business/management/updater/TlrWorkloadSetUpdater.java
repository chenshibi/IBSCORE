package com.huateng.ebank.business.management.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.management.operation.TlrWorkloadSetOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

import resource.bean.basic.TlrInfo;

/**
 * 操作员增加EX
 *
 * @author hyurain_yang
 *
 */
public class TlrWorkloadSetUpdater extends BaseUpdate {

    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
            HttpServletResponse response) throws AppException {
        try {
            UpdateResultBean bean = multiUpdateResultBean.getUpdateResultBeanByID("Management_TlrWorkloadSet");
            List<TlrInfo> updateList = new ArrayList<TlrInfo>();
            while (bean.hasNext()) {
                TlrInfo tlrInfo = new TlrInfo();
                Map map = bean.next();
                mapToObject(tlrInfo, map);
                updateList.add(tlrInfo);
            }
            OperationContext oc = new OperationContext();
            oc.setAttribute(TlrWorkloadSetOperation.UPDATE_LIST, updateList);
            OPCaller.call(TlrWorkloadSetOperation.ID, oc);
            return new UpdateReturnBean();
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

    /**
     * 只有支行级别的机构可以增加客户经理和支行行长的操作员
     * 
     * @param brcode
     * @param roleId
     *            return boolean
     */
    // public boolean isProBranchRoleAddCustManageAndSubBranch(String brcode,
    // String roleId) throws CommonException {
    // int roleIdInt = Integer.valueOf(roleId).intValue();
    // if ( SystemConstant.ROLE_CUST_MANAGER == roleIdInt ||
    // roleIdInt==SystemConstant.SUB_BRANCH_MANAGER) {
    // if (BctlService.getInstance().isSubBrcode(brcode)) {
    // return true;
    // } else
    // return false;
    // }
    // return true;
    // }

}
