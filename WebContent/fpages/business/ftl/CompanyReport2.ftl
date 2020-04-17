<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<@CommonQueryMacro.page title="第二代企业征信报告查询">
<style>
a:link,a:visited{font-size:16px}
</style>
<@CommonQueryMacro.CommonQuery id="CompanyReport2" init="false" submitMode="current" navigate="false">
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
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="opr[300],id[200],entName[110],entCertType,entCertNum,queryReason,serviceCode[120],respId[200],respCode,respMsg,queryDate,createUser,createTime,checkUser,checkTime,sendTime,respTime,status,certAuthStatus" readonly="true" width="100%"/>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	
	<#--将opr列变成超链接,需要记录类型,操作说明,原纪录主键,记录本身-->
	function datatable1_opr_onRefresh(cell, value, record){
		if(record){		
			var id = record.getValue("respId");
			innerText = "<a href=\"JavaScript:showReport1('"+id+"')\">原始企业征信报告&nbsp&nbsp </a> "
	        + "<a href=\"JavaScript:showReport2('"+id+"')\">二代企业征信报告企&nbsp&nbsp</a>"
	        + "<a href=\"JavaScript:showReport3('"+id+"')\">企业信息核验&nbsp&nbsp</a>"
	        + "<a href=\"JavaScript:showReport4('"+id+"')\">企业一般信息展开(二级)&nbsp&nbsp</a>"
	        + "<a href=\"JavaScript:showReport5('"+id+"')\">企业明细信息展开&nbsp&nbsp</a>"
	        cell.innerHTML= innerText +"<a href=\"JavaScript:queryDownload('"+id+"')\"><br>查询授权书下载</a>";
			
		}else{
			cell.innerHTML = "";
		}
	}
	<#-- 原始企业征信报告(未脱敏)-->
	function showReport1(id){
  		var params = {}
        params.uuid=id;
        openWindowWithPost("${contextPath}/CorpReportServlet2", params);
	}
	
	<#-- 二代企业征信报告(已脱敏)-->
	function showReport2(id){
  		var params = {}
        params.uuid=id;
        openWindowWithPost("${contextPath}/CorpReportServlet", params);
	}
	<#-- 企业信息核验-->
	function showReport3(id){
  		var params = {}
        params.uuid=id;
        openWindowWithPost("${contextPath}/CorpReportServlet3", params);
	}
	<#-- 企业一般信息展开(二级)-->
	function showReport4(id){
  		var params = {}
        params.uuid=id;
        openWindowWithPost("${contextPath}/CorpReportServlet4", params);
	}
	<#-- 企业明细信息展开-->
	function showReport5(id){
  		var params = {}
        params.uuid=id;
        openWindowWithPost("${contextPath}/CorpReportServlet5", params);
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
	
	function queryDownload(Id){
		dwr.engine.setAsync(false);
		var flag=PrivAction.test5(Id);
		dwr.engine.setAsync(false);
		if(flag=="1"){
			var paramMap = new Map();
	 		paramMap.put("Id",Id);
			window.location.href="${contextPath}/DownloadLoaAction.do?Id="+Id;}
			else{
				alert("The file does not exists！");
			}
	}	
	
	
	
	
	
</script>
</@CommonQueryMacro.page>
