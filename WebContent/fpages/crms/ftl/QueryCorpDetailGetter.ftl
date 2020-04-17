<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />
<@CommonQueryMacro.page title="企业征信维护">
<@CommonQueryMacro.CommonQuery id="QueryCorpDetailGetter" init="true" submitMode="all">
    <table width="100%"  class="grouptable">
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
           <td align="right" width="25%"><@CommonQueryMacro.Button id= "btClose"/></td>
           <td align="left" width="25%"><@CommonQueryMacro.Button id= "btModify"/></td>
           <td width="25%"></td>
       </tr>
   </table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
    function btClose_onClickCheck(button){
        unloadPageWindows("partWin");
        return false;
    }
	
    function btModify_postSubmit(button){
    	alert("修改成功，请审核。");
    }

</script>
</@CommonQueryMacro.page>
