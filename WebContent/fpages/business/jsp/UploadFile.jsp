<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="GB18030"%>
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>公共文件上传</title>
</head>
<style>
body {
font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
color: #4f6b72;
}
#mytable {
width: 100%;
padding: 0;
margin: 0;
}
td{
padding: 0;
margin: 0;
height:40px;
border:1px solid #ccc;
}
tr{
padding: 0;
margin: 0;

}

</style>
<body id="body">
	<%
	String dp = request.getParameter("department");
	%>
	<form id="uploadFileForm" name="myform" action="<%=request.getContextPath()%>/commFileGroupUpload/uploadExcel.spring" method="post" enctype="multipart/form-data" method="post" accept-charset="UTF-8">
	 <input type="hidden" name="department" id="department"
			value="<%=dp%>">
		<table id="mytable" cellspacing="0">
			<tr>
				<td id="uploadFile.title"  style="width:20%;text-align:right;height:60px">上传附件：</td>
				<td style="width: 60%;font-size:12px;border:1px solid lightgray" id="fileUpLoad"><input type="file" name="uploadFile"
					id="uploadFile" size="50" value="浏览" multiple="multiple"> &nbsp;&nbsp;<br>&nbsp;<font
					color="red"></font>
				</td>
			</tr>
			<tr>
				<td style="width: 40%;text-align:center" colspan="2" ><input value="提交"
					class="btn_width1111" type="button" onClick="return uploadFile1();"
					name="upload1" id="upload1">
					<br>&nbsp;<font  id="msg" style="display:none"
					color="blue">正在提交,请等待......</font>
				</td>
			</tr>
		</table>
	</form>
	<script language="javascript">
		function uploadFile1() {
			var form = document.forms[0];
			if (form.uploadFile.value == "") {
				alert("请选择上传附件路径！");
				return false;
			}
			var filePath=document.getElementById("uploadFile").value;
			var fileName = filePath.substring(filePath.lastIndexOf("\\") + 1);
			if (confirm('确定上传文件吗?')) {
				document.getElementById("uploadFileForm").submit();
				document.getElementById("fileUpLoad").disabled="disabled";
				document.getElementById("upload1").disabled="disabled";
				document.getElementById("msg").style.display="";				
				return true;
			} else {
				return false;
			}
		}

	</script>
</body>
</html>