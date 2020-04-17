package com.huateng.ebank.business.rolemng.update;

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
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.management.operation.RoleMngApplyOperation;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

import resource.bean.basic.RoleInfo;
import resource.dao.basic.RoleInfoDAO;

public class RoleStatusChgUpdate extends BaseUpdate {

    private final static String PARAM_ACTION = "statu";
    private final static String DATASET_ID = "ebankCustRoleMng";
    private final static String ROLE_ID = "id";

    @Override
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest arg1,
            HttpServletResponse arg2) throws AppException {
        try {
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
            UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
            RoleInfo roleInfo = new RoleInfo();
            RoleInfoDAO roleInfoDAO = BaseDAOUtils.getRoleInfoDAO();
            if (updateResultBean.hasNext()) {
            	 RoleInfo bean = new RoleInfo();
                 Map<String, String> map = updateResultBean.next();
                 mapToObject(bean, map);
                 roleInfo = roleInfoDAO.findById((bean.getId()));
                 String status=bean.getStatus();
                 //status状态 1-有效0-无效
                 if("0".equals(status)){
                 	roleInfo.setStatus("1");
                 }else if("1".equals(status)){
                 	roleInfo.setStatus("0");
                 }
                 // 设为修改状态
                 roleInfo.setSt("4");
//                 roleInfo.setIsLock("1");
                 rootdao.saveOrUpdate(roleInfo);
            } else {
                ExceptionUtil.throwAppException("请选择一条记录", ErrorCode.ERROR_CODE_NORMAL);
            }

            return updateReturnBean;
        } catch (CommonException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

}
