<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@taglib prefix="bill"
	uri="http://www.huateng.com/BillSysTag"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/public.css" rel="stylesheet" type="text/css">
<title>消息处理</title>
<script language="javascript">
var isflash=true;
function recivemail()
{
	isflash=false;
	var divrecive = document.getElementById("recive");
	if(divrecive.style.visibility == "hidden")
	{
		divrecive.style.visibility="";
	}
	var winFeatures="dialogHeight:360px;dialogWidth:480px;edge:Raised;center:Yes;help:No;resizable:No;status:No;";
  	var flags = new Array();
    flags = <bill:ShowModalDialog  URL="/jpages/mail/Recive.jsp" height="360" width="480" />;	  		  
    //flags = window.showModalDialog("../../jpages/mail/Recive.jsp" ,"",winFeatures);    
    if(!flags){
    	  return;
    }
    
}
function sendmail()
{
	var winFeatures="dialogHeight:360px;dialogWidth:480px;edge:Raised;center:Yes;help:No;resizable:No;status:No;";
  	var flags = new Array();
    flags = <bill:ShowModalDialog  URL="/jpages/mail/sendmail.jsp" height="360" width="480" />;
    if(!flags){
    	  return;
    }
}
function flash()
{
	var divrecive = document.getElementById("recive");
	if(divrecive.style.visibility != "hidden")
	{
		divrecive.style.visibility="hidden"
	}
	else
	{
		divrecive.style.visibility=""
	}		
}
function interval()
{
	if(isflash == true)
		flash();
}
setInterval("interval()",1000);
</script>
</head>
<body style="margin: 0;" bgcolor=#EDF2F6>
<div class="divtitle">
工作提醒/消息:
</div>
<div class="divtitle">
<table width="100%">
<tr>
	<td   align="right">
	<div id="recive" align="right">
		<img src="<%=request.getContextPath()%>/images/mail.gif" alt="接受邮件" title="接受邮件"/>
	</div>
	</td>
	<td align="left">
	<div class="divmsg" id="recivemail" onclick="recivemail()" align="left">
		您有3条新消息!
	</div>
	</td>
</tr>
<tr>
	<td  align="right">
	<div id="send" align="right">
		<img src="<%=request.getContextPath()%>/images/SendMail.bmp" alt="发送邮件" title="发送邮件"/>
	</div>
	</td>
	<td align="left">
		<div class="divmsg" id="sendmail" onclick="sendmail()" align="left">
		编写消息
		</div>
	</td>
</tr>
</table>
</div>
<body>
</html>