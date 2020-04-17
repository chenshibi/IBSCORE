<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="个人信息报告">
	<table align="left" width="100%">
     <tr>

<@CommonQueryMacro.CommonQuery id="IndPromptQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndPromptQuery_table">
 	<tr>
      	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="信用提示"  fieldStr="personHouseLoan,personBizHouseLoan,otherLoan,firstLoanIssueDate,crdAccount,firstCcIssueDate,pdcAccount,firstPdcIssueDate,selfStatementCount,dissentCount" colNm=6 /></br>
        </td>
    </tr>	
   
</table>
<div id="d"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndBreachQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndBreachQuery_table">
 	<tr>
      	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="逾期及违约信息概要"  fieldStr="badDebtCount,badDebtAmount,disposalCount,disposalAmount,ensurePayCount,ensurePayAmount" colNm=6 /></br>
        </td>
    </tr>	
   
</table>
<div id="d1"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndOverdueQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndOverdueQuery_table">
 	<tr>
      	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="逾期（透支）信息汇总"  fieldStr="loanCount,loanMonthCount,loanMaxAmount,loanMaxMonth,ccCount,ccMonthCount,ccMaxAmount,ccMaxMonth,pdcCount,pdcMonthCount,pcdMaxAmount,pdcMaxMonth" colNm=6 /></br>
        </td>
    </tr>	
   
</table>
<div id="d2"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>



<@CommonQueryMacro.CommonQuery id="IndEnquirySummaryQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndEnquirySummaryQuery_table">
 	<tr>
      	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="查询记录汇总"  fieldStr="loanApproveOrgL1m,ccApproveOrgL1m,loanApproveL1m,ccApproveL1m,loanManageL2y,assuranceCheckL2y,realNameCheckL2y" colNm=6 /></br>
        </td>
    </tr>	
   
</table>
<div id="d3"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndPublicRecordCivilQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndPublicRecordCivilQuery_table">
<tr valign="center">
	<td align="center">
	<h3>民事判决记录</h3>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,organ,reason,initDate,type,result,endDate,subjectName,subjectAmount" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="d4"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndPublicRecordForceQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndPublicRecordForceQuery_table">
<tr valign="center">
	<td align="center">
	<h3>强制执行记录</h3>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,organ,reason,initDate,type,status,endDate,subjectName,subjectAmount,objectName,objectAmount" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="d5"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndPublicRecordProgQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndPublicRecordProgQuery_table">
<tr valign="center">
	<td align="center">
	<h3>行政处罚记录</h3>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,organ,reason,subjectName,initDate,endDate,result" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="d6"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

     </tr>
</table>
<div  align="center" >
	<input type="button" name="close" value="关闭" style="margin-top:80px;background-color:#d6e5f8" onclick="goback()" />
	<input type="button" value="打印" style="margin-top:80px;background-color:#d6e5f8" onclick="printme()">
</div> 

<script language="JavaScript">
function printme(){
window.print();
}
function goback(){
	closeWin();
}
function master_initCallGetter_post() {
	IndPromptQuery_dataset.setReadOnly(true);
	IndBreachQuery_dataset.setReadOnly(true);
	IndOverdueQuery_dataset.setReadOnly(true);
	IndEnquirySummaryQuery_dataset.setReadOnly(true);
	if(IndPromptQuery_dataset.record==null){
		document.getElementById('IndPromptQuery_table').style.display="none";
		document.getElementById('d').style.display="none";
	}
	if(IndBreachQuery_dataset.record==null){
		document.getElementById('IndBreachQuery_table').style.display="none";
		document.getElementById('d1').style.display="none";
	}
	if(IndOverdueQuery_dataset.record==null){
		document.getElementById('IndOverdueQuery_table').style.display="none";
		document.getElementById('d2').style.display="none";
	}
	if(IndEnquirySummaryQuery_dataset.record==null){
		document.getElementById('IndEnquirySummaryQuery_table').style.display="none";
		document.getElementById('d3').style.display="none";
	}
	if(IndPublicRecordCivilQuery_dataset.record==null){
		document.getElementById('IndPublicRecordCivilQuery_table').style.display="none";
		document.getElementById('d4').style.display="none";
	}
	if(IndPublicRecordForceQuery_dataset.record==null){
		document.getElementById('IndPublicRecordForceQuery_table').style.display="none";
		document.getElementById('d5').style.display="none";
	}
	if(IndPublicRecordProgQuery_dataset.record==null){
		document.getElementById('IndPublicRecordProgQuery_table').style.display="none";
		document.getElementById('d6').style.display="none";
	}
	
}

</script>
</@CommonQueryMacro.page>
