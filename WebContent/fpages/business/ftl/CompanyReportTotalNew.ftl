<HTML>
<HEAD>
    <TITLE>IBS企业一般信息汇总</TITLE>
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
function showDkDbZqInfo(rptKey){
	var  url='TcorpOrginalDetailWindowsClearDk.ftl?rptKey='+rptKey;
	// window.open("TcorpOrginalDetailWindowsClearDk.ftl?rptKey='"+RptKey+"'","波波","width=1000,height=800"); 
	 window.showModalDialog(url,window,'dialogWidth:1000px;dialogHeight:800px;status:no;help:no;scroll:no;');
	
}
</script>
</HEAD>
<!--编号-->
<#assign rptKey = RequestParameters["rptKey"]?default("true")>

<!--时间-->
<#assign tcdareturnTime = RequestParameters["tcdareturnTime"]?default("true")>

<#assign rptList = statics["com.huateng.ebank.business.customer.getter.CompanyReportTotalQueryGetter"].getTcorpInfoBasicByrptKey(rptKey)/>					   
<#assign tlrno= statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstanceWithoutException().getTlrno()>



<BODY leftMargin=0 topMargin=35 rightMargin=0 width = "800">
<CENTER id="centerId">
  <#list rptList as reportList >
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
                                            face="黑体">企业一般信息汇总</font></b></font></div>
                        </td>
                    </tr>
                    

                    <tr>
                        <td class="high"  align="left"><span
                                class="style1"><b><font color="#0066cc">编号:${reportList.name}
                                        </font></b></span></td>
                        
                        <td height="40px"  align="right">
                            <span class="style1"><font
                                        color="#0066cc"><b>时间:${reportList.regEndDate}</b></font></span><font
                                    color="#0066cc"><b></b></font>
                        </td>
                    </tr>


                    </tbody>
                </table>
            </td>
        </tr>
        </tbody>
    </table>
     <table width="100%" align="center" cellspacing="0" cellpadding="0"
            border="0">
        <tbody>
        	<tr>
            	<td>
            	   <div align="center">
	                <table cellspacing="0" cellpadding="0" width="80%" 
	                       align="center" border="0">
	                    <tbody>
	                    <tr height="30" align="center" valign="middle">
	                    	  <td width="30%" class="tdStyle"><font color="#0066cc">操作</font>
	                        </td>
	                        <td width="30%" class="tdStyle"><font color="#0066cc">名称</font>
	                        </td>
	                        <td width="30%" class="tdStyle"><font color="#0066cc">注册地址</font>
	                        </td>
	                        <td width="30%" class="tdStyle"><font color="#0066cc">组织机构代码</font>
	                        </td>
	                         <td width="30%" class="tdStyle"><font color="#0066cc">登记注册类型</font>
	                        </td>
	                         <td width="30%" class="tdStyle"><font color="#0066cc">登记注册号</font>
	                        </td>
	                          <td width="30%" class="tdStyle"><font color="#0066cc">登记注册日期</font>
	                        </td>
	                          <td width="30%" class="tdStyle"><font color="#0066cc">有效截止日期</font>
	                        </td>
	                           <td width="30%" class="tdStyle"><font color="#0066cc">国税登记号 </font>
	                        </td>
	                            <td width="30%" class="tdStyle"><font color="#0066cc">地税登记号 </font>
	                        </td>
	                           <td width="30%" class="tdStyle"><font color="#0066cc">中征码 </font>
	                        </td>
	                    </tr>
	                    <tr height="30">
	                    	 <td class="tdStyle" width="30%">
	                       					<center><a href="JavaScript:showDkDbZqInfo(${reportList.rptKey})">详细</a>
	                        </td>
	                        
	                        <td class="tdStyle" width="30%">
	                            <div class="high" align="center"><font color="#0066cc"><span
	                                        class="high">${reportList.name}</span></font></div>
	                        </td>
	                        <td class="tdStyle" width="30%">
	                            <div class="high" align="center"><font color="#0066cc"><span
	                                        class="high">${reportList.address}</span></font></div>
	                        </td>
	                        <td class="tdStyle" width="30%">
	                            <div class="high" align="center"><font color="#0066cc"><font
	                                        color="#0066cc">${reportList.regOrganCode}</font></font></div>
	                        </td>
	                          <td class="tdStyle" width="30%">
	                            <div class="high" align="center"><font color="#0066cc"><span
	                                        class="high">${reportList.regOrganType}</span></font></div>
	                        </td>
	                        <td class="tdStyle" width="30%">
	                            <div class="high" align="center"><font color="#0066cc"><span
	                                        class="high">${reportList.regOrganNo}</span></font></div>
	                        </td>
	                        <td class="tdStyle" width="30%">
	                            <div class="high" align="center"><font color="#0066cc"><font
	                                        color="#0066cc">${reportList.regDate}</font></font></div>
	                        </td>
	                          <td class="tdStyle" width="30%">
	                            <div class="high" align="center"><font color="#0066cc"><span
	                                        class="high">${reportList.regEndDate}</span></font></div>
	                        </td>
	                        <td class="tdStyle" width="30%">
	                            <div class="high" align="center"><font color="#0066cc"><span
	                                        class="high">${reportList.regStateTaxNo}</span></font></div>
	                        </td>
	                        <td class="tdStyle" width="30%">
	                            <div class="high" align="center"><font color="#0066cc"><font
	                                        color="#0066cc">${reportList.regLocalTaxNo}</font></font></div>
	                        </td>
	                        <td class="tdStyle" width="30%">
	                            <div class="high" align="center"><font color="#0066cc"><font
	                                        color="#0066cc">${reportList.loancardId}</font></font></div>
	                        </td>
	                    </tr>
	                    </tbody>
	                </table>
         		</div>
            </td>
</#list>
        </tr>
        	<tr align="center" valign="middle">
                <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                             face="黑体">当前用户为：${tlrno}</font></b></font></div>
                </td>
        </tr>
</CENTER>
<div  align="center" >
				<input type="button" name="close" style="margin-top:80px;background-color:#d6e5f8"  value="关闭" onclick="goback()" />
				<input type="button" name="printhtml" value="打印" style="margin-top:80px;background-color:#d6e5f8"  onclick="printme()" />
</div>       

			
</BODY>
</HTML>