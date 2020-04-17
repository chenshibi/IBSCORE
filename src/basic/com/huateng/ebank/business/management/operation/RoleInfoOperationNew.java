/*
 * Created on 2005-5-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.ebank.business.management.operation;

import java.util.List;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.basic.RoleFuncRel;
import resource.bean.basic.RoleInfo;
import resource.bean.basic.view.FunctionInfoView;
import resource.dao.basic.RoleInfoDAO;

/**
 * @author wuguangjie
 *
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class RoleInfoOperationNew extends BaseOperation {

    public static final String CMD = "CMD";
    public static final String IN_ROLE_LIST = "IN_ROLE_LIST";
    public static final String OUT_ROLE_LIST = "OUT_ROLE_LIST";
    // public static final String IN_FUNC_LIST="IN_FUNC_LIST";
    // public static final String IN_REPORT_LIST="IN_REPORT_LIST";

    // public static final String IN_DEL = "IN_DEL";
    //
    // public static final String IN_INSERT = "IN_INSERT";

    public static final String IN_UPDATE = "IN_UPDATE";

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.huateng.ebank.framework.operation.IOperation#beforeProc(com.huateng.
     * ebank.framework.operation.OperationContext)
     */
    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.huateng.ebank.framework.operation.IOperation#execute(com.huateng.
     * ebank.framework.operation.OperationContext)
     */
    public void execute(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
        RoleInfoDAO roleInfoDao = DAOUtils.getRoleInfoDAO();

        String cmd = (String) context.getAttribute(RoleInfoOperationNew.CMD);
        // 查询所有角色信息
        if (cmd.equals("SELECT")) {
            List info = roleInfoDao.queryByCondition("1=1");
            context.setAttribute(RoleInfoOperationNew.OUT_ROLE_LIST, info);
        } else if (cmd.equals("UPDATE")) {
            checkBrcode();
            List updateList = (List) context.getAttribute(IN_UPDATE);
            for (int i = 0; i < updateList.size(); i++) {
                RoleInfo roleinfo = (RoleInfo) updateList.get(i);

                RoleInfo roleinfopdate = roleInfoDao.query(roleinfo.getId());
                // roleinfopdate.setRoleType(roleinfo.getRoleType());
                roleInfoDao.update(roleinfopdate);

            }

        } else if (cmd.equals("UPDATE_FUNC")) {
            // checkBrcode();

            String role_id = "";
            List mylist = (List) context.getAttribute(RoleInfoOperationNew.IN_UPDATE);
            for (int i = 0; i < mylist.size(); i++) {
                FunctionInfoView finfoview = (FunctionInfoView) mylist.get(i);
                role_id = finfoview.getRoleid();
                List list2 = DAOUtils.getRoleFuncRelDAO().queryByCondition(
                        "po.funcid='" + String.valueOf(finfoview.getFunccode()) + "'  and po.roleId='" + role_id + "'");
                RoleFuncRel rfinfo = null;
                // role_id funcCode对存在 role_Func_Relation中
                if (list2 != null && list2.size() != 0)
                    rfinfo = (RoleFuncRel) list2.get(0);

                if (rfinfo == null && finfoview.isSelect()) {
                    // 如果不存在，但是被选中，插入
                    RoleFuncRel rfinfo2 = new RoleFuncRel();

                    rfinfo2.setFuncid(finfoview.getFunccode());
                    rfinfo2.setRoleId(role_id);
                    DAOUtils.getRoleFuncRelDAO().insert(rfinfo2);
                } else if (rfinfo != null && !finfoview.isSelect())
                    // 原来存在但是没有选中 删除
                    DAOUtils.getRoleFuncRelDAO().delete(rfinfo);

            }

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng.
     * ebank.framework.operation.OperationContext)
     */
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    private void checkBrcode() throws CommonException {
        String brcode = GlobalInfo.getCurrentInstance().getBrcode();
        String brclass = BctlService.getInstance().getBrclass(brcode);
        if (!brclass.equals(SystemConstant.BRCODE_CLASS_HEAD)) {

            ExceptionUtil.throwCommonException("您不是总行，无权进行角色权限设置", ErrorCode.ERROR_CODE_NO_PERMISSION);
        }
    }

}