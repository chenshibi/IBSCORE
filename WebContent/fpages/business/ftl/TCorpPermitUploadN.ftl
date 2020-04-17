<#global contextPath = contextPath>
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="企业征信查询查询授权书上传">


<@CommonQueryMacro.CommonQuery id="TCorpPermitUploadN" init="true" submitMode="all" navigate="false">

	<table align="center" width="100%">
    	<tr>
			<td width="100%" align="left">
				<@CommonQueryMacro.Group id="group1" label="企业征信查询授权书上传"  fieldStr="loanCardNo,loanCardPass,enterpriseRegId,corpName,approveTime,expireDate" colNm=1 /></br>
			</td>
			
		</tr>
		</table>
</@CommonQueryMacro.CommonQuery>
		
		
<table width="57%">
		<tr>
			<form id="uploadFileForm" action="${contextPath}/TcorpPermitUploadServletN" method="post" enctype="multipart/form-data">
				<td width="50%"></td>
				<td width="30%" align="right">查询授权书&nbsp</td>
				<td width="30%">
					<input type="file"    name="file" id="uploadPermitFile"  size="20" >
					<input type="hidden"  name="form_loanCardNo" id="form_loanCardNo" >
					<input type="hidden"  name="form_loanCardPass" id="form_loanCardPass"   >
					<input type="hidden"  name="form_enterpriseRegId" id="form_enterpriseRegId" >
					<input type="hidden"  name="form_corpName" id="form_corpName"  >
					<input type="hidden"  name="form_expireDate" id="form_expireDate" >
					<input type="hidden"  name="form_approveTime" id="form_approveTime" >
				</td>
			</form>
		</tr>
</table>
			
<@CommonQueryMacro.CommonQuery id="TCorpPermitUploadN" init="true" submitMode="all" navigate="false">
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
	var loanCardNo=TCorpPermitUploadN_dataset.getParameter("corpCustLoancard");
	var loanCardPass=TCorpPermitUploadN_dataset.getParameter("corpCustPswd");
	var corpName=TCorpPermitUploadN_dataset.getParameter("corpCustCompanyname");
	loanCardNo = decodeURI(decodeURI(loanCardNo));
	loanCardPass = decodeURI(decodeURI(loanCardPass));
	corpName = decodeURI(decodeURI(corpName));
	TCorpPermitUploadN_dataset.setValue("loanCardNo",loanCardNo);
	TCorpPermitUploadN_dataset.setValue("loanCardPass",loanCardPass);
	TCorpPermitUploadN_dataset.setValue("corpName",corpName);



	var date = new Date();
	var month = date.getMonth()+1;
	var year=2099;
	var currentDate = year+"/"+month+"/"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	var approveTime=date.getFullYear()+"/"+month+"/"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	TCorpPermitUploadN_dataset.setValue("expireDate",currentDate);
	TCorpPermitUploadN_dataset.setValue("approveTime",approveTime);
}
	
	function btSave_onClickCheck(button){
		var loanCardNo= TCorpPermitUploadN_dataset.getValue("loanCardNo");
		var loanCardPass=TCorpPermitUploadN_dataset.getValue("loanCardPass");
		var enterpriseRegId= TCorpPermitUploadN_dataset.getValue("enterpriseRegId");
		var corpName= TCorpPermitUploadN_dataset.getValue("corpName");
		var filePath=document.getElementById("uploadPermitFile").value;
		if("" ==loanCardNo || ""==corpName || ""==filePath){
			alert("请对内容进行修改后再进行提交！");
			return false;
		}
		document.getElementById("form_loanCardNo").value = loanCardNo;
		document.getElementById("form_loanCardPass").value = loanCardPass;
		document.getElementById("form_enterpriseRegId").value = enterpriseRegId;
		document.getElementById("form_corpName").value = corpName;
		document.getElementById("form_expireDate").value = TCorpPermitUploadN_dataset.getValue("expireDate").format("yyyyMMdd");
		document.getElementById("form_approveTime").value = TCorpPermitUploadN_dataset.getValue("approveTime").format("yyyyMMdd");
		document.getElementById("uploadFileForm").submit();
		alert("提交成功！");
		return false;
	}
	
</script>
</@CommonQueryMacro.page>