<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="未结清正常类贸易融资">
<table align="left" width="100%">
<tr>

<@CommonQueryMacro.CommonQuery id="TcorpHistoryRecordMyrzQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="TcorpHistoryRecordMyrzQuery_table">
<tr valign="center">
	<td align="center">
	<h3>未结清正常贸易融资历史记录</h3>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="createDate,lastBalanceChgDate,balance,fiveLevel" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="TcorpExtendedDetailMyrzQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="TcorpExtendedDetailMyrzQuery_table">
<tr valign="center">
	<td align="center">
	<h3>未结清正常贸易融资展期信息</h3>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="startDate,endDate,extendedAmt" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="TcorpGuaranteedDetailLdkBzrQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="TcorpGuaranteedDetailLdkBzrQuery_table">
<tr valign="center">
	<td align="center">
	<h3>保证人信息</h3>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="assurePerson,assureDate,currency,assureAmt,assureType" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="TcorpGuaranteedDetailLdkDywQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="TcorpGuaranteedDetailLdkDywQuery_table">
<tr valign="center">
	<td align="center">
	<h3>抵押物信息</h3>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="assurePerson,assureKind,currency,valuation,assureDate,assureAmt" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="TcorpGuaranteedDetailLdkZywQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="TcorpGuaranteedDetailLdkZywQuery_table">
<tr valign="center">
	<td align="center">
	<h3>质押物信息</h3>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="assurePerson,assureKind,currency,valuation,assureAmt" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br>
</@CommonQueryMacro.CommonQuery>

</tr>
</table>
<div  align="center" >
<input type="button" name="close" value="关闭" style="margin-top:80px;background-color:#d6e5f8" onclick="goback()" />
</div> 

<script language="JavaScript">
function goback(){
	closeWin();
}
</script>
</@CommonQueryMacro.page>
