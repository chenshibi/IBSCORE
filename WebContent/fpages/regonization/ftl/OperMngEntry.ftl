<#import "/templets/commonQuery/CommonQueryTagMacroMng.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="操作员管理">
<@CommonQueryMacro.CommonQuery id="operMngEntry" init="false" submitMode="current">
<table width="100%">
	<tr valign="center">
		<td valign="top" colspan="2">
			<@CommonQueryMacro.Interface id="intface" label="Please enter the query condition" colNm=6 />
		</td>
	</tr>
  	<tr>
  		<td valign="top">
			<@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
		</td>
	
	 </tr>
	 <tr>
		 <td colspan="2">
			<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="-,btAdd,-,btStatus,-,btResetPwd,btLoginStatus,btSt" fieldStr="tlrno[60],tlrName[150],gwxx[400],flag[60],status[100],lastaccesstm[130],lastlogouttm[150],opr[100]"  readonly="true" width="100%" hasFrame="true"  />
		 </td>
	 </tr>
	 <tr align="center">
		<td>
			<div style="display:none">
				<@CommonQueryMacro.Button id= "btDel" />
				<@CommonQueryMacro.Button id= "btModify"/>
				<@CommonQueryMacro.Button id= "btAuth"/>
				<@CommonQueryMacro.Button id= "btResetPwd"/>
			 </div>
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	var currentTlrno = "${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}";
	//定位一条记录
	function locate(id) {
		var record = operMngEntry_dataset.find(["tlrno"],[id]);
		if (record) {
			operMngEntry_dataset.setRecord(record);
		}
	}

	function datatable1_opr_onRefresh(cell, value, record)
	{
		if(record&&record!=null){

			var id = record.getValue("tlrno");
			var branchId = record.getValue("tlrno");
			var st = record.getValue("st");
			var innerStr = "<PRE>";
			var status = record.getValue("flag");
			//alert(status);
			if (st == "1"  || st == "3"|| status == '0') {
				innerStr = innerStr + "<a style=\"color:#666666\" title=\"The record is locked and cannot be operated\">modify</a> " +"</PRE>";//记录已锁定，不能操作   修改
		    } else {
		    	innerStr = innerStr + " <a href=\"JavaScript:btModifyShow('"+id+"')\">modify</a>" +"</PRE>";
		    }
		    cell.innerHTML = innerStr;
		}else{
			cell.innerHTML = "";
		}
	}
	
	
	function btStatus_onClickCheck(button) {
		var flag = operMngEntry_dataset.getValue("flag");
		if(flag == '0'){
			if(confirm("Confirm that the operator is set to be valid?")){//确认将该操作员设置为有效
			    operMngEntry_dataset.setParameter("flag", "1");
				return true;
			}else{
				return false;
			}
		} else {
			if(confirm("Confirm that the operator is set to be invalid?")){//确认将该操作员设置为无效?
				operMngEntry_dataset.setParameter("flag", "0");
				return true;
			}else{
				return false;
			}
		}
	}
	
		function btSt_onClickCheck(button) {
		var status = operMngEntry_dataset.getValue("status");
		if(status == '0'){
			if(confirm("Confirm that the operator is set to be disable?")){//确认将该操作员设置为有效
			    operMngEntry_dataset.setParameter("statu", "2");
				return true;
			}else{
				return false;
			}
		}else if(status == '1'){
			alert("This account has been logged on,please exit and then operate!");
			 return false;
		} else if(status == '2'){
				//alert("该操作员已离职");
				//return false;
			if(confirm("Confirm that the operator is set to be recover?")){//确认将该操作员设置为有效
			    operMngEntry_dataset.setParameter("statu", "0");
				return true;
			}else{
				return false;
			}
		}
	}
	function btStatus_postSubmit(button) {
		alert("Set up success");//设置成功
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
	}
	function btSt_postSubmit(button) {
		alert("Set up success");//设置成功
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
	}
	

	
	/*
	//add by zhangdianchao 20160323 将有效/无效按钮 改为删除 start
	function btStatus_onClickCheck(button) {
		if(confirm("Confirm the deletion of the operator?")){//确认删除该操作员
			operMngEntry_dataset.setParameter("statu", "0");
			return true;
		}else{
			return false;
		}
	}
	
	function btStatus_postSubmit(button) {
		alert("Submitted audits");//已提交审核
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
	}*/
	//add by zhangdianchao 20160323 将有效/无效按钮 改为删除 end
	
	function btLoginStatus_onClickCheck(button){
		if(confirm("The operator forcibly return confirmation?")){//确认将该操作员强行签退
			operMngEntry_dataset.setParameter("statu","logout");
			return true;
		}else{
			return false;
		}
	}
	function btLoginStatus_postSubmit(button){
		alert("Return success");//签退成功
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
	}

//	function operMngEntry_dataset_dataset_afterScroll(dataset){
//		unLock.disable(dataset.getValue("isLock") != '1' || dataset.getValue("tlrno") == currentTlrno);
//	}

	//新增
	function btAdd_onClick(){
		window.location.href = "${contextPath}/fpages/regonization/ftl/OperMngRoleInfo.ftl?op=new";
	}

	//刷新数据
	function flushPage(){
		bopAccDsRecordAD_dataset.flushData();
	}

	function winZone_onCloseCheck(){
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
		return true;
	}

	function btModifyShow(tlrno){
	  	window.location.href = "${contextPath}/fpages/regonization/ftl/OperMngRoleInfo.ftl?op=modify&tlrno=" + tlrno;
	}

//	function btAuthShow(tlrno){
//		var paramMap = new Map();
//		var op = "auth";
//	  	paramMap.put("tlrno",tlrno);
//	  	paramMap.put("op",op);
//	  	loadPageWindows("userWin", "Role Setup", "/fpages/regonization/ftl/OperMngRoleInfo.ftl", paramMap, "winZone");
//	}



	function btResetPwd_onClickCheck(button){
			if(!confirm("Do you want to reset the passward?")){//是否要重置密码
				return false;
			}
	}

	function btResetPwd_postSubmit(button){
		var retParam = button.returnParam;
		//alert("密码重置成功,初始化为"+retParam.DefaultPWD);
		alert("Password reset success,lnitialize1qAZ@Wsx");//密码重置成功,初始化为1qAZ@Wsx
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
	}

//	function unLock_onClickCheck(button) {
//		operMngEntry_dataset.setParameter("tlrno",operMngEntry_dataset.getValue("tlrno"));
//	}
//	function unLock_postSubmit(button) {
//		alert("解锁成功！");
//		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
//	}


	function operMngEntry_dataset_afterScroll(dataset){
		//unLock.disable(dataset.getValue("isLock") != '1');
		//btLoginStatus.disable(dataset.getValue("status") != '1');
		btStatus.disable(false);
		if(dataset.getValue("tlrno") == currentTlrno){
			btStatus.disable(true);
			//unLock.disable(true);
			//btLoginStatus.disable(true);
		}
		var st = dataset.getValue("st");
		if (st == "1" || st == "2" || st == "3") {
			//btStatus.disable(true);
			//unLock.disable(true);
			//btLoginStatus.disable(true);
		}
	}

	//展示对比功能的js
	function datatable1_tlrno_onRefresh(cell, value, record){
		if(record!=null){
			var sta = record.getValue("st");
			var tlrno=record.getValue("tlrno");


			cell.innerHTML = "<a href=\"Javascript:showDetail('"+tlrno+"','"+sta+"')\">"+tlrno+"</a>";

		} else {
			cell.innerHTML = ""
		}
	}


	function showDetail(tlrno,sta){
		showWin("User Details", "/fpages/regonization/ftl/OperMngRoleCompare.ftl?id="+tlrno+"&st=1&flag=0","","",window);
	}
	function btRecover_postSubmit(button) {
		alert("Set up success");//设置成功
		operMngEntry_dataset.flushData(operMngEntry_dataset.pageIndex);
	}
	
	function btRecover_onClickCheck(button) {
		if(!confirm("Do you want to restore the selected operator?")){//是否要对选中的操作员进行恢复
			return false;
		}
	}
</script>
</@CommonQueryMacro.page>
