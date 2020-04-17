/*
 * ===================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2003-2004 Huateng Software System.  All rights
 * reserved.
 * ===================================================================
 */

package com.huateng.ebank.business.common;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author jason.mao
 * @date 2010-07-28
 * @desc 全局信息
 */

public class GlobalInfo extends BaseGlobalData implements Serializable {

    public GlobalInfo() {
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static ThreadLocal<GlobalInfo> session = new ThreadLocal<GlobalInfo>();
    private static final Logger log = Logger.getLogger(GlobalInfo.class);

    public static String KEY_GLOBAL_INFO = "GLOBAL_INFO";

    /***
     * 应用间post传递属性
     */
    private Date txdate = null; // 会计日期
    private String tlrno = null; // 操作员号
    private String brClass = null; // 机构级别
    private String workflowRoleId = "";// 工作流当前岗位号
    private String funcCode; // 交易代码
    private String sessionId = "";// 用于session校验
    private String language = null;// 语言,用于支持多国语言
    private String tokenId = null;
    private Set<String> eesSet = null;// 从EES返回的SET集合
    /**
     * 交易公共属性,由基类负责更新
     */
    private String ip = null; // IP
    private Time txtime = null; // 时间
    private int tlsrnoPr = 0; // 主流水号
    private int tlsrnoEx = 0; // 次流水号

    /**
     * 交易属性,由交易更新,用于记录流水
     */
    private String contractno = null; // 合同号
    private String cino = null; // 借据号
    private String custcd = null; // 客户号
    private String appno = null; // 申请编号
    private double txamt = 0; // 金额

    /**
     * 特殊用途
     */
    private Map allFunctions = Collections.synchronizedMap(new LinkedHashMap<Object, Object>());// 在登录时得到所有菜单展现\
    private String workflowTlrno;// 工作流提交时显示下一岗位操作员列表用

    private String contractnoFlag = "0";
    private String custcdFlag = "0";
    private String appnoFlag = "0";
    private String txamtFlag = "0";

    // add by learncy.zou 2011-02-15 begin
    private String taskId = "";// 任务号
    private String procInsId = "";// 流程号
    private int roleId = 0;
    // add by learncy.zou 2011-02-15 end

    /* add by shishu.zhang for TopReport 2012-8-15 begin. */
    private Date lastDate; // 上一个工作日
    private String brName;
    // ============================================report============
    private String fileDate;// 存储生成上报文件临时日期

    private String saveQueryLog;// 是否记录查询日志

    private List confrimCodeList = new ArrayList();// 可执行主管确认编码

    private String menuCode = "0";// 当前系统编号

    // ==============================================================

    // 按钮权限，以tab 的id 为K,功能吗为v
    private Map<String, String> buttonMap;
    private String currentTabId;
    // 用于按钮功能映射 从ROLE_FUNC_REL表
    private Map<String, String> buttonFunctionMap;
    // 用于按钮功能映射 从FUNCTIONINFO表
    private Map<String, String> buttonFuncMap;
    // 用于页面功能的映射 从ROLE_FUNC_REL表
    private Map<String, String> pageFunctionMap;
    // 用于页面功能的映射 从FUNCTIONINFO表
    private Map<String, String> pageFuncMap;
    // 用于其他功能的映射 从ROLE_FUNC_REL表
    private Map<String, String> otherFunctionMap;
    // 用于其他功能的映射 从FUNCTIONINFO表
    private Map<String, String> otherFuncMap;
    // ==============================================================

    public Map<String, String> getButtonFuncMap() {
        return buttonFuncMap;
    }

    public Map<String, String> getPageFunctionMap() {
        return pageFunctionMap;
    }

    public void setPageFunctionMap(Map<String, String> pageFunctionMap) {
        this.pageFunctionMap = pageFunctionMap;
    }

    public Map<String, String> getPageFuncMap() {
        return pageFuncMap;
    }

    public void setPageFuncMap(Map<String, String> pageFuncMap) {
        this.pageFuncMap = pageFuncMap;
    }

    public Map<String, String> getOtherFunctionMap() {
        return otherFunctionMap;
    }

    public void setOtherFunctionMap(Map<String, String> otherFunctionMap) {
        this.otherFunctionMap = otherFunctionMap;
    }

    public Map<String, String> getOtherFuncMap() {
        return otherFuncMap;
    }

    public void setOtherFuncMap(Map<String, String> otherFuncMap) {
        this.otherFuncMap = otherFuncMap;
    }

    public Map<String, String> getButtonMap() {
        return buttonMap;
    }

    public void setButtonFuncMap(Map<String, String> buttonFuncMap) {
        this.buttonFuncMap = buttonFuncMap;
    }

    public Map<String, String> getButtonFunctionMap() {
        return buttonFunctionMap;
    }

    public void setButtonFunctionMap(Map<String, String> buttonFunctionMap) {
        this.buttonFunctionMap = buttonFunctionMap;
    }

    public void setButtonMap(Map<String, String> buttonMap) {
        this.buttonMap = buttonMap;
    }

    public String getCurrentTabId() {
        return currentTabId;
    }

    public void setCurrentTabId(String currentTabId) {
        this.currentTabId = currentTabId;
    }

    public String getFileDate() {
        return fileDate;
    }

    public void setFileDate(String fileDate) {
        this.fileDate = fileDate;
    }

    public String getBrName() {
        return brName;
    }

    public void setBrName(String brName) {
        this.brName = brName;
    }

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }
    /* add by shishu.zhang for TopReport 2012-8-15 end. */

    private String sContextPath = "";

    /* modify by shen_anotnio JIRA:FPP-4 2011-12-18 begin. */
    private String assignedOprid = null;

    public String getAssignedOprid() {
        return assignedOprid;
    }

    public void setAssignedOprid(String assignedOprid) {
        this.assignedOprid = assignedOprid;
    }
    /* modify by shen_anotnio JIRA:FPP-4 2011-12-18 end. */

    public String getTaskId() {
        return taskId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getProcInsId() {
        return procInsId;
    }

    public void setProcInsId(String procInsId) {
        this.procInsId = procInsId;
    }

    public String getContractnoFlag() {
        return contractnoFlag;
    }

    public void setContractnoFlag(String contractnoFlag) {
        this.contractnoFlag = contractnoFlag;
    }

    public String getCustcdFlag() {
        return custcdFlag;
    }

    public void setCustcdFlag(String custcdFlag) {
        this.custcdFlag = custcdFlag;
    }

    public String getAppnoFlag() {
        return appnoFlag;
    }

    public void setAppnoFlag(String appnoFlag) {
        this.appnoFlag = appnoFlag;
    }

    public String getTxamtFlag() {
        return txamtFlag;
    }

    public void setTxamtFlag(String txamtFlag) {

        this.txamtFlag = txamtFlag;
    }

    public Set<String> getEesSet() {
        return eesSet;
    }

    public void setEesSet(Set<String> eesSet) {
        this.eesSet = eesSet;
    }

    public static GlobalInfo getFromRequest(HttpServletRequest request) throws CommonException {
        HttpSession httpSession = request.getSession();
        GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);

        if (log.isDebugEnabled()) {
            log.info("session id = " + httpSession.getId());
        }

        if (null != globalInfo) {
            setCurrentInstance(globalInfo);
            String oldSessionId = globalInfo.getSessionId();
            String sessionId = httpSession.getId();
            if (!sessionId.equals(oldSessionId)) {
                ExceptionUtil.throwCommonException("全局信息不符合, 请重新登录.", ErrorCode.ERROR_CODE_TLRNO_SESSION_BINDED);
            }
            globalInfo.setSessionId(sessionId);
        }
        return globalInfo;
    }

    /* shen_antonio . */
    public static GlobalInfo getFromRequest2(HttpServletRequest request) throws CommonException {
        HttpSession httpSession = request.getSession();
        GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);

        if (log.isDebugEnabled()) {
            log.info("session id = " + httpSession.getId());
        }

        if (null != globalInfo) {
            setCurrentInstance(globalInfo);
            String sessionId = httpSession.getId();
            globalInfo.setSessionId(sessionId);
        }
        return globalInfo;
    }

    public static void setGlobalInfo2HttpSession(HttpSession httpSession, GlobalInfo globalInfo) {
        httpSession.setAttribute(GlobalInfo.KEY_GLOBAL_INFO, globalInfo);
        globalInfo.setSessionId(httpSession.getId());
    }

    public static GlobalInfo getCurrentInstance() throws CommonException {
        GlobalInfo gi = (GlobalInfo) session.get();
        if (null == gi) {
            ExceptionUtil.throwCommonException("没有找到GlobalInfo", ErrorCode.ERROR_CODE_NO_GLOBALINFO_INSTANCE);
        }
        return gi;
    }

    public static GlobalInfo getCurrentInstanceWithoutException() {
        GlobalInfo gi = (GlobalInfo) session.get();
        return gi;
    }

    public static void setCurrentInstance(GlobalInfo gi) {
        session.set(gi);
    }

    /**
     * 初始化流水号
     * 
     * @param tlsrnoPr
     * @param tlsrnoEx
     */
    public void initTlsrno(int tlsrnoPr, int tlsrnoEx) {
        this.tlsrnoPr = tlsrnoPr;
        this.tlsrnoEx = tlsrnoEx;
    }

    /**
     * 取得流水号
     * 
     * @return
     */
    public String getTlsrno() {
        return DataFormat.intToString(tlsrnoPr, 5) + DataFormat.intToString(tlsrnoEx, 4);
    }

    /**
     * 取得下一个流水号
     * 
     * @return
     */
    public String getNextTlsrno() {
        tlsrnoEx++;
        return DataFormat.intToString(tlsrnoPr, 5) + DataFormat.intToString(tlsrnoEx, 4);
    }

    public Date getTxdate() {
        return txdate;
    }

    public void setTxdate(Date txdate) {
        this.txdate = txdate;
    }

    public String getTlrno() {
        return tlrno;
    }

    public void setTlrno(String tlrno) {
        this.tlrno = tlrno;
    }


    public String getBrcode() {
        return brcode;
    }

    public void setBrcode(String brcode) {
        this.brcode = brcode;
    }


    public String getBrClass() {
        return brClass;
    }

    public void setBrClass(String brClass) {
        this.brClass = brClass;
    }

    public String getWorkflowRoleId() {
        return workflowRoleId;
    }

    public void setWorkflowRoleId(String workflowRoleId) {
        this.workflowRoleId = workflowRoleId;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Time getTxtime() {
        return txtime;
    }

    public void setTxtime(Time txtime) {
        this.txtime = txtime;
    }

    public int getTlsrnoPr() {
        return tlsrnoPr;
    }

    public void setTlsrnoPr(int tlsrnoPr) {
        this.tlsrnoPr = tlsrnoPr;
    }

    public int getTlsrnoEx() {
        return tlsrnoEx;
    }

    public void setTlsrnoEx(int tlsrnoEx) {
        this.tlsrnoEx = tlsrnoEx;
    }

    public String getContractno() {
        return contractno;
    }

    public void setContractno(String contractno) {
        this.contractno = contractno;
    }

    public String getCino() {
        return cino;
    }

    public void setCino(String cino) {
        this.cino = cino;
    }

    public String getCustcd() {
        return custcd;
    }

    public void setCustcd(String custcd) {
        this.custcd = custcd;
    }

    public String getAppno() {
        return appno;
    }

    public void setAppno(String appno) {
        this.appno = appno;
    }

    public double getTxamt() {
        return txamt;
    }

    public void setTxamt(double txamt) {
        this.txamt = txamt;
    }

    public Map getAllFunctions() {
        return allFunctions;
    }

    public void setAllFunctions(Map allFunctions) {
        this.allFunctions = allFunctions;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getWorkflowTlrno() {
        return workflowTlrno;
    }

    public void setWorkflowTlrno(String workflowTlrno) {
        this.workflowTlrno = workflowTlrno;
    }

    /**
     * set关键业务信息
     * 
     * @param contractno
     * @param custcd
     * @param appno
     * @param txamt
     */
    public void setTransData(String contractno, String custcd, String appno, String txamt) {
        if (!DataFormat.isEmpty(contractno)) {
            this.contractno = contractno;
        }
        if (!DataFormat.isEmpty(custcd)) {
            this.custcd = custcd;
        }
        if (!DataFormat.isEmpty(appno)) {
            this.appno = appno;
        }
        if (!DataFormat.isEmpty(txamt) && !txamt.equals("null")) {
            this.txamt = Double.valueOf(txamt);
        }
    }

    public String getFormatedDate() {

        return DataFormat.dateToString(txdate);
    }

    private boolean isHeadBrcode = false; // 当前机构是否为总行

    public boolean isHeadBrcode() {
        return isHeadBrcode;
    }

    public void setHeadBrcode(boolean isHeadBrcode) {
        this.isHeadBrcode = isHeadBrcode;
    }

    public String getSContextPath() {
        return sContextPath;
    }

    public void setSContextPath(String contextPath) {
        sContextPath = contextPath;
    }

    /** add by zhaozhiguo 密码修改提醒 BMS-3153 begin */
    private boolean pswdForcedToChange = false;
    private Date lastpwdchgtm;
    private int effectiveDay;
    private static String pswdStrength = "0";

    public boolean isPswdForcedToChange() {
        return pswdForcedToChange;
    }

    public void setPswdForcedToChange(boolean pswdForcedToChange) {
        this.pswdForcedToChange = pswdForcedToChange;
    }

    public Date getLastpwdchgtm() {
        return lastpwdchgtm;
    }

    public void setLastpwdchgtm(Date lastpwdchgtm) {
        this.lastpwdchgtm = lastpwdchgtm;
    }

    public int getEffectiveDay() {
        return effectiveDay;
    }

    public void setEffectiveDay(int effectiveDay) {
        this.effectiveDay = effectiveDay;
    }

    public static String getPswdStrength() {
        return pswdStrength;
    }

    public static void setPswdStrength(String pswdStrength) {
        GlobalInfo.pswdStrength = pswdStrength;
    }

    /** add by zhaozhiguo 密码修改提醒 BMS-3153 end */

    /* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 begin . */
    private Locale locale;

    public Locale getLocale() {
        // if (locale == null) {
        // log.warn("locale is null, is setted to default.");
        // return Locale.getDefault();
        // } else {
        // return locale;
        // }
        if (Locale.US.equals(this.locale) || Locale.CHINA.equals(this.locale) || Locale.TAIWAN.equals(this.locale)) {
            return this.locale;
        } else {
            return Locale.CHINA;
        }
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
    /* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 end . */

    public String getSaveQueryLog() {
        return saveQueryLog;
    }

    public void setSaveQueryLog(String saveQueryLog) {
        this.saveQueryLog = saveQueryLog;
    }

    public List getConfrimCodeList() {
        return confrimCodeList;
    }

    public void setConfrimCodeList(List confrimCodeList) {
        this.confrimCodeList = confrimCodeList;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

}