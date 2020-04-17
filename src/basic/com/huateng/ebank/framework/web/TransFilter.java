package com.huateng.ebank.framework.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.system.service.SysParamsService;

import resource.bean.basic.FunctionInfo;
import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;

/**
 * 处理GlobalInfo ,把GlobalInfo放到threadLocal
 *
 * @author yjw
 *
 */
public class TransFilter implements Filter {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(TransFilter.class);
    /** memeber variable: String EXPIRED_PAGE. */
    private static final String EXPIRED_PAGE = "EXPIRED_PAGE";

    private FilterConfig filterConfig;
    private String expiredPageName = null;

    public String getExpiredPageName() {
        return expiredPageName;
    }

    public void setExpiredPageName(String expiredPageName) {
        this.expiredPageName = expiredPageName;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
        this.expiredPageName = this.filterConfig.getInitParameter(EXPIRED_PAGE);

    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession httpSession = request.getSession(false);

        if (null != httpSession) {
            GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
            if (null != globalInfo) {
                try {
                    HQLDAO hqlDAO = BaseDAOUtils.getHQLDAO();
                    String pagePath = request.getServletPath();
                    StringBuffer sql = new StringBuffer();
                    sql.append("select func from FunctionInfo func where func.pagepath = ? ");
                    List<FunctionInfo> infos = hqlDAO.queryByQL2List(sql.toString(), new String[] { pagePath }, null);
                    if (infos.size() != 0) {
                        String funcid = infos.get(0).getId();
                        String tlrNo = globalInfo.getTlrno();
                        StringBuffer sb = new StringBuffer();
                        sb.append("select distinct func from ")
                                .append("TlrRoleRel tr,RoleFuncRel rr,FunctionInfo func ")
                                .append(" where tr.roleId=rr.roleId and rr.funcid=func.id ").append("and tr.tlrno= ? ")
                                .append(" and func.id= ? ")
                                .append(" and tr.roleId in ( select id from RoleInfo ) ");
                        List<FunctionInfo> list = hqlDAO.queryByQL2List(sb.toString(),
                                new String[] { tlrNo, funcid}, null);
                        if (list.size() != 1) {
                            System.out.println(
                                    "funcid = " + funcid + ", tlrNo = " + tlrNo  + ", return.");
                            return;
                        }
                    }
                } catch (CommonException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                /**
                 * add jiang@20091029 BMS-2142
                 * 判断用户登录session与系统session是否一致，不一致则退出，并提示信息
                 */
                /*
                 * if(UserMgrService.getInstance().isKicked(globalInfo,
                 * httpSession)) { GlobalData.setCurrentInstance(null);
                 * HttpServletResponse response = (HttpServletResponse)resp;
                 * response.setHeader("Pragma", "No-cache");
                 * response.setHeader("Cache-Control",
                 * "no-cache,no-store,max-age=0");
                 * response.setDateHeader("Expires", 1); RequestDispatcher rd =
                 * (req).getRequestDispatcher(expiredPageName);
                 * httpSession.invalidate(); rd.forward(req, response);
                 * httpSession.invalidate(); return; } .
                 */
                /** end BMS-2142 */
                GlobalInfo.setCurrentInstance(globalInfo);
                String sessionId = httpSession.getId();
                globalInfo.setSessionId(sessionId);
            } else {
                try {
                    if (expiredSystem((HttpServletRequest) req, (HttpServletResponse) resp)) {
                        return;
                    }
                } catch (CommonException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } else {
            try {
                if (expiredSystem((HttpServletRequest) req, (HttpServletResponse) resp)) {
                    return;
                }
            } catch (CommonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        filterChain.doFilter(req, resp);
    }

    private boolean expiredSystem(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, CommonException {
        String uriStr = StringUtils.substringAfterLast(req.getServletPath(), "/");

        SysParams sysparams = SysParamsService.getInstance().selectById(new SysParamsPK("TRNSFILTER", "URL"));
        if (sysparams != null) {
            String loginRef = sysparams.getParamVal();
            if (StringUtils.indexOf(loginRef, uriStr) == -1) {
                if (req.getSession(false) == null) {
                    System.out.println("req.getSession(false) is null, and " + uriStr + " is not in loginRef");
                } else {
                    System.out.println("GlobalInfo in session(" + req.getSession(false).getId() + ") is null, and "
                            + uriStr + " is not in loginRef");
                }
                if (StringUtils.endsWithIgnoreCase(req.getRequestURI(), ".dwr")) {
                    ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_TLRNO_SESSION_INVALID);
                }

                resp.setHeader("Pragma", "No-cache");
                resp.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
                resp.setDateHeader("Expires", 1);
                SysParams logout = SysParamsService.getInstance().selectById(new SysParamsPK("SSO_LOGOUT", "URL"));
                if (logout == null || logout.getParamVal() == null || logout.getParamVal().trim().length() == 0) {
                    RequestDispatcher rd = (req).getRequestDispatcher(expiredPageName);
                    rd.forward(req, resp);
                } else {
                    RequestDispatcher rd = (req).getRequestDispatcher(logout.getParamVal().trim());
                    rd.forward(req, resp);
                }
                return true;
            }
        }
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {
        this.filterConfig = null;
    }

}