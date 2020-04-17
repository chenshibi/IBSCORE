<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="详细信息">
<@CommonQueryMacro.CommonQuery id="CorpScrubInfoQuerydetail" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="44%">
<tr  align="left">
		<td align="left">
				<@CommonQueryMacro.Group id="group1" label=""  fieldStr="checkNoPass" colNm=6 /></br>
		</td>
	</tr>
</table>
<table align="left" width="99%">
	
	<tr>
		<td  align="left">
				<@CommonQueryMacro.Group id="group2" label="一般报告查询状态统计"  fieldStr="querySuccess,query,queryDefeat" colNm=6 /></br>
		</td>
	</tr>
	
	<tr>
		<td  align="left">
				<@CommonQueryMacro.Group id="group3" label="明细报告查询状态统计"  fieldStr="querySuccessDetail,queryDetail,queryDefeatDetail" colNm=6 /></br>
		</td>
	</tr>
	
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="name,loancard,password,batchId,rptKey,orgcode,loanNo,status[150],detailstatus[150],queryReason,createUser,inputTime,returnTime" readonly="true" width="95%"/><br />
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>
<div height="80px"></div>

<style>#dd{line-height:200px}</style>
	<div  align="center" >
		<input type="button" name="close" value="关闭" style="margin-top:80px;background-color:#d6e5f8" onclick="goback()" />
	</div> 
<script language="JavaScript">
	function goback() {
		 closeWin();
	}
</script>
</@CommonQueryMacro.page>
