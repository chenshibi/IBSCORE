<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="个人征信许可文件上传查询">
<@CommonQueryMacro.CommonQuery id="IndPermitQuery" init="false" submitMode="selected" navigate="false">

<table  width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="opr[150],individualId[200],name,idType,customerConUp[150],createUser[100],inputTime[200],expireDate[200],approveTime,status" readonly="true" width="95%"/><br />
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function IndPermitQuery_interface_dataset_btnSubmit_onClickCheck(){
	var individualId = IndPermitQuery_interface_dataset.getValue("qindividualId");
	var name = IndPermitQuery_interface_dataset.getValue("qname");
	if((individualId==null||individualId=="")&&(name==null||name=="")){
		alert("证件号和客户名称必须选填一个！");
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
	 var flag=PrivAction.indQueryPermit(id);
		dwr.engine.setAsync(false);
		if(flag=="1"){
			window.location.href="${contextPath}/DownloadIndPermitAction.do?id="+id;
		}else{
			alert("The file does not exists！");
		}
}

</script>
</@CommonQueryMacro.page>