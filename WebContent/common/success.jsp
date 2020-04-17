<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<html:rewrite page='/css/style.css' />">
<%
String path = request.getContextPath();
String type = request.getParameter("type");
%>
</head>

<body style="text-align: center;">
<table width="90%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="56" align="right"><img src="<%=request.getContextPath()%>/images/info_f1.gif" width="56" height="44"></td>
    <td width="100%" background="<%=request.getContextPath()%>/images/info_f3.gif"><img src="<%=request.getContextPath()%>/images/info_f2.gif" width="165" height="44"></td>
    <td width="26"><img src="<%=request.getContextPath()%>/images/info_f4.gif" width="26" height="44"></td>
  </tr>
   <tr>
    <td height="71" valign="top" background="<%=request.getContextPath()%>/images/info_f6.gif"><img src="<%=request.getContextPath()%>/images/info_f5.gif" width="56" height="30"></td>
    <td align="center" class="errors">
    <table width="100%" height="100%">
        <%if(type==null|| !type.equalsIgnoreCase("signout")){ %>
        <tr height="100%">
            <td align="center"><font color="red">您的操作已成功！ </font></td>
        </tr>
        <%}else if(type!=null && type.equalsIgnoreCase("signout")){ %>
            <tr height="100%">
            <td align="center"><font color="red">用户已被签退或因已进行工作日期切换，系统将重新登录！</font></td>
        </tr>
        <%} %>
        <%
        int count = 5;
        if(type!=null && type.equalsIgnoreCase("approve")){
        %>
        <tr>
            <td align="right" style="padding-right: 10px;font-size: 12px;"><a href="javascript:void(0)" onclick="backApprove()"><span id="countspane"><%=count %></span>秒后自动返回，或点击链接返回</a>
            <script type="text/javascript">
            var ct = "<c:out value='<%=count%>'/>";
            var span = document.getElementById("countspane");
            function backApprove(){
                window.location.href="<%=request.getContextPath()%>/fpages/system/ftl/DirectorConfirm.ftl";
            }
            var t = window.setInterval(function(){
            try{
                if(ct<=1){
                    backApprove();
                }else{
                    ct--;
                    span.innerHTML = ct;
                }
            }catch(e){}},1000);
            </script>
            </td>
        </tr>
        <%}else if(type!=null && type.equalsIgnoreCase("tlrapprove")){ %>
             <tr>
            <td align="right" style="padding-right: 10px;font-size: 12px;"><a href="javascript:void(0)" onclick="backApprove()"><span id="countspane"><%=count %></span>秒后自动返回，或点击链接返回</a>
            <script type="text/javascript">
            var ct = "<c:out value='<%=count%>'/>";
            var span = document.getElementById("countspane");
            function backApprove(){
                window.location.href="<%=request.getContextPath()%>/fpages/regonization/ftl/OperMngCheck.ftl";
            }
            var t = window.setInterval(function(){
            try{
                if(ct<=1){
                    backApprove();
                }else{
                    ct--;
                    span.innerHTML = ct;
                }
            }catch(e){}},1000);
            </script>
            </td>
        </tr>
        <%}else if(type!=null && type.equalsIgnoreCase("approverole")){ %>
        <tr>
       		<td align="right" style="padding-right: 10px;font-size: 12px;"><a href="javascript:void(0)" onclick="backApprove()"><span id="countspane"><%=count %></span>秒后自动返回，或点击链接返回</a>
       		<script type="text/javascript">
       		var ct = "<c:out value='<%=count%>'/>";
      	 	var span = document.getElementById("countspane");
      	 	function backApprove(){
           		window.location.href="<%=request.getContextPath()%>/fpages/regonization/ftl/RoleMngCheck.ftl";
       		}
       		var t = window.setInterval(function(){
       		try{
           		if(ct<=1){
               		backApprove();
           		}else{
               		ct--;
               	span.innerHTML = ct;
           		}
       		}catch(e){}},1000);
       		</script>
       		</td>
   		</tr>
   		<%}else if(type!=null && type.equalsIgnoreCase("databak")){ %>
            <tr>
            <td align="right" style="padding-right: 10px;font-size: 12px;"><a href="javascript:void(0)" onclick="backout()"><span id="countspane"><%=count %></span>秒后自动返回登录页面，或点击链接返回</a>
            <script type="text/javascript">
            var ct = "<c:out value='<%=count%>'/>";
            var span = document.getElementById("countspane");
            function backout(){
                window.open("<%=request.getContextPath()%>/custlogout.do", "_top");
            }
            var t = window.setInterval(function(){
            try{
                if(ct<=1){
                    backout();
                }else{
                    ct--;
                    span.innerHTML = ct;
                }
            }catch(e){}},1000);
            </script>
            </td>
        </tr>
        <%}else if(type!=null && type.equalsIgnoreCase("signout")){ %>
            <tr>
            <td align="right" style="padding-right: 10px;font-size: 12px;"><a href="javascript:void(0)" onclick="backSignOut()"><span id="countspane"><%=count %></span>秒后自动返回登录页面，或点击链接返回</a>
            <script type="text/javascript">
            var ct = <c:out value='${count}'/>;
            var span = document.getElementById("countspane");
            function backSignOut(){
                window.open("<%=request.getContextPath()%>/custlogout.do", "_top");
            }
            var t = window.setInterval(function(){
            try{
                if(ct<=1){
                    backSignOut();
                }else{
                    ct--;
                    span.innerHTML = ct;
                }
            }catch(e){}},1000);
            </script>
            </td>
        </tr>
        <%}  else if(type!=null && type.equalsIgnoreCase("approvesysparams")){
        		String intInsId = request.getParameter("intInsId");
        %>
        <tr>
            <td align="right" style="padding-right: 10px;font-size: 12px;"><a href="javascript:void(0)" onclick="backApproveSysParams()"><span id="countspane"><%=count %></span>秒后自动返回登录页面，或点击链接返回</a>
            <script type="text/javascript">
            var ct = <c:out value='${count}'/>;
            var intInsId = <c:out value='${intInsId}'/>;
            var span = document.getElementById("countspane");
            function backApproveSysParams(){
            	if(intInsId=="100799"){
                	 window.location.href="<%=request.getContextPath()%>/fpages/system/ftl/SysParamsCheck.ftl";            
            	}else if(intInsId=="120299"){
            		 window.location.href="<%=request.getContextPath()%>/fpages/fayuan/ftl/businessCheck.ftl";
            	}else if(intInsId=="120399"){
            		 window.location.href="<%=request.getContextPath()%>/fpages/tfms/ftl/tcpBusinessCheck.ftl";
            	}
            }
            var t = window.setInterval(function(){
            try{
                if(ct<=1){
                	backApproveSysParams();
                }else{
                    ct--;
                    span.innerHTML = ct;
                }
            }catch(e){}},1000);
            </script>
            </td>
        </tr>
        <%}%>
    </table>
    </td>
    <td width="26" background="<%=request.getContextPath()%>/images/info_f11.gif">&nbsp;</td>
  </tr>
<tr>
    <td width="56"><img src="<%=request.getContextPath()%>/images/info_f7.gif" width="56" height="36"></td>
    <td background="<%=request.getContextPath()%>/images/info_f9.gif"><img src="<%=request.getContextPath()%>/images/info_f8.gif" width="77" height="36"></td>
    <td width="26"><img src="<%=request.getContextPath()%>/images/info_f10.gif" width="25" height="35"></td>
  </tr>
</table>
</body>
</html>
