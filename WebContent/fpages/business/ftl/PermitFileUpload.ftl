<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="个人征信许可文件上传查询">


<@CommonQueryMacro.CommonQuery id="PermitFileUpload" init="false" submitMode="selected" navigate="false">
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<table  width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="opr[150],fileName[300],sgement,product,scope,note,effectiveDate,expireDate,flag,filePath[500],createUser[100],inputTime[200]" readonly="true" width="95%"/><br />
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
 function initCallGetter_post(dataset) {
   PermitFileUpload_interface_dataset.setValue("qflag","0");
}


function PermitFileUpload_interface_dataset_btnSubmit_onClickCheck(){
	var qsgement = PermitFileUpload_interface_dataset.getValue("qsgement");
	var qproduct = PermitFileUpload_interface_dataset.getValue("qproduct");
	var qscope = PermitFileUpload_interface_dataset.getValue("qscope");
	var qfileName = PermitFileUpload_interface_dataset.getValue("qfileName");
	var qflag = PermitFileUpload_interface_dataset.getValue("qflag");
	
	if(qsgement=="" && qproduct=="" && qscope=="" && qfileName=="" && qflag==""){
		alert("条件必须选填一个！");
		return false;
	}
}

//当系统刷新单元格的内容时被触发
function datatable1_opr_onRefresh(cell,value,record) {
	var tlrno = "${v_tlrno}";
	
	var filePath = record.getValue("filePath");
	var sgement = record.getValue("sgement");
	var id = record.getValue("id");
	var product = record.getValue("product");
	var scope = record.getValue("scope");
	var flag = record.getValue("flag");
	var note = record.getValue("note");
	var createUser = record.getValue("createUser");
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<a href=\"JavaScript:dodownload('"+filePath+"','"+ id+"')\">文件下载</a>"
		if(tlrno==createUser){
			htmlStr = htmlStr 	+"&nbsp;&nbsp;&nbsp;&nbsp;" +
			"<a href=\"JavaScript:editFile('"+sgement+"','"+id+"','"+product+"','"+scope+"','"+note+"','"+flag+"')\">编辑文件</a>";
		}
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
function editFile(sgement,id,product,scope,note,flag){
			 var url = "/fpages/business/ftl/EditFile.ftl?id="+id+"&sgement="+sgement+"&product="+product+"&scope="+scope+"&note="+note+"&flag="+flag;
			 showWin("文件信息编辑", url, "window", "flushPage()", window);
			 flushPage();
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