<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#import "/templets/ui18n.ftl" as ui18n />
<@CommonQueryMacro.page title="IndAppRequest.title">
<table align="left" width="100%"><tr><td>
<@CommonQueryMacro.CommonQuery id="NaturePersonScrubInfoQuery" init="false" submitMode="current">
<table  width="80%">
    <tr>
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
		</td>
	</tr>
	<tr>
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="name,individualId,individualIdType,status" readonly="true" width="95%" hasFrame="true" /><br />
		</td>
	</tr>
	
</table>
</@CommonQueryMacro.CommonQuery>

</td></tr>
</table>
<script language="JavaScript">


function NaturePersonScrubInfoQuery_interface_dataset_btnSubmit_onClickCheck(){
	var batchId = NaturePersonScrubInfoQuery_interface_dataset.getValue("batchId");
	var startDate =  NaturePersonScrubInfoQuery_interface_dataset.getValue("startDate");
	if(batchId.trim() =="" && startDate == ""){
		alert("至少输入一个条件");
		return false;
	}
	}

 
</script>
</@CommonQueryMacro.page>