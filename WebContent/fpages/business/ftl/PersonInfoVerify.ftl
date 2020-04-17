<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="个人信息核验">
	<table align="left" width="100%">
     <tr>
     <@CommonQueryMacro.CommonQuery id="IndAppQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
		<table width="100%" id="IndAppQuery_table">
		 	<tr>
		      	<td  align="center">
					<@CommonQueryMacro.Group id="group1" label="个人基本信息"  fieldStr="rptId,returnTime,name,idType,individualId" colNm=6 /></br>
		        </td>
		    </tr>	
		   
		</table>
		<div id="c"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	</@CommonQueryMacro.CommonQuery>
	
    
    <@CommonQueryMacro.CommonQuery id="IndInfoQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="IndInfoQuery_table">
	 <tr>
	  	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="身份信息"  fieldStr="gender,birthday,marriage,mobile,phoneCom,phoneLiv,addr,education,hukouAddr,degree" colNm=4 /></br>
	    </td>
	    </tr>	
	    <tr>
	  	<td  align="center">
			<@CommonQueryMacro.Group id="group1" label="配偶信息"  fieldStr="spouse,spouseIdType,spouseIdNumber,spouseCom,spousePhone" colNm=6 /></br>
	    </td>
	    </tr>	
	   
	</table>
	<div id="c1"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndAddrQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndAddrQuery_table">
<tr valign="center">
	<td align="center">
	<h3>居住信息</h3>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="number,address[400],status,getDate[150]" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="c2"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndJobQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndJobQuery_table">
<tr valign="center">
	<td align="center">
	<h3>职业信息</h3>
	</td>
</tr>
<tr>
	<td valign="top">
		 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
	</td>
</tr>
<tr>
	<td>
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,name,addr,profession,industry,title,titleTec,startdates[200],getdate[200]" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="c3"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndOweTaxQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndOweTaxQuery_table">
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
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,manager,amount,taxDate" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="c4"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
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
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,organ,reason,initDate,type,result,endDate,subjectName[200],subjectAmount" readonly="true" width="100%"/>
	</td>
</tr>

</table>
<div id="c5"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
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
		<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="no,organ,reason,initDate,type,status,endDate,subjectName,subjectAmount[200],objectName,objectAmount" readonly="true" width="100%"/>
	</td>
</tr>
   
</table>
<div id="c6"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
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
<div id="c7"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndHousefundDepositQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndHousefundDepositQuery_table">
<tr valign="center">
	<td align="center">
	<h3>住房公积金参缴记录</h3>
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
<div id="c8"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndInsDepositQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndInsDepositQuery_table">
<tr valign="center">
	<td align="center">
	<h3>养老保险金缴存记录</h3>
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
<div id="c9"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndInsPaymentQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndInsPaymentQuery_table">
<tr valign="center">
	<td align="center">
	<h3>养老保险金发放记录</h3>
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
<div id="c10"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndSuccourQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndSuccourQuery_table">
<tr valign="center">
	<td align="center">
	<h3>低保救助记录</h3>
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
<div id="c11"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndAwardPraQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndAwardPraQuery_table">
<tr valign="center">
	<td align="center">
	<h3>执业资格记录</h3>
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
<div id="c12"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndAwardBonQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndAwardBonQuery_table">
<tr valign="center">
	<td align="center">
	<h3>行政奖励记录</h3>
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
<div id="c13"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndCarTradeQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndCarTradeQuery_table">
<tr valign="center">
	<td align="center">
	<h3>车辆交易和抵押记录</h3>
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
<div id="c14"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndTelecomPaymentQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndTelecomPaymentQuery_table">
<tr valign="center">
	<td align="center">
	<h3>电信缴费记录</h3>
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
<div id="c15"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndStatementDeclareQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndStatementDeclareQuery_table">
<tr valign="center">
	<td align="center">
	<h3>本人声明</h3>
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
<div id="c16"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
</@CommonQueryMacro.CommonQuery>

<@CommonQueryMacro.CommonQuery id="IndStatementDissentQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
<table width="100%" id="IndStatementDissentQuery_table">
<tr valign="center">
	<td align="center">
	<h3>异议标注</h3>
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
<div id="c17"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
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
function initCallGetter_post() {
	IndAppQuery_dataset.setReadOnly(true);
	IndInfoQuery_dataset.setReadOnly(true);
	if(IndAppQuery_dataset.record==null){
		document.getElementById('IndAppQuery_table').style.display="none";
		document.getElementById('c').style.display="none";
	}
	if(IndInfoQuery_dataset.record==null){
		document.getElementById('IndInfoQuery_table').style.display="none";
		document.getElementById('c1').style.display="none";
	}
	if(IndAddrQuery_dataset.record==null){
		document.getElementById('IndAddrQuery_table').style.display="none";
		document.getElementById('c2').style.display="none";
	}
	if(IndJobQuery_dataset.record==null){
		document.getElementById('IndJobQuery_table').style.display="none";
		document.getElementById('c3').style.display="none";
	}
	if(IndOweTaxQuery_dataset.record==null){
		document.getElementById('IndOweTaxQuery_table').style.display="none";
		document.getElementById('c4').style.display="none";
	}
	if(IndPublicRecordCivilQuery_dataset.record==null){
		document.getElementById('IndPublicRecordCivilQuery_table').style.display="none";
		document.getElementById('c5').style.display="none";
	}
	if(IndPublicRecordForceQuery_dataset.record==null){
		document.getElementById('IndPublicRecordForceQuery_table').style.display="none";
		document.getElementById('c6').style.display="none";
	}
	if(IndPublicRecordProgQuery_dataset.record==null){
		document.getElementById('IndPublicRecordProgQuery_table').style.display="none";
		document.getElementById('c7').style.display="none";
	}
	if(IndHousefundDepositQuery_dataset.record==null){
		document.getElementById('IndHousefundDepositQuery_table').style.display="none";
		document.getElementById('c8').style.display="none";
	}
	if(IndInsDepositQuery_dataset.record==null){
		document.getElementById('IndInsDepositQuery_table').style.display="none";
		document.getElementById('c9').style.display="none";
	}
	if(IndInsPaymentQuery_dataset.record==null){
		document.getElementById('IndInsPaymentQuery_table').style.display="none";
		document.getElementById('c10').style.display="none";
	}
	if(IndSuccourQuery_dataset.record==null){
		document.getElementById('IndSuccourQuery_table').style.display="none";
		document.getElementById('c11').style.display="none";
	}
	if(IndAwardPraQuery_dataset.record==null){
		document.getElementById('IndAwardPraQuery_table').style.display="none";
		document.getElementById('c12').style.display="none";
	}
	if(IndAwardBonQuery_dataset.record==null){
		document.getElementById('IndAwardBonQuery_table').style.display="none";
		document.getElementById('c13').style.display="none";
	}
	if(IndCarTradeQuery_dataset.record==null){
		document.getElementById('IndCarTradeQuery_table').style.display="none";
		document.getElementById('c14').style.display="none";
	}
	if(IndTelecomPaymentQuery_dataset.record==null){
		document.getElementById('IndTelecomPaymentQuery_table').style.display="none";
		document.getElementById('c15').style.display="none";
	}
	if(IndStatementDeclareQuery_dataset.record==null){
		document.getElementById('IndStatementDeclareQuery_table').style.display="none";
		document.getElementById('c16').style.display="none";
	}
	if(IndStatementDissentQuery_dataset.record==null){
		document.getElementById('IndStatementDissentQuery_table').style.display="none";
		document.getElementById('c17').style.display="none";
	}
	
}

</script>
</@CommonQueryMacro.page>
