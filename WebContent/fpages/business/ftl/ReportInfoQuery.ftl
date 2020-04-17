<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="报表抽查">
<@CommonQueryMacro.CommonQuery id="ReportInfoQuery" init="false" submitMode="current" navigate="false">
<table  width="100%">
    <tr align="center">
		<td colspan="4">
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" fieldStr="loanCardId,companyName,individualId,name,individualIda,namea,individualIdb,nameb,individualIdc,namec,individualIdd,named,individualIde,namee,individualIdf,namef,individualIdg,nameg,individualIdh,nameh,individualIdi,namei"  colNm=4 />
		</td>
	</tr>
</table>
<table>
	<tr >
		<td colspan="4">
			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="dbrxm[300],cxrq[300],sfbh[300],ywyq[100],yqje[260]" readonly="true" /><br />
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">
  
</script>
</@CommonQueryMacro.page>