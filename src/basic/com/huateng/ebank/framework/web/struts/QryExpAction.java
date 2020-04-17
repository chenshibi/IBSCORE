package com.huateng.ebank.framework.web.struts;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.Code;
import com.huateng.commquery.config.CommonQueryUtil;
import com.huateng.commquery.config.bean.base.ICommonQueryBean;
import com.huateng.commquery.result.qryExp.xls.QryExpService;
import com.huateng.ebank.business.common.ConfigReader;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.servlet.BaseServlet;
import com.huateng.exception.AppException;
import com.huateng.exception.DomainException;
import com.huateng.view.freemarker.SysDicStrMethod;

public class QryExpAction extends BaseServlet {
    private static SysDicStrMethod sysDic = new SysDicStrMethod();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        QueryExportForm form = new QueryExportForm(request, response);

        Map params = new HashMap();
        request.setCharacterEncoding("GB18030");
        form.setResponse(response);
        form.setRequest(request);

        String cqId = request.getParameter("CQId");
        form.setCqId(Code.decode(cqId));

        String expType = request.getParameter("expType");
        if ((expType != null) && (!"".equals(expType))) {
            form.setExportType(expType);
        }

        String els = Code.decode(request.getParameter(cqId + "_" + "expElements"));
        form.setColumnSort(els);

        form.setZipFlag(false);
        String zip = request.getParameter(cqId + "_" + "complex");
        if ((zip != null) && (!"".equals(zip)) && ("1".equals(zip.trim()))) {
            form.setZipFlag(true);
        }

        String startPage = request.getParameter(cqId + "_" + "startPage");
        if ((startPage == null) || ("".equals(startPage))) {
            form.setStartPage("1");
        } else {
            form.setStartPage(startPage.trim());
        }

        String endPage = request.getParameter(cqId + "_" + "endPage");
        String pageCount = request.getParameter("pageCount");
        if ((endPage != null) && (!"".equals(endPage.trim()))) {
            form.setEndPage(endPage.trim());
        } else if ((pageCount != null) && (!"".equals(pageCount.trim()))) {
            form.setEndPage(pageCount.trim());
        } else {
            form.setEndPage("1");
        }

        String pageSize = request.getParameter("everyPage");
        form.setEveryPage(pageSize);

        String fileName = Code.decode(request.getParameter(cqId + "_" + "fileName"));
        if (StringUtils.isBlank(fileName)) {
            ICommonQueryBean commonQueryBean = null;
            try {
                commonQueryBean = CommonQueryUtil.getCommonQueryBean(form.getCqId());
            } catch (AppException e1) {
                throw new IOException(e1.getMessage());
            }
            fileName = commonQueryBean.getPageExpConf("desc");
            if (StringUtils.isBlank(fileName)) {
                try {
                    fileName = ConfigReader.getProperty("PageQryExp_filename");
                } catch (CommonException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            String title = commonQueryBean.getPageExpConf("title");
            if (title != null) {
                params.put("PageQryExp_title", title);
            }
        }
        form.setFileName(fileName);

        form.setExpAll(false);
        // String expAll = request.getParameter(cqId + "_" + "expAll");
        String allPage = request.getParameter(cqId + "_" + "allPage");
        if ("1".equals(allPage)) {
            form.setEndPage("-1");
        }

        QryExpService qryService = new QryExpService();
        try {
            qryService.genExport(form, null, params);
        } catch (DomainException e) {
            e.printStackTrace();
        }
    }

    public static void rules(Object object) throws AppException {
        if (object == null) {
            throw new AppException();
        }

        if ((object instanceof QueryExportForm)) {
            if ((((QueryExportForm) object).getFileBody() == null)
                    || (((QueryExportForm) object).getFileBody().size() == 0)) {
                throw new AppException();
            }
        }
    }

    public String getTransId() {
        return null;
    }

    public boolean safePrivi(HttpServletRequest request) {
        return false;
    }
}
