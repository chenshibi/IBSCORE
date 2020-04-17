<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>

<@CommonQueryMacro.page title="原始个人征信报告查询">
<style>
	a:link,a:visited{font-size:16px}
	//a:hover,a:active{font-size:20px}
</style>
<@CommonQueryMacro.CommonQuery id="InqRequest" init="false" submitMode="current" navigate="false">
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
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="opr[350],rptId[150],idType[100],individualId[120],name[100],status,queryReason[150],inqCustType[100],createTime[120],createUser[100],returnTime[120],consentFilePath[200],relCorpId,relName,down[300]" readonly="true" width="100%"/>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">
function InqRequest_interface_dataset_btnSubmit_onClickCheck(){
	var individualId = InqRequest_interface_dataset.getValue("individualId");
	var name = InqRequest_interface_dataset.getValue("name");
	var rptId = InqRequest_interface_dataset.getValue("rptId");
	var MyQuery = InqRequest_interface_dataset.getValue("MyQuery");
	if((individualId==null||individualId=="")&&(name==null||name=="")
	&&(rptId==null||rptId=="")&&(MyQuery==null||MyQuery=="")){
		alert("请至少选填一个查询条件！");
		return false;
	}
}

function datatable1_down_onRefresh(cell,value,record) {
	var nonWorkhourFilepath=record.getValue("nonWorkhourFilepath");
	var nonWorkhourFile=nonWorkhourFilepath.substring(nonWorkhourFilepath.lastIndexOf("\/")+1,nonWorkhourFilepath.length);
	var htmlStr = "<center>";
	htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"JavaScript:downNonWorkFile('"+nonWorkhourFilepath+"')\">"+nonWorkhourFile+"</a>";
	cell.innerHTML=htmlStr;
	
}

//当系统刷新单元格的内容时被触发
function datatable1_opr_onRefresh(cell,value,record) {
	var rptId=record.getValue("rptId");
	var status=record.getValue("status");
	var id=record.getValue("id");
	var funcid1 = record.getValue("funcid1");//原始个人征信报告
	var funcid2 = record.getValue("funcid2");//个人信息汇总
	var funcid3 = record.getValue("funcid3");//个人信息核验
	var funcid4 = record.getValue("funcid4");//个人汇总报告
	var funcid5 = record.getValue("funcid5");//用户许可下载 
	var htmlStr = "<center>";
	var ccreturnTime=record.getValue("returnTime").format("yyyyMMdd HH:mm:ss");
	var tlrno = "${v_tlrno}";
	dwr.engine.setAsync(false);
    var flag=PrivAction.haveRole(tlrno,ccreturnTime,"ind");    //30天内或有权限
 	dwr.engine.setAsync(false);
	if (record) {//当存在记录时
		if(flag){
		
		if("66661001"==funcid1){
			htmlStr=htmlStr+"<a href=\"javascript:dodownload('"+rptId+"','"+status+"')\">原始个人征信报告</a>";
		}
		if("66661002"==funcid2){
			htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"JavaScript:showPersonInfo('"+rptId+"','"+status+"')\">个人信息汇总</a>";
		}
		if("66661003"==funcid3){
			htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"JavaScript:showPersonInfoVerify('"+rptId+"','"+status+"')\">个人信息核验</a>";
		}
		if("66661004"==funcid4){
			htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"JavaScript:showPersonSummaryReport('"+rptId+"','"+status+"')\">个人汇总报告</a>";
		}
		}
		if("66661005"==funcid5){
			htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"JavaScript:dodownload1('"+id+"')\">查询授权书下载</a>";
		}
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function downNonWorkFile(nonWorkhourFilepath){
	window.location.href="${contextPath}/DownloadNonWorkFileAction.do?nonWorkhourFilepath="+nonWorkhourFilepath;
	}
function dodownload(rptId,status){
	var flag=PrivAction.test3(rptId);

	if(status!="0"){
		alert("未成功查询!");
	}else
	if("" != rptId&& null != rptId ){
		dwr.engine.setAsync(false);
		var flag=PrivAction.test3(rptId);
		dwr.engine.setAsync(false);
		if(flag=="1"){
	 	var paramMap = new Map();
	 	paramMap.put("rptId",rptId);
		window.location.href="${contextPath}/DownloadInqCustAction.do?rptId="+rptId;}
		else{
			alert("The file does not exists！");
		}
	}else{
		alert("报告不存在！");
	}
	
}

function dodownload1(id){
	dwr.engine.setAsync(false);
	var flag=PrivAction.test4(id);
	dwr.engine.setAsync(false);
	if(flag=="1"){
		var paramMap = new Map();
		paramMap.put("id",id);
		window.location.href="${contextPath}/DownloadUserPermitAction.do?id="+id;}
	else{
		alert("The file does not exists！");
	}
	 
}
	function showPersonInfo(rptId,status){
		if(status!="0"){
			alert("未成功查询!");
		}else
		if("" != rptId && null != rptId){
				 var paramMap = new Map();
			 paramMap.put("rptId",rptId);
			 paramMap.put("type",1);
			 if("6"!=status){
			//loadPageWindows("partWin","查看明细","/fpages/business/ftl/PersonInfoTotal.ftl", paramMap, "winZone");
			//loadPageWindows("partWin","查看明细","/fpages/business/ftl/PersonInfoTotalNew.ftl", paramMap, "winZone");
			//window.location.href="${contextPath}/fpages/business/ftl/PersonInfoTotalNew.ftl?rptId="+rptId+"&type=1";
			var url = "/fpages/business/ftl/PersonInfoTotalNew.ftl?rptId="+rptId+"&type=1";
			showWin("个人信息汇总", url, "window", "flushPage()", window);
			 }
			 else{
				 alert("查无此人");
			 }
		}else{
				alert("报告不存在！");
		}
		
}
	//PersonInfoVerify.ftl
	function showPersonInfoVerify(rptId,status){
		if(status!="0"){
			alert("未成功查询!");
		}else
		if("" != rptId && null != rptId){
		var paramMap = new Map();
		 paramMap.put("rptId",rptId);
		 paramMap.put("type",2);
		 if("6"!=status){
		//loadPageWindows("partWin","查看明细","/fpages/business/ftl/PersonInfoVerify.ftl", paramMap, "winZone");
		var url = "/fpages/business/ftl/PersonInfoVerify.ftl?rptId="+rptId+"&type=2";
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
	function showPersonSummaryReport(rptId,status){
		if(status!="0"){
			alert("未成功查询!");
		}else
	if("" != rptId && null != rptId){
		 var paramMap = new Map();
		 paramMap.put("rptId",rptId);
		 if("6"!=status){
//		loadPageWindows("partWin","查看明细","/fpages/business/ftl/PersonSummaryReport.ftl", paramMap, "winZone");
		var url = "/fpages/business/ftl/PersonSummaryReport.ftl?rptId="+rptId;
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
