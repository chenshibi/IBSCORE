<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="日志明细报文导出">
<@CommonQueryMacro.CommonQuery id="logdownload" init="false" submitMode="current" navigate="false">
	<table align="left" width="100%">
     <tr>
      	<@CommonQueryMacro.Group id="group1" label="报文导出" colNm="2" fieldStr="searchDate" />
     </tr>
</table>
<table align="center">
			<tr>
    			<td width="50%">
					<@CommonQueryMacro.Button id= "downLoadind"/>&nbsp;&nbsp;  
    			</td>
    			<td width="50%">
					<@CommonQueryMacro.Button id= "downLoadcorp"/>&nbsp;&nbsp;  
    			</td>
    		</tr>
    	</table>
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">
function downLoadind_onClick(button){
	onClick(button);
}
function downLoadcorp_onClick(button){
	onClick(button);
}
function onClick(button){
	var dateString=logdownload_dataset.getValue("searchDate");
	if(dateString==""){
		alert("日期不能为空！");
		return false;
	}
	var year=dateString.getFullYear();
	var month = dateString.getMonth()+1;
	var day=dateString.getDate();
	if(month<10){
		month="0"+month;
	}
	if(day<10){
		day="0"+day;
	}
	var date=""+year+month+day;
	 dwr.engine.setAsync(false);
	 var flag=PrivAction.isFileNotExists(date,button.id);
	 dwr.engine.setAsync(false);
	 if(flag==true){
			window.location.href="${contextPath}/DownloadLogDetailsAction.do?date="+date+"&id="+button.id;
	 }else{
		 alert("The file does not exists!");
	 }
}

</script>
</@CommonQueryMacro.page>
