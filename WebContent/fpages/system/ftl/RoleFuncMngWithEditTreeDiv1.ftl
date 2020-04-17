<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>


<@CommonQueryMacro.page title="角色权限管理">
<script type="text/javascript" src="${contextPath}/js/xmlUtil.js"></script>
<script type="text/javascript" src="${contextPath}/js/tree.js"></script>
<script type="text/javascript" src="${contextPath}/js/xtree.js"></script>
<script type='text/javascript' src='${contextPath}/dwr/interface/PrivAction.js'> </script>
<table align="left" valign="top" >
	<tr>
	  <td>
		<script language="javascript">
			var functree = null;
			dwr.engine.setAsync(false);
			PrivAction.getFuncArray(
				function(data){
					functree = data;
				}
			);
			dwr.engine.setAsync(true);
            createTree(functree,0,0);
       </script>
     </td>
   </tr>
</table>
</span>
<script language="javascript">
	var varid = "${RequestParameters["id"]?default('')}";
	var st = "${RequestParameters["st"]?default('')}";
	var tskId = "${RequestParameters["tskId"]?default('')}";
	var flag = "${RequestParameters["flag"]?default('')}";

	function load(){
		PrivAction.getRoleFuncByIdCom(varid,st,flag,tskId,selectFunction);
	}

	function initCallGetter_post(){
		load();
		var chkboxs = $(":checkbox"); 
		var len = chkboxs.length;
		for(i=0;i<len;i++){
	    	chkboxs[i].disabled = true;
		}
	}


	function selectFunction(data)
	{
		for(var i=0;i <data.length;i++){
		 	var num = "id" + data[i];
	        if(document.getElementById(num) != null)
		 	{
	         document.getElementById(num).checked=true;
	        }
        }
        <#--20110818 BMSA-54 权限树目录菜单可全选 begin -->
		pcheck();
		<#--20110818 BMSA-54 权限树目录菜单可全选 end -->
	}
	
</script>


</@CommonQueryMacro.page>
