<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<#assign v_type = RequestParameters["type"]?default("")>
<@CommonQueryMacro.page title="接收用户组维护">
<table width="100%" >
 	<tr>
      	<td>
			<@CommonQueryMacro.CommonQuery id="CpgGroupInfTmp" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
			<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
			 <table width="100%" >
			 	<tr>
			      	<td  align="left">
						<@CommonQueryMacro.Group id="group1" label="接收用户组"  fieldStr="groupId,groupName[200]" colNm=1 /></br>
			        </td>
			    </tr>			   
			</table>
			</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
       	</td>
    </tr>
	<tr>
		<td width="100%">
			<@CommonQueryMacro.CommonQuery id="CpgUsrInf" init="true" submitMode="selected" navigate="false"  >
				<table width="100%" align="left" cellpadding="2">
					<tr>
						<td width="75%">
							<@CommonQueryMacro.GroupBox id="guoup10" label="接收对象列表" expand="true">
		      					<table  width="100%">
									<tr>
										<td>
											<@CommonQueryMacro.DataTable id ="stock" fieldStr="select,userId,userName[200]" width="100%" hasFrame="true"  readonly="false"/>
										</td>
									</tr>
								</table>
							</@CommonQueryMacro.GroupBox>
						</td>
					</tr>
				</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
	<tr>
		<td align="center">
			<@CommonQueryMacro.CommonQuery id="CpgGroupInfTmp" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
			<table align="center">
				<tr>
					<td colspan="2" align="center">
					<@CommonQueryMacro.Button id= "btBack"/>
					</td>
				</tr>
			</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="javascript">
	function initCallGetter_pre(){
		CpgUsrInf_dataset.setParameter("pageType","groupTmpDtlPage");
	}
	function initCallGetter_post(dataset) {
     	CpgGroupInfTmp_dataset.setAllFieldsReadOnly(true);
     	CpgUsrInf_dataset.setAllFieldsReadOnly(true);
	}
    var type = "${v_type}";
    function initCallGetter_post(dataset) {
    	if(type=='detail'||type=='delete'){
    	    CpgGroupInfTmp_dataset.setReadOnly(true);
            CpgUsrInf_dataset.setAllFieldsReadOnly(true);
    	}
    	else{
    		CpgGroupInfTmp_dataset.setReadOnly(false);
            CpgUsrInf_dataset.setAllFieldsReadOnly(false);
    	}

	}
	function btBack_onClick(button) {
		 closeWin();
	}
	
</script>
</@CommonQueryMacro.page>

