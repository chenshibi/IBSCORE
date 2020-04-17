<#global contextPath = contextPath>
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="个人征信查询许可文件上传">

<table width="57%">
		<tr>
			<form id="uploadFileForm" name="myform" action="${contextPath}/nonWorkhourFileUploadServlet" method="post" enctype="multipart/form-data" charset=utf-8>
				<td width="50%"></td>
				<td width="30%" align="right">许可证文件&nbsp</td>
				<td width="30%">
					<input type="file"  name="filePath" id="uploadFile"  size="20" >
				<input type="text"  name="openertext" id="BackTxt"  value=filePath size="30" >   	
				</td>
			</form>
		</tr>
</table>
			
<@CommonQueryMacro.CommonQuery id="IndPermitUpload" init="true" submitMode="all" navigate="false">
		<table align="center">
			<tr>
    			<td width="50%">
					<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;  
    			</td>
    		</tr>
    	</table>
</@CommonQueryMacro.CommonQuery>
    	
    

<script language="JavaScript">	
	
String  filePath=request.getAttribute("filePath");	

	function btSave_onClickCheck(button){
	
		var filePath=document.getElementById("uploadFile").value;
		if(""==filePath){
			alert("不能为空！");
			return false;
		}
			returnWin();
			closeWin();
	}
	function btSave_postSubmit(button){
	
		document.getElementById("uploadFileForm").submit();
		alert("提交成功！");
	}
</script>
</@CommonQueryMacro.page>