<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="<%=request.getContextPath()%>/js/menu.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/scrollbutton.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/js/poslib.js"></script>

<link href="<%=request.getContextPath()%>/css/menu.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/public.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
.menumsg {
	PADDING-TOP: 0px;
	MARGIN-TOP: 0px;
	PADDING-LEFT: 0px;
	MARGIN-LEFT: 0px;
	font-family: 宋体;
	font-size: 14px;
	margin: 0px;
}
-->
</style>
</head>
<body style="margin: 0; overflow: hidden ;background-color: #cae1f3;" >
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
<tr>
	<td height="86" width="800">
		<img src="<%=request.getContextPath()%>/images/title-a.jpg" align="left" height="86" />
	</td>
	<td background="<%=request.getContextPath()%>/images/title-b.jpg">
	 &nbsp;
	</td>
</tr>
</table>
<!--
<div >
<img src="<%=request.getContextPath()%>/images/tile.jpg" align="middle" width="984" height="83" />
</div>
 -->
<script language="javascript" >
Menu.prototype.mouseHoverDisabled = false;
Menu.prototype.cssFile = "<%=request.getContextPath()%>/css/menu.css";
var menuMain = new MenuBar();
<%
StringBuffer m = (StringBuffer)request.getSession().getAttribute("menu");
%>
Menu_buildMenu(new  Array(<c:out value='${m}'/>),menuMain);
menuMain.add( tmp = new MenuButtonUrl( "退出",function Exit(){sExit()} ));
menuMain.add( tmp = new MenuButtonUrl( "返回首页",function Exit(){backToWelcome()} ));

menuMain.write();

function sExit()
{
	window.open("<%=request.getContextPath()%>/custlogout.do", "_top");
}

function backToWelcome()
{
	window.open("<%=request.getContextPath()%>/welcome.do", "main");
}

</script>
</body>
</html>