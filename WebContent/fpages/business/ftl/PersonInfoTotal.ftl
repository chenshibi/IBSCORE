<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<div id="print">
<object id="WebBrowser" width=0 height=0 classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></object>
<@CommonQueryMacro.page title="个人信息汇总">
     <@CommonQueryMacro.CommonQuery id="IndAppQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
		<table width="100%" id="IndAppQuery_table">
		 	<tr>
		      	<td  align="center">
					<@CommonQueryMacro.Group id="group1" label="个人基本信息"  fieldStr="rptId[200],returnTime,name,idType,individualId,queryReason" colNm=6 /></br>
		        </td>
		    </tr>	
		   
		</table>
		<div id="b"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
    
    <@CommonQueryMacro.CommonQuery id="IndInfoQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="IndInfoQuery_table">
	 <tr>
	  	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="身份信息"  fieldStr="gender,birthday,marriage,mobile,phoneCom,phoneLiv,education,degree,addr,hukouAddr" colNm=6 /></br>
	    </td>
	    </tr>	
	    <tr>
	  	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="配偶信息"  fieldStr="spouse,spouseIdType,spouseIdNumber,spouseCom,spousePhone" colNm=6 /></br>
	    </td>
	    </tr>	
	   
	</table>
	<div id="b1"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndAddrQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndAddrQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">居住信息</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="number,address[200],status,getDate[150]" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b2"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndJobQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndJobQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">职业信息</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,name,addr,profession,industry,title,titleTec,startdate[200],getdate[200]" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b3"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndPromptQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndPromptQuery_table">
 	<tr>
      	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="信用提示"  fieldStr="personHouseLoan,personBizHouseLoan,otherLoan,firstLoanIssueDate,crdAccount,firstCcIssueDate,pdcAccount,firstPdcIssueDate,selfStatementCount,dissentCount" colNm=6 /></br>
        </td>
    </tr>	
   
</table>
<div id="b4"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndPbocScoreQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndPbocScoreQuery_table">
 	<tr>
      	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="中征信“信用1000”评分"  fieldStr="pbocScore,scorePercentile,scoreDescription" colNm=6 /></br>
        </td>
    </tr>	
   
</table>
<div id="b5"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndBreachQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndBreachQuery_table">
 	<tr>
      	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="逾期及违约信息概要"  fieldStr="badDebtCount,badDebtAmount,disposalCount,disposalAmount,ensurePayCount,ensurePayAmount" colNm=6 /></br>
        </td>
    </tr>	
   
</table>
<div id="b6"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndOverdueQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndOverdueQuery_table">
 	<tr>
      	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="逾期（透支）信息汇总"  fieldStr="loanCount,loanMonthCount,loanMaxAmount,loanMaxMonth,ccCount,ccMonthCount,ccMaxAmount,ccMaxMonth,pdcCount,pdcMonthCount,pcdMaxAmount,pdcMaxMonth" colNm=6 /></br>
        </td>
    </tr>	
   
</table>
<div id="b7"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndNoCloseLoanQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndNoCloseLoanQuery_table">
 	<tr>
      	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="未结清贷款信息汇总"  fieldStr="lawOrgCount,orgCount,count,totalAmount,totalBalance,avgMonthPayL6m" colNm=6 /></br>
        </td>
    </tr>	
   
</table>
<div id="b8"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndNoCloseCcQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndNoCloseCcQuery_table">
 	<tr>
      	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="未销户贷记卡信息汇总"  fieldStr="lawOrgCount,orgCount,count,totalCreditAmount,maxCreditAmount,minCreditAmount,totalUsed,avgUsedL6m" colNm=6 /></br>
        </td>
    </tr>	
   
</table>
<div id="b9"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndNoClosePdcQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndNoClosePdcQuery_table">
 	<tr>
      	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="未销户准贷记卡信息汇总"  fieldStr="lawOrgCount,orgCount,count,totalCreditAmount,maxCreditAmount,minCreditAmount,totalOverdraw,avgOverdrawL6m" colNm=6 /></br>
        </td>
    </tr>	
   
</table>
<div id="b10"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndAssuranceQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndAssuranceQuery_table">
 	<tr>
      	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="对外担保信息汇总"  fieldStr="count,bankAssurance,balance" colNm=6 /></br>
        </td>
    </tr>	
   
</table>
<div id="b11"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndDisposalQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndDisposalQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">资产处置信息</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,managerOrg,expropriateDate,expropriateAmount,lastPayDate,balance" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b12"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndEnsureQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndEnsureQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">保证人代偿信息</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,ensureOrg,lastEnsurePayDate,totalPayAmount,lastPayDate,balance" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b13"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndLonDetailQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndLonDetailQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">贷款</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="issurenceDate,endDate,orgName,amount,type,bizNo,assurance,overdueCount,accStatus,overdueAmount" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="b14"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndLonDetailInfoQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndLonDetailInfoQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">贷款详细1</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="l5class,balance,leftMonth,payMonth,payDay,yearmonth[200],payReal,recentPayDate,overdueCount,overdueAmount,over31[200],over61[200],over91[200],over180[200],month24[300]" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="b15"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndOverdueDetailLonQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndOverdueDetailLonQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">贷款详细2</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="month,monthCount,amount" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="b16"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndSpecialNewLonQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndSpecialNewLonQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">贷款详细3</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="type,date,changeMonth,amount,details,loanOrgDesc,orgdate,inDeclare,declareDate,objectTag,tagDate" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="b17"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndCrdDetailQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndCrdDetailQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">贷记卡</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="dateofcreate,issuer,currency,bizNo,credit,share_,assurance,overdue,accStatus" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="b18"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndCrdDetailInfoQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndCrdDetailInfoQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">贷记卡详细1</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="share_,overdue,avgusedl6m[200],maxDebit,payMonth,billday,yearmonth[200],payReal,recentDate,overCount,overAmount,month24[300]" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="b19"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndOverdueDetailCrdQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndOverdueDetailCrdQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">贷记卡详细2</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="month,monthCount,amount" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="b20"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndSpecialNewCrdQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndSpecialNewCrdQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">贷记卡详细3</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="type,date,changeMonth,amount,details,loanOrgDesc,orgdate,inDeclare,declareDate,objectTag,tagDate" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="b21"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndCrdDetailPreQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndCrdDetailPreQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">准贷记卡</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="dateofcreate,issuer,currency,bizNo,credit,share_,assurance,overdue,accStatus" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="b22"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndPreCrdDetailInfoQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndPreCrdDetailInfoQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">准贷记卡详细1</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="share_,overdue,avgusedl6m,maxDebit,payMonth,billday,payReal,recentDate,overCount,overAmount,month24[300]" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="b23"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndOverdueDetailPreCrdQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndOverdueDetailPreCrdQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">准贷记卡详细2</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="month,monthCount,amount" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="b24"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndSpecialNewPreCrdQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndSpecialNewPreCrdQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">准贷记卡详细3</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="type,date,changeMonth,amount,details,loanOrgDesc,orgdate,inDeclare,declareDate,objectTag,tagDate" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="b25"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>







<@CommonQueryMacro.CommonQuery id="IndAssuranceDetailLoanQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndAssuranceDetailLoanQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">对外贷款担保信息</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,assuranceOrg[200],contractAmount[200],issueDate[200],endDate[200],assuranceAmount,balance[200],l5class[200],yearmonth[200]" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b26"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndAssuranceDetailCreditQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndAssuranceDetailCreditQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">对外信用卡担保信息</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,assuranceOrg[200],contractAmount[200],issueDate[200],assuranceAmount,balance[200],yearmonth" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b27"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndOweTaxQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndOweTaxQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">欠税记录</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,manager,amount,taxDate" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b28"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndPublicRecordCivilQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndPublicRecordCivilQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">民事判决记录</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,organ,reason,initDate,type,result,endDate,subjectName[200],subjectAmount" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="b29"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndPublicRecordForceQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndPublicRecordForceQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">强制执行记录</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,organ,reason,initDate,type,status,endDate,subjectName,subjectAmount[200],objectName,objectAmount" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b30"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndPublicRecordProgQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndPublicRecordProgQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">行政处罚记录</h1>
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
<div id="b31"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndHousefundDepositQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndHousefundDepositQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">住房公积金参缴记录</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,city,initDate,firstMonth,toMonth,status,monthlyAmount,persentPer,percentCom,organ,updateDate" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b32"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndInsDepositQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndInsDepositQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">养老保险金缴存记录</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,city,initDate,totalMonth,workMonth,status,baseAmount,depositAmount,updateDate,organ,endReason[200]" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b33"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndInsPaymentQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndInsPaymentQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">养老保险金发放记录</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,city,type,retireMonth,workMonth,payAmount,endReason,organ,updateDate" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b34"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndSuccourQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndSuccourQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">低保救助记录</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,type,city,organ,familyIncome,applyDate,issueDate,updateDate" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b35"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndAwardPraQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndAwardPraQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">执业资格记录</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,name,level,initDate,expireDate,endDate,organ,city" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b36"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndAwardBonQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndAwardBonQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">行政奖励记录</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,organ,content,initDate,expireDate" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b37"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndCarTradeQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndCarTradeQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">车辆交易和抵押记录</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,carNumber,engineNumber,brand,type,carUsage,status,pledged,updateDate" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b38"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndTelecomPaymentQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndTelecomPaymentQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">电信缴费记录</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,organ,type,initDate,status,oweAmount,oweMonth,yearmonth,month24[300]" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b39"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndStatementDeclareQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndStatementDeclareQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">本人声明</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,content,initDate" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b40"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndStatementDissentQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndStatementDissentQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">异议标注</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,content,initDate" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b41"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndEnquirySummaryQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndEnquirySummaryQuery_table">
 	<tr>
      	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="查询记录汇总"  fieldStr="loanApproveOrgL1m,ccApproveOrgL1m,loanApproveL1m,ccApproveL1m,selfL1m,loanManageL2y,assuranceCheckL2y,realNameCheckL2y" colNm=6 /></br>
        </td>
    </tr>	
   
</table>
<div id="b42"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndEnquiryQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndEnquiryQuery_table">
<tr valign="center">
	<td align="center">
	<h1 style="text-align:center; ">信贷审批查询记录明细</h1>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,enqDate,enquirer,reason" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="b43"><h1 style="text-align:center; ">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h1></br></br></div>
</@CommonQueryMacro.CommonQuery>









</div>
<script language="JavaScript">
function master_initCallGetter_post() {
	IndAppQuery_dataset.setReadOnly(true);
	IndInfoQuery_dataset.setReadOnly(true);
	IndPromptQuery_dataset.setReadOnly(true);
	IndPbocScoreQuery_dataset.setReadOnly(true);
	IndBreachQuery_dataset.setReadOnly(true);
	IndOverdueQuery_dataset.setReadOnly(true);
	IndNoCloseLoanQuery_dataset.setReadOnly(true);
	IndNoCloseCcQuery_dataset.setReadOnly(true);
	IndNoClosePdcQuery_dataset.setReadOnly(true);
	IndAssuranceQuery_dataset.setReadOnly(true);
	IndEnquirySummaryQuery_dataset.setReadOnly(true);
	if(IndAppQuery_dataset.record==null){
		document.getElementById('IndAppQuery_table').style.display="none";
		document.getElementById('b').style.display="none";
	}
	if(IndInfoQuery_dataset.record==null){
		document.getElementById('IndInfoQuery_table').style.display="none";
		document.getElementById('b1').style.display="none";
	}
	if(IndAddrQuery_dataset.record==null){
		document.getElementById('IndAddrQuery_table').style.display="none";
		document.getElementById('b2').style.display="none";
	}
	if(IndJobQuery_dataset.record==null){
		document.getElementById('IndJobQuery_table').style.display="none";
		document.getElementById('b3').style.display="none";
	}
	if(IndPromptQuery_dataset.record==null){
		document.getElementById('IndPromptQuery_table').style.display="none";
		document.getElementById('b4').style.display="none";
	}
	if(IndPbocScoreQuery_dataset.record==null){
		document.getElementById('IndPbocScoreQuery_table').style.display="none";
		document.getElementById('b5').style.display="none";
	}
	if(IndBreachQuery_dataset.record==null){
		document.getElementById('IndBreachQuery_table').style.display="none";
		document.getElementById('b6').style.display="none";
	}
	if(IndOverdueQuery_dataset.record==null){
		document.getElementById('IndOverdueQuery_table').style.display="none";
		document.getElementById('b7').style.display="none";
	}
	if(IndNoCloseLoanQuery_dataset.record==null){
		document.getElementById('IndNoCloseLoanQuery_table').style.display="none";
		document.getElementById('b8').style.display="none";
	}
	if(IndNoCloseCcQuery_dataset.record==null){
		document.getElementById('IndNoCloseCcQuery_table').style.display="none";
		document.getElementById('b9').style.display="none";
	}
	if(IndNoClosePdcQuery_dataset.record==null){
		document.getElementById('IndNoClosePdcQuery_table').style.display="none";
		document.getElementById('b10').style.display="none";
	}
	if(IndAssuranceQuery_dataset.record==null){
		document.getElementById('IndAssuranceQuery_table').style.display="none";
		document.getElementById('b11').style.display="none";
	}
	if(IndDisposalQuery_dataset.record==null){
		document.getElementById('IndDisposalQuery_table').style.display="none";
		document.getElementById('b12').style.display="none";
	}
	if(IndEnsureQuery_dataset.record==null){
		document.getElementById('IndEnsureQuery_table').style.display="none";
		document.getElementById('b13').style.display="none";
	}
	if(IndLonDetailQuery_dataset.record==null){
		document.getElementById('IndLonDetailQuery_table').style.display="none";
		document.getElementById('b14').style.display="none";
	}
	if(IndLonDetailInfoQuery_dataset.record==null){
		document.getElementById('IndLonDetailInfoQuery_table').style.display="none";
		document.getElementById('b15').style.display="none";
	}
	if(IndOverdueDetailLonQuery_dataset.record==null){
		document.getElementById('IndOverdueDetailLonQuery_table').style.display="none";
		document.getElementById('b16').style.display="none";
	}
	if(IndSpecialNewLonQuery_dataset.record==null){
		document.getElementById('IndSpecialNewLonQuery_table').style.display="none";
		document.getElementById('b17').style.display="none";
	}
	if(IndCrdDetailQuery_dataset.record==null){
		document.getElementById('IndCrdDetailQuery_table').style.display="none";
		document.getElementById('b18').style.display="none";
	}
	if(IndCrdDetailInfoQuery_dataset.record==null){
		document.getElementById('IndCrdDetailInfoQuery_table').style.display="none";
		document.getElementById('b19').style.display="none";
	}
	if(IndOverdueDetailCrdQuery_dataset.record==null){
		document.getElementById('IndOverdueDetailCrdQuery_table').style.display="none";
		document.getElementById('b20').style.display="none";
	}
	if(IndSpecialNewCrdQuery_dataset.record==null){
		document.getElementById('IndSpecialNewCrdQuery_table').style.display="none";
		document.getElementById('b21').style.display="none";
	}
	if(IndCrdDetailPreQuery_dataset.record==null){
		document.getElementById('IndCrdDetailPreQuery_table').style.display="none";
		document.getElementById('b22').style.display="none";
	}
	if(IndPreCrdDetailInfoQuery_dataset.record==null){
		document.getElementById('IndPreCrdDetailInfoQuery_table').style.display="none";
		document.getElementById('b23').style.display="none";
	}
	if(IndOverdueDetailPreCrdQuery_dataset.record==null){
		document.getElementById('IndOverdueDetailPreCrdQuery_table').style.display="none";
		document.getElementById('b24').style.display="none";
	}
	if(IndSpecialNewPreCrdQuery_dataset.record==null){
		document.getElementById('IndSpecialNewPreCrdQuery_table').style.display="none";
		document.getElementById('b25').style.display="none";
	}
	if(IndAssuranceDetailLoanQuery_dataset.record==null){
		document.getElementById('IndAssuranceDetailLoanQuery_table').style.display="none";
		document.getElementById('b26').style.display="none";
	}
	if(IndAssuranceDetailCreditQuery_dataset.record==null){
		document.getElementById('IndAssuranceDetailCreditQuery_table').style.display="none";
		document.getElementById('b27').style.display="none";
	}
	if(IndOweTaxQuery_dataset.record==null){
		document.getElementById('IndOweTaxQuery_table').style.display="none";
		document.getElementById('b28').style.display="none";
	}
	if(IndPublicRecordCivilQuery_dataset.record==null){
		document.getElementById('IndPublicRecordCivilQuery_table').style.display="none";
		document.getElementById('b29').style.display="none";
	}
	if(IndPublicRecordForceQuery_dataset.record==null){
		document.getElementById('IndPublicRecordForceQuery_table').style.display="none";
		document.getElementById('b30').style.display="none";
	}
	if(IndPublicRecordProgQuery_dataset.record==null){
		document.getElementById('IndPublicRecordProgQuery_table').style.display="none";
		document.getElementById('b31').style.display="none";
	}
	if(IndHousefundDepositQuery_dataset.record==null){
		document.getElementById('IndHousefundDepositQuery_table').style.display="none";
		document.getElementById('b32').style.display="none";
	}
	if(IndInsDepositQuery_dataset.record==null){
		document.getElementById('IndInsDepositQuery_table').style.display="none";
		document.getElementById('b33').style.display="none";
	}
	if(IndInsPaymentQuery_dataset.record==null){
		document.getElementById('IndInsPaymentQuery_table').style.display="none";
		document.getElementById('b34').style.display="none";
	}
	if(IndSuccourQuery_dataset.record==null){
		document.getElementById('IndSuccourQuery_table').style.display="none";
		document.getElementById('b35').style.display="none";
	}
	if(IndAwardPraQuery_dataset.record==null){
		document.getElementById('IndAwardPraQuery_table').style.display="none";
		document.getElementById('b36').style.display="none";
	}
	if(IndAwardBonQuery_dataset.record==null){
		document.getElementById('IndAwardBonQuery_table').style.display="none";
		document.getElementById('b37').style.display="none";
	}
	if(IndCarTradeQuery_dataset.record==null){
		document.getElementById('IndCarTradeQuery_table').style.display="none";
		document.getElementById('b38').style.display="none";
	}
	if(IndTelecomPaymentQuery_dataset.record==null){
		document.getElementById('IndTelecomPaymentQuery_table').style.display="none";
		document.getElementById('b39').style.display="none";
	}
	if(IndStatementDeclareQuery_dataset.record==null){
		document.getElementById('IndStatementDeclareQuery_table').style.display="none";
		document.getElementById('b40').style.display="none";
	}
	if(IndStatementDissentQuery_dataset.record==null){
		document.getElementById('IndStatementDissentQuery_table').style.display="none";
		document.getElementById('b41').style.display="none";
	}
	if(IndEnquirySummaryQuery_dataset.record==null){
		document.getElementById('IndEnquirySummaryQuery_table').style.display="none";
		document.getElementById('b42').style.display="none";
	}
	if(IndEnquiryQuery_dataset.record==null){
		document.getElementById('IndEnquiryQuery_table').style.display="none";
		document.getElementById('b43').style.display="none";
	}
	
}

</script>
</@CommonQueryMacro.page>
