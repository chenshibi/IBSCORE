<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="个人征信历史查询">
<@CommonQueryMacro.CommonQuery id="CrmsPbocQueryPersonalHistory" init="false" submitMode="current" navigate="false">
	<table align="left" width="100%">
     <tr valign="center">
       			<td valign="top">
					<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
				</td>
     </tr>
     <tr>
      		<td valign="top">
      			 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="13" showArrow="true" pageCache="false"/>
      		</td>
	 </tr>
     <tr>
      		<td>
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="createUser,name,idType,idNum,queryReason,serviceCode,respId[200],respCode,respMsg,queryDate,sendTime,respTime,status" readonly="true" width="100%"/>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.CommonQuery>
<span style="display:none">

</span>

<script language="JavaScript">
    //展示对比功能的js
    function datatable1_respid_onRefresh(cell, value, record) {
        if (record) {
            var id = record.getValue("respId");
            var st = record.getValue("status");
            cell.innerHTML = "<a href=\"Javascript:showDetail('" + id + "','"+st+"')\">"+value+"</a>";
        } else {
            cell.innerHTML = ""
        }
    }


    function showDetail(id,st) {
        var params = {};
        params.uuid = id;
        if(st=="03"){
            alert('查询成功，将在新窗口打开征信查询结果页面');
            OpenWindowWithPost("${contextPath}/PersonalReportServlet", null, "_blank", params);
        }else if(st=="04"){
            alert('查询失败');
            return;
        }else if(st=="00"){
            alert("未查");
        }
        
        
    }

</script>
</@CommonQueryMacro.page>
