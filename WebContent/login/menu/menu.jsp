<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.huateng.ebank.business.common.CommonFunctions"%>
<%
String menuDiv = CommonFunctions.createMenu(session);
%>
<ul id="menu" class="first-menu">
<%=menuDiv%>
</ul>