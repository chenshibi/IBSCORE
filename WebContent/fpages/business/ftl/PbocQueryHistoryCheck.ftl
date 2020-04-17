<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="第二代企业信用信息查询check">
<@CommonQueryMacro.CommonQuery id="PbocQueryHistoryCheck" init="true" submitMode="selected" navigate="false">
     <tr valign="center">
       			<td valign="top">
					<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" colNm=4 />
				</td>
     </tr>
	 <tr>
      		<td>
      			<@CommonQueryMacro.DataTable id ="datatable1" fieldStr="select,entName,entCertType,entCertNum,queryReason,status,isLock,queryDate,userId" readonly="true" width="100%"/>
      		</td>
     </tr>
      	<tr>
    		<td  align="center">
				&nbsp<@CommonQueryMacro.Button id= "btapprove"/>
				&nbsp<@CommonQueryMacro.Button id= "disapprove"/>
    		</td>
    	</tr>	
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

function btapprove_postSubmit(){
    alert("审批同意成功！");
    PbocQueryHistoryCheck_dataset.flushData(1);
}

function disapprove_postSubmit(){
    alert("审批拒绝成功！");
    PbocQueryHistoryCheck_dataset.flushData(1);
}


</script>
</@CommonQueryMacro.page>
