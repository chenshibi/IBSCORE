/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.common.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import com.huateng.ebank.framework.util.ftp.FTPClientCallback;
import com.huateng.ebank.framework.util.ftp.FTPClientHelper;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.1 $
 * @date 2005-7-28
 * 
 *       Report ftp callback.
 */
public class ReportFTPCallback implements FTPClientCallback {
    private String buf;

    public void doFtp(InputStream inputStream) throws Exception {
        ByteArrayOutputStream writer = new ByteArrayOutputStream();
        while (true) {
            int in = inputStream.read();
            if (-1 == in) {
                break;
            }
            writer.write(in);
        }
        writer.flush();
        buf = writer.toString();
        writer.close();
    }

    /**
     * @return Returns the buf.
     */
    public String getBuf() {
        return buf;
    }

    /**
     * @param buf
     *            The buf to set.
     */
    public void setBuf(String buf) {
        this.buf = buf;
    }

    public static void main(String[] argv) {
        try {
            FTPClientHelper helper = new FTPClientHelper();
            helper.setHostname("10.102.14.75");
            helper.setUserName("gd");
            helper.setPassword("gd");
            helper.setTimeout(30000);

            ReportFTPCallback callback = new ReportFTPCallback();
            helper.getFile("/home/gd/temp/bctl1.txt", callback);

            System.out.println("result:");
            System.out.println(callback.getBuf());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}