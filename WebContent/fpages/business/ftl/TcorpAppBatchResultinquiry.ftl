<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />
<@CommonQueryMacro.page title="CorpAppRequest.title">
<table align="left" width="100%"><tr><td>
<@CommonQueryMacro.CommonQuery id="CorpScrubInfoQuery" init="false" submitMode="current">
<table  width="80%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="opr,batchId,inputTime[200],createUser,countid" readonly="true" width="95%" hasFrame="true" /><br />
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>

</td></tr>
</table>
<script language="JavaScript">
function CorpScrubInfoQuery_interface_dataset_btnSubmit_onClickCheck(){
		var startDate = CorpScrubInfoQuery_interface_dataset.getValue("startDate");
		var endDate = CorpScrubInfoQuery_interface_dataset.getValue("endDate");
		if(startDate == null || startDate == ""){
			alert("开始日期不能为空!");
			return false;
		}
		if(endDate == null || endDate == ""){
			alert("结束日期不能为空!");
			return false;
		}

		var between_days=(endDate-startDate)/(1000*3600*24);
		var year=startDate.getFullYear();
		var month=(startDate.getMonth()+1).toString();
		var day=(startDate.getDate()).toString();
		var y=endDate.getFullYear();
		var m=(endDate.getMonth()+1).toString();
		var d=(endDate.getDate()).toString();
		if(month.length==1){
		month="0"+month;
		}
		if(day.length==1){
		day="0"+day;
		}
		if(m.length==1){
		m="0"+m;
		}
		if(d.length==1){
		d="0"+d;
		}
		var startDates=year+month+day;
		var endDates=y+m+d;
		if(endDates<startDates){
		alert("结束日期不能大于开始日期!");
		return false;
		}
		if(between_days>=14){
		alert("开始日期和结束日期时间间隔不能超过14天!");
		return false;
		}
}
	
//当系统刷新单元格的内容时被触发
function datatable1_opr_onRefresh(cell,value,record) {
	
	
	var batchId = record.getValue("batchId");
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<a href=\"JavaScript:showdetail('"+batchId+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
	function showdetail(batchId){
		 var paramMap = new Map();
		 paramMap.put("batchId",batchId);
		//loadPageWindows("partWin","查看明细","/fpages/business/ftl/TcorpAppBatchResultinquirydetails.ftl", paramMap, "winZone");
		var url = "/fpages/business/ftl/TcorpAppBatchResultinquirydetails.ftl?batchId="+batchId;
    	showWin("查看明细", url, "window", "flushPage()", window);
	}
</script>
</@CommonQueryMacro.page>