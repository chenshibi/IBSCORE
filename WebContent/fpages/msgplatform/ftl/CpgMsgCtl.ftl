<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="消息类型维护">
<table width="100%" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="CpgMsgCtl" init="false" submitMode="current">
	<table width="100%">
		<tr>
   			<td valign="top" colspan="2">
   				<@CommonQueryMacro.Interface id="intface" label="机构查询" colNm=6 showButton="true" />
        	</td>
        </tr>
		<tr>
   			<td>
   				<@CommonQueryMacro.PagePilot id="PagePilot"/>
   			</td>
  		</tr>
  		<tr>
      		<td colspan="2">
          		<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="" fieldStr="sysType,msgId[150],msgName[250],type,status,modUser1,checkUser1,checkDate1[150],opr" width="100%"  readonly="true"/><br />
        	</td>
        </tr>
  		<tr>
  			<td style="display:none"><@CommonQueryMacro.Button id= "btSave"/></td>
		</tr>
	</table>
</@CommonQueryMacro.CommonQuery>
</td>
</tr>
</table>
<script language="javascript">
	//定位一条记录
	function locate(id) {
		var record = CpgMsgCtl_dataset.find(["id"],[id]);
		if (record) {
			CpgMsgCtl_dataset.setRecord(record);
		}
	}

	function datatable1_opr_onRefresh(cell, value, record){
		if (record) {//当存在记录时
			var status = record.getValue("status");
			var id = record.getValue("id");
			if(status == '0'){
				cell.innerHTML="<center><a href=\"JavaScript:changeStatus('"+id+"')\">置为无效</a></center>";
			}else{
				cell.innerHTML="<center><a href=\"JavaScript:changeStatus('"+id+"')\">置为有效</a></center>";
			}
		} else {//当不存在记录时
		 cell.innerHTML="&nbsp;";
		}
	}
	
	function changeStatus(id){
		locate(id);
		window.document.getElementById('btSave').click();
	}
	
	function btSave_postSubmit(button){
		alert("提交成功！");
		CpgMsgCtl_dataset.flushData(CpgMsgCtl_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>