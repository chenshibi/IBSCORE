<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<#assign st="${RequestParameters['st']}" />
<@CommonQueryMacro.page title="系统参数">
<#if st=="2">
	<@CommonQueryMacro.CommonQuery id="SysParamsEntryDetail" init="true" submitMode="all" navigate="false">
	<table align="left" width="100%">
	      <tr valign="top">
  			<td valign="top" >
	  			<FIELDSET name='group6' style="padding: 6px;">
					<LEGEND>系统参数详细信息</LEGEND>
					<table frame=void class="grouptable" id="detailTable" >
						<tr>       
		                  	<td nowrap class="labeltd" colspan=2 align="center">修改前</td>       
						  	<td nowrap class="labeltd" colspan=2 align="center">修改后</td>				 
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd" width="5%">参数段编号</td>
						  <td class="datatd" nowrap label width="45%" ><@CommonQueryMacro.SingleField fId="old_paramgroupId"/></td>
						   <td nowrap class="labeltd" width="5%">参数段编号</td>
						  <td class="datatd" nowrap width="45%"><@CommonQueryMacro.SingleField fId="paramgroupId"/></td>
						</tr>
		            	<tr>
		                  <td nowrap class="labeltd" width="5%">参数编号</td>
						  <td class="datatd" nowrap label width="45%"><@CommonQueryMacro.SingleField fId="old_paramId"/></td>
						   <td nowrap class="labeltd" width="5%">参数编号</td>
						  <td class="datatd" nowrap width="45%"><@CommonQueryMacro.SingleField fId="paramId"/></td>
						</tr>
						<tr>
		                  <td nowrap class="labeltd" width="5%">参数说明</td>
		                  <td class="datatd" nowrap label width="45%"><@CommonQueryMacro.SingleField fId="old_paramName"/></td>
		                  <td nowrap class="labeltd" width="5%">参数说明</td>
		                  <td class="datatd" nowrap width="45%"><@CommonQueryMacro.SingleField fId="paramName"/></td>
		                </tr>
		                <tr>
		                  <td nowrap class="labeltd" width="5%">参数值</td>
		                  <td class="datatd" nowrap label width="45%"><@CommonQueryMacro.SingleField fId="old_paramVal"/></td>
		                   <td nowrap class="labeltd" width="5%">参数值</td>
						  <td class="datatd" nowrap width="45%"><@CommonQueryMacro.SingleField fId="paramVal"/></td>
		                </tr>
		                <tr>
		                  <td nowrap class="labeltd" width="5%">备注</td>
						  <td class="datatd" nowrap label width="45%"><@CommonQueryMacro.SingleField fId="old_memo"/></td>
						  <td nowrap class="labeltd" width="5%">备注</td>
						  <td class="datatd" nowrap width="45%"><@CommonQueryMacro.SingleField fId="memo"/></td>
						</tr>	
					</table>
					</FIELDSET>	
			</td>
		</tr>
	 	<tr valign="top">
  		   <td valign="CENTER">
				<left><@CommonQueryMacro.Button id= "btClose"/></left>
  			</td>
  		</tr> 
	</table>
	</@CommonQueryMacro.CommonQuery>
<#else>
	<@CommonQueryMacro.CommonQuery id="SysParamsEntryDetail" init="true" submitMode="all"  navigate="false">
	<table align="left" width="50%">
      <tr valign="top">
  			<td valign="left">
  			<@CommonQueryMacro.Group id ="group1" label="系统参数详细信息" fieldStr="old_paramgroupId,old_paramId,old_paramName,old_paramVal,old_memo" colNm=2 labelwidth="50%"/>
  			</td>
  		</tr>

     <tr valign="top">
      		   <td valign="left">
					<left><@CommonQueryMacro.Button id= "btClose"/></left>
      			</td>
      		</tr>
	</table>
	</@CommonQueryMacro.CommonQuery>
</#if>
   <script language="javascript">
     function btClose_onClickCheck(button){
       unloadPageWindows("partWin");
       return false;
     }
</script>

</@CommonQueryMacro.page>
