/**
 *
 */
package com.huateng.ebank.framework.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huateng.common.err.Module;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.exception.AppException;
import com.huateng.mvc.servlet.HTFreemarkerServlet;

import freemarker.template.Template;
import freemarker.template.TemplateModel;

/**
 * @author shen_antonio
 *
 */
public class BankHTFreemarkServlet extends HTFreemarkerServlet {

    /** memeber variable: long serialVersionUID. */
    private static final long serialVersionUID = 57989966371044664L;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    /**
     * Called before the execution is passed to template.process(). This is a
     * generic hook you might use in subclasses to perform a specific action
     * before the template is processed. By default does nothing. A typical
     * action to perform here is to inject application-specific objects into the
     * model root
     *
     * @param request
     *            the actual HTTP request
     * @param response
     *            the actual HTTP response
     * @param template
     *            the template that will get executed
     * @param data
     *            the data that will be passed to the template
     * @return true to process the template, false to suppress template
     *         processing.
     */
    @Override
    protected boolean preTemplateProcess(HttpServletRequest request, HttpServletResponse response, Template template,
            TemplateModel data) throws ServletException, IOException {
        try {
            HttpSession httpSession = request.getSession();
            if (httpSession == null) {
                // ExceptionUtil.throwCommonException("用户没有登录.",
                // ErrorCode.ERROR_CODE_TLRNO_SESSION_INVALID);
                throw new AppException(Module.SYSTEM_MODULE, ErrorCode.ERROR_CODE_TLRNO_SESSION_INVALID, null, null);
            }
            GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
            if (null != globalInfo) {
                GlobalInfo.setCurrentInstance(globalInfo);
                String sessionId = httpSession.getId();
                globalInfo.setSessionId(sessionId);
            }

            return super.preTemplateProcess(request, response, template, data);
        } catch (AppException asEx) {
            asEx.printStackTrace();
            throw new ServletException(asEx);
        }
    }
}
