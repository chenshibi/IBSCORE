<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="贷款卡卡号(中证码)查询">
<@CommonQueryMacro.CommonQuery id="LoanCardNoInquiryQuery" init="false" submitMode="all" navigate="false" insertOnEmpty="true">
<table align="left" width="99%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="opr[100],queryReason[160],inquiryType[160],inquiryValue[160],status[160],pwid[160],inputTime[160]" readonly="true" width="95%"/><br />
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function LoanCardNoInquiryQuery_interface_dataset_btnSubmit_onClickCheck(){
		var inquiryType =LoanCardNoInquiryQuery_interface_dataset.getValue("qinquiryType");
		var inquiryValue = LoanCardNoInquiryQuery_interface_dataset.getValue("qinquiryValue");
		if((inquiryType==null||inquiryType=="")&&(inquiryValue==null || inquiryValue=="")){
			alert("请输入查询条件！");
			return false;
	}
}	
	

//当系统刷新单元格的内容时被触发
function datatable1_opr_onRefresh(cell,value,record) {
	
	
	var id = record.getValue("id");
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<a href=\"JavaScript:showdetail('"+id+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
	function showdetail(id){
		 var paramMap = new Map();
		 paramMap.put("id",id);
		//loadPageWindows("partWin","查看明细","/fpages/business/ftl/LoanCardNoInquirySingleDetail.ftl", paramMap, "winZone");
		var url = "/fpages/business/ftl/LoanCardNoInquirySingleDetail.ftl?id="+id;
		showWin("个人信息校验", url, "window", "flushPage()", window);
	}
	
	

</script>
</@CommonQueryMacro.page>
