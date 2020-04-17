<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>

<@CommonQueryMacro.page title="二代个人征信信息查询">
<style>
	a:link,a:visited{font-size:16px}
	//a:hover,a:active{font-size:20px}
</style>
<@CommonQueryMacro.CommonQuery id="personReport2" init="false" submitMode="current" navigate="false">
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
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="opr[300],id[200],name[60],idType,idNum[120],queryReason,serviceCode,respId[200],respCode,respMsg,queryDate,createUser,createTime,checkUser,checkTime,sendTime,respTime,status,certAuthStatus" readonly="true" width="100%"/>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">
	<#--将opr列变成超链接,需要记录类型,操作说明,原纪录主键,记录本身-->
	function datatable1_opr_onRefresh(cell, value, record){
		if(record){		
			var id = record.getValue("respId");
			innerText = "<a href=\"JavaScript:showReport1('"+id+"')\">原始个人征信报告&nbsp&nbsp </a>"
	        + "<a href=\"JavaScript:showReport2('"+id+"')\">二代个人征信报告&nbsp&nbsp</a>"
	        + "<a href=\"JavaScript:showReport3('"+id+"')\">个人信息核验&nbsp&nbsp</a>"
	        + "<a href=\"JavaScript:showReport4('"+id+"')\">个人汇总报告&nbsp&nbsp</a>";
	        cell.innerHTML= innerText +"<a href=\"JavaScript:queryDownload('"+id+"')\">查询授权书下载</a>";
			
		}else{
			cell.innerHTML = "";
		}
	}
	<#-- 原始个人征信报告(未脱敏)-->
	function showReport1(id){
  		var params = {}
        params.uuid=id;
        openWindowWithPost("${contextPath}/PersonalReportServlet2", params);
	}
	<#-- 二代个人征信报告(已脱敏)-->
	function showReport2(id){
  		var params = {}
        params.uuid=id;
        openWindowWithPost("${contextPath}/PersonalReportServlet", params);
	}
	<#-- 个人信息核验-->
	function showReport3(id){
  		var params = {}
        params.uuid=id;
        openWindowWithPost("${contextPath}/PersonalReportServlet3", params);
	}
	<#-- 个人汇总报告-->
	function showReport4(id){
  		var params = {}
        params.uuid=id;
        openWindowWithPost("${contextPath}/PersonalReportServlet4", params);
	}
	
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
	
	
	function queryDownload(id){
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
</script>
</@CommonQueryMacro.page>
