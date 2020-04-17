<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign op=RequestParameters["op"]?default("")>
<@CommonQueryMacro.page title="操作员角色管理">
<table align="left" width="100%">
    <tr align="center">
        <td width="100%" colspan="6">
            <@CommonQueryMacro.CommonQuery id="operMngMod" init="true" navigate="false" submitMode="all" >
                <FIELDSET name='guoup1' style="padding: 6px;">
                    <LEGEND extra="groupboxtitle">Please enter the query condition</LEGEND>
                    <table frame=void class="grouptable" width="100%">
                        <tr>
                            <td align="center" nowrap class="labeltd" width="15%"> User NO</td>
                            <td class="datatd" width="35%"><@CommonQueryMacro.SingleField fId="tlrno"/></td>
                            <td align="center" nowrap class="labeltd" width="15%"> User Name</td>
                            <td class="datatd" width="35%"><@CommonQueryMacro.SingleField fId="tlrName" /></td>
                        </tr> 
                         <tr>
                            <td align="center" nowrap class="labeltd" width="15%">City</td>  
                            <td class="datatd" width="35%"><@CommonQueryMacro.SingleField fId="city" /></td>
                            <td align="center" nowrap class="labeltd" width="15%"> Region</td>
                            <td class="datatd" width="35%"><@CommonQueryMacro.SingleField fId="region" /></td>
                        </tr>
                         <tr>
                            <td align="center" nowrap class="labeltd" width="15%">Department</td>  
                            <td class="datatd" width="35%"><@CommonQueryMacro.SingleField fId="department" /></td>
                        </tr>
                      	
                        
                    </table>
                </FIELDSET>
            </@CommonQueryMacro.CommonQuery>
        </td>
    </tr>

    <tr >
        <td width="45%" valign="top">
            <@CommonQueryMacro.CommonQuery id="operMngRoleInfoSel" init="true" submitMode="selected" navigate="false">
                <table width="100%">
                    <tr>
                        <td width="100%">

                            <FIELDSET name='guoup3' style="padding: 6px;">
                                <LEGEND extra="groupboxtitle">Optional Role Information</LEGEND>
                                <table frame=void width="100%">
                                    <tr>
                                        <td valign="top">
                                            <@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="roleId[160],roleName[420]" height="350" width="100%" readonly="false" pagination="false"/>
                                        </td>
                                    </tr>
                                </table>
                            </FIELDSET>
                        </td>
                    </tr>
                </table>
            </@CommonQueryMacro.CommonQuery>
        </td>
        <td width="10%" valign="top">
        <@CommonQueryMacro.CommonQuery id="operMngRoleInfo" init="true" submitMode="all" navigate="false">
        <table  width="100%">
                        <tr>
                           <td align="center">
                            <br/>
                            <@CommonQueryMacro.Button id= "btadd" />
                        </td>
                        </tr> 
                         <tr>
                           <td align="center">
                            <br/>
                            <@CommonQueryMacro.Button id= "btremove" />
                        </td>
                        </tr> 
                    </table>
        </@CommonQueryMacro.CommonQuery>
        </td>
        <td width="45%" valign="top">
            <@CommonQueryMacro.CommonQuery id="operMngRoleInfo" init="true" submitMode="all" navigate="false">
                <table width="100%">
                    <tr>
                        <td width="100%">

                            <FIELDSET name='guoup3' style="padding: 6px;">
                                <LEGEND extra="groupboxtitle">Selected Role Information</LEGEND>
                                <table frame=void width="100%">
                                    <tr>
                                        <td valign="top">
                                            <@CommonQueryMacro.DataTable id ="datatable2"  fieldStr="roleId[160],roleName[420]" height="350" width="100%" readonly="false" pagination="false"/>
                                        </td>
                                    </tr>
                                </table>
                            </FIELDSET>
                        </td>
                    </tr>
                </table>
            </@CommonQueryMacro.CommonQuery>
        </td>
    </tr>
    <tr align="center">
        <td width="100%" colspan="6">
                    <table  width="100%">
                        <tr>
                           <td align="center">
                            <br/>
                            <@CommonQueryMacro.Button id= "btRoleSave" />
                            &nbsp;&nbsp;
                            <@CommonQueryMacro.Button id= "btCancel" />
                        </td>
                        </tr> 
                    </table>
        </td>
    </tr>
</table>
<script language="javascript">
    var op = "${op}";

    function initCallGetter_post(dataset) {
        if (op == "new") {
            operMngMod_dataset.setFieldReadOnly("tlrno", false);
        } else {
            operMngMod_dataset.setFieldReadOnly("tlrno", true);
        }
        operMngMod_dataset.setParameter("op", op);
    }
    
    function roleGroup_DropDown_onSelect(dropdown, record, editor) {
	    operMngRoleInfoSel_dataset.flushData(1);
	    //去除重复记录
	    var rec = operMngRoleInfoSel_dataset.getFirstRecord();
	    while(rec){
	    	roleid = rec.getValue('roleId');
	    	var selRecord = operMngRoleInfoSel_dataset.find(["roleId"],[roleid]);
	    	if(selRecord != null){
	    		operMngRoleInfoSel_dataset.setRecord(selRecord);
	    		operMngRoleInfoSel_dataset.deleteRecord();
	    	}
	    	rec = rec.getNextRecord();
	    }
	    
	    return true;
    }
    

	
    function btRoleSave_onClickCheck() {
        var tlrno = operMngMod_dataset.getValue("tlrno");
        var tlrName = operMngMod_dataset.getValue("tlrName");
        if (tlrno.length == 0 || tlrName.length == 0) {
            alert("操作员号、操作员名称等必须填写！");
            return false;
        }

        var hasRoleSelected = false;
        var roleRecord = operMngRoleInfo_dataset.getFirstRecord();
        while (roleRecord) {
      // 	alert(roleRecord);
            var v_selected = roleRecord.getValue("select");
            if (v_selected == true) {
                hasRoleSelected = true;
            }
            roleRecord = roleRecord.getNextRecord();
        }
        if (!hasRoleSelected) {
            alert("至少选择一个角色！");
            return false;
        }

        return true;
    }
    
    
    function btadd_onClickCheck(button) {
    	var currentRecord = operMngRoleInfoSel_dataset.record;
    	if(currentRecord != null){
    	    operMngRoleInfo_dataset.insertRecord();
    	    currentRecord.setValue("select", true);
        	operMngRoleInfo_dataset.copyRecord(currentRecord);
        	operMngRoleInfoSel_dataset.deleteRecord();
    	}
	}
	
	function btremove_onClickCheck(button) {
    	var currentRecord = operMngRoleInfo_dataset.record;
    	if(currentRecord != null){
    	    operMngRoleInfoSel_dataset.insertRecord();
    	    currentRecord.setValue("select", true);
        	operMngRoleInfoSel_dataset.copyRecord(currentRecord);
        	operMngRoleInfo_dataset.deleteRecord();
    	}
	}
	
</script>
</@CommonQueryMacro.page>
