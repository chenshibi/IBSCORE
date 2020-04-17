<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="公共文件上传">
<@CommonQueryMacro.CommonQuery id="CommonFileGroupUpload" init="true" submitMode="selected" navigate="false">
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<table  width="100%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="disuseBN,-,uploadBN" fieldStr="select,department,createUser[100],inputTime[200],filePath[500],fileName[300],effectiveDate[200]" readonly="true" width="95%"/><br />
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">
 function initCallGetter_post() {
  
}

function isRecordSelected(dataset) {
    var record = dataset.getFirstRecord();
    var hasSelected = false;
    while (record) {
        var v_selected = record.getValue("select");
        if (v_selected == true) {
            hasSelected = true;
        }
        record = record.getNextRecord();
    }
    if (!hasSelected) {
        return false;
    }
    return true;
}


function disuseBN_onClickCheck() {
    if (!isRecordSelected(CommonFileGroupUpload_dataset)) {
        alert("请选择一条记录！");
        return false;
    }
    return true;
}
    
  //重新匹配
  function disuseBN_postSubmit(button){
      alert("更新成功"); 
      CommonFileGroupUpload_dataset.flushData();  			
   	} 
   	
  	function uploadBN_onClick(){
  	    var dp = CommonFileGroupUpload_interface_dataset.getValue("department");
  	    if((dp==null||dp=="")){
		    alert("请选择部门！");
		    return false;
	     }
		currentSubWin = openSubWin("pageWinId", "公共文件上传", "/fpages/business/jsp/UploadFile.jsp?department="+dp,"600","200");
	}	

	 

	
	
</script>
</@CommonQueryMacro.page>