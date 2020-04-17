<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="个人征信历史查询">
<@CommonQueryMacro.CommonQuery id="PbocQueryPersonalMake" init="false" submitMode="current" navigate="false">
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
<script language="javascript">
    function btSearch_postSubmit(button){
        if (button.returnParam && button.returnParam.uuid) {
            var params = {};
            params.uuid = button.returnParam.uuid;
            alert('查询成功，将在新窗口打开征信查询结果页面');
            OpenWindowWithPost("${contextPath}/PersonalReportServlet", null, "_blank", params);
            return false;
        } else {
            alert("查询失败！");
        }
    }
    
    function OpenWindowWithPost(url, windowoption, target, params)
    {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", url);
    if (target === "_blank") {
        target = "Window" + (new Date()).valueOf();
    }
    form.setAttribute("target", target);

    for (var i in params) {
        if (params.hasOwnProperty(i)) {
            var input = document.createElement('input');
            input.type = 'hidden';
            input.name = i;
            input.value = params[i];
            form.appendChild(input);
        }
    }

    document.body.appendChild(form);

    //note I am using a post.htm page since I did not want to make double request to the page
    //it might have some Page_Load call which might screw things up.
    window.open(_application_root + "/common/blank.html", target, windowoption);

    form.submit();

    document.body.removeChild(form);
 }
    

</script>
</@CommonQueryMacro.page>