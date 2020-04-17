<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.huateng.report.common.service.ReportCommonService"%>
<%@page import="java.util.List"%>
<%@page import="resource.bean.basic.FunctionInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<title>个人收藏夹</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/templets/easyui/themes/blue/easyui.css">
	<style type="text/css">
		.menudiv{
			background-color: #deedf7;
			border: solid 1px #aed0ea;
			text-align: left;
			line-height: 25px;
			overflow:hidden;
			white-space:nowrap;
			text-overflow:ellipsis;
			color: #000000;
			margin-bottom: 1px;
			width: 95%;
			white-space:nowrap;
			padding-left: 5px;
			margin-top: 1px;
		}
	</style>
	<%
	List funcList = ReportCommonService.getInstance().getFunctionInfoListByFavt(session);
	%>
</head>
<body bgcolor="white" style="margin: 0px;">
<center>
<div style="padding: 3px;text-align: center;">
<%
if(funcList.size()>0){
for(int i=0;i<funcList.size();i++){
	FunctionInfo fun = (FunctionInfo)funcList.get(i);
%>
<div class="menudiv" id="div_<c:out value='<%=fun.getId().trim()%>'/>" style="cursor: pointer;" onclick="doIndexWork('<c:out value='<%=fun.getId().trim()%>'/>','<c:out value='<%=fun.getFuncname()%>'/>','<c:out value='<%=fun.getPagepath()%>'/>')"  onmouseover="this.style.backgroundColor='#cce6f9'" onmouseout="this.style.backgroundColor=''" title="<c:out value='<%=fun.getFuncname()%>'/>"><c:out value='<%=fun.getFuncname()%>'/></div>
<%} }else{%>
<div style="font-size: 12px;color: green;padding: 5px;text-align: center;border: 1px solid #ededed;cursor: default;" onmouseover="this.style.backgroundColor='#ffffbe'" onmouseout="this.style.backgroundColor=''" id="msg" onclick="window.parent.maxFrm(0)">请点击设置收藏夹</div>
<%} %>

</div>
<script type="text/javascript">
	function doIndexWork(funcId,name,url){
		window.parent.parent.doWork(funcId,name,url);
	}
</script>
</center>
</body>
</html>