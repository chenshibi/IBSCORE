<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="SysParamsEntry.title">
<table align="left" width="100%"><tr><td>
<@CommonQueryMacro.CommonQuery id="sysParamsEntry" init="false" submitMode="current">
<table width="100%">
	<tr>
		<td>
			<@CommonQueryMacro.Interface id="interface" width="100%" label="请输入查询条件" />
		</td>
	</tr>
	<tr>
		<td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@CommonQueryMacro.DataTable id="datatable1" fieldStr="paramgroupId,paramId,paramName[260],paramVal,memo[260],st"  width="100%" hasFrame="true"/>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>

</td></tr>
</table>
</@CommonQueryMacro.page>