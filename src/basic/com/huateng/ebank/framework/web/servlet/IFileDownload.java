package com.huateng.ebank.framework.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class IFileDownload {
    public abstract void download(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException;
}
