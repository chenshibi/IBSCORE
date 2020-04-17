<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="消息类型维护审核" >
<@CommonQueryMacro.CommonQuery id="CpgMsgCtlTmp" navigate="true" init="false" submitMode= "current" >
<table align="left" width="1200px">
	<tr>
   		<td valign="top">
   			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=6 showButton="true" />
       	</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.PagePilot id="pagePilot1"  />
		</td>
	</tr>
	<tr>
		<td width="100%" valign="top">
			<@CommonQueryMacro.DataTable id="datatable1" paginationbar="" fieldStr="optType,msgId,sysType,msgName[200],type,status,creator1,createdDate1[150],opr"  readonly="true"  hasFrame="false" />
		</td>
	</tr>
	<tr>
		<td style="display:none"><@CommonQueryMacro.Button id= "btCheck"/></td>
		<td style="display:none"><@CommonQueryMacro.Button id= "btReject"/></td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery >
<script language="javascript">
//定位一条记录
function locate(id) {
	var record = CpgMsgCtlTmp_dataset.find(["id"],[id]);
	if (record) {
		CpgMsgCtlTmp_dataset.setRecord(record);
	}
}

function datatable1_opr_onRefresh(cell, value, record){
	if(record&&record!=null){
		var id = record.getValue("id");
		cell.innerHTML = "<center><a href=\"JavaScript:doCheck('"+id+"')\">审核</a>&nbsp;&nbsp;<a href=\"JavaScript:doReject('"+id+"')\">拒绝</a></center>";
	} else {
		cell.innerHTML = "";
	}
}

function doCheck(id){
	locate(id);
	window.document.getElementById('btCheck').click();
}

function doReject(id){
	locate(id);
	window.document.getElementById('btReject').click();
}
	
function btCheck_postSubmit(button){
	alert("操作成功！");
	CpgMsgCtlTmp_dataset.flushData(CpgMsgCtlTmp_dataset.pageIndex);
}

function btReject_postSubmit(button){
	alert("操作成功！");
	CpgMsgCtlTmp_dataset.flushData(CpgMsgCtlTmp_dataset.pageIndex);
}

</script >
</@CommonQueryMacro.page>