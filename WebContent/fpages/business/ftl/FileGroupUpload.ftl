<#global contextPath = contextPath>
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="文件上传功能">
<@CommonQueryMacro.CommonQuery id="FileGroupUpload" init="true" submitMode="all" navigate="false">

	<table align="center" width="100%">
    	<tr>
			<td width="100%" align="left">
				<@CommonQueryMacro.Group id="group1" label="文件上传功能"  fieldStr="sgement,product,scope,note,effectiveDate,expireDate,flag" colNm=1 /></br>
			</td>
		</tr>
	</table> 
</@CommonQueryMacro.CommonQuery>
		
		
<table width="57%">
		<tr>
			<form id="uploadFileForm" name="myform" action="${contextPath}/FileGroupUploadServlet" method="post" enctype="multipart/form-data" charset="utf-8">
				<td width="50%"></td>
				<td width="30%" align="right">需要上传的文件&nbsp</td>
				<td width="30%">
					<input type="file"    name="filePath" id="uploadPermitFile"  size="20"  >
					<input type="hidden"  name="form_sgement" id="form_sgement"  size="30" >
					<input type="hidden"  name="form_product" id="form_product"  size="30" >
					<input type="hidden"  name="form_scope" id="form_scope"  size="30" >
					<input type="hidden"  name="form_note" id="form_note"  size="30" >
					<input type="hidden"  name="form_effectiveDate" id="form_effectiveDate"  size="30" >
					<input type="hidden"  name="form_expireDate" id="form_expireDate"  size="30" >
					<input type="hidden"  name="form_flag" id="form_flag"  size="30" >
				</td>
			</form>
		</tr>
</table>
			
<@CommonQueryMacro.CommonQuery id="FileGroupUpload" init="true" submitMode="all" navigate="false">
<table width="100%"  >
			 	<tr>
    		<td colspan="2" align="center">
				<@CommonQueryMacro.Button id= "btSave"/>
				
    		</td>
    	</tr>	
			</table>
</@CommonQueryMacro.CommonQuery>
    	
    

<script language="JavaScript">	
	 
	function btSave_onClickCheck(button){
	 
		
		var filePath=document.getElementById("uploadPermitFile").value;
		
		var sgement=FileGroupUpload_dataset.getValue("sgement");
		var product=FileGroupUpload_dataset.getValue("product");
		var scope=FileGroupUpload_dataset.getValue("scope");
		var note=FileGroupUpload_dataset.getValue("note");
		var effectiveDate=FileGroupUpload_dataset.getValue("effectiveDate").format("yyyyMMdd");
		var expireDate=FileGroupUpload_dataset.getValue("expireDate").format("yyyyMMdd");
		var flag=FileGroupUpload_dataset.getValue("flag");
		
		var reg=/^[\s ]|[ ]$/gi;
	 
	 
		
		if("" == filePath){
			alert("请对内容进行修改后再进行提交！");
			return false;
		}
		 
		 
		document.getElementById("form_sgement").value =  sgement;
		document.getElementById("form_product").value =  product;
		document.getElementById("form_scope").value =  scope;
		document.getElementById("form_note").value =  note;
		document.getElementById("form_effectiveDate").value =  effectiveDate;
		document.getElementById("form_expireDate").value =  expireDate;
		document.getElementById("form_flag").value =  flag;
		
	 
		document.getElementById("uploadFileForm").submit();
		alert("提交成功！");
		return false;
	}
	
	
	
</script>
</@CommonQueryMacro.page>