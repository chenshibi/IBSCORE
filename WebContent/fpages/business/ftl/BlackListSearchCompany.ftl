<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<@CommonQueryMacro.page title="黑名单企业查询">
<style>
a:link,a:visited{font-size:16px}
</style>
<@CommonQueryMacro.CommonQuery id="BlackListSearchCompany" init="false" submitMode="current" navigate="false">
	<table align="left" width="100%">
     <tr valign="center">
       			<td valign="top">
					<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=1 />
				</td>
     </tr>
     <tr>
      		<td valign="top">
      			 <@CommonQueryMacro.PagePilot id="pagePilot1"  maxpagelink="9" showArrow="true" pageCache="false"/>
      		</td>
	 </tr>
     <tr>
      		<td>
      			<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="insertNewCompany" fieldStr="opr[60],compId[120],regId[120],nameChn[120],product,reason,loanNo,status" readonly="true" width="100%"/>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	<#--将opr列变成超链接,需要记录类型,操作说明,原纪录主键,记录本身-->
	function datatable1_opr_onRefresh(cell, value, record){
		var regId = record.getValue("regId");
		var reason = record.getValue("reason");
		var funcid1 = record.getValue("funcid1");
		
		var htmlStr = "<center>";
		var tlrno = "${v_tlrno}";
		dwr.engine.setAsync(false);
    	//var flag=PrivAction.haveRole(tlrno,respTime,"corp");    //30天内或有权限
 		dwr.engine.setAsync(false);
		
		if(record) {//当存在记录时
			//if(flag){
				if("91992"==funcid1){
					htmlStr=htmlStr+"<a href=\"javascript:showReport1('"+regId+"')\">详情</a>"
				}
			//}
			cell.innerHTML=htmlStr
		}
		else {//当不存在记录时
			cell.innerHTML="&nbsp"
		}
	}
	
	<#-- 详情 -->
	function showReport1(regId){
  		if("" != regId && null != regId){
  			var params = {}
        	params.uuid=regId
        	openWindowWithPost("${contextPath}/BlackListSearchCompanyServlet", params)	
  		}
  	}
	
	<#-- 跳转方法 -->
	function openWindowWithPost(url, data) {
	    var form = document.createElement("form")
	    form.target = "_blank"
	    form.method = "POST"
	    form.action = url
	    form.style.display = "none"
	
	    for (var key in data) {
	        var input = document.createElement("input")
	        input.type = "hidden"
	        input.name = key
	        input.value = data[key]
	        form.appendChild(input)
	    }
	
	    document.body.appendChild(form)
	    form.submit()
	    document.body.removeChild(form)
	}

	
	
	
</script>
</@CommonQueryMacro.page>
