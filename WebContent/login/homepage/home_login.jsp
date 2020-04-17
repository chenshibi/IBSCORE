<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="com.huateng.ebank.business.common.UserSessionInfo"%>
<%@page import="java.util.Date"%>
<%@page import="com.huateng.ebank.framework.util.DateUtil"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/easyui/themes/blue/easyui.css">
<title>登陆信息</title>
<%
UserSessionInfo userInfo =	(UserSessionInfo) session.getAttribute("USER_SESSION_INFO");
GlobalInfo globalInfo = (GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
GlobalInfo.setCurrentInstance(globalInfo);
%>
</head>
<body  style="padding:0px;margin:0px;font-size:12px;font-family: Arial,Helvetica,sans-serif;text-align: left;width: 100%;height: 100% " bgcolor="#ffffff">
<div style="font-size: 12px; color: green;padding-left: 15px;line-height: 25px;">
欢迎您：<c:out value='<%=userInfo.getTlrName()%>'/>(<c:out value='<%=userInfo.getTlrNo()%>'/>) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

</div>
<div style="font-size: 12px;padding-left: 15px;line-height: 25px;">
上次成功登录时间：<c:out value='<%=userInfo.getLastLoginTime()%>'/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上次登录失败时间：<c:out value='<%=userInfo.getLastLoginFailTime()%>'/>
</div>



</body>
</html>