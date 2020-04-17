<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="消息发送日志查询-明细">
<table align="left">
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="MsgLogQry" init="true" submitMode="all" navigate="false" insertOnEmpty="false">
			<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
			 <table width="100%" >
			 	<tr>
			      	<td  align="left">
<@CommonQueryMacro.Group id="group1" label="消息发送日志查询-明细"  fieldStr="bId,aId,msgId,msgName,oppId,userName,brno,type,subType,createdDate1,msgSysId,source,sendDate1,status,msgLogHead,msgLog" colNm=2 /></br>							
			        </td>
			    </tr>			   
			</table>
			</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
      	<td colspan="2">
      		<@CommonQueryMacro.Button id= "btBack"/>
  		</td>
  	</tr>
</table>
<script language="JavaScript">
	function initCallGetter_pre(){
		MsgLogQry_dataset.setParameter("pageType","detailPage");
	}
	function btBack_onClick(button) {
		 closeWin();
	}
</script>
</@CommonQueryMacro.page>