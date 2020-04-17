package com.huateng.report.common.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.huateng.report.utils.HuaTengUtils;
import com.huateng.report.utils.LogExceptionUtils;
import com.huateng.report.utils.ReportUtils;

/**
 * 从临时文件夹下载文件
 *
 * @author NING-PENG
 *
 */
public class DownloadFileTempServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    private static Logger log = Logger.getLogger(DownloadFileTempServlet.class);
    static final long serialVersionUID = 1L;

    public DownloadFileTempServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String fileName = request.getParameter("fileName");
        fileName=HuaTengUtils.toStringAndTrim(fileName);
        String filePath = ReportUtils.getSysTempPath() + fileName;
        File tmpFile = new File(filePath);
        if (!tmpFile.exists()) {
            PrintWriter writer = response.getWriter();
            writer.println("<script type='text/javascript'>alert('" + fileName + ",下载文件不存在!');</script>");
            writer.close();
            return;
        }
        ServletOutputStream out = null;
        // 读取文件流
        try {
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + "\"");
            out = response.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(filePath);

            if (fileInputStream != null) {
                byte[] tmp = new byte[1024 * 1024];
                int i = 0;
                while ((i = fileInputStream.read(tmp)) != -1) {
                    out.write(tmp, 0, i);
                }
            }
            fileInputStream.close();
            out.flush();
        } catch (IOException e) {
            LogExceptionUtils.logException(log, e);
            throw e;
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}