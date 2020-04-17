<%@page import="com.huateng.report.system.service.SysNoticeService"%>
<%@page import="resource.bean.basic.SysNotice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<script type="text/javascript" src="<%=request.getContextPath() %>/login/homepage/js/MSClass.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templets/easyui/themes/blue/easyui.css">
<title>登陆信息</title>
<style type="text/css">
	body{
		padding:0px;margin:0px;font-size:12px;font-family: Arial,Helvetica,sans-serif;
	}
	li{
		height:25px;font-size:12px;
	}
	.noticeDiv{
		padding-top:5px;
		text-align:left;
		padding-left:5px;
		width:280px;
		height:90px;
		overflow:hidden;
	}
	.notice{
		white-space: nowrap;
		width:280px;
		text-overflow:ellipsis;
		overflow:hidden;
		cursor: pointer;
	}
	.noticeSystem{
		white-space: nowrap;
		width:280px;
		text-overflow:ellipsis;
		overflow:hidden;
		cursor: pointer;
		color: red;
	}
	a{
		text-decoration: none;
	}
</style>
<%
int row = 4;



List sysNoticeList = SysNoticeService.getInstance().getViewSysNotice(request.getSession());
%>
</head>
<body bgcolor="#ffffff">
<div class="noticeDiv" id="noticeDiv">
	<ul id="noticeContent">
	<%if(sysNoticeList != null && sysNoticeList.size() > 0){
		int rs = sysNoticeList.size()/row;
		int yushu = sysNoticeList.size()%row;
		if(rs > 0){
			List beforList = sysNoticeList.subList(0, rs * row);
			for(int i = 0; i < beforList.size(); i++){
				SysNotice notice = (SysNotice)beforList.get(i);
				String cls = "notice";
				if(notice.getCrtTlr().equalsIgnoreCase("SYSTEM")){
					cls = "noticeSystem";
				}
				%>
				<li><a href="javascript:void(0);" onclick="showNotice('<%=notice.getId() %>');return false;" title="<%=notice.getNoticeTitle()%>"><div class="<%=cls %>"><%=notice.getNoticeTitle() %></div></a></li>
				<%
			}
		}
		if(yushu > 0){
			List afterList = sysNoticeList.subList(rs * row, sysNoticeList.size());
			for(int i = 0; i < afterList.size(); i++){
				SysNotice notice = (SysNotice)afterList.get(i);
				String cls = "notice";
				if(notice.getCrtTlr().equalsIgnoreCase("SYSTEM")){
					cls = "noticeSystem";
				}
				%>
				<li><a href="javascript:void(0);" onclick="showNotice('<%=notice.getId() %>');return false;" title="<%=notice.getNoticeTitle()%>"><div class="<%=cls %>"><%=notice.getNoticeTitle() %></div></a></li>
				<%
			}
			for(int j = 0; j < row-yushu; j++){
				%>
				<li>&nbsp;</li>
				<%
			}
		}
	}
	%>
	</ul>
</div>
<script type="text/javascript">
	new Marquee(["noticeDiv","noticeContent"],0,1,280,90,20,4000,2000,25);			//文字翻屏滚动实例
	function showNotice(id){
		window.parent.document.getElementById("noticeView").value=id;
		window.parent.maxFrm(10);
	}
</script>
</body>
</html>