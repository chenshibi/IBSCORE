<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="接收用户组维护">
<table align="left">
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="CpgGroupInf" init="false" submitMode="current">
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
						<@CommonQueryMacro.DataTable id="datatable1" paginationbar="btAdd" fieldStr="groupId,groupName[250],creator1,createdDate1[150],checkUser1,checkDate1[150],opr[100]" width="100%"/>
					</td>
				</tr>
			</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="JavaScript">
   //将id列变成超链接,需要记录类型,操作说明,原纪录主键,记录本身
	function datatable1_opr_onRefresh(cell,value,record){
       	var groupId = record.getValue("groupId");
	   	if(record){
           	innerText = "<a href=\"JavaScript:btModify('"+groupId+"')\">修改</a> "
	       	cell.innerHTML= innerText +"<a href=\"JavaScript:doDelete('"+groupId+"')\">删除</a>";
	       	//&nbsp;<a href=\"Javascript:void(0);\" onClick=\"Javascript:showDetail('"+groupId+"')\">详细</a>
	       	
       	}else {//当不存在记录时
			cell.innerHTML="&nbsp;";
		}
     }
    function locate(groupId) {
		var record = CpgGroupInf_dataset.find(["groupId"],[groupId]);
        if (record) {
			CpgGroupInf_dataset.setRecord(record);
		}
	}
	 function doDelete(groupId) {
        locate(groupId);
        var record = CpgGroupInf_dataset.find(["groupId"],[groupId]);
        var groupId=record.getValue("groupId");
		var url = "/fpages/msgplatform/ftl/RcvUserGroupInfo.ftl?type=delete&qgroupId="+groupId;
		showWin("接收用户组信息",url,"window","flushPage()",window);
    }
    function btModify(groupId){
        locate(groupId);
        var record = CpgGroupInf_dataset.find(["groupId"],[groupId]); 
        var groupId=record.getValue("groupId");  
		var url = "/fpages/msgplatform/ftl/RcvUserGroupInfo.ftl?type=update&qgroupId="+groupId;
		showWin("接收用户组信息",url,"window","flushPage()",window);
    }
    function btAdd_onClick(button){
		var url = "/fpages/msgplatform/ftl/RcvUserGroupInfo.ftl?type=addNewGroup";
		showWin("接收用户组信息",url,"window","flushPage()",window);
	}      
	function showDetail(groupId){
	    var record = CpgGroupInf_dataset.find(["groupId"],[groupId]);
	    var groupId=record.getValue("groupId"); 
        var url = "/fpages/msgplatform/ftl/RcvUserGroupInfo.ftl?type=detail&&gqroupId="+groupId;
		showWin("接收用户组信息",url,"window","flushPage()",window);
	}
    //刷新数据
	function flushPage(){
		CpgGroupInf_dataset.flushData(1);
	}
	
</script>
</@CommonQueryMacro.page>