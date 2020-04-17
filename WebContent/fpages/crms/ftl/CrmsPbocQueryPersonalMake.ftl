<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>

<@CommonQueryMacro.page title="">
    <@CommonQueryMacro.CommonQuery id="CrmsPbocQueryPersonalMake" init="false" submitMode="all">
    <table width="100%" class="grouptable">
        <tr>
            <td width="25%"></td>
            <td align="center" nowrap class="labeltd" width="25%">姓名</td>
            <td class="datatd" colspan="1" width="25%"><@CommonQueryMacro.SingleField fId="name"/></td>
            <td width="25%"></td>
        </tr>
        <tr>
            <td width="25%"></td>
            <td align="center" nowrap class="labeltd" width="25%">证件类型</td>
            <td class="datatd" colspan="1" width="25%"><@CommonQueryMacro.SingleField fId="idType"/></td>
            <td width="25%"></td>
        </tr>
        <tr>
            <td width="25%"></td>
            <td align="center" nowrap class="labeltd" width="25%">证件号码</td>
            <td class="datatd" colspan="1" width="25%"><@CommonQueryMacro.SingleField fId="idNum"/></td>
            <td width="25%"></td>
        </tr>
        <tr>
            <td width="25%"></td>
            <td align="center" nowrap class="labeltd" width="25%">查询原因</td>
            <td class="datatd" colspan="1" width="25%"><@CommonQueryMacro.SingleField fId="queryReason"/></td>
            <td width="25%"></td>
        </tr>
        <tr>
            <td width="25%"></td>
            <td align="center" nowrap class="labeltd" width="25%">服务代码</td>
            <td class="datatd" colspan="1" width="25%"><@CommonQueryMacro.SingleField fId="serviceCode"/></td>
            <td width="25%"></td>
        </tr>
        <tr>
            <td width="25%"></td>
            <td align="center" width="50%" colspan="2"><@CommonQueryMacro.Button id="btSearch"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             <@CommonQueryMacro.Button id="btGrantAuth"/>
            </td>
            <td width="25%"></td>
        </tr>

    </table>
    </@CommonQueryMacro.CommonQuery>

<script language="javascript">

    function btSearch_postSubmit(button) {
        if (button.returnParam && button.returnParam.result) {
            alert('录入成功，请审核员审核！');
            return false;
        } else {
            alert("查询失败！");
        }

    }

    function  btGrantAuth_postSubmit(button){
        if (button.returnParam && button.returnParam.result) {
            alert('授权成功，审核通过后，可查！');
            return false;
        } else {
            alert("授权失败！");
        }
    }

</script>
</@CommonQueryMacro.page>