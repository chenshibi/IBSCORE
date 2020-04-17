<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="指令相关报表">
<table width="1366px" align="left">
 	<tr>
      	<td>
			<@CommonQueryMacro.CommonQuery id="PersonalReportFormdownload" init="false" submitMode="current">
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
		var page = "${statics["com.huateng.htaml.reportForm.util.ReportFormUtils"].PAGE_06}";
	function btDownload_onClickCheck(){
		var reportDate = PersonalReportFormdownload_interface_dataset.getValue("reportDate");
		if(reportDate == null || reportDate == ""){
			alert("报表月份不能为空!");
			return false;
		}
		var date=new Date();
		 //获取年份  
        var year = date.getFullYear();  
        //获取月份  
        var month = date.getMonth() + 1; 
    /*     if(reportDate != (year.toString()+month.toString())){
        	alert("选择的当月文件不存在！");
        	return false;
        }*/
        //获取日子  
        var day = date.getDate();  
        var thisDate=year+""+(month<10 ? "0" + month : month);
        if(thisDate<reportDate) {
        	alert("报表时间不能大于当前时间!");
        	return false;
        }
		day=day<10 ? "0" + day : day;
		if(day=="01"&&year==reportDate.substring(0,4)&&thisDate==reportDate) {
			alert("报表数据暂未生成!");
			return false;
		}
	}
	
	function btDownload_onClick(){
		var reportDate = PersonalReportFormdownload_interface_dataset.getValue("reportDate");
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

