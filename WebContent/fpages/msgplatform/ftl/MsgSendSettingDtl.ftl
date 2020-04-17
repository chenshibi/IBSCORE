<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<#assign v_type = RequestParameters["type"]?default("")>
<#assign v_pageType = RequestParameters["pageType"]?default("")>
<@CommonQueryMacro.page title="消息发送配置维护明细">
<table width="100%">
    <tr>
        <td colspan="2">
            <@CommonQueryMacro.CommonQuery id="MsgSndSetting" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
                <@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
                    <table width="100%">
                        <tr>
                            <td align="left">
                                    <@CommonQueryMacro.Group id="group1" label="消息发送配置维护明细"  fieldStr="msgId" colNm=4 /></br>
                            </td>
                        </tr>
                    </table>
                </@CommonQueryMacro.GroupBox>
            </@CommonQueryMacro.CommonQuery>
        </td>
    </tr>
    <tr>
        <td align="top" width="50%">
            <@CommonQueryMacro.CommonQuery id="RcvUsrList" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
                <@CommonQueryMacro.GroupBox id="guoup2" label="可选接收用户列表" expand="true">
                    <table width="100%">
                        <tr>
                            <td align="left">
                                <@CommonQueryMacro.DataTable id ="branch" fitColumns="true" fieldStr="select,userId[150],userName[250]" width="100%" hasFrame="true" readonly="false"/>
                            </td>
                        </tr>
                    </table>
                </@CommonQueryMacro.GroupBox>
            </@CommonQueryMacro.CommonQuery>
        </td>
        <td align="top" width="50%">
            <@CommonQueryMacro.CommonQuery id="RcvGroupList" init="true" submitMode="all" navigate="false" insertOnEmpty="true">
                <@CommonQueryMacro.GroupBox id="guoup2" label="可选接收用户组列表" expand="true">
                    <table width="100%">
                        <tr>
                            <td align="left">
                                <@CommonQueryMacro.DataTable id ="branch" fitColumns="true" fieldStr="select,groupId[150],groupName[250]" width="100%" hasFrame="true" readonly="false"/>
                            </td>
                        </tr>
                    </table>
                </@CommonQueryMacro.GroupBox>
            </@CommonQueryMacro.CommonQuery>
        </td>
    </tr>
    <tr>
        <td align="center" colspan="2">
            <table align="center">
                <tr>
                    <td colspan="2" align="center">
                        <#if v_pageType=="entryPage">
                            <#if (v_type=="new") || (v_type=="update")>
                                <@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;
                            </#if>
                            <#if v_type=="delete">
                                <@CommonQueryMacro.Button id= "btDel"/>&nbsp;&nbsp;
                            </#if>
                            <@CommonQueryMacro.Button id= "btBack"/>
                        </#if>
                        <#if v_pageType=="checkPage">
                            <@CommonQueryMacro.Button id= "btBack"/>
                        </#if>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<script language="javascript">
    function initCallGetter_pre() {
        RcvUsrList_dataset.setParameter("objType", "user");
        RcvGroupList_dataset.setParameter("objType", "group");
    }
    var type = "${v_type}";
    function initCallGetter_post(dataset) {
        MsgSndSetting_dataset.setFieldRequired("msgId", true);
        if (type == 'detail' || type == 'delete') {
            MsgSndSetting_dataset.setAllFieldsReadOnly(true);
            RcvUsrList_dataset.setAllFieldsReadOnly(true);
            RcvGroupList_dataset.setAllFieldsReadOnly(true);
        } else if (type == 'new' || type == 'update') {
            if (type == 'new') {
                MsgSndSetting_dataset.setFieldReadOnly("msgId", false);
                MsgSndSetting_dataset.setFieldReadOnly("msgName", true);
            } else {
                MsgSndSetting_dataset.setAllFieldsReadOnly(true);
                MsgSndSetting_dataset.setFieldReadOnly("msgId", true);
                MsgSndSetting_dataset.setFieldReadOnly("roleGroup", false);
            }
            //user
            RcvUsrList_dataset.setFieldReadOnly("select", false);
            RcvUsrList_dataset.setFieldReadOnly("userId", true);
            RcvUsrList_dataset.setFieldReadOnly("userName", true);
            RcvUsrList_dataset.setFieldReadOnly("userEmail", true);
            //group
            RcvGroupList_dataset.setFieldReadOnly("select", false);
            RcvGroupList_dataset.setFieldReadOnly("groupId", true);
            RcvGroupList_dataset.setFieldReadOnly("groupName", true);
        }
    }
    function btBack_onClick(button) {
        closeWin();
    }
    function btSave_postSubmit(button) {
        alert("提交成功！");
        closeWin();
    }
    function btDel_postSubmit(button) {
        alert("提交成功！");
        closeWin();
    }
    
    function roleGroup_DropDown_onSelect(dropdown, record, editor) {
    	var v_roleGroup;
		if(record != null){
			v_roleGroup  = record.getValue('data');
		}else{
			v_roleGroup = null;
		}
	    RcvUsrList_dataset.setParameter("qroleGroup",v_roleGroup);
	    RcvUsrList_dataset.flushData(1);
	    return true;
    }
    
    function msgId_DropDown_onSelect(dropdown, record, editor) {
        var msgid = record.getValue('data');
        var usrList = null;
		dwr.engine.setAsync(false);
		PrivAction.getUsrByMsgId(msgid,
			function(data){
				usrList = data;
			}
		);
		dwr.engine.setAsync(true);
		var record = RcvUsrList_dataset.getFirstRecord();
		while(record){
			record.setValue("select", false);
			if(usrList != null){
				var usrid = record.getValue("userId");
				for(var i=0;i<usrList.length;i++){
					if (usrid == usrList[i]) {
						record.setValue("select", true);
					}
				}
			}
			record=record.getNextRecord();
	   	}
		
        return true;
    }

</script>
</@CommonQueryMacro.page>

