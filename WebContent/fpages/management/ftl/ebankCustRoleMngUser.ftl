<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="ebankCustRoleMngUser">
    <@CommonQueryMacro.CommonQuery id="ebankCustRoleMngUser" init="true" mode="0" submitMode="all">
    <table align="left">
        <tr valign="top">
            <td valign="center">
                <@CommonQueryMacro.Group id ="group1" label="Role Information" fieldStr="roleName" colNm=4/>
            </td>
        </tr>
        <tr valign="top">
            <td valign="center">
                <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9"  showArrow="true" pageCache="false"/>
                <@CommonQueryMacro.DataTable id ="datatable1" fitColumns="true" hasFrame="false" fieldStr="tlrno,tlrName,flag,lastaccesstm" readonly="true"  />
                <br/>
            </td>
        </tr>
        <tr valign="top">
            <td valign="center">
                <CENTER><@CommonQueryMacro.Button id= "btClose"/></CENTER>
            </td>
        </tr>
    </table>


    </@CommonQueryMacro.CommonQuery>
<script language="javascript">
    function btClose_onClickCheck(button) {
        unloadPageWindows("userWin");
        return false;
    }
</script>
</@CommonQueryMacro.page>
