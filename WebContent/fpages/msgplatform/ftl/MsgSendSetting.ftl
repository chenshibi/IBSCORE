<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="发送失败消息查询">
<table align="left">
    <tr>
        <td>
            <@CommonQueryMacro.CommonQuery id="MsgSndSetting" init="false" submitMode="current">
                <table width="100%">
                    <tr>
                        <td colspan="2" valign="top">
                            <@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" colNm=6 /><span
                                style='clear:both;'/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <@CommonQueryMacro.DataTable id="datatable1" paginationbar="btAdd" fieldStr="msgId[200],msgName[250],creator1,createdDate1[150],checkUser1,checkDate1[150],opr" width="100%"/>
                        </td>
                    </tr>
                </table>
            </@CommonQueryMacro.CommonQuery>
        </td>
    </tr>
</table>
<script language="JavaScript">
    function initCallGetter_pre() {
        MsgSndSetting_dataset.setParameter("pageType", "entryPage");
    }
    //将id列变成超链接,需要记录类型,操作说明,原纪录主键,记录本身
    function datatable1_opr_onRefresh(cell, value, record) {
        var msgId = record.getValue("msgId");
        //var recStatus = record.getValue("recStatus");
        if (record) {
            if (true) {
                innerText = "<center><a href=\"JavaScript:doModify('" + msgId + "')\">修改</a> "
                cell.innerHTML = innerText + "<a href=\"JavaScript:doDelete('" + msgId + "')\">删除</a></center>";
            } else {
                cell.innerHTML = "<center>记录锁定</center>";
            }
        } else {//当不存在记录时
            cell.innerHTML = "&nbsp;";
        }
    }
    function locate(msgId) {
        var record = MsgSndSetting_dataset.find(["msgId"], [msgId]);
        if (record) {
            MsgSndSetting_dataset.setRecord(record);
        }
    }
    function doDelete(msgId) {
        locate(msgId);
        var record = MsgSndSetting_dataset.find(["msgId"], [msgId]);
        var msgId = record.getValue("msgId");
        var url = "/fpages/msgplatform/ftl/MsgSendSettingDtl.ftl?type=delete&msgId=" + msgId + "&pageType=entryPage";
        showWin("消息发送配置维护", url, "window", "flushPage()", window);
    }
    function doModify(msgId) {
        locate(msgId);
        var record = MsgSndSetting_dataset.find(["msgId"], [msgId]);
        var msgId = record.getValue("msgId");
        var url = "/fpages/msgplatform/ftl/MsgSendSettingDtl.ftl?type=update&msgId=" + msgId + "&pageType=entryPage";
        showWin("消息发送配置维护", url, "window", "flushPage()", window);
    }
    function btAdd_onClick(button) {
        var url = "/fpages/msgplatform/ftl/MsgSendSettingDtl.ftl?type=new" + "&pageType=entryPage";
        showWin("消息发送配置维护", url, "window", "flushPage()", window);
    }

    function showDetail(id) {
        var record = MsgSndSetting_dataset.find(["msgId"], [msgId]);
        var url = "/fpages/msgplatform/ftl/MsgSendSettingDtl.ftl?type=detail&msgId=" + msgId + "&pageType=entryPage";
        showWin("消息发送配置维护", url, "window", "flushPage()", window);
    }
    //刷新数据
    function flushPage() {
        MsgSndSetting_dataset.flushData(1);
    }

</script>
</@CommonQueryMacro.page>