	<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as AssureIndCustTotalNew>

<HTML>
<HEAD>
<@AssureIndCustTotalNew.page title="自然人对外担保汇总">

    <TITLE>自然人对外担保汇总</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=UTF-8">
	<style type="text/css">
        
        .tableStyle {
            border-collapse: collapse;
            border: none;
            border-color: black;
        }

        .tdStyle {
            border: 1px solid;
        }

        
    </style>
    <style type="text/css">
        
        .style1 {
            color: #0066cc;
            font-weight: bold;
        }

        .style4 {
            color: #0066cc;
            font-size: 14px;
        }

        TD {
            FONT-FAMILY: 宋 体;
            FONT-SIZE: 9pt
        }

        
    </style>
    
    
    <script type="text/javascript">
function goback(){
	//window.location.href="${contextPath}/fpages/business/ftl/inqRequest.ftl";
	closeWin();
}
function printHtml(){
	var htmlpdf = document.getElementById("centerId").innerHTML;
	var sfForm = document.createElement("form");
	document.body.appendChild(sfForm);
		sfForm.method = "post";
		sfForm.style.display = "none";
		var tmpInput =  document.createElement("input");
		tmpInput.name = "htmlpdf";
		tmpInput.value = encodeURI(encodeURI(htmlpdf));
		sfForm.appendChild(tmpInput);
		var url = "${contextPath}/PrintAssureTotleCustAction.do";
		sfForm.action = url;
		sfForm.submit();	
}
function printme(){
window.print();
}
if(!window.showModalDialog){
	window.showModalDialog=function(url,name,option){
		if(window.hasOpenWindow){
			window.newWindow.focus();
		}
		var re = new RegExp(";", "g");  
		var option  = option.replace(re, '","'); //把option转为json字符串
		var re2 = new RegExp(":", "g");
		option = '{"'+option.replace(re2, '":"')+'"}';
		option = JSON.parse(option);
		var openOption = 'width='+parseInt(option.dialogWidth)+',height='+parseInt(option.dialogHeight)+',left='+(window.screen.width-parseInt(option.dialogWidth))/2+',top='+(window.screen.height-30-parseInt(option.dialogHeight))/2;
		window.hasOpenWindow = true;
		window.newWindow = window.open(url,name,openOption);
	}
}
function showGuarantDetail(contractNo,rptKey,no,contractType){
	var  url='/fpages/assure/ftl/AssureIndCustTotalGuarantDetail.ftl?contractNo='+contractNo+'&rptKey='+rptKey+'&no='+no+'&contractType='+contractType;
	//window.showModalDialog(url,window,'dialogWidth:1000px;dialogHeight:800px;status:no;help:no;scroll:no;');
	showWin("保证合同详细信息", url, "window", "flushPage()", window);
}
function showPledgeDetail(contractNo,rptKey,no,contractType){
	var  url='/fpages/assure/ftl/AssureIndCustTotalPledgeDetail.ftl?contractNo='+contractNo+'&rptKey='+rptKey+'&no='+no+'&contractType='+contractType;
	//window.showModalDialog(url,window,'dialogWidth:1000px;dialogHeight:800px;status:no;help:no;scroll:no;');
	showWin("抵押合同详细信息", url, "window", "flushPage()", window);
}
function showImpawnDetail(contractNo,rptKey,no,contractType){
	var  url='/fpages/assure/ftl/AssureIndCustTotalImpawnDetail.ftl?contractNo='+contractNo+'&rptKey='+rptKey+'&no='+no+'&contractType='+contractType;
	//window.showModalDialog(url,window,'dialogWidth:1000px;dialogHeight:800px;status:no;help:no;scroll:no;');
	showWin("质押合同详细信息", url, "window", "flushPage()", window);
	
}


</script>
</@AssureIndCustTotalNew.page>
</HEAD>
<#assign rptKey = RequestParameters["rptKey"]?default("true")>
<#assign queryTime = RequestParameters["queryTime"]?default("true")>
<#assign AssureIndSumList = statics["com.huateng.ebank.business.assure.getter.AssureIndCustTotalQueryGetter"].getAssureIndSum(rptKey)/>	
<#assign AssureIndGuaranteeGuarantList = statics["com.huateng.ebank.business.assure.getter.AssureIndCustTotalQueryGetter"].getAssureIndGuaranteeGuarant(rptKey)/>		
<#assign AssureIndGuaranteePledgeList = statics["com.huateng.ebank.business.assure.getter.AssureIndCustTotalQueryGetter"].getAssureIndGuaranteePledge(rptKey)/>	
<#assign AssureIndGuaranteeImpawnList = statics["com.huateng.ebank.business.assure.getter.AssureIndCustTotalQueryGetter"].getAssureIndGuaranteeImpawn(rptKey)/>				   

<#assign tlrno= statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()>


<BODY leftMargin=0 topMargin=35 rightMargin=0 width = "800">
<CENTER id="centerId">

    <table width="80%" cellspacing="0" cellpadding="0" align="center"
           style="border-collapse: collapse; border: none" border="0">
        <tbody>
        <tr>
            <td height="117" align="center">
                <table height="95" cellspacing="0" cellpadding="0" width="80%"
                       align="center" style="border-collapse: collapse; border: none">
                    <tbody>
                    <tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="6"><b><font
                                            face="黑体">自然人对外担保汇总</font></b></font></div>
                        </td>
                    </tr>
                    <tr>
                        <td class="high"  align="left"><span
                                class="style1"><b><font color="#0066cc">编号:${rptKey}
                                        </font></b></span></td>
                        <td height="40px"  align="right">
                            <span class="style1"><font
                                        color="#0066cc"><b>时间:${queryTime}</b></font></span><font
                                    color="#0066cc"><b></b></font>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </td>
        </tr>
        </tbody>
    </table>
<#list AssureIndSumList as AssureList >                    
<#if AssureList.contractType =="guarant" >

    <tr>
       <td height="30" valign="bottom">
          <div align="center"><font color="#0066cc"><span class="high"><b>保证合同</b></span></font></div>
       </td>
    </tr></br>
    <tr>
       <td>
                <table cellspacing="0" cellpadding="0" width="90%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tbody>
                    <tr height="30" align="center" valign="middle">
                        <td class="tdStyle" width="5%"><font color="#0066cc">序号</font>
                        </td>
                        <td class="tdStyle" width="30%"><font color="#0066cc">保证合同编号</font>
                        </td>
                        <td class="tdStyle" width="10%"><font color="#0066cc"> 保证合同有效状态</font>
                        </td>
                        <td class="tdStyle" width="10%" ><font color="#0066cc"> 保证合同金额</font>
                        </td>
                        <td class="tdStyle" width="10%" ><font color="#0066cc"> 保证合同金额计量币种</font>
                        </td>
                        <td class="tdStyle" width="10%" ><font color="#0066cc"> 本担保人保证担保金额</font>
                        </td>
                        <td class="tdStyle" width="10%" ><font color="#0066cc"> 本担保人保证担保金额计量币种</font>
                        </td>
                        <td class="tdStyle" width="30%" ><font color="#0066cc"> 业务发生金融机构名称</font>
                        </td>
                    </tr>
                   </tbody>
                </table>
<#list AssureIndGuaranteeGuarantList as guarantList  >
				 <table cellspacing="0" cellpadding="0" width="90%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tbody>
                    <tr height="30">
                        <td class="tdStyle" width="5%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.no}</span></font></div>
                        </td>
                         <td class="tdStyle" width="30%">
	                       	<center><a href="JavaScript:showGuarantDetail('${guarantList.contractNo}','${guarantList.rptKey}','${guarantList.no}','${guarantList.contractType}')">${guarantList.contractNo}</a>
	                     </td>
                         <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.contract_eff_flag}</span></font></div>
                        </td>
                          <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.contract_no_amount}</span></font></div>
                        </td>
                          <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.contract_no_currency}</span></font></div>
                        </td>
                          <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.guarantee_amount}</span></font></div>
                        </td>
                        </td>
                          <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.guarantee_currency}</span></font></div>
                        </td>
                        </td>
                          <td class="tdStyle" width="30%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.financial_org}</span></font></div>
                        </td>
                    </tr>
                    </tbody>
                </table>
          </td>
        </tr>
</#list>
         <tr align="center" valign="middle">
                 <td height="24" colspan="3">
                        <div align="center"><font color="#0066cc" size="2"><b><font face="黑体">本担保人保证担保金额本外币合计：${AssureList.sumAmount}</font></b></font></div>
                  </td>
        </tr></br>
        <tr align="center" valign="middle">
                 <td height="24" colspan="3">
                        <div align="center"><font color="#0066cc" size="2"><b><font face="黑体">当前用户为：${tlrno}</font></b></font></div>
                  </td>
        </tr></br></br></br>

</#if>	

<#if AssureList.contractType =="pledge" >
    <tr>
       <td height="30" valign="bottom">
          <div align="center"><font color="#0066cc"><span class="high"><b>抵押合同</b></span></font></div>
       </td>
    </tr></br>
    <tr>
       <td>
                <table cellspacing="0" cellpadding="0" width="90%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tbody>
                    <tr height="30" align="center" valign="middle">
                        <td class="tdStyle" width="5%"><font color="#0066cc">序号</font>
                        </td>
                        <td class="tdStyle" width="30%"><font color="#0066cc">抵押合同编号</font>
                        </td>
                        <td class="tdStyle" width="10%"><font color="#0066cc"> 抵押合同有效状态</font>
                        </td>
                        <td class="tdStyle" width="10%" ><font color="#0066cc"> 抵押合同金额</font>
                        </td>
                        <td class="tdStyle" width="10%" ><font color="#0066cc"> 抵押合同金额计量币种</font>
                        </td>
                        <td class="tdStyle" width="10%" ><font color="#0066cc"> 本担保人保证抵押金额</font>
                        </td>
                        <td class="tdStyle" width="10%" ><font color="#0066cc"> 本担保人保证抵押金额计量币种</font>
                        </td>
                        <td class="tdStyle" width="30%" ><font color="#0066cc"> 业务发生金融机构名称</font>
                        </td>
                    </tr>
                    </tbody>
                </table>
<#list AssureIndGuaranteePledgeList as pledgeList  >
  					<table cellspacing="0" cellpadding="0" width="90%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tbody>
                    <tr height="30">
                        <td class="tdStyle" width="5%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${pledgeList.no}</span></font></div>
                        </td>
                          <td class="tdStyle" width="30%">
	                       	<center><a href="JavaScript:showPledgeDetail('${pledgeList.contractNo}','${pledgeList.rptKey}','${pledgeList.no}','${pledgeList.contractType}')">${pledgeList.contractNo}</a>
	                     </td>
                         <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${pledgeList.contract_eff_flag}</span></font></div>
                        </td>
                          <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${pledgeList.contract_no_amount}</span></font></div>
                        </td>
                          <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${pledgeList.contract_no_currency}</span></font></div>
                        </td>
                          <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${pledgeList.guarantee_amount}</span></font></div>
                        </td>
                        </td>
                          <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${pledgeList.guarantee_currency}</span></font></div>
                        </td>
                        </td>
                          <td class="tdStyle" width="30%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${pledgeList.financial_org}</span></font></div>
                        </td>
                    </tr>
                    </tbody>
                </table>
          </td>
        </tr>
</#list>
        <tr align="center" valign="middle">
                 <td height="24" colspan="3">
                        <div align="center"><font color="#0066cc" size="2"><b><font face="黑体">本担保人保证抵押金额本外币合计：${AssureList.sumAmount}</font></b></font></div>
                  </td>
        </tr></br>
        <tr align="center" valign="middle">
                 <td height="24" colspan="3">
                        <div align="center"><font color="#0066cc" size="2"><b><font face="黑体">当前用户为：${tlrno}</font></b></font></div>
                  </td>
        </tr></br></br></br>

</#if>

<#if AssureList.contractType =="impawn" >
    <tr>
       <td height="30" valign="bottom">
          <div align="center"><font color="#0066cc"><span class="high"><b>质押合同</b></span></font></div>
       </td>
    </tr></br>
    <tr>
       <td>
                <table cellspacing="0" cellpadding="0" width="90%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tbody>
                    <tr height="30" align="center" valign="middle">
                        <td class="tdStyle" width="5%"><font color="#0066cc">序号</font>
                        </td>
                        <td class="tdStyle" width="30%"><font color="#0066cc">质押合同编号</font>
                        </td>
                        <td class="tdStyle" width="10%"><font color="#0066cc"> 质押合同有效状态</font>
                        </td>
                        <td class="tdStyle" width="10%" ><font color="#0066cc"> 质押合同金额</font>
                        </td>
                        <td class="tdStyle" width="10%" ><font color="#0066cc"> 质押合同金额计量币种</font>
                        </td>
                        <td class="tdStyle" width="10%" ><font color="#0066cc"> 本担保人保证质押金额</font>
                        </td>
                        <td class="tdStyle" width="10%" ><font color="#0066cc"> 本担保人保证质押金额计量币种</font>
                        </td>
                        <td class="tdStyle" width="30%" ><font color="#0066cc"> 业务发生金融机构名称</font>
                        </td>
                    </tr>
                      </tbody>
                </table>
<#list AssureIndGuaranteeImpawnList as impawnList>
 				<table cellspacing="0" cellpadding="0" width="90%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tbody>
                    <tr height="30">
                        <td class="tdStyle" width="5%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${impawnList.no}</span></font></div>
                        </td>
                         <td class="tdStyle" width="30%">
	                       	<center><a href="JavaScript:showImpawnDetail('${impawnList.contractNo}','${impawnList.rptKey}','${impawnList.no}','${impawnList.contractType}')">${impawnList.contractNo}</a>
	                     </td>
                         <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${impawnList.contract_eff_flag}</span></font></div>
                        </td>
                          <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${impawnList.contract_no_amount}</span></font></div>
                        </td>
                          <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${impawnList.contract_no_currency}</span></font></div>
                        </td>
                          <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${impawnList.guarantee_amount}</span></font></div>
                        </td>
                        </td>
                          <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${impawnList.guarantee_currency}</span></font></div>
                        </td>
                        </td>
                          <td class="tdStyle" width="30%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${impawnList.financial_org}</span></font></div>
                        </td>
                    </tr>
                    </tbody>
                </table>
          </td>
        </tr>
</#list>
        <tr align="center" valign="middle">
                 <td height="24" colspan="3">
                        <div align="center"><font color="#0066cc" size="2"><b><font face="黑体">本担保人保证质押金额本外币合计：${AssureList.sumAmount}</font></b></font></div>
                  </td>
        </tr></br>
        <tr align="center" valign="middle">
                 <td height="24" colspan="3">
                        <div align="center"><font color="#0066cc" size="2"><b><font face="黑体">当前用户为：${tlrno}</font></b></font></div>
                  </td>
        </tr>
</#if>
</#list>

                    	
				
                
	
</CENTER>
<div  align="center" >
				<input type="button" name="close" style="margin-top:80px;background-color:#d6e5f8"  value="关闭" onclick="goback()" />
				<input type="button" name="printhtml" value="打印" style="margin-top:80px;background-color:#d6e5f8"  onclick="printme()" />
     </div>           
			
</BODY>

</HTML>