<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="社会保险参保历史缴费记录明细">
<@CommonQueryMacro.CommonQuery id="TcorpPublicInfoDetailQuery" init="true" submitMode="current" navigate="false">
	<table align="left" width="100%">
     <tr>
      		<td valign="top">
      			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
      		</td>
	 </tr>
     <tr>
      		<td>
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="sumYm,monthFeePayable,monthFeePaid,payStatus,owAmount" readonly="true" width="100%"/>
      		</td>
     </tr>
</table>
<h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3>
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">

</script>
</@CommonQueryMacro.page>
