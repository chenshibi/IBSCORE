<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import=" java.util.Enumeration"%>

<html>
<head>
<title>IBSCORE SYSTEM</title>
<script language="javascript">

<%
System.out.println("enter login_sso.jsp begin........................");
System.out.println("login_error = " + request.getAttribute("login_error"));
Enumeration headerNames=request.getHeaderNames();
String tlrNo="";
String loginError = (String)request.getAttribute("login_error");
if(loginError == null){
    loginError = "";
}

while(headerNames.hasMoreElements()){
    String headerName=(String)headerNames.nextElement();
    if("uid".equals(headerName)){
        
        tlrNo=request.getHeader(headerName).toLowerCase();
        System.out.println("login_sso.jsp tlrNo=["+tlrNo+"]");
        break;
    }
}

%>
 function getHeader(){
 
 
    var userNmae = document.getElementById("userName");
    var loginError = document.getElementById("loginError");
    if( !userNmae || userNmae.value == ""){
        userNmae.readOnly = false;
    }
    else{
        userNmae.readOnly = true;
        
        if(!loginError || loginError.innerText == ""){
            var form = document.getElementById("loginForm");
            form.submit();
        }
    }
} 

function toValid(){
    var userNmae = document.getElementById("userName");
    if( !userNmae || userNmae.value == ""){
        alert("用户名不能为空！");
        return false;
    }
    return true;
}

</script>
</head>

<body style="margin:0px;overflow:hidden;" onload="getHeader();" >
<table align="center" width="100%" height="250px;" border=0>
<tr height="100px">
    <td>
        &nbsp;
    </td>
</tr>
<tr id="tr11">
    <td align="center">
        <form action="<%=request.getContextPath() %>/custlogin_sso" method="post" id="loginForm" target="_top" name="loginForm" onsubmit="return toValid();">
            <table cellpadding="0" cellspacing="0" border="0" width="246px" style="margin-top: 20px;">
                <tr height="30px" align="center" >
                    <td width="100%"><p id="loginError"><c:out value='${loginError}'/></p></td>
                </tr>
                <tr height="30px" align="center">
                    <td width="100%"> <input type="text" name="userName"  id="userName" value="<c:out value='${tlrNo}'/>" maxlength="10" autocomplete="off" /></td>
                </tr>
                <tr height="30px"  align="center">
                    <td width="100%"> <input width="100%" type="submit" name="Login"  id="Login" value="Login"  /></td>
                </tr>
            </table>
        <form>
    </td>
</tr>
</table>
</body>
</html>
