<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="自然人对外担保查询">
<style>
	a:link,a:visited{font-size:16px}
	//a:hover,a:active{font-size:20px}
</style>
<@CommonQueryMacro.CommonQuery id="AssureIndRequest" init="false" submitMode="current" navigate="false">
	<table align="left" width="100%">
     <tr valign="center">
       			<td valign="top">
					<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
				</td>
     </tr>
     <tr>
      		<td valign="top">
      			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
      		</td>
	 </tr>
     <tr>
      		<td>
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="opr[350],rptKey,individualIdType,individualId[120],name,inputUser,inputTime[160],queryTime[160],returnTime[160],status,consentFilePath[200]" readonly="true" width="100%"/>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">
function AssureIndRequest_interface_dataset_btnSubmit_onClickCheck(){
	var individualId = AssureIndRequest_interface_dataset.getValue("individualId");
	var name = AssureIndRequest_interface_dataset.getValue("name");
	var MyQuery = AssureIndRequest_interface_dataset.getValue("MyQuery");
	if((name==null||name=="") &&(individualId==null||individualId=="") && (MyQuery==null||MyQuery=="")){
		alert("客户姓名、证件号、我的查询必须选填一个！");
		return false;
	}
}

//当系统刷新单元格的内容时被触发
function datatable1_opr_onRefresh(cell,value,record) {
	var rptKey=record.getValue("rptKey");
	var status=record.getValue("status");
	var queryTime=record.getValue("queryTime").format('yyyyMMdd HH:mm:ss');
	var id=record.getValue("id");
	var funcid1 = record.getValue("funcid1");//自然人对外担保汇总查询
	var funcid2 = record.getValue("funcid2");//自然人对外担保明细信息展开
	var funcid3 = record.getValue("funcid3");//个人信息核验
	var funcid4 = record.getValue("funcid4");//个人汇总报告
	var funcid5 = record.getValue("funcid5");//授权书下载
	var htmlStr = "<center>";
	if (record) {//当存在记录时
		htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"JavaScript:showPersonInfo('"+rptKey+"','"+status+"','"+queryTime+"')\">自然人对外担保汇总查询   </a>";
		htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"javascript:dodownload('"+rptKey+"')\">自然人对外担保明细信息展开  </a>";
		htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"JavaScript:dodownload1('"+id+"')\">授权书下载</a>";
		/**
		if("66661001"==funcid1){
		}
	
		if("66661002"==funcid2){
		}
		
		if("66661003"==funcid3){
			htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"JavaScript:showPersonInfoVerify('"+rptKey+"','"+status+"')\">个人信息核验</a>";
		}
		if("66661004"==funcid4){
			htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"JavaScript:showPersonSummaryReport('"+rptKey+"','"+status+"')\">个人汇总报告</a>";
		}
		if("66661005"==funcid5){
		}
		*/
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}
function dodownload(rptKey){
	if("" != rptKey&& null != rptKey ){
		dwr.engine.setAsync(false);
		var flag=PrivAction.assureDownloadReport(rptKey);
		dwr.engine.setAsync(false);
		if(flag=="1"){
		 	var paramMap = new Map();
		 	paramMap.put("rptKey",rptKey);
			window.location.href="${contextPath}/DownloadAssureCustAction.do?rptKey="+rptKey;
		}else{
			alert("The file does not exists！");
		}
	}else{
		alert("报告不存在！");
	}
	
}

function dodownload1(id){
	dwr.engine.setAsync(false);
	var flag=PrivAction.assureDownloadPermit(id);
	dwr.engine.setAsync(false);
	if(flag=="1"){
		var paramMap = new Map();
		paramMap.put("id",id);
		window.location.href="${contextPath}/DownloadAssureUserPermitAction.do?id="+id;}
	else{
		alert("The file does not exists！");
	}
	 
}	
	//自然人对外担保汇总查询
	function showPersonInfo(rptKey,status,queryTime){
		if("" != rptKey && null != rptKey){
				 var paramMap = new Map();
			 paramMap.put("rptKey",rptKey);
			 paramMap.put("queryTime",queryTime);
			 paramMap.put("type",1);
			 if("6"!=status){
			var url = "/fpages/assure/ftl/AssureIndCustTotalNew.ftl?rptKey="+rptKey+"&queryTime="+queryTime+"&type=1";
			showWin("自然人对外担保汇总", url, "window", "flushPage()", window);
			 }
			 else{
				 alert("查无此人");
			 }
		}else{
				alert("报告不存在！");
		}
		
}
	//PersonInfoVerify.ftl
	function showPersonInfoVerify(rptKey,status){
		if("" != rptKey && null != rptKey){
		var paramMap = new Map();
		 paramMap.put("rptKey",rptKey);
		 paramMap.put("type",2);
		 if("6"!=status){
		//loadPageWindows("partWin","查看明细","/fpages/business/ftl/PersonInfoVerify.ftl", paramMap, "winZone");
		var url = "/fpages/business/ftl/PersonInfoVerify.ftl?rptKey="+rptKey+"&type=2";
		showWin("个人信息校验", url, "window", "flushPage()", window);
		 }
		 else{
			 alert("查无此人");
		 }
	}else{
			alert("报告不存在！");
	}
		 
}
	//PersonSummaryReport.ftl
	function showPersonSummaryReport(rptKey,status){
	if("" != rptKey && null != rptKey){
		 var paramMap = new Map();
		 paramMap.put("rptKey",rptKey);
		 if("6"!=status){
//		loadPageWindows("partWin","查看明细","/fpages/business/ftl/PersonSummaryReport.ftl", paramMap, "winZone");
		var url = "/fpages/business/ftl/PersonSummaryReport.ftl?rptKey="+rptKey;
		showWin("个人汇总报告", url, "window", "flushPage()", window);
		 }
		 else{
			 alert("查无此人");
		 }
	}else{
		alert("报告不存在！");
	}
		
}
</script>
</@CommonQueryMacro.page>
