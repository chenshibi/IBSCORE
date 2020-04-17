package com.huateng.report.downloadfile.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.report.downloadfile.bean.DataDownLoadFileBean;
import com.huateng.report.downloadfile.utils.ReportDownLoadFileResource;

public class DataDownloadFileServlet extends HttpServlet {
    private static final long serialVersionUID = -4024878097633037248L;

    public DataDownloadFileServlet() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    /**
     * 文件下载 fileId
     *
     * fileId 文件主键
     *
     * 调用方法
     *
     *
     * <a href='<%=request.getContextPath() %>/datadownload?fileId=1'>文件</a>
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String fid = request.getParameter("fileId");
        DataDownLoadFileBean bean = ReportDownLoadFileResource.getInstance().getDownLoadFileById(fid);

        InputStream is = null;
        ServletOutputStream out = null;
        boolean fileIsExist = true;
        if (bean == null) {
            fileIsExist = false;
        } else {
            is = this.getClass().getClassLoader().getResourceAsStream(bean.getFileName());
            if (null == is) {
                fileIsExist = false;
            }
        }
        if (!fileIsExist) {
            PrintWriter writer = response.getWriter();
            writer.println("<script type='text/javascript'>alert('文件不存在，请与管理员联系。');</script>");
            writer.close();
            return;
        }
        // 读取文件流
        try {
            String saveName = bean.getDisplayName() + "." + bean.getFileExt();
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition",
                    "attachment; filename=" + new String(saveName.getBytes("GB18030"), "iso-8859-1") + "\"");
            out = response.getOutputStream();

            byte[] tmp = new byte[1024 * 1024];
            int i = 0;
            while ((i = is.read(tmp)) != -1) {
                out.write(tmp, 0, i);
            }
            out.flush();
        } catch (IOException e) {
            throw e;
        } finally {
            if (is != null) {
                is.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    public void init() throws ServletException {
    }

}
