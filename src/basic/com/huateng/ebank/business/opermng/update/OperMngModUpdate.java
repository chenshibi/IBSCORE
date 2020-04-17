/**
 *
 */
package com.huateng.ebank.business.opermng.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boa.enterprise.instrumentation.core.types.NameValue;
import com.huateng.boa.log4j.monitor.Actions;
import com.huateng.boa.log4j.monitor.CustLogMonitorService;
import com.huateng.boa.log4j.monitor.ProprieraryDataLabels;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.opermng.operation.OperMngOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

import resource.bean.basic.RoleInfo;
import resource.bean.basic.TlrInfo;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngModUpdate extends BaseUpdate {

    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
            HttpServletResponse response) throws AppException {
        try {

            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
            UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("operMngMod");
            TlrInfo operator = null;
            while (updateResultBean.hasNext()) {
                operator = new TlrInfo();
                Map map = updateResultBean.next();
                mapToObject(operator, map);
            }

            GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
            String brname = globalInfo.getBrName();


            UpdateResultBean roleUpdateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("operMngRoleInfo");
            List<RoleInfo> roles = new ArrayList<RoleInfo>();
            String containRole = null;
            while (roleUpdateResultBean.hasNext()) {
                RoleInfo role = new RoleInfo();
                Map map = roleUpdateResultBean.next();
                String roleId = (String) map.get("roleId");
                String roleName = (String) map.get("roleName");
                String recordState = (String) map.get("recordState");
                if(recordState.equals("delete")){
                	continue;
                }

                role.setId((roleId));
                role.setRoleName(roleName);
                roles.add(role);
            }
            /**
            if (containRole != null) {
                operator.setRoleGroup(containRole);
            }
            */
            String op = updateResultBean.getParameter("op");

            OperationContext oc = new OperationContext();
            oc.setAttribute(OperMngOperation.CMD, op);
            oc.setAttribute(OperMngOperation.IN_ROLELIST, roles);
            oc.setAttribute(OperMngOperation.IN_TLRINFO, operator);
            OPCaller.call(OperMngOperation.ID, oc);

            try {
                if (operator != null) {
                    List<List<NameValue>> proprieraryDataResords = new ArrayList<List<NameValue>>();

                    List<NameValue> valueList = new ArrayList<NameValue>();
                    TlrInfo j = (TlrInfo) operator;
                    valueList.add(new NameValue(ProprieraryDataLabels.USER_ID, j.getTlrno()));
                    valueList.add(new NameValue(ProprieraryDataLabels.USER_NAME, j.getTlrName()));
                    valueList.add(new NameValue(ProprieraryDataLabels.USER_EMAIL, j.getEmail()));
                    valueList.add(new NameValue(ProprieraryDataLabels.USER_STATUS, j.getStatus()));
                    proprieraryDataResords.add(valueList);

                    CustLogMonitorService service = CustLogMonitorService.getInstance();
                    service.BOALogMonitorProprierary(httpReq, GlobalInfo.getCurrentInstance().getTlrno(),
                            Actions.UPDATE, proprieraryDataResords,
                            com.boa.enterprise.instrumentation.core.types.Result.SUCCEEDED, null);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return updateReturnBean;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

}
