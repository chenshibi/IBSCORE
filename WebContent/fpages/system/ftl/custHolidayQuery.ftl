<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="节假日查询">
<table align="left">
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="custHoliday" init="false" submitMode="current">
			<table width="100%">
				<tr>
					<td colspan="2" valign="top">
						<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" colNm="4" fieldStr="qreqdatebegin,qreqdateend"/>
					</td>
				</tr>
				<tr>
					<td>
						<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="true" showArrow="true" pageCache="false"/>
					</td>
				</tr>
			</table>
			<table width="100%">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.DataTable id="datatable1"    fieldStr="hdate[200],weekdy[200],work[200],last_up_tm[200]" width="100%"/>
					</td>
				</tr>
			</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>

</@CommonQueryMacro.page>