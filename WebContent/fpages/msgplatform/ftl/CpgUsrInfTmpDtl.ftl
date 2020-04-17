<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<#assign v_type = RequestParameters["type"]?default("")>
<@CommonQueryMacro.page title="接收用户维护审核 - 明细">
<table width="100%">
 	<tr>
      	<td colspan="2">
			<@CommonQueryMacro.CommonQuery id="CpgUsrInfTmp" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
			<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
			 <table width="100%" >
			 	<tr>
			      	<td  align="left">
							<@CommonQueryMacro.Group id="group1" label="接收用户维护审核 - 明细"  fieldStr="optType,userType,userId,userName,creator1,createdDate1[150]" colNm=4 /></br>
			        </td>
			    </tr>			   
			</table>
			</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
       	</td>
    </tr>
    <tr>
       	<td valign="top" width="50%">
       		<@CommonQueryMacro.CommonQuery id="CpgMsgUsrTmp" init="true" submitMode="all" navigate="false"  >
			<@CommonQueryMacro.GroupBox id="guoup10" label="接收方式列表" expand="true">
			 <table width="100%" >
			 	<tr>
			      	<td  align="left">
						<@CommonQueryMacro.DataTable id ="usrMsg" fieldStr="sendType,rcvInf[250]" width="100%" hasFrame="true" height="300" readonly="false"/>
			        </td>
			    </tr>			   
			</table>
			</@CommonQueryMacro.GroupBox>
			<#-- </@CommonQueryMacro.CommonQuery> -->
       	</td>
    </tr>
    <tr><td>&nbsp;</td></tr>
    <tr>
    	<td colspan="2" align="center">
    		<@CommonQueryMacro.Button id= "btBack"/>
    	</td>
    </tr>
</@CommonQueryMacro.CommonQuery>
</table>
<script language="javascript">
     var type = "${v_type}";
     function initCallGetter_post(dataset) {
    	//if(type=='detail'||type=='delete'){
    	if(true){
    	    CpgUsrInfTmp_dataset.setAllFieldsReadOnly(true);
            CpgMsgUsrTmp_dataset.setAllFieldsReadOnly(true);
    	}
    	else{
    		CpgUsrInfTmp_dataset.setAllFieldsReadOnly(true);
            CpgMsgUsrTmp_dataset.setAllFieldsReadOnly(true);
    	}

	}
	function btBack_onClick(button) {
		 closeWin();
	}
	
</script>
</@CommonQueryMacro.page>

