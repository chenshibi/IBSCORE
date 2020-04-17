<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="企业信息核验">
<#assign rptKey = RequestParameters["rptKey"]?default("true")>
<#assign tcdareturnTime = RequestParameters["tcdareturnTime"]?default("true")>
<div id="print">
	<table width="100%">
	 	<tr align="center">
	 		<td style="font-size:35px">
	 			<b>
	 				企业信息核验
	 			</b>
	 		</td>
	 	</tr>
 	</table></br>
	<table width="100%">
	 	<tr  align="center">
	 			<h3>编号：${rptKey}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp时间：${tcdareturnTime}</h3>
	 	</tr>
 	</table></br>

    <table width="100%">
	 	<tr align="center">
	 		<td align="center">
	 		<h3>关联信息</h3>
	 		</td>
	 	</tr>
 	</table>

	<@CommonQueryMacro.CommonQuery id="TcorpInfoInvestorCheckQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpInfoInvestorCheckQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>主要出资人信息</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="name[200],idType[200],idNumber[200],amount[200],proportion[200]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="d"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpInfoExecutiveCheckQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpInfoExecutiveCheckQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>高管人员信息</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="title[200],name[200],idType[200],idNumber[200]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="e"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	
	<div  align="center" >
	<input type="button" name="close" value="关闭" style="margin-top:80px;background-color:#d6e5f8" onclick="goback()" />
	<input type="button" value="打印" style="margin-top:80px;background-color:#d6e5f8" onclick="printme()">
	</div> 

<script language="JavaScript">
function printme(){
window.print();
}

function goback(){
//	window.location.href="${contextPath}/fpages/business/ftl/companyReport.ftl";
	closeWin();
}


function initCallGetter_post() {
	
if(TcorpInfoInvestorCheckQuery_dataset!=null&&TcorpInfoInvestorCheckQuery_dataset.record==null){
	document.getElementById('TcorpInfoInvestorCheckQuery_table').style.display="none";
	document.getElementById('d').style.display="none";
}
if(TcorpInfoExecutiveCheckQuery_dataset!=null&&TcorpInfoExecutiveCheckQuery_dataset.record==null){
	document.getElementById('TcorpInfoExecutiveCheckQuery_table').style.display="none";
	document.getElementById('e').style.display="none";
}


}
</script>
</@CommonQueryMacro.page>
