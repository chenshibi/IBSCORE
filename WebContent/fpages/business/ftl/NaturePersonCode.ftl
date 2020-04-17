<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="自然人中征码查询">
<@CommonQueryMacro.CommonQuery id="NaturePersonCode" init="false" submitMode="all" navigate="false" insertOnEmpty="true">
<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
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
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="opr[200],name,individualIdType,individualId,inputUser,inputTime,queryTime,returnTime,status" readonly="true" width="100%"/>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.GroupBox>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

//当系统刷新单元格的内容时被触发
function datatable1_opr_onRefresh(cell,value,record) {
	var individualId=record.getValue("individualId");
	var queryTime=record.getValue("queryTime");
	var queryTime2=record.getValue("queryTime").format('yyyyMMdd HH:mm:ss');
	var rptKey=record.getValue("rptKey");
	var year=queryTime.getFullYear();
	var month = queryTime.getMonth()+1;
	var day=queryTime.getDate();
	if(month<10){
		month="0"+month;
	}
	if(day<10){
		day="0"+day;
	}
	var date=""+year+month+day;
	var htmlStr = "<center>";
	
	if (record) {//当存在记录时
		
			htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"JavaScript:showPersonInfo('"+rptKey+"','"+queryTime2+"')\">自然人中征码汇总查询   </a>";
			htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"JavaScript:dodownload('"+individualId+"','"+date+"','"+rptKey+"')\">查询结果下载</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function dodownload(individualId,queryTime,rptKey){
	dwr.engine.setAsync(false);
	var flag=PrivAction.isNatureExist(individualId,queryTime,rptKey);
	dwr.engine.setAsync(false);
	if(flag){
		window.location.href="${contextPath}/DownloadNatureAction.do?individualId="+individualId+"&queryTime="+queryTime+"&rptKey="+rptKey;}
	else{
		alert("The file does not exists！");
	}
	 
}
function NaturePersonCode_interface_dataset_btnSubmit_onClickCheck(){
	var individualId = NaturePersonCode_interface_dataset.getValue("individualId");
	var myQuery = NaturePersonCode_interface_dataset.getValue("MyQuery");
	if((individualId==null||individualId=="")&&(myQuery==null||myQuery=="")){
		alert("证件号和我的查询必须选填一个！");
		return false;
	}
}

//自然人对外担保中证码汇总查询
function showPersonInfo(rptKey,queryTime2){
	if("" != rptKey && null != rptKey){
			 var paramMap = new Map();
		 paramMap.put("rptKey",rptKey);
		 paramMap.put("queryTime2",queryTime2);
		 if("6"!=status){
			var url = "/fpages/assure/ftl/AssureLoanCardTotalNew.ftl?rptKey="+rptKey+"&queryTime2="+queryTime2;
			showWin("自然人中征码汇总", url, "window", "flushPage()", window);
		 }
		 else{
			 alert("查无此人");
		 }
	}else{
			alert("报告不存在！");
	}
	
}
   
    function btSave_postSubmit(button){
   		alert("提交成功！");
	}
</script>
</@CommonQueryMacro.page>
