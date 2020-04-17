<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="详细信息">
<@CommonQueryMacro.CommonQuery id="IndScrubInfoQuerydetail" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table align="left" width="99%">
	<tr>
		<td  align="left">
				<@CommonQueryMacro.Group id="group1" label=""  fieldStr="querySuccess,query,checkNoPass,queryDefeat" colNm=4 /></br>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="name,individual,individualType,loanNo,applicationNo,relationshipNo,inputTime,returnTime,rptId,batchId,status,createUser,queryReason" readonly="true" width="95%"/><br />
		</td>
	</tr>
	
</table>


</@CommonQueryMacro.CommonQuery>
<div  align="center" >
	<input type="button" name="close" value="关闭" style="margin-top:80px;background-color:#d6e5f8" onclick="goback()" />
</div> 
<script language="JavaScript">
	
	function goback(){
		closeWin();
	}
</script>
</@CommonQueryMacro.page>
