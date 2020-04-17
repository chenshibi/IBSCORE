<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="自然人中征码查询请求">
<@CommonQueryMacro.CommonQuery id="NaturePersonCodeQuery" init="false" submitMode="all" navigate="false" insertOnEmpty="true">
<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
	<table  width="100%">
    	<tr>
			<td  align="left">
				<@CommonQueryMacro.Group id="group1" label="自然人中征码查询请求"  fieldStr="individualIdType,individualId,name" colNm=2 /></br>
			</td>
		</tr>
		<tr>
    		<td  align="center">
				<@CommonQueryMacro.Button id= "btSave"/>&nbsp;&nbsp;  
    		</td>
    	</tr>
	</table>
</@CommonQueryMacro.GroupBox>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	  function initCallGetter_post(dataset) {		
	}
   
    function btSave_postSubmit(button){
   		alert("提交成功！");
	}
</script>
</@CommonQueryMacro.page>
