<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#--jianxue.zhang-->
<@CommonQueryMacro.page title="系统参数审批">
<table width="800px" align="left">
 <tr>
 <td>
<@CommonQueryMacro.CommonQuery id="approve_SysParamsEntry" init="true"  navigate="true" submitMode="all">
 <FIELDSET name='intface' style="padding: 8px;"><LEGEND>&nbsp;待审批参数列表&nbsp;</LEGEND>
<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="id[220],paramName[300],paramVal,crtDt,updTransCd" width="100%" readonly="true" hasFrame="true" />	
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
  
  	<@CommonQueryMacro.Button id= "btApproveSysParams"/>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<@CommonQueryMacro.Button id= "btBackSysParams"/>
  </td>
  </tr>
  </table>
  </@CommonQueryMacro.CommonQuery>
  </td>
  </tr>
</table>
<script language="javascript" src="${contextPath}/js/topTsk.js"></script>
<script language="javascript">
 var type;
 function datatable1_id_onRefresh(cell, value, record){
	if(record){
		type = record.getValue("intInsId");
		var sta = record.getValue("updTransCd");
	var rcdpk = record.getValue("adtRcdPk");
	cell.innerHTML = "<a href=\"Javascript:void(0);\" onClick=\"Javascript:detail.showUodoTaskDetail('"+type+"','"+sta+"','"+rcdpk+"')\">"+value+"</a>";
} else {
		cell.innerHTML = "";
	}
}

function btApproveSysParams_onClickCheck(button){
	approve_common_dataset.setValue("intInsId",type);
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
	if(type=="100799"){
		button.url="/common/success.jsp?type=approvesysparams&intInsId=100799";
	}else if(type=="120299"){
		button.url="/common/success.jsp?type=approvesysparams&intInsId=120299";
	}else if(type=="120399"){
		button.url="/common/success.jsp?type=approvesysparams&intInsId=120399";
	}
	return true;
}

function btBackSysParams_onClickCheck(button){
	if(type=="100799"){
	button.url="/fpages/system/ftl/SysParamsCheck.ftl";
	}else if(type=="120299"){
	button.url="/fpages/fayuan/ftl/businessCheck.ftl";
	}else if(type=="120399"){
	button.url="/fpages/tfms/ftl/tcpBusinessCheck.ftl";
	}
	return true;
}
</script>

</@CommonQueryMacro.page>
