<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="二代企业征信历史信息报告查询">
<@CommonQueryMacro.CommonQuery id="PbocQueryHistoryAdd" init="false" submitMode="all">
<@CommonQueryMacro.GroupBox id="guoup1"  expand="true">
	<table  width="80%">
	<tr>
		<td  align="left">
			<@CommonQueryMacro.Group id="group1" label="请输入查询条件"  fieldStr="entName,entCertType,entCertNum,queryReason" colNm=1 /></br>
		</td>
	</tr>
	</table>
	
		<table width="100%"  >
			 	<tr>
    		<td  align="center">
				<@CommonQueryMacro.Button id= "btSubmit"/>
    		</td>
    	</tr>	
	</table>
</@CommonQueryMacro.GroupBox>	
</@CommonQueryMacro.CommonQuery>

<script language="javascript">

function btSubmit_onClickCheck(){
    var entName=PbocQueryHistoryAdd_dataset.getValue("entName");
    var entCertType=PbocQueryHistoryAdd_dataset.getValue("entCertType");
    var entCertNum=PbocQueryHistoryAdd_dataset.getValue("entCertNum");
    var queryReason=PbocQueryHistoryAdd_dataset.getValue("queryReason");
    PbocQueryHistoryAdd_dataset.setParameter("entName",entName);
    PbocQueryHistoryAdd_dataset.setParameter("entCertType",entCertType);
    PbocQueryHistoryAdd_dataset.setParameter("entCertNum",entCertNum);
    PbocQueryHistoryAdd_dataset.setParameter("queryReason",queryReason);

}

function btSubmit_postSubmit(button){
    alert("提交成功！");
    //button.url="/fpages/business/ftl/PbocQueryHistoryMake.ftl";
    closeWin();
}

</script>
</@CommonQueryMacro.page>