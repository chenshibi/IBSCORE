<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="机构信息维护">
<table width="100%" align="left">
    <tr>
        <td>
            <@CommonQueryMacro.CommonQuery id="Management_branchQuery" init="false" submitMode="current">
                <table width="100%">
                    <tr>
                        <td valign="top" colspan="2">
                            <@CommonQueryMacro.Interface id="intface" label="机构查询" colNm=4 showButton="true" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <@CommonQueryMacro.PagePilot id="PagePilot"/>
                        </td>

                    </tr>
                    <tr>
                        <td colspan="2">
                            <@CommonQueryMacro.DataTable id ="datatable1"  fitColumns="true" fieldStr="brno,brname[246],brclass,ssfrh[350],isFp" width="100%"  readonly="true"/><br />
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <@CommonQueryMacro.FloatWindow  id="shareshow" label="" width="" resize="true" defaultZoom="normal"
                                                            minimize="false" maximize="false" closure="true" float="true" exclusive="true"
                                                            position="center" show="false" >
                                <div align="center">
                                    <@CommonQueryMacro.Group id="group2" label="机构查询" fieldStr="brno,brname,address,postno,teleno,brclass,blnUpBrcode,blnManageBrcode,brattr,otherAreaFlag,ssfrh,isFp,cnapsCode" colNm=4/>
                                    <br/>
                                    <@CommonQueryMacro.Button id= "btCancel"/>
                                </div>
                            </@CommonQueryMacro.FloatWindow>

                        </td>
                    </tr>


                </table>
            </@CommonQueryMacro.CommonQuery>
        </td>
    </tr>
</table>
<script language="javascript">
    //定位一条记录
    function locate(id) {
        var record = Management_branchQuery_dataset.find(["brcode"],[id]);
        if (record) {
            Management_branchQuery_dataset.setRecord(record);
        }
    }

    function openBranchDtll(id){
        locate(id);
        Management_branchQuery_dataset.setFieldReadOnly("isFp", true);
        Management_branchQuery_dataset.setFieldReadOnly("ssfrh", true);
        Management_branchQuery_dataset.setFieldReadOnly("brno", true);
        Management_branchQuery_dataset.setFieldReadOnly("brname", true);
        Management_branchQuery_dataset.setFieldReadOnly("address", true);
        Management_branchQuery_dataset.setFieldReadOnly("postno", true);
        Management_branchQuery_dataset.setFieldReadOnly("teleno", true);
        Management_branchQuery_dataset.setFieldReadOnly("brclass", true);
        Management_branchQuery_dataset.setFieldReadOnly("blnUpBrcode", true);
        Management_branchQuery_dataset.setFieldReadOnly("blnManageBrcode", true);
        Management_branchQuery_dataset.setFieldReadOnly("brattr", true);
        Management_branchQuery_dataset.setFieldReadOnly("otherAreaFlag", true);
        Management_branchQuery_dataset.setFieldReadOnly("cnapsCode", true);
        subwindow_shareshow.show();
    }



    function signWindowDet_floatWindow_beforeHide(signWindowDet){
        return false;
    }



    function btCancel_onClick(){

        subwindow_shareshow.close();

    }

    function datatable1_opr_onRefresh(cell, value, record)
    {

        if (record) {//当存在记录时
            //var lock = record.getValue("lock");
            var st = record.getValue("st");
            var id = record.getValue("brcode");
            if (st == "1" || st == "2" || st == "3"){
                cell.innerHTML = "<center><a href=\"Javascript:void(0);\" style=\"color:#666666\" title=\"记录已锁定，不能操作\">修改</a></center>";
            }else{
                cell.innerHTML="<center><a href=\"JavaScript:openBranchDtl('"+id+"')\">修改</a></center>";
            }
        } else {//当不存在记录时
            cell.innerHTML="&nbsp;";
        }
    }

    function signWindow_floatWindow_beforeClose(subwindow){
        Management_branchQuery_dataset.cancelRecord();
        return true;
    }
    function signWindow_floatWindow_beforeHide(subwindow){
        return false;
    }

    function Management_branchManage_dataset_afterInsert(dataset, mode){
        Management_branchQuery_dataset.setValue2("status", "1");
    }
    //展示对比功能的js
    function datatable1_brno_onRefresh(cell, value, record){
        if(record!=null){
            var sta = record.getValue("st");
            var id = record.getValue("brcode");
            var brno=record.getValue("brno");


            //cell.innerHTML = "<a href=\"Javascript:showDetail('"+id+"','"+sta+"')\">"+brno+"</a>";
            cell.innerHTML="<center><a href=\"JavaScript:openBranchDtll('"+id+"')\">"+brno+"</a></center>";
        } else {
            cell.innerHTML = ""
        }
    }












</script>
</@CommonQueryMacro.page>