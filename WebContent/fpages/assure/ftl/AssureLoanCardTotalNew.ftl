	<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as AssureIndCustTotalNew>

<HTML>
<HEAD>
<@AssureIndCustTotalNew.page title="自然人中征码汇总">

    <TITLE>自然人中征码汇总</TITLE>
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

</script>
</@AssureIndCustTotalNew.page>
</HEAD>
<#assign rptKey = RequestParameters["rptKey"]?default("true")>
<#assign queryTime2 = RequestParameters["queryTime2"]?default("true")>
<#assign individualId = RequestParameters["individualId"]?default("true")>
<#assign TDetailIndResultList = statics["com.huateng.ebank.business.assure.getter.AssureLoanCardTotalQueryGetter"].getTDetailIndResult(rptKey)/>		
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
                                            face="黑体">自然人中征码汇总</font></b></font></div>
                        </td>
                    </tr>
                    <tr>
                        <td class="high"  align="left"><span
                                class="style1"><b><font color="#0066cc">编号:${rptKey}
                                        </font></b></span></td>
                        <td height="40px"  align="right">
                            <span class="style1"><font
                                        color="#0066cc"><b>时间:${queryTime2}</b></font></span><font
                                    color="#0066cc"><b></b></font>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </td>
        </tr>
        </tbody>
    </table>
<#list TDetailIndResultList as tdetailIndResultList  >
    <tr>
       <td height="30" valign="bottom">
          <div align="center"><font color="#0066cc"><span class="high"><b>自然人明细查询结果列表</b></span></font></div>
       </td>
    </tr>
    <tr></br></br>
       <td>
                <table cellspacing="0" cellpadding="0" width="90%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tbody>
                    
                    
                    <tr height="30" align="center">
                    	 <td class="tdStyle" width="5%" ><font color="#0066cc"> 中文名称</font>
                        </td>
                         <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.chineseName}</span></font></div>
                        </td>
                        
                        <td class="tdStyle" width="5%" ><font color="#0066cc"> 英文名称</font>
                        </td>
                         <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.englistName}</span></font></div>
                        </td>
                    </tr>
                    
                   
                    <tr height="30" align="center">
                    	<td class="tdStyle" width="15%" ><font color="#0066cc"> 机构信用代码</font>
                        </td>
                    	<td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.orgCreditCode}</span></font></div>
                        </td>
                    	<td class="tdStyle" width="5%" ><font color="#0066cc"> 组织机构代码</font>
                        </td>
                    	<td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.orgCode}</span></font></div>
                        </td>
                    </tr>
                    
                     <tr height="30" align="center">
                     
                        <td class="tdStyle" width="20%" ><font color="#0066cc"> 中征码</font>
                        </td>
                        <td class="tdStyle" width="30%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.loancardNo}</span></font></div>
                        </td>
                     	<td class="tdStyle" width="5%"><font color="#0066cc"> 登记注册类型</font>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.registType}</span></font></div>
                        </td>
                    </tr>
                    
                    <tr height="30" align="center">
                        <td class="tdStyle" width="15%" ><font color="#0066cc"> 登记注册号</font>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.registCode}</span></font></div>
                        </td>
                         <td class="tdStyle" width="15%" ><font color="#0066cc"> 纳税人识别号（国税）</font>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.countryTaxCode}</span></font></div>
                        </td>
                          
                    </tr>
                    
                     <tr height="30" align="center">
                        <td class="tdStyle" width="15%" ><font color="#0066cc"> 纳税人识别号（地税）</font>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.regionTaxCode}</span></font></div>
                        </td>
                         <td class="tdStyle" width="15%" ><font color="#0066cc"> 住址</font>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.address}</span></font></div>
                        </td>
                          
                    </tr>
                    
                     <tr height="30" align="center">
                        <td class="tdStyle" width="15%" ><font color="#0066cc"> 通讯地址</font>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.contactAddress}</span></font></div>
                        </td>
                         <td class="tdStyle" width="15%" ><font color="#0066cc"> 联系电话</font>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.contactNo}</span></font></div>
                        </td>
                          
                    </tr>
                    
                        <tr height="30" align="center">
                        <td class="tdStyle" width="15%" ><font color="#0066cc"> 证件号</font>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.individualId}</span></font></div>
                        </td>
                         <td class="tdStyle" width="15%" ><font color="#0066cc"> 证件类型</font>
                        </td>
                        <td class="tdStyle" width="10%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${tdetailIndResultList.individualType}</span></font></div>
                        </td>
                          
                    </tr>
                    </tbody>
                </table>
          </td>
        </tr></br></br>
</#list>

                    	
				
                
	
</CENTER>
<div  align="center" >
				<input type="button" name="close" style="margin-top:80px;background-color:#d6e5f8"  value="关闭" onclick="goback()" />
				<input type="button" name="printhtml" value="打印" style="margin-top:80px;background-color:#d6e5f8"  onclick="printme()" />
     </div>           
			
</BODY>

</HTML>