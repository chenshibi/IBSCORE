<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<@CommonQueryMacro.page title="企业征信重新查询">
<table width="100%" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="CrmsCorpReQuery" init="false" submitMode="selected">
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
          		<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btBatchApprove,-,btBatchReject" fieldStr="select,createUser,entName,entCertType,entCertNum,queryReason,serviceCode,queryDate,status" width="100%"  readonly="true"/><br />
        	</td>
        </tr>

   </table>
</@CommonQueryMacro.CommonQuery>

</td>
</tr>
</table>

<script language="javascript" src="${contextPath}/js/topTsk.js"></script>
 <script language="javascript">

function btBatchApprove_onClickCheck() {
    if (!isRecordSelected(CrmsCorpReQuery_dataset)) {
        alert("请选择一条记录！");
        return false;
    }
    return true;
}
function flushData() {
    CrmsCorpReQuery_dataset.flushData(1);
}

function btBatchReject_onClickCheck() {
    if (!isRecordSelected(CrmsCorpReQuery_dataset)) {
        alert("请选择一条记录！");
        return false;
    }
    return true;
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
function btBatchApprove_postSubmit(button) {
    alert("审核通过成功！")
    CrmsCorpReQuery_dataset.flushData(1);
    if (button.returnParam && button.returnParam.uuid) {
            var params = {}
            params.uuid=button.returnParam.uuid;
            var temp=params.uuid;
            var t=temp.toString();
            var t1=t.replace("[","");
            var t2=t1.replace("]","");
            var str= t2.split(",");
            var len=str.length;
            for(var i=0;i<len;i++){
                params.uuid=Trim(str[i]);
                alert('查询成功，将在新窗口打开征信查询结果页面');
                OpenWindowWithPost("${contextPath}/CorpReportServlet", null, "_blank", params);
            }
    } else {
        alert("查询失败！");
    }

  /*  alert("审核通过成功！")
    CrmsCorpReQuery_dataset.flushData(1);
    return false;*/
}

/**
 * 去掉字符串前后空格
 * @param str
 * @returns {void | string}
 * @constructor
 */
function Trim(str)
{
    return str.replace(/(^\s*)|(\s*$)/g, "");
}


function btBatchReject_postSubmit() {
    alert("审核拒绝成功！")
    CrmsCorpReQuery_dataset.flushData(1);
    return false;
}

</script>

</@CommonQueryMacro.page>