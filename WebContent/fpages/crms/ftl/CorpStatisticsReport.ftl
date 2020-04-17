<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="二代企业征信统计报表">
		<@CommonQueryMacro.CommonQuery id="CorpStatisticsReport" init="false" submitMode="current" navigate="false" >
			<table align="left"  width="100%">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件"   colNm="2"/>
					</td>
				</tr>

				<tr>
					<td valign="top">
						<@CommonQueryMacro.PagePilot id="pagequery" maxpagelink="10" showArrow="true" />
					</td>
		    	</tr>

		    	<tr >
		    		<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable1" fitColumns="false" fieldStr="corpPermitId,entName,entCertType,entCertNum[200],queryReason,queryOrgCode,branch[200],userCode,serviceCode[100],queryDate,status,ip"  hasFrame="true" width="100%"/>
		      		</td>
		    	</tr>
		    	
		    	<tr align="center">
	      			<td>
	      				<div >
	      					<@CommonQueryMacro.Button id= "btDownload"/>					
	      				</div>
	      			</td>
      			</tr>
		    	
			</table>
		</@CommonQueryMacro.CommonQuery>
<script language="javascript">
	var page = "${statics["com.huateng.htaml.reportForm.util.ReportFormUtils"].PAGE_07}";	
		function btDownload_onClick(){
		var reportDate = CorpStatisticsReport_interface_dataset.getValue("reportDate");
		var usrList = true;
	    dwr.engine.setAsync(false);
	    
	     PrivAction.getMsg3(reportDate,
	            function(data){
	                   usrList = data;
	            }
	     );
	     dwr.engine.setAsync(true);
	     
	            if(!usrList){
	               alert("The file does not exists!");
	            }else{
		window.location.href = "${contextPath}/reportForm/DownloadReportFormAction.do?page="+page+"&reportDate="+reportDate;
	            }
	}
	
	
</script>		
</@CommonQueryMacro.page>
