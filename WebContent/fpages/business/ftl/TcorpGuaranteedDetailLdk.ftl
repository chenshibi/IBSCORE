<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="正常类类贷款">
<table align="left" width="100%">
<tr>

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
<div id="a"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
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
<div id="b"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
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
<div id="c"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="TcorpExtendedDetailLdkZqQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="TcorpExtendedDetailLdkZqQuery_table">
<tr valign="center">
	<td align="center">
	<h3>展期信息</h3>
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
<div id="d"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="TcorpHistoryRecordLDkQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="TcorpHistoryRecordLDkQuery_table">
<tr valign="center">
	<td align="center">
	<h3>未结清正常类贷款历史记录</h3>
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
<div id="e"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>


</tr>
</table>

<div  align="center" >
<input type="button" name="close" value="关闭" style="margin-top:80px;background-color:#d6e5f8" onclick="goback()" />
</div> 

<script language="JavaScript">
function initCallGetter_post() {
	if(TcorpGuaranteedDetailLdkBzrQuery_dataset!=null&&TcorpGuaranteedDetailLdkBzrQuery_dataset.record==null){
		document.getElementById('TcorpGuaranteedDetailLdkBzrQuery_table').style.display="none";
		document.getElementById('a').style.display="none";
	}
	if(TcorpGuaranteedDetailLdkDywQuery_dataset!=null&&TcorpGuaranteedDetailLdkDywQuery_dataset.record==null){
		document.getElementById('TcorpGuaranteedDetailLdkDywQuery_table').style.display="none";
		document.getElementById('b').style.display="none";
	}
	if(TcorpGuaranteedDetailLdkZywQuery_dataset!=null&&TcorpGuaranteedDetailLdkZywQuery_dataset.record==null){
		document.getElementById('TcorpGuaranteedDetailLdkZywQuery_table').style.display="none";
		document.getElementById('c').style.display="none";
	}
	if(TcorpExtendedDetailLdkZqQuery_dataset!=null&&TcorpExtendedDetailLdkZqQuery_dataset.record==null){
		document.getElementById('TcorpExtendedDetailLdkZqQuery_table').style.display="none";
		document.getElementById('d').style.display="none";
	}
	if(TcorpHistoryRecordLDkQuery_dataset!=null&&TcorpHistoryRecordLDkQuery_dataset.record==null){
		document.getElementById('TcorpHistoryRecordLDkQuery_table').style.display="none";
		document.getElementById('e').style.display="none";
	}
}
function goback(){
	closeWin();
}
</script>
</@CommonQueryMacro.page>
