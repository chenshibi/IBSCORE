<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />
<input type="hidden"  name="openertext" id="feedBackTxt"  value="" size="30" >
<@CommonQueryMacro.page title="黑名单个人单笔插入">
<@CommonQueryMacro.CommonQuery id="BlackListIndivAdd" init="false" submitMode="current">
<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
	<table  width="80%">
	<tr>
		<td  align="left">
			<@CommonQueryMacro.Group id="group1" label="请输入查询条件"  fieldStr="custId,idType,nameChn,nameEng,dataSource,product,rm,loanNo,appNo,reason1,reason2,reason3,status,guaranShare,dateBirth,dateApp,dateInput,homeAddr1,homeAddr2,officePhone1,officePhone2,homePhone1,homePhone2,mobilePhone1,mobilePhone2,recovStatus,compName,compRegId,compId,compEng" colNm=1 /></br>
		</td>
	</tr>
	</table>
	
		<table width="100%"  >
			 	<tr>
    		<td  align="center">
				<@CommonQueryMacro.Button id= "btInsert"/>
    		</td>
    	</tr>	
			</table>
</@CommonQueryMacro.GroupBox>	
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
		
</script>
</@CommonQueryMacro.page>
