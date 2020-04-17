<%@page import="com.huateng.ebank.framework.util.DataFormat"%>
<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base target="_selft">
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Excel</title>
<%
String id = request.getParameter("id");
String errorMsg = (String)request.getAttribute("errorMsg");
String successFlag = (String)request.getAttribute("successFlag");
%>
</head>
<body>
<form action="IndAppUploadAction.do" method="post" enctype="multipart/form-data" name="uploadExcelform" target="checkExcelWindow">
<table align="left" style="padding: 10px;" width="95%">
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">�ļ�λ�ã�&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file"  size="30" >
		</td>
		<td width="10%"></td>
	</tr>
	<tr>
		<td colspan="3" valign="bottom" align="center">
			<input type="button" value="��������" id="subbtn" onclick="return ExcelImport(this);" style="width:80px;height:20px"  >
		</td>
	</tr>
	<tr>
		<td align="left"><br></td>
	</tr>
	<tr>
		<td  align="left" style="font-size: 12px;" id="execWait">
			<%if (!DataFormat.isEmpty(errorMsg)) {%>
			����ԭ��<font color="red"><c:out value='${errorMsg}'/></font>
			<%} %>
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
	window.name = "checkExcelWindow";
	window.returnValue = 0;
	<%if("success".equals(successFlag)){%>
	var count="<c:out value='<%=request.getAttribute("rowCount")%>'/>";
	window.returnValue = count;
	window.close();
	<%}%>
	
	function ExcelImport(obj){
		if(uploadExcelform.file.value == null || uploadExcelform.file.value == ""){
			uploadExcelform.file.focus();
			alert("��ѡ����Ҫ������ļ���");
			return false;
		}else{
			var filePath=uploadExcelform.file.value;
			var arrPath=filePath.split("\\");
			var fileName=arrPath[arrPath.length-1];
			var ext = fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
			if(".xls"== ext || ".xlsx" == ext){
				var id=<c:out value='${id}'/>;
				uploadExcelform.action = "<%=request.getContextPath()%>/IndAppUploadAction.do?id="+id;
				uploadExcelform.submit();
				alert("�����ļ��ɹ���");
				window.location='excelImport.jsp';
				return true;
			}else{
				alert("�ļ���ʽ����ȷ��������.xls��xlsx��β");
				return false;
			}
		}
	}
	
</script>
</body>
</html>