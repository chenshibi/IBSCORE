<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<@CommonQueryMacro.page title="企业征信维护">
<table width="100%" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="QueryCorpMaintainGetter" init="false" submitMode="selected">
	<table width="100%">
		<tr>
   			<td valign="top" colspan="2">
   			<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" fieldStr="entName,entCertNum,qtlrno"/>
        	</td>
        </tr>
		<tr>
   			<td colspan="2">
   				<@CommonQueryMacro.PagePilot id="PagePilot"/>
   			</td>
  		</tr>
  		<tr>
      		<td colspan="2">
          		<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btBatchGrantRole" fieldStr="select,createUser,entName,entCertType,entCertNum,queryReason,serviceCode,queryDate,status,certAuthStatus,id" width="100%"  readonly="true"/><br />
        	</td>
        </tr>

   </table>
</@CommonQueryMacro.CommonQuery>

</td>
</tr>
</table>

<script language="javascript" src="${contextPath}/js/topTsk.js"></script>
<script language="javascript">
    function datatable1_id_onRefresh(cell, value, record){
        if(record!=null){
            var eid = record.getOriginalValue("id");
            cell.innerHTML = "<a href=\"Javascript:showDetail('" + eid + "')\">修改</a>";
        }
    }
    function showDetail(id){
        var paramMap = new Map();
        paramMap.put("id", id);
        loadPageWindows("partWin", "修改","/fpages/crms/ftl/QueryCorpDetailGetter.ftl", paramMap, "winZone");
    }

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
        alert("批量授权成功！")
        QueryCorpMaintainGetter_dataset.flushData(1);
        return false;
    }

    function flushData() {
        QueryCorpMaintainGetter_dataset.flushData(1);
    }
</script>
</@CommonQueryMacro.page>