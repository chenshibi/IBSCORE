<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="客户级别查询">
<@CommonQueryMacro.CommonQuery id="CustomerLevelQuery" init="false" submitMode="selected" navigate="false">

<table  width="100%">
    <tr align="center">
		<td>
			<@CommonQueryMacro.Interface id="intface" label="请输入查询条件" fieldStr="loanCardId,companyName,individualId,name,individualIda,namea,individualIdb,nameb,individualIdc,namec,individualIdd,named,individualIde,namee,individualIdf,namef,individualIdg,nameg,individualIdh,nameh,individualIdi,namei"  colNm=4 />
		</td>
	</tr>
</table>
<table>
	<tr >
		<td>
			<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="btAdd" fieldStr="dpdx[160],maxLast12M[260],creditCards[300],personalLoans[300],last12Months[260],last6Months[260]" readonly="true" /><br />
		</td>
	</tr>
</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

function initCallGetter_post(dataset) {
	    	 $("#fldlabel_individualIda").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_individualIdb").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_individualIdc").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_individualIdd").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_individualIde").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_individualIdf").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_individualIdg").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_individualIdh").parent().parent().css({"display":"none"});
	    	 $("#fldlabel_individualIdi").parent().parent().css({"display":"none"});
}
var count=0;
var flag=true;

	function btnew(){
	count++;
	if(count==1){
		$("#fldlabel_individualIda").parent().parent().css({"display":""});
	}else if(count==2){
		$("#fldlabel_individualIdb").parent().parent().css({"display":""});
	}else if(count==3){
		 $("#fldlabel_individualIdc").parent().parent().css({"display":""});
	}else if(count==4){
		 $("#fldlabel_individualIdd").parent().parent().css({"display":""});
	}else if(count==5){
		 $("#fldlabel_individualIde").parent().parent().css({"display":""});
	}else if(count==6){
		 $("#fldlabel_individualIdf").parent().parent().css({"display":""});
	}else if(count==7){
		 $("#fldlabel_individualIdg").parent().parent().css({"display":""});
	}else if(count==8){
		 $("#fldlabel_individualIdh").parent().parent().css({"display":""});
	}else if(count==9){
		 $("#fldlabel_individualIdi").parent().parent().css({"display":""});
	}

}
function btAdd_onClick(button){
		btnew();
	}
	 

</script>
</@CommonQueryMacro.page>