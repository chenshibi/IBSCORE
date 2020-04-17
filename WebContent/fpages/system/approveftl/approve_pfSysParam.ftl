<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#--jianxue.zhang-->
<@CommonQueryMacro.page title="系统安全参数审批">
<table width="800px" align="left">
 <tr>
 <td>
<@CommonQueryMacro.CommonQuery id="approve_pfSysParams" init="true"  navigate="true" submitMode="all">
 <FIELDSET name='intface' style="padding: 8px;"><LEGEND>&nbsp;待审批系统安全参数列表&nbsp;</LEGEND>
<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="id[220],magicId,paramValueTx,crtDt,updTransCd" width="100%" readonly="true" hasFrame="true" />	
 </FIELDSET>
</@CommonQueryMacro.CommonQuery>
 </td>
 </tr>
 
<tr>
 <td>
 <@CommonQueryMacro.CommonQuery id="approve_common" init="false"  navigate="false" submitMode="all">
 <table>
 <tr>
 <td>
  <@CommonQueryMacro.Group id ="group1" label="审批意见" fieldStr="approveResult,approveRemark" colNm=2/>
  </td>
  </tr>
  <tr>
  <td >
  
  	<@CommonQueryMacro.Button id= "btApprove"/>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<@CommonQueryMacro.Button id= "btBack"/>
  </td>
  </tr>
  </table>
  </@CommonQueryMacro.CommonQuery>
  </td>
  </tr>
</table>
<script language="javascript" src="${contextPath}/js/topTsk.js"></script>
<script language="javascript">
 function datatable1_id_onRefresh(cell, value, record){
	if(record){
		var type = record.getValue("intInsId");
		var sta = record.getValue("updTransCd");
	var rcdpk = record.getValue("adtRcdPk");
	cell.innerHTML = "<a href=\"Javascript:void(0);\" onClick=\"Javascript:detail.showUodoTaskDetail('"+type+"','"+sta+"','"+rcdpk+"')\">"+value+"</a>";
} else {
		cell.innerHTML = "";
	}
}

function btApprove_onClickCheck(button){
	approve_common_dataset.setValue("intInsId","100899");
	var approveResult = approve_common_dataset.getValue("approveResult");
	var approveRemark = approve_common_dataset.getValue("approveRemark");
		if (!approveResult.length > 0) {
		   		alert("请选择审核结果！");
		   		return false;
		   	}
	   	if (approveResult == "02" && approveRemark.length < 1) {
	   		alert("审核结果不通过，审核说明必须填写！");
	   		return false;
	   	}
	var reg = new RegExp("^((?!<|>).)*$");
	if(!reg.test(approveRemark)){
		alert("审核说明中不能包含“<”或者“>”");
		return false;
	}
		approve_common_dataset.setParameter("approveResult",approveResult);
		approve_common_dataset.setParameter("approveRemark",approveRemark);
	return true;
}
</script>

</@CommonQueryMacro.page>
