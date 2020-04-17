<#global contextPath = contextPath>
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="个人征信查询信息上传">


<@CommonQueryMacro.CommonQuery id="IndPermitUploadN" init="true" submitMode="all" navigate="false">

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
			<form id="uploadFileForm" name="myform" action="${contextPath}/PermitUploadServletN" method="post" enctype="multipart/form-data" charset="utf-8">
				<td width="50%"></td>
				<td width="30%" align="right">查询授权书&nbsp</td>
				<td width="30%">
					<input type="file"  name="filePath" id="uploadPermitFile"  size="20"  >
					<input type="hidden"  name="form_id" id="form_id"  size="30" >
					<input type="hidden"  name="form_name" id="form_name"  size="30" >
					<input type="hidden"  name="form_individualId" id="form_individualId"  size="30" >
					<input type="hidden"  name="form_idType" id="form_idType"  size="30" >
					<input type="hidden"  name="form_expireDate" id="form_expireDate"  size="30" >
					<input type="hidden"  name="form_approveTime" id="form_approveTime"  size="30" >
				</td>
			</form>
		</tr>
</table>
			
<@CommonQueryMacro.CommonQuery id="IndPermitUploadN" init="true" submitMode="all" navigate="false">
<table align="center">
			<tr>
    			<td width="50%">
					<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;  
    			</td>
    		</tr>
    	</table>
</@CommonQueryMacro.CommonQuery>
    	
    

<script language="JavaScript">	

function initCallGetter_post(dataset) {
    var id=IndPermitUploadN_dataset.getParameter("id");
	var name=IndPermitUploadN_dataset.getParameter("name");
	name=decodeURI(decodeURI(name));
	var individualId=IndPermitUploadN_dataset.getParameter("individualId");
	individualId=decodeURI(decodeURI(individualId));
	var idType=IndPermitUploadN_dataset.getParameter("idType");
  //  var flag=IndPermitUploadN_dataset.getParameter("skip");
	IndPermitUploadN_dataset.setValue("id",id);
	IndPermitUploadN_dataset.setValue("name",name);
	IndPermitUploadN_dataset.setValue("individualId",individualId);
	IndPermitUploadN_dataset.setValue("idType",idType);
 //   IndPermitUploadN_dataset.setValue("flag",flag);
	var date = new Date();
	var month = date.getMonth()+1;
	var year=2099;
	var currentDate = year+"/"+month+"/"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	var approveTime=date.getFullYear()+"/"+month+"/"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	IndPermitUploadN_dataset.setValue("expireDate",currentDate);
	IndPermitUploadN_dataset.setValue("approveTime",approveTime);
}
	

	function btSave_onClickCheck(button){
	    var id=IndPermitUploadN_dataset.getValue("id");
		var name=IndPermitUploadN_dataset.getValue("name");
		var individualId=IndPermitUploadN_dataset.getValue("individualId");
		var idType=IndPermitUploadN_dataset.getValue("idType");
		var filePath=document.getElementById("uploadPermitFile").value;
	//	var flag=IndPermitUploadN_dataset.getValue("flag");
		if("" ==name || "" == individualId || "" ==idType || "" == filePath){
			alert("请对内容进行修改后再进行提交！");
			return false;
		}
		document.getElementById("form_id").value = id;
		document.getElementById("form_name").value = name;
		document.getElementById("form_individualId").value = individualId;
		document.getElementById("form_idType").value = idType;
		document.getElementById("form_expireDate").value = IndPermitUploadN_dataset.getValue("expireDate").format("yyyyMMdd");
		document.getElementById("form_approveTime").value = IndPermitUploadN_dataset.getValue("approveTime").format("yyyyMMdd");
		
		document.getElementById("uploadFileForm").submit();
        alert("提交成功");
     //   if("P"==flag){
    //        window.location.href="${contextPath}/fpages/crms/ftl/CrmsBatchQueryCorpReport.ftl";
    //    }
        return false;
	}
	
	
</script>
</@CommonQueryMacro.page>