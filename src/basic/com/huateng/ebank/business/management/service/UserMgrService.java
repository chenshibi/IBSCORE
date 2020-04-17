/*
 * Created on 2004-10-12
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.huateng.ebank.business.management.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.UserSessionInfo;
import com.huateng.ebank.business.common.operator.PswdValidteOP;
import com.huateng.ebank.business.common.service.BctlService;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.operation.SingleOPCaller;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.service.pub.PasswordService;

import resource.bean.basic.Bctl;
import resource.bean.basic.FunctionInfo;
import resource.bean.basic.RoleInfo;
import resource.bean.basic.TlrInfo;
import resource.bean.basic.TlrLoginLog;
import resource.dao.basic.BctlDAO;
import resource.dao.basic.TlrBctlRelDAO;
import resource.dao.basic.TlrInfoDAO;

/**
 * @author Administrator
 *
 *         To change the template for this generated type comment go to
 *         Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UserMgrService {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(UserMgrService.class);

    /**
     * get instance.
     *
     * @return
     */
    public synchronized static UserMgrService getInstance() {
        return (UserMgrService) ApplicationContextUtils.getBean(UserMgrService.class.getName());
    }

    public UserMgrService() {
    }

    /**
     * 校验用户密码信息
     *
     * @param userLoginId
     *            用户名
     * @param password
     *            输入的密码
     * @return 校验结果信息，如果用户不存在或用户存在但密码不对，抛出异常；校验通过，返回true
     *
     */
    public boolean checkUserPwd(String userLoginId, String password) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("checkUserPwd(String, String) - start"); //$NON-NLS-1$
        }
        TlrInfo tlrInfo = null;

        String encMethod = CommonService.getInstance().getSysParamDef("PSWD", "ENC_MODE", "AES128");

        String pwd = PasswordService.getInstance().EncryptPassword(password, encMethod);
        TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
        tlrInfo = tlrInfoDAO.query(userLoginId);
        // 判断返回条件
        if (tlrInfo == null) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_NOT_EXIST);
        }
        if (!tlrInfo.getPassword().equals(pwd)) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_PWD_INVALID);
        }

        if (logger.isDebugEnabled()) {
            logger.info("checkUserPwd(String, String) - end"); //$NON-NLS-1$
        }
        return true;
    }

    /**
     * 校验用户信息
     *
     * @param userLoginId
     *            用户名
     * @param password
     *            输入的密码
     * @param userBrno
     * @return 校验结果信息，如果用户不存在或用户存在但密码不对，抛出异常；校验通过，返回true
     */
    public TlrInfo checkUser(String userLoginId, String password) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("checkUser(String, String) - start"); //$NON-NLS-1$
        }
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
        try {
            TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
            TlrBctlRelDAO tlrBctlRelDao = ROOTDAOUtils.getTlrBctlRelDAO();
            List tlrList = tlrInfoDAO.queryByCondition("tlrno = '" + userLoginId + "'");
         //   List tlrBctlList = tlrBctlRelDao.queryByCondition("brNo = '" + userBrno + "' and tlrNo='" + userLoginId + "'");
            if (tlrList.isEmpty()) {
                ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_NOT_EXIST);
            } 
           /**else if (tlrBctlList.size() != 1) {
                logger.error("TlrInfo[" + userLoginId + "] existed mutil");
                ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_PWD_INVALID);
            } */
            else {
                // 如果密码错误次数超过3次，那么不校验密码对错，直接告诉客户需要管理员解锁
                // int totPswdErrCnt = tlrInfo.getTotPswdErrCnt(); //密码连续错误次数
                TlrInfo tlrInfo = (TlrInfo) tlrList.get(0);
                tlrInfoDAO.getHibernateTemplate().evict(tlrInfo);
              //  TlrBctlRel tlrBctlRel = (TlrBctlRel) tlrBctlList.get(0);

                // 判断用户是否在双岗复核中还未确认
                if (tlrInfo.getSt().trim().equals("1")) {
                    ExceptionUtil.throwCommonException("创建中的用户，主管未确认不能登录");
                }
                // if (tlrInfo.getSt().trim().equals("2")) {
                // ExceptionUtil.throwCommonException("修改中的用户，主管未确认不能登录");
                // }

                // 判断所选择登录机构是否是该用户授权的机构 modify by zhangshishu 2012-09-12

                HQLDAO hqldao = BaseDAOUtils.getHQLDAO();
                // List list = hqldao.queryByQL2List("from TlrBctlRel where
                // brNo='" + userBrno + "' and tlrNo='"+userLoginId+"'");
                // if (list.size() <= 0) {
                // ExceptionUtil.throwCommonException("选择登录的机构未授权");
                // }

            //    List<Bctl> bctls = hqldao.queryByQL2List("from Bctl where brno='" + 6841 + "'");
//                if (bctls.size() <= 0) {
//                    ExceptionUtil.throwCommonException("根据选择登录机构号brno[" + userBrno + "]未查到机构信息");
//                }
//                Bctl bctl = bctls.get(0);
//                tlrInfo.setBrno(userBrno);
//                tlrInfo  .setBrcode(bctl.getBrcode());

                // int totPswdErrCnt = tlrInfo.getTotpswderrcnt().intValue();
                // if (SystemConstant.ERR_PWD_TIMES_CONTINUE <= totPswdErrCnt) {
                // ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_TLRNO_PSWD_ERR_THREE_TIMES);
                // }
                String status = tlrInfo.getStatus();
                // 如果用户已经离职，不允许再登陆
                if (SystemConstant.TLR_NO_STATE_QUIT.equals(status)) {
                    ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_TLRNO_STATUS_INVALID);
                }
                // 如果用户长时间未查询，不允许再登陆
                if (SystemConstant.TLR_NO_STATE_LOKE.equals(status)) {
                    ExceptionUtil.throwCommonException("操作员由于长时间未查询已被锁定请找管理员解锁");
                }
                // 如果用户当天查询量过大，不允许再登陆
                if (SystemConstant.TLR_NO_STATE_SEARCH.equals(status)) {
                    ExceptionUtil.throwCommonException("操作员由于一天查询量过多已被锁定请找管理员解锁");
                }
                
                // 操作员被删除后，不能登陆
                
                if (SystemConstant.FLAG_OFF.equals(tlrInfo.getFlag())) {
                    ExceptionUtil.throwCommonException("操作员不合法", ErrorCode.ERROR_CODE_TLR_BE_DELETE);
                }
                // 操作员未到生效日期或操作员登陆日期已超过失效日期后，不能登陆
                // if (globalInfo.getTxdate().before(tlrInfo.getEffectDate())) {
                // ExceptionUtil.throwCommonException("操作员还未到生效期",
                // ErrorCode.ERROR_CODE_TLR_NO_EFFECT);
                // }
                // if (globalInfo.getTxdate().after(tlrInfo.getExpireDate())) {
                // ExceptionUtil.throwCommonException("操作员已无效",
                // ErrorCode.ERROR_CODE_TLR_IS_EXPIRE);
                // }
                // FIXME 如果用户已经登录，不允许重复登陆
//                 if (SystemConstant.TLR_NO_STATE_LOGIN.equals(status)) {
//                 /** 生产模式下，不允许同一操作员异地登录. */
//                 /** modify by shen_antonio for dlogin .*/
//                	 if(!tlrInfo.getSessionId().equals(globalInfo.getSessionId())){
//                		 if (SystemDProperty.isProductionMode()) {
//                			 ExceptionUtil.throwCommonException("用户已登录！");
//                		 }
//                	 }
//                 }
                // mod by zhaozhiguo BMS-3153
                // // 当日错误次数累计超过6次，那么不校验密码对错，需要第二天才能重新使用
//                 int pswdErrCnt = tlrInfo.getPswderrcnt().intValue();
//                // // Date pswdErrDate = tlrInfo.getPswdErrDate(); //密码错误日期
//                String pswdErrDate = tlrInfo.getPswderrdate(); // 密码错误日期
//                if (null == pswdErrDate)
//                 pswdErrDate = DateUtil.dateToString(globalInfo.getTxdate());
//                 String txDate = DateUtil.dateToString(globalInfo.getTxdate());
//                 String pwdErrDate = pswdErrDate;
//                 if ((SystemConstant.ERR_PWD_TIMES_SUM <= pswdErrCnt) && (true
//                 == txDate.equals(pwdErrDate))) {
//                 ExceptionUtil.throwCommonException("用户登录失败次数已满6次，无法登录，请重置状态");
//                 }
//                //
                // // 判断返回条件
                // if (!passMd5.equals(tlrInfo.getPassword())) {
                // ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_PWD_INVALID);
                // }
                checkPassword(tlrInfo, password, globalInfo);
                setLoginInInfo(userLoginId);
                return tlrInfo;
            }
        } catch (CommonException e) {
            ExceptionUtil.throwCommonException(e.getErrMessage(), e.getKey(), e);
        }
        if (logger.isDebugEnabled()) {
            logger.info("checkUser(String, String) - end"); //$NON-NLS-1$
        }
        return null;
    }

    private void checkPassword(TlrInfo user, String password, GlobalInfo globalInfo) throws CommonException {
        PasswordService passwdService = PasswordService.getInstance();
        String enc = user.getPasswdenc();

        int lockingTime = Integer.valueOf(CommonService.getInstance().getSysParamDef("PSWD", "LOCKING_TIME", "-1"));
        if (PswdValidteOP.LOCKED.equals(user.getIsLock())) {

            if (lockingTime < 0) {
                ExceptionUtil.throwCommonException("用户已被锁定,请联系管理员解锁", "");
            } else {
                long x = System.currentTimeMillis() - DateUtil.getDateFromTime14(user.getLastfailedtm()).getTime();
                long between = x / 1000 / 60;
                if (between < lockingTime || lockingTime < 0) {
                    ExceptionUtil.throwCommonException("密码错误超过限定次数，用户已被锁定。请等待" + lockingTime/60.0 + "小时后重试或请通过AUSMS系统申请重置密码", "");
                } else {
                    user.setTotpswderrcnt(0);
                    user.setIsLock(PswdValidteOP.NOT_LOCKED);
                }
            }
        }
        OperationContext context = new OperationContext();
        context.setAttribute(PswdValidteOP.IN_OPER, user);
        if (!passwdService.ComparePassword(password, user.getPassword(), enc)) {
            if (user.getTotpswderrcnt() != null) {
                int totpswderrcnt = user.getTotpswderrcnt().intValue();
                user.setTotpswderrcnt(totpswderrcnt + 1);
            } else {
                user.setTotpswderrcnt(1);
            }
            user.setLastfailedtm(DateUtil.get14Time());

            int maxErrCnt = Integer.valueOf(CommonService.getInstance().getSysParamDef("PSWD", "MAX_ERR_CNT", "0"));
            if (user.getTotpswderrcnt().intValue() > maxErrCnt && maxErrCnt >= 0) {
                user.setTotpswderrcnt(0);
                user.setIsLock(PswdValidteOP.LOCKED);
                user.setLockReason("用户密码连续输入错误次数超过允许的最大次数" + maxErrCnt);
            }
            SingleOPCaller.call(PswdValidteOP.ID, context);
            if (PswdValidteOP.LOCKED.equals(user.getIsLock())) {
                if (lockingTime < 0) {
                    ExceptionUtil.throwCommonException("用户已被锁定,请联系管理员解锁", "");
                } else {
                    ExceptionUtil.throwCommonException("密码错误超过限定次数，用户已被锁定。请等待" + lockingTime/60.0 + "小时后重试或请通过AUSMS系统申请重置密码", "");
                }
            } else {
                ExceptionUtil.throwCommonException("密码错误,您还有" + (maxErrCnt - user.getTotpswderrcnt() + 1) + "次尝试机会",
                        ErrorCode.ERROR_CODE_USER_PWD_INVALID);
            }
        } else {
            user.setTotpswderrcnt(0);
            user.setLastfailedtm(null);
            user.setLockReason(null);
            SingleOPCaller.call(PswdValidteOP.ID, context);
        }
        DAOUtils.getHQLDAO().getHibernateTemplate().refresh(user);

        // 密码有效时间(天)
        int effectiveDay = Integer.valueOf(CommonService.getInstance().getSysParamDef("PSWD", "EFFECTIVE_DAY", "0"));
        globalInfo.setEffectiveDay(effectiveDay);
        if (StringUtils.isBlank(user.getLastPwdUpdTime())) {
            globalInfo.setPswdForcedToChange(true);// 未修改过密码
        } else {
            long between = 0L;
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                globalInfo.setLastpwdchgtm(df.parse(user.getLastPwdUpdTime()));
                between = DateUtil.getDaysBetween(new Date(), df.parse(user.getLastPwdUpdTime()));
            } catch (ParseException e) {
                ExceptionUtil.throwCommonException(e.getMessage(), "");
            }
            if (between > effectiveDay && effectiveDay >= 0) {
                globalInfo.setPswdForcedToChange(true);// 超过N久没修改密码,要强制修改
            }
        }

        // 密码强度
        GlobalInfo.setPswdStrength(CommonService.getInstance().getSysParamDef("PSWD", "PSWD_STRENGTH", "2"));
    }

    /**
     * 设置最近登陆时间
     *
     * @param userLoginId
     *            用户名
     * @return
     */
    public boolean setLoginInInfo(String userLoginId) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("setLoginInInfo(String) - start"); //$NON-NLS-1$
        }
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
        TlrInfo tlrInfo = null;
        try {
            try {
                // yjw modify 修改数据库查询方式
                TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
                tlrInfo = tlrInfoDAO.queryById(userLoginId);
                if (null != tlrInfo) {
                    tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGIN);
//                     globalInfo.setTlrStatus(SystemConstant.TLR_NO_STATE_LOGIN);
                    tlrInfo.setLastaccesstm(DateUtil.get14Time());
                    // 登陆IP
                    tlrInfo.setLoginIp(globalInfo.getIp());
                    tlrInfo.setSessionId(globalInfo.getSessionId());
                    tlrInfoDAO.update(tlrInfo);
                    // 设置当前岗位号
//                     globalInfo.setRoleId(tlrInfo.getRoleid().intValue());
                }
            } finally {
            }
            if (logger.isDebugEnabled()) {
                logger.info("setLoginInInfo(String) - end"); //$NON-NLS-1$
            }
            return true;
        } catch (Exception e) {
            logger.error("setLoginInInfo(String)", e); //$NON-NLS-1$
        }
        return false;

    }

    /**
     * 设置最近退出登陆时间
     *
     * @param userLoginId
     *            用户名
     * @return
     */
    public boolean setLoginOutInfo(String userLoginId) throws CommonException {
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
        if (logger.isDebugEnabled()) {
            logger.info("setLoginOutInfo(String) - start"); //$NON-NLS-1$
        }
        TlrInfo tlrInfo = null;
        try {
            // 修改数据库查询方式
            TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
            tlrInfo = tlrInfoDAO.queryById(userLoginId);
            if (null != tlrInfo) {
                // 设置为登出状态
                // globalInfo.setTlrStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
                /** 如果当前操作员会话信息是最后登录的操作员信息和操作员当前为签到情况下，进行签退操作. */
                if (tlrInfo.getStatus().equals(SystemConstant.TLR_NO_STATE_LOGOUT)
                        || !tlrInfo.getSessionId().equals(globalInfo.getSessionId()) ) {
                    return true;
                }
                tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
                // 最近登出时间
                tlrInfo.setLastlogouttm(DateUtil.get14Time());
                // tlrInfo.setRoleid(tlrInfo.getRoleid());
                tlrInfoDAO.update(tlrInfo);
            }
        } catch (Exception e) {
            logger.error("setLoginOutInfo(String)", e); //$NON-NLS-1$
        }
        if (logger.isDebugEnabled()) {
            logger.info("setLoginOutInfo(String) - end"); //$NON-NLS-1$
        }
        return true;

    }

    public void setUserLoginOut() throws CommonException {
        TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
        List list = tlrInfoDAO.queryByCondition(" po.status='" + SystemConstant.TLR_NO_STATE_LOGIN + "'");
        for (int i = 0; i < list.size(); i++) {
            TlrInfo tlrInfo = (TlrInfo) list.get(i);
            tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
            // 最近登出时间
            tlrInfo.setLastlogouttm(DateUtil.get14Time());
            tlrInfoDAO.update(tlrInfo);
        }
    }

    /**
     * 获取用户登录状态
     * 
     * @param tlrNo
     * @return
     */
    public String getUserLoginStatus(String tlrNo) {
        String sta = SystemConstant.TLR_NO_STATE_LOGOUT;
        TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
        try {
            TlrInfo tlrInfo = tlrInfoDAO.query(tlrNo);
            if (tlrInfo != null && tlrInfo.getStatus() != null) {
                sta = tlrInfo.getStatus().trim();
            }
        } catch (CommonException e) {
            return sta;
        }
        return sta;
    }

    /**
     * 根据用户ID获得用户信息
     *
     * @param tlrNo
     *            用户名
     * @return UserInfo对象
     */
    public TlrInfo getUserInfo(String tlrNo) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("getUserInfo(String) - start"); //$NON-NLS-1$
        }
        TlrInfo tlrInfo = null;
        TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
        tlrInfo = tlrInfoDAO.query(tlrNo);
        if (tlrInfo == null) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_NOT_EXIST);
        }
        if (logger.isDebugEnabled()) {
            logger.info("getUserInfo(String) - end"); //$NON-NLS-1$
        }
        return tlrInfo;
    }

    /**
     * 修改用户密码
     *
     * @param userLoginId
     *            用户名
     * @return 校验结果信息，如果用户不存在或用户存在但密码不对，抛出异常；校验通过，返回0
     */
    public boolean updatePassword(String userLoginId, String newPwd) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("updatePassword(String, String) - start"); //$NON-NLS-1$
        }
        // GlobalData globalInfo = GlobalData.getCurrentInstance();
        TlrInfo tlrInfo = null;
        try {
            TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
            tlrInfo = tlrInfoDAO.query(userLoginId);
            if (null != tlrInfo) {
                int preventTime = Integer
                        .valueOf(CommonService.getInstance().getSysParamDef("PSWD", "PREVENT_TIME", "-1"));
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                if (preventTime != -1 && tlrInfo.getLastPwdUpdTime() != null) {
                    long x = System.currentTimeMillis() - df.parse(tlrInfo.getLastPwdUpdTime()).getTime();
                    if (x < preventTime * 60 * 60 * 1000L) {
                        ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_PREVENT_TIME,
                                new Object[] { preventTime });
                    }
                }

                String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD",
                        SystemConstant.DEFAULT_PASSWORD);
                String encMethod = CommonService.getInstance().getSysParamDef("PSWD", "ENC_MODE", "AES128");
                String password = PasswordService.getInstance().EncryptPassword(newPwd, encMethod);
                if (!sysDefaultPwd.equals(newPwd)) {
                    PasswordService.getInstance().savePasswordHis(tlrInfo.getTlrno(), password, tlrInfo.getPasswdenc());
                }
                tlrInfo.setPasswdenc(encMethod);
                tlrInfo.setPassword(password);
                tlrInfo.setPswderrcnt(new Integer(0));
                tlrInfo.setTotpswderrcnt(new Integer(0));
                // add by zhaozhiguo begin
                tlrInfo.setLastPwdUpdTime(df.format(new Date()));
                if (sysDefaultPwd.equals(newPwd)) {// 重置密码
                    tlrInfo.setLastPwdUpdTime(null);
                }
                // add by zhaozhiguo end
                tlrInfoDAO.update(tlrInfo);
            } else {
                ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_NOT_EXIST);
            }
            // modified by NT 2007-09-23 交行机构级别检查。需要可以补加
            // BctlService bctlService = new BctlService(globalInfo);
            // bctlService.chkBrclass(tlrInfo.getBrcode().trim());
        } catch (CommonException e) {
            if (e.getKey() != null) {
                throw e;
            } else {
                ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_TLR_INFO_SELECT);
            }
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_UNKNOWN);
        }
        if (logger.isDebugEnabled()) {
            logger.info("updatePassword(String, String) - end"); //$NON-NLS-1$
        }
        return true;
    }

    /**
     * 获取用户角色列表
     *
     * @param tlrNo
     * @return
     */
    public ArrayList getUserRoles(String tlrNo) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("getUserRoles(String) - start"); //$NON-NLS-1$
        }
        try {
            ArrayList<RoleInfo> list = new ArrayList(); // 返回的列表
            // Set set = null; // dao取回的集合

            HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
            StringBuffer sb = new StringBuffer();
            sb.append("select role from ").append("TlrRoleRelation tr,RoleInfo role ")
                    .append("where tr.roleId=role.id ").append("and tr.tlrno='").append(tlrNo).append("' ");
            Iterator iterator;
            iterator = hqlDAO.queryByQL(sb.toString());
            while (iterator.hasNext()) {
                RoleInfo role = (RoleInfo) iterator.next();
                list.add(role);
            }

            if (logger.isDebugEnabled()) {
                logger.info("getUserRoles(String) - end"); //$NON-NLS-1$
            }
            return list;
        } catch (CommonException e) {
            logger.error("getUserRoles(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_INFO_INVALID);
        }
        return new ArrayList();
    }

    public List<FunctionInfo> getApproveUserFunc(List<FunctionInfo> userRoleFunclist) {
        List<FunctionInfo> infolist = new ArrayList<FunctionInfo>();
        for (int i = 0; i < userRoleFunclist.size(); i++) {
            FunctionInfo info = userRoleFunclist.get(i);
            // if (info.getLastdirectory() != null
            // &&
            // info.getLastdirectory().toString().equals(ReportConstant.APPROVE_FUNC_ID))
            // {
            infolist.add(info);
            // }
        }
        return infolist;
    }

    /**
     * 获取用户功能列表
     *
     * @param tlrNo
     * @return
     */
    public ArrayList getUserFunctions(String tlrNo) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("getUserFunctions(String) - start"); //$NON-NLS-1$
        }
        try {
            ArrayList<FunctionInfo> list = new ArrayList(); // 返回的列表
            HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
            StringBuffer sb = new StringBuffer();
            sb.append("select distinct func from ").append("TlrRoleRel tr,RoleFuncRel rr,FunctionInfo func ")
                    .append("where tr.roleId=rr.roleId and rr.funcid=func.id ")
                    .append("and tr.tlrno= ? and (func.funcType='1')")
                    .append(" and tr.roleId in ( select id from RoleInfo  ) ")
                    .append(" order by func.showseq");
            list = (ArrayList<FunctionInfo>) hqlDAO.queryByQL2List(sb.toString(), new String[] { tlrNo }, null);
            if (logger.isDebugEnabled()) {
                logger.info("getUserFunctions(String) - end"); //$NON-NLS-1$
            }
            return list;
        } catch (CommonException e) {
            logger.error("getUserFunctions(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_INFO_INVALID);
        }
        return new ArrayList();

    }

    /**
     * 获取用户功能列表(区分功能）
     *
     * @param tlrNo
     * @return
     */
    public void getUserFunctionsByMenuType(String tlrNo, String funcId, List<FunctionInfo> resultList)
            throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("getUserFunctions(String) - start"); //$NON-NLS-1$
        }
        try {
            HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
            StringBuffer sb = new StringBuffer();
            sb.append("select distinct func from ").append("TlrRoleRel tr,RoleFuncRel rr,FunctionInfo func ")
                    .append("where tr.roleId=rr.roleId and rr.funcid=func.id ").append("and tr.tlrno= ? ");
            sb.append(" and func.lastdirectory= ? ");
            sb.append(" and tr.roleId in ( select id from RoleInfo ) ");
            sb.append(" order by func.showseq");
            List<FunctionInfo> list = hqlDAO.queryByQL2List(sb.toString(), new String[] { tlrNo, funcId }, null);
            for (FunctionInfo func : list) {
                resultList.add(func);
                if (func.getId().trim().equals(ReportConstant.APPROVE_FUNC_ID)) {
                    func.setIsdirectory(0);// 调整为不是目录
                }
                if (func.getLastdirectory() != null && !func.getLastdirectory().equals(ReportConstant.APPROVE_FUNC_ID)
                        && func.getIsdirectory() == 1) {
                    getUserFunctionsByMenuType(tlrNo, func.getId(), resultList);
                }
            }
            if (logger.isDebugEnabled()) {
                logger.info("getUserFunctions(String) - end"); //$NON-NLS-1$
            }
        } catch (CommonException e) {
            logger.error("getUserFunctions(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_INFO_INVALID);
        }

    }

    /**
     * 获取机构信息
     *
     * @param brCode
     * @return
     */
    public Bctl getUserBctl(String brCode) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("getUserBctl(String) - start"); //$NON-NLS-1$
        }
        Bctl bctl = null; // 返回的机构信息
        BctlDAO bctlDAO = BaseDAOUtils.getBctlDAO();
        bctl = bctlDAO.query(brCode);
        if (logger.isDebugEnabled()) {
            logger.info("getUserBctl(String) - end"); //$NON-NLS-1$
        }
        return bctl;
    }

    /**
     * 获取用户会话信息，交行优化版本 原因：交行需要实现切换操作员岗位
     *
     * @param String
     *            userID 柜员编号
     *
     * @author wu_james
     *
     * @return UserSessionInfo 用户会话信息
     */
    public UserSessionInfo getUserSessionInfo(TlrInfo tlrinfo) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("getUserSessionInfo(TlrInfo) - start"); //$NON-NLS-1$
        }
        UserSessionInfo sessionInfo = new UserSessionInfo();
        try {
            BctlService bctlService = BctlService.getInstance();
//            Bctl bctl = bctlService.getBctlByBrcode(DataFormat.trim(tlrinfo.getBrcode()));
            sessionInfo.setTlrNo(tlrinfo.getTlrno().trim());
            sessionInfo.setTlrName(DataFormat.trim(tlrinfo.getTlrName()));
            sessionInfo.setLastLogoutTime(GetDateFormat(tlrinfo.getLastlogouttm()));
            sessionInfo.setIp(DataFormat.trim(tlrinfo.getLoginIp()));
            // 这个名称是汉字，大于10个字就截掉，相当于20个字节
//            sessionInfo.setBrName(bctl.getBrname());
            HQLDAO hqldao = BaseDAOUtils.getHQLDAO();
            List<TlrLoginLog> lastSucList = hqldao.queryByQL2List("from TlrLoginLog where tlrNo='" + tlrinfo.getTlrno()
                    + "' and loginSucTm=(select max(log.loginSucTm) from TlrLoginLog log where tlrNo='"
                    + tlrinfo.getTlrno() + "')");
            if (lastSucList != null && lastSucList.size() > 0) {
                sessionInfo.setLastLoginTime(GetDateFormat(lastSucList.get(0).getLoginSucTm()));
            } else {
                sessionInfo.setLastLoginTime(GetDateFormat(tlrinfo.getLastaccesstm()));
            }
            // 设置最近登录失败时间
            List<TlrLoginLog> lastFailList = hqldao.queryByQL2List("from TlrLoginLog where tlrNo='" + tlrinfo.getTlrno()
                    + "' and loginFailTm=(select max(log.loginFailTm) from TlrLoginLog log where tlrNo='"
                    + tlrinfo.getTlrno() + "')");
            if (lastFailList != null && lastFailList.size() > 0) {
                sessionInfo.setLastLoginFailTime(GetDateFormat(lastFailList.get(0).getLoginFailTm()));
            }
        } catch (CommonException e) {
            throw e;
        } catch (Exception e) {
            logger.error("getUserSessionInfoEx(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_INFO_INVALID);
        } finally {
        }
        if (logger.isDebugEnabled()) {
            logger.info("getUserSessionInfo(TlrInfo) - end"); //$NON-NLS-1$
        }
        return sessionInfo;
    }

    /**
     * Description: 用户登录时，校验用户密码，并且获取用户岗位权限信息
     *
     * @param
     * @return UserSessionInfo
     * @exception @author
     *                shen_antonio
     * @version v1.0,2008-11-4
     * @param userBrno
     */
    public UserSessionInfo loginUserSessionInfo(String userId, String pwd) throws CommonException {
        // 检查用户密码
        TlrInfo tlrinfo = checkUser(userId, pwd);
        return getUserSessionInfo(tlrinfo);
    }

    /**
     * 校验用户密码信息
     *
     * @param userLoginId
     *            用户名
     * @param password
     *            输入的密码
     * @return 校验结果信息，如果用户不存在或用户存在但密码不对，抛出异常；校验通过，返回true
     *
     */
    public boolean checkUserPwd(String userLoginId, String password, String newPasswd) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("checkUserPwd(String, String, String) - start"); //$NON-NLS-1$
        }

        // 比较密码不能为六个相同字母
        boolean bSameChars = true;
        char c = newPasswd.charAt(0);
        for (int i = 0; i < newPasswd.length(); i++) {
            if (c != newPasswd.charAt(i)) {
                bSameChars = false;
                break;
            }
        }
        if (true == bSameChars)
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_CHG_PWD_SAME_CHARS);

        // 新旧密码不能相同
        if (true == newPasswd.trim().equals(password.trim()))
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_NEW_OLD_PWD_IS_SAME);
        TlrInfo tlrInfo = null;
        TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
        tlrInfo = tlrInfoDAO.query(userLoginId);
        // 判断返回条件
        if (tlrInfo == null) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_NOT_EXIST);
        }
        String encMethod = CommonService.getInstance().getSysParamDef("PSWD", "ENC_MODE", "AES128");

        String pwd = PasswordService.getInstance().EncryptPassword(password, encMethod);

        if (!tlrInfo.getPassword().equals(pwd)) {
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_PWD_INVALID);
        }

        if (logger.isDebugEnabled()) {
            logger.info("checkUserPwd(String, String, String) - end"); //$NON-NLS-1$
        }
        return true;
    }

    /**
     * 校验新旧密码字段数据有效性
     *
     * @param oldpwd
     *            旧密码
     * @param newpwd
     *            新密码
     * @param againnewpwd
     *            新密码确认
     * @return
     *
     */
    public void checkPwdFields(String oldPwd, String newPwd, String againNewPwd) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("checkPwdFields(String, String, String) - start"); //$NON-NLS-1$
        }

        // 所有密码字段不能为空或空格
        if ((null == oldPwd) || (null == newPwd) || (null == againNewPwd))
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_PWD_FIELDS_IS_NULL);

        if ((0 == oldPwd.trim().length()) || (0 == newPwd.trim().length()) || (0 == againNewPwd.trim().length()))
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_PWD_FIELDS_IS_NULL);

        // 新旧密码不能相同
        if (true == newPwd.trim().equals(oldPwd.trim()))
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_NEW_OLD_PWD_IS_SAME);

        // 新密码和确认密码必须相同
        if (false == newPwd.trim().equals(againNewPwd.trim()))
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_NEW_AGAIN_PWD_IS_NOT_SAME);

        if (logger.isDebugEnabled()) {
            logger.info("checkPwdFields(String, String, String) - end"); //$NON-NLS-1$
        }
        return;
    }

    /**
     * Description: 切换岗位，重启session中权限信息
     *
     * @param curRoleId
     *            当前岗位号
     * @return void
     * @exception @author
     *                shen_antonio
     * @version v1.0,2008-9-3
     */
    // public void changeRole(Integer curRoleId, UserSessionInfo
    // userSessionInfo) throws CommonException {
    // TlrInfoDAO tid = BaseDAOUtils.getTlrInfoDAO();
    // TlrInfo ti = tid.query(GlobalInfo.getCurrentInstance().getTlrno());
    // ti.setRoleid(curRoleId);
    // tid.update(ti);
    // RoleInfoService roleInfoService = RoleInfoService.getInstance();
    // RoleInfo roleInfo =
    // roleInfoService.getRoleInfoByRoleId(curRoleId.intValue());
    // String workfoleRole =
    // "";//roleInfo.getWorkflowRole();删除role_info中的workflow_role字段
    // // 设置操作员当前岗位
    // userSessionInfo.getUserRoles().clear();
    // userSessionInfo.addUserRolesItem(curRoleId.toString());
    // // 设置操作员当前工作流岗位
    // userSessionInfo.getWorkflowRoles().clear();
    // userSessionInfo.addWorkflowRolesItem(workfoleRole);
    // // 重新设置GlobalInfo信息
    // GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
    //// globalInfo.setRoleId(curRoleId.intValue());
    // globalInfo.setWorkflowRoleId(workfoleRole);
    //// globalInfo.getUserRoles().clear();
    // // 设置操作员当前岗位交易权限
    // StringBuffer sb = new StringBuffer(512);
    // sb.append("select fi.funcCode").append(" from RoleFuncRelation as rfr,
    // FunctionInfo as fi ").append("where rfr.roleId=").append(
    // ti.getRoleid()).append(" and rfr.funcCode = fi.funcCode ");
    // Iterator it = BaseDAOUtils.getHQLDAO().queryByQL(sb.toString());
    // if (it.hasNext()) {
    // userSessionInfo.clearFunctionsItems();
    // while (it.hasNext()) {
    // String results = (String) it.next();
    // userSessionInfo.addUserFunctionsItem(results.trim());
    //// globalInfo.getUserRoles().add(results.trim());
    // }
    // } else {
    // userSessionInfo.clearFunctionsItems();
    // }
    //
    // }

    /**
     * 该方法用于查询该机构存在的业务功能
     * 
     * @throws CommonException
     */
    public List getBranchFuctions(String brcode) throws CommonException {

        StringBuffer hqlBuffer = new StringBuffer(512);
        hqlBuffer.append("select distinct func ");
        hqlBuffer.append(" from FunctionInfo func,BranchFuncRel brel ");
        hqlBuffer.append(" where brel.funcid = func.id and func.status='1' and brel.brcode = '");
        hqlBuffer.append(brcode);
        hqlBuffer.append("'");

        String hql = hqlBuffer.toString();
        List branchFunctions = BaseDAOUtils.getHQLDAO().queryByQL2List(hql);

        return branchFunctions;
    }

    /* add by rls for CICS 20160803 begin */
    /**
     * 检查当前登录的用户
     * 
     * @param userID
     * @param userBrno
     */
    public void checkUserByBrhNo(String userID) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("checkUser(String, String) - start");
        }
//        try {
//            List<TlrBctlRel> tlrBctlRelList = DAOUtils.getHQLDAO().getHibernateTemplate()
//                    .find("from TlrBctlRel where tlrNo='" + userID + "' and brNo='" + userBrno + "'");
//            if (null != tlrBctlRelList && tlrBctlRelList.size() > 0) {
//                if (tlrBctlRelList.size() != 1) {
//                    ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_TLRNO_NO_FUNCTION);
//                } else {
//                    TlrBctlRel tlrBctlRel = tlrBctlRelList.get(0);
//                    if (!userBrno.equals(tlrBctlRel.getBrNo())) {
//                        ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_TLRNO_NO_FUNCTION);
//                    }
//                }
//            } else {
//                ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_TLRNO_NO_FUNCTION);
//            }
//        } catch (CommonException e) {
//            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_TLRNO_NO_FUNCTION);
//        }
        if (logger.isDebugEnabled()) {
            logger.info("checkUser(String, String) - end");
        }
    }
    /* add by rls for CICS 20160803 end */

    private String GetDateFormat(String date) {
        if (date == null) {
            return null;
        }
        try {
            String date1 = date.replace("/", "").replace("-", "").replace(":", "").replace(" ", "");
            if (date1 != null && date1.length() == 14) {
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
                Date getdate = format.parse(date1.toString());
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formatdate = format1.format(getdate);
                return formatdate;
            } else {
                return date;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

//    public String getBrnoName(String brno) {
//        try {
//            Bctl bctl = DAOUtils.getBctlDAO().query(brno);
//            if (bctl == null) {
//                return "";
//            } else {
//                return bctl.getBrname();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }

//    public ArrayList<Bctl> getBctlList(String tlrno) {
//        try {
//            List<TlrBctlRel> tlrBctlRelList = DAOUtils.getHQLDAO().getHibernateTemplate()
//                    .find("from TlrBctlRel where tlrNo= ? ", new String[] { tlrno });
//            if (tlrBctlRelList == null || tlrBctlRelList.size() == 0) {
//                return null;
//            } else {
//                ArrayList<Bctl> rlst = new ArrayList<Bctl>();
//                for (TlrBctlRel rel : tlrBctlRelList) {
//                    rlst.add(DAOUtils.getBctlDAO().query(rel.getBrNo()));
//                }
//                return rlst;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    public ArrayList<String> getBrnoList(String tlrno) {
//        try {
//            List<TlrBctlRel> tlrBctlRelList = DAOUtils.getHQLDAO().getHibernateTemplate()
//                    .find("from TlrBctlRel where status = '1' and tlrNo = ? ", new String[] { tlrno });
//            if (tlrBctlRelList == null || tlrBctlRelList.size() == 0) {
//                return null;
//            } else {
//                ArrayList<String> rlst = new ArrayList<String>();
//                for (TlrBctlRel rel : tlrBctlRelList) {
//                    rlst.add(rel.getBrNo() + "-" + getBrnoName(rel.getBrNo()));
//                }
//                return rlst;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
