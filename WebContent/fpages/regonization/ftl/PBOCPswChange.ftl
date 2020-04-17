<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="IBS企业/个人密码修改">
<@CommonQueryMacro.CommonQuery id="PBOCPswChange" init="true"  navigate="false">

<table  width="100%" align="center">
<tr valign="center">
		<td valign="top" colspan="2">
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件"  />
		</td>
		</tr>
   <tr height="50px">
   </tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id ="datatable"  fieldStr="userNo[300],userType,lastUpdateTime[300],updateTlrInfo,statusPswd[300],opr[100]" readonly="true"/><br />
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function initCallGetter_post(dataset) {
}
function datatable_opr_onRefresh(cell, value, record)
{
	if(record&&record!=null){

		var id = record.getValue("userNo");
		var statusPswd=record.getValue("statusPswd");
		var userType=record.getValue("userType");
		
		var innerStr = "<PRE>";
		if (statusPswd=="0"||statusPswd=="4") {                                       
			innerStr = innerStr + " <a href=\"JavaScript:btModifyShow('"+id+"','"+userType+"','"+statusPswd+"')\">modify</a>" +"</PRE>";
	    } else {
	    	innerStr = innerStr + "<a style=\"color:#666666\" title=\"The record is locked and cannot be operated\">modify</a> " +"</PRE>";
	    }
	    cell.innerHTML = innerStr;
	}else{
		cell.innerHTML = "";
	}
}
function btModifyShow(userNo,userType,statusPswd){
	var userType=encodeURI(encodeURI(userType));
	var statusPswd=encodeURI(encodeURI(statusPswd));
  	window.location.href = "${contextPath}/fpages/regonization/ftl/TlrPbocUserMod.ftl?userNo=" + userNo+"&userType="+userType+"&statusPswd="+statusPswd;
}

</script>
</@CommonQueryMacro.page>