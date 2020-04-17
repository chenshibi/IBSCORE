/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.common.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.huateng.ebank.framework.util.ftp.FTPClientCallback;
import com.huateng.report.utils.LogExceptionUtils;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.3 $
 * @date 2005-8-5
 * 
 *       在本地生成临时文件用于存储ftp数据.
 */
public class TmpFileFTPCallback implements FTPClientCallback {
    private static Logger log = Logger.getLogger(TmpFileFTPCallback.class);
    File file = null;

    public TmpFileFTPCallback() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.huateng.ebank.framework.util.ftp.FTPClientCallback#doFtp(java.io.
     * InputStream)
     */
    public void doFtp(InputStream inputStream) throws Exception {
        int length = 0;
        FileOutputStream fos = null;
        try {
            file = File.createTempFile("ftp", ".tmp");
            fos = new FileOutputStream(file);
            while (true) {

                int in = inputStream.read();
                if (-1 == in) {
                    break;
                }
                fos.write(in);
                length++;
            }

            System.out.println("length is " + length);
            // Util.copyStream(inputStream, fos);
            fos.flush();
        } finally {
            try {
                if (null != fos) {
                    fos.close();
                }
            } catch (Exception ex) {
                LogExceptionUtils.logException(log, ex);
            }
        }
    }

    public File getFile() {
        return file;
    }

    public boolean close() {
        return file.delete();
    }

}