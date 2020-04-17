<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>

<@CommonQueryMacro.page title="二代个人信用信息查询">
<style>
	a:link,a:visited{font-size:16px}
	//a:hover,a:active{font-size:20px}
</style>
<@CommonQueryMacro.CommonQuery id="personReport3" init="false" submitMode="current" navigate="false">
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
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="opr[300],name[60],idType,idNum[120],queryReason,serviceCode,respId[200],respCode,respMsg,queryDate,createUser,createTime,checkUser,checkTime,sendTime,respTime,status,certAuthStatus,down[300]" readonly="true" width="100%"/>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">

function datatable1_down_onRefresh(cell,value,record) {
	var nonWorkhourFilepath=record.getValue("rsv3");
	var nonWorkhourFile=nonWorkhourFilepath.substring(nonWorkhourFilepath.lastIndexOf("\/")+1,nonWorkhourFilepath.length);
	var htmlStr = "<center>";
	htmlStr=htmlStr+"&nbsp;&nbsp;<a href=\"JavaScript:downNonWorkFile('"+nonWorkhourFilepath+"')\">"+nonWorkhourFile+"</a>";
	cell.innerHTML=htmlStr;
	
}

function downNonWorkFile(nonWorkhourFilepath){
	window.location.href="${contextPath}/DownloadNonWorkFileAction.do?nonWorkhourFilepath="+nonWorkhourFilepath;
}

 function personReport3_interface_dataset_btnSubmit_onClickCheck(){
	var idNum = personReport3_interface_dataset.getValue("idNum");
	var name = personReport3_interface_dataset.getValue("name");
	var rptId = personReport3_interface_dataset.getValue("respId");
	var MyQuery = personReport3_interface_dataset.getValue("MyQuery");
	if((idNum==null||idNum=="")&&(name==null||name=="")
	&&(rptId==null||rptId=="")&&(MyQuery==null||MyQuery=="")){
		alert("请至少选填一个查询条件！");
		return false;
	}
}
<#--将opr列变成超链接,需要记录类型,操作说明,原纪录主键,记录本身-->
	function datatable1_opr_onRefresh(cell, value, record){
		var idType=record.getValue("idType");
	    var idNum=record.getValue("idNum");
	    var queryReason=record.getValue("queryReason");
	    var serviceCode=record.getValue("serviceCode");
		var respId=record.getValue("respId");
		var status=record.getValue("status");
		var respTime=record.getValue("respTime");
		var name=record.getValue("name");
		var rsv2=record.getValue("rsv2");
		
		var funcid1 = record.getValue("funcid1");//原始个人征信报告
		var funcid2 = record.getValue("funcid2");//二代个人征信报告
		var funcid3 = record.getValue("funcid3");//二代个人信息核验
		var funcid4 = record.getValue("funcid4");//二代个人汇总报告
		var funcid5 = record.getValue("funcid5");//查询授权书下载
		var funcid6 = record.getValue("funcid6");//二代个人信贷交易明细
		var funcid7 = record.getValue("funcid7");//二代个人信息汇总
		var htmlStr = "<center>";
		var tlrno = "${v_tlrno}";
		dwr.engine.setAsync(false);
		//var flag=PrivAction.haveRole(tlrno,respTime,"corp");    //30天内或有权限
		//dwr.engine.setAsync(false);
		
		if(record) {//当存在记录时
			//if(flag){
				if("66661801"==funcid1){
					//htmlStr=htmlStr+"<a href=\"javascript:showReport1('"+respId+"','"+status+"')\">原始二代个人征信报告</a>"
					htmlStr=htmlStr+"<a href=\"javascript:dodownload('"+respId+"','"+status+"')\">原始二代个人征信报告</a>"
				}
				if("66661802"==funcid2){
					htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:showReport2('"+respId+"','"+status+"')\">二代个人信息汇总</a>"
				}
			//	if("66661807"==funcid7){
		//			htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:showReport7('"+respId+"','"+status+"')\">二代个人信息汇总</a>"
			//	}
				if("66661803"==funcid3){
					htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:showReport3('"+respId+"','"+status+"')\">二代个人信息核验</a>"
				}
			//	if("66661804"==funcid4){
			//		htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:showReport4('"+respId+"','"+status+"')\">二代个人汇总报告</a>"
			//	}
			//	if("66661806"==funcid6){
			//		htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:showReport6('"+respId+"','"+status+"')\">二代个人信贷交易明细</a>"
		//		}
			//}
			if("66661805"==funcid5){
				htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:queryDownload('"+idNum+"','"+idType+"')\">查询授权书下载</a>"
			}
			cell.innerHTML=htmlStr
		}
		else {//当不存在记录时
			cell.innerHTML="&nbsp"
		}
	}
	
	<#-- 原始个人征信报告(未脱敏)-->
	function showReport1(respId,status){
  		if (status != "03"){
  			alert ("未查询成功！");
  		}else 
  			if("" != respId && null != respId){
		 		var params = {};
        		params.uuid=respId;
		 		alert("查询成功！即将跳到显示页面");
		 		openWindowWithPost("${contextPath}/PersonalReportServlet2", params);
		 		
  			}
  			else{
  			alert("报告不存在！");
  			}
	}
	<#-- 二代个人征信报告(已脱敏)-->
	function showReport2(respId,status){
  		if (status != "03"){
  			alert ("未查询成功！");
  		}else 
  			if("" != respId && null != respId){
		 		var params = {};
        		params.uuid=respId;
		 		alert("查询成功！即将跳到显示页面");
		 		openWindowWithPost("${contextPath}/PersonalReportServlet", params);
		 		
  			}
  			else{
  			alert("报告不存在！");
  			}
	}
	
	<#-- 个人信息核验-->
	function showReport3(respId,status){
  		if (status != "03"){
  			alert ("未查询成功！");
  		}else 
  			if("" != respId && null != respId){
		 		var params = {};
        		params.uuid=respId;
		 		alert("查询成功！即将跳到显示页面");
		 		openWindowWithPost("${contextPath}/PersonalReportServlet3", params);
		 		
  			}
  			else{
  			alert("报告不存在！");
  			}
	}
	<#-- 个人汇总报告-->
	function showReport4(respId,status){
  		if (status != "03"){
  			alert ("未查询成功！");
  		}else 
  			if("" != respId && null != respId){
		 		var params = {};
        		params.uuid=respId;
		 		alert("查询成功！即将跳到显示页面");
		 		openWindowWithPost("${contextPath}/PersonalReportServlet4", params);
		 		
  			}
  			else{
  			alert("报告不存在！");
  			}
	}
	<#-- 二代个人信贷交易明细-->
	function showReport6(respId,status){
  		if (status != "03"){
  			alert ("未查询成功！");
  		}else 
  			if("" != respId && null != respId){
		 		var params = {};
        		params.uuid=respId;
		 		alert("查询成功！即将跳到显示页面");
		 		openWindowWithPost("${contextPath}/PersonalReportServlet6", params);
		 		
  			}
  			else{
  			alert("报告不存在！");
  			}
	}
	<#-- 二代个人信息汇总-->
	function showReport7(respId,status){
  		if (status != "03"){
  			alert ("未查询成功！");
  		}else 
  			if("" != respId && null != respId){
		 		var params = {};
        		params.uuid=respId;
		 		alert("查询成功！即将跳到显示页面");
		 		openWindowWithPost("${contextPath}/PersonalReportServlet7", params);
		 		
  			}
  			else{
  			alert("报告不存在！");
  			}
	}
	
	
    <#-- 原始二代个人征信报告(下载)-->
	function dodownload(respId,status){
	<#--var flag=PrivAction.test33(respId);-->
	if(status!="03"){
		alert("未成功查询!");
	}else
	if("" != respId&& null != respId ){
		dwr.engine.setAsync(false);
		var flag=PrivAction.test33(respId);
		dwr.engine.setAsync(false);
		if(flag=="1"){
	 	var paramMap = new Map();
	 	paramMap.put("respId",respId);
		window.location.href="${contextPath}/DownloadCustPbocPerQueryAction.do?respId="+respId;}
		else{
			alert("The file does not exists！");
		}
	}else{
		alert("报告不存在！");
	}
	
	}
	
	
	
	<#-- 查询授权书下载 -->
	function queryDownload(idNum,idType){
	    dwr.engine.setAsync(false);
		var flag=PrivAction.test6(idNum,idType);
		dwr.engine.setAsync(false);
		if(flag=="1"){
			var paramMap = new Map();
			paramMap.put("idNum",idNum);
			window.location.href="${contextPath}/DownloadUserPermitAction2.do?idNum="+idNum+"&idType="+idType;
			}
		else{
			alert("The file does not exists！");
		}
	}
	
  <#-- 跳转方法openWindowWithPost -->
	function openWindowWithPost(url, data) {
	    var form = document.createElement("form");
	    form.target = "_blank";
	    form.method = "POST";
	    form.action = url;
	    form.style.display = "none";
	
	    for (var key in data) {
	        var input = document.createElement("input");
	        input.type = "hidden";
	        input.name = key;
	        input.value = data[key];
	        form.appendChild(input);
	    }
	
	    document.body.appendChild(form);
	    form.submit();
	    document.body.removeChild(form);
	}
	
	
	
	
</script>
</@CommonQueryMacro.page>
