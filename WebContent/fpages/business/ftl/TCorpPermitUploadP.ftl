<#global contextPath = contextPath>
<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="企业征信查询查询授权书上传">


<@CommonQueryMacro.CommonQuery id="TCorpPermitUploadP" init="true" submitMode="all" navigate="false">

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
			
<@CommonQueryMacro.CommonQuery id="TCorpPermitUploadP" init="true" submitMode="all" navigate="false">
		<table align="center">
			<tr>
    			<td width="50%">
					<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;  
    			</td>
    			<td width="50%">
					<@CommonQueryMacro.Button id= "btClose"/>
    			</td>
    		</tr>
    	</table>
</@CommonQueryMacro.CommonQuery>
    	

<script language="JavaScript">	

function initCallGetter_post(dataset) {
    var id=TCorpPermitUploadP_dataset.getParameter("id");
	var loanCardNo=TCorpPermitUploadP_dataset.getParameter("corpCustLoancard");
	var corpName=TCorpPermitUploadP_dataset.getParameter("corpCustCompanyname");
	var entCertType=TCorpPermitUploadP_dataset.getParameter("type");
	corpName = decodeURI(decodeURI(corpName));
	if("10"==entCertType){
	     TCorpPermitUploadP_dataset.setValue("loanCardNo",loanCardNo);
	 }if("30"==entCertType){
	     TCorpPermitUploadP_dataset.setValue("enterpriseRegId",loanCardNo);
	 }
	TCorpPermitUploadP_dataset.setValue("entCertType",entCertType);
	TCorpPermitUploadP_dataset.setValue("loanCardNo",loanCardNo);
	TCorpPermitUploadP_dataset.setValue("corpName",corpName);
    TCorpPermitUploadP_dataset.setValue("id",id)
	var date = new Date();
	var month = date.getMonth()+1;
	var year=2099;
	var currentDate = year+"/"+month+"/"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	var approveTime=date.getFullYear()+"/"+month+"/"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
	TCorpPermitUploadP_dataset.setValue("expireDate",currentDate);
	TCorpPermitUploadP_dataset.setValue("approveTime",approveTime);
}
	
	function btSave_onClickCheck(button){
	    var id=TCorpPermitUploadP_dataset.getValue("id");
		var loanCardNo= TCorpPermitUploadP_dataset.getValue("loanCardNo");
		var enterpriseRegId= TCorpPermitUploadP_dataset.getValue("enterpriseRegId");
		var corpName= TCorpPermitUploadP_dataset.getValue("corpName");
		var filePath=document.getElementById("uploadPermitFile").value;
		var loanCardPass=TCorpPermitUploadP_dataset.getValue("loanCardPass");
		var type=TCorpPermitUploadP_dataset.getValue("entCertType");
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
		document.getElementById("form_loanCardPass").value = loanCardPass;
		document.getElementById("form_enterpriseRegId").value = enterpriseRegId;
		document.getElementById("form_corpName").value = corpName;
		document.getElementById("form_loanCardNo").value = loanCardNo;
		document.getElementById("form_expireDate").value = TCorpPermitUploadP_dataset.getValue("expireDate").format("yyyyMMdd");
		document.getElementById("form_approveTime").value = TCorpPermitUploadP_dataset.getValue("approveTime").format("yyyyMMdd");
		document.getElementById("uploadFileForm").submit();
		alert("提交成功！");
     	window.location.href="${contextPath}/fpages/crms/ftl/CrmsBatchQueryCorpReport.ftl";
		return false;
	}
	
	
	
	
</script>
</@CommonQueryMacro.page>