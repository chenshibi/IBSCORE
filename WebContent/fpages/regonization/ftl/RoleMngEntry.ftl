<#import "/templets/commonQuery/CommonQueryTagMacroMng.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="角色管理">
    <@CommonQueryMacro.CommonQuery id="ebankCustRoleMng" init="false" submitMode="current">
    <table align="left" width="100%">
    	<tr valign="center">
			<td valign="top" colspan="2">
				<@CommonQueryMacro.Interface id="intface" label="Please enter the query condition" colNm=6 />
			</td>
		</tr>
        <tr>
            <td valign="top">
                <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
            </td>

        </tr>
        </tr>
        <tr>
            <td valign="top" colspan="2">
                <@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAddRole,-,btStatus"
                fieldStr="roleName[200],status[100],st[100],opr[230]"
                readonly="true" width="80%"/>
                <br/>
            </td>
        </tr>

        <tr>
            <td valign="top" colspan="2">
                <@CommonQueryMacro.FloatWindow id="signWindow" label="" width="" resize="true" defaultZoom="normal" minimize="false" maximize="false" closure="true" float="true" exclusive="true" position="center" show="false" >
                    <div align="center">
                        <@CommonQueryMacro.Group id ="group1" label="详细信息" fieldStr="roleName"/>
                        <div align="left"><font color="red">*</font>保存后,请设置相关权限信息.</div>
                        <@CommonQueryMacro.Button id= "btSave"/>
                    </div>
                </@CommonQueryMacro.FloatWindow>
            </td>
        </tr>
        <tr>
            <td style="display:none">
                <@CommonQueryMacro.Button id= "btDeleteRole"/>
      			<@CommonQueryMacro.Button id= "btRoleAuthorityManagement"/>
      			<@CommonQueryMacro.Button id= "btSelectRole"/>
            </td>
        </tr>
    </table>
    </@CommonQueryMacro.CommonQuery>
<span style="display:none">
</span>

<script language="JavaScript">
    //定位一条记录
    function locate(id) {
        var record = ebankCustRoleMng_dataset.find(["id"], [id]);
        if (record) {
            ebankCustRoleMng_dataset.setRecord(record);
        }
    }

    function openRoleDtl(id) {
        locate(id);
        subwindow_signWindow.show();
    }

    function btAddRole_onClick(button) {
        button.url += "?id=0";
    }
    function btStatus_onClickCheck(button) {
        var status = ebankCustRoleMng_dataset.getValue("status");
        if (status == '0') {
            if (confirm("Confirm that the operator is set to be valid?")) {//确认将该角色设置为有效
                ebankCustRoleMng_dataset.setParameter("statu", "1");
                return true;
            } else {
                return false;
            }
        } else {
            if (confirm("Confirm that the operator is set to be invalid?")) {//确认将该角色设置为无效
                ebankCustRoleMng_dataset.setParameter("statu", "0");
                return true;
            } else {
                return false;
            }
        }
    }
    function btStatus_postSubmit(button) {
        alert("Set up success");//设置成功
        ebankCustRoleMng_dataset.flushData(ebankCustRoleMng_dataset.pageIndex);
    }
    function datatable1_opr_onRefresh(cell, value, record) {
        if (record && record != null) {
            var id = record.getValue("id");
            var Lock = record.getValue("isLock");
            var innerText = "";
            var status = record.getValue("status");
            if (Lock == "1"||status == '0' ) {
                innerText = "<center><a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"The record is locked and cannot be operated\">Role permissions set</a> ";//记录已锁定，不能操作        角色权限设置
            }
            else {
                innerText = "<center><a href=\"JavaScript:rolePrivShow("+id+")\">Role permissions set&nbsp&nbsp&nbsp&nbsp</a> "//角色权限设置
            }
            cell.innerHTML = innerText + " <a href=\"JavaScript:btRoleUserShow(" + id + ")\">Viewing personnel</a></center>";//查看人员
        }
        else {
            cell.innerHTML = "";
        }
    }


    function datatable1_rolename_onRefresh(cell, value, record) {
        if (record != null) {
            var st = record.getValue("st");
            var id = record.getValue("id");
            cell.innerHTML = "<a href=\"Javascript:showDetail('" + id + "','" + st + "')\">" + value + "</a>";

        } else {
            cell.innerHTML = ""
        }
    }
    //function showDetail(id,st){
    //var paramMap = new Map();
    //paramMap.put("id",id);
    //paramMap.put("st",st);
    //paramMap.put("op","detail");
    //loadPageWindows("partWin", "角色管理详细信息","/fpages/management/ftl/RoleFuncMng.ftl", paramMap, "winZone");
    //}
    //详细
    function showDetail(id, st) {

        locate(id);
        showWin("Role Management Datails", "/fpages/system/ftl/RoleFuncMngWithEdit.ftl?id=" + id + "&st=" + st + "&flag=0", null, null, window);
    }


    function btRoleUserShow(id) {
        var paramMap = new Map();
        paramMap.put("roleId", id);
        loadPageWindows("userWin", "View Personnel Information", "/fpages/management/ftl/ebankCustRoleMngUser.ftl", paramMap, "winZone");
        return;
    }

    function rolePrivShow(id) {
        locate(id);
        //modify by zhangdianchao 20160405 [fix role_management page bug while modify role_rights] start
        //window.document.getElementById('btRoleAuthorityManagement').click();
        var button = window.document.getElementById('btRoleAuthorityManagement');
        button.url = '/fpages/management/ftl/RoleFuncMng.ftl?op=modify&id=' + id;
        button.click();
        //modify by zhangdianchao 20160405 [fix role_management page bug while modify role_rights] end
    }


    function btSave_postSubmit() {
        //alert('保存成功！');
        subwindow_signWindow.hide();
        ebankCustRoleMng_dataset.flushData(ebankCustRoleMng_dataset.pageIndex);
    }
    function signWindow_floatWindow_beforeClose(subwindow) {
        ebankCustRoleMng_dataset.cancelRecord();
        return true;
    }
    function signWindow_floatWindow_beforeHide(subwindow) {
        return signWindow_floatWindow_beforeClose(subwindow);
    }
    function ebankCustRoleMng_dataset_afterInsert(dataset, mode) {
        ebankCustRoleMng_dataset.setValue2("status", "1");
    }

    function ebankCustRoleMng_dataset_afterChange(dataset, field, value) {

    }
    function ebankCustRoleMng_dataset_afterScroll(dataset) {

        var Lock = dataset.getValue("isLock");
        if (Lock == "1") {
            btStatus.disable(true);
        }
        else {
            btStatus.disable(false);
        }
    }
</script>
</@CommonQueryMacro.page>
