<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >

<@CommonQueryMacro.page title="">
 <table align="left" width="90%">
   <tr>
      <td>
      	<@CommonQueryMacro.CommonQuery id="SysNotice" init="true" submitMode="current">
      		<table width="100%">
      			<tr>
      			  <td valign="top">
      			    <@CommonQueryMacro.Interface id="interface" label="请输入查询条件" />
      			  </td>
      			</tr>
      			<tr>
      			  <td>
      			    <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" pageCache="false" showArrow="true"/>
      			  </td>
      			</tr>
      			<tr>
      			  <td>
      			     <@CommonQueryMacro.DataTable paginationbar="-,btNew" id="datatable1" fieldStr="noticeTitle[300],startDate[100],endDate[100],crtTm[180],crtTlr[120],st[120],opr[160]" width="100%" hasFrame="true"  readonly="true" />
      			  </td>
      			 </tr>
      			 <tr>
		    		<td>
	    			<@CommonQueryMacro.FloatWindow id="editWindow" label="" width="600px" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
	      				<div align="center">
	      					<@CommonQueryMacro.Group id="group1" label="系统公告维护"  fieldStr="startDate,endDate,noticeTitle,noticeContent" colNm=4/>
	        			 	<br />
	      					<center>
	      						<@CommonQueryMacro.Button id= "btSave"/>
	      					</center>
	      				</div>
	     			</@CommonQueryMacro.FloatWindow>
		    		</td>
		    	</tr>
      			 <tr style="display:none">
					<td colspan="2">
						<@CommonQueryMacro.Button id= "btMod"/>&nbsp;&nbsp;
						<@CommonQueryMacro.Button id= "btDel"/>
					</td>
				</tr>

      		</table>
      	</@CommonQueryMacro.CommonQuery>
      </td>
   </tr>
   </table>
<script language="javascript">

	//展示对比功能的js
	function datatable1_noticetitle_onRefresh(cell,value,record){
		if(record){
			var sta = record.getValue("st");
			var id=record.getValue("id");
			cell.innerHTML = "<a href=\"Javascript:showDetail('"+id+"','"+sta+"')\">"+value+"</a>";
		} else {
			cell.innerHTML = "&nbsp;";
		}
	}

	function showDetail(id, st){
		showWin("系统公告信息","/fpages/system/ftl/SysNoticeCompare.ftl?id=" + id + "&st=" + st,"","",window);
	}

	//当系统刷新单元格的内容时被触发
	function datatable1_opr_onRefresh(cell,value,record) {
		if (record) {//当存在记录时
			var sta = record.getValue("st");
			var htmlStr = "";
			if(sta == "4"){
				htmlStr="<center><a href=\"JavaScript:doModify('"+value+"')\">修改</a>&nbsp;<a href=\"JavaScript:doDelete('"+value+"')\">删除</a>";
			} else {
				htmlStr="<center><a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"记录已锁定，不能操作\">修改</a>&nbsp;<a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"记录已锁定，不能操作\">删除</a>";
			}
			htmlStr = htmlStr + "&nbsp;<a href=\"JavaScript:doDetail('"+value+"')\">详细</a></center>"
			cell.innerHTML=htmlStr;
		} else {//当不存在记录时
			cell.innerHTML="&nbsp;";
		}
	}

	function doDetail(id){
		showWin("系统公告详细信息","/fpages/system/ftl/SysNoticeDetail.ftl?id=" + id,"","",window);
	}

	//定位一条记录
	function locate(id) {
		var record = SysNotice_dataset.find(["id"],[id]);
		if (record) {
			SysNotice_dataset.setRecord(record);
		}
	}

	function btNew_onClick(button){
		subwindow_editWindow.show();
		SysNotice_dataset.setParameter("opType", "new");
	}

	//修改
	function doModify(id) {
		locate(id);
		subwindow_editWindow.show();
		SysNotice_dataset.setParameter("opType", "mod");
	}

	function doDelete(id){
		locate(id);
		SysNotice_dataset.setParameter("opType", "del");
		btDel.click();
	}

	function btDel_postSubmit(button){
		alert("操作成功！");
		SysNotice_dataset.flushData(1);
	}

	function btSave_postSubmit(button){
		subwindow_editWindow.close();
		SysNotice_dataset.flushData(1);
	}

	function editWindow_floatWindow_beforeClose(subwindow){
		 SysNotice_dataset.cancelRecord();
		 return true;
	}

	function editWindow_floatWindow_beforeHide(subwindow){
		return false;
	}

</script>
</@CommonQueryMacro.page>