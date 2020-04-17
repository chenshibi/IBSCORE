<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<@CommonQueryMacro.page title="第二代企业信用信息查询">
<style>
a:link,a:visited{font-size:16px}
</style>
<@CommonQueryMacro.CommonQuery id="CompanyReport3" init="false" submitMode="current" navigate="false">
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
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="opr[300],entName[110],entCertType,entCertNum,queryReason,serviceCode[120],rsv9[200],respId[200],respCode,respMsg,queryDate,createUser,createTime,checkUser,checkTime,sendTime,respTime,status,certAuthStatus" readonly="true" width="100%"/>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	<#--将opr列变成超链接,需要记录类型,操作说明,原纪录主键,记录本身-->
	function datatable1_opr_onRefresh(cell, value, record){
		var id = record.getValue("id");
		var entName = record.getValue("entName");
		var entCertType = record.getValue("entCertType");
		var entCertNum = record.getValue("entCertNum");
		var queryReason = record.getValue("queryReason");
		var serviceCode = record.getValue("serviceCode");
		var respId = record.getValue("respId");
		var respCode = record.getValue("respCode");
		var respMsg = record.getValue("respMsg");
		var queryDate=record.getValue("queryDate");
		var createUser = record.getValue("createUser");
		var createTime=record.getValue("createTime").format("yyyyMMddHHmmss");
		var checkUser = record.getValue("checkUser");
		var checkTime=record.getValue("checkTime").format("yyyyMMddHHmmss");
		var sendTime=record.getValue("sendTime").format("yyyyMMddHHmmss");
		var respTime=record.getValue("respTime").format("yyyyMMddHHmmss");
		var status = record.getValue("status");
		var certAuthStatus = record.getValue("certAuthStatus");
		var queryLevel=record.getValue("queryLevel");
		var funcid1 = record.getValue("funcid1");
		var funcid2 = record.getValue("funcid2");
		var funcid3 = record.getValue("funcid3");
		var funcid4 = record.getValue("funcid4");
		var funcid5 = record.getValue("funcid5");
		var funcid6 = record.getValue("funcid6");
		var funcid7 = record.getValue("funcid7");
		
		var htmlStr = "<center>";
		var tlrno = "${v_tlrno}";
		dwr.engine.setAsync(false);
    	//var flag=PrivAction.haveRole(tlrno,respTime,"corp");    //30天内或有权限
 		dwr.engine.setAsync(false);
		
		if(record) {//当存在记录时
			//if(flag){
				if("66661701"==funcid1){
					//htmlStr=htmlStr+"<a href=\"javascript:showReport1('"+respId+"','"+status+"')\">原始企业征信报告</a>"
					htmlStr=htmlStr+"<a href=\"javascript:showReport1('"+respId+"','"+status+"')\">原始二代企业征信报告</a>"
				}
				if("66661702"==funcid2){
					//htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:showReport2('"+respId+"','"+status+"')\">二代企业征信报告</a>"
					htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:showReport2('"+respId+"','"+status+"')\">二代企业信息汇总</a>"
				}
				//if("66661707"==funcid7){
				//	htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:showReport7('"+respId+"','"+status+"')\">二代企业信息汇总</a>"
				//}
				if("66661703"==funcid3){
					htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:showReport3('"+respId+"','"+status+"')\">二代企业信息核验</a>"
				}
				//if("66661704"==funcid4){
				//	htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:showReport4('"+respId+"','"+status+"')\">二代企业一般信息展开(二级)</a>"
				//}
				//if("66661705"==funcid5){
				//	htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:showReport5('"+respId+"','"+status+"')\">二代企业明细信息展开</a>"
				//}
			//}
			if("66661706"==funcid6){
				htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:queryDownload('"+entCertType+"','"+entCertNum+"')\">查询授权书下载</a>"
			}
			//if(status=="04"){
			//	    htmlStr=htmlStr+"&nbsp&nbsp&nbsp&nbsp<a href=\"JavaScript:reQuery('"+entName+"','"+entCertType+"','"+entCertNum+"','"+queryReason+"','"+serviceCode+"','"+queryLevel+"')\">重新查询</a>"
			//	}
			
			cell.innerHTML=htmlStr
		}
		else {//当不存在记录时
			cell.innerHTML="&nbsp"
		}
	}
			
	<#-- 原始企业征信报告(未脱敏)-->
	function showReport1(respId,status){
  		if (status != "03"){
  			alert ("未查询成功！")
  		}else 
  			if("" != respId && null != respId){
  				//var paramMap = new Map()
		 		//paramMap.put("uuid",rptId)
		 		var params = {}
        		params.uuid=respId
		 		//if("6"!=status){//仿一代，个人时6为“查无此人”
		 			alert("查询成功！")
		 			openWindowWithPost("${contextPath}/CorpReportServlet2", params)
		 		//}
		 		//else{
		 		//	 alert("查无此人！")
		 		//}
  			}
  			else{
  			alert("报告不存在！")
  			}
	}
	
	<#-- 二代企业征信报告(已脱敏)-->
	function showReport2(respId,status){
  		if (status != "03"){
  			alert ("未查询成功！")
  		}else 
  			if("" != respId && null != respId){
  				//var paramMap = new Map()
		 		//paramMap.put("uuid",rptId)
		 		var params = {}
        		params.uuid=respId
		 		//if("6"!=status){//仿一代，个人时6为“查无此人”
		 			alert("查询成功！")
		 			openWindowWithPost("${contextPath}/CorpReportServlet", params)
		 		//}
		 		//else{
		 		//	 alert("查无此人！")
		 		//}
  			}
  			else{
  			alert("报告不存在！")
  			}
	}
	<#-- 企业信息核验-->
	function showReport3(respId,status){
  		if (status != "03"){
  			alert ("未查询成功！");
  		}else 
  			if("" != respId && null != respId){
		 		var params = {};
        		params.uuid=respId;
		 		alert("查询成功！即将跳到显示页面");
		 		openWindowWithPost("${contextPath}/CorpReportServlet3", params);
		 		
  			}
  			else{
  			alert("报告不存在！");
  			}
	}
	<#-- 企业一般信息展开(二级)-->
	function showReport4(respId,status){
  		if (status != "03"){
  			alert ("未查询成功！");
  		}else 
  			if("" != respId && null != respId){
		 		var params = {};
        		params.uuid=respId;
		 		alert("查询成功！即将跳到显示页面");
		 		openWindowWithPost("${contextPath}/CorpReportServlet4", params);
		 		
  			}
  			else{
  			alert("报告不存在！");
  			}
	}
	<#-- 企业明细信息展开-->
	function showReport5(respId,status){
  		if (status != "03"){
  			alert ("未查询成功！");
  		}else 
  			if("" != respId && null != respId){
		 		var params = {};
        		params.uuid=respId;
		 		alert("查询成功！即将跳到显示页面");
		 		openWindowWithPost("${contextPath}/CorpReportServlet5", params);
		 		
  			}
  			else{
  			alert("报告不存在！");
  			}
	}
	<#-- 二代企业信息汇总-->
	function showReport7(respId,status){
  		if (status != "03"){
  			alert ("未查询成功！");
  		}else 
  			if("" != respId && null != respId){
		 		var params = {};
        		params.uuid=respId;
		 		alert("查询成功！即将跳到显示页面");
		 		openWindowWithPost("${contextPath}/CorpReportServlet7", params);
		 		
  			}
  			else{
  			alert("报告不存在！");
  			}
	}
	
	<#-- 跳转方法 -->
	function openWindowWithPost(url, data) {
	    var form = document.createElement("form")
	    form.target = "_blank"
	    form.method = "POST"
	    form.action = url
	    form.style.display = "none"
	
	    for (var key in data) {
	        var input = document.createElement("input")
	        input.type = "hidden"
	        input.name = key
	        input.value = data[key]
	        form.appendChild(input)
	    }
	
	    document.body.appendChild(form)
	    form.submit()
	    document.body.removeChild(form)
	}
	
	
	<#--授权书下载-->
	function queryDownload(entCertType,entCertNum){
		dwr.engine.setAsync(false);
		var flag=PrivAction.test7(entCertType,entCertNum);
		dwr.engine.setAsync(false);
		if(flag=="1"){
			var paramMap = new Map();
	 		paramMap.put("entCertNum",entCertNum);
			window.location.href="${contextPath}/DownloadLoaAction2.do?entCertType="+entCertType+"&entCertNum="+entCertNum;
			}
			else{
				alert("The file does not exists！")
			}
	}	
	 
	function reQuery(entName,entCertType,entCertNum,queryReason,serviceCode,queryLevel){
	  dwr.engine.setAsync(false);
      var isCompanyExpire=PrivAction.isCompanyExpire(entCertNum,queryReason);//有无授权书标志
	  dwr.engine.setAsync(false);
	  if(isCompanyExpire == "0"){
					 alert("Name="+entName+",ID="+entCertNum+ " 没有查询授权书！");
					 window.location.href="${contextPath}/fpages/business/ftl/TCorpPermitUploadN2.ftl?id="+id+"&corpCustCompanyname=" +encodeURI(encodeURI(entName))+ "&corpCustLoancard=" + entCertNum;
			    	// showWin("查询授权书上传", "/fpages/business/ftl/TCorpPermitUploadN2.ftl?corpCustCompanyname=" + encodeURI(encodeURI(entName)) + "&corpCustLoancard=" + entCertNum,300,300,window);
			    	 return false;
				 }
				 if(isCompanyExpire == "1"){
					 alert("Name="+entName+",ID="+entCertNum+ " 查询授权书过期！");
					 window.location.href="${contextPath}/fpages/business/ftl/TCorpPermitUploadN2.ftl?id="+id+"&corpCustCompanyname=" +encodeURI(encodeURI(entName))+ "&corpCustLoancard=" + entCertNum;
			    //	 showWin("查询授权书上传", "/fpages/business/ftl/TCorpPermitUploadN2.ftl?corpCustCompanyname=" + encodeURI(encodeURI(entName)) + "&corpCustLoancard=" + entCertNum,300,300,window);
			    	 return false;
				 }
	  var result=PrivAction.dealCorpData(entName,entCertType,entCertNum,queryReason,serviceCode,queryLevel);
      if (result!=null) {
             var params = {};
             params.uuid=result;
             alert('查询成功，将在新窗口打开征信查询结果页面');
             openWindowWithPost("${contextPath}/CorpReportServlet",params);
     }else{
          alert("查询失败");
     }
	}
	
	
	
	
	

	
	
	
</script>
</@CommonQueryMacro.page>
