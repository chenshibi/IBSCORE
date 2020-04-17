<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>

<@CommonQueryMacro.page title="">
 <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="CicsActinfoCheck" init="true" submitMode="selected">
      		<table width="100%">

      			<tr>
      			  <td colspan="2" valign="top">
      			    <@CommonQueryMacro.Interface id="interface" label="CicsActinfoEntry.interface.interface.label" />
      			  </td>
      			</tr>

      			<tr>

      			  <td>
      			    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
      			  </td>
      			</tr>
      			<tr>
      			  <td colspan="2">
      			     <@CommonQueryMacro.DataTable id="datatable1" paginationbar="btAudit"  fieldStr="select,actionType[60],maker[80],actNo[200],curCd[70],cmpCodeType[160],cmpCode[150],actName[300],actType[200],status[50],opnBranchCode[50],opnDate[100],clsDate[100],addr[200],post[100],tel[50],remarks[200]" width="100%" hasFrame="true" height="350" readonly="true" />
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
<script language="javascript">

	function btCancel_onClick(){
	    subwindow_floatWindowAudit.close();
	}



	function btAudit_onClick() {
		var hasSelected = false;	
		var tlrno = "${v_tlrno}";
		if(tlrno==null||tlrno==""){
			alert("获取当前操作员信息失败！");
			return false;
		}
		var record = CicsActinfoCheck_dataset.getFirstRecord();
		while(record){
			var v_selected = record.getValue("select");
			if( v_selected == true ){
				hasSelected=true;
				if(tlrno==record.getValue("maker")){
					alert("存在由您修改的记录,审核和修改不能同一人！");
					return false;
				}
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

		var approveStatusChoose = CicsActinfoCheck_dataset.getValue("approveStatusChoose");
	   	var approveResultChoose = CicsActinfoCheck_dataset.getValue("approveResultChoose");
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
	   	CicsActinfoCheck_dataset.setParameter("approveStatusChoose",approveStatusChoose);
	   	CicsActinfoCheck_dataset.setParameter("approveResultChoose",approveResultChoose);
		subwindow_floatWindowAudit.hide();
		
	}
	
	function btConfirm_postSubmit(){
		subwindow_floatWindowAudit.close();
		CicsActinfoCheck_dataset.flushData(1);
		alert("审核结束");
	}


</script>
</@CommonQueryMacro.page>