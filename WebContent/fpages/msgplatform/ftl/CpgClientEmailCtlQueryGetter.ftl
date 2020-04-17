<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />
<@CommonQueryMacro.page title="黑灰名单客户邮件发送配置">
<table align="center" width="100%">
    <tr>
        <td>
            <@CommonQueryMacro.CommonQuery id="CpgClientEmailCtlQueryGetter" init="false" submitMode="current">
            <table width="100%">
                  <tr valign="center">
                    <td valign="top" colspan="2">
                        <@CommonQueryMacro.Interface id="interface" width="100%" label="请输入查询条件"  />
                    </td>
                </tr>
                <tr>
                    <td><@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <@CommonQueryMacro.DataTable id="datatable1" fieldStr="ftloperation,cpgClientEmailCtlMsgId,cpgClientEmailCtlMsgName,cpgClientEmailCtlSysName,cpgClientEmailCtlBrno,cpgClientEmailCtlClientSnd,cpgClientEmailCtlOpsSnd,cpgClientEmailCtlEmail,cpgClientEmailCtlSt"  width="100%" hasFrame="true"/>
                    </td>
                </tr>
            </table>
            </@CommonQueryMacro.CommonQuery>
        </td>
    </tr>
</table>
<script language="JavaScript">
    function datatable1_ftloperation_onRefresh(cell, value, record){
        if(record!=null){
            cell.innerHTML = "<a href=\"Javascript:showDetail()\">查看明细</a>";
        }
    }

    function showDetail(){
        var paramMap = new Map();
        loadPageWindows("partWin", "查看明细","/fpages/msg/ftl/CpgClientEmailCtlQueryDetailGetter.ftl", paramMap, "winZone");
    }

</script>
</@CommonQueryMacro.page>
