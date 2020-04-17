<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../../css/menu.css" rel="stylesheet" type="text/css">
</head>
<body style="margin: 0; overflow: hidden" bgcolor=#EDF2F6>
<script langauge=javascript>
var rows="60%,40%";
var showstatus=0;//0 都显示 1 显示tree 2 显示mess
function hiddentop()
{
	if(showstatus == 0)
	{
		rows=parent.parent.frames["left"].rows;
		parent.parent.frames["left"].rows="0,*";
		document.getElementById("topdirect").style.display ="none";
		document.getElementById("bottomdirect").style.display ="";
		showstatus=2;
	}
	else if(showstatus == 1)
	{
		parent.parent.frames["left"].rows=rows;
		document.getElementById("topdirect").style.display ="";
		document.getElementById("bottomdirect").style.display ="";
		showstatus=0;
	}
	else
	{
		return;
	}
}

function hiddenbottom()
{
	if(showstatus == 0)
	{
		rows=parent.parent.frames["left"].rows;
		parent.parent.frames["left"].rows="*,72px";
		document.getElementById("topdirect").style.display ="";
		document.getElementById("bottomdirect").style.display ="none";
		showstatus=1;
	}
	else if(showstatus == 2)
	{
		parent.parent.frames["left"].rows=rows;
		document.getElementById("topdirect").style.display ="";
		document.getElementById("bottomdirect").style.display ="";
		showstatus=0;
	}
	else
	{
		return;
	}
}
</script>
<div id='mnuMain' style='left:10px;top:0;width:100%;height:3%' align="center">

<img id="topdirect" src="<%=request.getContextPath()%>/images/switchtop.gif" onclick="hiddentop()"/>
<img id="bottomdirect" src="<%=request.getContextPath()%>/images/switchbottom.gif" onclick="hiddenbottom()"/>

</div>
</body>
</html>