<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="AuditTrialReport">
<table width="1366px" align="left">
 	<tr>
      	<td>
			<@CommonQueryMacro.CommonQuery id="AuditTrialReportDownload" init="false" submitMode="current">
				<table width="100%">
					<tr>
						<td valign="top">
							<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" colNm=4 showButton="false" />
						</td>
					</tr>
					<tr>
						<td align="center">
							<br/>
							<@CommonQueryMacro.Button id= "btDownload"/>
						</td>
					</tr>
				</table>
			</@CommonQueryMacro.CommonQuery>
       	</td>
    </tr>
</table>	
<script language="javascript">
		var page = "${statics["com.huateng.htaml.reportForm.util.ReportFormUtils"].PAGE_07}";
	function btDownload_onClickCheck(){
		var reportDate = AuditTrialReportDownload_interface_dataset.getValue("reportDate");
		if(reportDate == null || reportDate == ""){
			alert("报表月份不能为空!");
			return false;
		}
		var date=new Date();
		
		 //获取年份  
        var year = date.getFullYear();  
        //获取月份  
        var month = date.getMonth() + 1;
        //获取日子  
        var day = date.getDate();  
        var thisDate=year+""+(month<10 ? "0" + month : month);
       if(thisDate<reportDate) {
        	alert("报表时间不能大于当前时间!");
        	return false;
        }
	}
	
	function btDownload_onClick(){
		var reportDate = AuditTrialReportDownload_interface_dataset.getValue("reportDate");
		var usrList = true;
	    dwr.engine.setAsync(false);
	    
		window.location.href = "${contextPath}/reportForm/AuditTrialReportDownloadAction.do?reportDate="+reportDate;
	}
</script>
</@CommonQueryMacro.page>

