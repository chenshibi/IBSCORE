<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >

<@CommonQueryMacro.page title="">
 <table align="left">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="CicsActinfoEntry" init="true" submitMode="current">
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
      			     <@CommonQueryMacro.DataTable id="datatable1" paginationbar="-,btAdd" fieldStr="opr[100],actNo[200],curCd[70],cmpCodeType[160],cmpCode[150],actName[300],actType[200],status[50],opnBranchCode[50],opnDate[100],clsDate[100],addr[200],post[100],tel[50],remarks[200]" width="100%" hasFrame="true" height="350" readonly="true" />
      			  </td>
      			 </tr>
      			<tr align="center">
	      			<td>
	      				<div style="display:none">
	      					<@CommonQueryMacro.Button id= "btMod"/>
	      					<@CommonQueryMacro.Button id= "btDel"/>
	      				 </div>
	      			</td>
      			</tr>
      		</table>
      	</@CommonQueryMacro.CommonQuery>
      </td>
   </tr>
   </table>
<script language="javascript">

	function btNewClick(){
	    CicsActinfoEntry_dataset.insertRecord("end");
		btNew.click();
	}

	//当系统刷新单元格的内容时被触发
	function datatable1_opr_onRefresh(cell,value,record) {
		var actNo = record.getValue("actNo");
		var lockStatus = record.getValue("lockStatus");
		if(!isTrue(lockStatus)){
			if (record) {//当存在记录时		
				var actNo = record.getValue("actNo");
				cell.innerHTML="<center><a href=\"JavaScript:doModify('"+actNo+"')\"><@bean.message key="CicsActinfoEntry.button.btMod" /></a>  &nbsp; <a href=\"JavaScript:doDelete('"+actNo+"')\"><@bean.message key="CicsActinfoEntry.button.btDel" />";
			} else {//当不存在记录时
			 cell.innerHTML="&nbsp;";
			}
		}
		else{
			cell.innerHTML="<center>记录已锁定</center>";
		}
	}
	
	//新增
	function btAdd_onClick(){
		window.location.href = "${contextPath}/fpages/account/ftl/CicsActinfoModAdd.ftl?op=new";
	}

	//定位一条记录
	function locate(actNo) {
		
		var record = CicsActinfoEntry_dataset.find(["actNo"],[actNo]);
		if (record) {
			CicsActinfoEntry_dataset.setRecord(record);
		}
	}

	//修改
	function doModify(actNo) {
		
		locate(actNo);
		btMod.click();
	}

	//删除
	function doDelete(actNo) {
		locate(actNo);

		if(confirm('是否删除当前记录'))
		{
			btDel.click();
		}
	}


</script>
</@CommonQueryMacro.page>