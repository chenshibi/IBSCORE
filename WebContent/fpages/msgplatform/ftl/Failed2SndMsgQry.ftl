<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="消息发送日志查询">
<table align="left">
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="Failed2SndMsgQry" init="false" submitMode="current">
			<table width="100%">
				<tr>
					<td colspan="2" valign="top">
						<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" />
					</td>
				</tr>
				<tr>
					<td>
						<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.DataTable id="datatable1" paginationbar="" fieldStr="id[200],brno,msgName[200],msgSysId,msgLogHead[300],createdDate1[150],status,failedReason[350]" width="100%"/>
					</td>
				</tr>
			</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="JavaScript">
	/*
	function initCallGetter_pre(){
		Failed2SndMsgQry_dataset.setParameter("pageType","faildPage");
	}
	*/
	
	//将id列变成超链接,需要记录类型,操作说明,原纪录主键,记录本身
	function datatable1_opr_onRefresh(cell,value,record){
       	var id = record.getValue("id");
	   	if(record){
	       	cell.innerHTML= "<a href=\"JavaScript:showDetail('"+id+"')\">查看明细</a> "
	       	
       	}else {//当不存在记录时
			cell.innerHTML="&nbsp;";
		}
     }
    function locate(id) {
		var record = Failed2SndMsgQry_dataset.find(["id"],[id]);
        if (record) {
			Failed2SndMsgQry_dataset.setRecord(record);
		}
	}
	
	function showDetail(id){
	    var record = Failed2SndMsgQry_dataset.find(["id"],[id]);
        var url = "/fpages/msgplatform/ftl/MsgLogQryDtl.ftl?&id="+id;
		showWin("发送失败消息查询-明细",url,"window","flushPage()",window);
	}
    //刷新数据
	function flushPage(){
		Failed2SndMsgQry_dataset.flushData(1);
	}
</script>
</@CommonQueryMacro.page>