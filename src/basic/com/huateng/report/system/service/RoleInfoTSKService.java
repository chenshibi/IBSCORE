package com.huateng.report.system.service;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.msgplatform.service.SyncMsgPlatformService;
import com.huateng.report.utils.LogExceptionUtils;
import com.huateng.report.utils.ReportEnum.REPORT_TASK_FUNCID;
import com.huateng.report.utils.ReportTaskUtil;

import resource.bean.basic.RoleFuncRel;
import resource.bean.basic.RoleInfo;
import resource.bean.basic.SysTaskInfo;
import resource.dao.basic.RoleFuncRelDAO;
import resource.dao.basic.RoleInfoDAO;

/**
 * @author jianxue.zhang
 * @date 2008/7/2
 * @desc 岗位控制表service
 */
public class RoleInfoTSKService {
    private static final Logger logger = Logger.getLogger(RoleInfoTSKService.class);

    protected RoleInfoTSKService() {
    }

    /**
     * get instance.
     *
     * @return
     */
    public synchronized static RoleInfoTSKService getInstance() {
        return (RoleInfoTSKService) ApplicationContextUtils.getBean("RoleInfoTSKService");
    }

    /**
     * @author fubo
     * @desc 岗位增删改
     * @param insertList
     * @param delList
     * @param updateList
     * @throws CommonException
     */
    

    public void saveCustRole(List<RoleInfo> insertList, List<RoleInfo> updateList) throws CommonException {
        RoleInfoDAO roleInfoDAO = BaseDAOUtils.getRoleInfoDAO();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        // 新增岗位
        for (RoleInfo bean : insertList) {
            List<RoleInfo> rl = roleInfoDAO.findByRolename(bean.getRoleName());
            if (rl != null && rl.size() > 0) {
                ExceptionUtil.throwCommonException("角色名称重复[" + bean.getRoleName() + "]，不能新增");
            }
            List<SysTaskInfo> list = ROOTDAOUtils.getSysTaskInfoDAO().queryByRoleInfo(bean.getRoleName());
            if (list != null && list.size() > 0) {
                ExceptionUtil.throwCommonException("角色名称[" + bean.getRoleName() + "，不能新增待审核，不能新增");
            }
            roleInfoDAO.save(bean);
            // 取出rolelist执行插入;
            String roleList = bean.getRoleList();
            TaskListService tls = TaskListService.getInstance();
            tls.updateRoleFunc(bean.getId(), roleList);
        }

        // 更新新岗位
        for (RoleInfo bean : updateList) {
        	   // 更新菜单
        		deleteFromEntry(bean.getId());
                // 取出rolelist执行插入;
                String roleList = bean.getRoleList();
                TaskListService tls = TaskListService.getInstance();
                tls.updateRoleFunc(bean.getId(), roleList);
            }
            
        }
    
    
    
    public void deleteBySql(String sql) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        rootdao.executeSql(sql);
    }

    public void deleteFromEntry(String  roleId) throws CommonException {
        String sql = "delete from Role_Func_Rel where role_Id = '" + roleId + "'";
        this.deleteBySql(sql);
    }

	
}
