<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign v_tlrno = statics["com.huateng.ebank.business.common.GlobalInfo"].getCurrentInstance().getTlrno()?default('')>
<@CommonQueryMacro.page title="黑名单个人批量查询">
<style>
a:link,a:visited{font-size:16px}
</style>
<@CommonQueryMacro.CommonQuery id="BlackListBatchIndividual" init="false" submitMode="current" navigate="false">
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
      			<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="opr[60],custId,idType,nameChn[120],nameEng[120],product,reason,status,loanNo" readonly="true" width="100%"/>
      		</td>
     </tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
		function initCallGetter_post(dataset) {
	    	 $("#fldlabel_custIda").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_custIdb").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_custIdc").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_custIdd").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_custIde").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_custIdf").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_custIdg").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_custIdh").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_custIdi").parent().parent().css({"display":"none"});
		}
		
		var count=0;
		var flag=true;
	
		function btnew(){
			count++;
			if(count==1){
				$("#fldlabel_custIda").parent().parent().css({"display":""});
			}else if(count==2){
				$("#fldlabel_custIdb").parent().parent().css({"display":""});
			}else if(count==3){
				 $("#fldlabel_custIdc").parent().parent().css({"display":""});
			}else if(count==4){
				 $("#fldlabel_custIdd").parent().parent().css({"display":""});
			}else if(count==5){
				 $("#fldlabel_custIde").parent().parent().css({"display":""});
			}else if(count==6){
				 $("#fldlabel_custIdf").parent().parent().css({"display":""});
			}else if(count==7){
				 $("#fldlabel_custIdg").parent().parent().css({"display":""});
			}else if(count==8){
				 $("#fldlabel_custIdh").parent().parent().css({"display":""});
			}else if(count==9){
				 $("#fldlabel_custIdi").parent().parent().css({"display":""});
			}
	
		}
		
		function btAdd_onClick(button){
			btnew();
		}
	 
	
	
	<#--将opr列变成超链接,需要记录类型,操作说明,原纪录主键,记录本身-->
	function datatable1_opr_onRefresh(cell, value, record){
		var custId = record.getValue("custId");
		var funcid1 = record.getValue("funcid1");
		var htmlStr = "<center>";
		var tlrno = "${v_tlrno}";
		//dwr.engine.setAsync(false);
    	//var flag=PrivAction.haveRole(tlrno,respTime,"corp");    //30天内或有权限
 		dwr.engine.setAsync(false);
		
		if(record) {//当存在记录时
			if("91991"==funcid1){
				htmlStr=htmlStr+"<a href=\"javascript:showReport1('"+custId+"')\">详情</a>"
			}
				
			cell.innerHTML=htmlStr
		}
		else {//当不存在记录时
			cell.innerHTML="&nbsp"
		}
		
	}
	
	<#-- 详情 -->
	function showReport1(custId){
  		if("" != custId && null != custId){
  			var params = {}
        	params.uuid=custId
        	openWindowWithPost("${contextPath}/BlackListSearchIndivServlet", params)	
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
