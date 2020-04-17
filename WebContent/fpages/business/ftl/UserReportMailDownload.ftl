<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign bean=JspTaglibs["/WEB-INF/struts-bean.tld"] />
<@CommonQueryMacro.page title="邮件报表">
<table width="1366px" align="left">
<tr>
	<td>
	<@CommonQueryMacro.CommonQuery id="UserReportMailDownload" init="false" submitMode="current">
	<@CommonQueryMacro.GroupBox id="guoup10" label="Doubleful Message" expand="true">	
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
		</@CommonQueryMacro.GroupBox>
	</@CommonQueryMacro.CommonQuery>
	</td>
</tr>
</table>
<script language="javascript">
var page = "${statics["com.huateng.htaml.reportForm.util.ReportFormUtils"].PAGE_17}";
var page1= "${statics["com.huateng.htaml.reportForm.util.ReportFormUtils"].PAGE_16}";
	function btDownload_onClickCheck(){
		var reportDate = UserReportMailDownload_interface_dataset.getValue("reportDate");
		if(reportDate == null || reportDate == ""){
			alert("报表日期不能为空!");
			return false;
		}
}
	function btDownload_onClick(){
	var date = UserReportMailDownload_interface_dataset.getValue("reportDate");
	var year=date.getFullYear();
	var month=(date.getMonth()+1).toString();
	var day=(date.getDate()).toString();
	if(month.length==1){
	month="0"+month;
	}
	if(day.length==1){
	day="0"+day;
	}
	var reportDate=year+month+day;
	var usrList = true;
    dwr.engine.setAsync(false);
    
     PrivAction.getMsgMail(reportDate,
            function(data){
                   usrList = data;
            }
     );
     dwr.engine.setAsync(true);
     
            if(!usrList){
               alert("The file does not exists!");
            }else{
	window.location.href = "${contextPath}/reportForm/UserReportMailDownloadAction.do?page="+page+"&reportDate="+reportDate;
            }
	}
	

</script>
</@CommonQueryMacro.page>

