<html>

<head>

<title></title>
<script language="javascript">
v_change_role_flag = false;

function setChangeRoleFlag(booleanFlag){
	v_change_role_flag = booleanFlag;
}

function isChangeRoleFlag(){
	return v_change_role_flag;
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>

<frameset rows="85,*,26" framespacing="0"  frameborder="0" border="0">
  <frame src="<%=request.getContextPath()%>/pages/mainmenujh/frame/headBarIn.jsp" name="topFrame" scrolling="NO" noresize >
  <frameset cols="153,*,0" framespacing="0" frameborder="0" border="0" bordercolor="#99CC99" name=subFrame>
  	<frameset name="fleft" cols="*,15" frameborder="0">
      <frame src="<%=request.getContextPath()%>/pages/mainmenujh/frame/left8.jsp" name="left" scrolling="auto" noresize id="left">
      <frame src="<%=request.getContextPath()%>/pages/mainmenujh/frame/leftbar.htm" name="switchl" scrolling="no" noresize >
   	</frameset>
    <frameset name="main" cols="*,15,0" frameborder="0">
	  	<frameset rows="*,12,0" framespacing="0" frameborder="no" border="0" name="leftfrm">
			<frame name="businessfrm"  scrolling="auto" src="<%=request.getContextPath()%>/pages/mainmenujh/welcome.jsp">
<!--
			<iframe name="vswitch1" scrolling="no" src="pages/mainmenujh/frame/vswitch1.htm" noresize>
			<iframe name="customerfrm" src="trans/CommQueryServlet?CQId=queryIndvQuery&_cds_=0">
-->
	  	</frameset>
	   	<frame name="switch" scrolling="no" src="<%=request.getContextPath()%>/pages/mainmenujh/frame/rightbar.htm" noresize>
        <frame src="<%=request.getContextPath()%>/pages/mainmenujh/frame/right.jsp" name="ebookfrm" scrolling="no" noresize>
      </frameset>
    </frameset>
    <frame src="<%=request.getContextPath()%>/pages/mainmenujh/frame/footBar.jsp"  name="bottomFrame" scrolling="NO" noresize="noresize">
</frameset>
</html>

