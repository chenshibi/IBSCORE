<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="GB18030"%>
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>��������</title>
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
	
	String fileflag = request.getParameter("fileflag");
	String reportId = request.getParameter("reportId");
	String workDate = request.getParameter("workDate");

	%>
	<form action="<%=request.getContextPath()%>/roundRobinImport/uploadExcel.spring"
		enctype="multipart/form-data" name="inputform1" id="inputform1"
		method="post" accept-charset="UTF-8">
	  <input type="hidden" name="fileflag" id="fileflag"
			value="<%=fileflag%>">
		<input type="hidden" name="reportId" id="reportId"
			value="<%=reportId%>">
		<input type="hidden" name="workDate" id="workDate"
			value="<%=workDate%>">
		<table id="mytable" cellspacing="0">
			<tr>
				<td id="uploadFile.title"  style="width:20%;text-align:right;height:60px">�ϴ�������</td>
				<td style="width: 60%;font-size:12px;border:1px solid lightgray" id="fileUpLoad"><input type="file" name="uploadFile"
					id="uploadFile" size="50" value="���" multiple="multiple"> &nbsp;&nbsp;<br>&nbsp;<font
					color="red">(�ļ���ʽΪ*.xls��*.xlsx)</font>
				</td>
			</tr>
			<tr>
				<td style="width: 40%;text-align:center" colspan="2" ><input value="����"
					class="btn_width1111" type="button" onClick="return uploadFile1();"
					name="upload1" id="upload1">
					<!--  <input class="btn_width1111" value="����"
					onclick="javascript:parent.close()" type="button" id ="back">-->
					<br>&nbsp;<font  id="msg" style="display:none"
					color="blue">���ڵ���,��ȴ�......</font>
				</td>

			</tr>
		</table>
	</form>
	<script language="javascript">
		function uploadFile1() {
			var form = document.forms[0];
			if (form.uploadFile.value == "") {
				alert("��ѡ���ϴ�����·����");
				return false;
			}

			var regex1 = /\.xls$/gi;
			var regex2 = /\.xlsx$/gi;
			if (!regex1.test(document.getElementById("uploadFile").value)&&!regex2.test(document.getElementById("uploadFile").value)) {
				alert("�ļ���ʽ����ȷ�����ϴ�XLS��XLSX��ʽ���ļ���");
				return false;
			}



			if (confirm('ȷ�������ļ���?')) {
				document.getElementById("inputform1").submit();
				//document.getElementById("body").disabled="disabled";
				document.getElementById("fileUpLoad").disabled="disabled";
				document.getElementById("downLoad").disabled="disabled";
				document.getElementById("upload1").disabled="disabled";
				document.getElementById("back").disabled="disabled";
				document.getElementById("msg").style.display="";				
				return true;
			} else {
				return false;
			}
		}

	</script>
</body>
</html>