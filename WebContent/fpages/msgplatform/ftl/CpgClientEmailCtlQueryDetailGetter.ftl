<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />
<@CommonQueryMacro.page title="黑灰名单客户邮件发送配置">
<@CommonQueryMacro.CommonQuery id="CpgClientEmailCtlQueryDetailGetter" init="true" submitMode="current">
    <table width="100%"  class="grouptable">
        <tr>
            <td align="center" nowrap class="labeltd" width="25%">消息号</td>
            <td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="cpgClientEmailCtlMsgId"/></td>
            <td align="center" nowrap class="labeltd" width="25%">消息名</td>
            <td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="cpgClientEmailCtlMsgName"/></td>
        </tr>
        <tr>
            <td align="center" nowrap class="labeltd" width="25%">系统名</td>
            <td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="cpgClientEmailCtlSysName"/></td>
            <td align="center" nowrap class="labeltd" width="25%">分行号</td>
            <td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="cpgClientEmailCtlBrno"/></td>
        </tr>
        <tr>
            <td align="center" nowrap class="labeltd" width="25%">是否发送客户邮件</td>
            <td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="cpgClientEmailCtlClientSnd"/></td>
            <td align="center" nowrap class="labeltd" width="25%">是否发送用户邮件</td>
            <td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="cpgClientEmailCtlOpsSnd"/></td>
        </tr>
        <tr>
            <td align="center" nowrap class="labeltd" width="25%">用户邮件地址</td>
            <td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="cpgClientEmailCtlEmail"/></td>
            <td align="center" nowrap class="labeltd" width="25%">操作状态</td>
            <td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="cpgClientEmailCtlSt"/></td>
        </tr>
        <tr>
            <td align="center" nowrap class="labeltd" width="25%">录入操作员</td>
            <td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="cpgClientEmailCtlMdTlr"/></td>
            <td align="center" nowrap class="labeltd" width="25%">录入时间</td>
            <td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="cpgClientEmailCtlMdTime"/></td>
        </tr>
        <tr>
            <td align="center" nowrap class="labeltd" width="25%">审核操作员</td>
            <td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="cpgClientEmailCtlApvTlr"/></td>
            <td align="center" nowrap class="labeltd" width="25%">审核时间</td>
            <td class="datatd" width="25%"><@CommonQueryMacro.SingleField fId="cpgClientEmailCtlApvTime"/></td>
        </tr>
       <tr>
           <td></td>
           <td align="right"><@CommonQueryMacro.Button id= "btClose"/></td>
           <td></td>
           <td></td>
       </tr>
   </table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
    function btClose_onClickCheck(button){
        unloadPageWindows("partWin");
        return false;
    }

</script>
</@CommonQueryMacro.page>
