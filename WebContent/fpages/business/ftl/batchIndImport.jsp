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
		<td width="21%" align="right">批量查询列表上传&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="excelFile1" size="20" >
		</td>
		<td width="10%"></td>
	</tr>
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">批量查询列表上传&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="excelFile2" size="20" >
		</td>
		<td width="10%"></td>
	</tr>
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">批量查询列表上传&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="excelFile3" size="20" >
		</td>
		<td width="10%"></td>
	</tr>
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">批量查询列表上传&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="excelFile4" size="20" >
		</td>
		<td width="10%"></td>
	</tr>
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">批量查询列表上传&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="excelFile5" size="20" >
		</td>
		<td width="10%"></td>
	</tr>
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">批量查询列表上传&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="excelFile6" size="20" >
		</td>
		<td width="10%"></td>
	</tr>
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">批量查询列表上传&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="excelFile7" size="20" >
		</td>
		<td width="10%"></td>
	</tr>
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">批量查询列表上传&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="excelFile8" size="20" >
		</td>
		<td width="10%"></td>
	</tr>
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">批量查询列表上传&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="excelFile9" size="20" >
		</td>
		<td width="10%"></td>
	</tr>
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">批量查询列表上传&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="excelFile10" size="20" >
		</td>
		<td width="10%"></td>
	</tr>
	<tr>
	<td width="15%"></td>
		<td width="21%" align="right">&nbsp;</td>
		
	</tr>
	<tr style="">
		<td width="15%"></td>
		<td width="21%" align="right">主管批复文件上传&nbsp;</td>
		<td width="54%">
			<input type="file"  name="file" id="uploadFile"  size="20" >
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
<script type="text/javascript">

	window.name = "checkExcelWindow";
	window.returnValue = 0;
	<%if("success".equals(successFlag)){%>
    var count="<c:out value='<%=request.getAttribute("rowCount")%>'/>";
	window.returnValue = count;
	window.close();
	<%}%>
	

	function ExcelImport(obj){
		var excelFile1=document.getElementById("excelFile1").value;
		var excelFile2=document.getElementById("excelFile2").value;
		var excelFile3=document.getElementById("excelFile3").value;
		var excelFile4=document.getElementById("excelFile4").value;
		var excelFile5=document.getElementById("excelFile5").value;
		var excelFile6=document.getElementById("excelFile6").value;
		var excelFile7=document.getElementById("excelFile7").value;
		var excelFile8=document.getElementById("excelFile8").value;
		var excelFile9=document.getElementById("excelFile9").value;
		var excelFile10=document.getElementById("excelFile10").value;
		var uploadFile=document.getElementById("uploadFile").value;
		var excelFileList = [excelFile1,excelFile2,excelFile3,excelFile4,excelFile5,excelFile6,excelFile7,excelFile8,excelFile9,excelFile10];
		if((excelFile1 == null || excelFile1 == "")&&(excelFile2 == null || excelFile2 == "")
				&&(excelFile3 == null || excelFile3 == "")&&(excelFile4 == null || excelFile4 == "")
				&&(excelFile5 == null || excelFile5 == "")&&(excelFile6 == null || excelFile6 == "")
				&&(excelFile7 == null || excelFile7 == "")&&(excelFile8 == null || excelFile8 == "")
				&&(excelFile9 == null || excelFile9 == "")&&(excelFile10 == null || excelFile10 == "")){
			alert("请选择所要导入的EXCEL文件！");
			return false;
		
		}else if(uploadFile==null || uploadFile==""){	
			alert("请选择所要导入的主管批复文件！");
			return false;
		}else{
			for(var i=0;i<10;i++){
			if(excelFileList[i]!=null && excelFileList[i]!=""){
			var arrPath=excelFileList[i].split("\\");
			var fileName=arrPath[arrPath.length-1];
			var ext = fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
			if(".xls"== ext || ".xlsx" == ext){
			}else{
				alert("excel文件格式不正确，必须以.xls或xlsx结尾");
				return false;
			     }
			  }
			 }
		}
		uploadExcelform.action = "<%=request.getContextPath()%>/BatchIndAction.do";
		uploadExcelform.submit();
		alert("提交成功,正在导入......");
		if(flag == true)
		window.location='batchIndImport.jsp';
		return true;
	}
	function downLoad(obj){
		uploadExcelform.action = "<%=request.getContextPath()%>/IndDownloadAction.do";
		uploadExcelform.submit();
		//alert("下载成功");
	}
</script>
</body>
</html>