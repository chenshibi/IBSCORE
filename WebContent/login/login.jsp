<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/application-tags" prefix="app"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ page import ="com.huateng.ebank.business.common.UserSessionInfo"  %>
<%@page import="java.util.List"%>
<%@page import="com.huateng.ebank.business.common.service.BctlService"%>
<%@page import="resource.bean.basic.Bctl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/login/css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/templets/ui/js/b.js">
</script>
<%
List bctlList = BctlService.getInstance().getAllEnableBctl();
%>
<title> IBSCORE</title>
<script language="JavaScript" type="text/JavaScript">
function func_check()
{
	<% if (request.getAttribute("REQ_MSG") != null) {
		String errMsg = ((String) request.getAttribute("REQ_MSG")).replace("\n","[n]");
	%>
	var errMsg = "<c:out value='${errMsg}'/>";
	alert(errMsg.replace("[n]","\n"));
	<% } %>
	<%
	UserSessionInfo userInfo =	(UserSessionInfo) session.getAttribute("USER_SESSION_INFO");
	if(userInfo!=null)
	{
		out.println("document.loginForm.userName.value = \""+userInfo.getTlrNo()+"\";");
		out.println("document.loginForm.userName.readOnly=true;");
		out.println("focus(document.loginForm.passWord);");
	}
%>

	return;
}

function submitForm(){
	
if(document.loginForm.userName.value==""){
		document.getElementById("mistake").innerHTML="用户名不能为空！";
		return false;
	}else if(document.loginForm.passWord.value==""){
		document.getElementById("mistake").innerHTML="密码不能为空！";
		return false;
	}
	document.loginForm.passWord.value = new _B().encode(document.loginForm.passWord.value);
	document.loginForm.submit();
}
//modify by chenjinghui 2010-5-20 HTEBANK-11 begin
function resetForm(){
	document.loginForm.reset();
	//document.loginForm.brCodeName.value ="--请选择机构--";
	//document.loginForm.brCode.value ="";
	document.loginForm.userName.value ="";
	document.loginForm.passWord.value ="";
}
//modify by chenjinghui 2010-5-20 HTEBANK-11 end
function nextEvent(strName){
	if(event.keyCode==13 || event.keyCode==9){
	 	if (strName == "submit"){
			submitForm();
		}else{
			document.getElementById(strName).focus();
		}
	}
}
</script>
</head>
 
<body onload="func_check()" style="background: url('<%=request.getContextPath() %>/login/images/BJ.png');height:100%; margin:0 auto; width:100%;">
<img src="<%=request.getContextPath()%>/login/images/head.PNG" width=100% border="0"/>
<table cellpadding="0" cellspacing="0" border="0" height="90%" width="100%"   >
 
 
	<td valign="top" align="center">
	<html:form action="/custlogin.do" target="_top" focus="userName">
	<input type="hidden" name="brCode" id="brCode"/>
	<table  cellpadding="0" cellspacing="0" border="0" width="30%" height="10%">
		<tr>
			<td align="center" valign="top">
			
			<table cellpadding="0" cellspacing="0" border="0" width="555px" style="margin-top: 20px;">
			<!--
			<tr height="35px">
				<td width="37px"><img src="<%=request.getContextPath() %>/login/images/icon_jigou.gif"  alt="" id="brcodeImg1" title="点击选择机构"/></td>
				<td width="100%">
				<input type="text" name="brCodeName" id="brCodeName"  value="--请选择机构--" class="inputcls" readonly="readonly" style="cursor: default;" autocomplete="off" /><p>
				<div id="brCodeSelect" style="position:absolute;width:auto;">
					<ol id="brCodeOl">
					<%
					for(int i=0;i<bctlList.size();i++){
						Bctl bctl = (Bctl)bctlList.get(i);
					%>
					<li><a href="javascript:setBrCode("<c:out value='<%=bctl.getBrno()%>'/>"+"-"<c:out value='<%=bctl.getBrname()%>'/>","<c:out value='<%=bctl.getBrno()%>'/>");" id="bctl_<c:out value='<%=bctl.getBrno()%>'/>">"<c:out value='<%=bctl.getBrno()%>'/>"+"-"<c:out value='<%=bctl.getBrname()%>'/>"</a></li>
					<%} %>
					</ol>
				</div>
				</p>
				</td>
				<td width="9px;"><img src="<%=request.getContextPath() %>/login/images/corner_ipt_login.gif"  alt=""  id="brcodeImg2"/></td>
			</tr>
			-->
			<tr height="222px" ><td>&nbsp;</td></tr>
			<tr  height="35px"  >
				<td  colspan="5"  align="center"  ><font size="88" color="BLACK">IBS</font></td>
				
			</tr>
			<tr  height="35px" >
				<td   colspan="5"  align="center"  ><font size="5" color="BLACK">Internal Bureau System</font></td>
				
			</tr>
			
			<tr  height="35px">
			<td width="37px" colspan="2">  </td>
				<td width="130px" align="center">peoplewise&nbsp;id</td>
				<td  > <input type="text" name="userName"  id="userName" value=""	onkeypress="nextEvent('password');" maxlength="10" class="inputcls" autocomplete="off" /></td>
			
			</tr>
			<tr  height="35px">
			<td width="1px" colspan="2">   </td>
				<td width="130px" align="center">password</td>
				<td  ><input type="password" name="passWord" id="passWord" value=""	onkeypress="nextEvent('submit');" class="inputcls" autocomplete="off"/></td>
			</tr>
			<tr height="40px" >
				<td colspan="6" valign="middle" align="center">
				<table cellpadding="0" cellspacing="0" border="0" width="100%">
					<tr>
						
						<td align="right" colspan="2" >
						
						
						<img src="<%=request.getContextPath() %>/login/images/btn_login.png" class="hand"  alt="" onclick="submitForm()"/>
						</td>
						<td colspan="2">&nbsp;&nbsp;</td>
						<td align="left" colspan="2">
						
					
						<img src="<%=request.getContextPath() %>/login/images/btn_reset.png" class="hand"  alt="" onclick="resetForm()"/>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			</table>
			</td>
		</tr>
	</table>
	</html:form>
	</td>
	</tr>
	<tr    >
		 
	</tr>
	
	<tr height="30px"><td></td></tr>
</table>
<script type="text/javascript">
	function setBrCode(name,code){
		var sel = document.getElementById("brCode").value;
		document.getElementById("bctl_"+code).style.backgroundColor = "highlight";
		document.getElementById("bctl_"+code).style.color = "#ffffff";
		if(sel!=null && sel.length>0 && sel!=code){
			document.getElementById("bctl_"+sel).style.backgroundColor = "";
			document.getElementById("bctl_"+sel).style.color = "";
		}
		document.getElementById("brCodeName").value = name;
		document.getElementById("brCode").value = code;
		hideOptions();
		document.getElementById("userName").focus();
	}

	function showOptions () {
		var bcHt = document.getElementById("brCodeOl");
		bcHt.style.display='block';
		var ht = bcHt.offsetHeight;
		if(ht>160){
			bcHt.style.height="160px";
		}
	}
	function hideOptions () {
		document.getElementById("brCodeOl").style.display='none';
	}
	document.onclick = function(e){
		var evt = e?e:window.event;
		var ele = evt.srcElement || evt.target;
		if(ele.id == 'brCodeName' || ele.id == "brcodeImg1" || ele.id == "brcodeImg2"){
			showOptions();
		}else{
			hideOptions();
		}
	}
</script>
</body>
</html:html>
