<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="未结清正常类信用证记录明细">
<table align="left" width="100%">
<tr>

<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersXyzDetailQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="TcorpDetailOthersXyzDetailQuery_table">
<tr valign="center">
	<td align="center">
	<h3>未结清正常类信用证记录明细</h3>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ,currency,amount,balance,initDate,expireDate,depositRatio,assured,advanced" readonly="true" width="100%"/>
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
function initCallGetter_post() {
	if(TcorpDetailOthersXyzDetailQuery_dataset!=null&&TcorpDetailOthersXyzDetailQuery_dataset.record==null){
		document.getElementById('TcorpDetailOthersXyzDetailQuery_table').style.display="none";
	}
}
function goback(){
	closeWin();
}
</script>
</@CommonQueryMacro.page>
