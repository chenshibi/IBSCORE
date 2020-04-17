package com.huateng.ebank.business.print.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.print.base.BasePrinter;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class PrintServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 3180483653221654643L;

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            List jasperPrintList = null;
            // setGlobalInfoToThreadLoacl(request);
            String reportId = request.getParameter("report_id");
            BasePrinter printer = (BasePrinter) ApplicationContextUtils.getBean(reportId);
            jasperPrintList = printer.getPrinterList(request);

            // byte[]
            // compressByteArr=getCompressObject(jasperPrintList);//得到数据压缩后的字节数组
            response.reset();
            response.setContentType("application/octet-stream;charset=utf-8");
            ServletOutputStream ouputStream = response.getOutputStream();

            GZIPOutputStream gzpos = new GZIPOutputStream(ouputStream);
            ObjectOutputStream oos = new ObjectOutputStream(gzpos);
            oos.writeObject(jasperPrintList);

            oos.flush();
            oos.close();
            gzpos.flush();
            gzpos.close();
            ouputStream.flush();
            ouputStream.close();
        } catch (Throwable e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

    protected void setGlobalInfoToThreadLoacl(HttpServletRequest request) throws CommonException {
        HttpSession httpSession = request.getSession();
        GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
        if (null != globalInfo) {
            GlobalInfo.setCurrentInstance(globalInfo);
            String sessionId = httpSession.getId();
            globalInfo.setSessionId(sessionId);
        }
    }

    /** 数据压缩 */
    public byte[] getCompressObject(Object data) {
        byte[] result = null;
        try {
            // 建立字节数组输出流
            ByteArrayOutputStream byteos = new ByteArrayOutputStream();
            // 建立gzip压缩输出流
            GZIPOutputStream gzout = new GZIPOutputStream(byteos);
            // 建立对象序列化输出流
            ObjectOutputStream out = new ObjectOutputStream(gzout);
            out.writeObject(data);
            out.flush();
            out.close();
            gzout.close();

            // 返回压缩字节流
            result = byteos.toByteArray();
            byteos.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return result;
    }
}
