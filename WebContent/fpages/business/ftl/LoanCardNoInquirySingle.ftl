<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="贷款卡卡号(中证码)查询请求">
<@CommonQueryMacro.CommonQuery id="LoanCardNoInquiry" init="false" submitMode="all" navigate="false" insertOnEmpty="true">
<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
	<table  width="100%">
    	<tr>
			<td  align="left">
				<@CommonQueryMacro.Group id="group1" label="贷款卡卡号(中证码)查询请求"  fieldStr="inquiryType,inquiryValue,queryReason" colNm=2 /></br>
			</td>
		</tr>
		<tr>
    		<td  align="center">
				<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;  
    		</td>
    	</tr>
	</table>
</@CommonQueryMacro.GroupBox>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	  
   
    function btSave_postSubmit(button){
   		alert("提交成功！");
	}
</script>
</@CommonQueryMacro.page>
