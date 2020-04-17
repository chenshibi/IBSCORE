<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="征信查询企业报告头">
<@CommonQueryMacro.CommonQuery id="CrComEaa" init="false" submitMode="current" navigate="false">
	<table align="left" width="100%">
	 <tr valign="center">
       			<td valign="top" colspan="2">
					<@CommonQueryMacro.Interface id="intface" />
				</td>
     </tr>
     <tr>
      		<td valign="top">
      			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="13" showArrow="true" pageCache="false"/>
      		</td>
	 </tr>
     <tr>
      		<td colspan="2">
      			<@CommonQueryMacro.DataTable id ="datatable1" fitColumns="false" fieldStr="ea01ai01,ea01ar01,ea01bi01,ea01bd02,ea01cq01,ea01cs01,ea01ds01,ea01eq01,ea01er01,createUser,createTime,status" readonly="true" hasFrame="true" width="100%"/>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.CommonQuery>
<span style="display:none">

</span>

</@CommonQueryMacro.page>
