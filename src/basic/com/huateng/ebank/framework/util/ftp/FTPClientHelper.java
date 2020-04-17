/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.framework.util.ftp;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.12 $
 * @date 2005-7-28
 * 
 *       Helper class of ftp client.
 */
public class FTPClientHelper {
    public final static Logger log = Logger.getLogger(FTPClientHelper.class);

    /**
     * 超时时间. 缺省为30秒.
     */
    private int timeout = 30000;

    /**
     * 主机名称
     */
    private String hostname;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 传输类型
     */
    private String fileType = "binary";

    /**
     * 文件目录.
     */
    private String fileDir = "";

    /**
     * 查询结果文件目录.
     */
    private String inqDir = "";

    /**
     * 从服务器获取文件.
     * 
     * @param fileName
     * @param callback
     * @throws CommonException
     */
    public void getFile(String fileName, FTPClientCallback callback) throws CommonException {
        /*
         * FTPClient ftpClient = new FTPClient(); FTPClientConfig clientConfig =
         * new FTPClientConfig(FTPClientConfig.SYST_UNIX);
         * ftpClient.configure(clientConfig); boolean login = false;
         * 
         * try { if (log.isDebugEnabled()) { log.info("连接服务器:" + hostname); }
         * 
         * ftpClient.setDefaultTimeout(timeout);
         * ftpClient.setDataTimeout(timeout);
         * 
         * ftpClient.connect(hostname); int reply = ftpClient.getReplyCode(); if
         * (!FTPReply.isPositiveCompletion(reply)) {
         * ExceptionUtil.throwCommonException("FTP服务器拒绝连接, 返回代码:" + reply,
         * ErrorCode.ERROR_CODE_FTP); }
         * 
         * if (log.isDebugEnabled()) { log.info("登录服务器:" + hostname); } login =
         * ftpClient.login(userName, password); if (!login) {
         * ExceptionUtil.throwCommonException("FTP服务器拒绝用户登录.",
         * ErrorCode.ERROR_CODE_FTP); }
         * 
         * if (fileType.equalsIgnoreCase("binary")) { if (log.isDebugEnabled())
         * { log.info("设置传输类型binary"); } ftpClient.type(FTP.BINARY_FILE_TYPE); }
         * else { if (log.isDebugEnabled()) { log.info("设置传输类型ascii"); }
         * ftpClient.type(FTP.ASCII_FILE_TYPE); }
         * 
         * if (log.isDebugEnabled()) { log.info("获取文件" + fileName); }
         * InputStream inputStream = ftpClient.retrieveFileStream(fileName); if
         * (null == inputStream) { reply = ftpClient.getReplyCode();
         * ExceptionUtil.throwCommonException("从FTP服务器获取文件" + fileName +
         * "失败,错误代码:" + reply, ErrorCode.ERROR_CODE_FTP); } try {
         * callback.doFtp(inputStream);
         * 
         * if (false == ftpClient.completePendingCommand()) {
         * ExceptionUtil.throwCommonException("关闭FTP连接失败,错误代码:" +
         * ftpClient.getReplyCode(), ErrorCode.ERROR_CODE_FTP); } } finally {
         * try { if (null != inputStream) { inputStream.close(); } } catch
         * (Throwable t) { }; }
         * 
         * 
         * } catch (CommonException ce) { throw ce; } catch (Exception ex) {
         * ExceptionUtil.throwCommonException(ex.getMessage(),
         * ErrorCode.ERROR_CODE_FTP, ex); } finally { try { if (login) {
         * ftpClient.logout(); } if (ftpClient.isConnected()) {
         * ftpClient.disconnect(); } } catch (Throwable t) { }; }
         */

        InputStream is = null;
        try {
            // 为演示需要改FTP方式为打开本地文件2007-11-21
            // String urlString = "ftp://" + userName + ":" + password + "@" +
            // hostname + fileName;
            // if ( log.isDebugEnabled() ){
            // log.info("url is " + urlString);
            // }
            // URL url = new URL(urlString);
            // URLConnection urlc = url.openConnection();
            // is = urlc.getInputStream();
            is = new FileInputStream(fileName);

            callback.doFtp(is);
        } catch (Exception ex) {
            ExceptionUtil.throwCommonException("指定的报表不存在，报表所属机构错误或者该日没有产生此报表", ErrorCode.ERROR_CODE_FTP, ex);
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (Exception ex) {
                }
                ;
            }
        }
    }

    /**
     * @return Returns the fileType.
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * @param fileType
     *            The fileType to set.
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * @return Returns the hostname.
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * @param hostname
     *            The hostname to set.
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return Returns the userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            The userName to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return Returns the fileDir.
     */
    public String getFileDir() {
        return fileDir;
    }

    /**
     * @param fileDir
     *            The fileDir to set.
     */
    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    /**
     * @return Returns the timeout.
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * @param timeout
     *            The timeout to set.
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * @return Returns the inqDir.
     */
    public String getInqDir() {
        return inqDir;
    }

    /**
     * @param inqDir
     *            The inqDir to set.
     */
    public void setInqDir(String inqDir) {
        this.inqDir = inqDir;
    }
}