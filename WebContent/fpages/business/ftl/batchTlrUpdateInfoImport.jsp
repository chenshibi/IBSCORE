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
<form action="IndAppUploadAction.do" method="post" enctype="multipart/form-data" name="uploadExcelform" target="checkExcelWindow">
<table align="center" style="padding: 10px;" width="95%">
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">批量用户信息上传&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="excelFile" size="20" >
		</td>
		<td width="10%"></td>
	</tr>
	
	<table width="30%" align=center>
		<tr >
			<td  valign="bottom" >
				<input type="button" value="提交" id="subbtn" onclick="return ExcelImport(this);" style="width:50px;height:20px">
				<input type="button" value="批量文件template下载" id="subbtn" onclick="return downLoad(this);" style="width:160px;height:20px">
			</td>
		</tr>
	</table>
	<tr>
		<td align="left"><br></td>
	</tr>
	<tr>
		<td  align="left" style="font-size: 12px;" id="execWait">
			<%if (!DataFormat.isEmpty(errorMsg)) {%>
			错误原因：<font color="red"><c:out value='${errorMsg}'/></font>
			<%} %>
		</td>
	</tr>
</table>
</form>
<form action="IndAppUploadAction.do" method="post" enctype="multipart/form-data" name="uploadMatrixform" target="_self">
<table align="center" style="padding: 10px;" width="95%">
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">Role and Menu Matrix上传&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="matrixFile" size="20" >
		</td>
		<td width="10%"></td>
	</tr>
	
	<table width="30%" align=center>
		<tr >
			<td  valign="bottom" >
				<input type="button" value="提交" id="subbtn" onclick="return MatrixImport(this);" style="width:50px;height:20px">
			</td>
		</tr>
	</table>
	<tr>
		<td align="left"><br></td>
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
			alert("请选择所要导入的批量查询列表文件！");
			return false;
		
		}else{
			var arrPath=excelFile.split("\\");
			var fileName=arrPath[arrPath.length-1];
			var ext = fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
			if(".xls"== ext || ".xlsx" == ext){
					uploadExcelform.action = "<%=request.getContextPath()%>/BatchTlrUpdateInfoAction.do";
					uploadExcelform.submit();
						alert("提交成功,正在导入......");
					if(flag == true){
					}
					window.location='batchTlrUpdateInfoImport.jsp';
					return true;
				
			}else{
				alert("excel文件格式不正确，必须以.xls或xlsx结尾");
				return false;
			}
		}
	}
	
	function downLoad(obj){
		uploadExcelform.action = "<%=request.getContextPath()%>/BatchDownLoadTlrUpdateInfoAction.do";
		uploadExcelform.submit();
		//alert("下载成功");
	}
	
	function MatrixImport(obj){
		var matrixFile=document.getElementById("matrixFile").value;
		var arrPath=matrixFile.split("\\");
		var fileName=arrPath[arrPath.length-1];
		var ext = fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
		if(".xls"== ext ){
			if(matrixFile == null || matrixFile == ""){
				alert("请选择所要导入的文件！");
				return false;
			
			}else{
				uploadMatrixform.action = "<%=request.getContextPath()%>/MatrixUploadAction.do";
				uploadMatrixform.submit();
				alert("提交成功,正在导入......");
				window.location='batchTlrUpdateInfoImport.jsp';
						return false;
			}
		}else{
			alert("excel文件格式不正确，必须以.xls结尾");
			return false;
		}
	}
	
</script>
</body>
</html>