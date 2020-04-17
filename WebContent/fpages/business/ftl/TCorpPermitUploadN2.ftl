<#global contextPath = contextPath>
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="企业征信查询查询授权书上传">


<@CommonQueryMacro.CommonQuery id="TCorpPermitUploadN2" init="true" submitMode="all" navigate="false">

	<table align="center" width="100%">
    	<tr>
			<td width="100%" align="left">
				<@CommonQueryMacro.Group id="group1" label="二代企业征信查询授权书上传"  fieldStr="loanCardNo,loanCardPass,enterpriseRegId,corpName,approveTime,expireDate" colNm=1 /></br>
			</td>
			
		</tr>
		</table>
</@CommonQueryMacro.CommonQuery>
		
		
<table width="57%">
		<tr>
			<form id="uploadFileForm" action="${contextPath}/TcorpPermitUploadServletN2" method="post" enctype="multipart/form-data">
				<td width="50%"></td>
				<td width="30%" align="right">查询授权书&nbsp</td>
				<td width="30%">
					<input type="file"  name="file" id="uploadPermitFile"  size="20" >
					<input type="hidden"  name="form_loanCardNo" id="form_loanCardNo" >
					<input type="hidden"  name="form_loanCardPass" id="form_loanCardPass" >
					<input type="hidden"  name="form_enterpriseRegId" id="form_enterpriseRegId" >
					<input type="hidden"  name="form_corpName" id="form_corpName"  >
					<input type="hidden"  name="form_expireDate" id="form_expireDate" >
					<input type="hidden"  name="form_approveTime" id="form_approveTime" >
					<input type="hidden"  name="form_pbocEntId" id="form_pbocEntId" >
				</td>
			</form>
		</tr>
</table>
			
<@CommonQueryMacro.CommonQuery id="TCorpPermitUploadN2" init="true" submitMode="all" navigate="false">
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
    var id=TCorpPermitUploadN2_dataset.getParameter("id");
    var entCertType=TCorpPermitUploadN2_dataset.getParameter("type");
	var loanCardNo=TCorpPermitUploadN2_dataset.getParameter("corpCustLoancard");
	var corpName=TCorpPermitUploadN2_dataset.getParameter("corpCustCompanyname");
//	var entCertType=TCorpPermitUploadN2_dataset.getParameter("corpCustLoancard");
//	var flag=TCorpPermitUploadN2_dataset.getParameter("skip");
	corpName = decodeURI(decodeURI(corpName));
	if("10"==entCertType){
	     TCorpPermitUploadN2_dataset.setValue("loanCardNo",loanCardNo);
	 }else{
	     TCorpPermitUploadN2_dataset.setValue("enterpriseRegId",loanCardNo);
	 }
	TCorpPermitUploadN2_dataset.setValue("entCertType",entCertType);
	TCorpPermitUploadN2_dataset.setValue("corpName",corpName);
    TCorpPermitUploadN2_dataset.setValue("id",id)
	var date = new Date();
	var month = date.getMonth()+1;
	var year=2099;
	var currentDate = year+"/"+month+"/"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	var approveTime=date.getFullYear()+"/"+month+"/"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	TCorpPermitUploadN2_dataset.setValue("expireDate",currentDate);
	TCorpPermitUploadN2_dataset.setValue("approveTime",approveTime);
}
	
	function btSave_onClickCheck(button){
	    var id=TCorpPermitUploadN2_dataset.getValue("id");
		var loanCardNo= TCorpPermitUploadN2_dataset.getValue("loanCardNo");
		var enterpriseRegId= TCorpPermitUploadN2_dataset.getValue("enterpriseRegId");
		var corpName= TCorpPermitUploadN2_dataset.getValue("corpName");
		var filePath=document.getElementById("uploadPermitFile").value;
		var type=TCorpPermitUploadN2_dataset.getValue("entCertType");
		var loanCardPass=TCorpPermitUploadN2_dataset.getValue("loanCardPass");
		if("" ==loanCardNo || ""==corpName || ""==filePath){
			alert("请对内容进行修改后再进行提交！");
			return false;
		}
		if("10"==type){
		    if(loanCardNo.length>16){
		        alert("中征码长度不可以大于16位");
		        return false;
		    }
		}
		if("30"==type){
		    if(enterpriseRegId.length>12){
		        alert("组织码长度不可以大于12位");
		        return false;
		    }
		}
		document.getElementById("form_pbocEntId").value = id;
		document.getElementById("form_loanCardNo").value = loanCardNo;
		document.getElementById("form_enterpriseRegId").value = enterpriseRegId;
		document.getElementById("form_loanCardPass").value = loanCardPass;
		document.getElementById("form_corpName").value = corpName;
		document.getElementById("form_expireDate").value = TCorpPermitUploadN2_dataset.getValue("expireDate").format("yyyyMMdd");
		document.getElementById("form_approveTime").value = TCorpPermitUploadN2_dataset.getValue("approveTime").format("yyyyMMdd");
		document.getElementById("uploadFileForm").submit();
		alert("提交成功！");
		return false;
	}
	
	
	
	
</script>
</@CommonQueryMacro.page>