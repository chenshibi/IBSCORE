<HTML>
<HEAD>
    <TITLE>抵押合同详细信息</TITLE>
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
    <script type="text/javascript" src="${contextPath}/templets/ui/js/report.js"></script>
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
		var url = "${contextPath}/printPersonalInfoAction.do";
		sfForm.action = url;
		sfForm.submit();	
}
function printme(){
window.print();
}

</script>
</HEAD>
<#assign rptKey = RequestParameters["rptKey"]?default("true")>
<#assign contractNo = RequestParameters["contractNo"]?default("true")>
<#assign no = RequestParameters["no"]?default("true")>
<#assign contractType = RequestParameters["contractType"]?default("true")>
<#assign AssureIndGuaranteeGuarantDetailList = statics["com.huateng.ebank.business.assure.getter.AssureIndCustTotalQueryGetter"].getAssureIndGuaranteeGuarantDetail(rptKey,contractNo,no,contractType)/>
<#assign AssureIndGuarantDetailList = statics["com.huateng.ebank.business.assure.getter.AssureIndCustTotalQueryGetter"].getAssureGuarantDetail(rptKey,contractNo,no,contractType)/>	
<#assign AssureIndGuarantorList = statics["com.huateng.ebank.business.assure.getter.AssureIndCustTotalQueryGetter"].getAssureIndGuarantorList(rptKey,contractNo,no,contractType)/>		
<#assign AssureIndMainInfoList = statics["com.huateng.ebank.business.assure.getter.AssureIndCustTotalQueryGetter"].getAssureIndMainInfo(rptKey,contractNo,no,contractType)/>	
<BODY leftMargin=0 topMargin=35 rightMargin=0 width = "800">
<CENTER id="centerId">
<#list AssureIndGuaranteeGuarantDetailList as guarantList  >
    <tr>
       <td height="30" valign="bottom">
          <div align="center"><font color="#0066cc"><span class="high"><b>抵押合同详细信息</b></span></font></div>
       </td>
    </tr>
    <tr></br></br>
       <td>
                <table cellspacing="0" cellpadding="0" width="90%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tbody>
                    
                    <tr height="30" align="center">
                    	<td class="tdStyle" width="20%"><font color="#0066cc">抵押合同编号</font>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.contractNo}</span></font></div>
                        </td>
                       <td class="tdStyle" width="20%"><font color="#0066cc"></font>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high"></span></font></div>
                        </td>
                    </tr>
                    
                    
                    <tr height="30" align="center">
                    	 <td class="tdStyle" width="5%" ><font color="#0066cc"> 抵押合同金额</font>
                        </td>
                         <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.contract_no_amount}</span></font></div>
                        </td>
                        
                        <td class="tdStyle" width="5%" ><font color="#0066cc"> 币种</font>
                        </td>
                         <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.contract_no_currency}</span></font></div>
                        </td>
                    </tr>
                    
                   
                    <tr height="30" align="center">
                    	<td class="tdStyle" width="15%" ><font color="#0066cc"> 本担保人保证抵押金额</font>
                        </td>
                    	<td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.guarantee_amount}</span></font></div>
                        </td>
                    	<td class="tdStyle" width="5%" ><font color="#0066cc"> 本担保人保证抵押金额计量币种</font>
                        </td>
                    	<td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.guarantee_currency}</span></font></div>
                        </td>
                    </tr>
                    
                     <tr height="30" align="center">
                     
                        <td class="tdStyle" width="20%" ><font color="#0066cc"> 业务发生金融机构名称</font>
                        </td>
                        <td class="tdStyle" width="30%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.financial_org}</span></font></div>
                        </td>
                     	<td class="tdStyle" width="5%"><font color="#0066cc"> 抵押合同有效状态</font>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.contract_eff_flag}</span></font></div>
                        </td>
                    </tr>
                    
                    <tr height="30" align="center">
                        <td class="tdStyle" width="15%" ><font color="#0066cc"> 抵押合同签订日期</font>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${guarantList.contract_sign_date}</span></font></div>
                          
                    </tr>
                    </tbody>
                </table>
          </td>
        </tr></br></br>
</#list>
<#list AssureIndGuarantDetailList as AssureIndGuarantDetailList  >
<tr>
       <td height="30" valign="bottom">
          <div align="center"><font color="#0066cc"><span class="high"><b>抵押物详细列表信息 </b></span></font></div>
       </td>
    </tr></br></br>
    <tr>
       <td>
                <table cellspacing="0" cellpadding="0" width="90%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tbody>
                    <tr height="30" align="center" valign="middle">
                        <td class="tdStyle" width="8%"><font color="#0066cc">抵押序号</font>
                        </td>
                        <td class="tdStyle" width="8%"><font color="#0066cc">抵押金额</font>
                        </td>
                        <td class="tdStyle" width="8%"><font color="#0066cc">币种</font>
                        </td>
                         <td class="tdStyle" width="9%"><font color="#0066cc">抵押物评估价值</font>
                        </td>
                         <td class="tdStyle" width="8%"><font color="#0066cc">币种</font>
                        </td>
                         <td class="tdStyle" width="9%"><font color="#0066cc">评估日期</font>
                        </td>
                         <td class="tdStyle" width="8%"><font color="#0066cc">评估机构名称</font>
                        </td>
                         <td class="tdStyle" width="9%"><font color="#0066cc">评估机构组织机构代码</font>
                        </td>
                         <td class="tdStyle" width="8%"><font color="#0066cc">抵押物种类</font>
                        </td>
                         <td class="tdStyle" width="8%"><font color="#0066cc">登记机关</font>
                        </td>
                         <td class="tdStyle" width="8%"><font color="#0066cc">登记日期</font>
                        </td>
                         <td class="tdStyle" width="10%"><font color="#0066cc">抵押物说明</font>
                        </td>
                    </tr>
                
                    <tr height="30">
                        <td class="tdStyle" width="8%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantDetailList.pledgeNo}</span></font></div>
                        </td>
                        <td class="tdStyle" width="8%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantDetailList.pledgeAmount}</span></font></div>
                        </td>
                        <td class="tdStyle" width="8%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantDetailList.pledgeCurrency}</span></font></div>
                        </td>
                        <td class="tdStyle" width="9%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantDetailList.pledgeEstAmount}</span></font></div>
                        </td>
                        <td class="tdStyle" width="8%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantDetailList.pledgeEstCurrency}</span></font></div>
                        </td>
                        <td class="tdStyle" width="9%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantDetailList.estDate}</span></font></div>
                        </td>
                        <td class="tdStyle" width="8%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantDetailList.estOrgName}</span></font></div>
                        </td>
                        <td class="tdStyle" width="9%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantDetailList.estOrgCode}</span></font></div>
                        </td>
                        <td class="tdStyle" width="8%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantDetailList.pledgeType}</span></font></div>
                        </td>
                        <td class="tdStyle" width="8%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantDetailList.registerOrg}</span></font></div>
                        </td>
                        <td class="tdStyle" width="8%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantDetailList.registerDate}</span></font></div>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantDetailList.pledgeDesc}</span></font></div>
                        </td>
                    </tr>
                    </tbody>
                </table>
          </td>
        </tr><br/><br/>
</#list>

    <tr>
       <td height="30" valign="bottom">
          <div align="center"><font color="#0066cc"><span class="high"><b>被担保人列表</b></span></font></div>
       </td>
    </tr></br></br>
    <tr>
       <td>
                <table cellspacing="0" cellpadding="0" width="90%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tbody>
                    <tr height="30" align="center" valign="middle">
                        <td class="tdStyle" width="20%"><font color="#0066cc">被担保人名称 </font>
                        </td>
                        <td class="tdStyle" width="20%"><font color="#0066cc">被担保人中征码</font>
                        </td>
                    </tr>
                  </tbody>
                </table>
<#list AssureIndGuarantorList as AssureIndGuarantorlist  >
				 <table cellspacing="0" cellpadding="0" width="90%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tr height="30">
                        <td class="tdStyle" width="20%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantorlist.guarantor_name}</span></font></div>
                        </td>
                        </td>
                        <td class="tdStyle" width="20%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndGuarantorlist.guarantor_loancard_no}</span></font></div>
                        </td>
                    </tr>
                    </tbody>
                </table>
          </td>
        </tr>
</#list>



    </br></br><tr>
       <td height="30" valign="bottom">
          <div align="center"><font color="#0066cc"><span class="high"><b>该抵押合同对应主业务汇总信息</b></span></font></div>
       </td>
    </tr>
    <tr></br></br>
       <td>
                <table cellspacing="0" cellpadding="0" width="90%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tbody>
                    <tr height="30" align="center" valign="middle">
                        <td class="tdStyle" width="20%"><font color="#0066cc">业务类型 </font>
                        </td>
                        <td class="tdStyle" width="20%"><font color="#0066cc">业务发生额</font>
                        </td>
                        <td class="tdStyle" width="20%"><font color="#0066cc">业务余额</font>
                        </td>
                    </tr>
                 </tbody>
                </table>
<#list AssureIndMainInfoList as AssureIndMainInfolist  >
				<table cellspacing="0" cellpadding="0" width="90%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tbody>
                    <tr height="30">
                          <td class="tdStyle" width="20%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndMainInfolist.biz_type}</span></font></div>
                        </td>
                        </td>
                          <td class="tdStyle" width="20%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndMainInfolist.biz_amount}</span></font></div>
                        </td>
                         <td class="tdStyle" width="20%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${AssureIndMainInfolist.biz_balance}</span></font></div>
                        </td>
                    </tr>
                    </tbody>
                </table>
          </td>
        </tr>
</#list>
</CENTER>
<div  align="center" >
				<input type="button" name="close" style="margin-top:80px;background-color:#d6e5f8"  value="关闭" onclick="goback()" />
				
				<input type="button" name="printhtml" value="打印" style="margin-top:80px;background-color:#d6e5f8"  onclick="printme()" />
     </div>           
			
</BODY>

</HTML>