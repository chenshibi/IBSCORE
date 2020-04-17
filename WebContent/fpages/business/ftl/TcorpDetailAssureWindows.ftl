<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="对外担保记录">
<table align="left" width="100%">
<tr>

<@CommonQueryMacro.CommonQuery id="TcorpDetailAssureWindowsLoanQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailAssureWindowsQuery_table1" >
	<tr valign="center" >
		<td align="center">
		<h3>未结清贷款</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="currency,amout,releaseDate,closeDate,balance,fiveLevel,assureStatus" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
		<div id="a"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></div>
	
</@CommonQueryMacro.CommonQuery>
<@CommonQueryMacro.CommonQuery id="TcorpDetailAssureWindowsTradeFianlQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailAssureWindowsQuery_table2" >
	<tr valign="center" >
		<td align="center">
		<h3>未结清贸易融资</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable2"  fieldStr="currency,amout,releaseDate,closeDate,balance,fiveLevel" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
		<div id="b"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	
</@CommonQueryMacro.CommonQuery>
<@CommonQueryMacro.CommonQuery id="TcorpDetailAssureWindowsFactorQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailAssureWindowsQuery_table3"  >
	<tr valign="center">
		<td align="center" >
		<h3>未结清保理</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable3"  fieldStr="currency,amout,releaseDate,closeDate,balance,fiveLevel" readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
		<div id="c"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	
</@CommonQueryMacro.CommonQuery>
<@CommonQueryMacro.CommonQuery id="TcorpDetailAssureWindowsAcceptanceQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailAssureWindowsQuery_table4"  >
	<tr valign="center" >
		<td align="center">
		<h3>未结清银行承兑汇票</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable4"  fieldStr="currency,amout,releaseDate,closeDate,fiveLevel"  readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
		<div id="d"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	
</@CommonQueryMacro.CommonQuery>
<@CommonQueryMacro.CommonQuery id="TcorpDetailAssureWindowsCreditQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailAssureWindowsQuery_table5"  >
	<tr valign="center" >
		<td align="center">
		<h3>未结清信用证</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable5"  fieldStr="currency,amout,releaseDate,closeDate,fiveLevel"  readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
		<div id="e"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	
</@CommonQueryMacro.CommonQuery>
<@CommonQueryMacro.CommonQuery id="TcorpDetailAssureWindowsPaulikQuery" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
	<table width="100%" id="TcorpDetailAssureWindowsQuery_table6"  >
	<tr valign="center" >
		<td align="center">
		<h3>未结清保函</h3>
		</td>
	</tr>
	<tr>
		<td valign="top">
			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable6"  fieldStr="currency,amout,releaseDate,closeDate,fiveLevel"  readonly="true" width="100%"/>
		</td>
	</tr>
	   
	</table>
		<div id="f"><h3 style="text-align:center;">当前操作员:${statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()}</h3></br></br></div>
	
</@CommonQueryMacro.CommonQuery>


<div  align="center"  margin-top="20px">
	<input type="button" name="close" value="关闭" style="margin-top:80px;background-color:#d6e5f8" onclick="goback()" />
</div> 
<script language="JavaScript">
	function initCallGetter_post(){
			
			document.getElementById('TcorpDetailAssureWindowsQuery_table1').style.display="none";
			document.getElementById('TcorpDetailAssureWindowsQuery_table2').style.display="none";
			document.getElementById('TcorpDetailAssureWindowsQuery_table3').style.display="none";
			document.getElementById('TcorpDetailAssureWindowsQuery_table4').style.display="none";
			document.getElementById('TcorpDetailAssureWindowsQuery_table5').style.display="none";
			document.getElementById('TcorpDetailAssureWindowsQuery_table6').style.display="none";
			document.getElementById('a').style.display="none";
			document.getElementById('b').style.display="none";
			document.getElementById('c').style.display="none";
			document.getElementById('d').style.display="none";
			document.getElementById('e').style.display="none";
			document.getElementById('f').style.display="none";
		
			var title1=TcorpDetailAssureWindowsLoanQuery_dataset.getValue("title");
			var title2=TcorpDetailAssureWindowsTradeFianlQuery_dataset.getValue("title");
			var title3=TcorpDetailAssureWindowsFactorQuery_dataset.getValue("title");
			var title4=TcorpDetailAssureWindowsAcceptanceQuery_dataset.getValue("title");
			var title5=TcorpDetailAssureWindowsCreditQuery_dataset.getValue("title");
			var title6=TcorpDetailAssureWindowsPaulikQuery_dataset.getValue("title");
			
		if("未结清贷款" == title1){
			document.getElementById('TcorpDetailAssureWindowsQuery_table1').style.display="";
			document.getElementById('a').style.display="";
			
		}if("未结清贸易融资" == title2){
			document.getElementById('TcorpDetailAssureWindowsQuery_table2').style.display="";
			document.getElementById('b').style.display="";
		}if("未结清保理" == title3){
			document.getElementById('TcorpDetailAssureWindowsQuery_table3').style.display="";
			document.getElementById('c').style.display="";
		}if("未结清银行承兑汇票" == title4){
			document.getElementById('TcorpDetailAssureWindowsQuery_table4').style.display="";
			document.getElementById('d').style.display="";
		}if("未结清信用证" == title5){
			document.getElementById('TcorpDetailAssureWindowsQuery_table5').style.display="";
			document.getElementById('e').style.display="";
		}if("未结清保函" == title6){
			document.getElementById('TcorpDetailAssureWindowsQuery_table6').style.display="";
			document.getElementById('f').style.display="";
		}
	}
	function goback(){
		closeWin();
	}
</script>
</@CommonQueryMacro.page>
