<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="企业一般信息汇总">
<#assign rptKey = RequestParameters["rptKey"]?default("true")>
<#assign ccreturnTime = RequestParameters["ccreturnTime"]?default("true")>
<div id="print">
	<table width="100%">
	 	<tr align="center">
	 		<td style="font-size:35px">
	 			<b>
	 				企业一般信息汇总
	 			</b>
	 		</td>
	 	</tr>
 	</table></br>
	<table width="100%">
	 	<tr  align="center">
	 			<h3>编号：${rptKey}&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp时间：${ccreturnTime}</h3>
	 	</tr>
 	</table></br>

     <@CommonQueryMacro.CommonQuery id="TcorpInfoBasicQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
		<table width="100%" id="TcorpInfoBasicQuery_table">
		 	<tr>
		      	<td  align="center">
					<@CommonQueryMacro.Group id="group1" label="身份信息"  fieldStr="name[200],address,regOrganCode,regOrganType,regOrganNo,regDate,regEndDate,regStateTaxNo,regLocalTaxNo,loancardId" colNm=6 /></br>
		        </td>
		    </tr>	
		   
		</table>
		<div id="c"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpInfoInvestorQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpInfoInvestorQuery_table">
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
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="name[200],idType[200],idNumber[200],amount[200],proportion[100]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="d"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpInfoExecutiveQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpInfoExecutiveQuery_table">
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
	
	<@CommonQueryMacro.CommonQuery id="TcorpInfoRelevantCorpQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpInfoRelevantCorpQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>有直接关联关系的其他企业</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="name[200],loanCardNo[200],relevant[200]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="f"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<table width="100%" id="financialReport">
	<tr valign="center">
		<td align="center">
		<h3 style="font-size:35px">财务报表</h3></br></br>
		</td>
	</tr>
	</table>
	
	<@CommonQueryMacro.CommonQuery id="TcorpYearlyBalanceReportQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpYearlyBalanceReportQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>资产负债表</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="rptType,rptYear,rptSummaryType" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="zc"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpYearlyProfitReportQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpYearlyProfitReportQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>利润表</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="rptType,rptYear,rptSummaryType" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="lr"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpYearlyCashFlowReportQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpYearlyCashFlowReportQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>现金流量表</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="rptType,rptYear,rptSummaryType" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="xj"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<table width="100%">
		<tr valign="center">
			<td align="center">
			<h3 style="font-size:35px">信息概要</h3></br></br>
			</td>
		</tr>
	</table>
	
	<table width="100%" id="Infomation_table">
		<tr valign="center">
			<td align="center">
			<h3 style="font-size:20px">信息主体未与金融机构发生过信贷关系</h3></br></br>
			</td>
		</tr>
	</table>
	
	<@CommonQueryMacro.CommonQuery id="TcorpSumCreditUnclearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpSumCreditUnclearedQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>未结清信贷信息概要</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="disposeCount[180],disposeAmount[180],disposeDate[105],debitInterestCount[80],debitInterestAmount[80]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	</@CommonQueryMacro.CommonQuery>

	
	
	<@CommonQueryMacro.CommonQuery id="TcorpSumCreditItemsUnclearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	
	<table width="100%" id="UnclearedQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>未结清信贷信息概要</h3>
		</td>
	</tr>
	</table>
	
	<table width="100%" id="TcorpSumCreditItemsUnclearedQuery_table">
	<tr valign="center">		
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="itemName,normalCount,normalAmount,concernCount,concernAmount,badCount[120],badAmount[120],totalCount[60],totalAmount" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="g"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpSumCreditclearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpSumCreditclearedQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>已结清信贷信息概要</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="disposeCount[180],disposeAmount[200],disposeDate[105],divestCount[120],divestAmount[120],divestDate[120],debitInterestCount[80],debitInterestClearDate[130]" readonly="true" width="100%"/>
		</td>
	</tr>
	<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="advancedCount[100],advancedAmount[150],advancedDate[80],assureCreditCount[200],assureCreditSum[200],assureCreditClearDate[130]" readonly="true" width="100%"/>
	</td>
	</tr>
	   
	</table>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpSumCreditItemsclearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	
	<table width="100%" id="ClearedQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>已结清信贷信息概要</h3>
		</td>
	</tr>
	</table>
	
	<table width="100%" id="TcorpSumCreditItemsclearedQuery_table">
	<tr valign="center">		
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="itemName,badCount,concernCount,normalCount" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="h"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpSumDebitHistoryQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpSumDebitHistoryQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>负债变化历史</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="month,totalAmount,badAmount" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="i"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpSumAssureQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpSumAssureQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>对外担保信息概要</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="itemName,count,amount,normalAmount[200],concernAmount[200],badAmount[200],totalAmount[200]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="j"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<table width="100%" id="CreditRecord">
	<tr valign="center">
		<td align="center">
		<h3 style="font-size:30px">信贷记录明细</h3></br></br>
		</td>
	</tr>
	<tr valign="center">
		<td align="center">
		<h3 style="font-size:20px">未结清业务</h3>
		</td>
	</tr>
	</table>
	
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersDebtQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersDebtQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>由资产管理公司处置的债务</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],currency[60],amount,initDate,balance,updateDate[150]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="k"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersInterestQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersInterestQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>欠息</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],currency[60],balance,updateDate,type" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="l"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersDkQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersDkQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>垫款</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable27"  fieldStr="opr[40],organ[60],currency[60],amount,balance,initDate,fiveLevel,type" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="m"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<table width="100%" id="UnHealthyQuery_table">
	<tr valign="center">
		<td align="center">
		<h3 style="font-size:20px">不良违约类</h3>
		</td>
	</tr>
	</table>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailLoanUnHealthyQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailLoanUnHealthyQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>贷款</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable13"  fieldStr="opr[40],organ[60],type,currency[60],amount,balance,initDate,expireDate,fiveLevel,style,assured[60],extended[60]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="n"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TCorpDetailOthersQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TCorpDetailOthersQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>类贷款</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable66"  fieldStr="opr[40],organ,type,currency,amount,balance,initDate,expireDate,fiveLevel,assured,extended" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="cc"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersTradeQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersTradeQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>贸易融资</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable14"  fieldStr="opr[40],organ[60],type,currency[60],amount,balance,initDate,expireDate,fiveLevel,assured[60],extended[60]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="o"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersFactorQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersFactorQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>保理</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable15"  fieldStr="opr[40],organ[60],type,currency[60],amount,balance,initDate,fiveLevel,assured[60],advanced" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="p"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersBillQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersBillQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>票据贴现</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],currency[60],amount,initDate,expireDate,fiveLevel" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="q"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersDraftQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersDraftQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>银行承兑汇票</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable16"  fieldStr="opr[40],organ[60],currency[60],amount,initDate,expireDate,depositRatio,fiveLevel,assured[60],advanced" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="r"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersCreditQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersCreditQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>信用证</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable17"  fieldStr="opr[40],organ[60],currency[60],amount,balance,initDate,expireDate,depositRatio,fiveLevel,assured[60],advanced" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="s"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersLetterQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersLetterQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>保函</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable18"  fieldStr="opr[40],organ[60],type,currency[60],amount,balance,initDate,expireDate,depositRatio,fiveLevel,assured[60],advanced" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="t"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<table width="100%" id="HealthyQueryCare_table">
	<tr valign="center">
		<td align="center">
		<h3 style="font-size:20px">关注类</h3>
		</td>
	</tr>
	</table>
	
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailLoanHealthyCareQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailLoanHealthyCareQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>贷款</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],type,currency[60],amount,balance,initDate,expireDate,fiveLevel,style,assured[60],extended[60]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a33"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersAttentionQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersAttentionQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>类贷款</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable44"  fieldStr="opr[40],organ,type,currency,amount,balance,initDate,expireDate,fiveLevel,assured,extended" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a345"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersTradeCareQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersTradeCareQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>贸易融资</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable14"  fieldStr="organ[60],type,currency[60],amount,balance,initDate,expireDate,fiveLevel,assured[60],extended[60]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a34"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersFactorCareQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersFactorCareQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>保理</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable20"  fieldStr="organ[60],type,currency[60],amount,balance,initDate,assured[60],advanced" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a35"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersBillCareQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersBillCareQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>票据贴现</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],currency[60],amount,initDate,expireDate,fiveLevel" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a36"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersDraftCareQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersDraftCareQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>银行承兑汇票</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],currency[60],amount,initDate,expireDate,depositRatio,fiveLevel,assured[60],advanced" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a37"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersCreditCareQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersCreditCareQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>信用证</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],currency[60],amount,balance,initDate,expireDate,depositRatio,fiveLevel,assured[60],advanced" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a38"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersLetterCareQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersLetterCareQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>保函</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],type,currency[60],amount,balance,initDate,expireDate,depositRatio,fiveLevel,assured[60],advanced" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a39"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<table width="100%" id="HealthyQuery_table">
	<tr valign="center">
		<td align="center">
		<h3 style="font-size:20px">正常类</h3>
		</td>
	</tr>
	</table>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailLoanHealthyQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailLoanHealthyQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>贷款</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable10"  fieldStr="opr[40],organ[60],type,currency[60],amount,balance,initDate,expireDate,style,assured[60],extended[60],historyRecord[60]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="u"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersLdkNormalQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersLdkNormalQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>类贷款</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable19"  fieldStr="opr[40],organ[60],type,currency[60],amount,balance,initDate,expireDate,assured[60],extended[60],historyRecord[60]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="v"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersTradeNormalQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersTradeNormalQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>贸易融资</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable11"  fieldStr="opr[40],organ[60],type,currency[60],amount,balance,initDate,expireDate,assured[60],extended[60],historyRecord[60]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="w"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersFactorNormalQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersFactorNormalQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>保理</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable20"  fieldStr="opr[40],organ[60],type,currency[60],amount,balance,initDate,assured[60],advanced" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="x"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailSummaryBillQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailSummaryBillQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>票据贴现</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable21"  fieldStr="opr[40],organ[60],count,balance,bizDetail" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="y"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailSummaryDraftQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailSummaryDraftQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>银行承兑汇票</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable22"  fieldStr="opr[40],organ[60],count,balanceDay30,balanceDay60,balanceDay90,balanceDay90Plus,balance,bizDetail" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="z"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailSummaryCreditQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailSummaryCreditQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>信用证</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable23"  fieldStr="opr[40],organ[60],count,amount,balance,bizDetail" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a1"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailSummaryLetterQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailSummaryLetterQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>保函</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable24"  fieldStr="opr[40],organ[60],count,amount,balance,bizDetail" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a2"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<table width="100%" id="AlreadyClear">
	<tr valign="center">
		<td align="center">
		<h3 style="font-size:20px">已结清业务</h3>
		</td>
	</tr>
	</table>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersDebtClearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersDebtClearedQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>由资产管理公司处置的债务</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],currency[60],amount,initDate,closeDate" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a3"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersQxClearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersQxClearedQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>欠息</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],currency[60],amount,initDate,expireDate,type" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a4"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersDkClearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersDkClearedQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>垫款</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable28"  fieldStr="opr[40],organ[60],currency[60],amount,initDate,closeDate,fiveLevel,type" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a5"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TotalTcorpDetailOthersDkMxQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailLoanHealthyClearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailLoanHealthyClearedQuery_list">
	<tr valign="center">
		<td align="center">
		<h3>贷款</h3>
		<br/>
		<h3 id="TcorpDetailLoanHealthyClearedQuery_table_tip">该信息主体无不良或关注类已结清贷款业务</h3>
		</td>
	</tr>
	</table>
	<table width="100%" id="TcorpDetailLoanHealthyClearedQuery_table">
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable25"  fieldStr="organ[60],type,currency[60],amount,initDate,expireDate,closeDate,closeStyle,fiveLevel" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<table id="btn1" align="right">
		<tr>
			<td colspan="2" align="right">
				<@CommonQueryMacro.Button id= "queryNormalClearDk"/>
			</td>
		</tr>
	</table>
	<div id="a6"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersModLoanMaxQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	</@CommonQueryMacro.CommonQuery>
	<@CommonQueryMacro.CommonQuery id="TCorpDetailOthersLoanQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
		<table width="100%" id="TCorpDetailOthersLoanQuery_table">
		<tr valign="center">
			<td align="center">
			<h3>类贷款</h3>
			</td>
		</tr>
		<tr>
			<td valign="top">
				 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
			</td>
		</tr>
		<tr>
			<td>
				<@CommonQueryMacro.DataTable id ="datatable67"  fieldStr="organ[60],type,currency[60],amount,initDate,expireDate,closeDate,closeStyle,fiveLevel" readonly="true" width="100%"/>
			</td>
		</tr>
		</table>
		<table width="100%" id="TCorpDetailOthersLoanQuery_table_tip">
			<tr valign="center">
				<td align="center">
				<h3>类贷款</h3>
				<br/>
			    <h3 id="TCorpDetailOthersLoanQuery_table_tip">该信息主体无不良或关注类已结清贷款业务</h3>
				</td>
			</tr>
		</table>
		<table id="btnLoan" align="right">
		<tr>
		<td colspan="2" align="right">
		<@CommonQueryMacro.Button id= "queryNormalClearMoldLoan"/>
		</td>
		</tr>
	</table>
	<div id="dd"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	
	
	<@CommonQueryMacro.CommonQuery id="TotalTcorpDetailOthersMyrzMxQuery" init="true" submitMode="current" navigate="false">
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersTradeNormalClearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersTradeNormalClearedQuery_list">
	<tr valign="center">
		<td align="center">
		<h3>贸易融资</h3>
		<br/>
		<h3 id="TcorpDetailOthersTradeNormalClearedQuery_table_tip">该信息主体无不良或关注类已结清贷款业务</h3>
		</td>
	</tr>
	</table>
	<table width="100%" id="TcorpDetailOthersTradeNormalClearedQuery_table">
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable26"  fieldStr="organ[60],type,currency[60],amount,initDate,expireDate,closeDate,closeStyle,fiveLevel" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	
	<table id="btn2" align="right">
	<tr>
	<td colspan="2" align="center">
	<@CommonQueryMacro.Button id= "queryNormalClearMyrz"/>
	</td>
	</tr>
	</table>
	<div id="a7"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TotalTcorpDetailOthersBlMxQuery" init="true" submitMode="current" navigate="false">
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersFactorNormalClearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersFactorNormalClearedQuery_list">
	<tr valign="center">
		<td align="center">
		<h3>保理</h3>
		<br/>
		<h3 id="TcorpDetailOthersFactorNormalClearedQuery_table_tip">该信息主体无不良或关注类已结清贷款业务</h3>
		</td>
	</tr>
	</table>
	<table width="100%" id="TcorpDetailOthersFactorNormalClearedQuery_table">
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],type,currency[60],amount,initDate,closeDate,fiveLevel,advanced" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<table id="btn3" align="right">
	<tr>
	<td colspan="2" align="center">
	<@CommonQueryMacro.Button id= "queryNormalClearBl"/>
	</td>
	</tr>
	</table>
	<div id="a8"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
		
	<@CommonQueryMacro.CommonQuery id="TotalTcorpDetailOthersPjtxMxQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersBillClearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersBillClearedQuery_list">
	<tr valign="center">
		<td align="center">
		<h3>票据贴现</h3>
		<br/>
		<h3 id="TcorpDetailOthersBillClearedQuery_table_tip">该信息主体无不良或关注类已结清贷款业务</h3>
		</td>
	</tr>
	</table>
	<table width="100%" id="TcorpDetailOthersBillClearedQuery_table">
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],currency[60],amount,initDate,expireDate,closeDate,fiveLevel" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<table id="btn4" align="right">
	<tr>
	<td colspan="2" align="center">
	<@CommonQueryMacro.Button id= "queryNormalClearPjtx"/>
	</td>
	</tr>
	</table>
	<div id="a9"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TotalTcorpDetailOthersYhcdhpMxQuery" init="true" submitMode="current" navigate="false">
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersDraftClearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersDraftClearedQuery_list">
	<tr valign="center">
		<td align="center">
		<h3>银行承兑汇票</h3>
		<br/>
		<h3 id="TcorpDetailOthersDraftClearedQuery_table_tip">该信息主体无不良或关注类已结清贷款业务</h3>
		</td>
	</tr>
	</table>
	<table width="100%" id="TcorpDetailOthersDraftClearedQuery_table">
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],currency[60],amount,initDate,expireDate,closeDate,fiveLevel,advanced" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<table id="btn5" align="right">
	<tr>
	<td colspan="2" align="center">
	<@CommonQueryMacro.Button id= "queryNormalClearYhcdhp"/>
	</td>
	</tr>
	</table>
	<div id="a10"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TotalTcorpDetailOthersXyzMxQuery" init="true" submitMode="current" navigate="false">
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersCreditClearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersCreditClearedQuery_list">
	<tr valign="center">
		<td align="center">
		<h3>信用证</h3>
		<br/>
		<h3 id="TcorpDetailOthersCreditClearedQuery_table_tip">该信息主体无不良或关注类已结清贷款业务</h3>
		</td>
	</tr>
	</table>
	<table width="100%" id="TcorpDetailOthersCreditClearedQuery_table">
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],currency[60],amount,initDate,expireDate,closeDate,fiveLevel,advanced" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<table id="btn6" align="right">
	<tr>
	<td colspan="2" align="center">
	<@CommonQueryMacro.Button id= "queryNormalClearXyz"/>
	</td>
	</tr>
	</table>
	<div id="a11"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TotalTcorpDetailOthersBhMxQuery" init="true" submitMode="current" navigate="false">
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailOthersLetterClearedQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailOthersLetterClearedQuery_list">
	<tr valign="center">
		<td align="center">
		<h3>保函</h3>
		<br/>
		<h3 id="TcorpDetailOthersLetterClearedQuery_table_tip">该信息主体无不良或关注类已结清贷款业务</h3>
		</td>
	</tr>
	</table>
	<table width="100%" id="TcorpDetailOthersLetterClearedQuery_table">
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ[60],type,currency[60],amount,initDate,expireDate,closeDate,fiveLevel,advanced" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<table id="btn7" align="right">
	<tr>
	<td colspan="2" align="center">
	<@CommonQueryMacro.Button id= "queryNormalClearBh"/>
	</td>
	</tr>
	</table>
	<div id="a12"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpDetailAssureQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailAssureQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>对外担保记录</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable12"  fieldStr="opr[40],type,name,idType,idNumber,currency[60],amount,style,mainBiz" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a13"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	<table width="100%" id="BulletinRecord" >
	<tr valign="center">
		<td align="center">
		<h3 style="font-size:30px">公共记录明细</h3>
		</td>
	</tr>
	</table>
	<@CommonQueryMacro.CommonQuery id="TcorpPublicOweTaxQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpPublicOweTaxQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>欠税记录</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="manager,amount,taxDate" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a14"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpJudgeRecordQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpJudgeRecordQuery_table">
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
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="court,judgeDate,judgeReason,judgeParty,caseNo,judgeProcess,judgeObject,objectValue[120],caseCloseMode,judgeEffDate[150],judgeResult[100]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a15"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpJudgeRecordForceQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpJudgeRecordForceQuery_table">
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
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="court,judgeDate,judgeReason,caseNo,judgeObject,objectValue,caseStatus,caseCloseMode,executedObject,executedObjectValue[200]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a16"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpPunishRecordQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpPunishRecordQuery_table">
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
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ,punishDocNo,illegalAct,punishDate,punishDecision,punishAmount,punishSituation,reviewResult" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a17"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpSocialPayRecordQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpSocialPayRecordQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>社会保险参保缴费记录</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="insuranceType,insuredDate,sumYm,payAmt,payStatus,sumOwnAmt" readonly="true" width="100%"/>
		</td>
	</tr>
	
	</table>
	
	<table id="btn8">
	<tr valign="center">
	<td colspan="2" align="center">
	<@CommonQueryMacro.Button id= "query24monthBx"/>
	</td>
</tr>
	</table>
	<div id="a18"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpSocialPayRecordFundsQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpSocialPayRecordFundsQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>住房公积金缴费记录</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="sumYm[100],firstPayYm[100],employeeNumber[100],payAmt[100],lastPayDate[100],lastPayYm[100],payStatus[100],sumOwnAmt[200]" readonly="true" width="100%"/>
		</td>
	</tr>
	
	   
	</table>
	<table id="btn9">
	<tr>
	<td colspan="2" align="center">
	<@CommonQueryMacro.Button id= "query24monthGjj"/>
	</td>
	</tr>
	</table>
	<div id="a19"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>

	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpPublicAwardPermitQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpPublicAwardPermitQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>获得许可记录</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ,type,initDate,expireDate,content" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a20"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpPublicAwardRzQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpPublicAwardRzQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>获得认证记录</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ,type,initDate,expireDate,content" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a21"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpPublicAwardZzQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpPublicAwardZzQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>获得资质记录</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ,type,initDate,expireDate,content" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a22"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpPublicAwardRewardQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpPublicAwardRewardQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>获得奖励记录</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ,type,initDate,expireDate,content" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a23"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpPublicAwardCrjQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpPublicAwardCrjQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>出入境检验检疫绿色通道信息</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ,type,initDate" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a24"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	
	<@CommonQueryMacro.CommonQuery id="TcorpPublicAwardMjQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpPublicAwardMjQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>进出口商品免检信息</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ,type,awardCode,initDate,expireDate" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a25"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpPublicAwardJgQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpPublicAwardJgQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>进出口商品检验分类监管信息</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ,subOrgan,type,initDate,expireDate" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a26"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpStatementQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpStatementQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>上市公司或有事项</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ,content[800],updateDate" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a27"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpPublicAwardZlQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpPublicAwardZlQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>拥有专利情况</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ,awardCode,initDate,expireDate,term[200]" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a28"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpSocialPayRecordCauseQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpSocialPayRecordCauseQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>公用事业缴费记录</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="organ,infotype,sumYm,payStatus,lastPayDate,sumOwnAmt,highestOwnDate,highestOwnAmt" readonly="true" width="100%"/>
		</td>
	</tr>
	</table>
	<table id="btn10">
	<tr>
	<td colspan="2" align="center">
	<@CommonQueryMacro.Button id= "query24monthGysy"/>
	</td>
	</tr>
	</table>
	<div id="a29"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<table id="title11" width="100%">
	<tr valign="center">
		<td align="center">
		<h3 style="font-size:30px">声明信息明细</h3>
		</td>
	</tr>
	</table>
	
	<@CommonQueryMacro.CommonQuery id="TcorpStatementBsQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpStatementBsQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>报数机构说明</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="content[800],organ,initDate" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a30"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpStatementZxQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpStatementZxQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>征信中心标注</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="content[800],initDate" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a31"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	<@CommonQueryMacro.CommonQuery id="TcorpStatementZtQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpStatementZtQuery_table">
	<tr valign="center">
		<td align="center">
		<h3>信息主体声明</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="content[800],initDate" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	<div id="a32"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
	
	
	
	<@CommonQueryMacro.CommonQuery id="TcorpReportExchangeRate" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpReportExchangeRate_table" >
	<tr >
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr >
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="exchangeRate" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
	</@CommonQueryMacro.CommonQuery>
	<table>
	<tr valign="left">
		<td align="left" style="font-size:15px">
		<input type="text" readonly="readonly" style="border:0px" name="openertext" id="feedBackTxt"  value="exchangeRate" size="200" >
		</td>
	</tr>
	</table>
	
	<div>
	</div>
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

function datatable10_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var historyRecord="";
	var extended="";
	var assured="";
	var HistoryRecord = record.getValue("historyRecord");
	var Extended = record.getValue("extended");
	var Assured = record.getValue("assured");
	if("无"==HistoryRecord){
		historyRecord="";
	}
	else{
		historyRecord=HistoryRecord.replace(/查看/g,"look");
	}
	if("无"==Extended){
		extended="";
	}
	else{
		extended=Extended.replace(/有/g,"have");
	}
	if("无"==Assured){
		assured="";
	}
	else{
		assured=Assured.replace(/有/g,"have");
	}
//	alert(extended);
	if (record) {//当存在记录时
		var htmlStr = "";
			//htmlStr="<center><a href=\"JavaScript:showDkInfo('"+rptKey+"','"+historyRecord+"','"+extended+"')\">详细</a>";
			htmlStr="<center><a href=\"JavaScript:showDkInfo('"+rptKey+"','"+historyRecord+"','"+extended+"','"+assured+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable11_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var historyRecord="";
	var extended="";
	var assured="";
	var HistoryRecord = record.getValue("historyRecord");
	var Extended = record.getValue("extended");
	var Assured = record.getValue("assured");
	if("无"==HistoryRecord){
		historyRecord="";
	}
	else{
		historyRecord=HistoryRecord.replace(/查看/g,"look");
	}
	if("无"==Extended){
		extended="";
	}
	else{
		extended=Extended.replace(/有/g,"have");
	}
	if("无"==Assured){
		assured="";
	}
	else{
		assured=Assured.replace(/有/g,"have");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showMyrzInfo('"+rptKey+"','"+historyRecord+"','"+extended+"','"+assured+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable12_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var type="";
	var mainBiz="";
	var Type = record.getValue("type");
	var MainBiz = record.getValue("mainBiz");
	if("保证"==Type){
		type="bz";
	}
	else{
		type="qt";
	}
	if("无"==MainBiz){
		mainBiz="";
	}
	else{
		mainBiz=MainBiz.replace(/查看/g,"look");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showBzInfo('"+rptKey+"','"+type+"','"+mainBiz+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable13_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var assured="";//担保
	var extended="";//展期
	var Assured = record.getValue("assured");
	var Extended= record.getValue("extended");
	if("无"==Assured){
		assured="";
	}
	else{
		assured=Assured.replace(/有/g,"have");
	}
	if("无"==Extended){
		extended="";
	}
	else{
		extended=Extended.replace(/有/g,"have");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showDkDbZqInfo('"+rptKey+"','"+assured+"','"+assured+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}


function datatable66_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var assured="";//担保
	var extended="";//展期
	var Assured = record.getValue("assured");
	var Extended= record.getValue("extended");
	if("无"==Assured){
		assured="";
	}
	else{
		assured=Assured.replace(/有/g,"have");
	}
	if("无"==Extended){
		extended="";
	}
	else{
		extended=Extended.replace(/有/g,"have");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showMyrzDbZqInfo('"+rptKey+"','"+assured+"','"+extended+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}




function datatable44_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var assured="";//担保
	var extended="";//展期
	var Assured = record.getValue("assured");
	var Extended= record.getValue("extended");
	if("无"==Assured){
		assured="";
	}
	else{
		assured=Assured.replace(/有/g,"have");
	}
	if("无"==Extended){
		extended="";
	}
	else{
		extended=Extended.replace(/有/g,"have");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showMyrzDbZqInfo('"+rptKey+"','"+assured+"','"+extended+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}



function datatable14_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var assured="";//担保
	var extended="";//展期
	var Assured = record.getValue("assured");
	var Extended= record.getValue("extended");
	if("无"==Assured){
		assured="";
	}
	else{
		assured=Assured.replace(/有/g,"have");
	}
	if("无"==Extended){
		extended="";
	}
	else{
		extended=Extended.replace(/有/g,"have");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showMyrzDbZqInfo('"+rptKey+"','"+assured+"','"+extended+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable15_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var assured="";//担保
	var Assured = record.getValue("assured");
	if("无"==Assured){
		assured="";
	}
	else{
		assured=Assured.replace(/有/g,"have");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showBlDbInfo('"+rptKey+"','"+assured+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable16_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var assured="";//担保
	var Assured = record.getValue("assured");
	if("无"==Assured){
		assured="";
	}
	else{
		assured=Assured.replace(/有/g,"have");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showYhcdhpDbInfo('"+rptKey+"','"+assured+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable17_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var assured="";//担保
	var Assured = record.getValue("assured");
	if("无"==Assured){
		assured="";
	}
	else{
		assured=Assured.replace(/有/g,"have");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showXyzDbInfo('"+rptKey+"','"+assured+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable18_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var assured="";//担保
	var Assured = record.getValue("assured");
	if("无"==Assured){
		assured="";
	}
	else{
		assured=Assured.replace(/有/g,"have");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showBhDbInfo('"+rptKey+"','"+assured+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable19_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var assured="";//担保
	var extended="";//展期
	var historyRecord="";
	var Assured = record.getValue("assured");
	var Extended= record.getValue("extended");
	var HistoryRecord = record.getValue("historyRecord");
	if("无"==Assured){
		assured="";
	}
	else{
		assured=Assured.replace(/有/g,"have");
	}
	if("无"==Extended){
		extended="";
	}
	else{
		extended=Extended.replace(/有/g,"have");
	}
	if("无"==HistoryRecord){
		historyRecord="";
	}
	else{
		historyRecord=HistoryRecord.replace(/查看/g,"look");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showLdkDbZqInfo('"+rptKey+"','"+assured+"','"+extended+"','"+historyRecord+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable20_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var assured="";//担保
	var Assured = record.getValue("assured");
	if("无"==Assured){
		assured="";
	}
	else{
		assured=Assured.replace(/有/g,"have");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showNormalBlDbInfo('"+rptKey+"','"+assured+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function query24monthBx_onClick() {
	var rptKey = TcorpSocialPayRecordQuery_dataset.getParameter("rptKey");
	 var url = "/fpages/business/ftl/TcorpPublicInfoDetailShbx.ftl?rptKey="+rptKey;
	    showWin("社会保险参保历史缴费记录明细",url,"window","flushPage()",window);
}

function query24monthGjj_onClick() {
	var rptKey = TcorpSocialPayRecordFundsQuery_dataset.getParameter("rptKey");
	 var url = "/fpages/business/ftl/TcorpPublicInfoDetailGjj.ftl?rptKey="+rptKey;
	    showWin("住房公积金历史缴费记录明细",url,"window","flushPage()",window);
}

function queryNormalClearMoldLoan_onClick() {
	var rptKey = TCorpDetailOthersLoanQuery_dataset.getParameter("rptKey");
	 var url = "/fpages/business/ftl/TcorpDetailOthersModLoan.ftl?rptKey="+rptKey;
	    showWin("已结清正常类类贷款记录明细",url,"window","flushPage()",window);
}

function query24monthGysy_onClick() {
	var rptKey = TcorpSocialPayRecordCauseQuery_dataset.getParameter("rptKey");
	 var url = "/fpages/business/ftl/TcorpPublicInfoDetailGysy.ftl?rptKey="+rptKey;
	    showWin("公用事业历史缴费记录明细",url,"window","flushPage()",window);
}

function queryNormalClearDk_onClick() {
	var rptKey = TcorpDetailLoanHealthyClearedQuery_dataset.getParameter("rptKey");
	 var url = "/fpages/business/ftl/TcorpDetailOthersDk.ftl?rptKey="+rptKey;
	    showWin("已结清正常类贷款记录明细",url,"window","flushPage()",window);
}

function queryNormalClearMyrz_onClick() {
	var rptKey = TcorpDetailOthersTradeNormalClearedQuery_dataset.getParameter("rptKey");
	 var url = "/fpages/business/ftl/TcorpDetailOthersMyrz.ftl?rptKey="+rptKey;
	    showWin("已结清正常类贸易融资记录明细",url,"window","flushPage()",window);
}

function queryNormalClearBl_onClick() {
	var rptKey = TcorpDetailOthersFactorNormalClearedQuery_dataset.getParameter("rptKey");
	 var url = "/fpages/business/ftl/TcorpDetailOthersBl.ftl?rptKey="+rptKey;
	    showWin("已结清正常类保理记录明细",url,"window","flushPage()",window);
}

function queryNormalClearPjtx_onClick() {
	var rptKey = TcorpDetailOthersBillClearedQuery_dataset.getParameter("rptKey");
	 var url = "/fpages/business/ftl/TcorpDetailOthersPjtx.ftl?rptKey="+rptKey;
	    showWin("已结清正常类票据贴现记录明细",url,"window","flushPage()",window);
}

function queryNormalClearYhcdhp_onClick() {
	var rptKey = TcorpDetailOthersDraftClearedQuery_dataset.getParameter("rptKey");
	 var url = "/fpages/business/ftl/TcorpDetailOthersYhcdhp.ftl?rptKey="+rptKey;
	    showWin("已结清正常类银行承兑汇票记录明细",url,"window","flushPage()",window);
}

function queryNormalClearXyz_onClick() {
	var rptKey = TcorpDetailOthersCreditClearedQuery_dataset.getParameter("rptKey");
	 var url = "/fpages/business/ftl/TcorpDetailOthersXyz.ftl?rptKey="+rptKey;
	    showWin("已结清正常类信用证记录明细",url,"window","flushPage()",window);
}

function queryNormalClearBh_onClick() {
	var rptKey = TcorpDetailOthersLetterClearedQuery_dataset.getParameter("rptKey");
	 var url = "/fpages/business/ftl/TcorpDetailOthersBh.ftl?rptKey="+rptKey;
	    showWin("已结清正常类保函记录明细",url,"window","flushPage()",window);
}

function datatable21_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var bizDetail="";
	var BizDetail = record.getValue("bizDetail");
	if("无"==BizDetail){
		bizDetail="";
	}
	else{
		bizDetail=BizDetail.replace(/查看/g,"look");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showPjtxDetailInfo('"+rptKey+"','"+bizDetail+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable22_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var bizDetail="";
	var BizDetail = record.getValue("bizDetail");
	if("无"==BizDetail){
		bizDetail="";
	}
	else{
		bizDetail=BizDetail.replace(/查看/g,"look");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showYhcdhpDetailInfo('"+rptKey+"','"+bizDetail+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable23_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var bizDetail="";
	var BizDetail = record.getValue("bizDetail");
	if("无"==BizDetail){
		bizDetail="";
	}
	else{
		bizDetail=BizDetail.replace(/查看/g,"look");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showXyzDetailInfo('"+rptKey+"','"+bizDetail+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable24_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var bizDetail="";
	var BizDetail = record.getValue("bizDetail");
	if("无"==BizDetail){
		bizDetail="";
	}
	else{
		bizDetail=BizDetail.replace(/查看/g,"look");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showBhDetailInfo('"+rptKey+"','"+bizDetail+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable27_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var type="";
	var Type = record.getValue("type");
	if("无"==Type){
		type="";
	}
	else{
		type=Type.replace(/信用证/g,"xyz");
	}
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showDkDetailInfo('"+rptKey+"','"+type+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}

function datatable28_opr_onRefresh(cell,value,record) {
	var rptKey = record.getValue("rptKey");
	var type = record.getValue("type");
	/*if("无"==Type){
		type="无";
	}
	else{
		if("其他"==Type){
			type="其他";
		}
		else{
		type=Type.replace(/信用证/g,"xyz");
		}
	}*/
	if (record) {//当存在记录时
		var htmlStr = "";
			htmlStr="<center><a href=\"JavaScript:showClearDkDetailInfo('"+rptKey+"','"+type+"')\">详细</a>";
		cell.innerHTML=htmlStr;
	} else {//当不存在记录时
		cell.innerHTML="&nbsp;";
	}
}




function showDkInfo(rptKey,historyRecord,extended,assured){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("historyRecord",historyRecord);
	 paramMap.put("extended",extended);
	 paramMap.put("assured",assured);
	 //loadPageWindows("DkpartWin","查看明细","/fpages/business/ftl/TcorpHistoryRecordDkDetail.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpHistoryRecordDkDetail.ftl?rptKey="+rptKey+"&historyRecord="+historyRecord+"&extended="+extended+"&assured="+assured;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showMyrzInfo(rptKey,historyRecord,extended,assured){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("historyRecord",historyRecord);
	 paramMap.put("extended",extended);
	 paramMap.put("assured",assured);
	 //loadPageWindows("MyrzpartWin","查看明细","/fpages/business/ftl/TcorpHistoryRecordMyrzDetail.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpHistoryRecordMyrzDetail.ftl?rptKey="+rptKey+"&historyRecord="+historyRecord+"&extended="+extended+"&assured="+assured;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showBzInfo(rptKey,type,mainBiz){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("type",type);
	 paramMap.put("mainBiz",mainBiz);
	//loadPageWindows("BzpartWin","查看明细","/fpages/business/ftl/TcorpDetailAssureWindows.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpDetailAssureWindows.ftl?rptKey="+rptKey+"&type="+type+"&mainBiz="+mainBiz;
     showWin("查看明细", url, "window", "flushPage()", window);
}

function showDkDbZqInfo(rptKey,assured,extended){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("assured",assured);
	 paramMap.put("extended",extended);
	 //loadPageWindows("DkDbZqpartWin","查看明细","/fpages/business/ftl/TcorpGuaranteedDetailDk.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpGuaranteedDetailDk.ftl?rptKey="+rptKey+"&assured="+assured+"&extended="+extended;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showMyrzDbZqInfo(rptKey,assured,extended){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("assured",assured);
	 paramMap.put("extended",extended);
	 //loadPageWindows("MyrzDbZqpartWin","查看明细","/fpages/business/ftl/TcorpGuaranteedDetailMyrz.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpGuaranteedDetailMyrz.ftl?rptKey="+rptKey+"&assured="+assured+"&extended="+extended;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showBlDbInfo(rptKey,assured){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("assured",assured);
	 //loadPageWindows("BlDbpartWin","查看明细","/fpages/business/ftl/TcorpGuaranteedDetailBl.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpGuaranteedDetailBl.ftl?rptKey="+rptKey+"&assured="+assured;
	 showWin("查看明细", url, "window", "flushPage()", window);
	
}

function showYhcdhpDbInfo(rptKey,assured){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("assured",assured);
	 //loadPageWindows("YhcdhpDbpartWin","查看明细","/fpages/business/ftl/TcorpGuaranteedDetailYhcdhp.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpGuaranteedDetailYhcdhp.ftl?rptKey="+rptKey+"&assured="+assured;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showXyzDbInfo(rptKey,assured){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("assured",assured);
	 //loadPageWindows("XyzDbpartWin","查看明细","/fpages/business/ftl/TcorpGuaranteedDetailXyz.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpGuaranteedDetailXyz.ftl?rptKey="+rptKey+"&assured="+assured;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showBhDbInfo(rptKey,assured){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("assured",assured);
	 //loadPageWindows("BhDbpartWin","查看明细","/fpages/business/ftl/TcorpGuaranteedDetailBh.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpGuaranteedDetailBh.ftl?rptKey="+rptKey+"&assured="+assured;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showLdkDbZqInfo(rptKey,assured,extended,historyRecord){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("assured",assured);
	 paramMap.put("extended",extended);
	 paramMap.put("historyRecord",historyRecord);
	 //loadPageWindows("LdkDbZqpartWin","查看明细","/fpages/business/ftl/TcorpGuaranteedDetailLdk.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpGuaranteedDetailLdk.ftl?rptKey="+rptKey+"&assured="+assured+"&extended="+extended+"&historyRecord="+historyRecord;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showNormalBlDbInfo(rptKey,assured){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("assured",assured);
	 //loadPageWindows("NormalBlDbpartWin","查看明细","/fpages/business/ftl/TcorpGuaranteedDetailNormalBl.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpGuaranteedDetailNormalBl.ftl?rptKey="+rptKey+"&assured="+assured;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showPjtxDetailInfo(rptKey,bizDetail){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("bizDetail",bizDetail);
	 //loadPageWindows("PjtxDetailpartWin","查看明细","/fpages/business/ftl/TcorpDetailSummaryPjtx.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpDetailSummaryPjtx.ftl?rptKey="+rptKey+"&bizDetail="+bizDetail;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showYhcdhpDetailInfo(rptKey,bizDetail){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("bizDetail",bizDetail);
	 //loadPageWindows("YhcdhpDetailpartWin","查看明细","/fpages/business/ftl/TcorpDetailSummaryYhcdhp.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpDetailSummaryYhcdhp.ftl?rptKey="+rptKey+"&bizDetail="+bizDetail;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showXyzDetailInfo(rptKey,bizDetail){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("bizDetail",bizDetail);
	 //loadPageWindows("XyzDetailpartWin","查看明细","/fpages/business/ftl/TcorpDetailSummaryXyz.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpDetailSummaryXyz.ftl?rptKey="+rptKey+"&bizDetail="+bizDetail;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showBhDetailInfo(rptKey,bizDetail){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("bizDetail",bizDetail);
	 //loadPageWindows("BhDetailpartWin","查看明细","/fpages/business/ftl/TcorpDetailSummaryBh.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpDetailSummaryBh.ftl?rptKey="+rptKey+"&bizDetail="+bizDetail;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showDkDetailInfo(rptKey,type){
	 var paramMap = new Map();
	 paramMap.put("rptKey",rptKey);
	 paramMap.put("type",type);
	 //loadPageWindows("DkDetailpartWin","查看明细","/fpages/business/ftl/TcorpOrginalDetailWindowsDk.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpOrginalDetailWindowsDk.ftl?rptKey="+rptKey+"&type="+type;
	 showWin("查看明细", url, "window", "flushPage()", window);
}

function showClearDkDetailInfo(rptKey,type){
	// var paramMap = new Map();
	 /*paramMap.put("rptKey",rptKey);
	// paramMap.put("type",type);
	 //alert(type);
	 paramMap.put("type",encodeURI(type));*/
	 type=encodeURI(encodeURI(type));
	 
	 //alert("11"+encodeURI(encodeURI(type)));
	 if("无"==type||"其他"==type){
			alert("无详细信息");
		}
	 else{
	 //loadPageWindows("ClearDkDetailpartWin","查看明细","/fpages/business/ftl/TcorpOrginalDetailWindowsClearDk.ftl", paramMap, "winZone");
	 var url = "/fpages/business/ftl/TcorpOrginalDetailWindowsClearDk.ftl?rptKey="+rptKey+"&type="+type;
	 showWin("查看明细", url, "window", "flushPage()", window);
	 }
}

function initCallGetter_post() {
	document.getElementById('TcorpReportExchangeRate_table').style.display="none";
	var exchangeRate=TcorpReportExchangeRate_dataset.getValue("exchangeRate");
	document.getElementById("feedBackTxt").value=exchangeRate;
	TcorpInfoBasicQuery_dataset.setReadOnly(true);
	
	var unClear = "true";
	var Clear = "true";
	var health1 = "true";
	var health2 = "true";
	var health3 = "true";
	var health4 = "true";
	var health5 = "true";
	var health6 = "true";
	var health7 = "true";
	var health8 = "true";
	var care1 = "true";
	var care2 = "true";
	var care3 = "true";
	var care4 = "true";
	var care5 = "true";
	var care6 = "true";
	var care7 = "true";
	var care8 = "true";
	var unhealth1 = "true";
	var unhealth2 = "true";
	var unhealth3 = "true";
	var unhealth4 = "true";
	var unhealth5 = "true";
	var unhealth6 = "true";
	var unhealth7 = "true";
	var unhealth8 = "true";
	var unhealth9 = "true";	
	
	
if(TcorpInfoBasicQuery_dataset!=null&&TcorpInfoBasicQuery_dataset.record==null){
	document.getElementById('TcorpInfoBasicQuery_table').style.display="none";
	document.getElementById('c').style.display="none";
}
if(TcorpInfoInvestorQuery_dataset!=null&&TcorpInfoInvestorQuery_dataset.record==null){
	document.getElementById('TcorpInfoInvestorQuery_table').style.display="none";
	document.getElementById('d').style.display="none";
}
if(TcorpInfoExecutiveQuery_dataset!=null&&TcorpInfoExecutiveQuery_dataset.record==null){
	document.getElementById('TcorpInfoExecutiveQuery_table').style.display="none";
	document.getElementById('e').style.display="none";
}
if(TcorpInfoRelevantCorpQuery_dataset!=null&&TcorpInfoRelevantCorpQuery_dataset.record==null){
	document.getElementById('TcorpInfoRelevantCorpQuery_table').style.display="none";
	document.getElementById('f').style.display="none";
}
if(TcorpSumCreditUnclearedQuery_dataset!=null&&TcorpSumCreditUnclearedQuery_dataset.record==null){
	document.getElementById('TcorpSumCreditUnclearedQuery_table').style.display="none";	
	unClear = "false";
}
if(TcorpSumCreditItemsUnclearedQuery_dataset!=null&&TcorpSumCreditItemsUnclearedQuery_dataset.record==null){
	document.getElementById('TcorpSumCreditItemsUnclearedQuery_table').style.display="none";
	document.getElementById('g').style.display="none";
	document.getElementById('UnclearedQuery_table').style.display="none";
}
else{
	if("true" == unClear){
		document.getElementById('UnclearedQuery_table').style.display="none";
	}
}
if(TcorpSumCreditclearedQuery_dataset!=null&&TcorpSumCreditclearedQuery_dataset.record==null){
	document.getElementById('TcorpSumCreditclearedQuery_table').style.display="none";
	Clear = "false";
}
if(TcorpSumCreditItemsclearedQuery_dataset!=null&&TcorpSumCreditItemsclearedQuery_dataset.record==null){
	document.getElementById('TcorpSumCreditItemsclearedQuery_table').style.display="none";
	document.getElementById('h').style.display="none";
	document.getElementById('ClearedQuery_table').style.display="none";
}
else{
	if("true" == Clear){
		document.getElementById('ClearedQuery_table').style.display="none";
	}
}
if(TcorpSumDebitHistoryQuery_dataset!=null&&TcorpSumDebitHistoryQuery_dataset.record==null){
	document.getElementById('TcorpSumDebitHistoryQuery_table').style.display="none";
	document.getElementById('i').style.display="none";
}
if(TcorpSumAssureQuery_dataset!=null&&TcorpSumAssureQuery_dataset.record==null){
	document.getElementById('TcorpSumAssureQuery_table').style.display="none";
	document.getElementById('j').style.display="none";
}
if(TcorpDetailOthersDebtQuery_dataset!=null&&TcorpDetailOthersDebtQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersDebtQuery_table').style.display="none";
	document.getElementById('k').style.display="none";
}

if(TcorpDetailOthersInterestQuery_dataset!=null&&TcorpDetailOthersInterestQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersInterestQuery_table').style.display="none";
	document.getElementById('l').style.display="none";
}
if(TcorpDetailOthersDkQuery_dataset!=null&&TcorpDetailOthersDkQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersDkQuery_table').style.display="none";
	document.getElementById('m').style.display="none";
}
if(TcorpDetailLoanUnHealthyQuery_dataset!=null&&TcorpDetailLoanUnHealthyQuery_dataset.record==null){
	document.getElementById('TcorpDetailLoanUnHealthyQuery_table').style.display="none";
	document.getElementById('n').style.display="none";
	unhealth1 = "false";
}
if(TcorpDetailOthersTradeQuery_dataset!=null&&TcorpDetailOthersTradeQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersTradeQuery_table').style.display="none";
	document.getElementById('o').style.display="none";
	unhealth2 = "false";
}
if(TcorpDetailOthersFactorQuery_dataset!=null&&TcorpDetailOthersFactorQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersFactorQuery_table').style.display="none";
	document.getElementById('p').style.display="none";
	unhealth3 = "false";
}
if(TcorpDetailOthersBillQuery_dataset!=null&&TcorpDetailOthersBillQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersBillQuery_table').style.display="none";
	document.getElementById('q').style.display="none";
	unhealth4 = "false";
}
if(TcorpDetailOthersDraftQuery_dataset!=null&&TcorpDetailOthersDraftQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersDraftQuery_table').style.display="none";
	document.getElementById('r').style.display="none";
	unhealth5 = "false";
}
if(TcorpDetailOthersCreditQuery_dataset!=null&&TcorpDetailOthersCreditQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersCreditQuery_table').style.display="none";
	document.getElementById('s').style.display="none";
	unhealth6 = "false";
}
if(TcorpDetailOthersLetterQuery_dataset!=null&&TcorpDetailOthersLetterQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersLetterQuery_table').style.display="none";
	document.getElementById('t').style.display="none";
	unhealth7 = "false";
}
if(TcorpDetailLoanUnHealthyQuery_dataset!=null&&TcorpDetailLoanUnHealthyQuery_dataset.record==null){
	document.getElementById('TcorpDetailLoanUnHealthyQuery_table').style.display="none";
	document.getElementById('cc').style.display="none";
	unhealth8 = "false";
}


if(TCorpDetailOthersQuery_dataset!=null&&TCorpDetailOthersQuery_dataset.record==null){
	document.getElementById('TCorpDetailOthersQuery_table').style.display="none";
	document.getElementById('cc').style.display="none";
	unhealth9 = "false";
}


if("false" == unhealth1 && "false" == unhealth2 && "false" == unhealth3 && "false" == unhealth4 && 
	"false" == unhealth5 && "false" == unhealth6 && "false" == unhealth7 && "false" == unhealth8 && "false" == unhealth9){
	document.getElementById('UnHealthyQuery_table').style.display="none";
}
if(TcorpDetailLoanHealthyQuery_dataset!=null&&TcorpDetailLoanHealthyQuery_dataset.record==null){
	document.getElementById('TcorpDetailLoanHealthyQuery_table').style.display="none";
	document.getElementById('u').style.display="none";
	health1 = "false";
}
if(TcorpDetailOthersLdkNormalQuery_dataset!=null&&TcorpDetailOthersLdkNormalQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersLdkNormalQuery_table').style.display="none";
	document.getElementById('v').style.display="none";
	health2 = "false";
}
if(TcorpDetailOthersTradeNormalQuery_dataset!=null&&TcorpDetailOthersTradeNormalQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersTradeNormalQuery_table').style.display="none";
	document.getElementById('w').style.display="none";
	health3 = "false";
}
if(TcorpDetailOthersFactorNormalQuery_dataset!=null&&TcorpDetailOthersFactorNormalQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersFactorNormalQuery_table').style.display="none";
	document.getElementById('x').style.display="none";
	health4 = "false";
}
if(TcorpDetailSummaryBillQuery_dataset!=null&&TcorpDetailSummaryBillQuery_dataset.record==null){
	document.getElementById('TcorpDetailSummaryBillQuery_table').style.display="none";
	document.getElementById('y').style.display="none";
	health5 = "false";
}
if(TcorpDetailSummaryDraftQuery_dataset!=null&&TcorpDetailSummaryDraftQuery_dataset.record==null){
	document.getElementById('TcorpDetailSummaryDraftQuery_table').style.display="none";
	document.getElementById('z').style.display="none";
	health6 = "false";
}
if(TcorpDetailSummaryCreditQuery_dataset!=null&&TcorpDetailSummaryCreditQuery_dataset.record==null){
	document.getElementById('TcorpDetailSummaryCreditQuery_table').style.display="none";
	document.getElementById('a1').style.display="none";
	health7 = "false";
}
if(TcorpDetailSummaryLetterQuery_dataset!=null&&TcorpDetailSummaryLetterQuery_dataset.record==null){
	document.getElementById('TcorpDetailSummaryLetterQuery_table').style.display="none";
	document.getElementById('a2').style.display="none";
	health8 = "false";
}

if(TcorpDetailSummaryLetterQuery_dataset!=null&&TcorpDetailSummaryLetterQuery_dataset.record==null){
	document.getElementById('TcorpDetailSummaryLetterQuery_table').style.display="none";
	document.getElementById('a2').style.display="none";
	health8 = "false";
}
if("false" == health1 && "false" == health2 && "false" == health3 && "false" == health4 && "false" == health5 &&
	"false" == health6 && "false" == health7 && "false" == health8){
	document.getElementById('HealthyQuery_table').style.display="none";
}
if("false" == health1 && "false" == health2 && "false" == health3 && "false" == health4 && "false" == health5 &&
"false" == health6 && "false" == health7 && "false" == health8){
document.getElementById('HealthyQuery_table').style.display="none";
}
if(TcorpDetailOthersDebtClearedQuery_dataset!=null&&TcorpDetailOthersDebtClearedQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersDebtClearedQuery_table').style.display="none";
	document.getElementById('a3').style.display="none";
}
if(TcorpDetailOthersQxClearedQuery_dataset!=null&&TcorpDetailOthersQxClearedQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersQxClearedQuery_table').style.display="none";
	document.getElementById('a4').style.display="none";
}
if(TcorpDetailOthersDkClearedQuery_dataset!=null&&TcorpDetailOthersDkClearedQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersDkClearedQuery_table').style.display="none";
	document.getElementById('a5').style.display="none";
}
if(TcorpDetailLoanHealthyClearedQuery_dataset!=null&&TcorpDetailLoanHealthyClearedQuery_dataset.record==null){
	document.getElementById('TcorpDetailLoanHealthyClearedQuery_table').style.display="none";
}else{
	document.getElementById('TcorpDetailLoanHealthyClearedQuery_table_tip').style.display="none";
}

if(TCorpDetailOthersLoanQuery_dataset!=null&&TCorpDetailOthersLoanQuery_dataset.record==null){
	document.getElementById('TCorpDetailOthersLoanQuery_table').style.display="none";
}else if(TCorpDetailOthersLoanQuery_dataset!=null&&TCorpDetailOthersLoanQuery_dataset.record!=null){
	document.getElementById('TCorpDetailOthersLoanQuery_table_tip').style.display="none";
}
//alert(TotalTcorpDetailOthersDkMxQuery_dataset.getValue("display"));
if("0" == TotalTcorpDetailOthersDkMxQuery_dataset.getValue("display")){
	document.getElementById('btn1').style.display="none";
}

if(TcorpDetailLoanHealthyClearedQuery_dataset!=null&&TcorpDetailLoanHealthyClearedQuery_dataset.record==null&&"0" == TotalTcorpDetailOthersDkMxQuery_dataset.getValue("display")){
	document.getElementById('TcorpDetailLoanHealthyClearedQuery_list').style.display="none";
	document.getElementById('a6').style.display="none";
}
	
if(TcorpDetailOthersTradeNormalClearedQuery_dataset!=null&&TcorpDetailOthersTradeNormalClearedQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersTradeNormalClearedQuery_table').style.display="none";
	//document.getElementById('btn2').style.display="none";
}else{
	document.getElementById('TcorpDetailOthersTradeNormalClearedQuery_table_tip').style.display="none";
}
if("0"==TotalTcorpDetailOthersMyrzMxQuery_dataset.getValue("display")){
	document.getElementById('btn2').style.display="none";
}
if("0"==TcorpDetailOthersModLoanMaxQuery_dataset.getValue("display")){
	document.getElementById('btnLoan').style.display="none";
	document.getElementById('TCorpDetailOthersLoanQuery_table_tip').style.display="none";
}

if(TcorpDetailOthersTradeNormalClearedQuery_dataset!=null&&TcorpDetailOthersTradeNormalClearedQuery_dataset.record==null&&"0"==TotalTcorpDetailOthersMyrzMxQuery_dataset.getValue("display")){
	document.getElementById('TcorpDetailOthersTradeNormalClearedQuery_list').style.display="none";
	document.getElementById('a7').style.display="none";
}
if(TCorpDetailOthersLoanQuery_dataset!=null&&TCorpDetailOthersLoanQuery_dataset.record==null&&"0"==TcorpDetailOthersModLoanMaxQuery_dataset.getValue("display")){
	document.getElementById('TCorpDetailOthersLoanQuery_table').style.display="none";
	document.getElementById('dd').style.display="none";
}

if(TcorpDetailOthersFactorNormalClearedQuery_dataset!=null&&TcorpDetailOthersFactorNormalClearedQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersFactorNormalClearedQuery_table').style.display="none";
	//document.getElementById('btn3').style.display="none";
}else{
	document.getElementById('TcorpDetailOthersFactorNormalClearedQuery_table_tip').style.display="none";
}
if("0"==TotalTcorpDetailOthersBlMxQuery_dataset.getValue("display")){
	document.getElementById('btn3').style.display="none";
}
if(TcorpDetailOthersFactorNormalClearedQuery_dataset!=null&&TcorpDetailOthersFactorNormalClearedQuery_dataset.record==null&&"0"==TotalTcorpDetailOthersBlMxQuery_dataset.getValue("display")){
	document.getElementById('TcorpDetailOthersFactorNormalClearedQuery_list').style.display="none";
	document.getElementById('a8').style.display="none";
}
if(TcorpDetailOthersBillClearedQuery_dataset!=null&&TcorpDetailOthersBillClearedQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersBillClearedQuery_table').style.display="none";
}else{
	document.getElementById('TcorpDetailOthersBillClearedQuery_table_tip').style.display="none";
}
if("0"==TotalTcorpDetailOthersPjtxMxQuery_dataset.getValue("display")){
	document.getElementById('btn4').style.display="none";
}
if(TcorpDetailOthersBillClearedQuery_dataset!=null&&TcorpDetailOthersBillClearedQuery_dataset.record==null&&"0"==TotalTcorpDetailOthersPjtxMxQuery_dataset.getValue("display")){
	document.getElementById('a9').style.display="none";
	document.getElementById('TcorpDetailOthersBillClearedQuery_list').style.display="none";
}


if(TcorpDetailOthersDraftClearedQuery_dataset!=null&&TcorpDetailOthersDraftClearedQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersDraftClearedQuery_table').style.display="none";
	//document.getElementById('btn5').style.display="none";
}else{
	document.getElementById('TcorpDetailOthersDraftClearedQuery_table_tip').style.display="none";
}
if("0"==TotalTcorpDetailOthersYhcdhpMxQuery_dataset.getValue("display")){
	document.getElementById('btn5').style.display="none";
}
if(TcorpDetailOthersDraftClearedQuery_dataset!=null&&TcorpDetailOthersDraftClearedQuery_dataset.record==null&&"0"==TotalTcorpDetailOthersYhcdhpMxQuery_dataset.getValue("display")){
	document.getElementById('TcorpDetailOthersDraftClearedQuery_list').style.display="none";
	document.getElementById('a10').style.display="none";
}

if(TcorpDetailOthersCreditClearedQuery_dataset!=null&&TcorpDetailOthersCreditClearedQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersCreditClearedQuery_table').style.display="none";
	//document.getElementById('btn6').style.display="none";
}else{
	document.getElementById('TcorpDetailOthersCreditClearedQuery_table_tip').style.display="none";
}
if("0"==TotalTcorpDetailOthersXyzMxQuery_dataset.getValue("display")){
	document.getElementById('btn6').style.display="none";
}
if(TcorpDetailOthersCreditClearedQuery_dataset!=null&&TcorpDetailOthersCreditClearedQuery_dataset.record==null&&"0"==TotalTcorpDetailOthersXyzMxQuery_dataset.getValue("display")){
	document.getElementById('TcorpDetailOthersCreditClearedQuery_list').style.display="none";
	document.getElementById('a11').style.display="none";
	
}

if(TcorpDetailOthersLetterClearedQuery_dataset!=null&&TcorpDetailOthersLetterClearedQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersLetterClearedQuery_table').style.display="none";//
	//document.getElementById('btn7').style.display="none";
}else{
	document.getElementById('TcorpDetailOthersLetterClearedQuery_table_tip').style.display="none";
}
if("0"==TotalTcorpDetailOthersBhMxQuery_dataset.getValue("display")){
	document.getElementById('btn7').style.display="none";
}
if(TcorpDetailOthersLetterClearedQuery_dataset!=null&&TcorpDetailOthersLetterClearedQuery_dataset.record==null&&"0"==TotalTcorpDetailOthersBhMxQuery_dataset.getValue("display")){
	document.getElementById('TcorpDetailOthersLetterClearedQuery_list').style.display="none";
	document.getElementById('a12').style.display="none";
}


if(TcorpDetailAssureQuery_dataset!=null&&TcorpDetailAssureQuery_dataset.record==null){
	document.getElementById('TcorpDetailAssureQuery_table').style.display="none";
	document.getElementById('a13').style.display="none";
}
if(TcorpPublicOweTaxQuery_dataset!=null&&TcorpPublicOweTaxQuery_dataset.record==null){
	document.getElementById('TcorpPublicOweTaxQuery_table').style.display="none";
	document.getElementById('a14').style.display="none";
}
if(TcorpJudgeRecordQuery_dataset!=null&&TcorpJudgeRecordQuery_dataset.record==null){
	document.getElementById('TcorpJudgeRecordQuery_table').style.display="none";
	document.getElementById('a15').style.display="none";
}
if(TcorpJudgeRecordForceQuery_dataset!=null&&TcorpJudgeRecordForceQuery_dataset.record==null){
	document.getElementById('TcorpJudgeRecordForceQuery_table').style.display="none";
	document.getElementById('a16').style.display="none";
}
if(TcorpPunishRecordQuery_dataset!=null&&TcorpPunishRecordQuery_dataset.record==null){
	document.getElementById('TcorpPunishRecordQuery_table').style.display="none";
	document.getElementById('a17').style.display="none";
}
if(TcorpSocialPayRecordQuery_dataset!=null&&TcorpSocialPayRecordQuery_dataset.record==null){
	document.getElementById('TcorpSocialPayRecordQuery_table').style.display="none";
	document.getElementById('a18').style.display="none";
	document.getElementById('btn8').style.display="none";
}
if(TcorpSocialPayRecordFundsQuery_dataset!=null&&TcorpSocialPayRecordFundsQuery_dataset.record==null){
	document.getElementById('TcorpSocialPayRecordFundsQuery_table').style.display="none";
	document.getElementById('a19').style.display="none";
	document.getElementById('btn9').style.display="none";
}
if(TcorpPublicAwardPermitQuery_dataset!=null&&TcorpPublicAwardPermitQuery_dataset.record==null){
	document.getElementById('TcorpPublicAwardPermitQuery_table').style.display="none";
	document.getElementById('a20').style.display="none";
}
if(TcorpPublicAwardRzQuery_dataset!=null&&TcorpPublicAwardRzQuery_dataset.record==null){
	document.getElementById('TcorpPublicAwardRzQuery_table').style.display="none";
	document.getElementById('a21').style.display="none";
}
if(TcorpPublicAwardZzQuery_dataset!=null&&TcorpPublicAwardZzQuery_dataset.record==null){
	document.getElementById('TcorpPublicAwardZzQuery_table').style.display="none";
	document.getElementById('a22').style.display="none";
}
if(TcorpPublicAwardRewardQuery_dataset!=null&&TcorpPublicAwardRewardQuery_dataset.record==null){
	document.getElementById('TcorpPublicAwardRewardQuery_table').style.display="none";
	document.getElementById('a23').style.display="none";
}
if(TcorpPublicAwardCrjQuery_dataset!=null&&TcorpPublicAwardCrjQuery_dataset.record==null){
	document.getElementById('TcorpPublicAwardCrjQuery_table').style.display="none";
	document.getElementById('a24').style.display="none";
}
if(TcorpPublicAwardMjQuery_dataset!=null&&TcorpPublicAwardMjQuery_dataset.record==null){
	document.getElementById('TcorpPublicAwardMjQuery_table').style.display="none";
	document.getElementById('a25').style.display="none";
}
if(TcorpPublicAwardJgQuery_dataset!=null&&TcorpPublicAwardJgQuery_dataset.record==null){
	document.getElementById('TcorpPublicAwardJgQuery_table').style.display="none";
	document.getElementById('a26').style.display="none";
}
if(TcorpStatementQuery_dataset!=null&&TcorpStatementQuery_dataset.record==null){
	document.getElementById('TcorpStatementQuery_table').style.display="none";
	document.getElementById('a27').style.display="none";
}



if(TcorpPublicAwardZlQuery_dataset!=null&&TcorpPublicAwardZlQuery_dataset.record==null){
	document.getElementById('TcorpPublicAwardZlQuery_table').style.display="none";
	document.getElementById('a28').style.display="none";
}
if(TcorpSocialPayRecordCauseQuery_dataset!=null&&TcorpSocialPayRecordCauseQuery_dataset.record==null){
	document.getElementById('TcorpSocialPayRecordCauseQuery_table').style.display="none";
	document.getElementById('a29').style.display="none";
	document.getElementById('btn10').style.display="none";
}
if(TcorpStatementBsQuery_dataset!=null&&TcorpStatementBsQuery_dataset.record==null){
	document.getElementById('TcorpStatementBsQuery_table').style.display="none";
	document.getElementById('a30').style.display="none";
}
if(TcorpStatementZxQuery_dataset!=null&&TcorpStatementZxQuery_dataset.record==null){
	document.getElementById('TcorpStatementZxQuery_table').style.display="none";
	document.getElementById('a31').style.display="none";
}
if(TcorpStatementZtQuery_dataset!=null&&TcorpStatementZtQuery_dataset.record==null){
	document.getElementById('TcorpStatementZtQuery_table').style.display="none";
	document.getElementById('a32').style.display="none";
}

if(TcorpDetailLoanHealthyCareQuery_dataset!=null&&TcorpDetailLoanHealthyCareQuery_dataset.record==null){
	document.getElementById('TcorpDetailLoanHealthyCareQuery_table').style.display="none";
	document.getElementById('a33').style.display="none";
	care1 = "false";
}
if(TcorpDetailOthersTradeCareQuery_dataset!=null&&TcorpDetailOthersTradeCareQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersTradeCareQuery_table').style.display="none";
	document.getElementById('a34').style.display="none";
	care2 = "false";
}
if(TcorpDetailOthersFactorCareQuery_dataset!=null&&TcorpDetailOthersFactorCareQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersFactorCareQuery_table').style.display="none";
	document.getElementById('a35').style.display="none";
	care3 = "false";
}
if(TcorpDetailOthersBillCareQuery_dataset!=null&&TcorpDetailOthersBillCareQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersBillCareQuery_table').style.display="none";
	document.getElementById('a36').style.display="none";
	care4 = "false";
}
if(TcorpDetailOthersDraftCareQuery_dataset!=null&&TcorpDetailOthersDraftCareQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersDraftCareQuery_table').style.display="none";
	document.getElementById('a37').style.display="none";
	care5 = "false";
}
if(TcorpDetailOthersCreditCareQuery_dataset!=null&&TcorpDetailOthersCreditCareQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersCreditCareQuery_table').style.display="none";
	document.getElementById('a38').style.display="none";
	care6 = "false";
}
if(TcorpDetailOthersLetterCareQuery_dataset!=null&&TcorpDetailOthersLetterCareQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersLetterCareQuery_table').style.display="none";
	document.getElementById('a39').style.display="none";
	care7 = "false";
}
if(TcorpDetailOthersAttentionQuery_dataset!=null&&TcorpDetailOthersAttentionQuery_dataset.record==null){
	document.getElementById('TcorpDetailOthersAttentionQuery_table').style.display="none";
	document.getElementById('a345').style.display="none";
	care8 = "false";
}
if("false" == care1 && "false" == care2 && "false" == care3 && "false" == care4 && "false" == care5 &&
	"false" == care6 && "false" == care7 && "false" == care8){
	document.getElementById('HealthyQueryCare_table').style.display="none";
}

if((TcorpStatementBsQuery_dataset!=null&&TcorpStatementBsQuery_dataset.record==null)&&(TcorpStatementZxQuery_dataset!=null&&TcorpStatementZxQuery_dataset.record==null)&&(TcorpStatementZtQuery_dataset!=null&&TcorpStatementZtQuery_dataset.record==null)){
	document.getElementById('title11').style.display="none";
}
if(TcorpSumCreditUnclearedQuery_dataset.record == null && TcorpSumCreditItemsUnclearedQuery_dataset.record == null && TcorpSumCreditclearedQuery_dataset.record == null && TcorpSumCreditItemsclearedQuery_dataset.record == null &&  TcorpSumDebitHistoryQuery_dataset.record == null &&  TcorpSumAssureQuery_dataset.record == null ){
	document.getElementById('Infomation_table').style.display="";
}else{
	document.getElementById('Infomation_table').style.display="none";
	
}

//未结清业务
if((TcorpDetailOthersDebtQuery_dataset!=null&&TcorpDetailOthersDebtQuery_dataset.record==null)&&(TcorpDetailOthersInterestQuery_dataset!=null&&TcorpDetailOthersInterestQuery_dataset.record==null)&&(TcorpDetailOthersDkQuery_dataset!=null&&TcorpDetailOthersDkQuery_dataset.record==null)&&(TcorpDetailLoanUnHealthyQuery_dataset!=null&&TcorpDetailLoanUnHealthyQuery_dataset.record==null)&&(TcorpDetailOthersTradeQuery_dataset!=null&&TcorpDetailOthersTradeQuery_dataset.record==null)&&(TcorpDetailOthersFactorQuery_dataset!=null&&TcorpDetailOthersFactorQuery_dataset.record==null)&&(TcorpDetailOthersBillQuery_dataset!=null&&TcorpDetailOthersBillQuery_dataset.record==null)&&(TcorpDetailOthersDraftQuery_dataset!=null&&TcorpDetailOthersDraftQuery_dataset.record==null)&&(TcorpDetailOthersCreditQuery_dataset!=null&&TcorpDetailOthersCreditQuery_dataset.record==null)&&(TcorpDetailOthersLetterQuery_dataset!=null&&TcorpDetailOthersLetterQuery_dataset.record==null)&&(TcorpDetailLoanHealthyCareQuery_dataset!=null&&TcorpDetailLoanHealthyCareQuery_dataset.record==null)&&(TcorpDetailOthersTradeCareQuery_dataset!=null&&TcorpDetailOthersTradeCareQuery_dataset.record==null)&&(TcorpDetailOthersFactorCareQuery_dataset!=null&&TcorpDetailOthersFactorCareQuery_dataset.record==null)&&(TcorpDetailOthersBillCareQuery_dataset!=null&&TcorpDetailOthersBillCareQuery_dataset.record==null)&&(TcorpDetailOthersDraftCareQuery_dataset!=null&&TcorpDetailOthersDraftCareQuery_dataset.record==null)&&(TcorpDetailOthersCreditCareQuery_dataset!=null&&TcorpDetailOthersCreditCareQuery_dataset.record==null)&&(TcorpDetailOthersLetterCareQuery_dataset!=null&&TcorpDetailOthersLetterCareQuery_dataset.record==null)&&(TcorpDetailLoanHealthyQuery_dataset!=null&&TcorpDetailLoanHealthyQuery_dataset.record==null)&&(TcorpDetailOthersLdkNormalQuery_dataset!=null&&TcorpDetailOthersLdkNormalQuery_dataset.record==null)&&(TcorpDetailOthersTradeNormalQuery_dataset!=null&&TcorpDetailOthersTradeNormalQuery_dataset.record==null)&&(TcorpDetailOthersFactorNormalQuery_dataset!=null&&TcorpDetailOthersFactorNormalQuery_dataset.record==null)&&(TcorpDetailSummaryBillQuery_dataset!=null&&TcorpDetailSummaryBillQuery_dataset.record==null)&&(TcorpDetailSummaryDraftQuery_dataset!=null&&TcorpDetailSummaryDraftQuery_dataset.record==null)&&(TcorpDetailSummaryCreditQuery_dataset!=null&&TcorpDetailSummaryCreditQuery_dataset.record==null)&&(TcorpDetailSummaryLetterQuery_dataset!=null&&TcorpDetailSummaryLetterQuery_dataset.record==null)){
	document.getElementById('CreditRecord').style.display="none";
}

//已结清业务
if((TCorpDetailOthersLoanQuery_dataset!=null&&TCorpDetailOthersLoanQuery_dataset.record==null)&&(TcorpDetailOthersDebtClearedQuery_dataset!=null&&TcorpDetailOthersDebtClearedQuery_dataset.record==null)&&(TcorpDetailOthersQxClearedQuery_dataset!=null&&TcorpDetailOthersQxClearedQuery_dataset.record==null)&&(TcorpDetailOthersDkClearedQuery_dataset!=null&&TcorpDetailOthersDkClearedQuery_dataset.record==null)&&(TcorpDetailLoanHealthyClearedQuery_dataset!=null&&TcorpDetailLoanHealthyClearedQuery_dataset.record==null&&"0" == TotalTcorpDetailOthersDkMxQuery_dataset.getValue("display"))&&(TcorpDetailOthersTradeNormalClearedQuery_dataset!=null&&TcorpDetailOthersTradeNormalClearedQuery_dataset.record==null&&"0"==TotalTcorpDetailOthersMyrzMxQuery_dataset.getValue("display"))&&(TcorpDetailOthersFactorNormalClearedQuery_dataset!=null&&TcorpDetailOthersFactorNormalClearedQuery_dataset.record==null&&"0"==TotalTcorpDetailOthersBlMxQuery_dataset.getValue("display"))&&(TcorpDetailOthersBillClearedQuery_dataset!=null&&TcorpDetailOthersBillClearedQuery_dataset.record==null&&"0"==TotalTcorpDetailOthersPjtxMxQuery_dataset.getValue("display"))&&(TcorpDetailOthersDraftClearedQuery_dataset!=null&&TcorpDetailOthersDraftClearedQuery_dataset.record==null&&"0"==TotalTcorpDetailOthersYhcdhpMxQuery_dataset.getValue("display"))&&(TcorpDetailOthersCreditClearedQuery_dataset!=null&&TcorpDetailOthersCreditClearedQuery_dataset.record==null&&"0"==TotalTcorpDetailOthersXyzMxQuery_dataset.getValue("display"))&&(TcorpDetailOthersLetterClearedQuery_dataset!=null&&TcorpDetailOthersLetterClearedQuery_dataset.record==null&&"0"==TotalTcorpDetailOthersBhMxQuery_dataset.getValue("display"))&&(TcorpDetailAssureQuery_dataset!=null&&TcorpDetailAssureQuery_dataset.record==null)){
	document.getElementById('AlreadyClear').style.display="none";
}

//财务报表
if((TcorpYearlyBalanceReportQuery_dataset!=null&&TcorpYearlyBalanceReportQuery_dataset.record==null)&&(TcorpYearlyProfitReportQuery_dataset!=null&&TcorpYearlyProfitReportQuery_dataset.record==null)&&(TcorpYearlyCashFlowReportQuery_dataset!=null&&TcorpYearlyCashFlowReportQuery_dataset.record==null)){
	document.getElementById('financialReport').style.display="none";
}
if(TcorpYearlyBalanceReportQuery_dataset!=null&&TcorpYearlyBalanceReportQuery_dataset.record==null){
	document.getElementById('TcorpYearlyBalanceReportQuery_table').style.display="none";
	document.getElementById('zc').style.display="none";
}
if(TcorpYearlyProfitReportQuery_dataset!=null&&TcorpYearlyProfitReportQuery_dataset.record==null){
	document.getElementById('TcorpYearlyProfitReportQuery_table').style.display="none";
	document.getElementById('lr').style.display="none";
}
if(TcorpYearlyCashFlowReportQuery_dataset!=null&&TcorpYearlyCashFlowReportQuery_dataset.record==null){
	document.getElementById('TcorpYearlyCashFlowReportQuery_table').style.display="none";
	document.getElementById('xj').style.display="none";
}

if((TcorpPublicOweTaxQuery_dataset!=null&&TcorpPublicOweTaxQuery_dataset.record==null)&&(TcorpJudgeRecordQuery_dataset!=null&&TcorpJudgeRecordQuery_dataset.record==null)&&(TcorpJudgeRecordForceQuery_dataset!=null&&TcorpJudgeRecordForceQuery_dataset.record==null)&&(TcorpPunishRecordQuery_dataset!=null&&TcorpPunishRecordQuery_dataset.record==null)&&(TcorpSocialPayRecordQuery_dataset!=null&&TcorpSocialPayRecordQuery_dataset.record==null)&&(TcorpSocialPayRecordFundsQuery_dataset!=null&&TcorpSocialPayRecordFundsQuery_dataset.record==null)&&(TcorpPublicAwardPermitQuery_dataset!=null&&TcorpPublicAwardPermitQuery_dataset.record==null)&&(TcorpPublicAwardRzQuery_dataset!=null&&TcorpPublicAwardRzQuery_dataset.record==null)&&(TcorpPublicAwardZzQuery_dataset!=null&&TcorpPublicAwardZzQuery_dataset.record==null)&&(TcorpPublicAwardRewardQuery_dataset!=null&&TcorpPublicAwardRewardQuery_dataset.record==null)&&(TcorpPublicAwardCrjQuery_dataset!=null&&TcorpPublicAwardCrjQuery_dataset.record==null)&&(TcorpPublicAwardMjQuery_dataset!=null&&TcorpPublicAwardMjQuery_dataset.record==null)&&(TcorpPublicAwardJgQuery_dataset!=null&&TcorpPublicAwardJgQuery_dataset.record==null)&&(TcorpStatementQuery_dataset!=null&&TcorpStatementQuery_dataset.record==null)&&(TcorpPublicAwardZlQuery_dataset!=null&&TcorpPublicAwardZlQuery_dataset.record==null)&&(TcorpSocialPayRecordCauseQuery_dataset!=null&&TcorpSocialPayRecordCauseQuery_dataset.record==null)){
	document.getElementById('BulletinRecord').style.display="none";
}



}
function countCurrentAvailbleDataset(dataset){
	  var cnt=0;
	  var b=dataset.firstUnit;
	  while(b){
		  if(b.recordState !="delete" && b.recordState !="discard" ){
			  cnt=cnt+1;
		  }
		  b=b.nextUnit;
	  }
	  return cnt;
}
</script>
</@CommonQueryMacro.page>
