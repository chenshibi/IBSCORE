<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="不良关注类保理">
<table align="left" width="100%">
<tr>

<@CommonQueryMacro.CommonQuery id="TcorpGuaranteedDetailBlBzrQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="TcorpGuaranteedDetailBlBzrQuery_table">
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
<h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="TcorpGuaranteedDetailBlDywQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="TcorpGuaranteedDetailBlDywQuery_table">
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

<@CommonQueryMacro.CommonQuery id="TcorpGuaranteedDetailBlZywQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="TcorpGuaranteedDetailBlZywQuery_table">
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
<h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3>
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
