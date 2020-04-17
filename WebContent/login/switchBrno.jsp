<%@page import="com.huateng.ebank.business.common.GlobalInfo"%>
<%@page import="com.huateng.ebank.business.management.service.UserMgrService"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=9" />
<script  type="text/javascript">
    function doSwitchBrno(brno){
        var brCode = document.getElementById("brCode");
        brCode.value = brno;
        var form = document.getElementById("loginForm");
        form.submit();
    }
</script>
</head>

<body>
<%
    String tlrno = ((GlobalInfo) session.getAttribute(GlobalInfo.KEY_GLOBAL_INFO)).getTlrno();
    int count = 0;
    out.println("<div width=\"100%\">");
    
    
    for (String brnoname:rlst) {
        String brno = brnoname.split("-", 2)[0];
    	if(brno.equals(curBrno)){
    		continue;
    	}
    	if(count == 0){
    		out.println("<table border=\"1\" cellspacing=\"0\" width=\"80%\" align=\"center\">");
    	}
    	count++;
        out.println("<tr><td width=\"80%\">"+brnoname+"</td>" + "<td width=\"20%\"><a href=\"javascript:void(0)\" onclick=\"doSwitchBrno(" + brno + ")\">\u5207\u6362</a></td></tr>");
    }
    
    if(count == 0){
    	out.println("\u6CA1\u6709\u60A8\u53EF\u4EE5\u5207\u6362\u7684\u5206\u884C\u53F7\uFF0C\u8BF7\u5173\u95ED\u8BE5\u7A97\u53E3\u3002</div>");
    }
    else{
    	out.println("</table></div>");
    }
%>


<form action="<%=request.getContextPath() %>/custlogin_sso" method="post" id="loginForm" target="_top" style="display:none;" name="loginForm" onsubmit="return toValid();">
	<table cellpadding="0" cellspacing="0" border="0" width="246px" style="margin-top: 20px;">
	    <tr height="30px" align="center">
	        <td width="100%"> <input type="text" name="userName"  id="userName" value="<%=tlrno%>" maxlength="10" autocomplete="off" /></td>
	    </tr>
	    <tr height="30px" align="center">
            <td width="100%"> <input type="text" name="brCode"  id="brCode" value="" maxlength="10" autocomplete="off" /></td>
        </tr>
	    <tr height="30px"  align="center">
	        <td width="100%"> <input width="100%" type="submit" name="Login"  id="Login" value="Login"  /></td>
	    </tr>
	</table>
<form>
</body>
</html>