<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="接收用户组维护审核">
<table align="left">
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="CpgGroupInfTmp" init="false" submitMode="selected">
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
						<@CommonQueryMacro.DataTable id="datatable1" paginationbar="btAudit" fieldStr="select,groupId,optType,groupName[250],creator1,createdDate1[150],checkUser1,checkDate1[150],opr" width="100%"/>
					</td>
				</tr>
				<tr>
      				<td colspan="2">
      				<@CommonQueryMacro.FloatWindow id="floatWindowAudit" label="" width="300" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      					<div align="center">
      						<@CommonQueryMacro.Group id="group1" label="审核信息" fieldStr="approveStatusChoose,approveResultChoose" colNm=2/>
        			  		<br />
        					<@CommonQueryMacro.Button id= "btConfirm"/>
        					<@CommonQueryMacro.Button id= "btCancel"/>
      					</div>
     		 		</@CommonQueryMacro.FloatWindow>
  					</td>
  				</tr>
			</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="JavaScript">
   var _approveStatus = "";
	//将id列变成超链接,需要记录类型,操作说明,原纪录主键,记录本身
	function datatable1_opr_onRefresh(cell, value, record){
		if(record){
			var groupId = record.getValue("groupId");
			cell.innerHTML = "<a href=\"Javascript:void(0);\" onClick=\"Javascript:showDetail('"+groupId+"')\">明细</a>";
		}else{
			cell.innerHTML = "";
		}
	}
    //刷新数据
	function flushPage(){
		CpgGroupInfTmp_dataset.flushData(1);
	}
	
	function showDetail(groupId) {
		var record = CpgGroupInfTmp_dataset.find(["groupId"],[groupId]);
		var groupId=record.getValue("groupId");
		var optType=record.getValue("optType");
		if(optType=="3"){
			//3-删除，删除操作加载主页面的明细页面
			var url = "/fpages/msgplatform/ftl/RcvUserGroupInfo.ftl?type=detail&&qgroupId="+groupId;
			showWin("接收用户组信息",url,"window","flushPage()",window);
		}else{
			//新增或修改时加载新页面的明细页面
			var url = "/fpages/msgplatform/ftl/RcvUserGroupTmpDtl.ftl?type=detail&qgroupId="+groupId;
			showWin("接收用户组信息",url,"window","flushPage()",window);
		}
	}

    function btCancel_onClick(){
       subwindow_floatWindowAudit.close();
    }
	//审核
	function btAudit_onClick() {
		var hasSelected = false;
		var hasAudit = false;
		var hasRegcapitals = true;		
		var record =CpgGroupInfTmp_dataset.getFirstRecord();
			while(record){
				var v_selected = record.getValue("select");
				var v_approveStatus = record.getValue("optStatus");
				
				if( v_selected == true ){
					hasSelected=true;
					if (v_approveStatus != "0") {
						hasAudit = true;
					}
				}
				record=record.getNextRecord();
		   	}
		   	if (!hasSelected) {
		   		alert("请选择相应的记录！");
		   		return false;
		   	}
		   	if (hasAudit) {
		   		if(!confirm("所选记录包含已审核记录，确定需重新审核吗？"))
				{
					return false;
				}
		   	}
			subwindow_floatWindowAudit.show();
	}



	function btConfirm_onClickCheck() {

			var approveStatusChoose = CpgGroupInfTmp_dataset.getValue("approveStatusChoose");
		   	var approveResultChoose = CpgGroupInfTmp_dataset.getValue("approveResultChoose");
		   	if (!approveStatusChoose.length > 0) {
		   		alert("请选择审核结果！");
		   		return false;
		   	}
		   	if (approveStatusChoose == "2" && approveResultChoose.length < 1) {
		   		alert("审核结果不通过，审核说明必须填写！");
		   		return false;
		   	}
		   	var reg = new RegExp("^((?!<|>).)*$");
		   	if(!reg.test(approveResultChoose)){
		   		alert("审核说明中不能包含“<”或者“>”");
		   		return false;
		   	}
		   	CpgGroupInfTmp_dataset.setParameter("approveStatusChoose",approveStatusChoose);
		   	CpgGroupInfTmp_dataset.setParameter("approveResultChoose",approveResultChoose);
			subwindow_floatWindowAudit.hide();
	}

	//返回
	function btBack_onClick(){

		subwindow_floatWindowDetail.close();
	}
    function btConfirm_postSubmit(button){
	    alert("审核成功");
		CpgGroupInfTmp_dataset.flushData(CpgGroupInfTmp_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>