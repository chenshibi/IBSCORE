<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />
<@CommonQueryMacro.page title="二代企业征信相关还款人及抵押物查询">
<@CommonQueryMacro.CommonQuery id="QueryCollateralMake" init="false" submitMode="current">
<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
<input type="hidden"  name="openertext" id="feedBackTxt"  value="" size="30" >
	<table  width="80%">
	<tr>
		<td  align="left">
			<@CommonQueryMacro.Group id="group1" label="请输入查询条件"  fieldStr="entName,entCertType,entCertNum,queryReason,serviceCode" colNm=1 /></br>
		</td>
	</tr>
	</table>
	
		<table width="100%"  >
			 	<tr>
    		<td  align="center">
				<@CommonQueryMacro.Button id= "btSearch"/>
    		</td>
    	</tr>	
			</table>
</@CommonQueryMacro.GroupBox>	
</@CommonQueryMacro.CommonQuery>

<script language="javascript">

    function initCallGetter_post(dataset) {
      QueryCollateralMake_dataset.setValue("serviceCode","FW_QYXYBG_0043");
    }

  	function btSearch_onClickCheck(button){
      var entName=QueryCollateralMake_dataset.getValue("entName");
      var entCertType=QueryCollateralMake_dataset.getValue("entCertType");
      var entCertNum=QueryCollateralMake_dataset.getValue("entCertNum");
      var queryReason=QueryCollateralMake_dataset.getValue("queryReason");
      var serviceCode=QueryCollateralMake_dataset.getValue("serviceCode");
      if(entName==""){
         alert("企业名称不可为空");
         return false;
      }
      if(entCertType==""){
         alert("企业身份标识类型不可为空");
         return false;
      }
      if(entCertNum==""){
         alert("企业身份标识号码不可为空");
         return false;
      }
      if(queryReason==""){
         alert("查询原因不可为空");
         return false;
      }
      if(serviceCode==""){
         alert("服务代码不可为空");
         return false;
      }
	}

    function btSearch_postSubmit(button) {
     alert("查询成功！");
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