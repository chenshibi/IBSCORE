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
String flag = (String)request.getAttribute("flag");
String errorMsg = (String)request.getAttribute("errorMsg");
String successFlag = (String)request.getAttribute("successFlag");
%>
</head>
<body>
<form action="BatchCorpLoancardAction.do" method="post" enctype="multipart/form-data" name="uploadExcelform" target="checkExcelWindow">
<table align="center" style="padding: 10px;" width="95%">
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">��֤���ļ��ϴ�&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="excelFile" size="20" >
		</td>
		<td width="10%"></td>
	</tr>
	<table  align=center width="21%">
		<tr >
			<td  valign="bottom" >
				<input type="button" value="�ύ" id="subbtn" onclick="return ExcelImport(this);" style="width:50px;height:20px">
				<input type="button" value="�����ļ�template����" id="subbtn" onclick="return downLoad(this);" style="width:160px;height:20px">
			</td>
		</tr>
	</table>
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
	
	alert(flag);
	
	function ExcelImport(obj){
		var excelFile=document.getElementById("excelFile").value;
		if(excelFile == null || excelFile == ""){
			alert("��ѡ����Ҫ�����EXCEL�ļ���");
			return false;
		
		}else{
			var arrPath=excelFile.split("\\");
			var fileName=arrPath[arrPath.length-1];
			var ext = fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
			if(".xls"== ext || ".xlsx" == ext){
					uploadExcelform.action = "<%=request.getContextPath()%>/BatchCorpLoancardAction.do";
					uploadExcelform.submit();
						alert("�ύ�ɹ�,���ڵ���......");
					if(flag == true){
					}
					window.location='batchCorpImport.jsp';
					return true;
				
			}else{
				alert("excel�ļ���ʽ����ȷ��������.xls��xlsx��β");
				return false;
			}
		}
	}
	function downLoad(obj){
		uploadExcelform.action = "<%=request.getContextPath()%>/CorpLoancardDownloadAction.do";
		uploadExcelform.submit();
		//alert("���سɹ�");
	}
</script>
</body>
</html>