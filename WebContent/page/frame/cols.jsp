<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cols</title>
</head>
<body style="margin: 0; overflow: hidden" bgcolor=#EDF2F6>
<script langauge=javascript>
var cols="20%,80%";
var isShow=true;
function hidden()
{
	if(isShow == true)
	{
		cols=parent.parent.frames["splitcol"].cols;
		parent.parent.frames["splitcol"].cols="0,*";
		document.getElementById("direct").src="<%=request.getContextPath()%>/images/rightbar_btn_3.gif";
		isShow=false;
	}
	else
	{
		parent.parent.frames["splitcol"].cols=cols;
		document.getElementById("direct").src="<%=request.getContextPath()%>/images/rightbar_btn_1.gif";
		isShow=true;
	}
}

</script>

<div id='mnuMain' style='left:0;top:100px;width:3%;height:100%' align="middle" background-color: #EDF2F6;>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<img id="direct" src="<%=request.getContextPath()%>/images/rightbar_btn_1.gif" onclick="hidden()"/>
</div>

</body>
</html>