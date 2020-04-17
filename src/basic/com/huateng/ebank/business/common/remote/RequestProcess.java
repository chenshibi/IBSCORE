package com.huateng.ebank.business.common.remote;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.MapUtil;
import com.huateng.ebank.business.common.TransferConstant;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.encrypt.Base64URLEncode;
import com.huateng.report.utils.LogExceptionUtils;

public class RequestProcess {
    private static final Logger logger = Logger.getLogger(RequestProcess.class);

    public static boolean processBack(HttpServletRequest request, HttpServletResponse response) {
        try {
            Object url = getValueFromRequest(request, "URL");
            if (url == null) {
                logger.info("URL is null!can't forward!");
                return false;
            }
            HttpSession session = request.getSession(false);
            if (session == null) {
                logger.info("session is null!can't forward!");
                return false;
            }
            Object sessionId = session.getAttribute(TransferConstant.PORTAL_SESSIONID);
            if (sessionId == null) {
                logger.info("sessionId is null!can't forward!");
                return false;
            }
            GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
            if (globalInfo == null) {
                logger.info("globalInfo is null!can't forward!");
                return false;
            }
            if (request.getQueryString() != null) {
                String qryString = request.getQueryString().replaceAll("URL=" + url, "");
                if (qryString.indexOf("&&") > -1) {// URL在中间
                    qryString = qryString.replaceAll("&&", "&");
                }
                if (qryString.startsWith("&")) {// URL在头
                    qryString = qryString.substring(1);
                }
                if (qryString.endsWith("&")) {// URL在尾
                    qryString = qryString.substring(0, qryString.length() - 1);
                }
                url = url.toString() + "?" + qryString;
                // url = url.toString() + "?"+request.getQueryString();
            }
            // 处理request中的参数
            StringBuffer sb = new StringBuffer();
            String result = "";
            logger.info("来自于request中的请求参数：" + sb.toString());
            // 处理map中的参数
            Object m = request.getAttribute(TransferConstant.SEND_VALUE_MAP);
            HashMap<String, String> map = new HashMap<String, String>();
            if (m != null) {
                map = (HashMap) m;
            }
            map.put("URL", url.toString());
            map.put("sessionId", sessionId.toString());
            map.put("tokenId", globalInfo.getTokenId());
            String r = MapUtil.map2String(map);
            logger.info("所有的参数：" + r);
            sb.append(r);
            if (sb.toString().endsWith(";"))
                result = sb.substring(0, sb.length() - 1);
            else
                result = sb.toString();
            logger.info("result is:" + result);

            result = Base64URLEncode.byBase64Encode(result);
            logger.info("加密后：" + result);
            request.setAttribute("_" + TransferConstant.SEND_VALUE_MAP, result);
            return true;
        } catch (Exception e) {
            LogExceptionUtils.logException(logger, e);
            return false;
        }
    }

    public static GlobalInfo initGlobalInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 调用这个方法进行处理
        logger.info("begin RedirectServlet.");

        GlobalInfo globalInfo;

        HttpSession session = request.getSession();

        String tokenId = request.getParameter("tokenId");
        String sessionId = request.getParameter("sessionId"); // 用于session校验
        String tlrno = request.getParameter("tlrno_portal"); // 操作员号
        String brno = request.getParameter("brno_portal"); // 外部机构号
        String brcode = request.getParameter("brcode_portal"); // 机构号
        String branchBrcode = request.getParameter("branchBrcode_portal"); // 分行机构号
        String brClass = request.getParameter("brClass_portal"); // 机构级别
        String workflowRoleId = request.getParameter("workflowRoleId_portal"); // 工作流当前岗位号
        String funcCode = request.getParameter("funcCode"); // 交易代码
        String language = request.getParameter("language");
        String txdate = request.getParameter("txdate");

        String value_map = request.getParameter("_" + TransferConstant.SEND_VALUE_MAP);

        // value_map不为空才转换，菜单跳转value_map为空
        if (value_map != null && !value_map.trim().equals("")) {
            HashMap map = MapUtil.string2HashMap(Base64URLEncode.byBase64Descode(value_map));

            if (map != null) {
                request.setAttribute(TransferConstant.SEND_VALUE_MAP, map);
            } else
                go2ErrorPage(request, response);
        }

        globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
        if (globalInfo == null || (!globalInfo.getTlrno().equals(tlrno))) {
            logger.info("globalInfo is null");
            logger.info("tlrno:" + tlrno);
            // 重置GlobalInfo
            globalInfo = new GlobalInfo();
        }

        // 初始化GlobalInfo
        globalInfo.setTokenId(tokenId);
        if (DataFormat.isEmpty(globalInfo.getSessionId())) {
            globalInfo.setSessionId(session.getId());
        }
        session.setAttribute(TransferConstant.PORTAL_SESSIONID, sessionId);
        globalInfo.setTlrno(tlrno);
        globalInfo.setBrcode(brcode);
        globalInfo.setBrClass(brClass);
        globalInfo.setWorkflowRoleId(workflowRoleId);
        globalInfo.setFuncCode(funcCode);
        globalInfo.setLanguage(language);
        globalInfo.setIp(request.getRemoteAddr());
        // 设置会计日期
        Date txtDate = null;
        if (txdate != null)
            txtDate = DataFormat.stringToDate(txdate);
        globalInfo.setTxdate(txtDate);

        return globalInfo;

    }

    public static Object getValueFromRequest(HttpServletRequest request, String key) {

        Object value = request.getParameter(key);
        if (value != null) {
            return value;
        } else {
            value = request.getAttribute(key);
            if (value == null) {
                Object value_map = request.getAttribute(TransferConstant.SEND_VALUE_MAP);
                if (value_map != null)
                    value = ((HashMap) value_map).get(key);
            }
            return value;
        }
    }

    private static void go2ErrorPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache,no-store,max-age=0");
        resp.setDateHeader("Expires", 1);
        RequestDispatcher rd = ((HttpServletRequest) req).getRequestDispatcher("/common/error.jsp");
        rd.forward(req, resp);
    }

}
