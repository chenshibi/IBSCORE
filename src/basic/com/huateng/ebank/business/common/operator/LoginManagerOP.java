/*
 * $Header: /home/plis/batch/cvs/cvsdvp/BocomplJAR/JavaSource/com/huateng/bocompl/common/LoginManagerOP.java,v 1.32 2005/06/22 06:44:37 wu_zhiqiang Exp $
 * $Revision: 1.32 $
 * $Date: 2005/06/22 06:44:37 $
 *
 * ===================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ===================================================================
 */

package com.huateng.ebank.business.common.operator;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.util.CollectionUtils;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.CommonFunctions;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.UserSessionInfo;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.business.management.service.UserMgrService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.basic.Bctl;
import resource.bean.basic.FunctionInfo;
import resource.bean.basic.RoleInfo;

/**
 * 用户登陆操作
 *
 * @author James wu
 * @version 1.0.0
 */

public class LoginManagerOP extends BaseOperation {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(LoginManagerOP.class);

    // KEY值定义，包括输入IN 和输出OUT

    public static final String ID = "Management.LoginManagerOP";
    public static final String IN_TLR_NO = "TLR_NO";
    public static final String IN_TLR_PWD = "TLR_PWD";
    public static final String IN_GLOBALINFO = "IN_GLOBALINFO";
    public static final String OUT_USER_SESSION_INFO = "USER_SESSION_INFO";
    public static final String OUT_GLOBALINFO_INFO = "GLOBALINFO";

    public static final String CONTEXT_PATH = "CONTEXT_PATH";
    public static final String OUT_TREE = "TREE_FUNCTION";
    public static final String OUT_MENU = "MENU_FUNCTION";

    public static final String IN_TLR_BRNO = "IN_TLR_BRNO";

    /*
     * (non-Javadoc)
     *
     * @see com.huateng.ebank.framework.operation.BaseOperation#beforeProc(com.
     * huateng.ebank.framework.operation.OperationContext)
     */
    public void beforeProc(OperationContext context) throws CommonException {
        // 判断系统状态
        // 判断用户登录信息是否符合
        GlobalInfo globalInfo = (GlobalInfo) context.getAttribute(LoginManagerOP.IN_GLOBALINFO);
        globalInfo.setTxdate(new Date());
        globalInfo.setFileDate(DataFormat.getCurrentDateStr());

        globalInfo.setLastDate(DateUtil.getLastDate());
        GlobalInfo.setCurrentInstance(globalInfo);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.huateng.ebank.framework.operation.BaseOperation#execute(com.huateng.
     * ebank.framework.operation.OperationContext)
     */
    public void execute(OperationContext context) throws CommonException {

        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();

        String userID = (String) context.getAttribute(LoginManagerOP.IN_TLR_NO);

        String userPwd = (String) context.getAttribute(LoginManagerOP.IN_TLR_PWD);

    //    String userBrno = (String) context.getAttribute(IN_TLR_BRNO);

        UsernamePasswordToken userToken = new UsernamePasswordToken(userID, userPwd.toCharArray());
     //   userToken.setHost(userBrno);
        try {
            SecurityUtils.getSubject().login(userToken);
        } catch (AuthenticationException e) {
            // TODO Auto-generated catch block
            throw new CommonException(e.getMessage());
        }
        UserSessionInfo sessionInfo = (UserSessionInfo) SecurityUtils.getSubject().getPrincipal();
        new UserMgrService();
        UserMgrService userMgrService = UserMgrService.getInstance();
        /** add by rls for CICS 20160803 begin */
     //   userMgrService.checkUserByBrhNo(userID, userBrno);
        /** add by rls for CICS 20160803 end */
        // 保存会计日期
        sessionInfo.setTxDate(globalInfo.getTxdate());
        // 设定用户信息
  //      userMgrService.setLoginInInfo(userID, userBrno);

        // 设定全局信息
        // 设置工作流岗位号
        if (!sessionInfo.getWorkflowRoles().isEmpty()) {
            globalInfo.setWorkflowRoleId(((RoleInfo) sessionInfo.getWorkflowRoles().toArray()[0]).getId().toString());
        }

        // Iterator roleIt = sessionInfo.getUserRoles().iterator();
        // List roleList = new ArrayList();
        // while (roleIt.hasNext()) {
        // roleList.add(new
        // Integer(Integer.parseInt(roleIt.next().toString())));
        // }
        // globalInfo.setUserRoles(roleList);
        /* . */

        // 获得用户的分行号, 如果是总行, 设置为本身
        BctlService bctlService = BctlService.getInstance();
//        Bctl bctl = bctlService.getBctlByBrcode(globalInfo.getBrcode());

        /** modify by xiaojian.yu STL-80 bug修复 20101125 start **/
        // if(bctl.getBrclass().equals(SystemConstant.BRCODE_CLASS_HEAD)){
        // globalInfo.setBranchBrcode(bctl.getBrclass());
        // }else{
        // globalInfo.setBranchBrcode(bctl.getBlnBranchBrcode());
        // }
        /** modify by xiaojian.yu STL-80 bug修复 20101125 end **/

        // 设置分行级别
        // globalInfo.setBrClass(bctl.getBlnBranchClass());
        // 设置机构级别
//        globalInfo.setBrClass(bctl.getBrclass());
        // 设置外部机构号
  //      globalInfo.setBrno(bctl.getBrno());
        // 设置机构名称
//        globalInfo.setBrName(bctl.getBrname());
        // 设置操作员 add by shao_mying
        globalInfo.setTlrno(userID);
        // 设置地区码
        // globalInfo.setArea(bctl.getRegionalism());
        // 设置ContextPath
        globalInfo.setSContextPath((String) context.getAttribute(CONTEXT_PATH));

        // 记录查询日志参数
        String saveQeuryLog = CommonService.getInstance().getSysParamDef("PSWD", "SAVE_QUERY_LOG", "0");
        globalInfo.setSaveQueryLog(saveQeuryLog);

        // 获取用户的管理分行,如果是总行，设置为本身
        /*
         * String manageBrcode =
         * bctlService.getBranchManageBrcode(globalInfo.getBrcode());
         * globalInfo.setBranchMngBrcode(manageBrcode);
         */
        // 设置当前机构是否为总行
        // globalInfo.setHeadBrcode(bctlService.isHeadBrcode(globalInfo.getBrcode()));

        List<FunctionInfo> userRoleFunclist = userMgrService.getUserFunctions(userID);
        // List<FunctionInfo> resultFuncList = new ArrayList();

        // 设置返回值
        context.setAttribute(LoginManagerOP.OUT_USER_SESSION_INFO, sessionInfo);
        context.setAttribute(LoginManagerOP.OUT_GLOBALINFO_INFO, globalInfo);
        if (logger.isDebugEnabled()) {
            logger.info("logicProc() - end"); //$NON-NLS-1$
        }
        // 2:将用户有权限访问的功能页面的功能码 存入map中，作为按钮权限的基类调用。
        // 该map 的k为tab对象的id， v为功能码，由于我们的tab id 就是用的功能码，所以K,V均为FunctionInfo的ID。
        Map<String, String> buttonMap = new LinkedHashMap<String, String>();
        for (FunctionInfo f : userRoleFunclist) {
            // buttonMap.put(f.getId(),f.getId());
            if (f.getPagepath() != null) {
                String[] authPath = f.getPagepath().split("\\?");
                buttonMap.put(authPath[0], f.getId());
            }
        }
        globalInfo.setButtonMap(buttonMap);
        // 3:比对用户的功能列表和机构的功能列表 遍历方式
//        if (CollectionUtils.isEmpty(userRoleFunclist)) {
//            ExceptionUtil.throwCommonException("没有该用户可以操作的业务！");
//        }
        // String roleidHQL="select tr from TlrRoleRel tr where
        // tr.tlrno="+userID;
        // List
        // rolelist=ROOTDAOUtils.getROOTDAO().queryByQL2List(roleidHQL.toString());
        // int roleId=0;
        // if(rolelist.size()>0){
        // TlrRoleRel tRoleRel=(TlrRoleRel)rolelist.get(0);
        // roleId=tRoleRel.getRoleId();
        // }
        // globalInfo.setRoleId(roleId);
        // 4:把用于按钮，页面，其他权限的相关信息注入map中(用于渲染)，以便每次的请求从中对比是否具有权限。
        StringBuffer buttonHQL1 = new StringBuffer();
        buttonHQL1.append("select distinct func from ").append("TlrRoleRel tr,RoleFuncRel rr,FunctionInfo func ")
                .append("where tr.roleId=rr.roleId and rr.funcid=func.id ").append("and tr.tlrno='").append(userID)
                .append("' and func.funcType='1' order by func.showseq");
        List buttonFunctionList = BaseDAOUtils.getHQLDAO().queryByQL2List(buttonHQL1.toString());
        Map<String, String> buttonFunctionMap = new LinkedHashMap<String, String>();
        Map<String, String> pageFunctionMap = new LinkedHashMap<String, String>();
        Map<String, String> otherFunctionMap = new LinkedHashMap<String, String>();
        for (Object o : buttonFunctionList) {
            FunctionInfo functionInfo = (FunctionInfo) o;
            if ("0".equals(functionInfo.getFuncClass())) {
                buttonFunctionMap.put(functionInfo.getPagepath(), functionInfo.getId());
            } else if ("1".equals(functionInfo.getFuncClass())) {
                pageFunctionMap.put(functionInfo.getPagepath(), functionInfo.getId());
            } else if ("2".equals(functionInfo.getFuncClass())) {
                otherFunctionMap.put(functionInfo.getPagepath(), functionInfo.getId());
            }
        }
        globalInfo.setButtonFunctionMap(buttonFunctionMap);
        globalInfo.setPageFunctionMap(pageFunctionMap);
        globalInfo.setOtherFunctionMap(otherFunctionMap);
        // 5：对于设定了按钮，页面，其他权限的功能码的映射
        String buttonHQL2 = new String("select f from FunctionInfo f where f.funcType='1'");
        List buttonFunctList = BaseDAOUtils.getHQLDAO().queryByQL2List(buttonHQL2);
        Map<String, String> buttonFuncMap = new LinkedHashMap<String, String>();
        Map<String, String> pageFuncMap = new LinkedHashMap<String, String>();
        Map<String, String> otherFuncMap = new LinkedHashMap<String, String>();
        for (Object o : buttonFunctList) {
            FunctionInfo functionInfo = (FunctionInfo) o;
            if (functionInfo.getPagepath() == null) {
                continue;
            }
            if ("0".equals(functionInfo.getFuncClass())) {
                buttonFuncMap.put(functionInfo.getPagepath(), functionInfo.getId());
            } else if ("1".equals(functionInfo.getFuncClass())) {
                String[] authPath = functionInfo.getPagepath().split("\\?");
                pageFuncMap.put(authPath[0], functionInfo.getId());
                // pageFuncMap.put(functionInfo.getPagepath(),functionInfo.getId());
            } else if ("2".equals(functionInfo.getFuncClass())) {
                otherFuncMap.put(functionInfo.getPagepath(), functionInfo.getId());
            }
        }
        globalInfo.setButtonFuncMap(buttonFuncMap);
        globalInfo.setPageFuncMap(pageFuncMap);
        globalInfo.setOtherFuncMap(otherFuncMap);
        // 组装菜单
        StringBuffer tree = new StringBuffer();
        StringBuffer menu = new StringBuffer();

        // 是否可进行主管确认操作
        List<FunctionInfo> confrimList = userMgrService.getApproveUserFunc(userRoleFunclist);
        globalInfo.setConfrimCodeList(confrimList);

        globalInfo.setAllFunctions(CommonFunctions.transToHashtableByFunc(userRoleFunclist));
        GlobalInfo.setCurrentInstance(globalInfo);

        /**
         * tree.append(CommonFunctions.getRoleFunction(SystemConstant.TREE_ROOT,
         * userRoleFunclist, SystemConstant.TREE_TREE_FLAG)); if(tree.length()
         * != 0) tree.deleteCharAt(tree.length()-1);
         * menu.append(CommonFunctions.getRoleFunction(SystemConstant.TREE_ROOT,
         * userRoleFunclist, SystemConstant.TREE_MENU_FLAG)); if(menu.length()
         * != 0) menu.deleteCharAt(menu.length()-1);
         * 
         * 
         * context.setAttribute(LoginManagerOP.OUT_TREE, tree);
         * context.setAttribute(LoginManagerOP.OUT_MENU, menu);
         **/
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.huateng.ebank.framework.operation.BaseOperation#afterProc(com.huateng
     * .ebank.framework.operation.OperationContext)
     */
    public void afterProc(OperationContext context) throws CommonException {
    }

}
