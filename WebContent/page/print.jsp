<%@ page contentType="text/html;charset=utf-8" language="java"%>
<html>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	color: #2A0000;
	background-image: url(../images/back.jpg);
}

body,td,th {
	color: 020714;
}

.STYLE1 {
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	color: #9DB0BF;
	font-size: small;
}

.STYLE4 {
	color: #000000
}

.STYLE5 {
	font-size: medium;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	color: black;
}
.noBorder{
	BORDER-RIGHT: rgb(0,0,0)   1px   solid;
	BORDER-TOP:   rgb(0,0,0)   1px   solid;
	FONT-SIZE:   9pt;
	BORDER-LEFT:   rgb(0,0,0)   1px   solid;
	BORDER-BOTTOM:   rgb(0,0,0)   1px   solid
}
-->
</style>

<HEAD>
<title>打印中...</title>
<link rel="stylesheet" type="text/css" href="../css/header.css">
<link rel="stylesheet" type="text/css" href="../css/font.css">
<script language="javascript" src="../js/ajaxUtil.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/templets/lib/toexcel.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/templets/lib/basic.js"></script>
<script type='text/javascript' src="<%=request.getContextPath()%>/dwr/engine.js"> </script>
<script type='text/javascript' src="<%=request.getContextPath()%>/dwr/util.js"> </script>
<script language="javascript" src="<%=request.getContextPath()%>/templets/ui/js/dwr.js"></script>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=utf-8">
<style type="text/css">
<!--
.style1 {
	font-size: xx-small
}
-->
</style>
</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0
	MARGINHEIGHT=0>
	<table>
		<tr>
			<td>
				<label id="banner" class="STYLE5">正在打印，请稍候，请不要关闭此窗口，打印完成时它将自动关闭</label>
			</td>
		</tr>
	</table>

	<script type="text/javascript">
	//<!--
	window.onunload = function(){
		window.opener.printPageCallback();
	}

	try{
		printASExcelFrame(window.opener.parent.window.frames[2].window.frames[1].document);
	}catch (e){

	}

	window.opener.printPageCallback();
	window.close();

	//-->
	</script>
</BODY>
</HTML>