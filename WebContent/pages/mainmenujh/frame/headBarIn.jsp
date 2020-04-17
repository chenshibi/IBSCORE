<%@ page contentType="text/html;charset=utf-8" language="java"%>
<html:html>
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
	font-size: small;
	font-family: Arial, Helvetica, sans-serif;
	font-weight: bold;
	color: #BDCDDC;
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
<link rel="stylesheet" type="text/css" href="../css/header.css">
<link rel="stylesheet" type="text/css" href="../css/font.css">
<script language="javascript" src="../js/ajaxUtil.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/templets/lib/toexcel.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/templets/lib/basic.js"></script>
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
<table width="101%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="#5D7DDA">
		<script language="javascript">
				/*
				if(window.screen.width==800)
							document.writeln("<img src='../images/topbanner_800.gif'  >");
					else(window.screen.width==1024)
							document.writeln("<img src='../images/topbanner_1024.gif' >");
				*/

			window.onbeforeunload = function(){
				if( ! parent.isChangeRoleFlag()){
					window.location = "<%=request.getContextPath()%>/logout.do";
				}
			};
			function logoutconfrim(){
				if( confirm('确认要退出系统?') ) {
						window.onbeforeunload = function(){};
						window.parent.location = "<%=request.getContextPath()%>/logout.do";
						return true;
				}
				return false;
			}
			function printPage(){
			    printASExcelFrame(parent.window.frames[3].document);
			}
		</script>
		</td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="15%"><img src="../images/log.jpg" width="222"
			height="61" /></td>
		<td width="85%"><img src="../images/tile.jpg" width="557"
			height="61" /></td>
	</tr>
	<tr>
		<td colspan="2">
		<TABLE width="100%" border=0 cellPadding=0 cellSpacing=0>
			<TBODY>
				<TR>
					<TD width="15%" align=center valign="middle">
					<!--
					<span class="style1"><img src="../images/spacer.gif"
						width="90" height="1"> <br>
					</span>
					<a href="/logout.do" target="_top" class="whitelink">退 出</a>
					-->
					<!--
					<a  href="#" onclick="javascript:logoutconfrim();" target="_self"
						class="whitelink">退出系统</a>
					-->
					<input type="button"
							name="ibtn_Exit"
							id="ibtn_Exit"
							onClick="javascript:return logoutconfrim();"
							src=""
							value="退出"
							tip="退出"
							class="noBorder"

							alt="退出" border="0"
						style="height:16px;width:46px;" />

					</TD>
					<TD>
					<TABLE cellSpacing=0 cellPadding=0 border=0>
						<TBODY>
							<TR>
								<TD align=center></TD>
								<app:authorize menulevel="0" menuid="9910100">
									<TD class=tilemenu><A href="left1.jsp"
										target="left">客户管理</A></TD>
									<TD><IMG height=23 src="../images/ic01.jpg" width=6></TD>
								</app:authorize>
							</TR>
						</TBODY>
					</TABLE>
					</TD>
					<TD width="15%" align=center valign="middle">
					<input type="button"
							name="ibtn_Exit"
							id="ibtn_Exit"
							onClick="printPage()"
							src=""
							value="打印"
							tip="打印"
							class="noBorder"
							alt="退出" border="0"
						style="height:16px;width:46px;" />

					</TD>
				</TR>
			</TBODY>
		</TABLE>
		</td>
	</tr>
</table>
<div id="onlineBatchQueryDiv"
	style="display: none; position: absolute; left: 900px; top: 0px; height: 15px; width: 130px; border: 0px dashed #9fd6ff; font-size: 12px; background-color: white; font-family: Verdana, Arial, Helvetica, sans-serif"
	align="right"><br />
<br />
</div>
</BODY>
</html:html>