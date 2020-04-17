package com.huateng.ebank.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.business.common.ROOTDAOUtils;

public class WebDownloadFile {
    public static void downloadFile(HttpServletResponse response, File file, String displayName) throws Exception {
        OutputStream out = null;
        FileInputStream fis = null;
        try {
            response.setContentType("application/octet-stream;charset=utf-8");            
            String urlFileName = URLEncoder.encode(displayName, "utf-8");
            urlFileName=urlFileName.replaceAll("\\+", "%20");
            // System.out.println("displayName========================="+displayName);
            response.setHeader("Content-Disposition", "attachment;filename=\"" + urlFileName);
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");

            if (file.exists() == false) {
                String sql = "select filepath from (select wsnr as filepath from cics_documentinfo "
                        + " union all select gzz as filepath from cics_credentialsinfo where gzz is not null "
                        + " union all select gwz as filepath from cics_credentialsinfo where gwz is not null)"
                        + " where filepath like ?";
                String args = "%" + displayName;
                String fullName = "";
                Iterator pathItr = ROOTDAOUtils.getHQLDAO().queryBySQL(sql, new String[] { args }, null);
                if (pathItr.hasNext()) {
                    fullName = (String) pathItr.next();
                }
                System.out.println("before convert: file.getPath() = " + file.getPath());
                if (StringUtils.isNotBlank(fullName)) {
                    file = new File(fullName);
                }
                System.out.println("after  convert: file.getPath() = " + file.getPath());
            }
            long fileLength = file.length();
            response.setContentLength((int) fileLength);

            out = response.getOutputStream();

            fis = new FileInputStream(file);
            // System.out.println("=================file========================"+file);
            while (true) {
                int in = fis.read();
                if (-1 == in) {
                    break;
                }
                out.write(in);
            }

            out.flush();
        } finally {
            if (null != out)
                try {
                    out.close();
                } catch (Throwable ex) {
                }
            if (null != fis)
                try {
                    fis.close();
                } catch (Exception e) {
                }
        }
    }
}