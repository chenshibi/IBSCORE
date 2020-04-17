<#global contextPath = contextPath>
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="个人征信查询授权书上传">


<@CommonQueryMacro.CommonQuery id="IndPermitUpload" init="true" submitMode="all" navigate="false">

	<table align="center" width="100%">
    	<tr>
			<td width="100%" align="left">
				<@CommonQueryMacro.Group id="group1" label="个人征信查询授权书上传"  fieldStr="name,individualId,idType,approveTime,expireDate" colNm=1 /></br>
			</td>
		</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
		
		
<table width="57%">
		<tr>
			<form id="uploadFileForm" name="myform" action="${contextPath}/PermitUploadServlet" method="post" enctype="multipart/form-data" charset="utf-8">
				<td width="50%"></td>
				<td width="30%" align="right">查询授权书&nbsp</td>
				<td width="30%">
					<input type="file"  name="filePath" id="uploadPermitFile"  size="20"  >
					<input type="hidden"  name="form_name" id="form_name"  size="30" >
					<input type="hidden"  name="form_individualId" id="form_individualId"  size="30" >
					<input type="hidden"  name="form_idType" id="form_idType"  size="30" >
					<input type="hidden"  name="form_expireDate" id="form_expireDate"  size="30" >
					<input type="hidden"  name="form_approveTime" id="form_approveTime"  size="30" >
				</td>
			</form>
		</tr>
</table>
			
<@CommonQueryMacro.CommonQuery id="IndPermitUpload" init="true" submitMode="all" navigate="false">
<table width="100%"  >
			 	<tr>
    		<td colspan="2" align="center">
				<@CommonQueryMacro.Button id= "btSave"/>
				
    		</td>
    	</tr>	
			</table>
</@CommonQueryMacro.CommonQuery>
    	
    

<script language="JavaScript">	
	function initCallGetter_post(dataset) {
		var date = new Date();
		var month = date.getMonth()+1;
		var year=date.getFullYear()+82;
		var fullYear=date.getFullYear();
		var currentDate = year+"/"+month+"/"+date.getDate();
		var approveTime = fullYear+"/"+month+"/"+date.getDate();
	//	var currentDate = year+"/"+month+"/"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
		IndPermitUpload_dataset.setValue("expireDate",currentDate);
		IndPermitUpload_dataset.setValue("approveTime",approveTime);
	}
	function btSave_onClickCheck(button){
		var name=IndPermitUpload_dataset.getValue("name");
		var individualId=IndPermitUpload_dataset.getValue("individualId");
		var idType=IndPermitUpload_dataset.getValue("idType");
		var filePath=document.getElementById("uploadPermitFile").value;
		
		var reg=/^[\s ]|[ ]$/gi;
		if(reg.test(name)){
			alert("姓名开头或者结尾处存在空格！");
			return false;
		}
		if(reg.test(individualId)){
			alert("证件号码开头或者结尾处存在空格！");
			return false;
		}
		
		if("" ==name || "" == individualId || "" ==idType || "" == filePath){
			alert("请对内容进行修改后再进行提交！");
			return false;
		}
		document.getElementById("form_name").value = name;
		document.getElementById("form_individualId").value = individualId;
		document.getElementById("form_idType").value = idType;
		document.getElementById("form_expireDate").value = IndPermitUpload_dataset.getValue("expireDate").format("yyyyMMdd");
		document.getElementById("form_approveTime").value = IndPermitUpload_dataset.getValue("approveTime").format("yyyyMMdd");
		document.getElementById("uploadFileForm").submit();
		alert("提交成功！");
		return false;
	}
	
	
	
</script>
</@CommonQueryMacro.page>