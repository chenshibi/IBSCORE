<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.huateng.report.utils.ReportUtils" %>
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>批量导入导出</title>
</head>
<style>
body {
font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif;
color: #4f6b72;
width:50%
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
		String type = ReportUtils.getSysParamsValue("ACT_FILE", "FILE_SUFF");
	%>
	<form action="<%=request.getContextPath()%>/batchImport/upload.spring"
		enctype="multipart/form-data" name="inputform1" id="inputform1"
		method="post" accept-charset="UTF-8">
		<input type="hidden" name="flag" id="flag" value="ZHDR" />
		<input type="hidden" name="filetype" id="filetype" value="<%=type %>" />	
		
		<table id="mytable" cellspacing="0">
			<tr>
				<td id="uploadFile.title"  style="width:20%;text-align:right;height:60px">上传附件：</td>
				<td style="width: 60%;font-size:12px;border:1px solid lightgray" id="fileUpLoad"><input type="file" name="uploadFile"
					id="uploadFile" size="50" value="浏览"> &nbsp;&nbsp;<br>&nbsp;<font
					color="red">(文件格式为*.<%=type %>)</font> &nbsp;&nbsp;&nbsp;
					<% if("XLS".equals(type)){ %>
					<a id="downLoadXLS"href="#" onclick="downLoadXLS()">下载模板</a>
					<%} %>
				</td>
			</tr>
			<tr>
				<td style="width: 40%;text-align:center" colspan="2" ><input value="导入"
					class="btn_width1111" type="button" onClick="return uploadFile1();" name="upload1" id="upload1">
			<!-- 	<input class="btn_width1111" value="返回"
					onclick="javascript:parent.close()" type="button" id ="back"> -->	
					<br>&nbsp;<font  id="msg" style="display:none"
					color="blue">正在导入,请等待......</font>
				</td>

			</tr>
		</table>
	</form>
	<script language="javascript">
	
	
		function StringEndWith(str, b) {
		    var a = new RegExp(b + "$");
		    return a.test(str)
		}
		function uploadFile1() {
			var form = document.forms[0];
			if (form.uploadFile.value == "") {
				alert("请选择上传附件路径！");
				return false;
			}
		    
			var filename = document.getElementById("uploadFile").value;
			var suff = "<%=type%>";
			var suffs = suff.split(',');
			var checkSuff = false;
			var tmpSuff = "";
			for(var i=0;i<suffs.length;i++){
				if(suffs[i]){
					tmpSuff = suffs[i].replace(/(^\s*)|(\s*$)/g, "");
					if(tmpSuff && tmpSuff.length >0){
						if(StringEndWith(filename,tmpSuff)){
							checkSuff = true;
							break;
						}
					}
				}
			}

			if (!checkSuff) {
				alert("文件格式不正确，请上传<%=type%>格式的文件！");
				return false;
			}

			if (navigator.appName == "Microsoft Internet Explorer") {
				if (navigator.appVersion.indexOf("MSIE 6.0") > -1) {
					//IE6
					var maxSize = 5 * 1024 * 1024;//定义允许文件的大小，5M
					var image = new Image();
					image.dynsrc = form.uploadFile.value;
					if (image.fileSize > maxSize) {
						alert("文件大小超出规定限制，请您选择不大于" + maxSize / 1024 / 1024
								+ "M的文件进行上传!");
						return false;
					}
				}
			}

			if (confirm('确定导入文件吗?')) {
				document.getElementById("inputform1").submit();
				document.getElementById("fileUpLoad").disabled="disabled";
				document.getElementById("upload1").disabled="disabled";
				 document.getElementById("msg").style.display="";
				return true;
			} else {
				return false;
			}
		}
		
		//下载报文文件
		function downLoadXLS(){			
			window.location.href = "<%=request.getContextPath()%>/filedownload/DownloadActinfoAction.do";
		}
	</script>
</body>
</html>