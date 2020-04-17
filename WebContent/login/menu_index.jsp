<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.huateng.report.utils.NavigationShowUtil"%>
<%@ page pageEncoding="UTF-8" language="java"%>
<%
GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
GlobalInfo.setCurrentInstance(globalInfo);


String xml = NavigationShowUtil.showNavigationXml(globalInfo.getTlrno(),request.getContextPath());
response.setContentType("text/xml; charset=UTF-8");
PrintWriter pw = response.getWriter();
pw.print(xml.replaceAll("&", "&amp;"));
pw.flush();
pw.close();
%>
