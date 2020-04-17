package com.huateng.ebank.business.print.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 打印操作基类
 *
 */
public abstract class BasePrinter {

    public abstract List getPrinterList(HttpServletRequest request) throws Exception;
}
