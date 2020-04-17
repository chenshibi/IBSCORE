<HTML>
<HEAD>
    <TITLE>IBS个人信息汇总</TITLE>
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
<#assign rptId = RequestParameters["rptId"]?default("true")>
<#assign rptList = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndInfoByRptId(rptId)/>					   
<#assign IndAddrByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndAddrByRptId(rptId)/>
<#assign IndJobByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndJobByRptId(rptId)/>
<#assign IndPromptRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndPromptRptId(rptId)/>


<#assign IndDisposalByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndDisposalByRptId(rptId)/>
<#assign IndEnsureByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndEnsureByRptId(rptId)/>


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
                                            face="黑体">个人信息汇总</font></b></font></div>
                        </td>
                    </tr>
                    

                    <tr>
                        <td class="high"  align="left"><span
                                class="style1"><b><font color="#0066cc">编号:${reportList.Rpt_id}
                                        </font></b></span></td>
                        
                        <td height="40px"  align="right">
                            <span class="style1"><font
                                        color="#0066cc"><b>时间:${reportList.Report_date}</b></font></span><font
                                    color="#0066cc"><b></b></font>
                        </td>
                    </tr>


                    </tbody>
                </table>
            </td>
        </tr>
        </tbody>
    </table>

     <table width="75%" align="center" cellspacing="0" cellpadding="0"
            border="0">
        <tbody>
        	<tr>
            	<td>
            	   <div align="center">
            	
	                <table cellspacing="0" cellpadding="0" width="60%" 
	                       align="center" border="0">
	
	                    <tbody>
	                    <tr height="30" align="center" valign="middle">
	                        <td width="30%" class="tdStyle"><font color="#0066cc">姓名</font>
	                        </td>
	                        <td width="30%" class="tdStyle"><font color="#0066cc">证件类型</font>
	                        </td>
	                        <td width="30%" class="tdStyle"><font color="#0066cc">证件号码</font>
	                        </td>
	                    </tr>
	
	
	                    <tr height="30">
	                        <td class="tdStyle" width="30%">
	                            <div class="high" align="center"><font color="#0066cc"><span
	                                        class="high">${reportList.name_queried}</span></font></div>
	                        </td>
	                        <td class="tdStyle" width="30%">
	                            <div class="high" align="center"><font color="#0066cc"><span
	                                        class="high">${reportList.id_type_queried}</span></font></div>
	                        </td>
	                        <td class="tdStyle" width="30%">
	                            <div class="high" align="center"><font color="#0066cc"><font
	                                        color="#0066cc">${reportList.id_no_queried}</font></font></div>
	                        </td>
	                    </tr>
	                    </tbody>
	                </table>
         		</div>
            </td>
        </tr>
        			<tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
        
<#if reportList.flagCheck =="f" >
<#else>	
        <tr>
            <td height="30" valign="bottom">
                <div align="center"><font color="#0066cc"><span class="high"><b>公安部居民身份证核查信息</b></span></font></div>
            </td>
        </tr>
        <tr>
            <td>
                <table cellspacing="0" cellpadding="0" width="60%" border="0"
                       align="center"
                       style="border-collapse: collapse; border: none; border-color: black">
                    <tbody>
                    <tr height="30" align="center" valign="middle">
                        <td width="20%" class="tdStyle"><font color="#0066cc">核查结果</font>
                        </td>
                        <td class="tdStyle" width="20%"><font color="#0066cc">签发机关</font>
                        </td>
                        <td class="tdStyle" width="20%" rowspan="2"><font color="#0066cc"> 照片</font></td>
                    </tr>
                    <tr height="30">
                        <td class="tdStyle" width="20%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${reportList.verify_result}</span></font></div>
                        </td>
                        <td class="tdStyle" width="20%">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${reportList.issue_org}</span></font></div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </td>
        </tr>
        <tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
	</#if>	

        
        
		<#if reportList.flagIdentity == "f">
		<#else>
           <tr>
                <td height="30" valign="bottom">
                    <div align="center"><font color="#0066cc"><span class="high"><b>身份信息</b></span></font></div>
                </td>
            </tr>
            <tr>
                <td>
                    <table cellspacing="0" cellpadding="2" width="90%" align="center"
                           border="0" class="tableStyle">
                        <tbody>
                        <tr>
                            <td class="tdStyle">
                                <div align="center"><b><font color="#0066cc"><span class="high">性别</span></font></b>
                                </div>
                            </td>
                            <td class="tdStyle">
                                <div align="center"><b><font color="#0066cc"><span class="high">出生日期</span></font></b>
                                </div>
                            </td>
                            <td class="tdStyle">
                                <div align="center"><b><font color="#0066cc"><span class="high">婚姻状况</span></font></b>
                                </div>
                            </td>
                            <td class="tdStyle">
                                <div align="center"><b><font color="#0066cc"><span class="high">手机号码</span></font></b>
                                </div>
                            </td>
                            <td class="tdStyle">
                                <div align="center"><b><font color="#0066cc"><span class="high">单位电话</span></font></b>
                                </div>
                            </td>
                            <td class="tdStyle">
                                <div align="center"><b><font color="#0066cc"><span class="high">住宅电话</span></font></b>
                                </div>
                            </td>
                            <td class="tdStyle">
                                <div align="center"><b><font color="#0066cc"><span class="high">学历</span></font></b>
                                </div>
                            </td>
                            <td class="tdStyle">
                                <div align="center"><b><font color="#0066cc"><span class="high">学位</span></font></b>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="word-break: break-all" class="tdStyle">
                                <div align="center"><font color="#0066cc"><span
                                            class="high">${reportList.Gender}
                                            </span></font></div>
                            </td>
                            <td class="tdStyle" style="word-break: break-all">
                                <div align="center"><font color="#0066cc"><font 
                                            color="#0066cc">${reportList.Birthday}</font></font>
                                </div>
                            </td>
                            <td class="tdStyle" style="word-break: break-all">
                                <div align="center"><font color="#0066cc"><font 
                                            color="#0066cc">${reportList.Marriage}</font></font>
                                </div>
                            </td>
                            <td class="tdStyle" style="word-break: break-all">
                                <div align="center"><font color="#0066cc"><span class="high">${reportList.Mobile}
                                            </span></font></div>
                            </td>
                            <td class="tdStyle" style="word-break: break-all">
                                <div align="center"><font color="#0066cc"><span class="high">${reportList.Phone_com}
                                            </span></font>
                                </div>
                            </td>
                            <td class="tdStyle" style="word-break: break-all">
                                <div align="center"><font color="#0066cc"><span class="high">${reportList.Phone_liv}
                                            </span></font>
                                </div>
                            </td>
                            <td class="tdStyle" style="word-break: break-all">
                                <div align="center"><font color="#0066cc"><span class="high">${reportList.Education}
                                            </span></font>
                                </div>
                            </td>
                            <td class="tdStyle" style="word-break: break-all">
                                <div align="center"><font color="#0066cc"><span class="high">${reportList.Degree}
                                            </span></font></div>
                            </td>
                        </tr>
                        <tr>
                            <td class="tdStyle" colspan="3">
                                <div align="center"><b><font color="#0066cc"><span class="high">通讯地址</span></font></b>
                                </div>
                            </td>
                            <td class="tdStyle" colspan="5">
                                <div align="center"><b><font color="#0066cc"><span class="high">户籍地址</span></font></b>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td class="tdStyle" style="word-break: break-all" colspan="3">
                                <div align="center"><font color="#0066cc"><span class="high">${reportList.Addr}
                                            </span></font></div>
                            </td>
                            <td class="tdStyle" style="word-break: break-all" colspan="5">
                                <div align="center"><font color="#0066cc"><span class="high">${reportList.Hukou_addr}
                                            </span></font>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </td>
          </tr>
          <tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
</#if>
<#if  reportList.flagSpouse == "f">      
<#else>
<tr height="30" valign="bottom">
    <td>
        <div align="center"><font color="#0066cc"><span class="high"><b>配偶信息</b></span></font></div>
    </td>
</tr>
<tr>
    <td>
        <table cellspacing="0" cellpadding="2" width="90%" align="center"
               class="tableStyle">
            <tbody>
            <tr>
                <td class="tdStyle" colspan="2">
                    <div align="center"><b><font color="#0066cc"><span class="high">姓名</span></font></b>
                    </div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div align="center"><b><font color="#0066cc"><span class="high">证件类型</span></font></b>
                    </div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div align="center"><b><font color="#0066cc"><span class="high">证件号码</span></font></b>
                    </div>
                </td>
                <td class="tdStyle" colspan="3">
                    <div align="center"><b><font color="#0066cc"><span class="high">工作单位</span></font></b>
                    </div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div align="center"><b><font color="#0066cc"><span class="high">联系电话</span></font></b>
                    </div>
                </td>
            </tr>
            <tr>
                <td class="tdStyle" style="word-break: break-all" colspan="2">
                    <div align="center"><font color="#0066cc"><span class="high">${reportList.spouse}
                                </span></font></div>
                </td>
                <td class="tdStyle" style="word-break: break-all" colspan="1">
                    <div align="center"><font color="#0066cc"><span 
                                class="high">${reportList.Spouse_id_type}
                                </span></font></div>
                </td>
                <td class="tdStyle" style="word-break: break-all" colspan="1">
                    <div align="center"><font color="#0066cc"><span 
                                class="high">${reportList.Spouse_id_number}
                                </span></font></div>
                </td>
                <td class="tdStyle" style="word-break: break-all" colspan="3"> 
                    <div align="center"><font color="#0066cc"><span class="high">${reportList.Spouse_com}
                                </span></font>
                    </div>
                </td>
                <td class="tdStyle" style="word-break: break-all" colspan="1">
                    <div align="center"><font color="#0066cc"><span 
                                class="high">${reportList.Spouse_phone}
                                </span></font>
                    </div>
                </td>
            </tr>
            </tbody>
        </table>
    </td>
</tr>
<tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
</#if>		
</#list>	
		
<tr height="30" valign="bottom">
    <td>
        <div class="high" align="center"><font color="#0066cc"><span
                    class="high"><b>居住信息</b></span></font></div>
    </td>
</tr>
<tr>
    <td>
        <div align="center">
            <table cellspacing="0" cellpadding="2" width="90%" align="center"
                   border="0" class="tableStyle">
                <tbody>
                <tr>
                    <td width="6%" height="16" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">编号</span></font></b></div>
                    </td>
                    <td width="59%" height="16" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">居住地址</span></font></b></div>
                    </td>
                    <td width="15%" height="16" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">居住状况</span></font></b></div>
                    </td>
                    <td width="20%" height="16" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">信息更新日期</span></font></b></div>
                    </td>
                </tr>
<#list IndAddrByRptId as IndAddrByRptIdList >              
                    <tr>
                        <td width="6%" style="word-break: break-all" class="tdStyle">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndAddrByRptIdList.no}</span></font></div>
                        </td>
                        <td width="59%" style="word-break: break-all" class="tdStyle">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${IndAddrByRptIdList.Address}</span></font></div>
                        </td>
                        <td width="15%" style="word-break: break-all" class="tdStyle">
                            <div class="high" align="center"><font color="#0066cc"><span 
                                        class="high">${IndAddrByRptIdList.status}</span></font></div>
                        </td>
                        <td width="20%" style="word-break: break-all" class="tdStyle"> 
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndAddrByRptIdList.get_date}
                                        </span></font></div>
                        </td>
                    </tr>
</#list>                
                </tbody>
            </table>
        </div>
    </td>
</tr>
<tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
                    
<tr height="30" valign="bottom">
<td>
    <div align="center"><font color="#0066cc"><span><b>职业信息</b> </span> </font>
    </div>
</td>
</tr>
<tr>
<td>
    <div align="center">
        <table cellspacing="0" cellpadding="2" width="90%" align="center"
               border="0" class="tableStyle">
            <tbody>
            <tr>
                <td width="6%" class="tdStyle">
                    <div align="center"><b><font color="#0066cc"><span>编号</span> </font> </b></div>
                </td>
                <td colspan="4" class="tdStyle">
                    <div align="center"><b><font color="#0066cc"><span>工作单位</span> </font> </b></div>
                </td>
                <td colspan="2" class="tdStyle">
                    <div align="center"><b><font color="#0066cc"><span>单位地址</span> </font> </b></div>
                </td>
            </tr>  
<#list IndJobByRptId as IndJobByRptIdList>   							
                <tr>
                    <td width="6%" style="word-break: break-all" class="tdStyle">
                        <div align="center"><font color="#0066cc"><span>${IndJobByRptIdList.No}
                                    </span> </font></div>
                    </td>
                    <td colspan="4" style="word-break: break-all" class="tdStyle">
                        <div align="center"><font color="#0066cc"><span>${IndJobByRptIdList.name}
                                    </span> </font></div>
                    </td>
                    <td colspan="2" style="word-break: break-all" class="tdStyle">
                        <div align="center"><font color="#0066cc"><span>${IndJobByRptIdList.addr}
                                    </span> </font></div>
                    </td>
                </tr>
</#list>                         
            <tr>
                <td width="6%" class="tdStyle">
                    <div align="center"><b><font color="#0066cc"><span>编号</span> </font> </b></div>
                </td>
                <td width="16%" class="tdStyle">
                    <div align="center"><b><font color="#0066cc"><span>职业</span> </font> </b></div>
                </td>
                <td width="16%" class="tdStyle">
                    <div align="center"><b><font color="#0066cc"><span>行业</span> </font> </b></div>
                </td>
                <td width="16%" class="tdStyle">
                    <div align="center"><b><font color="#0066cc"><span>职务</span> </font> </b></div>
                </td>
                <td width="16%" class="tdStyle">
                    <div align="center"><b><font color="#0066cc"><span>职称</span> </font> </b></div>
                </td>
                <td width="16%" class="tdStyle">
                    <div align="center"><b><font color="#0066cc"><span>进入本单位年份</span> </font> </b></div>
                </td>
                <td width="14%" class="tdStyle">
                    <div align="center"><b><font color="#0066cc"><span>信息更新日期</span> </font> </b></div>
                </td>
            </tr> 
<#list IndJobByRptId as IndJobByRptIdLists>  							
                <tr>
                    <td width="6%" style="word-break: break-all" class="tdStyle">
                        <div align="center"><font color="#0066cc"><span>${IndJobByRptIdLists.No}</span>
                            </font></div>
                    </td>
                    <td width="16%" style="word-break: break-all" class="tdStyle">
                        <div align="center"><font color="#0066cc"><span>${IndJobByRptIdLists.Profession}
                                    </span> </font></div>
                    </td>
                    <td width="16%" style="word-break: break-all" class="tdStyle">
                        <div align="center"><font color="#0066cc"><span>${IndJobByRptIdLists.Industry}
                                    </span> </font></div>
                    </td>
                    <td width="16%" style="word-break: break-all" class="tdStyle">
                        <div align="center"><font color="#0066cc"><span>${IndJobByRptIdLists.Title}
                                    </span> </font></div>
                    </td>
                    <td width="16%" style="word-break: break-all" class="tdStyle">
                        <div align="center"><font color="#0066cc"><span>${IndJobByRptIdLists.Title_tec}
                                    </span> </font></div>
                    </td>
                    <td width="16%" style="word-break: break-all" class="tdStyle">
                        <div align="center"><font
                                color="#0066cc"><span>${IndJobByRptIdLists.Startdate}</span>
                            </font>
                        </div>
                    </td>
                    <td width="14%" style="word-break: break-all" class="tdStyle">
                        <div align="center"><font 
                                color="#0066cc"><span>${IndJobByRptIdLists.getdate}</span>
                            </font>
                        </div>
                    </td>
                </tr>
</#list>                           
            </tbody>
        </table>
    </div>
</td>
</tr>  
<tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>

  
<tr style="line-height: 15px">
<td><div style="height: 20px"></div></td>
</tr>
<tr height="40">
<td align="center" valign="middle"><font color="#0066cc"
                                         style="font-size: 14px"><b>信息概要</b></font></td>
</tr>	
<tr height="30" valign="bottom">
    <td align="center" valign="middle"><font color="#0066cc"
                                             style="font-size: 12px"><b>（一） 信用提示</b></font></td>
</tr>
<tr>
    <td>
        <div align="center">
            <table cellspacing="0" cellpadding="2" width="90%" align="center"
                   class="tableStyle">
                <tbody>
				
                <tr>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">个人住房<br/>贷款笔数</span></font></b></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">个人商用房<br/>（包括商住两用）<br/>贷款笔数</span></font></b></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">其他贷<br>
			款笔数</span></font></b></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">首笔贷款<br>
			发放月份</span></font></b></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">贷记卡<br>
			账户数</span></font></b></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">首张贷记卡<br>
			发卡月份</span></font></b></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">准贷记卡<br>
			账户数</span></font></b></div>
                        <font color="#0066cc"> </font></td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">首张准贷记<br>
			卡发卡月份</span></font></b></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">本人声明<br>
			数目</span></font></b></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">异议标注<br>
			数目</span></font></b></div>
                    </td>
                </tr>
				
<#list IndPromptRptId as IndPromptRptIdList>						
                <tr>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><font 
                                color="#0066cc"><strong>${IndPromptRptIdList.person_house_loan}
                                    </strong></font></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><font 
                                color="#0066cc"><strong>${IndPromptRptIdList.person_biz_house_loan}
                                    </strong></font></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><font 
                                color="#0066cc">${IndPromptRptIdList.other_loan}</font>
                        </div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><font  
                                color="#0066cc">${IndPromptRptIdList.first_loan_issue_date}
                                </font></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><font 
                                color="#0066cc">${IndPromptRptIdList.crd_account}</font>
                        </div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><font 
                                color="#0066cc">${IndPromptRptIdList.first_cc_issue_date}
                                </font></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><font 
                                color="#0066cc">${IndPromptRptIdList.pdc_account}</font>
                        </div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><font 
                                color="#0066cc">${IndPromptRptIdList.first_pdc_issue_date}
                                </font></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><font 
                                color="#0066cc">${IndPromptRptIdList.self_statement_count}
                                </font></div>
                    </td>
                    <td width="10%" class="tdStyle">
                        <div class="high" align="center"><font 
                                color="#0066cc">${IndPromptRptIdList.dissent_count}
                                </font></div>
                    </td>
                   </tr>

                   </#list>
				</tbody>
			</table>
		</div>
	</td>
</tr>
<tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
<#assign indPbocScoreRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getindPbocScoreRptId(rptId)/>
                    
<#if (indPbocScoreRptId?size>0) >
<tr height="30" valign="bottom">
<td align="center"><span class="high"><font color="#0066cc"><b>中征信“信用1000”评分</b></font></span></td>
</tr>
<tr>
<td>
    <div align="center">
        <table cellspacing="0" cellpadding="2" width="220" align="center"
               class="tableStyle">
            <tbody>
            <tr>
                <td width="10%" class="tdStyle">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">中征信评分</span></font></b></div>
                </td>
                <td width="10%" class="tdStyle">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">相对位置</span></font></b></div>
                </td>
				<td width="30%" class="tdStyle">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">说明</span></font></b></div>
                </td>
            </tr>
            <#list indPbocScoreRptId as indPbocScoreRptIdList >							
            
            <tr>
                <td width="10%" class="tdStyle">
                    <div class="high" align="center"><font 
                            color="#0066cc">${indPbocScoreRptIdList.pboc_score}</font></div>
                </td>
                <td width="10%" class="tdStyle">
                    <div class="high" align="center"><font 
                            color="#0066cc">${indPbocScoreRptIdList.score_percentile}
                            </font></div>
                </td>
				<td width="30%" class="tdStyle">
                    <div class="high" align="center"><font 
                            color="#0066cc">${indPbocScoreRptIdList.score_description}
                            </font></div>
                </td>
            </tr>
                </#list>							
            
            </tbody>
        </table>
    </div>
    
</td>
</tr>
<tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
</#if>

<#assign IndBreachRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndBreachRptId(rptId)/>
<#assign IndOverdueRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndOverdueRptId(rptId)/>

<#if (IndBreachRptId?size>0) || (IndOverdueRptId?size>0)>
<tr style="line-height: 15px">
<td><div style="height: 20px"></div></td>
</tr>
<tr height="10" valign="bottom">
<td align="center" valign="middle"><font color="#0066cc"
                                         style="font-size: 12px"><b>逾期及违约信息概要</b></font></td>
</tr>
<tr style="line-height: 10px">
<td><div style="height: 20px"></div></td>
</tr>
<#if (IndBreachRptId?size>0)>
<tr>
    <td>
        <div align="center">
            <table cellspacing="0" cellpadding="2" width="75%" align="center"
                   border="0" class="tableStyle">
                <tbody>
                <tr>
                    <td class="tdStyle" colspan="2">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">呆账信息汇总</span></font></b></div>
                    </td>
                    <td class="tdStyle" colspan="2">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">资产处置信息汇总</span></font></b></div>
                    </td>
                    <td class="tdStyle" colspan="2">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">保证人代偿信息汇总</span></font></b></div>
                    </td>
                </tr>
                <tr>
                    <td class="tdStyle" colspan="1">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">笔数</span></font></b></div>
                    </td>
                    <td class="tdStyle" colspan="1">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">余额</span></font></b></div>
                    </td>
                    <td class="tdStyle" colspan="1">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">笔数</span></font></b></div>
                    </td>
                    <td class="tdStyle" colspan="1">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">余额</span></font></b></div>
                    </td>
                    <td class="tdStyle" colspan="1">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">笔数</span></font></b></div>
                    </td>
                    <td class="tdStyle" colspan="1">
                        <div class="high" align="center"><b><font color="#0066cc"><span
                                        class="high">余额</span></font></b></div>
                    </td>
                </tr>
<#list IndBreachRptId as IndBreachRptIdList>
                <tr>

                    <td class="tdStyle" colspan="1">
                        <div class="high" align="center"><font color="#0066cc"><span 
                                    class="high">${IndBreachRptIdList.bad_debt_count}
                                    </span></font></div>
                    </td>
                    <td class="tdStyle" colspan="1">
                        <div class="high" align="center"><font color="#0066cc"><span 
                                    class="high">${IndBreachRptIdList.bad_debt_amount}
                                    </span></font></div>
                    </td>
                    <td class="tdStyle" colspan="1">
                        <div class="high" align="center"><font color="#0066cc"><span
                                    class="high">${IndBreachRptIdList.disposal_count}
                                    </span></font></div>
                    </td>
                    <td class="tdStyle" colspan="1">
                        <div class="high" align="center"><font color="#0066cc"><span 
                                    class="high"> ${IndBreachRptIdList.disposal_amount}
                                    </span></font></div>
                    </td>
                    <td class="tdStyle" colspan="1">
                        <div class="high" align="center"><font color="#0066cc"><span
                                    class="high">${IndBreachRptIdList.ensure_pay_count}
                                    </span></font></div>
                    </td>
                    <td class="tdStyle" colspan="1">
                        <div class="high" align="center"><font color="#0066cc"><span 
                                    class="high">${IndBreachRptIdList.ensure_pay_amount}
                                    </span></font></div>
                    </td>
                </tr>
</#list>								
                </tbody>
            </table>
        </div>
    </td>
</tr> 
<tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
</#if>

<#if (IndOverdueRptId?size>0) >
<tr height="30" valign="bottom">
<td align="center"><span class="high"><font color="#0066cc"><b>逾期（透支）信息汇总</b></font></span></td>
</tr>
<tr>
<td>
    <div align="center">
        <table cellspacing="0" cellpadding="2" width="75%" align="center"
               border="0" class="tableStyle">
            <tbody>
            <tr>
                <td class="tdStyle" colspan="4">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">贷款逾期</span></font></b></div>
                </td>
                <td class="tdStyle" colspan="4">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">贷记卡逾期</span></font></b></div>
                </td>
                <td class="tdStyle" colspan="4">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">准贷记卡60天以上透支</span></font></b></div>
                </td>
            </tr>
            <tr>
                <td class="tdStyle" colspan="1">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">笔<br>
	数</span></font></b></div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">月份<br>
	数</span></font></b></div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">单月最高<br>
	逾期总额</span></font></b></div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">最长逾<br>
	期月数</span></font></b></div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">账户<br>
	数</span></font></b></div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">月份<br>
	数</span></font></b></div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">单月最高<br>
	逾期总额</span></font></b></div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">最长逾<br>
	期月数</span></font></b></div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">账户<br>
	数</span></font></b></div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">月份<br>
	数</span></font></b></div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">单月最高<br>
	透支余额</span></font></b></div>
                </td>
                <td class="tdStyle" colspan="1">
                    <div class="high" align="center"><b><font color="#0066cc"><span
                                    class="high">最长透<br>
	支月数</span></font></b></div>
                </td>
            </tr>
<#list IndOverdueRptId as IndOverdueRptIdList>
		<tr>
		<td class="tdStyle" colspan="1">
		    <div class="high" align="center"><font color="#0066cc"><span   
		                class="high">${IndOverdueRptIdList.loan_count}</span></font>
		    </div>
		</td>
		<td class="tdStyle" colspan="1">
		    <div class="high" align="center"><font color="#0066cc"><span  
		                class="high">${IndOverdueRptIdList.loan_month_count}
		                </span></font></div>
		</td>
		<td class="tdStyle" colspan="1">
		    <div class="high" align="center"><font color="#0066cc"><span  
		                class="high">${IndOverdueRptIdList.loan_max_amount}
		                </span></font></div>
		</td>
		<td class="tdStyle" colspan="1">
		    <div class="high" align="center"><font color="#0066cc"><span 
		                class="high">${IndOverdueRptIdList.loan_max_month}
		                </span></font></div>
		</td>
		
		
		<td class="tdStyle" colspan="1">
		    <div class="high" align="center"><font color="#0066cc"><span  
		                class="high">${IndOverdueRptIdList.cc_count}</span></font>
		    </div>
		</td>
		<td class="tdStyle" colspan="1">
		    <div class="high" align="center"><font color="#0066cc"><span  
		                class="high">${IndOverdueRptIdList.cc_month_count}
		                </span></font></div>
		</td>
		<td class="tdStyle" colspan="1">
		    <div class="high" align="center"><font color="#0066cc"><span  
		                class="high">${IndOverdueRptIdList.cc_max_amount}
		                </span></font></div>
		</td>
		<td class="tdStyle" colspan="1">
		    <div class="high" align="center"><font color="#0066cc"><span 
		                class="high">${IndOverdueRptIdList.cc_max_month}
		                </span></font></div>
		</td>
		<td class="tdStyle" colspan="1">
		    <div class="high" align="center"><font color="#0066cc"><span 
		                class="high">${IndOverdueRptIdList.pdc_count}</span></font>
		    </div>
		</td>
		<td class="tdStyle" colspan="1">
		    <div class="high" align="center"><font color="#0066cc"><span 
		                class="high">${IndOverdueRptIdList.pdc_month_count}
		                </span></font></div>
		</td>
		<td class="tdStyle" colspan="1">
		    <div class="high" align="center"><font color="#0066cc"><span 
		                class="high">${IndOverdueRptIdList.pcd_max_amount} 
		                </span></font></div>
		</td>
		<td class="tdStyle" colspan="1">
		    <div class="high" align="center"><font color="#0066cc"><span 
		                class="high">${IndOverdueRptIdList.pdc_max_month}
		                </span></font></div>
		</td>
		</tr>							
</#list>								
</tbody>
</table>
</div>
</td>
</tr>
<tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
</#if>
</#if>   
<#assign IndNoCloseLoanByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndNoCloseLoanByRptId(rptId)/>
<#assign IndNoCloseCcByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndNoCloseCcByRptId(rptId)/>
<#assign IndNoClosePdcByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndNoClosePdcByRptId(rptId)/>
<#assign IndAssuranceByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndAssuranceByRptId(rptId)/>
<#if (IndNoCloseLoanByRptId?size>0) || (IndNoCloseCcByRptId?size>0)||(IndNoClosePdcByRptId?size>0) ||(IndAssuranceByRptId?size>0)>


<tr style="line-height: 15px">
    <td><div style="height: 20px"></div></td>
</tr>
<tr height="10" valign="bottom">
    <td align="center" valign="middle"><font color="#0066cc"
                                             style="font-size: 12px"><b>授信及负债信息概要</b></font></td>
</tr>
<#if (IndNoCloseLoanByRptId?size>0) >
    <tr height="20" valign="bottom">
        <td align="center"><span class="high"><font color="#0066cc"><b>未结清贷款信息汇总</b></font></span></td>
    </tr>
    <tr>
        <td>
        	<div align="center">
            <table cellspacing="0" cellpadding="2" width="75%" align="center"
                   border="0" class="tableStyle">
                <tbody>
                <tr>
                    <td class="tdStyle" width="25%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">贷款法人机构数</font></b></div>
                    </td>
                    <td class="tdStyle" width="15%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">贷款机构数</font></b></div>
                    </td>
                    <td class="tdStyle" width="10%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">笔数</font></b></div>
                    </td>
                    <td class="tdStyle" width="15%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">合同总额</font></b></div>
                    </td>
                    <td class="tdStyle" width="10%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">余额</font></b></div>
                    </td>
                    <td class="tdStyle" width="25%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">最近6个月平均应还款</font></b>
                        </div>
                    </td>
                </tr>
<#list IndNoCloseLoanByRptId as IndNoCloseLoanByRptIdList>						
                <tr>
                    <td class="tdStyle" width="25%">
                        <div class="high" align="center"><font 
                                color="#0066cc">${IndNoCloseLoanByRptIdList.law_org_count}
                                </font></div>
                    </td>
                    <td class="tdStyle" width="15%">
                        <div class="high" align="center"><font 
                                color="#0066cc">${IndNoCloseLoanByRptIdList.org_count}
                                </font></div>
                    </td>
                    <td class="tdStyle" width="10%">
                        <div class="high" align="center"><font
                                color="#0066cc">${IndNoCloseLoanByRptIdList.count}
                        </div>
                    </td>
                    <td class="tdStyle" width="15%">
                        <div class="high" align="center"><font
                                color="#0066cc">${IndNoCloseLoanByRptIdList.total_amount}
                                </font></div>
                    </td>
                    <td class="tdStyle" width="10%">
                        <div class="high" align="center"><font
                                color="#0066cc">${IndNoCloseLoanByRptIdList.total_balance}
                                </font></div>
                    </td>
                    <td class="tdStyle" width="25%">
                        <div class="high" align="center"><font
                                color="#0066cc">${IndNoCloseLoanByRptIdList.avg_month_pay_l6m}
                                </font></div>
                    </td>
                </tr>
</#list>							
                </tbody>
            </table>
            </div>
        </td>
    </tr>
    <tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
</#if >
<#if (IndNoCloseCcByRptId?size>0)>
    <tr height="30" valign="bottom">
        <td align="center"><span class="high"><font color="#0066cc"
                                                    style="font-size: 12px"><b>未销户贷记卡信息汇总</b></font></span>
        </td>
    </tr>
    <tr>
        <td>
            <div align="center">
                <table cellspacing="0" cellpadding="2" width="75%" align="center"
                       border="0" class="tableStyle">
                    <tbody>
                    <tr>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">发卡法人<br>
			机构数</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">发卡<br>
			机构数</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">账户数</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">授信总额</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">单家行最<br>
			高授信额</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">单家行最<br>
			低授信额</span></font></b></div>
                            <font color="#0066cc"> </font></td>
                        <td class="tdStyle" width="14%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">已用额度</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="14%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">最近6个月平<br>
			均使用额度</span></font></b></div>
                        </td>
                    </tr>
<#list IndNoCloseCcByRptId as IndNoCloseCcByRptIdList>								
                    <tr>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoCloseCcByRptIdList.law_org_count}</span></font>
                            </div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoCloseCcByRptIdList.org_count}
                                        </span></font></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoCloseCcByRptIdList.count}</span></font>
                            </div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoCloseCcByRptIdList.total_credit_amount}
                                        </span></font>
                            </div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoCloseCcByRptIdList.max_credit_amount}
                                        </span></font>
                            </div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoCloseCcByRptIdList.min_credit_amount}
                                        </span></font>
                            </div>
                        </td>
                        <td class="tdStyle" width="14%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoCloseCcByRptIdList.total_used}
                                        </span></font></div>
                        </td>
                        <td class="tdStyle" width="14%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoCloseCcByRptIdList.avg_used_l6m}
                                        </span></font></div>
                        </td>
                    </tr>
</#list>								
                    </tbody>
                </table>
            </div>
        </td>
    </tr>
    <tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
    </#if >
    <#if (IndNoClosePdcByRptId?size>0)>         
    <tr height="30" valign="bottom">
        <td align="center"><font color="#0066cc" style="font-size: 12px"><b>未销户准贷记卡信息汇总</b></font></td>
    </tr>
    <tr>
        <td>
            <div align="center">
                <table cellspacing="0" cellpadding="2" width="75%" align="center"
                       border="0" class="tableStyle">
                    <tbody>
                    <tr>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">发卡法人<br>
			机构数</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">发卡<br>
			机构数</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">账户数</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">授信总额</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">单家行最<br>
			高授信额</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">单家行最<br>
			低授信额</span></font></b></div>
                            <font color="#0066cc"> </font></td>
                        <td class="tdStyle" width="14%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">透支余额</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="14%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">最近6个月平<br>
			均透支余额</span></font></b></div>
                        </td>
                    </tr>
<#list IndNoClosePdcByRptId as IndNoClosePdcByRptIdList>								
                    <tr>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoClosePdcByRptIdList.law_org_count}</span></font>
                            </div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoClosePdcByRptIdList.org_count}
                                        </span></font></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoClosePdcByRptIdList.count}
                                        </span></font></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoClosePdcByRptIdList.total_credit_amount}
                                        </span></font>
                            </div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoClosePdcByRptIdList.max_credit_amount}
                                        </span></font>
                            </div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoClosePdcByRptIdList.min_credit_amount}
                                        </span></font>
                            </div>
                        </td>
                        <td class="tdStyle" width="14%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoClosePdcByRptIdList.total_overdraw}
                                        </span></font></div>
                        </td>
                        <td class="tdStyle" width="14%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndNoClosePdcByRptIdList.avg_overdraw_l6m}
                                        </span></font>
                            </div>
                        </td>
                    </tr>
</#list>								
                    </tbody>
                </table>
            </div>
        </td>
    </tr>    
    <tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
    </#if >
    
    <#if (IndAssuranceByRptId?size>0)>               
    <tr height="30" valign="bottom">
        <td align="center"><font color="#0066cc" style="font-size: 12px"><b>对外担保信息汇总</b></font></td>
    </tr>
    <tr>
        <td>
            <div align="center">
                <table cellspacing="0" cellpadding="2" width="320" align="center"
                       border="0" class="tableStyle">
                    <tbody>
                    <tr>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">担保笔数</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">担保金额</span></font></b></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">担保本金余额</span></font></b></div>
                        </td>
                    </tr>
<#list IndAssuranceByRptId as IndAssuranceByRptIdList>								
                    <tr>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndAssuranceByRptIdList.count}</span></font>
                            </div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndAssuranceByRptIdList.bank_assurance}
                                        </span></font></div>
                        </td>
                        <td class="tdStyle" width="12%">
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high">${IndAssuranceByRptIdList.balance}
                                        </span></font></div>
                        </td>
                    </tr>
</#list>								
                    </tbody>
                </table>
            </div>
        </td>
    </tr>
    <tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
</#if >
</#if >
<#assign IndDisposalByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndDisposalByRptId(rptId)/>
<#assign IndEnsureByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndEnsureByRptId(rptId)/>
<#if (IndDisposalByRptId?size>0) || (IndEnsureByRptId?size>0)>

<tr style="line-height: 15px">
    <td><div style="height: 20px"></div></td>
</tr>
<tr height="40">
    <td align="center" valign="middle"><font color="#0066cc"
                                             style="font-size: 14px"><b>信贷交易信息明细</b></font></td>
</tr>  
<#if (IndDisposalByRptId?size>0)>        
    <tr height="30" valign="bottom">
        <td>
            <div class="high" align="center"><font color="#0066cc"><span
                        class="high"><strong><b>资产处置信息</b></strong></span></font></div>
            <b> </b></td>
    </tr>
    <tr>
        <td>
            <table cellspacing="0" cellpadding="2" width="90%" align="center"
                   border="0" class="tableStyle">
                <tbody>
                <tr>
                    <td class="tdStyle" width="5%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">编<br/> 号</font></b></div>
                    </td>
                    <td class="tdStyle" width="15%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">资产管理公司</font></b></div>
                    </td>
                    <td class="tdStyle" width="15%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">债务接收日期</font></b></div>
                    </td>
                    <td class="tdStyle" width="15%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">接收的债务<br/> 金额</font></b>
                        </div>
                    </td>
                    <td class="tdStyle" width="20%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">最近一次<br/> 还款日期</font></b>
                        </div>
                    </td>
                    <td class="tdStyle" width="15%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">金额</font></b></div>
                    </td>
                </tr>
<#list IndDisposalByRptId as IndDisposalByRptIdList>	
                    <tr>
                        <td class="tdStyle">
                            <div class="high" align="center"><font color="#0066cc">${IndDisposalByRptIdList.no}
                                    </font></div>
                        </td>
                        <td class="tdStyle">
                            <div class="high" align="center"><font
                                    color="#0066cc">${IndDisposalByRptIdList.manager_org}</font></div>
                        </td>
                        <td class="tdStyle">
                            <div class="high" align="center"><font
                                    color="#0066cc">${IndDisposalByRptIdList.expropriate_date}
                                    </font></div>
                        </td>
                        <td class="tdStyle">
                            <div class="high" align="center"><font
                                    color="#0066cc">${IndDisposalByRptIdList.expropriate_amount}
                                    </font></div>
                        </td>
                        <td class="tdStyle">
                            <div class="high" align="center"><font
                                    color="#0066cc">${IndDisposalByRptIdList.last_pay_date}
                                    </font></div>
                        </td>
                        <td class="tdStyle">
                            <div class="high" align="center"><font
                                    color="#0066cc">${IndDisposalByRptIdList.balance}
                                    </font></div>
                        </td>
                    </tr>
</#list>                            
                </tbody>
            </table>
        </td>
    </tr>
    <tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
    </#if >
    
    <#if (IndEnsureByRptId?size>0)> 
    
    <tr height="30" valign="bottom">
        <td>
            <div class="high" align="center"><font color="#0066cc"><span
                        class="high"><strong><b>（<?php
                                echo $seqToCn [$seqChild++] ?>）保证人代偿信息</b></strong></span></font></div>
            <b> </b></td>
    </tr>
    <tr>
        <td>
            <table cellspacing="0" cellpadding="2" width="90%" align="center"
                   border="0" class="tableStyle">
                <tbody>
                <tr>
                    <td class="tdStyle" width="5%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">编<br/> 号</font></b></div>
                    </td>
                    <td class="tdStyle" width="15%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">代偿机构</font></b></div>
                    </td>
                    <td class="tdStyle" width="15%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">最近一次<br/> 代偿日期</font></b>
                        </div>
                    </td>
                    <td class="tdStyle" width="15%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">累计代偿<br/> 金额</font></b>
                        </div>
                    </td>
                    <td class="tdStyle" width="20%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">最近一次<br/> 还款日期</font></b>
                        </div>
                    </td>
                    <td class="tdStyle" width="15%" align="center">
                        <div class="high" align="center"><b><font color="#0066cc">金额</font></b></div>
                    </td>
                </tr>
<#list IndEnsureByRptId as IndEnsureByRptIdList>
                        <td class="tdStyle">
                            <div class="high" align="center"><font color="#0066cc">${IndEnsureByRptIdList.no}
                                    </font></div>
                        </td>
                        <td class="tdStyle">
                            <div class="high" align="center"><font
                                    color="#0066cc">${IndEnsureByRptIdList.ensure_org}</font></div>
                        </td>
                        <td class="tdStyle">
                            <div class="high" align="center"><font
                                    color="#0066cc">${IndEnsureByRptIdList.last_ensure_pay_date}
                                    </font></div>
                        </td>
                        <td class="tdStyle">
                            <div class="high" align="center"><font
                                    color="#0066cc">${IndEnsureByRptIdList.total_pay_amount}
                                    </font>
                            </div>
                        </td>
                        <td class="tdStyle">
                            <div class="high" align="center"><font
                                    color="#0066cc">${IndEnsureByRptIdList.last_pay_date}
                                    </font></div>
                        </td>
                        <td class="tdStyle">
                            <div class="high" align="center"><font
                                    color="#0066cc">${IndEnsureByRptIdList.balance}
                                    </font></div>
                        </td>
                    </tr>
                    </#list>                         
                </tbody>
            </table>
        </td>
    </tr>
    <tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
    </#if >
    </#if > 
    	<#assign rptId = RequestParameters["rptId"]?default("true")>
    	<#assign IndLonDetailorInfoByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndLonDetailorInfoByRptId(rptId)/>
    	<#if (IndLonDetailorInfoByRptId?size>0)>
                    <tr height="30" valign="bottom">
                        <td>
                            <div class="high" align="center"><font color="#0066cc"><span
                                        class="high"><strong><b>贷款</b></strong></span></font></div>
                            <b> </b></td>
                    </tr>
			<#list IndLonDetailorInfoByRptId as IndLonDetailorInfoByRptIdList>
    				
    	 <#assign No =IndLonDetailorInfoByRptIdList.No?default("true") >
    	 <#assign IndLonDetailorInfoTwoByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndLonDetailorInfoTwoByRptId(rptId,No)/>					              
                        <tr style="line-height: 25px">
                            <td><div style="height: 20px"></div></td>
                        </tr>
                        <tr  height="35" style="line-height: 25px; text-indent:5em;">
                        <#list IndLonDetailorInfoTwoByRptId as IndLonDetailorInfoTwoByRptIdList>                        
                            <#if IndLonDetailorInfoTwoByRptIdList.flagDesc == "success">
                            <td align="center" width="90%" >
                                <div class="high" align="left"><b><font color="#0066cc"><span
                                                class="high">${IndLonDetailorInfoTwoByRptIdList.valueDesc}</span></font></b></div>
                            </td>
                            </#if>
                        </#list>                            
                        </tr>
                        <tr>
                            <td>
                                <table cellspacing="0" cellpadding="0" width="90%" align="center"
                                       class="tableStyle">
                                    <tbody>
									<tr>
										<td>
											<div style ="height: 5px"></div>
										</td>
									</tr>
									<#if IndLonDetailorInfoByRptIdList.Acc_status == "呆账" ||	IndLonDetailorInfoByRptIdList.Acc_status=="转出" || IndLonDetailorInfoByRptIdList.Acc_status=="结清">
                
									<#else>	
                                        <tr>
                                            <td colspan="2" align="center" class="tdStyle">
                                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                                class="high">账户状态</span></font></b></div>
                                            </td>
                                            <td colspan="2" align="center" class="tdStyle">
                                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                                class="high">五级分类</span></font></b></div>
                                            </td>
                                            <td colspan="2" align="center" class="tdStyle">
                                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                                class="high">本金余额</span></font></b></div>
                                            </td>
                                            <td colspan="3" align="center" class="tdStyle">
                                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                                class="high">剩余还<br>款期数</span></font></b>
    																			</div>
                                            </td>
                                            <td colspan="3" align="center" class="tdStyle"><b><font
                                                        color="#0066cc"><span class="high">本月应还款</span></font></b></td>
                                            <td class="tdStyle" colspan="4" align="center"><b><font
                                                        color="#0066cc"><span class="high">应还款日</span></font></b></td>
                                            <td class="tdStyle" colspan="4" align="center"><b><font
                                                        color="#0066cc"><span class="high">本月实还款</span></font></b></td>
                                            <td class="tdStyle"  colspan="4"
                                                align="center"><b><font color="#0066cc"><span class="high">最近一次<br>还款日期</span></font></b></td>
                                        </tr>
                                        <#list IndLonDetailorInfoTwoByRptId as IndLonDetailorInfoTwoByRptIdList>							
		                                        <tr>
		                                            <td class="tdStyle" colspan="2" style="word-break: break-all">
		                                                <div class="high" align="center"><font color="#0066cc"><span
		                                                            class="high">${IndLonDetailorInfoByRptIdList.Acc_status}
		                                                            </span></font></div>
		                                            </td>
		                                            <td class="tdStyle" colspan="2" style="word-break: break-all">
		                                                <div class="high" align="center"><font color="#0066cc"><span
		                                                            class="high">${IndLonDetailorInfoTwoByRptIdList.valueClass}</span></font></div>
		                                            </td>
		                                            <td class="tdStyle" colspan="2" style="word-break: break-all">
		                                                <div class="high" align="center"><font color="#0066cc"><span
		                                                            class="high">${IndLonDetailorInfoByRptIdList.Balance}
		                                                            </span></font></div>
		                                            </td>
		                                            <td class="tdStyle" colspan="3" style="word-break: break-all">
		                                                <div class="high" align="center"><font color="#0066cc"><span 
		                                                            class="high">${IndLonDetailorInfoByRptIdList.Left_month}</span></font>
		                                                </div>
		                                            </td>
		                                            <td class="tdStyle" colspan="3" style="word-break: break-all">
		                                                <div class="high" align="center"><font color="#0066cc"><span 
		                                                            class="high">${IndLonDetailorInfoByRptIdList.Pay_month}
		                                                            </span></font></div>
		                                            </td>
		                                            <td class="tdStyle" colspan="4" style="word-break: break-all">
		                                                <div class="high" align="center"><font color="#0066cc"><span
		                                                            class="high">${IndLonDetailorInfoTwoByRptIdList.valuePayday}</span></font></div>
		                                            </td>
		                                            <td class="tdStyle" colspan="4" style="word-break: break-all">
		                                                <div class="high" align="center"><font color="#0066cc"><span 
		                                                            class="high">${IndLonDetailorInfoByRptIdList.Pay_real}
		                                                            </span></font></div>
		                                            </td>
		                                            <td class="tdStyle" colspan="4"
		                                                style="word-break: break-all;">
		                                                <div class="high" align="center"><font color="#0066cc"><span 
		                                                            class="high">${IndLonDetailorInfoByRptIdList.Recent_pay_date}
		                                                            </span></font></div>
		                                            </td>
		                                        </tr>
                                        </#list>
                                        <tr>
                                            <td class="tdStyle" colspan="4" align="center">
                                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                                class="high">当前逾期期数</span></font></b></div>
                                            </td>
                                            <td class="tdStyle" colspan="4" align="center">
                                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                                class="high">当前逾期金额</span></font></b></div>
                                            </td>
                                            <td class="tdStyle" colspan="4" align="center">
                                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                                class="high">逾期31-60天<br>
    						未还本金</span></font></b></div>
                                            </td>
                                            <td class="tdStyle" colspan="4" align="center">
                                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                                class="high">逾期61－90天<bt>未还本金</bt></span></font></b></div>
                                            </td>
                                            <td class="tdStyle" colspan="4" align="center">
                                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                                class="high">逾期91－180天<br>
    						未还本金</span></font></b></div>
                                            </td>
                                            <td class="tdStyle"  colspan="4"
                                                align="center">
                                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                                class="high">逾期180天以<br>
    						上未还本金</span></font></b></div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="tdStyle" colspan="4">
                                                <div class="high" align="center"><font color="#0066cc"><span 
                                                            class="high">${IndLonDetailorInfoByRptIdList.Overdue_count}
                                                            </span></font></div>
                                            </td>
                                            <td class="tdStyle" colspan="4">
                                                <div class="high" align="center"><font color="#0066cc"><span
                                                            class="high">${IndLonDetailorInfoByRptIdList.Overdue_amount}
                                                            </span></font></div>
                                            </td>
                                            <td class="tdStyle" colspan="4">
                                                <div class="high" align="center"><font color="#0066cc"><span
                                                            class="high">${IndLonDetailorInfoByRptIdList.Over31}
                                                            </span></font></div>
                                            </td>
                                            <td class="tdStyle" colspan="4">
                                                <div class="high" align="center"><font color="#0066cc"><span
                                                            class="high">${IndLonDetailorInfoByRptIdList.Over61}
                                                            </span></font></div>
                                            </td>
                                            <td class="tdStyle" colspan="4">
                                                <div class="high" align="center"><font color="#0066cc"><span
                                                            class="high"><span class="high">${IndLonDetailorInfoByRptIdList.Over91}
                                                            </span></font></div>
                                            </td>
                                            <td class="tdStyle" colspan="4" >
                                                <div class="high" align="center"><font color="#0066cc"><span 
                                                            class="high"><span class="high">${IndLonDetailorInfoByRptIdList.Over180}
                                                            </span></font></div>
                                            </td>
                                        </tr>
                                   <#assign  lists24 =statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndLonDetailorInfoByRptId24(rptId,No)/>
                                   <#if (lists24?size>0)>
                                        <tr>
                                            <td colspan="24" class="tdStyle" style="border-right-width: 1px">
                                                <div class="high" align="center"><font color="#0066cc"><strong><b>
                                                                ${IndLonDetailorInfoByRptIdList.yearMonth}
                                                            </b></strong></font></div>
                                                <b> </b></td>
                                        </tr>
                                   <tr>
									<#list lists24 as listss>
	                                             
	                                                <td class="tdStyle" colspan="1">
	                                                    <div class="high" align="center"><font color="#0066cc"><span
	                                                                class="high">
	                                                    ${listss.month24value}
	                                                    </span></font></div>
	                                                </td>
	                                        
                                   		</#list>
                                   		</tr>								
                                  </#if> 
                            </#if>
				<#if IndLonDetailorInfoByRptIdList.Acc_status == "呆账">
				<#else> 
					<#assign No =IndLonDetailorInfoByRptIdList.No >
					<#assign IndOverdueDetailByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndOverdueDetailByRptId(rptId,No)/>
					<#if (IndOverdueDetailByRptId?size>0)>
                       <tr>
                            <td class="tdStyle" colspan="24">
                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                class="high">${IndLonDetailorInfoByRptIdList["yqyearMonth"]}
			</span></font></b></div>
                            </td>
                        </tr>
                        <tr>
                            <td class="tdStyle" colspan="8">
                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                class="high">逾期月份</span></font></b></div>
                            </td>
                            <td class="tdStyle" colspan="8">
                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                class="high">逾期持续月数</span></font></b></div>
                            </td>
                            <td class="tdStyle" colspan="8">
                                <div class="high" align="center"><b><font color="#0066cc"><span
                                                class="high">逾期金额</span></font></b></div>
                            </td>
					<#list IndOverdueDetailByRptId as IndOverdueDetailByRptIdList>										                                  

                           
                        </tr>
                            <tr>
                                <td class="tdStyle" colspan="8">
                                    <div class="high" align="center"><font color="#0066cc"><span
                                                class="high">
												${IndOverdueDetailByRptIdList.month}																
                                                </span></font></div>
                                </td>
                                <td class="tdStyle" colspan="8">
                                    <div class="high" align="center"><font color="#0066cc"><span   
                                                class="high">${IndOverdueDetailByRptIdList.month_count}
                                                </span></font></div>
                                </td>
                                <td class="tdStyle" colspan="8">
                                    <div class="high" align="center"><font color="#0066cc"><span 
                                                class="high">${IndOverdueDetailByRptIdList.amount}
                                                </span></font></div>
                                </td>                                               
                            </tr>		
                            
					</#list>
					</#if>	
			</#if>				
		<#assign No =IndLonDetailorInfoByRptIdList.No >
		<#assign IndSpecialNewByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndSpecialNewByRptId(rptId,No)/>   
		<#if (IndSpecialNewByRptId?size>0)>                                                                   
                    <tr>
                        <td class="tdStyle" colspan="5">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">特殊交易类型</span></font></b></div>
                        </td>
                        <td class="tdStyle" colspan="4">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">发生日期</span></font></b></div>
                        </td>
                        <td class="tdStyle" colspan="4">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">变更月数</span></font></b></div>
                        </td>

                        <td class="tdStyle" colspan="4">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">发生金额</span></font></b></div>
                        </td>
                        <td class="tdStyle" colspan="7">
                            <div class="high" align="center"><b><font color="#0066cc"><span
                                            class="high">明细记录</span></font></b></div>
                        </td>
                    </tr>
                    <#list IndSpecialNewByRptId as IndSpecialNewByRptIdList>  
                        <tr>
                            <td class="tdStyle" colspan="5">
                                <div class="high" align="center"><font color="#0066cc"><span 
                                            class="high">${IndSpecialNewByRptIdList.type}</span></font>
                                </div>
                            </td>
                            <td class="tdStyle" colspan="4">
                                <div class="high" align="center"><font color="#0066cc"><span ${IndSpecialNewByRptIdList.date}
                                            class="high">${IndSpecialNewByRptIdList.date}
                                            </span></font></div>
                            </td>
                            <td class="tdStyle" colspan="4">
                                <div class="high" align="center"><font color="#0066cc"><span 
                                            class="high">${IndSpecialNewByRptIdList.change_month}
                                            </span></font></div>
                            </td>
                            <td class="tdStyle" colspan="4">
                                <div class="high" align="center"><font color="#0066cc"><span 
                                            class="high">${IndSpecialNewByRptIdList.amount}
                                            </span></font></div>
                            </td>
                            <td class="tdStyle" colspan="7">
                                <div class="high" align="center"><font color="#0066cc"><span 
                                            class="high">${IndSpecialNewByRptIdList.details}
                                            </span></font></div>
                            </td>
                        </tr>
                   </#list>								   							                               
                   </#if>
                    <#list IndLonDetailorInfoTwoByRptId as IndLonDetailorInfoTwoByRptIdListTwoOrgdesc>
                    <#if IndLonDetailorInfoTwoByRptIdListTwoOrgdesc.flagOrgdesc == "success">
                    <tr>
	                    <td class="tdStyle" colspan="20">
	                        <div class="high" align="center"><b><font color="#0066cc"><span
	                                        class="high">贷款机构说明</span></font></b></div>
	                    </td>
	                    <td class="tdStyle" colspan="4">
	                        <div class="high" align="center"><b><font color="#0066cc"><span
	                                        class="high">添加日期</span></font></b></div>
	                    </td>
                    </tr>
                        <tr>
                            <td class="tdStyle" colspan="20">
                                <div class="high" align="center"><font color="#0066cc"><span 
                                            class="high">${IndLonDetailorInfoTwoByRptIdListTwoOrgdesc.valueOrgdesc}</span></font>
                                </div>
                            </td>
                            <td class="tdStyle" colspan="4">
                                <div class="high" align="center"><font color="#0066cc"><span  
                                            class="high">${IndLonDetailorInfoTwoByRptIdListTwoOrgdesc.dateOrgdesc}
                                            </span></font></div>
                            </td>
                        </tr>
                    </#if>    
                    </#list>                                
                    
                  <#list IndLonDetailorInfoTwoByRptId as IndLonDetailorInfoTwoByRptIdListTwoSelfStatement>
                  	<#if IndLonDetailorInfoTwoByRptIdListTwoSelfStatement.flagSelfStatement == "success">
	                  <tr>
	                  <td class="tdStyle" colspan="20">
	                      <div class="high" align="center"><b><font color="#0066cc"><span
	                                      class="high">本人声明</span></font></b></div>
	                  </td>
	                  <td class="tdStyle" colspan="4">
	                      <div class="high" align="center"><b><font color="#0066cc"><span
	                                      class="high">添加日期</span></font></b></div>
	                  </td>
	                  </tr>
                        <tr>
                            <td class="tdStyle" colspan="20">
                                <div class="high" align="center"><font color="#0066cc"><span 
                                            class="high">${IndLonDetailorInfoTwoByRptIdListTwoSelfStatement.valueSelfStatement}</span></font>
                                </div>
                            </td>
                            <td class="tdStyle" colspan="4">
                                <div class="high" align="center"><font color="#0066cc"><span
                                            class="high">${IndLonDetailorInfoTwoByRptIdListTwoSelfStatement.dateSelfStatement}
                                            </span></font></div>
                            </td>
                        </tr>
                    </#if> 
                 </#list>
                   
                    
							<#list IndLonDetailorInfoTwoByRptId as IndLonDetailorInfoTwoByRptIdListDissent>
							<#if IndLonDetailorInfoTwoByRptIdListDissent.flagDissent == "success">
							 <tr>
		                        <td class="tdStyle" colspan="20">
		                            <div class="high" align="center"><b><font color="#0066cc"><span
		                                            class="high">异议标注</span></font></b></div>
		                        </td>
		                        <td class="tdStyle" colspan="4">
		                            <div class="high" align="center"><b><font color="#0066cc"><span
		                                            class="high">添加日期</span></font></b></div>
		                        </td>
		                    </tr>
							<tr>
                            	<td class="tdStyle" colspan="20">
                            		<div class="high" align="center"><font color="#0066cc"><span
                                            class="high">${IndLonDetailorInfoTwoByRptIdListDissent.valueDissent}</span></font>
                                     </div>
                                </td>
                            <td class="tdStyle" colspan="4">
                                <div class="high" align="center"><font color="#0066cc"><span
                                            class="high">${IndLonDetailorInfoTwoByRptIdListDissent.dateDissent}
                                            </span></font></div>
                            </td>
                        </tr>
                        </#if>
                    </#list>
					
                </tbody>
            </table>
        </td>
    </tr>
    <tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
</#list>
</#if>




		<#assign IndCrdDetailByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndCrdDetailByRptId(rptId)/>   
		<#if (IndCrdDetailByRptId?size>0)>       
		<tr height="30" valign="bottom">
			<td>
				<div class="high" align="center"><font color="#0066cc"><span
							class="high"><strong><b>贷记卡</b></strong></span></font></div>
				<b> </b></td>
		</tr>
		<#list IndCrdDetailByRptId as IndCrdDetailByRptIdList>     
		<#assign No =IndCrdDetailByRptIdList.No >
		<#assign IndDetailInfoCardByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndDetailInfoCardByRptId(rptId,No)/>
		
		<tr style="line-height: 25px">
            <td><div style="height: 20px"></div></td>
        </tr>
		<tr height="35" style="line-height: 25px; text-indent:5em;">
			<td align="center" width="90%">
				<div class="high" align="left"><b><font color="#0066cc"><span class="high">
		<#list IndDetailInfoCardByRptId as IndDetailInfoCardByRptIdListDesc>
					${IndDetailInfoCardByRptIdListDesc.valueDesc}
		</#list>
				</span></font></b></div>
			</td>
		</tr>
		
        <tr>
            <td>
                <table cellspacing="0" cellpadding="0" width="90%" align="center" class="tableStyle">
                    <tbody>
						<tr>
							<td>
							<div style = "height: 5px"></div>
							</td>
							</tr>
							<#if IndCrdDetailByRptIdList.Acc_status == "呆账" || IndCrdDetailByRptIdList.Acc_status == "销户" || IndCrdDetailByRptIdList.Acc_status == "未激活">					
							<#else>               
	                        <tr>
	                            <td colspan="4" align="center" class="tdStyle">
	                                <div class="high" align="center"><b><font color="#0066cc"><span
	                                                class="high">账户状态</span></font></b></div>
	                            </td>
	                            <td colspan="4"  align="center" class="tdStyle">
	                                <div class="high" align="center"><b><font color="#0066cc"><span
	                                                class="high">已用额度</span></font></b></div>
	                            </td>
	                            <td colspan="8" align="center" class="tdStyle"><font
	                                    color="#0066cc"><b>最近6个月平均使用额度</b></font></td>
	                            <td class="tdStyle" colspan="4" align="center" >
	                                <div class="high" align="center"><b><font color="#0066cc"><span
	                                                class="high">最大使用额度</span></font></b></div>
	                            </td>
	                            <td colspan="4" align="center" class="tdStyle"><b><font color="#0066cc"><span
	                                            class="high">本月应还款</span></font></b></td>
	                        </tr>
	                        <tr>
	                            <td colspan="4"  align="center" style="word-break: break-all" class="tdStyle">
	                                <div class="high" align="center"><font color="#0066cc"><span
	                                            class="high">${IndCrdDetailByRptIdList.Acc_status}
	                                            </span></font></div>
	                            </td>
	                            <td colspan="4"  align="center" style="word-break: break-all" class="tdStyle">
	                                <div class="high" align="center"><font color="#0066cc"><span 
	                                            class="high">${IndCrdDetailByRptIdList.Overdue}
	                                            </span></font></div>
	                            </td>
	                            <td colspan="8" class="tdStyle"   align="center"
	                                style="word-break: break-all"><font color="#0066cc">
	                                   <#list IndDetailInfoCardByRptId as IndDetailInfoCardByRptIdListAvgused16m>
											${IndDetailInfoCardByRptIdListAvgused16m.valueAvgusedl6m}
										</#list>
	                                    </font></td>
	                            <td class="tdStyle" align="center" colspan="4" style="word-break: break-all">
	                                <div class="high" align="center"><font color="#0066cc"><span 
	                                            class="high">${IndCrdDetailByRptIdList.Max_debit}
	                                            </span></font></div>
	                            </td>
	                            <td class="tdStyle" align="center" colspan="4"
	                                style="word-break: break-all">
	                                <div class="high" align="center"><font color="#0066cc"><span 
	                                            class="high">${IndCrdDetailByRptIdList.Pay_month}
	                                            </span></font></div>
	                            </td>
	                        </tr>
	                        <tr align="center">
	                            <td class="tdStyle" colspan="4" align="center"><b><font
	                                        color="#0066cc"><span class="high">账单日</span></font></b></td>
	                            <td class="tdStyle" colspan="4" align="center"><b><font
	                                        color="#0066cc"><span class="high">本月实还款</span></font></b></td>
	                            <td class="tdStyle" colspan="8" align="center">
	                                <div class="high" align="center"><b><font color="#0066cc"><span
	                                                class="high">最近一次还款日期</span></font></b></div>
	                            </td>
	                            <td class="tdStyle" colspan="4" align="center">
	                                <div class="high" align="center"><b><font color="#0066cc"><span
	                                                class="high">当前逾期期数</span></font></b></div>
	                            </td>
	                            <td class="tdStyle" colspan="4" align="center">
	                                <div class="high" align="center"><b><font color="#0066cc"><span
	                                                class="high">当前逾期金额</span></font></b></div>
	                            </td>
	                        </tr>
	                        <tr>
	                            <td class="tdStyle" colspan="4" style="word-break: break-all">
	                                <div class="high" align="center"><font color="#0066cc"><span
	                                            class="high">
										<#list IndDetailInfoCardByRptId as IndDetailInfoCardByRptIdListBillday>
											${IndDetailInfoCardByRptIdListBillday.valueBillday}
										</#list>
	                                            </span></font></div>
	                            </td>
	                            <td class="tdStyle" colspan="4" style="word-break: break-all">
	                                <div class="high" align="center"><font color="#0066cc"><span 
	                                            class="high">${IndCrdDetailByRptIdList.Pay_real}
	                                            </span></font></div>
	                            </td>
	                            <td class="tdStyle" colspan="8" style="word-break: break-all">
	                                <div class="high" align="center"><font color="#0066cc"><span 
	                                            class="high">${IndCrdDetailByRptIdList.Recent_date}
	                                            </span></font></div>
	                            </td>
	                            <td class="tdStyle" colspan="4" style="word-break: break-all">
	                                <div class="high" align="center"><font color="#0066cc"><span 
	                                            class="high">${IndCrdDetailByRptIdList.Over_count}</span></font>
	                                </div>
	                            </td>
	                            <td class="tdStyle" colspan="4"
	                                style="word-break: break-all">
	                                <div class="high" align="center"><font color="#0066cc"><span 
	                                            class="high">${IndCrdDetailByRptIdList.over_amount}
	                                            </span></font></div>
	                            </td>
	                        </tr>
	                        <#assign  CardType= "贷记卡"/>
							<#assign  Crdlists24 =statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndCrdDetailorInfoByRptId24(rptId,No,CardType)/>
							<#if (Crdlists24?size>0)>
	                        <tr>
	                            <td class="tdStyle" colspan="24" style="border-right-width: 1px">
	                                <div class="high" align="center"><b><font color="#0066cc"><span
	                                                class="high">
				                       ${IndCrdDetailByRptIdList.yearMonth}</span> </font></b></div>
	                                <b> </b></td>
	                        </tr>
	                        <tr>
	                            <#list Crdlists24 as listss>
	                                <td class="tdStyle" colspan="1">
	                                    <div class="high" align="center"><font color="#0066cc"><span
	                                                class="high">
													${listss.month24value}
													</span></font></div>
	                                </td>
	                            </#list>
	                        </tr>
	                       </#if>
							</#if>	
							<#if IndCrdDetailByRptIdList.Acc_status == "呆账" ||IndCrdDetailByRptIdList.Acc_status == "未激活">
	
							<#else>
							<#assign No =IndCrdDetailByRptIdList.No >
							<#assign IndOverdueDetailCardByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndOverdueDetailCardByRptId(rptId,No)/>
							<#if (IndOverdueDetailCardByRptId?size>0)>			
	                            <tr>
	                                <td class="tdStyle" colspan="24" style="border-right-width: 1px">
	                                    <div class="high" align="center"><b><font color="#0066cc"><span
	                                                    class="high">${IndCrdDetailByRptIdList.yqyearMonth}
								</span></font></b></div>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td class="tdStyle" colspan="8" align="center">
	                                    <div class="high" align="center"><b><font color="#0066cc"><span
	                                                    class="high">逾期月份</span></font></b></div>
	                                </td>
	                                <td class="tdStyle" colspan="8" align="center">
	                                    <div class="high" align="center"><b><font color="#0066cc"><span
	                                                    class="high">逾期持续月数</span></font></b></div>
	                                </td>
	                                <td class="tdStyle" colspan="8" align="center">
	                                    <div class="high" align="center"><b><font color="#0066cc"><span
	                                                    class="high">逾期金额</span></font></b></div>
	                                </td>
	                            </tr>
								<#list IndOverdueDetailCardByRptId as IndOverdueDetailCardByRptIdList>    
								<tr>
									<td class="tdStyle" colspan="8">
										<div class="high" align="center"><font color="#0066cc"><span 
													class="high">${IndOverdueDetailCardByRptIdList.month}
													</span></font></div>
									</td>
									<td class="tdStyle" colspan="8">
										<div class="high" align="center"><font color="#0066cc"><span 
													class="high">${IndOverdueDetailCardByRptIdList.month_count}
													</span></font></div>
									</td>
									<td class="tdStyle" colspan="8">
										<div class="high" align="center"><font color="#0066cc"><span 
													class="high">${IndOverdueDetailCardByRptIdList.amount}
													</span></font></div>
									</td>
								</tr>
							</#list>
							</#if>
						</#if>	
		<#if IndCrdDetailByRptIdList.Acc_status == "未激活" >	
		
		<#else>
				<#assign No =IndCrdDetailByRptIdList.No >
				<#assign IndSpecialNewCardByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndSpecialNewCardByRptId(rptId,No)/>				
				<#if (IndSpecialNewCardByRptId?size>0)>	                           
					<tr>
						<td class="tdStyle" colspan="5">
							<div class="high" align="center"><b><font color="#0066cc"><span
											class="high">特殊交易类型</span></font></b></div>
						</td>
						<td class="tdStyle" colspan="4">
							<div class="high" align="center"><b><font color="#0066cc"><span
											class="high">发生日期</span></font></b></div>
						</td>
						<td class="tdStyle" colspan="4">
							<div class="high" align="center"><b><font color="#0066cc"><span
											class="high">变更月数</span></font></b></div>
						</td>

						<td class="tdStyle" colspan="4">
							<div class="high" align="center"><b><font color="#0066cc"><span
											class="high">发生金额</span></font></b></div>
						</td>
						<td class="tdStyle" colspan="7">
							<div class="high" align="center"><b><font color="#0066cc"><span
											class="high">明细记录</span></font></b></div>
						</td>
					</tr>
				<#list IndSpecialNewCardByRptId	as IndSpecialNewCardByRptIdList>	
						<tr>
							<td class="tdStyle" colspan="5">
								<div class="high" align="center"><font color="#0066cc"><span 
											class="high">${IndSpecialNewCardByRptIdList.type}
											</span></font></div>
							</td>
							<td class="tdStyle" colspan="4">
								<div class="high" align="center"><font color="#0066cc"><span 
											class="high">${IndSpecialNewCardByRptIdList.date}
											</span></font></div>
							</td>
							<td class="tdStyle" colspan="4">
								<div class="high" align="center"><font color="#0066cc"><span 
											class="high">${IndSpecialNewCardByRptIdList.change_month}
											</span></font></div>
							</td>
							<td class="tdStyle" colspan="4">
								<div class="high" align="center"><font color="#0066cc"><span 
											class="high">${IndSpecialNewCardByRptIdList.amount}
											</span></font></div>
							</td>
							<td class="tdStyle" colspan="7">
								<div class="high" align="center"><font color="#0066cc"><span 
											class="high">${IndSpecialNewCardByRptIdList.details}</span></font>
								</div>
							</td>
						</tr>
						</#list>
                     </#if>                      
                 
                </#if>       
								
					<#assign No =IndCrdDetailByRptIdList.No >
					<#assign IndLonDetailorInfoTwoByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndDetailInfoCardByRptId(rptId,No)/>	
                          <#list IndLonDetailorInfoTwoByRptId as IndLonDetailorInfoTwoByRptIdListTwoOrgdesc>
                          <#if IndLonDetailorInfoTwoByRptIdListTwoOrgdesc.flagOrgdesc == "success">					
                            <tr>
                                <td class="tdStyle" colspan="20">
                                    <div class="high" align="center"><b><font color="#0066cc"><span
                                                    class="high">贷款机构说明</span></font></b></div>
                                </td>
                                <td class="tdStyle" colspan="4">
                                    <div class="high" align="center"><b><font color="#0066cc"><span
                                                    class="high">添加日期</span></font></b></div>
                                </td>
                            </tr>

	                            <tr>
	                                <td class="tdStyle" colspan="20">
	                                    <div class="high" align="center"><font color="#0066cc"><span 
	                                                class="high">${IndLonDetailorInfoTwoByRptIdListTwoOrgdesc.valueOrgdesc}</span></font>
	                                    </div>
	                                </td>
	                                <td class="tdStyle" colspan="4">
	                                    <div class="high" align="center"><font color="#0066cc"><span  
	                                                class="high">${IndLonDetailorInfoTwoByRptIdListTwoOrgdesc.dateOrgdesc}
	                                                </span></font></div>
	                                </td>
	                            </tr>
                            </#if>
                        </#list>    
                           <#list IndLonDetailorInfoTwoByRptId as IndLonDetailorInfoTwoByRptIdListTwoSelfStatement>
                           <#if IndLonDetailorInfoTwoByRptIdListTwoSelfStatement.flagSelfStatements == "success">
                            <tr>
                                <td class="tdStyle" colspan="20">
                                    <div class="high" align="center"><b><font color="#0066cc"><span
                                                    class="high">本人声明</span></font></b></div>
                                </td>
                                <td class="tdStyle" colspan="4">
                                    <div class="high" align="center"><b><font color="#0066cc"><span
                                                    class="high">添加日期</span></font></b></div>
                                </td>
                            </tr>
                            <tr>
                                <td class="tdStyle" colspan="20">
                                    <div class="high" align="center"><font color="#0066cc"><span 
                                                class="high">${IndLonDetailorInfoTwoByRptIdListTwoSelfStatement.valueSelfStatement}</span></font>
                                    </div>
                                </td>
                                <td class="tdStyle" colspan="4">
                                    <div class="high" align="center"><font color="#0066cc"><span
                                                class="high">${IndLonDetailorInfoTwoByRptIdListTwoSelfStatement.dateSelfStatement}
                                                </span></font></div>
                                </td>
                            </tr>
                            </#if>
                            </#list>
                            <#list IndLonDetailorInfoTwoByRptId as IndLonDetailorInfoTwoByRptIdListTwoSelfStatement>
                           <#if IndLonDetailorInfoTwoByRptIdListTwoSelfStatement.flagDissent == "success">                                 
                            <tr>
                                <td class="tdStyle" colspan="20">
                                    <div class="high" align="center"><b><font color="#0066cc"><span
                                                    class="high">异议标注</span></font></b></div>
                                </td>
                                <td class="tdStyle" colspan="4">
                                    <div class="high" align="center"><b><font color="#0066cc"><span
                                                    class="high">添加日期</span></font></b></div>
                                </td>
                            </tr>
                            
                            <tr>
                                <td class="tdStyle" colspan="20">
                                    <div class="high" align="center"><font color="#0066cc"><span 
                                                class="high">${IndLonDetailorInfoTwoByRptIdListTwoSelfStatement.valueDissent}</span></font>
                                    </div>
                                </td>
                                <td class="tdStyle" colspan="4">
                                    <div class="high" align="center"><font color="#0066cc"><span
                                                class="high">${IndLonDetailorInfoTwoByRptIdListTwoSelfStatement.dateDissent}
                                                </span></font></div>
                                </td>
                            </tr>
                             </#if>
                            </#list>
							
							
						 
		               </tbody>
				</table>
			</td>
		</tr>
		<tr align="center" valign="middle">
                        <td height="24" colspan="3">
                            <div align="center"><font color="#0066cc" size="2"><b><font
                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
                        </td>
                    </tr>
    </#list>
    </#if>
    
    
    
			<#assign rptId = RequestParameters["rptId"]?default("true")>			
            			<#assign IndCrdDetailQuaByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndCrdDetailQuaByRptId(rptId)/>	
            			<#if (IndCrdDetailQuaByRptId?size>0)>
						
                            <tr height="30" valign="bottom">
                                <td>
                                    <div class="high" align="center"><font color="#0066cc"><span
                                                class="high"><strong><b>准贷记卡</b></strong></span></font></div>
                                    <b> </b></td>
                            </tr>
            			<#list IndCrdDetailQuaByRptId as IndCrdDetailQuaByRptIdList>
            			<#assign No = IndCrdDetailQuaByRptIdList.No>			
            			<#assign IndDetailInfoCardQuaByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndDetailInfoCardQuaByRptId(rptId,No)/>				
                            
                                <tr style="line-height: 25px">
                                    <td><div style="height: 20px"></div></td>
                                </tr>
                                <tr height="35" style="line-height: 25px">
                                    <td align="center" width="90%">
                                        <div class="high" align="center"><b><font color="#0066cc"><span
                                                        class="high">
            											<#list IndDetailInfoCardQuaByRptId as IndDetailInfoCardQuaByRptIdLIst>
            											 ${IndDetailInfoCardQuaByRptIdLIst.valueDesc}
            											</#list>
            											</span></font></b></div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <table cellspacing="0" cellpadding="2" width="75%" align="center"
                                               class="tableStyle">
                                         <tbody>
										 <tr>
										 <td>
									<div style ="height: 5px"></div>
									</td>
									</tr>
											<#if IndCrdDetailQuaByRptIdList.Acc_status == "呆账" || IndCrdDetailQuaByRptIdList.Acc_status == "销户" || IndCrdDetailQuaByRptIdList.Acc_status == "未激活">													
											
											<#else>
                                                <tr align="center">
                                                    <td colspan="3" class="tdStyle">
                                                        <div class="high" align="center"><b><font color="#0066cc"><span
                                                                        class="high">账户状态</span></font></b></div>
                                                    </td>
                                                    <td colspan="3" class="tdStyle">
                                                        <div class="high" align="center"><b><font color="#0066cc"><span
                                                                        class="high">透支余额</span></font></b></div>
                                                    </td>
                                                    <td colspan="3" align="center" class="tdStyle"><font
                                                            color="#0066cc"><b>最近6个月平均透支余额</b></font></td>
                                                    <td class="tdStyle" colspan="3">
                                                        <div class="high" align="center"><b><font color="#0066cc"><span
                                                                        class="high">最大透支余额</span></font></b></div>
                                                    </td>
                                                    <td colspan="3" align="center" class="tdStyle"><b><font color="#0066cc"><span
                                                                    class="high">账单日</span></font></b></td>
                                                    <td colspan="3" align="center" class="tdStyle"><b><font color="#0066cc"><span
                                                                    class="high">本月实还款</span></font></b></td>
                                                    <td colspan="3" align="center" class="tdStyle"><b><font color="#0066cc"><span
                                                                    class="high">最近一次还款日期</span></font></b></td>
                                                    <td colspan="3" align="center" class="tdStyle"><b><font color="#0066cc"><span
                                                                    class="high">透支180天以上未付余额</span></font></b></td>
                                                </tr>
                                                <tr>
                                                    <td colspan="3" style="word-break: break-all" class="tdStyle">
                                                        <div class="high" align="center"><font color="#0066cc"><span
                                                                    class="high">${IndCrdDetailQuaByRptIdList.Acc_status}
                                                                    </span></font></div>
                                                    </td>
                                                    <td colspan="3" style="word-break: break-all" class="tdStyle">
                                                        <div class="high" align="center"><font color="#0066cc"><span 
                                                                    class="high">${IndCrdDetailQuaByRptIdList.Overdue}
                                                                    </span></font></div>
                                                    </td>
                                                    <td class="tdStyle" colspan="3" align="center"
                                                        style="word-break: break-all"><font color="#0066cc">
                                                            <#list IndDetailInfoCardQuaByRptId as IndDetailInfoCardQuaByRptIdLIst>
            											   ${IndDetailInfoCardQuaByRptIdLIst.valueAvgusedl6m}
            											   </#list>
                                                            </font></td>
                                                    <td class="tdStyle" colspan="3" style="word-break: break-all">
                                                        <div class="high" align="center"><font color="#0066cc"><span 
                                                                    class="high">${IndCrdDetailQuaByRptIdList.Max_debit}
                                                                    </span></font></div>
                                                    </td>
                                                    <td class="tdStyle" colspan="3" style="word-break: break-all">
                                                        <div class="high" align="center"><font color="#0066cc"><span
                                                                    class="high">
                                                            <#list IndDetailInfoCardQuaByRptId as IndDetailInfoCardQuaByRptIdLIst>
            													${IndDetailInfoCardQuaByRptIdLIst.valueBillday}
            											   </#list>
                                                                    </span></font></div>
                                                    </td>
                                                    <td class="tdStyle" colspan="3" style="word-break: break-all">
                                                        <div class="high" align="center"><font color="#0066cc"><span  
                                                                    class="high">${IndCrdDetailQuaByRptIdList.Pay_real}
                                                                    </span></font></div>
                                                    </td>
                                                    <td class="tdStyle" colspan="3" style="word-break: break-all">
                                                        <div class="high" align="center"><font color="#0066cc"><span 
                                                                    class="high">${IndCrdDetailQuaByRptIdList.Recent_date}
                                                                    </span></font></div>
                                                    </td>
                                                    <td class="tdStyle" colspan="3"
                                                        style="word-break: break-all">
                                                        <div class="high" align="center"><font color="#0066cc"><span 
                                                                    class="high">${IndCrdDetailQuaByRptIdList.Over180}
                                                                    </span></font></div>
                                                    </td>
                                                </tr>
						<#assign  CardType= "准贷记卡"/>
						<#assign  Crdlists24 =statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndCrdDetailorInfoByRptId24(rptId,No,CardType)/>
						<#if (Crdlists24?size>0)>
                                                <tr>
                                                    <td class="tdStyle" colspan="24" style="border-right-width: 1px">
                                                        <div class="high" align="center"><b><font color="#0066cc"><span
                                                                        class="high">${IndCrdDetailQuaByRptIdList.yearMonth}
            						</span></font></b></div>
                                                        <b> </b></td>
                                                </tr>
                                                <tr>
                                                   <#list Crdlists24 as listss>
                                                        <td class="tdStyle" width="37">
                                                            <div class="high" align="center"><font color="#0066cc"><span
                                                                        class="high">
            															${listss.month24value}</span></font></div>
                                                        </td>
                                                     </#list>
                                                </tr>
							</#if>
            			</#if>
            			<#if IndCrdDetailQuaByRptIdList.Acc_status == "呆账" || IndCrdDetailQuaByRptIdList.Acc_status == "未激活">
            			
            			<#else>
            			<#assign No = IndCrdDetailQuaByRptIdList.No>			
            			<#assign IndOverdueDetailCardQuaByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndOverdueDetailCardQuaByRptId(rptId,No)/>
            					<#if (IndOverdueDetailCardQuaByRptId?size>0)>				                                
                                                    <tr>
                                                        <td class="tdStyle" colspan="24" style="border-right-width: 1px">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">
            										${IndCrdDetailQuaByRptIdList.yearMonth}
            							</span></font></b></div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="tdStyle" colspan="4">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">逾期月份</span></font></b></div>
                                                        </td>
                                                        <td class="tdStyle" colspan="4">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">逾期持续月数</span></font></b></div>
                                                        </td>
                                                        <td class="tdStyle" colspan="4">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">逾期金额</span></font></b></div>
                                                        </td>

                                                        
                                                    </tr>
            										<#list IndOverdueDetailCardQuaByRptId as IndOverdueDetailCardQuaByRptIdList>                                     
                                                        <tr>
                                                            <td class="tdStyle" colspan="4">
                                                                <div class="high" align="center"><font color="#0066cc"><span 
                                                                            class="high">${IndOverdueDetailCardQuaByRptIdList.month}
                                                                            </span></font></div>
                                                            </td>
                                                            <td class="tdStyle" colspan="4">
                                                                <div class="high" align="center"><font color="#0066cc"><span 
                                                                            class="high">${IndOverdueDetailCardQuaByRptIdList.month_count}
                                                                            </span></font></div>
                                                            </td>
                                                            <td class="tdStyle" colspan="4">
                                                                <div class="high" align="center"><font color="#0066cc"><span 
                                                                            class="high">${IndOverdueDetailCardQuaByRptIdList.amount}
                                                                            </span></font></div>
                                                            </td>
                     
                                                        </tr>
                                                  </#list>       
            		                </#if>	                    
                               </#if>                         
            			 								
            			<#if IndCrdDetailQuaByRptIdList.Acc_status == "未激活">	
            			<#else>
            				<#assign No = IndCrdDetailQuaByRptIdList.No>			
            			    <#assign IndSpecialNewQuaByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndSpecialNewQuaByRptId(rptId,No)/>				   							
                                     <#if  (IndSpecialNewQuaByRptId?size>0)>              
                                                    <tr>
                                                        <td class="tdStyle" colspan="5">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">特殊交易类型</span></font></b></div>
                                                        </td>
                                                        <td class="tdStyle" colspan="4">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">发生日期</span></font></b></div>
                                                        </td>
                                                        <td class="tdStyle" colspan="4">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">变更月数</span></font></b></div>
                                                        </td>

                                                        <td class="tdStyle" colspan="4">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">发生金额</span></font></b></div>
                                                        </td>
                                                        <td class="tdStyle" colspan="7">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">明细记录</span></font></b></div>
                                                        </td>
                                                    </tr>
                                    <#list IndSpecialNewQuaByRptId as IndSpecialNewQuaByRptIdList>
                                                        <tr>
                                                            <td class="tdStyle" colspan="5">
                                                                <div class="high" align="center"><font color="#0066cc"><span 
                                                                            class="high">${IndSpecialNewQuaByRptIdList.type}
                                                                            </span></font></div>
                                                            </td>
                                                            <td class="tdStyle" colspan="4">
                                                                <div class="high" align="center"><font color="#0066cc"><span 
                                                                            class="high">${IndSpecialNewQuaByRptIdList.date}
                                                                            </span></font></div>
                                                            </td>
                                                            <td class="tdStyle" colspan="4">
                                                                <div class="high" align="center"><font color="#0066cc"><span  
                                                                            class="high">${IndSpecialNewQuaByRptIdList.change_month}
                                                                            </span></font></div>
                                                            </td>
                                                            <td class="tdStyle" colspan="4">
                                                                <div class="high" align="center"><font color="#0066cc"><span 
                                                                            class="high">${IndSpecialNewQuaByRptIdList.amount}
                                                                            </span></font></div>
                                                            </td>
                                                            <td class="tdStyle" colspan="7">
                                                                <div class="high" align="center"><font color="#0066cc"><span
                                                                            class="high">${IndSpecialNewQuaByRptIdList.details}</span></font>
                                                                </div>
                                                            </td>
                                                        </tr>
                                              </#list>
                                          </#if>
                                          <#list IndDetailInfoCardQuaByRptId as IndDetailInfoCardQuaByRptIdLIstOrgDesc>
                                                  <#if IndDetailInfoCardQuaByRptIdLIstOrgDesc.OrgDescflag=="success">                              
                                                    <tr>
                                                        <td class="tdStyle" colspan="20">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">贷款机构说明</span></font></b></div>
                                                        </td>
                                                        <td class="tdStyle" colspan="4">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">添加日期</span></font></b></div>
                                                        </td>
                                                    </tr>
            											 
                                                        <tr>
                                                            <td class="tdStyle" colspan="20">
                                                                <div class="high" align="center"><font color="#0066cc"><span
                                                                            class="high">${IndDetailInfoCardQuaByRptIdLIstOrgDesc.valueOrgDesc}</span></font></div>
                                                            </td>
                                                            <td class="tdStyle" colspan="4">
                                                                <div class="high" align="center"><font color="#0066cc"><span
                                                                            class="high">${IndDetailInfoCardQuaByRptIdLIstOrgDesc.dateOrgDesc}
                                                                            </span></font></div>
                                                            </td>
                                                        </tr>
                                                    <tr>
                                                    </#if>
                                                    <#if IndDetailInfoCardQuaByRptIdLIstOrgDesc.SelfStatementflag=="success">                              
                                                    
                                                        <td class="tdStyle" colspan="20">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">本人声明</span></font></b></div>
                                                        </td>
                                                        <td class="tdStyle" colspan="4">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">添加日期</span></font></b></div>
                                                        </td>
                                                    </tr>
                                                        <tr>
                                                            <td class="tdStyle" colspan="20">
                                                                <div class="high" align="center"><font color="#0066cc"><span
                                                                            class="high">${IndDetailInfoCardQuaByRptIdLIstSelfStatement.valueSelfStatement}
                                                                            </span></font></div>
                                                            </td>
                                                            <td class="tdStyle" colspan="4">
                                                                <div class="high" align="center"><font color="#0066cc"><span
                                                                            class="high">${IndDetailInfoCardQuaByRptIdLIstSelfStatement.dateSelfStatement}
                                                                            </span></font></div>
                                                            </td>
                                                        </tr>
                                                    </#if>
													<#if IndDetailInfoCardQuaByRptIdLIstOrgDesc.Dissentflag=="success">                              
                                                
                                                    <tr>
                                                        <td class="tdStyle" colspan="20">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">异议标注</span></font></b></div>
                                                        </td>
                                                        <td class="tdStyle" colspan="4">
                                                            <div class="high" align="center"><b><font color="#0066cc"><span
                                                                            class="high">添加日期</span></font></b></div>
                                                        </td>
                                                    </tr>
                                                        <tr>
                                                            <td class="tdStyle" colspan="20">
                                                                <div class="high" align="center"><font color="#0066cc"><span
                                                                            class="high">${IndDetailInfoCardQuaByRptIdLIstDissent.valueDissent}
                                                                            </span></font></div>
                                                            </td>
                                                            <td class="tdStyle" colspan="4">
                                                                <div class="high" align="center"><font color="#0066cc"><span
                                                                            class="high">${IndDetailInfoCardQuaByRptIdLIstDissent.dateDissent}
                                                                            </span></font></div>
                                                            </td>
                                                        </tr>
                                                    </#if>
                                                   </#list> 
                                                    </#if>
												
                                            </tbody>
                                        </table>
                                    </td>
                                    </tr>
                                    <tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    				</tr>
                              </#list>							
                         </#if>      				
            					
							<#assign rptId = RequestParameters["rptId"]?default("true")>
                      		<#assign IndAssuranceDetailByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndAssuranceDetailByRptId(rptId)/> 						
                      		<#if (IndAssuranceDetailByRptId?size>0)>
                                      <tr height="30" valign="bottom">
                                          <td>
                                              <div class="high" align="center"><font color="#0066cc"><span
                                                          class="high"><strong><b>（）担保信息</b></strong></span></font></div>
                                              <b> </b></td>
                                      </tr> 
                      				<#assign rptId = RequestParameters["rptId"]?default("true")>
                      				<#assign IndAssuranceDetailLoanByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndAssuranceDetailLoanByRptId(rptId)/> 										
                      				 <#if (IndAssuranceDetailLoanByRptId?size>0)>
                                          <tr style="line-height: 25px">
                                              <td><div style="height: 20px"></div></td>
                                          </tr>
                                          <tr>
                                              <td align="center" valign="middle"><span class="high"><font
                                                          color="#0066cc"><b>对外贷款担保信息</b></font></span></td>
                                          </tr>
                                          <tr>
                                              <td>
                                                  <table cellspacing="0" cellpadding="2" width="75%" align="center"
                                                         border="1" class="tableStyle">
                                                      <tbody>
                                                      <tr>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">编<br/> 号</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">担保贷款<br/> 发放机构</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">担保贷款<br/> 合同金额</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">担保贷款<br/> 发放日期</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">担保贷款<br/> 到期日期</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">担保<br/>金额</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">担保贷款<br/> 本金余额</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">担保贷款<br/> 五级分类</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">应还款日</font></b></div>
                                                          </td>
                                                      </tr>				
                                     <#list IndAssuranceDetailLoanByRptId as IndAssuranceDetailLoanByRptIdList>                
                                                          <tr>
                                                              <td class="tdStyle"> 
                                                                  <div class="high" align="center"><font color="#0066cc">${IndAssuranceDetailLoanByRptIdList.no}
                                                                          </font></div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailLoanByRptIdList.assurance_org}</font>
                                                                  </div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailLoanByRptIdList.contract_amount}
                                                                          </font>
                                                                  </div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailLoanByRptIdList.issue_date}
                                                                          </font></div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailLoanByRptIdList.end_date}</font>
                                                                  </div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailLoanByRptIdList.assurance_amount}
                                                                          </font>
                                                                  </div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailLoanByRptIdList.balance}
                                                                          </font></div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailLoanByRptIdList.l5class}</font></div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailLoanByRptIdList.yearMonth}
                                                                          </font></div>
                                                              </td>
                                                          </tr>
                                                          
                                                 </#list>
                                                      </tbody>
                                                  </table>
                                              </td>
                                          </tr>
											<tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    				</tr>                      					
                      					</#if>
                      					<#assign rptId = RequestParameters["rptId"]?default("true")>
                      					<#assign IndAssuranceDetailCredByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndAssuranceDetailCreditByRptId(rptId)/> 				
                      					<#if (IndAssuranceDetailCredByRptId?size>0)>
                                          <tr style="line-height: 25px">
                                              <td><div style="height: 20px"></div></td>
                                          </tr>
                                          <tr>
                                              <td align="center" valign="middle"><span class="high"><font
                                                          color="#0066cc"><b>对外信用卡担保信息</b></font></span></td>
                                          </tr>
                                          <tr>
                                              <td>
                                                  <table cellspacing="0" cellpadding="2" width="75%" align="center"
                                                         border="1" class="tableStyle">
                                                      <tbody>
                                                      <tr>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">编<br/> 号</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">担保信用卡<br/> 发放机构</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">担保信用卡<br/> 授信额度</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">担保信用卡<br/> 发卡日期</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">担保<br/>金额</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">担保信用卡<br/> 已用额度</font></b>
                                                              </div>
                                                          </td>
                                                          <td class="tdStyle" align="center">
                                                              <div class="high" align="center"><b><font color="#0066cc">账单日</font></b></div>
                                                          </td>
                                                      </tr>								
                                                      <#list IndAssuranceDetailCredByRptId as IndAssuranceDetailCredByRptIdList>
                                                          <tr>
                                                              <td class="tdStyle"> 
                                                                  <div class="high" align="center"><font color="#0066cc">${IndAssuranceDetailCredByRptIdList.no}
                                                                          </font></div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailCredByRptIdList.assurance_org}</font>
                                                                  </div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailCredByRptIdList.contract_amount}
                                                                          </font>
                                                                  </div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailCredByRptIdList.issue_date}
                                                                          </font></div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailCredByRptIdList.assurance_amount}
                                                                          </font>
                                                                  </div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailCredByRptIdList.balance}
                                                                          </font></div>
                                                              </td>
                                                              <td class="tdStyle">
                                                                  <div class="high" align="center"><font 
                                                                          color="#0066cc">${IndAssuranceDetailCredByRptIdList.yearMonth}
                                                                          </font></div>
                                                              </td>
                                                          </tr>
                                                     </#list>
                                                      </tbody>
                                                  </table>
                                              </td>
                                          </tr>
											<tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    					</tr>                      					
                      			</#if>
                             </#if>
                        <#assign rptId = RequestParameters["rptId"]?default("true")>
                        <#assign countbyrptid = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getCountByRptId(rptId)/> 								
                       <#if (countbyrptid?size>0)>				
                                    <tr style="line-height: 15px">
                                        <td><div style="height: 20px"></div></td>
                                    </tr>
                                    <tr height="40">
                                        <td align="center" valign="middle"><font color="#0066cc"
                                                                                 style="font-size: 14px"><b>
                                                    	公共信息明细</b></font></td>
                                    </tr>
                        			<#assign rptId = RequestParameters["rptId"]?default("true")>
                        			<#assign IndOweTaxByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndOweTaxByRptId(rptId)/> 
                        			<#if (IndOweTaxByRptId?size>0)>            
                                        <tr height="30" valign="bottom">
                                            <td>
                                                <div class="high" align="center">
                                                    <font color="#0066cc"><span class="high"><strong><b>欠税记录</b></strong></span></font>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="90%" align="center"
                                                       class="tableStyle">
                                                    <tbody>
                                                    <tr>
                                                        <td class="tdStyle" width="6%" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="151" align="center"><font
                                                                color="#0066cc"><b>主管税务机关</b></font></td>
                                                        <td class="tdStyle" width="156" align="center"><font color="#0066cc"><b>欠税总额</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="132" align="center"><font
                                                                color="#0066cc"><b>欠税统计日期</b></font></td>
                                                    </tr>
                                                    <#list IndOweTaxByRptId as IndOweTaxByRptIdList>
                                                        <tr>  
                                                            <td class="tdStyle" width="6%" style="word-break : break-all; " align="center"><font
                                                                    color="#0066cc">${IndOweTaxByRptIdList.no}</font></td>
                                                            <td class="tdStyle" width="151" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndOweTaxByRptIdList.manager}</font></td>
                                                            <td class="tdStyle" width="156" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndOweTaxByRptIdList.amount}</font></td>
                                                            <td class="tdStyle" width="132" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndOweTaxByRptIdList.tax_date}</font></td>
                                                        </tr>
                                                    </#list>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
										<tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    					</tr> 
                        			</#if>
                        			<#assign rptId = RequestParameters["rptId"]?default("true")>
                        			<#assign IndPublicRecordCivilByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndPublicRecordCivilByRptId(rptId)/> 
                        			<#if (IndPublicRecordCivilByRptId?size>0)>     			           
                                        <tr height="30" valign="bottom">
                                            <td>
                                                <div class="high" align="center">
                                                    <font color="#0066cc"><span class="high"><strong><b>民事判决记录</b></strong></span></font>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="90%" align="center"
                                                       class="tableStyle">
                                                    <tbody>
                                                    <tr>
                                                        <td class="tdStyle" width="6%" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="6" align="center"><font color="#0066cc"><b>立案法院</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="6" align="center"><font color="#0066cc"><b>案由</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="4" align="center"><font color="#0066cc"><b>立案日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="4" align="center"><font color="#0066cc"><b>结案方式</b></font>
                                                        </td>
                                                    </tr>
                                                   <#list IndPublicRecordCivilByRptId as IndPublicRecordCivilByRptIdList> 
                                                        <tr>
                                                            <td class="tdStyle" width="6%" style="word-break : break-all; " align="center"><font 
                                                                    color="#0066cc">${IndPublicRecordCivilByRptIdList.no}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordCivilByRptIdList.organ}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordCivilByRptIdList.reason}</font></td>
                                                            <td class="tdStyle" colspan="4" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordCivilByRptIdList.init_date}</font></td>
                                                            <td class="tdStyle" colspan="4" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordCivilByRptIdList.type}</font></td>
                                                        </tr>
                                                    </#list>
                                                    <tr>
                                                        <td class="tdStyle" width="6%" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="8" align="center"><font
                                                                color="#0066cc"><b>判决/调解结果</b></font></td>
                                                        <td class="tdStyle" colspan="4" align="center"><font
                                                                color="#0066cc"><b>判决/调解生效日期</b></font></td>
                                                        <td class="tdStyle" colspan="4" align="center"><font color="#0066cc"><b>诉讼标的</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="4" align="center"><font
                                                                color="#0066cc"><b>诉讼标的金额</b></font></td>
                                                    </tr>
                                                    <#list IndPublicRecordCivilByRptId as IndPublicRecordCivilByRptIdList> 
                                                        <tr>
                                                            <td class="tdStyle" width="6%" style="word-break : break-all; " align="center"><font
                                                                    color="#0066cc">${IndPublicRecordCivilByRptIdList.no}</font></td>
                                                            <td class="tdStyle" colspan="8" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordCivilByRptIdList.result}</font></td>
                                                            <td class="tdStyle" colspan="4" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordCivilByRptIdList.end_date}</font></td>
                                                            <td class="tdStyle" colspan="4" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordCivilByRptIdList.subject_name}</font></td>
                                                            <td class="tdStyle" colspan="4" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordCivilByRptIdList.subject_amount}</font></td>
                                                        </tr>
                                                    </#list>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
										<tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    					</tr> 
                        			 </#if>
                        			 
                        			<#assign rptId = RequestParameters["rptId"]?default("true")>
                        			<#assign IndPublicRecordForceByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndPublicRecordForceByRptId(rptId)/> 
                        			<#if (IndPublicRecordForceByRptId?size>0)>                 
                                        <tr height="30" valign="bottom">
                                            <td>
                                                <div class="high" align="center">
                                                    <font color="#0066cc"><span class="high"><strong><b>强制执行记录</b></strong></span></font>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="90%" align="center"
                                                       class="tableStyle">
                                                    <tbody>
                                                    <tr>
                                                        <td class="tdStyle" width="6%" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="6" align="center"><font color="#0066cc"><b>立案法院</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="6" align="center"><font color="#0066cc"><b>案由</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="6" align="center"><font color="#0066cc"><b>立案日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="6" align="center"><font color="#0066cc"><b>结案方式</b></font>
                                                        </td>
                                                    </tr>
                                                   <#list IndPublicRecordForceByRptId as IndPublicRecordForceByRptIdList>
                                                        <tr>
                                                            <td class="tdStyle" width="6%" style="word-break : break-all; " align="center"><font
                                                                    color="#0066cc">${IndPublicRecordForceByRptIdList.no}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordForceByRptIdList.organ}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordForceByRptIdList.reason}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordForceByRptIdList.init_date}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordForceByRptIdList.type}</font></td>
                                                        </tr>
                                                    </#list>
                                                    <tr>
                                                        <td class="tdStyle" width="6%" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font color="#0066cc"><b>案件状态</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font color="#0066cc"><b>结案日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font
                                                                color="#0066cc"><b>申请执行标的</b></font></td>
                                                        <td class="tdStyle" colspan="6" align="center"><font
                                                                color="#0066cc"><b>申请执行标的价值</b></font></td>
                                                        <td class="tdStyle" colspan="3" align="center"><font
                                                                color="#0066cc"><b>申请执行标的</b></font></td>
                                                        <td class="tdStyle" colspan="6" align="center"><font
                                                                color="#0066cc"><b>已执行标的金额</b></font></td>
                                                    </tr>
                                                    <#list IndPublicRecordForceByRptId as IndPublicRecordForceByRptIdList>
                                                        <tr>
                                                            <td class="tdStyle" width="6%" style="word-break : break-all; " align="center"><font
                                                                    color="#0066cc">${IndPublicRecordForceByRptIdList.no}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordForceByRptIdList.status}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordForceByRptIdList.end_date}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordForceByRptIdList.subject_name}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordForceByRptIdList.subject_amount}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordForceByRptIdList.object_name}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordForceByRptIdList.object_amount}</font></td>
                                                        </tr>
                                                   </#list>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
										<tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    					</tr> 
                        			</#if>	
                        			
                        			<#assign rptId = RequestParameters["rptId"]?default("true")>
                        			<#assign IndPublicRecordAdminRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndPublicRecordAdminByRptId(rptId)/> 
                        			<#if (IndPublicRecordAdminRptId?size>0)>  						
                                        <tr height="30" valign="bottom">
                                            <td>
                                                <div class="high" align="center">
                                                    <font color="#0066cc"><span class="high"><strong><b>行政处罚记录</b></strong></span></font>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="90%" align="center"
                                                       class="tableStyle">
                                                    <tbody>
                                                    <tr>
                                                        <td class="tdStyle" width="6%" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font color="#0066cc"><b>处罚机构</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="6" align="center"><font color="#0066cc"><b>处罚内容</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="2" align="center"><font color="#0066cc"><b>处罚金额</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="2" align="center"><font color="#0066cc"><b>生效日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="2" align="center"><font color="#0066cc"><b>截止日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="2" align="center"><font
                                                                color="#0066cc"><b>行政复议结果</b></font>
                                                        </td>
                                                    </tr>
                                                    <#list IndPublicRecordAdminRptId as IndPublicRecordAdminRptIdList>
                                                        <tr> 
                                                            <td class="tdStyle" width="6%" style="word-break : break-all; " align="center"><font
                                                                    color="#0066cc">${IndPublicRecordAdminRptIdList.no}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordAdminRptIdList.organ}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordAdminRptIdList.reason}</font></td>
                                                            <td class="tdStyle" colspan="2" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordAdminRptIdList.subject_name}</font></td>
                                                            <td class="tdStyle" colspan="2" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordAdminRptIdList.init_date}</font></td>
                                                            <td class="tdStyle" colspan="2" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordAdminRptIdList.end_date}</font></td>
                                                            <td class="tdStyle" colspan="2" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndPublicRecordAdminRptIdList.result}</font></td>
                                                        </tr>
                                                    </#list>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
										<tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    					</tr> 
                        			</#if>
                        			<#assign rptId = RequestParameters["rptId"]?default("true")>
                        			<#assign IndHousefundDepositByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndHousefundDepositByRptId(rptId)/> 
                        			<#if (IndHousefundDepositByRptId?size>0)>  			         
                                        <tr height="30" valign="bottom">
                                            <td>
                                                <div class="high" align="center">
                                                    <font color="#0066cc"><span class="high"><strong><b>住房公积金参缴记录</b></strong></span></font>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="90%" align="center"
                                                       class="tableStyle">
                                                    <tbody>
                                                    <tr>
                                                        <td class="tdStyle" align="center" style="width: 6%;"><font color="#0066cc"><b>编号</b></font>
														</td>
                                                        <td class="tdStyle" colspan="5" align="center"><font color="#0066cc"><b>参缴地</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font color="#0066cc"><b>参缴日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="2" align="center"><font color="#0066cc"><b>初缴月份</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="2" align="center"><font color="#0066cc"><b>缴至月份</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font color="#0066cc"><b>缴费状态</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="2" align="center"><font color="#0066cc"><b>月缴存额</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font
                                                                color="#0066cc"><b>个人缴存比例</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font
                                                                color="#0066cc"><b>单位缴存比例</b></font>
                                                        </td>
                                                    </tr>
                                               <#list IndHousefundDepositByRptId as IndHousefundDepositByRptIdList>     
                                                        <tr>
                                                            <td class="tdStyle" style="width: 6%; word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndHousefundDepositByRptIdList.no}</font></td>
                                                            <td class="tdStyle" colspan="5" style="word-break : break-all; " align="center">
                                                                <font
                                                                    color="#0066cc">${IndHousefundDepositByRptIdList.city}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font  
                                                                    color="#0066cc">${IndHousefundDepositByRptIdList.init_date}</font></td>
                                                            <td class="tdStyle" colspan="2" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndHousefundDepositByRptIdList.first_month}</font></td>
                                                            <td class="tdStyle" colspan="2" style="word-break : break-all; " align="center">
                                                                <font
                                                                    color="#0066cc"> ${IndHousefundDepositByRptIdList.to_month}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font  
                                                                    color="#0066cc">${IndHousefundDepositByRptIdList.status}</font></td>
                                                            <td class="tdStyle" colspan="2" style="word-break : break-all; " align="center">
                                                                <font
                                                                    color="#0066cc"> ${IndHousefundDepositByRptIdList.monthly_amount}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font  
                                                                    color="#0066cc">${IndHousefundDepositByRptIdList.persent_per}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndHousefundDepositByRptIdList.percent_com}</font></td>
                                                        </tr>
                                                  </#list> 
                                                    <tr>
                                                        <td class="tdStyle" style="width: 6%;" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="17" align="center"><font color="#0066cc"><b>缴费单位</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="6" align="center"><font
                                                                color="#0066cc"><b>信息更新日期</b></font>
                                                        </td>
                                                    </tr>
                                                    <#list IndHousefundDepositByRptId as IndHousefundDepositByRptIdList>     
                                                        <tr>
                                                            <td class="tdStyle" style="width: 6%; word-break : break-all; " align="center">
                                                                <font
                                                                    color="#0066cc">${IndHousefundDepositByRptIdList.no}</font></td>
                                                            <td class="tdStyle" colspan="17" style="word-break : break-all; " align="center">
                                                                <font
                                                                    color="#0066cc">${IndHousefundDepositByRptIdList.organ}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndHousefundDepositByRptIdList.update_date}</font></td>
                                                        </tr>
                                                    </#list>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
										<tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    					</tr> 
                        			</#if>
                        			<#assign rptId = RequestParameters["rptId"]?default("true")>
                        			<#assign IndInsDepositByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndInsDepositByRptId(rptId)/> 
                        			<#if (IndInsDepositByRptId?size>0)>  			            
                                        <tr height="30" valign="bottom">
                                            <td>
                                                <div class="high" align="center">
                                                    <font color="#0066cc"><span class="high"><strong><b>养老保险金缴存记录</b></strong></span></font>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="90%" align="center"
                                                       class="tableStyle">
                                                    <tbody>
                                                    <tr>
                                                        <td class="tdStyle" style="width: 6%;" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="4" align="center"><font color="#0066cc"><b>参保地</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="4" align="center"><font color="#0066cc"><b>参保日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="5" align="center"><font
                                                                color="#0066cc"><b>累计缴费月数</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="5" align="center"><font
                                                                color="#0066cc"><b>参加工作月份</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="2" align="center"><font color="#0066cc"><b>缴费状态</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="5" align="center"><font
                                                                color="#0066cc"><b>个人缴费基数</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="2" align="center"><font
                                                                color="#0066cc"><b>本月缴费金额</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="6" align="center"><font
                                                                color="#0066cc"><b>信息更新日期</b></font>
                                                        </td>
                                                    </tr>
                        							<#list IndInsDepositByRptId as IndInsDepositByRptIdList>				
                                                        <tr>
                                                            <td class="tdStyle" style="width: 6%; word-break : break-all; " align="center">
                                                                <font
                                                                    color="#0066cc">${IndInsDepositByRptIdList.no}</font></td>
                                                            <td class="tdStyle" colspan="4" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsDepositByRptIdList.city}</font></td>
                                                            <td class="tdStyle" colspan="4" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsDepositByRptIdList.init_date}</font></td>
                                                            <td class="tdStyle" colspan="5" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsDepositByRptIdList.total_month}</font></td>
                                                            <td class="tdStyle" colspan="5" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsDepositByRptIdList.work_month}</font></td>
                                                            <td class="tdStyle" colspan="2" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsDepositByRptIdList.status}</font></td>
                                                            <td class="tdStyle" colspan="5" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsDepositByRptIdList.base_amount}</font></td>
                                                            <td class="tdStyle" colspan="2" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsDepositByRptIdList.deposit_amount}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsDepositByRptIdList.update_date}</font></td>
                                                        </tr>
                                           			</#list>        
                                                    <tr>
                                                        <td class="tdStyle" style="width: 6%;" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="23" align="center"><font color="#0066cc"><b>缴费单位</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="10" align="center"><font
                                                                color="#0066cc"><b>中断或终止缴费原因</b></font>
                                                        </td>
                                                    </tr>
                                                    
                                            		<#list IndInsDepositByRptId as IndInsDepositByRptIdList>	
                                                        <tr>
                                                            <td class="tdStyle" style="width: 6%; word-break : break-all; " align="center">
                                                                <font
                                                                    color="#0066cc">${IndInsDepositByRptIdList.no}</font></td>
                                                            <td class="tdStyle" colspan="23" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsDepositByRptIdList.organ}</font></td>
                                                            <td class="tdStyle" colspan="10" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsDepositByRptIdList.end_reason}</font></td>
                                                        </tr>
                                            		</#list> 
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
										<tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    					</tr>
                        			</#if>
                        			
                        			<#assign rptId = RequestParameters["rptId"]?default("true")>
                        			<#assign IndInsPaymentByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndInsPaymentByRptId(rptId)/> 
                        			<#if (IndInsPaymentByRptId?size>0)>              
                                        <tr height="30" valign="bottom">
                                            <td>
                                                <div class="high" align="center">
                                                    <font color="#0066cc"><span class="high"><strong><b>养老保险金发放记录</b></strong></span></font>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="90%" align="center"
                                                       class="tableStyle">
                                                    <tbody>
                                                    <tr>
                                                        <td class="tdStyle" style="width: 6%;" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="5" align="center"><font color="#0066cc"><b>发放地</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="4" align="center"><font color="#0066cc"><b>离退休类别</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="4" align="center"><font
                                                                color="#0066cc"><b>离退休月份</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="6" align="center"><font
                                                                color="#0066cc"><b>参加工作月份</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="4" align="center"><font
                                                                color="#0066cc"><b>本月实发养老金</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font
                                                                color="#0066cc"><b>停发原因</b></font>
                                                        </td>
                                                    </tr>
                                           			<#list IndInsPaymentByRptId as IndInsPaymentByRptIdList>         
                                                        <tr>
                                                            <td class="tdStyle" style="width: 6%; word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsPaymentByRptIdList.no}</font></td>
                                                            <td class="tdStyle" colspan="5" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsPaymentByRptIdList.city}</font></td>
                                                            <td class="tdStyle" colspan="4" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsPaymentByRptIdList.type}</font></td>
                                                            <td class="tdStyle" colspan="4" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsPaymentByRptIdList.retire_month}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsPaymentByRptIdList.work_month}</font></td>
                                                            <td class="tdStyle" colspan="4" style="word-break : break-all; " align="center">
                                                                <font
                                                                    color="#0066cc">${IndInsPaymentByRptIdList.pay_amount}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font  
                                                                    color="#0066cc">${IndInsPaymentByRptIdList.end_reason}</font></td>
                                                        </tr>
                                            		</#list>       
                                                    <tr>
                                                        <td class="tdStyle" style="width: 6%;" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="20" align="center"><font
                                                                color="#0066cc"><b>原单位名称</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="6" align="center"><font
                                                                color="#0066cc"><b>信息更新日期</b></font>
                                                        </td>
                                                    </tr>
                                           			<#list IndInsPaymentByRptId as IndInsPaymentByRptIdList>
                                                        <tr>
                                                            <td class="tdStyle" style="width: 6%; word-break : break-all; " align="center">
                                                                <font
                                                                    color="#0066cc">${IndInsPaymentByRptIdList.no}</font></td>
                                                            <td class="tdStyle" colspan="20" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsPaymentByRptIdList.organ}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndInsPaymentByRptIdList.update_date}</font></td>
                                                        </tr>
                                           			</#list> 
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
										<tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    					</tr>
                        			</#if>
                                    <#assign rptId = RequestParameters["rptId"]?default("true")>
                        			<#assign IndSuccouryByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndSuccourByRptId(rptId)/> 
                        			<#if (IndSuccouryByRptId?size>0)>  
                                        <tr height="30" valign="bottom">
                                            <td>
                                                <div class="high" align="center">
                                                    <font color="#0066cc"><span class="high"><strong><b>低保救助记录</b></strong></span></font>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="90%" align="center"
                                                       class="tableStyle">
                                                    <tbody>
                                                    <tr>
                                                        <td class="tdStyle" width="6%" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="10%" align="center"><font color="#0066cc"><b>人员类别</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="10%" align="center"><font color="#0066cc"><b>所在地</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="15%" align="center"><font color="#0066cc"><b>工作单位</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="13%" align="center"><font color="#0066cc"><b>家庭月收入</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="13%" align="center"><font color="#0066cc"><b>申请日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="13%" align="center"><font
                                                                color="#0066cc"><b>批准日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="14%" align="center"><font
                                                                color="#0066cc"><b>信息更新日期</b></font>
                                                        </td>
                                                    </tr>
                                              		<#list IndSuccouryByRptId as IndSuccouryByRptIdList>     
                                                        <tr>
                                                            <td class="tdStyle" width="6%" style="word-break : break-all; " align="center"><font 
                                                                    color="#0066cc">${IndSuccouryByRptIdList.no}</font></td>
                                                            <td class="tdStyle" width="10%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndSuccouryByRptIdList.type}</font></td>
                                                            <td class="tdStyle" width="10%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndSuccouryByRptIdList.city}</font></td>
                                                            <td class="tdStyle" width="15%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndSuccouryByRptIdList.organ}</font></td>
                                                            <td class="tdStyle" width="13%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndSuccouryByRptIdList.family_income}</font></td>
                                                            <td class="tdStyle" width="13%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndSuccouryByRptIdList.apply_date}</font></td>
                                                            <td class="tdStyle" width="13%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndSuccouryByRptIdList.issue_date}</font></td>
                                                            <td class="tdStyle" width="14%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndSuccouryByRptIdList.update_date}</font></td>
                                                        </tr>
                                              		</#list>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
										<tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    					</tr>
                        			</#if>
                        			<#assign rptId = RequestParameters["rptId"]?default("true")>
                        			<#assign IndAwardByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndAwardByRptId(rptId)/> 
                        			<#if (IndAwardByRptId?size>0)> 
                                        <tr height="30" valign="bottom">
                                            <td>
                                                <div class="high" align="center">
                                                    <font color="#0066cc"><span class="high"><strong><b>执业资格记录</b></strong></span></font>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="75%" align="center"
                                                       class="tableStyle">
                                                    <tbody>
                                                    <tr>
                                                        <td class="tdStyle" width="6%" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="15%" align="center"><font
                                                                color="#0066cc"><b>执业资格名称</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="15%" align="center"><font color="#0066cc"><b>等级</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="10%" align="center"><font color="#0066cc"><b>获得日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="10%" align="center"><font color="#0066cc"><b>到期日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="10%" align="center"><font color="#0066cc"><b>吊销日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="15%" align="center"><font
                                                                color="#0066cc"><b>颁发机构</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="19%" align="center"><font
                                                                color="#0066cc"><b>机构所在地</b></font>
                                                        </td>
                                                    </tr>
                                           			<#list IndAwardByRptId as IndAwardByRptIdList>
                                                        <tr> 
                                                            <td class="tdStyle" width="6%" style="word-break : break-all; " align="center"><font
                                                                    color="#0066cc">${IndAwardByRptIdList.no}</font></td>
                                                            <td class="tdStyle" width="15%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndAwardByRptIdList.name}</font></td>
                                                            <td class="tdStyle" width="15%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndAwardByRptIdList.level}</font></td>
                                                            <td class="tdStyle" width="10%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndAwardByRptIdList.init_date}</font></td>
                                                            <td class="tdStyle" width="10%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndAwardByRptIdList.expire_date}</font></td>
                                                            <td class="tdStyle" width="10%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndAwardByRptIdList.end_date}</font></td>
                                                            <td class="tdStyle" width="15%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndAwardByRptIdList.organ}</font></td>
                                                            <td class="tdStyle" width="19%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndAwardByRptIdList.city}</font></td>
                                             			</#list>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                        			<tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    				</tr>

                        			</#if>	
                                    <#assign rptId = RequestParameters["rptId"]?default("true")>
                        			<#assign IndAwardAdminAwardByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndAwardAdminAwardByRptId(rptId)/> 
                        			<#if (IndAwardAdminAwardByRptId?size>0)> 
                                        
                                        <tr height="30" valign="bottom">
                                            <td>
                                                <div class="high" align="center">
                                                    <font color="#0066cc"><span class="high"><strong><b>行政奖励记录</b></strong></span></font>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="90%" align="center"
                                                       class="tableStyle">
                                                    <tbody>
                                                    <tr>
                                                        <td class="tdStyle" width="10%" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="30%" align="center"><font
                                                                color="#0066cc"><b>奖励机构</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="30%" align="center"><font color="#0066cc"><b>奖励内容</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="15%" align="center"><font color="#0066cc"><b>生效日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="15%" align="center"><font color="#0066cc"><b>截止日期</b></font>
                                                        </td>
                                                    </tr>
                                              <#list IndAwardAdminAwardByRptId as IndAwardAdminAwardByRptIdList>
                                                        <tr>
                                                            <td class="tdStyle" width="10%" style="word-break : break-all; " align="center">
                                                                <font
                                                                    color="#0066cc">${IndAwardAdminAwardByRptIdList.no}</font></td>
                                                            <td class="tdStyle" width="30%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndAwardAdminAwardByRptIdList.organ}</font></td>
                                                            <td class="tdStyle" width="30%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndAwardAdminAwardByRptIdList.content}</font></td>
                                                            <td class="tdStyle" width="15%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndAwardAdminAwardByRptIdList.init_date}</font></td>
                                                            <td class="tdStyle" width="15%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndAwardAdminAwardByRptIdList.expire_date}</font></td>
                                                        </tr>
                                             </#list>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                        			<tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    				</tr>

                        			</#if>	
                        			<#assign rptId = RequestParameters["rptId"]?default("true")>
                        			<#assign IndCarTradeByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndCarTradeByRptId(rptId)/> 
                        			<#if (IndCarTradeByRptId?size>0)> 
                                        <tr height="30" valign="bottom">
                                            <td>
                                                <div class="high" align="center">
                                                    <font color="#0066cc"><span class="high"><strong><b>车辆交易和抵押记录</b></strong></span></font>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="90%" align="center"
                                                       class="tableStyle">
                                                    <tbody>
                                                    <tr>
                                                        <td class="tdStyle" width="6%" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="12%" align="center"><font
                                                                color="#0066cc"><b>车牌号码</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="20%" align="center"><font color="#0066cc"><b>发动机号</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="10%" align="center"><font color="#0066cc"><b>品牌</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="10%" align="center"><font color="#0066cc"><b>车辆类型</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="10%" align="center"><font color="#0066cc"><b>使用性质</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="10%" align="center"><font color="#0066cc"><b>车辆状态</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="10%" align="center"><font color="#0066cc"><b>抵押标记</b></font>
                                                        </td>
                                                        <td class="tdStyle" width="12%" align="center"><font
                                                                color="#0066cc"><b>信息更新日期</b></font>
                                                        </td>
                                                    </tr>
                                             <#list IndCarTradeByRptId as IndCarTradeByRptIdList>
                                                        <tr>
                                                            <td class="tdStyle" width="6%" style="word-break : break-all; " align="center">
                                                                <font
                                                                    color="#0066cc">${IndCarTradeByRptIdList.no}</font></td>
                                                            <td class="tdStyle" width="12%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndCarTradeByRptIdList.car_number}</font></td>
                                                            <td class="tdStyle" width="20%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndCarTradeByRptIdList.engine_number}</font></td>
                                                            <td class="tdStyle" width="10%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndCarTradeByRptIdList.brand}</font></td>
                                                            <td class="tdStyle" width="10%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndCarTradeByRptIdList.type}</font></td>
                                                            <td class="tdStyle" width="10%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndCarTradeByRptIdList.car_usage}</font></td>
                                                            <td class="tdStyle" width="10%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndCarTradeByRptIdList.status}</font></td>
                                                            <td class="tdStyle" width="10%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndCarTradeByRptIdList.pledged}</font></td>
                                                            <td class="tdStyle" width="12%" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndCarTradeByRptIdList.update_date}</font></td>
                                                        </tr>
                                              </#list>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                        			<tr align="center" valign="middle">
					                        <td height="24" colspan="3">
					                            <div align="center"><font color="#0066cc" size="2"><b><font
					                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
					                        </td>
                    				</tr>

                        			</#if>
                        			<#assign rptId = RequestParameters["rptId"]?default("true")>
                        			<#assign IndTelecomPaymentByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndTelecomPaymentByRptId(rptId)/> 
                        			<#if (IndTelecomPaymentByRptId?size>0)> 
                                        <tr height="30" valign="bottom">
                                            <td>
                                                <div class="high" align="center">
                                                    <font color="#0066cc"><span class="high"><strong><b>电信缴费记录</b></strong></span></font>
                                                </div>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="90%" align="center"
                                                       class="tableStyle">
                                                    <tbody>
                                                    <tr>
                                                        <td class="tdStyle" width="80" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font
                                                                color="#0066cc"><b>电信运营商</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="6" align="center"><font color="#0066cc"><b>业务类型</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font
                                                                color="#0066cc"><b>业务开通日期</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font
                                                                color="#0066cc"><b>当前缴费状态</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font
                                                                color="#0066cc"><b>当前欠费金额</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font
                                                                color="#0066cc"><b>当前欠费月数</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="3" align="center"><font color="#0066cc"><b>记账年月</b></font>
                                                        </td>
                                                    </tr>
                                              <#list IndTelecomPaymentByRptId as IndTelecomPaymentByRptIdList>
                                                        <tr>
                                                            <td class="tdStyle" width="80" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndTelecomPaymentByRptIdList.no}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndTelecomPaymentByRptIdList.organ}</font></td>
                                                            <td class="tdStyle" colspan="6" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndTelecomPaymentByRptIdList.type}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndTelecomPaymentByRptIdList.init_date}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndTelecomPaymentByRptIdList.status}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font
                                                                    color="#0066cc"> ${IndTelecomPaymentByRptIdList.owe_amount}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font  
                                                                    color="#0066cc">${IndTelecomPaymentByRptIdList.owe_month}</font></td>
                                                            <td class="tdStyle" colspan="3" style="word-break : break-all; " align="center">
                                                                <font 
                                                                    color="#0066cc">${IndTelecomPaymentByRptIdList.yearMonth}</font></td>
                                                        </tr>
                                              </#list>
                                                    <tr>
                                                        <td class="tdStyle" width="116" align="center"><font color="#0066cc"><b>编号</b></font>
                                                        </td>
                                                        <td class="tdStyle" colspan="24" align="center"><font
                                                                color="#0066cc"><b>最近24个月缴费记录</b></font>
                                                        </td>
                                                    </tr>
                                             <#list IndTelecomPaymentByRptId as IndTelecomPaymentByRptIdList>
                                                        <tr>
                                                            <td class="tdStyle" width="116" style="word-break : break-all; " align="center">
                                                                <font
                                                                    color="#0066cc">${IndTelecomPaymentByRptIdList.no}</font></td>
                                                            <#assign no=IndTelecomPaymentByRptIdList.no/>
                                                            <#assign Telelists24 = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndTelecomPaymentByRptId24(rptId,no)/>        
                                                             <#list Telelists24 as listss>
		                                                        <td class="tdStyle" width="37">
		                                                            <div class="high" align="center"><font color="#0066cc"><span
		                                                                        class="high">
		            															${listss.month24value}</span></font></div>
		                                                        </td>
		                                                     </#list>       										
                                                                
                        												
                                                        </tr>
                                          </#list>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
										<tr align="center" valign="middle">
						                        <td height="24" colspan="3">
						                            <div align="center"><font color="#0066cc" size="2"><b><font
						                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
						                        </td>
	                    				</tr>
                        				</#if>
                        <#else>

                        </#if>					<#assign rptId = RequestParameters["rptId"]?default("true")>
                		<#assign IndStatementByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndStatementByRptId(rptId)/> 
                		<#if (IndStatementByRptId?size>0)>
                						<tr style="line-height: 15px">
                							<td><div style="height: 20px"></div></td>
                						</tr>
                						<tr height="40">
                							<td align="center" valign="middle"><font color="#0066cc"
                																	 style="font-size: 14px"><b>
                										本人声明</b></font></td>
                						</tr>
                						<tr>
                							<td>
                								<table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="90%" align="center"
                									   class="tableStyle">
                									<tbody>
                									<tr>
                										<td class="tdStyle" width="15%" align="center"><font color="#0066cc"><b>编号</b></font>
                										</td>
                										<td class="tdStyle" width="70%" align="center"><font
                												color="#0066cc"><b>声明内容</b></font>
                										</td>
                										<td class="tdStyle" width="15%" align="center"><font color="#0066cc"><b>添加日期</b></font>
                										</td>
                									</tr>
                									<#list IndStatementByRptId as IndStatementByRptIdListStatement>
                										<tr>
                											<td class="tdStyle" width="21" style="word-break : break-all; " align="center">
                												<font
                													color="#0066cc">${IndStatementByRptIdListStatement.noStatement}</font></td>
                											<td class="tdStyle" width="21" style="word-break : break-all; " align="center">
                												<font 
                													color="#0066cc">${IndStatementByRptIdListStatement.contentStatement}</font></td>
                											<td class="tdStyle" width="21" style="word-break : break-all; " align="center">
                												<font 
                													color="#0066cc">${IndStatementByRptIdListStatement.init_dateStatement}</font></td>
                										</tr>
                									</#list>
                									</tbody>
                								</table>
                							</td>
                						</tr>
                						<tr align="center" valign="middle">
						                        <td height="24" colspan="3">
						                            <div align="center"><font color="#0066cc" size="2"><b><font
						                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
						                        </td>
	                    				</tr>						
                				</#if>
								<#assign IndStatementDissentByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndStatementDissentByRptId(rptId)/> 
								<#if (IndStatementDissentByRptId?size>0)>
                						<tr style="line-height: 15px">
                							<td><div style="height: 20px"></div></td>
                						</tr>
                						<tr height="40">
                							<td align="center" valign="middle"><font color="#0066cc"
                																	 style="font-size: 14px"><b>
                										异议标注</b></font></td>
                						</tr>
                						<tr>
                							<td>
                								<table cellspacing="0" cellpadding="2" style="table-layout:fixed;" width="90%" align="center"
                									   class="tableStyle">
                									<tbody>
                									<tr>
                										<td class="tdStyle" width="15%" align="center"><font color="#0066cc"><b>编号</b></font>
                										</td>
                										<td class="tdStyle" width="70%" align="center"><font
                												color="#0066cc"><b>声明内容</b></font>
                										</td>
                										<td class="tdStyle" width="15%" align="center"><font color="#0066cc"><b>添加日期</b></font>
                										</td>
                									</tr>
                								<#list IndStatementDissentByRptId as IndStatementByRptIdListDissent>
                										<tr>
                											<td class="tdStyle" width="21" style="word-break : break-all; " align="center">
                												<font
                													color="#0066cc">${IndStatementByRptIdListDissent.noDissent}</font></td>
                											<td class="tdStyle" width="21" style="word-break : break-all; " align="center">
                												<font 
                													color="#0066cc">${IndStatementByRptIdListDissent.contentDissent}</font></td>
                											<td class="tdStyle" width="21" style="word-break : break-all; " align="center">
                												<font 
                													color="#0066cc">${IndStatementByRptIdListDissent.init_dateDissent}</font></td>
                										</tr>
                								</#list>
                									</tbody>
                								</table>
                							</td>
                						</tr>
       									<tr align="center" valign="middle">
						                        <td height="24" colspan="3">
						                            <div align="center"><font color="#0066cc" size="2"><b><font
						                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
						                        </td>
	                    				</tr>
                		
							</#if>	

                        <tr style="line-height: 15px">
                            <td><div style="height: 20px"></div></td>
                        </tr>
                        <tr height="40">
                            <td align="center" valign="middle"><font color="#0066cc"
                                                                     style="font-size: 14px"><b><?php
                                        echo $seqToCn [$seqMain++] ?>
                                        查询记录</b></font></td>
                        </tr>
                		<#assign rptId = RequestParameters["rptId"]?default("true")>
                		<#assign IndEnquirySummaryByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndEnquirySummaryByRptId(rptId)/> 
                		<#if (IndEnquirySummaryByRptId?size>0)>        
                            <tr>
                                <td align="center" valign="middle"><span class="high"><font
                                            color="#0066cc"><b>查询记录汇总</b></font></span></td>
                            </tr>
                            <tr>
                                <td>
                                    <div align="center">
                                        <table cellspacing="0" cellpadding="2" width="75%" align="center"
                                               class="tableStyle">
                                            <tbody>
                                            <tr>
                                                <td class="tdStyle" colspan="4">
                                                    <div class="high" align="center"><b><font color="#0066cc"><span
                                                                    class="high">最近1个月内的查询机构数</span></font></b></div>
                                                </td>
                                                <td class="tdStyle" colspan="6">
                                                    <div class="high" align="center"><b><font color="#0066cc"><span
                                                                    class="high">最近1个月内的查询次数</span></font></b></div>
                                                </td>
                                                <td class="tdStyle" colspan="4">
                                                    <div class="high" align="center"><b><font color="#0066cc"><span
                                                                    class="high">最近2年内的查询次数</span></font></b></div>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td class="tdStyle" colspan="2">
                                                    <div class="high" align="center"><b><font color="#0066cc">贷款审批</font></b></div>
                                                </td>
                                                <td class="tdStyle" colspan="2">
                                                    <div class="high" align="center"><b><font color="#0066cc">信用卡审批</font></b></div>
                                                </td>
                                                <td class="tdStyle" colspan="2">
                                                    <div class="high" align="center"><b><font color="#0066cc">贷款审批</font></b></div>
                                                </td>
                                                <td class="tdStyle" colspan="2">
                                                    <div class="high" align="center"><b><font color="#0066cc">信用卡审批</font></b></div>
                                                </td>
                                                <td class="tdStyle" colspan="2">
                                                    <div class="high" align="center"><b><font color="#0066cc">本人查询</font></b></div>
                                                </td>
                                                <td class="tdStyle" colspan="1">
                                                    <div class="high" align="center"><b><font color="#0066cc">贷后管理</font></b></div>
                                                </td>
                                                <td class="tdStyle" colspan="1">
                                                    <div class="high" align="center"><b><font color="#0066cc">担保资格审查</font></b></div>
                                                </td>
                                                <td class="tdStyle" colspan="2">
                                                    <div class="high" align="center"><b><font color="#0066cc">特约商户实名审查</font></b></div>
                                                </td>
                                            </tr>
                				  <#list IndEnquirySummaryByRptId as IndEnquirySummaryByRptIdList>
                                            <tr>
                                                <td class="tdStyle" colspan="2">
                                                    <div class="high" align="center"><font color="#0066cc"><span 
                                                                class="high">${IndEnquirySummaryByRptIdList.loan_approve_org_l1m}
                                                                </span></font></div>
                                                </td>
                                                <td class="tdStyle" colspan="2"> 
                                                    <div class="high" align="center"><font color="#0066cc"><span
                                                                class="high">${IndEnquirySummaryByRptIdList.cc_approve_org_l1m}
                                                                </span></font></div>
                                                </td>
                                                <td class="tdStyle" colspan="2">
                                                    <div class="high" align="center"><font color="#0066cc"><span 
                                                                class="high">${IndEnquirySummaryByRptIdList.loan_approve_l1m}
                                                                </span></font></div>
                                                </td>
                                                <td class="tdStyle" colspan="2">
                                                    <div class="high" align="center"><font color="#0066cc"><span 
                                                                class="high">${IndEnquirySummaryByRptIdList.cc_approve_l1m}</span></font>
                                                    </div>
                                                </td>
                                                <td class="tdStyle" colspan="2">
                                                    <div class="high" align="center"><font color="#0066cc"><span 
                                                                class="high">${IndEnquirySummaryByRptIdList.self_l1m}
                                                                </span></font>
                                                    </div>
                                                </td>
                                                <td class="tdStyle" colspan="1">
                                                    <div class="high" align="center"><font color="#0066cc"><span 
                                                                class="high">${IndEnquirySummaryByRptIdList.loan_manage_l2y}
                                                                </span></font></div>
                                                </td>
                                                <td class="tdStyle" colspan="1">
                                                    <div class="high" align="center"><font color="#0066cc"><span 
                                                                class="high">${IndEnquirySummaryByRptIdList.assurance_check_l2y}
                                                                </span></font></div>
                                                </td>
                                                <td class="tdStyle" colspan="2">
                                                    <div class="high" align="center"><font color="#0066cc"><span 
                                                                class="high">${IndEnquirySummaryByRptIdList.real_name_check_l2y}
                                                                </span></font></div>
                                                </td>
                                            </tr>
                					 </#list>				
                                            </tbody>
                                        </table>
                                    </div>
                                </td>
                            </tr>
							<tr align="center" valign="middle">
						                        <td height="24" colspan="3">
						                            <div align="center"><font color="#0066cc" size="2"><b><font
						                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
						                        </td>
	                    	</tr>                					
                		    </#if>			
                		<#assign rptId = RequestParameters["rptId"]?default("true")>
                		<#assign IndEnquiryByRptId = statics["com.huateng.ebank.business.customer.getter.PersonInfoTotalQueryGetter"].getIndEnquiryByRptId(rptId)/> 
                		<#if (IndEnquiryByRptId?size>0)>	        
                            <tr height="30" valign="bottom">
                                <td>
                                    <div class="high" align="center"><font color="#0066cc"><span
                                                class="high"><b>信贷审批查询记录明细</b></span></font></div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div align="center">
                                        <table cellspacing="0" cellpadding="2" width="75%" align="center"
                                               class="tableStyle" border="1">
                                            <tbody>
                                            <tr>
                                                <td class="tdStyle" width="6%">
                                                    <div class="high" align="center"><b><font color="#0066cc">编号</font></b></div>
                                                </td>
                                                <td class="tdStyle" width="32%">
                                                    <div class="high" align="center"><b><font color="#0066cc">查询日期</font></b></div>
                                                </td>
                                                <td class="tdStyle" width="32%">
                                                    <div class="high" align="center"><b><font color="#0066cc">查询操作员</font></b></div>
                                                </td>
                                                <td class="tdStyle" width="30%">
                                                    <div class="high" align="center"><b><font color="#0066cc">查询原因</font></b></div>
                                                </td>
                                            </tr>
                                         <#list IndEnquiryByRptId as IndEnquiryByRptIdList> 
                                                <tr>
                                                    <td class="tdStyle" width="6%" style="word-break: break-all"> 
                                                        <div class="high" align="center"><font color="#0066cc">${IndEnquiryByRptIdList.no}
                                                                </font>
                                                        </div>
                                                    </td>
                                                    <td class="tdStyle" width="32%" style="word-break: break-all">
                                                        <div class="high" align="center"><font 
                                                                color="#0066cc">${IndEnquiryByRptIdList.Enq_date}</font>
                                                        </div>
                                                    </td>

                                                    <td class="tdStyle" width="32%" style="word-break: break-all">
                                                        <div class="high" align="center"><font 
                                                                color="#0066cc">${IndEnquiryByRptIdList.enquirer}</font></div>
                                                    </td>
                                                    <td class="tdStyle" width="30%" style="word-break: break-all"> 
                                                        <div class="high" align="center"><font color="#0066cc">${IndEnquiryByRptIdList.reason}
                                                                </font></div>
                                                    </td>
                                                </tr>
                                         </#list>
                                            </tbody>
                                        </table>
                                    </div>
                                </td>
                            </tr>
							<tr align="center" valign="middle">
						                        <td height="24" colspan="3">
						                            <div align="center"><font color="#0066cc" size="2"><b><font
						                                            face="黑体">当前用户为：${tlrno}</font></b></font></div>
						                        </td>
	                    	</tr>                					
                		 </#if>	       
                        <tr style="line-height: 80px">
                            <td><div style="height: 20px"></div></td>
                        </tr>
                        
                    </table>
                    
                    	
				
                
	
</CENTER>
<div  align="center" >
				<input type="button" name="close" style="margin-top:80px;background-color:#d6e5f8"  value="关闭" onclick="goback()" />
				<input type="button" name="printhtml" value="打印" style="margin-top:80px;background-color:#d6e5f8"  onclick="printme()" />
     </div>           
			
</BODY>

</HTML>