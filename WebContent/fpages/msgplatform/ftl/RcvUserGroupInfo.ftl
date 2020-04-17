<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<#assign v_type = RequestParameters["type"]?default("")>
<@CommonQueryMacro.page title="接收用户组维护">
<#-- <table width="100%" > -->
<table width="700" >
 	<tr>
      	<td>
			<@CommonQueryMacro.CommonQuery id="CpgGroupInf" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
			<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
			 <table width="100%" >
			 	<tr>
			      	<td  align="left">
						<@CommonQueryMacro.Group id="group1" label="接收用户组"  fieldStr="groupId,groupName[200]" colNm=4 /></br>
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
											<@CommonQueryMacro.DataTable id ="stock" fieldStr="select,userId[200],userName[400]" width="100%" hasFrame="true" height="300" readonly="false"/>
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
		<@CommonQueryMacro.CommonQuery id="CpgGroupInf" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
			<table align="center">
				<tr>
		     		<td colspan="2" align="center">
		     		<#if (v_type=="addNewGroup") || (v_type=="update")>
		        		<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
		            </#if>
		            <#if v_type=="delete">
		            	<@CommonQueryMacro.Button id= "btDel"/>&nbsp;&nbsp;
	   				</#if>
	   					<@CommonQueryMacro.Button id= "btBack"/>
					</td>
				</tr>
				<tr style="display:none">
			      	<td  align="left">
						<@CommonQueryMacro.Group id="group1" label="接收用户组"  fieldStr="groupId,groupName[200]" colNm=8 /></br>
			        </td>
			    </tr>
			</table>
		</td>
		</@CommonQueryMacro.CommonQuery>
	</tr>
</table>
<script language="javascript">
	function initCallGetter_pre(){
		CpgUsrInf_dataset.setParameter("pageType","groupDtlPage");
	}
	
    var type = "${v_type}";
    function initCallGetter_post(dataset) {
    	if(type=='detail'||type=='delete'){
    	    CpgGroupInf_dataset.setReadOnly(true);
            CpgUsrInf_dataset.setAllFieldsReadOnly(true);
    	}
    	else if(type=='update'||type=="addNewGroup"){
    		if(type=='update'){
    	  		CpgGroupInf_dataset.setAllFieldsReadOnly(true);
            }else{
    			CpgGroupInf_dataset.setAllFieldsReadOnly(false);
    		}
    		CpgGroupInf_dataset.setFieldReadOnly("roleGroup",false);
    		CpgUsrInf_dataset.setFieldReadOnly("select",false);
            CpgUsrInf_dataset.setFieldReadOnly("userId",true);
            CpgUsrInf_dataset.setFieldReadOnly("userName",true);
    	}

	}
	function roleGroup_DropDown_onSelect(dropdown, record, editor) {
		var v_roleGroup;
		if(record != null){
			v_roleGroup  = record.getValue('data');
		}else{
			v_roleGroup = null;
		}
    	
	    CpgUsrInf_dataset.setParameter("qroleGroup",v_roleGroup);
	    CpgUsrInf_dataset.flushData(1);
	    return true;
    }
	function btBack_onClick(button) {
		 closeWin();
	}
    function btSave_postSubmit(button){
    	alert("提交成功！");
    	closeWin(true);
	}
	function btDel_postSubmit(button){
		alert("提交成功！");
		closeWin(true);
	}
	
</script>
</@CommonQueryMacro.page>

