<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="第二代企业信用信息查询make">
<@CommonQueryMacro.CommonQuery id="PbocQueryHistoryMake" init="true" submitMode="selected" navigate="false">
     <tr valign="center">
       			<td>
					<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" colNm=4 />
				</td>
     </tr>
	 <tr>
      		<td>
      			<@CommonQueryMacro.DataTable id ="datatable1" paginationbar="add,-" fieldStr="select,entName,entCertType,entCertNum,queryReason,status,isLock,queryDate,userId" readonly="true" width="100%"/>
      		</td>
     </tr>
      	<tr>
    		<td  align="center">			
				&nbsp<@CommonQueryMacro.Button id= "Submit"/>
				&nbsp<@CommonQueryMacro.Button id= "delete"/>
    		</td>
    	</tr>	
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">

  function add_onClickCheck(button){
  showWin("第二代企业信用信息查询新增", "/fpages/business/ftl/PbocQueryHistoryAdd.ftl",300,300,window);
  }
  
  function Submit_postSubmit(){
    alert("提交审批成功！");
    PbocQueryHistoryMake_dataset.flushData(1);
  }
  
   function delete_postSubmit(){
    alert("删除成功！");
    PbocQueryHistoryMake_dataset.flushData(1);
  }
 
</script>
</@CommonQueryMacro.page>
