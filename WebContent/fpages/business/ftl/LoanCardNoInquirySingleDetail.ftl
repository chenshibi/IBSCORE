<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="详细信息">
<@CommonQueryMacro.CommonQuery id="LoanCardNoInquiryDetail" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table align="left" width="99%" >
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="loancardno,engName,chnName,fullName,countryTaxCode,regionTaxCode,orgCreditCode,orgCode,registCode,registCodeType,returnTime" readonly="true" width="95%"/><br />
		</td>
	</tr>
	
</table>

</@CommonQueryMacro.CommonQuery>

	<div align="center">
		<input type="button" name="close" value="关闭" style="margin-top:80px;background-color:#d6e5f8" onclick="goback()" />
	</div>

<script language="JavaScript">
	
	function goback(){
		closeWin();
	}
</script>
</@CommonQueryMacro.page>
