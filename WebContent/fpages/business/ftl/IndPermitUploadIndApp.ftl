<#global contextPath = contextPath>
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="个人征信查询许可文件上传">


<@CommonQueryMacro.CommonQuery id="IndPermitUploadIndApp" init="true" submitMode="all" navigate="false">

	<table align="center" width="100%">
    	<tr>
			<td width="100%" align="left">
				<@CommonQueryMacro.Group id="group1" label="个人征信查询许可文件上传"  fieldStr="name,individualId,idType,expireDate" colNm=1 /></br>
			</td>
		</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
		
		
<table width="57%">
		<tr>
			<form id="uploadFileForm" name="myform" action="${contextPath}/PermitUploadServlet" method="post" enctype="multipart/form-data" charset=utf-8>
				<td width="50%"></td>
				<td width="30%" align="right">许可证文件&nbsp</td>
				<td width="30%">
					<input type="file"  name="filePath" id="uploadPermitFile"  size="20"  >
					<input type="hidden"  name="form_name" id="form_name"  size="30" >
					<input type="hidden"  name="form_individualId" id="form_individualId"  size="30" >
					<input type="hidden"  name="form_idType" id="form_idType"  size="30" >
					<input type="hidden"  name="form_expireDate" id="form_expireDate"  size="30" >
				</td>
			</form>
		</tr>
</table>
			
<@CommonQueryMacro.CommonQuery id="IndPermitUploadIndApp" init="true" submitMode="all" navigate="false">
		<table align="center">
			<tr>
    			<td width="50%">
					<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;  
    			</td>
    		</tr>
    	</table>
</@CommonQueryMacro.CommonQuery>
    	
    

<script language="JavaScript">	
	
	

	function btSave_onClickCheck(button){
		var name=IndPermitUpload_dataset.getValue("name");
		var individualId=IndPermitUpload_dataset.getValue("individualId");
		var idType=IndPermitUpload_dataset.getValue("idType");
		if("" ==name || "" == individualId || "" ==idType ){
			alert("请对内容进行修改后再进行提交！");
			return false;
		}
		document.getElementById("form_name").value = name
		document.getElementById("form_individualId").value = individualId
		document.getElementById("form_idType").value = idType
		document.getElementById("form_expireDate").value = IndPermitUpload_dataset.getValue("expireDate").format("yyyyMMdd");
		document.getElementById("uploadFileForm").submit();
		alert("提交成功！");
		return false;
	}
	
</script>
</@CommonQueryMacro.page>