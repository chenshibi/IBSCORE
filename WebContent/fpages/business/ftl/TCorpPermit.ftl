<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="企业征信许可文件上传查询">
<@CommonQueryMacro.CommonQueryTab id="BusinessQueryTabs" navigate="false" currentTab="TCorpPermitQuery">
<@CommonQueryMacro.CommonQuery id="TCorpPermitQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table align="left" width="99%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="loanCardNo[200],corpName[200],loanCardPass[200],enterpriseRegId[200],customerConUp[200],expireDate[200]" readonly="true" width="95%"/><br />
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>
</@CommonQueryMacro.CommonQueryTab>
<script language="JavaScript">
</script>
</@CommonQueryMacro.page>
