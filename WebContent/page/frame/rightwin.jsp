<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
</head>

<frameset cols="12px,*" framespacing="1" border="1" frameborder="1" >
 	<frame name="splitols"  id="splitols" src="cols.jsp" frameborder="0"  scrolling="no" noresize>
  	<frame name="main" id="main" src="<%=request.getContextPath()%>/welcome.do" frameborder="0" scrolling="yes"  noresize >
</frameset>

</html>