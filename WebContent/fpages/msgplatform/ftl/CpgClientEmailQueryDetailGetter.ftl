<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />
<@CommonQueryMacro.page title="黑灰名单客户邮件发送记录查询">
<@CommonQueryMacro.CommonQuery id="CpgClientEmailQueryDetailGetter" init="true" submitMode="current">
    <table width="100%"  class="grouptable">
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
