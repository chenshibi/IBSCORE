/**
 *
 */
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
import com.huateng.ebank.business.management.operation.RoleInfoOperationNew;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

import resource.bean.basic.view.FunctionInfoView;

/**
 * @author yjw
 *
 */
public class RoleInfo1Update extends BaseUpdate {

    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
            HttpServletResponse response) throws AppException {
        // TODO Auto-generated method stub
        try {
            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
            UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("parammng_RoleInfo1");
            List<FunctionInfoView> updateList = new ArrayList<FunctionInfoView>();

            while (updateResultBean.hasNext()) {
                FunctionInfoView functionInfoView = new FunctionInfoView();
                Map map = updateResultBean.next();
                functionInfoView.setSelect(Boolean.valueOf(String.valueOf(map.get("select"))).booleanValue());
                functionInfoView.setFunccode((String) map.get("funccode"));
                functionInfoView.setFuncname((String) map.get("funcname"));
                functionInfoView.setRoleid(((String) map.get("roleid")));

                switch (updateResultBean.getRecodeState()) {

                case UpdateResultBean.MODIFY:
                    updateList.add(functionInfoView);
                    break;
                default:
                    break;
                }
            }
            OperationContext oc = new OperationContext();

            oc.setAttribute(RoleInfoOperationNew.IN_UPDATE, updateList);
            oc.setAttribute(RoleInfoOperationNew.CMD, new String("UPDATE_FUNC"));

            OPCaller.call("parammng.RoleInfoOperationNew", oc);
            return updateReturnBean;

        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

}
