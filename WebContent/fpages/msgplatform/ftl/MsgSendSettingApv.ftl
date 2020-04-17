<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="消息发送配置维护审核">
<table align="left">
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="MsgSndSetting" init="false" submitMode="selected">
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
						<@CommonQueryMacro.DataTable id="datatable1" paginationbar="btAudit" fieldStr="select,msgId[200],msgName[250],optType,creator1,createdDate1[150],opr" width="100%"/>
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
	function initCallGetter_pre(){
		MsgSndSetting_dataset.setParameter("pageType","checkPage");
	}
	var _approveStatus = "";
	//将id列变成超链接,需要记录类型,操作说明,原纪录主键,记录本身
	function datatable1_opr_onRefresh(cell, value, record){
		if(record){
			var msgId = record.getValue("msgId");
			cell.innerHTML = "<a href=\"Javascript:void(0);\" onClick=\"Javascript:showDetail('"+msgId+"')\">明细</a>";
		}else{
			cell.innerHTML = "";
		}
	}
    //刷新数据
	function flushPage(){
		MsgSndSetting_dataset.flushData(1);
	}
	function showDetail(msgId) {
		var record = MsgSndSetting_dataset.find(["msgId"],[msgId]);
		var msgId = record.getValue("msgId");
		var optType = record.getValue("optType");
		var url = "url";
		if(optType == '3'){
			//pageType = entryPage
			url = "/fpages/msgplatform/ftl/MsgSendSettingDtl.ftl?type=detail&msgId="+msgId+"&pageType=entryPage";
		}else{
			//pageType = checkPage
			url = "/fpages/msgplatform/ftl/MsgSendSettingDtl.ftl?type=detail&msgId="+msgId+"&pageType=checkPage";
		}
		showWin("接收用户信息",url,"window","flushPage()",window);
	}

    function btCancel_onClick(){
       subwindow_floatWindowAudit.close();
    }
	//审核
	function btAudit_onClick() {
		var hasSelected = false;
		var hasAudit = false;
		var hasRegcapitals = true;		
		var record =MsgSndSetting_dataset.getFirstRecord();
			while(record){
				var v_selected = record.getValue("select");
				
				if( v_selected == true ){
					hasSelected=true;
				}
				record=record.getNextRecord();
		   	}
		   	if (!hasSelected) {
		   		alert("请选择相应的记录！");
		   		return false;
		   	}
		subwindow_floatWindowAudit.show();
	}

	function btConfirm_onClickCheck() {

			var approveStatusChoose = MsgSndSetting_dataset.getValue("approveStatusChoose");
		   	var approveResultChoose = MsgSndSetting_dataset.getValue("approveResultChoose");
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
		   	MsgSndSetting_dataset.setParameter("approveStatusChoose",approveStatusChoose);
		   	MsgSndSetting_dataset.setParameter("approveResultChoose",approveResultChoose);
			subwindow_floatWindowAudit.hide();
	}

	//返回
	function btBack_onClick(){

		subwindow_floatWindowDetail.close();
	}
    function btConfirm_postSubmit(button){
	    alert("审核成功");
		MsgSndSetting_dataset.flushData(MsgSndSetting_dataset.pageIndex);
	}
</script>
</@CommonQueryMacro.page>