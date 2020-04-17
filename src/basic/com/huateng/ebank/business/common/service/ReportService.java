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
import java.util.Date;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ftp.FTPClientHelper;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.4 $
 * @date 2005-7-28
 *
 *       Report service.
 */
@SuppressWarnings("ucd")
public class ReportService {
    // private static ReportService reportService = new ReportService();

    public static ReportService getInstance() {
        // return reportService;
        return (ReportService) ApplicationContextUtils.getBean(ReportService.class.getName());
    }

    public String getFileName(String brcode, Date reportDate, String fileBase) {
        String strDate = DataFormat.dateToNumber(reportDate);
        return brcode + "-" + strDate + "-" + fileBase;
    }

    public String getReport(String brcode, Date reportDate, String fileBase) throws CommonException {
        FTPClientHelper helper = (FTPClientHelper) ApplicationContextUtils.getBean("report.ftp");
        String strDate = DataFormat.dateToNumber(reportDate);
        String fileDir = helper.getFileDir();
        StringBuffer fileName = new StringBuffer(fileDir);
        if (!fileDir.endsWith("/")) {
            fileName.append("/");
        }

        fileName.append(strDate).append("/").append(brcode).append("/");
        fileName.append(getFileName(brcode, reportDate, fileBase));

        ReportFTPCallback callback = new ReportFTPCallback();
        helper.getFile(fileName.toString(), callback);

        return callback.getBuf();
    }

    /**
     * 从FTP服务器下载文件, 然后通过WEB方式传送给用户.
     * 
     * @param response
     *            应答流
     * @param brcode
     *            分行号
     * @param reportDate
     *            报表日期
     * @param fileBase
     *            基础文件名
     * @throws CommonException
     */
    public String[] downloadFile(String brcode, Date reportDate, String fileBase) throws CommonException {
        File file = null;

        FTPClientHelper helper = (FTPClientHelper) ApplicationContextUtils.getBean("report.ftp");

        String strDate = DataFormat.dateToNumber(reportDate);
        String fileDir = helper.getFileDir();
        StringBuffer dirName = new StringBuffer(fileDir);
        if (!fileDir.endsWith("/")) {
            dirName.append("/");
        }

        dirName.append(strDate).append("/").append(brcode).append("/");

        StringBuffer fileName = new StringBuffer();
        fileName.append(brcode).append("-").append(strDate).append("-").append(fileBase);

        dirName.append(fileName);
        TmpFileFTPCallback callback = new TmpFileFTPCallback();
        helper.getFile(dirName.toString(), callback);

        file = callback.getFile();
        return new String[] { file.getAbsolutePath(), fileName.toString() };
    }

    /**
     * 从FTP服务器下载文件, 然后通过WEB方式传送给用户.
     * 
     * @param appno
     *            查询编号
     * @throws CommonException
     */
    public String[] downloadINQ(String appno) throws CommonException {
        File file = null;

        FTPClientHelper helper = (FTPClientHelper) ApplicationContextUtils.getBean("report.ftp");

        String fileDir = helper.getInqDir();
        StringBuffer dirName = new StringBuffer(fileDir);
        if (!fileDir.endsWith("/")) {
            dirName.append("/");
        }

        StringBuffer fileName = new StringBuffer();
        fileName.append(appno).append(".csv.gz");

        dirName.append(fileName);
        TmpFileFTPCallback callback = new TmpFileFTPCallback();
        helper.getFile(dirName.toString(), callback);

        file = callback.getFile();
        return new String[] { file.getAbsolutePath(), fileName.toString() };
    }

    /**
     * 从FTP服务器下载文件, 然后通过WEB方式传送给用户.
     * 
     * @param appno
     *            查询编号
     * @throws CommonException
     */
    public String[] downloadOVD(String appno) throws CommonException {
        File file = null;

        FTPClientHelper helper = (FTPClientHelper) ApplicationContextUtils.getBean("report.ftp");

        String fileDir = helper.getInqDir();
        StringBuffer dirName = new StringBuffer(fileDir);
        if (!fileDir.endsWith("/")) {
            dirName.append("/");
        }

        StringBuffer fileName = new StringBuffer();
        fileName.append(appno).append(".txt.gz");

        dirName.append(fileName);
        TmpFileFTPCallback callback = new TmpFileFTPCallback();
        helper.getFile(dirName.toString(), callback);

        file = callback.getFile();
        return new String[] { file.getAbsolutePath(), fileName.toString() };
    }
}