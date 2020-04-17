<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="企业征信查询授权书上传查询">
<@CommonQueryMacro.CommonQuery id="TCorpPermitQuery" init="false" submitMode="all" navigate="false" insertOnEmpty="true">
<table align="left" width="99%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="opr[150],loanCardNo[160],corpName[160],loanCardPass,enterpriseRegId[160],customerConUp[150],createUser[160],inputTime[160],expireDate[160],approveTime,status" readonly="true" width="95%"/><br />
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function TCorpPermitQuery_interface_dataset_btnSubmit_onClickCheck(){
	var loanCardNo = TCorpPermitQuery_interface_dataset.getValue("qloanCardNo");
	var corpName = TCorpPermitQuery_interface_dataset.getValue("qcorpName");
	if((loanCardNo==null||loanCardNo=="")&&(corpName==null||corpName=="")){
		alert("组织机构代码和贷款卡号码/中征码必须选填一个！");
		return false;
	}
}


//当系统刷新单元格的内容时被触发
function datatable1_opr_onRefresh(cell,value,record) {
	var id = record.getValue("id");
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<a href=\"JavaScript:dodownload('"+id+"')\">查询授权书下载</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function dodownload(id){
	 var paramMap = new Map();
	 paramMap.put("id",id);
	 dwr.engine.setAsync(false);
		var flag=PrivAction.tCorpQueryPermit(id);
		dwr.engine.setAsync(false);
		if(flag=="1"){
			window.location.href="${contextPath}/DownloadTCorpPermitAction.do?id="+id;
	
		}else{
			alert("The file does not exists！");
		}
	
}
</script>
</@CommonQueryMacro.page>
