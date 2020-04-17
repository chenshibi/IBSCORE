<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="com.huateng.ebank.business.common.CommonFunctions"%>
<%String   menuBar = CommonFunctions.createMenu(session);%>

<div id="_MenuBar" style="display:none">
	<%=menuBar%>
</div>
<script>
	$(function(){
		$("#_MenuBar").show();
	});
</script>