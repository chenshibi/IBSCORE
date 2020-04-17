<#import "/templets/commonQuery/CommonQueryTagMacroMng.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="操作员管理">
    <@CommonQueryMacro.CommonQuery id="operMngEntry" init="false" submitMode="current">
    <table width="100%">
        <tr valign="center">
            <td valign="top" colspan="2">
                <@CommonQueryMacro.Interface id="intface" label="Please enter the query condition" colNm=6 />
            </td>
        </tr>
        <tr>
            <td valign="top">
                <@CommonQueryMacro.PagePilot id="ddresult" maxpagelink="9" showArrow="true" />
            </td>

        </tr>
        <tr>
            <td colspan="2">
                <@CommonQueryMacro.DataTable id ="datatable1"  fitColumns="false" fieldStr="tlrno[60],tlrName[150],gwxx[400],flag[60],status[60],isLock[60],lastaccesstm[150],lastlogouttm[150]"  readonly="true" width="100%" hasFrame="true"  />
            </td>
        </tr>

    </table>
    </@CommonQueryMacro.CommonQuery>

</@CommonQueryMacro.page>
