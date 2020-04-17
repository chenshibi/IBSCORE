<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="定时任务信息">
<@CommonQueryMacro.CommonQuery id="SystemTimedScheduler" init="false" submitMode="current">
<table width="100%">
  
    	<tr valign="center">
			<td valign="top" colspan="2">
				<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=6 />
			</td>
		</tr>
        <tr>
            <td valign="top">
                <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
            </td>

        </tr>
        </tr>    
	 <tr>
		 <td valign="top" colspan="2">
			<@CommonQueryMacro.DataTable id ="datatable1" fitColumns="true" fieldStr="jobName[240],sysName[150],jobTime[150],jobStauts[150],justWorkdateRun[150],jobRemark[200],opr[240]"  readonly="true" width="100%" hasFrame="true" />
			<br/>
		 </td>
	 </tr>
	 <tr>
	 	<td>
	 		<@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
      			<div align="center">
      				<@CommonQueryMacro.Group id="group1" label="定时任务信息修改"
        			  fieldStr="jobName,jobTime,jobStauts,justWorkdateRun,jobRemark" colNm=4/>
        			<br/>
        			<@CommonQueryMacro.Button id="btSave" />

      			</div>
     		</@CommonQueryMacro.FloatWindow>
	 	</td>
	 </tr>
	 <tr align="center">
		<td>
			<div style="display:none">
				<@CommonQueryMacro.Button id= "btJobStatus" />
				<@CommonQueryMacro.Button id= "btModify"/>
				<@CommonQueryMacro.Button id= "btStart"/>
			 </div>
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	//定位一条记录
	function locate(id) {
		var record = SystemTimedScheduler_dataset.find(["id"],[id]);
		if (record) {
			SystemTimedScheduler_dataset.setRecord(record);
		}
	}

	function datatable1_opr_onRefresh(cell, value, record)
	{
		if(record&&record!=null){
			var id = record.getValue("id");
			var jobStauts = record.getValue("jobStauts");
			var innerStr ="<center><a href=\"JavaScript:doStart('"+id+"')\">立即执行</a>&nbsp;&nbsp;" + "<a href=\"JavaScript:doModifyShow('"+id+"')\">修改</a>&nbsp;&nbsp;";
			//有效
			if (jobStauts == "1") {
				innerStr = innerStr + "<a style=\"color:#666666\" title=\"调度器已启动，不能操作\">启动</a>&nbsp;&nbsp;" +
		    		" <a href=\"JavaScript:doJobStatus('"+id+"','0')\">停止</a></center>";
		    } else {
		    	innerStr = innerStr + " <a href=\"JavaScript:doJobStatus('"+id+"','1')\">启动</a>&nbsp;&nbsp;" +
		    		"<a style=\"color:#666666\" title=\"调度器已停止，不能操作\">停止</a></center>";
		    }
		    cell.innerHTML = innerStr ;
		}else{
			cell.innerHTML = "";
		}
	}

	function doJobStatus(id, jobStatus){
		locate(id);
		SystemTimedScheduler_dataset.setParameter("id", id);
		SystemTimedScheduler_dataset.setParameter("jobStatus", jobStatus);
		btJobStatus.click();
	}

	function doModifyShow(id){
		locate(id);
		subwindow_signWindow.show();
	}

	function btSave_onClickCheck(){
		if (!SystemTimedScheduler_dataset.modified) {
			alert("请先修改后再保存！");
			return false;
		}
		return true;
	}

	function btSave_postSubmit(){
		alert("保存成功！");
		subwindow_signWindow.hide();
		SystemTimedScheduler_dataset.flushData(SystemTimedScheduler_dataset.pageIndex);
	}

	function btJobStatus_postSubmit(){
		alert("保存成功！");
		SystemTimedScheduler_dataset.flushData(SystemTimedScheduler_dataset.pageIndex);
	}
	function doStart(id){
		locate(id);
		SystemTimedScheduler_dataset.setParameter("id", id);
		btStart.click();
	}
	function btStart_postSubmit(){
		alert("执行成功！");
		SystemTimedScheduler_dataset.flushData(SystemTimedScheduler_dataset.pageIndex);
	}
	
	
</script>
</@CommonQueryMacro.page>
