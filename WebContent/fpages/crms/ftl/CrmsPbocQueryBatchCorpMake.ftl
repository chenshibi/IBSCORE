<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro >
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>

<@CommonQueryMacro.page title="">
    <@CommonQueryMacro.CommonQuery id="CrmsPbocQueryBatchCorpMake" init="false" submitMode="all">
    <table width="100%" class="grouptable">
        <tr>
            <td width="25%"></td>
            <td align="center" nowrap class="labeltd" width="25%">信息记录标识号</td>
            <td class="datatd" colspan="1" width="25%"><@CommonQueryMacro.SingleField fId="requestId"/></td>
            <td width="25%"></td>
        </tr>
        <tr>
            <td width="25%"></td>
            <td align="center" nowrap class="labeltd" width="25%">企业名称</td>
            <td class="datatd" colspan="1" width="25%"><@CommonQueryMacro.SingleField fId="entName"/></td>
            <td width="25%"></td>
        </tr>
        <tr>
            <td width="25%"></td>
            <td align="center" nowrap class="labeltd" width="25%">企业身份标识类型</td>
            <td class="datatd" colspan="1" width="25%"><@CommonQueryMacro.SingleField fId="entCertType"/></td>
            <td width="25%"></td>
        </tr>
        <tr>
            <td width="25%"></td>
            <td align="center" nowrap class="labeltd" width="25%">企业身份标识号码</td>
            <td class="datatd" colspan="1" width="25%"><@CommonQueryMacro.SingleField fId="entCertNum"/></td>
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
            <td align="center" width="50%" colspan="2"></td>
            <td width="25%"></td>
        </tr>
    </table>

    <table width="100%" class="grouptable">
        <tr>
            <td width="25%"></td>
            <td align="center" nowrap class="labeltd" width="25%">信息记录标识号</td>
            <td class="datatd" colspan="1" width="25%"><@CommonQueryMacro.SingleField fId="requestId"/></td>
            <td width="25%"></td>
        </tr>
        <tr>
            <td width="25%"></td>
            <td align="center" nowrap class="labeltd" width="25%">企业名称</td>
            <td class="datatd" colspan="1" width="25%"><@CommonQueryMacro.SingleField fId="entName"/></td>
            <td width="25%"></td>
        </tr>
        <tr>
            <td width="25%"></td>
            <td align="center" nowrap class="labeltd" width="25%">企业身份标识类型</td>
            <td class="datatd" colspan="1" width="25%"><@CommonQueryMacro.SingleField fId="entCertType"/></td>
            <td width="25%"></td>
        </tr>
        <tr>
            <td width="25%"></td>
            <td align="center" nowrap class="labeltd" width="25%">企业身份标识号码</td>
            <td class="datatd" colspan="1" width="25%"><@CommonQueryMacro.SingleField fId="entCertNum"/></td>
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
            <td align="center" width="50%" colspan="2"><@CommonQueryMacro.Button id="btSearch"/></td>
            <td width="25%"></td>
        </tr>
    </table>
    </@CommonQueryMacro.CommonQuery>

<script language="javascript">
    function btSearch_postSubmit(button) {

        if (button.returnParam && button.returnParam.uuid) {
            var params = {};
            params.uuid = button.returnParam.uuid;
            alert('查询成功，将在新窗口打开征信查询结果页面');
            OpenWindowWithPost("${contextPath}/BatchCorpReportServlet", null, "_blank", params);
            return false;
        } else {
            alert("查询失败！");
        }
    }


</script>
</@CommonQueryMacro.page>