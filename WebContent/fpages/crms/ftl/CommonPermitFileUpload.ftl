<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="征信查询文件下载">

<@CommonQueryMacro.CommonQuery id="CommonPermitFileUpload" init="true" submitMode="selected" navigate="false">
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<table  width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="opr[200],department,status,createUser[100],inputTime[200],filePath[500],fileName[300],effectiveDate" readonly="true" width="95%"/><br />
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function CommonPermitFileUpload_interface_dataset_btnSubmit_onClickCheck(){
  
}

//当系统刷新单元格的内容时被触发
function datatable1_opr_onRefresh(cell,value,record) {
	var tlrno = "${v_tlrno}";
	var filePath = record.getValue("filePath");
	var id = record.getValue("id");
	var createUser = record.getValue("createUser");
	if (record) {//当存在记录时
		var htmlStr = "";
		htmlStr="<a href=\"JavaScript:dodownload('"+filePath+"','"+ id+"')\">公共文件下载</a>"
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function dodownload(filePath,id){
	 var paramMap = new Map();
	 paramMap.put("filePath",filePath);
	 dwr.engine.setAsync(false);
	 var flag=PrivAction.queryFileExist(filePath);
	 dwr.engine.setAsync(false);
	 if(flag){
			window.location.href="${contextPath}/DownloadFileAction.do?id="+id;
	 }else{
			alert("The file does not exists！");
		}
}

</script>
</@CommonQueryMacro.page>