<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<@CommonQueryMacro.page title="授权资料审核">
<table width="100%" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="GrantAuthDataCheck" init="false" submitMode="selected">
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
          		<@CommonQueryMacro.DataTable id ="datatable1"  paginationbar="btBatchGrantRole" fieldStr="select,createUser,name,idType,idNum,queryReason,serviceCode,queryDate,status" width="100%"  readonly="true"/><br />
        	</td>
        </tr>

   </table>
</@CommonQueryMacro.CommonQuery>

</td>
</tr>
</table>

<script language="javascript" src="${contextPath}/js/topTsk.js"></script>
<script language="javascript">
    function isRecordSelected(dataset) {
        var record = dataset.getFirstRecord();
        var hasSelected = false;
        while (record) {
            var v_selected = record.getValue("select");
            if (v_selected == true) {
                hasSelected = true;
            }
            record = record.getNextRecord();
        }
        if (!hasSelected) {
            return false;
        }
        return true;
    }

    function btBatchGrantRole_postSubmit() {
        alert("审核成功！")
        GrantAuthDataCheck_dataset.flushData(1);
        return false;
    }

    function flushData() {
        GrantAuthDataCheck_dataset.flushData(1);
    }

</script>

</@CommonQueryMacro.page>