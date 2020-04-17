/**
 *
 */
package com.huateng.ebank.framework.web.commQuery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.huateng.commquery.common.CommonQueryConstants;
import com.huateng.commquery.config.CommonQueryUtil;
import com.huateng.commquery.config.bean.base.ICommonQueryBean;
import com.huateng.ebank.framework.web.servlet.BaseServlet;
import com.huateng.exception.DomainException;

/**
 * Title: TransDataAction Description: Copyright: Copyright (c) 2007 Company:
 * Shanghai Huateng Software Systems Co., Ltd.
 * 
 * @author shen_antonio
 * @version 1.1, 2007-11-13
 */
public class TransDataAction extends BaseServlet {
    private static final Logger log = Logger.getLogger(TransDataAction.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String id = request.getParameter(CommonQueryConstants.COMMON_QUERY_ID);
            ICommonQueryBean commonQueryBean = CommonQueryUtil.getCommonQueryBean(id);
            String buttonId = request.getParameter("_button_id");
            String page = commonQueryBean.getOperationsElement(buttonId).getAnyValue("url");
       //     response.sendRedirect(request.getContextPath() + page);
        } catch (DomainException dEx) {
            log.debug(dEx);
        //    response.sendRedirect(request.getContextPath() + "/common/error.jsp");
        } catch (Exception ex) {
            log.debug(ex);
         //   response.sendRedirect(request.getContextPath() + "/common/error.jsp");
        }
    }

}
