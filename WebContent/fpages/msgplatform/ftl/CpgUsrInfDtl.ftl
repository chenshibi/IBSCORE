<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<#assign v_type = RequestParameters["type"]?default("")>
<@CommonQueryMacro.page title="接收用户维护">
<table width="100%">
 	<tr>
      	<td colspan="2">
			<@CommonQueryMacro.CommonQuery id="CpgUsrInf" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
			<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
			 <table width="100%" >
			 	<tr>
			      	<td  align="left">
							<@CommonQueryMacro.Group id="group1" label="接收用户维护"  fieldStr="userId,userName" colNm=1 /></br>
			        </td>
			    </tr>			   
			</table>
			</@CommonQueryMacro.GroupBox>
			</@CommonQueryMacro.CommonQuery>
       	</td>
    </tr>
    <tr>
      	<td valign="top" >
			<@CommonQueryMacro.CommonQuery id="CpgUsrInfBctl" init="true" submitMode="all" navigate="false" insertOnEmpty="true" >
			<!--
			<@CommonQueryMacro.GroupBox id="guoup2" label="可选内部机构列表" expand="true">
			 <table width="100%" >
			 	<tr>
			      	<td  align="left">
						<@CommonQueryMacro.DataTable id ="branch" fieldStr="select,brno,brname[250]" width="100%" hasFrame="true" height="300" readonly="false"/>
			        </td>
			    </tr>			   
			</table>
			</@CommonQueryMacro.GroupBox>
			-->
			</@CommonQueryMacro.CommonQuery>
       	</td>
       	<td valign="top" >
       		<@CommonQueryMacro.CommonQuery id="CpgMsgUsr" init="true" submitMode="all" navigate="false"  >
			<@CommonQueryMacro.GroupBox id="guoup10" label="接收方式列表" expand="true" >
			 <table width="100%" >
			 	<tr>
			      	<td  align="left">
						<#if (v_type=="new") || (v_type=="update")>
							<@CommonQueryMacro.DataTable id ="usrMsg" paginationbar="companyBtNew,companyBtDel" fieldStr="sendType,rcvInf[200]" width="100%" hasFrame="true" height="300" readonly="false"/>
						</#if>
						<#if (v_type=="delete") || (v_type=="detail")>
							<@CommonQueryMacro.DataTable id ="usrMsg1" fieldStr="sendType,rcvInf[250]" width="100%" hasFrame="true" height="300" readonly="false"/>
						</#if>
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
    		<#if (v_type=="new") || (v_type=="update")>
				<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
			</#if>
			<#if v_type=="delete">
				<@CommonQueryMacro.Button id= "btDel"/>&nbsp;&nbsp;
			</#if>
				<@CommonQueryMacro.Button id= "btBack"/>
    	</td>
    </tr>
</@CommonQueryMacro.CommonQuery>
</table>
<script language="javascript">
     var type = "${v_type}";
     function initCallGetter_post(dataset) {
    	if(type=='detail'||type=='delete'){
    	    CpgUsrInf_dataset.setAllFieldsReadOnly(true);
    	    CpgUsrInfBctl_dataset.setAllFieldsReadOnly(true);
            CpgMsgUsr_dataset.setAllFieldsReadOnly(true);
    	}else if(type=='new'||type=='update'){
    		if(type=='new'){
    			CpgUsrInf_dataset.setAllFieldsReadOnly(false);
    		}else{
    			CpgUsrInf_dataset.setAllFieldsReadOnly(true);
    		}
            CpgMsgUsr_dataset.setAllFieldsReadOnly(false);
            //branch list
            CpgUsrInfBctl_dataset.setFieldReadOnly("select",false);
            CpgUsrInfBctl_dataset.setFieldReadOnly("brno",true);
            CpgUsrInfBctl_dataset.setFieldReadOnly("brname",true);
    	}
	}
	function btBack_onClick(button) {
		 closeWin();
	}
    function btSave_postSubmit(button){
    	alert("提交成功！");
    	closeWin();
	}
	function btDel_postSubmit(button){
		alert("提交成功！");
    	closeWin();
	}
	
</script>
</@CommonQueryMacro.page>

