/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.pageqryexp.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.common.Code;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.WebDownloadFile;
import com.huateng.ebank.framework.web.servlet.IFileDownload;

import resource.bean.boa.CustFilemap;

/**
 *
 * 下载文件的Action.
 */
public class FileDownloadAction extends IFileDownload {
    private static final Logger log = Logger.getLogger(FileDownloadAction.class);

    @Override
    public void download(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        File file = null;
        try {
            // 初始化GlobalInfo
            ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
            String id = request.getParameter("id");
            String downloadInfo = request.getParameter("downloadinfo");
            String type = request.getParameter("type");

            // 菜单权限
            boolean flag = false;// 是否有权限下载
            GlobalInfo global = GlobalInfo.getCurrentInstance();
            Map<String, String> buttonMap = global.getButtonMap();
            for (Map.Entry<String, String> entry : buttonMap.entrySet()) {
                if ('6' == entry.getValue().charAt(0)) {
                    flag = true;
                }
            }
            if (!flag) {
                throw new Exception("您无权下载！");
            }

            downloadInfo = java.net.URLDecoder.decode(downloadInfo, "utf-8");

            if (null == downloadInfo)
                throw new Exception("没有获取下载信息.");
            // String[] strArray =
            // (String[])ObjectSerialiszer.unserialize(downloadInfo);
            // downloadInfo = fileUrl + downloadInfo + suf;
            String displayName = new File(downloadInfo).getName();
            String absoluteFile = downloadInfo;

            file = new File(absoluteFile);

            if (file.exists() == false) {
                String hql1 = "from CustFilemap where filename = '" + downloadInfo + "'";
                List list1 = rootDao.queryByQL2List(hql1);
                if (list1.size() > 0) {
                    CustFilemap filemap = (CustFilemap) list1.get(0);
                    String allpath = filemap.getFilepath();
                    if (StringUtils.isNotBlank(allpath)) {
                        file = new File(allpath);
                        displayName = file.getName();
                    }
                }

            }
            WebDownloadFile.downloadFile(resp, file, displayName);
        } catch (Exception e) {
            log.error(e);
            String errmsg = Code.encode("下载失败!");
            resp.getWriter().write("<script>alert('download failed!');</script>");
        } finally {

        }
    }
}