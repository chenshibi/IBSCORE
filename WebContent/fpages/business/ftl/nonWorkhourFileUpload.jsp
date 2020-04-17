<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>上传附件</title>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()%>/templets/ui/js/report.js?version=21"></script>
</head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/templets/lib/themes/ocean/extra.css">
<style>
</style>
<body>
	<br/>
	<br/>
	<input type="hidden"  id="BackTxt"  value="${filePath }" size="30" >
	<table width="57%">
		<tr>
			<form id="uploadFileForm" name="myform" onsubmit="return checkNull()" action="<%=request.getContextPath()%>/nonWorkhourFileUploadServlet" method="post" enctype="multipart/form-data" charset=utf-8>
				<td width="50%"></td>
				<td width="30%" align="right">主管查询授权书&nbsp</td>
				<td width="30%">
			     <input type="file"  name="filePath" id="uploadFile"  size="20" >
				 <input id="btSave"  type="submit" class="button" value="上传" />	
				 <input id="btSave1" type="button" class="button" value="提交" onclick="returnback()"/>	
				</td>
			</form>
		</tr>
</table>
</body>
<script type="text/javascript">
function checkNull(){
	var filepath = document.getElementById("uploadFile").value;
	var usern = /^[a-zA-Z0-9:\\\\.]{1,}$/; 
	
	if(!filepath.match(usern)){
		alert("文件名只能用字母数字！");
		return flase;
	}
	if(document.getElementById("uploadFile").value==""||document.getElementById("uploadFile").value==null){
		alert("不能为空！");
		return flase;
	}else{
		alert('上传成功');
	}
}
function returnback(){
	if(document.getElementById("BackTxt").value==""||document.getElementById("BackTxt").value==null){
		alert("没有上传文件！");
		return flase;
	}else{
		returnWin();
		closeWin();	
	}
}
Request = {
	QueryString : function(item){
		var svalue = location.search.match(new RegExp("[\?\&]" + item + "=([^\&]*)(\&?)","i"));
		return svalue ? svalue[1] : svalue;
	}
}
var postForm = document.getElementById("postForm");
postForm.action+="?id="+Request.QueryString("id")+"&fileType="+Request.QueryString("fileType");
</script>
</html>