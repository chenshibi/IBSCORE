<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<#--jianxue.zhang-->
<@CommonQueryMacro.page title="主管维护审核">
<table width="100%" align="left">
<tr>
<td>
<@CommonQueryMacro.CommonQuery id="UndoConfirm" init="false" submitMode="current">
	<table width="100%">
		<tr>
   			<td valign="top" colspan="2">
   			<@CommonQueryMacro.Interface id="interface" label="UndoConfirm.interface.interface.label" colNm=4 showButton="true" />
        	</td>
        </tr>
		<tr>
   			<td colspan="2">
   				<@CommonQueryMacro.PagePilot id="PagePilot"/>
   			</td>

  		</tr>
  		<tr>
      		<td colspan="2">
          		<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btDo,-,btSee" fieldStr="select,id[220],intInsId[200],adtRcdPk[200],updTransCd,intOperId,crtDt" width="100%"  readonly="true"/><br />
        	</td>
        </tr>

   </table>
</@CommonQueryMacro.CommonQuery>

</td>
</tr>
</table>

<script language="javascript" src="${contextPath}/js/topTsk.js"></script>
 <script language="javascript">
function initCallGetter_post() {
	 var intInsId = "${RequestParameters["intInsId"]?default('')}";
	 if(intInsId!=null && intInsId.length>0){
	 	UndoConfirm_interface_dataset.setValue("intInsId", intInsId);
	 	UndoConfirm_dataset.flushData(UndoConfirm_dataset.pageIndex);
	 }
 }

//定位一条记录
function locate(id) {
	var record = UndoConfirm_dataset.find(["id"],[id]);
	if (record) {
		UndoConfirm_dataset.setRecord(record);
	}
}
//将id列变成超链接,需要记录类型,操作说明,原纪录主键,记录本身
//TODO
 function datatable1_id_onRefresh(cell, value, record){
	if(record){
		var type = record.getValue("intInsId");
		var sta = record.getValue("updTransCd");
		var rcdpk = record.getValue("adtRcdPk");
		cell.innerHTML = "<a href=\"Javascript:void(0);\" onClick=\"Javascript:detail.showUodoTaskDetail('"+type+"','"+sta+"','"+rcdpk+"')\">"+value+"</a>";
	}else{
		cell.innerHTML = "";
	}
}
//点击办理按钮的检查,需要任务编号,业务类型,
function btDo_onClickCheck(button){
	var tlrno = "${v_tlrno}";
	var record = UndoConfirm_dataset.firstUnit;
	var chk=0;
	var bizArr = new Array();
	var taskIdArr = new Array();
	while(record){
		var temp = record.getValue("select");
		if(temp){
			bizArr[chk] = record.getValue("intInsId");
			if(tlrno==null||tlrno==""){
				alert("获取当前操作员信息失败！");
				return false;
			}
			if(tlrno==record.getValue("intOperId")){
				alert("记录存在由您修改的记录,审核和修改不能同一人！");
				return false;
			}
			taskIdArr[chk] = record.getValue("id");
			chk++;
		}
		record=record.nextUnit;
	}
	if(chk==0){
		alert("请选择要办理的记录!");
		return false;
	}

	var type = bizArr[0];
	for(var i=1;i<bizArr.length;i++){
		if(type!=bizArr[i]){
			alert("请选择相同业务种类进行办理!");
			return false;
		}
	}
	//将任务集合和业务类型传下去
	button.url = approve.getApprovePage(taskIdArr,type);
	return true;
}

</script>

</@CommonQueryMacro.page>