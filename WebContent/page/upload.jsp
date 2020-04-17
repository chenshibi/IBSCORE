<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>批量导入</title>
</head>
<style>
body{
	margin:0px auto;
	text-align:center;
}
</style>
<body>
	<br/>
	<br/>
	<form method="POST" enctype="multipart/form-data" id="postForm"
		action="<%=request.getContextPath()%>/ExcelUploadServlet" target="_self">
		<input type="file" name="filename"></input>
		<input type="submit" />
	</form>
</body>
<script type="text/javascript">
Request = {
	QueryString : function(item){
		var svalue = location.search.match(new RegExp("[\?\&]" + item + "=([^\&]*)(\&?)","i"));
		return svalue ? svalue[1] : svalue;
	}
}
var postForm = document.getElementById("postForm");
postForm.action+="?contractId="+Request.QueryString("contractId");

</script>
</html>