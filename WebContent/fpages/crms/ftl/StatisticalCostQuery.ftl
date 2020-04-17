<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<@CommonQueryMacro.page title="统计查询费用量">
<table width="100%" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="StatisticalCostQuery" init="false" submitMode="selected">
	<table width="100%">
		<tr>
   			<td valign="top" colspan="2">
   			<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" fieldStr="name,idNum,qtlrno"/>
        	</td>
        </tr>
		<tr>
   			<td colspan="2">
   				<@CommonQueryMacro.PagePilot id="PagePilot"/>
   			</td>
  		</tr>
  		<tr>
      		<td colspan="2">
          		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="createUser,name,idType,idNum,queryReason,serviceCode,queryDate,status" width="100%"  readonly="true"/><br />
        	</td>
        </tr>

   </table>
</@CommonQueryMacro.CommonQuery>

</td>
</tr>
</table>

<script language="javascript" src="${contextPath}/js/topTsk.js"></script>
 <script language="javascript">


function flushData() {
    StatisticalCostQuery_dataset.flushData(1);
}
</script>

</@CommonQueryMacro.page>