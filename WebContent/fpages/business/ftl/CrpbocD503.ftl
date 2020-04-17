<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="新征信报告批量查询">
		<@CommonQueryMacro.CommonQuery id="CrpbocD503" init="false" submitMode="current" navigate="false" >
			<table align="left"  width="100%">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" colNm="4"/>
					</td>
				</tr>

				<tr>
					<td valign="top">
						<@CommonQueryMacro.PagePilot id="pagequery" maxpagelink="10" showArrow="true" />
					</td>
		    	</tr>

		    	<tr >
		    		<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable" paginationbar="importBN,-,modelDownload,-,rematch" fieldStr="rsv1[100],rsv3[200],requestid[100],entName[200],entCertNum[200],queryReason[100],createUser[100],createTime[100],status[100]"   width="100%"  readonly="true"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>

	<script language="JavaScript">
//导入数据
    var sysTxdate = ${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTxdate()?string("yyyyMMdd")};  
	function importBN_onClick(){
		currentSubWin = openSubWin("pageWinId", "批量导入查询请求文件", "/fpages/business/jsp/UpAllCrPbocD503.jsp?fileflag=CrPbocD503&workDate="+sysTxdate,"600","200");
	}
    
    function modelDownload_onClick(){
        var form = document.createElement("FORM");
        form.method = "post";
        form.action=_application_root +"/FileXLSXDownloadServlet";
        document.body.appendChild(form);
        form.submit();
    }
    
    //重新匹配
   	function rematch_onClick(){
  		if(confirm("确认要进行重新匹配吗？")){
  		var etlDateStart = CrpbocD503_interface_dataset.getString("etlDateStart");
		var etlDateEnd = CrpbocD503_interface_dataset.getString("etlDateEnd");
		var brcodeName= CrpbocD503_interface_dataset.getString("brcodeName");
	    var fileflag= "CrPbocD503";
		PrivAction.RematchMessage(etlDateStart,etlDateEnd,brcodeName,fileflag,selectFunction);	
		return true;
		}else{
			return false;
		}			
   	} 	
   	function selectFunction(msg){
   	  alert(msg);	
	}	
	
	</script>
</@CommonQueryMacro.page>